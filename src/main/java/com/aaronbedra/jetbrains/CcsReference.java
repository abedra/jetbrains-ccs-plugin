package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsFile;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CcsReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private String key;

    public CcsReference(PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<CcsProperty> properties = CcsUtil.findProperties(project, key);
        List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (CcsProperty property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<CcsProperty> properties = CcsUtil.findProperties(project);
        List<LookupElement> variants = new ArrayList<LookupElement>();
        for (final CcsProperty property : properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property)
                        .withIcon(CcsIcons.FILE)
                        .withTypeText(property.getContainingFile().getName()));
            }
        }
        return variants.toArray();
    }
}
