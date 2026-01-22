package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.billingclient.api.j0;
import com.android.billingclient.api.v;
import com.google.android.gms.internal.play_billing.zzaa;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzgz;
import com.google.android.gms.internal.play_billing.zzhb;
import com.google.android.gms.internal.play_billing.zzs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends g {
    private boolean A;

    /* renamed from: B */
    private ExecutorService f٧٠٥٣B;

    /* renamed from: a */
    private volatile int f٧٠٥٤a;

    /* renamed from: b */
    private final String f٧٠٥٥b;

    /* renamed from: c */
    private final Handler f٧٠٥٦c;

    /* renamed from: d */
    private volatile i3 f٧٠٥٧d;

    /* renamed from: e */
    private Context f٧٠٥٨e;

    /* renamed from: f */
    private d2 f٧٠٥٩f;

    /* renamed from: g */
    private volatile zzs f٧٠٦٠g;

    /* renamed from: h */
    private volatile l1 f٧٠٦١h;

    /* renamed from: i */
    private boolean f٧٠٦٢i;

    /* renamed from: j */
    private boolean f٧٠٦٣j;

    /* renamed from: k */
    private int f٧٠٦٤k;

    /* renamed from: l */
    private boolean f٧٠٦٥l;

    /* renamed from: m */
    private boolean f٧٠٦٦m;

    /* renamed from: n */
    private boolean f٧٠٦٧n;

    /* renamed from: o */
    private boolean f٧٠٦٨o;

    /* renamed from: p */
    private boolean f٧٠٦٩p;

    /* renamed from: q */
    private boolean f٧٠٧٠q;

    /* renamed from: r */
    private boolean f٧٠٧١r;

    /* renamed from: s */
    private boolean f٧٠٧٢s;

    /* renamed from: t */
    private boolean f٧٠٧٣t;

    /* renamed from: u */
    private boolean f٧٠٧٤u;

    /* renamed from: v */
    private boolean f٧٠٧٥v;

    /* renamed from: w */
    private boolean f٧٠٧٦w;

    /* renamed from: x */
    private boolean f٧٠٧٧x;

    /* renamed from: y */
    private boolean f٧٠٧٨y;

    /* renamed from: z */
    private d0 f٧٠٧٩z;

    public h(String str, Context context, d2 d2Var, ExecutorService executorService) {
        this.f٧٠٥٤a = 0;
        this.f٧٠٥٦c = new Handler(Looper.getMainLooper());
        this.f٧٠٦٤k = 0;
        String Z = Z();
        this.f٧٠٥٥b = Z;
        this.f٧٠٥٨e = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(Z);
        zzy.zzm(this.f٧٠٥٨e.getPackageName());
        this.f٧٠٥٩f = new i2(this.f٧٠٥٨e, (zzgu) zzy.zzf());
        this.f٧٠٥٨e.getPackageName();
    }

    public static /* bridge */ /* synthetic */ w2 S(h hVar, String str, int i10) {
        Bundle zzi;
        w2 w2Var;
        int i11;
        zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = zzb.zzc(hVar.f٧٠٦٧n, hVar.f٧٠٧٥v, hVar.f٧٠٧٩z.a(), hVar.f٧٠٧٩z.b(), hVar.f٧٠٥٥b);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                if (hVar.f٧٠٦٧n) {
                    zzs zzsVar = hVar.f٧٠٦٠g;
                    if (true != hVar.f٧٠٧٥v) {
                        i11 = 9;
                    } else {
                        i11 = 19;
                    }
                    zzi = zzsVar.zzj(i11, hVar.f٧٠٥٨e.getPackageName(), str, str2, zzc);
                } else {
                    zzi = hVar.f٧٠٦٠g.zzi(3, hVar.f٧٠٥٨e.getPackageName(), str, str2);
                }
                x2 a10 = y2.a(zzi, "BillingClient", "getPurchase()");
                w a11 = a10.a();
                if (a11 != f2.f٧٠٣٠l) {
                    hVar.b0(c2.a(a10.b(), 9, a11));
                    return new w2(a11, list);
                }
                ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z10 = false;
                for (int i12 = 0; i12 < stringArrayList2.size(); i12++) {
                    String str3 = stringArrayList2.get(i12);
                    String str4 = stringArrayList3.get(i12);
                    zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i12))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.e())) {
                            zzb.zzk("BillingClient", "BUG: empty/null token!");
                            z10 = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e10) {
                        zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e10);
                        w wVar = f2.f٧٠٢٨j;
                        hVar.b0(c2.a(51, 9, wVar));
                        w2Var = new w2(wVar, null);
                        return w2Var;
                    }
                }
                if (z10) {
                    hVar.b0(c2.a(26, 9, f2.f٧٠٢٨j));
                }
                str2 = zzi.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    w2Var = new w2(f2.f٧٠٣٠l, arrayList);
                    break;
                }
                list = null;
            } catch (Exception e11) {
                w wVar2 = f2.f٧٠٣١m;
                hVar.b0(c2.a(52, 9, wVar2));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e11);
                return new w2(wVar2, null);
            }
        }
    }

    public final Handler V() {
        if (Looper.myLooper() == null) {
            return this.f٧٠٥٦c;
        }
        return new Handler(Looper.myLooper());
    }

    private final w W(final w wVar) {
        if (Thread.interrupted()) {
            return wVar;
        }
        this.f٧٠٥٦c.post(new Runnable() { // from class: com.android.billingclient.api.k3
            @Override // java.lang.Runnable
            public final void run() {
                h.this.J(wVar);
            }
        });
        return wVar;
    }

    public final w X() {
        if (this.f٧٠٥٤a != 0 && this.f٧٠٥٤a != 3) {
            return f2.f٧٠٢٨j;
        }
        return f2.f٧٠٣١m;
    }

    private final String Y(j0 j0Var) {
        if (!TextUtils.isEmpty(null)) {
            return null;
        }
        return this.f٧٠٥٨e.getPackageName();
    }

    private static String Z() {
        try {
            return (String) c4.a.class.getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.0.0";
        }
    }

    public final Future a0(Callable callable, long j10, final Runnable runnable, Handler handler) {
        if (this.f٧٠٥٣B == null) {
            this.f٧٠٥٣B = Executors.newFixedThreadPool(zzb.zza, new e1(this));
        }
        try {
            final Future submit = this.f٧٠٥٣B.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.o3
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (!future.isDone() && !future.isCancelled()) {
                        Runnable runnable2 = runnable;
                        future.cancel(true);
                        zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                }
            }, (long) (j10 * 0.95d));
            return submit;
        } catch (Exception e10) {
            zzb.zzl("BillingClient", "Async task throws exception!", e10);
            return null;
        }
    }

    public final void b0(zzga zzgaVar) {
        this.f٧٠٥٩f.d(zzgaVar, this.f٧٠٦٤k);
    }

    public final void c0(zzge zzgeVar) {
        this.f٧٠٥٩f.a(zzgeVar, this.f٧٠٦٤k);
    }

    private final void d0(String str, final g0 g0Var) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 11, wVar));
            g0Var.a(wVar, null);
        } else if (a0(new g1(this, str, g0Var), 30000L, new Runnable() { // from class: com.android.billingclient.api.y0
            @Override // java.lang.Runnable
            public final void run() {
                h.this.P(g0Var);
            }
        }, V()) == null) {
            w X = X();
            b0(c2.a(25, 11, X));
            g0Var.a(X, null);
        }
    }

    private final void e0(String str, final h0 h0Var) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 9, wVar));
            h0Var.a(wVar, zzai.zzk());
        } else {
            if (TextUtils.isEmpty(str)) {
                zzb.zzk("BillingClient", "Please provide a valid product type.");
                w wVar2 = f2.f٧٠٢٥g;
                b0(c2.a(50, 9, wVar2));
                h0Var.a(wVar2, zzai.zzk());
                return;
            }
            if (a0(new f1(this, str, h0Var), 30000L, new Runnable() { // from class: com.android.billingclient.api.s0
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.Q(h0Var);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 9, X));
                h0Var.a(X, zzai.zzk());
            }
        }
    }

    private final boolean f0() {
        if (this.f٧٠٧٥v && this.f٧٠٧٩z.b()) {
            return true;
        }
        return false;
    }

    private final void g0(w wVar, int i10, int i11) {
        zzge zzgeVar = null;
        zzga zzgaVar = null;
        if (wVar.b() != 0) {
            int i12 = c2.f٦٩٥٨a;
            try {
                zzfz zzy = zzga.zzy();
                zzgg zzy2 = zzgk.zzy();
                zzy2.zzn(wVar.b());
                zzy2.zzm(wVar.a());
                zzy2.zzo(i10);
                zzy.zzl(zzy2);
                zzy.zzn(5);
                zzgz zzy3 = zzhb.zzy();
                zzy3.zzl(i11);
                zzy.zzm((zzhb) zzy3.zzf());
                zzgaVar = (zzga) zzy.zzf();
            } catch (Exception e10) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            }
            b0(zzgaVar);
            return;
        }
        int i13 = c2.f٦٩٥٨a;
        try {
            zzgd zzy4 = zzge.zzy();
            zzy4.zzm(5);
            zzgz zzy5 = zzhb.zzy();
            zzy5.zzl(i11);
            zzy4.zzl((zzhb) zzy5.zzf());
            zzgeVar = (zzge) zzy4.zzf();
        } catch (Exception e11) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e11);
        }
        c0(zzgeVar);
    }

    public static /* bridge */ /* synthetic */ u1 m0(h hVar, String str) {
        u1 u1Var;
        Bundle zzh;
        x2 a10;
        w a11;
        zzb.zzj("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = zzb.zzc(hVar.f٧٠٦٧n, hVar.f٧٠٧٥v, hVar.f٧٠٧٩z.a(), hVar.f٧٠٧٩z.b(), hVar.f٧٠٥٥b);
        String str2 = null;
        while (hVar.f٧٠٦٥l) {
            try {
                zzh = hVar.f٧٠٦٠g.zzh(6, hVar.f٧٠٥٨e.getPackageName(), str, str2, zzc);
                a10 = y2.a(zzh, "BillingClient", "getPurchaseHistory()");
                a11 = a10.a();
            } catch (RemoteException e10) {
                zzb.zzl("BillingClient", "Got exception trying to get purchase history, try to reconnect", e10);
                w wVar = f2.f٧٠٣١m;
                hVar.b0(c2.a(59, 11, wVar));
                u1Var = new u1(wVar, null);
            }
            if (a11 != f2.f٧٠٣٠l) {
                hVar.b0(c2.a(a10.b(), 11, a11));
                return new u1(a11, null);
            }
            ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            boolean z10 = false;
            for (int i10 = 0; i10 < stringArrayList2.size(); i10++) {
                String str3 = stringArrayList2.get(i10);
                String str4 = stringArrayList3.get(i10);
                zzb.zzj("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i10))));
                try {
                    PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                    if (TextUtils.isEmpty(purchaseHistoryRecord.b())) {
                        zzb.zzk("BillingClient", "BUG: empty/null token!");
                        z10 = true;
                    }
                    arrayList.add(purchaseHistoryRecord);
                } catch (JSONException e11) {
                    zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e11);
                    w wVar2 = f2.f٧٠٢٨j;
                    hVar.b0(c2.a(51, 11, wVar2));
                    u1Var = new u1(wVar2, null);
                }
            }
            if (z10) {
                hVar.b0(c2.a(26, 11, f2.f٧٠٢٨j));
            }
            str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
            zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
            if (TextUtils.isEmpty(str2)) {
                u1Var = new u1(f2.f٧٠٣٠l, arrayList);
                return u1Var;
            }
        }
        zzb.zzk("BillingClient", "getPurchaseHistory is not supported on current device");
        return new u1(f2.f٧٠٣٥q, null);
    }

    private void q(Context context, i0 i0Var, d0 d0Var, a2 a2Var, String str, d2 d2Var) {
        boolean z10;
        this.f٧٠٥٨e = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(str);
        zzy.zzm(this.f٧٠٥٨e.getPackageName());
        if (d2Var != null) {
            this.f٧٠٥٩f = d2Var;
        } else {
            this.f٧٠٥٩f = new i2(this.f٧٠٥٨e, (zzgu) zzy.zzf());
        }
        if (i0Var == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f٧٠٥٧d = new i3(this.f٧٠٥٨e, i0Var, null, a2Var, null, this.f٧٠٥٩f);
        this.f٧٠٧٩z = d0Var;
        if (a2Var != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.A = z10;
        this.f٧٠٥٨e.getPackageName();
    }

    public final /* synthetic */ void I(b bVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 3, wVar));
        bVar.a(wVar);
    }

    public final /* synthetic */ void J(w wVar) {
        if (this.f٧٠٥٧d.d() != null) {
            this.f٧٠٥٧d.d().onPurchasesUpdated(wVar, null);
        } else {
            zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    public final /* synthetic */ void K(y yVar, x xVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 4, wVar));
        yVar.a(wVar, xVar.a());
    }

    public final /* synthetic */ void L(b0 b0Var) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 24, wVar));
        b0Var.a(wVar, null);
    }

    public final /* synthetic */ void M(z zVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 23, wVar));
        zVar.a(wVar);
    }

    public final /* synthetic */ void N(f0 f0Var) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 7, wVar));
        f0Var.a(wVar, new ArrayList());
    }

    public final /* synthetic */ void P(g0 g0Var) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 11, wVar));
        g0Var.a(wVar, null);
    }

    public final /* synthetic */ void Q(h0 h0Var) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 9, wVar));
        h0Var.a(wVar, zzai.zzk());
    }

    @Override // com.android.billingclient.api.g
    public final void a(final a aVar, final b bVar) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 3, wVar));
            bVar.a(wVar);
            return;
        }
        if (TextUtils.isEmpty(aVar.a())) {
            zzb.zzk("BillingClient", "Please provide a valid purchase token.");
            w wVar2 = f2.f٧٠٢٧i;
            b0(c2.a(26, 3, wVar2));
            bVar.a(wVar2);
            return;
        }
        if (!this.f٧٠٦٧n) {
            w wVar3 = f2.f٧٠٢٠b;
            b0(c2.a(27, 3, wVar3));
            bVar.a(wVar3);
        } else if (a0(new Callable() { // from class: com.android.billingclient.api.m3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                h.this.q0(aVar, bVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.n3
            @Override // java.lang.Runnable
            public final void run() {
                h.this.I(bVar);
            }
        }, V()) == null) {
            w X = X();
            b0(c2.a(25, 3, X));
            bVar.a(X);
        }
    }

    @Override // com.android.billingclient.api.g
    public final void b(final x xVar, final y yVar) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 4, wVar));
            yVar.a(wVar, xVar.a());
        } else if (a0(new Callable() { // from class: com.android.billingclient.api.v0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                h.this.r0(xVar, yVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.w0
            @Override // java.lang.Runnable
            public final void run() {
                h.this.K(yVar, xVar);
            }
        }, V()) == null) {
            w X = X();
            b0(c2.a(25, 4, X));
            yVar.a(X, xVar.a());
        }
    }

    @Override // com.android.billingclient.api.g
    public void c(final b0 b0Var) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 24, wVar));
            b0Var.a(wVar, null);
        } else {
            if (!this.f٧٠٧٨y) {
                zzb.zzk("BillingClient", "Current client doesn't support external offer.");
                w wVar2 = f2.f٧٠٤٣y;
                b0(c2.a(103, 24, wVar2));
                b0Var.a(wVar2, null);
                return;
            }
            if (a0(new Callable() { // from class: com.android.billingclient.api.r0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    h.this.u0(b0Var);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.x0
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.L(b0Var);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 24, X));
                b0Var.a(X, null);
            }
        }
    }

    @Override // com.android.billingclient.api.g
    public void createAlternativeBillingOnlyReportingDetailsAsync(final f fVar) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 15, wVar));
            fVar.a(wVar, null);
        } else {
            if (!this.f٧٠٧٧x) {
                zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
                w wVar2 = f2.E;
                b0(c2.a(66, 15, wVar2));
                fVar.a(wVar2, null);
                return;
            }
            if (a0(new Callable() { // from class: com.android.billingclient.api.p3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    h.this.t0(fVar);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.q0
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.zzU(fVar);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 15, X));
                fVar.a(X, null);
            }
        }
    }

    @Override // com.android.billingclient.api.g
    public final void d() {
        c0(c2.c(12));
        try {
            try {
                if (this.f٧٠٥٧d != null) {
                    this.f٧٠٥٧d.f();
                }
                if (this.f٧٠٦١h != null) {
                    this.f٧٠٦١h.c();
                }
                if (this.f٧٠٦١h != null && this.f٧٠٦٠g != null) {
                    zzb.zzj("BillingClient", "Unbinding from service.");
                    this.f٧٠٥٨e.unbindService(this.f٧٠٦١h);
                    this.f٧٠٦١h = null;
                }
                this.f٧٠٦٠g = null;
                ExecutorService executorService = this.f٧٠٥٣B;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.f٧٠٥٣B = null;
                }
            } catch (Exception e10) {
                zzb.zzl("BillingClient", "There was an exception while ending connection!", e10);
            }
            this.f٧٠٥٤a = 3;
        } catch (Throwable th) {
            this.f٧٠٥٤a = 3;
            throw th;
        }
    }

    @Override // com.android.billingclient.api.g
    public void e(final z zVar) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 23, wVar));
            zVar.a(wVar);
        } else {
            if (!this.f٧٠٧٨y) {
                zzb.zzk("BillingClient", "Current client doesn't support external offer.");
                w wVar2 = f2.f٧٠٤٣y;
                b0(c2.a(103, 23, wVar2));
                zVar.a(wVar2);
                return;
            }
            if (a0(new Callable() { // from class: com.android.billingclient.api.b1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    h.this.w0(zVar);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.c1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.M(zVar);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 23, X));
                zVar.a(X);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.g
    public final w f(String str) {
        char c10;
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        w wVar10;
        w wVar11;
        w wVar12;
        w wVar13;
        w wVar14;
        if (!g()) {
            w wVar15 = f2.f٧٠٣١m;
            if (wVar15.b() != 0) {
                b0(c2.a(2, 5, wVar15));
            } else {
                c0(c2.c(5));
            }
            return wVar15;
        }
        w wVar16 = f2.f٧٠١٩a;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 97314:
                if (str.equals("bbb")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 101286:
                if (str.equals("fff")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 102279:
                if (str.equals("ggg")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 104265:
                if (str.equals("iii")) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case 105258:
                if (str.equals("jjj")) {
                    c10 = '\f';
                    break;
                }
                c10 = 65535;
                break;
            case 106251:
                if (str.equals("kkk")) {
                    c10 = '\r';
                    break;
                }
                c10 = 65535;
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                if (this.f٧٠٦٢i) {
                    wVar = f2.f٧٠٣٠l;
                } else {
                    wVar = f2.f٧٠٣٣o;
                }
                g0(wVar, 9, 2);
                return wVar;
            case 1:
                if (this.f٧٠٦٣j) {
                    wVar2 = f2.f٧٠٣٠l;
                } else {
                    wVar2 = f2.f٧٠٣٤p;
                }
                g0(wVar2, 10, 3);
                return wVar2;
            case 2:
                if (this.f٧٠٦٦m) {
                    wVar3 = f2.f٧٠٣٠l;
                } else {
                    wVar3 = f2.f٧٠٣٦r;
                }
                g0(wVar3, 35, 4);
                return wVar3;
            case 3:
                if (this.f٧٠٦٩p) {
                    wVar4 = f2.f٧٠٣٠l;
                } else {
                    wVar4 = f2.f٧٠٤١w;
                }
                g0(wVar4, 30, 5);
                return wVar4;
            case 4:
                if (this.f٧٠٧١r) {
                    wVar5 = f2.f٧٠٣٠l;
                } else {
                    wVar5 = f2.f٧٠٣٧s;
                }
                g0(wVar5, 31, 6);
                return wVar5;
            case 5:
                if (this.f٧٠٧٠q) {
                    wVar6 = f2.f٧٠٣٠l;
                } else {
                    wVar6 = f2.f٧٠٣٩u;
                }
                g0(wVar6, 21, 7);
                return wVar6;
            case 6:
                if (this.f٧٠٧٢s) {
                    wVar7 = f2.f٧٠٣٠l;
                } else {
                    wVar7 = f2.f٧٠٣٨t;
                }
                g0(wVar7, 19, 8);
                return wVar7;
            case 7:
                if (this.f٧٠٧٢s) {
                    wVar8 = f2.f٧٠٣٠l;
                } else {
                    wVar8 = f2.f٧٠٣٨t;
                }
                g0(wVar8, 61, 9);
                return wVar8;
            case '\b':
                if (this.f٧٠٧٣t) {
                    wVar9 = f2.f٧٠٣٠l;
                } else {
                    wVar9 = f2.f٧٠٤٠v;
                }
                g0(wVar9, 20, 10);
                return wVar9;
            case '\t':
                if (this.f٧٠٧٤u) {
                    wVar10 = f2.f٧٠٣٠l;
                } else {
                    wVar10 = f2.A;
                }
                g0(wVar10, 32, 11);
                return wVar10;
            case '\n':
                if (this.f٧٠٧٤u) {
                    wVar11 = f2.f٧٠٣٠l;
                } else {
                    wVar11 = f2.f٧٠١٨B;
                }
                g0(wVar11, 33, 12);
                return wVar11;
            case 11:
                if (this.f٧٠٧٦w) {
                    wVar12 = f2.f٧٠٣٠l;
                } else {
                    wVar12 = f2.D;
                }
                g0(wVar12, 60, 13);
                return wVar12;
            case '\f':
                if (this.f٧٠٧٧x) {
                    wVar13 = f2.f٧٠٣٠l;
                } else {
                    wVar13 = f2.E;
                }
                g0(wVar13, 66, 14);
                return wVar13;
            case '\r':
                if (this.f٧٠٧٨y) {
                    wVar14 = f2.f٧٠٣٠l;
                } else {
                    wVar14 = f2.f٧٠٤٣y;
                }
                g0(wVar14, 103, 18);
                return wVar14;
            default:
                zzb.zzk("BillingClient", "Unsupported feature: ".concat(str));
                w wVar17 = f2.f٧٠٤٤z;
                g0(wVar17, 34, 1);
                return wVar17;
        }
    }

    @Override // com.android.billingclient.api.g
    public final boolean g() {
        return (this.f٧٠٥٤a != 2 || this.f٧٠٦٠g == null || this.f٧٠٦١h == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0457 A[Catch: Exception -> 0x0467, CancellationException -> 0x0469, TimeoutException -> 0x046b, TRY_ENTER, TryCatch #4 {CancellationException -> 0x0469, TimeoutException -> 0x046b, Exception -> 0x0467, blocks: (B:132:0x0457, B:134:0x046d, B:136:0x0481, B:139:0x049d, B:141:0x04a9), top: B:130:0x0455 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x046d A[Catch: Exception -> 0x0467, CancellationException -> 0x0469, TimeoutException -> 0x046b, TryCatch #4 {CancellationException -> 0x0469, TimeoutException -> 0x046b, Exception -> 0x0467, blocks: (B:132:0x0457, B:134:0x046d, B:136:0x0481, B:139:0x049d, B:141:0x04a9), top: B:130:0x0455 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0418  */
    @Override // com.android.billingclient.api.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final w h(Activity activity, final v vVar) {
        String str;
        String str2;
        Future a02;
        int i10;
        boolean z10;
        String str3;
        v.b bVar;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z11;
        String str8;
        final int i11;
        String str9;
        boolean z12;
        h hVar = this;
        if (hVar.f٧٠٥٧d != null && hVar.f٧٠٥٧d.d() != null) {
            if (!g()) {
                w wVar = f2.f٧٠٣١m;
                hVar.b0(c2.a(2, 2, wVar));
                hVar.W(wVar);
                return wVar;
            }
            ArrayList<SkuDetails> g10 = vVar.g();
            List h10 = vVar.h();
            v.b bVar2 = (v.b) zzan.zza(h10, null);
            final String b10 = bVar2.b().b();
            final String c10 = bVar2.b().c();
            String str10 = "BillingClient";
            if (c10.equals("subs") && !hVar.f٧٠٦٢i) {
                zzb.zzk("BillingClient", "Current client doesn't support subscriptions.");
                w wVar2 = f2.f٧٠٣٣o;
                hVar.b0(c2.a(9, 2, wVar2));
                hVar.W(wVar2);
                return wVar2;
            }
            if (vVar.q() && !hVar.f٧٠٦٥l) {
                zzb.zzk("BillingClient", "Current client doesn't support extra params for buy intent.");
                w wVar3 = f2.f٧٠٢٦h;
                hVar.b0(c2.a(18, 2, wVar3));
                hVar.W(wVar3);
                return wVar3;
            }
            if (g10.size() > 1 && !hVar.f٧٠٧٢s) {
                zzb.zzk("BillingClient", "Current client doesn't support multi-item purchases.");
                w wVar4 = f2.f٧٠٣٨t;
                hVar.b0(c2.a(19, 2, wVar4));
                hVar.W(wVar4);
                return wVar4;
            }
            if (!h10.isEmpty() && !hVar.f٧٠٧٣t) {
                zzb.zzk("BillingClient", "Current client doesn't support purchases with ProductDetails.");
                w wVar5 = f2.f٧٠٤٠v;
                hVar.b0(c2.a(20, 2, wVar5));
                hVar.W(wVar5);
                return wVar5;
            }
            if (!hVar.f٧٠٦٥l) {
                str = "BUY_INTENT";
                str2 = "BillingClient";
                a02 = a0(new Callable() { // from class: com.android.billingclient.api.l3
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return h.this.j0(b10, c10);
                    }
                }, 5000L, null, hVar.f٧٠٥٦c);
                i10 = 80;
            } else {
                boolean z13 = hVar.f٧٠٦٧n;
                boolean z14 = hVar.f٧٠٧٥v;
                boolean a10 = hVar.f٧٠٧٩z.a();
                boolean b11 = hVar.f٧٠٧٩z.b();
                boolean z15 = hVar.A;
                String str11 = hVar.f٧٠٥٥b;
                str = "BUY_INTENT";
                final Bundle bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", str11);
                if (vVar.b() != 0) {
                    bundle.putInt("prorationMode", vVar.b());
                }
                if (!TextUtils.isEmpty(vVar.c())) {
                    bundle.putString("accountId", vVar.c());
                }
                if (!TextUtils.isEmpty(vVar.d())) {
                    bundle.putString("obfuscatedProfileId", vVar.d());
                }
                if (vVar.p()) {
                    bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
                }
                if (!TextUtils.isEmpty(null)) {
                    bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
                }
                if (!TextUtils.isEmpty(vVar.e())) {
                    bundle.putString("oldSkuPurchaseToken", vVar.e());
                }
                String str12 = null;
                if (!TextUtils.isEmpty(null)) {
                    bundle.putString("oldSkuPurchaseId", null);
                }
                if (!TextUtils.isEmpty(vVar.f())) {
                    bundle.putString("originalExternalTransactionId", vVar.f());
                    str12 = null;
                }
                if (!TextUtils.isEmpty(str12)) {
                    bundle.putString("paymentsPurchaseParams", str12);
                }
                if (z13 && a10) {
                    z10 = true;
                    bundle.putBoolean("enablePendingPurchases", true);
                } else {
                    z10 = true;
                }
                if (z14 && b11) {
                    bundle.putBoolean("enablePendingPurchaseForSubscriptions", z10);
                }
                if (z15) {
                    bundle.putBoolean("enableAlternativeBilling", z10);
                }
                if (g10.isEmpty()) {
                    str3 = "proxyPackageVersion";
                    bVar = bVar2;
                    str4 = b10;
                    str5 = c10;
                    str6 = "BillingClient";
                    ArrayList<String> arrayList = new ArrayList<>(h10.size() - 1);
                    ArrayList<String> arrayList2 = new ArrayList<>(h10.size() - 1);
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    ArrayList<String> arrayList5 = new ArrayList<>();
                    for (int i12 = 0; i12 < h10.size(); i12++) {
                        v.b bVar3 = (v.b) h10.get(i12);
                        e0 b12 = bVar3.b();
                        if (!b12.f().isEmpty()) {
                            arrayList3.add(b12.f());
                        }
                        arrayList4.add(bVar3.c());
                        if (!TextUtils.isEmpty(b12.g())) {
                            arrayList5.add(b12.g());
                        }
                        if (i12 > 0) {
                            arrayList.add(((v.b) h10.get(i12)).b().b());
                            arrayList2.add(((v.b) h10.get(i12)).b().c());
                        }
                    }
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                    if (!arrayList3.isEmpty()) {
                        bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                    }
                    if (!arrayList5.isEmpty()) {
                        bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if (!arrayList.isEmpty()) {
                        bundle.putStringArrayList("additionalSkus", arrayList);
                        bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                    }
                } else {
                    ArrayList<String> arrayList6 = new ArrayList<>();
                    ArrayList<String> arrayList7 = new ArrayList<>();
                    str5 = c10;
                    ArrayList<String> arrayList8 = new ArrayList<>();
                    str4 = b10;
                    ArrayList<Integer> arrayList9 = new ArrayList<>();
                    str3 = "proxyPackageVersion";
                    ArrayList<String> arrayList10 = new ArrayList<>();
                    boolean z16 = false;
                    boolean z17 = false;
                    boolean z18 = false;
                    boolean z19 = false;
                    for (SkuDetails skuDetails : g10) {
                        if (!skuDetails.h().isEmpty()) {
                            str9 = str10;
                            arrayList6.add(skuDetails.h());
                        } else {
                            str9 = str10;
                        }
                        String e10 = skuDetails.e();
                        v.b bVar4 = bVar2;
                        String d10 = skuDetails.d();
                        int c11 = skuDetails.c();
                        String g11 = skuDetails.g();
                        arrayList7.add(e10);
                        z16 |= !TextUtils.isEmpty(e10);
                        arrayList8.add(d10);
                        z17 |= !TextUtils.isEmpty(d10);
                        arrayList9.add(Integer.valueOf(c11));
                        if (c11 != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        z18 |= z12;
                        z19 |= !TextUtils.isEmpty(g11);
                        arrayList10.add(g11);
                        str10 = str9;
                        bVar2 = bVar4;
                    }
                    bVar = bVar2;
                    str6 = str10;
                    if (!arrayList6.isEmpty()) {
                        bundle.putStringArrayList("skuDetailsTokens", arrayList6);
                    }
                    if (z16) {
                        bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                    }
                    if (z17) {
                        bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList8);
                    }
                    if (z18) {
                        bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList9);
                    }
                    if (z19) {
                        bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList10);
                    }
                    if (g10.size() > 1) {
                        ArrayList<String> arrayList11 = new ArrayList<>(g10.size() - 1);
                        ArrayList<String> arrayList12 = new ArrayList<>(g10.size() - 1);
                        for (int i13 = 1; i13 < g10.size(); i13++) {
                            arrayList11.add(((SkuDetails) g10.get(i13)).a());
                            arrayList12.add(((SkuDetails) g10.get(i13)).b());
                        }
                        bundle.putStringArrayList("additionalSkus", arrayList11);
                        bundle.putStringArrayList("additionalSkuTypes", arrayList12);
                    }
                }
                hVar = this;
                if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !hVar.f٧٠٧٠q) {
                    w wVar6 = f2.f٧٠٣٩u;
                    hVar.b0(c2.a(21, 2, wVar6));
                    hVar.W(wVar6);
                    return wVar6;
                }
                if (bVar != null && !TextUtils.isEmpty(bVar.b().e())) {
                    bundle.putString("skuPackageName", bVar.b().e());
                    str7 = null;
                    z11 = true;
                } else {
                    str7 = null;
                    z11 = false;
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("accountName", str7);
                }
                Intent intent = activity.getIntent();
                if (intent == null) {
                    str2 = str6;
                    zzb.zzk(str2, "Activity's intent is null.");
                } else {
                    str2 = str6;
                    if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                        bundle.putString("proxyPackage", stringExtra);
                        try {
                            str8 = str3;
                            try {
                                bundle.putString(str8, hVar.f٧٠٥٨e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                            } catch (PackageManager.NameNotFoundException unused) {
                                bundle.putString(str8, "package not found");
                                if (!hVar.f٧٠٧٣t) {
                                }
                                if (!hVar.f٧٠٧١r) {
                                }
                                if (!hVar.f٧٠٦٧n) {
                                }
                                final String str13 = str4;
                                final String str14 = str5;
                                a02 = a0(new Callable() { // from class: com.android.billingclient.api.d1
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        return h.this.i0(i11, str13, str14, vVar, bundle);
                                    }
                                }, 5000L, null, hVar.f٧٠٥٦c);
                                i10 = 78;
                                if (a02 != null) {
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str8 = str3;
                        }
                    }
                }
                if (!hVar.f٧٠٧٣t && !h10.isEmpty()) {
                    i11 = 17;
                } else if (!hVar.f٧٠٧١r && z11) {
                    i11 = 15;
                } else if (!hVar.f٧٠٦٧n) {
                    i11 = 9;
                } else {
                    i11 = 6;
                }
                final String str132 = str4;
                final String str142 = str5;
                a02 = a0(new Callable() { // from class: com.android.billingclient.api.d1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return h.this.i0(i11, str132, str142, vVar, bundle);
                    }
                }, 5000L, null, hVar.f٧٠٥٦c);
                i10 = 78;
            }
            try {
                if (a02 != null) {
                    w wVar7 = f2.f٧٠٣١m;
                    hVar.b0(c2.a(25, 2, wVar7));
                    hVar.W(wVar7);
                    return wVar7;
                }
                Bundle bundle2 = (Bundle) a02.get(5000L, TimeUnit.MILLISECONDS);
                int zzb = zzb.zzb(bundle2, str2);
                String zzg = zzb.zzg(bundle2, str2);
                if (zzb != 0) {
                    zzb.zzk(str2, "Unable to buy item, Error response code: " + zzb);
                    w a11 = f2.a(zzb, zzg);
                    if (bundle2 != null) {
                        i10 = 23;
                    }
                    hVar.b0(c2.a(i10, 2, a11));
                    hVar.W(a11);
                    return a11;
                }
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str15 = str;
                intent2.putExtra(str15, (PendingIntent) bundle2.getParcelable(str15));
                activity.startActivity(intent2);
                return f2.f٧٠٣٠l;
            } catch (CancellationException e11) {
                e = e11;
                zzb.zzl(str2, "Time out while launching billing flow. Try to reconnect", e);
                w wVar8 = f2.f٧٠٣٢n;
                hVar.b0(c2.a(4, 2, wVar8));
                hVar.W(wVar8);
                return wVar8;
            } catch (TimeoutException e12) {
                e = e12;
                zzb.zzl(str2, "Time out while launching billing flow. Try to reconnect", e);
                w wVar82 = f2.f٧٠٣٢n;
                hVar.b0(c2.a(4, 2, wVar82));
                hVar.W(wVar82);
                return wVar82;
            } catch (Exception e13) {
                zzb.zzl(str2, "Exception while launching billing flow. Try to reconnect", e13);
                w wVar9 = f2.f٧٠٣١m;
                hVar.b0(c2.a(5, 2, wVar9));
                hVar.W(wVar9);
                return wVar9;
            }
        }
        w wVar10 = f2.F;
        hVar.b0(c2.a(12, 2, wVar10));
        return wVar10;
    }

    public final /* synthetic */ Bundle i0(int i10, String str, String str2, v vVar, Bundle bundle) {
        return this.f٧٠٦٠g.zzg(i10, this.f٧٠٥٨e.getPackageName(), str, str2, null, bundle);
    }

    @Override // com.android.billingclient.api.g
    public void isAlternativeBillingOnlyAvailableAsync(final c cVar) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 14, wVar));
            cVar.a(wVar);
        } else {
            if (!this.f٧٠٧٧x) {
                zzb.zzk("BillingClient", "Current client doesn't support alternative billing only.");
                w wVar2 = f2.E;
                b0(c2.a(66, 14, wVar2));
                cVar.a(wVar2);
                return;
            }
            if (a0(new Callable() { // from class: com.android.billingclient.api.t0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    h.this.v0(cVar);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.u0
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.zzX(cVar);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 14, X));
                cVar.a(X);
            }
        }
    }

    @Override // com.android.billingclient.api.g
    public final void j(final j0 j0Var, final f0 f0Var) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 7, wVar));
            f0Var.a(wVar, new ArrayList());
        } else {
            if (!this.f٧٠٧٣t) {
                zzb.zzk("BillingClient", "Querying product details is not supported.");
                w wVar2 = f2.f٧٠٤٠v;
                b0(c2.a(20, 7, wVar2));
                f0Var.a(wVar2, new ArrayList());
                return;
            }
            if (a0(new Callable() { // from class: com.android.billingclient.api.z0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    h.this.s0(j0Var, f0Var);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.a1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.N(f0Var);
                }
            }, V()) == null) {
                w X = X();
                b0(c2.a(25, 7, X));
                f0Var.a(X, new ArrayList());
            }
        }
    }

    public final /* synthetic */ Bundle j0(String str, String str2) {
        return this.f٧٠٦٠g.zzf(3, this.f٧٠٥٨e.getPackageName(), str, str2, null);
    }

    @Override // com.android.billingclient.api.g
    public final void k(k0 k0Var, g0 g0Var) {
        throw null;
    }

    @Override // com.android.billingclient.api.g
    public final void l(String str, g0 g0Var) {
        d0(str, g0Var);
    }

    @Override // com.android.billingclient.api.g
    public final void m(l0 l0Var, h0 h0Var) {
        e0(l0Var.b(), h0Var);
    }

    @Override // com.android.billingclient.api.g
    public final void n(String str, h0 h0Var) {
        e0(str, h0Var);
    }

    @Override // com.android.billingclient.api.g
    public final void o(m0 m0Var, n0 n0Var) {
        if (!g()) {
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(2, 8, wVar));
            n0Var.a(wVar, null);
            return;
        }
        throw null;
    }

    @Override // com.android.billingclient.api.g
    public final void p(u uVar) {
        if (g()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            c0(c2.c(6));
            uVar.onBillingSetupFinished(f2.f٧٠٣٠l);
            return;
        }
        int i10 = 1;
        if (this.f٧٠٥٤a == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            w wVar = f2.f٧٠٢٢d;
            b0(c2.a(37, 6, wVar));
            uVar.onBillingSetupFinished(wVar);
            return;
        }
        if (this.f٧٠٥٤a == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            w wVar2 = f2.f٧٠٣١m;
            b0(c2.a(38, 6, wVar2));
            uVar.onBillingSetupFinished(wVar2);
            return;
        }
        this.f٧٠٥٤a = 1;
        zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.f٧٠٦١h = new l1(this, uVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.f٧٠٥٨e.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if ("com.android.vending".equals(str) && str2 != null) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f٧٠٥٥b);
                    if (this.f٧٠٥٨e.bindService(intent2, this.f٧٠٦١h, 1)) {
                        zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i10 = 39;
                    }
                } else {
                    zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i10 = 40;
                }
            }
        } else {
            i10 = 41;
        }
        this.f٧٠٥٤a = 0;
        zzb.zzj("BillingClient", "Billing service unavailable on device.");
        w wVar3 = f2.f٧٠٢١c;
        b0(c2.a(i10, 6, wVar3));
        uVar.onBillingSetupFinished(wVar3);
    }

    public final /* synthetic */ Object q0(a aVar, b bVar) {
        try {
            zzs zzsVar = this.f٧٠٦٠g;
            String packageName = this.f٧٠٥٨e.getPackageName();
            String a10 = aVar.a();
            String str = this.f٧٠٥٥b;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zzsVar.zzd(9, packageName, a10, bundle);
            bVar.a(f2.a(zzb.zzb(zzd, "BillingClient"), zzb.zzg(zzd, "BillingClient")));
            return null;
        } catch (Exception e10) {
            zzb.zzl("BillingClient", "Error acknowledge purchase!", e10);
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(28, 3, wVar));
            bVar.a(wVar);
            return null;
        }
    }

    public final /* synthetic */ Object r0(x xVar, y yVar) {
        int zza;
        String str;
        String a10 = xVar.a();
        try {
            zzb.zzj("BillingClient", "Consuming purchase with token: " + a10);
            if (this.f٧٠٦٧n) {
                zzs zzsVar = this.f٧٠٦٠g;
                String packageName = this.f٧٠٥٨e.getPackageName();
                boolean z10 = this.f٧٠٦٧n;
                String str2 = this.f٧٠٥٥b;
                Bundle bundle = new Bundle();
                if (z10) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze = zzsVar.zze(9, packageName, a10, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = zzb.zzg(zze, "BillingClient");
            } else {
                zza = this.f٧٠٦٠g.zza(3, this.f٧٠٥٨e.getPackageName(), a10);
                str = "";
            }
            w a11 = f2.a(zza, str);
            if (zza == 0) {
                zzb.zzj("BillingClient", "Successfully consumed purchase.");
                yVar.a(a11, a10);
                return null;
            }
            zzb.zzk("BillingClient", "Error consuming purchase with token. Response code: " + zza);
            b0(c2.a(23, 4, a11));
            yVar.a(a11, a10);
            return null;
        } catch (Exception e10) {
            zzb.zzl("BillingClient", "Error consuming purchase!", e10);
            w wVar = f2.f٧٠٣١m;
            b0(c2.a(29, 4, wVar));
            yVar.a(wVar, a10);
            return null;
        }
    }

    public final /* synthetic */ Object s0(j0 j0Var, f0 f0Var) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        String c10 = j0Var.c();
        zzai b10 = j0Var.b();
        int size = b10.size();
        int i14 = 0;
        while (true) {
            if (i14 < size) {
                int i15 = i14 + 20;
                if (i15 > size) {
                    i11 = size;
                } else {
                    i11 = i15;
                }
                ArrayList arrayList2 = new ArrayList(b10.subList(i14, i11));
                ArrayList<String> arrayList3 = new ArrayList<>();
                int size2 = arrayList2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    arrayList3.add(((j0.b) arrayList2.get(i16)).b());
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
                bundle.putString("playBillingLibraryVersion", this.f٧٠٥٥b);
                try {
                    zzs zzsVar = this.f٧٠٦٠g;
                    if (true != this.f٧٠٧٦w) {
                        i13 = 17;
                    } else {
                        i13 = 20;
                    }
                    String packageName = this.f٧٠٥٨e.getPackageName();
                    boolean f02 = f0();
                    String str2 = this.f٧٠٥٥b;
                    Y(j0Var);
                    Y(j0Var);
                    Y(j0Var);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("playBillingLibraryVersion", str2);
                    bundle2.putBoolean("enablePendingPurchases", true);
                    bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                    if (f02) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    ArrayList<String> arrayList5 = new ArrayList<>();
                    int size3 = arrayList2.size();
                    zzai zzaiVar = b10;
                    int i17 = 0;
                    boolean z10 = false;
                    boolean z11 = false;
                    while (i17 < size3) {
                        j0.b bVar = (j0.b) arrayList2.get(i17);
                        ArrayList arrayList6 = arrayList2;
                        arrayList4.add(null);
                        z10 |= !TextUtils.isEmpty(null);
                        String c11 = bVar.c();
                        int i18 = size3;
                        if (c11.equals("first_party")) {
                            zzaa.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                            arrayList5.add(null);
                            z11 = true;
                        }
                        i17++;
                        size3 = i18;
                        arrayList2 = arrayList6;
                    }
                    if (z10) {
                        bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                    }
                    if (!arrayList5.isEmpty()) {
                        bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if (z11 && !TextUtils.isEmpty(null)) {
                        bundle2.putString("accountName", null);
                    }
                    i12 = 7;
                    try {
                        Bundle zzl = zzsVar.zzl(i13, packageName, c10, bundle, bundle2);
                        str = "Item is unavailable for purchase.";
                        if (zzl == null) {
                            zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                            b0(c2.a(44, 7, f2.C));
                            break;
                        }
                        if (!zzl.containsKey("DETAILS_LIST")) {
                            i10 = zzb.zzb(zzl, "BillingClient");
                            str = zzb.zzg(zzl, "BillingClient");
                            if (i10 != 0) {
                                zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i10);
                                b0(c2.a(23, 7, f2.a(i10, str)));
                            } else {
                                zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                                b0(c2.a(45, 7, f2.a(6, str)));
                            }
                        } else {
                            ArrayList<String> stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList == null) {
                                zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                                b0(c2.a(46, 7, f2.C));
                                break;
                            }
                            for (int i19 = 0; i19 < stringArrayList.size(); i19++) {
                                try {
                                    e0 e0Var = new e0(stringArrayList.get(i19));
                                    zzb.zzj("BillingClient", "Got product details: ".concat(e0Var.toString()));
                                    arrayList.add(e0Var);
                                } catch (JSONException e10) {
                                    zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e10);
                                    str = "Error trying to decode SkuDetails.";
                                    b0(c2.a(47, 7, f2.a(6, "Error trying to decode SkuDetails.")));
                                    i10 = 6;
                                    f0Var.a(f2.a(i10, str), arrayList);
                                    return null;
                                }
                            }
                            i14 = i15;
                            b10 = zzaiVar;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                        b0(c2.a(43, i12, f2.f٧٠٢٨j));
                        str = "An internal error occurred.";
                        i10 = 6;
                        f0Var.a(f2.a(i10, str), arrayList);
                        return null;
                    }
                } catch (Exception e12) {
                    e = e12;
                    i12 = 7;
                }
            } else {
                str = "";
                i10 = 0;
                break;
            }
        }
        i10 = 4;
        f0Var.a(f2.a(i10, str), arrayList);
        return null;
    }

    public final /* synthetic */ Void t0(f fVar) {
        try {
            this.f٧٠٦٠g.zzm(21, this.f٧٠٥٨e.getPackageName(), zzb.zzd(this.f٧٠٥٥b), new n1(fVar, this.f٧٠٥٩f, this.f٧٠٦٤k, null));
        } catch (Exception unused) {
            w wVar = f2.f٧٠٢٨j;
            b0(c2.a(70, 15, wVar));
            fVar.a(wVar, null);
        }
        return null;
    }

    public final /* synthetic */ Void u0(b0 b0Var) {
        try {
            this.f٧٠٦٠g.zzn(22, this.f٧٠٥٨e.getPackageName(), zzb.zzd(this.f٧٠٥٥b), new p1(b0Var, this.f٧٠٥٩f, this.f٧٠٦٤k, null));
        } catch (Exception e10) {
            w wVar = f2.f٧٠٢٨j;
            b0(c2.b(94, 24, wVar, String.format("%s: %s", e10.getClass().getName(), zzab.zzb(e10.getMessage()))));
            b0Var.a(wVar, null);
        }
        return null;
    }

    public final /* synthetic */ Void v0(c cVar) {
        try {
            this.f٧٠٦٠g.zzr(21, this.f٧٠٥٨e.getPackageName(), zzb.zzd(this.f٧٠٥٥b), new r1(cVar, this.f٧٠٥٩f, this.f٧٠٦٤k, null));
        } catch (Exception unused) {
            w wVar = f2.f٧٠٢٨j;
            b0(c2.a(69, 14, wVar));
            cVar.a(wVar);
        }
        return null;
    }

    public final /* synthetic */ Void w0(z zVar) {
        try {
            this.f٧٠٦٠g.zzs(22, this.f٧٠٥٨e.getPackageName(), zzb.zzd(this.f٧٠٥٥b), new t1(zVar, this.f٧٠٥٩f, this.f٧٠٦٤k, null));
        } catch (Exception e10) {
            w wVar = f2.f٧٠٢٨j;
            b0(c2.b(91, 23, wVar, String.format("%s: %s", e10.getClass().getName(), zzab.zzb(e10.getMessage()))));
            zVar.a(wVar);
        }
        return null;
    }

    public final /* synthetic */ void zzU(f fVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 15, wVar));
        fVar.a(wVar, null);
    }

    public final /* synthetic */ void zzX(c cVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 14, wVar));
        cVar.a(wVar);
    }

    final /* synthetic */ void zzad(d dVar) {
        w wVar = f2.f٧٠٣٢n;
        b0(c2.a(24, 16, wVar));
        dVar.a(wVar);
    }

    public h(String str, d0 d0Var, Context context, l2 l2Var, d2 d2Var, ExecutorService executorService) {
        this.f٧٠٥٤a = 0;
        this.f٧٠٥٦c = new Handler(Looper.getMainLooper());
        this.f٧٠٦٤k = 0;
        this.f٧٠٥٥b = Z();
        this.f٧٠٥٨e = context.getApplicationContext();
        zzgt zzy = zzgu.zzy();
        zzy.zzn(Z());
        zzy.zzm(this.f٧٠٥٨e.getPackageName());
        this.f٧٠٥٩f = new i2(this.f٧٠٥٨e, (zzgu) zzy.zzf());
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f٧٠٥٧d = new i3(this.f٧٠٥٨e, null, null, null, null, this.f٧٠٥٩f);
        this.f٧٠٧٩z = d0Var;
        this.f٧٠٥٨e.getPackageName();
    }

    public h(String str, d0 d0Var, Context context, i0 i0Var, a2 a2Var, d2 d2Var, ExecutorService executorService) {
        String Z = Z();
        this.f٧٠٥٤a = 0;
        this.f٧٠٥٦c = new Handler(Looper.getMainLooper());
        this.f٧٠٦٤k = 0;
        this.f٧٠٥٥b = Z;
        q(context, i0Var, d0Var, null, Z, null);
    }
}
