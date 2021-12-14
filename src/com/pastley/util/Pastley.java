package com.pastley.util;

import java.util.List;

import com.pastley.models.component.ItemComponent;

public class Pastley {
	public static <A> List<ItemComponent<A>> addItem(ItemComponent<A> item, List<ItemComponent<A>> list) {
		if (item != null && list != null)
			list.add(item);
		return list;
	}
}
