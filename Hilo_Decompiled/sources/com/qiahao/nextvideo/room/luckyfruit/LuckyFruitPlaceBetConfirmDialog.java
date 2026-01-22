package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogLuckyFruitPlaceBetConfirmBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u001aH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", ExchangeDetailActivity.TYPE_DIAMOND, "", "theme", "<init>", "(Landroid/content/Context;II)V", "getDiamond", "()I", "setDiamond", "(I)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitPlaceBetConfirmBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitPlaceBetConfirmBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitPlaceBetConfirmBinding;)V", "mLuckyFruitPlaceBetConfirmDialogListener", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialogListener;", "getMLuckyFruitPlaceBetConfirmDialogListener", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialogListener;", "setMLuckyFruitPlaceBetConfirmDialogListener", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialogListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTextDiamond", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitPlaceBetConfirmDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitPlaceBetConfirmDialog.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitPlaceBetConfirmDialog extends AppCompatDialog {

    @NotNull
    private static final String TAG = "LuckyFruitPlaceBetConfi";

    @Nullable
    private DialogLuckyFruitPlaceBetConfirmBinding binding;
    private int diamond;

    @Nullable
    private LuckyFruitPlaceBetConfirmDialogListener mLuckyFruitPlaceBetConfirmDialogListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitPlaceBetConfirmDialog(@NotNull Context context, int i, int i2) {
        super(context, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamond = i;
    }

    private final void initView() {
        AppCompatButton appCompatButton;
        AppCompatButton appCompatButton2;
        CheckBox checkBox;
        TextView textView;
        DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding = this.binding;
        if (dialogLuckyFruitPlaceBetConfirmBinding != null && (textView = dialogLuckyFruitPlaceBetConfirmBinding.tip) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952388), Arrays.copyOf(new Object[]{String.valueOf(this.diamond)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        final boolean luckyFruitConfirm = MeetingRoomManager.INSTANCE.getLuckyFruitConfirm();
        DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding2 = this.binding;
        if (dialogLuckyFruitPlaceBetConfirmBinding2 != null && (checkBox = dialogLuckyFruitPlaceBetConfirmBinding2.selectView) != null) {
            checkBox.setChecked(luckyFruitConfirm);
        }
        DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding3 = this.binding;
        if (dialogLuckyFruitPlaceBetConfirmBinding3 != null && (appCompatButton2 = dialogLuckyFruitPlaceBetConfirmBinding3.confirmReportButton) != null) {
            appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitPlaceBetConfirmDialog.initView$lambda$2(luckyFruitConfirm, this, view);
                }
            });
        }
        DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding4 = this.binding;
        if (dialogLuckyFruitPlaceBetConfirmBinding4 != null && (appCompatButton = dialogLuckyFruitPlaceBetConfirmBinding4.cancelButton) != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitPlaceBetConfirmDialog.this.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(boolean z, LuckyFruitPlaceBetConfirmDialog luckyFruitPlaceBetConfirmDialog, View view) {
        CheckBox checkBox;
        Log.d(TAG, "initView: isCheck = " + z);
        LuckyFruitPlaceBetConfirmDialogListener luckyFruitPlaceBetConfirmDialogListener = luckyFruitPlaceBetConfirmDialog.mLuckyFruitPlaceBetConfirmDialogListener;
        if (luckyFruitPlaceBetConfirmDialogListener != null) {
            DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding = luckyFruitPlaceBetConfirmDialog.binding;
            boolean z2 = false;
            if (dialogLuckyFruitPlaceBetConfirmBinding != null && (checkBox = dialogLuckyFruitPlaceBetConfirmBinding.selectView) != null && checkBox.isChecked()) {
                z2 = true;
            }
            luckyFruitPlaceBetConfirmDialogListener.onConfirm(z2);
        }
        luckyFruitPlaceBetConfirmDialog.dismiss();
    }

    @Nullable
    public final DialogLuckyFruitPlaceBetConfirmBinding getBinding() {
        return this.binding;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final LuckyFruitPlaceBetConfirmDialogListener getMLuckyFruitPlaceBetConfirmDialogListener() {
        return this.mLuckyFruitPlaceBetConfirmDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        View root;
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        DialogLuckyFruitPlaceBetConfirmBinding inflate = DialogLuckyFruitPlaceBetConfirmBinding.inflate(LayoutInflater.from(getContext()), null, false);
        this.binding = inflate;
        if (inflate != null && (root = inflate.getRoot()) != null) {
            setContentView(root);
        }
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        Dimens dimens = Dimens.INSTANCE;
        attributes.width = dimens.getScreenWidth() - dimens.dpToPx(68);
        attributes.height = -2;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setDimAmount(0.0f);
        initView();
    }

    public final void setBinding(@Nullable DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding) {
        this.binding = dialogLuckyFruitPlaceBetConfirmBinding;
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setMLuckyFruitPlaceBetConfirmDialogListener(@Nullable LuckyFruitPlaceBetConfirmDialogListener luckyFruitPlaceBetConfirmDialogListener) {
        this.mLuckyFruitPlaceBetConfirmDialogListener = luckyFruitPlaceBetConfirmDialogListener;
    }

    public final void setTextDiamond(int diamond) {
        TextView textView;
        this.diamond = diamond;
        DialogLuckyFruitPlaceBetConfirmBinding dialogLuckyFruitPlaceBetConfirmBinding = this.binding;
        if (dialogLuckyFruitPlaceBetConfirmBinding != null && (textView = dialogLuckyFruitPlaceBetConfirmBinding.tip) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952388), Arrays.copyOf(new Object[]{String.valueOf(diamond)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
    }

    public /* synthetic */ LuckyFruitPlaceBetConfirmDialog(Context context, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, (i3 & 4) != 0 ? R.style.HiloBottomSheetDialog : i2);
    }
}
