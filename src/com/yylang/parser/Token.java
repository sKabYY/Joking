package com.yylang.parser;

import com.yylang.debuginfo.PositionInfo;
import com.yylang.value.BoolValue;
import com.yylang.value.FloatValue;
import com.yylang.value.IntegerValue;
import com.yylang.value.StringValue;

public abstract class Token {
	public enum TokenType {
		SYMBOL,
		// Base types
		INTEGER,
		FLOAT,
		STRING,
		BOOL,
		//
		LPAREN,
		RPAREN,
		LBRACKET,
		RBRACKET,
		//
		QUOTE,
		COMMA,
		DOT,
	}
	
	PositionInfo posInfo;
	
	public Token(PositionInfo p) {
		posInfo = p;
	}
	
	public static class TLParen extends Token {
		public TLParen(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TLParen) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TRParen extends Token {
		public TRParen(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TRParen) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TLBracket extends Token {
		public TLBracket(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TLBracket) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TRBracket extends Token {
		public TRBracket(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TRBracket) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TIdentifier extends Token {
		public String value;
		public TIdentifier(PositionInfo p, String v) {
			super(p);
			value = v;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TIdentifier && ((TIdentifier) obj).value.equals(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TQuote extends Token {
		public TQuote(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TQuote) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TComma extends Token {
		public TComma(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TComma) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TDot extends Token {
		public TDot(PositionInfo p) {
			super(p);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TDot) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TInteger extends Token {
		public IntegerValue value;
		public TInteger(PositionInfo p, String s) {
			super(p);
			value = IntegerValue.parse(s);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TInteger && ((TInteger) obj).value.equalsValue(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TFloat extends Token {
		public FloatValue value;
		public TFloat(PositionInfo p, String s) {
			super(p);
			value = FloatValue.parse(s);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TFloat && ((TFloat) obj).value.equalsValue(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TString extends Token {
		public StringValue value;
		public TString(PositionInfo p, String s) {
			super(p);
			value = StringValue.parse(s);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TString && ((TString) obj).value.equalsValue(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static class TBool extends Token {
		public BoolValue value;
		public TBool(PositionInfo p, boolean b) {
			super(p);
			value = new BoolValue(b);
		}
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof TBool && ((TBool) obj).value.equalsValue(value)) {
				return true;
			} else {
				return false;
			}
		}
	}
}