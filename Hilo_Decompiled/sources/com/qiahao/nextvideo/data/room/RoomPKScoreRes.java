package com.qiahao.nextvideo.data.room;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016JD\u0010\u001d\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomPKScoreRes;", "", "scoreInfo", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/room/RoomPKScore;", "Lkotlin/collections/ArrayList;", "boxLevel", "", "unixMilli", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Long;)V", "getScoreInfo", "()Ljava/util/ArrayList;", "setScoreInfo", "(Ljava/util/ArrayList;)V", "getBoxLevel", "()Ljava/lang/Integer;", "setBoxLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUnixMilli", "()Ljava/lang/Long;", "setUnixMilli", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/room/RoomPKScoreRes;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomPKScoreRes {

    @Nullable
    private Integer boxLevel;

    @Nullable
    private ArrayList<RoomPKScore> scoreInfo;

    @Nullable
    private Long unixMilli;

    public RoomPKScoreRes() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomPKScoreRes copy$default(RoomPKScoreRes roomPKScoreRes, ArrayList arrayList, Integer num, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = roomPKScoreRes.scoreInfo;
        }
        if ((i & 2) != 0) {
            num = roomPKScoreRes.boxLevel;
        }
        if ((i & 4) != 0) {
            l = roomPKScoreRes.unixMilli;
        }
        return roomPKScoreRes.copy(arrayList, num, l);
    }

    @Nullable
    public final ArrayList<RoomPKScore> component1() {
        return this.scoreInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getBoxLevel() {
        return this.boxLevel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getUnixMilli() {
        return this.unixMilli;
    }

    @NotNull
    public final RoomPKScoreRes copy(@Nullable ArrayList<RoomPKScore> scoreInfo, @Nullable Integer boxLevel, @Nullable Long unixMilli) {
        return new RoomPKScoreRes(scoreInfo, boxLevel, unixMilli);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomPKScoreRes)) {
            return false;
        }
        RoomPKScoreRes roomPKScoreRes = (RoomPKScoreRes) other;
        return Intrinsics.areEqual(this.scoreInfo, roomPKScoreRes.scoreInfo) && Intrinsics.areEqual(this.boxLevel, roomPKScoreRes.boxLevel) && Intrinsics.areEqual(this.unixMilli, roomPKScoreRes.unixMilli);
    }

    @Nullable
    public final Integer getBoxLevel() {
        return this.boxLevel;
    }

    @Nullable
    public final ArrayList<RoomPKScore> getScoreInfo() {
        return this.scoreInfo;
    }

    @Nullable
    public final Long getUnixMilli() {
        return this.unixMilli;
    }

    public int hashCode() {
        ArrayList<RoomPKScore> arrayList = this.scoreInfo;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Integer num = this.boxLevel;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.unixMilli;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final void setBoxLevel(@Nullable Integer num) {
        this.boxLevel = num;
    }

    public final void setScoreInfo(@Nullable ArrayList<RoomPKScore> arrayList) {
        this.scoreInfo = arrayList;
    }

    public final void setUnixMilli(@Nullable Long l) {
        this.unixMilli = l;
    }

    @NotNull
    public String toString() {
        return "RoomPKScoreRes(scoreInfo=" + this.scoreInfo + ", boxLevel=" + this.boxLevel + ", unixMilli=" + this.unixMilli + ")";
    }

    public RoomPKScoreRes(@Nullable ArrayList<RoomPKScore> arrayList, @Nullable Integer num, @Nullable Long l) {
        this.scoreInfo = arrayList;
        this.boxLevel = num;
        this.unixMilli = l;
    }

    public /* synthetic */ RoomPKScoreRes(ArrayList arrayList, Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l);
    }
}
