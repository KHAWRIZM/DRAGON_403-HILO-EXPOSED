package com.qiahao.nextvideo.ui.home.matching;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.hjq.permissions.permission.base.IPermission;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogMatchPermissionsBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/MatchPermissionDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogMatchPermissionsBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mListener", "Lkotlin/Function0;", "", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "getLayoutResId", "", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchPermissionDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchPermissionDialog.kt\ncom/qiahao/nextvideo/ui/home/matching/MatchPermissionDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,52:1\n61#2,9:53\n*S KotlinDebug\n*F\n+ 1 MatchPermissionDialog.kt\ncom/qiahao/nextvideo/ui/home/matching/MatchPermissionDialog\n*L\n29#1:53,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchPermissionDialog extends BaseBindingDialog<DialogMatchPermissionsBinding> {

    @Nullable
    private Function0<Unit> mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchPermissionDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_match_permissions;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final AppCompatButton appCompatButton = ((DialogMatchPermissionsBinding) getBinding()).allowButton;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.MatchPermissionDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.getContext());
                    if (activity != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(fa.b.f());
                        arrayList.add(fa.b.o());
                        if (!w9.h.n(activity, arrayList)) {
                            w9.h j2 = w9.h.t(activity).q(arrayList).j(new PermissionInterceptor());
                            final MatchPermissionDialog matchPermissionDialog = this;
                            j2.r(new w9.c() { // from class: com.qiahao.nextvideo.ui.home.matching.MatchPermissionDialog$onInitialize$1$1$1
                                public final void onResult(List<IPermission> list, List<IPermission> list2) {
                                    Intrinsics.checkNotNullParameter(list, "grantedList");
                                    Intrinsics.checkNotNullParameter(list2, "deniedList");
                                    if (list2.isEmpty()) {
                                        Function0<Unit> mListener = MatchPermissionDialog.this.getMListener();
                                        if (mListener != null) {
                                            mListener.invoke();
                                        }
                                        MatchPermissionDialog.this.dismiss();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }
}
