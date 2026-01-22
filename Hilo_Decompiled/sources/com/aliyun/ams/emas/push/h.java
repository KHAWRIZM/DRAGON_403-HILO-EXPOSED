package com.aliyun.ams.emas.push;

import android.app.Notification;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Notification f٦٨٨٤a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Notification f٦٨٨٥b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f٦٨٨٦c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Notification notification, Notification notification2) {
        this.f٦٨٨٦c = gVar;
        this.f٦٨٨٤a = notification;
        this.f٦٨٨٥b = notification2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f٦٨٨٦c.f٦٨٨٣g.a(this.f٦٨٨٤a, this.f٦٨٨٥b);
    }
}
