package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import io.agora.rtc.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u001d\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\rHÆ\u0003Jt\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\rHÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\tJ\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\tHÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpPrivilege;", "Landroid/os/Parcelable;", "canSwitch", "", "icon", "", "name", "desc", "type", "", "userSwitch", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "getCanSwitch", "()Ljava/lang/Boolean;", "setCanSwitch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getName", "setName", "getDesc", "setDesc", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserSwitch", "setUserSwitch", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/ArrayList;)Lcom/qiahao/base_common/model/cp/CpPrivilege;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpPrivilege implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpPrivilege> CREATOR = new Creator();

    @Nullable
    private Boolean canSwitch;

    @Nullable
    private String desc;

    @Nullable
    private String icon;

    @Nullable
    private ArrayList<Integer> levelList;

    @Nullable
    private String name;

    @Nullable
    private Integer type;

    @Nullable
    private Boolean userSwitch;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpPrivilege> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpPrivilege createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Boolean valueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                }
            }
            return new CpPrivilege(valueOf, readString, readString2, readString3, valueOf2, valueOf3, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpPrivilege[] newArray(int i10) {
            return new CpPrivilege[i10];
        }
    }

    public CpPrivilege() {
        this(null, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null);
    }

    public static /* synthetic */ CpPrivilege copy$default(CpPrivilege cpPrivilege, Boolean bool, String str, String str2, String str3, Integer num, Boolean bool2, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = cpPrivilege.canSwitch;
        }
        if ((i10 & 2) != 0) {
            str = cpPrivilege.icon;
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            str2 = cpPrivilege.name;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = cpPrivilege.desc;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            num = cpPrivilege.type;
        }
        Integer num2 = num;
        if ((i10 & 32) != 0) {
            bool2 = cpPrivilege.userSwitch;
        }
        Boolean bool3 = bool2;
        if ((i10 & 64) != 0) {
            arrayList = cpPrivilege.levelList;
        }
        return cpPrivilege.copy(bool, str4, str5, str6, num2, bool3, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getCanSwitch() {
        return this.canSwitch;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getUserSwitch() {
        return this.userSwitch;
    }

    @Nullable
    public final ArrayList<Integer> component7() {
        return this.levelList;
    }

    @NotNull
    public final CpPrivilege copy(@Nullable Boolean canSwitch, @Nullable String icon, @Nullable String name, @Nullable String desc, @Nullable Integer type, @Nullable Boolean userSwitch, @Nullable ArrayList<Integer> levelList) {
        return new CpPrivilege(canSwitch, icon, name, desc, type, userSwitch, levelList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpPrivilege)) {
            return false;
        }
        CpPrivilege cpPrivilege = (CpPrivilege) other;
        return Intrinsics.areEqual(this.canSwitch, cpPrivilege.canSwitch) && Intrinsics.areEqual(this.icon, cpPrivilege.icon) && Intrinsics.areEqual(this.name, cpPrivilege.name) && Intrinsics.areEqual(this.desc, cpPrivilege.desc) && Intrinsics.areEqual(this.type, cpPrivilege.type) && Intrinsics.areEqual(this.userSwitch, cpPrivilege.userSwitch) && Intrinsics.areEqual(this.levelList, cpPrivilege.levelList);
    }

    @Nullable
    public final Boolean getCanSwitch() {
        return this.canSwitch;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final ArrayList<Integer> getLevelList() {
        return this.levelList;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final Boolean getUserSwitch() {
        return this.userSwitch;
    }

    public int hashCode() {
        Boolean bool = this.canSwitch;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.icon;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.type;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool2 = this.userSwitch;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.levelList;
        return hashCode6 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setCanSwitch(@Nullable Boolean bool) {
        this.canSwitch = bool;
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setLevelList(@Nullable ArrayList<Integer> arrayList) {
        this.levelList = arrayList;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setUserSwitch(@Nullable Boolean bool) {
        this.userSwitch = bool;
    }

    @NotNull
    public String toString() {
        return "CpPrivilege(canSwitch=" + this.canSwitch + ", icon=" + this.icon + ", name=" + this.name + ", desc=" + this.desc + ", type=" + this.type + ", userSwitch=" + this.userSwitch + ", levelList=" + this.levelList + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Boolean bool = this.canSwitch;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeString(this.desc);
        Integer num = this.type;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool2 = this.userSwitch;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        ArrayList<Integer> arrayList = this.levelList;
        if (arrayList == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(arrayList.size());
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            dest.writeInt(it.next().intValue());
        }
    }

    public CpPrivilege(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Boolean bool2, @Nullable ArrayList<Integer> arrayList) {
        this.canSwitch = bool;
        this.icon = str;
        this.name = str2;
        this.desc = str3;
        this.type = num;
        this.userSwitch = bool2;
        this.levelList = arrayList;
    }

    public /* synthetic */ CpPrivilege(Boolean bool, String str, String str2, String str3, Integer num, Boolean bool2, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : bool2, (i10 & 64) != 0 ? null : arrayList);
    }
}
