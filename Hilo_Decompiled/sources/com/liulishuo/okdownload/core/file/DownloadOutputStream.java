package com.liulishuo.okdownload.core.file;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface DownloadOutputStream {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Factory {
        DownloadOutputStream create(Context context, Uri uri, int i10);

        DownloadOutputStream create(Context context, File file, int i10);

        boolean supportSeek();
    }

    void close();

    void flushAndSync();

    void seek(long j10);

    void setLength(long j10);

    void write(byte[] bArr, int i10, int i11);
}
