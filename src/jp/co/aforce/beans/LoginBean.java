// ログインユーザ情報を格納
package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginBean implements Serializable {

	// フィールド
	private String member_no;
	private String mail;
	private String name;
	private String password;
	private int age;
	private String address;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private String authority;
	private String emsg;

	// 引数なしのデフォルト・コンストラクタ
	public LoginBean() {
	}

	// セッター プロパティを変更する
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	// ゲッター プロパティを読み取る
	public String getMember_no() {
		return member_no;
	}

	public String getEmsg() {
		return emsg;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public int getBirth_month() {
		return birth_month;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public String getAuthority() {
		return authority;
	}

}
