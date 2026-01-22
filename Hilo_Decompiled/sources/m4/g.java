package m4;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements m {

    /* renamed from: b, reason: collision with root package name */
    private final Collection f١٥٩٧٣b;

    public g(m... mVarArr) {
        if (mVarArr.length != 0) {
            this.f١٥٩٧٣b = Arrays.asList(mVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f١٥٩٧٣b.equals(((g) obj).f١٥٩٧٣b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f١٥٩٧٣b.hashCode();
    }

    @Override // m4.m
    public v transform(Context context, v vVar, int i10, int i11) {
        Iterator it = this.f١٥٩٧٣b.iterator();
        v vVar2 = vVar;
        while (it.hasNext()) {
            v transform = ((m) it.next()).transform(context, vVar2, i10, i11);
            if (vVar2 != null && !vVar2.equals(vVar) && !vVar2.equals(transform)) {
                vVar2.recycle();
            }
            vVar2 = transform;
        }
        return vVar2;
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator it = this.f١٥٩٧٣b.iterator();
        while (it.hasNext()) {
            ((m) it.next()).updateDiskCacheKey(messageDigest);
        }
    }
}
