package com.qmuiteam.qmui.widget.pullRefreshLayout;

import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a implements QMUIPullRefreshLayout.f {
    @Override // com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.f
    public int a(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i13 >= i15) {
            return i11;
        }
        if (i13 <= i14) {
            return i10;
        }
        return (int) (i10 + ((((i13 - i14) * 1.0f) / (i15 - i14)) * (i11 - i10)));
    }
}
