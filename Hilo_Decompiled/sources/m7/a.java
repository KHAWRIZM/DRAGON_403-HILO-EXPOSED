package m7;

import android.util.SparseArray;
import java.util.HashMap;
import z6.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray f١٥٩٩٢a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap f١٥٩٩٣b;

    static {
        HashMap hashMap = new HashMap();
        f١٥٩٩٣b = hashMap;
        hashMap.put(f.DEFAULT, 0);
        f١٥٩٩٣b.put(f.VERY_LOW, 1);
        f١٥٩٩٣b.put(f.HIGHEST, 2);
        for (f fVar : f١٥٩٩٣b.keySet()) {
            f١٥٩٩٢a.append(((Integer) f١٥٩٩٣b.get(fVar)).intValue(), fVar);
        }
    }

    public static int a(f fVar) {
        Integer num = (Integer) f١٥٩٩٣b.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + fVar);
    }

    public static f b(int i10) {
        f fVar = (f) f١٥٩٩٢a.get(i10);
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
