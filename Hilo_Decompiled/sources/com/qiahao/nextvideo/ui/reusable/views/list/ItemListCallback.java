package com.qiahao.nextvideo.ui.reusable.views.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListCallback;", "T", "", "onListOnItemSelected", "", "item", "position", "", "(Ljava/lang/Object;I)V", "onListShouldLoadNextPage", "page", "onViewAttachedToWindow", "holder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "onViewRecycled", "onLongListOnItemSelected", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface ItemListCallback<T> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static <T> void onLongListOnItemSelected(@NotNull ItemListCallback<T> itemListCallback, T t, int i) {
        }

        public static <T> void onViewAttachedToWindow(@NotNull ItemListCallback<T> itemListCallback, @NotNull ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
        }

        public static <T> void onViewRecycled(@NotNull ItemListCallback<T> itemListCallback, @NotNull ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
        }
    }

    void onListOnItemSelected(T item, int position);

    void onListShouldLoadNextPage(int page);

    void onLongListOnItemSelected(T item, int position);

    void onViewAttachedToWindow(@NotNull ViewHolder holder);

    void onViewRecycled(@NotNull ViewHolder holder);
}
