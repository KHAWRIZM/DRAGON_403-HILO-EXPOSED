package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0003J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoResultData;", "Landroid/os/Parcelable;", "giftBean", "", "otherUser", "Lcom/qiahao/base_common/model/common/User;", "talkBean", "talkDuration", "<init>", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getGiftBean", "()Ljava/lang/Integer;", "setGiftBean", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOtherUser", "()Lcom/qiahao/base_common/model/common/User;", "setOtherUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getTalkBean", "setTalkBean", "getTalkDuration", "setTalkDuration", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/VideoResultData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoResultData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VideoResultData> CREATOR = new Creator();

    @Nullable
    private Integer giftBean;

    @Nullable
    private User otherUser;

    @Nullable
    private Integer talkBean;

    @Nullable
    private Integer talkDuration;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<VideoResultData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoResultData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoResultData(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readParcelable(VideoResultData.class.getClassLoader()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoResultData[] newArray(int i) {
            return new VideoResultData[i];
        }
    }

    public VideoResultData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ VideoResultData copy$default(VideoResultData videoResultData, Integer num, User user, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = videoResultData.giftBean;
        }
        if ((i & 2) != 0) {
            user = videoResultData.otherUser;
        }
        if ((i & 4) != 0) {
            num2 = videoResultData.talkBean;
        }
        if ((i & 8) != 0) {
            num3 = videoResultData.talkDuration;
        }
        return videoResultData.copy(num, user, num2, num3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGiftBean() {
        return this.giftBean;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getOtherUser() {
        return this.otherUser;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getTalkBean() {
        return this.talkBean;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getTalkDuration() {
        return this.talkDuration;
    }

    @NotNull
    public final VideoResultData copy(@Nullable Integer giftBean, @Nullable User otherUser, @Nullable Integer talkBean, @Nullable Integer talkDuration) {
        return new VideoResultData(giftBean, otherUser, talkBean, talkDuration);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoResultData)) {
            return false;
        }
        VideoResultData videoResultData = (VideoResultData) other;
        return Intrinsics.areEqual(this.giftBean, videoResultData.giftBean) && Intrinsics.areEqual(this.otherUser, videoResultData.otherUser) && Intrinsics.areEqual(this.talkBean, videoResultData.talkBean) && Intrinsics.areEqual(this.talkDuration, videoResultData.talkDuration);
    }

    @Nullable
    public final Integer getGiftBean() {
        return this.giftBean;
    }

    @Nullable
    public final User getOtherUser() {
        return this.otherUser;
    }

    @Nullable
    public final Integer getTalkBean() {
        return this.talkBean;
    }

    @Nullable
    public final Integer getTalkDuration() {
        return this.talkDuration;
    }

    public int hashCode() {
        Integer num = this.giftBean;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        User user = this.otherUser;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        Integer num2 = this.talkBean;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.talkDuration;
        return hashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setGiftBean(@Nullable Integer num) {
        this.giftBean = num;
    }

    public final void setOtherUser(@Nullable User user) {
        this.otherUser = user;
    }

    public final void setTalkBean(@Nullable Integer num) {
        this.talkBean = num;
    }

    public final void setTalkDuration(@Nullable Integer num) {
        this.talkDuration = num;
    }

    @NotNull
    public String toString() {
        return "VideoResultData(giftBean=" + this.giftBean + ", otherUser=" + this.otherUser + ", talkBean=" + this.talkBean + ", talkDuration=" + this.talkDuration + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.giftBean;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeParcelable(this.otherUser, flags);
        Integer num2 = this.talkBean;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.talkDuration;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
    }

    public VideoResultData(@Nullable Integer num, @Nullable User user, @Nullable Integer num2, @Nullable Integer num3) {
        this.giftBean = num;
        this.otherUser = user;
        this.talkBean = num2;
        this.talkDuration = num3;
    }

    public /* synthetic */ VideoResultData(Integer num, User user, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : user, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }
}
