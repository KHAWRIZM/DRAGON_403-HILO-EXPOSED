package com.qiahao.nextvideo.room.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.OnlineSet;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.groupSets;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.DialogSendGroupBroadcastBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/SendGroupBroadcastDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "groupId", "", "type", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "mCurrentContext", "mDialogSendGroupBroadcastBinding", "Lcom/qiahao/nextvideo/databinding/DialogSendGroupBroadcastBinding;", "getMDialogSendGroupBroadcastBinding", "()Lcom/qiahao/nextvideo/databinding/DialogSendGroupBroadcastBinding;", "setMDialogSendGroupBroadcastBinding", "(Lcom/qiahao/nextvideo/databinding/DialogSendGroupBroadcastBinding;)V", "mGroupId", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mType", "getMType", "()I", "setMType", "(I)V", "mGlobalMoney", "", "getMGlobalMoney", "()J", "setMGlobalMoney", "(J)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTypeEditTextContent", "onClick", "v", "Landroid/view/View;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SendGroupBroadcastDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "SendGroupBroadcastDialo";
    public static final int TYPE_GLOBAL_ROOM_BROADCAST = 1;
    public static final int TYPE_ROOM_IN_MEMBER_BROADCAST = 0;

    @NotNull
    private Context mCurrentContext;
    public DialogSendGroupBroadcastBinding mDialogSendGroupBroadcastBinding;
    private long mGlobalMoney;

    @NotNull
    private String mGroupId;
    private int mType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGroupBroadcastDialog(@NotNull Context context, @NotNull String str, int i) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "groupId");
        this.mCurrentContext = context;
        this.mGroupId = str;
        this.mType = i;
    }

    private final void getTypeEditTextContent() {
        final int i;
        int i2 = this.mType;
        if (i2 == 0) {
            i = 500;
        } else {
            i = 100;
        }
        if (i2 == 1) {
            getMDialogSendGroupBroadcastBinding().etContent.setHint(2131952902);
        }
        getMDialogSendGroupBroadcastBinding().textNumber.setText("0/" + i);
        getMDialogSendGroupBroadcastBinding().setNumber(Integer.valueOf(i));
        getMDialogSendGroupBroadcastBinding().etContent.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.dialog.SendGroupBroadcastDialog$getTypeEditTextContent$1$1
            @Override // android.text.TextWatcher
            @SuppressLint({"SetTextI18n"})
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (s.length() > i) {
                    return;
                }
                this.getMDialogSendGroupBroadcastBinding().textNumber.setText(s.length() + "/" + i);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$2(SendGroupBroadcastDialog sendGroupBroadcastDialog, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Object systemService = sendGroupBroadcastDialog.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(sendGroupBroadcastDialog.getMDialogSendGroupBroadcastBinding().etContent.getWindowToken(), 0);
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = sendGroupBroadcastDialog.mCurrentContext;
        String string = context.getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        sendGroupBroadcastDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$3(SendGroupBroadcastDialog sendGroupBroadcastDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "onClick: " + th.getLocalizedMessage());
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = sendGroupBroadcastDialog.mCurrentContext;
        String string = context.getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onClick$lambda$4(SendGroupBroadcastDialog sendGroupBroadcastDialog, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Object systemService = sendGroupBroadcastDialog.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(sendGroupBroadcastDialog.getMDialogSendGroupBroadcastBinding().etContent.getWindowToken(), 0);
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = sendGroupBroadcastDialog.mCurrentContext;
        String string = context.getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        sendGroupBroadcastDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$5(SendGroupBroadcastDialog sendGroupBroadcastDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "onClick: " + th.getLocalizedMessage());
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = sendGroupBroadcastDialog.mCurrentContext;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = sendGroupBroadcastDialog.mCurrentContext.getString(2131952667);
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

    @NotNull
    public final DialogSendGroupBroadcastBinding getMDialogSendGroupBroadcastBinding() {
        DialogSendGroupBroadcastBinding dialogSendGroupBroadcastBinding = this.mDialogSendGroupBroadcastBinding;
        if (dialogSendGroupBroadcastBinding != null) {
            return dialogSendGroupBroadcastBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDialogSendGroupBroadcastBinding");
        return null;
    }

    public final long getMGlobalMoney() {
        return this.mGlobalMoney;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMType() {
        return this.mType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        int i;
        OnlineSet onlineSet;
        IBinder iBinder;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362224) {
            if (id2 == 2131362424) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.mCurrentContext.getSystemService("input_method");
                if (inputMethodManager != null && inputMethodManager.isActive()) {
                    View currentFocus = getCurrentFocus();
                    if (currentFocus != null) {
                        iBinder = currentFocus.getWindowToken();
                    } else {
                        iBinder = null;
                    }
                    inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
                }
                String obj = StringsKt.trim(getMDialogSendGroupBroadcastBinding().etContent.getText().toString()).toString();
                if (obj.length() == 0 || HiloUtils.INSTANCE.isFastClick()) {
                    return;
                }
                AppService service = AppController.INSTANCE.getService();
                if (service != null && service.checkSensitive(obj)) {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954057), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                    dismiss();
                    return;
                }
                double d = 0.0d;
                if (this.mType == 0) {
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        d = user.getDiamondNum();
                    }
                    PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
                    if (purchaseFeeDetail != null && (onlineSet = purchaseFeeDetail.getOnlineSet()) != null) {
                        i = onlineSet.getSessionPayFee();
                    } else {
                        i = 5;
                    }
                    if (d >= i) {
                        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomPostBroadcast(this.mGroupId, obj), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.y3
                            public final Object invoke(Object obj2) {
                                Unit onClick$lambda$2;
                                onClick$lambda$2 = SendGroupBroadcastDialog.onClick$lambda$2(SendGroupBroadcastDialog.this, (ApiResponse) obj2);
                                return onClick$lambda$2;
                            }
                        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.z3
                            public final Object invoke(Object obj2) {
                                Unit onClick$lambda$3;
                                onClick$lambda$3 = SendGroupBroadcastDialog.onClick$lambda$3(SendGroupBroadcastDialog.this, (Throwable) obj2);
                                return onClick$lambda$3;
                            }
                        }, (Function0) null, false, 12, (Object) null);
                        return;
                    } else {
                        WalletActivity.INSTANCE.start(this.mCurrentContext);
                        return;
                    }
                }
                User user2 = UserStore.INSTANCE.getShared().getUser();
                if (user2 != null) {
                    d = user2.getDiamondNum();
                }
                if (d >= this.mGlobalMoney) {
                    RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().sendGlobalBroadCast(obj, this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.a4
                        public final Object invoke(Object obj2) {
                            Unit onClick$lambda$4;
                            onClick$lambda$4 = SendGroupBroadcastDialog.onClick$lambda$4(SendGroupBroadcastDialog.this, (ApiResponse) obj2);
                            return onClick$lambda$4;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.b4
                        public final Object invoke(Object obj2) {
                            Unit onClick$lambda$5;
                            onClick$lambda$5 = SendGroupBroadcastDialog.onClick$lambda$5(SendGroupBroadcastDialog.this, (Throwable) obj2);
                            return onClick$lambda$5;
                        }
                    }, (Function0) null, false, 12, (Object) null);
                    return;
                } else {
                    WalletActivity.INSTANCE.start(this.mCurrentContext);
                    return;
                }
            }
            return;
        }
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        long j;
        int i;
        groupSets groupSet;
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setMDialogSendGroupBroadcastBinding((DialogSendGroupBroadcastBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_send_group_broadcast, (ViewGroup) null, false));
        getMDialogSendGroupBroadcastBinding().setClick(this);
        setContentView(getMDialogSendGroupBroadcastBinding().getRoot());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        Dimens dimens = Dimens.INSTANCE;
        attributes.height = dimens.dpToPx(356);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(dimens.dpToPx(34), 0, dimens.dpToPx(34), 0);
        getTypeEditTextContent();
        if (this.mType == 0) {
            PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
            if (purchaseFeeDetail != null && (groupSet = purchaseFeeDetail.getGroupSet()) != null) {
                i = groupSet.getGroupIMMass();
            } else {
                i = 0;
            }
            getMDialogSendGroupBroadcastBinding().confirmButton.setText(this.mCurrentContext.getString(2131954026, String.valueOf(i)));
            return;
        }
        PurchaseFeeDetailsX purchaseFeeDetail2 = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null) {
            j = purchaseFeeDetail2.getGlobalBroadcastFee();
        } else {
            j = 0;
        }
        this.mGlobalMoney = j;
        getMDialogSendGroupBroadcastBinding().confirmButton.setText(this.mCurrentContext.getString(2131954026, String.valueOf(this.mGlobalMoney)));
    }

    public final void setMDialogSendGroupBroadcastBinding(@NotNull DialogSendGroupBroadcastBinding dialogSendGroupBroadcastBinding) {
        Intrinsics.checkNotNullParameter(dialogSendGroupBroadcastBinding, "<set-?>");
        this.mDialogSendGroupBroadcastBinding = dialogSendGroupBroadcastBinding;
    }

    public final void setMGlobalMoney(long j) {
        this.mGlobalMoney = j;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
