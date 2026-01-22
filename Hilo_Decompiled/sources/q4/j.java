package q4;

import androidx.core.util.Pools;
import f5.k;
import f5.l;
import g5.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final f5.h f١٧١٥٤a = new f5.h(1000);

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool f١٧١٥٥b = g5.a.d(10, new a());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements a.d {
        a() {
        }

        @Override // g5.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        final MessageDigest f١٧١٥٧a;

        /* renamed from: b, reason: collision with root package name */
        private final g5.c f١٧١٥٨b = g5.c.a();

        b(MessageDigest messageDigest) {
            this.f١٧١٥٧a = messageDigest;
        }

        @Override // g5.a.f
        public g5.c a() {
            return this.f١٧١٥٨b;
        }
    }

    private String a(m4.f fVar) {
        b bVar = (b) k.d(this.f١٧١٥٥b.acquire());
        try {
            fVar.updateDiskCacheKey(bVar.f١٧١٥٧a);
            return l.y(bVar.f١٧١٥٧a.digest());
        } finally {
            this.f١٧١٥٥b.release(bVar);
        }
    }

    public String b(m4.f fVar) {
        String str;
        synchronized (this.f١٧١٥٤a) {
            str = (String) this.f١٧١٥٤a.j(fVar);
        }
        if (str == null) {
            str = a(fVar);
        }
        synchronized (this.f١٧١٥٤a) {
            this.f١٧١٥٤a.m(fVar, str);
        }
        return str;
    }
}
