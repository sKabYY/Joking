package com.yylang.parser;

import java.io.IOException;
import com.yylang.debuginfo.PositionInfo;

%%

%class Lexer
%type Token

%unicode
%line
%column

// %public
%final
// %abstract

%init{
	// TODO: code that goes to constructor
%init}

%yylexthrow ParseException

%{
	private StringBuffer sb = new StringBuffer();

	private PositionInfo pos() {
		return new PositionInfo("unknown", yyline, yycolumn);
	}

	private void error()
	throws ParseException
	{
		throw new ParseException(pos(), "Illegal character <" + yytext() + ">");
	}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
Comment        = ";" [^\r\n]* {LineTerminator}?
Letter         = [:jletter:] | [\+\-\*\/\?\!_\:\.]
LetterOrDigit  = {Letter} | [:digit:]
Identifier     = {Letter} {LetterOrDigit}*
Integer        = [\+\-]? [:digit:]*
Float          = [\+\-]? [:digit:]+ \. [:digit:]* /* TODO */
%state STRING

%%

<YYINITIAL> {
  "(" { return new Token.TLParen(pos()); }
  ")" { return new Token.TRParen(pos()); }
  "[" { return new Token.TLBracket(pos()); }
  "]" { return new Token.TRBracket(pos()); }
  \" { sb.setLength(0); yybegin(STRING); }
  {Integer} { return new Token.TInteger(pos(), yytext()); }
  {Float} { return new Token.TFloat(pos(), yytext()); }
  {Identifier} { return new Token.TSymbol(pos(), yytext()); }
  {Comment} {}
  {WhiteSpace} {}
}

<STRING> {
  \" { yybegin(YYINITIAL);
       return new Token.TString(pos(), sb.toString()); }
  [^\n\r\"\\]+ { sb.append(yytext()); }
  \\t { sb.append('\t'); }
  \\n { sb.append('\n'); }
  \\r { sb.append('\r'); }
  \\\" { sb.append('"'); }
  \\ { sb.append('\\'); }
}

[^] { error(); }  /* TODO */