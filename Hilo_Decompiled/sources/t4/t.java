package t4;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import java.util.List;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class t implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨١١٤a;

    /* renamed from: b, reason: collision with root package name */
    private final n f١٨١١٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨١١٦a;

        a(Context context) {
            this.f١٨١١٦a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new t(this.f١٨١١٦a, rVar.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨١١٧a;

        b(Context context) {
            this.f١٨١١٧a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new t(this.f١٨١١٧a, rVar.d(Integer.class, InputStream.class));
        }
    }

    t(Context context, n nVar) {
        this.f١٨١١٤a = context.getApplicationContext();
        this.f١٨١١٥b = nVar;
    }

    public static o c(Context context) {
        return new a(context);
    }

    public static o d(Context context) {
        return new b(context);
    }

    private n.a e(Uri uri, int i10, int i11, m4.i iVar) {
        try {
            int parseInt = Integer.parseInt(uri.getPathSegments().get(0));
            if (parseInt == 0) {
                if (Log.isLoggable("ResourceUriLoader", 5)) {
                    Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
                }
                return null;
            }
            return this.f١٨١١٥b.buildLoadData(Integer.valueOf(parseInt), i10, i11, iVar);
        } catch (NumberFormatException e10) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e10);
            }
            return null;
        }
    }

    private n.a f(Uri uri, int i10, int i11, m4.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f١٨١١٤a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f١٨١١٤a.getPackageName());
        if (identifier == 0) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
                return null;
            }
            return null;
        }
        return this.f١٨١١٥b.buildLoadData(Integer.valueOf(identifier), i10, i11, iVar);
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, m4.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return e(uri, i10, i11, iVar);
        }
        if (pathSegments.size() == 2) {
            return f(uri, i10, i11, iVar);
        }
        if (Log.isLoggable("ResourceUriLoader", 5)) {
            Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
            return null;
        }
        return null;
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        if ("android.resource".equals(uri.getScheme()) && this.f١٨١١٤a.getPackageName().equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }
}
