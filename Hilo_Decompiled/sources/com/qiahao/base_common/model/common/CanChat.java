package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/qiahao/base_common/model/common/CanChat;", "Landroid/os/Parcelable;", "canChat", "", "chatLeftUserCnt", "", "chatTips", "", "<init>", "(ZILjava/lang/String;)V", "getCanChat", "()Z", "setCanChat", "(Z)V", "getChatLeftUserCnt", "()I", "setChatLeftUserCnt", "(I)V", "getChatTips", "()Ljava/lang/String;", "setChatTips", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CanChat implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CanChat> CREATOR = new Creator();
    private boolean canChat;
    private int chatLeftUserCnt;

    @Nullable
    private String chatTips;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CanChat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CanChat createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CanChat(parcel.readInt() != 0, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CanChat[] newArray(int i10) {
            return new CanChat[i10];
        }
    }

    public CanChat() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ CanChat copy$default(CanChat canChat, boolean z10, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = canChat.canChat;
        }
        if ((i11 & 2) != 0) {
            i10 = canChat.chatLeftUserCnt;
        }
        if ((i11 & 4) != 0) {
            str = canChat.chatTips;
        }
        return canChat.copy(z10, i10, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanChat() {
        return this.canChat;
    }

    /* renamed from: component2, reason: from getter */
    public final int getChatLeftUserCnt() {
        return this.chatLeftUserCnt;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getChatTips() {
        return this.chatTips;
    }

    @NotNull
    public final CanChat copy(boolean canChat, int chatLeftUserCnt, @Nullable String chatTips) {
        return new CanChat(canChat, chatLeftUserCnt, chatTips);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CanChat)) {
            return false;
        }
        CanChat canChat = (CanChat) other;
        return this.canChat == canChat.canChat && this.chatLeftUserCnt == canChat.chatLeftUserCnt && Intrinsics.areEqual(this.chatTips, canChat.chatTips);
    }

    public final boolean getCanChat() {
        return this.canChat;
    }

    public final int getChatLeftUserCnt() {
        return this.chatLeftUserCnt;
    }

    @Nullable
    public final String getChatTips() {
        return this.chatTips;
    }

    public int hashCode() {
        int a10 = ((a.a(this.canChat) * 31) + this.chatLeftUserCnt) * 31;
        String str = this.chatTips;
        return a10 + (str == null ? 0 : str.hashCode());
    }

    public final void setCanChat(boolean z10) {
        this.canChat = z10;
    }

    public final void setChatLeftUserCnt(int i10) {
        this.chatLeftUserCnt = i10;
    }

    public final void setChatTips(@Nullable String str) {
        this.chatTips = str;
    }

    @NotNull
    public String toString() {
        return "CanChat(canChat=" + this.canChat + ", chatLeftUserCnt=" + this.chatLeftUserCnt + ", chatTips=" + this.chatTips + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.canChat ? 1 : 0);
        dest.writeInt(this.chatLeftUserCnt);
        dest.writeString(this.chatTips);
    }

    public CanChat(boolean z10, int i10, @Nullable String str) {
        this.canChat = z10;
        this.chatLeftUserCnt = i10;
        this.chatTips = str;
    }

    public /* synthetic */ CanChat(boolean z10, int i10, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z10, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str);
    }
}
