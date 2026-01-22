package com.oudi.core.common.listener;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0011H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oudi/core/common/listener/SafeListenerOwner;", "T", "Lcom/oudi/core/common/listener/ListenerOwner;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "checkCreateListener", "", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/Object;)V", "addFirstListener", "removeListener", "removeAllListener", "postEvent", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSafeListenerOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeListenerOwner.kt\ncom/oudi/core/common/listener/SafeListenerOwner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1863#2,2:47\n*S KotlinDebug\n*F\n+ 1 SafeListenerOwner.kt\ncom/oudi/core/common/listener/SafeListenerOwner\n*L\n42#1:47,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SafeListenerOwner<T> implements ListenerOwner<T> {

    @Nullable
    private CopyOnWriteArrayList<T> listeners;

    private final void checkCreateListener() {
        if (this.listeners == null) {
            this.listeners = new CopyOnWriteArrayList<>();
        }
    }

    @Override // com.oudi.core.common.listener.ListenerStore
    public void addFirstListener(T listener) {
        checkCreateListener();
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(0, listener);
        }
    }

    @Override // com.oudi.core.common.listener.ListenerStore
    public void addListener(T listener) {
        checkCreateListener();
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(listener);
        }
    }

    @Override // com.oudi.core.common.listener.ListenerOwner
    public void postEvent(@NotNull Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                block.invoke(it.next());
            }
        }
    }

    @Override // com.oudi.core.common.listener.ListenerStore
    public void removeAllListener() {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        this.listeners = null;
    }

    @Override // com.oudi.core.common.listener.ListenerStore
    public void removeListener(T listener) {
        CopyOnWriteArrayList<T> copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(listener);
        }
    }
}
