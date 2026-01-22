package tech.sud.logger;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Sudfor implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        int i = LogUtils.V;
        return str.matches("^" + LogUtils.Sudfor.Sudfor + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }
}
