// This is a generated file. Not intended for manual editing.
package com.aaronbedra.jetbrains.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CcsVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull CcsProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull CcsNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
