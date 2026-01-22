package sf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class c {
    private e a;
    private File b;
    private int c;
    private int d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, File file, boolean z) {
        this.b = file;
        this.a = eVar;
        this.e = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(eVar.open(), null, options);
        this.c = options.outWidth;
        this.d = options.outHeight;
    }

    private int b() {
        int i = this.c;
        if (i % 2 == 1) {
            i++;
        }
        this.c = i;
        int i2 = this.d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.d = i2;
        int max = Math.max(i, i2);
        float min = Math.min(this.c, this.d) / max;
        if (min <= 1.0f && min > 0.5625d) {
            if (max < 1664) {
                return 1;
            }
            if (max < 4990) {
                return 2;
            }
            if (max > 4990 && max < 10240) {
                return 4;
            }
            return max / 1280;
        }
        double d = min;
        if (d <= 0.5625d && d > 0.5d) {
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        }
        return (int) Math.ceil(max / (1280.0d / d));
    }

    private Bitmap c(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a() {
        Bitmap.CompressFormat compressFormat;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeStream = BitmapFactory.decodeStream(this.a.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = a.SINGLE;
        if (aVar.g(this.a.open())) {
            decodeStream = c(decodeStream, aVar.d(this.a.open()));
        }
        if (!this.e && !decodeStream.hasAlpha()) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        decodeStream.compress(compressFormat, 60, byteArrayOutputStream);
        decodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.b);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.b;
    }
}
