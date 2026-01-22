package w2;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected int f١٨٦٨٠a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f١٨٦٨١b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٨٦٨٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٨٦٨٣d;

    /* renamed from: e, reason: collision with root package name */
    d f١٨٦٨٤e = d.a();

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i10) {
        return i10 + this.f١٨٦٨١b.getInt(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i10) {
        if (i10 < this.f١٨٦٨٣d) {
            return this.f١٨٦٨١b.getShort(this.f١٨٦٨٢c + i10);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i10, ByteBuffer byteBuffer) {
        this.f١٨٦٨١b = byteBuffer;
        if (byteBuffer != null) {
            this.f١٨٦٨٠a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f١٨٦٨٢c = i11;
            this.f١٨٦٨٣d = this.f١٨٦٨١b.getShort(i11);
            return;
        }
        this.f١٨٦٨٠a = 0;
        this.f١٨٦٨٢c = 0;
        this.f١٨٦٨٣d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i10) {
        int i11 = i10 + this.f١٨٦٨٠a;
        return i11 + this.f١٨٦٨١b.getInt(i11) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i10) {
        int i11 = i10 + this.f١٨٦٨٠a;
        return this.f١٨٦٨١b.getInt(i11 + this.f١٨٦٨١b.getInt(i11));
    }
}
