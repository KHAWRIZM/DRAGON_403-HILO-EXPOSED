package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.cp.CpCheck;
import com.qiahao.nextvideo.databinding.DialogCpInvitationSendBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpInvitationSendDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpInvitationSendBinding;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/cp/CpCheck;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/cp/CpCheck;)V", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpInvitationSendDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpInvitationSendDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpInvitationSendDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,44:1\n61#2,9:45\n*S KotlinDebug\n*F\n+ 1 CpInvitationSendDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpInvitationSendDialog\n*L\n40#1:45,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpInvitationSendDialog extends BaseBindingDialog<DialogCpInvitationSendBinding> {

    @NotNull
    private final CpCheck data;

    @Nullable
    private Function1<? super CpCheck, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpInvitationSendDialog(@NotNull Context context, @NotNull CpCheck cpCheck) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cpCheck, "data");
        this.data = cpCheck;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_invitation_send;
    }

    @Nullable
    public final Function1<CpCheck, Unit> getListener() {
        return this.listener;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        HiloImageView hiloImageView = ((DialogCpInvitationSendBinding) getBinding()).avatar;
        User user = this.data.getUser();
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(str), 2131231655, 0, 4, (Object) null);
        NickTextView nickTextView = ((DialogCpInvitationSendBinding) getBinding()).nickName;
        User user2 = this.data.getUser();
        String str6 = "";
        if (user2 == null || (str2 = user2.getNick()) == null) {
            str2 = "";
        }
        nickTextView.setText(str2);
        TextView textView = ((DialogCpInvitationSendBinding) getBinding()).f٥٣id;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user3 = this.data.getUser();
        if (user3 != null) {
            str3 = user3.getCode();
        } else {
            str3 = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = ((DialogCpInvitationSendBinding) getBinding()).content;
        String msg = this.data.getMsg();
        if (msg != null) {
            str6 = msg;
        }
        textView2.setText(str6);
        HiloImageView hiloImageView2 = ((DialogCpInvitationSendBinding) getBinding()).avatar;
        User user4 = this.data.getUser();
        if (user4 != null) {
            str4 = user4.getAvatar();
        } else {
            str4 = null;
        }
        HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(str4), 0, 0, 6, (Object) null);
        SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(new SpannableTextBuilder(((DialogCpInvitationSendBinding) getBinding()).sendButton), ResourcesKtxKt.getStringById(this, 2131954022), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), "(", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null);
        Long diamond = this.data.getDiamond();
        if (diamond == null || (str5 = diamond.toString()) == null) {
            str5 = MessageService.MSG_DB_READY_REPORT;
        }
        SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(appendText$default, str5, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null).appendDrawable(R.drawable.bill_diamond, (Function1) null), ")", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null).apply();
        final TextView textView3 = ((DialogCpInvitationSendBinding) getBinding()).sendButton;
        final long j = 800;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpInvitationSendDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpCheck cpCheck;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    Function1<CpCheck, Unit> listener = this.getListener();
                    if (listener != null) {
                        cpCheck = this.data;
                        listener.invoke(cpCheck);
                    }
                }
            }
        });
    }

    public final void setListener(@Nullable Function1<? super CpCheck, Unit> function1) {
        this.listener = function1;
    }
}
