package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogGiftTextBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/GiftTextDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogGiftTextBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "mMaxTextNumber", "", "getMMaxTextNumber", "()I", "getLayoutResId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftTextDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftTextDialog.kt\ncom/qiahao/nextvideo/room/dialog/GiftTextDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,60:1\n61#2,9:61\n61#2,9:70\n*S KotlinDebug\n*F\n+ 1 GiftTextDialog.kt\ncom/qiahao/nextvideo/room/dialog/GiftTextDialog\n*L\n46#1:61,9\n55#1:70,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftTextDialog extends BaseBindingDialog<DialogGiftTextBinding> {

    @Nullable
    private Function1<? super String, Unit> listener;
    private final int mMaxTextNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftTextDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxTextNumber = 30;
    }

    public static final /* synthetic */ DialogGiftTextBinding access$getBinding(GiftTextDialog giftTextDialog) {
        return (DialogGiftTextBinding) giftTextDialog.getBinding();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_gift_text;
    }

    @Nullable
    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    public final int getMMaxTextNumber() {
        return this.mMaxTextNumber;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        ((DialogGiftTextBinding) getBinding()).editText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.dialog.GiftTextDialog$onCreate$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (s.length() > GiftTextDialog.this.getMMaxTextNumber()) {
                    return;
                }
                GiftTextDialog.access$getBinding(GiftTextDialog.this).number.setText(s.length() + "/" + GiftTextDialog.this.getMMaxTextNumber());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((DialogGiftTextBinding) getBinding()).number.setText("0/" + this.mMaxTextNumber);
        final TextView textView = ((DialogGiftTextBinding) getBinding()).confirm;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.GiftTextDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CharSequence charSequence;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Editable text = GiftTextDialog.access$getBinding(this).editText.getText();
                    if (text != null) {
                        charSequence = StringsKt.trim(text);
                    } else {
                        charSequence = null;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        Function1<String, Unit> listener = this.getListener();
                        if (listener != null) {
                            listener.invoke(String.valueOf(GiftTextDialog.access$getBinding(this).editText.getText()));
                        }
                        this.dismiss();
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131953673), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        final TextView textView2 = ((DialogGiftTextBinding) getBinding()).cancel;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.GiftTextDialog$onCreate$$inlined$singleClick$default$2
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

    public final void setListener(@Nullable Function1<? super String, Unit> function1) {
        this.listener = function1;
    }
}
