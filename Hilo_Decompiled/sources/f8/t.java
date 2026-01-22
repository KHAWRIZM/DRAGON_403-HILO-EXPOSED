package f8;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class t extends s {

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٤٢٥٤f = false;

    /* renamed from: g, reason: collision with root package name */
    private float f١٤٢٥٥g = DownloadProgress.UNKNOWN_PROGRESS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            t tVar = t.this;
            if (tVar.f١٤٢٥١c != null && !tVar.f١٤٢٥٢d.isEmpty()) {
                t tVar2 = t.this;
                RectF rectF = tVar2.f١٤٢٥٢d;
                outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, tVar2.f١٤٢٥٥g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(View view) {
        n(view);
    }

    private float m() {
        RectF rectF;
        o oVar = this.f١٤٢٥١c;
        if (oVar != null && (rectF = this.f١٤٢٥٢d) != null) {
            return oVar.f١٤١٨٤f.a(rectF);
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private void n(View view) {
        view.setOutlineProvider(new a());
    }

    private boolean o() {
        o oVar;
        if (!this.f١٤٢٥٢d.isEmpty() && (oVar = this.f١٤٢٥١c) != null) {
            return oVar.v(this.f١٤٢٥٢d);
        }
        return false;
    }

    private boolean p() {
        o oVar;
        if (!this.f١٤٢٥٢d.isEmpty() && (oVar = this.f١٤٢٥١c) != null && this.f١٤٢٥٠b && !oVar.v(this.f١٤٢٥٢d) && q(this.f١٤٢٥١c)) {
            float a10 = this.f١٤٢٥١c.r().a(this.f١٤٢٥٢d);
            float a11 = this.f١٤٢٥١c.t().a(this.f١٤٢٥٢d);
            float a12 = this.f١٤٢٥١c.j().a(this.f١٤٢٥٢d);
            float a13 = this.f١٤٢٥١c.l().a(this.f١٤٢٥٢d);
            if (a10 == DownloadProgress.UNKNOWN_PROGRESS && a12 == DownloadProgress.UNKNOWN_PROGRESS && a11 == a13) {
                RectF rectF = this.f١٤٢٥٢d;
                rectF.set(rectF.left - a11, rectF.top, rectF.right, rectF.bottom);
                this.f١٤٢٥٥g = a11;
                return true;
            }
            if (a10 == DownloadProgress.UNKNOWN_PROGRESS && a11 == DownloadProgress.UNKNOWN_PROGRESS && a12 == a13) {
                RectF rectF2 = this.f١٤٢٥٢d;
                rectF2.set(rectF2.left, rectF2.top - a12, rectF2.right, rectF2.bottom);
                this.f١٤٢٥٥g = a12;
                return true;
            }
            if (a11 == DownloadProgress.UNKNOWN_PROGRESS && a13 == DownloadProgress.UNKNOWN_PROGRESS && a10 == a12) {
                RectF rectF3 = this.f١٤٢٥٢d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + a10, rectF3.bottom);
                this.f١٤٢٥٥g = a10;
                return true;
            }
            if (a12 == DownloadProgress.UNKNOWN_PROGRESS && a13 == DownloadProgress.UNKNOWN_PROGRESS && a10 == a11) {
                RectF rectF4 = this.f١٤٢٥٢d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + a10);
                this.f١٤٢٥٥g = a10;
                return true;
            }
        }
        return false;
    }

    private static boolean q(o oVar) {
        if ((oVar.q() instanceof n) && (oVar.s() instanceof n) && (oVar.i() instanceof n) && (oVar.k() instanceof n)) {
            return true;
        }
        return false;
    }

    @Override // f8.s
    void b(View view) {
        boolean z10;
        this.f١٤٢٥٥g = m();
        if (!o() && !p()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f١٤٢٥٤f = z10;
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // f8.s
    boolean j() {
        if (this.f١٤٢٥٤f && !this.f١٤٢٤٩a) {
            return false;
        }
        return true;
    }
}
