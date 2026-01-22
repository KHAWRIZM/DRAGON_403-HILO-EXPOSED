package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WorkQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\bR\u00020\u0000H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "maxConcurrent", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningCount", "runningJobs", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "addActiveWorkItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "addToFront", "", "execute", "", "node", "finishItemAndStartNew", "finished", "startItem", "validate", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WorkQueue {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;

    @NotNull
    private final Executor executor;
    private final int maxConcurrent;

    @Nullable
    private WorkNode pendingJobs;
    private int runningCount;

    @Nullable
    private WorkNode runningJobs;

    @NotNull
    private final ReentrantLock workLock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "()V", "DEFAULT_MAX_CONCURRENT", "", "assert", "", "condition", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: assert, reason: not valid java name */
        public final void m٣٩٠assert(boolean condition) {
            if (condition) {
            } else {
                throw new FacebookException("Validation failed");
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "isRunning", "", "()Z", "cancel", "moveToFront", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface WorkItem {
        boolean cancel();

        /* renamed from: isRunning */
        boolean getIsRunning();

        void moveToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00060\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\f\u001a\b\u0018\u00010\u0000R\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0000R\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "getCallback", "()Ljava/lang/Runnable;", "isRunning", "", "()Z", "setRunning", "(Z)V", "<set-?>", "Lcom/facebook/internal/WorkQueue;", "next", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "addToList", "list", "addToFront", "cancel", "moveToFront", "", "removeFromList", "verify", "shouldBeRunning", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class WorkNode implements WorkItem {

        @NotNull
        private final Runnable callback;
        private boolean isRunning;

        @Nullable
        private WorkNode next;

        @Nullable
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(@NotNull WorkQueue this$0, Runnable callback) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = this$0;
            this.callback = callback;
        }

        @NotNull
        public final WorkNode addToList(@Nullable WorkNode list, boolean addToFront) {
            boolean z10;
            WorkNode workNode;
            Companion companion = WorkQueue.INSTANCE;
            boolean z11 = false;
            if (this.next == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            companion.m٣٩٠assert(z10);
            if (this.prev == null) {
                z11 = true;
            }
            companion.m٣٩٠assert(z11);
            if (list == null) {
                this.prev = this;
                this.next = this;
                list = this;
            } else {
                this.next = list;
                WorkNode workNode2 = list.prev;
                this.prev = workNode2;
                if (workNode2 != null) {
                    workNode2.next = this;
                }
                WorkNode workNode3 = this.next;
                if (workNode3 != null) {
                    if (workNode2 == null) {
                        workNode = null;
                    } else {
                        workNode = workNode2.next;
                    }
                    workNode3.prev = workNode;
                }
            }
            if (addToFront) {
                return this;
            }
            return list;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!getIsRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    reentrantLock.unlock();
                    return true;
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                return false;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @NotNull
        public final Runnable getCallback() {
            return this.callback;
        }

        @Nullable
        public final WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        /* renamed from: isRunning, reason: from getter */
        public boolean getIsRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            reentrantLock.lock();
            try {
                if (!getIsRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Nullable
        public final WorkNode removeFromList(@Nullable WorkNode list) {
            boolean z10;
            Companion companion = WorkQueue.INSTANCE;
            boolean z11 = false;
            if (this.next != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            companion.m٣٩٠assert(z10);
            if (this.prev != null) {
                z11 = true;
            }
            companion.m٣٩٠assert(z11);
            if (list == this && (list = this.next) == this) {
                list = null;
            }
            WorkNode workNode = this.next;
            if (workNode != null) {
                workNode.prev = this.prev;
            }
            WorkNode workNode2 = this.prev;
            if (workNode2 != null) {
                workNode2.next = workNode;
            }
            this.prev = null;
            this.next = null;
            return list;
        }

        public void setRunning(boolean z10) {
            this.isRunning = z10;
        }

        public final void verify(boolean shouldBeRunning) {
            WorkNode workNode;
            boolean z10;
            WorkNode workNode2;
            boolean z11;
            Companion companion = WorkQueue.INSTANCE;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            boolean z12 = false;
            if (workNode == this) {
                z10 = true;
            } else {
                z10 = false;
            }
            companion.m٣٩٠assert(z10);
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            if (workNode2 == this) {
                z11 = true;
            } else {
                z11 = false;
            }
            companion.m٣٩٠assert(z11);
            if (getIsRunning() == shouldBeRunning) {
                z12 = true;
            }
            companion.m٣٩٠assert(z12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public WorkQueue() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return workQueue.addActiveWorkItem(runnable, z10);
    }

    private final void execute(final WorkNode node) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.a0
            @Override // java.lang.Runnable
            public final void run() {
                WorkQueue.m٣٨٩execute$lambda2(WorkQueue.WorkNode.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execute$lambda-2, reason: not valid java name */
    public static final void m٣٨٩execute$lambda2(WorkNode node, WorkQueue this$0) {
        Intrinsics.checkNotNullParameter(node, "$node");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            node.getCallback().run();
        } finally {
            this$0.finishItemAndStartNew(node);
        }
    }

    private final void finishItemAndStartNew(WorkNode finished) {
        WorkNode workNode;
        this.workLock.lock();
        if (finished != null) {
            this.runningJobs = finished.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode = this.pendingJobs;
            if (workNode != null) {
                this.pendingJobs = workNode.removeFromList(workNode);
                this.runningJobs = workNode.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode.setRunning(true);
            }
        } else {
            workNode = null;
        }
        this.workLock.unlock();
        if (workNode != null) {
            execute(workNode);
        }
    }

    private final void startItem() {
        finishItemAndStartNew(null);
    }

    @JvmOverloads
    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return addActiveWorkItem$default(this, callback, false, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r1 = com.facebook.internal.WorkQueue.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if (r6.runningCount != r4) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r1.m٣٩٠assert(r2);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r0.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r1 != null) goto L٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        if (r1 == null) goto L٢٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        r1.verify(true);
        r4 = r4 + 1;
        r1 = r1.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r1 != r6.runningJobs) goto L٢٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void validate() {
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            WorkNode workNode = this.runningJobs;
            boolean z10 = false;
            int i10 = 0;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public WorkQueue(int i10) {
        this(i10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable callback, boolean addToFront) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        WorkNode workNode = new WorkNode(this, callback);
        ReentrantLock reentrantLock = this.workLock;
        reentrantLock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, addToFront);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @JvmOverloads
    public WorkQueue(int i10, @NotNull Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.maxConcurrent = i10;
        this.executor = executor;
        this.workLock = new ReentrantLock();
    }

    public /* synthetic */ WorkQueue(int i10, Executor executor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 8 : i10, (i11 & 2) != 0 ? FacebookSdk.getExecutor() : executor);
    }
}
