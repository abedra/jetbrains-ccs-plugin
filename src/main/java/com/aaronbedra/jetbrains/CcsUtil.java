package com.aaronbedra.jetbrains;

import com.aaronbedra.jetbrains.psi.CcsFile;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CcsUtil {
    public static List<CcsProperty> findProperties(Project project, String key) {
        List<CcsProperty> result = null;
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(CcsFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            CcsFile ccsFile = (CcsFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (ccsFile != null) {
                CcsProperty[] properties = PsiTreeUtil.getChildrenOfType(ccsFile, CcsProperty.class);
                if (properties != null) {
                    for (CcsProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<CcsProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<CcsProperty>emptyList();
    }

    public static List<CcsProperty> findProperties(Project project) {
        List<CcsProperty> result = new ArrayList<CcsProperty>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(CcsFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            CcsFile ccsFile = (CcsFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (ccsFile != null) {
                CcsProperty[] properties = PsiTreeUtil.getChildrenOfType(ccsFile, CcsProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}
