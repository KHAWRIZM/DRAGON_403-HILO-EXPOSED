package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/qiahao/hilo_message/data/RoomTip;", "", "type", "", "tipType", "", "notice", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTipType", "()I", "setTipType", "(I)V", "getNotice", "setNotice", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RoomTip {

    @Nullable
    private String notice;
    private int tipType;

    @Nullable
    private final String type;

    public RoomTip() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ RoomTip copy$default(RoomTip roomTip, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = roomTip.type;
        }
        if ((i11 & 2) != 0) {
            i10 = roomTip.tipType;
        }
        if ((i11 & 4) != 0) {
            str2 = roomTip.notice;
        }
        return roomTip.copy(str, i10, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTipType() {
        return this.tipType;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNotice() {
        return this.notice;
    }

    @NotNull
    public final RoomTip copy(@Nullable String type, int tipType, @Nullable String notice) {
        return new RoomTip(type, tipType, notice);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomTip)) {
            return false;
        }
        RoomTip roomTip = (RoomTip) other;
        return Intrinsics.areEqual(this.type, roomTip.type) && this.tipType == roomTip.tipType && Intrinsics.areEqual(this.notice, roomTip.notice);
    }

    @Nullable
    public final String getNotice() {
        return this.notice;
    }

    public final int getTipType() {
        return this.tipType;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (this.tipType + ((str == null ? 0 : str.hashCode()) * 31)) * 31;
        String str2 = this.notice;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setNotice(@Nullable String str) {
        this.notice = str;
    }

    public final void setTipType(int i10) {
        this.tipType = i10;
    }

    @NotNull
    public String toString() {
        return "RoomTip(type=" + this.type + ", tipType=" + this.tipType + ", notice=" + this.notice + ")";
    }

    public RoomTip(@Nullable String str, int i10, @Nullable String str2) {
        this.type = str;
        this.tipType = i10;
        this.notice = str2;
    }

    public /* synthetic */ RoomTip(String str, int i10, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 1 : i10, (i11 & 4) != 0 ? null : str2);
    }
}
