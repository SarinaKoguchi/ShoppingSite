/*
 * 商品一覧を取得する
 * ユーザ権限を判断する
 * 　ユーザ：商品一覧を表示
 * 　管理者：商品管理画面を表示
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

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.ItemModel;

@SuppressWarnings("serial")
public class ItemServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);

	}

	// LoginServlet から遷移
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		ItemModel itemModel = new ItemModel();
		HttpSession session = request.getSession();
		List<ItemBean> items = itemModel.getItems();

		session.setAttribute("items", items);

		// ユーザ権限情報取得
		LoginBean loginUser = (LoginBean) session.getAttribute("loginUser");
		String authority = loginUser.getAuthority();

		// ユーザ権限判断
		String forward_jsp = "";

		// 管理者
		if (authority.equals("admin")) {
			forward_jsp = "/views/stockList.jsp";

			// 一般ユーザ
		} else if (authority.equals("user")) {
			forward_jsp = "/views/itemList.jsp";
		}

		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}
