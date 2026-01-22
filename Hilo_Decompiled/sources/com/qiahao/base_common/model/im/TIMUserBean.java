package com.qiahao.base_common.model.im;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMUserBean;", "Landroid/os/Parcelable;", "externalId", "", "nick", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "getNick", "setNick", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TIMUserBean> CREATOR = new Creator();

    @NotNull
    private String externalId;

    @NotNull
    private String nick;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<TIMUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMUserBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TIMUserBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMUserBean[] newArray(int i10) {
            return new TIMUserBean[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TIMUserBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TIMUserBean copy$default(TIMUserBean tIMUserBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tIMUserBean.externalId;
        }
        if ((i10 & 2) != 0) {
            str2 = tIMUserBean.nick;
        }
        return tIMUserBean.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final TIMUserBean copy(@NotNull String externalId, @NotNull String nick) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new TIMUserBean(externalId, nick);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMUserBean)) {
            return false;
        }
        TIMUserBean tIMUserBean = (TIMUserBean) other;
        return Intrinsics.areEqual(this.externalId, tIMUserBean.externalId) && Intrinsics.areEqual(this.nick, tIMUserBean.nick);
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public int hashCode() {
        return (this.externalId.hashCode() * 31) + this.nick.hashCode();
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    @NotNull
    public String toString() {
        return "TIMUserBean(externalId=" + this.externalId + ", nick=" + this.nick + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.externalId);
        dest.writeString(this.nick);
    }

    public TIMUserBean(@NotNull String externalId, @NotNull String nick) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(nick, "nick");
        this.externalId = externalId;
        this.nick = nick;
    }

    public /* synthetic */ TIMUserBean(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }
}
