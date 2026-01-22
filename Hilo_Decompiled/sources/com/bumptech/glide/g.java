package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m4.l;
import o4.t;
import o4.v;
import t4.o;
import t4.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final p f٧٢٦٥a;

    /* renamed from: b, reason: collision with root package name */
    private final b5.a f٧٢٦٦b;

    /* renamed from: c, reason: collision with root package name */
    private final b5.e f٧٢٦٧c;

    /* renamed from: d, reason: collision with root package name */
    private final b5.f f٧٢٦٨d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f٧٢٦٩e;

    /* renamed from: f, reason: collision with root package name */
    private final y4.f f٧٢٧٠f;

    /* renamed from: g, reason: collision with root package name */
    private final b5.b f٧٢٧١g;

    /* renamed from: h, reason: collision with root package name */
    private final b5.d f٧٢٧٢h = new b5.d();

    /* renamed from: i, reason: collision with root package name */
    private final b5.c f٧٢٧٣i = new b5.c();

    /* renamed from: j, reason: collision with root package name */
    private final Pools.Pool f٧٢٧٤j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public c(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }

        public c(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends a {
        public d(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e extends a {
        public e(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public g() {
        Pools.Pool e10 = g5.a.e();
        this.f٧٢٧٤j = e10;
        this.f٧٢٦٥a = new p(e10);
        this.f٧٢٦٦b = new b5.a();
        this.f٧٢٦٧c = new b5.e();
        this.f٧٢٦٨d = new b5.f();
        this.f٧٢٦٩e = new com.bumptech.glide.load.data.f();
        this.f٧٢٧٠f = new y4.f();
        this.f٧٢٧١g = new b5.b();
        u(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    private List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f٧٢٦٧c.d(cls, cls2)) {
            for (Class cls5 : this.f٧٢٧٠f.b(cls4, cls3)) {
                arrayList.add(new o4.i(cls, cls4, cls5, this.f٧٢٦٧c.b(cls, cls4), this.f٧٢٧٠f.a(cls4, cls5), this.f٧٢٧٤j));
            }
        }
        return arrayList;
    }

    public g a(Class cls, Class cls2, m4.k kVar) {
        e("legacy_append", cls, cls2, kVar);
        return this;
    }

    public g b(Class cls, Class cls2, o oVar) {
        this.f٧٢٦٥a.a(cls, cls2, oVar);
        return this;
    }

    public g c(Class cls, m4.d dVar) {
        this.f٧٢٦٦b.a(cls, dVar);
        return this;
    }

    public g d(Class cls, l lVar) {
        this.f٧٢٦٨d.a(cls, lVar);
        return this;
    }

    public g e(String str, Class cls, Class cls2, m4.k kVar) {
        this.f٧٢٦٧c.a(str, kVar, cls, cls2);
        return this;
    }

    public List g() {
        List b10 = this.f٧٢٧١g.b();
        if (!b10.isEmpty()) {
            return b10;
        }
        throw new b();
    }

    public t h(Class cls, Class cls2, Class cls3) {
        t a10 = this.f٧٢٧٣i.a(cls, cls2, cls3);
        if (this.f٧٢٧٣i.c(a10)) {
            return null;
        }
        if (a10 == null) {
            List f10 = f(cls, cls2, cls3);
            if (f10.isEmpty()) {
                a10 = null;
            } else {
                a10 = new t(cls, cls2, cls3, f10, this.f٧٢٧٤j);
            }
            this.f٧٢٧٣i.d(cls, cls2, cls3, a10);
        }
        return a10;
    }

    public List i(Object obj) {
        return this.f٧٢٦٥a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List a10 = this.f٧٢٧٢h.a(cls, cls2, cls3);
        if (a10 == null) {
            a10 = new ArrayList();
            Iterator it = this.f٧٢٦٥a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.f٧٢٦٧c.d((Class) it.next(), cls2)) {
                    if (!this.f٧٢٧٠f.b(cls4, cls3).isEmpty() && !a10.contains(cls4)) {
                        a10.add(cls4);
                    }
                }
            }
            this.f٧٢٧٢h.b(cls, cls2, cls3, Collections.unmodifiableList(a10));
        }
        return a10;
    }

    public l k(v vVar) {
        l b10 = this.f٧٢٦٨d.b(vVar.getResourceClass());
        if (b10 != null) {
            return b10;
        }
        throw new d(vVar.getResourceClass());
    }

    public com.bumptech.glide.load.data.e l(Object obj) {
        return this.f٧٢٦٩e.a(obj);
    }

    public m4.d m(Object obj) {
        m4.d b10 = this.f٧٢٦٦b.b(obj.getClass());
        if (b10 != null) {
            return b10;
        }
        throw new e(obj.getClass());
    }

    public boolean n(v vVar) {
        if (this.f٧٢٦٨d.b(vVar.getResourceClass()) != null) {
            return true;
        }
        return false;
    }

    public g o(Class cls, Class cls2, m4.k kVar) {
        q("legacy_prepend_all", cls, cls2, kVar);
        return this;
    }

    public g p(Class cls, l lVar) {
        this.f٧٢٦٨d.c(cls, lVar);
        return this;
    }

    public g q(String str, Class cls, Class cls2, m4.k kVar) {
        this.f٧٢٦٧c.e(str, kVar, cls, cls2);
        return this;
    }

    public g r(ImageHeaderParser imageHeaderParser) {
        this.f٧٢٧١g.a(imageHeaderParser);
        return this;
    }

    public g s(e.a aVar) {
        this.f٧٢٦٩e.b(aVar);
        return this;
    }

    public g t(Class cls, Class cls2, y4.e eVar) {
        this.f٧٢٧٠f.c(cls, cls2, eVar);
        return this;
    }

    public final g u(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.f٧٢٦٧c.f(arrayList);
        return this;
    }
}
