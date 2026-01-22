package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\"\u001a\u00020\u0003J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006."}, d2 = {"Lcom/qiahao/base_common/model/svip/Details;", "Landroid/os/Parcelable;", "addReduce", "", "createdTime", "", "createdTimeUnix", "", "num", "remark", "<init>", "(ILjava/lang/String;JILjava/lang/String;)V", "getAddReduce", "()I", "setAddReduce", "(I)V", "getCreatedTime", "()Ljava/lang/String;", "setCreatedTime", "(Ljava/lang/String;)V", "getCreatedTimeUnix", "()J", "setCreatedTimeUnix", "(J)V", "getNum", "setNum", "getRemark", "setRemark", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Details implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Details> CREATOR = new Creator();
    private int addReduce;

    @NotNull
    private String createdTime;
    private long createdTimeUnix;
    private int num;

    @NotNull
    private String remark;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<Details> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Details createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Details(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Details[] newArray(int i10) {
            return new Details[i10];
        }
    }

    public Details() {
        this(0, null, 0L, 0, null, 31, null);
    }

    public static /* synthetic */ Details copy$default(Details details, int i10, String str, long j10, int i11, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = details.addReduce;
        }
        if ((i12 & 2) != 0) {
            str = details.createdTime;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            j10 = details.createdTimeUnix;
        }
        long j11 = j10;
        if ((i12 & 8) != 0) {
            i11 = details.num;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            str2 = details.remark;
        }
        return details.copy(i10, str3, j11, i13, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAddReduce() {
        return this.addReduce;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedTimeUnix() {
        return this.createdTimeUnix;
    }

    /* renamed from: component4, reason: from getter */
    public final int getNum() {
        return this.num;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    @NotNull
    public final Details copy(int addReduce, @NotNull String createdTime, long createdTimeUnix, int num, @NotNull String remark) {
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new Details(addReduce, createdTime, createdTimeUnix, num, remark);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Details)) {
            return false;
        }
        Details details = (Details) other;
        return this.addReduce == details.addReduce && Intrinsics.areEqual(this.createdTime, details.createdTime) && this.createdTimeUnix == details.createdTimeUnix && this.num == details.num && Intrinsics.areEqual(this.remark, details.remark);
    }

    public final int getAddReduce() {
        return this.addReduce;
    }

    @NotNull
    public final String getCreatedTime() {
        return this.createdTime;
    }

    public final long getCreatedTimeUnix() {
        return this.createdTimeUnix;
    }

    public final int getNum() {
        return this.num;
    }

    @NotNull
    public final String getRemark() {
        return this.remark;
    }

    public int hashCode() {
        return (((((((this.addReduce * 31) + this.createdTime.hashCode()) * 31) + c.a(this.createdTimeUnix)) * 31) + this.num) * 31) + this.remark.hashCode();
    }

    public final void setAddReduce(int i10) {
        this.addReduce = i10;
    }

    public final void setCreatedTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.createdTime = str;
    }

    public final void setCreatedTimeUnix(long j10) {
        this.createdTimeUnix = j10;
    }

    public final void setNum(int i10) {
        this.num = i10;
    }

    public final void setRemark(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remark = str;
    }

    @NotNull
    public String toString() {
        return "Details(addReduce=" + this.addReduce + ", createdTime=" + this.createdTime + ", createdTimeUnix=" + this.createdTimeUnix + ", num=" + this.num + ", remark=" + this.remark + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.addReduce);
        dest.writeString(this.createdTime);
        dest.writeLong(this.createdTimeUnix);
        dest.writeInt(this.num);
        dest.writeString(this.remark);
    }

    public Details(int i10, @NotNull String createdTime, long j10, int i11, @NotNull String remark) {
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(remark, "remark");
        this.addReduce = i10;
        this.createdTime = createdTime;
        this.createdTimeUnix = j10;
        this.num = i11;
        this.remark = remark;
    }

    public /* synthetic */ Details(int i10, String str, long j10, int i11, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? 0L : j10, (i12 & 8) == 0 ? i11 : 0, (i12 & 16) != 0 ? "" : str2);
    }
}
