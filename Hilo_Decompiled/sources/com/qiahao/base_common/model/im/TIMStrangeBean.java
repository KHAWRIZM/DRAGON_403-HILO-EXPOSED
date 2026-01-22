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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMStrangeBean;", "Landroid/os/Parcelable;", "userName", "", "userAvatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "getUserAvatar", "setUserAvatar", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMStrangeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TIMStrangeBean> CREATOR = new Creator();

    @Nullable
    private String userAvatar;

    @Nullable
    private String userName;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<TIMStrangeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMStrangeBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TIMStrangeBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMStrangeBean[] newArray(int i10) {
            return new TIMStrangeBean[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TIMStrangeBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TIMStrangeBean copy$default(TIMStrangeBean tIMStrangeBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tIMStrangeBean.userName;
        }
        if ((i10 & 2) != 0) {
            str2 = tIMStrangeBean.userAvatar;
        }
        return tIMStrangeBean.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @NotNull
    public final TIMStrangeBean copy(@Nullable String userName, @Nullable String userAvatar) {
        return new TIMStrangeBean(userName, userAvatar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMStrangeBean)) {
            return false;
        }
        TIMStrangeBean tIMStrangeBean = (TIMStrangeBean) other;
        return Intrinsics.areEqual(this.userName, tIMStrangeBean.userName) && Intrinsics.areEqual(this.userAvatar, tIMStrangeBean.userAvatar);
    }

    @Nullable
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.userName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userAvatar;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setUserAvatar(@Nullable String str) {
        this.userAvatar = str;
    }

    public final void setUserName(@Nullable String str) {
        this.userName = str;
    }

    @NotNull
    public String toString() {
        return "TIMStrangeBean(userName=" + this.userName + ", userAvatar=" + this.userAvatar + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.userName);
        dest.writeString(this.userAvatar);
    }

    public TIMStrangeBean(@Nullable String str, @Nullable String str2) {
        this.userName = str;
        this.userAvatar = str2;
    }

    public /* synthetic */ TIMStrangeBean(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
