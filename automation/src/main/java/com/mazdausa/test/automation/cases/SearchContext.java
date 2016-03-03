package com.mazdausa.test.automation.cases;

public class SearchContext {

	public static final int XPATH = 0;
	public static final int NAME = 1;
	public static final int ID = 2;

	private int context;
	private String contextValue;
	
	public SearchContext(int context, String value){
		this.context = context;
		this.contextValue = value;
	}
	
	public int getContext() {
		return context;
	}

	public void setContext(int context) {
		this.context = context;
	}

	public String getContextValue() {
		return contextValue;
	}

	public void setContextValue(String contextValue) {
		this.contextValue = contextValue;
	}
	
}
