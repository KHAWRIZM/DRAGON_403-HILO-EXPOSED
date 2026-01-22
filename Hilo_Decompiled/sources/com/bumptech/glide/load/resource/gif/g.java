package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import f5.k;
import f5.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import m4.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final l4.a f٧٤٨٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f٧٤٩٠b;

    /* renamed from: c, reason: collision with root package name */
    private final List f٧٤٩١c;

    /* renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.j f٧٤٩٢d;

    /* renamed from: e, reason: collision with root package name */
    private final p4.d f٧٤٩٣e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٧٤٩٤f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٧٤٩٥g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٧٤٩٦h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.i f٧٤٩٧i;

    /* renamed from: j, reason: collision with root package name */
    private a f٧٤٩٨j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٧٤٩٩k;

    /* renamed from: l, reason: collision with root package name */
    private a f٧٥٠٠l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f٧٥٠١m;

    /* renamed from: n, reason: collision with root package name */
    private m f٧٥٠٢n;

    /* renamed from: o, reason: collision with root package name */
    private a f٧٥٠٣o;

    /* renamed from: p, reason: collision with root package name */
    private int f٧٥٠٤p;

    /* renamed from: q, reason: collision with root package name */
    private int f٧٥٠٥q;

    /* renamed from: r, reason: collision with root package name */
    private int f٧٥٠٦r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends com.bumptech.glide.request.target.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f٧٥٠٧a;

        /* renamed from: b, reason: collision with root package name */
        final int f٧٥٠٨b;

        /* renamed from: c, reason: collision with root package name */
        private final long f٧٥٠٩c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f٧٥١٠d;

        a(Handler handler, int i10, long j10) {
            this.f٧٥٠٧a = handler;
            this.f٧٥٠٨b = i10;
            this.f٧٥٠٩c = j10;
        }

        Bitmap a() {
            return this.f٧٥١٠d;
        }

        @Override // com.bumptech.glide.request.target.j
        public void onLoadCleared(Drawable drawable) {
            this.f٧٥١٠d = null;
        }

        @Override // com.bumptech.glide.request.target.j
        public void onResourceReady(Bitmap bitmap, d5.b bVar) {
            this.f٧٥١٠d = bitmap;
            this.f٧٥٠٧a.sendMessageAtTime(this.f٧٥٠٧a.obtainMessage(1, this), this.f٧٥٠٩c);
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
                g.this.m((a) message.obj);
                return true;
            }
            if (i10 == 2) {
                g.this.f٧٤٩٢d.f((a) message.obj);
                return false;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface d {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Glide glide, l4.a aVar, int i10, int i11, m mVar, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), aVar, null, i(Glide.with(glide.getContext()), i10, i11), mVar, bitmap);
    }

    private static m4.f g() {
        return new e5.d(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.i i(com.bumptech.glide.j jVar, int i10, int i11) {
        return jVar.b().a(((c5.h) ((c5.h) c5.h.r0(o4.j.f١٦٦٣٧b).o0(true)).h0(true)).W(i10, i11));
    }

    private void l() {
        boolean z10;
        if (this.f٧٤٩٤f && !this.f٧٤٩٥g) {
            if (this.f٧٤٩٦h) {
                if (this.f٧٥٠٣o == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                k.a(z10, "Pending target must be null when starting from the first frame");
                this.f٧٤٨٩a.f();
                this.f٧٤٩٦h = false;
            }
            a aVar = this.f٧٥٠٣o;
            if (aVar != null) {
                this.f٧٥٠٣o = null;
                m(aVar);
                return;
            }
            this.f٧٤٩٥g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f٧٤٨٩a.e();
            this.f٧٤٨٩a.b();
            this.f٧٥٠٠l = new a(this.f٧٤٩٠b, this.f٧٤٨٩a.g(), uptimeMillis);
            this.f٧٤٩٧i.a(c5.h.s0(g())).J0(this.f٧٤٨٩a).A0(this.f٧٥٠٠l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f٧٥٠١m;
        if (bitmap != null) {
            this.f٧٤٩٣e.d(bitmap);
            this.f٧٥٠١m = null;
        }
    }

    private void p() {
        if (this.f٧٤٩٤f) {
            return;
        }
        this.f٧٤٩٤f = true;
        this.f٧٤٩٩k = false;
        l();
    }

    private void q() {
        this.f٧٤٩٤f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f٧٤٩١c.clear();
        n();
        q();
        a aVar = this.f٧٤٩٨j;
        if (aVar != null) {
            this.f٧٤٩٢d.f(aVar);
            this.f٧٤٩٨j = null;
        }
        a aVar2 = this.f٧٥٠٠l;
        if (aVar2 != null) {
            this.f٧٤٩٢d.f(aVar2);
            this.f٧٥٠٠l = null;
        }
        a aVar3 = this.f٧٥٠٣o;
        if (aVar3 != null) {
            this.f٧٤٩٢d.f(aVar3);
            this.f٧٥٠٣o = null;
        }
        this.f٧٤٨٩a.clear();
        this.f٧٤٩٩k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f٧٤٨٩a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f٧٤٩٨j;
        if (aVar != null) {
            return aVar.a();
        }
        return this.f٧٥٠١m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f٧٤٩٨j;
        if (aVar != null) {
            return aVar.f٧٥٠٨b;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f٧٥٠١m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f٧٤٨٩a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f٧٥٠٦r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f٧٤٨٩a.h() + this.f٧٥٠٤p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f٧٥٠٥q;
    }

    void m(a aVar) {
        this.f٧٤٩٥g = false;
        if (this.f٧٤٩٩k) {
            this.f٧٤٩٠b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f٧٤٩٤f) {
            if (this.f٧٤٩٦h) {
                this.f٧٤٩٠b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f٧٥٠٣o = aVar;
                return;
            }
        }
        if (aVar.a() != null) {
            n();
            a aVar2 = this.f٧٤٩٨j;
            this.f٧٤٩٨j = aVar;
            for (int size = this.f٧٤٩١c.size() - 1; size >= 0; size--) {
                ((b) this.f٧٤٩١c.get(size)).a();
            }
            if (aVar2 != null) {
                this.f٧٤٩٠b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(m mVar, Bitmap bitmap) {
        this.f٧٥٠٢n = (m) k.d(mVar);
        this.f٧٥٠١m = (Bitmap) k.d(bitmap);
        this.f٧٤٩٧i = this.f٧٤٩٧i.a(new c5.h().k0(mVar));
        this.f٧٥٠٤p = l.i(bitmap);
        this.f٧٥٠٥q = bitmap.getWidth();
        this.f٧٥٠٦r = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(b bVar) {
        if (!this.f٧٤٩٩k) {
            if (!this.f٧٤٩١c.contains(bVar)) {
                boolean isEmpty = this.f٧٤٩١c.isEmpty();
                this.f٧٤٩١c.add(bVar);
                if (isEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(b bVar) {
        this.f٧٤٩١c.remove(bVar);
        if (this.f٧٤٩١c.isEmpty()) {
            q();
        }
    }

    @VisibleForTesting
    void setOnEveryFrameReadyListener(d dVar) {
    }

    g(p4.d dVar, com.bumptech.glide.j jVar, l4.a aVar, Handler handler, com.bumptech.glide.i iVar, m mVar, Bitmap bitmap) {
        this.f٧٤٩١c = new ArrayList();
        this.f٧٤٩٢d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f٧٤٩٣e = dVar;
        this.f٧٤٩٠b = handler;
        this.f٧٤٩٧i = iVar;
        this.f٧٤٨٩a = aVar;
        o(mVar, bitmap);
    }
}
