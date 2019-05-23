package com.aaronbedra.jetbrains.psi;

import com.aaronbedra.jetbrains.Ccs;
import com.aaronbedra.jetbrains.CcsFileType;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CcsFile extends PsiFileBase {
    public CcsFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, Ccs.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CcsFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Ccs File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
