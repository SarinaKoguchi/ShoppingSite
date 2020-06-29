/*
 * かごの中身を変更・削除する
 */

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.CartModel;

public class UpdateCartServlet extends HttpServlet {

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

		// フォワード先指定
		String forward_jsp = "/displayCart";

		// インスタンス化
		CartModel cartModel = new CartModel();
		CartBean cartBean = new CartBean();

		// 会員IDをセッションから取得
		HttpSession session = request.getSession();
		LoginBean loginUser = (LoginBean) session.getAttribute("loginUser");
		loginUser.getMember_no();
		String member_no = loginUser.getMember_no();

		// 商品ID・数量を取得
		String item_id = request.getParameter("item_id");
		String item_quantity_string = request.getParameter("quantity");

		// ボタン判断
		String button = request.getParameter("submit");

		if (button.equals("変更")) {

			// 該当商品を削除する
			cartModel.deleteCart(item_id, member_no);

			// 新しい数量で登録しなおす
			if (cartModel.addCart(item_id, member_no, item_quantity_string)) {

				// 変更に成功した場合
				cartBean.setMsg("変更に成功しました");
				request.setAttribute("cartBean", cartBean);

			} else {

				// 変更に失敗した場合
				cartBean.setMsg("変更に失敗しました");
				request.setAttribute("cartBean", cartBean);

			}

		} else if (button.equals("削除")) {

			if (cartModel.deleteCart(item_id, member_no)) {

				// 削除に成功した場合
				cartBean.setMsg("削除に成功しました");
				request.setAttribute("cartBean", cartBean);

			} else {

				// 削除に失敗した場合
				cartBean.setMsg("削除に失敗しました");
				request.setAttribute("cartBean", cartBean);

			}

		} else if (button.equals("カートの中身を空にする")) {

			if (cartModel.allDeleteCart(member_no)) {

				// 削除に成功した場合
				cartBean.setMsg("カートの中身は空です。");
				request.setAttribute("cartBean", cartBean);

				// セッション破棄
				session.removeAttribute("cartItems");

			} else {

				// 削除に失敗した場合
				cartBean.setMsg("削除に失敗しました");
				request.setAttribute("cartBean", cartBean);

			}
		}

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}
