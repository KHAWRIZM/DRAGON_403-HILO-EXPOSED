package k0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements SeekableByteChannel {
    private final List<SeekableByteChannel> channels;
    private int currentChannelIdx;
    private long globalPosition;

    public i(List list) {
        Objects.requireNonNull(list, "channels must not be null");
        this.channels = Collections.unmodifiableList(new ArrayList(list));
    }

    public static SeekableByteChannel forSeekableByteChannels(SeekableByteChannel... seekableByteChannelArr) {
        Objects.requireNonNull(seekableByteChannelArr, "channels must not be null");
        if (seekableByteChannelArr.length == 1) {
            return seekableByteChannelArr[0];
        }
        return new i(Arrays.asList(seekableByteChannelArr));
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<SeekableByteChannel> it = this.channels.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            try {
                b.a(it.next()).close();
            } catch (IOException e10) {
                if (iOException == null) {
                    iOException = e10;
                }
            }
        }
        if (iOException == null) {
        } else {
            throw new IOException("failed to close wrapped channel", iOException);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        boolean isOpen;
        Iterator<SeekableByteChannel> it = this.channels.iterator();
        while (it.hasNext()) {
            isOpen = b.a(it.next()).isOpen();
            if (!isOpen) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.globalPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        int read;
        long position;
        long size;
        try {
            if (isOpen()) {
                int i10 = 0;
                if (!byteBuffer.hasRemaining()) {
                    return 0;
                }
                while (byteBuffer.hasRemaining() && this.currentChannelIdx < this.channels.size()) {
                    SeekableByteChannel a10 = b.a(this.channels.get(this.currentChannelIdx));
                    read = a10.read(byteBuffer);
                    if (read != -1) {
                        position = a10.position();
                        size = a10.size();
                        if (position >= size) {
                            this.currentChannelIdx++;
                        }
                        i10 += read;
                    } else {
                        this.currentChannelIdx++;
                    }
                }
                if (i10 <= 0) {
                    return -1;
                }
                this.globalPosition += i10;
                return i10;
            }
            throw new ClosedChannelException();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        long size;
        if (isOpen()) {
            Iterator<SeekableByteChannel> it = this.channels.iterator();
            long j10 = 0;
            while (it.hasNext()) {
                size = b.a(it.next()).size();
                j10 += size;
            }
            return j10;
        }
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j10) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    public synchronized SeekableByteChannel position(long j10, long j11) {
        long size;
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            for (int i10 = 0; i10 < j10; i10++) {
                size = b.a(this.channels.get(i10)).size();
                j11 += size;
            }
        } catch (Throwable th) {
            throw th;
        }
        return position(j11);
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j10) {
        long size;
        try {
            if (j10 >= 0) {
                if (isOpen()) {
                    this.globalPosition = j10;
                    int i10 = 0;
                    while (i10 < this.channels.size()) {
                        SeekableByteChannel a10 = b.a(this.channels.get(i10));
                        size = a10.size();
                        long j11 = -1;
                        if (j10 == -1) {
                            j11 = j10;
                            j10 = 0;
                        } else if (j10 <= size) {
                            this.currentChannelIdx = i10;
                        } else {
                            j11 = j10 - size;
                            j10 = size;
                        }
                        a10.position(j10);
                        i10++;
                        j10 = j11;
                    }
                } else {
                    throw new ClosedChannelException();
                }
            } else {
                throw new IllegalArgumentException("Negative position: " + j10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }
}
