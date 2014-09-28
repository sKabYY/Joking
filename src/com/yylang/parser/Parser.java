package com.yylang.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.yylang.node.Identifier;
import com.yylang.node.Expression;

public class Parser {
	private Lexer lexer;

	public Parser(InputStream is) {
		lexer = new Lexer(is);
	}

	public Parser(String src) {
		lexer = new Lexer(new ByteArrayInputStream(src.getBytes()));
	}

	public List<Token> scan() throws IOException, ParseException {
		List<Token> tokens = new ArrayList<Token>();
		while (true) {
			Token token = lexer.yylex();
			if (token == null)
				break;
			tokens.add(token);
		}
		return tokens;
	}
	
	private List<Expression> parseList(Token endToken) throws IOException,
			ParseException {
		List<Expression> ret = new ArrayList<Expression>();
		while (true) {
			Token token = lexer.yylex();
			if (token == null) {
				if (endToken == null) {
					break;
				} else {
					throw new ParseException(String.format("expected a %s to close", endToken));
				}
			} else {
				if (token.equals(endToken)) {
					break;
				} else {
					Expression node = parseOne(token);
					ret.add(node);
				}
			}
		}
		return ret;
	}

	private Expression parseOne(Token token) {
		if (token instanceof Token.TIdentifier) {
			return new Identifier(token.posInfo, ((Token.TIdentifier) token).value);
		} else if (token instanceof Token.TQuote) {
			
		}
		return null; // TODO
	}

	public Expression parse(List<Token> tokens) {
		return null;
	}

	public Expression scanAndParse(String src) {
		return null;
	}

	public static void main(String[] args) throws IOException, ParseException {
		List<Token> tokens = new Parser("(define 1.1 +0.a 0.1 iszero?)").scan();
		System.out.println(tokens);
	}
}