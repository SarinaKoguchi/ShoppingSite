/*
 * 買い物かごの処理
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

@SuppressWarnings("serial")
public class AddCartServlet extends HttpServlet {

	// ログイン画面へ遷移
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

		// 入力情報を取り出す
		String item_id = request.getParameter("item_id");
		String item_quantity_string = request.getParameter("quantity");

		// インスタンス化
		CartBean cartBean = new CartBean();
		CartModel cartModel = new CartModel();

		if (cartModel.addCart(item_id, member_no, item_quantity_string)) {
			// 成功
			cartBean.setMsg("カートに入れました。");
			request.setAttribute("cartBean", cartBean);

		} else {
			// 失敗
			cartBean.setMsg("カートに入れることが出来ませんでした。");
			request.setAttribute("cartBean", cartBean);
		}

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/item");
		rDispatcher.forward(request, response);

	}

}
