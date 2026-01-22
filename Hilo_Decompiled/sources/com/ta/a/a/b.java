package com.ta.a.a;

import android.text.TextUtils;
import com.ta.a.c.e;
import com.ta.a.c.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(com.ta.utdid2.a.a.a.encode(e.b(str.getBytes()), 2), "UTF-8");
        } catch (Exception e) {
            f.a("", e, new Object[0]);
            return "";
        }
    }
}
