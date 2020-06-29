package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.util.DBUtil;

public class CartModel {

	// カートに商品を入れる・数量を変更する
	public boolean addCart(String item_id, String member_no, String item_quantity_string) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// 文字列を数値に変換
			int quantity = Integer.parseInt(item_quantity_string);

			// Beanに値を格納する
			CartBean cartBean = new CartBean();
			cartBean.setItem_id(item_id);
			cartBean.setMember_no(member_no);
			cartBean.setQuantity(quantity);

			// SQLを実行
			String SQL = "INSERT INTO `cart` (member_no, item_id, quantity) VALUES "
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
					+ ",items.item_price * " + TAX + " AS item_tax_price"
					+ ",items.item_price * " + TAX + " * quantity AS subtotal"
					+ ",items.item_price * " + TAXRATE + " * quantity AS tax_total"
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
				cartBean.setQuantity(rs.getInt("quantity"));
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

	// カートの商品を空にする
	public boolean allDeleteCart(String member_no) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// Beanに値を格納する
			CartBean cartBean = new CartBean();
			cartBean.setMember_no(member_no);

			// SQLを実行
			String SQL = "DELETE FROM `cart` WHERE "
					+ "member_no = '" + member_no + "'";
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
