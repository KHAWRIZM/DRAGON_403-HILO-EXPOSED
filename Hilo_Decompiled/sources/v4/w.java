package v4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class w implements m4.m {

    /* renamed from: b, reason: collision with root package name */
    private final m4.m f١٨٥٦١b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٨٥٦٢c;

    public w(m4.m mVar, boolean z10) {
        this.f١٨٥٦١b = mVar;
        this.f١٨٥٦٢c = z10;
    }

    private o4.v b(Context context, o4.v vVar) {
        return c0.b(context.getResources(), vVar);
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof w) {
            return this.f١٨٥٦١b.equals(((w) obj).f١٨٥٦١b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f١٨٥٦١b.hashCode();
    }

    @Override // m4.m
    public o4.v transform(Context context, o4.v vVar, int i10, int i11) {
        p4.d bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = (Drawable) vVar.getEntity();
        o4.v a10 = v.a(bitmapPool, drawable, i10, i11);
        if (a10 == null) {
            if (!this.f١٨٥٦٢c) {
                return vVar;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        o4.v transform = this.f١٨٥٦١b.transform(context, a10, i10, i11);
        if (transform.equals(a10)) {
            transform.recycle();
            return vVar;
        }
        return b(context, transform);
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f١٨٥٦١b.updateDiskCacheKey(messageDigest);
    }

    public m4.m a() {
        return this;
    }
}
