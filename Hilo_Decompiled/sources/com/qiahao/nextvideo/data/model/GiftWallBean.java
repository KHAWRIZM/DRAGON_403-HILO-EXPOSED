package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftWallBean;", "", "giftUrl", "", "receiveUser", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "sendUser", "resGiftId", "", "<init>", "(Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;I)V", "getGiftUrl", "()Ljava/lang/String;", "getReceiveUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getSendUser", "getResGiftId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftWallBean {

    @NotNull
    private final String giftUrl;

    @NotNull
    private final UserSummaryInfo receiveUser;
    private final int resGiftId;

    @NotNull
    private final UserSummaryInfo sendUser;

    public GiftWallBean(@NotNull String str, @NotNull UserSummaryInfo userSummaryInfo, @NotNull UserSummaryInfo userSummaryInfo2, int i) {
        Intrinsics.checkNotNullParameter(str, "giftUrl");
        Intrinsics.checkNotNullParameter(userSummaryInfo, "receiveUser");
        Intrinsics.checkNotNullParameter(userSummaryInfo2, "sendUser");
        this.giftUrl = str;
        this.receiveUser = userSummaryInfo;
        this.sendUser = userSummaryInfo2;
        this.resGiftId = i;
    }

    public static /* synthetic */ GiftWallBean copy$default(GiftWallBean giftWallBean, String str, UserSummaryInfo userSummaryInfo, UserSummaryInfo userSummaryInfo2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = giftWallBean.giftUrl;
        }
        if ((i2 & 2) != 0) {
            userSummaryInfo = giftWallBean.receiveUser;
        }
        if ((i2 & 4) != 0) {
            userSummaryInfo2 = giftWallBean.sendUser;
        }
        if ((i2 & 8) != 0) {
            i = giftWallBean.resGiftId;
        }
        return giftWallBean.copy(str, userSummaryInfo, userSummaryInfo2, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGiftUrl() {
        return this.giftUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getReceiveUser() {
        return this.receiveUser;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UserSummaryInfo getSendUser() {
        return this.sendUser;
    }

    /* renamed from: component4, reason: from getter */
    public final int getResGiftId() {
        return this.resGiftId;
    }

    @NotNull
    public final GiftWallBean copy(@NotNull String giftUrl, @NotNull UserSummaryInfo receiveUser, @NotNull UserSummaryInfo sendUser, int resGiftId) {
        Intrinsics.checkNotNullParameter(giftUrl, "giftUrl");
        Intrinsics.checkNotNullParameter(receiveUser, "receiveUser");
        Intrinsics.checkNotNullParameter(sendUser, "sendUser");
        return new GiftWallBean(giftUrl, receiveUser, sendUser, resGiftId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftWallBean)) {
            return false;
        }
        GiftWallBean giftWallBean = (GiftWallBean) other;
        return Intrinsics.areEqual(this.giftUrl, giftWallBean.giftUrl) && Intrinsics.areEqual(this.receiveUser, giftWallBean.receiveUser) && Intrinsics.areEqual(this.sendUser, giftWallBean.sendUser) && this.resGiftId == giftWallBean.resGiftId;
    }

    @NotNull
    public final String getGiftUrl() {
        return this.giftUrl;
    }

    @NotNull
    public final UserSummaryInfo getReceiveUser() {
        return this.receiveUser;
    }

    public final int getResGiftId() {
        return this.resGiftId;
    }

    @NotNull
    public final UserSummaryInfo getSendUser() {
        return this.sendUser;
    }

    public int hashCode() {
        return (((((this.giftUrl.hashCode() * 31) + this.receiveUser.hashCode()) * 31) + this.sendUser.hashCode()) * 31) + this.resGiftId;
    }

    @NotNull
    public String toString() {
        return "GiftWallBean(giftUrl=" + this.giftUrl + ", receiveUser=" + this.receiveUser + ", sendUser=" + this.sendUser + ", resGiftId=" + this.resGiftId + ")";
    }
}
