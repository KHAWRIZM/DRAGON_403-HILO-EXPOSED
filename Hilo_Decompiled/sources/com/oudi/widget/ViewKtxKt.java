package com.oudi.widget;

import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.widget.u0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0019\u0010\b\u001a\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\n*\u0002H\t¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"disableTooltipText", "", "Lcom/google/android/material/tabs/TabLayout;", "scrollToBottom", "Landroidx/recyclerview/widget/RecyclerView;", "delayMillis", "", "smoothScrollToBottom", "fallbackLineUnable", "T", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "lib_widget_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewKtxKt {
    public static final void disableTooltipText(@NotNull TabLayout tabLayout) {
        TabLayout.TabView tabView;
        Intrinsics.checkNotNullParameter(tabLayout, "<this>");
        try {
            int tabCount = tabLayout.getTabCount();
            for (int i10 = 0; i10 < tabCount; i10++) {
                TabLayout.f tabAt = tabLayout.getTabAt(i10);
                if (tabAt != null && (tabView = tabAt.f١٠٠٥٣i) != null) {
                    u0.a(tabView, null);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static final <T extends TextView> void fallbackLineUnable(@NotNull T t10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            t10.setFallbackLineSpacing(false);
        }
    }

    public static final void scrollToBottom(@NotNull final RecyclerView recyclerView, long j10) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.postDelayed(new Runnable() { // from class: com.oudi.widget.a0
            @Override // java.lang.Runnable
            public final void run() {
                ViewKtxKt.scrollToBottom$lambda$1(RecyclerView.this);
            }
        }, j10);
    }

    public static /* synthetic */ void scrollToBottom$default(RecyclerView recyclerView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        scrollToBottom(recyclerView, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToBottom$lambda$1(RecyclerView recyclerView) {
        int i10;
        LinearLayoutManager linearLayoutManager;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        if (i10 <= 0) {
            return;
        }
        int i11 = i10 - 1;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i11, 0);
        }
    }

    public static final void smoothScrollToBottom(@NotNull final RecyclerView recyclerView, long j10) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.postDelayed(new Runnable() { // from class: com.oudi.widget.z
            @Override // java.lang.Runnable
            public final void run() {
                ViewKtxKt.smoothScrollToBottom$lambda$2(RecyclerView.this);
            }
        }, j10);
    }

    public static /* synthetic */ void smoothScrollToBottom$default(RecyclerView recyclerView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        smoothScrollToBottom(recyclerView, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void smoothScrollToBottom$lambda$2(RecyclerView recyclerView) {
        int i10;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        if (i10 <= 0) {
            return;
        }
        recyclerView.smoothScrollToPosition(i10 - 1);
    }
}
