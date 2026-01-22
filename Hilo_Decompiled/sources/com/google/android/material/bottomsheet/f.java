package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.d2;
import androidx.core.view.q1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class f extends q1.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f٨٤٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨٤٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private int f٨٥٠٠c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f٨٥٠١d;

    public f(View view) {
        super(0);
        this.f٨٥٠١d = new int[2];
        this.f٨٤٩٨a = view;
    }

    @Override // androidx.core.view.q1.b
    public void onEnd(q1 q1Var) {
        this.f٨٤٩٨a.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
    }

    @Override // androidx.core.view.q1.b
    public void onPrepare(q1 q1Var) {
        this.f٨٤٩٨a.getLocationOnScreen(this.f٨٥٠١d);
        this.f٨٤٩٩b = this.f٨٥٠١d[1];
    }

    @Override // androidx.core.view.q1.b
    public d2 onProgress(d2 d2Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((q1) it.next()).c() & d2.m.b()) != 0) {
                this.f٨٤٩٨a.setTranslationY(p7.a.c(this.f٨٥٠٠c, 0, r0.b()));
                break;
            }
        }
        return d2Var;
    }

    @Override // androidx.core.view.q1.b
    public q1.a onStart(q1 q1Var, q1.a aVar) {
        this.f٨٤٩٨a.getLocationOnScreen(this.f٨٥٠١d);
        int i10 = this.f٨٤٩٩b - this.f٨٥٠١d[1];
        this.f٨٥٠٠c = i10;
        this.f٨٤٩٨a.setTranslationY(i10);
        return aVar;
    }
}
