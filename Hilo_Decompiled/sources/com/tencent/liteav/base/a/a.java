package com.tencent.liteav.base.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    protected static a a;
    private int b = 60;
    private int c = 70;
    private int d = 80;
    private int e = 50;
    private int f = 10;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                try {
                    if (a == null) {
                        a = new a();
                    }
                } finally {
                }
            }
        }
        return a;
    }
}
