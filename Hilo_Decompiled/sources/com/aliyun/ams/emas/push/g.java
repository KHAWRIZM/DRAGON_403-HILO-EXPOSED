package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f٦٨٧٧a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f٦٨٧٨b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f٦٨٧٩c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f٦٨٨٠d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f٦٨٨١e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f٦٨٨٢f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ k f٦٨٨٣g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, Context context, Map map, String str, boolean z10, Handler handler, k kVar) {
        this.f٦٨٧٧a = cVar;
        this.f٦٨٧٨b = context;
        this.f٦٨٧٩c = map;
        this.f٦٨٨٠d = str;
        this.f٦٨٨١e = z10;
        this.f٦٨٨٢f = handler;
        this.f٦٨٨٣g = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Notification customSummaryNotification;
        Notification customNotificationUI = this.f٦٨٧٧a.customNotificationUI(this.f٦٨٧٨b, this.f٦٨٧٩c);
        if (TextUtils.isEmpty(this.f٦٨٨٠d) && !this.f٦٨٨١e) {
            customSummaryNotification = null;
        } else {
            customSummaryNotification = this.f٦٨٧٧a.customSummaryNotification(this.f٦٨٧٨b, this.f٦٨٧٩c);
        }
        Handler handler = this.f٦٨٨٢f;
        if (handler != null) {
            handler.post(new h(this, customNotificationUI, customSummaryNotification));
        } else {
            this.f٦٨٨٣g.a(customNotificationUI, customSummaryNotification);
        }
    }
}
