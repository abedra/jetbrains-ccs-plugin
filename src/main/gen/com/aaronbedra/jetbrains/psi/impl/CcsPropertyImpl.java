// This is a generated file. Not intended for manual editing.
package com.aaronbedra.jetbrains.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.aaronbedra.jetbrains.psi.CcsTypes.*;
import com.aaronbedra.jetbrains.psi.*;

public class CcsPropertyImpl extends CcsNamedElementImpl implements CcsProperty {

  public CcsPropertyImpl(ASTNode node) {
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

  @Override
  public String getName() {
    return CcsPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return CcsPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return CcsPsiImplUtil.getNameIdentifier(this);
  }

}
