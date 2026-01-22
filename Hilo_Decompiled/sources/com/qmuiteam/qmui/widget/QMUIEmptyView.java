package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import dc.d;
import dc.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIEmptyView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private QMUILoadingView f١٢٩٥٩a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f١٢٩٦٠b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f١٢٩٦١c;

    /* renamed from: d, reason: collision with root package name */
    protected Button f١٢٩٦٢d;

    public QMUIEmptyView(Context context) {
        this(context, null);
    }

    private void n() {
        LayoutInflater.from(getContext()).inflate(R.layout.qmui_empty_view, (ViewGroup) this, true);
        this.f١٢٩٥٩a = (QMUILoadingView) findViewById(R.id.empty_view_loading);
        this.f١٢٩٦٠b = (TextView) findViewById(R.id.empty_view_title);
        this.f١٢٩٦١c = (TextView) findViewById(R.id.empty_view_detail);
        this.f١٢٩٦٢d = (Button) findViewById(R.id.empty_view_button);
    }

    public void o(String str, View.OnClickListener onClickListener) {
        int i10;
        this.f١٢٩٦٢d.setText(str);
        Button button = this.f١٢٩٦٢d;
        if (str != null) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        button.setVisibility(i10);
        this.f١٢٩٦٢d.setOnClickListener(onClickListener);
    }

    public void p() {
        setVisibility(0);
    }

    public void q(boolean z10, String str, String str2, String str3, View.OnClickListener onClickListener) {
        setLoadingShowing(z10);
        setTitleText(str);
        setDetailText(str2);
        o(str3, onClickListener);
        p();
    }

    public void setBtnSkinValue(f fVar) {
        d.g(this.f١٢٩٦٢d, fVar);
    }

    public void setDetailColor(int i10) {
        this.f١٢٩٦١c.setTextColor(i10);
    }

    public void setDetailSkinValue(f fVar) {
        d.g(this.f١٢٩٦١c, fVar);
    }

    public void setDetailText(String str) {
        int i10;
        this.f١٢٩٦١c.setText(str);
        TextView textView = this.f١٢٩٦١c;
        if (str != null) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    public void setLoadingShowing(boolean z10) {
        int i10;
        QMUILoadingView qMUILoadingView = this.f١٢٩٥٩a;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        qMUILoadingView.setVisibility(i10);
    }

    public void setLoadingSkinValue(f fVar) {
        d.g(this.f١٢٩٥٩a, fVar);
    }

    public void setTitleColor(int i10) {
        this.f١٢٩٦٠b.setTextColor(i10);
    }

    public void setTitleSkinValue(f fVar) {
        d.g(this.f١٢٩٦٠b, fVar);
    }

    public void setTitleText(String str) {
        int i10;
        this.f١٢٩٦٠b.setText(str);
        TextView textView = this.f١٢٩٦٠b;
        if (str != null) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    public QMUIEmptyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIEmptyView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        n();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIEmptyView);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.QMUIEmptyView_qmui_show_loading, false);
        String string = obtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_title_text);
        String string2 = obtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_detail_text);
        String string3 = obtainStyledAttributes.getString(R.styleable.QMUIEmptyView_qmui_btn_text);
        obtainStyledAttributes.recycle();
        q(z10, string, string2, string3, null);
    }
}
