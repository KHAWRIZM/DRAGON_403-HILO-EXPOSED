package p4;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class n implements k {

    /* renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f١٦٨٨٢d;

    /* renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f١٦٨٨٣e;

    /* renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f١٦٨٨٤f;

    /* renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f١٦٨٨٥g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f١٦٨٨٦h;

    /* renamed from: a, reason: collision with root package name */
    private final c f١٦٨٨٧a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final g f١٦٨٨٨b = new g();

    /* renamed from: c, reason: collision with root package name */
    private final Map f١٦٨٨٩c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٨٩٠a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f١٦٨٩٠a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٨٩٠a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٦٨٩٠a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٨٩٠a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        private final c f١٦٨٩١a;

        /* renamed from: b, reason: collision with root package name */
        int f١٦٨٩٢b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f١٦٨٩٣c;

        public b(c cVar) {
            this.f١٦٨٩١a = cVar;
        }

        @Override // p4.l
        public void a() {
            this.f١٦٨٩١a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f١٦٨٩٢b = i10;
            this.f١٦٨٩٣c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f١٦٨٩٢b != bVar.f١٦٨٩٢b || !f5.l.e(this.f١٦٨٩٣c, bVar.f١٦٨٩٣c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int i11 = this.f١٦٨٩٢b * 31;
            Bitmap.Config config = this.f١٦٨٩٣c;
            if (config != null) {
                i10 = config.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return n.h(this.f١٦٨٩٢b, this.f١٦٨٩٣c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends p4.c {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i10, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f١٦٨٨٢d = configArr;
        f١٦٨٨٣e = configArr;
        f١٦٨٨٤f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f١٦٨٨٥g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f١٦٨٨٦h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void e(Integer num, Bitmap bitmap) {
        NavigableMap j10 = j(bitmap.getConfig());
        Integer num2 = (Integer) j10.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                j10.remove(num);
                return;
            } else {
                j10.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    private b g(int i10, Bitmap.Config config) {
        b e10 = this.f١٦٨٨٧a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer num = (Integer) j(config2).ceilingKey(Integer.valueOf(i10));
            if (num != null && num.intValue() <= i10 * 8) {
                if (num.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return e10;
                        }
                    } else if (config2.equals(config)) {
                        return e10;
                    }
                }
                this.f١٦٨٨٧a.c(e10);
                return this.f١٦٨٨٧a.e(num.intValue(), config2);
            }
        }
        return e10;
    }

    static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return f١٦٨٨٣e;
            }
        }
        int i10 = a.f١٦٨٩٠a[config.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return new Bitmap.Config[]{config};
                    }
                    return f١٦٨٨٦h;
                }
                return f١٦٨٨٥g;
            }
            return f١٦٨٨٤f;
        }
        return f١٦٨٨٢d;
    }

    private NavigableMap j(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap) this.f١٦٨٨٩c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f١٦٨٨٩c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // p4.k
    public String a(Bitmap bitmap) {
        return h(f5.l.i(bitmap), bitmap.getConfig());
    }

    @Override // p4.k
    public String b(int i10, int i11, Bitmap.Config config) {
        return h(f5.l.h(i10, i11, config), config);
    }

    @Override // p4.k
    public int c(Bitmap bitmap) {
        return f5.l.i(bitmap);
    }

    @Override // p4.k
    public void d(Bitmap bitmap) {
        b e10 = this.f١٦٨٨٧a.e(f5.l.i(bitmap), bitmap.getConfig());
        this.f١٦٨٨٨b.d(e10, bitmap);
        NavigableMap j10 = j(bitmap.getConfig());
        Integer num = (Integer) j10.get(Integer.valueOf(e10.f١٦٨٩٢b));
        Integer valueOf = Integer.valueOf(e10.f١٦٨٩٢b);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        j10.put(valueOf, Integer.valueOf(i10));
    }

    @Override // p4.k
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        b g10 = g(f5.l.h(i10, i11, config), config);
        Bitmap bitmap = (Bitmap) this.f١٦٨٨٨b.a(g10);
        if (bitmap != null) {
            e(Integer.valueOf(g10.f١٦٨٩٢b), bitmap);
            bitmap.reconfigure(i10, i11, config);
        }
        return bitmap;
    }

    @Override // p4.k
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f١٦٨٨٨b.f();
        if (bitmap != null) {
            e(Integer.valueOf(f5.l.i(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f١٦٨٨٨b);
        sb.append(", sortedSizes=(");
        for (Map.Entry entry : this.f١٦٨٨٩c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f١٦٨٨٩c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
