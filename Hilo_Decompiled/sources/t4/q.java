package t4;

import androidx.core.util.Pools;
import com.bumptech.glide.load.data.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class q implements n {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٨٠٩١a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool f١٨٠٩٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements com.bumptech.glide.load.data.d, d.a {

        /* renamed from: a, reason: collision with root package name */
        private final List f١٨٠٩٣a;

        /* renamed from: b, reason: collision with root package name */
        private final Pools.Pool f١٨٠٩٤b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٨٠٩٥c;

        /* renamed from: d, reason: collision with root package name */
        private com.bumptech.glide.f f١٨٠٩٦d;

        /* renamed from: e, reason: collision with root package name */
        private d.a f١٨٠٩٧e;

        /* renamed from: f, reason: collision with root package name */
        private List f١٨٠٩٨f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١٨٠٩٩g;

        a(List list, Pools.Pool pool) {
            this.f١٨٠٩٤b = pool;
            f5.k.c(list);
            this.f١٨٠٩٣a = list;
            this.f١٨٠٩٥c = 0;
        }

        private void a() {
            if (this.f١٨٠٩٩g) {
                return;
            }
            if (this.f١٨٠٩٥c < this.f١٨٠٩٣a.size() - 1) {
                this.f١٨٠٩٥c++;
                loadData(this.f١٨٠٩٦d, this.f١٨٠٩٧e);
            } else {
                f5.k.d(this.f١٨٠٩٨f);
                this.f١٨٠٩٧e.onLoadFailed(new o4.q("Fetch failed", new ArrayList(this.f١٨٠٩٨f)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f١٨٠٩٩g = true;
            Iterator it = this.f١٨٠٩٣a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            List list = this.f١٨٠٩٨f;
            if (list != null) {
                this.f١٨٠٩٤b.release(list);
            }
            this.f١٨٠٩٨f = null;
            Iterator it = this.f١٨٠٩٣a.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.load.data.d) it.next()).cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return ((com.bumptech.glide.load.data.d) this.f١٨٠٩٣a.get(0)).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return ((com.bumptech.glide.load.data.d) this.f١٨٠٩٣a.get(0)).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            this.f١٨٠٩٦d = fVar;
            this.f١٨٠٩٧e = aVar;
            this.f١٨٠٩٨f = (List) this.f١٨٠٩٤b.acquire();
            ((com.bumptech.glide.load.data.d) this.f١٨٠٩٣a.get(this.f١٨٠٩٥c)).loadData(fVar, this);
            if (this.f١٨٠٩٩g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void onDataReady(Object obj) {
            if (obj != null) {
                this.f١٨٠٩٧e.onDataReady(obj);
            } else {
                a();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void onLoadFailed(Exception exc) {
            ((List) f5.k.d(this.f١٨٠٩٨f)).add(exc);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(List list, Pools.Pool pool) {
        this.f١٨٠٩١a = list;
        this.f١٨٠٩٢b = pool;
    }

    @Override // t4.n
    public n.a buildLoadData(Object obj, int i10, int i11, m4.i iVar) {
        n.a buildLoadData;
        int size = this.f١٨٠٩١a.size();
        ArrayList arrayList = new ArrayList(size);
        m4.f fVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n nVar = (n) this.f١٨٠٩١a.get(i12);
            if (nVar.handles(obj) && (buildLoadData = nVar.buildLoadData(obj, i10, i11, iVar)) != null) {
                fVar = buildLoadData.f١٨٠٨٤a;
                arrayList.add(buildLoadData.f١٨٠٨٦c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a(fVar, new a(arrayList, this.f١٨٠٩٢b));
    }

    @Override // t4.n
    public boolean handles(Object obj) {
        Iterator it = this.f١٨٠٩١a.iterator();
        while (it.hasNext()) {
            if (((n) it.next()).handles(obj)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f١٨٠٩١a.toArray()) + '}';
    }
}
