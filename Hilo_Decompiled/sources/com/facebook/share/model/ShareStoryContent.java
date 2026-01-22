package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118F¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareStoryContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareStoryContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "attributionLink", "", "getAttributionLink", "()Ljava/lang/String;", "backgroundAsset", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAsset", "()Lcom/facebook/share/model/ShareMedia;", "backgroundColorList", "", "getBackgroundColorList", "()Ljava/util/List;", "stickerAsset", "Lcom/facebook/share/model/SharePhoto;", "getStickerAsset", "()Lcom/facebook/share/model/SharePhoto;", "describeContents", "", "readUnmodifiableStringList", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {

    @Nullable
    private final String attributionLink;

    @Nullable
    private final ShareMedia<?, ?> backgroundAsset;

    @Nullable
    private final List<String> backgroundColorList;

    @Nullable
    private final SharePhoto stickerAsset;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() { // from class: com.facebook.share.model.ShareStoryContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareStoryContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareStoryContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareStoryContent[] newArray(int size) {
            return new ShareStoryContent[size];
        }
    };

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bJ\u0016\u0010!\u001a\u00020\u00002\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareStoryContent;", "()V", "attributionLink", "", "getAttributionLink$facebook_common_release", "()Ljava/lang/String;", "setAttributionLink$facebook_common_release", "(Ljava/lang/String;)V", "backgroundAsset", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAsset$facebook_common_release", "()Lcom/facebook/share/model/ShareMedia;", "setBackgroundAsset$facebook_common_release", "(Lcom/facebook/share/model/ShareMedia;)V", "backgroundColorList", "", "getBackgroundColorList$facebook_common_release", "()Ljava/util/List;", "setBackgroundColorList$facebook_common_release", "(Ljava/util/List;)V", "stickerAsset", "Lcom/facebook/share/model/SharePhoto;", "getStickerAsset$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setStickerAsset$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", "build", "readFrom", DeviceRequestsHelper.DEVICE_INFO_MODEL, "setAttributionLink", "setBackgroundAsset", "setBackgroundColorList", "setStickerAsset", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {

        @Nullable
        private String attributionLink;

        @Nullable
        private ShareMedia<?, ?> backgroundAsset;

        @Nullable
        private List<String> backgroundColorList;

        @Nullable
        private SharePhoto stickerAsset;

        @Nullable
        /* renamed from: getAttributionLink$facebook_common_release, reason: from getter */
        public final String getAttributionLink() {
            return this.attributionLink;
        }

        @Nullable
        public final ShareMedia<?, ?> getBackgroundAsset$facebook_common_release() {
            return this.backgroundAsset;
        }

        @Nullable
        public final List<String> getBackgroundColorList$facebook_common_release() {
            return this.backgroundColorList;
        }

        @Nullable
        /* renamed from: getStickerAsset$facebook_common_release, reason: from getter */
        public final SharePhoto getStickerAsset() {
            return this.stickerAsset;
        }

        @NotNull
        public final Builder setAttributionLink(@Nullable String attributionLink) {
            this.attributionLink = attributionLink;
            return this;
        }

        public final void setAttributionLink$facebook_common_release(@Nullable String str) {
            this.attributionLink = str;
        }

        @NotNull
        public final Builder setBackgroundAsset(@Nullable ShareMedia<?, ?> backgroundAsset) {
            this.backgroundAsset = backgroundAsset;
            return this;
        }

        public final void setBackgroundAsset$facebook_common_release(@Nullable ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
        }

        @NotNull
        public final Builder setBackgroundColorList(@Nullable List<String> backgroundColorList) {
            List<String> list;
            if (backgroundColorList == null) {
                list = null;
            } else {
                list = CollectionsKt.toList(backgroundColorList);
            }
            this.backgroundColorList = list;
            return this;
        }

        public final void setBackgroundColorList$facebook_common_release(@Nullable List<String> list) {
            this.backgroundColorList = list;
        }

        @NotNull
        public final Builder setStickerAsset(@Nullable SharePhoto stickerAsset) {
            this.stickerAsset = stickerAsset;
            return this;
        }

        public final void setStickerAsset$facebook_common_release(@Nullable SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable ShareStoryContent model) {
            return model == null ? this : ((Builder) super.readFrom((Builder) model)).setBackgroundAsset(model.getBackgroundAsset()).setStickerAsset(model.getStickerAsset()).setBackgroundColorList(model.getBackgroundColorList()).setAttributionLink(model.getAttributionLink());
        }
    }

    public /* synthetic */ ShareStoryContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt.toList(arrayList);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAttributionLink() {
        return this.attributionLink;
    }

    @Nullable
    public final ShareMedia<?, ?> getBackgroundAsset() {
        return this.backgroundAsset;
    }

    @Nullable
    public final List<String> getBackgroundColorList() {
        List<String> list = this.backgroundColorList;
        if (list == null) {
            return null;
        }
        return CollectionsKt.toList(list);
    }

    @Nullable
    public final SharePhoto getStickerAsset() {
        return this.stickerAsset;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeParcelable(this.backgroundAsset, 0);
        out.writeParcelable(this.stickerAsset, 0);
        out.writeStringList(getBackgroundColorList());
        out.writeString(this.attributionLink);
    }

    private ShareStoryContent(Builder builder) {
        super(builder);
        this.backgroundAsset = builder.getBackgroundAsset$facebook_common_release();
        this.stickerAsset = builder.getStickerAsset();
        this.backgroundColorList = builder.getBackgroundColorList$facebook_common_release();
        this.attributionLink = builder.getAttributionLink();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStoryContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.backgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.backgroundColorList = readUnmodifiableStringList(parcel);
        this.attributionLink = parcel.readString();
    }
}
