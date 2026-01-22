package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.databinding.ViewGroupBannerBinding;
import com.zhpan.bannerview.BannerViewPager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#J\b\u0010$\u001a\u00020\u001eH\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GroupBannerView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewGroupBannerBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGroupBannerBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGroupBannerBinding;)V", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "groupBannerPagerAdapter", "Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapter;", "getGroupBannerPagerAdapter", "()Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapter;", "groupBannerPagerAdapter$delegate", "Lkotlin/Lazy;", "mGroupBannerViewLister", "Lcom/qiahao/nextvideo/room/view/GroupBannerViewLister;", "getMGroupBannerViewLister", "()Lcom/qiahao/nextvideo/room/view/GroupBannerViewLister;", "setMGroupBannerViewLister", "(Lcom/qiahao/nextvideo/room/view/GroupBannerViewLister;)V", "setGroupBannerViewLister", "", "listener", "initView", "setData", "groupTopBannerBean", "", "onDetachedFromWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupBannerView extends LinearLayoutCompat {

    @NotNull
    private static final String TAG = "GroupBannerView";
    public ViewGroupBannerBinding binding;

    /* renamed from: groupBannerPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupBannerPagerAdapter;

    @Nullable
    private GroupBannerViewLister mGroupBannerViewLister;
    private BannerViewPager<GroupTopBannerBean> mViewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.groupBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.g
            public final Object invoke() {
                GroupBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$0;
                groupBannerPagerAdapter_delegate$lambda$0 = GroupBannerView.groupBannerPagerAdapter_delegate$lambda$0();
                return groupBannerPagerAdapter_delegate$lambda$0;
            }
        });
        initView(context);
    }

    private final GroupBannerPagerAdapter getGroupBannerPagerAdapter() {
        return (GroupBannerPagerAdapter) this.groupBannerPagerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$0() {
        return new GroupBannerPagerAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(Context context) {
        setBinding((ViewGroupBannerBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_group_banner, this, true));
        BannerViewPager<GroupTopBannerBean> bannerViewPager = getBinding().bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.GroupTopBannerBean>");
        this.mViewPager = bannerViewPager;
        BannerViewPager<GroupTopBannerBean> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        GroupBannerPagerAdapter groupBannerPagerAdapter = getGroupBannerPagerAdapter();
        groupBannerPagerAdapter.setOnChildClickListener(new GroupBannerPagerAdapterListener() { // from class: com.qiahao.nextvideo.room.view.GroupBannerView$initView$1$1
            @Override // com.qiahao.nextvideo.room.view.GroupBannerPagerAdapterListener
            public void click(GroupTopBannerBean data) {
                GroupBannerViewLister mGroupBannerViewLister;
                Intrinsics.checkNotNullParameter(data, "data");
                String actionUrl = data.getActionUrl();
                if (actionUrl != null && (mGroupBannerViewLister = GroupBannerView.this.getMGroupBannerViewLister()) != null) {
                    mGroupBannerViewLister.openWebView(actionUrl);
                }
            }
        });
        bannerViewPager.G(groupBannerPagerAdapter);
        BannerViewPager<GroupTopBannerBean> bannerViewPager3 = this.mViewPager;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.g();
    }

    @NotNull
    public final ViewGroupBannerBinding getBinding() {
        ViewGroupBannerBinding viewGroupBannerBinding = this.binding;
        if (viewGroupBannerBinding != null) {
            return viewGroupBannerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final GroupBannerViewLister getMGroupBannerViewLister() {
        return this.mGroupBannerViewLister;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.mGroupBannerViewLister = null;
    }

    public final void setBinding(@NotNull ViewGroupBannerBinding viewGroupBannerBinding) {
        Intrinsics.checkNotNullParameter(viewGroupBannerBinding, "<set-?>");
        this.binding = viewGroupBannerBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setData(@NotNull List<GroupTopBannerBean> groupTopBannerBean) {
        Intrinsics.checkNotNullParameter(groupTopBannerBean, "groupTopBannerBean");
        BannerViewPager<GroupTopBannerBean> bannerViewPager = this.mViewPager;
        BannerViewPager<GroupTopBannerBean> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        bannerViewPager.L(4).P(4).N(dd.a.a(4.0f)).K(dd.a.a(4.0f)).M(androidx.core.content.a.getColor(getContext(), 2131100055), androidx.core.content.a.getColor(getContext(), 2131100060)).Q(getBinding().indicatorView).O(dd.a.a(4.0f), dd.a.a(8.0f));
        BannerViewPager<GroupTopBannerBean> bannerViewPager3 = this.mViewPager;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.C(groupTopBannerBean);
    }

    public final void setGroupBannerViewLister(@NotNull GroupBannerViewLister listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mGroupBannerViewLister = listener;
    }

    public final void setMGroupBannerViewLister(@Nullable GroupBannerViewLister groupBannerViewLister) {
        this.mGroupBannerViewLister = groupBannerViewLister;
    }
}
