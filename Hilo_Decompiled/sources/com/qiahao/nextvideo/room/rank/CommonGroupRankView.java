package com.qiahao.nextvideo.room.rank;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.nextvideo.databinding.ViewCharmRankParentBinding;
import com.qiahao.nextvideo.ui.rank.CommonViewPagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001c\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonGroupRankView;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Landroid/content/Context;", "mContext", "", "mLevelType", "", "mGroupId", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "", "initView", "()V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "I", "getMLevelType", "()I", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewCharmRankParentBinding;", "", "isInitView", "Z", "()Z", "setInitView", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonGroupRankView extends FrameLayout implements ViewPager.j, o6.b {
    public static final int CHARM_TYPE = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FAMOUS_TYPE = 1;

    @NotNull
    private static final String TAG = "CharmRankWrapper";

    @NotNull
    private final ViewCharmRankParentBinding binding;
    private boolean isInitView;

    @NotNull
    private final Context mContext;

    @NotNull
    private final String mGroupId;
    private final int mLevelType;

    @NotNull
    private final ArrayList<View> pageViews;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonGroupRankView$Companion;", "", "<init>", "()V", "TAG", "", "CHARM_TYPE", "", "FAMOUS_TYPE", "init", "Lcom/qiahao/nextvideo/room/rank/CommonGroupRankView;", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/qiahao/nextvideo/room/rank/GroupAllRankActivity;", "type", "groupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final CommonGroupRankView init(@NotNull GroupAllRankActivity activity, int type, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Log.d(CommonGroupRankView.TAG, "init: ");
            return new CommonGroupRankView(activity, type, groupId);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonGroupRankView(@NotNull Context context, int i, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        this.mContext = context;
        this.mLevelType = i;
        this.mGroupId = str;
        this.pageViews = new ArrayList<>();
        ViewCharmRankParentBinding inflate = ViewCharmRankParentBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    @NotNull
    public final ViewCharmRankParentBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMLevelType() {
        return this.mLevelType;
    }

    public final void initView() {
        if (this.isInitView) {
            return;
        }
        this.isInitView = true;
        this.pageViews.add(new CommonGroupRankChildView(this.mContext, this.mLevelType, "day", this.mGroupId));
        this.pageViews.add(new CommonGroupRankChildView(this.mContext, this.mLevelType, "week", this.mGroupId));
        this.pageViews.add(new CommonGroupRankChildView(this.mContext, this.mLevelType, "month", this.mGroupId));
        this.binding.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        this.binding.viewPager.setOffscreenPageLimit(this.pageViews.size());
        this.binding.viewPager.setCurrentItem(0);
        this.binding.viewPager.addOnPageChangeListener(this);
        this.binding.segmentTabLayout.setTabData(new String[]{this.mContext.getString(2131952477), this.mContext.getString(2131954482), this.mContext.getString(2131953415)});
        this.binding.segmentTabLayout.setCurrentTab(0);
        View view = this.pageViews.get(0);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonGroupRankChildView");
        ((CommonGroupRankChildView) view).getFirstData();
        this.binding.segmentTabLayout.setOnTabSelectListener(this);
        this.binding.segmentTabLayout.setTextSelectColor(Color.parseColor("#7a37ff"));
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
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonGroupRankChildView");
        ((CommonGroupRankChildView) view).getFirstData();
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
