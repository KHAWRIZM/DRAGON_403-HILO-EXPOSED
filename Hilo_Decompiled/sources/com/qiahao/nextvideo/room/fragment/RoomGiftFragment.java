package com.qiahao.nextvideo.room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.giftRecord.UploadGiftConfirm;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.FragmentRoomGiftBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.RoomGiftAdapter;
import com.qiahao.nextvideo.ui.giftEffect.UploadGiftEffectActivity;
import com.qiahao.nextvideo.utilities.data_utils.GiftUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u001b\u001a\u00020\u00052#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0004RA\u0010\u001a\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u001cR\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\n\"\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R*\u0010>\u001a\u0016\u0012\u0004\u0012\u00020<\u0018\u00010;j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/RoomGiftFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomGiftBinding;", "<init>", "()V", "", "initData", "initRecycleView", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "position", "", "isSelect", "refreshData", "(IZ)V", "Lkotlin/Function1;", "Lcom/qiahao/base_common/model/GiftData;", "Lkotlin/ParameterName;", "name", "data", "listener", "setSelectGiftListener", "(Lkotlin/jvm/functions/Function1;)V", "checkUploadGift", "onResume", "onDestroy", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "isRequest", "Z", "()Z", "setRequest", "(Z)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "mGiftType", "I", "getMGiftType", "setMGiftType", "(I)V", "Lcom/qiahao/nextvideo/room/adapter/RoomGiftAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/qiahao/nextvideo/room/adapter/RoomGiftAdapter;", "adapter", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MultiGiftData;", "Lkotlin/collections/ArrayList;", "giftItems", "Ljava/util/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomGiftFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomGiftFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomGiftFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n1563#2:175\n1634#2,3:176\n1#3:179\n*S KotlinDebug\n*F\n+ 1 RoomGiftFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomGiftFragment\n*L\n77#1:175\n77#1:176,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGiftFragment extends BaseBindingFragment<FragmentRoomGiftBinding> {

    @NotNull
    public static final String GIFT_TYPE = "gift_type";

    @Nullable
    private ArrayList<MultiGiftData> giftItems;
    private boolean isRequest;

    @Nullable
    private Function1<? super GiftData, Unit> listener;

    @NotNull
    private nd.a compositeDisposable = new nd.a();
    private int mGiftType = 1;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.n0
        public final Object invoke() {
            RoomGiftAdapter adapter_delegate$lambda$0;
            adapter_delegate$lambda$0 = RoomGiftFragment.adapter_delegate$lambda$0();
            return adapter_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomGiftAdapter adapter_delegate$lambda$0() {
        return new RoomGiftAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUploadGift$lambda$8(RoomGiftFragment roomGiftFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Context context = roomGiftFragment.getContext();
        if (context != null) {
            UploadGiftEffectActivity.INSTANCE.startActivity(context, (UploadGiftConfirm) apiResponse.getData());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUploadGift$lambda$9(RoomGiftFragment roomGiftFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomGiftFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomGiftFragment, 2131952667);
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

    private final void initData() {
        if (this.isRequest) {
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().giftListOfType(this.mGiftType), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.o0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = RoomGiftFragment.initData$lambda$4(RoomGiftFragment.this, (ApiResponse) obj);
                return initData$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.p0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = RoomGiftFragment.initData$lambda$5((Throwable) obj);
                return initData$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(RoomGiftFragment roomGiftFragment, ApiResponse apiResponse) {
        ArrayList<MultiGiftData> arrayList;
        TextView textView;
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        MultiGiftData multiGiftData;
        int i;
        MultiGiftData multiGiftData2;
        SuperStatusView superStatusView3;
        int i2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList<GiftData> arrayList2 = (ArrayList) apiResponse.getData();
        GiftData giftData = null;
        int i3 = 0;
        if (arrayList2 != null) {
            arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (GiftData giftData2 : arrayList2) {
                Integer type = giftData2.getType();
                if (type != null) {
                    i2 = type.intValue();
                } else {
                    i2 = 0;
                }
                arrayList.add(new MultiGiftData(i2, giftData2));
            }
        } else {
            arrayList = null;
        }
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.MultiGiftData>");
        roomGiftFragment.giftItems = arrayList;
        if (arrayList != null) {
            GiftUtils.INSTANCE.saveGiftList(roomGiftFragment.mGiftType, arrayList);
        }
        roomGiftFragment.getAdapter().setList(roomGiftFragment.giftItems);
        ArrayList<MultiGiftData> arrayList3 = roomGiftFragment.giftItems;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            roomGiftFragment.isRequest = true;
            FragmentRoomGiftBinding fragmentRoomGiftBinding = (FragmentRoomGiftBinding) roomGiftFragment.getBinding();
            if (fragmentRoomGiftBinding != null && (superStatusView3 = fragmentRoomGiftBinding.statusView) != null) {
                superStatusView3.showContent();
            }
        } else {
            FragmentRoomGiftBinding fragmentRoomGiftBinding2 = (FragmentRoomGiftBinding) roomGiftFragment.getBinding();
            if (fragmentRoomGiftBinding2 != null && (superStatusView2 = fragmentRoomGiftBinding2.statusView) != null) {
                superStatusView2.showEmpty();
            }
            FragmentRoomGiftBinding fragmentRoomGiftBinding3 = (FragmentRoomGiftBinding) roomGiftFragment.getBinding();
            if (fragmentRoomGiftBinding3 != null && (superStatusView = fragmentRoomGiftBinding3.statusView) != null) {
                textView = (TextView) superStatusView.findViewById(2131362075);
            } else {
                textView = null;
            }
            Context context = roomGiftFragment.getContext();
            if (context != null && textView != null) {
                textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
            }
        }
        if (roomGiftFragment.getAdapter().getSelectPosition() == -1) {
            ArrayList<MultiGiftData> arrayList4 = roomGiftFragment.giftItems;
            if (arrayList4 != null) {
                i = arrayList4.size();
            } else {
                i = 0;
            }
            if (i > 0) {
                roomGiftFragment.refreshData(0, true);
                Function1<? super GiftData, Unit> function1 = roomGiftFragment.listener;
                if (function1 != null) {
                    ArrayList<MultiGiftData> arrayList5 = roomGiftFragment.giftItems;
                    if (arrayList5 != null && (multiGiftData2 = arrayList5.get(0)) != null) {
                        giftData = multiGiftData2.getGiftData();
                    }
                    function1.invoke(giftData);
                }
            }
        } else {
            ArrayList<MultiGiftData> arrayList6 = roomGiftFragment.giftItems;
            if (arrayList6 != null) {
                i3 = arrayList6.size();
            }
            if (i3 >= roomGiftFragment.getAdapter().getSelectPosition()) {
                roomGiftFragment.refreshData(roomGiftFragment.getAdapter().getSelectPosition(), true);
                Function1<? super GiftData, Unit> function12 = roomGiftFragment.listener;
                if (function12 != null) {
                    ArrayList<MultiGiftData> arrayList7 = roomGiftFragment.giftItems;
                    if (arrayList7 != null && (multiGiftData = arrayList7.get(roomGiftFragment.getAdapter().getSelectPosition())) != null) {
                        giftData = multiGiftData.getGiftData();
                    }
                    function12.invoke(giftData);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initRecycleView() {
        RecyclerView recyclerView;
        FragmentRoomGiftBinding fragmentRoomGiftBinding = (FragmentRoomGiftBinding) getBinding();
        if (fragmentRoomGiftBinding != null && (recyclerView = fragmentRoomGiftBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.s0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomGiftFragment.initRecycleView$lambda$6(RoomGiftFragment.this, baseQuickAdapter, view, i);
            }
        });
        this.giftItems = GiftUtils.INSTANCE.getGiftList(this.mGiftType);
        getAdapter().setList(this.giftItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycleView$lambda$6(RoomGiftFragment roomGiftFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Integer type;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GiftData giftData = ((MultiGiftData) roomGiftFragment.getAdapter().getData().get(i)).getGiftData();
        if (giftData != null && (type = giftData.getType()) != null && type.intValue() == 1) {
            roomGiftFragment.checkUploadGift();
        } else {
            roomGiftFragment.refreshData(roomGiftFragment.getAdapter().getSelectPosition(), false);
            roomGiftFragment.refreshData(i, true);
        }
    }

    public final void checkUploadGift() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkUploadGiftConfirm(), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.q0
            public final Object invoke(Object obj) {
                Unit checkUploadGift$lambda$8;
                checkUploadGift$lambda$8 = RoomGiftFragment.checkUploadGift$lambda$8(RoomGiftFragment.this, (ApiResponse) obj);
                return checkUploadGift$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.r0
            public final Object invoke(Object obj) {
                Unit checkUploadGift$lambda$9;
                checkUploadGift$lambda$9 = RoomGiftFragment.checkUploadGift$lambda$9(RoomGiftFragment.this, (Throwable) obj);
                return checkUploadGift$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    @NotNull
    public final RoomGiftAdapter getAdapter() {
        return (RoomGiftAdapter) this.adapter.getValue();
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_gift;
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

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "REFRESH_UPLOAD_GIFT") && this.mGiftType == 4) {
            this.isRequest = false;
            initData();
        }
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
        initData();
    }

    public void onResume() {
        Function1<? super GiftData, Unit> function1;
        GiftData giftData;
        MultiGiftData multiGiftData;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (getAdapter().getSelectPosition() != -1 && getAdapter().getData().size() > getAdapter().getSelectPosition() && (function1 = this.listener) != null) {
            ArrayList<MultiGiftData> arrayList = this.giftItems;
            if (arrayList != null && (multiGiftData = arrayList.get(getAdapter().getSelectPosition())) != null) {
                giftData = multiGiftData.getGiftData();
            } else {
                giftData = null;
            }
            function1.invoke(giftData);
        }
    }

    public final void refreshData(int position, boolean isSelect) {
        GiftData giftData;
        MultiGiftData multiGiftData;
        if (getAdapter().getData().size() > position && position != -1) {
            GiftData giftData2 = ((MultiGiftData) getAdapter().getData().get(position)).getGiftData();
            if (giftData2 != null) {
                giftData2.setSelected(isSelect);
            }
            getAdapter().notifyItemChanged(position, Boolean.valueOf(isSelect));
            if (isSelect) {
                getAdapter().setSelectPosition(position);
                Function1<? super GiftData, Unit> function1 = this.listener;
                if (function1 != null) {
                    ArrayList<MultiGiftData> arrayList = this.giftItems;
                    if (arrayList != null && (multiGiftData = arrayList.get(position)) != null) {
                        giftData = multiGiftData.getGiftData();
                    } else {
                        giftData = null;
                    }
                    function1.invoke(giftData);
                }
            }
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
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
}
