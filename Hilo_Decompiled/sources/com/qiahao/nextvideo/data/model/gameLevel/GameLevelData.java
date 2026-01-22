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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelData;", "Landroid/os/Parcelable;", "cards", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;", "Lkotlin/collections/ArrayList;", "userLevel", "Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "<init>", "(Ljava/util/ArrayList;Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;)V", "getCards", "()Ljava/util/ArrayList;", "setCards", "(Ljava/util/ArrayList;)V", "getUserLevel", "()Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "setUserLevel", "(Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameLevelData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameLevelData> CREATOR = new Creator();

    @Nullable
    private ArrayList<GameLevelCard> cards;

    @Nullable
    private UserGameLevel userLevel;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameLevelData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameLevelData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(GameLevelCard.CREATOR.createFromParcel(parcel));
                }
            }
            return new GameLevelData(arrayList, parcel.readInt() != 0 ? UserGameLevel.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameLevelData[] newArray(int i) {
            return new GameLevelData[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameLevelData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameLevelData copy$default(GameLevelData gameLevelData, ArrayList arrayList, UserGameLevel userGameLevel, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = gameLevelData.cards;
        }
        if ((i & 2) != 0) {
            userGameLevel = gameLevelData.userLevel;
        }
        return gameLevelData.copy(arrayList, userGameLevel);
    }

    @Nullable
    public final ArrayList<GameLevelCard> component1() {
        return this.cards;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final UserGameLevel getUserLevel() {
        return this.userLevel;
    }

    @NotNull
    public final GameLevelData copy(@Nullable ArrayList<GameLevelCard> cards, @Nullable UserGameLevel userLevel) {
        return new GameLevelData(cards, userLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameLevelData)) {
            return false;
        }
        GameLevelData gameLevelData = (GameLevelData) other;
        return Intrinsics.areEqual(this.cards, gameLevelData.cards) && Intrinsics.areEqual(this.userLevel, gameLevelData.userLevel);
    }

    @Nullable
    public final ArrayList<GameLevelCard> getCards() {
        return this.cards;
    }

    @Nullable
    public final UserGameLevel getUserLevel() {
        return this.userLevel;
    }

    public int hashCode() {
        ArrayList<GameLevelCard> arrayList = this.cards;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        UserGameLevel userGameLevel = this.userLevel;
        return hashCode + (userGameLevel != null ? userGameLevel.hashCode() : 0);
    }

    public final void setCards(@Nullable ArrayList<GameLevelCard> arrayList) {
        this.cards = arrayList;
    }

    public final void setUserLevel(@Nullable UserGameLevel userGameLevel) {
        this.userLevel = userGameLevel;
    }

    @NotNull
    public String toString() {
        return "GameLevelData(cards=" + this.cards + ", userLevel=" + this.userLevel + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArrayList<GameLevelCard> arrayList = this.cards;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<GameLevelCard> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        UserGameLevel userGameLevel = this.userLevel;
        if (userGameLevel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userGameLevel.writeToParcel(dest, flags);
        }
    }

    public GameLevelData(@Nullable ArrayList<GameLevelCard> arrayList, @Nullable UserGameLevel userGameLevel) {
        this.cards = arrayList;
        this.userLevel = userGameLevel;
    }

    public /* synthetic */ GameLevelData(ArrayList arrayList, UserGameLevel userGameLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : userGameLevel);
    }
}
