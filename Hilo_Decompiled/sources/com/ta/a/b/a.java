package com.ta.a.b;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public int a = -1;
    public long timestamp = 0;

    /* renamed from: a, reason: collision with other field name */
    public String f١a = "";
    public byte[] data = null;
    public long b = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.ta.a.c.f.b("", "result", str, TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, str2);
                if (str2.equals(com.ta.utdid2.a.a.a.encodeToString(com.ta.a.c.b.d(str).getBytes(), 2))) {
                    com.ta.a.c.f.m١٢٧a("", "signature is ok");
                    return true;
                }
                com.ta.a.c.f.m١٢٧a("", "signature is error");
            }
        } catch (Exception e) {
            com.ta.a.c.f.m١٢٧a("", e);
        }
        return false;
    }
}
