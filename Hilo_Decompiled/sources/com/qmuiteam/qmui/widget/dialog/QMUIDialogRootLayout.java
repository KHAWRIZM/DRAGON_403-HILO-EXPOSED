package com.qmuiteam.qmui.widget.dialog;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import ic.e;
import ic.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIDialogRootLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private QMUIDialogView f١٣١٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout.LayoutParams f١٣١٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٣١٥١c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣١٥٢d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣١٥٣e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣١٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٣١٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٣١٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٣١٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٣١٥٨j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    interface a {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f١٣١٥٨j > 0) {
            motionEvent.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, -r0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public QMUIDialogView getDialogView() {
        return this.f١٣١٤٩a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = ((i12 - i10) - this.f١٣١٤٩a.getMeasuredWidth()) / 2;
        QMUIDialogView qMUIDialogView = this.f١٣١٤٩a;
        qMUIDialogView.layout(measuredWidth, this.f١٣١٥٤f, qMUIDialogView.getMeasuredWidth() + measuredWidth, this.f١٣١٥٤f + this.f١٣١٤٩a.getMeasuredHeight());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int makeMeasureSpec;
        int i15;
        int min;
        int makeMeasureSpec2;
        int measuredWidth;
        int i16;
        if (this.f١٣١٥٥g) {
            Rect c10 = m.c(this);
            Rect b10 = m.b(this);
            if (c10 != null) {
                i12 = c10.bottom;
            } else {
                i12 = 0;
            }
            if (b10 != null) {
                int i17 = b10.top;
                this.f١٣١٥٨j = i17;
                i13 = i17 + b10.bottom;
                int size = View.MeasureSpec.getSize(i10);
                int size2 = View.MeasureSpec.getSize(i11);
                i14 = this.f١٣١٥٠b.width;
                if (i14 <= 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                } else {
                    int min2 = Math.min(this.f١٣١٥٢d, size - (this.f١٣١٥٣e * 2));
                    int i18 = this.f١٣١٥١c;
                    if (min2 <= i18) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    } else if (this.f١٣١٥٠b.width == -1) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(min2, Integer.MIN_VALUE);
                    }
                }
                i15 = this.f١٣١٥٠b.height;
                if (i15 <= 0) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                } else {
                    if (i12 > 0) {
                        if (getRootView() != null && getRootView().getHeight() > 0) {
                            size2 = getRootView().getHeight();
                            if (!this.f١٣١٥٧i) {
                                this.f١٣١٥٧i = true;
                            }
                        }
                        min = Math.max(((size2 - (this.f١٣١٥٤f * 2)) - i12) - i13, 0);
                    } else {
                        this.f١٣١٥٧i = false;
                        min = Math.min((size2 - (this.f١٣١٥٤f * 2)) - i13, (int) ((e.g(getContext()) * this.f١٣١٥٦h) - (this.f١٣١٥٤f * 2)));
                    }
                    if (this.f١٣١٥٠b.height == -1) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                    } else {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE);
                    }
                }
                this.f١٣١٤٩a.measure(makeMeasureSpec, makeMeasureSpec2);
                measuredWidth = this.f١٣١٤٩a.getMeasuredWidth();
                i16 = this.f١٣١٥١c;
                if (measuredWidth < i16) {
                    this.f١٣١٤٩a.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), makeMeasureSpec2);
                }
                setMeasuredDimension(this.f١٣١٤٩a.getMeasuredWidth(), this.f١٣١٤٩a.getMeasuredHeight() + (this.f١٣١٥٤f * 2) + i12 + i13);
            }
        } else {
            i12 = 0;
        }
        i13 = 0;
        int size3 = View.MeasureSpec.getSize(i10);
        int size22 = View.MeasureSpec.getSize(i11);
        i14 = this.f١٣١٥٠b.width;
        if (i14 <= 0) {
        }
        i15 = this.f١٣١٥٠b.height;
        if (i15 <= 0) {
        }
        this.f١٣١٤٩a.measure(makeMeasureSpec, makeMeasureSpec2);
        measuredWidth = this.f١٣١٤٩a.getMeasuredWidth();
        i16 = this.f١٣١٥١c;
        if (measuredWidth < i16) {
        }
        setMeasuredDimension(this.f١٣١٤٩a.getMeasuredWidth(), this.f١٣١٤٩a.getMeasuredHeight() + (this.f١٣١٥٤f * 2) + i12 + i13);
    }

    public void setCheckKeyboardOverlay(boolean z10) {
        this.f١٣١٥٥g = z10;
    }

    public void setInsetHor(int i10) {
        this.f١٣١٥٣e = i10;
    }

    public void setInsetVer(int i10) {
        this.f١٣١٥٤f = i10;
    }

    public void setMaxPercent(float f10) {
        this.f١٣١٥٦h = f10;
    }

    public void setMaxWidth(int i10) {
        this.f١٣١٥٢d = i10;
    }

    public void setMinWidth(int i10) {
        this.f١٣١٥١c = i10;
    }

    public void setOverlayOccurInMeasureCallback(a aVar) {
    }
}
