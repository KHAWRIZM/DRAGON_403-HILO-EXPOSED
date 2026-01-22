package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import f5.f;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    static final k f٧٢٤٢k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final p4.b f٧٢٤٣a;

    /* renamed from: b, reason: collision with root package name */
    private final f.b f٧٢٤٤b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.request.target.g f٧٢٤٥c;

    /* renamed from: d, reason: collision with root package name */
    private final Glide.a f٧٢٤٦d;

    /* renamed from: e, reason: collision with root package name */
    private final List f٧٢٤٧e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f٧٢٤٨f;

    /* renamed from: g, reason: collision with root package name */
    private final o4.k f٧٢٤٩g;

    /* renamed from: h, reason: collision with root package name */
    private final d f٧٢٥٠h;

    /* renamed from: i, reason: collision with root package name */
    private final int f٧٢٥١i;

    /* renamed from: j, reason: collision with root package name */
    private c5.h f٧٢٥٢j;

    public c(Context context, p4.b bVar, f.b bVar2, com.bumptech.glide.request.target.g gVar, Glide.a aVar, Map map, List list, o4.k kVar, d dVar, int i10) {
        super(context.getApplicationContext());
        this.f٧٢٤٣a = bVar;
        this.f٧٢٤٥c = gVar;
        this.f٧٢٤٦d = aVar;
        this.f٧٢٤٧e = list;
        this.f٧٢٤٨f = map;
        this.f٧٢٤٩g = kVar;
        this.f٧٢٥٠h = dVar;
        this.f٧٢٥١i = i10;
        this.f٧٢٤٤b = f5.f.a(bVar2);
    }

    public com.bumptech.glide.request.target.k a(ImageView imageView, Class cls) {
        return this.f٧٢٤٥c.buildTarget(imageView, cls);
    }

    public p4.b b() {
        return this.f٧٢٤٣a;
    }

    public List c() {
        return this.f٧٢٤٧e;
    }

    public synchronized c5.h d() {
        try {
            if (this.f٧٢٥٢j == null) {
                this.f٧٢٥٢j = (c5.h) this.f٧٢٤٦d.build().P();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f٧٢٥٢j;
    }

    public k e(Class cls) {
        k kVar = (k) this.f٧٢٤٨f.get(cls);
        if (kVar == null) {
            for (Map.Entry entry : this.f٧٢٤٨f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                }
            }
        }
        if (kVar == null) {
            return f٧٢٤٢k;
        }
        return kVar;
    }

    public o4.k f() {
        return this.f٧٢٤٩g;
    }

    public d g() {
        return this.f٧٢٥٠h;
    }

    public int h() {
        return this.f٧٢٥١i;
    }

    public g i() {
        return (g) this.f٧٢٤٤b.get();
    }
}
