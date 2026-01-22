package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogLeaveRoomBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogLeaveRoomBinding;", "context", "Landroid/content/Context;", "mNoble", "", "<init>", "(Landroid/content/Context;I)V", "getMNoble", "()I", "getLayoutResId", "isNeedFullScreen", "", "onInitialize", "", "mLeaveRoomDialogListener", "Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialogListener;", "getMLeaveRoomDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialogListener;", "setMLeaveRoomDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialogListener;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LeaveRoomDialog extends BaseBindingDialog<DialogLeaveRoomBinding> {

    @Nullable
    private LeaveRoomDialogListener mLeaveRoomDialogListener;
    private final int mNoble;

    public /* synthetic */ LeaveRoomDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(LeaveRoomDialog leaveRoomDialog, View view) {
        leaveRoomDialog.dismiss();
        LeaveRoomDialogListener leaveRoomDialogListener = leaveRoomDialog.mLeaveRoomDialogListener;
        if (leaveRoomDialogListener != null) {
            leaveRoomDialogListener.onLeaveRoomDialogListenerSmallRoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(LeaveRoomDialog leaveRoomDialog, View view) {
        leaveRoomDialog.dismiss();
        LeaveRoomDialogListener leaveRoomDialogListener = leaveRoomDialog.mLeaveRoomDialogListener;
        if (leaveRoomDialogListener != null) {
            leaveRoomDialogListener.onLeaveRoomDialogListenerLeaveRoom();
        }
    }

    protected int getLayoutResId() {
        return R.layout.dialog_leave_room;
    }

    @Nullable
    public final LeaveRoomDialogListener getMLeaveRoomDialogListener() {
        return this.mLeaveRoomDialogListener;
    }

    public final int getMNoble() {
        return this.mNoble;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        int i;
        String str;
        int i2;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setBackgroundDimAmount(0.0f);
        setBackgroundDrawableColor(androidx.core.content.a.getColor(getContext(), 2131099964));
        ImageView imageView = ((DialogLeaveRoomBinding) getBinding()).small;
        Context context = getContext();
        int i3 = this.mNoble;
        if (i3 == 9) {
            i = 2131232364;
        } else if (i3 >= 10) {
            i = 2131232365;
        } else {
            i = R.drawable.ic_room_small;
        }
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
        TextView textView = ((DialogLeaveRoomBinding) getBinding()).smallText;
        String str2 = "#ffffff";
        if (this.mNoble < 9) {
            str = "#ffffff";
        } else {
            str = "#FFD02B";
        }
        textView.setTextColor(Color.parseColor(str));
        ImageView imageView2 = ((DialogLeaveRoomBinding) getBinding()).close;
        Context context2 = getContext();
        int i4 = this.mNoble;
        if (i4 == 9) {
            i2 = 2131232343;
        } else if (i4 >= 10) {
            i2 = 2131232344;
        } else {
            i2 = R.drawable.ic_room_close;
        }
        imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context2, i2));
        TextView textView2 = ((DialogLeaveRoomBinding) getBinding()).closeText;
        if (this.mNoble >= 9) {
            str2 = "#FFD02B";
        }
        textView2.setTextColor(Color.parseColor(str2));
        ((DialogLeaveRoomBinding) getBinding()).lineLayout1.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveRoomDialog.onInitialize$lambda$0(LeaveRoomDialog.this, view);
            }
        });
        ((DialogLeaveRoomBinding) getBinding()).lineLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveRoomDialog.onInitialize$lambda$1(LeaveRoomDialog.this, view);
            }
        });
        ((DialogLeaveRoomBinding) getBinding()).bgRoot.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveRoomDialog.this.dismiss();
            }
        });
    }

    public final void setMLeaveRoomDialogListener(@Nullable LeaveRoomDialogListener leaveRoomDialogListener) {
        this.mLeaveRoomDialogListener = leaveRoomDialogListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveRoomDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNoble = i;
    }
}
