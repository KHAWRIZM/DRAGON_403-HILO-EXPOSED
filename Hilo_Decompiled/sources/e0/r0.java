package e0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class r0 extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٣٨٢٢a;

    public r0(Context context) {
        this.f١٣٨٢٢a = context;
    }

    @Override // e0.j0
    public final j b(e0 e0Var, int i10) {
        Resources resourcesForApplication;
        int parseInt;
        Context context = this.f١٣٨٢٢a;
        StringBuilder sb = u0.f١٣٨٣٥a;
        e0Var.getClass();
        Uri uri = e0Var.f١٣٧٨٣a;
        if (uri == null) {
            resourcesForApplication = context.getResources();
        } else {
            String authority = uri.getAuthority();
            if (authority != null) {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new FileNotFoundException("Unable to obtain resources for package: " + e0Var.f١٣٧٨٣a);
                }
            } else {
                throw new FileNotFoundException("No package provided: " + e0Var.f١٣٧٨٣a);
            }
        }
        Uri uri2 = e0Var.f١٣٧٨٣a;
        if (uri2 == null) {
            parseInt = 0;
        } else {
            String authority2 = uri2.getAuthority();
            if (authority2 != null) {
                List<String> pathSegments = e0Var.f١٣٧٨٣a.getPathSegments();
                if (pathSegments != null && !pathSegments.isEmpty()) {
                    if (pathSegments.size() == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused2) {
                            throw new FileNotFoundException("Last path segment is not a resource ID: " + e0Var.f١٣٧٨٣a);
                        }
                    } else if (pathSegments.size() == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + e0Var.f١٣٧٨٣a);
                    }
                } else {
                    throw new FileNotFoundException("No path segments: " + e0Var.f١٣٧٨٣a);
                }
            } else {
                throw new FileNotFoundException("No package provided: " + e0Var.f١٣٧٨٣a);
            }
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resourcesForApplication, parseInt, null);
        if (decodeResource != null) {
            return new j(decodeResource, null, 2, 0);
        }
        throw new NullPointerException("bitmap == null");
    }

    @Override // e0.j0
    public final boolean d(e0 e0Var) {
        return "android.resource".equals(e0Var.f١٣٧٨٣a.getScheme());
    }
}
