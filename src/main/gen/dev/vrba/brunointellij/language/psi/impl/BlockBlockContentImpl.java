// This is a generated file. Not intended for manual editing.
package dev.vrba.brunointellij.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.vrba.brunointellij.language.psi.BlockTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.vrba.brunointellij.language.psi.*;

public class BlockBlockContentImpl extends ASTWrapperPsiElement implements BlockBlockContent {

  public BlockBlockContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BlockVisitor visitor) {
    visitor.visitBlockContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BlockVisitor) accept((BlockVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getBlockContentToken() {
    return findNotNullChildByType(BLOCK_CONTENT_TOKEN);
  }

}
