package com.qiahao.nextvideo.room.game;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCrushIntroduceBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/CrushIntroduceDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCrushIntroduceBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrushIntroduceDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrushIntroduceDialog.kt\ncom/qiahao/nextvideo/room/game/CrushIntroduceDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,25:1\n61#2,9:26\n*S KotlinDebug\n*F\n+ 1 CrushIntroduceDialog.kt\ncom/qiahao/nextvideo/room/game/CrushIntroduceDialog\n*L\n21#1:26,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CrushIntroduceDialog extends BaseBindingDialog<DialogCrushIntroduceBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrushIntroduceDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_crush_introduce;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final TextView textView = ((DialogCrushIntroduceBinding) getBinding()).confirm;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.CrushIntroduceDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }
}
