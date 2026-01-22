package e0;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    public static final i0 f١٣٧٣٣i = new i0(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public static volatile b f١٣٧٣٤j = null;

    /* renamed from: a, reason: collision with root package name */
    public final List f١٣٧٣٥a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f١٣٧٣٦b;

    /* renamed from: c, reason: collision with root package name */
    public final c f١٣٧٣٧c;

    /* renamed from: d, reason: collision with root package name */
    public final r f١٣٧٣٨d;

    /* renamed from: e, reason: collision with root package name */
    public final p0 f١٣٧٣٩e;

    /* renamed from: f, reason: collision with root package name */
    public final WeakHashMap f١٣٧٤٠f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakHashMap f١٣٧٤١g;

    /* renamed from: h, reason: collision with root package name */
    public final ReferenceQueue f١٣٧٤٢h;

    public b(Context context, c cVar, r rVar, p0 p0Var) {
        this.f١٣٧٣٦b = context;
        this.f١٣٧٣٧c = cVar;
        this.f١٣٧٣٨d = rVar;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new r0(context));
        arrayList.add(new g(context));
        arrayList.add(new k0(context));
        arrayList.add(new n(context));
        arrayList.add(new s(context));
        arrayList.add(new f(context));
        arrayList.add(new b0(cVar.f١٣٧٤٧c, p0Var));
        this.f١٣٧٣٥a = Collections.unmodifiableList(arrayList);
        this.f١٣٧٣٩e = p0Var;
        this.f١٣٧٤٠f = new WeakHashMap();
        this.f١٣٧٤١g = new WeakHashMap();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.f١٣٧٤٢h = referenceQueue;
        new o0(referenceQueue, f١٣٧٣٣i).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Bitmap bitmap, int i10, u uVar, Exception exc) {
        if (uVar.f١٣٨٣٤h) {
            return;
        }
        if (!uVar.f١٣٨٣٣g) {
            this.f١٣٧٤٠f.remove(uVar.b());
        }
        if (bitmap != null) {
            if (i10 != 0) {
                h hVar = (h) uVar;
                ImageView imageView = (ImageView) hVar.f١٣٨٢٩c.get();
                if (imageView != null) {
                    k.b(imageView, hVar.f١٣٨٢٧a.f١٣٧٣٦b, bitmap, i10);
                    return;
                }
                return;
            }
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        uVar.a();
    }

    public final void b(Object obj) {
        u0.d();
        u uVar = (u) this.f١٣٧٤٠f.remove(obj);
        if (uVar != null) {
            ((h) uVar).f١٣٨٣٤h = true;
            a0 a0Var = this.f١٣٧٣٧c.f١٣٧٥٢h;
            a0Var.sendMessage(a0Var.obtainMessage(2, uVar));
        }
        if (obj instanceof ImageView) {
            if (this.f١٣٧٤١g.remove((ImageView) obj) == null) {
            } else {
                throw new ClassCastException();
            }
        }
    }
}
