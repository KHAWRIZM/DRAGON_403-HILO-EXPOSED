package tech.sud.gip.asr.base.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ByteArrayBlockingQueue implements Serializable {
    private static final long serialVersionUID = -817911632652898426L;
    int count;
    final byte[] items;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    int putIndex;
    int takeIndex;

    public ByteArrayBlockingQueue(int i) {
        this(i, false);
    }

    private static void checkNotNull(Object obj) {
        obj.getClass();
    }

    private byte dequeue() {
        byte[] bArr = this.items;
        int i = this.takeIndex;
        byte b = bArr[i];
        bArr[i] = 0;
        this.takeIndex = inc(i);
        this.count--;
        this.notFull.signal();
        return b;
    }

    private void enqueue(byte b) {
        byte[] bArr = this.items;
        int i = this.putIndex;
        bArr[i] = b;
        this.putIndex = inc(i);
        this.count++;
        this.notEmpty.signal();
    }

    public void clear() {
        byte[] bArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            if (i > 0) {
                int i2 = this.putIndex;
                int i3 = this.takeIndex;
                do {
                    bArr[i3] = 0;
                    i3 = inc(i3);
                } while (i3 != i2);
                this.takeIndex = i2;
                this.count = 0;
                while (i > 0) {
                    if (!reentrantLock.hasWaiters(this.notFull)) {
                        break;
                    }
                    this.notFull.signal();
                    i--;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        byte[] bArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count > 0) {
                int i = this.putIndex;
                int i2 = this.takeIndex;
                while (!obj.equals(Byte.valueOf(bArr[i2]))) {
                    i2 = inc(i2);
                    if (i2 == i) {
                    }
                }
                reentrantLock.unlock();
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int dec(int i) {
        if (i == 0) {
            i = this.items.length;
        }
        return i - 1;
    }

    public final int inc(int i, int i2) {
        int length = this.items.length;
        int i3 = i + i2;
        return i3 >= length ? i3 % length : i3;
    }

    public final byte itemAt(int i) {
        return this.items[i];
    }

    public boolean offer(byte b) {
        checkNotNull(Byte.valueOf(b));
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count == this.items.length) {
                reentrantLock.unlock();
                return false;
            }
            enqueue(b);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean offerBuffer(byte[] bArr) {
        checkNotNull(bArr);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            byte[] bArr2 = this.items;
            int i2 = 0;
            if (i != bArr2.length && i + bArr.length <= bArr2.length) {
                while (i2 < bArr.length) {
                    i2 += enqueue(bArr, i2);
                }
                this.notEmpty.signal();
                reentrantLock.unlock();
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public byte peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return itemAt(this.takeIndex);
        } finally {
            reentrantLock.unlock();
        }
    }

    public byte poll() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count == 0 ? (byte) 0 : dequeue();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(byte b) {
        checkNotNull(Byte.valueOf(b));
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                this.notFull.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        enqueue(b);
        reentrantLock.unlock();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.items.length - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        byte[] bArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count > 0) {
                int i = this.putIndex;
                int i2 = this.takeIndex;
                while (!obj.equals(Byte.valueOf(bArr[i2]))) {
                    i2 = inc(i2);
                    if (i2 == i) {
                    }
                }
                removeAt(i2);
                reentrantLock.unlock();
                return true;
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void removeAt(int i) {
        byte[] bArr = this.items;
        int i2 = this.takeIndex;
        if (i == i2) {
            bArr[i2] = 0;
            this.takeIndex = inc(i2);
            this.count--;
        } else {
            int i3 = this.putIndex;
            while (true) {
                int inc = inc(i);
                if (inc == i3) {
                    break;
                }
                bArr[i] = bArr[inc];
                i = inc;
            }
            bArr[i] = 0;
            this.putIndex = i;
            this.count--;
        }
        this.notFull.signal();
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public byte take() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        byte dequeue = dequeue();
        reentrantLock.unlock();
        return dequeue;
    }

    public int takeBuffer(byte[] bArr, int i) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        int dequeue = dequeue(bArr, i);
        reentrantLock.unlock();
        return dequeue;
    }

    public byte[] toArray() {
        byte[] bArr = this.items;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            byte[] bArr2 = new byte[i];
            int length = bArr.length;
            int i2 = this.takeIndex;
            int i3 = length - i2;
            if (i <= i3) {
                System.arraycopy(bArr, i2, bArr2, 0, i);
            } else {
                System.arraycopy(bArr, i2, bArr2, 0, i3);
                System.arraycopy(bArr, 0, bArr2, i3, i - i3);
            }
            reentrantLock.unlock();
            return bArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.count;
            if (i == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            int i2 = this.takeIndex;
            while (true) {
                Object valueOf = Byte.valueOf(this.items[i2]);
                if (valueOf == this) {
                    valueOf = "(this Collection)";
                }
                sb2.append(valueOf);
                i--;
                if (i == 0) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(',');
                sb2.append(' ');
                i2 = inc(i2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public ByteArrayBlockingQueue(int i, boolean z) {
        if (i > 0) {
            this.items = new byte[i];
            ReentrantLock reentrantLock = new ReentrantLock(z);
            this.lock = reentrantLock;
            this.notEmpty = reentrantLock.newCondition();
            this.notFull = reentrantLock.newCondition();
            return;
        }
        throw new IllegalArgumentException();
    }

    public final int inc(int i) {
        int i2 = i + 1;
        if (i2 == this.items.length) {
            return 0;
        }
        return i2;
    }

    private int enqueue(byte[] bArr, int i) {
        int min = Math.min(this.items.length - this.putIndex, bArr.length - i);
        System.arraycopy(bArr, i, this.items, this.putIndex, min);
        this.putIndex = inc(this.putIndex, min);
        this.count += min;
        return min;
    }

    private int dequeue(byte[] bArr, int i) {
        byte[] bArr2 = this.items;
        int min = Math.min(Math.min(this.count, bArr2.length - this.takeIndex), bArr.length - i);
        System.arraycopy(bArr2, this.takeIndex, bArr, i, min);
        this.takeIndex = inc(this.takeIndex, min);
        this.count -= min;
        this.notFull.signal();
        return min;
    }

    public byte poll(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return (byte) 0;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        byte dequeue = dequeue();
        reentrantLock.unlock();
        return dequeue;
    }

    public ByteArrayBlockingQueue(int i, boolean z, Collection<Byte> collection) {
        this(i, z);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            try {
                int i2 = 0;
                int i3 = 0;
                for (Byte b : collection) {
                    checkNotNull(b);
                    int i4 = i3 + 1;
                    this.items[i3] = b.byteValue();
                    i3 = i4;
                }
                this.count = i3;
                if (i3 != i) {
                    i2 = i3;
                }
                this.putIndex = i2;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offer(byte b, long j, TimeUnit timeUnit) {
        checkNotNull(Byte.valueOf(b));
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        enqueue(b);
        reentrantLock.unlock();
        return true;
    }
}
