package com.qiahao.base_common.model;

import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00064"}, d2 = {"Lcom/qiahao/base_common/model/MyBagBean;", "Ljava/io/Serializable;", "effectUrl", "", "id", "", "picUrl", "using", "", "timeLeft", "senderAvatar", "receiverAvatar", "sendType", "<init>", "(Ljava/lang/String;JLjava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEffectUrl", "()Ljava/lang/String;", "setEffectUrl", "(Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getPicUrl", "setPicUrl", "getUsing", "()Z", "setUsing", "(Z)V", "getTimeLeft", "setTimeLeft", "getSenderAvatar", "setSenderAvatar", "getReceiverAvatar", "setReceiverAvatar", "getSendType", "setSendType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MyBagBean implements Serializable {

    @NotNull
    private String effectUrl;
    private long id;

    @NotNull
    private String picUrl;

    @NotNull
    private String receiverAvatar;

    @Nullable
    private String sendType;

    @NotNull
    private String senderAvatar;
    private long timeLeft;
    private boolean using;

    public MyBagBean(@NotNull String effectUrl, long j10, @NotNull String picUrl, boolean z10, long j11, @NotNull String senderAvatar, @NotNull String receiverAvatar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        this.effectUrl = effectUrl;
        this.id = j10;
        this.picUrl = picUrl;
        this.using = z10;
        this.timeLeft = j11;
        this.senderAvatar = senderAvatar;
        this.receiverAvatar = receiverAvatar;
        this.sendType = str;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUsing() {
        return this.using;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeLeft() {
        return this.timeLeft;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getSendType() {
        return this.sendType;
    }

    @NotNull
    public final MyBagBean copy(@NotNull String effectUrl, long id, @NotNull String picUrl, boolean using, long timeLeft, @NotNull String senderAvatar, @NotNull String receiverAvatar, @Nullable String sendType) {
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        return new MyBagBean(effectUrl, id, picUrl, using, timeLeft, senderAvatar, receiverAvatar, sendType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyBagBean)) {
            return false;
        }
        MyBagBean myBagBean = (MyBagBean) other;
        return Intrinsics.areEqual(this.effectUrl, myBagBean.effectUrl) && this.id == myBagBean.id && Intrinsics.areEqual(this.picUrl, myBagBean.picUrl) && this.using == myBagBean.using && this.timeLeft == myBagBean.timeLeft && Intrinsics.areEqual(this.senderAvatar, myBagBean.senderAvatar) && Intrinsics.areEqual(this.receiverAvatar, myBagBean.receiverAvatar) && Intrinsics.areEqual(this.sendType, myBagBean.sendType);
    }

    @NotNull
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final String getSendType() {
        return this.sendType;
    }

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    public final long getTimeLeft() {
        return this.timeLeft;
    }

    public final boolean getUsing() {
        return this.using;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.effectUrl.hashCode() * 31) + c.a(this.id)) * 31) + this.picUrl.hashCode()) * 31) + q2.a.a(this.using)) * 31) + c.a(this.timeLeft)) * 31) + this.senderAvatar.hashCode()) * 31) + this.receiverAvatar.hashCode()) * 31;
        String str = this.sendType;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setEffectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.effectUrl = str;
    }

    public final void setId(long j10) {
        this.id = j10;
    }

    public final void setPicUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picUrl = str;
    }

    public final void setReceiverAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiverAvatar = str;
    }

    public final void setSendType(@Nullable String str) {
        this.sendType = str;
    }

    public final void setSenderAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderAvatar = str;
    }

    public final void setTimeLeft(long j10) {
        this.timeLeft = j10;
    }

    public final void setUsing(boolean z10) {
        this.using = z10;
    }

    @NotNull
    public String toString() {
        return "MyBagBean(effectUrl=" + this.effectUrl + ", id=" + this.id + ", picUrl=" + this.picUrl + ", using=" + this.using + ", timeLeft=" + this.timeLeft + ", senderAvatar=" + this.senderAvatar + ", receiverAvatar=" + this.receiverAvatar + ", sendType=" + this.sendType + ")";
    }

    public /* synthetic */ MyBagBean(String str, long j10, String str2, boolean z10, long j11, String str3, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j10, str2, z10, j11, (i10 & 32) != 0 ? "" : str3, (i10 & 64) != 0 ? "" : str4, (i10 & 128) != 0 ? null : str5);
    }
}
