package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.agora.rtc.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u001d\u00103\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003Jz\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020\u0005J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0005HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006E"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipCard;", "Landroid/os/Parcelable;", "cardUrl", "", FirebaseAnalytics.Param.LEVEL, "", "levelPoints", "", "privileges", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/svip/Privilege;", "Lkotlin/collections/ArrayList;", "userSvip", "Lcom/qiahao/base_common/model/svip/UserSvip;", "effectUrl", "taskPrivileges", "", "Lcom/qiahao/base_common/model/svip/TaskPrivilegeBean;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/ArrayList;Lcom/qiahao/base_common/model/svip/UserSvip;Ljava/lang/String;Ljava/util/List;)V", "getCardUrl", "()Ljava/lang/String;", "setCardUrl", "(Ljava/lang/String;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLevelPoints", "()Ljava/lang/Long;", "setLevelPoints", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPrivileges", "()Ljava/util/ArrayList;", "setPrivileges", "(Ljava/util/ArrayList;)V", "getUserSvip", "()Lcom/qiahao/base_common/model/svip/UserSvip;", "setUserSvip", "(Lcom/qiahao/base_common/model/svip/UserSvip;)V", "getEffectUrl", "setEffectUrl", "getTaskPrivileges", "()Ljava/util/List;", "setTaskPrivileges", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/ArrayList;Lcom/qiahao/base_common/model/svip/UserSvip;Ljava/lang/String;Ljava/util/List;)Lcom/qiahao/base_common/model/svip/SvipCard;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipCard implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SvipCard> CREATOR = new Creator();

    @Nullable
    private String cardUrl;

    @Nullable
    private String effectUrl;

    @Nullable
    private Integer level;

    @Nullable
    private Long levelPoints;

    @Nullable
    private ArrayList<Privilege> privileges;

    @Nullable
    private List<TaskPrivilegeBean> taskPrivileges;

    @Nullable
    private UserSvip userSvip;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipCard> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipCard createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Privilege.CREATOR.createFromParcel(parcel));
                }
            }
            UserSvip createFromParcel = parcel.readInt() == 0 ? null : UserSvip.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(TaskPrivilegeBean.CREATOR.createFromParcel(parcel));
                }
            }
            return new SvipCard(readString, valueOf, valueOf2, arrayList, createFromParcel, readString2, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipCard[] newArray(int i10) {
            return new SvipCard[i10];
        }
    }

    public SvipCard() {
        this(null, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null);
    }

    public static /* synthetic */ SvipCard copy$default(SvipCard svipCard, String str, Integer num, Long l10, ArrayList arrayList, UserSvip userSvip, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = svipCard.cardUrl;
        }
        if ((i10 & 2) != 0) {
            num = svipCard.level;
        }
        Integer num2 = num;
        if ((i10 & 4) != 0) {
            l10 = svipCard.levelPoints;
        }
        Long l11 = l10;
        if ((i10 & 8) != 0) {
            arrayList = svipCard.privileges;
        }
        ArrayList arrayList2 = arrayList;
        if ((i10 & 16) != 0) {
            userSvip = svipCard.userSvip;
        }
        UserSvip userSvip2 = userSvip;
        if ((i10 & 32) != 0) {
            str2 = svipCard.effectUrl;
        }
        String str3 = str2;
        if ((i10 & 64) != 0) {
            list = svipCard.taskPrivileges;
        }
        return svipCard.copy(str, num2, l11, arrayList2, userSvip2, str3, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCardUrl() {
        return this.cardUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getLevelPoints() {
        return this.levelPoints;
    }

    @Nullable
    public final ArrayList<Privilege> component4() {
        return this.privileges;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final UserSvip getUserSvip() {
        return this.userSvip;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    public final List<TaskPrivilegeBean> component7() {
        return this.taskPrivileges;
    }

    @NotNull
    public final SvipCard copy(@Nullable String cardUrl, @Nullable Integer level, @Nullable Long levelPoints, @Nullable ArrayList<Privilege> privileges, @Nullable UserSvip userSvip, @Nullable String effectUrl, @Nullable List<TaskPrivilegeBean> taskPrivileges) {
        return new SvipCard(cardUrl, level, levelPoints, privileges, userSvip, effectUrl, taskPrivileges);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipCard)) {
            return false;
        }
        SvipCard svipCard = (SvipCard) other;
        return Intrinsics.areEqual(this.cardUrl, svipCard.cardUrl) && Intrinsics.areEqual(this.level, svipCard.level) && Intrinsics.areEqual(this.levelPoints, svipCard.levelPoints) && Intrinsics.areEqual(this.privileges, svipCard.privileges) && Intrinsics.areEqual(this.userSvip, svipCard.userSvip) && Intrinsics.areEqual(this.effectUrl, svipCard.effectUrl) && Intrinsics.areEqual(this.taskPrivileges, svipCard.taskPrivileges);
    }

    @Nullable
    public final String getCardUrl() {
        return this.cardUrl;
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final Long getLevelPoints() {
        return this.levelPoints;
    }

    @Nullable
    public final ArrayList<Privilege> getPrivileges() {
        return this.privileges;
    }

    @Nullable
    public final List<TaskPrivilegeBean> getTaskPrivileges() {
        return this.taskPrivileges;
    }

    @Nullable
    public final UserSvip getUserSvip() {
        return this.userSvip;
    }

    public int hashCode() {
        String str = this.cardUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.levelPoints;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        ArrayList<Privilege> arrayList = this.privileges;
        int hashCode4 = (hashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        UserSvip userSvip = this.userSvip;
        int hashCode5 = (hashCode4 + (userSvip == null ? 0 : userSvip.hashCode())) * 31;
        String str2 = this.effectUrl;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<TaskPrivilegeBean> list = this.taskPrivileges;
        return hashCode6 + (list != null ? list.hashCode() : 0);
    }

    public final void setCardUrl(@Nullable String str) {
        this.cardUrl = str;
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setLevelPoints(@Nullable Long l10) {
        this.levelPoints = l10;
    }

    public final void setPrivileges(@Nullable ArrayList<Privilege> arrayList) {
        this.privileges = arrayList;
    }

    public final void setTaskPrivileges(@Nullable List<TaskPrivilegeBean> list) {
        this.taskPrivileges = list;
    }

    public final void setUserSvip(@Nullable UserSvip userSvip) {
        this.userSvip = userSvip;
    }

    @NotNull
    public String toString() {
        return "SvipCard(cardUrl=" + this.cardUrl + ", level=" + this.level + ", levelPoints=" + this.levelPoints + ", privileges=" + this.privileges + ", userSvip=" + this.userSvip + ", effectUrl=" + this.effectUrl + ", taskPrivileges=" + this.taskPrivileges + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.cardUrl);
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l10 = this.levelPoints;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        ArrayList<Privilege> arrayList = this.privileges;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Privilege> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        UserSvip userSvip = this.userSvip;
        if (userSvip == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userSvip.writeToParcel(dest, flags);
        }
        dest.writeString(this.effectUrl);
        List<TaskPrivilegeBean> list = this.taskPrivileges;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list.size());
        Iterator<TaskPrivilegeBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
    }

    public SvipCard(@Nullable String str, @Nullable Integer num, @Nullable Long l10, @Nullable ArrayList<Privilege> arrayList, @Nullable UserSvip userSvip, @Nullable String str2, @Nullable List<TaskPrivilegeBean> list) {
        this.cardUrl = str;
        this.level = num;
        this.levelPoints = l10;
        this.privileges = arrayList;
        this.userSvip = userSvip;
        this.effectUrl = str2;
        this.taskPrivileges = list;
    }

    public /* synthetic */ SvipCard(String str, Integer num, Long l10, ArrayList arrayList, UserSvip userSvip, String str2, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : arrayList, (i10 & 16) != 0 ? null : userSvip, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? null : list);
    }
}
