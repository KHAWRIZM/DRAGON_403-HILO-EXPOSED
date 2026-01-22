package tech.sud.runtime.core;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class h {
    private tech.sud.runtime.a.b a;

    public h(tech.sud.runtime.a.b bVar) {
        this.a = bVar;
    }

    public void onLog(int i, int i2, String str, String str2, String str3) {
        String str4;
        String str5;
        if (this.a != null) {
            String str6 = null;
            if (str == null) {
                str4 = null;
            } else {
                str4 = new String(str);
            }
            if (str2 == null) {
                str5 = null;
            } else {
                str5 = new String(str2);
            }
            if (str3 != null) {
                str6 = new String(str3);
            }
            this.a.a(i, i2, str4, str5, str6);
        }
    }
}
