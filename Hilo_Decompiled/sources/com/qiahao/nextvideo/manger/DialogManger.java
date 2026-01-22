package com.qiahao.nextvideo.manger;

import android.app.Dialog;
import android.content.DialogInterface;
import com.qiahao.nextvideo.manger.DialogManger;
import java.util.HashMap;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/manger/DialogManger;", "", "<init>", "()V", "mDialogLevels", "Ljava/util/Stack;", "Lcom/qiahao/nextvideo/manger/DialogTag;", "mAllDialog", "Ljava/util/HashMap;", "Landroid/app/Dialog;", "addDialog", "dialog", "tag", "addStack", "", "addStackAndShow", "deleteDialog", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DialogManger {

    @NotNull
    public static final DialogManger INSTANCE = new DialogManger();

    @NotNull
    private static final Stack<DialogTag> mDialogLevels = new Stack<>();

    @NotNull
    private static final HashMap<DialogTag, Dialog> mAllDialog = new HashMap<>();

    private DialogManger() {
    }

    private final void addStack(Dialog dialog, DialogTag tag) {
        Stack<DialogTag> stack = mDialogLevels;
        if (stack.size() > 0) {
            if (tag.getLevel() > stack.peek().getLevel()) {
                addStackAndShow(dialog, tag);
                return;
            }
            return;
        }
        addStackAndShow(dialog, tag);
    }

    private final void addStackAndShow(Dialog dialog, DialogTag tag) {
        mDialogLevels.push(tag);
        Intrinsics.checkNotNull(dialog);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kb.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogManger.addStackAndShow$lambda$0(dialogInterface);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addStackAndShow$lambda$0(DialogInterface dialogInterface) {
        DialogTag pop = mDialogLevels.pop();
        if (pop != null) {
            HashMap<DialogTag, Dialog> hashMap = mAllDialog;
            hashMap.remove(pop);
            for (DialogTag dialogTag : hashMap.keySet()) {
                Intrinsics.checkNotNullExpressionValue(dialogTag, "next(...)");
                DialogTag dialogTag2 = dialogTag;
                if (dialogTag2.getLevel() >= pop.getLevel()) {
                    INSTANCE.addStack(mAllDialog.get(dialogTag2), dialogTag2);
                    return;
                }
            }
            HashMap<DialogTag, Dialog> hashMap2 = mAllDialog;
            if (hashMap2.size() > 0) {
                for (DialogTag dialogTag3 : hashMap2.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(dialogTag3, "next(...)");
                    DialogTag dialogTag4 = dialogTag3;
                    INSTANCE.addStack(mAllDialog.get(dialogTag4), dialogTag4);
                }
            }
        }
    }

    @NotNull
    public final DialogManger addDialog(@NotNull Dialog dialog, @NotNull DialogTag tag) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(tag, "tag");
        mAllDialog.put(tag, dialog);
        addStack(dialog, tag);
        return this;
    }

    public final void deleteDialog(@NotNull DialogTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        mAllDialog.remove(tag);
    }
}
