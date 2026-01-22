package com.ta.utdid2.device;

import com.ta.a.c.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class e {
    public static boolean a(com.ta.a.b.a aVar) {
        String str;
        try {
            str = new String(aVar.data, "UTF-8");
        } catch (Exception e) {
            Object[] objArr = {e};
            str = "";
            f.m١٢٧a("", objArr);
        }
        if (!com.ta.a.b.a.a(str, aVar.f١a)) {
            return false;
        }
        return b.a(b.a(str).d);
    }
}
