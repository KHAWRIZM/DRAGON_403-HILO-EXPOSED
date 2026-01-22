package v4;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import v4.u;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h0 implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final u f١٨٥٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.b f١٨٥٠١b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements u.b {

        /* renamed from: a, reason: collision with root package name */
        private final e0 f١٨٥٠٢a;

        /* renamed from: b, reason: collision with root package name */
        private final f5.d f١٨٥٠٣b;

        a(e0 e0Var, f5.d dVar) {
            this.f١٨٥٠٢a = e0Var;
            this.f١٨٥٠٣b = dVar;
        }

        @Override // v4.u.b
        public void a(p4.d dVar, Bitmap bitmap) {
            IOException a10 = this.f١٨٥٠٣b.a();
            if (a10 != null) {
                if (bitmap != null) {
                    dVar.d(bitmap);
                    throw a10;
                }
                throw a10;
            }
        }

        @Override // v4.u.b
        public void b() {
            this.f١٨٥٠٢a.b();
        }
    }

    public h0(u uVar, p4.b bVar) {
        this.f١٨٥٠٠a = uVar;
        this.f١٨٥٠١b = bVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o4.v decode(InputStream inputStream, int i10, int i11, m4.i iVar) {
        e0 e0Var;
        boolean z10;
        if (inputStream instanceof e0) {
            e0Var = (e0) inputStream;
            z10 = false;
        } else {
            e0Var = new e0(inputStream, this.f١٨٥٠١b);
            z10 = true;
        }
        f5.d b10 = f5.d.b(e0Var);
        try {
            return this.f١٨٥٠٠a.e(new f5.i(b10), i10, i11, iVar, new a(e0Var, b10));
        } finally {
            b10.release();
            if (z10) {
                e0Var.release();
            }
        }
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(InputStream inputStream, m4.i iVar) {
        return this.f١٨٥٠٠a.p(inputStream);
    }
}
