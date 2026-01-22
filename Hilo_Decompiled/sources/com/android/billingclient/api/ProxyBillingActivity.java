package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.w;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@UsedByReflection("PlatformActivityProxy")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProxyBillingActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ResultReceiver f٦٩٣٣a;

    /* renamed from: b, reason: collision with root package name */
    private ResultReceiver f٦٩٣٤b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٦٩٣٥c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٦٩٣٦d;

    private Intent a(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent b() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onActivityResult(int i10, int i11, Intent intent) {
        ResultReceiver resultReceiver;
        Intent b10;
        super.onActivityResult(i10, i11, intent);
        Bundle bundle = null;
        if (i10 != 100 && i10 != 110) {
            if (i10 == 101) {
                int zza = zzb.zza(intent, "ProxyBillingActivity");
                ResultReceiver resultReceiver2 = this.f٦٩٣٤b;
                if (resultReceiver2 != null) {
                    if (intent != null) {
                        bundle = intent.getExtras();
                    }
                    resultReceiver2.send(zza, bundle);
                }
            } else {
                zzb.zzk("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i10 + "; skipping...");
            }
        } else {
            int b11 = zzb.zze(intent, "ProxyBillingActivity").b();
            if (i11 == -1) {
                if (b11 != 0) {
                    i11 = -1;
                } else {
                    b11 = 0;
                    resultReceiver = this.f٦٩٣٣a;
                    if (resultReceiver == null) {
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        resultReceiver.send(b11, bundle);
                    } else {
                        if (intent != null) {
                            if (intent.getExtras() != null) {
                                String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                                if (string != null) {
                                    b10 = a(string);
                                    b10.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                                } else {
                                    b10 = b();
                                    b10.putExtras(intent.getExtras());
                                    b10.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                                }
                            } else {
                                b10 = b();
                                zzb.zzk("ProxyBillingActivity", "Got null bundle!");
                                b10.putExtra("RESPONSE_CODE", 6);
                                b10.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                                w.a c10 = w.c();
                                c10.c(6);
                                c10.b("An internal error occurred.");
                                b10.putExtra("FAILURE_LOGGING_PAYLOAD", c2.a(22, 2, c10.a()).zzc());
                                b10.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                            }
                        } else {
                            b10 = b();
                        }
                        if (i10 == 110) {
                            b10.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        sendBroadcast(b10);
                    }
                }
            }
            zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + i11 + " and billing's responseCode: " + b11);
            resultReceiver = this.f٦٩٣٣a;
            if (resultReceiver == null) {
            }
        }
        this.f٦٩٣٥c = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        int i10;
        super.onCreate(bundle);
        if (bundle == null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.f٦٩٣٦d = true;
                    i10 = 110;
                }
                i10 = 100;
            } else {
                if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                    pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                    this.f٦٩٣٣a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
                } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                    pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                    this.f٦٩٣٤b = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
                    i10 = 101;
                } else {
                    pendingIntent = null;
                }
                i10 = 100;
            }
            try {
                this.f٦٩٣٥c = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i10, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e10) {
                zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e10);
                ResultReceiver resultReceiver = this.f٦٩٣٣a;
                if (resultReceiver != null) {
                    resultReceiver.send(6, null);
                } else {
                    ResultReceiver resultReceiver2 = this.f٦٩٣٤b;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, null);
                    } else {
                        Intent b10 = b();
                        if (this.f٦٩٣٦d) {
                            b10.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        b10.putExtra("RESPONSE_CODE", 6);
                        b10.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        sendBroadcast(b10);
                    }
                }
                this.f٦٩٣٥c = false;
                finish();
                return;
            }
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.f٦٩٣٥c = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
        if (bundle.containsKey("result_receiver")) {
            this.f٦٩٣٣a = (ResultReceiver) bundle.getParcelable("result_receiver");
        } else if (bundle.containsKey("in_app_message_result_receiver")) {
            this.f٦٩٣٤b = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
        }
        this.f٦٩٣٦d = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f٦٩٣٥c) {
            Intent b10 = b();
            b10.putExtra("RESPONSE_CODE", 1);
            b10.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(b10);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f٦٩٣٣a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f٦٩٣٤b;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f٦٩٣٥c);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f٦٩٣٦d);
    }
}
