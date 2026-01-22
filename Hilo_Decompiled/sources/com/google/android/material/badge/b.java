package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static void a(a aVar, View view) {
        b(aVar, view, null);
    }

    public static void b(a aVar, View view, FrameLayout frameLayout) {
        f(aVar, view, frameLayout);
        if (aVar.k() != null) {
            aVar.k().setForeground(aVar);
        } else {
            view.getOverlay().add(aVar);
        }
    }

    public static SparseArray c(Context context, ParcelableSparseArray parcelableSparseArray) {
        a aVar;
        SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
        for (int i10 = 0; i10 < parcelableSparseArray.size(); i10++) {
            int keyAt = parcelableSparseArray.keyAt(i10);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i10);
            if (state != null) {
                aVar = a.f(context, state);
            } else {
                aVar = null;
            }
            sparseArray.put(keyAt, aVar);
        }
        return sparseArray;
    }

    public static ParcelableSparseArray d(SparseArray sparseArray) {
        BadgeState.State state;
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            a aVar = (a) sparseArray.valueAt(i10);
            if (aVar != null) {
                state = aVar.u();
            } else {
                state = null;
            }
            parcelableSparseArray.put(keyAt, state);
        }
        return parcelableSparseArray;
    }

    public static void e(a aVar, View view) {
        if (aVar == null) {
            return;
        }
        if (aVar.k() != null) {
            aVar.k().setForeground(null);
        } else {
            view.getOverlay().remove(aVar);
        }
    }

    public static void f(a aVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.Q(view, frameLayout);
    }

    public static void g(Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
