package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PropertyCarResponseBean;", "", "effectUrl", "", AgooConstants.MESSAGE_ID, "", "picUrl", "receiverAvatar", "senderAvatar", "timeLeft", "using", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getEffectUrl", "()Ljava/lang/String;", "getId", "()I", "getPicUrl", "getReceiverAvatar", "getSenderAvatar", "getTimeLeft", "getUsing", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PropertyCarResponseBean {

    @NotNull
    private final String effectUrl;
    private final int id;

    @NotNull
    private final String picUrl;

    @NotNull
    private final String receiverAvatar;

    @NotNull
    private final String senderAvatar;
    private final int timeLeft;
    private final boolean using;

    public PropertyCarResponseBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "effectUrl");
        Intrinsics.checkNotNullParameter(str2, "picUrl");
        Intrinsics.checkNotNullParameter(str3, "receiverAvatar");
        Intrinsics.checkNotNullParameter(str4, "senderAvatar");
        this.effectUrl = str;
        this.id = i;
        this.picUrl = str2;
        this.receiverAvatar = str3;
        this.senderAvatar = str4;
        this.timeLeft = i2;
        this.using = z;
    }

    public static /* synthetic */ PropertyCarResponseBean copy$default(PropertyCarResponseBean propertyCarResponseBean, String str, int i, String str2, String str3, String str4, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = propertyCarResponseBean.effectUrl;
        }
        if ((i3 & 2) != 0) {
            i = propertyCarResponseBean.id;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = propertyCarResponseBean.picUrl;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            str3 = propertyCarResponseBean.receiverAvatar;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = propertyCarResponseBean.senderAvatar;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = propertyCarResponseBean.timeLeft;
        }
        int i5 = i2;
        if ((i3 & 64) != 0) {
            z = propertyCarResponseBean.using;
        }
        return propertyCarResponseBean.copy(str, i4, str5, str6, str7, i5, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTimeLeft() {
        return this.timeLeft;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getUsing() {
        return this.using;
    }

    @NotNull
    public final PropertyCarResponseBean copy(@NotNull String effectUrl, int id2, @NotNull String picUrl, @NotNull String receiverAvatar, @NotNull String senderAvatar, int timeLeft, boolean using) {
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        return new PropertyCarResponseBean(effectUrl, id2, picUrl, receiverAvatar, senderAvatar, timeLeft, using);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PropertyCarResponseBean)) {
            return false;
        }
        PropertyCarResponseBean propertyCarResponseBean = (PropertyCarResponseBean) other;
        return Intrinsics.areEqual(this.effectUrl, propertyCarResponseBean.effectUrl) && this.id == propertyCarResponseBean.id && Intrinsics.areEqual(this.picUrl, propertyCarResponseBean.picUrl) && Intrinsics.areEqual(this.receiverAvatar, propertyCarResponseBean.receiverAvatar) && Intrinsics.areEqual(this.senderAvatar, propertyCarResponseBean.senderAvatar) && this.timeLeft == propertyCarResponseBean.timeLeft && this.using == propertyCarResponseBean.using;
    }

    @NotNull
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    public final int getId() {
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

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    public final int getTimeLeft() {
        return this.timeLeft;
    }

    public final boolean getUsing() {
        return this.using;
    }

    public int hashCode() {
        return (((((((((((this.effectUrl.hashCode() * 31) + this.id) * 31) + this.picUrl.hashCode()) * 31) + this.receiverAvatar.hashCode()) * 31) + this.senderAvatar.hashCode()) * 31) + this.timeLeft) * 31) + a.a(this.using);
    }

    @NotNull
    public String toString() {
        return "PropertyCarResponseBean(effectUrl=" + this.effectUrl + ", id=" + this.id + ", picUrl=" + this.picUrl + ", receiverAvatar=" + this.receiverAvatar + ", senderAvatar=" + this.senderAvatar + ", timeLeft=" + this.timeLeft + ", using=" + this.using + ")";
    }
}
