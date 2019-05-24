package com.aaronbedra.jetbrains;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.*;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import org.jetbrains.annotations.*;

import java.util.*;

public class CcsFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        FoldingGroup group = FoldingGroup.newGroup("ccs");

        List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        Collection<PsiLiteralExpression> literalExpressions = PsiTreeUtil.findChildrenOfType(root, PsiLiteralExpression.class);
        for (final PsiLiteralExpression literalExpression : literalExpressions) {
            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;

            if (value != null && value.startsWith("ccs:")) {
                Project project = literalExpression.getProject();
                String key = value.substring(4);
                final List<CcsProperty> properties = CcsUtil.findProperties(project, key);
                if (properties.size() == 1) {
                    descriptors.add(
                            new FoldingDescriptor(
                                    literalExpression.getNode(),
                                    new TextRange(literalExpression.getTextRange().getStartOffset() + 1,
                                    literalExpression.getTextRange().getEndOffset() - 1),
                                    group) {
                        @Nullable
                        @Override
                        public String getPlaceholderText() {
                            String valueOf = properties.get(0).getValue();
                            return valueOf == null ? "" : valueOf.replaceAll("\n", "\\n").replaceAll("\"", "\\\\\"");
                        }
                    });
                }
            }
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }
}
