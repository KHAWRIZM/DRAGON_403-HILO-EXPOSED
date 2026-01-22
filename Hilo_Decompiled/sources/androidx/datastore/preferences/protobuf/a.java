package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j0;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements j0 {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class AbstractC٠٠٣٤a implements j0.a {
        protected static void b(Iterable iterable, List list) {
            u.a(iterable);
            c(iterable, list);
        }

        private static void c(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static d1 d(j0 j0Var) {
            return new d1(j0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Iterable iterable, List list) {
        AbstractC٠٠٣٤a.b(iterable, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c(x0 x0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1 d() {
        return new d1(this);
    }

    public void e(OutputStream outputStream) {
        i Y = i.Y(outputStream, i.C(getSerializedSize()));
        a(Y);
        Y.V();
    }
}
