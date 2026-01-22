package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Relation;", "", "heartValue", "", "heartValueMax", "meetDays", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeartValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeartValueMax", "getMeetDays", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/Relation;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Relation {

    @Nullable
    @c("heartValue")
    private final Integer heartValue;

    @Nullable
    @c("heartValueMax")
    private final Integer heartValueMax;

    @Nullable
    @c("meetDays")
    private final Integer meetDays;

    public Relation(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.heartValue = num;
        this.heartValueMax = num2;
        this.meetDays = num3;
    }

    public static /* synthetic */ Relation copy$default(Relation relation, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = relation.heartValue;
        }
        if ((i & 2) != 0) {
            num2 = relation.heartValueMax;
        }
        if ((i & 4) != 0) {
            num3 = relation.meetDays;
        }
        return relation.copy(num, num2, num3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getHeartValue() {
        return this.heartValue;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getHeartValueMax() {
        return this.heartValueMax;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getMeetDays() {
        return this.meetDays;
    }

    @NotNull
    public final Relation copy(@Nullable Integer heartValue, @Nullable Integer heartValueMax, @Nullable Integer meetDays) {
        return new Relation(heartValue, heartValueMax, meetDays);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Relation)) {
            return false;
        }
        Relation relation = (Relation) other;
        return Intrinsics.areEqual(this.heartValue, relation.heartValue) && Intrinsics.areEqual(this.heartValueMax, relation.heartValueMax) && Intrinsics.areEqual(this.meetDays, relation.meetDays);
    }

    @Nullable
    public final Integer getHeartValue() {
        return this.heartValue;
    }

    @Nullable
    public final Integer getHeartValueMax() {
        return this.heartValueMax;
    }

    @Nullable
    public final Integer getMeetDays() {
        return this.meetDays;
    }

    public int hashCode() {
        Integer num = this.heartValue;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.heartValueMax;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.meetDays;
        return hashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Relation(heartValue=" + this.heartValue + ", heartValueMax=" + this.heartValueMax + ", meetDays=" + this.meetDays + ")";
    }
}
