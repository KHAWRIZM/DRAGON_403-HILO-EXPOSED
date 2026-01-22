package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIWebViewContainer extends QMUIFrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private QMUIWebView f١٣٤٥٧c;

    public QMUIWebViewContainer(Context context) {
        super(context);
    }

    protected FrameLayout.LayoutParams getWebViewLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void setCustomOnScrollChangeListener(QMUIWebView.c cVar) {
    }

    public void setNeedDispatchSafeAreaInset(boolean z10) {
        QMUIWebView qMUIWebView = this.f١٣٤٥٧c;
        if (qMUIWebView != null) {
            qMUIWebView.setNeedDispatchSafeAreaInset(z10);
        }
    }

    public QMUIWebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
