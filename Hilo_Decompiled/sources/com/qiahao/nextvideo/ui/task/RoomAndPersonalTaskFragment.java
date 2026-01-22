package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GetTaskRewardBean;
import com.qiahao.nextvideo.data.model.RoomAndPersonalTaskBean;
import com.qiahao.nextvideo.data.model.TaskTabBean;
import com.qiahao.nextvideo.data.model.TasksListBean;
import com.qiahao.nextvideo.databinding.FragmentRoomAndPersonalBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0006H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomAndPersonalBinding;", "<init>", "()V", RoomAndPersonalTaskFragment.TASK_TYPE, "", "countDownTimer", "Landroid/os/CountDownTimer;", "isJumpToOtherAndComeback", "", "mMediaPlayer", "Landroid/media/MediaPlayer;", "viewModel", "Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "roomAndPersonalTaskListAdapter", "Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskListAdapter;", "getRoomAndPersonalTaskListAdapter", "()Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskListAdapter;", "roomAndPersonalTaskListAdapter$delegate", "getLayoutResId", "onInitialize", "", "onResume", "initArgumentParam", "initView", "initObserver", "onPause", "handleJumpEvent", "bean", "Lcom/qiahao/nextvideo/data/model/TasksListBean;", "position", "setCountDownTime", "secondsTime", "", "onDestroyView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomAndPersonalTaskFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomAndPersonalTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,240:1\n1878#2,3:241\n*S KotlinDebug\n*F\n+ 1 RoomAndPersonalTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskFragment\n*L\n100#1:241,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAndPersonalTaskFragment extends BaseBindingFragment<FragmentRoomAndPersonalBinding> {

    @NotNull
    public static final String TASK_TYPE = "taskType";

    @Nullable
    private CountDownTimer countDownTimer;
    private boolean isJumpToOtherAndComeback;

    @Nullable
    private MediaPlayer mMediaPlayer;
    private int taskType = 1;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.s0
        public final Object invoke() {
            RoomAndPersonalTaskViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = RoomAndPersonalTaskFragment.viewModel_delegate$lambda$0(RoomAndPersonalTaskFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: roomAndPersonalTaskListAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomAndPersonalTaskListAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.t0
        public final Object invoke() {
            RoomAndPersonalTaskListAdapter roomAndPersonalTaskListAdapter_delegate$lambda$1;
            roomAndPersonalTaskListAdapter_delegate$lambda$1 = RoomAndPersonalTaskFragment.roomAndPersonalTaskListAdapter_delegate$lambda$1();
            return roomAndPersonalTaskListAdapter_delegate$lambda$1;
        }
    });

    private final RoomAndPersonalTaskListAdapter getRoomAndPersonalTaskListAdapter() {
        return (RoomAndPersonalTaskListAdapter) this.roomAndPersonalTaskListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomAndPersonalTaskViewModel getViewModel() {
        return (RoomAndPersonalTaskViewModel) this.viewModel.getValue();
    }

    private final void handleJumpEvent(TasksListBean bean, int position) {
        int i = this.taskType;
        if (i != 1) {
            if (i == 2) {
                int taskStatus = bean.getTaskStatus();
                if (taskStatus != 0) {
                    if (taskStatus == 1) {
                        getViewModel().getPersonalAndRoomTaskAward(bean.getId(), position);
                        return;
                    }
                    return;
                } else {
                    if (bean.getType() == 3) {
                        Context activity = getActivity();
                        if (activity != null) {
                            WalletActivity.INSTANCE.start(activity);
                            return;
                        }
                        return;
                    }
                    String groupId = bean.getGroupId();
                    if (groupId != null && groupId.length() != 0) {
                        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, bean.getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                        return;
                    } else {
                        getViewModel().getMyGroup();
                        return;
                    }
                }
            }
            return;
        }
        int taskStatus2 = bean.getTaskStatus();
        if (taskStatus2 != 0) {
            if (taskStatus2 == 1) {
                getViewModel().getPersonalAndRoomTaskAward(bean.getId(), position);
                return;
            }
            return;
        }
        if (bean.getType() == 3) {
            Context activity2 = getActivity();
            if (activity2 != null) {
                WalletActivity.INSTANCE.start(activity2);
                return;
            }
            return;
        }
        if (bean.getId() == 23) {
            Context activity3 = getActivity();
            if (activity3 != null) {
                StrangeListActivity.INSTANCE.start(activity3, false);
                return;
            }
            return;
        }
        String groupId2 = bean.getGroupId();
        if (groupId2 != null && groupId2.length() != 0) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, bean.getGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        } else {
            getViewModel().getMyGroup();
        }
    }

    private final void initArgumentParam() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.taskType = arguments.getInt(TASK_TYPE, 1);
        }
    }

    private final void initObserver() {
        getViewModel().getPersonalAndRoomTaskList().observe(getViewLifecycleOwner(), new RoomAndPersonalTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.n0
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$11;
                initObserver$lambda$11 = RoomAndPersonalTaskFragment.initObserver$lambda$11(RoomAndPersonalTaskFragment.this, (RoomAndPersonalTaskBean) obj);
                return initObserver$lambda$11;
            }
        }));
        getViewModel().getPersonalAndRoomAward().observe(getViewLifecycleOwner(), new RoomAndPersonalTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.o0
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$14;
                initObserver$lambda$14 = RoomAndPersonalTaskFragment.initObserver$lambda$14(RoomAndPersonalTaskFragment.this, (GetTaskRewardBean) obj);
                return initObserver$lambda$14;
            }
        }));
        getViewModel().getMException().observe(this, new RoomAndPersonalTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.p0
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$15;
                initObserver$lambda$15 = RoomAndPersonalTaskFragment.initObserver$lambda$15(RoomAndPersonalTaskFragment.this, (Pair) obj);
                return initObserver$lambda$15;
            }
        }));
        getViewModel().m٩١getPersonalAndRoomTaskList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserver$lambda$11(RoomAndPersonalTaskFragment roomAndPersonalTaskFragment, RoomAndPersonalTaskBean roomAndPersonalTaskBean) {
        List<TaskTabBean> taskTab;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        TextView textView;
        TextView textView2;
        BaseStatusEmptyBinding baseStatusEmptyBinding2;
        ConstraintLayout root2;
        BaseStatusEmptyBinding baseStatusEmptyBinding3;
        ConstraintLayout root3;
        if (roomAndPersonalTaskBean != null && (taskTab = roomAndPersonalTaskBean.getTaskTab()) != null) {
            if (!taskTab.isEmpty()) {
                FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding = (FragmentRoomAndPersonalBinding) roomAndPersonalTaskFragment.getBinding();
                if (fragmentRoomAndPersonalBinding != null && (baseStatusEmptyBinding3 = fragmentRoomAndPersonalBinding.emptyView) != null && (root3 = baseStatusEmptyBinding3.getRoot()) != null) {
                    ViewKtxKt.visibleOrGone(root3, true);
                }
                List<TasksListBean> list = null;
                int i = 0;
                for (Object obj : taskTab) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TaskTabBean taskTabBean = (TaskTabBean) obj;
                    if (taskTabBean.getTab() == roomAndPersonalTaskFragment.taskType) {
                        list = taskTabBean.getTasks();
                    }
                    i = i2;
                }
                if (list != null && !list.isEmpty()) {
                    FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding2 = (FragmentRoomAndPersonalBinding) roomAndPersonalTaskFragment.getBinding();
                    if (fragmentRoomAndPersonalBinding2 != null && (baseStatusEmptyBinding2 = fragmentRoomAndPersonalBinding2.emptyView) != null && (root2 = baseStatusEmptyBinding2.getRoot()) != null) {
                        ViewKtxKt.visibleOrGone(root2, false);
                    }
                    roomAndPersonalTaskFragment.getRoomAndPersonalTaskListAdapter().setList(list);
                    Long cd2 = roomAndPersonalTaskBean.getCd();
                    if (cd2 != null) {
                        long longValue = cd2.longValue();
                        FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding3 = (FragmentRoomAndPersonalBinding) roomAndPersonalTaskFragment.getBinding();
                        if (fragmentRoomAndPersonalBinding3 != null && (textView2 = fragmentRoomAndPersonalBinding3.tvTime) != null) {
                            ViewKtxKt.visibleOrGone(textView2, true);
                        }
                        roomAndPersonalTaskFragment.setCountDownTime(longValue);
                    }
                }
            } else {
                FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding4 = (FragmentRoomAndPersonalBinding) roomAndPersonalTaskFragment.getBinding();
                if (fragmentRoomAndPersonalBinding4 != null && (textView = fragmentRoomAndPersonalBinding4.tvTime) != null) {
                    ViewKtxKt.visibleOrGone(textView, false);
                }
                FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding5 = (FragmentRoomAndPersonalBinding) roomAndPersonalTaskFragment.getBinding();
                if (fragmentRoomAndPersonalBinding5 != null && (baseStatusEmptyBinding = fragmentRoomAndPersonalBinding5.emptyView) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                    ViewKtxKt.visibleOrGone(root, true);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserver$lambda$14(RoomAndPersonalTaskFragment roomAndPersonalTaskFragment, GetTaskRewardBean getTaskRewardBean) {
        if (getTaskRewardBean != null) {
            FragmentActivity activity = roomAndPersonalTaskFragment.getActivity();
            if (activity != null) {
                MediaPlayer create = MediaPlayer.create((Context) activity, R.raw.family_diamond);
                roomAndPersonalTaskFragment.mMediaPlayer = create;
                if (create != null) {
                    create.setLooping(false);
                }
                MediaPlayer mediaPlayer = roomAndPersonalTaskFragment.mMediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
            roomAndPersonalTaskFragment.getRoomAndPersonalTaskListAdapter().setRewardDiamonds(getTaskRewardBean.getDiamonds());
            roomAndPersonalTaskFragment.getRoomAndPersonalTaskListAdapter().notifyItemChanged(getTaskRewardBean.getPosition(), RoomAndPersonalTaskListAdapter.TASK_START_ANIMATION);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(roomAndPersonalTaskFragment), Dispatchers.getMain(), (CoroutineStart) null, new RoomAndPersonalTaskFragment$initObserver$2$1$2(roomAndPersonalTaskFragment, null), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserver$lambda$15(RoomAndPersonalTaskFragment roomAndPersonalTaskFragment, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomAndPersonalTaskFragment.getContext();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomAndPersonalTaskFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        final FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding = (FragmentRoomAndPersonalBinding) getBinding();
        if (fragmentRoomAndPersonalBinding != null) {
            RecyclerView recyclerView = fragmentRoomAndPersonalBinding.taskRv;
            recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            RoomAndPersonalTaskListAdapter roomAndPersonalTaskListAdapter = getRoomAndPersonalTaskListAdapter();
            roomAndPersonalTaskListAdapter.setOnGoBtnClick(new Function2() { // from class: com.qiahao.nextvideo.ui.task.q0
                public final Object invoke(Object obj, Object obj2) {
                    Unit initView$lambda$7$lambda$5$lambda$4$lambda$3;
                    initView$lambda$7$lambda$5$lambda$4$lambda$3 = RoomAndPersonalTaskFragment.initView$lambda$7$lambda$5$lambda$4$lambda$3(RoomAndPersonalTaskFragment.this, (TasksListBean) obj, ((Integer) obj2).intValue());
                    return initView$lambda$7$lambda$5$lambda$4$lambda$3;
                }
            });
            recyclerView.setAdapter(roomAndPersonalTaskListAdapter);
            fragmentRoomAndPersonalBinding.smartRefreshLayout.setEnableLoadMore(false);
            fragmentRoomAndPersonalBinding.smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.task.r0
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    RoomAndPersonalTaskFragment.initView$lambda$7$lambda$6(FragmentRoomAndPersonalBinding.this, this, fVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7$lambda$5$lambda$4$lambda$3(RoomAndPersonalTaskFragment roomAndPersonalTaskFragment, TasksListBean tasksListBean, int i) {
        Intrinsics.checkNotNullParameter(tasksListBean, "bean");
        roomAndPersonalTaskFragment.isJumpToOtherAndComeback = true;
        roomAndPersonalTaskFragment.handleJumpEvent(tasksListBean, i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding, RoomAndPersonalTaskFragment roomAndPersonalTaskFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        fragmentRoomAndPersonalBinding.smartRefreshLayout.finishRefresh();
        roomAndPersonalTaskFragment.getViewModel().m٩١getPersonalAndRoomTaskList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomAndPersonalTaskListAdapter roomAndPersonalTaskListAdapter_delegate$lambda$1() {
        return new RoomAndPersonalTaskListAdapter(R.layout.item_room_personal_task_list_adapter);
    }

    private final void setCountDownTime(long secondsTime) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        if (secondsTime > 0) {
            final long j = secondsTime * 1000;
            this.countDownTimer = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskFragment$setCountDownTime$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    CountDownTimer countDownTimer2;
                    TextView textView;
                    countDownTimer2 = RoomAndPersonalTaskFragment.this.countDownTimer;
                    if (countDownTimer2 != null) {
                        countDownTimer2.cancel();
                    }
                    RoomAndPersonalTaskFragment.this.countDownTimer = null;
                    FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding = (FragmentRoomAndPersonalBinding) RoomAndPersonalTaskFragment.this.getBinding();
                    if (fragmentRoomAndPersonalBinding != null && (textView = fragmentRoomAndPersonalBinding.tvTime) != null) {
                        textView.setVisibility(8);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisTime) {
                    TextView textView;
                    FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding = (FragmentRoomAndPersonalBinding) RoomAndPersonalTaskFragment.this.getBinding();
                    if (fragmentRoomAndPersonalBinding != null && (textView = fragmentRoomAndPersonalBinding.tvTime) != null) {
                        textView.setText("Countdown: " + DateTimeUtilityKt.changeTaskTime(millisTime / 1000));
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomAndPersonalTaskViewModel viewModel_delegate$lambda$0(RoomAndPersonalTaskFragment roomAndPersonalTaskFragment) {
        return new ViewModelProvider(roomAndPersonalTaskFragment).get(RoomAndPersonalTaskViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_and_personal;
    }

    public void onDestroyView() {
        SmartRefreshLayout smartRefreshLayout;
        getRoomAndPersonalTaskListAdapter().clearAnimation();
        FragmentRoomAndPersonalBinding fragmentRoomAndPersonalBinding = (FragmentRoomAndPersonalBinding) getBinding();
        if (fragmentRoomAndPersonalBinding != null && (smartRefreshLayout = fragmentRoomAndPersonalBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(null);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        super.onDestroyView();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initArgumentParam();
        initView();
        initObserver();
    }

    public void onPause() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (this.isJumpToOtherAndComeback) {
            this.isJumpToOtherAndComeback = false;
            getViewModel().m٩١getPersonalAndRoomTaskList();
        }
    }
}
