package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@UsedByReflection("PlatformActivityProxy")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {

    /* renamed from: a, reason: collision with root package name */
    private androidx.activity.result.d f٦٩٣٧a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.activity.result.d f٦٩٣٨b;

    /* renamed from: c, reason: collision with root package name */
    private ResultReceiver f٦٩٣٩c;

    /* renamed from: d, reason: collision with root package name */
    private ResultReceiver f٦٩٤٠d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(ActivityResult activityResult) {
        Bundle extras;
        Intent a10 = activityResult.a();
        int b10 = zzb.zze(a10, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f٦٩٣٩c;
        if (resultReceiver != null) {
            if (a10 == null) {
                extras = null;
            } else {
                extras = a10.getExtras();
            }
            resultReceiver.send(b10, extras);
        }
        if (activityResult.b() != -1 || b10 != 0) {
            zzb.zzk("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + activityResult.b() + " and billing's responseCode: " + b10);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(ActivityResult activityResult) {
        Bundle extras;
        Intent a10 = activityResult.a();
        int b10 = zzb.zze(a10, "ProxyBillingActivityV2").b();
        ResultReceiver resultReceiver = this.f٦٩٤٠d;
        if (resultReceiver != null) {
            if (a10 == null) {
                extras = null;
            } else {
                extras = a10.getExtras();
            }
            resultReceiver.send(b10, extras);
        }
        if (activityResult.b() != -1 || b10 != 0) {
            zzb.zzk("ProxyBillingActivityV2", String.format("External offer dialog finished with resultCode: %s and billing's responseCode: %s", Integer.valueOf(activityResult.b()), Integer.valueOf(b10)));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f٦٩٣٧a = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.u2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProxyBillingActivityV2.this.h((ActivityResult) obj);
            }
        });
        this.f٦٩٣٨b = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.android.billingclient.api.v2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProxyBillingActivityV2.this.i((ActivityResult) obj);
            }
        });
        if (bundle == null) {
            zzb.zzj("ProxyBillingActivityV2", "Launching Play Store billing dialog");
            if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.f٦٩٣٩c = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                this.f٦٩٣٧a.launch(new IntentSenderRequest.Builder(pendingIntent).build());
                return;
            } else {
                if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                    PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                    this.f٦٩٤٠d = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                    this.f٦٩٣٨b.launch(new IntentSenderRequest.Builder(pendingIntent2).build());
                    return;
                }
                return;
            }
        }
        if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
            this.f٦٩٣٩c = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
        } else if (bundle.containsKey("external_payment_dialog_result_receiver")) {
            this.f٦٩٤٠d = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f٦٩٣٩c;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f٦٩٤٠d;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }
}
