package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.entity.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ParcelableInputStreamImpl extends ParcelableInputStream.Stub {
    private static final ByteArray EOS = ByteArray.create(0);
    private static final String TAG = "anet.ParcelableInputStreamImpl";
    private int blockIndex;
    private int blockOffset;
    private int contentLength;
    final ReentrantLock lock;
    final Condition newDataArrive;
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private LinkedList<ByteArray> byteList = new LinkedList<>();
    private int rto = 10000;
    private String seqNo = "";

    public ParcelableInputStreamImpl() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.newDataArrive = reentrantLock.newCondition();
    }

    private void recycleCurrentItem() {
        this.lock.lock();
        try {
            this.byteList.set(this.blockIndex, EOS).recycle();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int available() throws RemoteException {
        if (!this.isClosed.get()) {
            this.lock.lock();
            try {
                int i10 = 0;
                if (this.blockIndex == this.byteList.size()) {
                    this.lock.unlock();
                    return 0;
                }
                ListIterator<ByteArray> listIterator = this.byteList.listIterator(this.blockIndex);
                while (listIterator.hasNext()) {
                    i10 += listIterator.next().getDataLength();
                }
                int i11 = i10 - this.blockOffset;
                this.lock.unlock();
                return i11;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        throw new RuntimeException("Stream is closed");
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public void close() throws RemoteException {
        if (this.isClosed.compareAndSet(false, true)) {
            this.lock.lock();
            try {
                Iterator<ByteArray> it = this.byteList.iterator();
                while (it.hasNext()) {
                    ByteArray next = it.next();
                    if (next != EOS) {
                        next.recycle();
                    }
                }
                this.byteList.clear();
                this.byteList = null;
                this.blockIndex = -1;
                this.blockOffset = -1;
                this.contentLength = 0;
                this.lock.unlock();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    public void init(g gVar, int i10) {
        this.contentLength = i10;
        this.seqNo = gVar.f٥٢٢٨e;
        this.rto = gVar.f٥٢٢٧d;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int length() throws RemoteException {
        return this.contentLength;
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int read(byte[] bArr) throws RemoteException {
        return readBytes(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readByte() throws RemoteException {
        byte b10;
        if (!this.isClosed.get()) {
            this.lock.lock();
            while (true) {
                try {
                    try {
                        if (this.blockIndex == this.byteList.size() && !this.newDataArrive.await(this.rto, TimeUnit.MILLISECONDS)) {
                            close();
                            throw new RuntimeException("await timeout.");
                        }
                        ByteArray byteArray = this.byteList.get(this.blockIndex);
                        if (byteArray == EOS) {
                            b10 = -1;
                            break;
                        }
                        if (this.blockOffset < byteArray.getDataLength()) {
                            byte[] buffer = byteArray.getBuffer();
                            int i10 = this.blockOffset;
                            b10 = buffer[i10];
                            this.blockOffset = i10 + 1;
                            break;
                        }
                        recycleCurrentItem();
                        this.blockIndex++;
                        this.blockOffset = 0;
                    } catch (InterruptedException unused) {
                        close();
                        throw new RuntimeException("await interrupt");
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return b10;
        }
        throw new RuntimeException("Stream is closed");
    }

    /* JADX WARN: Finally extract failed */
    @Override // anetwork.channel.aidl.ParcelableInputStream
    public int readBytes(byte[] bArr, int i10, int i11) throws RemoteException {
        int i12;
        if (!this.isClosed.get()) {
            bArr.getClass();
            if (i10 >= 0 && i11 >= 0 && (i12 = i11 + i10) <= bArr.length) {
                this.lock.lock();
                int i13 = i10;
                while (i13 < i12) {
                    try {
                        try {
                            if (this.blockIndex == this.byteList.size() && !this.newDataArrive.await(this.rto, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            ByteArray byteArray = this.byteList.get(this.blockIndex);
                            if (byteArray == EOS) {
                                break;
                            }
                            int dataLength = byteArray.getDataLength() - this.blockOffset;
                            int i14 = i12 - i13;
                            if (dataLength < i14) {
                                System.arraycopy(byteArray.getBuffer(), this.blockOffset, bArr, i13, dataLength);
                                i13 += dataLength;
                                recycleCurrentItem();
                                this.blockIndex++;
                                this.blockOffset = 0;
                            } else {
                                System.arraycopy(byteArray.getBuffer(), this.blockOffset, bArr, i13, i14);
                                this.blockOffset += i14;
                                i13 += i14;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.lock.unlock();
                        throw th;
                    }
                }
                this.lock.unlock();
                int i15 = i13 - i10;
                if (i15 <= 0) {
                    return -1;
                }
                return i15;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new RuntimeException("Stream is closed");
    }

    /* JADX WARN: Finally extract failed */
    @Override // anetwork.channel.aidl.ParcelableInputStream
    public long skip(int i10) throws RemoteException {
        ByteArray byteArray;
        this.lock.lock();
        int i11 = 0;
        while (i11 < i10) {
            try {
                if (this.blockIndex != this.byteList.size() && (byteArray = this.byteList.get(this.blockIndex)) != EOS) {
                    int dataLength = byteArray.getDataLength();
                    int i12 = this.blockOffset;
                    int i13 = i10 - i11;
                    if (dataLength - i12 < i13) {
                        i11 += dataLength - i12;
                        recycleCurrentItem();
                        this.blockIndex++;
                        this.blockOffset = 0;
                    } else {
                        this.blockOffset = i12 + i13;
                        i11 = i10;
                    }
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
        return i11;
    }

    public void write(ByteArray byteArray) {
        if (this.isClosed.get()) {
            return;
        }
        this.lock.lock();
        try {
            this.byteList.add(byteArray);
            this.newDataArrive.signal();
        } finally {
            this.lock.unlock();
        }
    }

    public void writeEnd() {
        write(EOS);
    }
}
