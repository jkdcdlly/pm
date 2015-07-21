package com.thinkgem.jeesite.modules.oa.constant;

import java.util.ArrayList;
import java.util.List;

public class TimePoint {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("50");
		list.add("60");
		List<String> newlist = new ArrayList<String>(288);
		int j = 0;
		for (int i = 0; i <= 288; i++) {
			if (list.size() > j && String.valueOf(i).equals(list.get(j))) {
				newlist.add(list.get(j));
				j++;
			} else {
				newlist.add("0");
			}
		}
		for (int i = 0; i < newlist.size(); i++) {
			System.out.println(i + ":" + newlist.get(i));
		}

	}
}
