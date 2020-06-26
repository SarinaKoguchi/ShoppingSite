/*
 * カートの情報を格納する
 */

package jp.co.aforce.beans;

import java.io.Serializable;

public class CartBean implements Serializable {

	private String item_id;
	private String item_name;
	private String item_img;
	private int item_price;
	private int item_tax_price;
	private String member_no;
	private int quantity;
	private int subtotal;
	private int tax_total;
	private int total;
	private String msg;

	public CartBean() {
	}

	// セッター
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public void setItem_tax_price(int item_tax_price) {
		this.item_tax_price = item_tax_price;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public void setTax_total(int tax_total) {
		this.tax_total = tax_total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// ゲッター
	public String getItem_id() {
		return item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public String getItem_img() {
		return item_img;
	}

	public int getItem_price() {
		return item_price;
	}

	public int getItem_tax_price() {
		return item_tax_price;
	}

	public String getMember_no() {
		return member_no;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public int getTax_total() {
		return tax_total;
	}

	public int getTotal() {
		return total;
	}

	public String getMsg() {
		return msg;
	}

}
