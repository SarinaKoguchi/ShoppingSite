package jp.co.aforce.models;

import jp.co.aforce.beans.SignUpBean;
import jp.co.aforce.util.DBUtil;

public class SignUpModel {

	// 登録ボタン押下
	public boolean signUp(String name, String mail, String password, String ageString, String address,
			String birth_year_string, String birth_month_string, String birth_day_string) {
		boolean result = true;

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// 文字列を数字に変換
			int age = Integer.parseInt(ageString);
			int birth_year = Integer.parseInt(birth_year_string);
			int birth_month = Integer.parseInt(birth_month_string);
			int birth_day = Integer.parseInt(birth_day_string);

			// Beanに値を格納する
			SignUpBean signUpBean = new SignUpBean();
			signUpBean.setName(name);
			signUpBean.setMail(mail);
			signUpBean.setPassword(password);
			signUpBean.setAge(age);
			signUpBean.setAddress(address);
			signUpBean.setBirth_year(birth_year);
			signUpBean.setBirth_month(birth_month);
			signUpBean.setBirth_day(birth_day);

			String SQL = "INSERT INTO `members` VALUES"
					+ "(DATE_FORMAT(NOW(), 'A%y%m%d%H%i%s'), '" + name + "', '" + mail + "', '" + password + "',"
					+"'" + age + "', '" + address + "', '" + birth_year + "', '"+ birth_month + "', '" + birth_day + "')";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;

		} finally {
			DBUtil.closeConnection();

		}

		return result;
	}

}
