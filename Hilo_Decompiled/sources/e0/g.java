package e0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.InputStream;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g extends j0 {

    /* renamed from: b, reason: collision with root package name */
    public static final UriMatcher f١٣٧٨٧b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٣٧٨٨a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f١٣٧٨٧b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public g(Context context) {
        this.f١٣٧٨٨a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    @Override // e0.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j b(e0 e0Var, int i10) {
        InputStream inputStream;
        ContentResolver contentResolver = this.f١٣٧٨٨a.getContentResolver();
        Uri uri = e0Var.f١٣٧٨٣a;
        int match = f١٣٧٨٧b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
                inputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
                if (inputStream != null) {
                    return null;
                }
                return new j(Okio.source(inputStream), 2);
            }
            inputStream = contentResolver.openInputStream(uri);
            if (inputStream != null) {
            }
        } else {
            uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
            if (uri == null) {
                inputStream = null;
                if (inputStream != null) {
                }
            }
            inputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            if (inputStream != null) {
            }
        }
    }

    @Override // e0.j0
    public final boolean d(e0 e0Var) {
        Uri uri = e0Var.f١٣٧٨٣a;
        if ("content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f١٣٧٨٧b.match(e0Var.f١٣٧٨٣a) != -1) {
            return true;
        }
        return false;
    }
}
