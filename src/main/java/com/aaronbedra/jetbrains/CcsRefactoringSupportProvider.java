package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;

public class CcsRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof CcsProperty;
    }
}
