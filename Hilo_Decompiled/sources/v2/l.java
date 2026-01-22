package v2;

import android.util.AndroidRuntimeException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import v2.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l extends h {

    /* renamed from: B, reason: collision with root package name */
    private m f١٨٣٨٩B;
    private float C;
    private boolean D;

    public l(j jVar) {
        super(jVar);
        this.f١٨٣٨٩B = null;
        this.C = Float.MAX_VALUE;
        this.D = false;
    }

    private void x() {
        m mVar = this.f١٨٣٨٩B;
        if (mVar != null) {
            double b10 = mVar.b();
            if (b10 <= this.f١٨٣٧٦g) {
                if (b10 >= this.f١٨٣٧٧h) {
                    return;
                } else {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    @Override // v2.h
    public void r() {
        x();
        this.f١٨٣٨٩B.i(g());
        super.r();
    }

    @Override // v2.h
    boolean t(long j10) {
        if (this.D) {
            float f10 = this.C;
            if (f10 != Float.MAX_VALUE) {
                this.f١٨٣٨٩B.g(f10);
                this.C = Float.MAX_VALUE;
            }
            this.f١٨٣٧١b = this.f١٨٣٨٩B.b();
            this.f١٨٣٧٠a = DownloadProgress.UNKNOWN_PROGRESS;
            this.D = false;
            return true;
        }
        if (this.C != Float.MAX_VALUE) {
            long j11 = j10 / 2;
            h.p j12 = this.f١٨٣٨٩B.j(this.f١٨٣٧١b, this.f١٨٣٧٠a, j11);
            this.f١٨٣٨٩B.g(this.C);
            this.C = Float.MAX_VALUE;
            h.p j13 = this.f١٨٣٨٩B.j(j12.f١٨٣٨٥a, j12.f١٨٣٨٦b, j11);
            this.f١٨٣٧١b = j13.f١٨٣٨٥a;
            this.f١٨٣٧٠a = j13.f١٨٣٨٦b;
        } else {
            h.p j14 = this.f١٨٣٨٩B.j(this.f١٨٣٧١b, this.f١٨٣٧٠a, j10);
            this.f١٨٣٧١b = j14.f١٨٣٨٥a;
            this.f١٨٣٧٠a = j14.f١٨٣٨٦b;
        }
        float max = Math.max(this.f١٨٣٧١b, this.f١٨٣٧٧h);
        this.f١٨٣٧١b = max;
        float min = Math.min(max, this.f١٨٣٧٦g);
        this.f١٨٣٧١b = min;
        if (!w(min, this.f١٨٣٧٠a)) {
            return false;
        }
        this.f١٨٣٧١b = this.f١٨٣٨٩B.b();
        this.f١٨٣٧٠a = DownloadProgress.UNKNOWN_PROGRESS;
        return true;
    }

    public void u(float f10) {
        if (h()) {
            this.C = f10;
            return;
        }
        if (this.f١٨٣٨٩B == null) {
            this.f١٨٣٨٩B = new m(f10);
        }
        this.f١٨٣٨٩B.g(f10);
        r();
    }

    public boolean v() {
        if (this.f١٨٣٨٩B.f١٨٣٩١b > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return true;
        }
        return false;
    }

    boolean w(float f10, float f11) {
        return this.f١٨٣٨٩B.e(f10, f11);
    }

    public l y(m mVar) {
        this.f١٨٣٨٩B = mVar;
        return this;
    }

    public void z() {
        if (v()) {
            if (e().j()) {
                if (this.f١٨٣٧٥f) {
                    this.D = true;
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public l(Object obj, i iVar) {
        super(obj, iVar);
        this.f١٨٣٨٩B = null;
        this.C = Float.MAX_VALUE;
        this.D = false;
    }

    @Override // v2.h
    void q(float f10) {
    }
}
