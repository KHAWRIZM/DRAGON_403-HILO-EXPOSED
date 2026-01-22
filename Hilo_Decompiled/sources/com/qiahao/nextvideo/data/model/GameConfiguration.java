package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.profile.activity.SelectCountryActivity;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import okhttp3.internal.http2.Settings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0014HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%Jà\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010VJ\u0006\u0010W\u001a\u00020\u0003J\u0013\u0010X\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J\u0016\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b\u0007\u0010%\"\u0004\b&\u0010'R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b\u0017\u0010%\"\u0004\bD\u0010'¨\u0006b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Landroid/os/Parcelable;", "gameType", "", TUIConstants.TUIChat.INPUT_MORE_ICON, "", "bannerUrl", SelectCountryActivity.IS_FULL, "", "rate", "", "themeColor", "title", "url", GameMatchActivity.GAME_ID, "startColor", "endColor", "desc", "modes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "inGameCenter", "groupId", "is1V1", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getGameType", "()Ljava/lang/Integer;", "setGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getBannerUrl", "setBannerUrl", "()Ljava/lang/Boolean;", "setFull", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRate", "()Ljava/lang/Double;", "setRate", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getThemeColor", "setThemeColor", "getTitle", "setTitle", "getUrl", "setUrl", "getGameId", "setGameId", "getStartColor", "setStartColor", "getEndColor", "setEndColor", "getDesc", "setDesc", "getModes", "()Ljava/util/ArrayList;", "setModes", "(Ljava/util/ArrayList;)V", "getInGameCenter", "setInGameCenter", "getGroupId", "setGroupId", "set1V1", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameConfiguration implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameConfiguration> CREATOR = new Creator();

    @Nullable
    private String bannerUrl;

    @Nullable
    private String desc;

    @Nullable
    private String endColor;

    @Nullable
    private Integer gameId;

    @Nullable
    private Integer gameType;

    @Nullable
    private String groupId;

    @Nullable
    private String icon;

    @Nullable
    private Boolean inGameCenter;

    @Nullable
    private Boolean is1V1;

    @Nullable
    private Boolean isFull;

    @Nullable
    private ArrayList<Integer> modes;

    @Nullable
    private Double rate;

    @Nullable
    private String startColor;

    @Nullable
    private String themeColor;

    @Nullable
    private String title;

    @Nullable
    private String url;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfiguration createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Boolean valueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Double valueOf3 = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(Integer.valueOf(parcel.readInt()));
                }
                arrayList = arrayList2;
            }
            return new GameConfiguration(valueOf, readString, readString2, valueOf2, valueOf3, readString3, readString4, readString5, valueOf4, readString6, readString7, readString8, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfiguration[] newArray(int i) {
            return new GameConfiguration[i];
        }
    }

    public GameConfiguration() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getStartColor() {
        return this.startColor;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getEndColor() {
        return this.endColor;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final ArrayList<Integer> component13() {
        return this.modes;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Boolean getInGameCenter() {
        return this.inGameCenter;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Boolean getIs1V1() {
        return this.is1V1;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getIsFull() {
        return this.isFull;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Double getRate() {
        return this.rate;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getThemeColor() {
        return this.themeColor;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @NotNull
    public final GameConfiguration copy(@Nullable Integer gameType, @Nullable String icon, @Nullable String bannerUrl, @Nullable Boolean isFull, @Nullable Double rate, @Nullable String themeColor, @Nullable String title, @Nullable String url, @Nullable Integer gameId, @Nullable String startColor, @Nullable String endColor, @Nullable String desc, @Nullable ArrayList<Integer> modes, @Nullable Boolean inGameCenter, @Nullable String groupId, @Nullable Boolean is1V1) {
        return new GameConfiguration(gameType, icon, bannerUrl, isFull, rate, themeColor, title, url, gameId, startColor, endColor, desc, modes, inGameCenter, groupId, is1V1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameConfiguration)) {
            return false;
        }
        GameConfiguration gameConfiguration = (GameConfiguration) other;
        return Intrinsics.areEqual(this.gameType, gameConfiguration.gameType) && Intrinsics.areEqual(this.icon, gameConfiguration.icon) && Intrinsics.areEqual(this.bannerUrl, gameConfiguration.bannerUrl) && Intrinsics.areEqual(this.isFull, gameConfiguration.isFull) && Intrinsics.areEqual(this.rate, gameConfiguration.rate) && Intrinsics.areEqual(this.themeColor, gameConfiguration.themeColor) && Intrinsics.areEqual(this.title, gameConfiguration.title) && Intrinsics.areEqual(this.url, gameConfiguration.url) && Intrinsics.areEqual(this.gameId, gameConfiguration.gameId) && Intrinsics.areEqual(this.startColor, gameConfiguration.startColor) && Intrinsics.areEqual(this.endColor, gameConfiguration.endColor) && Intrinsics.areEqual(this.desc, gameConfiguration.desc) && Intrinsics.areEqual(this.modes, gameConfiguration.modes) && Intrinsics.areEqual(this.inGameCenter, gameConfiguration.inGameCenter) && Intrinsics.areEqual(this.groupId, gameConfiguration.groupId) && Intrinsics.areEqual(this.is1V1, gameConfiguration.is1V1);
    }

    @Nullable
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getEndColor() {
        return this.endColor;
    }

    @Nullable
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final Boolean getInGameCenter() {
        return this.inGameCenter;
    }

    @Nullable
    public final ArrayList<Integer> getModes() {
        return this.modes;
    }

    @Nullable
    public final Double getRate() {
        return this.rate;
    }

    @Nullable
    public final String getStartColor() {
        return this.startColor;
    }

    @Nullable
    public final String getThemeColor() {
        return this.themeColor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Integer num = this.gameType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.icon;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bannerUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isFull;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.rate;
        int hashCode5 = (hashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        String str3 = this.themeColor;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.gameId;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.startColor;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endColor;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.desc;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.modes;
        int hashCode13 = (hashCode12 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Boolean bool2 = this.inGameCenter;
        int hashCode14 = (hashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str9 = this.groupId;
        int hashCode15 = (hashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool3 = this.is1V1;
        return hashCode15 + (bool3 != null ? bool3.hashCode() : 0);
    }

    @Nullable
    public final Boolean is1V1() {
        return this.is1V1;
    }

    @Nullable
    public final Boolean isFull() {
        return this.isFull;
    }

    public final void set1V1(@Nullable Boolean bool) {
        this.is1V1 = bool;
    }

    public final void setBannerUrl(@Nullable String str) {
        this.bannerUrl = str;
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setEndColor(@Nullable String str) {
        this.endColor = str;
    }

    public final void setFull(@Nullable Boolean bool) {
        this.isFull = bool;
    }

    public final void setGameId(@Nullable Integer num) {
        this.gameId = num;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setInGameCenter(@Nullable Boolean bool) {
        this.inGameCenter = bool;
    }

    public final void setModes(@Nullable ArrayList<Integer> arrayList) {
        this.modes = arrayList;
    }

    public final void setRate(@Nullable Double d) {
        this.rate = d;
    }

    public final void setStartColor(@Nullable String str) {
        this.startColor = str;
    }

    public final void setThemeColor(@Nullable String str) {
        this.themeColor = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "GameConfiguration(gameType=" + this.gameType + ", icon=" + this.icon + ", bannerUrl=" + this.bannerUrl + ", isFull=" + this.isFull + ", rate=" + this.rate + ", themeColor=" + this.themeColor + ", title=" + this.title + ", url=" + this.url + ", gameId=" + this.gameId + ", startColor=" + this.startColor + ", endColor=" + this.endColor + ", desc=" + this.desc + ", modes=" + this.modes + ", inGameCenter=" + this.inGameCenter + ", groupId=" + this.groupId + ", is1V1=" + this.is1V1 + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.gameType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.icon);
        dest.writeString(this.bannerUrl);
        Boolean bool = this.isFull;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Double d = this.rate;
        if (d == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeDouble(d.doubleValue());
        }
        dest.writeString(this.themeColor);
        dest.writeString(this.title);
        dest.writeString(this.url);
        Integer num2 = this.gameId;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.startColor);
        dest.writeString(this.endColor);
        dest.writeString(this.desc);
        ArrayList<Integer> arrayList = this.modes;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        Boolean bool2 = this.inGameCenter;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.groupId);
        Boolean bool3 = this.is1V1;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    public GameConfiguration(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Double d, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable ArrayList<Integer> arrayList, @Nullable Boolean bool2, @Nullable String str9, @Nullable Boolean bool3) {
        this.gameType = num;
        this.icon = str;
        this.bannerUrl = str2;
        this.isFull = bool;
        this.rate = d;
        this.themeColor = str3;
        this.title = str4;
        this.url = str5;
        this.gameId = num2;
        this.startColor = str6;
        this.endColor = str7;
        this.desc = str8;
        this.modes = arrayList;
        this.inGameCenter = bool2;
        this.groupId = str9;
        this.is1V1 = bool3;
    }

    public /* synthetic */ GameConfiguration(Integer num, String str, String str2, Boolean bool, Double d, String str3, String str4, String str5, Integer num2, String str6, String str7, String str8, ArrayList arrayList, Boolean bool2, String str9, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : str6, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : arrayList, (i & 8192) != 0 ? Boolean.FALSE : bool2, (i & 16384) != 0 ? null : str9, (i & 32768) != 0 ? Boolean.FALSE : bool3);
    }
}
