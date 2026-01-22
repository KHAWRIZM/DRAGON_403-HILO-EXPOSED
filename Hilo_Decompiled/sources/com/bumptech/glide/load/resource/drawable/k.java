package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k implements m4.k {

    /* renamed from: b, reason: collision with root package name */
    public static final m4.h f٧٤٦٤b = m4.h.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* renamed from: a, reason: collision with root package name */
    private final Context f٧٤٦٥a;

    public k(Context context) {
        this.f٧٤٦٥a = context.getApplicationContext();
    }

    private Context b(Uri uri, String str) {
        if (str.equals(this.f٧٤٦٥a.getPackageName())) {
            return this.f٧٤٦٥a;
        }
        try {
            return this.f٧٤٦٥a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f٧٤٦٥a.getPackageName())) {
                return this.f٧٤٦٥a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    private int c(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    private int d(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int e(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return d(context, uri);
        }
        if (pathSegments.size() == 1) {
            return c(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(Uri uri, int i10, int i11, m4.i iVar) {
        Resources.Theme theme;
        Drawable a10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context b10 = b(uri, authority);
            int e10 = e(b10, uri);
            if (((String) f5.k.d(authority)).equals(this.f٧٤٦٥a.getPackageName())) {
                theme = (Resources.Theme) iVar.a(f٧٤٦٤b);
            } else {
                theme = null;
            }
            if (theme == null) {
                a10 = h.b(this.f٧٤٦٥a, b10, e10);
            } else {
                a10 = h.a(this.f٧٤٦٥a, e10, theme);
            }
            return j.a(a10);
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    @Override // m4.k
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri, m4.i iVar) {
        String scheme = uri.getScheme();
        if (scheme != null && scheme.equals("android.resource")) {
            return true;
        }
        return false;
    }
}
