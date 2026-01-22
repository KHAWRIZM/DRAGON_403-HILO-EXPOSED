package tech.sud.runtime.component.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import tech.sud.runtime.core.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class FileOperation {
    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    try {
                        file2.delete();
                    } catch (Exception unused) {
                    }
                } else if (file2.exists()) {
                    a(file2);
                    file2.delete();
                }
            }
        }
    }

    public static float getMediaDuration(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (str.startsWith("/")) {
                mediaMetadataRetriever.setDataSource(str);
            } else {
                AssetFileDescriptor openFd = b.b().getAssets().openFd(str);
                mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            }
            return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) * 0.001f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static void saveImageDataToAlbum(String str, byte[] bArr) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        if (file.exists() || file.mkdirs()) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray != null) {
                    File file2 = new File(file, str);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Uri fromFile = Uri.fromFile(file2);
                    Context b = b.b();
                    if (b != null) {
                        b.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
