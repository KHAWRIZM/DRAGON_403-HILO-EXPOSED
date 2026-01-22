package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.ProtectedPointer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private String domain;
    private Handler handler;
    Intenalcb intenalcb;
    private int mode;
    private ProtectedPointer pptr4sessionNativePtr;
    private int pubkey_seqnum;
    SessionCb sessionCallBack;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream;
    private HandlerThread thread;
    private Object userData;
    private AtomicBoolean closed = new AtomicBoolean();
    private boolean sessionClearedFromSessionMgr = false;
    private Object lock = new Object();
    private int streamcount = 1;
    volatile int refcount = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdySession(long j, SpdyAgent spdyAgent, String str, String str2, SessionCb sessionCb, int i, int i2, Object obj) {
        this.spdyStream = null;
        this.sessionCallBack = null;
        this.pubkey_seqnum = 0;
        this.userData = null;
        this.sessionNativePtr = j;
        ProtectedPointer protectedPointer = new ProtectedPointer(this);
        this.pptr4sessionNativePtr = protectedPointer;
        protectedPointer.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() { // from class: org.android.spdy.SpdySession.1
            @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
            public void close(Object obj2) {
                SpdySession spdySession = (SpdySession) obj2;
                spdySession.NotifyNotInvokeAnyMoreN(spdySession.sessionNativePtr);
                spdySession.setSessionNativePtr(0L);
            }
        });
        this.agent = spdyAgent;
        this.authority = str;
        this.intenalcb = new SpdySessionCallBack();
        this.domain = str2;
        this.spdyStream = new NetSparseArray<>(5);
        this.sessionCallBack = sessionCb;
        this.pubkey_seqnum = i2;
        this.mode = i;
        this.userData = obj;
        this.closed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int NotifyNotInvokeAnyMoreN(long j);

    private int closeprivate() {
        synchronized (this.lock) {
            try {
                if (!this.sessionClearedFromSessionMgr) {
                    this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                    this.sessionClearedFromSessionMgr = true;
                }
            } finally {
            }
        }
        synchronized (this.lock) {
            try {
                SpdyStreamContext[] allStreamCb = getAllStreamCb();
                if (allStreamCb != null) {
                    for (SpdyStreamContext spdyStreamContext : allStreamCb) {
                        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] unfinished stm=" + spdyStreamContext.streamId);
                        spdyStreamContext.callBack.spdyStreamCloseCallback(this, (long) spdyStreamContext.streamId, -2001, spdyStreamContext.streamContext, null);
                    }
                }
                this.spdyStream.clear();
            } finally {
            }
        }
        return 0;
    }

    private String getAuthority() {
        return this.authority;
    }

    private native int sendCustomControlFrameN(long j, int i, int i2, int i3, int i4, byte[] bArr);

    private native int sendHeadersN(long j, int i, String[] strArr, boolean z);

    private native int setOptionN(long j, int i, int i2);

    private native int streamCloseN(long j, int i, int i2);

    private native int streamSendDataN(long j, int i, byte[] bArr, int i2, int i3, boolean z);

    private native int submitBioPingN(long j);

    private native int submitPingN(long j);

    private native int submitRequestN(long j, String str, byte b, String[] strArr, byte[] bArr, boolean z, int i, int i2, int i3);

    public int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (!this.closed.getAndSet(true)) {
            this.agent.removeSession(this);
            return closeprivate();
        }
        return 0;
    }

    public void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    int closeInternal() {
        if (!this.closed.getAndSet(true)) {
            return closeprivate();
        }
        return 0;
    }

    public int closeSession() {
        int i;
        ProtectedPointer protectedPointer;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            i = 0;
            if (!this.sessionClearedFromSessionMgr) {
                spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - " + this.authority);
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
                if (this.pptr4sessionNativePtr.enter()) {
                    try {
                        try {
                            i = this.agent.closeSession(this.sessionNativePtr);
                            protectedPointer = this.pptr4sessionNativePtr;
                        } catch (UnsatisfiedLinkError e) {
                            e.printStackTrace();
                            protectedPointer = this.pptr4sessionNativePtr;
                        }
                        protectedPointer.exit();
                    } catch (Throwable th) {
                        this.pptr4sessionNativePtr.exit();
                        throw th;
                    }
                } else {
                    i = -2001;
                }
            }
        }
        return i;
    }

    public SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            try {
                int size = this.spdyStream.size();
                if (size > 0) {
                    spdyStreamContextArr = new SpdyStreamContext[size];
                    this.spdyStream.toArray(spdyStreamContextArr);
                } else {
                    spdyStreamContextArr = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return spdyStreamContextArr;
    }

    public String getDomain() {
        return this.domain;
    }

    Handler getMsgHandler() {
        return this.handler;
    }

    public int getRefCount() {
        return this.refcount;
    }

    long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyStreamContext getSpdyStream(int i) {
        SpdyStreamContext spdyStreamContext;
        if (i > 0) {
            synchronized (this.lock) {
                spdyStreamContext = this.spdyStream.get(i);
            }
            return spdyStreamContext;
        }
        return null;
    }

    public Object getUserData() {
        return this.userData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increRefCount() {
        this.refcount++;
    }

    int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i;
        synchronized (this.lock) {
            i = this.streamcount;
            this.streamcount = i + 1;
            this.spdyStream.put(i, spdyStreamContext);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releasePptr() {
        this.pptr4sessionNativePtr.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSpdyStream(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i);
            }
        }
    }

    public int sendCustomControlFrame(int i, int i2, int i3, int i4, byte[] bArr) throws SpdyErrorException {
        int i5;
        sessionIsOpen();
        if (bArr != null && bArr.length <= 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        spduLog.Logi("tnet-jni", "[sendCustomControlFrame] - type: " + i2);
        if (this.pptr4sessionNativePtr.enter()) {
            i5 = sendCustomControlFrameN(this.sessionNativePtr, i, i2, i3, i4, bArr2);
            this.pptr4sessionNativePtr.exit();
        } else {
            i5 = -2001;
        }
        if (i5 == 0) {
            return i5;
        }
        throw new SpdyErrorException("sendCustomControlFrame error: " + i5, i5);
    }

    void sessionIsOpen() {
        if (!this.closed.get()) {
        } else {
            throw new SpdyErrorException("session is already closed: -1104", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    public int setOption(int i, int i2) throws SpdyErrorException {
        int i3;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i3 = setOptionN(this.sessionNativePtr, i, i2);
            this.pptr4sessionNativePtr.exit();
        } else {
            i3 = -2001;
        }
        if (i3 == 0) {
            return i3;
        }
        throw new SpdyErrorException("setOption error: " + i3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSessionNativePtr(long j) {
        this.sessionNativePtr = j;
    }

    public int streamReset(long j, int i) throws SpdyErrorException {
        int i2;
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        if (this.pptr4sessionNativePtr.enter()) {
            i2 = streamCloseN(this.sessionNativePtr, (int) j, i);
            this.pptr4sessionNativePtr.exit();
        } else {
            i2 = -2001;
        }
        if (i2 == 0) {
            return i2;
        }
        throw new SpdyErrorException("streamReset error: " + i2, i2);
    }

    @Deprecated
    public int submitBioPing() throws SpdyErrorException {
        int i;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i = submitBioPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i = -2001;
        }
        if (i == 0) {
            return i;
        }
        throw new SpdyErrorException("submitBioPing error: " + i, i);
    }

    public int submitPing() throws SpdyErrorException {
        int i;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i = submitPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i = -2001;
        }
        if (i == 0) {
            return i;
        }
        throw new SpdyErrorException("submitPing error: " + i, i);
    }

    public int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) throws SpdyErrorException {
        boolean z;
        SpdyStreamContext spdyStreamContext;
        String str;
        int i;
        if (spdyRequest != null && obj != null && spdyRequest.getAuthority() != null) {
            sessionIsOpen();
            byte[] dataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
            if (dataproviderToByteArray != null && dataproviderToByteArray.length <= 0) {
                dataproviderToByteArray = null;
            }
            byte[] bArr = dataproviderToByteArray;
            if (spdyDataProvider != null) {
                z = spdyDataProvider.finished;
            } else {
                z = true;
            }
            SpdyStreamContext spdyStreamContext2 = new SpdyStreamContext(obj, spdycb);
            int putSpdyStreamCtx = putSpdyStreamCtx(spdyStreamContext2);
            String[] mapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
            spduLog.Logi("tnet-jni", "index=" + putSpdyStreamCtx + "  starttime=" + System.currentTimeMillis());
            if (this.pptr4sessionNativePtr.enter()) {
                spdyStreamContext = spdyStreamContext2;
                str = "tnet-jni";
                i = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), mapToByteArray, bArr, z, putSpdyStreamCtx, spdyRequest.getRequestTimeoutMs(), spdyRequest.getRequestRdTimeoutMs());
                this.pptr4sessionNativePtr.exit();
            } else {
                spdyStreamContext = spdyStreamContext2;
                str = "tnet-jni";
                i = -2001;
            }
            spduLog.Logi(str, "index=" + putSpdyStreamCtx + "   calltime=" + System.currentTimeMillis());
            if (i >= 0) {
                spdyStreamContext.streamId = i;
                return i;
            }
            removeSpdyStream(putSpdyStreamCtx);
            throw new SpdyErrorException("submitRequest error: " + i, i);
        }
        throw new SpdyErrorException("submitRequest error: -1102", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }
}
