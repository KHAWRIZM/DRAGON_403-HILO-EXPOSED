package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.CpBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewChildCpRankDetailBinding;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\u0018\u001a\u00020\f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u000eJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b'\u0010&J\u0015\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0015¢\u0006\u0004\b(\u0010&J\u0015\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0014¢\u0006\u0004\b,\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010E\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010#R\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010L\u001a\u0004\bR\u0010N\"\u0004\bS\u0010P¨\u0006U"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpRankChildWrapper;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Lvc/e;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "viewController", "", "mDateType", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;Ljava/lang/String;)V", "", "initRecyclerView", "()V", "Lcom/qiahao/base_common/utils/image/HiloImageView;", "circleImageView", "getViewTagAndOpenProfile", "(Lcom/qiahao/base_common/utils/image/HiloImageView;)V", "getDataFromCache", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/CpBean;", "Lkotlin/collections/ArrayList;", "it", "showTop3layoutAndSetList", "(Ljava/util/ArrayList;)V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getDate", "(Z)V", "cpBean", "showTop1Avatar", "(Lcom/qiahao/nextvideo/data/model/CpBean;)V", "showTop2Avatar", "showTop3Avatar", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "Ljava/lang/String;", "getMDateType", "()Ljava/lang/String;", "Lcom/qiahao/nextvideo/databinding/ViewChildCpRankDetailBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewChildCpRankDetailBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewChildCpRankDetailBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewChildCpRankDetailBinding;)V", "Lnd/a;", "compose", "Lnd/a;", "getCompose", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/rank/CpRankAdapter;", "mCpRankAdapter$delegate", "Lkotlin/Lazy;", "getMCpRankAdapter", "()Lcom/qiahao/nextvideo/ui/rank/CpRankAdapter;", "mCpRankAdapter", "unRequestData", "Z", "getUnRequestData", "()Z", "setUnRequestData", "", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankChildWrapper extends FrameLayout implements vc.g, vc.e {

    @NotNull
    public static final String ALL = "all";

    @NotNull
    public static final String DAY = "day";

    @NotNull
    public static final String MONTH = "month";

    @NotNull
    private static final String TAG = "CpRankChildWrapper";

    @NotNull
    public static final String WEEK = "week";

    @NotNull
    private final nd.a compose;

    /* renamed from: mCpRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCpRankAdapter;

    @NotNull
    private ViewChildCpRankDetailBinding mDataBinding;

    @NotNull
    private final String mDateType;
    private int mPageIndex;
    private int mPageSize;
    private boolean unRequestData;

    @NotNull
    private final CpRankViewController viewController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpRankChildWrapper(@NotNull Context context, @NotNull CpRankViewController cpRankViewController, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cpRankViewController, "viewController");
        Intrinsics.checkNotNullParameter(str, "mDateType");
        this.viewController = cpRankViewController;
        this.mDateType = str;
        this.compose = new nd.a();
        this.mCpRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.rank.z
            public final Object invoke() {
                CpRankAdapter mCpRankAdapter_delegate$lambda$0;
                mCpRankAdapter_delegate$lambda$0 = CpRankChildWrapper.mCpRankAdapter_delegate$lambda$0(CpRankChildWrapper.this);
                return mCpRankAdapter_delegate$lambda$0;
            }
        });
        this.unRequestData = true;
        this.mPageIndex = 1;
        this.mPageSize = 10;
        this.mDataBinding = (ViewChildCpRankDetailBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_child_cp_rank_detail, this, true);
        initRecyclerView();
    }

    private final void getDataFromCache() {
        ArrayList<CpBean> cpRankCache = MMKVToLocalCache.INSTANCE.getCpRankCache(this.mDateType);
        if (cpRankCache != null) {
            showTop3layoutAndSetList(cpRankCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$14(CpRankChildWrapper cpRankChildWrapper, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankChildWrapper.mPageIndex++;
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null && arrayList.isEmpty()) {
            if (z) {
                cpRankChildWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
                ArrayList<CpBean> arrayList2 = (ArrayList) apiResponse.getData();
                if (arrayList2 != null) {
                    cpRankChildWrapper.showTop3layoutAndSetList(arrayList2);
                }
            }
            cpRankChildWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        } else {
            cpRankChildWrapper.mDataBinding.emptyTipTextView.setVisibility(8);
            ArrayList arrayList3 = (ArrayList) apiResponse.getData();
            if (arrayList3 != null && arrayList3.size() == cpRankChildWrapper.mPageSize) {
                cpRankChildWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(true);
            } else {
                cpRankChildWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
            }
            ArrayList<CpBean> arrayList4 = (ArrayList) apiResponse.getData();
            if (arrayList4 != null) {
                if (z) {
                    MMKVToLocalCache.INSTANCE.saveCpRankCache(arrayList4, cpRankChildWrapper.mDateType);
                    cpRankChildWrapper.showTop3layoutAndSetList(arrayList4);
                } else {
                    cpRankChildWrapper.getMCpRankAdapter().addData(arrayList4);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$15(CpRankChildWrapper cpRankChildWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (cpRankChildWrapper.mPageIndex == 1) {
            cpRankChildWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
            cpRankChildWrapper.showTop3layoutAndSetList(new ArrayList<>());
            cpRankChildWrapper.mDataBinding.llTop1.setVisibility(8);
            cpRankChildWrapper.mDataBinding.llTop2.setVisibility(8);
            cpRankChildWrapper.mDataBinding.llTop3.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDate$lambda$16(boolean z, CpRankChildWrapper cpRankChildWrapper) {
        if (z) {
            cpRankChildWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        } else {
            cpRankChildWrapper.mDataBinding.smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    private final void getViewTagAndOpenProfile(HiloImageView circleImageView) {
        String str = (String) circleImageView.getTag();
        Log.d(TAG, "getViewTagAndOpenProfile: 打开用户id" + ((Object) str) + " viewId:" + circleImageView.getId());
        if (str != null) {
            onOpenUserProfile(str);
        }
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setOnLoadMoreListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout = this.mDataBinding.smartRefreshLayout;
        FootLoading footLoading = new FootLoading(getContext());
        footLoading.setBackground(footLoading.getContext().getDrawable(2131101214));
        smartRefreshLayout.setRefreshFooter(footLoading);
        RecyclerView recyclerView = this.mDataBinding.recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMCpRankAdapter());
        this.mDataBinding.recyclerRank.getLayoutParams();
        getMCpRankAdapter().addChildClickViewIds(new int[]{R.id.user1_avatar_cimage_view});
        getMCpRankAdapter().addChildClickViewIds(new int[]{R.id.user2_avatar_cimage_view});
        getMCpRankAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.rank.y
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CpRankChildWrapper.initRecyclerView$lambda$3(CpRankChildWrapper.this, baseQuickAdapter, view, i);
            }
        });
        this.mDataBinding.top1Cp1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$4(CpRankChildWrapper.this, view);
            }
        });
        this.mDataBinding.top1Cp2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$5(CpRankChildWrapper.this, view);
            }
        });
        this.mDataBinding.top2Cp1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$6(CpRankChildWrapper.this, view);
            }
        });
        this.mDataBinding.top2Cp2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$7(CpRankChildWrapper.this, view);
            }
        });
        this.mDataBinding.top3Cp1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$8(CpRankChildWrapper.this, view);
            }
        });
        this.mDataBinding.top3Cp2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpRankChildWrapper.initRecyclerView$lambda$9(CpRankChildWrapper.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$3(CpRankChildWrapper cpRankChildWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.CpBean");
        CpBean cpBean = (CpBean) item;
        int id2 = view.getId();
        String str = "";
        if (id2 != 2131365514) {
            if (id2 == 2131365517) {
                String externalId = cpBean.getUser_2().getExternalId();
                if (externalId != null) {
                    str = externalId;
                }
                cpRankChildWrapper.onOpenUserProfile(str);
                return;
            }
            return;
        }
        String externalId2 = cpBean.getUser_1().getExternalId();
        if (externalId2 != null) {
            str = externalId2;
        }
        cpRankChildWrapper.onOpenUserProfile(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$4(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top1Cp1Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top1Cp1Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$5(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top1Cp2Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top1Cp2Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$6(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top2Cp1Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top2Cp1Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$7(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top2Cp2Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top2Cp2Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$8(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top3Cp1Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top3Cp1Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$9(CpRankChildWrapper cpRankChildWrapper, View view) {
        HiloImageView hiloImageView = cpRankChildWrapper.mDataBinding.top3Cp2Avatar;
        Intrinsics.checkNotNullExpressionValue(hiloImageView, "top3Cp2Avatar");
        cpRankChildWrapper.getViewTagAndOpenProfile(hiloImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRankAdapter mCpRankAdapter_delegate$lambda$0(CpRankChildWrapper cpRankChildWrapper) {
        return new CpRankAdapter(R.layout.item_cp_rank, cpRankChildWrapper.mDateType);
    }

    private final void showTop3layoutAndSetList(ArrayList<CpBean> it) {
        if (it.size() > 3) {
            List<CpBean> subList = it.subList(3, it.size());
            Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
            getMCpRankAdapter().setList(subList);
            this.mDataBinding.llTop1.setVisibility(0);
            this.mDataBinding.llTop2.setVisibility(0);
            this.mDataBinding.llTop3.setVisibility(0);
            CpBean cpBean = it.get(0);
            Intrinsics.checkNotNullExpressionValue(cpBean, "get(...)");
            showTop1Avatar(cpBean);
            CpBean cpBean2 = it.get(1);
            Intrinsics.checkNotNullExpressionValue(cpBean2, "get(...)");
            showTop2Avatar(cpBean2);
            CpBean cpBean3 = it.get(2);
            Intrinsics.checkNotNullExpressionValue(cpBean3, "get(...)");
            showTop3Avatar(cpBean3);
            return;
        }
        getMCpRankAdapter().setList(new ArrayList());
        int size = it.size();
        if (size != 0) {
            if (size != 1) {
                if (size != 2) {
                    if (size == 3) {
                        this.mDataBinding.llTop1.setVisibility(0);
                        this.mDataBinding.llTop2.setVisibility(0);
                        this.mDataBinding.llTop3.setVisibility(0);
                        CpBean cpBean4 = it.get(0);
                        Intrinsics.checkNotNullExpressionValue(cpBean4, "get(...)");
                        showTop1Avatar(cpBean4);
                        CpBean cpBean5 = it.get(1);
                        Intrinsics.checkNotNullExpressionValue(cpBean5, "get(...)");
                        showTop2Avatar(cpBean5);
                        CpBean cpBean6 = it.get(2);
                        Intrinsics.checkNotNullExpressionValue(cpBean6, "get(...)");
                        showTop3Avatar(cpBean6);
                        return;
                    }
                    return;
                }
                this.mDataBinding.llTop1.setVisibility(0);
                this.mDataBinding.llTop2.setVisibility(0);
                this.mDataBinding.llTop3.setVisibility(8);
                CpBean cpBean7 = it.get(0);
                Intrinsics.checkNotNullExpressionValue(cpBean7, "get(...)");
                showTop1Avatar(cpBean7);
                CpBean cpBean8 = it.get(1);
                Intrinsics.checkNotNullExpressionValue(cpBean8, "get(...)");
                showTop2Avatar(cpBean8);
                return;
            }
            this.mDataBinding.llTop1.setVisibility(0);
            this.mDataBinding.llTop2.setVisibility(8);
            this.mDataBinding.llTop3.setVisibility(8);
            CpBean cpBean9 = it.get(0);
            Intrinsics.checkNotNullExpressionValue(cpBean9, "get(...)");
            showTop1Avatar(cpBean9);
            return;
        }
        this.mDataBinding.llTop1.setVisibility(8);
        this.mDataBinding.llTop2.setVisibility(8);
        this.mDataBinding.llTop3.setVisibility(8);
    }

    @NotNull
    public final nd.a getCompose() {
        return this.compose;
    }

    public final void getDate(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getCpRankList(this.mPageIndex, this.mPageSize, this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.g0
            public final Object invoke(Object obj) {
                Unit date$lambda$14;
                date$lambda$14 = CpRankChildWrapper.getDate$lambda$14(CpRankChildWrapper.this, isRefresh, (ApiResponse) obj);
                return date$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.h0
            public final Object invoke(Object obj) {
                Unit date$lambda$15;
                date$lambda$15 = CpRankChildWrapper.getDate$lambda$15(CpRankChildWrapper.this, (Throwable) obj);
                return date$lambda$15;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.rank.i0
            public final Object invoke() {
                Unit date$lambda$16;
                date$lambda$16 = CpRankChildWrapper.getDate$lambda$16(isRefresh, this);
                return date$lambda$16;
            }
        }, false, 8, (Object) null), this.viewController.getCompositeDisposable());
    }

    public final void getFirstData() {
        if (this.unRequestData) {
            this.unRequestData = false;
            Log.d(TAG, "getFirstData: 一次获取数据  " + this.mDateType);
            getDataFromCache();
            getDate(true);
            return;
        }
        Log.d(TAG, "getFirstData: 非一次获取数据  " + this.mDateType);
    }

    @NotNull
    public final CpRankAdapter getMCpRankAdapter() {
        return (CpRankAdapter) this.mCpRankAdapter.getValue();
    }

    @NotNull
    public final ViewChildCpRankDetailBinding getMDataBinding() {
        return this.mDataBinding;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    public final boolean getUnRequestData() {
        return this.unRequestData;
    }

    @NotNull
    public final CpRankViewController getViewController() {
        return this.viewController;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compose.d();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getDate(false);
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getDate(true);
    }

    public final void setMDataBinding(@NotNull ViewChildCpRankDetailBinding viewChildCpRankDetailBinding) {
        Intrinsics.checkNotNullParameter(viewChildCpRankDetailBinding, "<set-?>");
        this.mDataBinding = viewChildCpRankDetailBinding;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    public final void setUnRequestData(boolean z) {
        this.unRequestData = z;
    }

    public final void showTop1Avatar(@NotNull CpBean cpBean) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String name;
        int i6;
        String name2;
        CharSequence charSequence;
        int i7;
        Integer level;
        Integer level2;
        int i8;
        Integer level3;
        Integer level4;
        int i9;
        Integer level5;
        Integer level6;
        int i10;
        Integer level7;
        Integer level8;
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(cpBean, "cpBean");
        HiloImageView.loadImage$default(this.mDataBinding.top1Cp1Avatar, ImageSizeKt.image100(cpBean.getUser_1().getAvatar()), 0, 0, 6, (Object) null);
        this.mDataBinding.top1Cp1Avatar.setTag(cpBean.getUser_1().getExternalId());
        CharSequence charSequence2 = null;
        if (cpBean.getUser_1().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = this.mDataBinding.top1Cp1Medal;
            List<MedalInfo> medalInfo = cpBean.getUser_1().getMedalInfo();
            if (medalInfo != null) {
                list2 = CollectionsKt.toMutableList(medalInfo);
            } else {
                list2 = null;
            }
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) list2, 0, 2, null);
        }
        if (cpBean.getUser_2().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout2 = this.mDataBinding.top1Cp2Medal;
            List<MedalInfo> medalInfo2 = cpBean.getUser_2().getMedalInfo();
            if (medalInfo2 != null) {
                list = CollectionsKt.toMutableList(medalInfo2);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout2, (ArrayList) list, 0, 2, null);
        }
        HiloImageView.loadImage$default(this.mDataBinding.top1Cp2Avatar, ImageSizeKt.image100(cpBean.getUser_2().getAvatar()), 0, 0, 6, (Object) null);
        Boolean isVip = cpBean.getUser_1().isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            this.mDataBinding.top1Cp1Vip.setVisibility(0);
        } else {
            this.mDataBinding.top1Cp1Vip.setVisibility(8);
        }
        if (Intrinsics.areEqual(cpBean.getUser_2().isVip(), bool)) {
            this.mDataBinding.top1Cp2Vip.setVisibility(0);
        } else {
            this.mDataBinding.top1Cp2Vip.setVisibility(8);
        }
        NobleInfo noble = cpBean.getUser_1().getNoble();
        if (noble != null && (level8 = noble.getLevel()) != null) {
            i = level8.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            this.mDataBinding.top1Cp1Vip.setVisibility(8);
            this.mDataBinding.top1Cp1Noble.setVisibility(0);
            ImageView imageView = this.mDataBinding.top1Cp1Noble;
            Context context = getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = cpBean.getUser_1().getNoble();
            if (noble2 != null && (level7 = noble2.getLevel()) != null) {
                i10 = level7.intValue();
            } else {
                i10 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i10)));
        } else {
            this.mDataBinding.top1Cp1Noble.setVisibility(8);
        }
        NobleInfo noble3 = cpBean.getUser_2().getNoble();
        if (noble3 != null && (level6 = noble3.getLevel()) != null) {
            i2 = level6.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            this.mDataBinding.top1Cp2Vip.setVisibility(8);
            this.mDataBinding.top1Cp2Noble.setVisibility(0);
            ImageView imageView2 = this.mDataBinding.top1Cp2Noble;
            Context context2 = getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = cpBean.getUser_2().getNoble();
            if (noble4 != null && (level5 = noble4.getLevel()) != null) {
                i9 = level5.intValue();
            } else {
                i9 = 0;
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion2.getNobleDrawableRes(i9)));
        } else {
            this.mDataBinding.top1Cp2Noble.setVisibility(8);
        }
        this.mDataBinding.top1Cp2Avatar.setTag(cpBean.getUser_2().getExternalId());
        NobleInfo noble5 = cpBean.getUser_1().getNoble();
        if (noble5 != null && (level4 = noble5.getLevel()) != null) {
            i3 = level4.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            TextView textView = this.mDataBinding.top1Cp1UserName;
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble6 = cpBean.getUser_1().getNoble();
            if (noble6 != null && (level3 = noble6.getLevel()) != null) {
                i8 = level3.intValue();
            } else {
                i8 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion3, i8, 0, 2, null));
        } else {
            this.mDataBinding.top1Cp1UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        NobleInfo noble7 = cpBean.getUser_2().getNoble();
        if (noble7 != null && (level2 = noble7.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            TextView textView2 = this.mDataBinding.top1Cp2UserName;
            UserService.Companion companion4 = UserService.INSTANCE;
            NobleInfo noble8 = cpBean.getUser_2().getNoble();
            if (noble8 != null && (level = noble8.getLevel()) != null) {
                i7 = level.intValue();
            } else {
                i7 = 0;
            }
            textView2.setTextColor(UserService.Companion.getNobleColor$default(companion4, i7, 0, 2, null));
        } else {
            this.mDataBinding.top1Cp2UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        TextView textView3 = this.mDataBinding.top1Cp1UserName;
        String name3 = cpBean.getUser_1().getName();
        if (name3 != null) {
            i5 = name3.length();
        } else {
            i5 = 0;
        }
        if (i5 > 20) {
            String name4 = cpBean.getUser_1().getName();
            if (name4 != null) {
                charSequence = name4.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            name = ((Object) charSequence) + "...";
        } else {
            name = cpBean.getUser_1().getName();
        }
        textView3.setText(name);
        TextView textView4 = this.mDataBinding.top1Cp2UserName;
        String name5 = cpBean.getUser_2().getName();
        if (name5 != null) {
            i6 = name5.length();
        } else {
            i6 = 0;
        }
        if (i6 > 20) {
            String name6 = cpBean.getUser_2().getName();
            if (name6 != null) {
                charSequence2 = name6.subSequence(0, 19);
            }
            name2 = ((Object) charSequence2) + "...";
        } else {
            name2 = cpBean.getUser_2().getName();
            if (name2 == null) {
                name2 = "";
            }
        }
        textView4.setText(name2);
        this.mDataBinding.top1CpValue.setText(NumberUtilsKt.rankNumberFormat(cpBean.getScore()));
    }

    public final void showTop2Avatar(@NotNull CpBean cpBean) {
        int i;
        int i2;
        int i3;
        String name;
        int i4;
        String name2;
        int i5;
        int i6;
        Integer level;
        Integer level2;
        int i7;
        Integer level3;
        Integer level4;
        CharSequence charSequence;
        int i8;
        Integer level5;
        Integer level6;
        int i9;
        Integer level7;
        Integer level8;
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(cpBean, "cpBean");
        int i10 = 0;
        HiloImageView.loadImage$default(this.mDataBinding.top2Cp1Avatar, ImageSizeKt.image100(cpBean.getUser_1().getAvatar()), 0, 0, 6, (Object) null);
        this.mDataBinding.top2Cp1Avatar.setTag(cpBean.getUser_1().getExternalId());
        CharSequence charSequence2 = null;
        if (cpBean.getUser_1().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = this.mDataBinding.top2Cp1Medal;
            List<MedalInfo> medalInfo = cpBean.getUser_1().getMedalInfo();
            if (medalInfo != null) {
                list2 = CollectionsKt.toMutableList(medalInfo);
            } else {
                list2 = null;
            }
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) list2, 0, 2, null);
        }
        if (cpBean.getUser_2().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout2 = this.mDataBinding.top2Cp2Medal;
            List<MedalInfo> medalInfo2 = cpBean.getUser_2().getMedalInfo();
            if (medalInfo2 != null) {
                list = CollectionsKt.toMutableList(medalInfo2);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout2, (ArrayList) list, 0, 2, null);
        }
        HiloImageView.loadImage$default(this.mDataBinding.top2Cp2Avatar, ImageSizeKt.image100(cpBean.getUser_2().getAvatar()), 0, 0, 6, (Object) null);
        this.mDataBinding.top2Cp2Avatar.setTag(cpBean.getUser_2().getExternalId());
        NobleInfo noble = cpBean.getUser_1().getNoble();
        if (noble != null && (level8 = noble.getLevel()) != null) {
            i = level8.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView = this.mDataBinding.top2Cp1UserName;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = cpBean.getUser_1().getNoble();
            if (noble2 != null && (level7 = noble2.getLevel()) != null) {
                i9 = level7.intValue();
            } else {
                i9 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion, i9, 0, 2, null));
        } else {
            this.mDataBinding.top2Cp1UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        NobleInfo noble3 = cpBean.getUser_2().getNoble();
        if (noble3 != null && (level6 = noble3.getLevel()) != null) {
            i2 = level6.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            TextView textView2 = this.mDataBinding.top2Cp2UserName;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = cpBean.getUser_2().getNoble();
            if (noble4 != null && (level5 = noble4.getLevel()) != null) {
                i8 = level5.intValue();
            } else {
                i8 = 0;
            }
            textView2.setTextColor(UserService.Companion.getNobleColor$default(companion2, i8, 0, 2, null));
        } else {
            this.mDataBinding.top1Cp2UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        TextView textView3 = this.mDataBinding.top2Cp1UserName;
        String name3 = cpBean.getUser_1().getName();
        if (name3 != null) {
            i3 = name3.length();
        } else {
            i3 = 0;
        }
        if (i3 > 20) {
            String name4 = cpBean.getUser_1().getName();
            if (name4 != null) {
                charSequence = name4.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            name = ((Object) charSequence) + "...";
        } else {
            name = cpBean.getUser_1().getName();
        }
        textView3.setText(name);
        TextView textView4 = this.mDataBinding.top2Cp2UserName;
        String name5 = cpBean.getUser_2().getName();
        if (name5 != null) {
            i4 = name5.length();
        } else {
            i4 = 0;
        }
        if (i4 > 20) {
            String name6 = cpBean.getUser_2().getName();
            if (name6 != null) {
                charSequence2 = name6.subSequence(0, 19);
            }
            name2 = ((Object) charSequence2) + "...";
        } else {
            name2 = cpBean.getUser_2().getName();
        }
        textView4.setText(name2);
        this.mDataBinding.top2CpValue.setText(NumberUtilsKt.rankNumberFormat(cpBean.getScore()));
        Boolean isVip = cpBean.getUser_1().isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            this.mDataBinding.top2Cp1Vip.setVisibility(0);
        } else {
            this.mDataBinding.top2Cp1Vip.setVisibility(8);
        }
        if (Intrinsics.areEqual(cpBean.getUser_2().isVip(), bool)) {
            this.mDataBinding.top2Cp2Vip.setVisibility(0);
        } else {
            this.mDataBinding.top2Cp2Vip.setVisibility(8);
        }
        NobleInfo noble5 = cpBean.getUser_1().getNoble();
        if (noble5 != null && (level4 = noble5.getLevel()) != null) {
            i5 = level4.intValue();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            this.mDataBinding.top2Cp1Vip.setVisibility(8);
            this.mDataBinding.top2Cp1Noble.setVisibility(0);
            ImageView imageView = this.mDataBinding.top2Cp1Noble;
            Context context = getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble6 = cpBean.getUser_1().getNoble();
            if (noble6 != null && (level3 = noble6.getLevel()) != null) {
                i7 = level3.intValue();
            } else {
                i7 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i7)));
        } else {
            this.mDataBinding.top2Cp1Noble.setVisibility(8);
        }
        NobleInfo noble7 = cpBean.getUser_2().getNoble();
        if (noble7 != null && (level2 = noble7.getLevel()) != null) {
            i6 = level2.intValue();
        } else {
            i6 = 0;
        }
        if (i6 > 0) {
            this.mDataBinding.top2Cp2Vip.setVisibility(8);
            this.mDataBinding.top2Cp2Noble.setVisibility(0);
            ImageView imageView2 = this.mDataBinding.top2Cp2Noble;
            Context context2 = getContext();
            UserService.Companion companion4 = UserService.INSTANCE;
            NobleInfo noble8 = cpBean.getUser_2().getNoble();
            if (noble8 != null && (level = noble8.getLevel()) != null) {
                i10 = level.intValue();
            }
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion4.getNobleDrawableRes(i10)));
            return;
        }
        this.mDataBinding.top2Cp2Noble.setVisibility(8);
    }

    public final void showTop3Avatar(@NotNull CpBean cpBean) {
        int i;
        int i2;
        int i3;
        String name;
        int i4;
        String name2;
        int i5;
        int i6;
        Integer level;
        Integer level2;
        int i7;
        Integer level3;
        Integer level4;
        CharSequence charSequence;
        int i8;
        Integer level5;
        Integer level6;
        int i9;
        Integer level7;
        Integer level8;
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(cpBean, "cpBean");
        int i10 = 0;
        HiloImageView.loadImage$default(this.mDataBinding.top3Cp1Avatar, ImageSizeKt.image100(cpBean.getUser_1().getAvatar()), 0, 0, 6, (Object) null);
        this.mDataBinding.top3Cp1Avatar.setTag(cpBean.getUser_1().getExternalId());
        CharSequence charSequence2 = null;
        if (cpBean.getUser_1().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout = this.mDataBinding.top3Cp1Medal;
            List<MedalInfo> medalInfo = cpBean.getUser_1().getMedalInfo();
            if (medalInfo != null) {
                list2 = CollectionsKt.toMutableList(medalInfo);
            } else {
                list2 = null;
            }
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) list2, 0, 2, null);
        }
        if (cpBean.getUser_2().getMedalInfo() != null) {
            MedalGridLayout medalGridLayout2 = this.mDataBinding.top3Cp2Medal;
            List<MedalInfo> medalInfo2 = cpBean.getUser_2().getMedalInfo();
            if (medalInfo2 != null) {
                list = CollectionsKt.toMutableList(medalInfo2);
            } else {
                list = null;
            }
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            MedalGridLayout.setDataAndLayoutView$default(medalGridLayout2, (ArrayList) list, 0, 2, null);
        }
        HiloImageView.loadImage$default(this.mDataBinding.top3Cp2Avatar, ImageSizeKt.image100(cpBean.getUser_2().getAvatar()), 0, 0, 6, (Object) null);
        this.mDataBinding.top3Cp2Avatar.setTag(cpBean.getUser_2().getExternalId());
        NobleInfo noble = cpBean.getUser_1().getNoble();
        if (noble != null && (level8 = noble.getLevel()) != null) {
            i = level8.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            TextView textView = this.mDataBinding.top3Cp1UserName;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = cpBean.getUser_1().getNoble();
            if (noble2 != null && (level7 = noble2.getLevel()) != null) {
                i9 = level7.intValue();
            } else {
                i9 = 0;
            }
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion, i9, 0, 2, null));
        } else {
            this.mDataBinding.top3Cp1UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        NobleInfo noble3 = cpBean.getUser_2().getNoble();
        if (noble3 != null && (level6 = noble3.getLevel()) != null) {
            i2 = level6.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            TextView textView2 = this.mDataBinding.top3Cp2UserName;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = cpBean.getUser_2().getNoble();
            if (noble4 != null && (level5 = noble4.getLevel()) != null) {
                i8 = level5.intValue();
            } else {
                i8 = 0;
            }
            textView2.setTextColor(UserService.Companion.getNobleColor$default(companion2, i8, 0, 2, null));
        } else {
            this.mDataBinding.top3Cp2UserName.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        TextView textView3 = this.mDataBinding.top3Cp1UserName;
        String name3 = cpBean.getUser_1().getName();
        if (name3 != null) {
            i3 = name3.length();
        } else {
            i3 = 0;
        }
        if (i3 > 20) {
            String name4 = cpBean.getUser_1().getName();
            if (name4 != null) {
                charSequence = name4.subSequence(0, 19);
            } else {
                charSequence = null;
            }
            name = ((Object) charSequence) + "...";
        } else {
            name = cpBean.getUser_1().getName();
        }
        textView3.setText(name);
        TextView textView4 = this.mDataBinding.top3Cp2UserName;
        String name5 = cpBean.getUser_2().getName();
        if (name5 != null) {
            i4 = name5.length();
        } else {
            i4 = 0;
        }
        if (i4 > 20) {
            String name6 = cpBean.getUser_2().getName();
            if (name6 != null) {
                charSequence2 = name6.subSequence(0, 19);
            }
            name2 = ((Object) charSequence2) + "...";
        } else {
            name2 = cpBean.getUser_2().getName();
        }
        textView4.setText(name2);
        this.mDataBinding.top3CpValue.setText(NumberUtilsKt.rankNumberFormat(cpBean.getScore()));
        Boolean isVip = cpBean.getUser_1().isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            this.mDataBinding.top3Cp1Vip.setVisibility(0);
        } else {
            this.mDataBinding.top3Cp1Vip.setVisibility(8);
        }
        if (Intrinsics.areEqual(cpBean.getUser_2().isVip(), bool)) {
            this.mDataBinding.top3Cp2Vip.setVisibility(0);
        } else {
            this.mDataBinding.top3Cp2Vip.setVisibility(8);
        }
        NobleInfo noble5 = cpBean.getUser_1().getNoble();
        if (noble5 != null && (level4 = noble5.getLevel()) != null) {
            i5 = level4.intValue();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            this.mDataBinding.top3Cp1Vip.setVisibility(8);
            this.mDataBinding.top3Cp1Noble.setVisibility(0);
            ImageView imageView = this.mDataBinding.top3Cp1Noble;
            Context context = getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble6 = cpBean.getUser_1().getNoble();
            if (noble6 != null && (level3 = noble6.getLevel()) != null) {
                i7 = level3.intValue();
            } else {
                i7 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i7)));
        } else {
            this.mDataBinding.top3Cp1Noble.setVisibility(8);
        }
        ImageView imageView2 = this.mDataBinding.top3Cp2Vip;
        Intrinsics.checkNotNullExpressionValue(imageView2, "top3Cp2Vip");
        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        NobleInfo noble7 = cpBean.getUser_2().getNoble();
        if (noble7 != null && (level2 = noble7.getLevel()) != null) {
            i6 = level2.intValue();
        } else {
            i6 = 0;
        }
        if (i6 > 0) {
            this.mDataBinding.top3Cp2Vip.setVisibility(8);
            this.mDataBinding.top3Cp2Noble.setVisibility(0);
            ImageView imageView3 = this.mDataBinding.top3Cp2Noble;
            Context context2 = getContext();
            UserService.Companion companion4 = UserService.INSTANCE;
            NobleInfo noble8 = cpBean.getUser_2().getNoble();
            if (noble8 != null && (level = noble8.getLevel()) != null) {
                i10 = level.intValue();
            }
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion4.getNobleDrawableRes(i10)));
            return;
        }
        this.mDataBinding.top3Cp2Noble.setVisibility(8);
    }
}
