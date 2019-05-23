package com.aaronbedra.jetbrains;

import com.intellij.lang.Language;

public class Ccs extends Language {
    public static final Ccs INSTANCE = new Ccs();

    private Ccs() {
        super("Ccs");
    }
}
