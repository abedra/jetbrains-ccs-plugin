// This is a generated file. Not intended for manual editing.
package com.aaronbedra.jetbrains.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.aaronbedra.jetbrains.psi.impl.*;

public interface CcsTypes {

  IElementType PROPERTY = new CcsElementType("PROPERTY");

  IElementType COMMENT = new CcsTokenType("COMMENT");
  IElementType CRLF = new CcsTokenType("CRLF");
  IElementType KEY = new CcsTokenType("KEY");
  IElementType SEPARATOR = new CcsTokenType("SEPARATOR");
  IElementType VALUE = new CcsTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new CcsPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
