package com.qiahao.nextvideo.room.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftShortcutData;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.DialogRoomGiftBinding;
import com.qiahao.nextvideo.databinding.PopWindowGiftNumberRecyclerBinding;
import com.qiahao.nextvideo.databinding.ViewGiftMemberRecyclerBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.adapter.PopUpGiftMemberAdapter;
import com.qiahao.nextvideo.room.adapter.PopUpGiftNumberAdapter;
import com.qiahao.nextvideo.room.adapter.RoomGiftTabLayoutAdapter;
import com.qiahao.nextvideo.room.fragment.RoomBagFragment;
import com.qiahao.nextvideo.room.fragment.RoomGiftFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.SetGroupSendGiftListener;
import com.qiahao.nextvideo.room.viewmodel.RoomGiftViewModel;
import com.qiahao.nextvideo.ui.home.medal.MedalLevelDialog;
import com.qiahao.nextvideo.ui.svip.SvipPrivilegesActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import com.tencent.qcloud.tuicore.util.PopWindowUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LB/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0014J\b\u00106\u001a\u000205H\u0014J\b\u00107\u001a\u000203H\u0016J\b\u00108\u001a\u000203H\u0002J\u0016\u00109\u001a\u0002032\f\u0010:\u001a\b\u0012\u0004\u0012\u0002030;H\u0002J\b\u0010<\u001a\u000203H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\bH\u0002J\b\u0010@\u001a\u000203H\u0002J\u0012\u0010A\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u000203H\u0002J\u000e\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020HJ\u0010\u0010I\u001a\u0002032\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u001bJ\b\u0010K\u001a\u000203H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00040'j\b\u0012\u0004\u0012\u00020\u0004`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020*0'j\b\u0012\u0004\u0012\u00020*`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b/\u00100¨\u0006M"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomGiftDialogFragment;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogRoomGiftBinding;", "extraId", "", "userName", "groupId", "isAllMic", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getExtraId", "()Ljava/lang/String;", "getUserName", "getGroupId", "mPopUpGiftMemberAdapter", "Lcom/qiahao/nextvideo/room/adapter/PopUpGiftMemberAdapter;", "getMPopUpGiftMemberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PopUpGiftMemberAdapter;", "mPopUpGiftMemberAdapter$delegate", "Lkotlin/Lazy;", "mPopUpGiftNumberAdapter", "Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "getMPopUpGiftNumberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "mPopUpGiftNumberAdapter$delegate", "sendGiftListener", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "getSendGiftListener", "()Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "setSendGiftListener", "(Lcom/qiahao/base_common/interfaceing/SendGiftListener;)V", "giftShortcutData", "Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "getGiftShortcutData", "()Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "setGiftShortcutData", "(Lcom/qiahao/nextvideo/data/model/GiftShortcutData;)V", "mTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mFragments", "Landroidx/fragment/app/Fragment;", "mRoomBagFragment", "Lcom/qiahao/nextvideo/room/fragment/RoomBagFragment;", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "viewModel$delegate", "onStart", "", "getLayoutResId", "", "getGravity", "onInitialize", "clickGift", "showGiftTextDialog", "listener", "Lkotlin/Function0;", "sendBagGift", "initData", "showBag", "isShow", "initViewPage", "requestShorcut", "data", "Lcom/qiahao/base_common/model/GiftData;", "toSVIPPrivileges", "refreshTopLayout", "showGiftNumberPopWindow", "view", "Landroid/view/View;", "showPopUpMicroView", "setListener", "onResume", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomGiftDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomGiftDialogFragment.kt\ncom/qiahao/nextvideo/room/dialog/RoomGiftDialogFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n61#2,9:666\n61#2,9:675\n61#2,9:684\n61#2,9:693\n61#2,9:702\n61#2,9:711\n61#2,9:720\n61#2,9:733\n61#2,9:742\n61#2,9:751\n61#2,9:760\n61#2,9:769\n61#2,9:778\n1#3:729\n1878#4,3:730\n*S KotlinDebug\n*F\n+ 1 RoomGiftDialogFragment.kt\ncom/qiahao/nextvideo/room/dialog/RoomGiftDialogFragment\n*L\n130#1:666,9\n134#1:675,9\n138#1:684,9\n142#1:693,9\n146#1:702,9\n151#1:711,9\n154#1:720,9\n472#1:733,9\n497#1:742,9\n512#1:751,9\n532#1:760,9\n552#1:769,9\n563#1:778,9\n356#1:730,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGiftDialogFragment extends BaseBindingDialogFragment<DialogRoomGiftBinding> {
    public static final int SEND_TYPE_ALL_MIC = 1;
    public static final int SEND_TYPE_ALL_PERSON = 0;
    public static final int SEND_TYPE_ALL_ROOM = 2;

    @NotNull
    private final String extraId;

    @Nullable
    private GiftShortcutData giftShortcutData;

    @NotNull
    private final String groupId;
    private final boolean isAllMic;

    @NotNull
    private ArrayList<Fragment> mFragments;

    /* renamed from: mPopUpGiftMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPopUpGiftMemberAdapter;

    /* renamed from: mPopUpGiftNumberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPopUpGiftNumberAdapter;

    @Nullable
    private RoomBagFragment mRoomBagFragment;

    @NotNull
    private ArrayList<String> mTypeList;

    @Nullable
    private SendGiftListener sendGiftListener;

    @NotNull
    private final String userName;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public RoomGiftDialogFragment() {
        this(null, null, null, false, 15, null);
    }

    public static final /* synthetic */ DialogRoomGiftBinding access$getBinding(RoomGiftDialogFragment roomGiftDialogFragment) {
        return (DialogRoomGiftBinding) roomGiftDialogFragment.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
    
        if (r0 >= (getViewModel().getGiftNumber() * getViewModel().getExtraIdList().size())) goto L٤٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void clickGift() {
        Integer type;
        Integer count;
        int i;
        Integer count2;
        String str;
        String str2;
        Long l = null;
        if (getViewModel().getExtraIdList().isEmpty()) {
            if (getViewModel().getMSendType() == 1) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str2 = user.getExternalId();
                } else {
                    str2 = null;
                }
                if (meetingRoomManager.checkUserOnMic(str2)) {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952168), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        return;
                    }
                    return;
                }
            }
            if (getViewModel().getMSendType() == 0) {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131953535), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                    return;
                }
                return;
            }
        }
        int i2 = 0;
        if (getViewModel().getMSendType() == 0) {
            String str3 = getViewModel().getExtraIdList().get(0);
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null) {
                str = user2.getExternalId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str3, str)) {
                Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952168), false, 4, (Object) null);
                if (normal$default3 != null) {
                    normal$default3.show();
                    return;
                }
                return;
            }
        }
        GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null) {
            l = selectedGift.getBagId();
        }
        if (l != null) {
            if (getViewModel().getMSendType() == 1) {
                GiftData selectedGift2 = getViewModel().getSelectedGift();
                if (selectedGift2 != null && (count2 = selectedGift2.getCount()) != null) {
                    i = count2.intValue();
                } else {
                    i = 0;
                }
            }
            GiftData selectedGift3 = getViewModel().getSelectedGift();
            if (selectedGift3 != null && (count = selectedGift3.getCount()) != null) {
                i2 = count.intValue();
            }
            if (i2 >= getViewModel().getGiftNumber()) {
                showGiftTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.u2
                    public final Object invoke() {
                        Unit clickGift$lambda$11;
                        clickGift$lambda$11 = RoomGiftDialogFragment.clickGift$lambda$11(RoomGiftDialogFragment.this);
                        return clickGift$lambda$11;
                    }
                });
                return;
            }
            Toast normal$default4 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952063), false, 4, (Object) null);
            if (normal$default4 != null) {
                normal$default4.show();
                return;
            }
            return;
        }
        final GiftData selectedGift4 = getViewModel().getSelectedGift();
        if (selectedGift4 == null || (type = selectedGift4.getType()) == null || type.intValue() != 0) {
            return;
        }
        double d = 0.0d;
        if (getViewModel().getMSendType() == 1) {
            User user3 = UserStore.INSTANCE.getShared().getUser();
            if (user3 != null) {
                d = user3.getDiamondNum();
            }
            if (d < selectedGift4.getDiamondNum() * getViewModel().getGiftNumber() * getViewModel().getExtraIdList().size()) {
                Context context = getContext();
                if (context != null) {
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$clickGift$2$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SendGiftListener sendGiftListener = RoomGiftDialogFragment.this.getSendGiftListener();
                            if (sendGiftListener != null) {
                                sendGiftListener.showRechargeView();
                            }
                            RoomGiftDialogFragment.this.dismiss();
                        }
                    }).show();
                    return;
                }
                return;
            }
        } else if (getViewModel().getMSendType() == 0) {
            User user4 = UserStore.INSTANCE.getShared().getUser();
            if (user4 != null) {
                d = user4.getDiamondNum();
            }
            if (d < selectedGift4.getDiamondNum() * getViewModel().getGiftNumber()) {
                Context context2 = getContext();
                if (context2 != null) {
                    new TipDialog(context2).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$clickGift$2$2$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SendGiftListener sendGiftListener = RoomGiftDialogFragment.this.getSendGiftListener();
                            if (sendGiftListener != null) {
                                sendGiftListener.showRechargeView();
                            }
                            RoomGiftDialogFragment.this.dismiss();
                        }
                    }).show();
                    return;
                }
                return;
            }
        }
        showGiftTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.v2
            public final Object invoke() {
                Unit clickGift$lambda$15$lambda$14;
                clickGift$lambda$15$lambda$14 = RoomGiftDialogFragment.clickGift$lambda$15$lambda$14(RoomGiftDialogFragment.this, selectedGift4);
                return clickGift$lambda$15$lambda$14;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickGift$lambda$11(RoomGiftDialogFragment roomGiftDialogFragment) {
        roomGiftDialogFragment.sendBagGift();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickGift$lambda$15$lambda$14(RoomGiftDialogFragment roomGiftDialogFragment, GiftData giftData) {
        SendGiftListener sendGiftListener = roomGiftDialogFragment.sendGiftListener;
        if (sendGiftListener != null) {
            sendGiftListener.roomGiftsChoose(giftData, roomGiftDialogFragment.getViewModel().getGiftNumber(), roomGiftDialogFragment.getViewModel().getExtraIdList(), roomGiftDialogFragment.getViewModel().getMSendType());
        }
        return Unit.INSTANCE;
    }

    private final PopUpGiftMemberAdapter getMPopUpGiftMemberAdapter() {
        return (PopUpGiftMemberAdapter) this.mPopUpGiftMemberAdapter.getValue();
    }

    private final PopUpGiftNumberAdapter getMPopUpGiftNumberAdapter() {
        return (PopUpGiftNumberAdapter) this.mPopUpGiftNumberAdapter.getValue();
    }

    private final void initData() {
        Long l;
        if (this.isAllMic) {
            getViewModel().setMSendType(1);
        } else {
            getViewModel().setMSendType(0);
        }
        if (getViewModel().getMSendType() == 1) {
            ((DialogRoomGiftBinding) getBinding()).userName.setText(ResourcesKtxKt.getStringById(this, 2131952950));
            getViewModel().setSendAllMicMember(MeetingRoomManager.INSTANCE.getMicQueueMemberList());
        } else if (!TextUtils.isEmpty(this.extraId) && !TextUtils.isEmpty(this.userName)) {
            ((DialogRoomGiftBinding) getBinding()).userName.setText(this.userName);
            getViewModel().getExtraIdList().clear();
            getViewModel().getExtraIdList().add(this.extraId);
        }
        TextView textView = ((DialogRoomGiftBinding) getBinding()).diamondText;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            l = Long.valueOf((long) user.getDiamondNum());
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        nd.c subscribe = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                if (userObjectEvent != null) {
                    RoomGiftDialogFragment roomGiftDialogFragment = RoomGiftDialogFragment.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView2 = RoomGiftDialogFragment.access$getBinding(roomGiftDialogFragment).diamondText;
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        textView2.setText(String.valueOf(user2 != null ? Long.valueOf((long) user2.getDiamondNum()) : null));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        AppRequestUtils.INSTANCE.refreshDiamondOrGem();
    }

    private final void initViewPage() {
        this.mTypeList.clear();
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952885));
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952398));
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952394));
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952632));
        this.mTypeList.add("");
        if (this.mFragments.isEmpty()) {
            int i = 0;
            for (Object obj : this.mTypeList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i < 4) {
                    Fragment roomGiftFragment = new RoomGiftFragment();
                    roomGiftFragment.setSelectGiftListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s2
                        public final Object invoke(Object obj2) {
                            Unit initViewPage$lambda$27$lambda$24;
                            initViewPage$lambda$27$lambda$24 = RoomGiftDialogFragment.initViewPage$lambda$27$lambda$24(RoomGiftDialogFragment.this, (GiftData) obj2);
                            return initViewPage$lambda$27$lambda$24;
                        }
                    });
                    Bundle bundle = new Bundle();
                    bundle.putInt("gift_type", i2);
                    roomGiftFragment.setArguments(bundle);
                    this.mFragments.add(roomGiftFragment);
                } else if (i == 4) {
                    RoomBagFragment roomBagFragment = new RoomBagFragment();
                    this.mRoomBagFragment = roomBagFragment;
                    roomBagFragment.setSelectGiftListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.t2
                        public final Object invoke(Object obj2) {
                            Unit initViewPage$lambda$27$lambda$25;
                            initViewPage$lambda$27$lambda$25 = RoomGiftDialogFragment.initViewPage$lambda$27$lambda$25(RoomGiftDialogFragment.this, (GiftData) obj2);
                            return initViewPage$lambda$27$lambda$25;
                        }
                    });
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("gift_type", 1);
                    RoomBagFragment roomBagFragment2 = this.mRoomBagFragment;
                    if (roomBagFragment2 != null) {
                        roomBagFragment2.setArguments(bundle2);
                    }
                    Fragment fragment = this.mRoomBagFragment;
                    if (fragment != null) {
                        this.mFragments.add(fragment);
                    }
                }
                i = i2;
            }
        }
        ((DialogRoomGiftBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$initViewPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(RoomGiftDialogFragment.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = RoomGiftDialogFragment.this.mFragments;
                Object obj2 = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                return (Fragment) obj2;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = RoomGiftDialogFragment.this.mFragments;
                return arrayList.size();
            }
        });
        ((DialogRoomGiftBinding) getBinding()).viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$initViewPage$3
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ArrayList arrayList;
                RoomGiftDialogFragment roomGiftDialogFragment = RoomGiftDialogFragment.this;
                arrayList = roomGiftDialogFragment.mTypeList;
                boolean z = true;
                if (position != arrayList.size() - 1) {
                    z = false;
                }
                roomGiftDialogFragment.showBag(z);
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((DialogRoomGiftBinding) getBinding()).tabLayout;
        ViewPager2 viewPager2 = ((DialogRoomGiftBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new RoomGiftTabLayoutAdapter(this.mTypeList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewPage$lambda$27$lambda$24(RoomGiftDialogFragment roomGiftDialogFragment, GiftData giftData) {
        if (giftData != null) {
            roomGiftDialogFragment.getViewModel().setSelectedGift(giftData);
        }
        roomGiftDialogFragment.requestShorcut(giftData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewPage$lambda$27$lambda$25(RoomGiftDialogFragment roomGiftDialogFragment, GiftData giftData) {
        roomGiftDialogFragment.getViewModel().setSelectedGift(giftData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopUpGiftMemberAdapter mPopUpGiftMemberAdapter_delegate$lambda$0() {
        return new PopUpGiftMemberAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopUpGiftNumberAdapter mPopUpGiftNumberAdapter_delegate$lambda$1() {
        return new PopUpGiftNumberAdapter();
    }

    private final void refreshTopLayout() {
        final GiftShortcutData giftShortcutData = this.giftShortcutData;
        if (giftShortcutData != null) {
            Integer type = giftShortcutData.getType();
            Drawable drawable = null;
            if (type != null && type.intValue() == 1) {
                ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(0);
                ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(8);
                ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(8);
                QMUIRadiusImageView2 qMUIRadiusImageView2 = ((DialogRoomGiftBinding) getBinding()).image;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "image");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, giftShortcutData.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.gift_default_avatar), Integer.valueOf(R.drawable.gift_default_avatar), (c5.g) null, 40958, (Object) null);
                FrameLayout frameLayout = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                Context context = getContext();
                if (context != null) {
                    drawable = androidx.core.content.a.getDrawable(context, R.drawable.room_gift_week_bg);
                }
                frameLayout.setBackground(drawable);
                final FrameLayout frameLayout2 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                final long j = 800;
                frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout2) > j || (frameLayout2 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(frameLayout2, currentTimeMillis);
                            Context context2 = this.getContext();
                            if (context2 != null) {
                                DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                                String entryUrl = giftShortcutData.getEntryUrl();
                                if (entryUrl == null) {
                                    entryUrl = "";
                                }
                                DefaultWebActivity.Companion.start$default(companion, context2, entryUrl, null, 4, null);
                            }
                        }
                    }
                });
            } else {
                final long j2 = 800;
                if (type != null && type.intValue() == 2) {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(8);
                    QMUIRadiusImageView2 qMUIRadiusImageView22 = ((DialogRoomGiftBinding) getBinding()).imageOne;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "imageOne");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView22, giftShortcutData.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.gift_default_avatar), Integer.valueOf(R.drawable.gift_default_avatar), (c5.g) null, 40958, (Object) null);
                    QMUIRadiusImageView2 qMUIRadiusImageView23 = ((DialogRoomGiftBinding) getBinding()).imageTwo;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView23, "imageTwo");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView23, giftShortcutData.getAvatar2(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.gift_default_avatar), Integer.valueOf(R.drawable.gift_default_avatar), (c5.g) null, 40958, (Object) null);
                    FrameLayout frameLayout3 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    Context context2 = getContext();
                    if (context2 != null) {
                        drawable = androidx.core.content.a.getDrawable(context2, R.drawable.room_gift_cp_bg);
                    }
                    frameLayout3.setBackground(drawable);
                    final FrameLayout frameLayout4 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    frameLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout4) > j2 || (frameLayout4 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(frameLayout4, currentTimeMillis);
                                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                                String entryUrl = giftShortcutData.getEntryUrl();
                                if (entryUrl == null) {
                                    entryUrl = "";
                                }
                                NavigationHelper.jump$default(navigationHelper, entryUrl, (SuperCallBack) null, 2, (Object) null);
                            }
                        }
                    });
                } else if (type != null && type.intValue() == 3) {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(8);
                    FrameLayout frameLayout5 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    Context context3 = getContext();
                    if (context3 != null) {
                        drawable = androidx.core.content.a.getDrawable(context3, R.drawable.room_gift_medal_bg);
                    }
                    frameLayout5.setBackground(drawable);
                    final FrameLayout frameLayout6 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    final long j3 = 800;
                    frameLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout6) > j3 || (frameLayout6 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(frameLayout6, currentTimeMillis);
                                Context context4 = this.getContext();
                                if (context4 != null) {
                                    Integer resMedalType = giftShortcutData.getResMedalType();
                                    if (resMedalType != null) {
                                        i = resMedalType.intValue();
                                    } else {
                                        i = 0;
                                    }
                                    new MedalLevelDialog(context4, i).show();
                                }
                            }
                        }
                    });
                } else if (type != null && type.intValue() == 4) {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(8);
                    QMUIRadiusImageView2 qMUIRadiusImageView24 = ((DialogRoomGiftBinding) getBinding()).image;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView24, "image");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView24, giftShortcutData.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.gift_default_avatar), Integer.valueOf(R.drawable.gift_default_avatar), (c5.g) null, 40958, (Object) null);
                    FrameLayout frameLayout7 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    Context context4 = getContext();
                    if (context4 != null) {
                        drawable = androidx.core.content.a.getDrawable(context4, R.drawable.room_gift_country_bg);
                    }
                    frameLayout7.setBackground(drawable);
                    final FrameLayout frameLayout8 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    frameLayout8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout8) > j2 || (frameLayout8 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(frameLayout8, currentTimeMillis);
                                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                                String entryUrl = giftShortcutData.getEntryUrl();
                                if (entryUrl == null) {
                                    entryUrl = "";
                                }
                                NavigationHelper.jump$default(navigationHelper, entryUrl, (SuperCallBack) null, 2, (Object) null);
                            }
                        }
                    });
                } else if (type != null && type.intValue() == 5) {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(8);
                    QMUIRadiusImageView2 qMUIRadiusImageView25 = ((DialogRoomGiftBinding) getBinding()).image;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView25, "image");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView25, giftShortcutData.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.gift_default_avatar), Integer.valueOf(R.drawable.gift_default_avatar), (c5.g) null, 40958, (Object) null);
                    FrameLayout frameLayout9 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    Context context5 = getContext();
                    if (context5 != null) {
                        drawable = androidx.core.content.a.getDrawable(context5, R.drawable.room_gift_exclusive_bg);
                    }
                    frameLayout9.setBackground(drawable);
                    final FrameLayout frameLayout10 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    frameLayout10.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout10) > j2 || (frameLayout10 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(frameLayout10, currentTimeMillis);
                                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                                String entryUrl = giftShortcutData.getEntryUrl();
                                if (entryUrl == null) {
                                    entryUrl = "";
                                }
                                NavigationHelper.jump$default(navigationHelper, entryUrl, (SuperCallBack) null, 2, (Object) null);
                            }
                        }
                    });
                } else if (type != null && type.intValue() == 6) {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setBackground(null);
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).topFrameBg.setVisibility(0);
                    ((DialogRoomGiftBinding) getBinding()).oneLayout.setVisibility(8);
                    ((DialogRoomGiftBinding) getBinding()).twoLayout.setVisibility(8);
                    ImageView imageView = ((DialogRoomGiftBinding) getBinding()).topFrameBg;
                    Intrinsics.checkNotNullExpressionValue(imageView, "topFrameBg");
                    ImageKtxKt.loadImage$default(imageView, giftShortcutData.getBannerUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                    final FrameLayout frameLayout11 = ((DialogRoomGiftBinding) getBinding()).topFrameLayout;
                    frameLayout11.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$refreshTopLayout$lambda$46$$inlined$singleClick$default$6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout11) > j2 || (frameLayout11 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(frameLayout11, currentTimeMillis);
                                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                                String entryUrl = giftShortcutData.getEntryUrl();
                                if (entryUrl == null) {
                                    entryUrl = "";
                                }
                                NavigationHelper.jump$default(navigationHelper, entryUrl, (SuperCallBack) null, 2, (Object) null);
                            }
                        }
                    });
                } else {
                    ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(8);
                }
            }
        }
        if (this.giftShortcutData == null) {
            ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(8);
        }
    }

    private final void requestShorcut(GiftData data) {
        long j;
        Long giftId;
        GroupService companion = GroupService.INSTANCE.getInstance();
        if (data != null && (giftId = data.getGiftId()) != null) {
            j = giftId.longValue();
        } else {
            j = 0;
        }
        RxUtilsKt.observeOnMainThread$default(companion.giftShortcut(j, this.groupId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.o2
            public final Object invoke(Object obj) {
                Unit requestShorcut$lambda$28;
                requestShorcut$lambda$28 = RoomGiftDialogFragment.requestShorcut$lambda$28(RoomGiftDialogFragment.this, (ApiResponse) obj);
                return requestShorcut$lambda$28;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.p2
            public final Object invoke(Object obj) {
                Unit requestShorcut$lambda$29;
                requestShorcut$lambda$29 = RoomGiftDialogFragment.requestShorcut$lambda$29(RoomGiftDialogFragment.this, (Throwable) obj);
                return requestShorcut$lambda$29;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestShorcut$lambda$28(RoomGiftDialogFragment roomGiftDialogFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomGiftDialogFragment.giftShortcutData = (GiftShortcutData) apiResponse.getData();
        roomGiftDialogFragment.refreshTopLayout();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestShorcut$lambda$29(RoomGiftDialogFragment roomGiftDialogFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ((DialogRoomGiftBinding) roomGiftDialogFragment.getBinding()).topFrameLayout.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void sendBagGift() {
        String str;
        long j;
        Long l;
        int i;
        String str2;
        Long giftId;
        ServerApi apis = AppServer.INSTANCE.getApis();
        if (getViewModel().getMSendType() == 0) {
            str = getViewModel().getExtraIdList().get(0);
        } else {
            str = null;
        }
        String str3 = this.groupId;
        int giftNumber = getViewModel().getGiftNumber();
        GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null && (giftId = selectedGift.getGiftId()) != null) {
            j = giftId.longValue();
        } else {
            j = 0;
        }
        String str4 = this.groupId;
        GiftData selectedGift2 = getViewModel().getSelectedGift();
        if (selectedGift2 != null) {
            l = selectedGift2.getBagId();
        } else {
            l = null;
        }
        if (getViewModel().getMSendType() == 2) {
            i = 1;
        } else {
            i = 0;
        }
        GiftData selectedGift3 = getViewModel().getSelectedGift();
        if (selectedGift3 != null) {
            str2 = selectedGift3.getGiftText();
        } else {
            str2 = null;
        }
        RxUtilsKt.observeOnMainThread$default(ServerApi.DefaultImpls.sendBagGift$default(apis, str, str3, j, giftNumber, 4, str4, l, i, str2, null, 512, null), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.g2
            public final Object invoke(Object obj) {
                Unit sendBagGift$lambda$19;
                sendBagGift$lambda$19 = RoomGiftDialogFragment.sendBagGift$lambda$19(RoomGiftDialogFragment.this, (ApiResponse) obj);
                return sendBagGift$lambda$19;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.n2
            public final Object invoke(Object obj) {
                Unit sendBagGift$lambda$20;
                sendBagGift$lambda$20 = RoomGiftDialogFragment.sendBagGift$lambda$20(RoomGiftDialogFragment.this, (Throwable) obj);
                return sendBagGift$lambda$20;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGift$lambda$19(RoomGiftDialogFragment roomGiftDialogFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        RoomBagFragment roomBagFragment = roomGiftDialogFragment.mRoomBagFragment;
        if (roomBagFragment != null) {
            roomBagFragment.refreshData((GiftData) apiResponse.getData());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGift$lambda$20(RoomGiftDialogFragment roomGiftDialogFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomGiftDialogFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomGiftDialogFragment, 2131952667);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBag(boolean isShow) {
        Drawable drawable = null;
        if (isShow) {
            ImageView imageView = ((DialogRoomGiftBinding) getBinding()).bagImage;
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.icon_room_bag);
            }
            imageView.setImageDrawable(drawable);
            ((DialogRoomGiftBinding) getBinding()).topFrameLayout.setVisibility(8);
            return;
        }
        ImageView imageView2 = ((DialogRoomGiftBinding) getBinding()).bagImage;
        Context context2 = getContext();
        if (context2 != null) {
            drawable = androidx.core.content.a.getDrawable(context2, R.drawable.icon_room_bag_default);
        }
        imageView2.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGiftNumberPopWindow$lambda$47(RoomGiftDialogFragment roomGiftDialogFragment, PopupWindow popupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        roomGiftDialogFragment.getViewModel().setGiftNumber(((Number) roomGiftDialogFragment.getMPopUpGiftNumberAdapter().getData().get(i)).intValue());
        ((DialogRoomGiftBinding) roomGiftDialogFragment.getBinding()).sendGiftLinearLayout.getBinding().giftNumber.setText(String.valueOf(roomGiftDialogFragment.getViewModel().getGiftNumber()));
        popupWindow.dismiss();
    }

    private final void showGiftTextDialog(final Function0<Unit> listener) {
        boolean z;
        GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null) {
            z = Intrinsics.areEqual(selectedGift.getHasGiftText(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            Context context = getContext();
            if (context != null) {
                GiftTextDialog giftTextDialog = new GiftTextDialog(context);
                giftTextDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.q2
                    public final Object invoke(Object obj) {
                        Unit showGiftTextDialog$lambda$18$lambda$17$lambda$16;
                        showGiftTextDialog$lambda$18$lambda$17$lambda$16 = RoomGiftDialogFragment.showGiftTextDialog$lambda$18$lambda$17$lambda$16(RoomGiftDialogFragment.this, listener, (String) obj);
                        return showGiftTextDialog$lambda$18$lambda$17$lambda$16;
                    }
                });
                giftTextDialog.show();
                return;
            }
            return;
        }
        listener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGiftTextDialog$lambda$18$lambda$17$lambda$16(RoomGiftDialogFragment roomGiftDialogFragment, Function0 function0, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        GiftData selectedGift = roomGiftDialogFragment.getViewModel().getSelectedGift();
        if (selectedGift != null) {
            selectedGift.setGiftText(str);
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPopUpMicroView(View view) {
        ViewGiftMemberRecyclerBinding viewGiftMemberRecyclerBinding = (ViewGiftMemberRecyclerBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_gift_member_recycler, (ViewGroup) null, false);
        viewGiftMemberRecyclerBinding.recyclerView.setAdapter(getMPopUpGiftMemberAdapter());
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(viewGiftMemberRecyclerBinding.getRoot(), view, UiKtxKt.getDp(173), UiKtxKt.getDp(UserProxyUtility.roomOnLine));
        final ArrayList<MicroBean> micQueueMemberList = MeetingRoomManager.INSTANCE.getMicQueueMemberList();
        MicroBean.Companion companion = MicroBean.INSTANCE;
        micQueueMemberList.add(0, MicroBean.Companion.emptyMicroBean$default(companion, 0, false, 2, null));
        micQueueMemberList.add(1, MicroBean.Companion.emptyMicroBean$default(companion, 1, false, 2, null));
        getMPopUpGiftMemberAdapter().setList(micQueueMemberList);
        getMPopUpGiftMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.k2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RoomGiftDialogFragment.showPopUpMicroView$lambda$48(RoomGiftDialogFragment.this, micQueueMemberList, popupWindowAndShow, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUpMicroView$lambda$48(RoomGiftDialogFragment roomGiftDialogFragment, ArrayList arrayList, PopupWindow popupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        SvipData svip;
        String str2;
        SvipData svip2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MicroBean");
        MicroBean microBean = (MicroBean) item;
        if (i != 0) {
            if (i != 1) {
                roomGiftDialogFragment.getViewModel().setMSendType(0);
                TextView textView = ((DialogRoomGiftBinding) roomGiftDialogFragment.getBinding()).userName;
                MicroUserBean user = microBean.getUser();
                if (user != null && (svip = user.getSvip()) != null && svip.isMystery()) {
                    String stringById = ResourcesKtxKt.getStringById(roomGiftDialogFragment, 2131953504);
                    MicroUserBean user2 = microBean.getUser();
                    if (user2 != null && (svip2 = user2.getSvip()) != null) {
                        str2 = svip2.mysteryNumber();
                    } else {
                        str2 = null;
                    }
                    str = String.format(stringById, Arrays.copyOf(new Object[]{str2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                } else {
                    MicroUserBean user3 = microBean.getUser();
                    if (user3 == null || (str = user3.getNick()) == null) {
                        str = "";
                    }
                }
                textView.setText(str);
                roomGiftDialogFragment.getViewModel().setSendMicMember(microBean);
                popupWindow.dismiss();
                return;
            }
            roomGiftDialogFragment.getViewModel().setMSendType(2);
            ((DialogRoomGiftBinding) roomGiftDialogFragment.getBinding()).userName.setText(ResourcesKtxKt.getStringById(roomGiftDialogFragment, 2131952004));
            roomGiftDialogFragment.getViewModel().getExtraIdList().clear();
            popupWindow.dismiss();
            return;
        }
        roomGiftDialogFragment.getViewModel().setMSendType(1);
        ((DialogRoomGiftBinding) roomGiftDialogFragment.getBinding()).userName.setText(ResourcesKtxKt.getStringById(roomGiftDialogFragment, 2131952950));
        roomGiftDialogFragment.getViewModel().getExtraIdList().clear();
        roomGiftDialogFragment.getViewModel().setSendAllMicMember(arrayList);
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toSVIPPrivileges() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getActivity());
        if (activity != null) {
            ILoading.DefaultImpls.showLoading$default(activity, (Integer) null, (CharSequence) null, 3, (Object) null);
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getSvipInfo(), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.l2
            public final Object invoke(Object obj) {
                Unit sVIPPrivileges$lambda$31;
                sVIPPrivileges$lambda$31 = RoomGiftDialogFragment.toSVIPPrivileges$lambda$31(RoomGiftDialogFragment.this, (ApiResponse) obj);
                return sVIPPrivileges$lambda$31;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.m2
            public final Object invoke(Object obj) {
                Unit sVIPPrivileges$lambda$32;
                sVIPPrivileges$lambda$32 = RoomGiftDialogFragment.toSVIPPrivileges$lambda$32(RoomGiftDialogFragment.this, (Throwable) obj);
                return sVIPPrivileges$lambda$32;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSVIPPrivileges$lambda$31(RoomGiftDialogFragment roomGiftDialogFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(roomGiftDialogFragment.getActivity());
        if (activity != null) {
            ILoading.DefaultImpls.dismissLoading$default(activity, (Integer) null, 1, (Object) null);
        }
        SvipInfo svipInfo = (SvipInfo) apiResponse.getData();
        if (svipInfo != null) {
            Intent intent = new Intent(roomGiftDialogFragment.getContext(), (Class<?>) SvipPrivilegesActivity.class);
            intent.putExtra("data", BaseApplication.Companion.getGSON().s(svipInfo));
            intent.putExtra("type", 17);
            roomGiftDialogFragment.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSVIPPrivileges$lambda$32(RoomGiftDialogFragment roomGiftDialogFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(roomGiftDialogFragment.getActivity());
        if (activity != null) {
            ILoading.DefaultImpls.dismissLoading$default(activity, (Integer) null, 1, (Object) null);
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomGiftDialogFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomGiftDialogFragment, 2131952667);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomGiftViewModel viewModel_delegate$lambda$2(RoomGiftDialogFragment roomGiftDialogFragment) {
        return new ViewModelProvider(roomGiftDialogFragment).get(RoomGiftViewModel.class);
    }

    @NotNull
    public final String getExtraId() {
        return this.extraId;
    }

    @Nullable
    public final GiftShortcutData getGiftShortcutData() {
        return this.giftShortcutData;
    }

    protected int getGravity() {
        return 80;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_gift;
    }

    @Nullable
    public final SendGiftListener getSendGiftListener() {
        return this.sendGiftListener;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    public final RoomGiftViewModel getViewModel() {
        return (RoomGiftViewModel) this.viewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initViewPage();
        initData();
        ((DialogRoomGiftBinding) getBinding()).sendGiftLinearLayout.setListener(new SetGroupSendGiftListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$1
            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void selectNumber(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                RoomGiftDialogFragment.this.showGiftNumberPopWindow(view);
            }

            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void sendGift() {
                RoomGiftDialogFragment.this.clickGift();
            }
        });
        final LinearLayout linearLayout = ((DialogRoomGiftBinding) getBinding()).selectMember;
        final long j = 800;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    LinearLayout linearLayout2 = (LinearLayout) linearLayout;
                    RoomGiftDialogFragment roomGiftDialogFragment = this;
                    Intrinsics.checkNotNull(linearLayout2);
                    roomGiftDialogFragment.showPopUpMicroView(linearLayout2);
                }
            }
        });
        final TextView textView = ((DialogRoomGiftBinding) getBinding()).diamondText;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogRoomGiftBinding) getBinding()).rechargeText;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
        final ImageView imageView = ((DialogRoomGiftBinding) getBinding()).rechargeIcon;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
        final ConstraintLayout constraintLayout = ((DialogRoomGiftBinding) getBinding()).topLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    if (RoomGiftDialogFragment.access$getBinding(this).topFrameLayout.getVisibility() == 8) {
                        this.dismiss();
                    }
                }
            }
        });
        final LinearLayout linearLayout2 = ((DialogRoomGiftBinding) getBinding()).svipLayout;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout2) > j || (linearLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout2, currentTimeMillis);
                    this.toSVIPPrivileges();
                }
            }
        });
        final ImageView imageView2 = ((DialogRoomGiftBinding) getBinding()).bagImage;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArrayList arrayList;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.showBag(true);
                    ViewPager2 viewPager2 = RoomGiftDialogFragment.access$getBinding(this).viewPage;
                    arrayList = this.mTypeList;
                    viewPager2.setCurrentItem(arrayList.size() - 1, true);
                }
            }
        });
    }

    public void onResume() {
        Drawable drawable;
        int i;
        SvipData svip;
        super/*androidx.fragment.app.Fragment*/.onResume();
        ImageView imageView = ((DialogRoomGiftBinding) getBinding()).svipLeftImage;
        Context context = getContext();
        if (context != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (svip = user.getSvip()) != null && !svip.isMystery()) {
                i = R.drawable.svip_open;
            } else {
                i = R.drawable.svip_close;
            }
            drawable = androidx.core.content.a.getDrawable(context, i);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void setGiftShortcutData(@Nullable GiftShortcutData giftShortcutData) {
        this.giftShortcutData = giftShortcutData;
    }

    @NotNull
    public final RoomGiftDialogFragment setListener(@NotNull SendGiftListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sendGiftListener = listener;
        return this;
    }

    public final void setSendGiftListener(@Nullable SendGiftListener sendGiftListener) {
        this.sendGiftListener = sendGiftListener;
    }

    public final void showGiftNumberPopWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(7);
        arrayList.add(77);
        arrayList.add(111);
        arrayList.add(555);
        arrayList.add(7777);
        PopWindowGiftNumberRecyclerBinding popWindowGiftNumberRecyclerBinding = (PopWindowGiftNumberRecyclerBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.pop_window_gift_number_recycler, (ViewGroup) null, false);
        popWindowGiftNumberRecyclerBinding.recyclerView.setAdapter(getMPopUpGiftNumberAdapter());
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(popWindowGiftNumberRecyclerBinding.getRoot(), view, UiKtxKt.getDp(84), UiKtxKt.getDp(180));
        getMPopUpGiftNumberAdapter().setList(arrayList);
        getMPopUpGiftNumberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.r2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RoomGiftDialogFragment.showGiftNumberPopWindow$lambda$47(RoomGiftDialogFragment.this, popupWindowAndShow, baseQuickAdapter, view2, i);
            }
        });
    }

    public /* synthetic */ RoomGiftDialogFragment(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }

    public RoomGiftDialogFragment(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "extraId");
        Intrinsics.checkNotNullParameter(str2, "userName");
        Intrinsics.checkNotNullParameter(str3, "groupId");
        this.extraId = str;
        this.userName = str2;
        this.groupId = str3;
        this.isAllMic = z;
        this.mPopUpGiftMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.h2
            public final Object invoke() {
                PopUpGiftMemberAdapter mPopUpGiftMemberAdapter_delegate$lambda$0;
                mPopUpGiftMemberAdapter_delegate$lambda$0 = RoomGiftDialogFragment.mPopUpGiftMemberAdapter_delegate$lambda$0();
                return mPopUpGiftMemberAdapter_delegate$lambda$0;
            }
        });
        this.mPopUpGiftNumberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.i2
            public final Object invoke() {
                PopUpGiftNumberAdapter mPopUpGiftNumberAdapter_delegate$lambda$1;
                mPopUpGiftNumberAdapter_delegate$lambda$1 = RoomGiftDialogFragment.mPopUpGiftNumberAdapter_delegate$lambda$1();
                return mPopUpGiftNumberAdapter_delegate$lambda$1;
            }
        });
        this.mTypeList = new ArrayList<>();
        this.mFragments = new ArrayList<>();
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.j2
            public final Object invoke() {
                RoomGiftViewModel viewModel_delegate$lambda$2;
                viewModel_delegate$lambda$2 = RoomGiftDialogFragment.viewModel_delegate$lambda$2(RoomGiftDialogFragment.this);
                return viewModel_delegate$lambda$2;
            }
        });
    }
}
