package com.qmuiteam.qmui.widget.popup;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class QMUINormalPopup extends com.qmuiteam.qmui.widget.popup.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class ContentView extends QMUIFrameLayout {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class DecorRootView extends FrameLayout implements dc.a {

        /* renamed from: a, reason: collision with root package name */
        private View f١٣١٧٦a;

        /* renamed from: b, reason: collision with root package name */
        private Runnable f١٣١٧٧b;

        @Override // dc.a
        public boolean a(int i10, Resources.Theme theme) {
            if (!QMUINormalPopup.d(null) && QMUINormalPopup.b(null) != 0) {
                QMUINormalPopup.f(null, i.c(theme, QMUINormalPopup.b(null)));
            }
            if (!QMUINormalPopup.c(null) && QMUINormalPopup.a(null) != 0) {
                QMUINormalPopup.e(null, i.c(theme, QMUINormalPopup.a(null)));
                return false;
            }
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            removeCallbacks(this.f١٣١٧٧b);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            removeCallbacks(this.f١٣١٧٧b);
            setMeasuredDimension(0, 0);
        }

        public void setContentView(View view) {
            View view2 = this.f١٣١٧٦a;
            if (view2 != null) {
                removeView(view2);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f١٣١٧٦a = view;
            addView(view);
        }

        public void setShowInfo(com.qmuiteam.qmui.widget.popup.QMUINormalPopup.a aVar) {
            requestFocus();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a {
    }

    static /* bridge */ /* synthetic */ int a(QMUINormalPopup qMUINormalPopup) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int b(QMUINormalPopup qMUINormalPopup) {
        throw null;
    }

    static /* bridge */ /* synthetic */ boolean c(QMUINormalPopup qMUINormalPopup) {
        throw null;
    }

    static /* bridge */ /* synthetic */ boolean d(QMUINormalPopup qMUINormalPopup) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void e(QMUINormalPopup qMUINormalPopup, int i10) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void f(QMUINormalPopup qMUINormalPopup, int i10) {
        throw null;
    }
}
