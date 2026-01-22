package e0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f١٣٧٨٦a;

    public f0(Looper looper, p0 p0Var) {
        super(looper);
        this.f١٣٧٨٦a = p0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            b.f١٣٧٣٣i.post(new z(message));
                            return;
                        }
                        p0 p0Var = this.f١٣٧٨٦a;
                        Long l10 = (Long) message.obj;
                        p0Var.f١٣٨١٨k++;
                        long longValue = l10.longValue() + p0Var.f١٣٨١٢e;
                        p0Var.f١٣٨١٢e = longValue;
                        p0Var.f١٣٨١٥h = longValue / p0Var.f١٣٨١٨k;
                        return;
                    }
                    p0 p0Var2 = this.f١٣٧٨٦a;
                    long j10 = message.arg1;
                    p0Var2.f١٣٨٢٠m++;
                    long j11 = p0Var2.f١٣٨١٤g + j10;
                    p0Var2.f١٣٨١٤g = j11;
                    p0Var2.f١٣٨١٧j = j11 / p0Var2.f١٣٨١٩l;
                    return;
                }
                p0 p0Var3 = this.f١٣٧٨٦a;
                long j12 = message.arg1;
                int i11 = p0Var3.f١٣٨١٩l + 1;
                p0Var3.f١٣٨١٩l = i11;
                long j13 = p0Var3.f١٣٨١٣f + j12;
                p0Var3.f١٣٨١٣f = j13;
                p0Var3.f١٣٨١٦i = j13 / i11;
                return;
            }
            this.f١٣٧٨٦a.f١٣٨١١d++;
            return;
        }
        this.f١٣٧٨٦a.f١٣٨١٠c++;
    }
}
