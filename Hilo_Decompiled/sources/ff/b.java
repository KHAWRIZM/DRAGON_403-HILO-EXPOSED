package ff;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b extends AssertionError {
    private static final long serialVersionUID = 1;
    private String a;
    private String b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ff.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class C٠٠٥٠b {
        private final int a;
        private final String b;
        private final String c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ff.b$b$a */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public class a {
            private final String a;
            private final String b;

            private String e(String str) {
                return "[" + str.substring(this.a.length(), str.length() - this.b.length()) + "]";
            }

            public String a() {
                return e(C٠٠٥٠b.this.c);
            }

            public String b() {
                if (this.a.length() <= C٠٠٥٠b.this.a) {
                    return this.a;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("...");
                String str = this.a;
                sb2.append(str.substring(str.length() - C٠٠٥٠b.this.a));
                return sb2.toString();
            }

            public String c() {
                if (this.b.length() <= C٠٠٥٠b.this.a) {
                    return this.b;
                }
                return this.b.substring(0, C٠٠٥٠b.this.a) + "...";
            }

            public String d() {
                return e(C٠٠٥٠b.this.b);
            }

            private a() {
                String g = C٠٠٥٠b.this.g();
                this.a = g;
                this.b = C٠٠٥٠b.this.h(g);
            }
        }

        public C٠٠٥٠b(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            int min = Math.min(this.b.length(), this.c.length());
            for (int i = 0; i < min; i++) {
                if (this.b.charAt(i) != this.c.charAt(i)) {
                    return this.b.substring(0, i);
                }
            }
            return this.b.substring(0, min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h(String str) {
            int min = Math.min(this.b.length() - str.length(), this.c.length() - str.length()) - 1;
            int i = 0;
            while (i <= min) {
                if (this.b.charAt((r1.length() - 1) - i) != this.c.charAt((r2.length() - 1) - i)) {
                    break;
                }
                i++;
            }
            String str2 = this.b;
            return str2.substring(str2.length() - i);
        }

        public String f(String str) {
            String str2;
            String str3 = this.b;
            if (str3 != null && (str2 = this.c) != null && !str3.equals(str2)) {
                a aVar = new a();
                String b = aVar.b();
                String c = aVar.c();
                return ff.a.i(str, b + aVar.d() + c, b + aVar.a() + c);
            }
            return ff.a.i(str, this.b, this.c);
        }
    }

    public b(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new C٠٠٥٠b(20, this.a, this.b).f(super.getMessage());
    }
}
