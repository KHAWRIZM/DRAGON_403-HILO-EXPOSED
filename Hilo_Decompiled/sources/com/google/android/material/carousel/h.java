package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h extends c {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f٨٦٩٣d = {1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f٨٦٩٤e = {1, 0};

    /* renamed from: c, reason: collision with root package name */
    private int f٨٦٩٥c = 0;

    @Override // com.google.android.material.carousel.c
    public e g(t7.a aVar, View view) {
        int b10 = aVar.b();
        if (aVar.d()) {
            b10 = aVar.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (aVar.d()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float d10 = d() + f10;
        float max = Math.max(c() + f10, d10);
        float f11 = b10;
        float min = Math.min(measuredHeight + f10, f11);
        float a10 = j2.a.a((measuredHeight / 3.0f) + f10, d10 + f10, max + f10);
        float f12 = (min + a10) / 2.0f;
        int[] iArr = f٨٦٩٣d;
        float f13 = d10 * 2.0f;
        if (f11 <= f13) {
            iArr = new int[]{0};
        }
        int[] iArr2 = f٨٦٩٤e;
        if (aVar.c() == 1) {
            iArr = c.a(iArr);
            iArr2 = c.a(iArr2);
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int max2 = (int) Math.max(1.0d, Math.floor(((f11 - (d.i(iArr4) * f12)) - (d.i(iArr3) * max)) / min));
        int ceil = (int) Math.ceil(f11 / min);
        int i10 = (ceil - max2) + 1;
        int[] iArr5 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr5[i11] = ceil - i11;
        }
        int i12 = b10;
        a c10 = a.c(f11, a10, d10, max, iArr3, f12, iArr4, min, iArr5);
        this.f٨٦٩٥c = c10.e();
        boolean i13 = i(c10, aVar.getItemCount());
        int i14 = c10.f٨٦٤٩d;
        if (i14 == 0 && c10.f٨٦٤٨c == 0 && f11 > f13) {
            c10.f٨٦٤٨c = 1;
            i13 = true;
        }
        if (i13) {
            c10 = a.c(f11, a10, d10, max, new int[]{c10.f٨٦٤٨c}, f12, new int[]{i14}, min, new int[]{c10.f٨٦٥٢g});
        }
        return d.d(view.getContext(), f10, i12, c10, aVar.c());
    }

    @Override // com.google.android.material.carousel.c
    public boolean h(t7.a aVar, int i10) {
        if ((i10 < this.f٨٦٩٥c && aVar.getItemCount() >= this.f٨٦٩٥c) || (i10 >= this.f٨٦٩٥c && aVar.getItemCount() < this.f٨٦٩٥c)) {
            return true;
        }
        return false;
    }

    boolean i(a aVar, int i10) {
        boolean z10;
        int e10 = aVar.e() - i10;
        if (e10 > 0 && (aVar.f٨٦٤٨c > 0 || aVar.f٨٦٤٩d > 1)) {
            z10 = true;
        } else {
            z10 = false;
        }
        while (e10 > 0) {
            int i11 = aVar.f٨٦٤٨c;
            if (i11 > 0) {
                aVar.f٨٦٤٨c = i11 - 1;
            } else {
                int i12 = aVar.f٨٦٤٩d;
                if (i12 > 1) {
                    aVar.f٨٦٤٩d = i12 - 1;
                }
            }
            e10--;
        }
        return z10;
    }
}
