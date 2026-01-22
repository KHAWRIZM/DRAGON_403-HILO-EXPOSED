package t4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨٠٧٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٠٧٤a;

        public a(Context context) {
            this.f١٨٠٧٤a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new l(this.f١٨٠٧٤a);
        }
    }

    public l(Context context) {
        this.f١٨٠٧٣a = context;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, m4.i iVar) {
        return new n.a(new e5.d(uri), new b(this.f١٨٠٧٣a, uri));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return n4.b.c(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements com.bumptech.glide.load.data.d {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f١٨٠٧٥c = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٠٧٦a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f١٨٠٧٧b;

        b(Context context, Uri uri) {
            this.f١٨٠٧٦a = context;
            this.f١٨٠٧٧b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            Cursor query = this.f١٨٠٧٦a.getContentResolver().query(this.f١٨٠٧٧b, f١٨٠٧٥c, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.f١٨٠٧٧b));
                return;
            }
            aVar.onDataReady(new File(str));
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
