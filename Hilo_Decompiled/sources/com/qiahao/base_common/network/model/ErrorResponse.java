package com.qiahao.base_common.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0005J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u00069"}, d2 = {"Lcom/qiahao/base_common/network/model/ErrorResponse;", "Landroid/os/Parcelable;", "code", "", "num", "", "second", HeaderInterceptor.TIMESTAMP, "", "title", "detail", "actionUrl", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getNum", "()Ljava/lang/Integer;", "setNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSecond", "setSecond", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTitle", "setTitle", "getDetail", "setDetail", "getActionUrl", "setActionUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/base_common/network/model/ErrorResponse;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ErrorResponse implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ErrorResponse> CREATOR = new Creator();

    @Nullable
    private String actionUrl;

    @Nullable
    private String code;

    @Nullable
    private String detail;

    @Nullable
    private Integer num;

    @Nullable
    private Integer second;

    @Nullable
    private Long timestamp;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<ErrorResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ErrorResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorResponse(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ErrorResponse[] newArray(int i10) {
            return new ErrorResponse[i10];
        }
    }

    public ErrorResponse() {
        this(null, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, String str, Integer num, Integer num2, Long l10, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = errorResponse.code;
        }
        if ((i10 & 2) != 0) {
            num = errorResponse.num;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            num2 = errorResponse.second;
        }
        Integer num4 = num2;
        if ((i10 & 8) != 0) {
            l10 = errorResponse.timestamp;
        }
        Long l11 = l10;
        if ((i10 & 16) != 0) {
            str2 = errorResponse.title;
        }
        String str5 = str2;
        if ((i10 & 32) != 0) {
            str3 = errorResponse.detail;
        }
        String str6 = str3;
        if ((i10 & 64) != 0) {
            str4 = errorResponse.actionUrl;
        }
        return errorResponse.copy(str, num3, num4, l11, str5, str6, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getNum() {
        return this.num;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getSecond() {
        return this.second;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @NotNull
    public final ErrorResponse copy(@Nullable String code, @Nullable Integer num, @Nullable Integer second, @Nullable Long timestamp, @Nullable String title, @Nullable String detail, @Nullable String actionUrl) {
        return new ErrorResponse(code, num, second, timestamp, title, detail, actionUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) other;
        return Intrinsics.areEqual(this.code, errorResponse.code) && Intrinsics.areEqual(this.num, errorResponse.num) && Intrinsics.areEqual(this.second, errorResponse.second) && Intrinsics.areEqual(this.timestamp, errorResponse.timestamp) && Intrinsics.areEqual(this.title, errorResponse.title) && Intrinsics.areEqual(this.detail, errorResponse.detail) && Intrinsics.areEqual(this.actionUrl, errorResponse.actionUrl);
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getDetail() {
        return this.detail;
    }

    @Nullable
    public final Integer getNum() {
        return this.num;
    }

    @Nullable
    public final Integer getSecond() {
        return this.second;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.num;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.second;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.timestamp;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.title;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.detail;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actionUrl;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setActionUrl(@Nullable String str) {
        this.actionUrl = str;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setDetail(@Nullable String str) {
        this.detail = str;
    }

    public final void setNum(@Nullable Integer num) {
        this.num = num;
    }

    public final void setSecond(@Nullable Integer num) {
        this.second = num;
    }

    public final void setTimestamp(@Nullable Long l10) {
        this.timestamp = l10;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "ErrorResponse(code=" + this.code + ", num=" + this.num + ", second=" + this.second + ", timestamp=" + this.timestamp + ", title=" + this.title + ", detail=" + this.detail + ", actionUrl=" + this.actionUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.code);
        Integer num = this.num;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.second;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Long l10 = this.timestamp;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.title);
        dest.writeString(this.detail);
        dest.writeString(this.actionUrl);
    }

    public ErrorResponse(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l10, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.code = str;
        this.num = num;
        this.second = num2;
        this.timestamp = l10;
        this.title = str2;
        this.detail = str3;
        this.actionUrl = str4;
    }

    public /* synthetic */ ErrorResponse(String str, Integer num, Integer num2, Long l10, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : num2, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4);
    }
}
