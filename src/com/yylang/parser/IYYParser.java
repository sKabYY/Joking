package com.yylang.parser;

import java.util.List;

public interface IYYParser {
	public List<Token> scan(String src);
	public Node parse(List<Token> tokens);
	public Node scanAndParse(String src);
}