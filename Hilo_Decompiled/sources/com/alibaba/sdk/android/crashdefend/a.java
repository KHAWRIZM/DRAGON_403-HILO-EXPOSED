package com.alibaba.sdk.android.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.crashdefend.a.b;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f٦٣٦٣a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f٦٣٦٤b;

    /* renamed from: d, reason: collision with root package name */
    private b f٦٣٦٦d;

    /* renamed from: c, reason: collision with root package name */
    private final com.alibaba.sdk.android.crashdefend.a.a f٦٣٦٥c = new com.alibaba.sdk.android.crashdefend.a.a();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f٦٣٦٨f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final int[] f٦٣٦٩g = new int[5];

    /* renamed from: h, reason: collision with root package name */
    private final List<b> f٦٣٧٠h = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final ExecutorService f٦٣٦٧e = new com.alibaba.sdk.android.crashdefend.b.a().a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.alibaba.sdk.android.crashdefend.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class RunnableC٠٠٧٦a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private b f٦٣٧٣b;

        /* renamed from: c, reason: collision with root package name */
        private int f٦٣٧٤c;

        RunnableC٠٠٧٦a(b bVar, int i10) {
            this.f٦٣٧٣b = bVar;
            this.f٦٣٧٤c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            do {
                try {
                    Thread.sleep(1000L);
                    i10 = this.f٦٣٧٤c - 1;
                    this.f٦٣٧٤c = i10;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e10) {
                    Log.d("CrashDefend", e10.getMessage(), e10);
                    return;
                }
            } while (i10 > 0);
            if (i10 <= 0) {
                a.this.c(this.f٦٣٧٣b);
                com.alibaba.sdk.android.crashdefend.c.a.a(a.this.f٦٣٦٤b, a.this.f٦٣٦٥c, a.this.f٦٣٧٠h);
            }
        }
    }

    private a(Context context) {
        this.f٦٣٦٤b = context.getApplicationContext();
        for (int i10 = 0; i10 < 5; i10++) {
            this.f٦٣٦٩g[i10] = (i10 * 5) + 5;
        }
        this.f٦٣٦٨f.put("sdkId", "crashdefend");
        this.f٦٣٦٨f.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "0.0.6");
        try {
            a();
            b();
        } catch (Exception e10) {
            Log.d("CrashDefend", e10.getMessage(), e10);
        }
    }

    private void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f٦٣٦٧e.execute(new RunnableC٠٠٧٦a(bVar, bVar.f٦٣٧٩e));
    }

    public static a a(Context context) {
        if (f٦٣٦٣a == null) {
            synchronized (a.class) {
                try {
                    if (f٦٣٦٣a == null) {
                        f٦٣٦٣a = new a(context);
                    }
                } finally {
                }
            }
        }
        return f٦٣٦٣a;
    }

    private synchronized b b(b bVar, CrashDefendCallback crashDefendCallback) {
        try {
            b bVar2 = null;
            if (this.f٦٣٧٠h.size() > 0) {
                Iterator<b> it = this.f٦٣٧٠h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next != null && next.f٦٣٧٥a.equals(bVar.f٦٣٧٥a)) {
                        if (!next.f٦٣٧٦b.equals(bVar.f٦٣٧٦b)) {
                            next.f٦٣٧٦b = bVar.f٦٣٧٦b;
                            next.f٦٣٧٧c = bVar.f٦٣٧٧c;
                            next.f٦٣٧٩e = bVar.f٦٣٧٩e;
                            next.f٦٣٧٨d = 0;
                            next.f٦٣٨٢h = 0;
                            next.f٦٣٨٣i = 0L;
                        }
                        if (next.f٦٣٨٤j) {
                            com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", "SDK " + bVar.f٦٣٧٥a + " has been registered");
                            return null;
                        }
                        next.f٦٣٨٤j = true;
                        next.f٦٣٨٥k = crashDefendCallback;
                        next.f٦٣٨٠f = this.f٦٣٦٥c.f٦٣٧١a;
                        bVar2 = next;
                    }
                }
            }
            if (bVar2 == null) {
                bVar2 = (b) bVar.clone();
                bVar2.f٦٣٨٤j = true;
                bVar2.f٦٣٨٥k = crashDefendCallback;
                bVar2.f٦٣٧٨d = 0;
                bVar2.f٦٣٨٠f = this.f٦٣٦٥c.f٦٣٧١a;
                this.f٦٣٧٠h.add(bVar2);
            }
            return bVar2;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.f٦٣٧٨d = 0;
        bVar.f٦٣٨٢h = 0;
    }

    private void a() {
        if (!com.alibaba.sdk.android.crashdefend.c.a.b(this.f٦٣٦٤b, this.f٦٣٦٥c, this.f٦٣٧٠h)) {
            this.f٦٣٦٥c.f٦٣٧١a = 1L;
        } else {
            this.f٦٣٦٥c.f٦٣٧١a++;
        }
    }

    private void b() {
        String str;
        String str2;
        this.f٦٣٦٦d = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f٦٣٧٠h) {
            try {
                for (b bVar : this.f٦٣٧٠h) {
                    if (bVar.f٦٣٧٨d >= bVar.f٦٣٧٧c) {
                        arrayList.add(bVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar2 = (b) it.next();
                    if (bVar2.f٦٣٨٢h < 5) {
                        long j10 = this.f٦٣٦٥c.f٦٣٧١a - this.f٦٣٦٩g[r3];
                        long j11 = (bVar2.f٦٣٨١g - j10) + 1;
                        com.alibaba.sdk.android.crashdefend.c.b.a("CrashDefend", "after restart " + j11 + " times, sdk will be restore");
                        bVar2.f٦٣٨٣i = j11;
                        if (bVar2.f٦٣٨١g < j10) {
                            this.f٦٣٦٦d = bVar2;
                            break;
                        }
                    } else {
                        com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", "SDK " + bVar2.f٦٣٧٥a + " has been closed");
                    }
                }
                b bVar3 = this.f٦٣٦٦d;
                if (bVar3 == null) {
                    str = "CrashDefend";
                    str2 = "NO SDK restore";
                } else {
                    bVar3.f٦٣٨٢h++;
                    str = "CrashDefend";
                    str2 = this.f٦٣٦٦d.f٦٣٧٥a + " will restore --- startSerialNumber:" + this.f٦٣٦٦d.f٦٣٨١g + "   crashCount:" + this.f٦٣٦٦d.f٦٣٧٨d;
                }
                com.alibaba.sdk.android.crashdefend.c.b.b(str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b(b bVar) {
        if (bVar == null) {
            return;
        }
        d(bVar);
        CrashDefendCallback crashDefendCallback = bVar.f٦٣٨٥k;
        if (crashDefendCallback != null) {
            crashDefendCallback.onSdkStart(bVar.f٦٣٧٧c, bVar.f٦٣٧٨d - 1, bVar.f٦٣٨٢h);
        }
    }

    private boolean a(b bVar) {
        if (bVar.f٦٣٧٨d >= bVar.f٦٣٧٧c) {
            b bVar2 = this.f٦٣٦٦d;
            if (bVar2 == null || !bVar2.f٦٣٧٥a.equals(bVar.f٦٣٧٥a)) {
                return false;
            }
            bVar.f٦٣٧٨d = bVar.f٦٣٧٧c - 1;
        }
        bVar.f٦٣٨١g = bVar.f٦٣٨٠f;
        return true;
    }

    private boolean a(b bVar, CrashDefendCallback crashDefendCallback) {
        b b10;
        String str;
        if (bVar != null && crashDefendCallback != null) {
            try {
                if (TextUtils.isEmpty(bVar.f٦٣٧٦b) || TextUtils.isEmpty(bVar.f٦٣٧٥a) || (b10 = b(bVar, crashDefendCallback)) == null) {
                    return false;
                }
                boolean a10 = a(b10);
                b10.f٦٣٧٨d++;
                com.alibaba.sdk.android.crashdefend.c.a.a(this.f٦٣٦٤b, this.f٦٣٦٥c, this.f٦٣٧٠h);
                if (a10) {
                    b(b10);
                    str = "START:" + b10.f٦٣٧٥a + " --- limit:" + b10.f٦٣٧٧c + "  count:" + (b10.f٦٣٧٨d - 1) + "  restore:" + b10.f٦٣٨٢h + "  startSerialNumber:" + b10.f٦٣٨١g + "  registerSerialNumber:" + b10.f٦٣٨٠f;
                } else {
                    int i10 = b10.f٦٣٨٢h;
                    if (i10 >= 5) {
                        crashDefendCallback.onSdkClosed(i10);
                        str = "CLOSED: " + b10.f٦٣٧٥a + " --- restored " + b10.f٦٣٨٢h + ", has more than retry limit, so closed it";
                    } else {
                        crashDefendCallback.onSdkStop(b10.f٦٣٧٧c, b10.f٦٣٧٨d - 1, i10, b10.f٦٣٨٣i);
                        str = "STOP:" + b10.f٦٣٧٥a + " --- limit:" + b10.f٦٣٧٧c + "  count:" + (b10.f٦٣٧٨d - 1) + "  restore:" + b10.f٦٣٨٢h + "  startSerialNumber:" + b10.f٦٣٨١g + "  registerSerialNumber:" + b10.f٦٣٨٠f;
                    }
                }
                com.alibaba.sdk.android.crashdefend.c.b.b("CrashDefend", str);
                return true;
            } catch (Exception e10) {
                Log.d("CrashDefend", e10.getMessage(), e10);
            }
        }
        return false;
    }

    public boolean a(String str, String str2, int i10, int i11, CrashDefendCallback crashDefendCallback) {
        b bVar = new b();
        bVar.f٦٣٧٥a = str;
        bVar.f٦٣٧٦b = str2;
        bVar.f٦٣٧٧c = i10;
        bVar.f٦٣٧٩e = i11;
        return a(bVar, crashDefendCallback);
    }
}
