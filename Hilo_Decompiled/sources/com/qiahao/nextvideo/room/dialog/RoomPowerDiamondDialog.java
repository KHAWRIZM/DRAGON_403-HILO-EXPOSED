package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogRoomPowerDiamondBinding;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.utilities.InputFilterMinMax;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomPowerDiamondDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRoomPowerDiamondBinding;", "context", "Landroid/content/Context;", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Landroid/content/Context;I)V", "getDiamond", "()I", "setDiamond", "(I)V", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomPowerDiamondDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomPowerDiamondDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPowerDiamondDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,39:1\n61#2,9:40\n61#2,9:49\n*S KotlinDebug\n*F\n+ 1 RoomPowerDiamondDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPowerDiamondDialog\n*L\n28#1:40,9\n31#1:49,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPowerDiamondDialog extends BaseBindingDialog<DialogRoomPowerDiamondBinding> {
    private int diamond;

    @Nullable
    private Function1<? super Integer, Unit> listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomPowerDiamondDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamond = i;
    }

    public static final /* synthetic */ DialogRoomPowerDiamondBinding access$getBinding(RoomPowerDiamondDialog roomPowerDiamondDialog) {
        return (DialogRoomPowerDiamondBinding) roomPowerDiamondDialog.getBinding();
    }

    public final int getDiamond() {
        return this.diamond;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_power_diamond;
    }

    @Nullable
    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogRoomPowerDiamondBinding) getBinding()).editText.setFilters(new InputFilter[]{new InputFilterMinMax(0, 500000)});
        ((DialogRoomPowerDiamondBinding) getBinding()).editText.setText(String.valueOf(this.diamond));
        final AppCompatImageView appCompatImageView = ((DialogRoomPowerDiamondBinding) getBinding()).close;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPowerDiamondDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.dismiss();
                }
            }
        });
        final AppCompatTextView appCompatTextView = ((DialogRoomPowerDiamondBinding) getBinding()).confirm;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPowerDiamondDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    if (!TextUtils.isEmpty(String.valueOf(RoomPowerDiamondDialog.access$getBinding(this).editText.getText()))) {
                        Function1<Integer, Unit> listener = this.getListener();
                        if (listener != null) {
                            listener.invoke(Integer.valueOf(Integer.parseInt(String.valueOf(RoomPowerDiamondDialog.access$getBinding(this).editText.getText()))));
                        }
                        this.dismiss();
                    }
                }
            }
        });
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    public /* synthetic */ RoomPowerDiamondDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }
}
