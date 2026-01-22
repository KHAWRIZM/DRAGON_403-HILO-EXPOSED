package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import v4.e0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١٠٥a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f٧٤١٨a;

        C٠١٠٥a(InputStream inputStream) {
            this.f٧٤١٨a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.d(this.f٧٤١٨a);
            } finally {
                this.f٧٤١٨a.reset();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f٧٤١٩a;

        b(ByteBuffer byteBuffer) {
            this.f٧٤١٩a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.c(this.f٧٤١٩a);
            } finally {
                f5.a.d(this.f٧٤١٩a);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f٧٤٢٠a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p4.b f٧٤٢١b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, p4.b bVar) {
            this.f٧٤٢٠a = parcelFileDescriptorRewinder;
            this.f٧٤٢١b = bVar;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            e0 e0Var = null;
            try {
                e0 e0Var2 = new e0(new FileInputStream(this.f٧٤٢٠a.a().getFileDescriptor()), this.f٧٤٢١b);
                try {
                    ImageHeaderParser.ImageType d10 = imageHeaderParser.d(e0Var2);
                    e0Var2.release();
                    this.f٧٤٢٠a.a();
                    return d10;
                } catch (Throwable th) {
                    th = th;
                    e0Var = e0Var2;
                    if (e0Var != null) {
                        e0Var.release();
                    }
                    this.f٧٤٢٠a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f٧٤٢٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p4.b f٧٤٢٣b;

        d(ByteBuffer byteBuffer, p4.b bVar) {
            this.f٧٤٢٢a = byteBuffer;
            this.f٧٤٢٣b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.f٧٤٢٢a, this.f٧٤٢٣b);
            } finally {
                f5.a.d(this.f٧٤٢٢a);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f٧٤٢٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p4.b f٧٤٢٥b;

        e(InputStream inputStream, p4.b bVar) {
            this.f٧٤٢٤a = inputStream;
            this.f٧٤٢٥b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.a(this.f٧٤٢٤a, this.f٧٤٢٥b);
            } finally {
                this.f٧٤٢٤a.reset();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class f implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f٧٤٢٦a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p4.b f٧٤٢٧b;

        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, p4.b bVar) {
            this.f٧٤٢٦a = parcelFileDescriptorRewinder;
            this.f٧٤٢٧b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            e0 e0Var = null;
            try {
                e0 e0Var2 = new e0(new FileInputStream(this.f٧٤٢٦a.a().getFileDescriptor()), this.f٧٤٢٧b);
                try {
                    int a10 = imageHeaderParser.a(e0Var2, this.f٧٤٢٧b);
                    e0Var2.release();
                    this.f٧٤٢٦a.a();
                    return a10;
                } catch (Throwable th) {
                    th = th;
                    e0Var = e0Var2;
                    if (e0Var != null) {
                        e0Var.release();
                    }
                    this.f٧٤٢٦a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, p4.b bVar) {
        return d(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(List list, InputStream inputStream, p4.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, bVar));
    }

    public static int c(List list, ByteBuffer byteBuffer, p4.b bVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, bVar));
    }

    private static int d(List list, g gVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int a10 = gVar.a((ImageHeaderParser) list.get(i10));
            if (a10 != -1) {
                return a10;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, p4.b bVar) {
        return h(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    public static ImageHeaderParser.ImageType f(List list, InputStream inputStream, p4.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return h(list, new C٠١٠٥a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return h(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType h(List list, h hVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType a10 = hVar.a((ImageHeaderParser) list.get(i10));
            if (a10 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a10;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
