package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.CartModel;
import jp.co.aforce.models.StockModel;

public class BuyItemsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		String forward_jsp = "";

		// インスタンス化
		CartModel cartModel = new CartModel();
		CartBean cartBean = new CartBean();
		StockModel stockModel = new StockModel();

		HttpSession session = request.getSession();

		// ユーザ情報(ユーザID)を取得
		LoginBean loginUser = (LoginBean) session.getAttribute("loginUser");
		String member_no = loginUser.getMember_no();

		// 買い物かごの中身を取得
		List<CartBean> cartItems = cartModel.getCartItems(member_no);
		List<CartBean> buyItems = new ArrayList<CartBean>();
		buyItems = cartItems;

		// 支払い方法を取得
		String payment = request.getParameter("payment");

		if (payment.equals("")) {

			cartBean.setMsg("お支払い方法を選択してください。");
			request.setAttribute("cartBean", cartBean);

			forward_jsp = "/views/orderConfirm.jsp";

			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

		} else {

			// 在庫から購入数を引く
			String item_id = null;
			try {

				for (int i = 0; i < buyItems.size(); i++) {

					item_id = buyItems.get(i).getItem_id();

					if (!stockModel.purchaseItems(member_no, item_id)) {
						// 在庫数を減らせなかった場合
						throw new Exception();
					}

				}

				if (cartModel.allDeleteCart(member_no)) {

					forward_jsp = "/views/orderDone.jsp";

				} else {

					throw new Exception();

				}

			} catch (Exception e) {

				e.printStackTrace();
				cartBean.setMsg("カートの商品を購入できませんでした。");
				request.setAttribute("cartBean", cartBean);
				forward_jsp = "/views/orderConfirm.jsp";

			} finally {

				// フォワード
				RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
				rDispatcher.forward(request, response);
			}

		}
	}

}
