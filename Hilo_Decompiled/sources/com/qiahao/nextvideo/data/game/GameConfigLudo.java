package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0004J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "Landroid/os/Parcelable;", ExchangeDetailActivity.TYPE_DIAMOND, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "showBetModule", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "getDiamond", "()Ljava/util/ArrayList;", "setDiamond", "(Ljava/util/ArrayList;)V", "getShowBetModule", "()Ljava/lang/Boolean;", "setShowBetModule", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/ArrayList;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameConfigLudo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GameConfigLudo> CREATOR = new Creator();

    @Nullable
    private ArrayList<Integer> diamond;

    @Nullable
    private Boolean showBetModule;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GameConfigLudo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfigLudo createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                }
            }
            return new GameConfigLudo(arrayList, parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GameConfigLudo[] newArray(int i) {
            return new GameConfigLudo[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GameConfigLudo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameConfigLudo copy$default(GameConfigLudo gameConfigLudo, ArrayList arrayList, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = gameConfigLudo.diamond;
        }
        if ((i & 2) != 0) {
            bool = gameConfigLudo.showBetModule;
        }
        return gameConfigLudo.copy(arrayList, bool);
    }

    @Nullable
    public final ArrayList<Integer> component1() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getShowBetModule() {
        return this.showBetModule;
    }

    @NotNull
    public final GameConfigLudo copy(@Nullable ArrayList<Integer> diamond, @Nullable Boolean showBetModule) {
        return new GameConfigLudo(diamond, showBetModule);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameConfigLudo)) {
            return false;
        }
        GameConfigLudo gameConfigLudo = (GameConfigLudo) other;
        return Intrinsics.areEqual(this.diamond, gameConfigLudo.diamond) && Intrinsics.areEqual(this.showBetModule, gameConfigLudo.showBetModule);
    }

    @Nullable
    public final ArrayList<Integer> getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Boolean getShowBetModule() {
        return this.showBetModule;
    }

    public int hashCode() {
        ArrayList<Integer> arrayList = this.diamond;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Boolean bool = this.showBetModule;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final void setDiamond(@Nullable ArrayList<Integer> arrayList) {
        this.diamond = arrayList;
    }

    public final void setShowBetModule(@Nullable Boolean bool) {
        this.showBetModule = bool;
    }

    @NotNull
    public String toString() {
        return "GameConfigLudo(diamond=" + this.diamond + ", showBetModule=" + this.showBetModule + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArrayList<Integer> arrayList = this.diamond;
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
        Boolean bool = this.showBetModule;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public GameConfigLudo(@Nullable ArrayList<Integer> arrayList, @Nullable Boolean bool) {
        this.diamond = arrayList;
        this.showBetModule = bool;
    }

    public /* synthetic */ GameConfigLudo(ArrayList arrayList, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? Boolean.FALSE : bool);
    }
}
