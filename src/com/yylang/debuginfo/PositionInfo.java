package com.yylang.debuginfo;

public class PositionInfo {
	public String filename;
	public int lineno;
	public int colnum;
	
	public PositionInfo(String fn) {
		filename = fn;
		lineno = 0;
		colnum = 0;
	}
	
	public void next() {
		++colnum;
	}
	
	public void newline() {
		++lineno;
		colnum = 0;
	}
}