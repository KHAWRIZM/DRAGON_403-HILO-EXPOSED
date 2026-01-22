package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoFreeCheck;", "", "freeVideoCallQuota", "", "isVideoCanFree", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFreeVideoCallQuota", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "hasFreeVideoCallQuota", "", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/VideoFreeCheck;", "equals", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoFreeCheck {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    @c("freeN")
    private final Integer freeVideoCallQuota;

    @Nullable
    @c("isVideoCanFree")
    private final Integer isVideoCanFree;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoFreeCheck$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/VideoFreeCheck;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoFreeCheck fake() {
            List listOf = CollectionsKt.listOf(new Integer[]{0, 3});
            Random.Default r5 = Random.Default;
            return new VideoFreeCheck((Integer) CollectionsKt.random(listOf, r5), (Integer) CollectionsKt.random(CollectionsKt.listOf(new Integer[]{0, 1}), r5));
        }

        private Companion() {
        }
    }

    public VideoFreeCheck(@Nullable Integer num, @Nullable Integer num2) {
        this.freeVideoCallQuota = num;
        this.isVideoCanFree = num2;
    }

    public static /* synthetic */ VideoFreeCheck copy$default(VideoFreeCheck videoFreeCheck, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = videoFreeCheck.freeVideoCallQuota;
        }
        if ((i & 2) != 0) {
            num2 = videoFreeCheck.isVideoCanFree;
        }
        return videoFreeCheck.copy(num, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getFreeVideoCallQuota() {
        return this.freeVideoCallQuota;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getIsVideoCanFree() {
        return this.isVideoCanFree;
    }

    @NotNull
    public final VideoFreeCheck copy(@Nullable Integer freeVideoCallQuota, @Nullable Integer isVideoCanFree) {
        return new VideoFreeCheck(freeVideoCallQuota, isVideoCanFree);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoFreeCheck)) {
            return false;
        }
        VideoFreeCheck videoFreeCheck = (VideoFreeCheck) other;
        return Intrinsics.areEqual(this.freeVideoCallQuota, videoFreeCheck.freeVideoCallQuota) && Intrinsics.areEqual(this.isVideoCanFree, videoFreeCheck.isVideoCanFree);
    }

    @Nullable
    public final Integer getFreeVideoCallQuota() {
        return this.freeVideoCallQuota;
    }

    public final boolean hasFreeVideoCallQuota() {
        int i;
        Integer num = this.freeVideoCallQuota;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (i < 1) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.freeVideoCallQuota;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.isVideoCanFree;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    @Nullable
    public final Integer isVideoCanFree() {
        return this.isVideoCanFree;
    }

    @NotNull
    public String toString() {
        return "VideoFreeCheck(freeVideoCallQuota=" + this.freeVideoCallQuota + ", isVideoCanFree=" + this.isVideoCanFree + ")";
    }
}
