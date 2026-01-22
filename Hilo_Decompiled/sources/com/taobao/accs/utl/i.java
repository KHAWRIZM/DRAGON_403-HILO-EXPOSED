package com.taobao.accs.utl;

import com.taobao.accs.utl.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class i implements k.a {
    private c[] a;
    private final int b;
    private String[] c;
    private long[] d;
    private int e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class a implements c {
        private String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.taobao.accs.utl.i.c
        public boolean a(String str) {
            if (str != null && str.contains(this.a)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class b {
        private static final i a = new i();

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface c {
        boolean a(String str);
    }

    public static i a() {
        return b.a;
    }

    private void b(String str) {
        int i = this.e % 5;
        this.c[i] = str;
        this.d[i] = System.currentTimeMillis() / 1000;
        this.e = i + 1;
    }

    private i() {
        this.b = 5;
        this.c = new String[5];
        this.d = new long[5];
        this.e = 0;
        for (int i = 0; i < 5; i++) {
            this.c[i] = null;
            this.d[i] = 0;
        }
        this.a = new c[]{new a("send msg time out"), new a("errorCode::"), new a("errorId::"), new a("TNET_JNI_ERR_LOAD_SO_FAIL")};
    }

    @Override // com.taobao.accs.utl.k.a
    public void a(String str) {
        try {
            if (a(str, this.a)) {
                b(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(String str, c[] cVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.a(str)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis() / 1000);
        sb2.append(" ");
        try {
            int i = ((this.e - 1) % 5) + 5;
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = (i - i2) % 5;
                if (this.c[i3] == null) {
                    break;
                }
                sb2.append(this.d[i3]);
                sb2.append(" ");
                sb2.append(this.c[i3]);
                sb2.append(" ");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb2.toString();
    }
}
