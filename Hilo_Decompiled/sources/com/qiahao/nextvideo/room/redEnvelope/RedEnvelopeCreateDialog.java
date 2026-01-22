package com.qiahao.nextvideo.room.redEnvelope;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.RefreshDiamond;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomEnvelopeConfig;
import com.qiahao.nextvideo.data.room.RoomEnvelopeData;
import com.qiahao.nextvideo.databinding.DialogRedEnvelopeCreateBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.home.medal.MedalActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeCreateDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogRedEnvelopeCreateBinding;", "<init>", "()V", "", "initData", "initView", "createEnvelope", "Landroid/widget/TextView;", "buttonText", "", "isSelect", "refreshButton", "(Landroid/widget/TextView;Z)V", "", "getLayoutResId", "()I", "onInitialize", "onStart", "getHeight", "dismiss", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "", "roomCoins", "J", "roomQuantity", "worldCoins", "worldQuantity", "selectRoom", "Z", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRedEnvelopeCreateDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RedEnvelopeCreateDialog.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeCreateDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n61#2,9:224\n61#2,9:233\n61#2,9:242\n61#2,9:251\n61#2,9:260\n61#2,9:269\n61#2,9:278\n61#2,9:287\n61#2,9:296\n1#3:305\n*S KotlinDebug\n*F\n+ 1 RedEnvelopeCreateDialog.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeCreateDialog\n*L\n93#1:224,9\n96#1:233,9\n99#1:242,9\n109#1:251,9\n114#1:260,9\n128#1:269,9\n142#1:278,9\n147#1:287,9\n151#1:296,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeCreateDialog extends BaseBindingDialogFragment<DialogRedEnvelopeCreateBinding> {
    private long roomCoins;
    private long roomQuantity;
    private long worldCoins;
    private long worldQuantity;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();
    private boolean selectRoom = true;

    public static final /* synthetic */ DialogRedEnvelopeCreateBinding access$getBinding(RedEnvelopeCreateDialog redEnvelopeCreateDialog) {
        return (DialogRedEnvelopeCreateBinding) redEnvelopeCreateDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createEnvelope() {
        double d;
        long j;
        long j2;
        long j3;
        long j4;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (this.selectRoom) {
            j = this.roomCoins;
        } else {
            j = this.worldCoins;
        }
        if (d < j) {
            Context context = getContext();
            if (context != null) {
                new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$createEnvelope$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null) {
                            service.openWallet();
                        }
                    }
                }).show();
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        boolean z = this.selectRoom;
        if (z) {
            j2 = 0;
        } else {
            j2 = 1;
        }
        if (z) {
            j3 = this.roomCoins;
        } else {
            j3 = this.worldCoins;
        }
        if (z) {
            j4 = this.roomQuantity;
        } else {
            j4 = this.worldQuantity;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.sendEnvelope(j2, j3, j4), new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.g
            public final Object invoke(Object obj) {
                Unit createEnvelope$lambda$22;
                createEnvelope$lambda$22 = RedEnvelopeCreateDialog.createEnvelope$lambda$22(RedEnvelopeCreateDialog.this, (ApiResponse) obj);
                return createEnvelope$lambda$22;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.h
            public final Object invoke(Object obj) {
                Unit createEnvelope$lambda$23;
                createEnvelope$lambda$23 = RedEnvelopeCreateDialog.createEnvelope$lambda$23(RedEnvelopeCreateDialog.this, (Throwable) obj);
                return createEnvelope$lambda$23;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createEnvelope$lambda$22(RedEnvelopeCreateDialog redEnvelopeCreateDialog, ApiResponse apiResponse) {
        double d;
        Long diamond;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        RefreshDiamond refreshDiamond = (RefreshDiamond) apiResponse.getData();
        if (refreshDiamond != null && (diamond = refreshDiamond.getDiamond()) != null) {
            d = diamond.longValue();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        redEnvelopeCreateDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createEnvelope$lambda$23(RedEnvelopeCreateDialog redEnvelopeCreateDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = redEnvelopeCreateDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(redEnvelopeCreateDialog, 2131952667);
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
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                if (userObjectEvent != null) {
                    RedEnvelopeCreateDialog redEnvelopeCreateDialog = RedEnvelopeCreateDialog.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView = RedEnvelopeCreateDialog.access$getBinding(redEnvelopeCreateDialog).diamond;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        textView.setText(String.valueOf(user != null ? Long.valueOf((long) user.getDiamondNum()) : null));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.mCompositeDisposable);
    }

    private final void initView() {
        Long l;
        RoomEnvelopeConfig luckyBag;
        RoomEnvelopeData room;
        ArrayList<Long> quantity;
        RoomEnvelopeConfig luckyBag2;
        RoomEnvelopeData room2;
        ArrayList<Long> diamond;
        ((DialogRedEnvelopeCreateBinding) getBinding()).coinsNumber.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.e
            public final Object invoke(Object obj) {
                Unit initView$lambda$1;
                initView$lambda$1 = RedEnvelopeCreateDialog.initView$lambda$1(RedEnvelopeCreateDialog.this, ((Long) obj).longValue());
                return initView$lambda$1;
            }
        });
        ((DialogRedEnvelopeCreateBinding) getBinding()).quantityNumber.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.f
            public final Object invoke(Object obj) {
                Unit initView$lambda$2;
                initView$lambda$2 = RedEnvelopeCreateDialog.initView$lambda$2(RedEnvelopeCreateDialog.this, ((Long) obj).longValue());
                return initView$lambda$2;
            }
        });
        final FrameLayout frameLayout = ((DialogRedEnvelopeCreateBinding) getBinding()).frameLayout;
        final long j = 800;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView = ((DialogRedEnvelopeCreateBinding) getBinding()).buttonBg;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                }
            }
        });
        final ImageView imageView2 = ((DialogRedEnvelopeCreateBinding) getBinding()).helper;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        RoomTipDialog tipContent = new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131952622));
                        tipContent.getBinding().content.setGravity(8388611);
                        tipContent.getBinding().cancel.setVisibility(8);
                        tipContent.show();
                    }
                }
            }
        });
        final ImageView imageView3 = ((DialogRedEnvelopeCreateBinding) getBinding()).list;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        RedEnvelopeRecordActivity.INSTANCE.start(context);
                    }
                }
            }
        });
        final TextView textView = ((DialogRedEnvelopeCreateBinding) getBinding()).room;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long j2;
                long j3;
                RoomEnvelopeConfig luckyBag3;
                RoomEnvelopeData room3;
                ArrayList<Long> quantity2;
                RoomEnvelopeConfig luckyBag4;
                RoomEnvelopeData room4;
                ArrayList<Long> diamond2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.selectRoom = true;
                    RedEnvelopeCreateDialog redEnvelopeCreateDialog = this;
                    TextView textView2 = RedEnvelopeCreateDialog.access$getBinding(redEnvelopeCreateDialog).room;
                    Intrinsics.checkNotNullExpressionValue(textView2, MedalActivity.TYPE_ROOM);
                    redEnvelopeCreateDialog.refreshButton(textView2, true);
                    RedEnvelopeCreateDialog redEnvelopeCreateDialog2 = this;
                    TextView textView3 = RedEnvelopeCreateDialog.access$getBinding(redEnvelopeCreateDialog2).world;
                    Intrinsics.checkNotNullExpressionValue(textView3, "world");
                    redEnvelopeCreateDialog2.refreshButton(textView3, false);
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
                    if (mGroupDetailBean != null && (luckyBag4 = mGroupDetailBean.getLuckyBag()) != null && (room4 = luckyBag4.getRoom()) != null && (diamond2 = room4.getDiamond()) != null) {
                        RedEnvelopeCreateDialog.access$getBinding(this).coinsNumber.refreshList(diamond2);
                    }
                    GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
                    if (mGroupDetailBean2 != null && (luckyBag3 = mGroupDetailBean2.getLuckyBag()) != null && (room3 = luckyBag3.getRoom()) != null && (quantity2 = room3.getQuantity()) != null) {
                        RedEnvelopeCreateDialog.access$getBinding(this).quantityNumber.refreshList(quantity2);
                    }
                    EnvelopeNumberView envelopeNumberView = RedEnvelopeCreateDialog.access$getBinding(this).coinsNumber;
                    j2 = this.roomCoins;
                    envelopeNumberView.refreshPosition(j2);
                    EnvelopeNumberView envelopeNumberView2 = RedEnvelopeCreateDialog.access$getBinding(this).quantityNumber;
                    j3 = this.roomQuantity;
                    envelopeNumberView2.refreshPosition(j3);
                }
            }
        });
        final TextView textView2 = ((DialogRedEnvelopeCreateBinding) getBinding()).world;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long j2;
                long j3;
                RoomEnvelopeConfig luckyBag3;
                RoomEnvelopeData world;
                ArrayList<Long> quantity2;
                RoomEnvelopeConfig luckyBag4;
                RoomEnvelopeData world2;
                ArrayList<Long> diamond2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.selectRoom = false;
                    RedEnvelopeCreateDialog redEnvelopeCreateDialog = this;
                    TextView textView3 = RedEnvelopeCreateDialog.access$getBinding(redEnvelopeCreateDialog).room;
                    Intrinsics.checkNotNullExpressionValue(textView3, MedalActivity.TYPE_ROOM);
                    redEnvelopeCreateDialog.refreshButton(textView3, false);
                    RedEnvelopeCreateDialog redEnvelopeCreateDialog2 = this;
                    TextView textView4 = RedEnvelopeCreateDialog.access$getBinding(redEnvelopeCreateDialog2).world;
                    Intrinsics.checkNotNullExpressionValue(textView4, "world");
                    redEnvelopeCreateDialog2.refreshButton(textView4, true);
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
                    if (mGroupDetailBean != null && (luckyBag4 = mGroupDetailBean.getLuckyBag()) != null && (world2 = luckyBag4.getWorld()) != null && (diamond2 = world2.getDiamond()) != null) {
                        RedEnvelopeCreateDialog.access$getBinding(this).coinsNumber.refreshList(diamond2);
                    }
                    GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
                    if (mGroupDetailBean2 != null && (luckyBag3 = mGroupDetailBean2.getLuckyBag()) != null && (world = luckyBag3.getWorld()) != null && (quantity2 = world.getQuantity()) != null) {
                        RedEnvelopeCreateDialog.access$getBinding(this).quantityNumber.refreshList(quantity2);
                    }
                    EnvelopeNumberView envelopeNumberView = RedEnvelopeCreateDialog.access$getBinding(this).coinsNumber;
                    j2 = this.worldCoins;
                    envelopeNumberView.refreshPosition(j2);
                    EnvelopeNumberView envelopeNumberView2 = RedEnvelopeCreateDialog.access$getBinding(this).quantityNumber;
                    j3 = this.worldQuantity;
                    envelopeNumberView2.refreshPosition(j3);
                }
            }
        });
        final TextView textView3 = ((DialogRedEnvelopeCreateBinding) getBinding()).send;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.createEnvelope();
                }
            }
        });
        final TextView textView4 = ((DialogRedEnvelopeCreateBinding) getBinding()).recharge;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        service.openWallet();
                    }
                }
            }
        });
        final ImageView imageView4 = ((DialogRedEnvelopeCreateBinding) getBinding()).arrow;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog$initView$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        service.openWallet();
                    }
                }
            }
        });
        TextView textView5 = ((DialogRedEnvelopeCreateBinding) getBinding()).diamond;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            l = Long.valueOf((long) user.getDiamondNum());
        } else {
            l = null;
        }
        textView5.setText(String.valueOf(l));
        TextView textView6 = ((DialogRedEnvelopeCreateBinding) getBinding()).room;
        Intrinsics.checkNotNullExpressionValue(textView6, MedalActivity.TYPE_ROOM);
        refreshButton(textView6, this.selectRoom);
        TextView textView7 = ((DialogRedEnvelopeCreateBinding) getBinding()).world;
        Intrinsics.checkNotNullExpressionValue(textView7, "world");
        refreshButton(textView7, !this.selectRoom);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
        if (mGroupDetailBean != null && (luckyBag2 = mGroupDetailBean.getLuckyBag()) != null && (room2 = luckyBag2.getRoom()) != null && (diamond = room2.getDiamond()) != null) {
            ((DialogRedEnvelopeCreateBinding) getBinding()).coinsNumber.refreshList(diamond);
            if (!diamond.isEmpty()) {
                this.roomCoins = diamond.get(0).longValue();
            }
        }
        GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
        if (mGroupDetailBean2 != null && (luckyBag = mGroupDetailBean2.getLuckyBag()) != null && (room = luckyBag.getRoom()) != null && (quantity = room.getQuantity()) != null) {
            ((DialogRedEnvelopeCreateBinding) getBinding()).quantityNumber.refreshList(quantity);
            if (!quantity.isEmpty()) {
                this.roomQuantity = quantity.get(0).longValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(RedEnvelopeCreateDialog redEnvelopeCreateDialog, long j) {
        if (redEnvelopeCreateDialog.selectRoom) {
            redEnvelopeCreateDialog.roomCoins = j;
        } else {
            redEnvelopeCreateDialog.worldCoins = j;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(RedEnvelopeCreateDialog redEnvelopeCreateDialog, long j) {
        if (redEnvelopeCreateDialog.selectRoom) {
            redEnvelopeCreateDialog.roomQuantity = j;
        } else {
            redEnvelopeCreateDialog.worldQuantity = j;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshButton(TextView buttonText, boolean isSelect) {
        Drawable drawable = null;
        if (isSelect) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.envelope_yellow);
            }
            buttonText.setBackground(drawable);
            buttonText.setTextColor(Color.parseColor("#EF003E"));
            return;
        }
        Context context2 = getContext();
        if (context2 != null) {
            drawable = androidx.core.content.a.getDrawable(context2, R.drawable.envelope_red);
        }
        buttonText.setBackground(drawable);
        buttonText.setTextColor(Color.parseColor("#ffffff"));
    }

    public void dismiss() {
        super/*androidx.fragment.app.DialogFragment*/.dismiss();
        this.mCompositeDisposable.d();
    }

    protected int getHeight() {
        return -1;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_red_envelope_create;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
        }
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
