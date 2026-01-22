package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006#"}, d2 = {"Lcom/qiahao/base_common/model/common/VideoSetting;", "Landroid/os/Parcelable;", "frontOrBack", "", "cameraOnOff", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFrontOrBack", "()Ljava/lang/Integer;", "setFrontOrBack", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCameraOnOff", "setCameraOnOff", "changeCameraFront", "isFrontCamera", "", "switchCameraOpen", "isOpenCamera", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/common/VideoSetting;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class VideoSetting implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VideoSetting> CREATOR = new Creator();

    @Nullable
    private Integer cameraOnOff;

    @Nullable
    private Integer frontOrBack;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<VideoSetting> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoSetting createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoSetting(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoSetting[] newArray(int i10) {
            return new VideoSetting[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoSetting() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VideoSetting copy$default(VideoSetting videoSetting, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = videoSetting.frontOrBack;
        }
        if ((i10 & 2) != 0) {
            num2 = videoSetting.cameraOnOff;
        }
        return videoSetting.copy(num, num2);
    }

    public final int changeCameraFront() {
        Integer num = this.frontOrBack;
        if (num == null || num.intValue() != 1) {
            return 1;
        }
        return 2;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getFrontOrBack() {
        return this.frontOrBack;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCameraOnOff() {
        return this.cameraOnOff;
    }

    @NotNull
    public final VideoSetting copy(@Nullable Integer frontOrBack, @Nullable Integer cameraOnOff) {
        return new VideoSetting(frontOrBack, cameraOnOff);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSetting)) {
            return false;
        }
        VideoSetting videoSetting = (VideoSetting) other;
        return Intrinsics.areEqual(this.frontOrBack, videoSetting.frontOrBack) && Intrinsics.areEqual(this.cameraOnOff, videoSetting.cameraOnOff);
    }

    @Nullable
    public final Integer getCameraOnOff() {
        return this.cameraOnOff;
    }

    @Nullable
    public final Integer getFrontOrBack() {
        return this.frontOrBack;
    }

    public int hashCode() {
        Integer num = this.frontOrBack;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.cameraOnOff;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final boolean isFrontCamera() {
        Integer num = this.frontOrBack;
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean isOpenCamera() {
        Integer num = this.cameraOnOff;
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public final void setCameraOnOff(@Nullable Integer num) {
        this.cameraOnOff = num;
    }

    public final void setFrontOrBack(@Nullable Integer num) {
        this.frontOrBack = num;
    }

    public final int switchCameraOpen() {
        Integer num = this.cameraOnOff;
        if (num == null || num.intValue() != 1) {
            return 1;
        }
        return 2;
    }

    @NotNull
    public String toString() {
        return "VideoSetting(frontOrBack=" + this.frontOrBack + ", cameraOnOff=" + this.cameraOnOff + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.frontOrBack;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.cameraOnOff;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
    }

    public VideoSetting(@Nullable Integer num, @Nullable Integer num2) {
        this.frontOrBack = num;
        this.cameraOnOff = num2;
    }

    public /* synthetic */ VideoSetting(Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2);
    }
}
