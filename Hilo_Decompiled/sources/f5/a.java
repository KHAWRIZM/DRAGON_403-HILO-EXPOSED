package f5;

import com.liulishuo.okdownload.DownloadTask;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference f١٤٠٥٢a = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f١٤٠٥٥a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٤٠٥٦b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f١٤٠٥٧c;

        b(byte[] bArr, int i10, int i11) {
            this.f١٤٠٥٧c = bArr;
            this.f١٤٠٥٥a = i10;
            this.f١٤٠٥٦b = i11;
        }
    }

    public static ByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        byte[] bArr = (byte[]) f١٤٠٥٢a.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                f١٤٠٥٢a.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    private static b c(ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return null;
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        b c10 = c(byteBuffer);
        if (c10 != null && c10.f١٤٠٥٥a == 0 && c10.f١٤٠٥٦b == c10.f١٤٠٥٧c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        d(asReadOnlyBuffer);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void f(ByteBuffer byteBuffer, File file) {
        RandomAccessFile randomAccessFile;
        d(byteBuffer);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream g(ByteBuffer byteBuffer) {
        return new C٠١٦١a(byteBuffer);
    }

    /* renamed from: f5.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class C٠١٦١a extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f١٤٠٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٤٠٥٤b = -1;

        C٠١٦١a(ByteBuffer byteBuffer) {
            this.f١٤٠٥٣a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f١٤٠٥٣a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i10) {
            this.f١٤٠٥٤b = this.f١٤٠٥٣a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f١٤٠٥٣a.hasRemaining()) {
                return this.f١٤٠٥٣a.get() & UByte.MAX_VALUE;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i10 = this.f١٤٠٥٤b;
            if (i10 != -1) {
                this.f١٤٠٥٣a.position(i10);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (!this.f١٤٠٥٣a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j10, available());
            this.f١٤٠٥٣a.position((int) (r0.position() + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            if (!this.f١٤٠٥٣a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i11, available());
            this.f١٤٠٥٣a.get(bArr, i10, min);
            return min;
        }
    }
}
