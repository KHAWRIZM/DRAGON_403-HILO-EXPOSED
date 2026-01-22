package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzcd;
import com.google.android.gms.internal.play_billing.zzga;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h3 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٧٠٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f٧٠٨٢b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ i3 f٧٠٨٣c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3(i3 i3Var, boolean z10) {
        this.f٧٠٨٣c = i3Var;
        this.f٧٠٨٢b = z10;
    }

    private final void d(Bundle bundle, w wVar, int i10) {
        d2 d2Var;
        d2 d2Var2;
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                d2Var = this.f٧٠٨٣c.f٧٠٨٩c;
                d2Var.e(zzga.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzcd.zza()));
                return;
            } catch (Throwable unused) {
                zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
                return;
            }
        }
        d2Var2 = this.f٧٠٨٣c.f٧٠٨٩c;
        d2Var2.e(c2.a(23, i10, wVar));
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        int i10;
        try {
            if (this.f٧٠٨١a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                if (true != this.f٧٠٨٢b) {
                    i10 = 4;
                } else {
                    i10 = 2;
                }
                context.registerReceiver(this, intentFilter, i10);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f٧٠٨١a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, IntentFilter intentFilter, String str) {
        int i10;
        try {
            if (this.f٧٠٨١a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                if (true != this.f٧٠٨٢b) {
                    i10 = 4;
                } else {
                    i10 = 2;
                }
                context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, i10);
            } else {
                context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
            }
            this.f٧٠٨١a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Context context) {
        if (this.f٧٠٨١a) {
            context.unregisterReceiver(this);
            this.f٧٠٨١a = false;
        } else {
            zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        i0 i0Var;
        d2 d2Var;
        d2 d2Var2;
        i0 i0Var2;
        i0 i0Var3;
        d2 d2Var3;
        i0 i0Var4;
        i0 i0Var5;
        Bundle extras = intent.getExtras();
        int i10 = 1;
        if (extras == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            d2Var3 = this.f٧٠٨٣c.f٧٠٨٩c;
            w wVar = f2.f٧٠٢٨j;
            d2Var3.e(c2.a(11, 1, wVar));
            i3 i3Var = this.f٧٠٨٣c;
            i0Var4 = i3Var.f٧٠٨٨b;
            if (i0Var4 != null) {
                i0Var5 = i3Var.f٧٠٨٨b;
                i0Var5.onPurchasesUpdated(wVar, null);
                return;
            }
            return;
        }
        w zze = zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        if (true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW")) {
            i10 = 2;
        }
        if (!action.equals("com.android.vending.billing.PURCHASES_UPDATED") && !action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                if (zze.b() != 0) {
                    d(extras, zze, i10);
                    i0Var3 = this.f٧٠٨٣c.f٧٠٨٨b;
                    i0Var3.onPurchasesUpdated(zze, zzai.zzk());
                    return;
                }
                i3 i3Var2 = this.f٧٠٨٣c;
                i3.a(i3Var2);
                i3.e(i3Var2);
                zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                d2Var2 = this.f٧٠٨٣c.f٧٠٨٩c;
                w wVar2 = f2.f٧٠٢٨j;
                d2Var2.e(c2.a(77, i10, wVar2));
                i0Var2 = this.f٧٠٨٣c.f٧٠٨٨b;
                i0Var2.onPurchasesUpdated(wVar2, zzai.zzk());
                return;
            }
            return;
        }
        List zzi = zzb.zzi(extras);
        if (zze.b() == 0) {
            d2Var = this.f٧٠٨٣c.f٧٠٨٩c;
            d2Var.b(c2.c(i10));
        } else {
            d(extras, zze, i10);
        }
        i0Var = this.f٧٠٨٣c.f٧٠٨٨b;
        i0Var.onPurchasesUpdated(zze, zzi);
    }
}
