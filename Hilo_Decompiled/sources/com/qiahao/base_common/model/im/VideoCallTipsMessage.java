package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/qiahao/base_common/model/im/VideoCallTipsMessage;", "Lcom/qiahao/base_common/model/im/TIMCustomMessage;", "callStatus", "", "duration", "identifier", "", "<init>", "(IILjava/lang/String;)V", "getCallStatus", "()I", "setCallStatus", "(I)V", "getDuration", "setDuration", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class VideoCallTipsMessage extends TIMCustomMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int callStatus;
    private int duration;

    @NotNull
    private String identifier;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/model/im/VideoCallTipsMessage$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/base_common/model/im/VideoCallTipsMessage;", "callStatus", "Lcom/qiahao/base_common/model/im/CallStatus;", "durationInSecs", "", "identifier", "Lcom/qiahao/base_common/model/im/Identifier;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VideoCallTipsMessage init$default(Companion companion, CallStatus callStatus, int i10, Identifier identifier, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                identifier = Identifier.TIMVideoCallMessage;
            }
            return companion.init(callStatus, i10, identifier);
        }

        @NotNull
        public final VideoCallTipsMessage init(@NotNull CallStatus callStatus, int durationInSecs, @NotNull Identifier identifier) {
            Intrinsics.checkNotNullParameter(callStatus, "callStatus");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new VideoCallTipsMessage(callStatus.ordinal(), durationInSecs, identifier.name());
        }

        private Companion() {
        }
    }

    public VideoCallTipsMessage(int i10, int i11, @NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.callStatus = i10;
        this.duration = i11;
        this.identifier = identifier;
    }

    public static /* synthetic */ VideoCallTipsMessage copy$default(VideoCallTipsMessage videoCallTipsMessage, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = videoCallTipsMessage.callStatus;
        }
        if ((i12 & 2) != 0) {
            i11 = videoCallTipsMessage.duration;
        }
        if ((i12 & 4) != 0) {
            str = videoCallTipsMessage.identifier;
        }
        return videoCallTipsMessage.copy(i10, i11, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCallStatus() {
        return this.callStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final VideoCallTipsMessage copy(int callStatus, int duration, @NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new VideoCallTipsMessage(callStatus, duration, identifier);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallTipsMessage)) {
            return false;
        }
        VideoCallTipsMessage videoCallTipsMessage = (VideoCallTipsMessage) other;
        return this.callStatus == videoCallTipsMessage.callStatus && this.duration == videoCallTipsMessage.duration && Intrinsics.areEqual(this.identifier, videoCallTipsMessage.identifier);
    }

    public final int getCallStatus() {
        return this.callStatus;
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return (((this.callStatus * 31) + this.duration) * 31) + this.identifier.hashCode();
    }

    public final void setCallStatus(int i10) {
        this.callStatus = i10;
    }

    public final void setDuration(int i10) {
        this.duration = i10;
    }

    public final void setIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "VideoCallTipsMessage(callStatus=" + this.callStatus + ", duration=" + this.duration + ", identifier=" + this.identifier + ")";
    }
}
