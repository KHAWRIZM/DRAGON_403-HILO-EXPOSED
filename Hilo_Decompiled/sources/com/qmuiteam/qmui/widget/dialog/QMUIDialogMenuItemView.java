package com.qmuiteam.qmui.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import dc.d;
import dc.f;
import ic.i;
import ic.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIDialogMenuItemView extends QMUIConstraintLayout {

    /* renamed from: c, reason: collision with root package name */
    private int f١٣١٤١c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٣١٤٢d;

    @SuppressLint({"ViewConstructor", "CustomViewStyleable"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class CheckItemView extends QMUIDialogMenuItemView {

        /* renamed from: e, reason: collision with root package name */
        private TextView f١٣١٤٣e;

        /* renamed from: f, reason: collision with root package name */
        private AppCompatImageView f١٣١٤٤f;

        public CharSequence getText() {
            return this.f١٣١٤٣e.getText();
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void p(boolean z10) {
            k.f(this.f١٣١٤٤f, z10);
        }

        public void setText(CharSequence charSequence) {
            this.f١٣١٤٣e.setText(charSequence);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MarkItemView extends QMUIDialogMenuItemView {

        /* renamed from: e, reason: collision with root package name */
        private Context f١٣١٤٥e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f١٣١٤٦f;

        /* renamed from: g, reason: collision with root package name */
        private AppCompatImageView f١٣١٤٧g;

        @SuppressLint({"CustomViewStyleable"})
        public MarkItemView(Context context) {
            super(context);
            this.f١٣١٤٥e = context;
            AppCompatImageView appCompatImageView = new AppCompatImageView(this.f١٣١٤٥e);
            this.f١٣١٤٧g = appCompatImageView;
            appCompatImageView.setId(View.generateViewId());
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuMarkDef, R.attr.qmui_dialog_menu_item_style, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i10 = 0;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                    i10 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_mark_drawable) {
                    this.f١٣١٤٧g.setImageDrawable(i.h(context, obtainStyledAttributes, index));
                }
            }
            obtainStyledAttributes.recycle();
            f a10 = f.a();
            a10.h(R.attr.qmui_skin_support_dialog_mark_drawable);
            d.g(this.f١٣١٤٧g, a10);
            f.g(a10);
            ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
            bVar.f٢٣١٣h = 0;
            bVar.f٢٣١٥i = 0;
            bVar.f٢٣٢١l = 0;
            addView(this.f١٣١٤٧g, bVar);
            this.f١٣١٤٦f = QMUIDialogMenuItemView.o(this.f١٣١٤٥e);
            ConstraintLayout.b bVar2 = new ConstraintLayout.b(0, 0);
            bVar2.f٢٣٠٧e = 0;
            bVar2.f٢٣١٥i = 0;
            bVar2.f٢٣٢١l = 0;
            bVar2.f٢٣١١g = this.f١٣١٤٧g.getId();
            ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = i10;
            addView(this.f١٣١٤٦f, bVar2);
            this.f١٣١٤٧g.setVisibility(4);
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void p(boolean z10) {
            int i10;
            AppCompatImageView appCompatImageView = this.f١٣١٤٧g;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            appCompatImageView.setVisibility(i10);
        }

        public void setText(CharSequence charSequence) {
            this.f١٣١٤٦f.setText(charSequence);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TextItemView extends QMUIDialogMenuItemView {

        /* renamed from: e, reason: collision with root package name */
        protected TextView f١٣١٤٨e;

        public TextItemView(Context context) {
            super(context);
            q();
        }

        private void q() {
            this.f١٣١٤٨e = QMUIDialogMenuItemView.o(getContext());
            ConstraintLayout.b bVar = new ConstraintLayout.b(0, 0);
            bVar.f٢٣٠٧e = 0;
            bVar.f٢٣١٣h = 0;
            bVar.f٢٣٢١l = 0;
            bVar.f٢٣١٥i = 0;
            addView(this.f١٣١٤٨e, bVar);
        }

        public void setText(CharSequence charSequence) {
            this.f١٣١٤٨e.setText(charSequence);
        }

        @Deprecated
        public void setTextColor(int i10) {
            this.f١٣١٤٨e.setTextColor(i10);
        }

        public void setTextColorAttr(int i10) {
            this.f١٣١٤٨e.setTextColor(d.a(this, i10));
            f a10 = f.a();
            a10.i(i10);
            d.g(this.f١٣١٤٨e, a10);
            f.g(a10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
    }

    public QMUIDialogMenuItemView(Context context) {
        super(context, null, R.attr.qmui_dialog_menu_item_style);
        this.f١٣١٤١c = -1;
        this.f١٣١٤٢d = false;
        f a10 = f.a();
        a10.b(R.attr.qmui_skin_support_s_dialog_menu_item_bg);
        d.g(this, a10);
        f.g(a10);
    }

    public static TextView o(Context context) {
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuTextStyleDef, R.attr.qmui_dialog_menu_item_style, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_gravity) {
                qMUISpanTouchFixTextView.setGravity(obtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_textColor) {
                qMUISpanTouchFixTextView.setTextColor(obtainStyledAttributes.getColorStateList(index));
            } else if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_textSize) {
                qMUISpanTouchFixTextView.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(index, 0));
            }
        }
        obtainStyledAttributes.recycle();
        qMUISpanTouchFixTextView.setId(View.generateViewId());
        qMUISpanTouchFixTextView.setSingleLine(true);
        qMUISpanTouchFixTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        qMUISpanTouchFixTextView.setDuplicateParentStateEnabled(false);
        f a10 = f.a();
        a10.i(R.attr.qmui_skin_support_dialog_menu_item_text_color);
        d.g(qMUISpanTouchFixTextView, a10);
        f.g(a10);
        return qMUISpanTouchFixTextView;
    }

    public int getMenuIndex() {
        return this.f١٣١٤١c;
    }

    protected void p(boolean z10) {
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setChecked(boolean z10) {
        this.f١٣١٤٢d = z10;
        p(z10);
    }

    public void setListener(a aVar) {
        if (!isClickable()) {
            setClickable(true);
        }
    }

    public void setMenuIndex(int i10) {
        this.f١٣١٤١c = i10;
    }
}
