package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpTipBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpTipDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpTipBinding;", "context", "Landroid/content/Context;", "cpMemorial", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/cp/CpMemorial;)V", "getLayoutResId", "", "isNeedFullScreen", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpTipDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpTipDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpTipDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,52:1\n61#2,9:53\n61#2,9:62\n61#2,9:71\n61#2,9:80\n61#2,9:89\n61#2,9:98\n*S KotlinDebug\n*F\n+ 1 CpTipDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpTipDialog\n*L\n29#1:53,9\n32#1:62,9\n38#1:71,9\n39#1:80,9\n43#1:89,9\n47#1:98,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpTipDialog extends BaseBindingDialog<DialogCpTipBinding> {

    @NotNull
    private final CpMemorial cpMemorial;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpTipDialog(@NotNull Context context, @NotNull CpMemorial cpMemorial) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cpMemorial, "cpMemorial");
        this.cpMemorial = cpMemorial;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_tip;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        User cpUserInfo;
        User userInfo;
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        final ConstraintLayout constraintLayout = ((DialogCpTipBinding) getBinding()).constraintLayout;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.dismiss();
                }
            }
        });
        final TextView textView = ((DialogCpTipBinding) getBinding()).confirm;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        TextView textView2 = ((DialogCpTipBinding) getBinding()).title;
        String content = this.cpMemorial.getContent();
        if (content == null) {
            content = "";
        }
        textView2.setText(content);
        HiloImageView hiloImageView = ((DialogCpTipBinding) getBinding()).leftAvatar;
        CpInfo cpInfo = this.cpMemorial.getCpInfo();
        String str2 = null;
        if (cpInfo != null && (userInfo = cpInfo.getUserInfo()) != null) {
            str = userInfo.getAvatar();
        } else {
            str = null;
        }
        HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(str), 0, 0, 6, (Object) null);
        HiloImageView hiloImageView2 = ((DialogCpTipBinding) getBinding()).rightAvatar;
        CpInfo cpInfo2 = this.cpMemorial.getCpInfo();
        if (cpInfo2 != null && (cpUserInfo = cpInfo2.getCpUserInfo()) != null) {
            str2 = cpUserInfo.getAvatar();
        }
        HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(str2), 0, 0, 6, (Object) null);
        final FrameLayout frameLayout = ((DialogCpTipBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                }
            }
        });
        final TextView textView3 = ((DialogCpTipBinding) getBinding()).confirm;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        service.openMemorial();
                    }
                    this.dismiss();
                }
            }
        });
        final HiloImageView hiloImageView3 = ((DialogCpTipBinding) getBinding()).leftAvatar;
        hiloImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpMemorial cpMemorial;
                String str3;
                User userInfo2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView3) > j || (hiloImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView3, currentTimeMillis);
                    HiloImageView hiloImageView4 = hiloImageView3;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        cpMemorial = this.cpMemorial;
                        CpInfo cpInfo3 = cpMemorial.getCpInfo();
                        if (cpInfo3 == null || (userInfo2 = cpInfo3.getUserInfo()) == null || (str3 = userInfo2.getAvatar()) == null) {
                            str3 = "";
                        }
                        service.openPersonPage(str3);
                    }
                }
            }
        });
        final HiloImageView hiloImageView4 = ((DialogCpTipBinding) getBinding()).rightAvatar;
        hiloImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpTipDialog$onCreate$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpMemorial cpMemorial;
                String str3;
                User cpUserInfo2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView4) > j || (hiloImageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(hiloImageView4, currentTimeMillis);
                    HiloImageView hiloImageView5 = hiloImageView4;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        cpMemorial = this.cpMemorial;
                        CpInfo cpInfo3 = cpMemorial.getCpInfo();
                        if (cpInfo3 == null || (cpUserInfo2 = cpInfo3.getCpUserInfo()) == null || (str3 = cpUserInfo2.getAvatar()) == null) {
                            str3 = "";
                        }
                        service.openPersonPage(str3);
                    }
                }
            }
        });
    }
}
