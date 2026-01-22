package z8;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f١٩٥١٩a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٩٥٢٠b;

    public c(a aVar) {
        this.f١٩٥١٩a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f١٩٥٢٠b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i10) {
        if (i10 >= this.f١٩٥٢٠b.size()) {
            List list = this.f١٩٥٢٠b;
            b bVar = (b) list.get(list.size() - 1);
            for (int size = this.f١٩٥٢٠b.size(); size <= i10; size++) {
                a aVar = this.f١٩٥١٩a;
                bVar = bVar.g(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f١٩٥٢٠b.add(bVar);
            }
        }
        return (b) this.f١٩٥٢٠b.get(i10);
    }

    public void b(int[] iArr, int i10) {
        if (i10 != 0) {
            int length = iArr.length - i10;
            if (length > 0) {
                b a10 = a(i10);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] d10 = new b(this.f١٩٥١٩a, iArr2).h(i10, 1).b(a10)[1].d();
                int length2 = i10 - d10.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    iArr[length + i11] = 0;
                }
                System.arraycopy(d10, 0, iArr, length + length2, d10.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
