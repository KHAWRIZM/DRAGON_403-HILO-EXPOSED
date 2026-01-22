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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoSet;", "", "videoCost", "", "videoFreeNum", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getVideoCost", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoFreeNum", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/VideoSet;", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoSet {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    @c("videoCost")
    private final Integer videoCost;

    @Nullable
    @c("videoFreeNum")
    private final Integer videoFreeNum;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoSet$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/VideoSet;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoSet fake() {
            List listOf = CollectionsKt.listOf(new Integer[]{50, 100});
            Random.Default r4 = Random.Default;
            return new VideoSet((Integer) CollectionsKt.random(listOf, r4), (Integer) CollectionsKt.random(CollectionsKt.listOf(new Integer[]{2, 4}), r4));
        }

        private Companion() {
        }
    }

    public VideoSet(@Nullable Integer num, @Nullable Integer num2) {
        this.videoCost = num;
        this.videoFreeNum = num2;
    }

    public static /* synthetic */ VideoSet copy$default(VideoSet videoSet, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = videoSet.videoCost;
        }
        if ((i & 2) != 0) {
            num2 = videoSet.videoFreeNum;
        }
        return videoSet.copy(num, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getVideoCost() {
        return this.videoCost;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getVideoFreeNum() {
        return this.videoFreeNum;
    }

    @NotNull
    public final VideoSet copy(@Nullable Integer videoCost, @Nullable Integer videoFreeNum) {
        return new VideoSet(videoCost, videoFreeNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSet)) {
            return false;
        }
        VideoSet videoSet = (VideoSet) other;
        return Intrinsics.areEqual(this.videoCost, videoSet.videoCost) && Intrinsics.areEqual(this.videoFreeNum, videoSet.videoFreeNum);
    }

    @Nullable
    public final Integer getVideoCost() {
        return this.videoCost;
    }

    @Nullable
    public final Integer getVideoFreeNum() {
        return this.videoFreeNum;
    }

    public int hashCode() {
        Integer num = this.videoCost;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.videoFreeNum;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VideoSet(videoCost=" + this.videoCost + ", videoFreeNum=" + this.videoFreeNum + ")";
    }
}
