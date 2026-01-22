package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    private static final q0 f١١٨٩٩a;

    /* renamed from: b, reason: collision with root package name */
    private static final q0 f١١٩٠٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b extends q0 {

        /* renamed from: c, reason: collision with root package name */
        private static final Class f١١٩٠١c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static List f(Object obj, long j10) {
            return (List) p2.G(obj, j10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static List g(Object obj, long j10, int i10) {
            o0 o0Var;
            List arrayList;
            List f10 = f(obj, j10);
            if (f10.isEmpty()) {
                if (f10 instanceof p0) {
                    arrayList = new o0(i10);
                } else if ((f10 instanceof s1) && (f10 instanceof j0.i)) {
                    arrayList = ((j0.i) f10).a(i10);
                } else {
                    arrayList = new ArrayList(i10);
                }
                p2.X(obj, j10, arrayList);
                return arrayList;
            }
            if (f١١٩٠١c.isAssignableFrom(f10.getClass())) {
                ArrayList arrayList2 = new ArrayList(f10.size() + i10);
                arrayList2.addAll(f10);
                p2.X(obj, j10, arrayList2);
                o0Var = arrayList2;
            } else if (f10 instanceof o2) {
                o0 o0Var2 = new o0(f10.size() + i10);
                o0Var2.addAll((o2) f10);
                p2.X(obj, j10, o0Var2);
                o0Var = o0Var2;
            } else {
                if ((f10 instanceof s1) && (f10 instanceof j0.i)) {
                    j0.i iVar = (j0.i) f10;
                    if (!iVar.c()) {
                        j0.i a10 = iVar.a(f10.size() + i10);
                        p2.X(obj, j10, a10);
                        return a10;
                    }
                    return f10;
                }
                return f10;
            }
            return o0Var;
        }

        @Override // com.google.protobuf.q0
        void c(Object obj, long j10) {
            Object unmodifiableList;
            List list = (List) p2.G(obj, j10);
            if (list instanceof p0) {
                unmodifiableList = ((p0) list).getUnmodifiableView();
            } else {
                if (f١١٩٠١c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof s1) && (list instanceof j0.i)) {
                    j0.i iVar = (j0.i) list;
                    if (iVar.c()) {
                        iVar.b();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            p2.X(obj, j10, unmodifiableList);
        }

        @Override // com.google.protobuf.q0
        void d(Object obj, Object obj2, long j10) {
            List f10 = f(obj2, j10);
            List g10 = g(obj, j10, f10.size());
            int size = g10.size();
            int size2 = f10.size();
            if (size > 0 && size2 > 0) {
                g10.addAll(f10);
            }
            if (size > 0) {
                f10 = g10;
            }
            p2.X(obj, j10, f10);
        }

        @Override // com.google.protobuf.q0
        List e(Object obj, long j10) {
            return g(obj, j10, 10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c extends q0 {
        private c() {
            super();
        }

        static j0.i f(Object obj, long j10) {
            return (j0.i) p2.G(obj, j10);
        }

        @Override // com.google.protobuf.q0
        void c(Object obj, long j10) {
            f(obj, j10).b();
        }

        @Override // com.google.protobuf.q0
        void d(Object obj, Object obj2, long j10) {
            j0.i f10 = f(obj, j10);
            j0.i f11 = f(obj2, j10);
            int size = f10.size();
            int size2 = f11.size();
            if (size > 0 && size2 > 0) {
                if (!f10.c()) {
                    f10 = f10.a(size2 + size);
                }
                f10.addAll(f11);
            }
            if (size > 0) {
                f11 = f10;
            }
            p2.X(obj, j10, f11);
        }

        @Override // com.google.protobuf.q0
        List e(Object obj, long j10) {
            int i10;
            j0.i f10 = f(obj, j10);
            if (!f10.c()) {
                int size = f10.size();
                if (size == 0) {
                    i10 = 10;
                } else {
                    i10 = size * 2;
                }
                j0.i a10 = f10.a(i10);
                p2.X(obj, j10, a10);
                return a10;
            }
            return f10;
        }
    }

    static {
        f١١٨٩٩a = new b();
        f١١٩٠٠b = new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 a() {
        return f١١٨٩٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 b() {
        return f١١٩٠٠b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj, Object obj2, long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List e(Object obj, long j10);

    private q0() {
    }
}
