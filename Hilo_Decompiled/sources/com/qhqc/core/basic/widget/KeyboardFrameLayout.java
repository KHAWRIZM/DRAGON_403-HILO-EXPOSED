package com.qhqc.core.basic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class KeyboardFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٢٢٥٣a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٢٢٥٤b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٢٥٥c;

    /* renamed from: d, reason: collision with root package name */
    private a f١٢٢٥٦d;

    /* renamed from: e, reason: collision with root package name */
    private long f١٢٢٥٧e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
        void a(int i10);
    }

    public KeyboardFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٢٥٧e = 0L;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f١٢٢٥٣a) {
            this.f١٢٢٥٣a = true;
            this.f١٢٢٥٥c = i13;
            a aVar2 = this.f١٢٢٥٦d;
            if (aVar2 != null) {
                aVar2.a(-1);
            }
        } else {
            int i14 = this.f١٢٢٥٥c;
            if (i14 < i13) {
                i14 = i13;
            }
            this.f١٢٢٥٥c = i14;
        }
        if (this.f١٢٢٥٣a && this.f١٢٢٥٥c > i13) {
            this.f١٢٢٥٤b = true;
            a aVar3 = this.f١٢٢٥٦d;
            if (aVar3 != null) {
                aVar3.a(-3);
                this.f١٢٢٥٧e = System.currentTimeMillis();
            }
        }
        if (this.f١٢٢٥٣a && this.f١٢٢٥٤b && this.f١٢٢٥٥c == i13) {
            this.f١٢٢٥٤b = false;
            if (System.currentTimeMillis() - this.f١٢٢٥٧e > 500 && (aVar = this.f١٢٢٥٦d) != null) {
                aVar.a(-2);
            }
        }
    }

    public void setOnkbdStateListener(a aVar) {
        this.f١٢٢٥٦d = aVar;
    }

    public void setmHasKeybord(boolean z10) {
        this.f١٢٢٥٤b = z10;
    }

    public KeyboardFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٢٥٧e = 0L;
    }

    public KeyboardFrameLayout(Context context) {
        super(context);
        this.f١٢٢٥٧e = 0L;
    }
}
