package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.g0;
import com.google.android.material.internal.k0;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    private final Chip f١٠٢٧٣a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f١٠٢٧٤b;

    /* renamed from: c, reason: collision with root package name */
    private final EditText f١٠٢٧٥c;

    /* renamed from: d, reason: collision with root package name */
    private TextWatcher f١٠٢٧٦d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f١٠٢٧٧e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class b extends g0 {
        private b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                String c10 = ChipTextInputComboView.this.c(editable);
                Chip chip = ChipTextInputComboView.this.f١٠٢٧٣a;
                if (TextUtils.isEmpty(c10)) {
                    c10 = ChipTextInputComboView.this.c("00");
                }
                chip.setText(c10);
                return;
            }
            ChipTextInputComboView.this.f١٠٢٧٣a.setText(ChipTextInputComboView.this.c("00"));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void d() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f١٠٢٧٥c.setImeHintLocales(locales);
        }
    }

    public TextInputLayout getTextInput() {
        return this.f١٠٢٧٤b;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f١٠٢٧٣a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        int i10;
        int i11;
        this.f١٠٢٧٣a.setChecked(z10);
        EditText editText = this.f١٠٢٧٥c;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        editText.setVisibility(i10);
        Chip chip = this.f١٠٢٧٣a;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        chip.setVisibility(i11);
        if (isChecked()) {
            k0.q(this.f١٠٢٧٥c, false);
        }
    }

    public void setChipDelegate(androidx.core.view.a aVar) {
        d1.q0(this.f١٠٢٧٣a, aVar);
    }

    public void setCursorVisible(boolean z10) {
        this.f١٠٢٧٥c.setCursorVisible(z10);
    }

    public void setHelperText(CharSequence charSequence) {
        this.f١٠٢٧٧e.setText(charSequence);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f١٠٢٧٣a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f١٠٢٧٣a.setTag(i10, obj);
    }

    public void setText(CharSequence charSequence) {
        String c10 = c(charSequence);
        this.f١٠٢٧٣a.setText(c10);
        if (!TextUtils.isEmpty(c10)) {
            this.f١٠٢٧٥c.removeTextChangedListener(this.f١٠٢٧٦d);
            this.f١٠٢٧٥c.setText(c10);
            this.f١٠٢٧٥c.addTextChangedListener(this.f١٠٢٧٦d);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f١٠٢٧٣a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f١٠٢٧٣a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f١٠٢٧٤b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f١٠٢٧٥c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f١٠٢٧٦d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f١٠٢٧٧e = (TextView) findViewById(R.id.material_label);
        editText.setId(View.generateViewId());
        this.f١٠٢٧٧e.setLabelFor(editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
