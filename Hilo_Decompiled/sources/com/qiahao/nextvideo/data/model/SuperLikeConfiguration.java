package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;", "", "originalGold", "", "gold", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOriginalGold", "()Ljava/lang/Integer;", "setOriginalGold", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGold", "setGold", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SuperLikeConfiguration {

    @Nullable
    private Integer gold;

    @Nullable
    private Integer originalGold;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SuperLikeConfiguration() {
        this(r0, r0, 3, r0);
        Integer num = null;
    }

    public static /* synthetic */ SuperLikeConfiguration copy$default(SuperLikeConfiguration superLikeConfiguration, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = superLikeConfiguration.originalGold;
        }
        if ((i & 2) != 0) {
            num2 = superLikeConfiguration.gold;
        }
        return superLikeConfiguration.copy(num, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getOriginalGold() {
        return this.originalGold;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGold() {
        return this.gold;
    }

    @NotNull
    public final SuperLikeConfiguration copy(@Nullable Integer originalGold, @Nullable Integer gold) {
        return new SuperLikeConfiguration(originalGold, gold);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuperLikeConfiguration)) {
            return false;
        }
        SuperLikeConfiguration superLikeConfiguration = (SuperLikeConfiguration) other;
        return Intrinsics.areEqual(this.originalGold, superLikeConfiguration.originalGold) && Intrinsics.areEqual(this.gold, superLikeConfiguration.gold);
    }

    @Nullable
    public final Integer getGold() {
        return this.gold;
    }

    @Nullable
    public final Integer getOriginalGold() {
        return this.originalGold;
    }

    public int hashCode() {
        Integer num = this.originalGold;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gold;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setGold(@Nullable Integer num) {
        this.gold = num;
    }

    public final void setOriginalGold(@Nullable Integer num) {
        this.originalGold = num;
    }

    @NotNull
    public String toString() {
        return "SuperLikeConfiguration(originalGold=" + this.originalGold + ", gold=" + this.gold + ")";
    }

    public SuperLikeConfiguration(@Nullable Integer num, @Nullable Integer num2) {
        this.originalGold = num;
        this.gold = num2;
    }

    public /* synthetic */ SuperLikeConfiguration(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }
}
