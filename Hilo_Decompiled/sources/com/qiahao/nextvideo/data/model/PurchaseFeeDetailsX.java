package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\u000bHÆ\u0003J\t\u0010L\u001a\u00020\rHÆ\u0003J\t\u0010M\u001a\u00020\u000fHÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003J\t\u0010O\u001a\u00020\u0013HÆ\u0003J\t\u0010P\u001a\u00020\u0015HÆ\u0003J\t\u0010Q\u001a\u00020\u0017HÆ\u0003J\t\u0010R\u001a\u00020\u0017HÆ\u0003J\t\u0010S\u001a\u00020\u0017HÆ\u0003J\t\u0010T\u001a\u00020\u001bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001dHÆ\u0003J¡\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0017HÖ\u0001J\t\u0010[\u001a\u00020\\HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00109\"\u0004\b;\u0010<R\u001a\u0010\u0019\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010<R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006]"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;", "", "matchSetTypes", "Lcom/qiahao/nextvideo/data/model/MatchSetTypes;", "onlineSet", "Lcom/qiahao/nextvideo/data/model/OnlineSet;", "videoCallQuota", "Lcom/qiahao/nextvideo/data/model/VideoSet;", "groupSet", "Lcom/qiahao/nextvideo/data/model/groupSets;", "vipSets", "Lcom/qiahao/nextvideo/data/model/vipSets;", "likeSets", "Lcom/qiahao/nextvideo/data/model/LikeSets;", "relationSet", "Lcom/qiahao/nextvideo/data/model/RelationSet;", "beanSet", "Lcom/qiahao/nextvideo/data/model/BeanSet;", "gemSets", "Lcom/qiahao/nextvideo/data/model/GemSets;", "globalBroadcastFee", "", "groupActivityFee", "", "topGlobalBroadcastFee", "diamondToGem", "diamondToGemFloat", "", "superLike", "Lcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;", "<init>", "(Lcom/qiahao/nextvideo/data/model/MatchSetTypes;Lcom/qiahao/nextvideo/data/model/OnlineSet;Lcom/qiahao/nextvideo/data/model/VideoSet;Lcom/qiahao/nextvideo/data/model/groupSets;Lcom/qiahao/nextvideo/data/model/vipSets;Lcom/qiahao/nextvideo/data/model/LikeSets;Lcom/qiahao/nextvideo/data/model/RelationSet;Lcom/qiahao/nextvideo/data/model/BeanSet;Lcom/qiahao/nextvideo/data/model/GemSets;JIIIFLcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;)V", "getMatchSetTypes", "()Lcom/qiahao/nextvideo/data/model/MatchSetTypes;", "setMatchSetTypes", "(Lcom/qiahao/nextvideo/data/model/MatchSetTypes;)V", "getOnlineSet", "()Lcom/qiahao/nextvideo/data/model/OnlineSet;", "setOnlineSet", "(Lcom/qiahao/nextvideo/data/model/OnlineSet;)V", "getVideoCallQuota", "()Lcom/qiahao/nextvideo/data/model/VideoSet;", "getGroupSet", "()Lcom/qiahao/nextvideo/data/model/groupSets;", "getVipSets", "()Lcom/qiahao/nextvideo/data/model/vipSets;", "getLikeSets", "()Lcom/qiahao/nextvideo/data/model/LikeSets;", "getRelationSet", "()Lcom/qiahao/nextvideo/data/model/RelationSet;", "getBeanSet", "()Lcom/qiahao/nextvideo/data/model/BeanSet;", "getGemSets", "()Lcom/qiahao/nextvideo/data/model/GemSets;", "getGlobalBroadcastFee", "()J", "getGroupActivityFee", "()I", "getTopGlobalBroadcastFee", "setTopGlobalBroadcastFee", "(I)V", "getDiamondToGem", "setDiamondToGem", "getDiamondToGemFloat", "()F", "setDiamondToGemFloat", "(F)V", "getSuperLike", "()Lcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;", "setSuperLike", "(Lcom/qiahao/nextvideo/data/model/SuperLikeConfiguration;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PurchaseFeeDetailsX {

    @NotNull
    @c("beanSet")
    private final BeanSet beanSet;
    private int diamondToGem;
    private float diamondToGemFloat;

    @NotNull
    @c("gemSets")
    private final GemSets gemSets;

    @c("globalBroadcastFee")
    private final long globalBroadcastFee;

    @c("groupActivityFee")
    private final int groupActivityFee;

    @NotNull
    @c("groupSets")
    private final groupSets groupSet;

    @NotNull
    @c("likeSets")
    private final LikeSets likeSets;

    @NotNull
    @c("matchSetTypes")
    private MatchSetTypes matchSetTypes;

    @NotNull
    @c("onlineSet")
    private OnlineSet onlineSet;

    @NotNull
    @c("relationSet")
    private final RelationSet relationSet;

    @Nullable
    private SuperLikeConfiguration superLike;
    private int topGlobalBroadcastFee;

    @NotNull
    @c("videoSet")
    private final VideoSet videoCallQuota;

    @NotNull
    @c("vipSets")
    private final vipSets vipSets;

    public PurchaseFeeDetailsX(@NotNull MatchSetTypes matchSetTypes, @NotNull OnlineSet onlineSet, @NotNull VideoSet videoSet, @NotNull groupSets groupsets, @NotNull vipSets vipsets, @NotNull LikeSets likeSets, @NotNull RelationSet relationSet, @NotNull BeanSet beanSet, @NotNull GemSets gemSets, long j, int i, int i2, int i3, float f, @Nullable SuperLikeConfiguration superLikeConfiguration) {
        Intrinsics.checkNotNullParameter(matchSetTypes, "matchSetTypes");
        Intrinsics.checkNotNullParameter(onlineSet, "onlineSet");
        Intrinsics.checkNotNullParameter(videoSet, "videoCallQuota");
        Intrinsics.checkNotNullParameter(groupsets, "groupSet");
        Intrinsics.checkNotNullParameter(vipsets, "vipSets");
        Intrinsics.checkNotNullParameter(likeSets, "likeSets");
        Intrinsics.checkNotNullParameter(relationSet, "relationSet");
        Intrinsics.checkNotNullParameter(beanSet, "beanSet");
        Intrinsics.checkNotNullParameter(gemSets, "gemSets");
        this.matchSetTypes = matchSetTypes;
        this.onlineSet = onlineSet;
        this.videoCallQuota = videoSet;
        this.groupSet = groupsets;
        this.vipSets = vipsets;
        this.likeSets = likeSets;
        this.relationSet = relationSet;
        this.beanSet = beanSet;
        this.gemSets = gemSets;
        this.globalBroadcastFee = j;
        this.groupActivityFee = i;
        this.topGlobalBroadcastFee = i2;
        this.diamondToGem = i3;
        this.diamondToGemFloat = f;
        this.superLike = superLikeConfiguration;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final MatchSetTypes getMatchSetTypes() {
        return this.matchSetTypes;
    }

    /* renamed from: component10, reason: from getter */
    public final long getGlobalBroadcastFee() {
        return this.globalBroadcastFee;
    }

    /* renamed from: component11, reason: from getter */
    public final int getGroupActivityFee() {
        return this.groupActivityFee;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTopGlobalBroadcastFee() {
        return this.topGlobalBroadcastFee;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDiamondToGem() {
        return this.diamondToGem;
    }

    /* renamed from: component14, reason: from getter */
    public final float getDiamondToGemFloat() {
        return this.diamondToGemFloat;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final SuperLikeConfiguration getSuperLike() {
        return this.superLike;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final OnlineSet getOnlineSet() {
        return this.onlineSet;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final VideoSet getVideoCallQuota() {
        return this.videoCallQuota;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final groupSets getGroupSet() {
        return this.groupSet;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final vipSets getVipSets() {
        return this.vipSets;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final LikeSets getLikeSets() {
        return this.likeSets;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final RelationSet getRelationSet() {
        return this.relationSet;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final BeanSet getBeanSet() {
        return this.beanSet;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final GemSets getGemSets() {
        return this.gemSets;
    }

    @NotNull
    public final PurchaseFeeDetailsX copy(@NotNull MatchSetTypes matchSetTypes, @NotNull OnlineSet onlineSet, @NotNull VideoSet videoCallQuota, @NotNull groupSets groupSet, @NotNull vipSets vipSets, @NotNull LikeSets likeSets, @NotNull RelationSet relationSet, @NotNull BeanSet beanSet, @NotNull GemSets gemSets, long globalBroadcastFee, int groupActivityFee, int topGlobalBroadcastFee, int diamondToGem, float diamondToGemFloat, @Nullable SuperLikeConfiguration superLike) {
        Intrinsics.checkNotNullParameter(matchSetTypes, "matchSetTypes");
        Intrinsics.checkNotNullParameter(onlineSet, "onlineSet");
        Intrinsics.checkNotNullParameter(videoCallQuota, "videoCallQuota");
        Intrinsics.checkNotNullParameter(groupSet, "groupSet");
        Intrinsics.checkNotNullParameter(vipSets, "vipSets");
        Intrinsics.checkNotNullParameter(likeSets, "likeSets");
        Intrinsics.checkNotNullParameter(relationSet, "relationSet");
        Intrinsics.checkNotNullParameter(beanSet, "beanSet");
        Intrinsics.checkNotNullParameter(gemSets, "gemSets");
        return new PurchaseFeeDetailsX(matchSetTypes, onlineSet, videoCallQuota, groupSet, vipSets, likeSets, relationSet, beanSet, gemSets, globalBroadcastFee, groupActivityFee, topGlobalBroadcastFee, diamondToGem, diamondToGemFloat, superLike);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseFeeDetailsX)) {
            return false;
        }
        PurchaseFeeDetailsX purchaseFeeDetailsX = (PurchaseFeeDetailsX) other;
        return Intrinsics.areEqual(this.matchSetTypes, purchaseFeeDetailsX.matchSetTypes) && Intrinsics.areEqual(this.onlineSet, purchaseFeeDetailsX.onlineSet) && Intrinsics.areEqual(this.videoCallQuota, purchaseFeeDetailsX.videoCallQuota) && Intrinsics.areEqual(this.groupSet, purchaseFeeDetailsX.groupSet) && Intrinsics.areEqual(this.vipSets, purchaseFeeDetailsX.vipSets) && Intrinsics.areEqual(this.likeSets, purchaseFeeDetailsX.likeSets) && Intrinsics.areEqual(this.relationSet, purchaseFeeDetailsX.relationSet) && Intrinsics.areEqual(this.beanSet, purchaseFeeDetailsX.beanSet) && Intrinsics.areEqual(this.gemSets, purchaseFeeDetailsX.gemSets) && this.globalBroadcastFee == purchaseFeeDetailsX.globalBroadcastFee && this.groupActivityFee == purchaseFeeDetailsX.groupActivityFee && this.topGlobalBroadcastFee == purchaseFeeDetailsX.topGlobalBroadcastFee && this.diamondToGem == purchaseFeeDetailsX.diamondToGem && Float.compare(this.diamondToGemFloat, purchaseFeeDetailsX.diamondToGemFloat) == 0 && Intrinsics.areEqual(this.superLike, purchaseFeeDetailsX.superLike);
    }

    @NotNull
    public final BeanSet getBeanSet() {
        return this.beanSet;
    }

    public final int getDiamondToGem() {
        return this.diamondToGem;
    }

    public final float getDiamondToGemFloat() {
        return this.diamondToGemFloat;
    }

    @NotNull
    public final GemSets getGemSets() {
        return this.gemSets;
    }

    public final long getGlobalBroadcastFee() {
        return this.globalBroadcastFee;
    }

    public final int getGroupActivityFee() {
        return this.groupActivityFee;
    }

    @NotNull
    public final groupSets getGroupSet() {
        return this.groupSet;
    }

    @NotNull
    public final LikeSets getLikeSets() {
        return this.likeSets;
    }

    @NotNull
    public final MatchSetTypes getMatchSetTypes() {
        return this.matchSetTypes;
    }

    @NotNull
    public final OnlineSet getOnlineSet() {
        return this.onlineSet;
    }

    @NotNull
    public final RelationSet getRelationSet() {
        return this.relationSet;
    }

    @Nullable
    public final SuperLikeConfiguration getSuperLike() {
        return this.superLike;
    }

    public final int getTopGlobalBroadcastFee() {
        return this.topGlobalBroadcastFee;
    }

    @NotNull
    public final VideoSet getVideoCallQuota() {
        return this.videoCallQuota;
    }

    @NotNull
    public final vipSets getVipSets() {
        return this.vipSets;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((((((((((this.matchSetTypes.hashCode() * 31) + this.onlineSet.hashCode()) * 31) + this.videoCallQuota.hashCode()) * 31) + this.groupSet.hashCode()) * 31) + this.vipSets.hashCode()) * 31) + this.likeSets.hashCode()) * 31) + this.relationSet.hashCode()) * 31) + this.beanSet.hashCode()) * 31) + this.gemSets.hashCode()) * 31) + androidx.collection.c.a(this.globalBroadcastFee)) * 31) + this.groupActivityFee) * 31) + this.topGlobalBroadcastFee) * 31) + this.diamondToGem) * 31) + Float.floatToIntBits(this.diamondToGemFloat)) * 31;
        SuperLikeConfiguration superLikeConfiguration = this.superLike;
        if (superLikeConfiguration == null) {
            hashCode = 0;
        } else {
            hashCode = superLikeConfiguration.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setDiamondToGem(int i) {
        this.diamondToGem = i;
    }

    public final void setDiamondToGemFloat(float f) {
        this.diamondToGemFloat = f;
    }

    public final void setMatchSetTypes(@NotNull MatchSetTypes matchSetTypes) {
        Intrinsics.checkNotNullParameter(matchSetTypes, "<set-?>");
        this.matchSetTypes = matchSetTypes;
    }

    public final void setOnlineSet(@NotNull OnlineSet onlineSet) {
        Intrinsics.checkNotNullParameter(onlineSet, "<set-?>");
        this.onlineSet = onlineSet;
    }

    public final void setSuperLike(@Nullable SuperLikeConfiguration superLikeConfiguration) {
        this.superLike = superLikeConfiguration;
    }

    public final void setTopGlobalBroadcastFee(int i) {
        this.topGlobalBroadcastFee = i;
    }

    @NotNull
    public String toString() {
        return "PurchaseFeeDetailsX(matchSetTypes=" + this.matchSetTypes + ", onlineSet=" + this.onlineSet + ", videoCallQuota=" + this.videoCallQuota + ", groupSet=" + this.groupSet + ", vipSets=" + this.vipSets + ", likeSets=" + this.likeSets + ", relationSet=" + this.relationSet + ", beanSet=" + this.beanSet + ", gemSets=" + this.gemSets + ", globalBroadcastFee=" + this.globalBroadcastFee + ", groupActivityFee=" + this.groupActivityFee + ", topGlobalBroadcastFee=" + this.topGlobalBroadcastFee + ", diamondToGem=" + this.diamondToGem + ", diamondToGemFloat=" + this.diamondToGemFloat + ", superLike=" + this.superLike + ")";
    }

    public /* synthetic */ PurchaseFeeDetailsX(MatchSetTypes matchSetTypes, OnlineSet onlineSet, VideoSet videoSet, groupSets groupsets, vipSets vipsets, LikeSets likeSets, RelationSet relationSet, BeanSet beanSet, GemSets gemSets, long j, int i, int i2, int i3, float f, SuperLikeConfiguration superLikeConfiguration, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(matchSetTypes, onlineSet, videoSet, groupsets, vipsets, likeSets, relationSet, beanSet, gemSets, j, i, i2, i3, f, (i4 & 16384) != 0 ? null : superLikeConfiguration);
    }
}
