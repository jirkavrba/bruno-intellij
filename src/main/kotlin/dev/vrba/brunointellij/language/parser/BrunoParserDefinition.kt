package dev.vrba.brunointellij.language.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import dev.vrba.brunointellij.file.BrunoFile
import dev.vrba.brunointellij.language.BrunoLanguage
import dev.vrba.brunointellij.language.lexer.BrunoLexerAdapter
import dev.vrba.brunointellij.language.psi.BlockTypes

private val FILE = IFileElementType(BrunoLanguage.INSTANCE)

class BrunoParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer {
        return BrunoLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return BlockParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return BlockTypes.Factory.createElement(node)
    }

    override fun createFile(fileViewProvider: FileViewProvider): PsiFile {
        return BrunoFile(fileViewProvider)
    }
}