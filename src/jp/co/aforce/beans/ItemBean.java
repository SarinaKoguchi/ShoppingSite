/*
 *  商品情報を格納する
 */

package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable {

	private String item_id;
	private String item_name;
	private int item_price;
	private String item_price_string;
	private String item_img;
	private int item_stock;
	private String item_stock_string;
	private String search;
	private String msg;

	public ItemBean() {
	}

	// セッター
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public void setItem_price_string(String item_price_string) {
		this.item_price_string = item_price_string;
	}

	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public void setItem_stock_string(String item_stock_string) {
		this.item_stock_string = item_stock_string;
	}

	public void setSearch(String search) {
		this.search = search;
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

	public int getItem_price() {
		return item_price;
	}

	public String getItem_price_string() {
		return item_price_string;
	}

	public String getItem_img() {
		return item_img;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public String getItem_stock_string() {
		return item_stock_string;
	}

	public String getSearch() {
		return search;
	}

	public String getMsg() {
		return msg;
	}

}