package y;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f١٩٠٤١a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f١٩٠٤٢b;

    /* renamed from: c, reason: collision with root package name */
    public final int f١٩٠٤٣c;

    /* renamed from: d, reason: collision with root package name */
    public final int f١٩٠٤٤d;

    /* renamed from: e, reason: collision with root package name */
    public final int f١٩٠٤٥e;

    /* renamed from: f, reason: collision with root package name */
    public final int f١٩٠٤٦f;

    /* renamed from: g, reason: collision with root package name */
    public final String f١٩٠٤٧g;

    public b(LinkedHashMap linkedHashMap) {
        this.f١٩٠٤٢b = Collections.unmodifiableMap(linkedHashMap);
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            int length = ((String) entry.getKey()).length();
            i10 = length > i10 ? length : i10;
            i12 = length < i12 ? length : i12;
            String str = (String) entry.getValue();
            int length2 = str.length();
            if (length2 > 0) {
                if (!this.f١٩٠٤١a.containsKey(str)) {
                    this.f١٩٠٤١a.put(str, (String) entry.getKey());
                }
                i11 = length2 > i11 ? length2 : i11;
                if (length2 < i13) {
                    i13 = length2;
                }
            }
        }
        this.f١٩٠٤٣c = i10;
        this.f١٩٠٤٥e = i11;
        this.f١٩٠٤٤d = i12;
        this.f١٩٠٤٦f = i13;
        this.f١٩٠٤٧g = ".gz";
    }
}
