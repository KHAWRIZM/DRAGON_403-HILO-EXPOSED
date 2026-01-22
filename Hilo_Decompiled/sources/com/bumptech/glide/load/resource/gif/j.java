package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.liulishuo.okdownload.DownloadTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import m4.k;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j implements k {

    /* renamed from: a, reason: collision with root package name */
    private final List f٧٥١٥a;

    /* renamed from: b, reason: collision with root package name */
    private final k f٧٥١٦b;

    /* renamed from: c, reason: collision with root package name */
    private final p4.b f٧٥١٧c;

    public j(List list, k kVar, p4.b bVar) {
        this.f٧٥١٥a = list;
        this.f٧٥١٦b = kVar;
        this.f٧٥١٧c = bVar;
    }

    private static byte[] c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        try {
            byte[] bArr = new byte[DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e10);
                return null;
            }
            return null;
        }
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(InputStream inputStream, int i10, int i11, m4.i iVar) {
        byte[] c10 = c(inputStream);
        if (c10 == null) {
            return null;
        }
        return this.f٧٥١٦b.decode(ByteBuffer.wrap(c10), i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(InputStream inputStream, m4.i iVar) {
        if (!((Boolean) iVar.a(i.f٧٥١٤b)).booleanValue() && com.bumptech.glide.load.a.f(this.f٧٥١٥a, inputStream, this.f٧٥١٧c) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }
}
