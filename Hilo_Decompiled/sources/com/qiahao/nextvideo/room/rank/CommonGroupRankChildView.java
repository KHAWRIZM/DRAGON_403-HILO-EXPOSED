package com.qiahao.nextvideo.room.rank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupRankBean;
import com.qiahao.nextvideo.databinding.ViewGroupChildCharmRankDetailBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001c\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonGroupRankChildView;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Landroid/content/Context;", "mContext", "", "mLevelType", "", "mDateType", "mGroupId", "<init>", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)V", "", "initRecyclerView", "()V", "", "Lcom/qiahao/nextvideo/data/model/GroupRankBean;", "list", "saveDataAndFullView", "(Ljava/util/List;)V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "onDetachedFromWindow", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "I", "getMLevelType", "()I", "Ljava/lang/String;", "getMDateType", "()Ljava/lang/String;", "getMGroupId", "Lcom/qiahao/nextvideo/databinding/ViewGroupChildCharmRankDetailBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewGroupChildCharmRankDetailBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGroupChildCharmRankDetailBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGroupChildCharmRankDetailBinding;)V", "Lnd/a;", "compose", "Lnd/a;", "getCompose", "()Lnd/a;", "Lcom/qiahao/nextvideo/room/rank/GroupCommonRankAdapter;", "mCommonRankAdapter$delegate", "Lkotlin/Lazy;", "getMCommonRankAdapter", "()Lcom/qiahao/nextvideo/room/rank/GroupCommonRankAdapter;", "mCommonRankAdapter", "", "unRequestData", "Z", "getUnRequestData", "()Z", "setUnRequestData", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonGroupRankChildView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonGroupRankChildView.kt\ncom/qiahao/nextvideo/room/rank/CommonGroupRankChildView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonGroupRankChildView extends FrameLayout implements vc.g {

    @NotNull
    public static final String DAY = "day";

    @NotNull
    public static final String MONTH = "month";

    @NotNull
    private static final String TAG = "CommonRankChildWrapper";

    @NotNull
    public static final String WEEK = "week";

    @NotNull
    private final nd.a compose;

    /* renamed from: mCommonRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommonRankAdapter;

    @NotNull
    private final Context mContext;

    @NotNull
    private ViewGroupChildCharmRankDetailBinding mDataBinding;

    @NotNull
    private final String mDateType;

    @NotNull
    private final String mGroupId;
    private final int mLevelType;
    private boolean unRequestData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonGroupRankChildView(@NotNull Context context, int i, @NotNull String str, @NotNull String str2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, "mDateType");
        Intrinsics.checkNotNullParameter(str2, "mGroupId");
        this.mContext = context;
        this.mLevelType = i;
        this.mDateType = str;
        this.mGroupId = str2;
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_group_child_charm_rank_detail, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.mDataBinding = (ViewGroupChildCharmRankDetailBinding) h;
        this.compose = new nd.a();
        this.mCommonRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.rank.g
            public final Object invoke() {
                GroupCommonRankAdapter mCommonRankAdapter_delegate$lambda$0;
                mCommonRankAdapter_delegate$lambda$0 = CommonGroupRankChildView.mCommonRankAdapter_delegate$lambda$0();
                return mCommonRankAdapter_delegate$lambda$0;
            }
        });
        this.unRequestData = true;
        initRecyclerView();
    }

    private final GroupCommonRankAdapter getMCommonRankAdapter() {
        return (GroupCommonRankAdapter) this.mCommonRankAdapter.getValue();
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = this.mDataBinding.recyclerRank;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        getMCommonRankAdapter().setMDateType(this.mDateType);
        recyclerView.setAdapter(getMCommonRankAdapter());
        getMCommonRankAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.rank.h
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommonGroupRankChildView.initRecyclerView$lambda$2(CommonGroupRankChildView.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$2(CommonGroupRankChildView commonGroupRankChildView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        commonGroupRankChildView.onOpenUserProfile(((GroupCommonRankEntity) commonGroupRankChildView.getMCommonRankAdapter().getItem(i)).getExternalId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupCommonRankAdapter mCommonRankAdapter_delegate$lambda$0() {
        return new GroupCommonRankAdapter(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$10(CommonGroupRankChildView commonGroupRankChildView) {
        commonGroupRankChildView.mDataBinding.smartRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$4(CommonGroupRankChildView commonGroupRankChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<GroupRankBean> list = (List) apiResponse.getData();
        if (list != null) {
            commonGroupRankChildView.saveDataAndFullView(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$5(CommonGroupRankChildView commonGroupRankChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        commonGroupRankChildView.mDataBinding.emptyTipTextView.setVisibility(0);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, commonGroupRankChildView.getContext(), ResourcesKtxKt.getStringById(commonGroupRankChildView, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "onRefresh: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$6(CommonGroupRankChildView commonGroupRankChildView) {
        commonGroupRankChildView.mDataBinding.smartRefreshLayout.finishRefresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$8(CommonGroupRankChildView commonGroupRankChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<GroupRankBean> list = (List) apiResponse.getData();
        if (list != null) {
            commonGroupRankChildView.saveDataAndFullView(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$9(CommonGroupRankChildView commonGroupRankChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, commonGroupRankChildView.getContext(), ResourcesKtxKt.getStringById(commonGroupRankChildView, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "onRefresh: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    private final void saveDataAndFullView(List<GroupRankBean> list) {
        GroupCommonRankEntity groupCommonRankEntity;
        String str;
        String str2;
        int i;
        boolean z;
        String str3;
        String str4;
        int i2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            this.mDataBinding.emptyTipTextView.setVisibility(8);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                long j = 0;
                if (i3 == 0) {
                    String externalId = list.get(i3).getUserBase().getExternalId();
                    if (externalId == null) {
                        str3 = "";
                    } else {
                        str3 = externalId;
                    }
                    String avatar = list.get(i3).getUserBase().getAvatar();
                    String name = list.get(i3).getUserBase().getName();
                    if (name == null) {
                        str4 = "";
                    } else {
                        str4 = name;
                    }
                    Integer sex = list.get(i3).getUserBase().getSex();
                    if (sex != null) {
                        i2 = sex.intValue();
                    } else {
                        i2 = 0;
                    }
                    String valueOf = String.valueOf(list.get(i3).getUserBase().getCode());
                    long num = list.get(i3).getNum();
                    Boolean isVip = list.get(i3).getUserBase().isVip();
                    if (isVip != null) {
                        z2 = isVip.booleanValue();
                    } else {
                        z2 = false;
                    }
                    Long birthday = list.get(i3).getUserBase().getBirthday();
                    if (birthday != null) {
                        j = birthday.longValue();
                    }
                    groupCommonRankEntity = new GroupCommonRankEntity(str3, avatar, str4, i2, valueOf, num, z2, j, list.get(i3).getUserBase().isShowAge(), list.get(i3).getUserBase().getNoble(), list.get(i3).getUserBase().getSvip(), 1);
                } else {
                    String externalId2 = list.get(i3).getUserBase().getExternalId();
                    if (externalId2 == null) {
                        str = "";
                    } else {
                        str = externalId2;
                    }
                    String avatar2 = list.get(i3).getUserBase().getAvatar();
                    String name2 = list.get(i3).getUserBase().getName();
                    if (name2 == null) {
                        str2 = "";
                    } else {
                        str2 = name2;
                    }
                    Integer sex2 = list.get(i3).getUserBase().getSex();
                    if (sex2 != null) {
                        i = sex2.intValue();
                    } else {
                        i = 0;
                    }
                    String valueOf2 = String.valueOf(list.get(i3).getUserBase().getCode());
                    long num2 = list.get(i3).getNum();
                    Boolean isVip2 = list.get(i3).getUserBase().isVip();
                    if (isVip2 != null) {
                        z = isVip2.booleanValue();
                    } else {
                        z = false;
                    }
                    Long birthday2 = list.get(i3).getUserBase().getBirthday();
                    if (birthday2 != null) {
                        j = birthday2.longValue();
                    }
                    groupCommonRankEntity = new GroupCommonRankEntity(str, avatar2, str2, i, valueOf2, num2, z, j, list.get(i3).getUserBase().isShowAge(), list.get(i3).getUserBase().getNoble(), list.get(i3).getUserBase().getSvip(), 2);
                }
                arrayList.add(groupCommonRankEntity);
            }
            getMCommonRankAdapter().setList(arrayList);
            return;
        }
        this.mDataBinding.emptyTipTextView.setVisibility(0);
    }

    @NotNull
    public final nd.a getCompose() {
        return this.compose;
    }

    public final void getFirstData() {
        if (this.unRequestData) {
            this.unRequestData = false;
            Log.d(TAG, "getFirstData: 一次获取数据 " + this.mLevelType + " " + this.mDateType);
            this.mDataBinding.smartRefreshLayout.autoRefresh();
            return;
        }
        Log.d(TAG, "getFirstData: 非一次获取数据 " + this.mLevelType + " " + this.mDateType);
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final ViewGroupChildCharmRankDetailBinding getMDataBinding() {
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

    public final int getMLevelType() {
        return this.mLevelType;
    }

    public final boolean getUnRequestData() {
        return this.unRequestData;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compose.d();
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        int i = this.mLevelType;
        if (i != 0) {
            if (i == 1) {
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupFamous(this.mGroupId, this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.room.rank.d
                    public final Object invoke(Object obj) {
                        Unit onRefresh$lambda$8;
                        onRefresh$lambda$8 = CommonGroupRankChildView.onRefresh$lambda$8(CommonGroupRankChildView.this, (ApiResponse) obj);
                        return onRefresh$lambda$8;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.room.rank.e
                    public final Object invoke(Object obj) {
                        Unit onRefresh$lambda$9;
                        onRefresh$lambda$9 = CommonGroupRankChildView.onRefresh$lambda$9(CommonGroupRankChildView.this, (Throwable) obj);
                        return onRefresh$lambda$9;
                    }
                }, new Function0() { // from class: com.qiahao.nextvideo.room.rank.f
                    public final Object invoke() {
                        Unit onRefresh$lambda$10;
                        onRefresh$lambda$10 = CommonGroupRankChildView.onRefresh$lambda$10(CommonGroupRankChildView.this);
                        return onRefresh$lambda$10;
                    }
                }, false, 8, (Object) null), this.compose);
                return;
            }
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupCharm(this.mGroupId, this.mDateType), new Function1() { // from class: com.qiahao.nextvideo.room.rank.a
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$4;
                onRefresh$lambda$4 = CommonGroupRankChildView.onRefresh$lambda$4(CommonGroupRankChildView.this, (ApiResponse) obj);
                return onRefresh$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.rank.b
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$5;
                onRefresh$lambda$5 = CommonGroupRankChildView.onRefresh$lambda$5(CommonGroupRankChildView.this, (Throwable) obj);
                return onRefresh$lambda$5;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.rank.c
            public final Object invoke() {
                Unit onRefresh$lambda$6;
                onRefresh$lambda$6 = CommonGroupRankChildView.onRefresh$lambda$6(CommonGroupRankChildView.this);
                return onRefresh$lambda$6;
            }
        }, false, 8, (Object) null), this.compose);
    }

    public final void setMDataBinding(@NotNull ViewGroupChildCharmRankDetailBinding viewGroupChildCharmRankDetailBinding) {
        Intrinsics.checkNotNullParameter(viewGroupChildCharmRankDetailBinding, "<set-?>");
        this.mDataBinding = viewGroupChildCharmRankDetailBinding;
    }

    public final void setUnRequestData(boolean z) {
        this.unRequestData = z;
    }
}
