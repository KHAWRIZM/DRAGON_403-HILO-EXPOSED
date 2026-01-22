package com.google.android.material.progressindicator;

import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    protected j f٩٦٩٩a;

    /* renamed from: b, reason: collision with root package name */
    protected final List f٩٧٠٠b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public i(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f٩٧٠٠b.add(new h.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i10, int i11, int i12) {
        return j2.a.a((i10 - i11) / i12, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
    }

    public abstract void c();

    public abstract void d(androidx.vectordrawable.graphics.drawable.b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(j jVar) {
        this.f٩٦٩٩a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
