package z4;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class s implements l {

    /* renamed from: a, reason: collision with root package name */
    private final Set f١٩٤٩٠a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f١٩٤٩٠a.clear();
    }

    public List b() {
        return f5.l.k(this.f١٩٤٩٠a);
    }

    public void c(com.bumptech.glide.request.target.j jVar) {
        this.f١٩٤٩٠a.add(jVar);
    }

    public void d(com.bumptech.glide.request.target.j jVar) {
        this.f١٩٤٩٠a.remove(jVar);
    }

    @Override // z4.l
    public void onDestroy() {
        Iterator it = f5.l.k(this.f١٩٤٩٠a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.j) it.next()).onDestroy();
        }
    }

    @Override // z4.l
    public void onStart() {
        Iterator it = f5.l.k(this.f١٩٤٩٠a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.j) it.next()).onStart();
        }
    }

    @Override // z4.l
    public void onStop() {
        Iterator it = f5.l.k(this.f١٩٤٩٠a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.j) it.next()).onStop();
        }
    }
}
