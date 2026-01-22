package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.ServiceReceiver;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class f {
    protected static volatile f b;
    private static final int[] c = {270, 360, 480};
    protected Context a;
    private int d;
    private long e;
    private boolean f = false;
    private int[] g = {0, 0, 0};
    private boolean h;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context) {
        this.h = true;
        try {
            this.a = context;
            this.d = 0;
            this.e = System.currentTimeMillis();
            this.h = OrangeAdapter.isSmartHb();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        if (b(context)) {
                            ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                            b = new t(context);
                        } else if (c(context)) {
                            ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                            b = new a(context);
                        } else {
                            ALog.i("HeartbeatManager", "hb use thread", new Object[0]);
                            b = new u(context);
                        }
                    }
                } finally {
                }
            }
        }
        return b;
    }

    private static boolean b(Context context) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), AccsJobService.class.getName())) == 1;
    }

    private static boolean c(Context context) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), ServiceReceiver.class.getName())) == 1;
    }

    protected abstract void a(int i);

    public void d() {
        this.e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.e > 7199000) {
            int i = this.d;
            if (i < c.length - 1 && this.g[i] <= 2) {
                ALog.d("HeartbeatManager", "upgrade", new Object[0]);
                this.d++;
                this.f = true;
                this.e = System.currentTimeMillis();
                return;
            }
            return;
        }
        this.f = false;
        this.g[this.d] = 0;
    }

    public void f() {
        this.d = 0;
        this.e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i = this.h ? c[this.d] : 270;
        this.h = OrangeAdapter.isSmartHb();
        return i;
    }

    public void c() {
        this.e = -1L;
        if (this.f) {
            int[] iArr = this.g;
            int i = this.d;
            iArr[i] = iArr[i] + 1;
        }
        int i2 = this.d;
        this.d = i2 > 0 ? i2 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public synchronized void a() {
        try {
            if (this.e < 0) {
                this.e = System.currentTimeMillis();
            }
            int b2 = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + b2, new Object[0]);
            }
            a(b2);
        } finally {
        }
    }
}
