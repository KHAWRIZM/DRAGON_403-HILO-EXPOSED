package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class x implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private Iterator f٣٥٣٧a;

    public x(Iterator it) {
        this.f٣٥٣٧a = it;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f٣٥٣٧a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f٣٥٣٧a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f٣٥٣٧a.remove();
    }
}
