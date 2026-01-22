package com.qiahao.nextvideo.ui.home.matching.advertising;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.databinding.ViewPopularBinding;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.BannerViewPager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/advertising/PopularView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "listener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewPopularBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewPopularBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewPopularBinding;)V", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/PopularViewAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/matching/advertising/PopularViewAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "initView", "setData", "list", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PopularView extends LinearLayoutCompat {
    public ViewPopularBinding binding;

    @Nullable
    private Function1<? super VideoBaseData, Unit> listener;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;
    private BannerViewPager<VideoBaseData> mViewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopularView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.d
            public final Object invoke() {
                PopularViewAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = PopularView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    private final PopularViewAdapter getMAdapter() {
        return (PopularViewAdapter) this.mAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView(Context context) {
        setBinding((ViewPopularBinding) g.h(LayoutInflater.from(context), R.layout.view_popular, this, true));
        BannerViewPager<VideoBaseData> bannerViewPager = getBinding().bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.VideoBaseData>");
        this.mViewPager = bannerViewPager;
        getMAdapter().setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.c
            public final Object invoke(Object obj) {
                Unit initView$lambda$1;
                initView$lambda$1 = PopularView.initView$lambda$1(PopularView.this, (VideoBaseData) obj);
                return initView$lambda$1;
            }
        });
        BannerViewPager<VideoBaseData> bannerViewPager2 = this.mViewPager;
        BannerViewPager<VideoBaseData> bannerViewPager3 = null;
        if (bannerViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager2 = null;
        }
        bannerViewPager2.G(getMAdapter());
        BannerViewPager<VideoBaseData> bannerViewPager4 = this.mViewPager;
        if (bannerViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager4 = null;
        }
        bannerViewPager4.S(HonorResultCode.ADVANCED_RECORD_SUCCESS);
        BannerViewPager<VideoBaseData> bannerViewPager5 = this.mViewPager;
        if (bannerViewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager5 = null;
        }
        bannerViewPager5.c0(200);
        BannerViewPager<VideoBaseData> bannerViewPager6 = this.mViewPager;
        if (bannerViewPager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager3 = bannerViewPager6;
        }
        bannerViewPager3.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(PopularView popularView, VideoBaseData videoBaseData) {
        Intrinsics.checkNotNullParameter(videoBaseData, "data");
        Function1<? super VideoBaseData, Unit> function1 = popularView.listener;
        if (function1 != null) {
            function1.invoke(videoBaseData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopularViewAdapter mAdapter_delegate$lambda$0() {
        return new PopularViewAdapter();
    }

    @NotNull
    public final ViewPopularBinding getBinding() {
        ViewPopularBinding viewPopularBinding = this.binding;
        if (viewPopularBinding != null) {
            return viewPopularBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final Function1<VideoBaseData, Unit> getListener() {
        return this.listener;
    }

    public final void setBinding(@NotNull ViewPopularBinding viewPopularBinding) {
        Intrinsics.checkNotNullParameter(viewPopularBinding, "<set-?>");
        this.binding = viewPopularBinding;
    }

    public final void setData(@NotNull List<VideoBaseData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        BannerViewPager<VideoBaseData> bannerViewPager = this.mViewPager;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        bannerViewPager.C(list);
    }

    public final void setListener(@Nullable Function1<? super VideoBaseData, Unit> function1) {
        this.listener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopularView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.d
            public final Object invoke() {
                PopularViewAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = PopularView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        initView(context);
    }
}
