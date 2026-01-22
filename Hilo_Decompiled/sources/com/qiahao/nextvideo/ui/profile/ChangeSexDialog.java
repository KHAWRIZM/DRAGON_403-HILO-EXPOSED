package com.qiahao.nextvideo.ui.profile;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.DialogChangeSexBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0016R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/ChangeSexDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogChangeSexBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mListener", "Lkotlin/Function1;", "", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "isNeedFullScreen", "", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChangeSexDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChangeSexDialog.kt\ncom/qiahao/nextvideo/ui/profile/ChangeSexDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,49:1\n61#2,9:50\n61#2,9:59\n*S KotlinDebug\n*F\n+ 1 ChangeSexDialog.kt\ncom/qiahao/nextvideo/ui/profile/ChangeSexDialog\n*L\n28#1:50,9\n31#1:59,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChangeSexDialog extends BaseBindingDialog<DialogChangeSexBinding> {

    @Nullable
    private Function1<? super Integer, Unit> mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeSexDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$2(ChangeSexDialog changeSexDialog, View view) {
        int checkedRadioButtonId = ((DialogChangeSexBinding) changeSexDialog.getBinding()).sexRadioGroup.getCheckedRadioButtonId();
        Function1<? super Integer, Unit> function1 = changeSexDialog.mListener;
        if (function1 != null) {
            int i = 1;
            if (checkedRadioButtonId != 2131362175 && checkedRadioButtonId == 2131363048) {
                i = 2;
            }
            function1.invoke(Integer.valueOf(i));
        }
        changeSexDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_change_sex;
    }

    @Nullable
    public final Function1<Integer, Unit> getMListener() {
        return this.mListener;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final FrameLayout frameLayout = ((DialogChangeSexBinding) getBinding()).frameLayout;
        final long j = 800;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.ChangeSexDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final CardView cardView = ((DialogChangeSexBinding) getBinding()).contentBg;
        cardView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.ChangeSexDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(cardView) > j || (cardView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(cardView, currentTimeMillis);
                    CardView cardView2 = cardView;
                }
            }
        });
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.getSex() == 1) {
            ((DialogChangeSexBinding) getBinding()).sexRadioGroup.check(R.id.boy_radio_button);
        } else {
            ((DialogChangeSexBinding) getBinding()).sexRadioGroup.check(R.id.girl_radio_button);
        }
        ((DialogChangeSexBinding) getBinding()).confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeSexDialog.onInitialize$lambda$2(ChangeSexDialog.this, view);
            }
        });
    }

    public final void setMListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.mListener = function1;
    }
}
