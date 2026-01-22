package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u00020\nJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020\nHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010'R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010$R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010$¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/data/model/NewRoomBean;", "Landroid/os/Parcelable;", Constants.KEY_HTTP_CODE, "", "createTime", "", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "cornerMark", "", "name", "groupInUserDuration", "micUsers", "", "Lcom/qiahao/base_common/model/common/User;", "gameTypes", "gameTypeIcon", "micUserNum", "countryIcon", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFaceUrl", "getGroupId", "getIntroduction", "getCornerMark", "()I", "setCornerMark", "(I)V", "getName", "setName", "(Ljava/lang/String;)V", "getGroupInUserDuration", "setGroupInUserDuration", "(Ljava/lang/Long;)V", "getMicUsers", "()Ljava/util/List;", "setMicUsers", "(Ljava/util/List;)V", "getGameTypes", "setGameTypes", "getGameTypeIcon", "setGameTypeIcon", "getMicUserNum", "()Ljava/lang/Integer;", "setMicUserNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCountryIcon", "setCountryIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/NewRoomBean;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class NewRoomBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<NewRoomBean> CREATOR = new Creator();

    @Nullable
    private final String code;
    private int cornerMark;

    @Nullable
    private String countryIcon;

    @Nullable
    private final Long createTime;

    @Nullable
    private final String faceUrl;

    @Nullable
    private String gameTypeIcon;

    @Nullable
    private List<Integer> gameTypes;

    @Nullable
    private final String groupId;

    @Nullable
    private Long groupInUserDuration;

    @Nullable
    private final String introduction;

    @Nullable
    private Integer micUserNum;

    @Nullable
    private List<User> micUsers;

    @Nullable
    private String name;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<NewRoomBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewRoomBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList.add(parcel.readParcelable(NewRoomBean.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList2 = new ArrayList(readInt3);
                for (int i2 = 0; i2 != readInt3; i2++) {
                    arrayList2.add(Integer.valueOf(parcel.readInt()));
                }
            }
            return new NewRoomBean(readString, valueOf, readString2, readString3, readString4, readInt, readString5, valueOf2, arrayList, arrayList2, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NewRoomBean[] newArray(int i) {
            return new NewRoomBean[i];
        }
    }

    public NewRoomBean() {
        this(null, null, null, null, null, 0, null, null, null, null, null, null, null, 8191, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final List<Integer> component10() {
        return this.gameTypes;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getMicUserNum() {
        return this.micUserNum;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    /* renamed from: component6, reason: from getter */
    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    public final List<User> component9() {
        return this.micUsers;
    }

    @NotNull
    public final NewRoomBean copy(@Nullable String code, @Nullable Long createTime, @Nullable String faceUrl, @Nullable String groupId, @Nullable String introduction, int cornerMark, @Nullable String name, @Nullable Long groupInUserDuration, @Nullable List<User> micUsers, @Nullable List<Integer> gameTypes, @Nullable String gameTypeIcon, @Nullable Integer micUserNum, @Nullable String countryIcon) {
        return new NewRoomBean(code, createTime, faceUrl, groupId, introduction, cornerMark, name, groupInUserDuration, micUsers, gameTypes, gameTypeIcon, micUserNum, countryIcon);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewRoomBean)) {
            return false;
        }
        NewRoomBean newRoomBean = (NewRoomBean) other;
        return Intrinsics.areEqual(this.code, newRoomBean.code) && Intrinsics.areEqual(this.createTime, newRoomBean.createTime) && Intrinsics.areEqual(this.faceUrl, newRoomBean.faceUrl) && Intrinsics.areEqual(this.groupId, newRoomBean.groupId) && Intrinsics.areEqual(this.introduction, newRoomBean.introduction) && this.cornerMark == newRoomBean.cornerMark && Intrinsics.areEqual(this.name, newRoomBean.name) && Intrinsics.areEqual(this.groupInUserDuration, newRoomBean.groupInUserDuration) && Intrinsics.areEqual(this.micUsers, newRoomBean.micUsers) && Intrinsics.areEqual(this.gameTypes, newRoomBean.gameTypes) && Intrinsics.areEqual(this.gameTypeIcon, newRoomBean.gameTypeIcon) && Intrinsics.areEqual(this.micUserNum, newRoomBean.micUserNum) && Intrinsics.areEqual(this.countryIcon, newRoomBean.countryIcon);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    public final List<Integer> getGameTypes() {
        return this.gameTypes;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Long getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    public final String getIntroduction() {
        return this.introduction;
    }

    @Nullable
    public final Integer getMicUserNum() {
        return this.micUserNum;
    }

    @Nullable
    public final List<User> getMicUsers() {
        return this.micUsers;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.createTime;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.faceUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.introduction;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.cornerMark) * 31;
        String str5 = this.name;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l2 = this.groupInUserDuration;
        int hashCode7 = (hashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        List<User> list = this.micUsers;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.gameTypes;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str6 = this.gameTypeIcon;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.micUserNum;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.countryIcon;
        return hashCode11 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setCornerMark(int i) {
        this.cornerMark = i;
    }

    public final void setCountryIcon(@Nullable String str) {
        this.countryIcon = str;
    }

    public final void setGameTypeIcon(@Nullable String str) {
        this.gameTypeIcon = str;
    }

    public final void setGameTypes(@Nullable List<Integer> list) {
        this.gameTypes = list;
    }

    public final void setGroupInUserDuration(@Nullable Long l) {
        this.groupInUserDuration = l;
    }

    public final void setMicUserNum(@Nullable Integer num) {
        this.micUserNum = num;
    }

    public final void setMicUsers(@Nullable List<User> list) {
        this.micUsers = list;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @NotNull
    public String toString() {
        return "NewRoomBean(code=" + this.code + ", createTime=" + this.createTime + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", cornerMark=" + this.cornerMark + ", name=" + this.name + ", groupInUserDuration=" + this.groupInUserDuration + ", micUsers=" + this.micUsers + ", gameTypes=" + this.gameTypes + ", gameTypeIcon=" + this.gameTypeIcon + ", micUserNum=" + this.micUserNum + ", countryIcon=" + this.countryIcon + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.code);
        Long l = this.createTime;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.faceUrl);
        dest.writeString(this.groupId);
        dest.writeString(this.introduction);
        dest.writeInt(this.cornerMark);
        dest.writeString(this.name);
        Long l2 = this.groupInUserDuration;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        List<User> list = this.micUsers;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<User> it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }
        List<Integer> list2 = this.gameTypes;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<Integer> it2 = list2.iterator();
            while (it2.hasNext()) {
                dest.writeInt(it2.next().intValue());
            }
        }
        dest.writeString(this.gameTypeIcon);
        Integer num = this.micUserNum;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.countryIcon);
    }

    public NewRoomBean(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, @Nullable String str5, @Nullable Long l2, @Nullable List<User> list, @Nullable List<Integer> list2, @Nullable String str6, @Nullable Integer num, @Nullable String str7) {
        this.code = str;
        this.createTime = l;
        this.faceUrl = str2;
        this.groupId = str3;
        this.introduction = str4;
        this.cornerMark = i;
        this.name = str5;
        this.groupInUserDuration = l2;
        this.micUsers = list;
        this.gameTypes = list2;
        this.gameTypeIcon = str6;
        this.micUserNum = num;
        this.countryIcon = str7;
    }

    public /* synthetic */ NewRoomBean(String str, Long l, String str2, String str3, String str4, int i, String str5, Long l2, List list, List list2, String str6, Integer num, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : l2, (i2 & 256) != 0 ? null : list, (i2 & 512) != 0 ? null : list2, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str6, (i2 & 2048) != 0 ? 0 : num, (i2 & 4096) == 0 ? str7 : null);
    }
}
