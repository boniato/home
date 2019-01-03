package com.home.util;

/**
 * Created by Lee on 2019.01.03.
 */
public enum Section {
	HOME("Home"), POST("Post"), CATEGORY("Category");

	private String value;

	Section(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}