package com.yylang.parser;

import java.util.List;

public class YYParser implements IYYParser {
	@Override
	public List<Token> scan(String src) {
		int idx = 0;
		StringBuffer buffer = new StringBuffer();
		while (idx < src.length()) {
			char c = src.charAt(idx);
			if (c == '(') {
			
			} else if (c == ')') {
				
			} else if (c == '[') {
				
			} else if (c == ']') {
				
			}
			++idx;
		}
		return null;
	}
	
	@Override
	public Node parse(List<Token> tokens) {
		return null;
	}
	
	@Override
	public Node scanAndParse(String src) {
		return null;
	}
}