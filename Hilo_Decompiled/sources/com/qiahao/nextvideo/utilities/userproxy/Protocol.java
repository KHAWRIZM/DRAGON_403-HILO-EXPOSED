package com.qiahao.nextvideo.utilities.userproxy;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.taobao.accs.common.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/utilities/userproxy/Protocol;", "", Constants.SP_KEY_VERSION, "", "msgType", "", "msgID", "", "timestamp", "dataSize", "data", "", "remoteCrc35", "localCrc35", "<init>", "(SIJJI[BJJ)V", "getVersion", "()S", "getMsgType", "()I", "getMsgID", "()J", "getTimestamp", "getDataSize", "getData", "()[B", "getRemoteCrc35", "getLocalCrc35", "onSuccess", "", "onError", "equals", "", "other", "hashCode", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Protocol {

    @NotNull
    private final byte[] data;
    private final int dataSize;
    private final long localCrc35;
    private final long msgID;
    private final int msgType;
    private final long remoteCrc35;
    private final long timestamp;
    private final short version;

    public Protocol(short s, int i, long j, long j2, int i2, @NotNull byte[] bArr, long j3, long j4) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.version = s;
        this.msgType = i;
        this.msgID = j;
        this.timestamp = j2;
        this.dataSize = i2;
        this.data = bArr;
        this.remoteCrc35 = j3;
        this.localCrc35 = j4;
    }

    /* renamed from: component1, reason: from getter */
    public final short getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMsgType() {
        return this.msgType;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMsgID() {
        return this.msgID;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDataSize() {
        return this.dataSize;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: component7, reason: from getter */
    public final long getRemoteCrc35() {
        return this.remoteCrc35;
    }

    /* renamed from: component8, reason: from getter */
    public final long getLocalCrc35() {
        return this.localCrc35;
    }

    @NotNull
    public final Protocol copy(short version, int msgType, long msgID, long timestamp, int dataSize, @NotNull byte[] data, long remoteCrc35, long localCrc35) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Protocol(version, msgType, msgID, timestamp, dataSize, data, remoteCrc35, localCrc35);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(Protocol.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.qiahao.nextvideo.utilities.userproxy.Protocol");
        Protocol protocol = (Protocol) other;
        if (this.version == protocol.version && this.msgType == protocol.msgType && this.msgID == protocol.msgID && this.timestamp == protocol.timestamp && this.dataSize == protocol.dataSize && Arrays.equals(this.data, protocol.data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final byte[] getData() {
        return this.data;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final long getLocalCrc35() {
        return this.localCrc35;
    }

    public final long getMsgID() {
        return this.msgID;
    }

    public final int getMsgType() {
        return this.msgType;
    }

    public final long getRemoteCrc35() {
        return this.remoteCrc35;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final short getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((this.version * 31) + this.msgType) * 31) + c.a(this.msgID)) * 31) + c.a(this.timestamp)) * 31) + this.dataSize) * 31) + Arrays.hashCode(this.data);
    }

    public final void onError() {
    }

    public final void onSuccess() {
    }

    @NotNull
    public String toString() {
        short s = this.version;
        return "protocal version: " + ((int) s) + ", msgType: " + this.msgType + ", msgID: " + this.msgID + ", timestamp: " + this.timestamp + ", dataSize: " + this.dataSize + ", data: " + this.data + "crc32: [remote: " + this.remoteCrc35 + ", local: " + this.localCrc35 + "]}";
    }
}
