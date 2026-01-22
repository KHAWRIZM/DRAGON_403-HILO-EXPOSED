package com.qmuiteam.qmui.widget.popup;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.a0;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import ic.k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class QMUIFullScreenPopup extends com.qmuiteam.qmui.widget.popup.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class RootView extends QMUIConstraintLayout {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            Iterator it = QMUIFullScreenPopup.b(null).iterator();
            while (it.hasNext()) {
                a0.a(it.next());
                k.d(b.a(null)).e();
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            motionEvent.getActionMasked();
            QMUIFullScreenPopup.a(null);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b {
        static /* bridge */ /* synthetic */ View a(b bVar) {
            throw null;
        }
    }

    static /* bridge */ /* synthetic */ a a(QMUIFullScreenPopup qMUIFullScreenPopup) {
        throw null;
    }

    static /* bridge */ /* synthetic */ ArrayList b(QMUIFullScreenPopup qMUIFullScreenPopup) {
        throw null;
    }
}
