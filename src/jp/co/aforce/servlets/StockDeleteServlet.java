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
public class StockDeleteServlet extends HttpServlet {

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
		String forward_jsp = "/views/stockDelete.jsp";

		String button = request.getParameter("submit");

		// ボタン判断
		if (button.equals("戻る")) {

			forward_jsp = "/item";

		} else if (button.equals("削除")) {

			// インスタンス化
			StockModel stockModel = new StockModel();
			ItemBean itemBean = new ItemBean();

			// 入力情報取得
			String item_id = request.getParameter("item_id");

			if (stockModel.deleteItemData(item_id)) {
				// 削除成功
				itemBean.setMsg("削除に成功しました");
				request.setAttribute("itemBean", itemBean);

			} else {
				// 削除失敗
				itemBean.setMsg("削除に失敗しました");
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