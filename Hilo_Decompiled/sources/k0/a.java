package k0;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f١٥٤٠٤a = new byte[4096];

    public static int a(InputStream inputStream, byte[] bArr, int i10, int i11) {
        if (i11 >= 0 && i10 >= 0 && i11 + i10 <= bArr.length) {
            int i12 = 0;
            while (i12 != i11) {
                int read = inputStream.read(bArr, i10 + i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            }
            return i12;
        }
        throw new IndexOutOfBoundsException();
    }

    public static long b(InputStream inputStream, long j10) {
        int a10;
        long j11 = j10;
        while (j11 > 0) {
            long skip = inputStream.skip(j11);
            if (skip == 0) {
                break;
            }
            j11 -= skip;
        }
        while (j11 > 0 && (a10 = a(inputStream, f١٥٤٠٤a, 0, (int) Math.min(j11, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM))) >= 1) {
            j11 -= a10;
        }
        return j10 - j11;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int i10 = 0;
        while (i10 < remaining) {
            int read = readableByteChannel.read(byteBuffer);
            if (read <= 0) {
                break;
            } else {
                i10 += read;
            }
        }
        if (i10 >= remaining) {
        } else {
            throw new EOFException();
        }
    }
}
