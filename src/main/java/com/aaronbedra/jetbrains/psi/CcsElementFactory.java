package com.aaronbedra.jetbrains.psi;

import com.aaronbedra.jetbrains.CcsFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class CcsElementFactory {
    public static CcsProperty createProperty(Project project, String name, String value) {
        final CcsFile file = createFile(project, name + " = " + value);
        return (CcsProperty) file.getFirstChild();
    }

    public static CcsProperty createProperty(Project project, String name) {
        final CcsFile file = createFile(project, name);
        return (CcsProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final CcsFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static CcsFile createFile(Project project, String text) {
        String name = "dummy.ccs";
        return (CcsFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, CcsFileType.INSTANCE, text);
    }
}
