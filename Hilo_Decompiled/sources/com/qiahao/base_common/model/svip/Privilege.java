package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0004J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lcom/qiahao/base_common/model/svip/Privilege;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "type", "", "canSwitch", "", "userSwitch", "mysteryCode", "", "<init>", "(IZZLjava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getCanSwitch", "()Z", "setCanSwitch", "(Z)V", "getUserSwitch", "setUserSwitch", "getMysteryCode", "()Ljava/lang/String;", "setMysteryCode", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Privilege implements Parcelable, Serializable {
    public static final int PRIVILEGE_17 = 17;
    public static final int PRIVILEGE_27 = 27;
    public static final int PRIVILEGE_29 = 29;
    public static final int PRIVILEGE_4 = 4;
    public static final int PRIVILEGE_5 = 5;
    public static final int PRIVILEGE_7 = 7;
    public static final int PRIVILEGE_9 = 9;
    private boolean canSwitch;

    @Nullable
    private String mysteryCode;
    private int type;
    private boolean userSwitch;

    @NotNull
    public static final Parcelable.Creator<Privilege> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<Privilege> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Privilege createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Privilege(parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Privilege[] newArray(int i10) {
            return new Privilege[i10];
        }
    }

    public Privilege(int i10, boolean z10, boolean z11, @Nullable String str) {
        this.type = i10;
        this.canSwitch = z10;
        this.userSwitch = z11;
        this.mysteryCode = str;
    }

    public static /* synthetic */ Privilege copy$default(Privilege privilege, int i10, boolean z10, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = privilege.type;
        }
        if ((i11 & 2) != 0) {
            z10 = privilege.canSwitch;
        }
        if ((i11 & 4) != 0) {
            z11 = privilege.userSwitch;
        }
        if ((i11 & 8) != 0) {
            str = privilege.mysteryCode;
        }
        return privilege.copy(i10, z10, z11, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanSwitch() {
        return this.canSwitch;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUserSwitch() {
        return this.userSwitch;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMysteryCode() {
        return this.mysteryCode;
    }

    @NotNull
    public final Privilege copy(int type, boolean canSwitch, boolean userSwitch, @Nullable String mysteryCode) {
        return new Privilege(type, canSwitch, userSwitch, mysteryCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Privilege)) {
            return false;
        }
        Privilege privilege = (Privilege) other;
        return this.type == privilege.type && this.canSwitch == privilege.canSwitch && this.userSwitch == privilege.userSwitch && Intrinsics.areEqual(this.mysteryCode, privilege.mysteryCode);
    }

    public final boolean getCanSwitch() {
        return this.canSwitch;
    }

    @Nullable
    public final String getMysteryCode() {
        return this.mysteryCode;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getUserSwitch() {
        return this.userSwitch;
    }

    public int hashCode() {
        int a10 = ((((this.type * 31) + a.a(this.canSwitch)) * 31) + a.a(this.userSwitch)) * 31;
        String str = this.mysteryCode;
        return a10 + (str == null ? 0 : str.hashCode());
    }

    public final void setCanSwitch(boolean z10) {
        this.canSwitch = z10;
    }

    public final void setMysteryCode(@Nullable String str) {
        this.mysteryCode = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUserSwitch(boolean z10) {
        this.userSwitch = z10;
    }

    @NotNull
    public String toString() {
        return "Privilege(type=" + this.type + ", canSwitch=" + this.canSwitch + ", userSwitch=" + this.userSwitch + ", mysteryCode=" + this.mysteryCode + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.type);
        dest.writeInt(this.canSwitch ? 1 : 0);
        dest.writeInt(this.userSwitch ? 1 : 0);
        dest.writeString(this.mysteryCode);
    }

    public /* synthetic */ Privilege(int i10, boolean z10, boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, z10, z11, (i11 & 8) != 0 ? "" : str);
    }
}
