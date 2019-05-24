package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.aaronbedra.jetbrains.psi.CcsTypes;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CcsFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(
                new CcsLexerAdapter(),
                TokenSet.create(CcsTypes.KEY),
                TokenSet.create(CcsTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(PsiElement element) {
        if (element instanceof CcsProperty) {
            return "ccs property";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(PsiElement element) {
        if (element instanceof CcsProperty) {
            return ((CcsProperty) element).getKey();
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getNodeText(PsiElement element, boolean useFullName) {
        if (element instanceof CcsProperty) {
            return ((CcsProperty) element).getKey() + ":" + ((CcsProperty) element).getValue();
        } else {
            return "";
        }
    }
}
