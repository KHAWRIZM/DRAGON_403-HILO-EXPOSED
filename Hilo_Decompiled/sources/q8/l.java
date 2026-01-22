package q8;

import androidx.appcompat.app.a0;
import com.google.gson.t;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class l {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f١٧٢٣٨a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f١٧٢٣٩b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f١٧٢٣٩b = method;
            }

            @Override // q8.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f١٧٢٣٩b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* renamed from: q8.l$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢١٣b extends b {
            C٠٢١٣b() {
                super();
            }

            @Override // q8.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
        static {
            b aVar;
            if (e.d()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                }
                if (aVar == null) {
                    aVar = new C٠٢١٣b();
                }
                f١٧٢٣٨a = aVar;
            }
            aVar = null;
            if (aVar == null) {
            }
            f١٧٢٣٨a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f١٧٢٣٨a.a(accessibleObject, obj);
    }

    public static t b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return t.ALLOW;
        }
        a0.a(it.next());
        throw null;
    }
}
