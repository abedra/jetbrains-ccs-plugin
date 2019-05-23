package com.aaronbedra.jetbrains;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

import java.io.Reader;

public class CcsLexerAdapter extends FlexAdapter {
    public CcsLexerAdapter() {
        super(new CcsLexer((Reader) null));
    }
}
