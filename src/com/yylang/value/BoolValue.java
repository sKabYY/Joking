package com.yylang.value;

public class BoolValue extends Value {
	boolean value;
	public BoolValue(boolean b) {
		value = b;
	}
	@Override
	public boolean equalsValue(Value v) {
		if (v instanceof BoolValue && ((BoolValue) v).value == value) {
			return true;
		} else {
			return false;
		}
	}
}