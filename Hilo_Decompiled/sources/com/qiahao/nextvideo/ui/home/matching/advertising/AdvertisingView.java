package com.qiahao.nextvideo.ui.home.matching.advertising;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ActivityIngResponseBean;
import com.qiahao.nextvideo.data.model.ActivityIngResponseBeanItem;
import com.qiahao.nextvideo.databinding.ViewAdvertisingBinding;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.BannerViewPager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewAdvertisingBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewAdvertisingBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewAdvertisingBinding;)V", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBeanItem;", "advertisingPagerAdapter", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapter;", "getAdvertisingPagerAdapter", "()Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapter;", "advertisingPagerAdapter$delegate", "Lkotlin/Lazy;", "mAdvertisingLister", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingLister;", "getMAdvertisingLister", "()Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingLister;", "setMAdvertisingLister", "(Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingLister;)V", "setAdvertisingViewListener", "", "listener", "initView", "setData", "activityIngResponseBean", "Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBean;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AdvertisingView extends LinearLayoutCompat {

    @NotNull
    private static final String TAG = "AdvertisingView";

    /* renamed from: advertisingPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy advertisingPagerAdapter;
    public ViewAdvertisingBinding binding;
    public AdvertisingLister mAdvertisingLister;
    private BannerViewPager<ActivityIngResponseBeanItem> mViewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvertisingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.advertisingPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.b
            public final Object invoke() {
                AdvertisingPagerAdapter advertisingPagerAdapter_delegate$lambda$0;
                advertisingPagerAdapter_delegate$lambda$0 = AdvertisingView.advertisingPagerAdapter_delegate$lambda$0();
                return advertisingPagerAdapter_delegate$lambda$0;
            }
        });
        initView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdvertisingPagerAdapter advertisingPagerAdapter_delegate$lambda$0() {
        return new AdvertisingPagerAdapter();
    }

    private final AdvertisingPagerAdapter getAdvertisingPagerAdapter() {
        return (AdvertisingPagerAdapter) this.advertisingPagerAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(Context context) {
        setBinding((ViewAdvertisingBinding) g.h(LayoutInflater.from(context), R.layout.view_advertising, this, true));
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager = getBinding().bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.ActivityIngResponseBeanItem>");
        this.mViewPager = bannerViewPager;
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        AdvertisingPagerAdapter advertisingPagerAdapter = getAdvertisingPagerAdapter();
        advertisingPagerAdapter.setOnChildClickListener(new AdvertisingPagerAdapterListener() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.AdvertisingView$initView$1$1
            @Override // com.qiahao.nextvideo.ui.home.matching.advertising.AdvertisingPagerAdapterListener
            public void click(ActivityIngResponseBeanItem data) {
                Intrinsics.checkNotNullParameter(data, "data");
                AdvertisingView.this.getMAdvertisingLister().openWebView(data.getUrl());
            }
        });
        bannerViewPager.G(advertisingPagerAdapter);
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager3 = this.mViewPager;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager3 = null;
        }
        bannerViewPager3.S(HonorResultCode.ADVANCED_RECORD_SUCCESS);
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager4 = this.mViewPager;
        if (bannerViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager4 = null;
        }
        bannerViewPager4.c0(200);
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager5 = this.mViewPager;
        if (bannerViewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager2 = bannerViewPager5;
        }
        bannerViewPager2.g();
    }

    @NotNull
    public final ViewAdvertisingBinding getBinding() {
        ViewAdvertisingBinding viewAdvertisingBinding = this.binding;
        if (viewAdvertisingBinding != null) {
            return viewAdvertisingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final AdvertisingLister getMAdvertisingLister() {
        AdvertisingLister advertisingLister = this.mAdvertisingLister;
        if (advertisingLister != null) {
            return advertisingLister;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdvertisingLister");
        return null;
    }

    public final void setAdvertisingViewListener(@NotNull AdvertisingLister listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setMAdvertisingLister(listener);
    }

    public final void setBinding(@NotNull ViewAdvertisingBinding viewAdvertisingBinding) {
        Intrinsics.checkNotNullParameter(viewAdvertisingBinding, "<set-?>");
        this.binding = viewAdvertisingBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setData(@NotNull ActivityIngResponseBean activityIngResponseBean) {
        Intrinsics.checkNotNullParameter(activityIngResponseBean, "activityIngResponseBean");
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager = this.mViewPager;
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager2 = null;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        bannerViewPager.L(4).P(4).N(dd.a.a(6.0f)).K(dd.a.a(6.0f)).M(androidx.core.content.a.getColor(getContext(), 2131100055), androidx.core.content.a.getColor(getContext(), 2131100060)).Q(getBinding().indicatorView).O(dd.a.a(6.0f), dd.a.a(10.0f));
        BannerViewPager<ActivityIngResponseBeanItem> bannerViewPager3 = this.mViewPager;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.C(activityIngResponseBean);
    }

    public final void setMAdvertisingLister(@NotNull AdvertisingLister advertisingLister) {
        Intrinsics.checkNotNullParameter(advertisingLister, "<set-?>");
        this.mAdvertisingLister = advertisingLister;
    }
}
