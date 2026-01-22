package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import m4.l;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements l {
    @Override // m4.l
    public m4.c a(m4.i iVar) {
        return m4.c.SOURCE;
    }

    @Override // m4.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean encode(v vVar, File file, m4.i iVar) {
        try {
            f5.a.f(((c) vVar.get()).c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }
}
