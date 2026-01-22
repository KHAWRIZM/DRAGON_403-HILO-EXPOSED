package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhl;
import com.google.android.gms.internal.play_billing.zzr;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l1 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Object f٧١٠٩a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f٧١١٠b = false;

    /* renamed from: c, reason: collision with root package name */
    private u f٧١١١c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f٧١١٢d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l1(h hVar, u uVar, k1 k1Var) {
        this.f٧١١٢d = hVar;
        this.f٧١١١c = uVar;
    }

    private final void d(w wVar) {
        synchronized (this.f٧١٠٩a) {
            try {
                u uVar = this.f٧١١١c;
                if (uVar != null) {
                    uVar.onBillingSetupFinished(wVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object a() {
        Bundle bundle;
        int i10;
        String str;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        synchronized (this.f٧١٠٩a) {
            try {
                if (!this.f٧١١٠b) {
                    if (!TextUtils.isEmpty(null)) {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                    } else {
                        bundle = null;
                    }
                    int i12 = 3;
                    try {
                        String packageName = h.h0(this.f٧١١٢d).getPackageName();
                        int i13 = 22;
                        i11 = 3;
                        while (true) {
                            if (i13 >= 3) {
                                if (bundle == null) {
                                    try {
                                        i11 = h.p0(this.f٧١١٢d).zzy(i13, packageName, "subs");
                                    } catch (Exception e10) {
                                        e = e10;
                                        i12 = i11;
                                        zzb.zzl("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                        if (e instanceof DeadObjectException) {
                                            i10 = 101;
                                        } else if (e instanceof RemoteException) {
                                            i10 = 100;
                                        } else if (e instanceof SecurityException) {
                                            i10 = 102;
                                        } else {
                                            i10 = 42;
                                        }
                                        if (i10 == 42) {
                                            str = e.getClass().getSimpleName() + ": " + zzab.zzb(e.getMessage());
                                            if (str.length() > 70) {
                                                str = str.substring(0, 70);
                                            }
                                        } else {
                                            str = null;
                                        }
                                        h.y0(this.f٧١١٢d, 0);
                                        h.E(this.f٧١١٢d, null);
                                        i11 = i12;
                                        if (i11 != 0) {
                                        }
                                        return null;
                                    }
                                } else {
                                    i11 = h.p0(this.f٧١١٢d).zzc(i13, packageName, "subs", bundle);
                                }
                                if (i11 == 0) {
                                    zzb.zzj("BillingClient", "highestLevelSupportedForSubs: " + i13);
                                    break;
                                }
                                i13--;
                            } else {
                                i13 = 0;
                                break;
                            }
                        }
                        h hVar = this.f٧١١٢d;
                        boolean z25 = true;
                        if (i13 >= 5) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        h.F(hVar, z10);
                        h hVar2 = this.f٧١١٢d;
                        if (i13 >= 3) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        h.G(hVar2, z11);
                        if (i13 < 3) {
                            zzb.zzj("BillingClient", "In-app billing API does not support subscription on this device.");
                            i10 = 9;
                        } else {
                            i10 = 1;
                        }
                        int i14 = 22;
                        while (true) {
                            if (i14 < 3) {
                                break;
                            }
                            if (bundle == null) {
                                i11 = h.p0(this.f٧١١٢d).zzy(i14, packageName, "inapp");
                            } else {
                                i11 = h.p0(this.f٧١١٢d).zzc(i14, packageName, "inapp", bundle);
                            }
                            if (i11 == 0) {
                                h.z0(this.f٧١١٢d, i14);
                                zzb.zzj("BillingClient", "mHighestLevelSupportedForInApp: " + h.O(this.f٧١١٢d));
                                break;
                            }
                            i14--;
                        }
                        h hVar3 = this.f٧١١٢d;
                        if (h.O(hVar3) >= 22) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        h.A(hVar3, z12);
                        h hVar4 = this.f٧١١٢d;
                        if (h.O(hVar4) >= 21) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        h.z(hVar4, z13);
                        h hVar5 = this.f٧١١٢d;
                        if (h.O(hVar5) >= 20) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        h.y(hVar5, z14);
                        h hVar6 = this.f٧١١٢d;
                        if (h.O(hVar6) >= 19) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        h.x(hVar6, z15);
                        h hVar7 = this.f٧١١٢d;
                        if (h.O(hVar7) >= 18) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        h.w(hVar7, z16);
                        h hVar8 = this.f٧١١٢d;
                        if (h.O(hVar8) >= 17) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        h.v(hVar8, z17);
                        h hVar9 = this.f٧١١٢d;
                        if (h.O(hVar9) >= 16) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        h.u(hVar9, z18);
                        h hVar10 = this.f٧١١٢d;
                        if (h.O(hVar10) >= 15) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        h.t(hVar10, z19);
                        h hVar11 = this.f٧١١٢d;
                        if (h.O(hVar11) >= 14) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        h.s(hVar11, z20);
                        h hVar12 = this.f٧١١٢d;
                        if (h.O(hVar12) >= 12) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        h.r(hVar12, z21);
                        h hVar13 = this.f٧١١٢d;
                        if (h.O(hVar13) >= 10) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        h.A0(hVar13, z22);
                        h hVar14 = this.f٧١١٢d;
                        if (h.O(hVar14) >= 9) {
                            z23 = true;
                        } else {
                            z23 = false;
                        }
                        h.D(hVar14, z23);
                        h hVar15 = this.f٧١١٢d;
                        if (h.O(hVar15) >= 8) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        h.C(hVar15, z24);
                        h hVar16 = this.f٧١١٢d;
                        if (h.O(hVar16) < 6) {
                            z25 = false;
                        }
                        h.B(hVar16, z25);
                        if (h.O(this.f٧١١٢d) < 3) {
                            zzb.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            i10 = 36;
                        }
                        if (i11 == 0) {
                            h.y0(this.f٧١١٢d, 2);
                            if (h.l0(this.f٧١١٢d) != null) {
                                h.l0(this.f٧١١٢d).g(h.R(this.f٧١١٢d));
                            }
                        } else {
                            h.y0(this.f٧١١٢d, 0);
                            h.E(this.f٧١١٢d, null);
                        }
                        str = null;
                    } catch (Exception e11) {
                        e = e11;
                    }
                    if (i11 != 0) {
                        h.U(this.f٧١١٢d, 6);
                        d(f2.f٧٠٣٠l);
                    } else {
                        h hVar17 = this.f٧١١٢d;
                        w wVar = f2.f٧٠١٩a;
                        h.H(hVar17, c2.b(i10, 6, wVar, str));
                        d(wVar);
                    }
                }
            } finally {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        h.y0(this.f٧١١٢d, 0);
        h.E(this.f٧١١٢d, null);
        w wVar = f2.f٧٠٣٢n;
        h.T(this.f٧١١٢d, 24, 6, wVar);
        d(wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        synchronized (this.f٧١٠٩a) {
            this.f٧١١١c = null;
            this.f٧١١٠b = true;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb.zzj("BillingClient", "Billing service connected.");
        h.E(this.f٧١١٢d, zzr.zzu(iBinder));
        Callable callable = new Callable() { // from class: com.android.billingclient.api.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                l1.this.a();
                return null;
            }
        };
        Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.j1
            @Override // java.lang.Runnable
            public final void run() {
                l1.this.b();
            }
        };
        h hVar = this.f٧١١٢d;
        if (h.x0(hVar, callable, 30000L, runnable, h.k0(hVar)) == null) {
            h hVar2 = this.f٧١١٢d;
            w o02 = h.o0(hVar2);
            h.T(hVar2, 25, 6, o02);
            d(o02);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzb.zzk("BillingClient", "Billing service disconnected.");
        h.n0(this.f٧١١٢d).c(zzhl.zzz());
        h.E(this.f٧١١٢d, null);
        h.y0(this.f٧١١٢d, 0);
        synchronized (this.f٧١٠٩a) {
            try {
                u uVar = this.f٧١١١c;
                if (uVar != null) {
                    uVar.onBillingServiceDisconnected();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
