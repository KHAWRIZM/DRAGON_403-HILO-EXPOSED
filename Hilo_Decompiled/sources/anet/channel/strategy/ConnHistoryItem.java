package anet.channel.strategy;

import com.qiahao.base_common.network.BaseServer;
import java.io.Serializable;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConnHistoryItem implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    byte f٤٩٤١a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f٤٩٤٢b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f٤٩٤٣c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z10 ? this.f٤٩٤٢b : this.f٤٩٤٣c) > BaseServer.TIMEOUT_DEBUG) {
            this.f٤٩٤١a = (byte) ((this.f٤٩٤١a << 1) | (!z10 ? 1 : 0));
            if (z10) {
                this.f٤٩٤٢b = currentTimeMillis;
            } else {
                this.f٤٩٤٣c = currentTimeMillis;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if ((this.f٤٩٤١a & 1) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        if (a() < 3 || System.currentTimeMillis() - this.f٤٩٤٣c > 300000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        long j10 = this.f٤٩٤٢b;
        long j11 = this.f٤٩٤٣c;
        if (j10 <= j11) {
            j10 = j11;
        }
        if (j10 != 0 && System.currentTimeMillis() - j10 > 86400000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i10 = 0;
        for (int i11 = this.f٤٩٤١a & UByte.MAX_VALUE; i11 > 0; i11 >>= 1) {
            i10 += i11 & 1;
        }
        return i10;
    }
}
