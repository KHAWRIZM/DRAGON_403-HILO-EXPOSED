package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0004J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010&\u001a\u00020\u0004J\u0013\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\t\u0010+\u001a\u00020\nHÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipData;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "svipLevel", "", "privileges", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/svip/Privilege;", "Lkotlin/collections/ArrayList;", "medalEffect", "", "<init>", "(ILjava/util/ArrayList;Ljava/lang/String;)V", "getSvipLevel", "()I", "setSvipLevel", "(I)V", "getPrivileges", "()Ljava/util/ArrayList;", "setPrivileges", "(Ljava/util/ArrayList;)V", "getMedalEffect", "()Ljava/lang/String;", "setMedalEffect", "(Ljava/lang/String;)V", "isHideGift", "", "isNotFollow", "isRankStealth", "isMystery", "mysteryNumber", "isHideOnLine", "checkPrivilege", "type", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipData.kt\ncom/qiahao/base_common/model/svip/SvipData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1869#2,2:95\n1869#2,2:97\n1869#2,2:99\n1869#2,2:101\n1869#2,2:103\n1869#2,2:105\n1869#2,2:107\n*S KotlinDebug\n*F\n+ 1 SvipData.kt\ncom/qiahao/base_common/model/svip/SvipData\n*L\n20#1:95,2\n31#1:97,2\n42#1:99,2\n53#1:101,2\n63#1:103,2\n74#1:105,2\n87#1:107,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipData implements Parcelable, Serializable {

    @NotNull
    public static final Parcelable.Creator<SvipData> CREATOR = new Creator();

    @Nullable
    private String medalEffect;

    @Nullable
    private ArrayList<Privilege> privileges;
    private int svipLevel;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i10 = 0; i10 != readInt2; i10++) {
                    arrayList2.add(Privilege.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SvipData(readInt, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipData[] newArray(int i10) {
            return new SvipData[i10];
        }
    }

    public SvipData(int i10, @Nullable ArrayList<Privilege> arrayList, @Nullable String str) {
        this.svipLevel = i10;
        this.privileges = arrayList;
        this.medalEffect = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SvipData copy$default(SvipData svipData, int i10, ArrayList arrayList, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = svipData.svipLevel;
        }
        if ((i11 & 2) != 0) {
            arrayList = svipData.privileges;
        }
        if ((i11 & 4) != 0) {
            str = svipData.medalEffect;
        }
        return svipData.copy(i10, arrayList, str);
    }

    public final boolean checkPrivilege(int type) {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == type && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    /* renamed from: component1, reason: from getter */
    public final int getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final ArrayList<Privilege> component2() {
        return this.privileges;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMedalEffect() {
        return this.medalEffect;
    }

    @NotNull
    public final SvipData copy(int svipLevel, @Nullable ArrayList<Privilege> privileges, @Nullable String medalEffect) {
        return new SvipData(svipLevel, privileges, medalEffect);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipData)) {
            return false;
        }
        SvipData svipData = (SvipData) other;
        return this.svipLevel == svipData.svipLevel && Intrinsics.areEqual(this.privileges, svipData.privileges) && Intrinsics.areEqual(this.medalEffect, svipData.medalEffect);
    }

    @Nullable
    public final String getMedalEffect() {
        return this.medalEffect;
    }

    @Nullable
    public final ArrayList<Privilege> getPrivileges() {
        return this.privileges;
    }

    public final int getSvipLevel() {
        return this.svipLevel;
    }

    public int hashCode() {
        int i10 = this.svipLevel * 31;
        ArrayList<Privilege> arrayList = this.privileges;
        int hashCode = (i10 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str = this.medalEffect;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isHideGift() {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == 7 && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isHideOnLine() {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == 4 && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isMystery() {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == 17 && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isNotFollow() {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == 5 && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final boolean isRankStealth() {
        ArrayList<Privilege> arrayList = this.privileges;
        boolean z10 = false;
        if (arrayList != null) {
            for (Privilege privilege : arrayList) {
                if (privilege.getType() == 9 && privilege.getUserSwitch()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    @NotNull
    public final String mysteryNumber() {
        ArrayList<Privilege> arrayList = this.privileges;
        if (arrayList == null) {
            return "";
        }
        for (Privilege privilege : arrayList) {
            if (privilege.getType() == 17 && privilege.getUserSwitch()) {
                String mysteryCode = privilege.getMysteryCode();
                if (mysteryCode == null) {
                    return "";
                }
                return mysteryCode;
            }
        }
        return "";
    }

    public final void setMedalEffect(@Nullable String str) {
        this.medalEffect = str;
    }

    public final void setPrivileges(@Nullable ArrayList<Privilege> arrayList) {
        this.privileges = arrayList;
    }

    public final void setSvipLevel(int i10) {
        this.svipLevel = i10;
    }

    @NotNull
    public String toString() {
        return "SvipData(svipLevel=" + this.svipLevel + ", privileges=" + this.privileges + ", medalEffect=" + this.medalEffect + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.svipLevel);
        ArrayList<Privilege> arrayList = this.privileges;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Privilege> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.medalEffect);
    }

    public /* synthetic */ SvipData(int i10, ArrayList arrayList, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : arrayList, (i11 & 4) != 0 ? null : str);
    }
}
