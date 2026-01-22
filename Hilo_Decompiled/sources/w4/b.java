package w4;

import f5.k;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements v {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f١٨٧١٨a;

    public b(byte[] bArr) {
        this.f١٨٧١٨a = (byte[]) k.d(bArr);
    }

    @Override // o4.v
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f١٨٧١٨a;
    }

    @Override // o4.v
    public Class getResourceClass() {
        return byte[].class;
    }

    @Override // o4.v
    public int getSize() {
        return this.f١٨٧١٨a.length;
    }

    @Override // o4.v
    public void recycle() {
    }
}
