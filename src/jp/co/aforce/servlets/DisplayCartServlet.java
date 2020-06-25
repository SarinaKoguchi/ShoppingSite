/*
 * 買い物かごを表示する
 */

package jp.co.aforce.servlets;

import java.io.IOException;
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

		CartModel cartModel = new CartModel();
		List<CartBean> cartItems = cartModel.getCartItems(member_no);

		// カートの中身をセッションに保存
		session.setAttribute("cartItems", cartItems);

		// インスタンス化
		//		CartBean cartBean = new CartBean();

		//フォワード先の指定
		String forward_jsp = "/views/cart.jsp";

		//		if (cartItems.equals("")) {
		//			cartBean.setMsg("カートの中身がありません。");
		//			request.setAttribute("cartBean", cartBean);
		//		}

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}
}
