package k2;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import k2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache f١٥٤٣٧a = new LruCache(2);

    /* renamed from: b, reason: collision with root package name */
    private static final Comparator f١٥٤٣٨b = new Comparator() { // from class: k2.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g10;
            g10 = e.g((byte[]) obj, (byte[]) obj2);
            return g10;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f١٥٤٣٩a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Context context, Uri uri) {
            this.f١٥٤٣٩a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // k2.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f١٥٤٣٩a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        @Override // k2.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f١٥٤٣٩a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f١٥٤٤٠a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Context context, Uri uri) {
            this.f١٥٤٤٠a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // k2.e.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f١٥٤٤٠a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        @Override // k2.e.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f١٥٤٤٠a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        String f١٥٤٤١a;

        /* renamed from: b, reason: collision with root package name */
        String f١٥٤٤٢b;

        /* renamed from: c, reason: collision with root package name */
        List f١٥٤٤٣c;

        d(String str, String str2, List list) {
            this.f١٥٤٤١a = str;
            this.f١٥٤٤٢b = str2;
            this.f١٥٤٤٣c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (Objects.equals(this.f١٥٤٤١a, dVar.f١٥٤٤١a) && Objects.equals(this.f١٥٤٤٢b, dVar.f١٥٤٤٢b) && Objects.equals(this.f١٥٤٤٣c, dVar.f١٥٤٤٣c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f١٥٤٤١a, this.f١٥٤٤٢b, this.f١٥٤٤٣c);
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals((byte[]) list.get(i10), (byte[]) list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private static List d(f fVar, Resources resources) {
        if (fVar.b() != null) {
            return fVar.b();
        }
        return androidx.core.content.res.e.c(resources, fVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l.a e(Context context, List list, CancellationSignal cancellationSignal) {
        h3.a.a("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                f fVar = (f) list.get(i10);
                ProviderInfo f10 = f(context.getPackageManager(), fVar, context.getResources());
                if (f10 == null) {
                    return l.a.b(1, null);
                }
                arrayList.add(h(context, fVar, f10.authority, cancellationSignal));
            }
            return l.a.a(0, arrayList);
        } finally {
            h3.a.b();
        }
    }

    static ProviderInfo f(PackageManager packageManager, f fVar, Resources resources) {
        h3.a.a("FontProvider.getProvider");
        try {
            List d10 = d(fVar, resources);
            d dVar = new d(fVar.e(), fVar.f(), d10);
            ProviderInfo providerInfo = (ProviderInfo) f١٥٤٣٧a.get(dVar);
            if (providerInfo != null) {
                return providerInfo;
            }
            String e10 = fVar.e();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e10, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(fVar.f())) {
                    List b10 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                    Collections.sort(b10, f١٥٤٣٨b);
                    for (int i10 = 0; i10 < d10.size(); i10++) {
                        ArrayList arrayList = new ArrayList((Collection) d10.get(i10));
                        Collections.sort(arrayList, f١٥٤٣٨b);
                        if (c(b10, arrayList)) {
                            f١٥٤٣٧a.put(dVar, resolveContentProvider);
                            return resolveContentProvider;
                        }
                    }
                    h3.a.b();
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + e10 + ", but package was not " + fVar.f());
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e10);
        } finally {
            h3.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    static l.b[] h(Context context, f fVar, String str, CancellationSignal cancellationSignal) {
        int i10;
        int i11;
        ArrayList arrayList;
        Uri withAppendedId;
        int i12;
        boolean z10;
        h3.a.a("FontProvider.query");
        try {
            ArrayList arrayList2 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            a a10 = k2.d.a(context, build);
            Cursor cursor = null;
            try {
                String[] strArr = {TransferTable.COLUMN_ID, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                h3.a.a("ContentQueryWrapper.query");
                try {
                    cursor = a10.a(build, strArr, "query = ?", new String[]{fVar.g()}, null, cancellationSignal);
                    h3.a.b();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex(TransferTable.COLUMN_ID);
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i10 = cursor.getInt(columnIndex);
                            } else {
                                i10 = 0;
                            }
                            if (columnIndex4 != -1) {
                                i11 = cursor.getInt(columnIndex4);
                            } else {
                                i11 = 0;
                            }
                            if (columnIndex3 == -1) {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                arrayList = arrayList3;
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            if (columnIndex5 != -1) {
                                i12 = cursor.getInt(columnIndex5);
                            } else {
                                i12 = 400;
                            }
                            if (columnIndex6 != -1) {
                                z10 = true;
                                if (cursor.getInt(columnIndex6) == 1) {
                                    l.b a11 = l.b.a(withAppendedId, i11, i12, z10, i10);
                                    arrayList3 = arrayList;
                                    arrayList3.add(a11);
                                }
                            }
                            z10 = false;
                            l.b a112 = l.b.a(withAppendedId, i11, i12, z10, i10);
                            arrayList3 = arrayList;
                            arrayList3.add(a112);
                        }
                        arrayList2 = arrayList3;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    a10.close();
                    return (l.b[]) arrayList2.toArray(new l.b[0]);
                } finally {
                    h3.a.b();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                a10.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
