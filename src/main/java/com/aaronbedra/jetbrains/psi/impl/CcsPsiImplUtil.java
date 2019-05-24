package com.aaronbedra.jetbrains.psi.impl;

import com.aaronbedra.jetbrains.psi.CcsProperty;
import com.aaronbedra.jetbrains.psi.CcsTypes;
import com.intellij.lang.ASTNode;

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
}
