/*
 * 在庫管理処理(登録・変更・削除)
 * 入力情報を保持して、ページ遷移
 */

package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;

@SuppressWarnings("serial")
public class StockServlet extends HttpServlet {

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

		// インスタンス化
		ItemBean itemBean = new ItemBean();

		// ボタン判断
		String button = request.getParameter("submit");

		// 入力情報を取り出す
		String item_id = request.getParameter("item_id");
		String item_img = request.getParameter("item_img");
		String item_name = request.getParameter("item_name");
		String item_stock_string = request.getParameter("item_stock");
		String item_price_string = request.getParameter("item_price");

		// 入力情報をBeanに格納
		ItemBean stockItem = new ItemBean();
		stockItem.setItem_id(item_id);
		stockItem.setItem_name(item_name);
		stockItem.setItem_img(item_img);
		stockItem.setItem_price_string(item_price_string);
		stockItem.setItem_stock_string(item_stock_string);

		// セッションに保存
		HttpSession session = request.getSession();
		session.setAttribute("stockItem", stockItem);

		// フォワード先指定
		String forward_jsp = "";

		// 未入力チェック
		if (item_id.equals("") || item_img.equals("") || item_name.equals("")
				|| item_stock_string.equals("") || item_price_string.equals("")) {

			// 未入力項目がある場合
			itemBean.setMsg("入力されていない項目があります");
			request.setAttribute("itemBean", itemBean);

			forward_jsp = "/views/stockList.jsp";

		} else {

			// ボタン判断
			if (button.equals("登録")) {

				forward_jsp = "views/stockRegister.jsp";

			} else if (button.equals("変更")) {

				forward_jsp = "views/stockUpdate.jsp";

			} else if (button.equals("削除")) {

				forward_jsp = "/views/stockDelete.jsp";

			}
		}

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}
