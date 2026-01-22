package com.qiahao.nextvideo.ui.rank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.MySupportAllBean;
import com.qiahao.nextvideo.data.model.MySupportBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivitySupportGiftRankBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001FB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0007J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J\u0015\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\bH\u0014¢\u0006\u0004\b1\u0010\u0007R\"\u00102\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001fR\"\u00106\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00103\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001fR\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/SupportGiftRankActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySupportGiftRankBinding;", "Lvc/g;", "Lvc/e;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "initRecyclerView", "Lcom/qiahao/nextvideo/ui/reusable/CircleImageView;", "circleImageView", "getViewTagAndOpenProfile", "(Lcom/qiahao/nextvideo/ui/reusable/CircleImageView;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MySupportBean;", "Lkotlin/collections/ArrayList;", "it", "showTop3layoutAndSetList", "(Ljava/util/ArrayList;)V", "mySupportBean", "showTop1Avatar", "(Lcom/qiahao/nextvideo/data/model/MySupportBean;)V", "showTop2Avatar", "showTop3Avatar", "", "getLayoutResId", "()I", "onInitialize", "total", "showTitle", "(I)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getData", "(Z)V", "", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onDestroy", "mPageIndex", "I", "getMPageIndex", "setMPageIndex", "mPageSize", "getMPageSize", "setMPageSize", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "mExternalId", "Ljava/lang/String;", "Lcom/qiahao/nextvideo/ui/rank/SupportRankAdapter;", "mSupportRankAdapter$delegate", "Lkotlin/Lazy;", "getMSupportRankAdapter", "()Lcom/qiahao/nextvideo/ui/rank/SupportRankAdapter;", "mSupportRankAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SupportGiftRankActivity extends HiloBaseBindingActivity<ActivitySupportGiftRankBinding> implements vc.g, vc.e, View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTERNAL_ID = "externalId";
    private int mPageIndex = 1;
    private int mPageSize = 15;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @NotNull
    private String mExternalId = "";

    /* renamed from: mSupportRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSupportRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.rank.f1
        public final Object invoke() {
            SupportRankAdapter mSupportRankAdapter_delegate$lambda$0;
            mSupportRankAdapter_delegate$lambda$0 = SupportGiftRankActivity.mSupportRankAdapter_delegate$lambda$0();
            return mSupportRankAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/SupportGiftRankActivity$Companion;", "", "<init>", "()V", "EXTERNAL_ID", "", "startActivity", "", SupportGiftRankActivity.EXTERNAL_ID, "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull String externalId, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) SupportGiftRankActivity.class);
            intent.putExtra(SupportGiftRankActivity.EXTERNAL_ID, externalId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$10(SupportGiftRankActivity supportGiftRankActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (supportGiftRankActivity.mPageIndex == 1) {
            supportGiftRankActivity.getBinding().emptyTipTextView.setVisibility(0);
            supportGiftRankActivity.getBinding().recyclerRank.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$11(boolean z, SupportGiftRankActivity supportGiftRankActivity) {
        if (z) {
            supportGiftRankActivity.getBinding().smartRefreshLayout.finishRefresh();
        } else {
            supportGiftRankActivity.getBinding().smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$9(SupportGiftRankActivity supportGiftRankActivity, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MySupportAllBean mySupportAllBean = (MySupportAllBean) apiResponse.getData();
        if (mySupportAllBean != null) {
            supportGiftRankActivity.mPageIndex++;
            supportGiftRankActivity.showTitle(mySupportAllBean.getTotal());
            if (mySupportAllBean.getUserScores().isEmpty()) {
                if (z) {
                    supportGiftRankActivity.getBinding().emptyTipTextView.setVisibility(0);
                    supportGiftRankActivity.getBinding().recyclerRank.setVisibility(8);
                    supportGiftRankActivity.showTop3layoutAndSetList(mySupportAllBean.getUserScores());
                }
                supportGiftRankActivity.getBinding().smartRefreshLayout.setEnableLoadMore(false);
            } else {
                supportGiftRankActivity.getBinding().emptyTipTextView.setVisibility(8);
                supportGiftRankActivity.getBinding().recyclerRank.setVisibility(0);
                if (mySupportAllBean.getUserScores().size() == supportGiftRankActivity.mPageSize) {
                    supportGiftRankActivity.getBinding().smartRefreshLayout.setEnableLoadMore(true);
                } else {
                    supportGiftRankActivity.getBinding().smartRefreshLayout.setEnableLoadMore(false);
                }
                if (z) {
                    MMKVToLocalCache.INSTANCE.saveSupportMyRank(mySupportAllBean);
                    supportGiftRankActivity.showTop3layoutAndSetList(mySupportAllBean.getUserScores());
                } else {
                    supportGiftRankActivity.getMSupportRankAdapter().addData(mySupportAllBean.getUserScores());
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final SupportRankAdapter getMSupportRankAdapter() {
        return (SupportRankAdapter) this.mSupportRankAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void getViewTagAndOpenProfile(CircleImageView circleImageView) {
        String str = (String) circleImageView.getTag();
        if (str != null) {
            onOpenUserProfile(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initRecyclerView() {
        ((ActivitySupportGiftRankBinding) getBinding()).smartRefreshLayout.setOnRefreshListener(this);
        ((ActivitySupportGiftRankBinding) getBinding()).smartRefreshLayout.setOnLoadMoreListener(this);
        ((ActivitySupportGiftRankBinding) getBinding()).smartRefreshLayout.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout = ((ActivitySupportGiftRankBinding) getBinding()).smartRefreshLayout;
        FootLoading footLoading = new FootLoading((Context) this);
        footLoading.setBackground(androidx.core.content.a.getDrawable(this, 2131101214));
        smartRefreshLayout.setRefreshFooter(footLoading);
        RecyclerView recyclerView = ((ActivitySupportGiftRankBinding) getBinding()).recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMSupportRankAdapter());
        getMSupportRankAdapter().addChildClickViewIds(new int[]{R.id.user_avatar_cimage_view});
        getMSupportRankAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.rank.i1
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SupportGiftRankActivity.initRecyclerView$lambda$5(SupportGiftRankActivity.this, baseQuickAdapter, view, i);
            }
        });
        ((ActivitySupportGiftRankBinding) getBinding()).recyclerRank.getLayoutParams();
        ((ActivitySupportGiftRankBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportGiftRankActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initRecyclerView$lambda$5(SupportGiftRankActivity supportGiftRankActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MySupportBean");
        MySupportBean mySupportBean = (MySupportBean) item;
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && mySupportBean.getUser().checkNotOfficialStaff()) {
            new TipDialog(supportGiftRankActivity).setTipContent(ResourcesKtxKt.getStringById(supportGiftRankActivity, 2131954198)).show();
            return;
        }
        String externalId = mySupportBean.getUser().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        supportGiftRankActivity.onOpenUserProfile(externalId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportRankAdapter mSupportRankAdapter_delegate$lambda$0() {
        return new SupportRankAdapter(R.layout.item_rank);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(SupportGiftRankActivity supportGiftRankActivity, int i, int i2) {
        ViewKtxKt.setMargin(supportGiftRankActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showTop1Avatar(final MySupportBean mySupportBean) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        Integer num;
        int i6;
        Integer level;
        Integer level2;
        CharSequence charSequence;
        int i7;
        Integer level3;
        Integer level4;
        boolean z = true;
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) getBinding()).top1Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top1Avatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = mySupportBean.getUser().getAvatar();
        String str2 = "";
        if (avatar == null) {
            avatar = "";
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(65));
        fill.setHeight(dimens.dpToPx(65));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        ((ActivitySupportGiftRankBinding) getBinding()).top1Avatar.setTag(mySupportBean.getUser().getExternalId());
        NobleInfo noble = mySupportBean.getUser().getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView = ((ActivitySupportGiftRankBinding) getBinding()).top1Name;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = mySupportBean.getUser().getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i7 = level3.intValue();
            } else {
                i7 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion2, i7, 0, 2, null));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).top1Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView2 = ((ActivitySupportGiftRankBinding) getBinding()).top1Name;
        String name = mySupportBean.getUser().getName();
        if (name != null) {
            i2 = name.length();
        } else {
            i2 = 0;
        }
        if (i2 > 20) {
            String name2 = mySupportBean.getUser().getName();
            if (name2 != null) {
                charSequence = name2.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            str = ((Object) charSequence) + "...";
        } else {
            String name3 = mySupportBean.getUser().getName();
            if (name3 != null) {
                str2 = name3;
            }
            str = str2;
        }
        textView2.setText(str);
        ((ActivitySupportGiftRankBinding) getBinding()).top1Id.setText(getString(2131953102, mySupportBean.getUser().getCode()));
        Boolean isPrettyCode = mySupportBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivitySupportGiftRankBinding) getBinding()).top1Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top1Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, dimens.dpToPx(4)));
            ((ActivitySupportGiftRankBinding) getBinding()).top1Id.setCompoundDrawablePadding(dimens.dpToPx(4));
        } else {
            ShineTextView shineTextView2 = ((ActivitySupportGiftRankBinding) getBinding()).top1Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top1Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top1Diamond.setText(NumberUtilsKt.rankNumberFormat(mySupportBean.getScore()));
        ImageView imageView = ((ActivitySupportGiftRankBinding) getBinding()).iconVip1;
        if (Intrinsics.areEqual(mySupportBean.getUser().isVip(), bool)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        NobleInfo noble3 = mySupportBean.getUser().getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble1.setVisibility(0);
            ImageView imageView2 = ((ActivitySupportGiftRankBinding) getBinding()).iconNoble1;
            Context context = ((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = mySupportBean.getUser().getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i6 = level.intValue();
            } else {
                i6 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i6)));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble1.setVisibility(8);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportGiftRankActivity.showTop1Avatar$lambda$13(MySupportBean.this, this, view);
            }
        });
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null) {
            i5 = svip.getSvipLevel();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip1.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = mySupportBean.getUser().getSvip();
            if (svip2 != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            } else {
                num = null;
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivitySupportGiftRankBinding) getBinding()).svip1.setImageDrawable(androidx.core.content.a.getDrawable(((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).svip1.setVisibility(8);
        }
        if (mySupportBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivitySupportGiftRankBinding) getBinding()).top1Medal;
            List<MedalInfo> medalInfo = mySupportBean.getUser().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo);
            List mutableList = CollectionsKt.toMutableList(medalInfo);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) mutableList, 0, 2, null);
        }
        SvipData svip3 = mySupportBean.getUser().getSvip();
        if (svip3 == null || !svip3.isRankStealth()) {
            z = false;
        }
        if (z) {
            AppCompatImageView appCompatImageView = ((ActivitySupportGiftRankBinding) getBinding()).top1Avatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "top1Avatar");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((ActivitySupportGiftRankBinding) getBinding()).top1Id.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top1Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip1.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top1Medal.setVisibility(8);
            return;
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top1Id.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showTop1Avatar$lambda$13(MySupportBean mySupportBean, SupportGiftRankActivity supportGiftRankActivity, View view) {
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && mySupportBean.getUser().checkNotOfficialStaff()) {
            new TipDialog(supportGiftRankActivity).setTipContent(ResourcesKtxKt.getStringById(supportGiftRankActivity, 2131954198)).show();
            return;
        }
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) supportGiftRankActivity.getBinding()).top1Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top1Avatar");
        supportGiftRankActivity.getViewTagAndOpenProfile(circleImageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showTop2Avatar(final MySupportBean mySupportBean) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        Integer level;
        Integer level2;
        CharSequence charSequence;
        int i7;
        Integer level3;
        Integer level4;
        boolean z = true;
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) getBinding()).top2Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top2Avatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = mySupportBean.getUser().getAvatar();
        String str2 = "";
        if (avatar == null) {
            avatar = "";
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(65));
        fill.setHeight(dimens.dpToPx(65));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayUserAvatarImage = companion.displayUserAvatarImage(avatar, fill);
        Integer num = null;
        ViewUtilitiesKt.bind$default(circleImageView, displayUserAvatarImage, null, 2, null);
        ((ActivitySupportGiftRankBinding) getBinding()).top2Avatar.setTag(mySupportBean.getUser().getExternalId());
        NobleInfo noble = mySupportBean.getUser().getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView = ((ActivitySupportGiftRankBinding) getBinding()).top2Name;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = mySupportBean.getUser().getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i7 = level3.intValue();
            } else {
                i7 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion2, i7, 0, 2, null));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).top2Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView2 = ((ActivitySupportGiftRankBinding) getBinding()).top2Name;
        String name = mySupportBean.getUser().getName();
        if (name != null) {
            i2 = name.length();
        } else {
            i2 = 0;
        }
        if (i2 > 20) {
            String name2 = mySupportBean.getUser().getName();
            if (name2 != null) {
                charSequence = name2.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            str = ((Object) charSequence) + "...";
        } else {
            String name3 = mySupportBean.getUser().getName();
            if (name3 != null) {
                str2 = name3;
            }
            str = str2;
        }
        textView2.setText(str);
        ((ActivitySupportGiftRankBinding) getBinding()).top2Id.setText(getString(2131953102, mySupportBean.getUser().getCode()));
        Boolean isPrettyCode = mySupportBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivitySupportGiftRankBinding) getBinding()).top2Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top2Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, dimens.dpToPx(4)));
            ((ActivitySupportGiftRankBinding) getBinding()).top2Id.setCompoundDrawablePadding(dimens.dpToPx(4));
        } else {
            ShineTextView shineTextView2 = ((ActivitySupportGiftRankBinding) getBinding()).top2Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top2Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top2Diamond.setText(NumberUtilsKt.rankNumberFormat(mySupportBean.getScore()));
        ImageView imageView = ((ActivitySupportGiftRankBinding) getBinding()).iconVip2;
        if (Intrinsics.areEqual(mySupportBean.getUser().isVip(), bool)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (mySupportBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivitySupportGiftRankBinding) getBinding()).top2Medal;
            List<MedalInfo> medalInfo = mySupportBean.getUser().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo);
            List mutableList = CollectionsKt.toMutableList(medalInfo);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) mutableList, 0, 2, null);
        }
        NobleInfo noble3 = mySupportBean.getUser().getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble2.setVisibility(0);
            ImageView imageView2 = ((ActivitySupportGiftRankBinding) getBinding()).iconNoble2;
            Context context = ((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = mySupportBean.getUser().getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i6 = level.intValue();
            } else {
                i6 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i6)));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble2.setVisibility(8);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportGiftRankActivity.showTop2Avatar$lambda$16(MySupportBean.this, this, view);
            }
        });
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null) {
            i5 = svip.getSvipLevel();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip2.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = mySupportBean.getUser().getSvip();
            if (svip2 != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivitySupportGiftRankBinding) getBinding()).svip2.setImageDrawable(androidx.core.content.a.getDrawable(((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).svip2.setVisibility(8);
        }
        SvipData svip3 = mySupportBean.getUser().getSvip();
        if (svip3 == null || !svip3.isRankStealth()) {
            z = false;
        }
        if (z) {
            AppCompatImageView appCompatImageView = ((ActivitySupportGiftRankBinding) getBinding()).top2Avatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "top2Avatar");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((ActivitySupportGiftRankBinding) getBinding()).top2Id.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top2Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip2.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top2Medal.setVisibility(8);
            return;
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top2Id.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showTop2Avatar$lambda$16(MySupportBean mySupportBean, SupportGiftRankActivity supportGiftRankActivity, View view) {
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && mySupportBean.getUser().checkNotOfficialStaff()) {
            new TipDialog(supportGiftRankActivity).setTipContent(ResourcesKtxKt.getStringById(supportGiftRankActivity, 2131954198)).show();
            return;
        }
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) supportGiftRankActivity.getBinding()).top2Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top2Avatar");
        supportGiftRankActivity.getViewTagAndOpenProfile(circleImageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showTop3Avatar(final MySupportBean mySupportBean) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        Integer level;
        Integer level2;
        CharSequence charSequence;
        int i7;
        Integer level3;
        Integer level4;
        boolean z = true;
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) getBinding()).top3Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top3Avatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = mySupportBean.getUser().getAvatar();
        String str2 = "";
        if (avatar == null) {
            avatar = "";
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(65));
        fill.setHeight(dimens.dpToPx(65));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayUserAvatarImage = companion.displayUserAvatarImage(avatar, fill);
        Integer num = null;
        ViewUtilitiesKt.bind$default(circleImageView, displayUserAvatarImage, null, 2, null);
        ((ActivitySupportGiftRankBinding) getBinding()).top3Avatar.setTag(mySupportBean.getUser().getExternalId());
        NobleInfo noble = mySupportBean.getUser().getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i = level4.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView = ((ActivitySupportGiftRankBinding) getBinding()).top3Name;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = mySupportBean.getUser().getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i7 = level3.intValue();
            } else {
                i7 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion2, i7, 0, 2, null));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).top3Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView2 = ((ActivitySupportGiftRankBinding) getBinding()).top3Name;
        String name = mySupportBean.getUser().getName();
        if (name != null) {
            i2 = name.length();
        } else {
            i2 = 0;
        }
        if (i2 > 20) {
            String name2 = mySupportBean.getUser().getName();
            if (name2 != null) {
                charSequence = name2.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            str = ((Object) charSequence) + "...";
        } else {
            String name3 = mySupportBean.getUser().getName();
            if (name3 != null) {
                str2 = name3;
            }
            str = str2;
        }
        textView2.setText(str);
        ((ActivitySupportGiftRankBinding) getBinding()).top3Id.setText(getString(2131953102, mySupportBean.getUser().getCode()));
        Boolean isPrettyCode = mySupportBean.getUser().isPrettyCode();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isPrettyCode, bool)) {
            ShineTextView shineTextView = ((ActivitySupportGiftRankBinding) getBinding()).top3Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView, "top3Id");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, dimens.dpToPx(4)));
            ((ActivitySupportGiftRankBinding) getBinding()).top3Id.setCompoundDrawablePadding(dimens.dpToPx(4));
        } else {
            ShineTextView shineTextView2 = ((ActivitySupportGiftRankBinding) getBinding()).top3Id;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, "top3Id");
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top3Diamond.setText(NumberUtilsKt.rankNumberFormat(mySupportBean.getScore()));
        ImageView imageView = ((ActivitySupportGiftRankBinding) getBinding()).iconVip3;
        if (Intrinsics.areEqual(mySupportBean.getUser().isVip(), bool)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (mySupportBean.getUser().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = ((ActivitySupportGiftRankBinding) getBinding()).top3Medal;
            List<MedalInfo> medalInfo = mySupportBean.getUser().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo);
            List mutableList = CollectionsKt.toMutableList(medalInfo);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) mutableList, 0, 2, null);
        }
        NobleInfo noble3 = mySupportBean.getUser().getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble3.setVisibility(0);
            ImageView imageView2 = ((ActivitySupportGiftRankBinding) getBinding()).iconNoble3;
            Context context = ((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = mySupportBean.getUser().getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i6 = level.intValue();
            } else {
                i6 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i6)));
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble3.setVisibility(8);
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top3Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportGiftRankActivity.showTop3Avatar$lambda$19(MySupportBean.this, this, view);
            }
        });
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null) {
            i5 = svip.getSvipLevel();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip3.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = mySupportBean.getUser().getSvip();
            if (svip2 != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                ((ActivitySupportGiftRankBinding) getBinding()).svip3.setImageDrawable(androidx.core.content.a.getDrawable(((ActivitySupportGiftRankBinding) getBinding()).getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            ((ActivitySupportGiftRankBinding) getBinding()).svip3.setVisibility(8);
        }
        SvipData svip3 = mySupportBean.getUser().getSvip();
        if (svip3 == null || !svip3.isRankStealth()) {
            z = false;
        }
        if (z) {
            AppCompatImageView appCompatImageView = ((ActivitySupportGiftRankBinding) getBinding()).top3Avatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "top3Avatar");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((ActivitySupportGiftRankBinding) getBinding()).top3Id.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top3Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            ((ActivitySupportGiftRankBinding) getBinding()).iconVip3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).iconNoble3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).svip3.setVisibility(8);
            ((ActivitySupportGiftRankBinding) getBinding()).top3Medal.setVisibility(8);
            return;
        }
        ((ActivitySupportGiftRankBinding) getBinding()).top3Id.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showTop3Avatar$lambda$19(MySupportBean mySupportBean, SupportGiftRankActivity supportGiftRankActivity, View view) {
        SvipData svip = mySupportBean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && mySupportBean.getUser().checkNotOfficialStaff()) {
            new TipDialog(supportGiftRankActivity).setTipContent(ResourcesKtxKt.getStringById(supportGiftRankActivity, 2131954198)).show();
            return;
        }
        CircleImageView circleImageView = ((ActivitySupportGiftRankBinding) supportGiftRankActivity.getBinding()).top3Avatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "top3Avatar");
        supportGiftRankActivity.getViewTagAndOpenProfile(circleImageView);
    }

    private final void showTop3layoutAndSetList(ArrayList<MySupportBean> it) {
        if (it.size() > 3) {
            List<MySupportBean> subList = it.subList(3, it.size());
            Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
            getMSupportRankAdapter().setList(subList);
            getBinding().llContentTop1.setVisibility(0);
            getBinding().llContentTop2.setVisibility(0);
            getBinding().llContentTop3.setVisibility(0);
            MySupportBean mySupportBean = it.get(0);
            Intrinsics.checkNotNullExpressionValue(mySupportBean, "get(...)");
            showTop1Avatar(mySupportBean);
            MySupportBean mySupportBean2 = it.get(1);
            Intrinsics.checkNotNullExpressionValue(mySupportBean2, "get(...)");
            showTop2Avatar(mySupportBean2);
            MySupportBean mySupportBean3 = it.get(2);
            Intrinsics.checkNotNullExpressionValue(mySupportBean3, "get(...)");
            showTop3Avatar(mySupportBean3);
            return;
        }
        getMSupportRankAdapter().setList(new ArrayList());
        int size = it.size();
        if (size != 0) {
            if (size != 1) {
                if (size != 2) {
                    if (size == 3) {
                        getBinding().llContentTop1.setVisibility(0);
                        getBinding().llContentTop2.setVisibility(0);
                        getBinding().llContentTop3.setVisibility(0);
                        MySupportBean mySupportBean4 = it.get(0);
                        Intrinsics.checkNotNullExpressionValue(mySupportBean4, "get(...)");
                        showTop1Avatar(mySupportBean4);
                        MySupportBean mySupportBean5 = it.get(1);
                        Intrinsics.checkNotNullExpressionValue(mySupportBean5, "get(...)");
                        showTop2Avatar(mySupportBean5);
                        MySupportBean mySupportBean6 = it.get(2);
                        Intrinsics.checkNotNullExpressionValue(mySupportBean6, "get(...)");
                        showTop3Avatar(mySupportBean6);
                        return;
                    }
                    return;
                }
                getBinding().llContentTop1.setVisibility(0);
                getBinding().llContentTop2.setVisibility(0);
                getBinding().llContentTop3.setVisibility(4);
                MySupportBean mySupportBean7 = it.get(0);
                Intrinsics.checkNotNullExpressionValue(mySupportBean7, "get(...)");
                showTop1Avatar(mySupportBean7);
                MySupportBean mySupportBean8 = it.get(1);
                Intrinsics.checkNotNullExpressionValue(mySupportBean8, "get(...)");
                showTop2Avatar(mySupportBean8);
                return;
            }
            getBinding().llContentTop1.setVisibility(0);
            getBinding().llContentTop2.setVisibility(4);
            getBinding().llContentTop3.setVisibility(4);
            MySupportBean mySupportBean9 = it.get(0);
            Intrinsics.checkNotNullExpressionValue(mySupportBean9, "get(...)");
            showTop1Avatar(mySupportBean9);
            return;
        }
        getBinding().llContentTop1.setVisibility(4);
        getBinding().llContentTop2.setVisibility(4);
        getBinding().llContentTop3.setVisibility(4);
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void getData(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getRecentUserSendGift(this.mPageIndex, this.mPageSize, this.mExternalId), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.a1
            public final Object invoke(Object obj) {
                Unit data$lambda$9;
                data$lambda$9 = SupportGiftRankActivity.getData$lambda$9(SupportGiftRankActivity.this, isRefresh, (ApiResponse) obj);
                return data$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.b1
            public final Object invoke(Object obj) {
                Unit data$lambda$10;
                data$lambda$10 = SupportGiftRankActivity.getData$lambda$10(SupportGiftRankActivity.this, (Throwable) obj);
                return data$lambda$10;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.rank.c1
            public final Object invoke() {
                Unit data$lambda$11;
                data$lambda$11 = SupportGiftRankActivity.getData$lambda$11(isRefresh, this);
                return data$lambda$11;
            }
        }, false, 8, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_support_gift_rank;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131363156) {
                new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131953500)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131953574)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity$onClick$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                    }
                }).show();
                return;
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        String stringExtra = getIntent().getStringExtra(EXTERNAL_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mExternalId = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        FrameLayout frameLayout = ((ActivitySupportGiftRankBinding) getBinding()).activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.rank.g1
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = SupportGiftRankActivity.onInitialize$lambda$1(SupportGiftRankActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        ((ActivitySupportGiftRankBinding) getBinding()).activityMainContainer.setBackgroundColor(-1);
        ((ActivitySupportGiftRankBinding) getBinding()).setClick(this);
        initRecyclerView();
        ((ActivitySupportGiftRankBinding) getBinding()).smartRefreshLayout.autoRefresh();
        MySupportAllBean supportMyRank = MMKVToLocalCache.INSTANCE.getSupportMyRank();
        if (supportMyRank != null) {
            showTitle(0);
            showTop3layoutAndSetList(supportMyRank.getUserScores());
        }
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(false);
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, EXTERNAL_ID);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(true);
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    @SuppressLint({"SetTextI18n"})
    public final void showTitle(int total) {
        getBinding().titleTextView.setText(ResourcesKtxKt.getStringById(this, 2131954183) + "(" + total + ")");
    }
}
