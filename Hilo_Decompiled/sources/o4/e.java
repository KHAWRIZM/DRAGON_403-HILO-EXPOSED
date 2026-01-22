package o4;

import java.io.File;
import q4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class e implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final m4.d f١٦٥٦١a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f١٦٥٦٢b;

    /* renamed from: c, reason: collision with root package name */
    private final m4.i f١٦٥٦٣c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(m4.d dVar, Object obj, m4.i iVar) {
        this.f١٦٥٦١a = dVar;
        this.f١٦٥٦٢b = obj;
        this.f١٦٥٦٣c = iVar;
    }

    @Override // q4.a.b
    public boolean a(File file) {
        return this.f١٦٥٦١a.encode(this.f١٦٥٦٢b, file, this.f١٦٥٦٣c);
    }
}
