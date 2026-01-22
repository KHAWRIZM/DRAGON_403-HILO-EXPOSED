package com.therouter;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/therouter/Task;", "Ljava/lang/Runnable;", "r", AgooConstants.MESSAGE_TRACE, "", MessageMenuDialog.BLOCK, "Lkotlin/Function0;", "", "(Ljava/lang/Runnable;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getR", "()Ljava/lang/Runnable;", "getTrace", "()Ljava/lang/String;", "run", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Task implements Runnable {

    @NotNull
    private final Function0<Unit> block;

    @NotNull
    private final Runnable r;

    @NotNull
    private final String trace;

    public Task(@NotNull Runnable runnable, @NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(runnable, "r");
        Intrinsics.checkNotNullParameter(str, AgooConstants.MESSAGE_TRACE);
        Intrinsics.checkNotNullParameter(function0, MessageMenuDialog.BLOCK);
        this.r = runnable;
        this.trace = str;
        this.block = function0;
    }

    @NotNull
    public final Function0<Unit> getBlock() {
        return this.block;
    }

    @NotNull
    public final Runnable getR() {
        return this.r;
    }

    @NotNull
    public final String getTrace() {
        return this.trace;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.r.run();
        } finally {
            this.block.invoke();
        }
    }
}
