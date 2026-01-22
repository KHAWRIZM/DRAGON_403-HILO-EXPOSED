package u4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import m4.i;
import t4.n;
import t4.o;
import t4.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨٢٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private final n f١٨٢٤٦b;

    /* renamed from: c, reason: collision with root package name */
    private final n f١٨٢٤٧c;

    /* renamed from: d, reason: collision with root package name */
    private final Class f١٨٢٤٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static abstract class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٢٤٩a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f١٨٢٥٠b;

        a(Context context, Class cls) {
            this.f١٨٢٤٩a = context;
            this.f١٨٢٥٠b = cls;
        }

        @Override // t4.o
        public final n build(r rVar) {
            return new d(this.f١٨٢٤٩a, rVar.d(File.class, this.f١٨٢٥٠b), rVar.d(Uri.class, this.f١٨٢٥٠b), this.f١٨٢٥٠b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends a {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c extends a {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u4.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class C٠٢٣٥d implements com.bumptech.glide.load.data.d {

        /* renamed from: k, reason: collision with root package name */
        private static final String[] f١٨٢٥١k = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٢٥٢a;

        /* renamed from: b, reason: collision with root package name */
        private final n f١٨٢٥٣b;

        /* renamed from: c, reason: collision with root package name */
        private final n f١٨٢٥٤c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f١٨٢٥٥d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١٨٢٥٦e;

        /* renamed from: f, reason: collision with root package name */
        private final int f١٨٢٥٧f;

        /* renamed from: g, reason: collision with root package name */
        private final i f١٨٢٥٨g;

        /* renamed from: h, reason: collision with root package name */
        private final Class f١٨٢٥٩h;

        /* renamed from: i, reason: collision with root package name */
        private volatile boolean f١٨٢٦٠i;

        /* renamed from: j, reason: collision with root package name */
        private volatile com.bumptech.glide.load.data.d f١٨٢٦١j;

        C٠٢٣٥d(Context context, n nVar, n nVar2, Uri uri, int i10, int i11, i iVar, Class cls) {
            this.f١٨٢٥٢a = context.getApplicationContext();
            this.f١٨٢٥٣b = nVar;
            this.f١٨٢٥٤c = nVar2;
            this.f١٨٢٥٥d = uri;
            this.f١٨٢٥٦e = i10;
            this.f١٨٢٥٧f = i11;
            this.f١٨٢٥٨g = iVar;
            this.f١٨٢٥٩h = cls;
        }

        private n.a a() {
            boolean isExternalStorageLegacy;
            Uri uri;
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return this.f١٨٢٥٣b.buildLoadData(d(this.f١٨٢٥٥d), this.f١٨٢٥٦e, this.f١٨٢٥٧f, this.f١٨٢٥٨g);
            }
            if (n4.b.a(this.f١٨٢٥٥d)) {
                return this.f١٨٢٥٤c.buildLoadData(this.f١٨٢٥٥d, this.f١٨٢٥٦e, this.f١٨٢٥٧f, this.f١٨٢٥٨g);
            }
            if (c()) {
                uri = MediaStore.setRequireOriginal(this.f١٨٢٥٥d);
            } else {
                uri = this.f١٨٢٥٥d;
            }
            return this.f١٨٢٥٤c.buildLoadData(uri, this.f١٨٢٥٦e, this.f١٨٢٥٧f, this.f١٨٢٥٨g);
        }

        private com.bumptech.glide.load.data.d b() {
            n.a a10 = a();
            if (a10 != null) {
                return a10.f١٨٠٨٦c;
            }
            return null;
        }

        private boolean c() {
            int checkSelfPermission;
            checkSelfPermission = this.f١٨٢٥٢a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
            if (checkSelfPermission == 0) {
                return true;
            }
            return false;
        }

        private File d(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor query = this.f١٨٢٥٢a.getContentResolver().query(uri, f١٨٢٥١k, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        query.close();
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f١٨٢٦٠i = true;
            com.bumptech.glide.load.data.d dVar = this.f١٨٢٦١j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            com.bumptech.glide.load.data.d dVar = this.f١٨٢٦١j;
            if (dVar != null) {
                dVar.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨٢٥٩h;
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            try {
                com.bumptech.glide.load.data.d b10 = b();
                if (b10 == null) {
                    aVar.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.f١٨٢٥٥d));
                    return;
                }
                this.f١٨٢٦١j = b10;
                if (this.f١٨٢٦٠i) {
                    cancel();
                } else {
                    b10.loadData(fVar, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.onLoadFailed(e10);
            }
        }
    }

    d(Context context, n nVar, n nVar2, Class cls) {
        this.f١٨٢٤٥a = context.getApplicationContext();
        this.f١٨٢٤٦b = nVar;
        this.f١٨٢٤٧c = nVar2;
        this.f١٨٢٤٨d = cls;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, i iVar) {
        return new n.a(new e5.d(uri), new C٠٢٣٥d(this.f١٨٢٤٥a, this.f١٨٢٤٦b, this.f١٨٢٤٧c, uri, i10, i11, iVar, this.f١٨٢٤٨d));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        if (Build.VERSION.SDK_INT >= 29 && n4.b.c(uri)) {
            return true;
        }
        return false;
    }
}
