package k2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.i0;
import androidx.core.graphics.j0;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    static final LruCache f١٥٤٥٠a = new LruCache(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f١٥٤٥١b = m.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f١٥٤٥٢c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final SimpleArrayMap f١٥٤٥٣d = new SimpleArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٥٤٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f١٥٤٥٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f١٥٤٥٦c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f١٥٤٥٧d;

        a(String str, Context context, f fVar, int i10) {
            this.f١٥٤٥٤a = str;
            this.f١٥٤٥٥b = context;
            this.f١٥٤٥٦c = fVar;
            this.f١٥٤٥٧d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            List a10;
            String str = this.f١٥٤٥٤a;
            Context context = this.f١٥٤٥٥b;
            a10 = i0.a(new Object[]{this.f١٥٤٥٦c});
            return j.c(str, context, a10, this.f١٥٤٥٧d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k2.a f١٥٤٥٨a;

        b(k2.a aVar) {
            this.f١٥٤٥٨a = aVar;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f١٥٤٥٨a.b(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٥٤٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f١٥٤٦٠b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f١٥٤٦١c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f١٥٤٦٢d;

        c(String str, Context context, List list, int i10) {
            this.f١٥٤٥٩a = str;
            this.f١٥٤٦٠b = context;
            this.f١٥٤٦١c = list;
            this.f١٥٤٦٢d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return j.c(this.f١٥٤٥٩a, this.f١٥٤٦٠b, this.f١٥٤٦١c, this.f١٥٤٦٢d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٥٤٦٣a;

        d(String str) {
            this.f١٥٤٦٣a = str;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (j.f١٥٤٥٢c) {
                try {
                    SimpleArrayMap simpleArrayMap = j.f١٥٤٥٣d;
                    ArrayList arrayList = (ArrayList) simpleArrayMap.get(this.f١٥٤٦٣a);
                    if (arrayList == null) {
                        return;
                    }
                    simpleArrayMap.remove(this.f١٥٤٦٣a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        ((Consumer) arrayList.get(i10)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(List list, int i10) {
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb.append(((f) list.get(i11)).d());
            sb.append("-");
            sb.append(i10);
            if (i11 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    private static int b(l.a aVar) {
        int i10 = 1;
        if (aVar.e() != 0) {
            if (aVar.e() != 1) {
                return -3;
            }
            return -2;
        }
        l.b[] c10 = aVar.c();
        if (c10 != null && c10.length != 0) {
            i10 = 0;
            for (l.b bVar : c10) {
                int b10 = bVar.b();
                if (b10 != 0) {
                    if (b10 < 0) {
                        return -3;
                    }
                    return b10;
                }
            }
        }
        return i10;
    }

    static e c(String str, Context context, List list, int i10) {
        Typeface b10;
        h3.a.a("getFontSync");
        try {
            LruCache lruCache = f١٥٤٥٠a;
            Typeface typeface = (Typeface) lruCache.get(str);
            if (typeface != null) {
                return new e(typeface);
            }
            l.a e10 = k2.e.e(context, list, null);
            int b11 = b(e10);
            if (b11 != 0) {
                return new e(b11);
            }
            if (e10.f() && Build.VERSION.SDK_INT >= 29) {
                b10 = j0.c(context, null, e10.d(), i10);
            } else {
                b10 = j0.b(context, null, e10.c(), i10);
            }
            if (b10 != null) {
                lruCache.put(str, b10);
                return new e(b10);
            }
            return new e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            h3.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, List list, int i10, Executor executor, k2.a aVar) {
        String a10 = a(list, i10);
        Typeface typeface = (Typeface) f١٥٤٥٠a.get(a10);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f١٥٤٥٢c) {
            try {
                SimpleArrayMap simpleArrayMap = f١٥٤٥٣d;
                ArrayList arrayList = (ArrayList) simpleArrayMap.get(a10);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                simpleArrayMap.put(a10, arrayList2);
                c cVar = new c(a10, context, list, i10);
                if (executor == null) {
                    executor = f١٥٤٥١b;
                }
                m.c(executor, cVar, new d(a10));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, f fVar, k2.a aVar, int i10, int i11) {
        List a10;
        List a11;
        a10 = i0.a(new Object[]{fVar});
        String a12 = a(a10, i10);
        Typeface typeface = (Typeface) f١٥٤٥٠a.get(a12);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            a11 = i0.a(new Object[]{fVar});
            e c10 = c(a12, context, a11, i10);
            aVar.b(c10);
            return c10.f١٥٤٦٤a;
        }
        try {
            e eVar = (e) m.d(f١٥٤٥١b, new a(a12, context, fVar, i10), i11);
            aVar.b(eVar);
            return eVar.f١٥٤٦٤a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f١٥٤٦٤a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٥٤٦٥b;

        e(int i10) {
            this.f١٥٤٦٤a = null;
            this.f١٥٤٦٥b = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            if (this.f١٥٤٦٥b == 0) {
                return true;
            }
            return false;
        }

        e(Typeface typeface) {
            this.f١٥٤٦٤a = typeface;
            this.f١٥٤٦٥b = 0;
        }
    }
}
