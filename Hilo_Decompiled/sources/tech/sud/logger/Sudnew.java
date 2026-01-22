package tech.sud.logger;

import android.util.Log;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Sudnew implements Runnable {
    public final /* synthetic */ File Suddo;

    public Sudnew(File file) {
        this.Suddo = file;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.Suddo.delete()) {
            Log.e("LogUtils", "delete " + this.Suddo + " failed!");
        }
    }
}
