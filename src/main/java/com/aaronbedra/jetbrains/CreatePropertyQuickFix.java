package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsElementFactory;
import com.aaronbedra.jetbrains.psi.CcsFile;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class CreatePropertyQuickFix extends BaseIntentionAction {
    private String key;

    CreatePropertyQuickFix(String key) {
        this.key = key;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create property";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Ccs properties";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                Collection<VirtualFile> virtualFiles =
                        FileTypeIndex.getFiles(CcsFileType.INSTANCE, GlobalSearchScope.allScope(project));
                if (virtualFiles.size() == 1) {
                    createProperty(project, virtualFiles.iterator().next());
                } else {
                    final FileChooserDescriptor descriptor =
                            FileChooserDescriptorFactory.createSingleFileDescriptor(CcsFileType.INSTANCE);
                    descriptor.setRoots(ProjectUtil.guessProjectDir(project));
                    final VirtualFile file = FileChooser.chooseFile(descriptor, project, null);
                    if (file != null) {
                        createProperty(project, file);
                    }
                }
            }
        });
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            CcsFile ccsFile = (CcsFile) PsiManager.getInstance(project).findFile(file);
            ASTNode lastChildNode = ccsFile.getNode().getLastChildNode();
            if (lastChildNode != null) {
                ccsFile.getNode().addChild(CcsElementFactory.createCRLF(project).getNode());
            }
            CcsProperty property = CcsElementFactory.createProperty(project, key.replaceAll(" ", "\\\\ "), "");
            ccsFile.getNode().addChild(property.getNode());
            ((Navigatable) property.getLastChild().getNavigationElement()).navigate(true);
            FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }
}
