package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogMicOperateClickBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/MicOperateBottomDialog;", "Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "showLockLayout", "", "showMicMute", "<init>", "(Landroid/content/Context;ZZ)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogMicOperateClickBinding;", "mContext", "mMicOperateListener", "Lcom/qiahao/nextvideo/room/dialog/MicOperateListener;", "getMMicOperateListener", "()Lcom/qiahao/nextvideo/room/dialog/MicOperateListener;", "setMMicOperateListener", "(Lcom/qiahao/nextvideo/room/dialog/MicOperateListener;)V", "mIsShowLockLayout", "getMIsShowLockLayout", "()Z", "setMIsShowLockLayout", "(Z)V", "mShowMicMute", "getMShowMicMute", "setMShowMicMute", "initDataBinding", "", "setMicOperateListener", "micOperateListener", "onClick", "v", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MicOperateBottomDialog extends BaseBottomSheetDialog implements View.OnClickListener {
    private DialogMicOperateClickBinding binding;

    @NotNull
    private Context mContext;
    private boolean mIsShowLockLayout;
    public MicOperateListener mMicOperateListener;
    private boolean mShowMicMute;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicOperateBottomDialog(@NotNull Context context, boolean z, boolean z2) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mIsShowLockLayout = z;
        this.mShowMicMute = z2;
    }

    public final boolean getMIsShowLockLayout() {
        return this.mIsShowLockLayout;
    }

    @NotNull
    public final MicOperateListener getMMicOperateListener() {
        MicOperateListener micOperateListener = this.mMicOperateListener;
        if (micOperateListener != null) {
            return micOperateListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMicOperateListener");
        return null;
    }

    public final boolean getMShowMicMute() {
        return this.mShowMicMute;
    }

    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    public void initDataBinding() {
        DialogMicOperateClickBinding dialogMicOperateClickBinding = null;
        DialogMicOperateClickBinding dialogMicOperateClickBinding2 = (DialogMicOperateClickBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.dialog_mic_operate_click, (ViewGroup) null, false);
        this.binding = dialogMicOperateClickBinding2;
        if (dialogMicOperateClickBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMicOperateClickBinding2 = null;
        }
        setContentView(dialogMicOperateClickBinding2.getRoot());
        DialogMicOperateClickBinding dialogMicOperateClickBinding3 = this.binding;
        if (dialogMicOperateClickBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMicOperateClickBinding3 = null;
        }
        dialogMicOperateClickBinding3.setClick(this);
        if (MeetingRoomManager.INSTANCE.isMySelfOnMic()) {
            DialogMicOperateClickBinding dialogMicOperateClickBinding4 = this.binding;
            if (dialogMicOperateClickBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogMicOperateClickBinding4 = null;
            }
            dialogMicOperateClickBinding4.takeTheMic.setText(ResourcesKtxKt.getStringById(this, 2131952967));
        } else {
            DialogMicOperateClickBinding dialogMicOperateClickBinding5 = this.binding;
            if (dialogMicOperateClickBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogMicOperateClickBinding5 = null;
            }
            dialogMicOperateClickBinding5.takeTheMic.setText(ResourcesKtxKt.getStringById(this, 2131953023));
        }
        if (this.mIsShowLockLayout) {
            DialogMicOperateClickBinding dialogMicOperateClickBinding6 = this.binding;
            if (dialogMicOperateClickBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogMicOperateClickBinding6 = null;
            }
            dialogMicOperateClickBinding6.lockMute.setText(ResourcesKtxKt.getStringById(this, 2131953247));
        } else {
            DialogMicOperateClickBinding dialogMicOperateClickBinding7 = this.binding;
            if (dialogMicOperateClickBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogMicOperateClickBinding7 = null;
            }
            dialogMicOperateClickBinding7.lockMute.setText(ResourcesKtxKt.getStringById(this, 2131954360));
        }
        if (this.mShowMicMute) {
            DialogMicOperateClickBinding dialogMicOperateClickBinding8 = this.binding;
            if (dialogMicOperateClickBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogMicOperateClickBinding = dialogMicOperateClickBinding8;
            }
            dialogMicOperateClickBinding.theMic.setText(ResourcesKtxKt.getStringById(this, 2131952989));
            return;
        }
        DialogMicOperateClickBinding dialogMicOperateClickBinding9 = this.binding;
        if (dialogMicOperateClickBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogMicOperateClickBinding = dialogMicOperateClickBinding9;
        }
        dialogMicOperateClickBinding.theMic.setText(ResourcesKtxKt.getStringById(this, 2131954362));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case 2131362220:
                dismiss();
                return;
            case R.id.lockMute /* 2131363623 */:
                if (this.mIsShowLockLayout) {
                    getMMicOperateListener().lockTheMic();
                } else {
                    getMMicOperateListener().unlockTheMic();
                }
                dismiss();
                return;
            case R.id.take_the_mic /* 2131365009 */:
                getMMicOperateListener().takeTheMic();
                dismiss();
                return;
            case R.id.theMic /* 2131365122 */:
                getMMicOperateListener().micMute(this.mShowMicMute);
                dismiss();
                return;
            default:
                return;
        }
    }

    public final void setMIsShowLockLayout(boolean z) {
        this.mIsShowLockLayout = z;
    }

    public final void setMMicOperateListener(@NotNull MicOperateListener micOperateListener) {
        Intrinsics.checkNotNullParameter(micOperateListener, "<set-?>");
        this.mMicOperateListener = micOperateListener;
    }

    public final void setMShowMicMute(boolean z) {
        this.mShowMicMute = z;
    }

    public final void setMicOperateListener(@NotNull MicOperateListener micOperateListener) {
        Intrinsics.checkNotNullParameter(micOperateListener, "micOperateListener");
        setMMicOperateListener(micOperateListener);
    }
}
