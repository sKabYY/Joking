package com.yylang.node;

import com.yylang.debuginfo.PositionInfo;

public class Identifier extends Expression {
	String name;
	public Identifier(PositionInfo p, String s) {
		super(p);
		name = s;
	}
}