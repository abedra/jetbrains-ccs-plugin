package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;

public class CcsCompletionComtributor extends CompletionContributor {
    public CcsCompletionComtributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(CcsTypes.VALUE).withLanguage(Ccs.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(CompletionParameters parameters,
                                               ProcessingContext context,
                                               CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("Hello"));
                    }
                }
        );
    }
}
