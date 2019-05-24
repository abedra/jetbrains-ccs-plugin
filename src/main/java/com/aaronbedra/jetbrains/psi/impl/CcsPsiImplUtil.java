package com.aaronbedra.jetbrains.psi.impl;

import com.aaronbedra.jetbrains.CcsIcons;
import com.aaronbedra.jetbrains.psi.CcsElementFactory;
import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.aaronbedra.jetbrains.psi.CcsTypes;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CcsPsiImplUtil {
    public static String getKey(CcsProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(CcsTypes.KEY);
        if (keyNode != null) {
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(CcsProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(CcsTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(CcsProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(CcsProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(CcsTypes.KEY);
        if (keyNode != null) {
            CcsProperty property = CcsElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(CcsProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(CcsTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final CcsProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return CcsIcons.FILE;
            }
        };
    }
}
