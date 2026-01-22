package com.qiahao.nextvideo.flowingdrawer;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
abstract class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view) {
        return view.getLayoutDirection();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(View view) {
        return (int) (view.getLeft() + view.getTranslationX());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(View view) {
        return (int) (view.getRight() + view.getTranslationX());
    }
}
