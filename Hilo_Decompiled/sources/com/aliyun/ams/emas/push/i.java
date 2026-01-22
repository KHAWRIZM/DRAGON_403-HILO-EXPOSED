package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements k {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f٦٨٨٧a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b4.a f٦٨٨٨b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b4.b f٦٨٨٩c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f٦٨٩٠d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ b f٦٨٩١e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Map map, b4.a aVar, b4.b bVar, Context context, b bVar2) {
        this.f٦٨٨٧a = map;
        this.f٦٨٨٨b = aVar;
        this.f٦٨٨٩c = bVar;
        this.f٦٨٩٠d = context;
        this.f٦٨٩١e = bVar2;
    }

    @Override // com.aliyun.ams.emas.push.k
    public void a(Notification notification, Notification notification2) {
        String str = (String) this.f٦٨٨٧a.get("emas_group");
        if (!TextUtils.isEmpty(str)) {
            this.f٦٨٨٨b.C(str);
        }
        ILog iLog = l.f٦٨٩٨a;
        iLog.d("push created notification" + this.f٦٨٨٨b.e());
        this.f٦٨٨٩c.d(this.f٦٨٩٠d, notification, notification2, this.f٦٨٨٨b);
        iLog.d("push onNotificationShow " + this.f٦٨٨٨b.e());
        this.f٦٨٩١e.onNotificationShow(this.f٦٨٩٠d, this.f٦٨٨٨b.e(), this.f٦٨٨٨b.h(), this.f٦٨٨٨b.l());
    }
}
