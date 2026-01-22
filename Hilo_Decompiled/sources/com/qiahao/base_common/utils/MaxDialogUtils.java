package com.qiahao.base_common.utils;

import com.qiahao.base_common.common.BaseDialog;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/utils/MaxDialogUtils;", "", "<init>", "()V", "MAX_DIALOG_SIZE", "", "dialogQueue", "Ljava/util/Queue;", "Lcom/qiahao/base_common/common/BaseDialog;", "showDialog", "", "dialog", "releaseAllDialog", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MaxDialogUtils {

    @NotNull
    public static final MaxDialogUtils INSTANCE = new MaxDialogUtils();
    private static int MAX_DIALOG_SIZE = 8;

    @NotNull
    private static final Queue<BaseDialog> dialogQueue = new LinkedList();

    private MaxDialogUtils() {
    }

    public final void releaseAllDialog() {
        while (true) {
            Queue<BaseDialog> queue = dialogQueue;
            if (!queue.isEmpty()) {
                BaseDialog poll = queue.poll();
                if (poll != null && poll.isShowing()) {
                    poll.dismiss();
                }
            } else {
                return;
            }
        }
    }

    public final void showDialog(@Nullable BaseDialog dialog) {
        final BaseDialog poll;
        Queue<BaseDialog> queue = dialogQueue;
        if (queue.size() >= MAX_DIALOG_SIZE && (poll = queue.poll()) != null && poll.isShowing()) {
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.base_common.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    BaseDialog.this.dismiss();
                }
            }, 500L);
        }
        if (dialog != null) {
            queue.offer(dialog);
            dialog.show();
        }
    }
}
