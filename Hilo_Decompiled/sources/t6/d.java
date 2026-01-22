package t6;

import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;
import r6.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements r {

    /* renamed from: a, reason: collision with root package name */
    private final TimeWheelLayout f١٨١٣١a;

    public d(TimeWheelLayout timeWheelLayout) {
        this.f١٨١٣١a = timeWheelLayout;
    }

    @Override // r6.r
    public String a(int i10) {
        StringBuilder sb;
        String str;
        if (i10 < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i10);
        return sb.toString();
    }

    @Override // r6.r
    public String b(int i10) {
        StringBuilder sb;
        String str;
        if (this.f١٨١٣١a.p()) {
            if (i10 == 0) {
                i10 = 24;
            }
            if (i10 > 12) {
                i10 -= 12;
            }
        }
        if (i10 < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i10);
        return sb.toString();
    }

    @Override // r6.r
    public String c(int i10) {
        StringBuilder sb;
        String str;
        if (i10 < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i10);
        return sb.toString();
    }
}
