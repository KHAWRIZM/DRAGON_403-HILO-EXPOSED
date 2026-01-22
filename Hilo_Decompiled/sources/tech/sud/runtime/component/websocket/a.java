package tech.sud.runtime.component.websocket;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;

    public a(String str) {
        String str2 = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        try {
            this.a = str;
            int indexOf = str.indexOf(58);
            this.b = str.substring(0, indexOf);
            String substring = str.substring(indexOf + 1);
            this.d = substring;
            if (substring.startsWith("//")) {
                this.d = this.d.substring(2);
            }
            int indexOf2 = this.d.indexOf(35);
            if (indexOf2 != -1) {
                this.d = this.d.substring(0, indexOf2);
            }
            int indexOf3 = this.d.indexOf(63);
            if (indexOf3 != -1) {
                this.f = this.d.substring(indexOf3 + 1);
                this.d = this.d.substring(0, indexOf3);
            }
            int indexOf4 = this.d.indexOf(47);
            if (indexOf4 != -1) {
                this.e = this.d.substring(indexOf4);
                this.d = this.d.substring(0, indexOf4);
            }
            int indexOf5 = this.d.indexOf(64);
            if (indexOf5 != -1) {
                this.c = this.d.substring(0, indexOf5);
                this.d = this.d.substring(indexOf5 + 1);
            }
            if (this.d.indexOf(91) == 0) {
                int indexOf6 = this.d.indexOf(93);
                if (indexOf6 != -1) {
                    int i = indexOf6 + 1;
                    if (this.d.indexOf(58, i) == i) {
                        str2 = this.d.substring(indexOf6 + 2);
                        this.d = this.d.substring(0, i);
                    }
                }
            } else {
                int indexOf7 = this.d.indexOf(58);
                if (indexOf7 != -1 && indexOf7 == this.d.lastIndexOf(58)) {
                    str2 = this.d.substring(indexOf7 + 1);
                    this.d = this.d.substring(0, indexOf7);
                }
            }
            if (str2 != null) {
                this.g = Integer.parseInt(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }
}
