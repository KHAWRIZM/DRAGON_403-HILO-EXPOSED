package e5;

import android.content.Context;
import f5.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import m4.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements f {

    /* renamed from: b, reason: collision with root package name */
    private final int f١٣٨٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private final f f١٣٨٨٤c;

    private a(int i10, f fVar) {
        this.f١٣٨٨٣b = i10;
        this.f١٣٨٨٤c = fVar;
    }

    public static f a(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f١٣٨٨٣b != aVar.f١٣٨٨٣b || !this.f١٣٨٨٤c.equals(aVar.f١٣٨٨٤c)) {
            return false;
        }
        return true;
    }

    @Override // m4.f
    public int hashCode() {
        return l.q(this.f١٣٨٨٤c, this.f١٣٨٨٣b);
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f١٣٨٨٤c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f١٣٨٨٣b).array());
    }
}
