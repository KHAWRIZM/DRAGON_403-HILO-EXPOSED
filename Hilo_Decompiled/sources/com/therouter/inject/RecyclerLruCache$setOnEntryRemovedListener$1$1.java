package com.therouter.inject;

import com.therouter.inject.RecyclerLruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
/* synthetic */ class RecyclerLruCache$setOnEntryRemovedListener$1$1<K, V> extends FunctionReferenceImpl implements Function3<K, V, V, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerLruCache$setOnEntryRemovedListener$1$1(Object obj) {
        super(3, obj, RecyclerLruCache.OnEntryRemovedListener.class, "entryRemoved", "entryRemoved(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m١٧٨invoke((RecyclerLruCache$setOnEntryRemovedListener$1$1<K, V>) obj, obj2, obj3);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m١٧٨invoke(K k, V v, V v2) {
        ((RecyclerLruCache.OnEntryRemovedListener) ((CallableReference) this).receiver).entryRemoved(k, v, v2);
    }
}
