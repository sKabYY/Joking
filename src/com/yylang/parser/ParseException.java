package com.yylang.parser;

import com.yylang.debuginfo.PositionInfo;

public class ParseException extends Exception {
	public ParseException(PositionInfo p, String msg) {
		super(String.format("(%s %d %d) %s", p.filename, p.lineno, p.colnum, msg));
	}
	
	public ParseException(String msg) {
		super(msg);
	}
}