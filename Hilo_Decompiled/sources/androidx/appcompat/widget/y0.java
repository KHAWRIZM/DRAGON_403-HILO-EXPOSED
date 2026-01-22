package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class y0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٧٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private final View f١٧٠٣b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f١٧٠٤c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f١٧٠٥d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f١٧٠٦e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f١٧٠٧f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f١٧٠٨g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f١٧٠٥d = layoutParams;
        this.f١٧٠٦e = new Rect();
        this.f١٧٠٧f = new int[2];
        this.f١٧٠٨g = new int[2];
        this.f١٧٠٢a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f١٧٠٣b = inflate;
        this.f١٧٠٤c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int height;
        int i12;
        int i13;
        int i14;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f١٧٠٢a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f١٧٠٢a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.f١٧٠٢a.getResources();
        if (z10) {
            i13 = R.dimen.tooltip_y_offset_touch;
        } else {
            i13 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i13);
        View b10 = b(view);
        if (b10 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b10.getWindowVisibleDisplayFrame(this.f١٧٠٦e);
        Rect rect = this.f١٧٠٦e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.f١٧٠٢a.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i14 = resources2.getDimensionPixelSize(identifier);
            } else {
                i14 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.f١٧٠٦e.set(0, i14, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b10.getLocationOnScreen(this.f١٧٠٨g);
        view.getLocationOnScreen(this.f١٧٠٧f);
        int[] iArr = this.f١٧٠٧f;
        int i15 = iArr[0];
        int[] iArr2 = this.f١٧٠٨g;
        int i16 = i15 - iArr2[0];
        iArr[0] = i16;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i16 + i10) - (b10.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f١٧٠٣b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f١٧٠٣b.getMeasuredHeight();
        int i17 = this.f١٧٠٧f[1];
        int i18 = ((i12 + i17) - dimensionPixelOffset3) - measuredHeight;
        int i19 = i17 + height + dimensionPixelOffset3;
        if (z10) {
            if (i18 >= 0) {
                layoutParams.y = i18;
                return;
            } else {
                layoutParams.y = i19;
                return;
            }
        }
        if (measuredHeight + i19 <= this.f١٧٠٦e.height()) {
            layoutParams.y = i19;
        } else {
            layoutParams.y = i18;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (!d()) {
            return;
        }
        ((WindowManager) this.f١٧٠٢a.getSystemService("window")).removeView(this.f١٧٠٣b);
    }

    boolean d() {
        if (this.f١٧٠٣b.getParent() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f١٧٠٤c.setText(charSequence);
        a(view, i10, i11, z10, this.f١٧٠٥d);
        ((WindowManager) this.f١٧٠٢a.getSystemService("window")).addView(this.f١٧٠٣b, this.f١٧٠٥d);
    }
}
