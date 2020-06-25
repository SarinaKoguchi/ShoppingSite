package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.util.DBUtil;

public class LoginModel {

	// DBにユーザが存在するか
	public boolean loginCheck(String mail, String password) {
		// 実行結果を格納する変数
		ResultSet rs = null;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `members` WHERE `mail` = '" + mail + "' AND `password` = '" + password + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

	// 	ログインユーザの情報を取得
	public LoginBean getLoguinUserData(String mail, String password) {
		ResultSet rs = null;
		LoginBean loginUser = new LoginBean();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `members` WHERE `mail` = '" + mail + "' AND `password` = '" + password + "'";
			rs = DBUtil.execute(SQL);

			// データを取得
			loginUser.setAuthority(rs.getString("authority"));
			loginUser.setMember_no(rs.getString("member_no"));
			loginUser.setName(rs.getString("name"));
			loginUser.setMail(rs.getString("mail"));
			loginUser.setAddress(rs.getString("address"));
			loginUser.setPassword(rs.getString("password"));
			loginUser.setBirth_year(rs.getInt("birth_year"));
			loginUser.setBirth_month(rs.getInt("birth_month"));
			loginUser.setBirth_day(rs.getInt("birth_day"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return loginUser;
	}

}
