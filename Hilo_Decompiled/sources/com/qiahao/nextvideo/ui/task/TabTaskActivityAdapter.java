package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.view.View;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.data.tab.MainTabData;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016R+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TabTaskActivityAdapter;", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "<init>", "()V", "tabList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/tab/MainTabData;", "Lkotlin/collections/ArrayList;", "getTabList", "()Ljava/util/ArrayList;", "tabList$delegate", "Lkotlin/Lazy;", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TabTaskActivityAdapter implements ViewPage2TabLayout.CustomTabAdapter {

    /* renamed from: tabList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabList = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.m1
        public final Object invoke() {
            ArrayList tabList_delegate$lambda$1;
            tabList_delegate$lambda$1 = TabTaskActivityAdapter.tabList_delegate$lambda$1();
            return tabList_delegate$lambda$1;
        }
    });

    private final ArrayList<MainTabData> getTabList() {
        return (ArrayList) this.tabList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList tabList_delegate$lambda$1() {
        ArrayList arrayList = new ArrayList();
        MainTabData.Companion companion = MainTabData.INSTANCE;
        arrayList.add(companion.initTask(ResourcesKtxKt.getStringById(arrayList, 2131952566)));
        arrayList.add(companion.initTask(ResourcesKtxKt.getStringById(arrayList, 2131952923)));
        return arrayList;
    }

    @NotNull
    public View getTabView(@NotNull Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TaskActivityView(context, getTabList().get(position));
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabSelected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.task.TaskActivityView");
        ((TaskActivityView) tabView).setSelected(true);
    }

    public void onTabUnSelected2(int i, @Nullable View view, int i2) {
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, i, view, i2);
    }

    public void onTabUnselected(int position, @Nullable View tabView) {
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.task.TaskActivityView");
        ((TaskActivityView) tabView).setSelected(false);
    }
}
