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
	
	public PositionInfo(String fn, int l, int c) {
		filename = fn;
		lineno = l;
		colnum = c;
	}
	
	@Override
	public PositionInfo clone() {
		PositionInfo posInfo = new PositionInfo(filename);
		posInfo.lineno = lineno;
		posInfo.colnum = colnum;
		return posInfo;
	}
	
	public void next() {
		++colnum;
	}
	
	public void newline() {
		++lineno;
		colnum = 0;
	}
}