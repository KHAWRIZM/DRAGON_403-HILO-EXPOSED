package androidx.transition;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e0 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f٤٢٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f٤٢٧١b = new float[20];

    /* renamed from: c, reason: collision with root package name */
    private int f٤٢٧٢c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0() {
        long[] jArr = new long[20];
        this.f٤٢٧٠a = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float c(float f10) {
        return (float) (Math.signum(f10) * Math.sqrt(Math.abs(f10) * 2.0f));
    }

    public void a(long j10, float f10) {
        int i10 = (this.f٤٢٧٢c + 1) % 20;
        this.f٤٢٧٢c = i10;
        this.f٤٢٧٠a[i10] = j10;
        this.f٤٢٧١b[i10] = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        float c10;
        int i10 = this.f٤٢٧٢c;
        if (i10 == 0 && this.f٤٢٧٠a[i10] == Long.MIN_VALUE) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        long j10 = this.f٤٢٧٠a[i10];
        int i11 = 0;
        long j11 = j10;
        while (true) {
            long j12 = this.f٤٢٧٠a[i10];
            if (j12 == Long.MIN_VALUE) {
                break;
            }
            float f10 = (float) (j10 - j12);
            float abs = (float) Math.abs(j12 - j11);
            if (f10 > 100.0f || abs > 40.0f) {
                break;
            }
            if (i10 == 0) {
                i10 = 20;
            }
            i10--;
            i11++;
            if (i11 >= 20) {
                break;
            }
            j11 = j12;
        }
        if (i11 < 2) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (i11 == 2) {
            int i12 = this.f٤٢٧٢c;
            int i13 = i12 == 0 ? 19 : i12 - 1;
            long[] jArr = this.f٤٢٧٠a;
            float f11 = (float) (jArr[i12] - jArr[i13]);
            if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            float[] fArr = this.f٤٢٧١b;
            c10 = (fArr[i12] - fArr[i13]) / f11;
        } else {
            int i14 = this.f٤٢٧٢c;
            int i15 = ((i14 - i11) + 21) % 20;
            int i16 = (i14 + 21) % 20;
            long j13 = this.f٤٢٧٠a[i15];
            float f12 = this.f٤٢٧١b[i15];
            int i17 = i15 + 1;
            float f13 = DownloadProgress.UNKNOWN_PROGRESS;
            for (int i18 = i17 % 20; i18 != i16; i18 = (i18 + 1) % 20) {
                long j14 = this.f٤٢٧٠a[i18];
                float f14 = (float) (j14 - j13);
                if (f14 != DownloadProgress.UNKNOWN_PROGRESS) {
                    float f15 = this.f٤٢٧١b[i18];
                    float f16 = (f15 - f12) / f14;
                    f13 += (f16 - c(f13)) * Math.abs(f16);
                    if (i18 == i17) {
                        f13 *= 0.5f;
                    }
                    f12 = f15;
                    j13 = j14;
                }
            }
            c10 = c(f13);
        }
        return c10 * 1000.0f;
    }
}
