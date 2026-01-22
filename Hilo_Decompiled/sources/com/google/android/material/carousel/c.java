package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private float f٨٦٥٧a;

    /* renamed from: b, reason: collision with root package name */
    private float f٨٦٥٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    enum a {
        CONTAINED,
        UNCONTAINED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = iArr[i10] * 2;
        }
        return iArr2;
    }

    public static float b(float f10, float f11, float f12) {
        return 1.0f - ((f10 - f12) / (f11 - f12));
    }

    public float c() {
        return this.f٨٦٥٨b;
    }

    public float d() {
        return this.f٨٦٥٧a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a e() {
        return a.CONTAINED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Context context) {
        float f10 = this.f٨٦٥٧a;
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            f10 = d.h(context);
        }
        this.f٨٦٥٧a = f10;
        float f11 = this.f٨٦٥٨b;
        if (f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
            f11 = d.g(context);
        }
        this.f٨٦٥٨b = f11;
    }

    public abstract e g(t7.a aVar, View view);

    public abstract boolean h(t7.a aVar, int i10);
}
