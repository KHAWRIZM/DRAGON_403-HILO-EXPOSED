package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogShareInviteFriendsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/InviteFriendsBottomSheetDialog;", "Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "context", "Landroid/content/Context;", "inviteFriendsListener", "Lcom/qiahao/nextvideo/room/dialog/InviteFriendsListener;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/room/dialog/InviteFriendsListener;)V", "mDialogShareInviteFriendsBinding", "Lcom/qiahao/nextvideo/databinding/DialogShareInviteFriendsBinding;", "mContext", "mInviteFriendsListener", "initDataBinding", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class InviteFriendsBottomSheetDialog extends BaseBottomSheetDialog {

    @NotNull
    private Context mContext;
    private DialogShareInviteFriendsBinding mDialogShareInviteFriendsBinding;

    @Nullable
    private InviteFriendsListener mInviteFriendsListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteFriendsBottomSheetDialog(@NotNull Context context, @NotNull InviteFriendsListener inviteFriendsListener) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inviteFriendsListener, "inviteFriendsListener");
        this.mContext = context;
        this.mInviteFriendsListener = inviteFriendsListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$0(InviteFriendsBottomSheetDialog inviteFriendsBottomSheetDialog, View view) {
        InviteFriendsListener inviteFriendsListener = inviteFriendsBottomSheetDialog.mInviteFriendsListener;
        if (inviteFriendsListener != null) {
            inviteFriendsListener.shareContacts();
        }
        inviteFriendsBottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$1(InviteFriendsBottomSheetDialog inviteFriendsBottomSheetDialog, View view) {
        InviteFriendsListener inviteFriendsListener = inviteFriendsBottomSheetDialog.mInviteFriendsListener;
        if (inviteFriendsListener != null) {
            inviteFriendsListener.shareCopyLink();
        }
        inviteFriendsBottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$2(InviteFriendsBottomSheetDialog inviteFriendsBottomSheetDialog, View view) {
        InviteFriendsListener inviteFriendsListener = inviteFriendsBottomSheetDialog.mInviteFriendsListener;
        if (inviteFriendsListener != null) {
            inviteFriendsListener.shareWhatApps();
        }
        inviteFriendsBottomSheetDialog.dismiss();
    }

    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    public void initDataBinding() {
        DialogShareInviteFriendsBinding dialogShareInviteFriendsBinding = null;
        DialogShareInviteFriendsBinding dialogShareInviteFriendsBinding2 = (DialogShareInviteFriendsBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.dialog_share_invite_friends, (ViewGroup) null, false);
        this.mDialogShareInviteFriendsBinding = dialogShareInviteFriendsBinding2;
        if (dialogShareInviteFriendsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogShareInviteFriendsBinding");
            dialogShareInviteFriendsBinding2 = null;
        }
        setContentView(dialogShareInviteFriendsBinding2.getRoot());
        DialogShareInviteFriendsBinding dialogShareInviteFriendsBinding3 = this.mDialogShareInviteFriendsBinding;
        if (dialogShareInviteFriendsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogShareInviteFriendsBinding");
            dialogShareInviteFriendsBinding3 = null;
        }
        dialogShareInviteFriendsBinding3.shareContacts.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteFriendsBottomSheetDialog.initDataBinding$lambda$0(InviteFriendsBottomSheetDialog.this, view);
            }
        });
        DialogShareInviteFriendsBinding dialogShareInviteFriendsBinding4 = this.mDialogShareInviteFriendsBinding;
        if (dialogShareInviteFriendsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogShareInviteFriendsBinding");
            dialogShareInviteFriendsBinding4 = null;
        }
        dialogShareInviteFriendsBinding4.shareCopyLink.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteFriendsBottomSheetDialog.initDataBinding$lambda$1(InviteFriendsBottomSheetDialog.this, view);
            }
        });
        DialogShareInviteFriendsBinding dialogShareInviteFriendsBinding5 = this.mDialogShareInviteFriendsBinding;
        if (dialogShareInviteFriendsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogShareInviteFriendsBinding");
        } else {
            dialogShareInviteFriendsBinding = dialogShareInviteFriendsBinding5;
        }
        dialogShareInviteFriendsBinding.shareWhatApps.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteFriendsBottomSheetDialog.initDataBinding$lambda$2(InviteFriendsBottomSheetDialog.this, view);
            }
        });
    }
}
