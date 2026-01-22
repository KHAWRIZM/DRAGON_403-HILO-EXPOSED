package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.databinding.DialogUserMenuBinding;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R\"\u0010\"\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010&R$\u0010*\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/UserMenuDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogUserMenuBinding;", "Landroid/content/Context;", "mContext", "", TUIConstants.TUILive.USER_ID, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "hideProfileButton", "()V", "showPinnedButton", "hideDeleteButton", "showCommonTip", "blockButtonPressed", "", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "Lcom/qiahao/nextvideo/data/interfaces/UserMenuInterfaces;", "listener", "setDialogListener", "(Lcom/qiahao/nextvideo/data/interfaces/UserMenuInterfaces;)Lcom/qiahao/nextvideo/room/dialog/UserMenuDialog;", "getViewBinding", "()Lcom/qiahao/nextvideo/databinding/DialogUserMenuBinding;", "dismiss", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Ljava/lang/String;", "hideDelete", "Z", "getHideDelete", "setHideDelete", "(Z)V", "hideProfile", "getHideProfile", "setHideProfile", "hidePinned", "Ljava/lang/Boolean;", "getHidePinned", "()Ljava/lang/Boolean;", "setHidePinned", "(Ljava/lang/Boolean;)V", "Lcom/qiahao/nextvideo/data/interfaces/UserMenuInterfaces;", "getListener", "()Lcom/qiahao/nextvideo/data/interfaces/UserMenuInterfaces;", "setListener", "(Lcom/qiahao/nextvideo/data/interfaces/UserMenuInterfaces;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserMenuDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserMenuDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserMenuDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,168:1\n61#2,9:169\n61#2,9:178\n61#2,9:187\n61#2,9:196\n61#2,9:205\n61#2,9:214\n61#2,9:223\n*S KotlinDebug\n*F\n+ 1 UserMenuDialog.kt\ncom/qiahao/nextvideo/room/dialog/UserMenuDialog\n*L\n51#1:169,9\n55#1:178,9\n59#1:187,9\n60#1:196,9\n64#1:205,9\n72#1:214,9\n75#1:223,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserMenuDialog extends BaseBindingDialog<DialogUserMenuBinding> {

    @NotNull
    private nd.a compositeDisposable;
    private boolean hideDelete;

    @Nullable
    private Boolean hidePinned;
    private boolean hideProfile;

    @Nullable
    private UserMenuInterfaces listener;

    @NotNull
    private final Context mContext;

    @NotNull
    private final String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMenuDialog(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, TUIConstants.TUILive.USER_ID);
        this.mContext = context;
        this.userId = str;
        this.compositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blockButtonPressed() {
        io.reactivex.rxjava3.core.i0 j = FeedbackService.INSTANCE.getShared().blockUser(this.userId).j(new pd.o() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$blockButtonPressed$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                String str;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                str = UserMenuDialog.this.userId;
                conversationManager.deleteConversation(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$blockButtonPressed$1.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int code, String desc) {
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.f5
            public final Object invoke(Object obj) {
                Unit blockButtonPressed$lambda$7;
                blockButtonPressed$lambda$7 = UserMenuDialog.blockButtonPressed$lambda$7(UserMenuDialog.this, (Unit) obj);
                return blockButtonPressed$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.g5
            public final Object invoke(Object obj) {
                Unit blockButtonPressed$lambda$8;
                blockButtonPressed$lambda$8 = UserMenuDialog.blockButtonPressed$lambda$8(UserMenuDialog.this, (Throwable) obj);
                return blockButtonPressed$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockButtonPressed$lambda$7(UserMenuDialog userMenuDialog, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        UserMenuInterfaces userMenuInterfaces = userMenuDialog.listener;
        if (userMenuInterfaces != null) {
            userMenuInterfaces.onClickBlock(userMenuDialog.userId);
        }
        userMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockButtonPressed$lambda$8(UserMenuDialog userMenuDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = userMenuDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = userMenuDialog.mContext.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        userMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void hideDeleteButton() {
        ((DialogUserMenuBinding) getBinding()).deleteButton.setVisibility(8);
        ((DialogUserMenuBinding) getBinding()).deleteLine.setVisibility(8);
    }

    private final void hideProfileButton() {
        ((DialogUserMenuBinding) getBinding()).profileButton.setVisibility(8);
        ((DialogUserMenuBinding) getBinding()).profileLine.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCommonTip() {
        new TipDialog(this.mContext).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$showCommonTip$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                UserMenuDialog.this.blockButtonPressed();
            }
        }).show();
    }

    private final void showPinnedButton() {
        ((DialogUserMenuBinding) getBinding()).pinnedButton.setVisibility(0);
        ((DialogUserMenuBinding) getBinding()).pinnedLine.setVisibility(0);
    }

    public void dismiss() {
        super.dismiss();
        this.compositeDisposable.dispose();
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final boolean getHideDelete() {
        return this.hideDelete;
    }

    @Nullable
    public final Boolean getHidePinned() {
        return this.hidePinned;
    }

    public final boolean getHideProfile() {
        return this.hideProfile;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_user_menu;
    }

    @Nullable
    public final UserMenuInterfaces getListener() {
        return this.listener;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final DialogUserMenuBinding getViewBinding() {
        return (DialogUserMenuBinding) getBinding();
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final TextView textView = ((DialogUserMenuBinding) getBinding()).reportButton;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    UserMenuInterfaces listener = this.getListener();
                    if (listener != null) {
                        str2 = this.userId;
                        listener.onClickReport(str2);
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogUserMenuBinding) getBinding()).deleteButton;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    UserMenuInterfaces listener = this.getListener();
                    if (listener != null) {
                        listener.onClickDelete();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView3 = ((DialogUserMenuBinding) getBinding()).blockButton;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.showCommonTip();
                }
            }
        });
        final TextView textView4 = ((DialogUserMenuBinding) getBinding()).profileButton;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    UserMenuInterfaces listener = this.getListener();
                    if (listener != null) {
                        str2 = this.userId;
                        listener.onClickProfile(str2);
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView5 = ((DialogUserMenuBinding) getBinding()).pinnedButton;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView5) > j || (textView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView5, currentTimeMillis);
                    if (Intrinsics.areEqual(this.getHidePinned(), Boolean.TRUE)) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131954293), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    } else {
                        UserMenuInterfaces listener = this.getListener();
                        if (listener != null) {
                            listener.onClickPinned();
                        }
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton = ((DialogUserMenuBinding) getBinding()).cancelButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
        final View view = ((DialogUserMenuBinding) getBinding()).backView;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.UserMenuDialog$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        if (this.hideProfile) {
            hideProfileButton();
        }
        if (this.hideDelete) {
            hideDeleteButton();
        }
        String str2 = this.userId;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str) && this.hidePinned != null) {
            showPinnedButton();
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    @NotNull
    public final UserMenuDialog setDialogListener(@NotNull UserMenuInterfaces listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void setHideDelete(boolean z) {
        this.hideDelete = z;
    }

    public final void setHidePinned(@Nullable Boolean bool) {
        this.hidePinned = bool;
    }

    public final void setHideProfile(boolean z) {
        this.hideProfile = z;
    }

    public final void setListener(@Nullable UserMenuInterfaces userMenuInterfaces) {
        this.listener = userMenuInterfaces;
    }
}
