package com.qmuiteam.qmui.link;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference f١٢٧٤٦a;

    public a a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f10 = scrollX;
        try {
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f10);
            if (f10 < layout.getLineLeft(lineForVertical) || f10 > layout.getLineRight(lineForVertical)) {
                offsetForHorizontal = -1;
            }
            a[] aVarArr = (a[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, a.class);
            if (aVarArr.length <= 0) {
                return null;
            }
            return aVarArr[0];
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        a aVar;
        a aVar2;
        a aVar3;
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (motionEvent.getAction() == 0) {
            a a10 = a(textView, spannable, motionEvent);
            if (a10 != null) {
                a10.a(true);
                Selection.setSelection(spannable, spannable.getSpanStart(a10), spannable.getSpanEnd(a10));
                this.f١٢٧٤٦a = new WeakReference(a10);
            }
            if (textView instanceof kc.a) {
                kc.a aVar4 = (kc.a) textView;
                if (a10 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                aVar4.setTouchSpanHit(z11);
            }
            if (a10 != null) {
                return true;
            }
            return false;
        }
        a aVar5 = null;
        if (motionEvent.getAction() == 2) {
            a a11 = a(textView, spannable, motionEvent);
            WeakReference weakReference = this.f١٢٧٤٦a;
            if (weakReference != null) {
                aVar3 = (a) weakReference.get();
            } else {
                aVar3 = null;
            }
            if (aVar3 != null && aVar3 != a11) {
                aVar3.a(false);
                this.f١٢٧٤٦a = null;
                Selection.removeSelection(spannable);
            } else {
                aVar5 = aVar3;
            }
            if (textView instanceof kc.a) {
                kc.a aVar6 = (kc.a) textView;
                if (aVar5 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                aVar6.setTouchSpanHit(z10);
            }
            if (aVar5 != null) {
                return true;
            }
            return false;
        }
        if (motionEvent.getAction() == 1) {
            WeakReference weakReference2 = this.f١٢٧٤٦a;
            if (weakReference2 != null) {
                aVar2 = (a) weakReference2.get();
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                aVar2.a(false);
                if (motionEvent.getAction() == 1) {
                    aVar2.onClick(textView);
                }
            } else {
                z12 = false;
            }
            this.f١٢٧٤٦a = null;
            Selection.removeSelection(spannable);
            if (textView instanceof kc.a) {
                ((kc.a) textView).setTouchSpanHit(z12);
            }
            return z12;
        }
        WeakReference weakReference3 = this.f١٢٧٤٦a;
        if (weakReference3 != null) {
            aVar = (a) weakReference3.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(false);
        }
        if (textView instanceof kc.a) {
            ((kc.a) textView).setTouchSpanHit(false);
        }
        this.f١٢٧٤٦a = null;
        Selection.removeSelection(spannable);
        return false;
    }
}
