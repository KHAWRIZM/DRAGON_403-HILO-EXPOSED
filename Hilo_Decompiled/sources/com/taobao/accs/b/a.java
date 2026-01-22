package com.taobao.accs.b;

import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private static a a;
    private ClassLoader b = null;
    private boolean c = false;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (a == null) {
                    a = new a();
                }
                aVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public synchronized ClassLoader b() {
        try {
            if (this.b == null) {
                ALog.d("ACCSClassLoader", "getClassLoader", new Object[0]);
                this.b = a.class.getClassLoader();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }
}
