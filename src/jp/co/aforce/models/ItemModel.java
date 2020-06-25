package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class ItemModel {

	// 商品データを取得
	public List<ItemBean> getItems() {

		ResultSet rs = null;
		List<ItemBean> items = new ArrayList<ItemBean>();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `items` ";
			rs = DBUtil.execute(SQL);

			rs.beforeFirst();
			while (rs.next()) {
				/* データを取得 */
				ItemBean itemBean = new ItemBean();
				itemBean.setItem_id(rs.getString("item_id"));
				itemBean.setItem_name(rs.getString("item_name"));
				itemBean.setItem_price(rs.getInt("item_price"));
				itemBean.setItem_img(rs.getString("item_img"));
				itemBean.setItem_stock(rs.getInt("item_stock"));
				items.add(itemBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return items;
	}

	// 商品検索結果を返す
	public List<ItemBean> searchItems(String search) {
		ResultSet rs = null;
		List<ItemBean> searchItems = new ArrayList<ItemBean>();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT * FROM `items` WHERE "
					+ "`item_id` LIKE '%" + search + "%'"
					+ " OR `item_name` LIKE '%" + search + "%'";

			rs = DBUtil.execute(SQL);

			/* データを取得 */
			rs.beforeFirst();
			while (rs.next()) {
				ItemBean itemBean = new ItemBean();
				itemBean.setItem_id(rs.getString("item_id"));
				itemBean.setItem_name(rs.getString("item_name"));
				itemBean.setItem_price(rs.getInt("item_price"));
				itemBean.setItem_img(rs.getString("item_img"));
				itemBean.setItem_stock(rs.getInt("item_stock"));
				searchItems.add(itemBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return searchItems;
	}

}
