package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.DialogRelationInvitationReceiveBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatApi;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR?\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/RelationInvitationReceiveDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRelationInvitationReceiveBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/base_common/model/common/User;", "user", "Lcom/qiahao/base_common/model/im/RelationMessageData;", "data", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/im/RelationMessageData;)V", "", "type", "", "inviteReply", "(I)V", "getLayoutResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "dismiss", "()V", "Lcom/qiahao/base_common/model/common/User;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "Lcom/qiahao/base_common/model/im/RelationMessageData;", "getData", "()Lcom/qiahao/base_common/model/im/RelationMessageData;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRelationInvitationReceiveDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RelationInvitationReceiveDialog.kt\ncom/qiahao/nextvideo/ui/cp/RelationInvitationReceiveDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,101:1\n61#2,9:102\n61#2,9:111\n*S KotlinDebug\n*F\n+ 1 RelationInvitationReceiveDialog.kt\ncom/qiahao/nextvideo/ui/cp/RelationInvitationReceiveDialog\n*L\n42#1:102,9\n45#1:111,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RelationInvitationReceiveDialog extends BaseBindingDialog<DialogRelationInvitationReceiveBinding> {

    @Nullable
    private final RelationMessageData data;

    @Nullable
    private Function1<? super Integer, Unit> listener;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationInvitationReceiveDialog(@NotNull Context context, @NotNull User user, @Nullable RelationMessageData relationMessageData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
        this.data = relationMessageData;
        this.mCompositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void inviteReply(final int type) {
        int i;
        Integer type2;
        ChatApi apis = ChatServer.INSTANCE.getApis();
        String externalId = this.user.getExternalId();
        RelationMessageData relationMessageData = this.data;
        if (relationMessageData != null && (type2 = relationMessageData.getType()) != null) {
            i = type2.intValue();
        } else {
            i = 0;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.relationInviteReply(externalId, type, i), new Function1() { // from class: com.qiahao.nextvideo.ui.cp.k2
            public final Object invoke(Object obj) {
                Unit inviteReply$lambda$3;
                inviteReply$lambda$3 = RelationInvitationReceiveDialog.inviteReply$lambda$3(type, this, (ApiResponse) obj);
                return inviteReply$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.l2
            public final Object invoke(Object obj) {
                Unit inviteReply$lambda$4;
                inviteReply$lambda$4 = RelationInvitationReceiveDialog.inviteReply$lambda$4(RelationInvitationReceiveDialog.this, (Throwable) obj);
                return inviteReply$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit inviteReply$lambda$3(int i, final RelationInvitationReceiveDialog relationInvitationReceiveDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (i == 1) {
            final BaseActivity activity = HiloUtils.INSTANCE.getActivity(relationInvitationReceiveDialog.getContext());
            if (activity != null) {
                new CpConfirmDialog(activity, false).setTipContent(ResourcesKtxKt.getStringById(relationInvitationReceiveDialog, 2131952914)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog$inviteReply$1$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        String str;
                        int i2;
                        Integer type;
                        CpSpaceActivity.Companion companion = CpSpaceActivity.Companion;
                        BaseActivity baseActivity = activity;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user == null || (str = user.getExternalId()) == null) {
                            str = "";
                        }
                        String externalId = relationInvitationReceiveDialog.getUser().getExternalId();
                        RelationMessageData data = relationInvitationReceiveDialog.getData();
                        if (data != null && (type = data.getType()) != null) {
                            i2 = type.intValue();
                        } else {
                            i2 = 0;
                        }
                        companion.startActivity(baseActivity, str, externalId, i2);
                    }
                }).show();
            }
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, relationInvitationReceiveDialog.getContext(), ResourcesKtxKt.getStringById(relationInvitationReceiveDialog, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        relationInvitationReceiveDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit inviteReply$lambda$4(RelationInvitationReceiveDialog relationInvitationReceiveDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = relationInvitationReceiveDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(relationInvitationReceiveDialog, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        relationInvitationReceiveDialog.dismiss();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
    }

    @Nullable
    public final RelationMessageData getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_relation_invitation_receive;
    }

    @Nullable
    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        String msg;
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        NickTextView nickTextView = ((DialogRelationInvitationReceiveBinding) getBinding()).nickName;
        String nick = this.user.getNick();
        String str = "";
        if (nick == null) {
            nick = "";
        }
        nickTextView.setText(nick);
        TextView textView = ((DialogRelationInvitationReceiveBinding) getBinding()).f٥٥id;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{this.user.getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = ((DialogRelationInvitationReceiveBinding) getBinding()).content;
        RelationMessageData relationMessageData = this.data;
        if (relationMessageData != null && (msg = relationMessageData.getMsg()) != null) {
            str = msg;
        }
        textView2.setText(str);
        HiloImageView.loadImage$default(((DialogRelationInvitationReceiveBinding) getBinding()).avatar, ImageSizeKt.image100(this.user.getAvatar()), 0, 0, 6, (Object) null);
        final TextView textView3 = ((DialogRelationInvitationReceiveBinding) getBinding()).refuse;
        final long j = 800;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.inviteReply(2);
                }
            }
        });
        final TextView textView4 = ((DialogRelationInvitationReceiveBinding) getBinding()).agree;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog$onCreate$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    this.inviteReply(1);
                }
            }
        });
        RelationMessageData relationMessageData2 = this.data;
        if (relationMessageData2 != null) {
            num = relationMessageData2.getType();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            ((DialogRelationInvitationReceiveBinding) getBinding()).topBanner.setText(ResourcesKtxKt.getStringById(this, 2131954110));
            return;
        }
        if (num != null && num.intValue() == 3) {
            ((DialogRelationInvitationReceiveBinding) getBinding()).topBanner.setText(ResourcesKtxKt.getStringById(this, 2131952104));
        } else if (num != null && num.intValue() == 4) {
            ((DialogRelationInvitationReceiveBinding) getBinding()).topBanner.setText(ResourcesKtxKt.getStringById(this, 2131953079));
        }
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public /* synthetic */ RelationInvitationReceiveDialog(Context context, User user, RelationMessageData relationMessageData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, user, (i & 4) != 0 ? null : relationMessageData);
    }
}
