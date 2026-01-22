package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import com.qmuiteam.qmui.nestedScroll.b;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedTopWebView extends QMUIWebView implements c {

    /* renamed from: h, reason: collision with root package name */
    private b.a f١٢٨١٩h;

    public QMUIContinuousNestedTopWebView(Context context) {
        super(context);
        m();
    }

    private void m() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int a(int i10) {
        int i11;
        int scrollY = getScrollY();
        int scrollOffsetRange = getScrollOffsetRange();
        int max = Math.max(0, Math.min(scrollY, scrollOffsetRange));
        if (i10 < 0) {
            i11 = Math.max(i10, -max);
        } else if (i10 > 0) {
            i11 = Math.min(i10, scrollOffsetRange - max);
        } else {
            i11 = 0;
        }
        scrollBy(0, i11);
        return i10 - i11;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.b
    public void c(b.a aVar) {
        this.f١٢٨١٩h = aVar;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getCurrentScroll() {
        return Math.max(0, Math.min(getScrollY(), getScrollOffsetRange()));
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getScrollOffsetRange() {
        return computeVerticalScrollRange() - getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.webview.QMUIWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        b.a aVar = this.f١٢٨١٩h;
        if (aVar != null) {
            aVar.a(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m();
    }

    public QMUIContinuousNestedTopWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m();
    }
}
