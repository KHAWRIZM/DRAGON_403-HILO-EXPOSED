package com.oudi.utils.ktx;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.EditText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"setOnInputChangedListener", "", "Landroid/widget/EditText;", "onChanged", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "switchPasswordVisibility", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "setMaxLengthFilter", "maxLength", "setInputEnabled", "isEnabled", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class EditTextKtxKt {
    public static final void setInputEnabled(EditText editText, boolean z10) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        if (z10) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.setClickable(true);
        } else {
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false);
            editText.setClickable(false);
            editText.setKeyListener(null);
        }
    }

    public static final void setMaxLengthFilter(EditText editText, int i10) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i10)});
    }

    public static final void setOnInputChangedListener(final EditText editText, final Function1<? super Integer, Boolean> onChanged) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.oudi.utils.ktx.EditTextKtxKt$setOnInputChangedListener$1
            private boolean flag;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable p02) {
                int i10;
                String str;
                if (this.flag) {
                    return;
                }
                Function1<Integer, Boolean> function1 = onChanged;
                if (p02 != null) {
                    i10 = p02.length();
                } else {
                    i10 = 0;
                }
                if (!function1.invoke(Integer.valueOf(i10)).booleanValue()) {
                    this.flag = true;
                    EditText editText2 = editText;
                    Object tag = editText2.getTag(1982329101);
                    if (tag instanceof String) {
                        str = (String) tag;
                    } else {
                        str = null;
                    }
                    editText2.setText(str);
                    EditText editText3 = editText;
                    editText3.setSelection(editText3.length());
                    this.flag = false;
                    return;
                }
                this.flag = false;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p02, int p12, int p22, int p32) {
                String str;
                EditText editText2 = editText;
                if (p02 != null) {
                    str = p02.toString();
                } else {
                    str = null;
                }
                editText2.setTag(1982329101, str);
            }

            public final boolean getFlag() {
                return this.flag;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p02, int p12, int p22, int p32) {
            }

            public final void setFlag(boolean z10) {
                this.flag = z10;
            }
        });
    }

    public static final void switchPasswordVisibility(EditText editText, boolean z10) {
        TransformationMethod passwordTransformationMethod;
        Intrinsics.checkNotNullParameter(editText, "<this>");
        if (!z10) {
            passwordTransformationMethod = HideReturnsTransformationMethod.getInstance();
        } else {
            passwordTransformationMethod = PasswordTransformationMethod.getInstance();
        }
        editText.setTransformationMethod(passwordTransformationMethod);
    }
}
