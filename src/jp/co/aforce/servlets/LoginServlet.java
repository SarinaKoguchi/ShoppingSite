/*
 * ログイン機能
 * 　ログインユーザ情報&ログイン状態をセッションに保存
 */


package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字コード
		request.setCharacterEncoding("UTF-8");

		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();

		// フォワード先指定
		String forward_jsp = "/viewsBeforeLogin/login.jsp";

		// ユーザによって入力された情報を取り出す リクエストパラメータの取得
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		// 取り出した情報を loginBean に格納する
		LoginBean loginBean = new LoginBean();
		loginBean.setMail(mail);
		loginBean.setPassword(password);

		// モデルをインスタンス化する
		LoginModel loginModel = new LoginModel();

		// 入力された情報がDBに存在するか調べる
		if (loginModel.loginCheck(mail, password)) {

			// ログインユーザ情報を取得＆セッションに保存
			LoginBean loginUser = loginModel.getLoguinUserData(mail, password);
			session.setAttribute("loginUser", loginUser);

			// ログイン状態をセッションに保存
			session.setAttribute("login_state", "login");

			//ソート状態をセッションに保存
			session.setAttribute("sort", "1"); // デフォルト（価格が高い順）

			// フォワード先
			forward_jsp = "/item";

			// ログインが失敗したときの処理
		} else {
			// エラーメッセージを設定
			loginBean.setEmsg("メールアドレスまたはパスワードが違います");
			request.setAttribute("loginBean", loginBean);
		}

		// forwaed_jsp に設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}