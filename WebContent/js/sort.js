/**
 *
 */

"use strict";

// ソート機能
$(function() {
	// ソート順変更
	$('.sort_btn_expensive').click(function() {

		// li要素を取得して並び替え
		var $elements = $('ul#itemList > li').sort(function(a, b) {
			var aa = $(a).text();
			var bb = $(b).text();
			// 昇順ソート。不等号を逆にすることで降順にできる。
			if (aa > bb) {
				return 1;
			} else if (aa < bb) {
				return -1;
			}
			return 0;
		});

		// リスト（ulの中のli）を全て削除
		$('ul#itemList').empty();

		// 並び替えた順にliを追加する
		$elements.each(function() {
			$('ul#itemList').append($(this));

		});
	});
});