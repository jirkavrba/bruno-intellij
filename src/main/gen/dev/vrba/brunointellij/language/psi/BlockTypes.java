// This is a generated file. Not intended for manual editing.
package dev.vrba.brunointellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.vrba.brunointellij.language.parser.psi.BlockElementType;
import dev.vrba.brunointellij.language.parser.psi.BlockTokenType;
import dev.vrba.brunointellij.language.psi.impl.*;

public interface BlockTypes {

  IElementType BLOCK = new BlockElementType("BLOCK");
  IElementType BLOCK_CONTENT = new BlockElementType("BLOCK_CONTENT");
  IElementType BLOCK_NAME = new BlockElementType("BLOCK_NAME");

  IElementType BLOCK_CONTENT_TOKEN = new BlockTokenType("BLOCK_CONTENT_TOKEN");
  IElementType COLON = new BlockTokenType(":");
  IElementType IDENTIFIER = new BlockTokenType("IDENTIFIER");
  IElementType LBRACE = new BlockTokenType("{");
  IElementType RBRACE = new BlockTokenType("}");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK) {
        return new BlockBlockImpl(node);
      }
      else if (type == BLOCK_CONTENT) {
        return new BlockBlockContentImpl(node);
      }
      else if (type == BLOCK_NAME) {
        return new BlockBlockNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
