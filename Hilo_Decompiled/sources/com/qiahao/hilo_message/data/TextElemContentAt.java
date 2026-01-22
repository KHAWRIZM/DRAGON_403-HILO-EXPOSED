package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/hilo_message/data/TextElemContentAt;", "", "atAccount", "", "atNick", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAtAccount", "()Ljava/lang/String;", "setAtAccount", "(Ljava/lang/String;)V", "getAtNick", "setAtNick", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TextElemContentAt {

    @Nullable
    private String atAccount;

    @Nullable
    private String atNick;

    /* JADX WARN: Multi-variable type inference failed */
    public TextElemContentAt() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TextElemContentAt copy$default(TextElemContentAt textElemContentAt, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = textElemContentAt.atAccount;
        }
        if ((i10 & 2) != 0) {
            str2 = textElemContentAt.atNick;
        }
        return textElemContentAt.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAtAccount() {
        return this.atAccount;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAtNick() {
        return this.atNick;
    }

    @NotNull
    public final TextElemContentAt copy(@Nullable String atAccount, @Nullable String atNick) {
        return new TextElemContentAt(atAccount, atNick);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextElemContentAt)) {
            return false;
        }
        TextElemContentAt textElemContentAt = (TextElemContentAt) other;
        return Intrinsics.areEqual(this.atAccount, textElemContentAt.atAccount) && Intrinsics.areEqual(this.atNick, textElemContentAt.atNick);
    }

    @Nullable
    public final String getAtAccount() {
        return this.atAccount;
    }

    @Nullable
    public final String getAtNick() {
        return this.atNick;
    }

    public int hashCode() {
        String str = this.atAccount;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.atNick;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setAtAccount(@Nullable String str) {
        this.atAccount = str;
    }

    public final void setAtNick(@Nullable String str) {
        this.atNick = str;
    }

    @NotNull
    public String toString() {
        return "TextElemContentAt(atAccount=" + this.atAccount + ", atNick=" + this.atNick + ")";
    }

    public TextElemContentAt(@Nullable String str, @Nullable String str2) {
        this.atAccount = str;
        this.atNick = str2;
    }

    public /* synthetic */ TextElemContentAt(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
