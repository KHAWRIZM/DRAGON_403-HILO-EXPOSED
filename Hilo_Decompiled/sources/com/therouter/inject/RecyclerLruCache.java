package com.therouter.inject;

import android.util.LruCache;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0012JS\u0010\u0013\u001a\u00020\u000e2K\u0010\u0014\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bJ\u001c\u0010\u0013\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016RS\u0010\u0007\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/therouter/inject/RecyclerLruCache;", "K", "V", "Landroid/util/LruCache;", "maxSize", "", "(I)V", "mListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "key", "oldValue", "newValue", "", "entryRemoved", "evicted", "", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "setOnEntryRemovedListener", MessageMenuDialog.BLOCK, "listener", "Lcom/therouter/inject/RecyclerLruCache$OnEntryRemovedListener;", "OnEntryRemovedListener", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RecyclerLruCache<K, V> extends LruCache<K, V> {

    @NotNull
    private Function3<? super K, ? super V, ? super V, Unit> mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0007\u001a\u00028\u00032\u0006\u0010\b\u001a\u00028\u0003H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/therouter/inject/RecyclerLruCache$OnEntryRemovedListener;", "K", "V", "", "entryRemoved", "", "key", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnEntryRemovedListener<K, V> {
        void entryRemoved(K key, V oldValue, V newValue);
    }

    public RecyclerLruCache(int i) {
        super(i);
        this.mListener = new Function3<K, V, V, Unit>() { // from class: com.therouter.inject.RecyclerLruCache$mListener$1
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٧٧invoke(K k, V v, V v2) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m١٧٧invoke((RecyclerLruCache$mListener$1<K, V>) obj, obj2, obj3);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        super.entryRemoved(evicted, key, oldValue, newValue);
        this.mListener.invoke(key, oldValue, newValue);
    }

    public final void setOnEntryRemovedListener(@Nullable OnEntryRemovedListener<K, V> listener) {
        if (listener != null) {
            this.mListener = new RecyclerLruCache$setOnEntryRemovedListener$1$1(listener);
        }
    }

    public final void setOnEntryRemovedListener(@NotNull Function3<? super K, ? super V, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        this.mListener = block;
    }
}
