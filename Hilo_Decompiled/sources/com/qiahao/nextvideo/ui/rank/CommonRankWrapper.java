package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.databinding.ViewCharmRankParentBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CommonRankWrapper;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Landroid/content/Context;", "context", "", "mLevelType", "Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "viewController", "<init>", "(Landroid/content/Context;ILcom/qiahao/nextvideo/ui/rank/AllRankViewController;)V", "", "initView", "()V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "I", "getMLevelType", "()I", "Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "", "isInitView", "Z", "()Z", "setInitView", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRankWrapper extends FrameLayout implements ViewPager.j, o6.b {
    public static final int CHARM_TYPE = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FAMOUS_TYPE = 1;
    public static final int ROOM_TYPE = 2;

    @NotNull
    private static final String TAG = "CharmRankWrapper";

    @NotNull
    private final ViewCharmRankParentBinding binding;
    private boolean isInitView;
    private final int mLevelType;

    @NotNull
    private final ArrayList<View> pageViews;

    @NotNull
    private final AllRankViewController viewController;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CommonRankWrapper$Companion;", "", "<init>", "()V", "TAG", "", "CHARM_TYPE", "", "FAMOUS_TYPE", "ROOM_TYPE", "init", "Lcom/qiahao/nextvideo/ui/rank/CommonRankWrapper;", "type", "viewController", "Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommonRankWrapper init(int type, @NotNull AllRankViewController viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            Log.d(CommonRankWrapper.TAG, "init: ");
            return new CommonRankWrapper(viewController.getRequireContext(), type, viewController);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRankWrapper(@NotNull Context context, int i, @NotNull AllRankViewController allRankViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(allRankViewController, "viewController");
        this.mLevelType = i;
        this.viewController = allRankViewController;
        this.pageViews = new ArrayList<>();
        ViewCharmRankParentBinding inflate = ViewCharmRankParentBinding.inflate(LayoutInflater.from(allRankViewController.getRequireContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    @NotNull
    public final ViewCharmRankParentBinding getBinding() {
        return this.binding;
    }

    public final int getMLevelType() {
        return this.mLevelType;
    }

    @NotNull
    public final AllRankViewController getViewController() {
        return this.viewController;
    }

    public final void initView() {
        if (this.isInitView) {
            return;
        }
        this.isInitView = true;
        ArrayList<View> arrayList = this.pageViews;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        arrayList.add(new CommonRankChildWrapper(context, this.viewController, this.mLevelType, "day"));
        ArrayList<View> arrayList2 = this.pageViews;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        arrayList2.add(new CommonRankChildWrapper(context2, this.viewController, this.mLevelType, "week"));
        ArrayList<View> arrayList3 = this.pageViews;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        arrayList3.add(new CommonRankChildWrapper(context3, this.viewController, this.mLevelType, "month"));
        this.binding.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        this.binding.viewPager.setCurrentItem(0);
        this.binding.viewPager.addOnPageChangeListener(this);
        this.binding.segmentTabLayout.setTabData(new String[]{ResourcesKtxKt.getStringById(this, 2131952477), ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)});
        this.binding.segmentTabLayout.setCurrentTab(0);
        View view = this.pageViews.get(0);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CommonRankChildWrapper");
        ((CommonRankChildWrapper) view).getFirstData();
        this.binding.segmentTabLayout.setOnTabSelectListener(this);
        int i = this.mLevelType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.binding.segmentTabLayout.setTextSelectColor(Color.parseColor("#7a37ff"));
                    return;
                }
                return;
            }
            this.binding.segmentTabLayout.setTextSelectColor(Color.parseColor("#ffa106"));
            return;
        }
        this.binding.segmentTabLayout.setTextSelectColor(Color.parseColor("#fe7b79"));
    }

    /* renamed from: isInitView, reason: from getter */
    public final boolean getIsInitView() {
        return this.isInitView;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        View view = this.pageViews.get(position);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CommonRankChildWrapper");
        ((CommonRankChildWrapper) view).getFirstData();
        this.binding.segmentTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        this.binding.viewPager.setCurrentItem(position);
    }

    public final void setInitView(boolean z) {
        this.isInitView = z;
    }
}
