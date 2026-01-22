package com.liulishuo.okdownload.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.file.DownloadOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadUriOutputStream implements DownloadOutputStream {
    private final FileChannel channel;
    final FileOutputStream fos;
    final BufferedOutputStream out;
    final ParcelFileDescriptor pdf;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Factory implements DownloadOutputStream.Factory {
        @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, File file, int i10) {
            return new DownloadUriOutputStream(context, Uri.fromFile(file), i10);
        }

        @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream.Factory
        public boolean supportSeek() {
            return true;
        }

        @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, Uri uri, int i10) {
            return new DownloadUriOutputStream(context, uri, i10);
        }
    }

    public DownloadUriOutputStream(Context context, Uri uri, int i10) {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor != null) {
            this.pdf = openFileDescriptor;
            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
            this.fos = fileOutputStream;
            this.channel = fileOutputStream.getChannel();
            this.out = new BufferedOutputStream(fileOutputStream, i10);
            return;
        }
        throw new FileNotFoundException("result of " + uri + " is null!");
    }

    @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream
    public void close() {
        this.out.close();
        this.fos.close();
        this.pdf.close();
    }

    @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream
    public void flushAndSync() {
        this.out.flush();
        this.pdf.getFileDescriptor().sync();
    }

    @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream
    public void seek(long j10) {
        this.channel.position(j10);
    }

    @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream
    public void setLength(long j10) {
        try {
            Os.posix_fallocate(this.pdf.getFileDescriptor(), 0L, j10);
        } catch (Throwable th) {
            if (th instanceof ErrnoException) {
                int i10 = th.errno;
                if (i10 == OsConstants.ENOSYS || i10 == OsConstants.ENOTSUP) {
                    Util.w("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                    try {
                        Os.ftruncate(this.pdf.getFileDescriptor(), j10);
                        return;
                    } catch (Throwable th2) {
                        Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + j10 + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th2);
                        return;
                    }
                }
                return;
            }
            Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + j10 + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th);
        }
    }

    @Override // com.liulishuo.okdownload.core.file.DownloadOutputStream
    public void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
    }

    public DownloadUriOutputStream(FileChannel fileChannel, ParcelFileDescriptor parcelFileDescriptor, FileOutputStream fileOutputStream, BufferedOutputStream bufferedOutputStream) {
        this.channel = fileChannel;
        this.pdf = parcelFileDescriptor;
        this.fos = fileOutputStream;
        this.out = bufferedOutputStream;
    }
}
