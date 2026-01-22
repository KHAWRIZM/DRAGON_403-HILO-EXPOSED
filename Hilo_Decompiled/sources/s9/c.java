package s9;

import kotlin.io.encoding.Base64;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c implements BinaryEncoder, BinaryDecoder {

    /* renamed from: a, reason: collision with root package name */
    protected final byte f١٧٩١٧a = Base64.padSymbol;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٧٩١٨b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٧٩١٩c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f١٧٩٢٠d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٧٩٢١e;

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f١٧٩٢٢f;

    /* renamed from: g, reason: collision with root package name */
    protected int f١٧٩٢٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٧٩٢٤h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f١٧٩٢٥i;

    /* renamed from: j, reason: collision with root package name */
    protected int f١٧٩٢٦j;

    /* renamed from: k, reason: collision with root package name */
    protected int f١٧٩٢٧k;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i10, int i11, int i12, int i13) {
        int i14;
        this.f١٧٩١٨b = i10;
        this.f١٧٩١٩c = i11;
        if (i12 > 0 && i13 > 0) {
            i14 = (i12 / i11) * i11;
        } else {
            i14 = 0;
        }
        this.f١٧٩٢٠d = i14;
        this.f١٧٩٢١e = i13;
    }

    private void j() {
        this.f١٧٩٢٢f = null;
        this.f١٧٩٢٣g = 0;
        this.f١٧٩٢٤h = 0;
        this.f١٧٩٢٦j = 0;
        this.f١٧٩٢٧k = 0;
        this.f١٧٩٢٥i = false;
    }

    private void k() {
        byte[] bArr = this.f١٧٩٢٢f;
        if (bArr == null) {
            this.f١٧٩٢٢f = new byte[g()];
            this.f١٧٩٢٣g = 0;
            this.f١٧٩٢٤h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f١٧٩٢٢f = bArr2;
        }
    }

    int a() {
        if (this.f١٧٩٢٢f != null) {
            return this.f١٧٩٢٣g - this.f١٧٩٢٤h;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b10 : bArr) {
            if (61 == b10 || h(b10)) {
                return true;
            }
        }
        return false;
    }

    abstract void c(byte[] bArr, int i10, int i11);

    public byte[] d(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return d((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    abstract void e(byte[] bArr, int i10, int i11);

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i10) {
        byte[] bArr = this.f١٧٩٢٢f;
        if (bArr == null || bArr.length < this.f١٧٩٢٣g + i10) {
            k();
        }
    }

    protected int g() {
        return 8192;
    }

    protected abstract boolean h(byte b10);

    int i(byte[] bArr, int i10, int i11) {
        if (this.f١٧٩٢٢f != null) {
            int min = Math.min(a(), i11);
            System.arraycopy(this.f١٧٩٢٢f, this.f١٧٩٢٤h, bArr, i10, min);
            int i12 = this.f١٧٩٢٤h + min;
            this.f١٧٩٢٤h = i12;
            if (i12 >= this.f١٧٩٢٣g) {
                this.f١٧٩٢٢f = null;
            }
            return min;
        }
        if (this.f١٧٩٢٥i) {
            return -1;
        }
        return 0;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        e(bArr, 0, bArr.length);
        e(bArr, 0, -1);
        int i10 = this.f١٧٩٢٣g - this.f١٧٩٢٤h;
        byte[] bArr2 = new byte[i10];
        i(bArr2, 0, i10);
        return bArr2;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        j();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        c(bArr, 0, bArr.length);
        c(bArr, 0, -1);
        int i10 = this.f١٧٩٢٣g;
        byte[] bArr2 = new byte[i10];
        i(bArr2, 0, i10);
        return bArr2;
    }
}
