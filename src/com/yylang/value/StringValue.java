package com.yylang.value;

public class StringValue extends Value {
	public String value;
	public StringValue(String s) {
		value = s;
	}
	public static StringValue parse(String s) {
		return new StringValue(s);
	}
	@Override
	public boolean equalsValue(Value v) {
		if (v instanceof StringValue && ((StringValue) v).value.equals(value)) {
			return true;
		} else {
			return false;
		}
	}
}