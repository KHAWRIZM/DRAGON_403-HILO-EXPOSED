package ic;

import android.view.View;
import androidx.core.view.d1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final View f١٤٨٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٤٨٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٤٩٠٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٤٩٠١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٤٩٠٢e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٤٩٠٣f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٤٩٠٤g = true;

    public l(View view) {
        this.f١٤٨٩٨a = view;
    }

    public void a() {
        View view = this.f١٤٨٩٨a;
        d1.b0(view, this.f١٤٩٠١d - (view.getTop() - this.f١٤٨٩٩b));
        View view2 = this.f١٤٨٩٨a;
        d1.a0(view2, this.f١٤٩٠٢e - (view2.getLeft() - this.f١٤٩٠٠c));
    }

    public int b() {
        return this.f١٤٨٩٩b;
    }

    public int c() {
        return this.f١٤٩٠٢e;
    }

    public int d() {
        return this.f١٤٩٠١d;
    }

    public void e() {
        f(true);
    }

    public void f(boolean z10) {
        this.f١٤٨٩٩b = this.f١٤٨٩٨a.getTop();
        this.f١٤٩٠٠c = this.f١٤٨٩٨a.getLeft();
        if (z10) {
            a();
        }
    }

    public boolean g(int i10) {
        if (this.f١٤٩٠٤g && this.f١٤٩٠٢e != i10) {
            this.f١٤٩٠٢e = i10;
            a();
            return true;
        }
        return false;
    }

    public boolean h(int i10) {
        if (this.f١٤٩٠٣f && this.f١٤٩٠١d != i10) {
            this.f١٤٩٠١d = i10;
            a();
            return true;
        }
        return false;
    }
}
