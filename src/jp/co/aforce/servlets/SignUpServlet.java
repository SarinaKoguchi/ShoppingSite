package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.SignUpBean;
import jp.co.aforce.models.SignUpModel;

@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 新規登録画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/signUp.jsp");
		rDispatcher.forward(request, response);
	}

	// 登録ボタン押下
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// 入力情報取得
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String ageString = request.getParameter("age");
		String address = request.getParameter("address");
		String birth_year_string = request.getParameter("birth_year");
		String birth_month_string = request.getParameter("birth_month");
		String birth_day_string = request.getParameter("birth_day");

		SignUpBean signUpBean = new SignUpBean();
		SignUpModel signUpModel = new SignUpModel();

		String forward_jsp = "/views/signUpConfirm.jsp";

		// 確認ボタン押下
		if (name.equals("") || mail.equals("") || password.equals("") || ageString.equals("") || address.equals("")
				|| birth_year_string.equals("") || birth_month_string.equals("") || birth_day_string.equals("")) {

			// 未入力項目がある場合
			signUpBean.setMsg("入力されていない項目があります");
			request.setAttribute("signUpBean", signUpBean);

		} else {

			// 揃っていた場合 確認画面に進む
			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

			// 登録ボタン押下
			if (signUpModel.signUp(name, mail, password, ageString, address, birth_year_string, birth_month_string,
					birth_day_string)) {

				// 登録に成功した場合
				signUpBean.setMsg("登録に成功しました");
				request.setAttribute("signUpBean", signUpBean);

			} else {

				// 登録に失敗した場合
				signUpBean.setMsg("登録に失敗しました");
				request.setAttribute("registerBean", signUpBean);
			}

		}

		forward_jsp = "/views/signUp.jsp";
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);

	}

}
