package com.qmuiteam.qmui.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private Pools.Pool f١٣١١٦a;

    /* renamed from: b, reason: collision with root package name */
    private List f١٣١١٧b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f١٣١١٨c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f١٣١١٩d;

    public a(ViewGroup viewGroup) {
        this.f١٣١١٩d = viewGroup;
    }

    private View k() {
        View view;
        Pools.Pool pool = this.f١٣١١٦a;
        if (pool != null) {
            view = (View) pool.acquire();
        } else {
            view = null;
        }
        if (view == null) {
            return g(this.f١٣١١٩d);
        }
        return view;
    }

    public a d(Object obj) {
        this.f١٣١١٧b.add(obj);
        return this;
    }

    protected abstract void e(Object obj, View view, int i10);

    public void f() {
        this.f١٣١١٧b.clear();
        h(this.f١٣١١٨c.size());
    }

    protected abstract View g(ViewGroup viewGroup);

    public void h(int i10) {
        int size = this.f١٣١١٨c.size();
        while (size > 0 && i10 > 0) {
            View view = (View) this.f١٣١١٨c.remove(size - 1);
            if (this.f١٣١١٦a == null) {
                this.f١٣١١٦a = new Pools.SimplePool(12);
            }
            Object tag = view.getTag(R.id.qmui_view_can_not_cache_tag);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                try {
                    m(view);
                    this.f١٣١١٦a.release(view);
                } catch (Exception unused) {
                }
            }
            this.f١٣١١٩d.removeView(view);
            size--;
            i10--;
        }
    }

    public Object i(int i10) {
        List list = this.f١٣١١٧b;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f١٣١١٧b.get(i10);
    }

    public int j() {
        List list = this.f١٣١١٧b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List l() {
        return this.f١٣١١٨c;
    }

    protected abstract void m(View view);

    public void n() {
        int size = this.f١٣١١٧b.size();
        int size2 = this.f١٣١١٨c.size();
        if (size2 > size) {
            h(size2 - size);
        } else if (size2 < size) {
            for (int i10 = 0; i10 < size - size2; i10++) {
                View k10 = k();
                this.f١٣١١٩d.addView(k10);
                this.f١٣١١٨c.add(k10);
            }
        }
        for (int i11 = 0; i11 < size; i11++) {
            e(this.f١٣١١٧b.get(i11), (View) this.f١٣١١٨c.get(i11), i11);
        }
        this.f١٣١١٩d.invalidate();
        this.f١٣١١٩d.requestLayout();
    }
}
