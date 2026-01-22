package t4;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class x implements n {

    /* renamed from: b, reason: collision with root package name */
    private static final Set f١٨١٢٣b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* renamed from: a, reason: collision with root package name */
    private final c f١٨١٢٤a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements o, c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f١٨١٢٥a;

        public a(ContentResolver contentResolver) {
            this.f١٨١٢٥a = contentResolver;
        }

        @Override // t4.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f١٨١٢٥a, uri);
        }

        @Override // t4.o
        public n build(r rVar) {
            return new x(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements o, c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f١٨١٢٦a;

        public b(ContentResolver contentResolver) {
            this.f١٨١٢٦a = contentResolver;
        }

        @Override // t4.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f١٨١٢٦a, uri);
        }

        @Override // t4.o
        public n build(r rVar) {
            return new x(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        com.bumptech.glide.load.data.d a(Uri uri);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d implements o, c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f١٨١٢٧a;

        public d(ContentResolver contentResolver) {
            this.f١٨١٢٧a = contentResolver;
        }

        @Override // t4.x.c
        public com.bumptech.glide.load.data.d a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f١٨١٢٧a, uri);
        }

        @Override // t4.o
        public n build(r rVar) {
            return new x(this);
        }
    }

    public x(c cVar) {
        this.f١٨١٢٤a = cVar;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(uri), this.f١٨١٢٤a.a(uri));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return f١٨١٢٣b.contains(uri.getScheme());
    }
}
