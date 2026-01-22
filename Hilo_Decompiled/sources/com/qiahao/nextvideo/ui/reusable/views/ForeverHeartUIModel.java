package com.qiahao.nextvideo.ui.reusable.views;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.ui.conversation.ForeverHeartPercentType;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "Landroid/os/Parcelable;", "heartPer", "", "drawableRes", "svgaUrl", "", "<init>", "(IILjava/lang/String;)V", "getHeartPer", "()I", "setHeartPer", "(I)V", "getDrawableRes", "getSvgaUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ForeverHeartUIModel implements Parcelable {
    private final int drawableRes;
    private int heartPer;

    @NotNull
    private final String svgaUrl;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ForeverHeartUIModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "user", "Lcom/qiahao/base_common/model/common/User;", "heartPer", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        
            if (r4 < r1.getLimit()) goto L١٣;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ForeverHeartUIModel init(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            int heartPer = user.getHeartPer();
            ForeverHeartPercentType foreverHeartPercentType = ForeverHeartPercentType.Percent25;
            if (heartPer < foreverHeartPercentType.getLimit()) {
                foreverHeartPercentType = ForeverHeartPercentType.Percent0;
            } else {
                ForeverHeartPercentType foreverHeartPercentType2 = ForeverHeartPercentType.Percent50;
                if (heartPer >= foreverHeartPercentType2.getLimit()) {
                    foreverHeartPercentType = ForeverHeartPercentType.Percent75;
                    if (heartPer >= foreverHeartPercentType.getLimit()) {
                        foreverHeartPercentType2 = ForeverHeartPercentType.Percent100;
                    }
                    foreverHeartPercentType = foreverHeartPercentType2;
                }
            }
            return new ForeverHeartUIModel(heartPer, foreverHeartPercentType.getDrawableRes(), foreverHeartPercentType.getSvgaUrl());
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        
            if (r4 < r1.getLimit()) goto L١٣;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ForeverHeartUIModel init(int heartPer) {
            ForeverHeartPercentType foreverHeartPercentType = ForeverHeartPercentType.Percent25;
            if (heartPer < foreverHeartPercentType.getLimit()) {
                foreverHeartPercentType = ForeverHeartPercentType.Percent0;
            } else {
                ForeverHeartPercentType foreverHeartPercentType2 = ForeverHeartPercentType.Percent50;
                if (heartPer >= foreverHeartPercentType2.getLimit()) {
                    foreverHeartPercentType = ForeverHeartPercentType.Percent75;
                    if (heartPer >= foreverHeartPercentType.getLimit()) {
                        foreverHeartPercentType2 = ForeverHeartPercentType.Percent100;
                    }
                    foreverHeartPercentType = foreverHeartPercentType2;
                }
            }
            return new ForeverHeartUIModel(heartPer, foreverHeartPercentType.getDrawableRes(), foreverHeartPercentType.getSvgaUrl());
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<ForeverHeartUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ForeverHeartUIModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ForeverHeartUIModel(parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ForeverHeartUIModel[] newArray(int i) {
            return new ForeverHeartUIModel[i];
        }
    }

    public ForeverHeartUIModel(int i, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "svgaUrl");
        this.heartPer = i;
        this.drawableRes = i2;
        this.svgaUrl = str;
    }

    public static /* synthetic */ ForeverHeartUIModel copy$default(ForeverHeartUIModel foreverHeartUIModel, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = foreverHeartUIModel.heartPer;
        }
        if ((i3 & 2) != 0) {
            i2 = foreverHeartUIModel.drawableRes;
        }
        if ((i3 & 4) != 0) {
            str = foreverHeartUIModel.svgaUrl;
        }
        return foreverHeartUIModel.copy(i, i2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHeartPer() {
        return this.heartPer;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDrawableRes() {
        return this.drawableRes;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final ForeverHeartUIModel copy(int heartPer, int drawableRes, @NotNull String svgaUrl) {
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        return new ForeverHeartUIModel(heartPer, drawableRes, svgaUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForeverHeartUIModel)) {
            return false;
        }
        ForeverHeartUIModel foreverHeartUIModel = (ForeverHeartUIModel) other;
        return this.heartPer == foreverHeartUIModel.heartPer && this.drawableRes == foreverHeartUIModel.drawableRes && Intrinsics.areEqual(this.svgaUrl, foreverHeartUIModel.svgaUrl);
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final int getHeartPer() {
        return this.heartPer;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public int hashCode() {
        return (((this.heartPer * 31) + this.drawableRes) * 31) + this.svgaUrl.hashCode();
    }

    public final void setHeartPer(int i) {
        this.heartPer = i;
    }

    @NotNull
    public String toString() {
        return "ForeverHeartUIModel(heartPer=" + this.heartPer + ", drawableRes=" + this.drawableRes + ", svgaUrl=" + this.svgaUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.heartPer);
        dest.writeInt(this.drawableRes);
        dest.writeString(this.svgaUrl);
    }
}
