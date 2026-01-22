package z4;

import android.content.Context;
import z4.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٩٤٣٨a;

    /* renamed from: b, reason: collision with root package name */
    final b.a f١٩٤٣٩b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, b.a aVar) {
        this.f١٩٤٣٨a = context.getApplicationContext();
        this.f١٩٤٣٩b = aVar;
    }

    private void a() {
        r.a(this.f١٩٤٣٨a).d(this.f١٩٤٣٩b);
    }

    private void b() {
        r.a(this.f١٩٤٣٨a).e(this.f١٩٤٣٩b);
    }

    @Override // z4.l
    public void onStart() {
        a();
    }

    @Override // z4.l
    public void onStop() {
        b();
    }

    @Override // z4.l
    public void onDestroy() {
    }
}
