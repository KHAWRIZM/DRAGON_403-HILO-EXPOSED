package k2;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.graphics.i0;
import androidx.core.graphics.j0;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f١٥٤٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١٥٤٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private final int f١٥٤٧٠c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f١٥٤٧١d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١٥٤٧٢e;

        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f١٥٤٦٨a = (Uri) androidx.core.util.h.g(uri);
            this.f١٥٤٦٩b = i10;
            this.f١٥٤٧٠c = i11;
            this.f١٥٤٧١d = z10;
            this.f١٥٤٧٢e = i12;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f١٥٤٧٢e;
        }

        public int c() {
            return this.f١٥٤٦٩b;
        }

        public Uri d() {
            return this.f١٥٤٦٨a;
        }

        public int e() {
            return this.f١٥٤٧٠c;
        }

        public boolean f() {
            return this.f١٥٤٧١d;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        public abstract void a(int i10);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return j0.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, f fVar) {
        List a10;
        a10 = i0.a(new Object[]{fVar});
        return e.e(context, a10, cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i10, boolean z10, int i11, Handler handler, c cVar) {
        k2.a aVar = new k2.a(cVar, m.b(handler));
        if (z10) {
            if (list.size() <= 1) {
                return j.e(context, (f) list.get(0), aVar, i10, i11);
            }
            throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
        }
        return j.d(context, list, i10, null, aVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f١٥٤٦٦a;

        /* renamed from: b, reason: collision with root package name */
        private final List f١٥٤٦٧b;

        public a(int i10, b[] bVarArr) {
            this.f١٥٤٦٦a = i10;
            this.f١٥٤٦٧b = Collections.singletonList(bVarArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i10, List list) {
            return new a(i10, list);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a b(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] c() {
            return (b[]) this.f١٥٤٦٧b.get(0);
        }

        public List d() {
            return this.f١٥٤٦٧b;
        }

        public int e() {
            return this.f١٥٤٦٦a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean f() {
            if (this.f١٥٤٦٧b.size() > 1) {
                return true;
            }
            return false;
        }

        a(int i10, List list) {
            this.f١٥٤٦٦a = i10;
            this.f١٥٤٦٧b = list;
        }
    }
}
