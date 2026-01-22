package pa;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    ArrayList f١٦٩٨٥a = null;

    /* renamed from: pa.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠٢٠٩a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    public void a(InterfaceC٠٢٠٩a r22) {
        if (this.f١٦٩٨٥a == null) {
            this.f١٦٩٨٥a = new ArrayList();
        }
        this.f١٦٩٨٥a.add(r22);
    }

    public a b() {
        try {
            a aVar = (a) super.clone();
            ArrayList arrayList = this.f١٦٩٨٥a;
            if (arrayList != null) {
                aVar.f١٦٩٨٥a = new ArrayList();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    aVar.f١٦٩٨٥a.add(arrayList.get(i10));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
