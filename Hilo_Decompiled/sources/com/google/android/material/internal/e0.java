package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e0 {

    /* renamed from: c, reason: collision with root package name */
    private float f٩٢٩٣c;

    /* renamed from: d, reason: collision with root package name */
    private float f٩٢٩٤d;

    /* renamed from: g, reason: collision with root package name */
    private c8.e f٩٢٩٧g;

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f٩٢٩١a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final c8.g f٩٢٩٢b = new a();

    /* renamed from: e, reason: collision with root package name */
    private boolean f٩٢٩٥e = true;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f٩٢٩٦f = new WeakReference(null);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends c8.g {
        a() {
        }

        @Override // c8.g
        public void a(int i10) {
            e0.this.f٩٢٩٥e = true;
            b bVar = (b) e0.this.f٩٢٩٦f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c8.g
        public void b(Typeface typeface, boolean z10) {
            if (!z10) {
                e0.this.f٩٢٩٥e = true;
                b bVar = (b) e0.this.f٩٢٩٦f.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public e0(b bVar) {
        j(bVar);
    }

    private float c(String str) {
        if (str == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return Math.abs(this.f٩٢٩١a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return this.f٩٢٩١a.measureText(charSequence, 0, charSequence.length());
    }

    private void i(String str) {
        this.f٩٢٩٣c = d(str);
        this.f٩٢٩٤d = c(str);
        this.f٩٢٩٥e = false;
    }

    public c8.e e() {
        return this.f٩٢٩٧g;
    }

    public float f(String str) {
        if (!this.f٩٢٩٥e) {
            return this.f٩٢٩٤d;
        }
        i(str);
        return this.f٩٢٩٤d;
    }

    public TextPaint g() {
        return this.f٩٢٩١a;
    }

    public float h(String str) {
        if (!this.f٩٢٩٥e) {
            return this.f٩٢٩٣c;
        }
        i(str);
        return this.f٩٢٩٣c;
    }

    public void j(b bVar) {
        this.f٩٢٩٦f = new WeakReference(bVar);
    }

    public void k(c8.e eVar, Context context) {
        if (this.f٩٢٩٧g != eVar) {
            this.f٩٢٩٧g = eVar;
            if (eVar != null) {
                eVar.q(context, this.f٩٢٩١a, this.f٩٢٩٢b);
                b bVar = (b) this.f٩٢٩٦f.get();
                if (bVar != null) {
                    this.f٩٢٩١a.drawableState = bVar.getState();
                }
                eVar.p(context, this.f٩٢٩١a, this.f٩٢٩٢b);
                this.f٩٢٩٥e = true;
            }
            b bVar2 = (b) this.f٩٢٩٦f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z10) {
        this.f٩٢٩٥e = z10;
    }

    public void m(boolean z10) {
        this.f٩٢٩٥e = z10;
    }

    public void n(Context context) {
        this.f٩٢٩٧g.p(context, this.f٩٢٩١a, this.f٩٢٩٢b);
    }
}
