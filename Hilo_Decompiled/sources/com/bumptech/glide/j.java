package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import z4.b;
import z4.l;
import z4.p;
import z4.q;
import z4.s;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j implements ComponentCallbacks2, l {

    /* renamed from: m, reason: collision with root package name */
    private static final c5.h f٧٣٩٧m = (c5.h) c5.h.q0(Bitmap.class).P();

    /* renamed from: n, reason: collision with root package name */
    private static final c5.h f٧٣٩٨n = (c5.h) c5.h.q0(com.bumptech.glide.load.resource.gif.c.class).P();

    /* renamed from: o, reason: collision with root package name */
    private static final c5.h f٧٣٩٩o = (c5.h) ((c5.h) c5.h.r0(o4.j.f١٦٦٣٨c).Y(f.LOW)).h0(true);

    /* renamed from: a, reason: collision with root package name */
    protected final Glide f٧٤٠٠a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f٧٤٠١b;

    /* renamed from: c, reason: collision with root package name */
    final z4.j f٧٤٠٢c;

    /* renamed from: d, reason: collision with root package name */
    private final q f٧٤٠٣d;

    /* renamed from: e, reason: collision with root package name */
    private final p f٧٤٠٤e;

    /* renamed from: f, reason: collision with root package name */
    private final s f٧٤٠٥f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f٧٤٠٦g;

    /* renamed from: h, reason: collision with root package name */
    private final z4.b f٧٤٠٧h;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList f٧٤٠٨i;

    /* renamed from: j, reason: collision with root package name */
    private c5.h f٧٤٠٩j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٧٤١٠k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٧٤١١l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.f٧٤٠٢c.b(jVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final q f٧٤١٣a;

        c(q qVar) {
            this.f٧٤١٣a = qVar;
        }

        @Override // z4.b.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (j.this) {
                    this.f٧٤١٣a.e();
                }
            }
        }
    }

    public j(Glide glide, z4.j jVar, p pVar, Context context) {
        this(glide, jVar, pVar, new q(), glide.getConnectivityMonitorFactory(), context);
    }

    private synchronized void g() {
        try {
            Iterator it = this.f٧٤٠٥f.b().iterator();
            while (it.hasNext()) {
                f((com.bumptech.glide.request.target.j) it.next());
            }
            this.f٧٤٠٥f.a();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void y(com.bumptech.glide.request.target.j jVar) {
        boolean x10 = x(jVar);
        c5.d request = jVar.getRequest();
        if (!x10 && !this.f٧٤٠٠a.removeFromManagers(jVar) && request != null) {
            jVar.setRequest(null);
            request.clear();
        }
    }

    public i a(Class cls) {
        return new i(this.f٧٤٠٠a, this, cls, this.f٧٤٠١b);
    }

    public i b() {
        return a(Bitmap.class).a(f٧٣٩٧m);
    }

    public i c() {
        return a(Drawable.class);
    }

    public i d() {
        return a(File.class).a(c5.h.t0(true));
    }

    public void e(View view) {
        f(new b(view));
    }

    public void f(com.bumptech.glide.request.target.j jVar) {
        if (jVar == null) {
            return;
        }
        y(jVar);
    }

    public i h(Object obj) {
        return i().J0(obj);
    }

    public i i() {
        return a(File.class).a(f٧٣٩٩o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List j() {
        return this.f٧٤٠٨i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c5.h k() {
        return this.f٧٤٠٩j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k l(Class cls) {
        return this.f٧٤٠٠a.getGlideContext().e(cls);
    }

    public i m(Bitmap bitmap) {
        return c().G0(bitmap);
    }

    public i n(Uri uri) {
        return c().H0(uri);
    }

    public i o(Integer num) {
        return c().I0(num);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // z4.l
    public synchronized void onDestroy() {
        this.f٧٤٠٥f.onDestroy();
        g();
        this.f٧٤٠٣d.b();
        this.f٧٤٠٢c.a(this);
        this.f٧٤٠٢c.a(this.f٧٤٠٧h);
        f5.l.x(this.f٧٤٠٦g);
        this.f٧٤٠٠a.unregisterRequestManager(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // z4.l
    public synchronized void onStart() {
        u();
        this.f٧٤٠٥f.onStart();
    }

    @Override // z4.l
    public synchronized void onStop() {
        try {
            this.f٧٤٠٥f.onStop();
            if (this.f٧٤١١l) {
                g();
            } else {
                t();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f٧٤١٠k) {
            s();
        }
    }

    public i p(Object obj) {
        return c().J0(obj);
    }

    public i q(String str) {
        return c().K0(str);
    }

    public synchronized void r() {
        this.f٧٤٠٣d.c();
    }

    public synchronized void s() {
        r();
        Iterator it = this.f٧٤٠٤e.a().iterator();
        while (it.hasNext()) {
            ((j) it.next()).r();
        }
    }

    public synchronized void t() {
        this.f٧٤٠٣d.d();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f٧٤٠٣d + ", treeNode=" + this.f٧٤٠٤e + "}";
    }

    public synchronized void u() {
        this.f٧٤٠٣d.f();
    }

    protected synchronized void v(c5.h hVar) {
        this.f٧٤٠٩j = (c5.h) ((c5.h) hVar.clone()).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void w(com.bumptech.glide.request.target.j jVar, c5.d dVar) {
        this.f٧٤٠٥f.c(jVar);
        this.f٧٤٠٣d.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean x(com.bumptech.glide.request.target.j jVar) {
        c5.d request = jVar.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f٧٤٠٣d.a(request)) {
            this.f٧٤٠٥f.d(jVar);
            jVar.setRequest(null);
            return true;
        }
        return false;
    }

    j(Glide glide, z4.j jVar, p pVar, q qVar, z4.c cVar, Context context) {
        this.f٧٤٠٥f = new s();
        a aVar = new a();
        this.f٧٤٠٦g = aVar;
        this.f٧٤٠٠a = glide;
        this.f٧٤٠٢c = jVar;
        this.f٧٤٠٤e = pVar;
        this.f٧٤٠٣d = qVar;
        this.f٧٤٠١b = context;
        z4.b a10 = cVar.a(context.getApplicationContext(), new c(qVar));
        this.f٧٤٠٧h = a10;
        glide.registerRequestManager(this);
        if (f5.l.s()) {
            f5.l.w(aVar);
        } else {
            jVar.b(this);
        }
        jVar.b(a10);
        this.f٧٤٠٨i = new CopyOnWriteArrayList(glide.getGlideContext().c());
        v(glide.getGlideContext().d());
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b extends com.bumptech.glide.request.target.d {
        b(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.d
        protected void d(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.j
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.j
        public void onResourceReady(Object obj, d5.b bVar) {
        }
    }
}
