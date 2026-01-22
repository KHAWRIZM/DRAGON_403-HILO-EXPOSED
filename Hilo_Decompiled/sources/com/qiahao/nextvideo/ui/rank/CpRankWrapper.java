package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.nextvideo.databinding.ViewCpRankParentBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001c\u0010\u000eR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpRankWrapper;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Landroid/content/Context;", "context", "", "mPosition", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "viewController", "<init>", "(Landroid/content/Context;ILcom/qiahao/nextvideo/ui/rank/CpRankViewController;)V", "", "initView", "()V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "onAttachedToWindow", "onDetachedFromWindow", "I", "getMPosition", "()I", "setMPosition", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/databinding/ViewCpRankParentBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewCpRankParentBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewCpRankParentBinding;", "", "isInitView", "Z", "()Z", "setInitView", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankWrapper extends FrameLayout implements ViewPager.j, o6.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "CpRankWrapper";

    @NotNull
    private final ViewCpRankParentBinding binding;
    private boolean isInitView;
    private int mPosition;

    @NotNull
    private final ArrayList<View> pageViews;

    @NotNull
    private final CpRankViewController viewController;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpRankWrapper$Companion;", "", "<init>", "()V", "TAG", "", "init", "Lcom/qiahao/nextvideo/ui/rank/CpRankWrapper;", "mPosition", "", "viewController", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CpRankWrapper init(int mPosition, @NotNull CpRankViewController viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            Log.d(CpRankWrapper.TAG, "init: ");
            return new CpRankWrapper(viewController.getRequireContext(), mPosition, viewController);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CpRankWrapper(Context context, int i, CpRankViewController cpRankViewController, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i, cpRankViewController);
    }

    @NotNull
    public final ViewCpRankParentBinding getBinding() {
        return this.binding;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    @NotNull
    public final CpRankViewController getViewController() {
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
        arrayList.add(new CpRankChildWrapper(context, this.viewController, "day"));
        ArrayList<View> arrayList2 = this.pageViews;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        arrayList2.add(new CpRankChildWrapper(context2, this.viewController, "week"));
        ArrayList<View> arrayList3 = this.pageViews;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        arrayList3.add(new CpRankChildWrapper(context3, this.viewController, "month"));
        ArrayList<View> arrayList4 = this.pageViews;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        arrayList4.add(new CpRankChildWrapper(context4, this.viewController, "all"));
        this.binding.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        this.binding.viewPager.setOffscreenPageLimit(this.pageViews.size());
        this.binding.viewPager.setCurrentItem(this.mPosition);
        this.binding.viewPager.addOnPageChangeListener(this);
        this.binding.segmentTabLayout.setTabData(new String[]{BaseViewControllerKt.getString(this.viewController, 2131952477, new Object[0]), BaseViewControllerKt.getString(this.viewController, 2131954482, new Object[0]), BaseViewControllerKt.getString(this.viewController, 2131953415, new Object[0]), BaseViewControllerKt.getString(this.viewController, 2131954295, new Object[0])});
        this.binding.segmentTabLayout.setCurrentTab(this.mPosition);
        View view = this.pageViews.get(this.mPosition);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CpRankChildWrapper");
        ((CpRankChildWrapper) view).getFirstData();
        this.binding.segmentTabLayout.setOnTabSelectListener(this);
    }

    /* renamed from: isInitView, reason: from getter */
    public final boolean getIsInitView() {
        return this.isInitView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow: -------------");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow: -------------");
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        View view = this.pageViews.get(position);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CpRankChildWrapper");
        ((CpRankChildWrapper) view).getFirstData();
        this.mPosition = position;
        this.binding.segmentTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        this.mPosition = position;
        this.binding.viewPager.setCurrentItem(position);
    }

    public final void setInitView(boolean z) {
        this.isInitView = z;
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpRankWrapper(@NotNull Context context, int i, @NotNull CpRankViewController cpRankViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cpRankViewController, "viewController");
        this.mPosition = i;
        this.viewController = cpRankViewController;
        this.pageViews = new ArrayList<>();
        ViewCpRankParentBinding inflate = ViewCpRankParentBinding.inflate(LayoutInflater.from(cpRankViewController.getRequireContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }
}
