package com.yylang.value;

public class FloatValue extends Value {
	double value;
	public FloatValue(double d) {
		value = d;
	}
	public static FloatValue parse(String s) {
		return new FloatValue(Double.parseDouble(s));
	}
	@Override
	public boolean equalsValue(Value v) {
		if (v instanceof FloatValue && ((FloatValue) v).value == value) {
			return true;
		} else {
			return false;
		}
	}
}