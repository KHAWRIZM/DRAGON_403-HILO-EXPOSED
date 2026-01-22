package t4;

import com.bumptech.glide.load.data.d;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class w implements n {

    /* renamed from: a, reason: collision with root package name */
    private static final w f١٨١٢٠a = new w();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private static final a f١٨١٢١a = new a();

        public static a a() {
            return f١٨١٢١a;
        }

        @Override // t4.o
        public n build(r rVar) {
            return w.a();
        }
    }

    public static w a() {
        return f١٨١٢٠a;
    }

    @Override // t4.n
    public n.a buildLoadData(Object obj, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(obj), new b(obj));
    }

    @Override // t4.n
    public boolean handles(Object obj) {
        return true;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b implements com.bumptech.glide.load.data.d {

        /* renamed from: a, reason: collision with root package name */
        private final Object f١٨١٢٢a;

        b(Object obj) {
            this.f١٨١٢٢a = obj;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨١٢٢a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            aVar.onDataReady(this.f١٨١٢٢a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
