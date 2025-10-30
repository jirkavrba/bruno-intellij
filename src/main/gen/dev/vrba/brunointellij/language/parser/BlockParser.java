// This is a generated file. Not intended for manual editing.
package dev.vrba.brunointellij.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.vrba.brunointellij.language.psi.BlockTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BlockParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // block_name LBRACE block_content? RBRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, null);
    r = block_name(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, block_2(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // block_content?
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    block_content(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BLOCK_CONTENT_TOKEN
  public static boolean block_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_content")) return false;
    if (!nextTokenIs(b, BLOCK_CONTENT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_CONTENT_TOKEN);
    exit_section_(b, m, BLOCK_CONTENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (COLON IDENTIFIER)?
  public static boolean block_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && block_name_1(b, l + 1);
    exit_section_(b, m, BLOCK_NAME, r);
    return r;
  }

  // (COLON IDENTIFIER)?
  private static boolean block_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name_1")) return false;
    block_name_1_0(b, l + 1);
    return true;
  }

  // COLON IDENTIFIER
  private static boolean block_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // block*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

}
