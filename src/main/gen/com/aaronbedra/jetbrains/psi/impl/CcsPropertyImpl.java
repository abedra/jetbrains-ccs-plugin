// This is a generated file. Not intended for manual editing.
package com.aaronbedra.jetbrains.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.aaronbedra.jetbrains.psi.CcsTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.aaronbedra.jetbrains.psi.*;

public class CcsPropertyImpl extends ASTWrapperPsiElement implements CcsProperty {

  public CcsPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CcsVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CcsVisitor) accept((CcsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return CcsPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return CcsPsiImplUtil.getValue(this);
  }

}
