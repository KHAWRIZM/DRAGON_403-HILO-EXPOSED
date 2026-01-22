package com.qmuiteam.qmui.widget.tab;

import android.view.ViewGroup;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.widget.tab.QMUITabView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b extends com.qmuiteam.qmui.widget.a implements QMUITabView.b {

    /* renamed from: e, reason: collision with root package name */
    private QMUIBasicTabSegment f١٣٣٩٤e;

    public b(QMUIBasicTabSegment qMUIBasicTabSegment, ViewGroup viewGroup) {
        super(viewGroup);
        this.f١٣٣٩٤e = qMUIBasicTabSegment;
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.b
    public void a(QMUITabView qMUITabView) {
        this.f١٣٣٩٤e.A(qMUITabView, l().indexOf(qMUITabView));
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.b
    public void b(QMUITabView qMUITabView) {
    }

    @Override // com.qmuiteam.qmui.widget.tab.QMUITabView.b
    public void c(QMUITabView qMUITabView) {
        this.f١٣٣٩٤e.B(l().indexOf(qMUITabView));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void e(a aVar, QMUITabView qMUITabView, int i10) {
        q(aVar, qMUITabView, i10);
        qMUITabView.setCallback(this);
        if (qMUITabView.getSelectFraction() != DownloadProgress.UNKNOWN_PROGRESS || qMUITabView.isSelected()) {
            qMUITabView.setSelected(false);
            qMUITabView.setSelectFraction(DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public QMUITabView g(ViewGroup viewGroup) {
        return new QMUITabView(viewGroup.getContext());
    }

    protected void q(a aVar, QMUITabView qMUITabView, int i10) {
        qMUITabView.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void m(QMUITabView qMUITabView) {
        qMUITabView.setSelected(false);
        qMUITabView.setSelectFraction(DownloadProgress.UNKNOWN_PROGRESS);
        qMUITabView.setCallback(null);
    }
}
