package com.qiahao.nextvideo.ui.home;

import androidx.annotation.Keep;
import com.qiahao.nextvideo.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010!R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010!¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/HomeFeedTabUIModel;", "Lo6/a;", "", "title", "", "selectedIcon", "unSelectedIcon", "<init>", "(Ljava/lang/String;II)V", "getTabTitle", "()Ljava/lang/String;", "getTabSelectedIcon", "()I", "getTabUnselectedIcon", "component1", "component2", "component3", "copy", "(Ljava/lang/String;II)Lcom/qiahao/nextvideo/ui/home/HomeFeedTabUIModel;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "I", "getSelectedIcon", "setSelectedIcon", "(I)V", "getUnSelectedIcon", "setUnSelectedIcon", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HomeFeedTabUIModel implements o6.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int selectedIcon;

    @NotNull
    private String title;
    private int unSelectedIcon;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/HomeFeedTabUIModel$Companion;", "", "<init>", "()V", "", "randomTabName", "chatTabName", "gameTabName", "groupTabName", "Ljava/util/ArrayList;", "Lo6/a;", "Lkotlin/collections/ArrayList;", "init", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nUIModels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIModels.kt\ncom/qiahao/nextvideo/ui/home/HomeFeedTabUIModel$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,64:1\n13537#2,3:65\n*S KotlinDebug\n*F\n+ 1 UIModels.kt\ncom/qiahao/nextvideo/ui/home/HomeFeedTabUIModel$Companion\n*L\n39#1:65,3\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<o6.a> init(@NotNull String randomTabName, @NotNull String chatTabName, @NotNull String gameTabName, @NotNull String groupTabName) {
            Intrinsics.checkNotNullParameter(randomTabName, "randomTabName");
            Intrinsics.checkNotNullParameter(chatTabName, "chatTabName");
            Intrinsics.checkNotNullParameter(gameTabName, "gameTabName");
            Intrinsics.checkNotNullParameter(groupTabName, "groupTabName");
            String[] strArr = {randomTabName, groupTabName, gameTabName, chatTabName};
            int i = 0;
            Integer[] numArr = {Integer.valueOf(R.drawable.icon_random_selected), Integer.valueOf(R.drawable.icon_group_selected), Integer.valueOf(R.drawable.icon_game_selected), Integer.valueOf(R.drawable.icon_chat_selected)};
            Integer[] numArr2 = {Integer.valueOf(R.drawable.icon_random_unselected), Integer.valueOf(R.drawable.icon_group_unselected), Integer.valueOf(R.drawable.icon_game_unselected), Integer.valueOf(R.drawable.icon_chat_unselected)};
            ArrayList<o6.a> arrayList = new ArrayList<>();
            int i2 = 0;
            while (i < 4) {
                arrayList.add(new HomeFeedTabUIModel(strArr[i], numArr[i2].intValue(), numArr2[i2].intValue()));
                i++;
                i2++;
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public HomeFeedTabUIModel(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.selectedIcon = i;
        this.unSelectedIcon = i2;
    }

    public static /* synthetic */ HomeFeedTabUIModel copy$default(HomeFeedTabUIModel homeFeedTabUIModel, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = homeFeedTabUIModel.title;
        }
        if ((i3 & 2) != 0) {
            i = homeFeedTabUIModel.selectedIcon;
        }
        if ((i3 & 4) != 0) {
            i2 = homeFeedTabUIModel.unSelectedIcon;
        }
        return homeFeedTabUIModel.copy(str, i, i2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSelectedIcon() {
        return this.selectedIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUnSelectedIcon() {
        return this.unSelectedIcon;
    }

    @NotNull
    public final HomeFeedTabUIModel copy(@NotNull String title, int selectedIcon, int unSelectedIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new HomeFeedTabUIModel(title, selectedIcon, unSelectedIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeFeedTabUIModel)) {
            return false;
        }
        HomeFeedTabUIModel homeFeedTabUIModel = (HomeFeedTabUIModel) other;
        return Intrinsics.areEqual(this.title, homeFeedTabUIModel.title) && this.selectedIcon == homeFeedTabUIModel.selectedIcon && this.unSelectedIcon == homeFeedTabUIModel.unSelectedIcon;
    }

    public final int getSelectedIcon() {
        return this.selectedIcon;
    }

    public int getTabSelectedIcon() {
        return this.selectedIcon;
    }

    @NotNull
    public String getTabTitle() {
        return this.title;
    }

    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getUnSelectedIcon() {
        return this.unSelectedIcon;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.selectedIcon) * 31) + this.unSelectedIcon;
    }

    public final void setSelectedIcon(int i) {
        this.selectedIcon = i;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUnSelectedIcon(int i) {
        this.unSelectedIcon = i;
    }

    @NotNull
    public String toString() {
        return "HomeFeedTabUIModel(title=" + this.title + ", selectedIcon=" + this.selectedIcon + ", unSelectedIcon=" + this.unSelectedIcon + ")";
    }
}
