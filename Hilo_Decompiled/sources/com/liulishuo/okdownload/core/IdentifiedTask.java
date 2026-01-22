package com.liulishuo.okdownload.core;

import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class IdentifiedTask {
    public static final File EMPTY_FILE = new File("");
    public static final String EMPTY_URL = "";

    public boolean compareIgnoreId(IdentifiedTask identifiedTask) {
        if (!getUrl().equals(identifiedTask.getUrl()) || getUrl().equals("") || getParentFile().equals(EMPTY_FILE)) {
            return false;
        }
        if (getProvidedPathFile().equals(identifiedTask.getProvidedPathFile())) {
            return true;
        }
        if (!getParentFile().equals(identifiedTask.getParentFile())) {
            return false;
        }
        String filename = getFilename();
        String filename2 = identifiedTask.getFilename();
        if (filename2 == null || filename == null || !filename2.equals(filename)) {
            return false;
        }
        return true;
    }

    public abstract String getFilename();

    public abstract int getId();

    public abstract File getParentFile();

    public abstract File getProvidedPathFile();

    public abstract String getUrl();
}
