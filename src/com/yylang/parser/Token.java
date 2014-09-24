package com.yylang.parser;

public class Token {
	public enum TokenType {
		SYMBOL,
		// Base types
		INTEGER,
		FLOAT,
		STRING,
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
	
	public TokenType type;
	
	private Token() {}
}