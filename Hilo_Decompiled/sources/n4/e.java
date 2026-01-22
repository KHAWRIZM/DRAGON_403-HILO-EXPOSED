package n4;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class e {

    /* renamed from: f, reason: collision with root package name */
    private static final a f١٦٣٢٢f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f١٦٣٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private final d f١٦٣٢٤b;

    /* renamed from: c, reason: collision with root package name */
    private final p4.b f١٦٣٢٥c;

    /* renamed from: d, reason: collision with root package name */
    private final ContentResolver f١٦٣٢٦d;

    /* renamed from: e, reason: collision with root package name */
    private final List f١٦٣٢٧e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List list, d dVar, p4.b bVar, ContentResolver contentResolver) {
        this(list, f١٦٣٢٢f, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x001b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:28), block:B:26:0x001b */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Uri uri) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            try {
                cursor = this.f١٦٣٢٤b.a(uri);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(0);
                            cursor.close();
                            return string;
                        }
                    } catch (SecurityException e10) {
                        e = e10;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SecurityException e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    private boolean c(File file) {
        if (this.f١٦٣٢٣a.a(file) && 0 < this.f١٦٣٢٣a.c(file)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f١٦٣٢٦d.openInputStream(uri);
                int b10 = com.bumptech.glide.load.a.b(this.f١٦٣٢٧e, inputStream, this.f١٦٣٢٥c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b10;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e10) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
            return -1;
        }
    }

    public InputStream d(Uri uri) {
        String b10 = b(uri);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        File b11 = this.f١٦٣٢٣a.b(b10);
        if (!c(b11)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b11);
        try {
            return this.f١٦٣٢٦d.openInputStream(fromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e10));
        }
    }

    e(List list, a aVar, d dVar, p4.b bVar, ContentResolver contentResolver) {
        this.f١٦٣٢٣a = aVar;
        this.f١٦٣٢٤b = dVar;
        this.f١٦٣٢٥c = bVar;
        this.f١٦٣٢٦d = contentResolver;
        this.f١٦٣٢٧e = list;
    }
}
