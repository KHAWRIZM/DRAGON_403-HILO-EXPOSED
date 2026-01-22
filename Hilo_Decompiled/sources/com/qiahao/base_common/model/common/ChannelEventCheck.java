package com.qiahao.base_common.model.common;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEventCheck;", "", "videoUniqueId", "", "diamond", "", "<init>", "(Ljava/lang/String;J)V", "getVideoUniqueId", "()Ljava/lang/String;", "getDiamond", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEventCheck {
    private final long diamond;

    @NotNull
    private final String videoUniqueId;

    public ChannelEventCheck(@NotNull String videoUniqueId, long j10) {
        Intrinsics.checkNotNullParameter(videoUniqueId, "videoUniqueId");
        this.videoUniqueId = videoUniqueId;
        this.diamond = j10;
    }

    public static /* synthetic */ ChannelEventCheck copy$default(ChannelEventCheck channelEventCheck, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = channelEventCheck.videoUniqueId;
        }
        if ((i10 & 2) != 0) {
            j10 = channelEventCheck.diamond;
        }
        return channelEventCheck.copy(str, j10);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVideoUniqueId() {
        return this.videoUniqueId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final ChannelEventCheck copy(@NotNull String videoUniqueId, long diamond) {
        Intrinsics.checkNotNullParameter(videoUniqueId, "videoUniqueId");
        return new ChannelEventCheck(videoUniqueId, diamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEventCheck)) {
            return false;
        }
        ChannelEventCheck channelEventCheck = (ChannelEventCheck) other;
        return Intrinsics.areEqual(this.videoUniqueId, channelEventCheck.videoUniqueId) && this.diamond == channelEventCheck.diamond;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final String getVideoUniqueId() {
        return this.videoUniqueId;
    }

    public int hashCode() {
        return (this.videoUniqueId.hashCode() * 31) + c.a(this.diamond);
    }

    @NotNull
    public String toString() {
        return "ChannelEventCheck(videoUniqueId=" + this.videoUniqueId + ", diamond=" + this.diamond + ")";
    }
}
