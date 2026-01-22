package com.qiahao.base_common.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import anetwork.channel.unified.e;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.amazonaws.services.s3.internal.Constants;
import com.liulishuo.okdownload.DownloadTask;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\bj\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010`\u001a\u00020\u0005J\u0006\u0010a\u001a\u00020\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010AJ\t\u0010p\u001a\u00020\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\t\u0010x\u001a\u00020\u0013HÆ\u0003J\u0096\u0002\u0010y\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u0010zJ\u0006\u0010{\u001a\u00020\u0005J\u0013\u0010|\u001a\u00020\u00132\b\u0010}\u001a\u0004\u0018\u00010~HÖ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b=\u0010-\"\u0004\b>\u0010/R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b\u0012\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010F\"\u0004\bJ\u0010HR\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010\"R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010 \"\u0004\bV\u0010\"R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010F\"\u0004\bX\u0010HR\u001a\u0010\u001c\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010 \"\u0004\b_\u0010\"¨\u0006\u0086\u0001"}, d2 = {"Lcom/qiahao/base_common/model/ActivityDetailData;", "Landroid/os/Parcelable;", "type", "", "acType", "", "banner", "desc", "endAt", "", "groupHot", "groupId", "groupCode", "groupIcon", "groupName", "id", "startAt", "theme", "isSubscribe", "", "personNum", "supportNum", "diamond", "externalId", "groupOwnerCode", "countryIcon", "groupOwnerId", "notRecommend", "showDiamond", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getAcType", "()Ljava/lang/Integer;", "setAcType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBanner", "setBanner", "getDesc", "setDesc", "getEndAt", "()Ljava/lang/Long;", "setEndAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGroupHot", "setGroupHot", "getGroupId", "setGroupId", "getGroupCode", "setGroupCode", "getGroupIcon", "setGroupIcon", "getGroupName", "setGroupName", "getId", "setId", "getStartAt", "setStartAt", "getTheme", "setTheme", "()Ljava/lang/Boolean;", "setSubscribe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPersonNum", "()I", "setPersonNum", "(I)V", "getSupportNum", "setSupportNum", "getDiamond", "()J", "setDiamond", "(J)V", "getExternalId", "setExternalId", "getGroupOwnerCode", "setGroupOwnerCode", "getCountryIcon", "setCountryIcon", "getGroupOwnerId", "setGroupOwnerId", "getNotRecommend", "setNotRecommend", "getShowDiamond", "()Z", "setShowDiamond", "(Z)V", AgooMessageReceiver.MESSAGE_ID, "getMessageId", "setMessageId", "getActivityTypeIcon", "getActivityTypeText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/qiahao/base_common/model/ActivityDetailData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ActivityDetailData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ActivityDetailData> CREATOR = new Creator();

    @Nullable
    private Integer acType;

    @Nullable
    private String banner;

    @Nullable
    private String countryIcon;

    @Nullable
    private String desc;
    private long diamond;

    @Nullable
    private Long endAt;

    @Nullable
    private String externalId;

    @NotNull
    private String groupCode;

    @Nullable
    private Integer groupHot;

    @Nullable
    private String groupIcon;

    @Nullable
    private String groupId;

    @Nullable
    private String groupName;

    @Nullable
    private String groupOwnerCode;

    @Nullable
    private String groupOwnerId;

    @Nullable
    private String id;

    @Nullable
    private Boolean isSubscribe;

    @Nullable
    private String messageId;
    private int notRecommend;
    private int personNum;
    private boolean showDiamond;

    @Nullable
    private Long startAt;
    private int supportNum;

    @Nullable
    private String theme;

    @Nullable
    private String type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<ActivityDetailData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivityDetailData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Boolean bool = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString9 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ActivityDetailData(readString, valueOf, readString2, readString3, valueOf2, valueOf3, readString4, readString5, readString6, readString7, readString8, valueOf4, readString9, bool, parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActivityDetailData[] newArray(int i10) {
            return new ActivityDetailData[i10];
        }
    }

    public ActivityDetailData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0L, null, null, null, null, 0, false, 8388607, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Long getStartAt() {
        return this.startAt;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Boolean getIsSubscribe() {
        return this.isSubscribe;
    }

    /* renamed from: component15, reason: from getter */
    public final int getPersonNum() {
        return this.personNum;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSupportNum() {
        return this.supportNum;
    }

    /* renamed from: component17, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getGroupOwnerCode() {
        return this.groupOwnerCode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getAcType() {
        return this.acType;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final String getGroupOwnerId() {
        return this.groupOwnerId;
    }

    /* renamed from: component22, reason: from getter */
    public final int getNotRecommend() {
        return this.notRecommend;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getShowDiamond() {
        return this.showDiamond;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getEndAt() {
        return this.endAt;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getGroupHot() {
        return this.groupHot;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getGroupCode() {
        return this.groupCode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getGroupIcon() {
        return this.groupIcon;
    }

    @NotNull
    public final ActivityDetailData copy(@Nullable String type, @Nullable Integer acType, @Nullable String banner, @Nullable String desc, @Nullable Long endAt, @Nullable Integer groupHot, @Nullable String groupId, @NotNull String groupCode, @Nullable String groupIcon, @Nullable String groupName, @Nullable String id, @Nullable Long startAt, @Nullable String theme, @Nullable Boolean isSubscribe, int personNum, int supportNum, long diamond, @Nullable String externalId, @Nullable String groupOwnerCode, @Nullable String countryIcon, @Nullable String groupOwnerId, int notRecommend, boolean showDiamond) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        return new ActivityDetailData(type, acType, banner, desc, endAt, groupHot, groupId, groupCode, groupIcon, groupName, id, startAt, theme, isSubscribe, personNum, supportNum, diamond, externalId, groupOwnerCode, countryIcon, groupOwnerId, notRecommend, showDiamond);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityDetailData)) {
            return false;
        }
        ActivityDetailData activityDetailData = (ActivityDetailData) other;
        return Intrinsics.areEqual(this.type, activityDetailData.type) && Intrinsics.areEqual(this.acType, activityDetailData.acType) && Intrinsics.areEqual(this.banner, activityDetailData.banner) && Intrinsics.areEqual(this.desc, activityDetailData.desc) && Intrinsics.areEqual(this.endAt, activityDetailData.endAt) && Intrinsics.areEqual(this.groupHot, activityDetailData.groupHot) && Intrinsics.areEqual(this.groupId, activityDetailData.groupId) && Intrinsics.areEqual(this.groupCode, activityDetailData.groupCode) && Intrinsics.areEqual(this.groupIcon, activityDetailData.groupIcon) && Intrinsics.areEqual(this.groupName, activityDetailData.groupName) && Intrinsics.areEqual(this.id, activityDetailData.id) && Intrinsics.areEqual(this.startAt, activityDetailData.startAt) && Intrinsics.areEqual(this.theme, activityDetailData.theme) && Intrinsics.areEqual(this.isSubscribe, activityDetailData.isSubscribe) && this.personNum == activityDetailData.personNum && this.supportNum == activityDetailData.supportNum && this.diamond == activityDetailData.diamond && Intrinsics.areEqual(this.externalId, activityDetailData.externalId) && Intrinsics.areEqual(this.groupOwnerCode, activityDetailData.groupOwnerCode) && Intrinsics.areEqual(this.countryIcon, activityDetailData.countryIcon) && Intrinsics.areEqual(this.groupOwnerId, activityDetailData.groupOwnerId) && this.notRecommend == activityDetailData.notRecommend && this.showDiamond == activityDetailData.showDiamond;
    }

    @Nullable
    public final Integer getAcType() {
        return this.acType;
    }

    public final int getActivityTypeIcon() {
        Integer num = this.acType;
        if (num != null && num.intValue() == 1) {
            return R.drawable.activity_type_game;
        }
        if (num != null && num.intValue() == 2) {
            return R.drawable.activity_type_contest;
        }
        if (num != null && num.intValue() == 3) {
            return R.drawable.activity_type_party;
        }
        if (num != null && num.intValue() == 4) {
            return R.drawable.activity_type_poetry;
        }
        return R.drawable.activity_type_game;
    }

    @NotNull
    public final String getActivityTypeText() {
        Integer num = this.acType;
        if (num != null && num.intValue() == 1) {
            return ResourcesKtxKt.getStringById(this, R.string.activity_type_game);
        }
        if (num != null && num.intValue() == 2) {
            return ResourcesKtxKt.getStringById(this, R.string.activity_type_play);
        }
        if (num != null && num.intValue() == 3) {
            return ResourcesKtxKt.getStringById(this, R.string.activity_type_party);
        }
        if (num != null && num.intValue() == 4) {
            return ResourcesKtxKt.getStringById(this, R.string.activity_type_poetry);
        }
        return "";
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Long getEndAt() {
        return this.endAt;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getGroupCode() {
        return this.groupCode;
    }

    @Nullable
    public final Integer getGroupHot() {
        return this.groupHot;
    }

    @Nullable
    public final String getGroupIcon() {
        return this.groupIcon;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getGroupName() {
        return this.groupName;
    }

    @Nullable
    public final String getGroupOwnerCode() {
        return this.groupOwnerCode;
    }

    @Nullable
    public final String getGroupOwnerId() {
        return this.groupOwnerId;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    public final int getNotRecommend() {
        return this.notRecommend;
    }

    public final int getPersonNum() {
        return this.personNum;
    }

    public final boolean getShowDiamond() {
        return this.showDiamond;
    }

    @Nullable
    public final Long getStartAt() {
        return this.startAt;
    }

    public final int getSupportNum() {
        return this.supportNum;
    }

    @Nullable
    public final String getTheme() {
        return this.theme;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.acType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.banner;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l10 = this.endAt;
        int hashCode5 = (hashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num2 = this.groupHot;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.groupId;
        int hashCode7 = (((hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.groupCode.hashCode()) * 31;
        String str5 = this.groupIcon;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.groupName;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.id;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l11 = this.startAt;
        int hashCode11 = (hashCode10 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str8 = this.theme;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.isSubscribe;
        int hashCode13 = (((((((hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31) + this.personNum) * 31) + this.supportNum) * 31) + c.a(this.diamond)) * 31;
        String str9 = this.externalId;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.groupOwnerCode;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.countryIcon;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.groupOwnerId;
        return ((((hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31) + this.notRecommend) * 31) + q2.a.a(this.showDiamond);
    }

    @Nullable
    public final Boolean isSubscribe() {
        return this.isSubscribe;
    }

    public final void setAcType(@Nullable Integer num) {
        this.acType = num;
    }

    public final void setBanner(@Nullable String str) {
        this.banner = str;
    }

    public final void setCountryIcon(@Nullable String str) {
        this.countryIcon = str;
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setDiamond(long j10) {
        this.diamond = j10;
    }

    public final void setEndAt(@Nullable Long l10) {
        this.endAt = l10;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setGroupCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupCode = str;
    }

    public final void setGroupHot(@Nullable Integer num) {
        this.groupHot = num;
    }

    public final void setGroupIcon(@Nullable String str) {
        this.groupIcon = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setGroupName(@Nullable String str) {
        this.groupName = str;
    }

    public final void setGroupOwnerCode(@Nullable String str) {
        this.groupOwnerCode = str;
    }

    public final void setGroupOwnerId(@Nullable String str) {
        this.groupOwnerId = str;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setMessageId(@Nullable String str) {
        this.messageId = str;
    }

    public final void setNotRecommend(int i10) {
        this.notRecommend = i10;
    }

    public final void setPersonNum(int i10) {
        this.personNum = i10;
    }

    public final void setShowDiamond(boolean z10) {
        this.showDiamond = z10;
    }

    public final void setStartAt(@Nullable Long l10) {
        this.startAt = l10;
    }

    public final void setSubscribe(@Nullable Boolean bool) {
        this.isSubscribe = bool;
    }

    public final void setSupportNum(int i10) {
        this.supportNum = i10;
    }

    public final void setTheme(@Nullable String str) {
        this.theme = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public String toString() {
        return "ActivityDetailData(type=" + this.type + ", acType=" + this.acType + ", banner=" + this.banner + ", desc=" + this.desc + ", endAt=" + this.endAt + ", groupHot=" + this.groupHot + ", groupId=" + this.groupId + ", groupCode=" + this.groupCode + ", groupIcon=" + this.groupIcon + ", groupName=" + this.groupName + ", id=" + this.id + ", startAt=" + this.startAt + ", theme=" + this.theme + ", isSubscribe=" + this.isSubscribe + ", personNum=" + this.personNum + ", supportNum=" + this.supportNum + ", diamond=" + this.diamond + ", externalId=" + this.externalId + ", groupOwnerCode=" + this.groupOwnerCode + ", countryIcon=" + this.countryIcon + ", groupOwnerId=" + this.groupOwnerId + ", notRecommend=" + this.notRecommend + ", showDiamond=" + this.showDiamond + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.type);
        Integer num = this.acType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.banner);
        dest.writeString(this.desc);
        Long l10 = this.endAt;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Integer num2 = this.groupHot;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.groupId);
        dest.writeString(this.groupCode);
        dest.writeString(this.groupIcon);
        dest.writeString(this.groupName);
        dest.writeString(this.id);
        Long l11 = this.startAt;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        dest.writeString(this.theme);
        Boolean bool = this.isSubscribe;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.personNum);
        dest.writeInt(this.supportNum);
        dest.writeLong(this.diamond);
        dest.writeString(this.externalId);
        dest.writeString(this.groupOwnerCode);
        dest.writeString(this.countryIcon);
        dest.writeString(this.groupOwnerId);
        dest.writeInt(this.notRecommend);
        dest.writeInt(this.showDiamond ? 1 : 0);
    }

    public ActivityDetailData(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable Long l10, @Nullable Integer num2, @Nullable String str4, @NotNull String groupCode, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Long l11, @Nullable String str8, @Nullable Boolean bool, int i10, int i11, long j10, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, int i12, boolean z10) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        this.type = str;
        this.acType = num;
        this.banner = str2;
        this.desc = str3;
        this.endAt = l10;
        this.groupHot = num2;
        this.groupId = str4;
        this.groupCode = groupCode;
        this.groupIcon = str5;
        this.groupName = str6;
        this.id = str7;
        this.startAt = l11;
        this.theme = str8;
        this.isSubscribe = bool;
        this.personNum = i10;
        this.supportNum = i11;
        this.diamond = j10;
        this.externalId = str9;
        this.groupOwnerCode = str10;
        this.countryIcon = str11;
        this.groupOwnerId = str12;
        this.notRecommend = i12;
        this.showDiamond = z10;
    }

    public /* synthetic */ ActivityDetailData(String str, Integer num, String str2, String str3, Long l10, Integer num2, String str4, String str5, String str6, String str7, String str8, Long l11, String str9, Boolean bool, int i10, int i11, long j10, String str10, String str11, String str12, String str13, int i12, boolean z10, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : num, (i13 & 4) != 0 ? null : str2, (i13 & 8) != 0 ? null : str3, (i13 & 16) != 0 ? null : l10, (i13 & 32) != 0 ? null : num2, (i13 & 64) != 0 ? null : str4, (i13 & 128) != 0 ? "" : str5, (i13 & 256) != 0 ? null : str6, (i13 & 512) != 0 ? null : str7, (i13 & 1024) == 0 ? str8 : "", (i13 & 2048) != 0 ? null : l11, (i13 & 4096) != 0 ? null : str9, (i13 & 8192) != 0 ? null : bool, (i13 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? 0 : i10, (i13 & 32768) != 0 ? 0 : i11, (i13 & 65536) != 0 ? 0L : j10, (i13 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? null : str10, (i13 & 262144) != 0 ? null : str11, (i13 & anet.channel.bytes.a.MAX_POOL_SIZE) != 0 ? null : str12, (i13 & Constants.MB) != 0 ? null : str13, (i13 & 2097152) != 0 ? 0 : i12, (i13 & 4194304) == 0 ? z10 : false);
    }
}
