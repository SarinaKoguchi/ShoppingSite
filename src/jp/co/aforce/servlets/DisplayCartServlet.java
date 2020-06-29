/*
 * 買い物かごを表示する
 */

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

@SuppressWarnings("serial")

public class DisplayCartServlet extends HttpServlet {

	// ログイン画面へ遷移
	// TODO 未ログインならトップへ遷移処理
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// ログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// ユーザ情報(ユーザID)を取得
		HttpSession session = request.getSession();
		LoginBean loginUser = (LoginBean) session.getAttribute("loginUser");
		String member_no = loginUser.getMember_no();

		// カートの中身を取得
		CartModel cartModel = new CartModel();
		CartBean cartBean = new CartBean();
		List<CartBean> cartItems = cartModel.getCartItems(member_no);

		// 合計・消費税合計を求める
		List<CartBean> listTotal = new ArrayList<CartBean>();
		listTotal = cartItems;

		int total = 0;
		int taxTotal = 0;

		for (int i = 0; i < listTotal.size(); i++) {
			total = total + listTotal.get(i).getSubtotal();
			taxTotal = taxTotal + listTotal.get(i).getTax_total();
		}

		cartBean.setTax_total(taxTotal);
		cartBean.setTotal(total);

		System.out.println("total = " + total);
		System.out.println("taxTotal = " + taxTotal);

		// 該当ユーザのカートの中身・合計・消費税合計をセッションに保存
		session.setAttribute("cartItems", cartItems);
		session.setAttribute("total", total);
		session.setAttribute("taxTotal", taxTotal);

		// カートの中身が空だった場合メッセージ表示
		if (cartItems.isEmpty()) {
			cartBean.setMsg("カートの中身は空です。");
			request.setAttribute("cartBean", cartBean);
		}

		//フォワード先の指定
		String forward_jsp = "/views/cart.jsp";

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}
}
