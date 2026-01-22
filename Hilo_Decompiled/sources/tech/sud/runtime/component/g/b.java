package tech.sud.runtime.component.g;

import java.io.EOFException;
import java.io.InputStream;
import org.apache.commons.codec.CharEncoding;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private int a;
    private int b;
    private byte[] c;

    public b(InputStream inputStream) {
        b(inputStream);
    }

    public static e a(InputStream inputStream) {
        e eVar = new e();
        eVar.a(new b(inputStream));
        return eVar;
    }

    private void b(InputStream inputStream) {
        byte[] a = c.a(inputStream);
        this.c = a;
        this.a = a.length;
        this.b = 0;
    }

    private byte g() {
        int i = this.b;
        if (i < this.a) {
            byte[] bArr = this.c;
            this.b = i + 1;
            return bArr[i];
        }
        throw new EOFException("Reached EOF, file size=" + this.a);
    }

    public int c() {
        return (int) ((((((d() << 8) + d()) << 8) + d()) << 8) + d());
    }

    public int d() {
        byte g = g();
        if (g < 0) {
            return g + 256;
        }
        return g;
    }

    public long e() {
        return (((((d() << 8) + d()) << 8) + d()) << 8) + d();
    }

    public int f() {
        return d() + (d() << 8);
    }

    public int a() {
        return this.b;
    }

    public String a(int i) {
        String str;
        int i2 = this.b;
        if (i + i2 <= this.a) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.c, i2, bArr, 0, i);
            this.b += i;
            if (i > 0 && bArr[0] == 0) {
                str = CharEncoding.UTF_16BE;
            } else {
                str = CharEncoding.ISO_8859_1;
            }
            return new String(bArr, str);
        }
        throw new EOFException("Reached EOF, file size=" + this.a);
    }

    public byte b() {
        return g();
    }

    public void b(long j) {
        a(this.b + j);
    }

    public String a(int i, int i2) {
        int i3 = this.b;
        if (i + i3 <= this.a) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.c, i3, bArr, 0, i);
            this.b += i;
            return new String(bArr, CharEncoding.UTF_16BE);
        }
        throw new EOFException("Reached EOF, file size=" + this.a);
    }

    public void a(long j) {
        if (j <= this.a && j >= 0) {
            this.b = (int) j;
            return;
        }
        throw new EOFException("Reached EOF, file size=" + this.a + " offset=" + j);
    }
}
