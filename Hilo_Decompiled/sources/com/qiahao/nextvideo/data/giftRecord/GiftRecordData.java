package com.qiahao.nextvideo.data.giftRecord;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/giftRecord/GiftRecordData;", "", "user", "Lcom/qiahao/base_common/model/common/User;", "giftN", "", "unixCreatedTime", "", "iconUrl", "", "<init>", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getGiftN", "()Ljava/lang/Integer;", "setGiftN", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUnixCreatedTime", "()Ljava/lang/Long;", "setUnixCreatedTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/giftRecord/GiftRecordData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftRecordData {

    @Nullable
    private Integer giftN;

    @Nullable
    private String iconUrl;

    @Nullable
    private Long unixCreatedTime;

    @Nullable
    private User user;

    public GiftRecordData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GiftRecordData copy$default(GiftRecordData giftRecordData, User user, Integer num, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            user = giftRecordData.user;
        }
        if ((i & 2) != 0) {
            num = giftRecordData.giftN;
        }
        if ((i & 4) != 0) {
            l = giftRecordData.unixCreatedTime;
        }
        if ((i & 8) != 0) {
            str = giftRecordData.iconUrl;
        }
        return giftRecordData.copy(user, num, l, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGiftN() {
        return this.giftN;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getUnixCreatedTime() {
        return this.unixCreatedTime;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final GiftRecordData copy(@Nullable User user, @Nullable Integer giftN, @Nullable Long unixCreatedTime, @Nullable String iconUrl) {
        return new GiftRecordData(user, giftN, unixCreatedTime, iconUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftRecordData)) {
            return false;
        }
        GiftRecordData giftRecordData = (GiftRecordData) other;
        return Intrinsics.areEqual(this.user, giftRecordData.user) && Intrinsics.areEqual(this.giftN, giftRecordData.giftN) && Intrinsics.areEqual(this.unixCreatedTime, giftRecordData.unixCreatedTime) && Intrinsics.areEqual(this.iconUrl, giftRecordData.iconUrl);
    }

    @Nullable
    public final Integer getGiftN() {
        return this.giftN;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    public final Long getUnixCreatedTime() {
        return this.unixCreatedTime;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        Integer num = this.giftN;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.unixCreatedTime;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.iconUrl;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setGiftN(@Nullable Integer num) {
        this.giftN = num;
    }

    public final void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public final void setUnixCreatedTime(@Nullable Long l) {
        this.unixCreatedTime = l;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "GiftRecordData(user=" + this.user + ", giftN=" + this.giftN + ", unixCreatedTime=" + this.unixCreatedTime + ", iconUrl=" + this.iconUrl + ")";
    }

    public GiftRecordData(@Nullable User user, @Nullable Integer num, @Nullable Long l, @Nullable String str) {
        this.user = user;
        this.giftN = num;
        this.unixCreatedTime = l;
        this.iconUrl = str;
    }

    public /* synthetic */ GiftRecordData(User user, Integer num, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str);
    }
}
