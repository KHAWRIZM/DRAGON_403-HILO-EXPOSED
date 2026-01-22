package y7;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final View f١٩١٩٣a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٩١٩٤b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f١٩١٩٥c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f١٩١٩٣a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f١٩١٩٣a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).r(this.f١٩١٩٣a);
        }
    }

    public int b() {
        return this.f١٩١٩٥c;
    }

    public boolean c() {
        return this.f١٩١٩٤b;
    }

    public void d(Bundle bundle) {
        this.f١٩١٩٤b = bundle.getBoolean("expanded", false);
        this.f١٩١٩٥c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f١٩١٩٤b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f١٩١٩٤b);
        bundle.putInt("expandedComponentIdHint", this.f١٩١٩٥c);
        return bundle;
    }

    public void f(int i10) {
        this.f١٩١٩٥c = i10;
    }
}
