package v4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
interface a0 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.k f١٨٤٧١a;

        /* renamed from: b, reason: collision with root package name */
        private final p4.b f١٨٤٧٢b;

        /* renamed from: c, reason: collision with root package name */
        private final List f١٨٤٧٣c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(InputStream inputStream, List list, p4.b bVar) {
            this.f١٨٤٧٢b = (p4.b) f5.k.d(bVar);
            this.f١٨٤٧٣c = (List) f5.k.d(list);
            this.f١٨٤٧١a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // v4.a0
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f١٨٤٧١a.a(), null, options);
        }

        @Override // v4.a0
        public void b() {
            this.f١٨٤٧١a.b();
        }

        @Override // v4.a0
        public int c() {
            return com.bumptech.glide.load.a.b(this.f١٨٤٧٣c, this.f١٨٤٧١a.a(), this.f١٨٤٧٢b);
        }

        @Override // v4.a0
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.f(this.f١٨٤٧٣c, this.f١٨٤٧١a.a(), this.f١٨٤٧٢b);
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void b();

    int c();

    ImageHeaderParser.ImageType d();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f١٨٤٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private final List f١٨٤٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private final p4.b f١٨٤٧٠c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ByteBuffer byteBuffer, List list, p4.b bVar) {
            this.f١٨٤٦٨a = byteBuffer;
            this.f١٨٤٦٩b = list;
            this.f١٨٤٧٠c = bVar;
        }

        private InputStream e() {
            return f5.a.g(f5.a.d(this.f١٨٤٦٨a));
        }

        @Override // v4.a0
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // v4.a0
        public int c() {
            return com.bumptech.glide.load.a.c(this.f١٨٤٦٩b, f5.a.d(this.f١٨٤٦٨a), this.f١٨٤٧٠c);
        }

        @Override // v4.a0
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.g(this.f١٨٤٦٩b, f5.a.d(this.f١٨٤٦٨a));
        }

        @Override // v4.a0
        public void b() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c implements a0 {

        /* renamed from: a, reason: collision with root package name */
        private final p4.b f١٨٤٧٤a;

        /* renamed from: b, reason: collision with root package name */
        private final List f١٨٤٧٥b;

        /* renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f١٨٤٧٦c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(ParcelFileDescriptor parcelFileDescriptor, List list, p4.b bVar) {
            this.f١٨٤٧٤a = (p4.b) f5.k.d(bVar);
            this.f١٨٤٧٥b = (List) f5.k.d(list);
            this.f١٨٤٧٦c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // v4.a0
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f١٨٤٧٦c.a().getFileDescriptor(), null, options);
        }

        @Override // v4.a0
        public int c() {
            return com.bumptech.glide.load.a.a(this.f١٨٤٧٥b, this.f١٨٤٧٦c, this.f١٨٤٧٤a);
        }

        @Override // v4.a0
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.f١٨٤٧٥b, this.f١٨٤٧٦c, this.f١٨٤٧٤a);
        }

        @Override // v4.a0
        public void b() {
        }
    }
}
