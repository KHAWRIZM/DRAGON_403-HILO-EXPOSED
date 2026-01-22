package zb;

import android.view.View;
import com.qmuiteam.qmui.R;
import ic.i;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f١٩٥٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٩٥٢٧b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٩٥٢٨c = true;

    /* renamed from: d, reason: collision with root package name */
    private float f١٩٥٢٩d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f١٩٥٣٠e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٩٥٣١f;

    public a(View view) {
        this.f١٩٥٣٠e = 0.5f;
        this.f١٩٥٣١f = 0.5f;
        this.f١٩٥٢٦a = new WeakReference(view);
        this.f١٩٥٣٠e = i.i(view.getContext(), R.attr.qmui_alpha_pressed);
        this.f١٩٥٣١f = i.i(view.getContext(), R.attr.qmui_alpha_disabled);
    }

    public void a(View view, boolean z10) {
        float f10;
        View view2 = (View) this.f١٩٥٢٦a.get();
        if (view2 == null) {
            return;
        }
        if (this.f١٩٥٢٨c) {
            if (z10) {
                f10 = this.f١٩٥٢٩d;
            } else {
                f10 = this.f١٩٥٣١f;
            }
        } else {
            f10 = this.f١٩٥٢٩d;
        }
        if (view != view2 && view2.isEnabled() != z10) {
            view2.setEnabled(z10);
        }
        view2.setAlpha(f10);
    }

    public void b(View view, boolean z10) {
        float f10;
        View view2 = (View) this.f١٩٥٢٦a.get();
        if (view2 == null) {
            return;
        }
        if (view.isEnabled()) {
            if (this.f١٩٥٢٧b && z10 && view.isClickable()) {
                f10 = this.f١٩٥٣٠e;
            } else {
                f10 = this.f١٩٥٢٩d;
            }
            view2.setAlpha(f10);
            return;
        }
        if (this.f١٩٥٢٨c) {
            view2.setAlpha(this.f١٩٥٣١f);
        }
    }

    public void c(boolean z10) {
        this.f١٩٥٢٨c = z10;
        View view = (View) this.f١٩٥٢٦a.get();
        if (view != null) {
            a(view, view.isEnabled());
        }
    }

    public void d(boolean z10) {
        this.f١٩٥٢٧b = z10;
    }
}
