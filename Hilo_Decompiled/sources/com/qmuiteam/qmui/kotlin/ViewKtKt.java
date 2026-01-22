package com.qmuiteam.qmui.kotlin;

import android.os.SystemClock;
import android.view.View;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.kotlin.ViewKtKt;
import dc.d;
import dc.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\t\u0010\b\u001a/\u0010\n\u001a\u00020\u0004*\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u00020\u0004*\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\f\u0010\u000b\u001a4\u0010\u0011\u001a\u00020\u0004*\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0004*\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"", "wait", "Lkotlin/Function1;", "Landroid/view/View;", "", ChatMenuDialog.CLICK_BLOCK, "Landroid/view/View$OnClickListener;", "throttleClick", "(JLkotlin/jvm/functions/Function1;)Landroid/view/View$OnClickListener;", "debounceClick", "onClick", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "onDebounceClick", "", "increment", "Ldc/f;", "Lkotlin/ExtensionFunctionType;", "skin", "(Landroid/view/View;ZLkotlin/jvm/functions/Function1;)V", "clearSkin", "(Landroid/view/View;)V", "qmui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ViewKtKt {
    public static final void clearSkin(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        d.h(view, "");
    }

    @NotNull
    public static final View.OnClickListener debounceClick(final long j10, @NotNull final Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new View.OnClickListener() { // from class: ac.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKtKt.m٥٣٤debounceClick$lambda1(Function1.this, j10, view);
            }
        };
    }

    public static /* synthetic */ View.OnClickListener debounceClick$default(long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        return debounceClick(j10, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: debounceClick$lambda-1, reason: not valid java name */
    public static final void m٥٣٤debounceClick$lambda1(Function1 block, long j10, View v10) {
        DebounceAction debounceAction;
        Intrinsics.checkNotNullParameter(block, "$block");
        int i10 = R.id.qmui_click_debounce_action;
        Object tag = v10.getTag(i10);
        if (tag instanceof DebounceAction) {
            debounceAction = (DebounceAction) tag;
        } else {
            debounceAction = null;
        }
        if (debounceAction == null) {
            Intrinsics.checkNotNullExpressionValue(v10, "v");
            debounceAction = new DebounceAction(v10, block);
            v10.setTag(i10, debounceAction);
        } else {
            debounceAction.setBlock(block);
        }
        v10.removeCallbacks(debounceAction);
        v10.postDelayed(debounceAction, j10);
    }

    public static final void onClick(@NotNull View view, long j10, @NotNull Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(throttleClick(j10, block));
    }

    public static /* synthetic */ void onClick$default(View view, long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        onClick(view, j10, function1);
    }

    public static final void onDebounceClick(@NotNull View view, long j10, @NotNull Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(debounceClick(j10, block));
    }

    public static /* synthetic */ void onDebounceClick$default(View view, long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        onDebounceClick(view, j10, function1);
    }

    public static final void skin(@NotNull View view, boolean z10, @NotNull Function1<? super f, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        f builder = f.a();
        if (z10) {
            Object tag = view.getTag(R.id.qmui_skin_value);
            if (tag instanceof String) {
                builder.e((String) tag);
            }
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        block.invoke(builder);
        d.g(view, builder);
        builder.f();
    }

    public static /* synthetic */ void skin$default(View view, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        skin(view, z10, function1);
    }

    @NotNull
    public static final View.OnClickListener throttleClick(final long j10, @NotNull final Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new View.OnClickListener() { // from class: ac.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewKtKt.m٥٣٥throttleClick$lambda0(j10, block, view);
            }
        };
    }

    public static /* synthetic */ View.OnClickListener throttleClick$default(long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        return throttleClick(j10, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: throttleClick$lambda-0, reason: not valid java name */
    public static final void m٥٣٥throttleClick$lambda0(long j10, Function1 block, View v10) {
        Long l10;
        long longValue;
        Intrinsics.checkNotNullParameter(block, "$block");
        long uptimeMillis = SystemClock.uptimeMillis();
        int i10 = R.id.qmui_click_timestamp;
        Object tag = v10.getTag(i10);
        if (tag instanceof Long) {
            l10 = (Long) tag;
        } else {
            l10 = null;
        }
        if (l10 == null) {
            longValue = 0;
        } else {
            longValue = l10.longValue();
        }
        if (uptimeMillis - longValue > j10) {
            v10.setTag(i10, Long.valueOf(uptimeMillis));
            Intrinsics.checkNotNullExpressionValue(v10, "v");
            block.invoke(v10);
        }
    }
}
