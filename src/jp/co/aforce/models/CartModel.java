package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.util.DBUtil;

public class CartModel {

	// カートに商品を入れる
	public boolean addCart(String item_id, String member_no, int quantity) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// Beanに値を格納する
			CartBean cartBean = new CartBean();
			cartBean.setItem_id(item_id);
			cartBean.setMember_no(member_no);
			cartBean.setQuantity(quantity);

			// SQLを実行
			String SQL = "INSERT INTO `cart`(member_no, item_id, quantity) VALUES"
					+ "('" + member_no + "', '" + item_id + "', '" + quantity + "')";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			DBUtil.closeConnection();
		}
		return result;

	}

	// 消費税
	public static final double TAX = 1.1;
	public static final double TAXRATE = 0.1;

	// カートの商品を表示する
	public List<CartBean> getCartItems(String member_no) {

		ResultSet rs = null;
		List<CartBean> cartItems = new ArrayList<CartBean>();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT *"
					+ ", sum(quantity)"
					+ ",item_price * " + TAX + " as item_tax_price"
					+ ",sum(item_price) * " + TAX + " as subtotal"
					+ ",sum(item_price) * " + TAXRATE + " as tax_total"
					+ " FROM `cart` LEFT OUTER JOIN `items`"
					+ " ON cart.item_id = items.item_id"
					+ " WHERE cart.member_no = '" + member_no + "'"
					+ " GROUP BY cart.item_id";
			rs = DBUtil.execute(SQL);



			rs.beforeFirst();
			while (rs.next()) {
				/* データを取得 */
				CartBean cartBean = new CartBean();
				cartBean.setItem_id(rs.getString("item_id"));
				cartBean.setItem_name(rs.getString("item_name"));
				cartBean.setItem_img(rs.getString("item_img"));
				cartBean.setItem_price(rs.getInt("item_price"));
				cartBean.setMember_no(rs.getString("member_no"));
				cartBean.setQuantity(rs.getInt("sum(quantity)"));
				// 税込価格・小計・消費税
				cartBean.setSubtotal(rs.getInt("subtotal"));
				cartBean.setTax_total(rs.getInt("tax_total"));
				cartBean.setItem_tax_price(rs.getInt("item_tax_price"));
				cartItems.add(cartBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return cartItems;

	}

	// カートの商品を削除する(商品を購入する)
	// TODO 動作確認未了
	public boolean deleteCart(String item_id, String member_no) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// Beanに値を格納する
			CartBean cartBean = new CartBean();
			cartBean.setItem_id(item_id);
			cartBean.setMember_no(member_no);

			// SQLを実行
			String SQL = "DELETE FROM `cart` WHERE "
					+ "member_no = '" + member_no + "' AND item_id = '" + item_id + "'";
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
