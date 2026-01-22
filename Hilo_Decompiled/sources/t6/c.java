package t6;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements r6.a {
    @Override // r6.a
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

    @Override // r6.a
    public String b(int i10) {
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

    @Override // r6.a
    public String c(int i10) {
        if (i10 < 1000) {
            i10 += 1000;
        }
        return "" + i10;
    }
}
