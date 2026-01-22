package com.tencent.liteav.videobase.utils;

import android.content.Intent;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class d {
    private static final com.tencent.liteav.base.b.a a = new com.tencent.liteav.base.b.a(1000);

    public static byte[] a(int i) {
        try {
            return new byte[i];
        } catch (OutOfMemoryError e) {
            a(e.getMessage());
            return null;
        }
    }

    public static ByteBuffer b(int i) {
        try {
            return ByteBuffer.allocateDirect(i);
        } catch (OutOfMemoryError e) {
            a(e.getMessage());
            return null;
        }
    }

    private static synchronized void a(String str) {
        synchronized (d.class) {
            if (a.a()) {
                LiteavLog.e("MemoryAllocator", "allocate buffer failed with oom error, msg:".concat(String.valueOf(str)));
                c.a().a(new Intent("com.tencent.liteav.video.action.OUT_OF_MEMORY"));
            }
        }
    }
}
