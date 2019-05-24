package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsFile;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.aaronbedra.jetbrains.psi.impl.CcsPropertyImpl;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CcsStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private NavigatablePsiElement element;

    public CcsStructureViewElement(NavigatablePsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        element.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return element.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        String name = element.getName();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = element.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @Override
    public TreeElement[] getChildren() {
        if (element instanceof CcsFile) {
            CcsProperty[] properties = PsiTreeUtil.getChildrenOfType(element, CcsProperty.class);
            List<TreeElement> treeElements = new ArrayList<TreeElement>(properties.length);
            for (CcsProperty property : properties) {
                treeElements.add(new CcsStructureViewElement((CcsPropertyImpl) property));
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        } else {
            return EMPTY_ARRAY;
        }
    }
}
