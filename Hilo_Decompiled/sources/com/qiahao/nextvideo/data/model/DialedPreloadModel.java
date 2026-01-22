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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;", "Landroid/os/Parcelable;", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "<init>", "(Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;)V", "getAgoraVideoCallConfig", "()Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DialedPreloadModel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DialedPreloadModel> CREATOR = new Creator();

    @NotNull
    private final AgoraVideoCallConfig agoraVideoCallConfig;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<DialedPreloadModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DialedPreloadModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DialedPreloadModel(AgoraVideoCallConfig.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DialedPreloadModel[] newArray(int i) {
            return new DialedPreloadModel[i];
        }
    }

    public DialedPreloadModel(@NotNull AgoraVideoCallConfig agoraVideoCallConfig) {
        Intrinsics.checkNotNullParameter(agoraVideoCallConfig, "agoraVideoCallConfig");
        this.agoraVideoCallConfig = agoraVideoCallConfig;
    }

    public static /* synthetic */ DialedPreloadModel copy$default(DialedPreloadModel dialedPreloadModel, AgoraVideoCallConfig agoraVideoCallConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            agoraVideoCallConfig = dialedPreloadModel.agoraVideoCallConfig;
        }
        return dialedPreloadModel.copy(agoraVideoCallConfig);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AgoraVideoCallConfig getAgoraVideoCallConfig() {
        return this.agoraVideoCallConfig;
    }

    @NotNull
    public final DialedPreloadModel copy(@NotNull AgoraVideoCallConfig agoraVideoCallConfig) {
        Intrinsics.checkNotNullParameter(agoraVideoCallConfig, "agoraVideoCallConfig");
        return new DialedPreloadModel(agoraVideoCallConfig);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DialedPreloadModel) && Intrinsics.areEqual(this.agoraVideoCallConfig, ((DialedPreloadModel) other).agoraVideoCallConfig);
    }

    @NotNull
    public final AgoraVideoCallConfig getAgoraVideoCallConfig() {
        return this.agoraVideoCallConfig;
    }

    public int hashCode() {
        return this.agoraVideoCallConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "DialedPreloadModel(agoraVideoCallConfig=" + this.agoraVideoCallConfig + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.agoraVideoCallConfig.writeToParcel(dest, flags);
    }
}
