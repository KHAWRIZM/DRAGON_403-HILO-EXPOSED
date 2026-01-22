package com.qiahao.nextvideo.data.model;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u0007J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;", "Landroid/os/Parcelable;", "name", "", "birthday", "", "sex", "", "country", "loginType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSex", "()Ljava/lang/Integer;", "setSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCountry", "setCountry", "getLoginType", "setLoginType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FillUserDataUIModel implements Parcelable {

    @Nullable
    private Long birthday;

    @Nullable
    private String country;

    @Nullable
    private Integer loginType;

    @Nullable
    private String name;

    @Nullable
    private Integer sex;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<FillUserDataUIModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;", "user", "Lcom/qiahao/base_common/model/common/User;", "loginType", "", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/FillUserDataUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FillUserDataUIModel init(@NotNull User user, @Nullable Integer loginType) {
            Intrinsics.checkNotNullParameter(user, "user");
            return new FillUserDataUIModel(user.getNick(), user.getBirthday(), Integer.valueOf(user.getSex()), user.getCountry(), loginType);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FillUserDataUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FillUserDataUIModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FillUserDataUIModel(parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FillUserDataUIModel[] newArray(int i) {
            return new FillUserDataUIModel[i];
        }
    }

    public FillUserDataUIModel(@Nullable String str, @Nullable Long l, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2) {
        this.name = str;
        this.birthday = l;
        this.sex = num;
        this.country = str2;
        this.loginType = num2;
    }

    public static /* synthetic */ FillUserDataUIModel copy$default(FillUserDataUIModel fillUserDataUIModel, String str, Long l, Integer num, String str2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fillUserDataUIModel.name;
        }
        if ((i & 2) != 0) {
            l = fillUserDataUIModel.birthday;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            num = fillUserDataUIModel.sex;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            str2 = fillUserDataUIModel.country;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            num2 = fillUserDataUIModel.loginType;
        }
        return fillUserDataUIModel.copy(str, l2, num3, str3, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getLoginType() {
        return this.loginType;
    }

    @NotNull
    public final FillUserDataUIModel copy(@Nullable String name, @Nullable Long birthday, @Nullable Integer sex, @Nullable String country, @Nullable Integer loginType) {
        return new FillUserDataUIModel(name, birthday, sex, country, loginType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FillUserDataUIModel)) {
            return false;
        }
        FillUserDataUIModel fillUserDataUIModel = (FillUserDataUIModel) other;
        return Intrinsics.areEqual(this.name, fillUserDataUIModel.name) && Intrinsics.areEqual(this.birthday, fillUserDataUIModel.birthday) && Intrinsics.areEqual(this.sex, fillUserDataUIModel.sex) && Intrinsics.areEqual(this.country, fillUserDataUIModel.country) && Intrinsics.areEqual(this.loginType, fillUserDataUIModel.loginType);
    }

    @Nullable
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final Integer getLoginType() {
        return this.loginType;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.birthday;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.sex;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.loginType;
        return hashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setBirthday(@Nullable Long l) {
        this.birthday = l;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setLoginType(@Nullable Integer num) {
        this.loginType = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    @NotNull
    public String toString() {
        return "FillUserDataUIModel(name=" + this.name + ", birthday=" + this.birthday + ", sex=" + this.sex + ", country=" + this.country + ", loginType=" + this.loginType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.name);
        Long l = this.birthday;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Integer num = this.sex;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.country);
        Integer num2 = this.loginType;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
    }

    public /* synthetic */ FillUserDataUIModel(String str, Long l, Integer num, String str2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, num, str2, (i & 16) != 0 ? 0 : num2);
    }
}
