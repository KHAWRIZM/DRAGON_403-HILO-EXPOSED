package com.qiahao.nextvideo.data.planets;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/planets/HiloPlanetsData;", "Landroid/os/Parcelable;", "currentRoom", "", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;)V", "getCurrentRoom", "()Ljava/lang/String;", "setCurrentRoom", "(Ljava/lang/String;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloPlanetsData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<HiloPlanetsData> CREATOR = new Creator();

    @Nullable
    private String currentRoom;

    @Nullable
    private User user;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<HiloPlanetsData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HiloPlanetsData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HiloPlanetsData(parcel.readString(), parcel.readParcelable(HiloPlanetsData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HiloPlanetsData[] newArray(int i) {
            return new HiloPlanetsData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HiloPlanetsData() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ HiloPlanetsData copy$default(HiloPlanetsData hiloPlanetsData, String str, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hiloPlanetsData.currentRoom;
        }
        if ((i & 2) != 0) {
            user = hiloPlanetsData.user;
        }
        return hiloPlanetsData.copy(str, user);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final HiloPlanetsData copy(@Nullable String currentRoom, @Nullable User user) {
        return new HiloPlanetsData(currentRoom, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloPlanetsData)) {
            return false;
        }
        HiloPlanetsData hiloPlanetsData = (HiloPlanetsData) other;
        return Intrinsics.areEqual(this.currentRoom, hiloPlanetsData.currentRoom) && Intrinsics.areEqual(this.user, hiloPlanetsData.user);
    }

    @Nullable
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.currentRoom;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        User user = this.user;
        return hashCode + (user != null ? user.hashCode() : 0);
    }

    public final void setCurrentRoom(@Nullable String str) {
        this.currentRoom = str;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "HiloPlanetsData(currentRoom=" + this.currentRoom + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.currentRoom);
        dest.writeParcelable(this.user, flags);
    }

    public HiloPlanetsData(@Nullable String str, @Nullable User user) {
        this.currentRoom = str;
        this.user = user;
    }

    public /* synthetic */ HiloPlanetsData(String str, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : user);
    }
}
