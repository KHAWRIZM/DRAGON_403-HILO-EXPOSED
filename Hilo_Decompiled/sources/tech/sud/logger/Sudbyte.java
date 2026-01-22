package tech.sud.logger;

import android.util.Log;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Sudbyte implements Runnable {
    public final /* synthetic */ File Suddo;

    public Sudbyte(File file) {
        this.Suddo = file;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.Suddo.delete()) {
            Log.e("LogUtils", "delete " + this.Suddo + " failed!");
        }
    }
}
