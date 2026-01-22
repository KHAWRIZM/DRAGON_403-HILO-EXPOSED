package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import ic.i;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBottomSheetGridLineLayout extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    private static b f١٣١٢٩h = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f١٣١٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣١٣١b;

    /* renamed from: c, reason: collision with root package name */
    private List f١٣١٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private List f١٣١٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣١٣٤e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣١٣٥f;

    /* renamed from: g, reason: collision with root package name */
    private final b f١٣١٣٦g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements b {
        a() {
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetGridLineLayout.b
        public int a(Context context, int i10, int i11, int i12, int i13, int i14) {
            int i15;
            int i16 = i10 - i13;
            int i17 = i16 - i14;
            if (i12 >= 3 && (i15 = i17 - (i12 * i11)) > 0 && i15 < i11) {
                i11 = i17 / (i17 / i11);
            }
            if (i12 * i11 > i17) {
                return (int) (i16 / ((i16 / i11) + 0.5f));
            }
            return i11;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        int a(Context context, int i10, int i11, int i12, int i13, int i14);
    }

    private int a(int i10, int i11, int i12, int i13) {
        if (this.f١٣١٣١b == -1) {
            this.f١٣١٣١b = i.e(getContext(), R.attr.qmui_bottom_sheet_grid_item_mini_width);
        }
        return this.f١٣١٣٦g.a(getContext(), i10, this.f١٣١٣١b, i11, i12, i13);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i10, int i11) {
        super.measureChild(view, i10, i11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.f١٣١٣٠a;
        int i13 = this.f١٣١٣٤e;
        this.f١٣١٣٥f = a(size, i12, i13, i13);
        List list = this.f١٣١٣٢c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object obj = ((Pair) it.next()).second;
                int i14 = ((LinearLayout.LayoutParams) obj).width;
                int i15 = this.f١٣١٣٥f;
                if (i14 != i15) {
                    ((LinearLayout.LayoutParams) obj).width = i15;
                }
            }
        }
        List list2 = this.f١٣١٣٣d;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                Object obj2 = ((Pair) it2.next()).second;
                int i16 = ((LinearLayout.LayoutParams) obj2).width;
                int i17 = this.f١٣١٣٥f;
                if (i16 != i17) {
                    ((LinearLayout.LayoutParams) obj2).width = i17;
                }
            }
        }
        super.onMeasure(i10, i11);
    }
}
