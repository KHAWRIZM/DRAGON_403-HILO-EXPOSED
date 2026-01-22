package com.qiahao.nextvideo.ui.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogSvipUnblockBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/SvipUnBlockDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogSvipUnblockBinding;", "context", "Landroid/content/Context;", "todayNumber", "", "monthNumber", "<init>", "(Landroid/content/Context;II)V", "listener", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "getLayoutResId", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipUnBlockDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipUnBlockDialog.kt\ncom/qiahao/nextvideo/ui/profile/SvipUnBlockDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,40:1\n61#2,9:41\n61#2,9:50\n*S KotlinDebug\n*F\n+ 1 SvipUnBlockDialog.kt\ncom/qiahao/nextvideo/ui/profile/SvipUnBlockDialog\n*L\n31#1:41,9\n35#1:50,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipUnBlockDialog extends BaseBindingDialog<DialogSvipUnblockBinding> {

    @Nullable
    private OnCommonDialogListener listener;
    private final int monthNumber;
    private final int todayNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvipUnBlockDialog(@NotNull Context context, int i, int i2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.todayNumber = i;
        this.monthNumber = i2;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_svip_unblock;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953903), Arrays.copyOf(new Object[]{Integer.valueOf(this.todayNumber)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(((DialogSvipUnblockBinding) getBinding()).content1), format, String.valueOf(this.todayNumber), Integer.valueOf(Color.parseColor("#9036FF")), (Integer) null, 8, (Object) null).apply();
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953902), Arrays.copyOf(new Object[]{Integer.valueOf(this.monthNumber)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(((DialogSvipUnblockBinding) getBinding()).content2), format2, String.valueOf(this.monthNumber), Integer.valueOf(Color.parseColor("#9036FF")), (Integer) null, 8, (Object) null).apply();
        final TextView textView = ((DialogSvipUnblockBinding) getBinding()).confirm;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.SvipUnBlockDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    OnCommonDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.confirm();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogSvipUnblockBinding) getBinding()).cancel;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.SvipUnBlockDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.listener = onCommonDialogListener;
    }

    public /* synthetic */ SvipUnBlockDialog(Context context, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, i2);
    }
}
