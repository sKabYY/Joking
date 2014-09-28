package com.yylang.value;

public class IntegerValue extends Value {
	int value;
	private IntegerValue(int i) {
		value = i;
	}
	public static IntegerValue parse(String s) {
		return new IntegerValue(Integer.parseInt(s));
	}
	@Override
	public boolean equalsValue(Value v) {
		if (v instanceof IntegerValue && ((IntegerValue) v).value == value) {
			return true;
		} else {
			return false;
		}
	}
}