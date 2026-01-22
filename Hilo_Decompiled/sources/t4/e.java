package t4;

import android.util.Base64;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e implements n {

    /* renamed from: a, reason: collision with root package name */
    private final a f١٨٠٣٥a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        void close(Object obj);

        Object decode(String str);

        Class getDataClass();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c implements o {

        /* renamed from: a, reason: collision with root package name */
        private final a f١٨٠٣٩a = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements a {
            a() {
            }

            @Override // t4.e.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) {
                inputStream.close();
            }

            @Override // t4.e.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }

            @Override // t4.e.a
            public Class getDataClass() {
                return InputStream.class;
            }
        }

        @Override // t4.o
        public n build(r rVar) {
            return new e(this.f١٨٠٣٩a);
        }
    }

    public e(a aVar) {
        this.f١٨٠٣٥a = aVar;
    }

    @Override // t4.n
    public n.a buildLoadData(Object obj, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(obj), new b(obj.toString(), this.f١٨٠٣٥a));
    }

    @Override // t4.n
    public boolean handles(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements com.bumptech.glide.load.data.d {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٨٠٣٦a;

        /* renamed from: b, reason: collision with root package name */
        private final a f١٨٠٣٧b;

        /* renamed from: c, reason: collision with root package name */
        private Object f١٨٠٣٨c;

        b(String str, a aVar) {
            this.f١٨٠٣٦a = str;
            this.f١٨٠٣٧b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            try {
                this.f١٨٠٣٧b.close(this.f١٨٠٣٨c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨٠٣٧b.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            try {
                Object decode = this.f١٨٠٣٧b.decode(this.f١٨٠٣٦a);
                this.f١٨٠٣٨c = decode;
                aVar.onDataReady(decode);
            } catch (IllegalArgumentException e10) {
                aVar.onLoadFailed(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
