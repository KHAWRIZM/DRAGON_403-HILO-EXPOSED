package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class n implements m4.l {
    @Override // m4.l
    public m4.c a(m4.i iVar) {
        return m4.c.SOURCE;
    }

    @Override // m4.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean encode(v vVar, File file, m4.i iVar) {
        try {
            f5.a.f(((m) vVar.get()).c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("WebpEncoder", 5)) {
                Log.w("WebpEncoder", "Failed to encode WebP drawable data", e10);
            }
            return false;
        }
    }
}
