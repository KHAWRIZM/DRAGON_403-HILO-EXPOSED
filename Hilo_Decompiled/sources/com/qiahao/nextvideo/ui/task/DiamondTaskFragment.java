package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.EarnDiamondBean;
import com.qiahao.nextvideo.data.model.EarnDiamondDailyBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.FragmentDiamondTaskBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.home.earn.EarnDiamondAdapter;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/DiamondTaskFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentDiamondTaskBinding;", "<init>", "()V", "", "initView", "getMyGroup", "createRoomAndEnterRoom", "", "taskConfigId", "getReward", "(I)V", "getLayoutResId", "()I", "onInitialize", "onResume", "getData", "onDestroy", "Lcom/qiahao/nextvideo/ui/home/earn/EarnDiamondAdapter;", "mDailyEarnDiamondAdapter$delegate", "Lkotlin/Lazy;", "getMDailyEarnDiamondAdapter", "()Lcom/qiahao/nextvideo/ui/home/earn/EarnDiamondAdapter;", "mDailyEarnDiamondAdapter", "mAdEarnDiamondAdapter$delegate", "getMAdEarnDiamondAdapter", "mAdEarnDiamondAdapter", "Lnd/a;", "compositeDisposable", "Lnd/a;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiamondTaskFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiamondTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/DiamondTaskFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,242:1\n1#2:243\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiamondTaskFragment extends BaseBindingFragment<FragmentDiamondTaskBinding> {

    /* renamed from: mDailyEarnDiamondAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDailyEarnDiamondAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.a
        public final Object invoke() {
            EarnDiamondAdapter mDailyEarnDiamondAdapter_delegate$lambda$0;
            mDailyEarnDiamondAdapter_delegate$lambda$0 = DiamondTaskFragment.mDailyEarnDiamondAdapter_delegate$lambda$0();
            return mDailyEarnDiamondAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mAdEarnDiamondAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdEarnDiamondAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.d
        public final Object invoke() {
            EarnDiamondAdapter mAdEarnDiamondAdapter_delegate$lambda$1;
            mAdEarnDiamondAdapter_delegate$lambda$1 = DiamondTaskFragment.mAdEarnDiamondAdapter_delegate$lambda$1();
            return mAdEarnDiamondAdapter_delegate$lambda$1;
        }
    });

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    private final void createRoomAndEnterRoom() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().createGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.i
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$10;
                createRoomAndEnterRoom$lambda$10 = DiamondTaskFragment.createRoomAndEnterRoom$lambda$10((ApiResponse) obj);
                return createRoomAndEnterRoom$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.j
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$11;
                createRoomAndEnterRoom$lambda$11 = DiamondTaskFragment.createRoomAndEnterRoom$lambda$11(DiamondTaskFragment.this, (Throwable) obj);
                return createRoomAndEnterRoom$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$10(ApiResponse apiResponse) {
        String str;
        String str2;
        String str3;
        String imGroupId;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!meetingRoomManager.isRoomSmall()) {
            str = "";
        } else {
            str = meetingRoomManager.getMGroupId();
        }
        CreateGroupBean createGroupBean = (CreateGroupBean) apiResponse.getData();
        if (createGroupBean != null) {
            str2 = createGroupBean.getImGroupId();
        } else {
            str2 = null;
        }
        boolean areEqual = Intrinsics.areEqual(str2, str);
        if (meetingRoomManager.getMGroupId().length() > 0) {
            if (str.length() == 0) {
                cf.c.c().l(new RoomEvent().closeRoom(meetingRoomManager.getMGroupId(), true));
            } else if (!areEqual) {
                n5.e.c("createRoomAndEnterRoom 调用MeetingRoomManager的LeaveRoom()");
                MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
            }
        }
        cf.c.c().l(new RoomEvent().setEventId(RoomEvent.ROOM_IN));
        n5.e.c("createRoomAndEnterRoom 打开房间页面5");
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        CreateGroupBean createGroupBean2 = (CreateGroupBean) apiResponse.getData();
        if (createGroupBean2 == null || (imGroupId = createGroupBean2.getImGroupId()) == null) {
            str3 = "";
        } else {
            str3 = imGroupId;
        }
        StartRoomUtils.start$default(startRoomUtils, str3, false, 0, null, null, null, null, 0, 0, 0, null, null, false, 0, false, 0, 65534, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$11(DiamondTaskFragment diamondTaskFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 14014) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = diamondTaskFragment.getContext();
                String localizedMessage = hiloException.getLocalizedMessage();
                if (localizedMessage == null) {
                    str = ResourcesKtxKt.getStringById(diamondTaskFragment, 2131952667);
                } else {
                    str = localizedMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, diamondTaskFragment.getContext(), ResourcesKtxKt.getStringById(diamondTaskFragment, 2131952667), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, diamondTaskFragment.getContext(), ResourcesKtxKt.getStringById(diamondTaskFragment, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$14(DiamondTaskFragment diamondTaskFragment, ApiResponse apiResponse) {
        List<EarnDiamondDailyBean> list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        EarnDiamondAdapter mDailyEarnDiamondAdapter = diamondTaskFragment.getMDailyEarnDiamondAdapter();
        EarnDiamondBean earnDiamondBean = (EarnDiamondBean) apiResponse.getData();
        List<EarnDiamondDailyBean> list2 = null;
        if (earnDiamondBean != null) {
            list = earnDiamondBean.getDailys();
        } else {
            list = null;
        }
        mDailyEarnDiamondAdapter.setList(list);
        EarnDiamondAdapter mAdEarnDiamondAdapter = diamondTaskFragment.getMAdEarnDiamondAdapter();
        EarnDiamondBean earnDiamondBean2 = (EarnDiamondBean) apiResponse.getData();
        if (earnDiamondBean2 != null) {
            list2 = earnDiamondBean2.getAdvanceds();
        }
        mAdEarnDiamondAdapter.setList(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$15(DiamondTaskFragment diamondTaskFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = diamondTaskFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = diamondTaskFragment.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final EarnDiamondAdapter getMAdEarnDiamondAdapter() {
        return (EarnDiamondAdapter) this.mAdEarnDiamondAdapter.getValue();
    }

    private final EarnDiamondAdapter getMDailyEarnDiamondAdapter() {
        return (EarnDiamondAdapter) this.mDailyEarnDiamondAdapter.getValue();
    }

    private final void getMyGroup() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getOwnGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.e
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$8;
                myGroup$lambda$8 = DiamondTaskFragment.getMyGroup$lambda$8(DiamondTaskFragment.this, (ApiResponse) obj);
                return myGroup$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.f
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$9;
                myGroup$lambda$9 = DiamondTaskFragment.getMyGroup$lambda$9(DiamondTaskFragment.this, (Throwable) obj);
                return myGroup$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$8(DiamondTaskFragment diamondTaskFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "list");
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((HotGroupBean) list.get(0)).getGroupId(), ((HotGroupBean) list.get(0)).getCode(), ((HotGroupBean) list.get(0)).getFaceUrl(), ((HotGroupBean) list.get(0)).getName(), Boolean.valueOf(((HotGroupBean) list.get(0)).getHasPassWord()), ((HotGroupBean) list.get(0)).getCountryIcon(), ((HotGroupBean) list.get(0)).getIntroduction(), ((HotGroupBean) list.get(0)).getNotification(), 0, 0, null, 0, false, 7936, null);
            }
        } else {
            diamondTaskFragment.createRoomAndEnterRoom();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$9(DiamondTaskFragment diamondTaskFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = diamondTaskFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = diamondTaskFragment.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void getReward(int taskConfigId) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.awardEarnDiamondTask$default(PurchaseService.INSTANCE.getShared(), taskConfigId, 0, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.task.k
            public final Object invoke(Object obj) {
                Unit reward$lambda$12;
                reward$lambda$12 = DiamondTaskFragment.getReward$lambda$12(DiamondTaskFragment.this, (ApiResponse) obj);
                return reward$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.l
            public final Object invoke(Object obj) {
                Unit reward$lambda$13;
                reward$lambda$13 = DiamondTaskFragment.getReward$lambda$13(DiamondTaskFragment.this, (Throwable) obj);
                return reward$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getReward$lambda$12(DiamondTaskFragment diamondTaskFragment, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        diamondTaskFragment.getData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getReward$lambda$13(DiamondTaskFragment diamondTaskFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = diamondTaskFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = diamondTaskFragment.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        NestedScrollView nestedScrollView;
        FragmentDiamondTaskBinding fragmentDiamondTaskBinding = (FragmentDiamondTaskBinding) getBinding();
        if (fragmentDiamondTaskBinding != null && (nestedScrollView = fragmentDiamondTaskBinding.scrollView) != null) {
            nestedScrollView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentDiamondTaskBinding fragmentDiamondTaskBinding2 = (FragmentDiamondTaskBinding) getBinding();
        if (fragmentDiamondTaskBinding2 != null && (recyclerView2 = fragmentDiamondTaskBinding2.dailyTasksRecycler) != null) {
            recyclerView2.setLayoutManager(new CustomLinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getMDailyEarnDiamondAdapter());
        }
        FragmentDiamondTaskBinding fragmentDiamondTaskBinding3 = (FragmentDiamondTaskBinding) getBinding();
        if (fragmentDiamondTaskBinding3 != null && (recyclerView = fragmentDiamondTaskBinding3.growthTasksRecycler) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getMAdEarnDiamondAdapter());
        }
        getMDailyEarnDiamondAdapter().addChildClickViewIds(new int[]{R.id.earn_take_button});
        getMDailyEarnDiamondAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.task.b
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiamondTaskFragment.initView$lambda$4(DiamondTaskFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMAdEarnDiamondAdapter().addChildClickViewIds(new int[]{R.id.earn_take_button});
        getMAdEarnDiamondAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.task.c
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiamondTaskFragment.initView$lambda$6(DiamondTaskFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(DiamondTaskFragment diamondTaskFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EarnDiamondDailyBean");
        EarnDiamondDailyBean earnDiamondDailyBean = (EarnDiamondDailyBean) item;
        if (view.getId() == 2131362729 && FastClickOneUtils.INSTANCE.isFastClick()) {
            if (earnDiamondDailyBean.getHasFinish() == 2) {
                int type = earnDiamondDailyBean.getType();
                if (type != 10 && type != 11) {
                    diamondTaskFragment.getMyGroup();
                    return;
                } else {
                    cf.c.c().l(new VideoEvent("HOME_PAGE_MATCH", new Object()));
                    return;
                }
            }
            if (earnDiamondDailyBean.getHasAward() == 2) {
                diamondTaskFragment.getReward(earnDiamondDailyBean.getTaskConfigId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(DiamondTaskFragment diamondTaskFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EarnDiamondDailyBean");
        EarnDiamondDailyBean earnDiamondDailyBean = (EarnDiamondDailyBean) item;
        if (view.getId() == 2131362729 && FastClickOneUtils.INSTANCE.isFastClick()) {
            if (earnDiamondDailyBean.getHasFinish() == 2) {
                int type = earnDiamondDailyBean.getType();
                if (type != 7) {
                    if (type != 9) {
                        Context context = diamondTaskFragment.getContext();
                        if (context != null) {
                            WalletActivity.INSTANCE.start(context);
                            return;
                        }
                        return;
                    }
                    cf.c.c().l(new VideoEvent("HOME_PAGE_MATCH", new Object()));
                    return;
                }
                diamondTaskFragment.getMyGroup();
                return;
            }
            if (earnDiamondDailyBean.getHasAward() == 2) {
                diamondTaskFragment.getReward(earnDiamondDailyBean.getTaskConfigId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarnDiamondAdapter mAdEarnDiamondAdapter_delegate$lambda$1() {
        return new EarnDiamondAdapter(R.layout.item_daily_earn_diamond_task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarnDiamondAdapter mDailyEarnDiamondAdapter_delegate$lambda$0() {
        return new EarnDiamondAdapter(R.layout.item_daily_earn_diamond_task);
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.getEarnDiamondTaskList$default(PurchaseService.INSTANCE.getShared(), 0, 1, null), new Function1() { // from class: com.qiahao.nextvideo.ui.task.g
            public final Object invoke(Object obj) {
                Unit data$lambda$14;
                data$lambda$14 = DiamondTaskFragment.getData$lambda$14(DiamondTaskFragment.this, (ApiResponse) obj);
                return data$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.h
            public final Object invoke(Object obj) {
                Unit data$lambda$15;
                data$lambda$15 = DiamondTaskFragment.getData$lambda$15(DiamondTaskFragment.this, (Throwable) obj);
                return data$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_diamond_task;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        getData();
    }
}
