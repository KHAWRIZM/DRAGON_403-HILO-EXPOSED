package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.google.android.material.R;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j extends g {

    /* renamed from: r, reason: collision with root package name */
    private h f٩٧٠١r;

    /* renamed from: s, reason: collision with root package name */
    private i f٩٧٠٢s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f٩٧٠٣t;

    j(Context context, a aVar, h hVar, i iVar) {
        super(context, aVar);
        B(hVar);
        A(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j v(Context context, e eVar, b bVar) {
        i cVar;
        if (eVar.f٩٦٤٨o == 1) {
            cVar = new d(context, eVar);
        } else {
            cVar = new c(eVar);
        }
        j jVar = new j(context, eVar, bVar, cVar);
        jVar.C(androidx.vectordrawable.graphics.drawable.j.b(context.getResources(), R.drawable.ic_mtrl_arrow_circle, null));
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j w(Context context, n nVar, k kVar) {
        i mVar;
        if (nVar.f٩٧٣٥o == 0) {
            mVar = new l(nVar);
        } else {
            mVar = new m(context, nVar);
        }
        return new j(context, nVar, kVar, mVar);
    }

    private boolean z() {
        b8.a aVar = this.f٩٦٦٦c;
        if (aVar == null || aVar.a(this.f٩٦٦٤a.getContentResolver()) != DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(i iVar) {
        this.f٩٧٠٢s = iVar;
        iVar.e(this);
    }

    void B(h hVar) {
        this.f٩٧٠١r = hVar;
    }

    public void C(Drawable drawable) {
        this.f٩٧٠٣t = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        boolean z11;
        Drawable drawable;
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.f٩٦٧٩p)) {
            if (z() && (drawable = this.f٩٧٠٣t) != null) {
                drawable.setBounds(getBounds());
                this.f٩٧٠٣t.setTint(this.f٩٦٦٥b.f٩٥٩٦e[0]);
                this.f٩٧٠٣t.draw(canvas);
                return;
            }
            canvas.save();
            this.f٩٧٠١r.h(canvas, getBounds(), h(), m(), l());
            int i10 = this.f٩٦٦٥b.f٩٦٠٠i;
            int alpha = getAlpha();
            a aVar = this.f٩٦٦٥b;
            if (!(aVar instanceof n) && (!(aVar instanceof e) || !((e) aVar).f٩٦٥٢s)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && i10 == 0 && !aVar.b(false)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.f٩٧٠١r.d(canvas, this.f٩٦٧٧n, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, this.f٩٦٦٥b.f٩٥٩٧f, alpha, 0);
            } else if (z10) {
                h.a aVar2 = (h.a) this.f٩٧٠٢s.f٩٧٠٠b.get(0);
                List list = this.f٩٧٠٢s.f٩٧٠٠b;
                h.a aVar3 = (h.a) list.get(list.size() - 1);
                h hVar = this.f٩٧٠١r;
                if (hVar instanceof k) {
                    hVar.d(canvas, this.f٩٦٧٧n, DownloadProgress.UNKNOWN_PROGRESS, aVar2.f٩٦٨٧a, this.f٩٦٦٥b.f٩٥٩٧f, alpha, i10);
                    this.f٩٧٠١r.d(canvas, this.f٩٦٧٧n, aVar3.f٩٦٨٨b, 1.0f, this.f٩٦٦٥b.f٩٥٩٧f, alpha, i10);
                } else {
                    canvas.save();
                    canvas.rotate(aVar3.f٩٦٩٣g);
                    this.f٩٧٠١r.d(canvas, this.f٩٦٧٧n, aVar3.f٩٦٨٨b, 1.0f + aVar2.f٩٦٨٧a, this.f٩٦٦٥b.f٩٥٩٧f, alpha, i10);
                    canvas.restore();
                }
            }
            for (int i11 = 0; i11 < this.f٩٧٠٢s.f٩٧٠٠b.size(); i11++) {
                h.a aVar4 = (h.a) this.f٩٧٠٢s.f٩٧٠٠b.get(i11);
                aVar4.f٩٦٩٢f = i();
                this.f٩٧٠١r.c(canvas, this.f٩٦٧٧n, aVar4, getAlpha());
                if (i11 > 0 && !z11 && z10) {
                    this.f٩٧٠١r.d(canvas, this.f٩٦٧٧n, ((h.a) this.f٩٧٠٢s.f٩٧٠٠b.get(i11 - 1)).f٩٦٨٨b, aVar4.f٩٦٨٧a, this.f٩٦٦٥b.f٩٥٩٧f, alpha, i10);
                }
            }
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٩٧٠١r.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٩٧٠١r.f();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ void o(androidx.vectordrawable.graphics.drawable.b bVar) {
        super.o(bVar);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean s(boolean z10, boolean z11, boolean z12) {
        return super.s(z10, z11, z12);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public boolean t(boolean z10, boolean z11, boolean z12) {
        Drawable drawable;
        boolean t10 = super.t(z10, z11, z12);
        if (z() && (drawable = this.f٩٧٠٣t) != null) {
            return drawable.setVisible(z10, z11);
        }
        if (!isRunning()) {
            this.f٩٧٠٢s.a();
        }
        if (z10 && (z12 || (Build.VERSION.SDK_INT <= 22 && !z()))) {
            this.f٩٧٠٢s.g();
        }
        return t10;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean u(androidx.vectordrawable.graphics.drawable.b bVar) {
        return super.u(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i x() {
        return this.f٩٧٠٢s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h y() {
        return this.f٩٧٠١r;
    }
}
