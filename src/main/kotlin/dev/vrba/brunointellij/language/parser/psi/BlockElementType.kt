package dev.vrba.brunointellij.language.parser.psi

import com.intellij.psi.tree.IElementType
import dev.vrba.brunointellij.language.BrunoLanguage

data class BlockElementType(val name: String) : IElementType(name, BrunoLanguage.INSTANCE)
