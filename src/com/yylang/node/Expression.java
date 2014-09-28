package com.yylang.node;

import com.yylang.debuginfo.PositionInfo;

public abstract class Expression {
	public PositionInfo posInfo;
	public Expression(PositionInfo p) {
		posInfo = p;
	}
}