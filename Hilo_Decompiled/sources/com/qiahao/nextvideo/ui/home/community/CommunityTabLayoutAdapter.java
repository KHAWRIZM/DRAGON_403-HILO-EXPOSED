package com.qiahao.nextvideo.ui.home.community;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.oudi.utils.ColorUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.databinding.LayoutCustomCommunityTabItemBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016R+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/community/CommunityTabLayoutAdapter;", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "<init>", "()V", "tabList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;", "Lkotlin/collections/ArrayList;", "getTabList", "()Ljava/util/ArrayList;", "tabList$delegate", "Lkotlin/Lazy;", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "onTabUnSelected2", "selectPosition", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommunityTabLayoutAdapter implements CustomTabLayout.CustomTabAdapter {

    /* renamed from: tabList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabList = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.community.a
        public final Object invoke() {
            ArrayList tabList_delegate$lambda$1;
            tabList_delegate$lambda$1 = CommunityTabLayoutAdapter.tabList_delegate$lambda$1();
            return tabList_delegate$lambda$1;
        }
    });

    private final ArrayList<CommunityTabData> getTabList() {
        return (ArrayList) this.tabList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList tabList_delegate$lambda$1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommunityTabData(ResourcesKtxKt.getStringById(arrayList, 2131952760), "#ffffff", "#80ffffff"));
        arrayList.add(new CommunityTabData(ResourcesKtxKt.getStringById(arrayList, 2131953668), "#ffffff", "#80ffffff"));
        return arrayList;
    }

    @NotNull
    public View getTabView(@NotNull Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommunityTabData communityTabData = getTabList().get(position);
        Intrinsics.checkNotNullExpressionValue(communityTabData, "get(...)");
        return new CommunityTabView(context, communityTabData);
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        CommunityTabView communityTabView;
        LayoutCustomCommunityTabItemBinding binding;
        TextView textView;
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabSelected(this, position, tabView);
        if (tabView instanceof CommunityTabView) {
            communityTabView = (CommunityTabView) tabView;
        } else {
            communityTabView = null;
        }
        if (communityTabView != null && (binding = communityTabView.getBinding()) != null && (textView = binding.title) != null) {
            textView.setTextColor(ColorUtils.string2Int("#ffffff"));
        }
    }

    public void onTabUnSelected2(int position, @Nullable View tabView, int selectPosition) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, position, tabView, selectPosition);
    }

    public void onTabUnselected(int position, @Nullable View tabView) {
        CommunityTabView communityTabView;
        LayoutCustomCommunityTabItemBinding binding;
        TextView textView;
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, position, tabView);
        if (tabView instanceof CommunityTabView) {
            communityTabView = (CommunityTabView) tabView;
        } else {
            communityTabView = null;
        }
        if (communityTabView != null && (binding = communityTabView.getBinding()) != null && (textView = binding.title) != null) {
            textView.setTextColor(ColorUtils.string2Int("#80ffffff"));
        }
    }
}
