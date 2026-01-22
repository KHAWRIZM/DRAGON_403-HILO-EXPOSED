package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/qiahao/base_common/model/im/LikeMessage;", "", "giftType", "", "identifier", "", "giftData", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getGiftType", "()Ljava/lang/Integer;", "setGiftType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getGiftData", "setGiftData", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/LikeMessage;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class LikeMessage {

    @Nullable
    private String giftData;

    @Nullable
    private Integer giftType;

    @Nullable
    private String identifier;

    public LikeMessage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LikeMessage copy$default(LikeMessage likeMessage, Integer num, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = likeMessage.giftType;
        }
        if ((i10 & 2) != 0) {
            str = likeMessage.identifier;
        }
        if ((i10 & 4) != 0) {
            str2 = likeMessage.giftData;
        }
        return likeMessage.copy(num, str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGiftData() {
        return this.giftData;
    }

    @NotNull
    public final LikeMessage copy(@Nullable Integer giftType, @Nullable String identifier, @Nullable String giftData) {
        return new LikeMessage(giftType, identifier, giftData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeMessage)) {
            return false;
        }
        LikeMessage likeMessage = (LikeMessage) other;
        return Intrinsics.areEqual(this.giftType, likeMessage.giftType) && Intrinsics.areEqual(this.identifier, likeMessage.identifier) && Intrinsics.areEqual(this.giftData, likeMessage.giftData);
    }

    @Nullable
    public final String getGiftData() {
        return this.giftData;
    }

    @Nullable
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        Integer num = this.giftType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.identifier;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.giftData;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setGiftData(@Nullable String str) {
        this.giftData = str;
    }

    public final void setGiftType(@Nullable Integer num) {
        this.giftType = num;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "LikeMessage(giftType=" + this.giftType + ", identifier=" + this.identifier + ", giftData=" + this.giftData + ")";
    }

    public LikeMessage(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.giftType = num;
        this.identifier = str;
        this.giftData = str2;
    }

    public /* synthetic */ LikeMessage(Integer num, String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
