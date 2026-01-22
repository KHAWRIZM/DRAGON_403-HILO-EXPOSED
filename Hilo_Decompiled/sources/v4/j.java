package v4;

import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final e f١٨٥١٤a = new e();

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o4.v decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(byteBuffer);
        return this.f١٨٥١٤a.a(createSource, i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
        return true;
    }
}
