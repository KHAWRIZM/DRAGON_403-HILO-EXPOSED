package e0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k0 extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f١٣٧٩٩b = {"orientation"};

    public k0(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r0 != null) goto L٩;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    @Override // e0.n, e0.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j b(e0 e0Var, int i10) {
        Cursor cursor;
        String type;
        ContentResolver contentResolver = this.f١٣٨٠٢a.getContentResolver();
        int i11 = 0;
        Cursor cursor2 = null;
        try {
            cursor = contentResolver.query(e0Var.f١٣٧٨٣a, f١٣٧٩٩b, null, null, null);
        } catch (RuntimeException unused) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursor != null) {
            try {
            } catch (RuntimeException unused2) {
                if (cursor != null) {
                    cursor.close();
                }
                type = contentResolver.getType(e0Var.f١٣٧٨٣a);
                if (type != null) {
                }
                return new j(null, Okio.source(this.f١٣٨٠٢a.getContentResolver().openInputStream(e0Var.f١٣٧٨٣a)), 2, i11);
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursor.moveToFirst()) {
                i11 = cursor.getInt(0);
                cursor.close();
                type = contentResolver.getType(e0Var.f١٣٧٨٣a);
                if (type != null) {
                    type.startsWith("video/");
                }
                return new j(null, Okio.source(this.f١٣٨٠٢a.getContentResolver().openInputStream(e0Var.f١٣٧٨٣a)), 2, i11);
            }
        }
    }

    @Override // e0.n, e0.j0
    public final boolean d(e0 e0Var) {
        Uri uri = e0Var.f١٣٧٨٣a;
        if ("content".equals(uri.getScheme()) && ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }
}
