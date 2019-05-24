package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;

import java.util.Collection;
import java.util.List;

public class CcsLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
            if (value != null && value.startsWith("ccs"+ ":")) {
                Project project = element.getProject();
                final List<CcsProperty> properties = CcsUtil.findProperties(project, value.substring(4));
                if (properties.size() > 0) {
                    NavigationGutterIconBuilder<PsiElement> builder = NavigationGutterIconBuilder
                            .create(CcsIcons.FILE)
                            .setTargets(properties)
                            .setTooltipText("Navigate to a ccs property");
                    result.add(builder.createLineMarkerInfo(element));
                }
            }
        }
    }
}
