package com.yylang.parser;

import java.util.List;

import com.yylang.debuginfo.PositionInfo;

public class Lexer {
	private String source;
	private int offset;
	// debug info
	private PositionInfo posInfo;

	private Lexer(String src, String fn) {
		source = src;
		offset = 0;
		posInfo = new PositionInfo(fn);
	}

	private boolean eof() {
		if (offset < source.length()) {
			return false;
		} else {
			return true;
		}
	}

	private char currentChar() {
		return source.charAt(offset);
	}

	private void forward() {
		if (eof()) return;
		if (currentChar() == '\n') {
			posInfo.newline();
		} else {
			posInfo.next();
		}
		++offset;
	}
	
	private Token scanToken() {
		if (eof()) return null;
		char cur = currentChar();
		// TODO
	}
	
	public static List<Token> scan(String source, String filename) {
		
	}
}