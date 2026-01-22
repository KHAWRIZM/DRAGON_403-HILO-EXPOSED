package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/model/im/SendNobleMessage;", "", "days", "", "identifier", "nobleLevel", "", "nickName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getDays", "()Ljava/lang/String;", "setDays", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "getNobleLevel", "()Ljava/lang/Integer;", "setNobleLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNickName", "setNickName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/SendNobleMessage;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SendNobleMessage {

    @Nullable
    private String days;

    @Nullable
    private String identifier;

    @Nullable
    private String nickName;

    @Nullable
    private Integer nobleLevel;

    public SendNobleMessage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SendNobleMessage copy$default(SendNobleMessage sendNobleMessage, String str, String str2, Integer num, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sendNobleMessage.days;
        }
        if ((i10 & 2) != 0) {
            str2 = sendNobleMessage.identifier;
        }
        if ((i10 & 4) != 0) {
            num = sendNobleMessage.nobleLevel;
        }
        if ((i10 & 8) != 0) {
            str3 = sendNobleMessage.nickName;
        }
        return sendNobleMessage.copy(str, str2, num, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDays() {
        return this.days;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final SendNobleMessage copy(@Nullable String days, @Nullable String identifier, @Nullable Integer nobleLevel, @Nullable String nickName) {
        return new SendNobleMessage(days, identifier, nobleLevel, nickName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendNobleMessage)) {
            return false;
        }
        SendNobleMessage sendNobleMessage = (SendNobleMessage) other;
        return Intrinsics.areEqual(this.days, sendNobleMessage.days) && Intrinsics.areEqual(this.identifier, sendNobleMessage.identifier) && Intrinsics.areEqual(this.nobleLevel, sendNobleMessage.nobleLevel) && Intrinsics.areEqual(this.nickName, sendNobleMessage.nickName);
    }

    @Nullable
    public final String getDays() {
        return this.days;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    public int hashCode() {
        String str = this.days;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.identifier;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.nobleLevel;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.nickName;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDays(@Nullable String str) {
        this.days = str;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    public final void setNickName(@Nullable String str) {
        this.nickName = str;
    }

    public final void setNobleLevel(@Nullable Integer num) {
        this.nobleLevel = num;
    }

    @NotNull
    public String toString() {
        return "SendNobleMessage(days=" + this.days + ", identifier=" + this.identifier + ", nobleLevel=" + this.nobleLevel + ", nickName=" + this.nickName + ")";
    }

    public SendNobleMessage(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3) {
        this.days = str;
        this.identifier = str2;
        this.nobleLevel = num;
        this.nickName = str3;
    }

    public /* synthetic */ SendNobleMessage(String str, String str2, Integer num, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3);
    }
}
