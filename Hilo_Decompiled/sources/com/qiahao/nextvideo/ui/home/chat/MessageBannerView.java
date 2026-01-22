package com.qiahao.nextvideo.ui.home.chat;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.databinding.ViewMessageBannerBinding;
import com.qiahao.nextvideo.ui.home.matching.advertising.MessagePopularAdapter;
import com.qiahao.nextvideo.ui.home.onlinefeed.GoddessActivity;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u001c2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001fj\b\u0012\u0004\u0012\u00020\u0014` R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/MessageBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewMessageBannerBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewMessageBannerBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewMessageBannerBinding;)V", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "mMessageAdapter", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/MessagePopularAdapter;", "getMMessageAdapter", "()Lcom/qiahao/nextvideo/ui/home/matching/advertising/MessagePopularAdapter;", "mMessageAdapter$delegate", "Lkotlin/Lazy;", "initView", "", "refreshData", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageBannerView extends FrameLayout {
    public ViewMessageBannerBinding mDataBinding;

    /* renamed from: mMessageAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMessageAdapter;
    private BannerViewPager<VideoBaseData> mViewPager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageBannerView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final MessagePopularAdapter getMMessageAdapter() {
        return (MessagePopularAdapter) this.mMessageAdapter.getValue();
    }

    private final void initView() {
        setMDataBinding(ViewMessageBannerBinding.inflate(LayoutInflater.from(getContext()), this, true));
        BannerViewPager<VideoBaseData> bannerViewPager = getMDataBinding().bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.VideoBaseData>");
        this.mViewPager = bannerViewPager;
        getMMessageAdapter().setListener(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.v
            public final Object invoke(Object obj) {
                Unit initView$lambda$2;
                initView$lambda$2 = MessageBannerView.initView$lambda$2(MessageBannerView.this, (VideoBaseData) obj);
                return initView$lambda$2;
            }
        });
        BannerViewPager<VideoBaseData> bannerViewPager2 = this.mViewPager;
        BannerViewPager<VideoBaseData> bannerViewPager3 = null;
        if (bannerViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager2 = null;
        }
        bannerViewPager2.G(getMMessageAdapter());
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
    public static final Unit initView$lambda$2(MessageBannerView messageBannerView, VideoBaseData videoBaseData) {
        Intrinsics.checkNotNullParameter(videoBaseData, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(messageBannerView.getContext());
        if (activity != null) {
            activity.startActivity(new Intent((Context) activity, (Class<?>) GoddessActivity.class));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessagePopularAdapter mMessageAdapter_delegate$lambda$0() {
        return new MessagePopularAdapter();
    }

    @NotNull
    public final ViewMessageBannerBinding getMDataBinding() {
        ViewMessageBannerBinding viewMessageBannerBinding = this.mDataBinding;
        if (viewMessageBannerBinding != null) {
            return viewMessageBannerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    public final void refreshData(@NotNull ArrayList<VideoBaseData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        BannerViewPager<VideoBaseData> bannerViewPager = this.mViewPager;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        bannerViewPager.C(list);
    }

    public final void setMDataBinding(@NotNull ViewMessageBannerBinding viewMessageBannerBinding) {
        Intrinsics.checkNotNullParameter(viewMessageBannerBinding, "<set-?>");
        this.mDataBinding = viewMessageBannerBinding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMessageAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.w
            public final Object invoke() {
                MessagePopularAdapter mMessageAdapter_delegate$lambda$0;
                mMessageAdapter_delegate$lambda$0 = MessageBannerView.mMessageAdapter_delegate$lambda$0();
                return mMessageAdapter_delegate$lambda$0;
            }
        });
        initView();
    }
}
