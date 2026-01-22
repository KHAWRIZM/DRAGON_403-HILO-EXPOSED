package j7;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class w0 implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f١٥٣٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f١٥٣٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f١٥٣٣٤c;

    public w0(ne.a aVar, ne.a aVar2, ne.a aVar3) {
        this.f١٥٣٣٢a = aVar;
        this.f١٥٣٣٣b = aVar2;
        this.f١٥٣٣٤c = aVar3;
    }

    public static w0 a(ne.a aVar, ne.a aVar2, ne.a aVar3) {
        return new w0(aVar, aVar2, aVar3);
    }

    public static v0 c(Context context, String str, int i10) {
        return new v0(context, str, i10);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v0 get() {
        return c((Context) this.f١٥٣٣٢a.get(), (String) this.f١٥٣٣٣b.get(), ((Integer) this.f١٥٣٣٤c.get()).intValue());
    }
}
