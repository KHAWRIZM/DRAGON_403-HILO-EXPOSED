package com.qiahao.nextvideo.data.game;

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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "Landroid/os/Parcelable;", "players", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "Lkotlin/collections/ArrayList;", "ownerId", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getPlayers", "()Ljava/util/ArrayList;", "setPlayers", "(Ljava/util/ArrayList;)V", "getOwnerId", "()Ljava/lang/String;", "setOwnerId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SUDGameAward implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SUDGameAward> CREATOR = new Creator();

    @Nullable
    private String ownerId;

    @Nullable
    private ArrayList<SUDGamePlayerAward> players;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SUDGameAward> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGameAward createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(SUDGamePlayerAward.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SUDGameAward(arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGameAward[] newArray(int i) {
            return new SUDGameAward[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SUDGameAward() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SUDGameAward copy$default(SUDGameAward sUDGameAward, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = sUDGameAward.players;
        }
        if ((i & 2) != 0) {
            str = sUDGameAward.ownerId;
        }
        return sUDGameAward.copy(arrayList, str);
    }

    @Nullable
    public final ArrayList<SUDGamePlayerAward> component1() {
        return this.players;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getOwnerId() {
        return this.ownerId;
    }

    @NotNull
    public final SUDGameAward copy(@Nullable ArrayList<SUDGamePlayerAward> players, @Nullable String ownerId) {
        return new SUDGameAward(players, ownerId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SUDGameAward)) {
            return false;
        }
        SUDGameAward sUDGameAward = (SUDGameAward) other;
        return Intrinsics.areEqual(this.players, sUDGameAward.players) && Intrinsics.areEqual(this.ownerId, sUDGameAward.ownerId);
    }

    @Nullable
    public final String getOwnerId() {
        return this.ownerId;
    }

    @Nullable
    public final ArrayList<SUDGamePlayerAward> getPlayers() {
        return this.players;
    }

    public int hashCode() {
        ArrayList<SUDGamePlayerAward> arrayList = this.players;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.ownerId;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setOwnerId(@Nullable String str) {
        this.ownerId = str;
    }

    public final void setPlayers(@Nullable ArrayList<SUDGamePlayerAward> arrayList) {
        this.players = arrayList;
    }

    @NotNull
    public String toString() {
        return "SUDGameAward(players=" + this.players + ", ownerId=" + this.ownerId + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArrayList<SUDGamePlayerAward> arrayList = this.players;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<SUDGamePlayerAward> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.ownerId);
    }

    public SUDGameAward(@Nullable ArrayList<SUDGamePlayerAward> arrayList, @Nullable String str) {
        this.players = arrayList;
        this.ownerId = str;
    }

    public /* synthetic */ SUDGameAward(ArrayList arrayList, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : str);
    }
}
