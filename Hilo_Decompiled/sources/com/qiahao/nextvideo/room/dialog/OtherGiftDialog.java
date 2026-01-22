package com.qiahao.nextvideo.room.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.databinding.DialogOtherGiftBinding;
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
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.qcloud.tuicore.util.PopWindowUtil;
import java.util.ArrayList;
import java.util.List;
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

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020-H\u0014J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u000200H\u0002J\u0016\u00103\u001a\u0002002\f\u00104\u001a\b\u0012\u0004\u0012\u00020005H\u0002J\b\u00106\u001a\u000200H\u0002J\b\u00107\u001a\u000200H\u0002J\b\u00108\u001a\u000200H\u0002J\u0010\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020\u0007H\u0002J\u000e\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u0002002\u0006\u0010<\u001a\u00020=H\u0002J\u000e\u0010?\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040!j\b\u0012\u0004\u0012\u00020\u0004`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020$0!j\b\u0012\u0004\u0012\u00020$`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b)\u0010*¨\u0006@"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/OtherGiftDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogOtherGiftBinding;", "extraId", "", "userName", "isAllMic", "", "groupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getExtraId", "()Ljava/lang/String;", "getUserName", "getGroupId", "mPopUpGiftMemberAdapter", "Lcom/qiahao/nextvideo/room/adapter/PopUpGiftMemberAdapter;", "getMPopUpGiftMemberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PopUpGiftMemberAdapter;", "mPopUpGiftMemberAdapter$delegate", "Lkotlin/Lazy;", "mPopUpGiftNumberAdapter", "Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "getMPopUpGiftNumberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "mPopUpGiftNumberAdapter$delegate", "sendGiftListener", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "getSendGiftListener", "()Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "setSendGiftListener", "(Lcom/qiahao/base_common/interfaceing/SendGiftListener;)V", "mTypeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mFragments", "Landroidx/fragment/app/Fragment;", "mRoomBagFragment", "Lcom/qiahao/nextvideo/room/fragment/RoomBagFragment;", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "viewModel$delegate", "getLayoutResId", "", "getGravity", "onStart", "", "onInitialize", "clickGift", "showGiftTextDialog", "listener", "Lkotlin/Function0;", "initData", "initViewPage", "sendBagGift", "showBag", "isShow", "showGiftNumberPopWindow", "view", "Landroid/view/View;", "showPopUpMicroView", "setListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOtherGiftDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OtherGiftDialog.kt\ncom/qiahao/nextvideo/room/dialog/OtherGiftDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,463:1\n61#2,9:464\n61#2,9:473\n61#2,9:482\n61#2,9:491\n61#2,9:500\n1878#3,3:509\n1#4:512\n*S KotlinDebug\n*F\n+ 1 OtherGiftDialog.kt\ncom/qiahao/nextvideo/room/dialog/OtherGiftDialog\n*L\n113#1:464,9\n117#1:473,9\n121#1:482,9\n125#1:491,9\n129#1:500,9\n288#1:509,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherGiftDialog extends BaseBindingDialogFragment<DialogOtherGiftBinding> {

    @NotNull
    private final String extraId;

    @Nullable
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

    public OtherGiftDialog() {
        this(null, null, false, null, 15, null);
    }

    public static final /* synthetic */ DialogOtherGiftBinding access$getBinding(OtherGiftDialog otherGiftDialog) {
        return (DialogOtherGiftBinding) otherGiftDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f1, code lost:
    
        if (r0 >= (getViewModel().getGiftNumber() * getViewModel().getExtraIdList().size())) goto L٤٤;
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
        Long l = null;
        String str2 = null;
        if (getViewModel().getExtraIdList().isEmpty()) {
            if (getViewModel().getMIsAllMic()) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str2 = user.getExternalId();
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
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131953535), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
                return;
            }
            return;
        }
        int i2 = 0;
        if (!getViewModel().getMIsAllMic()) {
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
            if (getViewModel().getMIsAllMic()) {
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
                showGiftTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.d1
                    public final Object invoke() {
                        Unit clickGift$lambda$9;
                        clickGift$lambda$9 = OtherGiftDialog.clickGift$lambda$9(OtherGiftDialog.this);
                        return clickGift$lambda$9;
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
        if (getViewModel().getMIsAllMic()) {
            User user3 = UserStore.INSTANCE.getShared().getUser();
            if (user3 != null) {
                d = user3.getDiamondNum();
            }
            if (d < selectedGift4.getDiamondNum() * getViewModel().getGiftNumber() * getViewModel().getExtraIdList().size()) {
                Context context = getContext();
                if (context != null) {
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$clickGift$2$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SendGiftListener sendGiftListener = OtherGiftDialog.this.getSendGiftListener();
                            if (sendGiftListener != null) {
                                sendGiftListener.showRechargeView();
                            }
                            OtherGiftDialog.this.dismiss();
                        }
                    }).show();
                    return;
                }
                return;
            }
        } else {
            User user4 = UserStore.INSTANCE.getShared().getUser();
            if (user4 != null) {
                d = user4.getDiamondNum();
            }
            if (d < selectedGift4.getDiamondNum() * getViewModel().getGiftNumber()) {
                Context context2 = getContext();
                if (context2 != null) {
                    new TipDialog(context2).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$clickGift$2$2$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            SendGiftListener sendGiftListener = OtherGiftDialog.this.getSendGiftListener();
                            if (sendGiftListener != null) {
                                sendGiftListener.showRechargeView();
                            }
                            OtherGiftDialog.this.dismiss();
                        }
                    }).show();
                    return;
                }
                return;
            }
        }
        showGiftTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.e1
            public final Object invoke() {
                Unit clickGift$lambda$13$lambda$12;
                clickGift$lambda$13$lambda$12 = OtherGiftDialog.clickGift$lambda$13$lambda$12(OtherGiftDialog.this, selectedGift4);
                return clickGift$lambda$13$lambda$12;
            }
        });
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickGift$lambda$13$lambda$12(OtherGiftDialog otherGiftDialog, GiftData giftData) {
        SendGiftListener sendGiftListener = otherGiftDialog.sendGiftListener;
        if (sendGiftListener != null) {
            sendGiftListener.giftsChoose(giftData, otherGiftDialog.getViewModel().getGiftNumber(), otherGiftDialog.getViewModel().getExtraIdList(), otherGiftDialog.getViewModel().getMIsAllMic());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickGift$lambda$9(OtherGiftDialog otherGiftDialog) {
        otherGiftDialog.sendBagGift();
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
        getViewModel().setMIsAllMic(this.isAllMic);
        if (getViewModel().getMIsAllMic()) {
            ((DialogOtherGiftBinding) getBinding()).userName.setText(ResourcesKtxKt.getStringById(this, 2131952950));
            getViewModel().setSendAllMicMember(MeetingRoomManager.INSTANCE.getMicQueueMemberList());
        } else if (!TextUtils.isEmpty(this.extraId) && !TextUtils.isEmpty(this.userName)) {
            ((DialogOtherGiftBinding) getBinding()).userName.setText(this.userName);
            getViewModel().getExtraIdList().clear();
            getViewModel().getExtraIdList().add(this.extraId);
        }
        TextView textView = ((DialogOtherGiftBinding) getBinding()).diamondText;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            l = Long.valueOf((long) user.getDiamondNum());
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        nd.c subscribe = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                if (userObjectEvent != null) {
                    OtherGiftDialog otherGiftDialog = OtherGiftDialog.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView2 = OtherGiftDialog.access$getBinding(otherGiftDialog).diamondText;
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        textView2.setText(String.valueOf(user2 != null ? Long.valueOf((long) user2.getDiamondNum()) : null));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
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
                    roomGiftFragment.setSelectGiftListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.z0
                        public final Object invoke(Object obj2) {
                            Unit initViewPage$lambda$21$lambda$18;
                            initViewPage$lambda$21$lambda$18 = OtherGiftDialog.initViewPage$lambda$21$lambda$18(OtherGiftDialog.this, (GiftData) obj2);
                            return initViewPage$lambda$21$lambda$18;
                        }
                    });
                    Bundle bundle = new Bundle();
                    bundle.putInt("gift_type", i2);
                    roomGiftFragment.setArguments(bundle);
                    this.mFragments.add(roomGiftFragment);
                } else if (i == 4) {
                    RoomBagFragment roomBagFragment = new RoomBagFragment();
                    this.mRoomBagFragment = roomBagFragment;
                    roomBagFragment.setSelectGiftListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.c1
                        public final Object invoke(Object obj2) {
                            Unit initViewPage$lambda$21$lambda$19;
                            initViewPage$lambda$21$lambda$19 = OtherGiftDialog.initViewPage$lambda$21$lambda$19(OtherGiftDialog.this, (GiftData) obj2);
                            return initViewPage$lambda$21$lambda$19;
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
        ((DialogOtherGiftBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$initViewPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(OtherGiftDialog.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = OtherGiftDialog.this.mFragments;
                Object obj2 = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                return (Fragment) obj2;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = OtherGiftDialog.this.mFragments;
                return arrayList.size();
            }
        });
        ((DialogOtherGiftBinding) getBinding()).viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$initViewPage$3
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ArrayList arrayList;
                OtherGiftDialog otherGiftDialog = OtherGiftDialog.this;
                arrayList = otherGiftDialog.mTypeList;
                boolean z = true;
                if (position != arrayList.size() - 1) {
                    z = false;
                }
                otherGiftDialog.showBag(z);
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((DialogOtherGiftBinding) getBinding()).tabLayout;
        ViewPager2 viewPager2 = ((DialogOtherGiftBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new RoomGiftTabLayoutAdapter(this.mTypeList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewPage$lambda$21$lambda$18(OtherGiftDialog otherGiftDialog, GiftData giftData) {
        if (giftData != null) {
            otherGiftDialog.getViewModel().setSelectedGift(giftData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewPage$lambda$21$lambda$19(OtherGiftDialog otherGiftDialog, GiftData giftData) {
        otherGiftDialog.getViewModel().setSelectedGift(giftData);
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
        int giftNumber = getViewModel().getGiftNumber();
        GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null && (giftId = selectedGift.getGiftId()) != null) {
            j = giftId.longValue();
        } else {
            j = 0;
        }
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
        RxUtilsKt.observeOnMainThread$default(apis.sendBagGift(str, "", j, giftNumber, 2, "", l, i, str2, this.groupId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.a1
            public final Object invoke(Object obj) {
                Unit sendBagGift$lambda$23;
                sendBagGift$lambda$23 = OtherGiftDialog.sendBagGift$lambda$23(OtherGiftDialog.this, (ApiResponse) obj);
                return sendBagGift$lambda$23;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.b1
            public final Object invoke(Object obj) {
                Unit sendBagGift$lambda$24;
                sendBagGift$lambda$24 = OtherGiftDialog.sendBagGift$lambda$24(OtherGiftDialog.this, (Throwable) obj);
                return sendBagGift$lambda$24;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGift$lambda$23(OtherGiftDialog otherGiftDialog, ApiResponse apiResponse) {
        SendGiftListener sendGiftListener;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GiftData giftData = (GiftData) apiResponse.getData();
        List list = null;
        if (giftData != null) {
            GiftData selectedGift = otherGiftDialog.getViewModel().getSelectedGift();
            if (selectedGift != null) {
                str = selectedGift.getGiftText();
            } else {
                str = null;
            }
            giftData.setGiftText(str);
        }
        GiftData giftData2 = (GiftData) apiResponse.getData();
        if (giftData2 != null) {
            GiftData selectedGift2 = otherGiftDialog.getViewModel().getSelectedGift();
            if (selectedGift2 != null) {
                list = selectedGift2.getTextStyleList();
            }
            giftData2.setTextStyleList(list);
        }
        RoomBagFragment roomBagFragment = otherGiftDialog.mRoomBagFragment;
        if (roomBagFragment != null) {
            roomBagFragment.refreshData((GiftData) apiResponse.getData());
        }
        GiftData giftData3 = (GiftData) apiResponse.getData();
        if (giftData3 != null && (sendGiftListener = otherGiftDialog.sendGiftListener) != null) {
            sendGiftListener.begGift(giftData3, otherGiftDialog.getViewModel().getGiftNumber());
        }
        otherGiftDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGift$lambda$24(OtherGiftDialog otherGiftDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = otherGiftDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(otherGiftDialog, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        otherGiftDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBag(boolean isShow) {
        Drawable drawable = null;
        if (isShow) {
            ImageView imageView = ((DialogOtherGiftBinding) getBinding()).bagImage;
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.icon_room_bag);
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        ImageView imageView2 = ((DialogOtherGiftBinding) getBinding()).bagImage;
        Context context2 = getContext();
        if (context2 != null) {
            drawable = androidx.core.content.a.getDrawable(context2, R.drawable.icon_room_bag_default);
        }
        imageView2.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGiftNumberPopWindow$lambda$27(OtherGiftDialog otherGiftDialog, PopupWindow popupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        otherGiftDialog.getViewModel().setGiftNumber(((Number) otherGiftDialog.getMPopUpGiftNumberAdapter().getData().get(i)).intValue());
        ((DialogOtherGiftBinding) otherGiftDialog.getBinding()).sendGiftLinearLayout.getBinding().giftNumber.setText(String.valueOf(otherGiftDialog.getViewModel().getGiftNumber()));
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
                giftTextDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.f1
                    public final Object invoke(Object obj) {
                        Unit showGiftTextDialog$lambda$16$lambda$15$lambda$14;
                        showGiftTextDialog$lambda$16$lambda$15$lambda$14 = OtherGiftDialog.showGiftTextDialog$lambda$16$lambda$15$lambda$14(OtherGiftDialog.this, listener, (String) obj);
                        return showGiftTextDialog$lambda$16$lambda$15$lambda$14;
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
    public static final Unit showGiftTextDialog$lambda$16$lambda$15$lambda$14(OtherGiftDialog otherGiftDialog, Function0 function0, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        GiftData selectedGift = otherGiftDialog.getViewModel().getSelectedGift();
        if (selectedGift != null) {
            selectedGift.setGiftText(str);
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void showPopUpMicroView(View view) {
        ViewGiftMemberRecyclerBinding viewGiftMemberRecyclerBinding = (ViewGiftMemberRecyclerBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_gift_member_recycler, (ViewGroup) null, false);
        viewGiftMemberRecyclerBinding.recyclerView.setAdapter(getMPopUpGiftMemberAdapter());
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(viewGiftMemberRecyclerBinding.getRoot(), view, UiKtxKt.getDp(173), UiKtxKt.getDp(UserProxyUtility.roomOnLine));
        final ArrayList<MicroBean> micQueueMemberList = MeetingRoomManager.INSTANCE.getMicQueueMemberList();
        micQueueMemberList.add(0, MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, 0, false, 2, null));
        getMPopUpGiftMemberAdapter().setList(micQueueMemberList);
        getMPopUpGiftMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.k1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                OtherGiftDialog.showPopUpMicroView$lambda$28(OtherGiftDialog.this, micQueueMemberList, popupWindowAndShow, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUpMicroView$lambda$28(OtherGiftDialog otherGiftDialog, ArrayList arrayList, PopupWindow popupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MicroBean");
        MicroBean microBean = (MicroBean) item;
        if (i == 0) {
            otherGiftDialog.getViewModel().setMIsAllMic(true);
            ((DialogOtherGiftBinding) otherGiftDialog.getBinding()).userName.setText(ResourcesKtxKt.getStringById(otherGiftDialog, 2131952950));
            otherGiftDialog.getViewModel().getExtraIdList().clear();
            otherGiftDialog.getViewModel().setSendAllMicMember(arrayList);
            popupWindow.dismiss();
            return;
        }
        otherGiftDialog.getViewModel().setMIsAllMic(false);
        TextView textView = ((DialogOtherGiftBinding) otherGiftDialog.getBinding()).userName;
        MicroUserBean user = microBean.getUser();
        if (user == null || (str = user.getNick()) == null) {
            str = "";
        }
        textView.setText(str);
        otherGiftDialog.getViewModel().setSendMicMember(microBean);
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomGiftViewModel viewModel_delegate$lambda$2(OtherGiftDialog otherGiftDialog) {
        return new ViewModelProvider(otherGiftDialog).get(RoomGiftViewModel.class);
    }

    @NotNull
    public final String getExtraId() {
        return this.extraId;
    }

    protected int getGravity() {
        return 80;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_other_gift;
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
        ((DialogOtherGiftBinding) getBinding()).sendGiftLinearLayout.setListener(new SetGroupSendGiftListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$1
            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void selectNumber(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                OtherGiftDialog.this.showGiftNumberPopWindow(view);
            }

            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void sendGift() {
                OtherGiftDialog.this.clickGift();
            }
        });
        final LinearLayout linearLayout = ((DialogOtherGiftBinding) getBinding()).selectMember;
        final long j = 800;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                }
            }
        });
        final TextView textView = ((DialogOtherGiftBinding) getBinding()).diamondText;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$$inlined$singleClick$default$2
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
        final TextView textView2 = ((DialogOtherGiftBinding) getBinding()).rechargeText;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$$inlined$singleClick$default$3
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
        final ImageView imageView = ((DialogOtherGiftBinding) getBinding()).rechargeIcon;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$$inlined$singleClick$default$4
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
        final ImageView imageView2 = ((DialogOtherGiftBinding) getBinding()).bagImage;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.OtherGiftDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArrayList arrayList;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.showBag(true);
                    ViewPager2 viewPager2 = OtherGiftDialog.access$getBinding(this).viewPage;
                    arrayList = this.mTypeList;
                    viewPager2.setCurrentItem(arrayList.size() - 1, true);
                }
            }
        });
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

    @NotNull
    public final OtherGiftDialog setListener(@NotNull SendGiftListener listener) {
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
        arrayList.add(17);
        arrayList.add(77);
        arrayList.add(111);
        arrayList.add(555);
        arrayList.add(777);
        PopWindowGiftNumberRecyclerBinding popWindowGiftNumberRecyclerBinding = (PopWindowGiftNumberRecyclerBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.pop_window_gift_number_recycler, (ViewGroup) null, false);
        popWindowGiftNumberRecyclerBinding.recyclerView.setAdapter(getMPopUpGiftNumberAdapter());
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(popWindowGiftNumberRecyclerBinding.getRoot(), view, UiKtxKt.getDp(84), UiKtxKt.getDp(207));
        getMPopUpGiftNumberAdapter().setList(arrayList);
        getMPopUpGiftNumberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.g1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                OtherGiftDialog.showGiftNumberPopWindow$lambda$27(OtherGiftDialog.this, popupWindowAndShow, baseQuickAdapter, view2, i);
            }
        });
    }

    public /* synthetic */ OtherGiftDialog(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3);
    }

    public OtherGiftDialog(@NotNull String str, @NotNull String str2, boolean z, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "extraId");
        Intrinsics.checkNotNullParameter(str2, "userName");
        this.extraId = str;
        this.userName = str2;
        this.isAllMic = z;
        this.groupId = str3;
        this.mPopUpGiftMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.h1
            public final Object invoke() {
                PopUpGiftMemberAdapter mPopUpGiftMemberAdapter_delegate$lambda$0;
                mPopUpGiftMemberAdapter_delegate$lambda$0 = OtherGiftDialog.mPopUpGiftMemberAdapter_delegate$lambda$0();
                return mPopUpGiftMemberAdapter_delegate$lambda$0;
            }
        });
        this.mPopUpGiftNumberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.i1
            public final Object invoke() {
                PopUpGiftNumberAdapter mPopUpGiftNumberAdapter_delegate$lambda$1;
                mPopUpGiftNumberAdapter_delegate$lambda$1 = OtherGiftDialog.mPopUpGiftNumberAdapter_delegate$lambda$1();
                return mPopUpGiftNumberAdapter_delegate$lambda$1;
            }
        });
        this.mTypeList = new ArrayList<>();
        this.mFragments = new ArrayList<>();
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.j1
            public final Object invoke() {
                RoomGiftViewModel viewModel_delegate$lambda$2;
                viewModel_delegate$lambda$2 = OtherGiftDialog.viewModel_delegate$lambda$2(OtherGiftDialog.this);
                return viewModel_delegate$lambda$2;
            }
        });
    }
}
