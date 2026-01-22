package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.databinding.DialogMessageMenuBinding;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014RT\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/dialog/MessageMenuDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogMessageMenuBinding;", "Landroid/content/Context;", "context", "", SupportGiftRankActivity.EXTERNAL_ID, "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "reportButtonPressed", "()V", "blockButtonPressed", "", "getLayoutResId", "()I", "", "isBottomStyle", "()Z", "onInitialize", "Ljava/lang/String;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "mListener", "Lkotlin/jvm/functions/Function2;", "getMListener", "()Lkotlin/jvm/functions/Function2;", "setMListener", "(Lkotlin/jvm/functions/Function2;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageMenuDialog extends BaseBindingDialog<DialogMessageMenuBinding> {

    @NotNull
    public static final String BLOCK = "block";

    @NotNull
    public static final String DELETE = "delete";

    @NotNull
    public static final String REPORT = "report";

    @NotNull
    private nd.a compositeDisposable;

    @NotNull
    private final String externalId;

    @Nullable
    private Function2<? super String, ? super String, Unit> mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageMenuDialog(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        this.externalId = str;
        this.compositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blockButtonPressed() {
        i0 j = FeedbackService.INSTANCE.getShared().blockUser(this.externalId).j(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog$blockButtonPressed$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                String str;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                str = MessageMenuDialog.this.externalId;
                conversationManager.deleteConversation(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog$blockButtonPressed$1.1
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.p
            public final Object invoke(Object obj) {
                Unit blockButtonPressed$lambda$6;
                blockButtonPressed$lambda$6 = MessageMenuDialog.blockButtonPressed$lambda$6(MessageMenuDialog.this, (Unit) obj);
                return blockButtonPressed$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.q
            public final Object invoke(Object obj) {
                Unit blockButtonPressed$lambda$7;
                blockButtonPressed$lambda$7 = MessageMenuDialog.blockButtonPressed$lambda$7(MessageMenuDialog.this, (Throwable) obj);
                return blockButtonPressed$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockButtonPressed$lambda$6(MessageMenuDialog messageMenuDialog, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(messageMenuDialog.externalId);
        Function2<? super String, ? super String, Unit> function2 = messageMenuDialog.mListener;
        if (function2 != null) {
            function2.invoke(BLOCK, messageMenuDialog.externalId);
        }
        messageMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockButtonPressed$lambda$7(MessageMenuDialog messageMenuDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = messageMenuDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(messageMenuDialog, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        messageMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(MessageMenuDialog messageMenuDialog, View view) {
        Function2<? super String, ? super String, Unit> function2 = messageMenuDialog.mListener;
        if (function2 != null) {
            function2.invoke("delete", messageMenuDialog.externalId);
        }
        messageMenuDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportButtonPressed() {
        i0 j = FeedbackService.INSTANCE.getShared().blockUser(this.externalId).j(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog$reportButtonPressed$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                String str;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                str = MessageMenuDialog.this.externalId;
                conversationManager.deleteConversation(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog$reportButtonPressed$1.1
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.r
            public final Object invoke(Object obj) {
                Unit reportButtonPressed$lambda$4;
                reportButtonPressed$lambda$4 = MessageMenuDialog.reportButtonPressed$lambda$4(MessageMenuDialog.this, (Unit) obj);
                return reportButtonPressed$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.s
            public final Object invoke(Object obj) {
                Unit reportButtonPressed$lambda$5;
                reportButtonPressed$lambda$5 = MessageMenuDialog.reportButtonPressed$lambda$5(MessageMenuDialog.this, (Throwable) obj);
                return reportButtonPressed$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportButtonPressed$lambda$4(MessageMenuDialog messageMenuDialog, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        Function2<? super String, ? super String, Unit> function2 = messageMenuDialog.mListener;
        if (function2 != null) {
            function2.invoke("report", messageMenuDialog.externalId);
        }
        messageMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportButtonPressed$lambda$5(MessageMenuDialog messageMenuDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = messageMenuDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(messageMenuDialog, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        messageMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_message_menu;
    }

    @Nullable
    public final Function2<String, String, Unit> getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogMessageMenuBinding) getBinding()).reportButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuDialog.this.reportButtonPressed();
            }
        });
        ((DialogMessageMenuBinding) getBinding()).deleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuDialog.onInitialize$lambda$1(MessageMenuDialog.this, view);
            }
        });
        ((DialogMessageMenuBinding) getBinding()).blockButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuDialog.this.blockButtonPressed();
            }
        });
        ((DialogMessageMenuBinding) getBinding()).cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageMenuDialog.this.dismiss();
            }
        });
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function2<? super String, ? super String, Unit> function2) {
        this.mListener = function2;
    }
}
