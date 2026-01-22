package v4;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements m4.l {

    /* renamed from: b, reason: collision with root package name */
    public static final m4.h f١٨٤٨٠b = m4.h.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final m4.h f١٨٤٨١c = m4.h.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a, reason: collision with root package name */
    private final p4.b f١٨٤٨٢a;

    public c(p4.b bVar) {
        this.f١٨٤٨٢a = bVar;
    }

    private Bitmap.CompressFormat c(Bitmap bitmap, m4.i iVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.a(f١٨٤٨١c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // m4.l
    public m4.c a(m4.i iVar) {
        return m4.c.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #4 {all -> 0x0056, blocks: (B:3:0x0021, B:14:0x0052, B:17:0x0070, B:19:0x0076, B:45:0x00c2, B:43:0x00c5, B:37:0x006b), top: B:2:0x0021 }] */
    @Override // m4.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean encode(o4.v vVar, File file, m4.i iVar) {
        boolean z10;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = (Bitmap) vVar.get();
        Bitmap.CompressFormat c10 = c(bitmap, iVar);
        g5.b.d("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), c10);
        try {
            long b10 = f5.g.b();
            int intValue = ((Integer) iVar.a(f١٨٤٨٠b)).intValue();
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e10) {
                e = e10;
            }
            try {
                if (this.f١٨٤٨٢a != null) {
                    outputStream = new com.bumptech.glide.load.data.c(fileOutputStream, this.f١٨٤٨٢a);
                } else {
                    outputStream = fileOutputStream;
                }
                bitmap.compress(c10, intValue, outputStream);
                outputStream.close();
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
                z10 = true;
            } catch (IOException e11) {
                e = e11;
                outputStream = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                z10 = false;
                if (Log.isLoggable("BitmapEncoder", 2)) {
                }
                return z10;
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + c10 + " of size " + f5.l.i(bitmap) + " in " + f5.g.a(b10) + ", options format: " + iVar.a(f١٨٤٨١c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z10;
        } finally {
            g5.b.e();
        }
    }
}
