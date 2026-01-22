package com.qiahao.nextvideo.room.rank;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.databinding.ViewActiveRankParentBinding;
import com.qiahao.nextvideo.ui.rank.CommonViewPagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0017\u0010&\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveView;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Landroid/content/Context;", "mContext", "", "mGroupId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "initView", "()V", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/databinding/ViewActiveRankParentBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewActiveRankParentBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewActiveRankParentBinding;", "", "isInitView", "Z", "()Z", "setInitView", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRoomActiveView extends FrameLayout implements ViewPager.j, o6.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final ViewActiveRankParentBinding binding;
    private boolean isInitView;

    @NotNull
    private final Context mContext;

    @NotNull
    private final String mGroupId;

    @NotNull
    private final ArrayList<View> pageViews;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveView$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveView;", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/qiahao/nextvideo/room/rank/GroupAllRankActivity;", "groupId", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final CommonRoomActiveView init(@NotNull GroupAllRankActivity activity, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            return new CommonRoomActiveView(activity, groupId);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRoomActiveView(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        this.mContext = context;
        this.mGroupId = str;
        this.pageViews = new ArrayList<>();
        ViewActiveRankParentBinding inflate = ViewActiveRankParentBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
    }

    @NotNull
    public final ViewActiveRankParentBinding getBinding() {
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

    public final void initView() {
        if (this.isInitView) {
            return;
        }
        this.isInitView = true;
        this.pageViews.add(new CommonRoomActiveChildView(this.mContext, CommonRoomActiveChildView.THIS_WEEK, this.mGroupId));
        this.pageViews.add(new CommonRoomActiveChildView(this.mContext, CommonRoomActiveChildView.LAST_WEEK, this.mGroupId));
        this.binding.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        this.binding.viewPager.setOffscreenPageLimit(this.pageViews.size());
        this.binding.viewPager.setCurrentItem(0);
        this.binding.viewPager.addOnPageChangeListener(this);
        this.binding.segmentTabLayout.setTabData(new String[]{ResourcesKtxKt.getStringById(this, 2131952462), ResourcesKtxKt.getStringById(this, 2131953196)});
        this.binding.segmentTabLayout.setCurrentTab(0);
        View view = this.pageViews.get(0);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonRoomActiveChildView");
        ((CommonRoomActiveChildView) view).getFirstData();
        this.binding.segmentTabLayout.setOnTabSelectListener(this);
        this.binding.segmentTabLayout.setTextSelectColor(Color.parseColor("#7a37ff"));
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
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonRoomActiveChildView");
        ((CommonRoomActiveChildView) view).getFirstData();
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
