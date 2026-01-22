package com.oudi.utils.ktx;

import android.view.View;
import android.widget.Checkable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX WARN: Incorrect field signature: TT; */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewKtxKt$singleClick$1 implements View.OnClickListener {
    final /* synthetic */ Function1<T, Unit> $block;
    final /* synthetic */ View $this_singleClick;
    final /* synthetic */ long $time;

    /* JADX WARN: Incorrect types in method signature: (TT;JLkotlin/jvm/functions/Function1<-TT;Lkotlin/Unit;>;)V */
    public ViewKtxKt$singleClick$1(View view, long j10, Function1 function1) {
        this.$this_singleClick = view;
        this.$time = j10;
        this.$block = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.$this_singleClick) > this.$time || (this.$this_singleClick instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.$this_singleClick, currentTimeMillis);
            this.$block.invoke(this.$this_singleClick);
        }
    }
}
