package com.qiahao.nextvideo.data.signaling;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/signaling/RoomAllGift;", "", "giftIcon", "", "<init>", "(Ljava/lang/String;)V", "getGiftIcon", "()Ljava/lang/String;", "setGiftIcon", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomAllGift {

    @Nullable
    private String giftIcon;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoomAllGift() {
        this(r0, 1, r0);
        String str = null;
    }

    public static /* synthetic */ RoomAllGift copy$default(RoomAllGift roomAllGift, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roomAllGift.giftIcon;
        }
        return roomAllGift.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGiftIcon() {
        return this.giftIcon;
    }

    @NotNull
    public final RoomAllGift copy(@Nullable String giftIcon) {
        return new RoomAllGift(giftIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RoomAllGift) && Intrinsics.areEqual(this.giftIcon, ((RoomAllGift) other).giftIcon);
    }

    @Nullable
    public final String getGiftIcon() {
        return this.giftIcon;
    }

    public int hashCode() {
        String str = this.giftIcon;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setGiftIcon(@Nullable String str) {
        this.giftIcon = str;
    }

    @NotNull
    public String toString() {
        return "RoomAllGift(giftIcon=" + this.giftIcon + ")";
    }

    public RoomAllGift(@Nullable String str) {
        this.giftIcon = str;
    }

    public /* synthetic */ RoomAllGift(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
