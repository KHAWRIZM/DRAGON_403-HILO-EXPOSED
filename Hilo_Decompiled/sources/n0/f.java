package n0;

import Sudif.Sudtry;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import w.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: i, reason: collision with root package name */
    public static volatile f f١٦١٣٦i;

    /* renamed from: a, reason: collision with root package name */
    public final w.a f١٦١٣٧a;

    /* renamed from: b, reason: collision with root package name */
    public final o f١٦١٣٨b;

    /* renamed from: c, reason: collision with root package name */
    public final r0.c f١٦١٣٩c;

    /* renamed from: d, reason: collision with root package name */
    public final l1.b f١٦١٤٠d;

    /* renamed from: e, reason: collision with root package name */
    public final g0.f f١٦١٤١e;

    /* renamed from: f, reason: collision with root package name */
    public final g0.c f١٦١٤٢f;

    /* renamed from: g, reason: collision with root package name */
    public final x.e f١٦١٤٣g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f١٦١٤٤h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [r0.d] */
    public f(Context context, w.a aVar, o oVar, r0.c cVar, l1.b bVar, g0.f fVar, g0.c cVar2, x.e eVar) {
        this.f١٦١٤٤h = context;
        this.f١٦١٣٧a = aVar;
        this.f١٦١٣٨b = oVar;
        this.f١٦١٣٩c = cVar;
        this.f١٦١٤٠d = bVar;
        this.f١٦١٤١e = fVar;
        this.f١٦١٤٢f = cVar2;
        this.f١٦١٤٣g = eVar;
        try {
            cVar = (r0.d) r0.c.class.getMethod("createRemitSelf", null).invoke(cVar, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        Objects.toString(cVar);
        aVar.f١٨٦٤٠i = cVar;
    }

    public static f a() {
        if (f١٦١٣٦i == null) {
            synchronized (f.class) {
                try {
                    if (f١٦١٣٦i == null) {
                        Context context = Sudtry.f٣٩a;
                        if (context != null) {
                            Context applicationContext = context.getApplicationContext();
                            w.a aVar = new w.a();
                            o oVar = new o();
                            r0.c cVar = new r0.c(applicationContext);
                            l1.b bVar = new l1.b();
                            f fVar = new f(applicationContext, aVar, oVar, cVar, bVar, new g0.f(), new g0.c(), new x.e());
                            Objects.toString(cVar);
                            Objects.toString(bVar);
                            f١٦١٣٦i = fVar;
                        } else {
                            throw new IllegalStateException("context == null");
                        }
                    }
                } finally {
                }
            }
        }
        return f١٦١٣٦i;
    }
}
