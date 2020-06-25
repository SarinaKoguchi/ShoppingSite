package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.StockModel;

@SuppressWarnings("serial")
public class StockRegisterServlet extends HttpServlet {

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
		String forward_jsp = "/views/stockRegister.jsp";

		// ボタン判断
		String button = request.getParameter("submit");

		if (button.equals("戻る")) {

			forward_jsp = "/item";

		} else if (button.equals("登録")) {

			// インスタンス化
			StockModel stockModel = new StockModel();
			ItemBean itemBean = new ItemBean();

			// 入力情報取得
			String item_id = request.getParameter("item_id");
			String item_name = request.getParameter("item_name");
			String item_price_string = request.getParameter("item_price");
			String item_img = request.getParameter("item_img");
			String item_stock_string = request.getParameter("item_stock");

			if (stockModel.registerItemData(item_id, item_name, item_price_string, item_img, item_stock_string)) {
				// 削除成功
				itemBean.setMsg("登録に成功しました");
				request.setAttribute("itemBean", itemBean);

			} else {
				// 削除失敗
				itemBean.setMsg("登録に失敗しました");
				request.setAttribute("itemBean", itemBean);

			}

		}

		// セッションオブジェクトを破棄
		HttpSession session = request.getSession();
		session.removeAttribute("stockItem");

		// フォワード
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}
