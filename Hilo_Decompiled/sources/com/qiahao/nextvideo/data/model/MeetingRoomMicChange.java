package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MeetingRoomMicChange;", "", "micOn", "", "micNumType", "", "timestamp", "", "<init>", "(ZIJ)V", "getMicOn", "()Z", "getMicNumType", "()I", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MeetingRoomMicChange {
    private final int micNumType;
    private final boolean micOn;
    private final long timestamp;

    public MeetingRoomMicChange(boolean z, int i, long j) {
        this.micOn = z;
        this.micNumType = i;
        this.timestamp = j;
    }

    public static /* synthetic */ MeetingRoomMicChange copy$default(MeetingRoomMicChange meetingRoomMicChange, boolean z, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = meetingRoomMicChange.micOn;
        }
        if ((i2 & 2) != 0) {
            i = meetingRoomMicChange.micNumType;
        }
        if ((i2 & 4) != 0) {
            j = meetingRoomMicChange.timestamp;
        }
        return meetingRoomMicChange.copy(z, i, j);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getMicOn() {
        return this.micOn;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMicNumType() {
        return this.micNumType;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final MeetingRoomMicChange copy(boolean micOn, int micNumType, long timestamp) {
        return new MeetingRoomMicChange(micOn, micNumType, timestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeetingRoomMicChange)) {
            return false;
        }
        MeetingRoomMicChange meetingRoomMicChange = (MeetingRoomMicChange) other;
        return this.micOn == meetingRoomMicChange.micOn && this.micNumType == meetingRoomMicChange.micNumType && this.timestamp == meetingRoomMicChange.timestamp;
    }

    public final int getMicNumType() {
        return this.micNumType;
    }

    public final boolean getMicOn() {
        return this.micOn;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((a.a(this.micOn) * 31) + this.micNumType) * 31) + c.a(this.timestamp);
    }

    @NotNull
    public String toString() {
        return "MeetingRoomMicChange(micOn=" + this.micOn + ", micNumType=" + this.micNumType + ", timestamp=" + this.timestamp + ")";
    }
}
