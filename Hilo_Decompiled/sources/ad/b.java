package ad;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.transform.OverlapPageTransformer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    private c a;
    private final a b;
    private final CompositePageTransformer c;
    private MarginPageTransformer d;
    private ViewPager2.PageTransformer e;

    public b() {
        c cVar = new c();
        this.a = cVar;
        this.b = new a(cVar);
        this.c = new CompositePageTransformer();
    }

    public void a() {
        f();
        MarginPageTransformer marginPageTransformer = new MarginPageTransformer(this.a.i());
        this.d = marginPageTransformer;
        this.c.addTransformer(marginPageTransformer);
    }

    public c b() {
        if (this.a == null) {
            this.a = new c();
        }
        return this.a;
    }

    public CompositePageTransformer c() {
        return this.c;
    }

    public void d(Context context, AttributeSet attributeSet) {
        this.b.a(context, attributeSet);
    }

    public void e() {
        ViewPager2.PageTransformer pageTransformer = this.e;
        if (pageTransformer != null) {
            this.c.removeTransformer(pageTransformer);
        }
    }

    public void f() {
        MarginPageTransformer marginPageTransformer = this.d;
        if (marginPageTransformer != null) {
            this.c.removeTransformer(marginPageTransformer);
        }
    }

    public void g(boolean z, float f) {
        e();
        if (z) {
            this.e = new OverlapPageTransformer(this.a.h(), f, 0.0f, 1.0f, 0.0f);
        } else {
            this.e = new cd.a(f);
        }
        this.c.addTransformer(this.e);
    }

    public void h(int i) {
        this.a.I(i);
    }
}
