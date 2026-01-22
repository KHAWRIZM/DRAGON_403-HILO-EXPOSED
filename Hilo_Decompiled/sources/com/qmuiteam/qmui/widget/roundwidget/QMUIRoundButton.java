package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaButton;
import fc.a;
import ic.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIRoundButton extends QMUIAlphaButton implements a {

    /* renamed from: c, reason: collision with root package name */
    private static SimpleArrayMap f١٣٢٨١c;

    /* renamed from: b, reason: collision with root package name */
    private jc.a f١٣٢٨٢b;

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(3);
        f١٣٢٨١c = simpleArrayMap;
        simpleArrayMap.put("background", Integer.valueOf(R.attr.qmui_skin_support_round_btn_bg_color));
        f١٣٢٨١c.put("border", Integer.valueOf(R.attr.qmui_skin_support_round_btn_border_color));
        f١٣٢٨١c.put("textColor", Integer.valueOf(R.attr.qmui_skin_support_round_btn_text_color));
    }

    public QMUIRoundButton(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        jc.a a10 = jc.a.a(context, attributeSet, i10);
        this.f١٣٢٨٢b = a10;
        k.g(this, a10);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenPress(false);
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٣٢٨١c;
    }

    public int getStrokeWidth() {
        return this.f١٣٢٨٢b.b();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f١٣٢٨٢b.c(ColorStateList.valueOf(i10));
    }

    public void setBgData(ColorStateList colorStateList) {
        this.f١٣٢٨٢b.c(colorStateList);
    }

    public void setStrokeColors(ColorStateList colorStateList) {
        this.f١٣٢٨٢b.e(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QMUIRoundButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int i10 = R.attr.QMUIButtonStyle;
        a(context, attributeSet, i10);
    }

    public QMUIRoundButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10);
    }
}
