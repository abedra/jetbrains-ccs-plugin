package com.aaronbedra.jetbrains.psi;

import com.aaronbedra.jetbrains.Ccs;
import com.intellij.psi.tree.IElementType;

public class CcsTokenType extends IElementType {
    public CcsTokenType(String debugName) {
        super(debugName, Ccs.INSTANCE);
    }

    @Override
    public String toString() {
        return "CcsTokenType." + super.toString();
    }
}
