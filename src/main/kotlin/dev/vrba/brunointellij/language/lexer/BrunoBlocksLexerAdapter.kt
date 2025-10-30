package dev.vrba.brunointellij.language.lexer

import com.intellij.lexer.FlexAdapter

class BrunoLexerAdapter : FlexAdapter(BlockLexer(null)) {
}