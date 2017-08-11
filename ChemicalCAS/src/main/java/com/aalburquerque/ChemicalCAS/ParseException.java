package com.aalburquerque.ChemicalCAS;

public class ParseException extends Exception {

	private String str;
	private int pos;

	public ParseException(String str, int pos) {
		this.str=str;
		this.pos=pos;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
	

}
