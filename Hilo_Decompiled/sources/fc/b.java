package fc;

import androidx.collection.SimpleArrayMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private SimpleArrayMap f١٤٢٩٢a = new SimpleArrayMap();

    public void a(String str, int i10) {
        this.f١٤٢٩٢a.put(str, Integer.valueOf(i10));
    }

    @Override // fc.a
    public SimpleArrayMap getDefaultSkinAttrs() {
        return this.f١٤٢٩٢a;
    }
}
