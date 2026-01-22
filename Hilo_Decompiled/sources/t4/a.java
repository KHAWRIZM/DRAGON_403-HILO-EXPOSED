package t4;

import android.content.res.AssetManager;
import android.net.Uri;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements n {

    /* renamed from: c, reason: collision with root package name */
    private static final int f١٨٠٢٤c = 22;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f١٨٠٢٥a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC٠٢٢٩a f١٨٠٢٦b;

    /* renamed from: t4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠٢٢٩a {
        com.bumptech.glide.load.data.d a(AssetManager assetManager, String str);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements o, InterfaceC٠٢٢٩a {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f١٨٠٢٧a;

        public b(AssetManager assetManager) {
            this.f١٨٠٢٧a = assetManager;
        }

        @Override // t4.a.InterfaceC٠٢٢٩a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // t4.o
        public n build(r rVar) {
            return new a(this.f١٨٠٢٧a, this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements o, InterfaceC٠٢٢٩a {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f١٨٠٢٨a;

        public c(AssetManager assetManager) {
            this.f١٨٠٢٨a = assetManager;
        }

        @Override // t4.a.InterfaceC٠٢٢٩a
        public com.bumptech.glide.load.data.d a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // t4.o
        public n build(r rVar) {
            return new a(this.f١٨٠٢٨a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC٠٢٢٩a r22) {
        this.f١٨٠٢٥a = assetManager;
        this.f١٨٠٢٦b = r22;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(uri), this.f١٨٠٢٦b.a(this.f١٨٠٢٥a, uri.toString().substring(f١٨٠٢٤c)));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
