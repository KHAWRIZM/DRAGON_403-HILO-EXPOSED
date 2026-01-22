package com.alibaba.sdk.android.logger.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f٦٤٤٣a;

    public g(String str) {
        this.f٦٤٤٣a = str;
        if (str == null) {
            this.f٦٤٤٣a = "default";
        }
    }

    public String a(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else if (obj instanceof Class) {
            str = ((Class) obj).getSimpleName();
        } else if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName() + "@" + obj.hashCode();
        }
        return this.f٦٤٤٣a + "_" + str;
    }
}
