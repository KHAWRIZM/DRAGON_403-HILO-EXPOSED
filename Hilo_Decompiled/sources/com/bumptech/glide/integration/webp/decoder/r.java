package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class r {

    /* renamed from: s, reason: collision with root package name */
    public static final m4.h f٧٣٧١s = m4.h.f("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", q.f٧٣٦٠d);

    /* renamed from: a, reason: collision with root package name */
    private final j f٧٣٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f٧٣٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private final List f٧٣٧٤c;

    /* renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.j f٧٣٧٥d;

    /* renamed from: e, reason: collision with root package name */
    private final p4.d f٧٣٧٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٧٣٧٧f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٧٣٧٨g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٧٣٧٩h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.i f٧٣٨٠i;

    /* renamed from: j, reason: collision with root package name */
    private a f٧٣٨١j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٧٣٨٢k;

    /* renamed from: l, reason: collision with root package name */
    private a f٧٣٨٣l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f٧٣٨٤m;

    /* renamed from: n, reason: collision with root package name */
    private m4.m f٧٣٨٥n;

    /* renamed from: o, reason: collision with root package name */
    private a f٧٣٨٦o;

    /* renamed from: p, reason: collision with root package name */
    private int f٧٣٨٧p;

    /* renamed from: q, reason: collision with root package name */
    private int f٧٣٨٨q;

    /* renamed from: r, reason: collision with root package name */
    private int f٧٣٨٩r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends com.bumptech.glide.request.target.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f٧٣٩٠a;

        /* renamed from: b, reason: collision with root package name */
        final int f٧٣٩١b;

        /* renamed from: c, reason: collision with root package name */
        private final long f٧٣٩٢c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f٧٣٩٣d;

        a(Handler handler, int i10, long j10) {
            this.f٧٣٩٠a = handler;
            this.f٧٣٩١b = i10;
            this.f٧٣٩٢c = j10;
        }

        Bitmap a() {
            return this.f٧٣٩٣d;
        }

        @Override // com.bumptech.glide.request.target.j
        public void onLoadCleared(Drawable drawable) {
            this.f٧٣٩٣d = null;
        }

        @Override // com.bumptech.glide.request.target.j
        public void onResourceReady(Bitmap bitmap, d5.b bVar) {
            this.f٧٣٩٣d = bitmap;
            this.f٧٣٩٠a.sendMessageAtTime(this.f٧٣٩٠a.obtainMessage(1, this), this.f٧٣٩٢c);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                r.this.n((a) message.obj);
                return true;
            }
            if (i10 == 2) {
                r.this.f٧٣٧٥d.f((a) message.obj);
                return false;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e implements m4.f {

        /* renamed from: b, reason: collision with root package name */
        private final m4.f f٧٣٩٥b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٧٣٩٦c;

        e(m4.f fVar, int i10) {
            this.f٧٣٩٥b = fVar;
            this.f٧٣٩٦c = i10;
        }

        @Override // m4.f
        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (!this.f٧٣٩٥b.equals(eVar.f٧٣٩٥b) || this.f٧٣٩٦c != eVar.f٧٣٩٦c) {
                return false;
            }
            return true;
        }

        @Override // m4.f
        public int hashCode() {
            return (this.f٧٣٩٥b.hashCode() * 31) + this.f٧٣٩٦c;
        }

        @Override // m4.f
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.f٧٣٩٦c).array());
            this.f٧٣٩٥b.updateDiskCacheKey(messageDigest);
        }
    }

    public r(Glide glide, j jVar, int i10, int i11, m4.m mVar, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), jVar, null, j(Glide.with(glide.getContext()), i10, i11), mVar, bitmap);
    }

    private m4.f g(int i10) {
        return new e(new e5.d(this.f٧٣٧٢a), i10);
    }

    private static com.bumptech.glide.i j(com.bumptech.glide.j jVar, int i10, int i11) {
        return jVar.b().a(((c5.h) ((c5.h) c5.h.r0(o4.j.f١٦٦٣٧b).o0(true)).h0(true)).W(i10, i11));
    }

    private void m() {
        boolean z10;
        if (this.f٧٣٧٧f && !this.f٧٣٧٨g) {
            if (this.f٧٣٧٩h) {
                if (this.f٧٣٨٦o == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                f5.k.a(z10, "Pending target must be null when starting from the first frame");
                this.f٧٣٧٢a.f();
                this.f٧٣٧٩h = false;
            }
            a aVar = this.f٧٣٨٦o;
            if (aVar != null) {
                this.f٧٣٨٦o = null;
                n(aVar);
                return;
            }
            this.f٧٣٧٨g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f٧٣٧٢a.e();
            this.f٧٣٧٢a.b();
            int g10 = this.f٧٣٧٢a.g();
            this.f٧٣٨٣l = new a(this.f٧٣٧٣b, g10, uptimeMillis);
            this.f٧٣٨٠i.a((c5.h) c5.h.s0(g(g10)).h0(this.f٧٣٧٢a.l().c())).J0(this.f٧٣٧٢a).A0(this.f٧٣٨٣l);
        }
    }

    private void o() {
        Bitmap bitmap = this.f٧٣٨٤m;
        if (bitmap != null) {
            this.f٧٣٧٦e.d(bitmap);
            this.f٧٣٨٤m = null;
        }
    }

    private void q() {
        if (this.f٧٣٧٧f) {
            return;
        }
        this.f٧٣٧٧f = true;
        this.f٧٣٨٢k = false;
        m();
    }

    private void r() {
        this.f٧٣٧٧f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f٧٣٧٤c.clear();
        o();
        r();
        a aVar = this.f٧٣٨١j;
        if (aVar != null) {
            this.f٧٣٧٥d.f(aVar);
            this.f٧٣٨١j = null;
        }
        a aVar2 = this.f٧٣٨٣l;
        if (aVar2 != null) {
            this.f٧٣٧٥d.f(aVar2);
            this.f٧٣٨٣l = null;
        }
        a aVar3 = this.f٧٣٨٦o;
        if (aVar3 != null) {
            this.f٧٣٧٥d.f(aVar3);
            this.f٧٣٨٦o = null;
        }
        this.f٧٣٧٢a.clear();
        this.f٧٣٨٢k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f٧٣٧٢a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f٧٣٨١j;
        if (aVar != null) {
            return aVar.a();
        }
        return this.f٧٣٨٤m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f٧٣٨١j;
        if (aVar != null) {
            return aVar.f٧٣٩١b;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f٧٣٨٤m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f٧٣٧٢a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f٧٣٨٩r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f٧٣٧٢a.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f٧٣٧٢a.h() + this.f٧٣٨٧p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f٧٣٨٨q;
    }

    void n(a aVar) {
        this.f٧٣٧٨g = false;
        if (this.f٧٣٨٢k) {
            this.f٧٣٧٣b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f٧٣٧٧f) {
            if (this.f٧٣٧٩h) {
                this.f٧٣٧٣b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f٧٣٨٦o = aVar;
                return;
            }
        }
        if (aVar.a() != null) {
            o();
            a aVar2 = this.f٧٣٨١j;
            this.f٧٣٨١j = aVar;
            for (int size = this.f٧٣٧٤c.size() - 1; size >= 0; size--) {
                try {
                    b bVar = (b) this.f٧٣٧٤c.get(size);
                    if (bVar != null) {
                        bVar.a();
                    }
                } catch (IndexOutOfBoundsException e10) {
                    e10.printStackTrace();
                }
            }
            if (aVar2 != null) {
                this.f٧٣٧٣b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(m4.m mVar, Bitmap bitmap) {
        this.f٧٣٨٥n = (m4.m) f5.k.d(mVar);
        this.f٧٣٨٤m = (Bitmap) f5.k.d(bitmap);
        this.f٧٣٨٠i = this.f٧٣٨٠i.a(new c5.h().k0(mVar));
        this.f٧٣٨٧p = f5.l.i(bitmap);
        this.f٧٣٨٨q = bitmap.getWidth();
        this.f٧٣٨٩r = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(b bVar) {
        if (!this.f٧٣٨٢k) {
            if (!this.f٧٣٧٤c.contains(bVar)) {
                boolean isEmpty = this.f٧٣٧٤c.isEmpty();
                this.f٧٣٧٤c.add(bVar);
                if (isEmpty) {
                    q();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void setOnEveryFrameReadyListener(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(b bVar) {
        this.f٧٣٧٤c.remove(bVar);
        if (this.f٧٣٧٤c.isEmpty()) {
            r();
        }
    }

    r(p4.d dVar, com.bumptech.glide.j jVar, j jVar2, Handler handler, com.bumptech.glide.i iVar, m4.m mVar, Bitmap bitmap) {
        this.f٧٣٧٤c = new ArrayList();
        this.f٧٣٧٧f = false;
        this.f٧٣٧٨g = false;
        this.f٧٣٧٩h = false;
        this.f٧٣٧٥d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f٧٣٧٦e = dVar;
        this.f٧٣٧٣b = handler;
        this.f٧٣٨٠i = iVar;
        this.f٧٣٧٢a = jVar2;
        p(mVar, bitmap);
    }
}
