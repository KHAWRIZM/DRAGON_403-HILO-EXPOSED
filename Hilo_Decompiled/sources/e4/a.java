package e4;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements k5.a {

    /* renamed from: a, reason: collision with root package name */
    private List f١٣٨٨٠a;

    public a(List list) {
        this.f١٣٨٨٠a = list;
    }

    @Override // k5.a
    public int a() {
        return this.f١٣٨٨٠a.size();
    }

    @Override // k5.a
    public Object getItem(int i10) {
        if (i10 >= 0 && i10 < this.f١٣٨٨٠a.size()) {
            return this.f١٣٨٨٠a.get(i10);
        }
        return "";
    }
}
