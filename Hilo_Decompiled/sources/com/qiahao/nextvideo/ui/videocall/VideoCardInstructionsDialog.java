package com.qiahao.nextvideo.ui.videocall;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogVideoInstructionsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoCardInstructionsDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogVideoInstructionsBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoCardInstructionsDialog extends BaseBindingDialog<DialogVideoInstructionsBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCardInstructionsDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VideoCardInstructionsDialog videoCardInstructionsDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            videoCardInstructionsDialog.dismiss();
        }
    }

    protected int getLayoutResId() {
        return R.layout.dialog_video_instructions;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        ((DialogVideoInstructionsBinding) getBinding()).confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoCardInstructionsDialog.onCreate$lambda$0(VideoCardInstructionsDialog.this, view);
            }
        });
    }
}
