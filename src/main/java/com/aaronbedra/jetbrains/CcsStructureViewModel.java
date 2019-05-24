package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsFile;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class CcsStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public CcsStructureViewModel(PsiFile psiFile) {
        super(psiFile, new CcsStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof CcsFile;
    }
}
