package anet.channel.monitor;

import anet.channel.util.ALog;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f٤٨٢٥a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f٤٨٢٦b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f٤٨٢٧c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f٤٨٢٨d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, long j10, long j11, long j12) {
        this.f٤٨٢٨d = bVar;
        this.f٤٨٢٥a = j10;
        this.f٤٨٢٦b = j11;
        this.f٤٨٢٧c = j12;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        int i10;
        e eVar2;
        int i11 = 5;
        b.f٤٨٠٩a++;
        b.f٤٨١٣e += this.f٤٨٢٥a;
        if (b.f٤٨٠٩a == 1) {
            b.f٤٨١٢d = this.f٤٨٢٦b - this.f٤٨٢٧c;
        }
        int i12 = b.f٤٨٠٩a;
        if (i12 >= 2 && i12 <= 3) {
            long j10 = this.f٤٨٢٧c;
            long j11 = b.f٤٨١١c;
            if (j10 >= j11) {
                b.f٤٨١٢d += this.f٤٨٢٦b - j10;
            } else if (j10 < j11) {
                long j12 = this.f٤٨٢٦b;
                if (j12 >= j11) {
                    long j13 = b.f٤٨١٢d + (j12 - j10);
                    b.f٤٨١٢d = j13;
                    b.f٤٨١٢d = j13 - (b.f٤٨١١c - j10);
                }
            }
        }
        b.f٤٨١٠b = this.f٤٨٢٧c;
        b.f٤٨١١c = this.f٤٨٢٦b;
        if (b.f٤٨٠٩a == 3) {
            eVar = this.f٤٨٢٨d.f٤٨٢٢n;
            b.f٤٨١٧i = (long) eVar.a(b.f٤٨١٣e, b.f٤٨١٢d);
            b.f٤٨١٤f++;
            b.b(this.f٤٨٢٨d);
            if (b.f٤٨١٤f > 30) {
                eVar2 = this.f٤٨٢٨d.f٤٨٢٢n;
                eVar2.a();
                b.f٤٨١٤f = 3L;
            }
            double d10 = (b.f٤٨١٧i * 0.68d) + (b.f٤٨١٦h * 0.27d) + (b.f٤٨١٥g * 0.05d);
            b.f٤٨١٥g = b.f٤٨١٦h;
            b.f٤٨١٦h = b.f٤٨١٧i;
            if (b.f٤٨١٧i < b.f٤٨١٥g * 0.65d || b.f٤٨١٧i > b.f٤٨١٥g * 2.0d) {
                b.f٤٨١٧i = d10;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f٤٨١٣e), "mKalmanTimeUsed", Long.valueOf(b.f٤٨١٢d), TransferTable.COLUMN_SPEED, Double.valueOf(b.f٤٨١٧i), "mSpeedKalmanCount", Long.valueOf(b.f٤٨١٤f));
            }
            i10 = this.f٤٨٢٨d.f٤٨٢١m;
            if (i10 > 5 || b.f٤٨١٤f == 2) {
                a.a().a(b.f٤٨١٧i);
                this.f٤٨٢٨d.f٤٨٢١m = 0;
                b bVar = this.f٤٨٢٨d;
                if (b.f٤٨١٧i < b.f٤٨١٨j) {
                    i11 = 1;
                }
                bVar.f٤٨٢٠l = i11;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f٤٨١٢d = 0L;
            b.f٤٨١٣e = 0L;
            b.f٤٨٠٩a = 0;
        }
    }
}
