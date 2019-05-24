package com.aaronbedra.jetbrains.psi.impl;

import com.aaronbedra.jetbrains.psi.CcsNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;

public abstract class CcsNamedElementImpl extends ASTWrapperPsiElement implements CcsNamedElement {
    public CcsNamedElementImpl(ASTNode node) {
        super(node);
    }
}
