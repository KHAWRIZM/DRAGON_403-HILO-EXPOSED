package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import dc.d;
import dc.f;
import ic.g;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUICommonListItemView extends QMUIConstraintLayout {

    /* renamed from: c, reason: collision with root package name */
    private int f١٣١٦٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣١٦٣d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣١٦٤e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f١٣١٦٥f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f١٣١٦٦g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f١٣١٦٧h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f١٣١٦٨i;

    /* renamed from: j, reason: collision with root package name */
    protected CheckBox f١٣١٦٩j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f١٣١٧٠k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f١٣١٧١l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٣١٧٢m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٣١٧٣n;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class a {
    }

    public QMUICommonListItemView(Context context) {
        this(context, null);
    }

    private ImageView getAccessoryImageView() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(getAccessoryLayoutParams());
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        f a10 = f.a();
        a10.j(R.attr.qmui_skin_support_common_list_chevron_color);
        d.g(appCompatImageView, a10);
        f.g(a10);
        return appCompatImageView;
    }

    private ViewGroup.LayoutParams getAccessoryLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    private void o() {
        int i10;
        ImageView imageView = this.f١٣١٧١l;
        int i11 = 8;
        if (this.f١٣١٧٣n == 2) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        ImageView imageView2 = this.f١٣١٧٠k;
        if (this.f١٣١٧٣n == 1) {
            i11 = 0;
        }
        imageView2.setVisibility(i11);
        ConstraintLayout.b bVar = (ConstraintLayout.b) this.f١٣١٦٧h.getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f١٣١٦٨i.getLayoutParams();
        ConstraintLayout.b bVar3 = (ConstraintLayout.b) this.f١٣١٧١l.getLayoutParams();
        ConstraintLayout.b bVar4 = (ConstraintLayout.b) this.f١٣١٧٠k.getLayoutParams();
        if (this.f١٣١٦٣d == 0) {
            this.f١٣١٦٧h.setTextSize(0, i.e(getContext(), R.attr.qmui_common_list_item_title_v_text_size));
            this.f١٣١٦٨i.setTextSize(0, i.e(getContext(), R.attr.qmui_common_list_item_detail_v_text_size));
            bVar.O = 2;
            bVar.f٢٣٢١l = -1;
            bVar.f٢٣١٩k = this.f١٣١٦٨i.getId();
            bVar2.N = -1;
            bVar2.O = 2;
            bVar2.f٢٣٠٧e = this.f١٣١٦٧h.getId();
            bVar2.f٢٣٠٩f = -1;
            bVar2.G = DownloadProgress.UNKNOWN_PROGRESS;
            bVar2.f٢٣١٥i = -1;
            bVar2.f٢٣١٧j = this.f١٣١٦٧h.getId();
            ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) bVar2).topMargin = i.e(getContext(), R.attr.qmui_common_list_item_detail_v_margin_with_title);
            int i12 = this.f١٣١٧٣n;
            if (i12 == 2) {
                if (this.f١٣١٦٤e == 0) {
                    q(this.f١٣١٧١l, bVar3, bVar, bVar2);
                } else {
                    s(this.f١٣١٧١l, bVar3, bVar, bVar2);
                }
            } else if (i12 == 1) {
                if (this.f١٣١٦٤e == 0) {
                    q(this.f١٣١٧٠k, bVar4, bVar, bVar2);
                } else {
                    s(this.f١٣١٧٠k, bVar4, bVar, bVar2);
                }
            } else {
                int e10 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
                bVar.N = -1;
                bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e10;
                bVar.f٢٣٤٦y = 0;
                bVar2.f٢٣٠٩f = this.f١٣١٦٦g.getId();
                ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e10;
                bVar2.f٢٣٤٦y = 0;
            }
        } else {
            this.f١٣١٦٧h.setTextSize(0, i.e(getContext(), R.attr.qmui_common_list_item_title_h_text_size));
            this.f١٣١٦٨i.setTextSize(0, i.e(getContext(), R.attr.qmui_common_list_item_detail_h_text_size));
            bVar.O = -1;
            bVar.f٢٣٢١l = 0;
            bVar.f٢٣١٩k = -1;
            bVar2.O = -1;
            bVar2.f٢٣٠٧e = -1;
            bVar2.f٢٣١٥i = 0;
            bVar2.f٢٣١٧j = -1;
            ((ViewGroup.MarginLayoutParams) bVar2).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = i.e(getContext(), R.attr.qmui_common_list_item_detail_h_margin_with_title);
            int i13 = this.f١٣١٧٣n;
            if (i13 == 2) {
                if (this.f١٣١٦٤e == 0) {
                    p(this.f١٣١٧١l, bVar3, bVar, bVar2);
                } else {
                    r(this.f١٣١٧١l, bVar3, bVar, bVar2);
                }
            } else if (i13 == 1) {
                if (this.f١٣١٦٤e == 0) {
                    p(this.f١٣١٧٠k, bVar4, bVar, bVar2);
                } else {
                    r(this.f١٣١٧٠k, bVar4, bVar, bVar2);
                }
            } else {
                int e11 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
                bVar.N = -1;
                bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e11;
                bVar.f٢٣٤٦y = 0;
                bVar2.f٢٣٠٩f = this.f١٣١٦٧h.getId();
                bVar2.f٢٣١١g = this.f١٣١٦٦g.getId();
                ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e11;
                bVar2.f٢٣٤٦y = 0;
            }
        }
        this.f١٣١٦٧h.setLayoutParams(bVar);
        this.f١٣١٦٨i.setLayoutParams(bVar2);
        this.f١٣١٧١l.setLayoutParams(bVar3);
        this.f١٣١٧٠k.setLayoutParams(bVar4);
    }

    private void p(View view, ConstraintLayout.b bVar, ConstraintLayout.b bVar2, ConstraintLayout.b bVar3) {
        int e10 = i.e(getContext(), R.attr.qmui_common_list_item_holder_margin_with_title);
        int e11 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        bVar2.N = 2;
        bVar2.G = DownloadProgress.UNKNOWN_PROGRESS;
        bVar2.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e10;
        bVar.f٢٣٠٩f = this.f١٣١٦٧h.getId();
        bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e11;
        bVar.f٢٣١٥i = this.f١٣١٦٧h.getId();
        bVar.f٢٣٢١l = this.f١٣١٦٧h.getId();
        bVar.f٢٣٤٦y = 0;
        bVar3.f٢٣٠٩f = view.getId();
        bVar3.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = e11;
        bVar3.f٢٣٤٦y = 0;
    }

    private void q(View view, ConstraintLayout.b bVar, ConstraintLayout.b bVar2, ConstraintLayout.b bVar3) {
        int e10 = i.e(getContext(), R.attr.qmui_common_list_item_holder_margin_with_title);
        int e11 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        bVar2.N = 2;
        bVar2.G = DownloadProgress.UNKNOWN_PROGRESS;
        bVar2.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e10;
        bVar.f٢٣٠٩f = this.f١٣١٦٧h.getId();
        bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e11;
        bVar.f٢٣١٥i = this.f١٣١٦٧h.getId();
        bVar.f٢٣٢١l = this.f١٣١٦٧h.getId();
        bVar.f٢٣٤٦y = 0;
        bVar3.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = e11;
        bVar3.f٢٣٤٦y = 0;
    }

    private void r(View view, ConstraintLayout.b bVar, ConstraintLayout.b bVar2, ConstraintLayout.b bVar3) {
        int e10 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        bVar.f٢٣٠٩f = -1;
        bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e10;
        bVar.f٢٣٤٦y = 0;
        bVar.f٢٣١٥i = 0;
        bVar.f٢٣٢١l = 0;
        bVar2.N = -1;
        bVar2.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e10;
        bVar2.G = DownloadProgress.UNKNOWN_PROGRESS;
        bVar3.f٢٣٠٩f = this.f١٣١٦٧h.getId();
        bVar3.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = e10;
    }

    private void s(View view, ConstraintLayout.b bVar, ConstraintLayout.b bVar2, ConstraintLayout.b bVar3) {
        int e10 = i.e(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        bVar.f٢٣٠٩f = -1;
        bVar.f٢٣١١g = this.f١٣١٦٦g.getId();
        ((ViewGroup.MarginLayoutParams) bVar).rightMargin = e10;
        bVar.f٢٣٤٦y = 0;
        bVar.f٢٣١٥i = 0;
        bVar.f٢٣٢١l = 0;
        bVar2.N = -1;
        bVar2.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = e10;
        bVar3.f٢٣١١g = view.getId();
        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = e10;
    }

    public ViewGroup getAccessoryContainerView() {
        return this.f١٣١٦٦g;
    }

    public int getAccessoryType() {
        return this.f١٣١٦٢c;
    }

    public CharSequence getDetailText() {
        return this.f١٣١٦٨i.getText();
    }

    public TextView getDetailTextView() {
        return this.f١٣١٦٨i;
    }

    public int getOrientation() {
        return this.f١٣١٦٣d;
    }

    public CheckBox getSwitch() {
        return this.f١٣١٦٩j;
    }

    public CharSequence getText() {
        return this.f١٣١٦٧h.getText();
    }

    public TextView getTextView() {
        return this.f١٣١٦٧h;
    }

    protected void n(Context context, AttributeSet attributeSet, int i10) {
        LayoutInflater.from(context).inflate(R.layout.qmui_common_list_item, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICommonListItemView, i10, 0);
        int i11 = obtainStyledAttributes.getInt(R.styleable.QMUICommonListItemView_qmui_orientation, 1);
        int i12 = obtainStyledAttributes.getInt(R.styleable.QMUICommonListItemView_qmui_accessory_type, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.QMUICommonListItemView_qmui_common_list_title_color, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.QMUICommonListItemView_qmui_common_list_detail_color, 0);
        obtainStyledAttributes.recycle();
        this.f١٣١٦٥f = (ImageView) findViewById(R.id.group_list_item_imageView);
        this.f١٣١٦٧h = (TextView) findViewById(R.id.group_list_item_textView);
        this.f١٣١٧٠k = (ImageView) findViewById(R.id.group_list_item_tips_dot);
        this.f١٣١٧١l = (ImageView) findViewById(R.id.group_list_item_tips_new);
        this.f١٣١٦٨i = (TextView) findViewById(R.id.group_list_item_detailTextView);
        this.f١٣١٦٧h.setTextColor(color);
        this.f١٣١٦٨i.setTextColor(color2);
        this.f١٣١٦٦g = (ViewGroup) findViewById(R.id.group_list_item_accessoryView);
        setOrientation(i11);
        setAccessoryType(i12);
    }

    public void setAccessoryType(int i10) {
        this.f١٣١٦٦g.removeAllViews();
        this.f١٣١٦٢c = i10;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        this.f١٣١٦٦g.setVisibility(0);
                    }
                } else {
                    if (this.f١٣١٦٩j == null) {
                        AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(getContext());
                        this.f١٣١٦٩j = appCompatCheckBox;
                        appCompatCheckBox.setBackground(null);
                        this.f١٣١٦٩j.setButtonDrawable(i.f(getContext(), R.attr.qmui_common_list_item_switch));
                        this.f١٣١٦٩j.setLayoutParams(getAccessoryLayoutParams());
                        if (this.f١٣١٧٢m) {
                            this.f١٣١٦٩j.setClickable(false);
                            this.f١٣١٦٩j.setEnabled(false);
                        }
                    }
                    this.f١٣١٦٦g.addView(this.f١٣١٦٩j);
                    this.f١٣١٦٦g.setVisibility(0);
                }
            } else {
                ImageView accessoryImageView = getAccessoryImageView();
                accessoryImageView.setImageDrawable(i.f(getContext(), R.attr.qmui_common_list_item_chevron));
                this.f١٣١٦٦g.addView(accessoryImageView);
                this.f١٣١٦٦g.setVisibility(0);
            }
        } else {
            this.f١٣١٦٦g.setVisibility(8);
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) this.f١٣١٦٧h.getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f١٣١٦٨i.getLayoutParams();
        if (this.f١٣١٦٦g.getVisibility() != 8) {
            bVar2.f٢٣٤٦y = ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
            bVar.f٢٣٤٦y = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            bVar2.f٢٣٤٦y = 0;
            bVar.f٢٣٤٦y = 0;
        }
    }

    public void setDetailText(CharSequence charSequence) {
        this.f١٣١٦٨i.setText(charSequence);
        if (g.f(charSequence)) {
            this.f١٣١٦٨i.setVisibility(8);
        } else {
            this.f١٣١٦٨i.setVisibility(0);
        }
    }

    public void setDisableSwitchSelf(boolean z10) {
        this.f١٣١٧٢m = z10;
        CheckBox checkBox = this.f١٣١٦٩j;
        if (checkBox != null) {
            checkBox.setClickable(!z10);
            this.f١٣١٦٩j.setEnabled(!z10);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f١٣١٦٥f.setVisibility(8);
        } else {
            this.f١٣١٦٥f.setImageDrawable(drawable);
            this.f١٣١٦٥f.setVisibility(0);
        }
    }

    public void setOrientation(int i10) {
        if (this.f١٣١٦٣d == i10) {
            return;
        }
        this.f١٣١٦٣d = i10;
        o();
    }

    public void setSkinConfig(a aVar) {
        f.a();
        throw null;
    }

    public void setText(CharSequence charSequence) {
        this.f١٣١٦٧h.setText(charSequence);
        if (g.f(charSequence)) {
            this.f١٣١٦٧h.setVisibility(8);
        } else {
            this.f١٣١٦٧h.setVisibility(0);
        }
    }

    public void setTipPosition(int i10) {
        if (this.f١٣١٦٤e != i10) {
            this.f١٣١٦٤e = i10;
            o();
        }
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUICommonListItemViewStyle);
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١٦٣d = 1;
        this.f١٣١٦٤e = 0;
        this.f١٣١٧٢m = false;
        this.f١٣١٧٣n = 0;
        n(context, attributeSet, i10);
    }
}
