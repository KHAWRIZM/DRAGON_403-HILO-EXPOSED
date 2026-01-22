package com.qiahao.nextvideo.data.model.gameLevel;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008c\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010?J\u0006\u0010@\u001a\u00020\bJ\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\bHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;", "Landroid/os/Parcelable;", "bg1Url", "", "bg2Url", "bgUrl", "cardUrl", "level", "", "levelPoints", "", "medalUrl", "privileges", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelPrivilege;", "Lkotlin/collections/ArrayList;", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getBg1Url", "()Ljava/lang/String;", "setBg1Url", "(Ljava/lang/String;)V", "getBg2Url", "setBg2Url", "getBgUrl", "setBgUrl", "getCardUrl", "setCardUrl", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLevelPoints", "()Ljava/lang/Long;", "setLevelPoints", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMedalUrl", "setMedalUrl", "getPrivileges", "()Ljava/util/ArrayList;", "setPrivileges", "(Ljava/util/ArrayList;)V", "getTitle", "setTitle", "userLevel", "Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "getUserLevel", "()Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "setUserLevel", "(Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameLevelCard implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameLevelCard> CREATOR = new Creator();

    @Nullable
    private String bg1Url;

    @Nullable
    private String bg2Url;

    @Nullable
    private String bgUrl;

    @Nullable
    private String cardUrl;

    @Nullable
    private Integer level;

    @Nullable
    private Long levelPoints;

    @Nullable
    private String medalUrl;

    @Nullable
    private ArrayList<GameLevelPrivilege> privileges;

    @Nullable
    private String title;

    @Nullable
    private UserGameLevel userLevel;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameLevelCard> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameLevelCard createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(GameLevelPrivilege.CREATOR.createFromParcel(parcel));
                }
            }
            return new GameLevelCard(readString, readString2, readString3, readString4, valueOf, valueOf2, readString5, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameLevelCard[] newArray(int i) {
            return new GameLevelCard[i];
        }
    }

    public GameLevelCard() {
        this(null, null, null, null, null, null, null, null, null, UnixStat.DEFAULT_LINK_PERM, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getBg1Url() {
        return this.bg1Url;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getBg2Url() {
        return this.bg2Url;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBgUrl() {
        return this.bgUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCardUrl() {
        return this.cardUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getLevelPoints() {
        return this.levelPoints;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @Nullable
    public final ArrayList<GameLevelPrivilege> component8() {
        return this.privileges;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final GameLevelCard copy(@Nullable String bg1Url, @Nullable String bg2Url, @Nullable String bgUrl, @Nullable String cardUrl, @Nullable Integer level, @Nullable Long levelPoints, @Nullable String medalUrl, @Nullable ArrayList<GameLevelPrivilege> privileges, @Nullable String title) {
        return new GameLevelCard(bg1Url, bg2Url, bgUrl, cardUrl, level, levelPoints, medalUrl, privileges, title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameLevelCard)) {
            return false;
        }
        GameLevelCard gameLevelCard = (GameLevelCard) other;
        return Intrinsics.areEqual(this.bg1Url, gameLevelCard.bg1Url) && Intrinsics.areEqual(this.bg2Url, gameLevelCard.bg2Url) && Intrinsics.areEqual(this.bgUrl, gameLevelCard.bgUrl) && Intrinsics.areEqual(this.cardUrl, gameLevelCard.cardUrl) && Intrinsics.areEqual(this.level, gameLevelCard.level) && Intrinsics.areEqual(this.levelPoints, gameLevelCard.levelPoints) && Intrinsics.areEqual(this.medalUrl, gameLevelCard.medalUrl) && Intrinsics.areEqual(this.privileges, gameLevelCard.privileges) && Intrinsics.areEqual(this.title, gameLevelCard.title);
    }

    @Nullable
    public final String getBg1Url() {
        return this.bg1Url;
    }

    @Nullable
    public final String getBg2Url() {
        return this.bg2Url;
    }

    @Nullable
    public final String getBgUrl() {
        return this.bgUrl;
    }

    @Nullable
    public final String getCardUrl() {
        return this.cardUrl;
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
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @Nullable
    public final ArrayList<GameLevelPrivilege> getPrivileges() {
        return this.privileges;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final UserGameLevel getUserLevel() {
        return this.userLevel;
    }

    public int hashCode() {
        String str = this.bg1Url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bg2Url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bgUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.level;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.levelPoints;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.medalUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ArrayList<GameLevelPrivilege> arrayList = this.privileges;
        int hashCode8 = (hashCode7 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str6 = this.title;
        return hashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setBg1Url(@Nullable String str) {
        this.bg1Url = str;
    }

    public final void setBg2Url(@Nullable String str) {
        this.bg2Url = str;
    }

    public final void setBgUrl(@Nullable String str) {
        this.bgUrl = str;
    }

    public final void setCardUrl(@Nullable String str) {
        this.cardUrl = str;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setLevelPoints(@Nullable Long l) {
        this.levelPoints = l;
    }

    public final void setMedalUrl(@Nullable String str) {
        this.medalUrl = str;
    }

    public final void setPrivileges(@Nullable ArrayList<GameLevelPrivilege> arrayList) {
        this.privileges = arrayList;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUserLevel(@Nullable UserGameLevel userGameLevel) {
        this.userLevel = userGameLevel;
    }

    @NotNull
    public String toString() {
        return "GameLevelCard(bg1Url=" + this.bg1Url + ", bg2Url=" + this.bg2Url + ", bgUrl=" + this.bgUrl + ", cardUrl=" + this.cardUrl + ", level=" + this.level + ", levelPoints=" + this.levelPoints + ", medalUrl=" + this.medalUrl + ", privileges=" + this.privileges + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.bg1Url);
        dest.writeString(this.bg2Url);
        dest.writeString(this.bgUrl);
        dest.writeString(this.cardUrl);
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l = this.levelPoints;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.medalUrl);
        ArrayList<GameLevelPrivilege> arrayList = this.privileges;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<GameLevelPrivilege> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.title);
    }

    public GameLevelCard(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Long l, @Nullable String str5, @Nullable ArrayList<GameLevelPrivilege> arrayList, @Nullable String str6) {
        this.bg1Url = str;
        this.bg2Url = str2;
        this.bgUrl = str3;
        this.cardUrl = str4;
        this.level = num;
        this.levelPoints = l;
        this.medalUrl = str5;
        this.privileges = arrayList;
        this.title = str6;
    }

    public /* synthetic */ GameLevelCard(String str, String str2, String str3, String str4, Integer num, Long l, String str5, ArrayList arrayList, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : arrayList, (i & 256) == 0 ? str6 : null);
    }
}
