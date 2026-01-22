package com.qiahao.nextvideo.ui.home.tab;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.tab.MainTabData;
import com.qiahao.nextvideo.databinding.BaseLayoutCustomTabItemBinding;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.ui.home.tab.MainTabLayoutAdapter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0002R+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/tab/MainTabLayoutAdapter;", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "<init>", "()V", "titleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTitleList", "()Ljava/util/ArrayList;", "titleList$delegate", "Lkotlin/Lazy;", "tabList", "Lcom/qiahao/nextvideo/data/tab/MainTabData;", "getTabList", "tabList$delegate", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "onTabUnSelected2", "selectPosition", "setTabPosition", "mainTabBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainTabLayoutAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainTabLayoutAdapter.kt\ncom/qiahao/nextvideo/ui/home/tab/MainTabLayoutAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainTabLayoutAdapter implements CustomTabLayout.CustomTabAdapter {

    /* renamed from: titleList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleList = LazyKt.lazy(new Function0() { // from class: sb.a
        public final Object invoke() {
            ArrayList titleList_delegate$lambda$1;
            titleList_delegate$lambda$1 = MainTabLayoutAdapter.titleList_delegate$lambda$1();
            return titleList_delegate$lambda$1;
        }
    });

    /* renamed from: tabList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabList = LazyKt.lazy(new Function0() { // from class: sb.b
        public final Object invoke() {
            ArrayList tabList_delegate$lambda$5;
            tabList_delegate$lambda$5 = MainTabLayoutAdapter.tabList_delegate$lambda$5(MainTabLayoutAdapter.this);
            return tabList_delegate$lambda$5;
        }
    });

    private final ArrayList<MainTabData> getTabList() {
        return (ArrayList) this.tabList.getValue();
    }

    private final ArrayList<String> getTitleList() {
        return (ArrayList) this.titleList.getValue();
    }

    private final MainTabData setTabPosition(int position, MainTabData mainTabBean) {
        getTabList().set(position, mainTabBean);
        return mainTabBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList tabList_delegate$lambda$5(MainTabLayoutAdapter mainTabLayoutAdapter) {
        MainTabData initTabData;
        ArrayList arrayList = new ArrayList();
        if (SkinMessage.INSTANCE.checkSkin()) {
            for (int i = 0; i < 5; i++) {
                SkinData skinData = SkinMessage.INSTANCE.skinData();
                if (skinData != null && (initTabData = MainTabData.INSTANCE.initTabData(skinData, mainTabLayoutAdapter.getTitleList().get(i), i)) != null) {
                    arrayList.add(initTabData);
                }
            }
        } else {
            arrayList.add(new MainTabData("#ffffff", "#999999", ResourcesKtxKt.getStringById(arrayList, 2131953324), Integer.valueOf(R.drawable.icon_random_selected), Integer.valueOf(R.drawable.icon_random_unselected), null, null, null, false, 480, null));
            MainTabData.Companion companion = MainTabData.INSTANCE;
            arrayList.add(companion.initDefault(ResourcesKtxKt.getStringById(arrayList, 2131952939), Integer.valueOf(R.drawable.icon_group_selected), Integer.valueOf(R.drawable.icon_group_unselected), Integer.valueOf(R.drawable.icon_random_unselected_group)));
            arrayList.add(companion.initDefault(ResourcesKtxKt.getStringById(arrayList, 2131951971), Integer.valueOf(R.drawable.icon_game_selected), Integer.valueOf(R.drawable.icon_game_unselected), Integer.valueOf(R.drawable.icon_random_unselected_game)));
            arrayList.add(companion.initDefault(ResourcesKtxKt.getStringById(arrayList, 2131953668), Integer.valueOf(R.drawable.home_community_selected), Integer.valueOf(R.drawable.home_community_unselected), Integer.valueOf(R.drawable.home_community_unselected_special)));
            arrayList.add(companion.initDefault(ResourcesKtxKt.getStringById(arrayList, 2131952208), Integer.valueOf(R.drawable.icon_chat_selected), Integer.valueOf(R.drawable.icon_chat_unselected), Integer.valueOf(R.drawable.icon_random_unselected_message)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList titleList_delegate$lambda$1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131953324));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131952939));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131951971));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131953668));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131952208));
        return arrayList;
    }

    @NotNull
    public View getTabView(@NotNull Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        MainTabData mainTabData = getTabList().get(position);
        Intrinsics.checkNotNullExpressionValue(mainTabData, "get(...)");
        return new MainTabView(context, mainTabData);
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        ImageView imageView;
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabSelected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.home.tab.MainTabView");
        MainTabView mainTabView = (MainTabView) tabView;
        mainTabView.setSelected(true);
        BaseLayoutCustomTabItemBinding binding = mainTabView.getBinding();
        if (binding != null && (imageView = binding.ivIcon) != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(mainTabView.getContext(), R.anim.main_tab_in);
            loadAnimation.setFillAfter(true);
            loadAnimation.setDuration(150L);
            imageView.startAnimation(loadAnimation);
        }
    }

    public void onTabUnSelected2(int position, @Nullable View tabView, int selectPosition) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, position, tabView, selectPosition);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.home.tab.MainTabView");
        MainTabView mainTabView = (MainTabView) tabView;
        mainTabView.setMSelectPosition(selectPosition);
        mainTabView.setSelected(false);
    }

    public void onTabUnselected(int position, @Nullable View tabView) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.home.tab.MainTabView");
        ((MainTabView) tabView).setSelected(false);
    }
}
