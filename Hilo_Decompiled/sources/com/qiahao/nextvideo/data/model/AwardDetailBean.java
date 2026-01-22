package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\bY\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010]\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\nHÆ\u0003Jþ\u0001\u0010_\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010`J\u0006\u0010a\u001a\u00020\u0003J\u0013\u0010b\u001a\u00020\u00052\b\u0010c\u001a\u0004\u0018\u00010dHÖ\u0003J\t\u0010e\u001a\u00020\u0003HÖ\u0001J\t\u0010f\u001a\u00020\nHÖ\u0001J\u0016\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.¨\u0006l"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AwardDetailBean;", "Landroid/os/Parcelable;", "diamondNum", "", "hasGetReward", "", "headwearDiamond", "headwearDuration", "headwearId", "headwearPicUrl", "", "headwearSvgaUrl", "medalDiamond", "medalDuration", "medalId", "medalPicUrl", "medalSvgaUrl", "nobleDiamond", "nobleDuration", "nobleLevel", "propertyDiamond", "propertyDuration", "propertyId", "propertyPicUrl", "propertySvgaUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDiamondNum", "()Ljava/lang/Integer;", "setDiamondNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasGetReward", "()Ljava/lang/Boolean;", "setHasGetReward", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHeadwearDiamond", "setHeadwearDiamond", "getHeadwearDuration", "setHeadwearDuration", "getHeadwearId", "setHeadwearId", "getHeadwearPicUrl", "()Ljava/lang/String;", "setHeadwearPicUrl", "(Ljava/lang/String;)V", "getHeadwearSvgaUrl", "setHeadwearSvgaUrl", "getMedalDiamond", "setMedalDiamond", "getMedalDuration", "setMedalDuration", "getMedalId", "setMedalId", "getMedalPicUrl", "setMedalPicUrl", "getMedalSvgaUrl", "setMedalSvgaUrl", "getNobleDiamond", "setNobleDiamond", "getNobleDuration", "setNobleDuration", "getNobleLevel", "setNobleLevel", "getPropertyDiamond", "setPropertyDiamond", "getPropertyDuration", "setPropertyDuration", "getPropertyId", "setPropertyId", "getPropertyPicUrl", "setPropertyPicUrl", "getPropertySvgaUrl", "setPropertySvgaUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/AwardDetailBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AwardDetailBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AwardDetailBean> CREATOR = new Creator();

    @Nullable
    private Integer diamondNum;

    @Nullable
    private Boolean hasGetReward;

    @Nullable
    private Integer headwearDiamond;

    @Nullable
    private Integer headwearDuration;

    @Nullable
    private Integer headwearId;

    @Nullable
    private String headwearPicUrl;

    @Nullable
    private String headwearSvgaUrl;

    @Nullable
    private Integer medalDiamond;

    @Nullable
    private Integer medalDuration;

    @Nullable
    private Integer medalId;

    @Nullable
    private String medalPicUrl;

    @Nullable
    private String medalSvgaUrl;

    @Nullable
    private Integer nobleDiamond;

    @Nullable
    private Integer nobleDuration;

    @Nullable
    private Integer nobleLevel;

    @Nullable
    private Integer propertyDiamond;

    @Nullable
    private Integer propertyDuration;

    @Nullable
    private Integer propertyId;

    @Nullable
    private String propertyPicUrl;

    @Nullable
    private String propertySvgaUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<AwardDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwardDetailBean createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new AwardDetailBean(valueOf2, valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwardDetailBean[] newArray(int i) {
            return new AwardDetailBean[i];
        }
    }

    public AwardDetailBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getMedalId() {
        return this.medalId;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getMedalPicUrl() {
        return this.medalPicUrl;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getMedalSvgaUrl() {
        return this.medalSvgaUrl;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getNobleDiamond() {
        return this.nobleDiamond;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getNobleDuration() {
        return this.nobleDuration;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Integer getPropertyDiamond() {
        return this.propertyDiamond;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getPropertyDuration() {
        return this.propertyDuration;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Integer getPropertyId() {
        return this.propertyId;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getPropertyPicUrl() {
        return this.propertyPicUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final String getPropertySvgaUrl() {
        return this.propertySvgaUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getHeadwearDiamond() {
        return this.headwearDiamond;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getHeadwearDuration() {
        return this.headwearDuration;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getHeadwearId() {
        return this.headwearId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getHeadwearPicUrl() {
        return this.headwearPicUrl;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getHeadwearSvgaUrl() {
        return this.headwearSvgaUrl;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getMedalDiamond() {
        return this.medalDiamond;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getMedalDuration() {
        return this.medalDuration;
    }

    @NotNull
    public final AwardDetailBean copy(@Nullable Integer diamondNum, @Nullable Boolean hasGetReward, @Nullable Integer headwearDiamond, @Nullable Integer headwearDuration, @Nullable Integer headwearId, @Nullable String headwearPicUrl, @Nullable String headwearSvgaUrl, @Nullable Integer medalDiamond, @Nullable Integer medalDuration, @Nullable Integer medalId, @Nullable String medalPicUrl, @Nullable String medalSvgaUrl, @Nullable Integer nobleDiamond, @Nullable Integer nobleDuration, @Nullable Integer nobleLevel, @Nullable Integer propertyDiamond, @Nullable Integer propertyDuration, @Nullable Integer propertyId, @Nullable String propertyPicUrl, @Nullable String propertySvgaUrl) {
        return new AwardDetailBean(diamondNum, hasGetReward, headwearDiamond, headwearDuration, headwearId, headwearPicUrl, headwearSvgaUrl, medalDiamond, medalDuration, medalId, medalPicUrl, medalSvgaUrl, nobleDiamond, nobleDuration, nobleLevel, propertyDiamond, propertyDuration, propertyId, propertyPicUrl, propertySvgaUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardDetailBean)) {
            return false;
        }
        AwardDetailBean awardDetailBean = (AwardDetailBean) other;
        return Intrinsics.areEqual(this.diamondNum, awardDetailBean.diamondNum) && Intrinsics.areEqual(this.hasGetReward, awardDetailBean.hasGetReward) && Intrinsics.areEqual(this.headwearDiamond, awardDetailBean.headwearDiamond) && Intrinsics.areEqual(this.headwearDuration, awardDetailBean.headwearDuration) && Intrinsics.areEqual(this.headwearId, awardDetailBean.headwearId) && Intrinsics.areEqual(this.headwearPicUrl, awardDetailBean.headwearPicUrl) && Intrinsics.areEqual(this.headwearSvgaUrl, awardDetailBean.headwearSvgaUrl) && Intrinsics.areEqual(this.medalDiamond, awardDetailBean.medalDiamond) && Intrinsics.areEqual(this.medalDuration, awardDetailBean.medalDuration) && Intrinsics.areEqual(this.medalId, awardDetailBean.medalId) && Intrinsics.areEqual(this.medalPicUrl, awardDetailBean.medalPicUrl) && Intrinsics.areEqual(this.medalSvgaUrl, awardDetailBean.medalSvgaUrl) && Intrinsics.areEqual(this.nobleDiamond, awardDetailBean.nobleDiamond) && Intrinsics.areEqual(this.nobleDuration, awardDetailBean.nobleDuration) && Intrinsics.areEqual(this.nobleLevel, awardDetailBean.nobleLevel) && Intrinsics.areEqual(this.propertyDiamond, awardDetailBean.propertyDiamond) && Intrinsics.areEqual(this.propertyDuration, awardDetailBean.propertyDuration) && Intrinsics.areEqual(this.propertyId, awardDetailBean.propertyId) && Intrinsics.areEqual(this.propertyPicUrl, awardDetailBean.propertyPicUrl) && Intrinsics.areEqual(this.propertySvgaUrl, awardDetailBean.propertySvgaUrl);
    }

    @Nullable
    public final Integer getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    public final Integer getHeadwearDiamond() {
        return this.headwearDiamond;
    }

    @Nullable
    public final Integer getHeadwearDuration() {
        return this.headwearDuration;
    }

    @Nullable
    public final Integer getHeadwearId() {
        return this.headwearId;
    }

    @Nullable
    public final String getHeadwearPicUrl() {
        return this.headwearPicUrl;
    }

    @Nullable
    public final String getHeadwearSvgaUrl() {
        return this.headwearSvgaUrl;
    }

    @Nullable
    public final Integer getMedalDiamond() {
        return this.medalDiamond;
    }

    @Nullable
    public final Integer getMedalDuration() {
        return this.medalDuration;
    }

    @Nullable
    public final Integer getMedalId() {
        return this.medalId;
    }

    @Nullable
    public final String getMedalPicUrl() {
        return this.medalPicUrl;
    }

    @Nullable
    public final String getMedalSvgaUrl() {
        return this.medalSvgaUrl;
    }

    @Nullable
    public final Integer getNobleDiamond() {
        return this.nobleDiamond;
    }

    @Nullable
    public final Integer getNobleDuration() {
        return this.nobleDuration;
    }

    @Nullable
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final Integer getPropertyDiamond() {
        return this.propertyDiamond;
    }

    @Nullable
    public final Integer getPropertyDuration() {
        return this.propertyDuration;
    }

    @Nullable
    public final Integer getPropertyId() {
        return this.propertyId;
    }

    @Nullable
    public final String getPropertyPicUrl() {
        return this.propertyPicUrl;
    }

    @Nullable
    public final String getPropertySvgaUrl() {
        return this.propertySvgaUrl;
    }

    public int hashCode() {
        Integer num = this.diamondNum;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.hasGetReward;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.headwearDiamond;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.headwearDuration;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.headwearId;
        int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.headwearPicUrl;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.headwearSvgaUrl;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num5 = this.medalDiamond;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.medalDuration;
        int hashCode9 = (hashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.medalId;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str3 = this.medalPicUrl;
        int hashCode11 = (hashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.medalSvgaUrl;
        int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num8 = this.nobleDiamond;
        int hashCode13 = (hashCode12 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.nobleDuration;
        int hashCode14 = (hashCode13 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.nobleLevel;
        int hashCode15 = (hashCode14 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.propertyDiamond;
        int hashCode16 = (hashCode15 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.propertyDuration;
        int hashCode17 = (hashCode16 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.propertyId;
        int hashCode18 = (hashCode17 + (num13 == null ? 0 : num13.hashCode())) * 31;
        String str5 = this.propertyPicUrl;
        int hashCode19 = (hashCode18 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.propertySvgaUrl;
        return hashCode19 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setDiamondNum(@Nullable Integer num) {
        this.diamondNum = num;
    }

    public final void setHasGetReward(@Nullable Boolean bool) {
        this.hasGetReward = bool;
    }

    public final void setHeadwearDiamond(@Nullable Integer num) {
        this.headwearDiamond = num;
    }

    public final void setHeadwearDuration(@Nullable Integer num) {
        this.headwearDuration = num;
    }

    public final void setHeadwearId(@Nullable Integer num) {
        this.headwearId = num;
    }

    public final void setHeadwearPicUrl(@Nullable String str) {
        this.headwearPicUrl = str;
    }

    public final void setHeadwearSvgaUrl(@Nullable String str) {
        this.headwearSvgaUrl = str;
    }

    public final void setMedalDiamond(@Nullable Integer num) {
        this.medalDiamond = num;
    }

    public final void setMedalDuration(@Nullable Integer num) {
        this.medalDuration = num;
    }

    public final void setMedalId(@Nullable Integer num) {
        this.medalId = num;
    }

    public final void setMedalPicUrl(@Nullable String str) {
        this.medalPicUrl = str;
    }

    public final void setMedalSvgaUrl(@Nullable String str) {
        this.medalSvgaUrl = str;
    }

    public final void setNobleDiamond(@Nullable Integer num) {
        this.nobleDiamond = num;
    }

    public final void setNobleDuration(@Nullable Integer num) {
        this.nobleDuration = num;
    }

    public final void setNobleLevel(@Nullable Integer num) {
        this.nobleLevel = num;
    }

    public final void setPropertyDiamond(@Nullable Integer num) {
        this.propertyDiamond = num;
    }

    public final void setPropertyDuration(@Nullable Integer num) {
        this.propertyDuration = num;
    }

    public final void setPropertyId(@Nullable Integer num) {
        this.propertyId = num;
    }

    public final void setPropertyPicUrl(@Nullable String str) {
        this.propertyPicUrl = str;
    }

    public final void setPropertySvgaUrl(@Nullable String str) {
        this.propertySvgaUrl = str;
    }

    @NotNull
    public String toString() {
        return "AwardDetailBean(diamondNum=" + this.diamondNum + ", hasGetReward=" + this.hasGetReward + ", headwearDiamond=" + this.headwearDiamond + ", headwearDuration=" + this.headwearDuration + ", headwearId=" + this.headwearId + ", headwearPicUrl=" + this.headwearPicUrl + ", headwearSvgaUrl=" + this.headwearSvgaUrl + ", medalDiamond=" + this.medalDiamond + ", medalDuration=" + this.medalDuration + ", medalId=" + this.medalId + ", medalPicUrl=" + this.medalPicUrl + ", medalSvgaUrl=" + this.medalSvgaUrl + ", nobleDiamond=" + this.nobleDiamond + ", nobleDuration=" + this.nobleDuration + ", nobleLevel=" + this.nobleLevel + ", propertyDiamond=" + this.propertyDiamond + ", propertyDuration=" + this.propertyDuration + ", propertyId=" + this.propertyId + ", propertyPicUrl=" + this.propertyPicUrl + ", propertySvgaUrl=" + this.propertySvgaUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.diamondNum;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool = this.hasGetReward;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.headwearDiamond;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.headwearDuration;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.headwearId;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        dest.writeString(this.headwearPicUrl);
        dest.writeString(this.headwearSvgaUrl);
        Integer num5 = this.medalDiamond;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
        Integer num6 = this.medalDuration;
        if (num6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num6.intValue());
        }
        Integer num7 = this.medalId;
        if (num7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num7.intValue());
        }
        dest.writeString(this.medalPicUrl);
        dest.writeString(this.medalSvgaUrl);
        Integer num8 = this.nobleDiamond;
        if (num8 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num8.intValue());
        }
        Integer num9 = this.nobleDuration;
        if (num9 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num9.intValue());
        }
        Integer num10 = this.nobleLevel;
        if (num10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num10.intValue());
        }
        Integer num11 = this.propertyDiamond;
        if (num11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num11.intValue());
        }
        Integer num12 = this.propertyDuration;
        if (num12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num12.intValue());
        }
        Integer num13 = this.propertyId;
        if (num13 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num13.intValue());
        }
        dest.writeString(this.propertyPicUrl);
        dest.writeString(this.propertySvgaUrl);
    }

    public AwardDetailBean(@Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str, @Nullable String str2, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str3, @Nullable String str4, @Nullable Integer num8, @Nullable Integer num9, @Nullable Integer num10, @Nullable Integer num11, @Nullable Integer num12, @Nullable Integer num13, @Nullable String str5, @Nullable String str6) {
        this.diamondNum = num;
        this.hasGetReward = bool;
        this.headwearDiamond = num2;
        this.headwearDuration = num3;
        this.headwearId = num4;
        this.headwearPicUrl = str;
        this.headwearSvgaUrl = str2;
        this.medalDiamond = num5;
        this.medalDuration = num6;
        this.medalId = num7;
        this.medalPicUrl = str3;
        this.medalSvgaUrl = str4;
        this.nobleDiamond = num8;
        this.nobleDuration = num9;
        this.nobleLevel = num10;
        this.propertyDiamond = num11;
        this.propertyDuration = num12;
        this.propertyId = num13;
        this.propertyPicUrl = str5;
        this.propertySvgaUrl = str6;
    }

    public /* synthetic */ AwardDetailBean(Integer num, Boolean bool, Integer num2, Integer num3, Integer num4, String str, String str2, Integer num5, Integer num6, Integer num7, String str3, String str4, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : num5, (i & 256) != 0 ? null : num6, (i & 512) != 0 ? null : num7, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str3, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : num8, (i & 8192) != 0 ? null : num9, (i & 16384) != 0 ? null : num10, (i & 32768) != 0 ? null : num11, (i & 65536) != 0 ? null : num12, (i & 131072) != 0 ? null : num13, (i & 262144) != 0 ? null : str5, (i & 524288) != 0 ? null : str6);
    }
}
