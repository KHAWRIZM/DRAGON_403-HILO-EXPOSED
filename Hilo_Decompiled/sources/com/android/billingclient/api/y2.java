package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.w;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class y2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static x2 a(Bundle bundle, String str, String str2) {
        w wVar = f2.f٧٠٢٨j;
        if (bundle == null) {
            zzb.zzk("BillingClient", String.format("%s got null owned items list", str2));
            return new x2(wVar, 54);
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        String zzg = zzb.zzg(bundle, "BillingClient");
        w.a c10 = w.c();
        c10.c(zzb);
        c10.b(zzg);
        w a10 = c10.a();
        if (zzb != 0) {
            zzb.zzk("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(zzb)));
            return new x2(a10, 23);
        }
        if (bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
                return new x2(wVar, 56);
            }
            if (stringArrayList2 == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
                return new x2(wVar, 57);
            }
            if (stringArrayList3 == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
                return new x2(wVar, 58);
            }
            return new x2(f2.f٧٠٣٠l, 1);
        }
        zzb.zzk("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
        return new x2(wVar, 55);
    }
}
