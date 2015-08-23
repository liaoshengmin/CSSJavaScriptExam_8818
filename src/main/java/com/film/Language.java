package com.film;

import java.io.Serializable;

public class Language implements Serializable {
	private int language_id ;
	private String name;
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", name=" + name + "]";
	}
	

}
