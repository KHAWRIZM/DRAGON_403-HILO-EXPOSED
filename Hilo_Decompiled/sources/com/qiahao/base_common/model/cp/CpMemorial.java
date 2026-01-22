package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 Jv\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010=J\u0006\u0010>\u001a\u00020\u000bJ\u0013\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u000bHÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\f\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010.\"\u0004\b/\u00100R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"¨\u0006I"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpMemorial;", "Landroid/os/Parcelable;", "canDel", "", "content", "", "cpInfo", "Lcom/qiahao/base_common/model/cp/CpInfo;", HeaderInterceptor.TIMESTAMP, "", "id", "", "isRemind", "type", "isTop", "originTimestamp", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/cp/CpInfo;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;IZLjava/lang/Long;)V", "getCanDel", "()Ljava/lang/Boolean;", "setCanDel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCpInfo", "()Lcom/qiahao/base_common/model/cp/CpInfo;", "setCpInfo", "(Lcom/qiahao/base_common/model/cp/CpInfo;)V", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setRemind", "getType", "()I", "setType", "(I)V", "()Z", "setTop", "(Z)V", "getOriginTimestamp", "setOriginTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/cp/CpInfo;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;IZLjava/lang/Long;)Lcom/qiahao/base_common/model/cp/CpMemorial;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpMemorial implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpMemorial> CREATOR = new Creator();

    @Nullable
    private Boolean canDel;

    @Nullable
    private String content;

    @Nullable
    private CpInfo cpInfo;

    @Nullable
    private Integer id;

    @Nullable
    private Boolean isRemind;
    private boolean isTop;

    @Nullable
    private Long originTimestamp;

    @Nullable
    private Long timestamp;
    private int type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpMemorial> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpMemorial createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString = parcel.readString();
            CpInfo createFromParcel = parcel.readInt() == 0 ? null : CpInfo.CREATOR.createFromParcel(parcel);
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CpMemorial(valueOf, readString, createFromParcel, valueOf3, valueOf4, valueOf2, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpMemorial[] newArray(int i10) {
            return new CpMemorial[i10];
        }
    }

    public CpMemorial() {
        this(null, null, null, null, null, null, 0, false, null, 511, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getCanDel() {
        return this.canDel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final CpInfo getCpInfo() {
        return this.cpInfo;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getIsRemind() {
        return this.isRemind;
    }

    /* renamed from: component7, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getOriginTimestamp() {
        return this.originTimestamp;
    }

    @NotNull
    public final CpMemorial copy(@Nullable Boolean canDel, @Nullable String content, @Nullable CpInfo cpInfo, @Nullable Long timestamp, @Nullable Integer id, @Nullable Boolean isRemind, int type, boolean isTop, @Nullable Long originTimestamp) {
        return new CpMemorial(canDel, content, cpInfo, timestamp, id, isRemind, type, isTop, originTimestamp);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpMemorial)) {
            return false;
        }
        CpMemorial cpMemorial = (CpMemorial) other;
        return Intrinsics.areEqual(this.canDel, cpMemorial.canDel) && Intrinsics.areEqual(this.content, cpMemorial.content) && Intrinsics.areEqual(this.cpInfo, cpMemorial.cpInfo) && Intrinsics.areEqual(this.timestamp, cpMemorial.timestamp) && Intrinsics.areEqual(this.id, cpMemorial.id) && Intrinsics.areEqual(this.isRemind, cpMemorial.isRemind) && this.type == cpMemorial.type && this.isTop == cpMemorial.isTop && Intrinsics.areEqual(this.originTimestamp, cpMemorial.originTimestamp);
    }

    @Nullable
    public final Boolean getCanDel() {
        return this.canDel;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final CpInfo getCpInfo() {
        return this.cpInfo;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final Long getOriginTimestamp() {
        return this.originTimestamp;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        Boolean bool = this.canDel;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CpInfo cpInfo = this.cpInfo;
        int hashCode3 = (hashCode2 + (cpInfo == null ? 0 : cpInfo.hashCode())) * 31;
        Long l10 = this.timestamp;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.id;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool2 = this.isRemind;
        int hashCode6 = (((((hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + this.type) * 31) + a.a(this.isTop)) * 31;
        Long l11 = this.originTimestamp;
        return hashCode6 + (l11 != null ? l11.hashCode() : 0);
    }

    @Nullable
    public final Boolean isRemind() {
        return this.isRemind;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public final void setCanDel(@Nullable Boolean bool) {
        this.canDel = bool;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCpInfo(@Nullable CpInfo cpInfo) {
        this.cpInfo = cpInfo;
    }

    public final void setId(@Nullable Integer num) {
        this.id = num;
    }

    public final void setOriginTimestamp(@Nullable Long l10) {
        this.originTimestamp = l10;
    }

    public final void setRemind(@Nullable Boolean bool) {
        this.isRemind = bool;
    }

    public final void setTimestamp(@Nullable Long l10) {
        this.timestamp = l10;
    }

    public final void setTop(boolean z10) {
        this.isTop = z10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @NotNull
    public String toString() {
        return "CpMemorial(canDel=" + this.canDel + ", content=" + this.content + ", cpInfo=" + this.cpInfo + ", timestamp=" + this.timestamp + ", id=" + this.id + ", isRemind=" + this.isRemind + ", type=" + this.type + ", isTop=" + this.isTop + ", originTimestamp=" + this.originTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Boolean bool = this.canDel;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.content);
        CpInfo cpInfo = this.cpInfo;
        if (cpInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            cpInfo.writeToParcel(dest, flags);
        }
        Long l10 = this.timestamp;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Integer num = this.id;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool2 = this.isRemind;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.type);
        dest.writeInt(this.isTop ? 1 : 0);
        Long l11 = this.originTimestamp;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
    }

    public CpMemorial(@Nullable Boolean bool, @Nullable String str, @Nullable CpInfo cpInfo, @Nullable Long l10, @Nullable Integer num, @Nullable Boolean bool2, int i10, boolean z10, @Nullable Long l11) {
        this.canDel = bool;
        this.content = str;
        this.cpInfo = cpInfo;
        this.timestamp = l10;
        this.id = num;
        this.isRemind = bool2;
        this.type = i10;
        this.isTop = z10;
        this.originTimestamp = l11;
    }

    public /* synthetic */ CpMemorial(Boolean bool, String str, CpInfo cpInfo, Long l10, Integer num, Boolean bool2, int i10, boolean z10, Long l11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : cpInfo, (i11 & 8) != 0 ? null : l10, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : bool2, (i11 & 64) != 0 ? 0 : i10, (i11 & 128) == 0 ? z10 : false, (i11 & 256) == 0 ? l11 : null);
    }
}
