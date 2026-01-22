package t4;

import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements n {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC٠٢٣١b f١٨٠٢٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {

        /* renamed from: t4.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢٣٠a implements InterfaceC٠٢٣١b {
            C٠٢٣٠a() {
            }

            @Override // t4.b.InterfaceC٠٢٣١b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // t4.b.InterfaceC٠٢٣١b
            public Class getDataClass() {
                return ByteBuffer.class;
            }
        }

        @Override // t4.o
        public n build(r rVar) {
            return new b(new C٠٢٣٠a());
        }
    }

    /* renamed from: t4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠٢٣١b {
        Object a(byte[] bArr);

        Class getDataClass();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d implements o {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements InterfaceC٠٢٣١b {
            a() {
            }

            @Override // t4.b.InterfaceC٠٢٣١b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // t4.b.InterfaceC٠٢٣١b
            public Class getDataClass() {
                return InputStream.class;
            }
        }

        @Override // t4.o
        public n build(r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC٠٢٣١b r12) {
        this.f١٨٠٢٩a = r12;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(byte[] bArr, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(bArr), new c(bArr, this.f١٨٠٢٩a));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(byte[] bArr) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements com.bumptech.glide.load.data.d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f١٨٠٣١a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC٠٢٣١b f١٨٠٣٢b;

        c(byte[] bArr, InterfaceC٠٢٣١b r22) {
            this.f١٨٠٣١a = bArr;
            this.f١٨٠٣٢b = r22;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨٠٣٢b.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            aVar.onDataReady(this.f١٨٠٣٢b.a(this.f١٨٠٣١a));
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
