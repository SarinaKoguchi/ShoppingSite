/*
 * 商品検索機能
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
import jp.co.aforce.models.ItemModel;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String forward_jsp = "/views/itemList.jsp";

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// インスタンス化
		ItemModel itemModel = new ItemModel();
		ItemBean itemBean = new ItemBean();

		HttpSession session = request.getSession();

		// 検索フォームの入力値を取得
		String search = request.getParameter("search");
		itemBean.setSearch(search);
		request.setAttribute("itemBean", itemBean);

		// 未入力だった場合
		if (search.equals("")) {
			// エラーメッセージを表示
			itemBean.setMsg("検索ワードが未入力です。");
			request.setAttribute("itemBean", itemBean);

			// 入力された場合
		} else {

			forward_jsp = "/views/searchDone.jsp";

			// 検索結果のリストを取得
			List<ItemBean> searchItems = itemModel.searchItems(search);

			if (searchItems.isEmpty()) {

				// エラーメッセージを表示
				itemBean.setMsg("一致する商品がありません。");
				request.setAttribute("itemBean", itemBean);

			} else {

				// 検索結果をリクエストに保存
				request.setAttribute("searchItems", searchItems);

			}

		}

		// 画面遷移
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

}
