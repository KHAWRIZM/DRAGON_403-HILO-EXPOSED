package n4;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.f;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements com.bumptech.glide.load.data.d {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f١٦٣١٥a;

    /* renamed from: b, reason: collision with root package name */
    private final e f١٦٣١٦b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f١٦٣١٧c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f١٦٣١٨b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f١٦٣١٩a;

        a(ContentResolver contentResolver) {
            this.f١٦٣١٩a = contentResolver;
        }

        @Override // n4.d
        public Cursor a(Uri uri) {
            return this.f١٦٣١٩a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f١٦٣١٨b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f١٦٣٢٠b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f١٦٣٢١a;

        b(ContentResolver contentResolver) {
            this.f١٦٣٢١a = contentResolver;
        }

        @Override // n4.d
        public Cursor a(Uri uri) {
            return this.f١٦٣٢١a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f١٦٣٢٠b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f١٦٣١٥a = uri;
        this.f١٦٣١٦b = eVar;
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(Glide.get(context).getRegistry().g(), dVar, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c c(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() {
        int i10;
        InputStream d10 = this.f١٦٣١٦b.d(this.f١٦٣١٥a);
        if (d10 != null) {
            i10 = this.f١٦٣١٦b.a(this.f١٦٣١٥a);
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return new g(d10, i10);
        }
        return d10;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        InputStream inputStream = this.f١٦٣١٧c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public Class getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public m4.a getDataSource() {
        return m4.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void loadData(f fVar, d.a aVar) {
        try {
            InputStream d10 = d();
            this.f١٦٣١٧c = d10;
            aVar.onDataReady(d10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.onLoadFailed(e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
