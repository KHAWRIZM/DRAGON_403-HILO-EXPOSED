package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogRoomAnimationEffectBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomAnimationEffectBottomDialog;", "Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mBinding", "Lcom/qiahao/nextvideo/databinding/DialogRoomAnimationEffectBinding;", "mCurrentContext", "isFirstShow", "", "mRoomGamePanelListener", "Lcom/qiahao/nextvideo/room/dialog/RoomAnimationEffectListener;", "getMRoomGamePanelListener", "()Lcom/qiahao/nextvideo/room/dialog/RoomAnimationEffectListener;", "setMRoomGamePanelListener", "(Lcom/qiahao/nextvideo/room/dialog/RoomAnimationEffectListener;)V", "initDataBinding", "", "dismiss", "show", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAnimationEffectBottomDialog extends BaseBottomSheetDialog {

    @NotNull
    private static final String TAG = "RoomAnimationEffectBottomDialog";
    private boolean isFirstShow;
    private DialogRoomAnimationEffectBinding mBinding;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private RoomAnimationEffectListener mRoomGamePanelListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomAnimationEffectBottomDialog(@NotNull Context context) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.isFirstShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initDataBinding$lambda$0(RoomAnimationEffectBottomDialog roomAnimationEffectBottomDialog, CompoundButton compoundButton, boolean z) {
        RoomAnimationEffectListener roomAnimationEffectListener = roomAnimationEffectBottomDialog.mRoomGamePanelListener;
        if (roomAnimationEffectListener != null) {
            roomAnimationEffectListener.clickEnterEffect(z);
        }
        if (!roomAnimationEffectBottomDialog.isFirstShow) {
            if (z) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = roomAnimationEffectBottomDialog.getContext();
                String string = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953947);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = roomAnimationEffectBottomDialog.getContext();
            String string2 = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953946);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, context2, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initDataBinding$lambda$1(RoomAnimationEffectBottomDialog roomAnimationEffectBottomDialog, CompoundButton compoundButton, boolean z) {
        RoomAnimationEffectListener roomAnimationEffectListener = roomAnimationEffectBottomDialog.mRoomGamePanelListener;
        if (roomAnimationEffectListener != null) {
            roomAnimationEffectListener.clickGiftEffect(z);
        }
        if (!roomAnimationEffectBottomDialog.isFirstShow) {
            if (z) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = roomAnimationEffectBottomDialog.getContext();
                String string = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953957);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = roomAnimationEffectBottomDialog.getContext();
            String string2 = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953956);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, context2, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initDataBinding$lambda$2(RoomAnimationEffectBottomDialog roomAnimationEffectBottomDialog, CompoundButton compoundButton, boolean z) {
        RoomAnimationEffectListener roomAnimationEffectListener = roomAnimationEffectBottomDialog.mRoomGamePanelListener;
        if (roomAnimationEffectListener != null) {
            roomAnimationEffectListener.clickRocketEffect(z);
        }
        if (!roomAnimationEffectBottomDialog.isFirstShow) {
            if (z) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = roomAnimationEffectBottomDialog.getContext();
                String string = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953939);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = roomAnimationEffectBottomDialog.getContext();
            String string2 = roomAnimationEffectBottomDialog.mCurrentContext.getString(2131953938);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, context2, string2, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
    }

    public void dismiss() {
        this.mRoomGamePanelListener = null;
        super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
    }

    @Nullable
    public final RoomAnimationEffectListener getMRoomGamePanelListener() {
        return this.mRoomGamePanelListener;
    }

    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    public void initDataBinding() {
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding = null;
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding2 = (DialogRoomAnimationEffectBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_room_animation_effect, (ViewGroup) null, false);
        this.mBinding = dialogRoomAnimationEffectBinding2;
        if (dialogRoomAnimationEffectBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding2 = null;
        }
        setContentView(dialogRoomAnimationEffectBinding2.getRoot());
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding3 = this.mBinding;
        if (dialogRoomAnimationEffectBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding3 = null;
        }
        dialogRoomAnimationEffectBinding3.enterEffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.dialog.x1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RoomAnimationEffectBottomDialog.initDataBinding$lambda$0(RoomAnimationEffectBottomDialog.this, compoundButton, z);
            }
        });
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding4 = this.mBinding;
        if (dialogRoomAnimationEffectBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding4 = null;
        }
        dialogRoomAnimationEffectBinding4.giftEffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.dialog.y1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RoomAnimationEffectBottomDialog.initDataBinding$lambda$1(RoomAnimationEffectBottomDialog.this, compoundButton, z);
            }
        });
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding5 = this.mBinding;
        if (dialogRoomAnimationEffectBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding5 = null;
        }
        dialogRoomAnimationEffectBinding5.rocketEffect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.room.dialog.z1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RoomAnimationEffectBottomDialog.initDataBinding$lambda$2(RoomAnimationEffectBottomDialog.this, compoundButton, z);
            }
        });
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding6 = this.mBinding;
        if (dialogRoomAnimationEffectBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding6 = null;
        }
        SwitchButton switchButton = dialogRoomAnimationEffectBinding6.enterEffect;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        switchButton.setChecked(meetingRoomManager.isShowEnterEffect());
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding7 = this.mBinding;
        if (dialogRoomAnimationEffectBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dialogRoomAnimationEffectBinding7 = null;
        }
        dialogRoomAnimationEffectBinding7.giftEffect.setChecked(meetingRoomManager.isShowGiftEffect());
        DialogRoomAnimationEffectBinding dialogRoomAnimationEffectBinding8 = this.mBinding;
        if (dialogRoomAnimationEffectBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dialogRoomAnimationEffectBinding = dialogRoomAnimationEffectBinding8;
        }
        dialogRoomAnimationEffectBinding.rocketEffect.setChecked(meetingRoomManager.isShowRocketEffect());
    }

    public final void setMRoomGamePanelListener(@Nullable RoomAnimationEffectListener roomAnimationEffectListener) {
        this.mRoomGamePanelListener = roomAnimationEffectListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        this.isFirstShow = false;
    }
}
