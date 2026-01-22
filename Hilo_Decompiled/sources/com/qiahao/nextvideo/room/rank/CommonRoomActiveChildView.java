package com.qiahao.nextvideo.room.rank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.RoomActiveData;
import com.qiahao.nextvideo.databinding.ViewRoomChildActiveRankDetailBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveChildView;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Landroid/content/Context;", "mContext", "", "mDateType", "mGroupId", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "", "initRecyclerView", "()V", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onDetachedFromWindow", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getMDateType", "()Ljava/lang/String;", "getMGroupId", "Lcom/qiahao/nextvideo/databinding/ViewRoomChildActiveRankDetailBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewRoomChildActiveRankDetailBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewRoomChildActiveRankDetailBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewRoomChildActiveRankDetailBinding;)V", "Lnd/a;", "compose", "Lnd/a;", "getCompose", "()Lnd/a;", "Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveRankAdapter;", "mCommonRankAdapter$delegate", "Lkotlin/Lazy;", "getMCommonRankAdapter", "()Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveRankAdapter;", "mCommonRankAdapter", "", "unRequestData", "Z", "getUnRequestData", "()Z", "setUnRequestData", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonRoomActiveChildView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonRoomActiveChildView.kt\ncom/qiahao/nextvideo/room/rank/CommonRoomActiveChildView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,126:1\n1878#2,3:127\n*S KotlinDebug\n*F\n+ 1 CommonRoomActiveChildView.kt\ncom/qiahao/nextvideo/room/rank/CommonRoomActiveChildView\n*L\n92#1:127,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRoomActiveChildView extends FrameLayout implements vc.g {

    @NotNull
    public static final String LAST_WEEK = "lastWeek";

    @NotNull
    public static final String THIS_WEEK = "thisWeek";

    @NotNull
    private final nd.a compose;

    /* renamed from: mCommonRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommonRankAdapter;

    @NotNull
    private final Context mContext;

    @NotNull
    private ViewRoomChildActiveRankDetailBinding mDataBinding;

    @NotNull
    private final String mDateType;

    @NotNull
    private final String mGroupId;
    private boolean unRequestData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRoomActiveChildView(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, "mDateType");
        Intrinsics.checkNotNullParameter(str2, "mGroupId");
        this.mContext = context;
        this.mDateType = str;
        this.mGroupId = str2;
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_room_child_active_rank_detail, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.mDataBinding = (ViewRoomChildActiveRankDetailBinding) h;
        this.compose = new nd.a();
        this.mCommonRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.rank.l
            public final Object invoke() {
                CommonRoomActiveRankAdapter mCommonRankAdapter_delegate$lambda$0;
                mCommonRankAdapter_delegate$lambda$0 = CommonRoomActiveChildView.mCommonRankAdapter_delegate$lambda$0();
                return mCommonRankAdapter_delegate$lambda$0;
            }
        });
        this.unRequestData = true;
        initRecyclerView();
    }

    private final CommonRoomActiveRankAdapter getMCommonRankAdapter() {
        return (CommonRoomActiveRankAdapter) this.mCommonRankAdapter.getValue();
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = this.mDataBinding.recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMCommonRankAdapter());
        getMCommonRankAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.rank.m
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommonRoomActiveChildView.initRecyclerView$lambda$2(CommonRoomActiveChildView.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$2(CommonRoomActiveChildView commonRoomActiveChildView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User userBase = ((RoomActiveData) commonRoomActiveChildView.getMCommonRankAdapter().getItem(i)).getUserBase();
        if (userBase == null || (str = userBase.getExternalId()) == null) {
            str = "";
        }
        commonRoomActiveChildView.onOpenUserProfile(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CommonRoomActiveRankAdapter mCommonRankAdapter_delegate$lambda$0() {
        return new CommonRoomActiveRankAdapter(new ArrayList());
    }

    private final void onOpenUserProfile(String externalId) {
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$4(CommonRoomActiveChildView commonRoomActiveChildView, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        int i2 = 0;
        if (collection != null && !collection.isEmpty()) {
            commonRoomActiveChildView.mDataBinding.emptyTipTextView.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) apiResponse.getData();
            if (arrayList2 != null) {
                for (Object obj : arrayList2) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RoomActiveData roomActiveData = (RoomActiveData) obj;
                    if (i2 == 0) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    arrayList.add(new RoomActiveData(roomActiveData.getNum(), roomActiveData.getUserBase(), i));
                    i2 = i3;
                }
            }
            commonRoomActiveChildView.getMCommonRankAdapter().setList(arrayList);
        } else {
            commonRoomActiveChildView.mDataBinding.emptyTipTextView.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$5(CommonRoomActiveChildView commonRoomActiveChildView, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        commonRoomActiveChildView.mDataBinding.emptyTipTextView.setVisibility(0);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = commonRoomActiveChildView.getContext();
        String message = th.getMessage();
        if (message == null) {
            str = ResourcesKtxKt.getStringById(commonRoomActiveChildView, 2131952667);
        } else {
            str = message;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$6(CommonRoomActiveChildView commonRoomActiveChildView) {
        commonRoomActiveChildView.mDataBinding.smartRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompose() {
        return this.compose;
    }

    public final void getFirstData() {
        if (this.unRequestData) {
            this.unRequestData = false;
            this.mDataBinding.smartRefreshLayout.autoRefresh();
        }
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final ViewRoomChildActiveRankDetailBinding getMDataBinding() {
        return this.mDataBinding;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean getUnRequestData() {
        return this.unRequestData;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compose.d();
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().groupActive(this.mGroupId, this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.room.rank.i
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$4;
                onRefresh$lambda$4 = CommonRoomActiveChildView.onRefresh$lambda$4(CommonRoomActiveChildView.this, (ApiResponse) obj);
                return onRefresh$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.rank.j
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$5;
                onRefresh$lambda$5 = CommonRoomActiveChildView.onRefresh$lambda$5(CommonRoomActiveChildView.this, (Throwable) obj);
                return onRefresh$lambda$5;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.rank.k
            public final Object invoke() {
                Unit onRefresh$lambda$6;
                onRefresh$lambda$6 = CommonRoomActiveChildView.onRefresh$lambda$6(CommonRoomActiveChildView.this);
                return onRefresh$lambda$6;
            }
        }, false, 8, (Object) null), this.compose);
    }

    public final void setMDataBinding(@NotNull ViewRoomChildActiveRankDetailBinding viewRoomChildActiveRankDetailBinding) {
        Intrinsics.checkNotNullParameter(viewRoomChildActiveRankDetailBinding, "<set-?>");
        this.mDataBinding = viewRoomChildActiveRankDetailBinding;
    }

    public final void setUnRequestData(boolean z) {
        this.unRequestData = z;
    }
}
