package com.qiahao.base_common.model.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEventFace;", "", "senderUserID", "", "faceType", "", "<init>", "(ILjava/lang/String;)V", "getSenderUserID", "()I", "getFaceType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEventFace {

    @NotNull
    public static final String NOT_SHOW_FACE = "0";

    @NotNull
    public static final String REMOTE_AGREE_NOT_FACE = "2";

    @NotNull
    public static final String SHOW_FACE = "1";

    @NotNull
    private final String faceType;
    private final int senderUserID;

    public ChannelEventFace(int i10, @NotNull String faceType) {
        Intrinsics.checkNotNullParameter(faceType, "faceType");
        this.senderUserID = i10;
        this.faceType = faceType;
    }

    public static /* synthetic */ ChannelEventFace copy$default(ChannelEventFace channelEventFace, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = channelEventFace.senderUserID;
        }
        if ((i11 & 2) != 0) {
            str = channelEventFace.faceType;
        }
        return channelEventFace.copy(i10, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSenderUserID() {
        return this.senderUserID;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFaceType() {
        return this.faceType;
    }

    @NotNull
    public final ChannelEventFace copy(int senderUserID, @NotNull String faceType) {
        Intrinsics.checkNotNullParameter(faceType, "faceType");
        return new ChannelEventFace(senderUserID, faceType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEventFace)) {
            return false;
        }
        ChannelEventFace channelEventFace = (ChannelEventFace) other;
        return this.senderUserID == channelEventFace.senderUserID && Intrinsics.areEqual(this.faceType, channelEventFace.faceType);
    }

    @NotNull
    public final String getFaceType() {
        return this.faceType;
    }

    public final int getSenderUserID() {
        return this.senderUserID;
    }

    public int hashCode() {
        return (this.senderUserID * 31) + this.faceType.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelEventFace(senderUserID=" + this.senderUserID + ", faceType=" + this.faceType + ")";
    }
}
