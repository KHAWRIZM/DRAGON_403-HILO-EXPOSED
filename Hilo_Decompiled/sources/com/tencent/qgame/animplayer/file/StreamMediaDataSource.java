package com.tencent.qgame.animplayer.file;

import android.annotation.TargetApi;
import android.media.MediaDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tencent/qgame/animplayer/file/StreamMediaDataSource;", "Landroid/media/MediaDataSource;", "bytes", "", "([B)V", "getBytes", "()[B", "close", "", "getSize", "", "readAt", "", "position", "buffer", "offset", "size", "animplayer_release"}, k = 1, mv = {1, 1, 15})
@TargetApi(23)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class StreamMediaDataSource extends MediaDataSource {

    @NotNull
    private final byte[] bytes;

    public StreamMediaDataSource(@NotNull byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @NotNull
    public final byte[] getBytes() {
        return this.bytes;
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        long length;
        synchronized (Reflection.getOrCreateKotlinClass(StreamMediaDataSource.class)) {
            length = this.bytes.length;
        }
        return length;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long position, @NotNull byte[] buffer, int offset, int size) {
        synchronized (Reflection.getOrCreateKotlinClass(StreamMediaDataSource.class)) {
            byte[] bArr = this.bytes;
            int length = bArr.length;
            long j = length;
            if (position >= j) {
                return -1;
            }
            long j2 = size + position;
            if (j2 > j) {
                size -= ((int) j2) - length;
            }
            System.arraycopy(bArr, (int) position, buffer, offset, size);
            return size;
        }
    }
}
