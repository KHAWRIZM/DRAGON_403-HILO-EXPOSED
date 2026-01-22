package com.tencent.trtc.txcopyrightedmedia;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.SoLoader;

@JNINamespace("liteav::extensions")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class YsdLibLoader {
    public static String getLibraryPath() {
        return SoLoader.getLibraryPath();
    }

    public static boolean loadLibrary() {
        return SoLoader.loadLibrary("txktvscore");
    }
}
