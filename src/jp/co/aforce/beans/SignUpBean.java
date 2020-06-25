package jp.co.aforce.beans;

public class SignUpBean {

	private String msg;
	private String name;
	private String mail;
	private String password;
	private int age;
	private String address;
	private int birth_year;
	private int birth_month;
	private int birth_day;

	public SignUpBean() {
	}

	// セッター
	public void setMsg(String msg) {
		this.msg = msg;
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

	// ゲッター
	public String getMsg() {
		return msg;
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

}
