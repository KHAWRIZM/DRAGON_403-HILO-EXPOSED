package t4;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements n {

    /* renamed from: a, reason: collision with root package name */
    private final d f١٨٠٥١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final d f١٨٠٥٢a;

        public a(d dVar) {
            this.f١٨٠٥٢a = dVar;
        }

        @Override // t4.o
        public final n build(r rVar) {
            return new g(this.f١٨٠٥٢a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends a {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements d {
            a() {
            }

            @Override // t4.g.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            @Override // t4.g.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor a(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // t4.g.d
            public Class getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        Object a(File file);

        void close(Object obj);

        Class getDataClass();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends a {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements d {
            a() {
            }

            @Override // t4.g.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) {
                inputStream.close();
            }

            @Override // t4.g.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream a(File file) {
                return new FileInputStream(file);
            }

            @Override // t4.g.d
            public Class getDataClass() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public g(d dVar) {
        this.f١٨٠٥١a = dVar;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(File file, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(file), new c(file, this.f١٨٠٥١a));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(File file) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c implements com.bumptech.glide.load.data.d {

        /* renamed from: a, reason: collision with root package name */
        private final File f١٨٠٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private final d f١٨٠٥٤b;

        /* renamed from: c, reason: collision with root package name */
        private Object f١٨٠٥٥c;

        c(File file, d dVar) {
            this.f١٨٠٥٣a = file;
            this.f١٨٠٥٤b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            Object obj = this.f١٨٠٥٥c;
            if (obj != null) {
                try {
                    this.f١٨٠٥٤b.close(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨٠٥٤b.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            try {
                Object a10 = this.f١٨٠٥٤b.a(this.f١٨٠٥٣a);
                this.f١٨٠٥٥c = a10;
                aVar.onDataReady(a10);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e10);
                }
                aVar.onLoadFailed(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
