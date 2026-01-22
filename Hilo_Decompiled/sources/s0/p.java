package s0;

import android.content.Context;
import java.util.ArrayList;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.SudLoadMGParamModel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p {

    /* renamed from: i, reason: collision with root package name */
    public static final String f١٧٥٨٨i = "SudGIP ".concat(p.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٧٥٨٩a;

    /* renamed from: b, reason: collision with root package name */
    public final int f١٧٥٩٠b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٧٥٩١c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f١٧٥٩٢d;

    /* renamed from: e, reason: collision with root package name */
    public GameInfo f١٧٥٩٣e;

    /* renamed from: f, reason: collision with root package name */
    public final m f١٧٥٩٤f;

    /* renamed from: g, reason: collision with root package name */
    public int f١٧٥٩٥g;

    /* renamed from: h, reason: collision with root package name */
    public e f١٧٥٩٦h;

    public p(Context context, SudLoadMGParamModel sudLoadMGParamModel, int i10, String str, q0.f fVar) {
        ArrayList arrayList = new ArrayList();
        this.f١٧٥٩٢d = arrayList;
        this.f١٧٥٩٥g = 0;
        o oVar = new o(this);
        this.f١٧٥٨٩a = context;
        this.f١٧٥٩٠b = i10;
        this.f١٧٥٩١c = str;
        this.f١٧٥٩٤f = fVar;
        gd.a aVar = gd.a.c;
        if (aVar != null) {
            arrayList.add(new k(context, sudLoadMGParamModel, aVar, oVar));
            gd.a aVar2 = gd.a.c;
            if (aVar2 != null) {
                arrayList.add(new u(context, aVar2, oVar));
                gd.a aVar3 = gd.a.c;
                if (aVar3 != null) {
                    arrayList.add(new i(context, aVar3, oVar));
                    return;
                }
                throw new IllegalStateException("SudGameRuntime hasn't been initialized");
            }
            throw new IllegalStateException("SudGameRuntime hasn't been initialized");
        }
        throw new IllegalStateException("SudGameRuntime hasn't been initialized");
    }
}
