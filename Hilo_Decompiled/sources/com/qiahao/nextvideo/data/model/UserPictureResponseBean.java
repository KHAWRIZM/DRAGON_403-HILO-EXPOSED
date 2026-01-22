package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserPictureResponseBean;", "Landroid/os/Parcelable;", "photo_id", "", "photo_url", "", "<init>", "(ILjava/lang/String;)V", "getPhoto_id", "()I", "setPhoto_id", "(I)V", "getPhoto_url", "()Ljava/lang/String;", "setPhoto_url", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserPictureResponseBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserPictureResponseBean> CREATOR = new Creator();
    private int photo_id;

    @NotNull
    private String photo_url;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<UserPictureResponseBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserPictureResponseBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserPictureResponseBean(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserPictureResponseBean[] newArray(int i) {
            return new UserPictureResponseBean[i];
        }
    }

    public UserPictureResponseBean(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "photo_url");
        this.photo_id = i;
        this.photo_url = str;
    }

    public static /* synthetic */ UserPictureResponseBean copy$default(UserPictureResponseBean userPictureResponseBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userPictureResponseBean.photo_id;
        }
        if ((i2 & 2) != 0) {
            str = userPictureResponseBean.photo_url;
        }
        return userPictureResponseBean.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPhoto_id() {
        return this.photo_id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPhoto_url() {
        return this.photo_url;
    }

    @NotNull
    public final UserPictureResponseBean copy(int photo_id, @NotNull String photo_url) {
        Intrinsics.checkNotNullParameter(photo_url, "photo_url");
        return new UserPictureResponseBean(photo_id, photo_url);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPictureResponseBean)) {
            return false;
        }
        UserPictureResponseBean userPictureResponseBean = (UserPictureResponseBean) other;
        return this.photo_id == userPictureResponseBean.photo_id && Intrinsics.areEqual(this.photo_url, userPictureResponseBean.photo_url);
    }

    public final int getPhoto_id() {
        return this.photo_id;
    }

    @NotNull
    public final String getPhoto_url() {
        return this.photo_url;
    }

    public int hashCode() {
        return (this.photo_id * 31) + this.photo_url.hashCode();
    }

    public final void setPhoto_id(int i) {
        this.photo_id = i;
    }

    public final void setPhoto_url(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photo_url = str;
    }

    @NotNull
    public String toString() {
        return "UserPictureResponseBean(photo_id=" + this.photo_id + ", photo_url=" + this.photo_url + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.photo_id);
        dest.writeString(this.photo_url);
    }
}
