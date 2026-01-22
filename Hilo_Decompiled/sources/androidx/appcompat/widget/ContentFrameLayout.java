package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TypedValue f١٣١٣a;

    /* renamed from: b, reason: collision with root package name */
    private TypedValue f١٣١٤b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f١٣١٥c;

    /* renamed from: d, reason: collision with root package name */
    private TypedValue f١٣١٦d;

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f١٣١٧e;

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f١٣١٨f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f١٣١٩g;

    /* renamed from: h, reason: collision with root package name */
    private a f١٣٢٠h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i10, int i11, int i12, int i13) {
        this.f١٣١٩g.set(i10, i11, i12, i13);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f١٣١٧e == null) {
            this.f١٣١٧e = new TypedValue();
        }
        return this.f١٣١٧e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f١٣١٨f == null) {
            this.f١٣١٨f = new TypedValue();
        }
        return this.f١٣١٨f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f١٣١٥c == null) {
            this.f١٣١٥c = new TypedValue();
        }
        return this.f١٣١٥c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f١٣١٦d == null) {
            this.f١٣١٦d = new TypedValue();
        }
        return this.f١٣١٦d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f١٣١٣a == null) {
            this.f١٣١٣a = new TypedValue();
        }
        return this.f١٣١٣a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f١٣١٤b == null) {
            this.f١٣١٤b = new TypedValue();
        }
        return this.f١٣١٤b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f١٣٢٠h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f١٣٢٠h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        boolean z11;
        int measuredWidth;
        TypedValue typedValue;
        int i12;
        int i13;
        float fraction;
        TypedValue typedValue2;
        int i14;
        int i15;
        float fraction2;
        TypedValue typedValue3;
        int i16;
        int i17;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z12 = true;
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            z10 = true;
        } else {
            z10 = false;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            if (z10) {
                typedValue3 = this.f١٣١٦d;
            } else {
                typedValue3 = this.f١٣١٥c;
            }
            if (typedValue3 != null && (i16 = typedValue3.type) != 0) {
                if (i16 == 5) {
                    fraction3 = typedValue3.getDimension(displayMetrics);
                } else if (i16 == 6) {
                    int i18 = displayMetrics.widthPixels;
                    fraction3 = typedValue3.getFraction(i18, i18);
                } else {
                    i17 = 0;
                    if (i17 > 0) {
                        Rect rect = this.f١٣١٩g;
                        i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i17 - (rect.left + rect.right), View.MeasureSpec.getSize(i10)), 1073741824);
                        z11 = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            if (z10) {
                                typedValue2 = this.f١٣١٧e;
                            } else {
                                typedValue2 = this.f١٣١٨f;
                            }
                            if (typedValue2 != null && (i14 = typedValue2.type) != 0) {
                                if (i14 == 5) {
                                    fraction2 = typedValue2.getDimension(displayMetrics);
                                } else if (i14 == 6) {
                                    int i19 = displayMetrics.heightPixels;
                                    fraction2 = typedValue2.getFraction(i19, i19);
                                } else {
                                    i15 = 0;
                                    if (i15 > 0) {
                                        Rect rect2 = this.f١٣١٩g;
                                        i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i15 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i11)), 1073741824);
                                    }
                                }
                                i15 = (int) fraction2;
                                if (i15 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i10, i11);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z11 && mode == Integer.MIN_VALUE) {
                            if (!z10) {
                                typedValue = this.f١٣١٤b;
                            } else {
                                typedValue = this.f١٣١٣a;
                            }
                            if (typedValue != null && (i12 = typedValue.type) != 0) {
                                if (i12 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i12 == 6) {
                                    int i20 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i20, i20);
                                } else {
                                    i13 = 0;
                                    if (i13 > 0) {
                                        Rect rect3 = this.f١٣١٩g;
                                        i13 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i13) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                        if (z12) {
                                            super.onMeasure(makeMeasureSpec, i11);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i13 = (int) fraction;
                                if (i13 > 0) {
                                }
                                if (measuredWidth < i13) {
                                }
                            }
                        }
                        z12 = false;
                        if (z12) {
                        }
                    }
                }
                i17 = (int) fraction3;
                if (i17 > 0) {
                }
            }
        }
        z11 = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i10, i11);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z11) {
            if (!z10) {
            }
            if (typedValue != null) {
                if (i12 != 5) {
                }
                i13 = (int) fraction;
                if (i13 > 0) {
                }
                if (measuredWidth < i13) {
                }
            }
        }
        z12 = false;
        if (z12) {
        }
    }

    public void setAttachListener(a aVar) {
        this.f١٣٢٠h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١٩g = new Rect();
    }
}
