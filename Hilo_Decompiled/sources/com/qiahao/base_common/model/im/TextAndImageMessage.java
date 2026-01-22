package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/model/im/TextAndImageMessage;", "", "identifier", "", "imgWidth", "", "imgHeight", "imgUrl", "content", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getImgWidth", "()Ljava/lang/Float;", "setImgWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getImgHeight", "setImgHeight", "getImgUrl", "setImgUrl", "getContent", "setContent", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/TextAndImageMessage;", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TextAndImageMessage {

    @Nullable
    private String content;

    @Nullable
    private String identifier;

    @Nullable
    private Float imgHeight;

    @Nullable
    private String imgUrl;

    @Nullable
    private Float imgWidth;

    public TextAndImageMessage() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TextAndImageMessage copy$default(TextAndImageMessage textAndImageMessage, String str, Float f10, Float f11, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = textAndImageMessage.identifier;
        }
        if ((i10 & 2) != 0) {
            f10 = textAndImageMessage.imgWidth;
        }
        Float f12 = f10;
        if ((i10 & 4) != 0) {
            f11 = textAndImageMessage.imgHeight;
        }
        Float f13 = f11;
        if ((i10 & 8) != 0) {
            str2 = textAndImageMessage.imgUrl;
        }
        String str4 = str2;
        if ((i10 & 16) != 0) {
            str3 = textAndImageMessage.content;
        }
        return textAndImageMessage.copy(str, f12, f13, str4, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Float getImgWidth() {
        return this.imgWidth;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Float getImgHeight() {
        return this.imgHeight;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final TextAndImageMessage copy(@Nullable String identifier, @Nullable Float imgWidth, @Nullable Float imgHeight, @Nullable String imgUrl, @Nullable String content) {
        return new TextAndImageMessage(identifier, imgWidth, imgHeight, imgUrl, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextAndImageMessage)) {
            return false;
        }
        TextAndImageMessage textAndImageMessage = (TextAndImageMessage) other;
        return Intrinsics.areEqual(this.identifier, textAndImageMessage.identifier) && Intrinsics.areEqual((Object) this.imgWidth, (Object) textAndImageMessage.imgWidth) && Intrinsics.areEqual((Object) this.imgHeight, (Object) textAndImageMessage.imgHeight) && Intrinsics.areEqual(this.imgUrl, textAndImageMessage.imgUrl) && Intrinsics.areEqual(this.content, textAndImageMessage.content);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final Float getImgHeight() {
        return this.imgHeight;
    }

    @Nullable
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    public final Float getImgWidth() {
        return this.imgWidth;
    }

    public int hashCode() {
        String str = this.identifier;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f10 = this.imgWidth;
        int hashCode2 = (hashCode + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.imgHeight;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str2 = this.imgUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.content;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    public final void setImgHeight(@Nullable Float f10) {
        this.imgHeight = f10;
    }

    public final void setImgUrl(@Nullable String str) {
        this.imgUrl = str;
    }

    public final void setImgWidth(@Nullable Float f10) {
        this.imgWidth = f10;
    }

    @NotNull
    public String toString() {
        return "TextAndImageMessage(identifier=" + this.identifier + ", imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", imgUrl=" + this.imgUrl + ", content=" + this.content + ")";
    }

    public TextAndImageMessage(@Nullable String str, @Nullable Float f10, @Nullable Float f11, @Nullable String str2, @Nullable String str3) {
        this.identifier = str;
        this.imgWidth = f10;
        this.imgHeight = f11;
        this.imgUrl = str2;
        this.content = str3;
    }

    public /* synthetic */ TextAndImageMessage(String str, Float f10, Float f11, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : f10, (i10 & 4) != 0 ? null : f11, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3);
    }
}
