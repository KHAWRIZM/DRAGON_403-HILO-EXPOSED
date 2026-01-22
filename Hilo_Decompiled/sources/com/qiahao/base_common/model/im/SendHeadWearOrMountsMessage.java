package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/model/im/SendHeadWearOrMountsMessage;", "", "days", "", "identifier", "resHeadwearId", "", "resPropertyId", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDays", "()Ljava/lang/String;", "setDays", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "getResHeadwearId", "()Ljava/lang/Integer;", "setResHeadwearId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getResPropertyId", "setResPropertyId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/SendHeadWearOrMountsMessage;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SendHeadWearOrMountsMessage {

    @Nullable
    private String days;

    @Nullable
    private String identifier;

    @Nullable
    private Integer resHeadwearId;

    @Nullable
    private Integer resPropertyId;

    @Nullable
    private String url;

    public SendHeadWearOrMountsMessage() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SendHeadWearOrMountsMessage copy$default(SendHeadWearOrMountsMessage sendHeadWearOrMountsMessage, String str, String str2, Integer num, Integer num2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sendHeadWearOrMountsMessage.days;
        }
        if ((i10 & 2) != 0) {
            str2 = sendHeadWearOrMountsMessage.identifier;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            num = sendHeadWearOrMountsMessage.resHeadwearId;
        }
        Integer num3 = num;
        if ((i10 & 8) != 0) {
            num2 = sendHeadWearOrMountsMessage.resPropertyId;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            str3 = sendHeadWearOrMountsMessage.url;
        }
        return sendHeadWearOrMountsMessage.copy(str, str4, num3, num4, str3);
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
    public final Integer getResHeadwearId() {
        return this.resHeadwearId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getResPropertyId() {
        return this.resPropertyId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final SendHeadWearOrMountsMessage copy(@Nullable String days, @Nullable String identifier, @Nullable Integer resHeadwearId, @Nullable Integer resPropertyId, @Nullable String url) {
        return new SendHeadWearOrMountsMessage(days, identifier, resHeadwearId, resPropertyId, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendHeadWearOrMountsMessage)) {
            return false;
        }
        SendHeadWearOrMountsMessage sendHeadWearOrMountsMessage = (SendHeadWearOrMountsMessage) other;
        return Intrinsics.areEqual(this.days, sendHeadWearOrMountsMessage.days) && Intrinsics.areEqual(this.identifier, sendHeadWearOrMountsMessage.identifier) && Intrinsics.areEqual(this.resHeadwearId, sendHeadWearOrMountsMessage.resHeadwearId) && Intrinsics.areEqual(this.resPropertyId, sendHeadWearOrMountsMessage.resPropertyId) && Intrinsics.areEqual(this.url, sendHeadWearOrMountsMessage.url);
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
    public final Integer getResHeadwearId() {
        return this.resHeadwearId;
    }

    @Nullable
    public final Integer getResPropertyId() {
        return this.resPropertyId;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.days;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.identifier;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.resHeadwearId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.resPropertyId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.url;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDays(@Nullable String str) {
        this.days = str;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    public final void setResHeadwearId(@Nullable Integer num) {
        this.resHeadwearId = num;
    }

    public final void setResPropertyId(@Nullable Integer num) {
        this.resPropertyId = num;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "SendHeadWearOrMountsMessage(days=" + this.days + ", identifier=" + this.identifier + ", resHeadwearId=" + this.resHeadwearId + ", resPropertyId=" + this.resPropertyId + ", url=" + this.url + ")";
    }

    public SendHeadWearOrMountsMessage(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3) {
        this.days = str;
        this.identifier = str2;
        this.resHeadwearId = num;
        this.resPropertyId = num2;
        this.url = str3;
    }

    public /* synthetic */ SendHeadWearOrMountsMessage(String str, String str2, Integer num, Integer num2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : str3);
    }
}
