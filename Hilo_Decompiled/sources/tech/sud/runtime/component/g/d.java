package tech.sud.runtime.component.g;

import org.apache.commons.codec.CharEncoding;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d {
    private final byte[] a;
    private long b;
    private long c;

    public d() {
        this.a = new byte[4];
    }

    public long a() {
        return this.b;
    }

    public String toString() {
        return "Read dir tab [" + ((int) this.a[0]) + " " + ((int) this.a[1]) + " " + ((int) this.a[2]) + " " + ((int) this.a[3]) + "] offset: " + this.b + " bytesToUpload: " + this.c + " name: " + this.a;
    }

    public String a(b bVar) {
        this.a[0] = bVar.b();
        this.a[1] = bVar.b();
        this.a[2] = bVar.b();
        this.a[3] = bVar.b();
        bVar.b(4L);
        this.b = bVar.e();
        this.c = bVar.e();
        return new String(this.a, CharEncoding.ISO_8859_1);
    }

    public d(long j, long j2) {
        this.a = new byte[4];
        this.b = j;
        this.c = j2;
    }
}
