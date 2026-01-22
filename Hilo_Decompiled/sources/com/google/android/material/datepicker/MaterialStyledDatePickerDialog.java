package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    /* renamed from: c, reason: collision with root package name */
    private static final int f٨٨٢٨c = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f٨٨٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f٨٨٣٠b;

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f٨٨٢٩a);
        getWindow().getDecorView().setOnTouchListener(new w7.a(this, this.f٨٨٣٠b));
    }
}
