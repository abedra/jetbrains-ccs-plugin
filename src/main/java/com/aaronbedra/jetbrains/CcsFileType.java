package com.aaronbedra.jetbrains;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CcsFileType extends LanguageFileType {
    public static final CcsFileType INSTANCE = new CcsFileType();

    private CcsFileType() {
        super(Ccs.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Ccs File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Ccs language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ccs";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CcsIcons.FILE;
    }
}
