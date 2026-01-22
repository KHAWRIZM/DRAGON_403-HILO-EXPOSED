package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBean;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.databinding.LayoutRoomOnlineMemberBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.adapter.GroupMemberRoomOnlineAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.rank.GroupAllRankActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
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
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\fJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0006R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00100R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "initView", "()V", "refreshData", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "currentRoomOnlineBean", "updateData", "(Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;)V", "", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "getOnLineData", "()Ljava/util/List;", "", ExchangeDetailActivity.TYPE_DIAMOND, "updateRankSum", "(Ljava/lang/String;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onDetachedFromWindow", "", "noble", "refreshGoldView", "(I)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "Lcom/qiahao/nextvideo/databinding/LayoutRoomOnlineMemberBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/LayoutRoomOnlineMemberBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/LayoutRoomOnlineMemberBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/LayoutRoomOnlineMemberBinding;)V", "totalNumber", "I", "", "isScroll", "Z", "roomOnlineBean", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "Ljava/lang/Runnable;", "mTask", "Ljava/lang/Runnable;", "Lcom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayoutListener;", "mMeetingRoomOnlineMemberLayoutListener", "Lcom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayoutListener;", "getMMeetingRoomOnlineMemberLayoutListener", "()Lcom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayoutListener;", "setMMeetingRoomOnlineMemberLayoutListener", "(Lcom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayoutListener;)V", "", "mCurrentLastTime", "J", "Lnd/a;", "mCompose", "Lnd/a;", "Lcom/qiahao/nextvideo/room/adapter/GroupMemberRoomOnlineAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMemberRoomOnlineAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMeetingRoomOnlineMemberLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeetingRoomOnlineMemberLayout.kt\ncom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayout\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,209:1\n439#2:210\n439#2:211\n439#2:212\n439#2:213\n439#2:214\n439#2:215\n*S KotlinDebug\n*F\n+ 1 MeetingRoomOnlineMemberLayout.kt\ncom/qiahao/nextvideo/room/view/MeetingRoomOnlineMemberLayout\n*L\n181#1:210\n183#1:211\n186#1:212\n188#1:213\n191#1:214\n193#1:215\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MeetingRoomOnlineMemberLayout extends LinearLayout implements View.OnClickListener {
    public LayoutRoomOnlineMemberBinding binding;
    private boolean isScroll;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompose;

    @NotNull
    private Context mContext;
    private long mCurrentLastTime;

    @Nullable
    private MeetingRoomOnlineMemberLayoutListener mMeetingRoomOnlineMemberLayoutListener;

    @NotNull
    private Runnable mTask;
    private int noble;

    @Nullable
    private CurrentRoomOnlineBeanList roomOnlineBean;
    private int totalNumber;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MeetingRoomOnlineMemberLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GroupMemberRoomOnlineAdapter getMAdapter() {
        return (GroupMemberRoomOnlineAdapter) this.mAdapter.getValue();
    }

    private final void initView() {
        setBinding(LayoutRoomOnlineMemberBinding.inflate(LayoutInflater.from(this.mContext), this, true));
        getBinding().setClick(this);
        RecyclerView recyclerView = getBinding().numberOnlineRecycler;
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(recyclerView.getContext(), 0, false);
        customLinearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(customLinearLayoutManager);
        recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.view.s
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MeetingRoomOnlineMemberLayout.initView$lambda$6(MeetingRoomOnlineMemberLayout.this, baseQuickAdapter, view, i);
            }
        });
        getBinding().numberOnlineRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout$initView$3
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, newState);
                if (newState == 0) {
                    MeetingRoomOnlineMemberLayout.this.isScroll = false;
                } else if (newState == 1 || newState == 2) {
                    MeetingRoomOnlineMemberLayout.this.isScroll = true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MeetingRoomOnlineMemberLayoutListener meetingRoomOnlineMemberLayoutListener;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.CurrentRoomOnlineBean");
        String externalId = ((CurrentRoomOnlineBean) item).getExternalId();
        if (externalId != null && (meetingRoomOnlineMemberLayoutListener = meetingRoomOnlineMemberLayout.mMeetingRoomOnlineMemberLayoutListener) != null) {
            meetingRoomOnlineMemberLayoutListener.meetingRoomOnlineMemberClickUserAvatar(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMemberRoomOnlineAdapter mAdapter_delegate$lambda$2() {
        return new GroupMemberRoomOnlineAdapter(R.layout.item_room_online_member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTask$lambda$1(MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout) {
        CurrentRoomOnlineBeanList currentRoomOnlineBeanList = meetingRoomOnlineMemberLayout.roomOnlineBean;
        if (currentRoomOnlineBeanList != null) {
            meetingRoomOnlineMemberLayout.updateData(currentRoomOnlineBeanList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshData$lambda$7(MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout, ApiResponse apiResponse) {
        long j;
        ArrayList<CurrentRoomOnlineBean> arrayList;
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CurrentRoomOnlineBeanList currentRoomOnlineBeanList = (CurrentRoomOnlineBeanList) apiResponse.getData();
        long j2 = 0;
        if (currentRoomOnlineBeanList != null) {
            j = currentRoomOnlineBeanList.getServiceTime();
        } else {
            j = 0;
        }
        if (j > meetingRoomOnlineMemberLayout.mCurrentLastTime) {
            CurrentRoomOnlineBeanList currentRoomOnlineBeanList2 = (CurrentRoomOnlineBeanList) apiResponse.getData();
            if (currentRoomOnlineBeanList2 != null) {
                j2 = currentRoomOnlineBeanList2.getServiceTime();
            }
            meetingRoomOnlineMemberLayout.mCurrentLastTime = j2;
            GroupMemberRoomOnlineAdapter mAdapter = meetingRoomOnlineMemberLayout.getMAdapter();
            CurrentRoomOnlineBeanList currentRoomOnlineBeanList3 = (CurrentRoomOnlineBeanList) apiResponse.getData();
            if (currentRoomOnlineBeanList3 != null) {
                arrayList = currentRoomOnlineBeanList3.getUsers();
            } else {
                arrayList = null;
            }
            mAdapter.setList(arrayList);
            int i2 = 0;
            if (!meetingRoomOnlineMemberLayout.getMAdapter().getData().isEmpty()) {
                meetingRoomOnlineMemberLayout.getBinding().numberOnlineRecycler.smoothScrollToPosition(0);
            }
            CurrentRoomOnlineBeanList currentRoomOnlineBeanList4 = (CurrentRoomOnlineBeanList) apiResponse.getData();
            if (currentRoomOnlineBeanList4 != null) {
                i = currentRoomOnlineBeanList4.getTotal();
            } else {
                i = 0;
            }
            meetingRoomOnlineMemberLayout.totalNumber = i;
            TextView textView = meetingRoomOnlineMemberLayout.getBinding().numberSum;
            CurrentRoomOnlineBeanList currentRoomOnlineBeanList5 = (CurrentRoomOnlineBeanList) apiResponse.getData();
            if (currentRoomOnlineBeanList5 != null) {
                i2 = currentRoomOnlineBeanList5.getTotal();
            }
            textView.setText(String.valueOf(i2));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshData$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final LayoutRoomOnlineMemberBinding getBinding() {
        LayoutRoomOnlineMemberBinding layoutRoomOnlineMemberBinding = this.binding;
        if (layoutRoomOnlineMemberBinding != null) {
            return layoutRoomOnlineMemberBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final MeetingRoomOnlineMemberLayoutListener getMMeetingRoomOnlineMemberLayoutListener() {
        return this.mMeetingRoomOnlineMemberLayoutListener;
    }

    @NotNull
    public final List<CurrentRoomOnlineBean> getOnLineData() {
        return getMAdapter().getData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131363575) {
            if (id2 == 2131363586) {
                GroupAllRankActivity.INSTANCE.start(this.mContext, MeetingRoomManager.INSTANCE.getMGroupId());
                return;
            }
            return;
        }
        RoomMemberOnlineActivity.INSTANCE.start(this.mContext, MeetingRoomManager.INSTANCE.getMGroupId(), true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCompose.d();
        this.mMeetingRoomOnlineMemberLayoutListener = null;
    }

    public final void refreshData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomOnlineUser(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.view.t
            public final Object invoke(Object obj) {
                Unit refreshData$lambda$7;
                refreshData$lambda$7 = MeetingRoomOnlineMemberLayout.refreshData$lambda$7(MeetingRoomOnlineMemberLayout.this, (ApiResponse) obj);
                return refreshData$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.view.u
            public final Object invoke(Object obj) {
                Unit refreshData$lambda$8;
                refreshData$lambda$8 = MeetingRoomOnlineMemberLayout.refreshData$lambda$8((Throwable) obj);
                return refreshData$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompose);
    }

    public final void refreshGoldView(int noble) {
        this.noble = noble;
        if (noble == 9) {
            getBinding().trophy.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, 2131232361));
            getBinding().trophyRoomRankSum.setTextColor(Color.parseColor("#FFD02B"));
            getBinding().numberImage.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, 2131232707));
            getBinding().numberSum.setTextColor(Color.parseColor("#FFD02B"));
        } else if (noble >= 10) {
            getBinding().trophy.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, 2131232362));
            getBinding().trophyRoomRankSum.setTextColor(Color.parseColor("#FFD02B"));
            getBinding().numberImage.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, 2131232708));
            getBinding().numberSum.setTextColor(Color.parseColor("#FFD02B"));
        } else {
            getBinding().trophy.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, R.drawable.ic_room_rank_trophy));
            getBinding().trophyRoomRankSum.setTextColor(Color.parseColor("#ffd02b"));
            getBinding().numberImage.setImageDrawable(androidx.core.content.a.getDrawable(this.mContext, R.drawable.icon_room_online_right));
            getBinding().numberSum.setTextColor(Color.parseColor("#ccffffff"));
        }
        if (noble > 9) {
            getBinding().trophySVGA.setVisibility(0);
            getBinding().lottieView.setVisibility(0);
            getBinding().trophy.setVisibility(8);
            getBinding().numberImage.setVisibility(8);
            return;
        }
        getBinding().trophySVGA.setVisibility(8);
        getBinding().lottieView.setVisibility(8);
        getBinding().trophy.setVisibility(0);
        getBinding().numberImage.setVisibility(0);
    }

    public final void setBinding(@NotNull LayoutRoomOnlineMemberBinding layoutRoomOnlineMemberBinding) {
        Intrinsics.checkNotNullParameter(layoutRoomOnlineMemberBinding, "<set-?>");
        this.binding = layoutRoomOnlineMemberBinding;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMMeetingRoomOnlineMemberLayoutListener(@Nullable MeetingRoomOnlineMemberLayoutListener meetingRoomOnlineMemberLayoutListener) {
        this.mMeetingRoomOnlineMemberLayoutListener = meetingRoomOnlineMemberLayoutListener;
    }

    public final void updateData(@NotNull CurrentRoomOnlineBeanList currentRoomOnlineBean) {
        Intrinsics.checkNotNullParameter(currentRoomOnlineBean, "currentRoomOnlineBean");
        if (this.isScroll) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            hiloUtils.removeTask(this.mTask);
            this.roomOnlineBean = currentRoomOnlineBean;
            hiloUtils.runInMainThread(this.mTask, 600L);
            return;
        }
        HiloUtils.INSTANCE.removeTask(this.mTask);
        getMAdapter().setList(currentRoomOnlineBean.getUsers());
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        this.totalNumber = meetingRoomManager.getMRoomOnLine();
        getBinding().numberSum.setText(String.valueOf(meetingRoomManager.getMRoomOnLine()));
        this.roomOnlineBean = null;
    }

    public final void updateRankSum(@NotNull String diamond) {
        Intrinsics.checkNotNullParameter(diamond, ExchangeDetailActivity.TYPE_DIAMOND);
        getBinding().trophyRoomRankSum.setText(diamond);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeetingRoomOnlineMemberLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTask = new Runnable() { // from class: com.qiahao.nextvideo.room.view.v
            @Override // java.lang.Runnable
            public final void run() {
                MeetingRoomOnlineMemberLayout.mTask$lambda$1(MeetingRoomOnlineMemberLayout.this);
            }
        };
        this.mCompose = new nd.a();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.w
            public final Object invoke() {
                GroupMemberRoomOnlineAdapter mAdapter_delegate$lambda$2;
                mAdapter_delegate$lambda$2 = MeetingRoomOnlineMemberLayout.mAdapter_delegate$lambda$2();
                return mAdapter_delegate$lambda$2;
            }
        });
        this.mContext = context;
        initView();
    }
}
