package r3;

import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class n implements m {

    /* renamed from: a, reason: collision with root package name */
    final List f١٧٣٣٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List list) {
        this.f١٧٣٣٩a = list;
    }

    @Override // r3.m
    public List b() {
        return this.f١٧٣٣٩a;
    }

    @Override // r3.m
    public boolean isStatic() {
        if (this.f١٧٣٣٩a.isEmpty()) {
            return true;
        }
        if (this.f١٧٣٣٩a.size() == 1 && ((y3.a) this.f١٧٣٣٩a.get(0)).i()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f١٧٣٣٩a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f١٧٣٣٩a.toArray()));
        }
        return sb.toString();
    }
}
