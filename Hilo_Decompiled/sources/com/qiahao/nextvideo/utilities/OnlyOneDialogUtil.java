package com.qiahao.nextvideo.utilities;

import android.app.Dialog;
import android.content.DialogInterface;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/utilities/OnlyOneDialogUtil;", "", "<init>", "()V", "dialogQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/qiahao/nextvideo/utilities/OnlyOneDialogUtil$DialogWrapper;", "currentDialog", "addDialog", "", "dialog", "Landroid/app/Dialog;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "type", "", "isDialogExist", "", "dialogWrapper", "tryShowNextDialog", "removeAllDialogs", "getQueueSize", "", "hasPendingDialogs", "DialogWrapper", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOnlyOneDialogUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnlyOneDialogUtil.kt\ncom/qiahao/nextvideo/utilities/OnlyOneDialogUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OnlyOneDialogUtil {

    @Nullable
    private static DialogWrapper currentDialog;

    @NotNull
    public static final OnlyOneDialogUtil INSTANCE = new OnlyOneDialogUtil();

    @NotNull
    private static final ConcurrentLinkedQueue<DialogWrapper> dialogQueue = new ConcurrentLinkedQueue<>();

    private OnlyOneDialogUtil() {
    }

    public static /* synthetic */ void addDialog$default(OnlyOneDialogUtil onlyOneDialogUtil, Dialog dialog, DialogInterface.OnDismissListener onDismissListener, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            onDismissListener = null;
        }
        if ((i & 4) != 0) {
            str = String.valueOf(com.qiahao.base_common.utils.f.e());
        }
        onlyOneDialogUtil.addDialog(dialog, onDismissListener, str);
    }

    private final boolean isDialogExist(DialogWrapper dialogWrapper) {
        String str;
        DialogWrapper dialogWrapper2 = currentDialog;
        if (dialogWrapper2 != null) {
            str = dialogWrapper2.getType();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, dialogWrapper.getType())) {
            return true;
        }
        Iterator<DialogWrapper> it = dialogQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getType(), dialogWrapper.getType())) {
                return true;
            }
        }
        return false;
    }

    private final void tryShowNextDialog() {
        DialogWrapper poll;
        Dialog dialog;
        Dialog dialog2;
        DialogWrapper dialogWrapper = currentDialog;
        if ((dialogWrapper == null || (dialog2 = dialogWrapper.getDialog()) == null || !dialog2.isShowing()) && (poll = dialogQueue.poll()) != null) {
            currentDialog = poll;
            Dialog dialog3 = poll.getDialog();
            if (dialog3 != null) {
                dialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.utilities.j0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        OnlyOneDialogUtil.tryShowNextDialog$lambda$0(dialogInterface);
                    }
                });
            }
            try {
                DialogWrapper dialogWrapper2 = currentDialog;
                if (dialogWrapper2 != null && (dialog = dialogWrapper2.getDialog()) != null) {
                    dialog.show();
                }
            } catch (Exception unused) {
                currentDialog = null;
                tryShowNextDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryShowNextDialog$lambda$0(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener;
        DialogWrapper dialogWrapper = currentDialog;
        if (dialogWrapper != null && (onDismissListener = dialogWrapper.getOnDismissListener()) != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        currentDialog = null;
        INSTANCE.tryShowNextDialog();
    }

    public final void addDialog(@NotNull Dialog dialog, @Nullable DialogInterface.OnDismissListener onDismissListener, @NotNull String type) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(type, "type");
        DialogWrapper dialogWrapper = new DialogWrapper(dialog, onDismissListener, type);
        if (!isDialogExist(dialogWrapper)) {
            dialogQueue.offer(dialogWrapper);
            tryShowNextDialog();
        }
    }

    public final int getQueueSize() {
        return dialogQueue.size();
    }

    public final boolean hasPendingDialogs() {
        Dialog dialog;
        DialogWrapper dialogWrapper = currentDialog;
        if ((dialogWrapper != null && (dialog = dialogWrapper.getDialog()) != null && dialog.isShowing()) || !dialogQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public final void removeAllDialogs() {
        Dialog dialog;
        Dialog dialog2;
        DialogWrapper dialogWrapper = currentDialog;
        if (dialogWrapper != null && (dialog2 = dialogWrapper.getDialog()) != null) {
            if (!dialog2.isShowing()) {
                dialog2 = null;
            }
            if (dialog2 != null) {
                try {
                    dialog2.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        currentDialog = null;
        while (true) {
            ConcurrentLinkedQueue<DialogWrapper> concurrentLinkedQueue = dialogQueue;
            if (!concurrentLinkedQueue.isEmpty()) {
                DialogWrapper poll = concurrentLinkedQueue.poll();
                if (poll != null && (dialog = poll.getDialog()) != null) {
                    if (!dialog.isShowing()) {
                        dialog = null;
                    }
                    if (dialog != null) {
                        try {
                            dialog.dismiss();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/utilities/OnlyOneDialogUtil$DialogWrapper;", "", "dialog", "Landroid/app/Dialog;", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "type", "", "<init>", "(Landroid/app/Dialog;Landroid/content/DialogInterface$OnDismissListener;Ljava/lang/String;)V", "getDialog", "()Landroid/app/Dialog;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final /* data */ class DialogWrapper {

        @NotNull
        private final Dialog dialog;

        @Nullable
        private final DialogInterface.OnDismissListener onDismissListener;

        @NotNull
        private String type;

        public DialogWrapper(@NotNull Dialog dialog, @Nullable DialogInterface.OnDismissListener onDismissListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(str, "type");
            this.dialog = dialog;
            this.onDismissListener = onDismissListener;
            this.type = str;
        }

        public static /* synthetic */ DialogWrapper copy$default(DialogWrapper dialogWrapper, Dialog dialog, DialogInterface.OnDismissListener onDismissListener, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                dialog = dialogWrapper.dialog;
            }
            if ((i & 2) != 0) {
                onDismissListener = dialogWrapper.onDismissListener;
            }
            if ((i & 4) != 0) {
                str = dialogWrapper.type;
            }
            return dialogWrapper.copy(dialog, onDismissListener, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Dialog getDialog() {
            return this.dialog;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final DialogInterface.OnDismissListener getOnDismissListener() {
            return this.onDismissListener;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final DialogWrapper copy(@NotNull Dialog dialog, @Nullable DialogInterface.OnDismissListener onDismissListener, @NotNull String type) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(type, "type");
            return new DialogWrapper(dialog, onDismissListener, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DialogWrapper)) {
                return false;
            }
            DialogWrapper dialogWrapper = (DialogWrapper) other;
            return Intrinsics.areEqual(this.dialog, dialogWrapper.dialog) && Intrinsics.areEqual(this.onDismissListener, dialogWrapper.onDismissListener) && Intrinsics.areEqual(this.type, dialogWrapper.type);
        }

        @NotNull
        public final Dialog getDialog() {
            return this.dialog;
        }

        @Nullable
        public final DialogInterface.OnDismissListener getOnDismissListener() {
            return this.onDismissListener;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int hashCode = this.dialog.hashCode() * 31;
            DialogInterface.OnDismissListener onDismissListener = this.onDismissListener;
            return ((hashCode + (onDismissListener == null ? 0 : onDismissListener.hashCode())) * 31) + this.type.hashCode();
        }

        public final void setType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        @NotNull
        public String toString() {
            return "DialogWrapper(dialog=" + this.dialog + ", onDismissListener=" + this.onDismissListener + ", type=" + this.type + ")";
        }

        public /* synthetic */ DialogWrapper(Dialog dialog, DialogInterface.OnDismissListener onDismissListener, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(dialog, onDismissListener, (i & 4) != 0 ? "" : str);
        }
    }
}
