package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialSplitButton extends MaterialButtonGroup {

    /* renamed from: l, reason: collision with root package name */
    private static final int f٨٥٥٠l = R.style.Widget_Material3_MaterialSplitButton;

    public MaterialSplitButton(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(MaterialButton materialButton, boolean z10) {
        int i10;
        Resources resources = getResources();
        if (z10) {
            i10 = R.string.mtrl_button_expanded_content_description;
        } else {
            i10 = R.string.mtrl_button_collapsed_content_description;
        }
        materialButton.setStateDescription(resources.getString(i10));
    }

    @Override // com.google.android.material.button.MaterialButtonGroup, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        int i11;
        if (view instanceof MaterialButton) {
            if (getChildCount() <= 2) {
                MaterialButton materialButton = (MaterialButton) view;
                super.addView(view, i10, layoutParams);
                if (indexOfChild(view) == 1) {
                    materialButton.setCheckable(true);
                    materialButton.setA11yClassName(Button.class.getName());
                    if (Build.VERSION.SDK_INT >= 30) {
                        Resources resources = getResources();
                        if (materialButton.isChecked()) {
                            i11 = R.string.mtrl_button_expanded_content_description;
                        } else {
                            i11 = R.string.mtrl_button_collapsed_content_description;
                        }
                        materialButton.setStateDescription(resources.getString(i11));
                        materialButton.addOnCheckedChangeListener(new MaterialButton.b() { // from class: com.google.android.material.button.f
                            @Override // com.google.android.material.button.MaterialButton.b
                            public final void a(MaterialButton materialButton2, boolean z10) {
                                MaterialSplitButton.this.r(materialButton2, z10);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("MaterialSplitButton can only hold two MaterialButtons.");
        }
        throw new IllegalArgumentException("MaterialSplitButton can only hold MaterialButtons.");
    }

    public MaterialSplitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSplitButtonStyle);
    }

    public MaterialSplitButton(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, f٨٥٥٠l), attributeSet, i10);
    }
}
