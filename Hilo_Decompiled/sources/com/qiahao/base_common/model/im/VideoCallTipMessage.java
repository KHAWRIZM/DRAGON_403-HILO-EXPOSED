package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/qiahao/base_common/model/im/VideoCallTipMessage;", "", "callStatus", "", "duration", "identifier", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCallStatus", "()Ljava/lang/Integer;", "setCallStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDuration", "setDuration", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/VideoCallTipMessage;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class VideoCallTipMessage {

    @Nullable
    private Integer callStatus;

    @Nullable
    private Integer duration;

    @Nullable
    private String identifier;

    public VideoCallTipMessage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoCallTipMessage copy$default(VideoCallTipMessage videoCallTipMessage, Integer num, Integer num2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = videoCallTipMessage.callStatus;
        }
        if ((i10 & 2) != 0) {
            num2 = videoCallTipMessage.duration;
        }
        if ((i10 & 4) != 0) {
            str = videoCallTipMessage.identifier;
        }
        return videoCallTipMessage.copy(num, num2, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCallStatus() {
        return this.callStatus;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final VideoCallTipMessage copy(@Nullable Integer callStatus, @Nullable Integer duration, @Nullable String identifier) {
        return new VideoCallTipMessage(callStatus, duration, identifier);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallTipMessage)) {
            return false;
        }
        VideoCallTipMessage videoCallTipMessage = (VideoCallTipMessage) other;
        return Intrinsics.areEqual(this.callStatus, videoCallTipMessage.callStatus) && Intrinsics.areEqual(this.duration, videoCallTipMessage.duration) && Intrinsics.areEqual(this.identifier, videoCallTipMessage.identifier);
    }

    @Nullable
    public final Integer getCallStatus() {
        return this.callStatus;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        Integer num = this.callStatus;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.duration;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.identifier;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setCallStatus(@Nullable Integer num) {
        this.callStatus = num;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "VideoCallTipMessage(callStatus=" + this.callStatus + ", duration=" + this.duration + ", identifier=" + this.identifier + ")";
    }

    public VideoCallTipMessage(@Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        this.callStatus = num;
        this.duration = num2;
        this.identifier = str;
    }

    public /* synthetic */ VideoCallTipMessage(Integer num, Integer num2, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : str);
    }
}
