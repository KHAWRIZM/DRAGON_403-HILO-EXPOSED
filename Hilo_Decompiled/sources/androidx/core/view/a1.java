package androidx.core.view;

import android.view.MotionEvent;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class a1 {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f٢٨٩٣a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f٢٨٩٤b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    private float f٢٨٩٥c = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: d, reason: collision with root package name */
    private int f٢٨٩٦d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f٢٨٩٧e = 0;

    private void b() {
        this.f٢٨٩٦d = 0;
        this.f٢٨٩٥c = DownloadProgress.UNKNOWN_PROGRESS;
    }

    private float e() {
        long[] jArr;
        long j10;
        int i10 = this.f٢٨٩٦d;
        if (i10 < 2) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        int i11 = this.f٢٨٩٧e;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.f٢٨٩٤b[i11];
        while (true) {
            jArr = this.f٢٨٩٤b;
            j10 = jArr[i12];
            if (j11 - j10 <= 100) {
                break;
            }
            this.f٢٨٩٦d--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.f٢٨٩٦d;
        if (i13 < 2) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            long j12 = jArr[i14];
            if (j10 == j12) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            return this.f٢٨٩٣a[i14] / ((float) (j12 - j10));
        }
        int i15 = 0;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i16 = 0; i16 < this.f٢٨٩٦d - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.f٢٨٩٤b;
            long j13 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j13) {
                i15++;
                float f11 = f(f10);
                float f12 = this.f٢٨٩٣a[i18] / ((float) (this.f٢٨٩٤b[i18] - j13));
                f10 += (f12 - f11) * Math.abs(f12);
                if (i15 == 1) {
                    f10 *= 0.5f;
                }
            }
        }
        return f(f10);
    }

    private static float f(float f10) {
        float f11;
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            f11 = -1.0f;
        } else {
            f11 = 1.0f;
        }
        return f11 * ((float) Math.sqrt(Math.abs(f10) * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f٢٨٩٦d != 0 && eventTime - this.f٢٨٩٤b[this.f٢٨٩٧e] > 40) {
            b();
        }
        int i10 = (this.f٢٨٩٧e + 1) % 20;
        this.f٢٨٩٧e = i10;
        int i11 = this.f٢٨٩٦d;
        if (i11 != 20) {
            this.f٢٨٩٦d = i11 + 1;
        }
        this.f٢٨٩٣a[i10] = motionEvent.getAxisValue(26);
        this.f٢٨٩٤b[this.f٢٨٩٧e] = eventTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i10, float f10) {
        float e10 = e() * i10;
        this.f٢٨٩٥c = e10;
        if (e10 < (-Math.abs(f10))) {
            this.f٢٨٩٥c = -Math.abs(f10);
        } else if (this.f٢٨٩٥c > Math.abs(f10)) {
            this.f٢٨٩٥c = Math.abs(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d(int i10) {
        if (i10 != 26) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return this.f٢٨٩٥c;
    }
}
