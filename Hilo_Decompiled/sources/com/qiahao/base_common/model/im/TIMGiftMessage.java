package com.qiahao.base_common.model.im;

import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.GiftData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMGiftMessage;", "Lcom/qiahao/base_common/model/im/TIMCustomMessage;", "giftData", "", "identifier", "giftType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getGiftData", "()Ljava/lang/String;", "setGiftData", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "getGiftType", "()I", "setGiftType", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMGiftMessage extends TIMCustomMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String giftData;
    private int giftType;

    @NotNull
    private String identifier;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMGiftMessage$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/base_common/model/im/TIMGiftMessage;", "identifier", "", "giftItem", "Lcom/qiahao/base_common/model/GiftData;", "giftType", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TIMGiftMessage init$default(Companion companion, String str, GiftData giftData, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            return companion.init(str, giftData, i10);
        }

        @NotNull
        public final TIMGiftMessage init(@NotNull String identifier, @NotNull GiftData giftItem, int giftType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(giftItem, "giftItem");
            String s10 = BaseApplication.INSTANCE.getGSON().s(giftItem);
            Intrinsics.checkNotNull(s10);
            return new TIMGiftMessage(s10, identifier, giftType);
        }

        private Companion() {
        }
    }

    public /* synthetic */ TIMGiftMessage(String str, String str2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? 0 : i10);
    }

    public static /* synthetic */ TIMGiftMessage copy$default(TIMGiftMessage tIMGiftMessage, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tIMGiftMessage.giftData;
        }
        if ((i11 & 2) != 0) {
            str2 = tIMGiftMessage.identifier;
        }
        if ((i11 & 4) != 0) {
            i10 = tIMGiftMessage.giftType;
        }
        return tIMGiftMessage.copy(str, str2, i10);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGiftData() {
        return this.giftData;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component3, reason: from getter */
    public final int getGiftType() {
        return this.giftType;
    }

    @NotNull
    public final TIMGiftMessage copy(@NotNull String giftData, @NotNull String identifier, int giftType) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new TIMGiftMessage(giftData, identifier, giftType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMGiftMessage)) {
            return false;
        }
        TIMGiftMessage tIMGiftMessage = (TIMGiftMessage) other;
        return Intrinsics.areEqual(this.giftData, tIMGiftMessage.giftData) && Intrinsics.areEqual(this.identifier, tIMGiftMessage.identifier) && this.giftType == tIMGiftMessage.giftType;
    }

    @NotNull
    public final String getGiftData() {
        return this.giftData;
    }

    public final int getGiftType() {
        return this.giftType;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return (((this.giftData.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.giftType;
    }

    public final void setGiftData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftData = str;
    }

    public final void setGiftType(int i10) {
        this.giftType = i10;
    }

    public final void setIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "TIMGiftMessage(giftData=" + this.giftData + ", identifier=" + this.identifier + ", giftType=" + this.giftType + ")";
    }

    public TIMGiftMessage(@NotNull String giftData, @NotNull String identifier, int i10) {
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.giftData = giftData;
        this.identifier = identifier;
        this.giftType = i10;
    }
}
