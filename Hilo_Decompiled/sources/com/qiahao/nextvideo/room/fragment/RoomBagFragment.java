package com.qiahao.nextvideo.room.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.FragmentRoomBagBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.RoomBagAdapter;
import com.qiahao.nextvideo.ui.reusable.views.PageIndicator;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.List;
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
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010!\u001a\u00020\u0016H\u0014J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0002J\u0016\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0011J\u0012\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0006\u0010'\u001a\u00020\u000bJ+\u0010(\u001a\u00020\u000b2#\u0010\u0005\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J\b\u0010)\u001a\u00020\u000bH\u0016R9\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/RoomBagFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomBagBinding;", "<init>", "()V", "listener", "Lkotlin/Function1;", "Lcom/qiahao/base_common/model/GiftData;", "Lkotlin/ParameterName;", "name", "data", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "isRequest", "", "()Z", "setRequest", "(Z)V", "mGiftType", "", "getMGiftType", "()I", "setMGiftType", "(I)V", "mBagAdapter", "Lcom/qiahao/nextvideo/room/adapter/RoomBagAdapter;", "getMBagAdapter", "()Lcom/qiahao/nextvideo/room/adapter/RoomBagAdapter;", "mBagAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "initRecycleView", "refreshData", "position", "isSelect", "requestData", "setSelectGiftListener", "onResume", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomBagFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomBagFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomBagFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n1878#2,3:158\n*S KotlinDebug\n*F\n+ 1 RoomBagFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomBagFragment\n*L\n93#1:158,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomBagFragment extends BaseBindingFragment<FragmentRoomBagBinding> {

    @NotNull
    public static final String GIFT_TYPE = "gift_type";
    private boolean isRequest;

    @Nullable
    private Function1<? super GiftData, Unit> listener;
    private int mGiftType = 1;

    /* renamed from: mBagAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBagAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.k0
        public final Object invoke() {
            RoomBagAdapter mBagAdapter_delegate$lambda$0;
            mBagAdapter_delegate$lambda$0 = RoomBagFragment.mBagAdapter_delegate$lambda$0();
            return mBagAdapter_delegate$lambda$0;
        }
    });

    private final RoomBagAdapter getMBagAdapter() {
        return (RoomBagAdapter) this.mBagAdapter.getValue();
    }

    private final void initRecycleView() {
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SuperStatusView superStatusView3;
        SuperStatusView superStatusView4;
        SuperStatusView superStatusView5;
        RecyclerView recyclerView;
        FragmentRoomBagBinding fragmentRoomBagBinding = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding != null && (recyclerView = fragmentRoomBagBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMBagAdapter());
        }
        FragmentRoomBagBinding fragmentRoomBagBinding2 = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding2 != null && (superStatusView5 = fragmentRoomBagBinding2.statusView) != null) {
            superStatusView5.addStatus(Status.Empty.INSTANCE, R.layout.gift_status_empty);
        }
        FragmentRoomBagBinding fragmentRoomBagBinding3 = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding3 != null && (superStatusView4 = fragmentRoomBagBinding3.statusView) != null) {
            superStatusView4.addStatus(Status.Error.INSTANCE, R.layout.gift_status_empty);
        }
        FragmentRoomBagBinding fragmentRoomBagBinding4 = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding4 != null && (superStatusView3 = fragmentRoomBagBinding4.statusView) != null) {
            superStatusView3.addStatus(Status.Loading.INSTANCE, 2131558549);
        }
        FragmentRoomBagBinding fragmentRoomBagBinding5 = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding5 != null && (superStatusView2 = fragmentRoomBagBinding5.statusView) != null) {
            superStatusView2.addStatus(Status.NoNetwork.INSTANCE, R.layout.gift_status_empty);
        }
        FragmentRoomBagBinding fragmentRoomBagBinding6 = (FragmentRoomBagBinding) getBinding();
        if (fragmentRoomBagBinding6 != null && (superStatusView = fragmentRoomBagBinding6.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.fragment.RoomBagFragment$initRecycleView$1
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    RoomBagFragment.this.requestData();
                }
            });
        }
        getMBagAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.j0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomBagFragment.initRecycleView$lambda$1(RoomBagFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycleView$lambda$1(RoomBagFragment roomBagFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        roomBagFragment.refreshData(roomBagFragment.getMBagAdapter().getSelectPosition(), false);
        roomBagFragment.refreshData(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomBagAdapter mBagAdapter_delegate$lambda$0() {
        return new RoomBagAdapter();
    }

    public static /* synthetic */ void refreshData$default(RoomBagFragment roomBagFragment, GiftData giftData, int i, Object obj) {
        if ((i & 1) != 0) {
            giftData = null;
        }
        roomBagFragment.refreshData(giftData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$5(RoomBagFragment roomBagFragment, ApiResponse apiResponse) {
        SuperStatusView superStatusView;
        PageIndicator pageIndicator;
        List list;
        SuperStatusView superStatusView2;
        Intrinsics.checkNotNullParameter(apiResponse, TUIConstants.TUICalling.METHOD_NAME_CALL);
        if (apiResponse.getData() != null && ((list = (List) apiResponse.getData()) == null || !list.isEmpty())) {
            roomBagFragment.isRequest = true;
            FragmentRoomBagBinding fragmentRoomBagBinding = (FragmentRoomBagBinding) roomBagFragment.getBinding();
            if (fragmentRoomBagBinding != null && (superStatusView2 = fragmentRoomBagBinding.statusView) != null) {
                superStatusView2.showContent();
            }
        } else {
            FragmentRoomBagBinding fragmentRoomBagBinding2 = (FragmentRoomBagBinding) roomBagFragment.getBinding();
            if (fragmentRoomBagBinding2 != null && (superStatusView = fragmentRoomBagBinding2.statusView) != null) {
                superStatusView.showEmpty();
            }
            Function1<? super GiftData, Unit> function1 = roomBagFragment.listener;
            if (function1 != null) {
                function1.invoke((Object) null);
            }
        }
        List list2 = (List) apiResponse.getData();
        if (list2 != null) {
            roomBagFragment.getMBagAdapter().setList(list2);
            if (roomBagFragment.getMBagAdapter().getSelectPosition() == -1) {
                if (list2.size() > 0) {
                    roomBagFragment.refreshData(0, true);
                }
            } else if (list2.size() >= roomBagFragment.getMBagAdapter().getSelectPosition()) {
                roomBagFragment.refreshData(roomBagFragment.getMBagAdapter().getSelectPosition(), true);
            }
            int ceil = (int) Math.ceil(roomBagFragment.getMBagAdapter().getItemCount() / 8);
            FragmentRoomBagBinding fragmentRoomBagBinding3 = (FragmentRoomBagBinding) roomBagFragment.getBinding();
            if (fragmentRoomBagBinding3 != null && (pageIndicator = fragmentRoomBagBinding3.pageIndicator) != null) {
                pageIndicator.setPageCount(ceil);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$6(RoomBagFragment roomBagFragment, Throwable th) {
        SuperStatusView superStatusView;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentRoomBagBinding fragmentRoomBagBinding = (FragmentRoomBagBinding) roomBagFragment.getBinding();
        if (fragmentRoomBagBinding != null && (superStatusView = fragmentRoomBagBinding.statusView) != null) {
            superStatusView.showNoNetwork();
        }
        Function1<? super GiftData, Unit> function1 = roomBagFragment.listener;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_bag;
    }

    @Nullable
    public final Function1<GiftData, Unit> getListener() {
        return this.listener;
    }

    public final int getMGiftType() {
        return this.mGiftType;
    }

    /* renamed from: isRequest, reason: from getter */
    public final boolean getIsRequest() {
        return this.isRequest;
    }

    public void onInitialize() {
        int i;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("gift_type");
        } else {
            i = 1;
        }
        this.mGiftType = i;
        initRecycleView();
    }

    public void onResume() {
        Function1<? super GiftData, Unit> function1;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (getMBagAdapter().getSelectPosition() != -1 && getMBagAdapter().getData().size() > getMBagAdapter().getSelectPosition() && (function1 = this.listener) != null) {
            function1.invoke(getMBagAdapter().getData().get(getMBagAdapter().getSelectPosition()));
        }
        requestData();
    }

    public final void refreshData(int position, boolean isSelect) {
        if (getMBagAdapter().getData().size() <= position || position == -1) {
            return;
        }
        ((GiftData) getMBagAdapter().getData().get(position)).setSelected(isSelect);
        getMBagAdapter().notifyItemChanged(position, Boolean.valueOf(isSelect));
        if (isSelect) {
            getMBagAdapter().setSelectPosition(position);
            Function1<? super GiftData, Unit> function1 = this.listener;
            if (function1 != null) {
                function1.invoke(getMBagAdapter().getData().get(position));
            }
        }
    }

    public final void requestData() {
        if (this.isRequest) {
            return;
        }
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getBagGiftList(this.mGiftType), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.l0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$5;
                requestData$lambda$5 = RoomBagFragment.requestData$lambda$5(RoomBagFragment.this, (ApiResponse) obj);
                return requestData$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.m0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$6;
                requestData$lambda$6 = RoomBagFragment.requestData$lambda$6(RoomBagFragment.this, (Throwable) obj);
                return requestData$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void setListener(@Nullable Function1<? super GiftData, Unit> function1) {
        this.listener = function1;
    }

    public final void setMGiftType(int i) {
        this.mGiftType = i;
    }

    public final void setRequest(boolean z) {
        this.isRequest = z;
    }

    public final void setSelectGiftListener(@NotNull Function1<? super GiftData, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void refreshData(@Nullable GiftData data) {
        if (data != null) {
            int i = -1;
            int i2 = 0;
            for (Object obj : getMBagAdapter().getData()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(data.getBagId(), ((GiftData) obj).getBagId())) {
                    i = i2;
                }
                i2 = i3;
            }
            if (i != -1) {
                Integer count = data.getCount();
                if ((count != null ? count.intValue() : 0) == 0) {
                    getMBagAdapter().removeAt(i);
                    Function1<? super GiftData, Unit> function1 = this.listener;
                    if (function1 != null) {
                        function1.invoke((Object) null);
                        return;
                    }
                    return;
                }
                data.setSelected(true);
                getMBagAdapter().setData(i, data);
            }
        }
    }
}
