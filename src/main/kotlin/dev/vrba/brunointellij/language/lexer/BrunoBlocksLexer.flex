package dev.vrba.brunointellij.language.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import dev.vrba.brunointellij.language.parser.psi.BlockTypes;
import com.intellij.psi.TokenType;

%%

%class BlockLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
  private int braceDepth = 0;
  private int contentStart = 0;
%}

CRLF=\r|\n|\r\n
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_-]*

%state IN_BLOCK

%%

<YYINITIAL> {
  {WHITE_SPACE}+                { return TokenType.WHITE_SPACE; }
  {CRLF}+                       { return TokenType.WHITE_SPACE; }

  {IDENTIFIER}                  { return BlockTypes.IDENTIFIER; }
  ":"                           { return BlockTypes.COLON; }

  "{"                           {
                                  braceDepth = 1;
                                  contentStart = zzMarkedPos;
                                  yybegin(IN_BLOCK);
                                  return BlockTypes.LBRACE;
                                }
}

<IN_BLOCK> {
  "{"                           { braceDepth++; }

  "}"                           {
                                  braceDepth--;
                                  if (braceDepth == 0) {
                                    if (zzMarkedPos - 1 > contentStart) {
                                      yypushback(1);
                                      yybegin(YYINITIAL);
                                      return BlockTypes.BLOCK_CONTENT;
                                    } else {
                                      yybegin(YYINITIAL);
                                      return BlockTypes.RBRACE;
                                    }
                                  }
                                }

  [^{}]+                        { /* consume the inner block */ }
}

[^]                             { return TokenType.BAD_CHARACTER; }
