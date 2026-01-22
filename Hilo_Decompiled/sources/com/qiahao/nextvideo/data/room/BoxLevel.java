package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/room/BoxLevel;", "", "level", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/room/BoxLevel;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BoxLevel {

    @Nullable
    private Long diamond;

    @Nullable
    private Integer level;

    /* JADX WARN: Multi-variable type inference failed */
    public BoxLevel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BoxLevel copy$default(BoxLevel boxLevel, Integer num, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = boxLevel.level;
        }
        if ((i & 2) != 0) {
            l = boxLevel.diamond;
        }
        return boxLevel.copy(num, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final BoxLevel copy(@Nullable Integer level, @Nullable Long diamond) {
        return new BoxLevel(level, diamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxLevel)) {
            return false;
        }
        BoxLevel boxLevel = (BoxLevel) other;
        return Intrinsics.areEqual(this.level, boxLevel.level) && Intrinsics.areEqual(this.diamond, boxLevel.diamond);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    public int hashCode() {
        Integer num = this.level;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.diamond;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    @NotNull
    public String toString() {
        return "BoxLevel(level=" + this.level + ", diamond=" + this.diamond + ")";
    }

    public BoxLevel(@Nullable Integer num, @Nullable Long l) {
        this.level = num;
        this.diamond = l;
    }

    public /* synthetic */ BoxLevel(Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? null : l);
    }
}
