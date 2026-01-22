package t2;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {
    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        boolean z10;
        boolean z11;
        if (charSequence == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (charSequence2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 != z11) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return true;
            }
        }
        return false;
    }

    public static void b(TextView textView, int i10) {
        InputFilter[] filters = textView.getFilters();
        if (filters == null) {
            filters = new InputFilter[]{new InputFilter.LengthFilter(i10)};
        } else {
            int i11 = 0;
            while (true) {
                if (i11 < filters.length) {
                    InputFilter inputFilter = filters[i11];
                    if (inputFilter instanceof InputFilter.LengthFilter) {
                        if (((InputFilter.LengthFilter) inputFilter).getMax() != i10) {
                            filters[i11] = new InputFilter.LengthFilter(i10);
                        }
                    } else {
                        i11++;
                    }
                } else {
                    int length = filters.length;
                    InputFilter[] inputFilterArr = new InputFilter[length + 1];
                    System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                    inputFilterArr[length] = new InputFilter.LengthFilter(i10);
                    filters = inputFilterArr;
                    break;
                }
            }
        }
        textView.setFilters(filters);
    }

    public static void c(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence != null || text.length() != 0) {
                if (charSequence instanceof Spanned) {
                    if (charSequence.equals(text)) {
                        return;
                    }
                } else if (!a(charSequence, text)) {
                    return;
                }
                textView.setText(charSequence);
            }
        }
    }
}
