package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001d\u001eB\u000f\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0018H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/facebook/share/model/ShareVideoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareModel;", "builder", "(Lcom/facebook/share/model/ShareVideoContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "contentTitle", "getContentTitle", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto", "()Lcom/facebook/share/model/SharePhoto;", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo", "()Lcom/facebook/share/model/ShareVideo;", "describeContents", "", "writeToParcel", "", "out", "flags", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {

    @Nullable
    private final String contentDescription;

    @Nullable
    private final String contentTitle;

    @Nullable
    private final SharePhoto previewPhoto;

    @Nullable
    private final ShareVideo video;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareVideoContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareVideoContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShareVideoContent[] newArray(int size) {
            return new ShareVideoContent[size];
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0012\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareVideoContent;", "()V", "contentDescription", "", "getContentDescription$facebook_common_release", "()Ljava/lang/String;", "setContentDescription$facebook_common_release", "(Ljava/lang/String;)V", "contentTitle", "getContentTitle$facebook_common_release", "setContentTitle$facebook_common_release", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setPreviewPhoto$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo$facebook_common_release", "()Lcom/facebook/share/model/ShareVideo;", "setVideo$facebook_common_release", "(Lcom/facebook/share/model/ShareVideo;)V", "build", "readFrom", "content", "setContentDescription", "setContentTitle", "setPreviewPhoto", "setVideo", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {

        @Nullable
        private String contentDescription;

        @Nullable
        private String contentTitle;

        @Nullable
        private SharePhoto previewPhoto;

        @Nullable
        private ShareVideo video;

        @Nullable
        /* renamed from: getContentDescription$facebook_common_release, reason: from getter */
        public final String getContentDescription() {
            return this.contentDescription;
        }

        @Nullable
        /* renamed from: getContentTitle$facebook_common_release, reason: from getter */
        public final String getContentTitle() {
            return this.contentTitle;
        }

        @Nullable
        /* renamed from: getPreviewPhoto$facebook_common_release, reason: from getter */
        public final SharePhoto getPreviewPhoto() {
            return this.previewPhoto;
        }

        @Nullable
        /* renamed from: getVideo$facebook_common_release, reason: from getter */
        public final ShareVideo getVideo() {
            return this.video;
        }

        @NotNull
        public final Builder setContentDescription(@Nullable String contentDescription) {
            this.contentDescription = contentDescription;
            return this;
        }

        public final void setContentDescription$facebook_common_release(@Nullable String str) {
            this.contentDescription = str;
        }

        @NotNull
        public final Builder setContentTitle(@Nullable String contentTitle) {
            this.contentTitle = contentTitle;
            return this;
        }

        public final void setContentTitle$facebook_common_release(@Nullable String str) {
            this.contentTitle = str;
        }

        @NotNull
        public final Builder setPreviewPhoto(@Nullable SharePhoto previewPhoto) {
            SharePhoto build;
            if (previewPhoto == null) {
                build = null;
            } else {
                build = new SharePhoto.Builder().readFrom(previewPhoto).build();
            }
            this.previewPhoto = build;
            return this;
        }

        public final void setPreviewPhoto$facebook_common_release(@Nullable SharePhoto sharePhoto) {
            this.previewPhoto = sharePhoto;
        }

        @NotNull
        public final Builder setVideo(@Nullable ShareVideo video) {
            if (video == null) {
                return this;
            }
            this.video = new ShareVideo.Builder().readFrom(video).build();
            return this;
        }

        public final void setVideo$facebook_common_release(@Nullable ShareVideo shareVideo) {
            this.video = shareVideo;
        }

        @Override // com.facebook.share.ShareBuilder
        @NotNull
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        @NotNull
        public Builder readFrom(@Nullable ShareVideoContent content) {
            return content == null ? this : ((Builder) super.readFrom((Builder) content)).setContentDescription(content.getContentDescription()).setContentTitle(content.getContentTitle()).setPreviewPhoto(content.getPreviewPhoto()).setVideo(content.getVideo());
        }
    }

    public /* synthetic */ ShareVideoContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Nullable
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @Nullable
    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    @Nullable
    public final ShareVideo getVideo() {
        return this.video;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeString(this.contentDescription);
        out.writeString(this.contentTitle);
        out.writeParcelable(this.previewPhoto, 0);
        out.writeParcelable(this.video, 0);
    }

    private ShareVideoContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.getContentDescription();
        this.contentTitle = builder.getContentTitle();
        this.previewPhoto = builder.getPreviewPhoto();
        this.video = builder.getVideo();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareVideoContent(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom$facebook_common_release = new SharePhoto.Builder().readFrom$facebook_common_release(parcel);
        this.previewPhoto = (readFrom$facebook_common_release.getImageUrl() == null && readFrom$facebook_common_release.getBitmap() == null) ? null : readFrom$facebook_common_release.build();
        this.video = new ShareVideo.Builder().readFrom$facebook_common_release(parcel).build();
    }
}
