/*
 *  商品に関する処理(管理者向け)
 */

package jp.co.aforce.models;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class StockModel {

	// 商品データを登録する
	public boolean registerItemData(String item_id, String item_name, String item_price_string, String item_img,
			String item_stock_string) {

		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// 文字列を数字に変換
			int item_price = Integer.parseInt(item_price_string);
			int item_stock = Integer.parseInt(item_stock_string);

			// Beanに値を格納する
			ItemBean itemBean = new ItemBean();
			itemBean.setItem_id(item_id);
			itemBean.setItem_name(item_name);
			itemBean.setItem_price(item_price);
			itemBean.setItem_img(item_img);
			itemBean.setItem_stock(item_stock);

			// SQLを実行
			String SQL = "INSERT INTO `items` VALUES ('" + item_id + "', '" + item_name + "', '" + item_price + "', '"
					+ item_img + "', '" + item_stock + "')";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			DBUtil.closeConnection();
		}
		return result;

	}

	// 商品データを変更する
	public boolean updateItemData(String item_id, String item_name, String item_price_string, String item_img,
			String item_stock_string) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// 文字列を数字に変換
			int item_price = Integer.parseInt(item_price_string);
			int item_stock = Integer.parseInt(item_stock_string);

			// Beanに値を格納する
			ItemBean itemBean = new ItemBean();
			itemBean.setItem_id(item_id);
			itemBean.setItem_name(item_name);
			itemBean.setItem_price(item_price);
			itemBean.setItem_img(item_img);
			itemBean.setItem_stock(item_stock);

			// SQLを実行
			String SQL = "UPDATE `items` SET `item_name` = '" + item_name + "', `item_price` = '" + item_price + "',"
					+ "`item_img` = '" + item_img + "', `item_stock` = '" + item_stock + "' WHERE `item_id` =  '"
					+ item_id + "'";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			DBUtil.closeConnection();
		}
		return result;

	}

	// 商品データを削除する
	public boolean deleteItemData(String item_id) {

		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "DELETE FROM `items` WHERE `item_id` = '" + item_id + "'";
			DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			DBUtil.closeConnection();
		}
		return result;

	}

	// 商品を購入する(数量の変更)
	public boolean purchaseItems(String member_no, String item_id) {
		boolean result = true;

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// Beanに値を格納する
			ItemBean itemBean = new ItemBean();
			itemBean.setItem_id(item_id);

			// SQLを実行
			String SQL = "UPDATE `items` SET `item_stock` = "
					+ "(SELECT items.item_stock - cart.quantity "
					+ " FROM `cart` LEFT OUTER JOIN `items` "
					+ " ON cart.item_id = items.item_id"
					+ " WHERE cart.member_no = '" + member_no + "' "
					+ " AND items.item_id = '" + item_id + "') "
					+ " WHERE item_id = '" + item_id + "'";
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
