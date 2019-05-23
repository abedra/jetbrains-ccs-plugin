package com.aaronbedra.jetbrains.psi;

import com.aaronbedra.jetbrains.Ccs;
import com.intellij.psi.tree.IElementType;

public class CcsElementType extends IElementType {
    public CcsElementType(String debugName) {
        super(debugName, Ccs.INSTANCE);
    }
}
