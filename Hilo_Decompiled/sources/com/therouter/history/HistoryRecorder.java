package com.therouter.history;

import com.therouter.TheRouterThreadPool;
import com.therouter.history.Level;
import com.therouter.inject.RecyclerLruCache;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n\"\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\"\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"$\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"$\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/therouter/history/a;", "event", "", "pushHistory", "(Lcom/therouter/history/a;)Z", "Lcom/therouter/history/Level;", "level", "", "", "export", "(Lcom/therouter/history/Level;)Ljava/util/List;", "", "counter", "J", "", "HISTORY_LOG_MAX_SIZE", "I", "getHISTORY_LOG_MAX_SIZE", "()I", "setHISTORY_LOG_MAX_SIZE", "(I)V", "Lcom/therouter/inject/RecyclerLruCache;", "mCacher", "Lcom/therouter/inject/RecyclerLruCache;", "Ljava/util/WeakHashMap;", "m2ndCacher", "Ljava/util/WeakHashMap;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "HistoryRecorder")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HistoryRecorder {
    private static int HISTORY_LOG_MAX_SIZE = 30;
    private static long counter;

    @NotNull
    private static final WeakHashMap<String, a> m2ndCacher;

    @NotNull
    private static final RecyclerLruCache<String, a> mCacher;

    static {
        RecyclerLruCache<String, a> recyclerLruCache = new RecyclerLruCache<>(HISTORY_LOG_MAX_SIZE);
        recyclerLruCache.setOnEntryRemovedListener(new Function3<String, a, a, Unit>() { // from class: com.therouter.history.HistoryRecorder$mCacher$1$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (a) obj2, (a) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable String str, @Nullable a aVar, @Nullable a aVar2) {
                WeakHashMap weakHashMap;
                weakHashMap = HistoryRecorder.m2ndCacher;
                weakHashMap.put(str, aVar);
            }
        });
        mCacher = recyclerLruCache;
        m2ndCacher = new WeakHashMap<>();
    }

    @NotNull
    public static final List<String> export(@NotNull Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        ArrayList arrayList = new ArrayList();
        long j = counter;
        long j2 = 0;
        if (0 <= j) {
            while (true) {
                a aVar = mCacher.get(String.valueOf(j2));
                if (aVar == null) {
                    aVar = m2ndCacher.get(String.valueOf(j2));
                }
                if (aVar != null) {
                    if (aVar instanceof ActivityNavigatorHistory) {
                        int v = level.getV();
                        Level.Companion companion = Level.INSTANCE;
                        if ((v & companion.getACTIVITY().getV()) == companion.getACTIVITY().getV()) {
                            arrayList.add(((ActivityNavigatorHistory) aVar).getEvent());
                        }
                    } else if (aVar instanceof FragmentNavigatorHistory) {
                        int v2 = level.getV();
                        Level.Companion companion2 = Level.INSTANCE;
                        if ((v2 & companion2.getFRAGMENT().getV()) == companion2.getFRAGMENT().getV()) {
                            arrayList.add(((FragmentNavigatorHistory) aVar).getEvent());
                        }
                    } else if (aVar instanceof ActionNavigatorHistory) {
                        int v3 = level.getV();
                        Level.Companion companion3 = Level.INSTANCE;
                        if ((v3 & companion3.getACTION().getV()) == companion3.getACTION().getV()) {
                            arrayList.add(((ActionNavigatorHistory) aVar).getEvent());
                        }
                    } else if (aVar instanceof ServiceProviderHistory) {
                        int v4 = level.getV();
                        Level.Companion companion4 = Level.INSTANCE;
                        if ((v4 & companion4.getSERVICE_PROVIDER().getV()) == companion4.getSERVICE_PROVIDER().getV()) {
                            arrayList.add(((ServiceProviderHistory) aVar).getEvent());
                        }
                    } else if (aVar instanceof FlowTaskHistory) {
                        int v5 = level.getV();
                        Level.Companion companion5 = Level.INSTANCE;
                        if ((v5 & companion5.getFLOW_TASK().getV()) == companion5.getFLOW_TASK().getV()) {
                            arrayList.add(((FlowTaskHistory) aVar).getEvent());
                        }
                    }
                }
                if (j2 == j) {
                    break;
                }
                j2++;
            }
        }
        return arrayList;
    }

    public static final int getHISTORY_LOG_MAX_SIZE() {
        return HISTORY_LOG_MAX_SIZE;
    }

    public static final boolean pushHistory(@NotNull final a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "event");
        return TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.history.b
            @Override // java.lang.Runnable
            public final void run() {
                HistoryRecorder.pushHistory$lambda$1(a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pushHistory$lambda$1(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "$event");
        RecyclerLruCache<String, a> recyclerLruCache = mCacher;
        long j = counter;
        counter = 1 + j;
        recyclerLruCache.put(String.valueOf(j), aVar);
    }

    public static final void setHISTORY_LOG_MAX_SIZE(int i) {
        HISTORY_LOG_MAX_SIZE = i;
    }
}
