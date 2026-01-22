package f5;

import androidx.collection.SimpleArrayMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends androidx.collection.a {

    /* renamed from: d, reason: collision with root package name */
    private int f١٤٠٥٨d;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f١٤٠٥٨d = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f١٤٠٥٨d == 0) {
            this.f١٤٠٥٨d = super.hashCode();
        }
        return this.f١٤٠٥٨d;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.f١٤٠٥٨d = 0;
        return super.put(obj, obj2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap simpleArrayMap) {
        this.f١٤٠٥٨d = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public Object removeAt(int i10) {
        this.f١٤٠٥٨d = 0;
        return super.removeAt(i10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public Object setValueAt(int i10, Object obj) {
        this.f١٤٠٥٨d = 0;
        return super.setValueAt(i10, obj);
    }
}
