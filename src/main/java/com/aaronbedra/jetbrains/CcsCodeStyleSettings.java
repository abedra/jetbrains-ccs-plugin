package com.aaronbedra.jetbrains;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class CcsCodeStyleSettings extends CustomCodeStyleSettings {
    public CcsCodeStyleSettings(CodeStyleSettings settings) {
        super("CcsCodeStyleSettings", settings);
    }
}
