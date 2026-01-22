package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/qiahao/hilo_message/data/MsgBody;", "", "msgType", "", "customContent", "Lcom/qiahao/hilo_message/data/CustomElemContent;", "textContent", "Lcom/qiahao/hilo_message/data/TextElemContent;", "videoContent", "Lcom/qiahao/hilo_message/data/VideoElemContent;", "imageContent", "Lcom/qiahao/hilo_message/data/ImageElemContent;", "<init>", "(Ljava/lang/String;Lcom/qiahao/hilo_message/data/CustomElemContent;Lcom/qiahao/hilo_message/data/TextElemContent;Lcom/qiahao/hilo_message/data/VideoElemContent;Lcom/qiahao/hilo_message/data/ImageElemContent;)V", "getMsgType", "()Ljava/lang/String;", "setMsgType", "(Ljava/lang/String;)V", "getCustomContent", "()Lcom/qiahao/hilo_message/data/CustomElemContent;", "setCustomContent", "(Lcom/qiahao/hilo_message/data/CustomElemContent;)V", "getTextContent", "()Lcom/qiahao/hilo_message/data/TextElemContent;", "setTextContent", "(Lcom/qiahao/hilo_message/data/TextElemContent;)V", "getVideoContent", "()Lcom/qiahao/hilo_message/data/VideoElemContent;", "setVideoContent", "(Lcom/qiahao/hilo_message/data/VideoElemContent;)V", "getImageContent", "()Lcom/qiahao/hilo_message/data/ImageElemContent;", "setImageContent", "(Lcom/qiahao/hilo_message/data/ImageElemContent;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MsgBody {

    @Nullable
    private CustomElemContent customContent;

    @Nullable
    private ImageElemContent imageContent;

    @Nullable
    private String msgType;

    @Nullable
    private TextElemContent textContent;

    @Nullable
    private VideoElemContent videoContent;

    public MsgBody() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MsgBody copy$default(MsgBody msgBody, String str, CustomElemContent customElemContent, TextElemContent textElemContent, VideoElemContent videoElemContent, ImageElemContent imageElemContent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = msgBody.msgType;
        }
        if ((i10 & 2) != 0) {
            customElemContent = msgBody.customContent;
        }
        CustomElemContent customElemContent2 = customElemContent;
        if ((i10 & 4) != 0) {
            textElemContent = msgBody.textContent;
        }
        TextElemContent textElemContent2 = textElemContent;
        if ((i10 & 8) != 0) {
            videoElemContent = msgBody.videoContent;
        }
        VideoElemContent videoElemContent2 = videoElemContent;
        if ((i10 & 16) != 0) {
            imageElemContent = msgBody.imageContent;
        }
        return msgBody.copy(str, customElemContent2, textElemContent2, videoElemContent2, imageElemContent);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgType() {
        return this.msgType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CustomElemContent getCustomContent() {
        return this.customContent;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final TextElemContent getTextContent() {
        return this.textContent;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final VideoElemContent getVideoContent() {
        return this.videoContent;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final ImageElemContent getImageContent() {
        return this.imageContent;
    }

    @NotNull
    public final MsgBody copy(@Nullable String msgType, @Nullable CustomElemContent customContent, @Nullable TextElemContent textContent, @Nullable VideoElemContent videoContent, @Nullable ImageElemContent imageContent) {
        return new MsgBody(msgType, customContent, textContent, videoContent, imageContent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgBody)) {
            return false;
        }
        MsgBody msgBody = (MsgBody) other;
        return Intrinsics.areEqual(this.msgType, msgBody.msgType) && Intrinsics.areEqual(this.customContent, msgBody.customContent) && Intrinsics.areEqual(this.textContent, msgBody.textContent) && Intrinsics.areEqual(this.videoContent, msgBody.videoContent) && Intrinsics.areEqual(this.imageContent, msgBody.imageContent);
    }

    @Nullable
    public final CustomElemContent getCustomContent() {
        return this.customContent;
    }

    @Nullable
    public final ImageElemContent getImageContent() {
        return this.imageContent;
    }

    @Nullable
    public final String getMsgType() {
        return this.msgType;
    }

    @Nullable
    public final TextElemContent getTextContent() {
        return this.textContent;
    }

    @Nullable
    public final VideoElemContent getVideoContent() {
        return this.videoContent;
    }

    public int hashCode() {
        String str = this.msgType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CustomElemContent customElemContent = this.customContent;
        int hashCode2 = (hashCode + (customElemContent == null ? 0 : customElemContent.hashCode())) * 31;
        TextElemContent textElemContent = this.textContent;
        int hashCode3 = (hashCode2 + (textElemContent == null ? 0 : textElemContent.hashCode())) * 31;
        VideoElemContent videoElemContent = this.videoContent;
        int hashCode4 = (hashCode3 + (videoElemContent == null ? 0 : videoElemContent.hashCode())) * 31;
        ImageElemContent imageElemContent = this.imageContent;
        return hashCode4 + (imageElemContent != null ? imageElemContent.hashCode() : 0);
    }

    public final void setCustomContent(@Nullable CustomElemContent customElemContent) {
        this.customContent = customElemContent;
    }

    public final void setImageContent(@Nullable ImageElemContent imageElemContent) {
        this.imageContent = imageElemContent;
    }

    public final void setMsgType(@Nullable String str) {
        this.msgType = str;
    }

    public final void setTextContent(@Nullable TextElemContent textElemContent) {
        this.textContent = textElemContent;
    }

    public final void setVideoContent(@Nullable VideoElemContent videoElemContent) {
        this.videoContent = videoElemContent;
    }

    @NotNull
    public String toString() {
        return "MsgBody(msgType=" + this.msgType + ", customContent=" + this.customContent + ", textContent=" + this.textContent + ", videoContent=" + this.videoContent + ", imageContent=" + this.imageContent + ")";
    }

    public MsgBody(@Nullable String str, @Nullable CustomElemContent customElemContent, @Nullable TextElemContent textElemContent, @Nullable VideoElemContent videoElemContent, @Nullable ImageElemContent imageElemContent) {
        this.msgType = str;
        this.customContent = customElemContent;
        this.textContent = textElemContent;
        this.videoContent = videoElemContent;
        this.imageContent = imageElemContent;
    }

    public /* synthetic */ MsgBody(String str, CustomElemContent customElemContent, TextElemContent textElemContent, VideoElemContent videoElemContent, ImageElemContent imageElemContent, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : customElemContent, (i10 & 4) != 0 ? null : textElemContent, (i10 & 8) != 0 ? null : videoElemContent, (i10 & 16) != 0 ? null : imageElemContent);
    }
}
