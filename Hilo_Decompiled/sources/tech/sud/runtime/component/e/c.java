package tech.sud.runtime.component.e;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;
import tech.sud.runtime.core.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class c extends EditText {
    public boolean a;
    private String b;
    private boolean c;
    private final g d;
    private TextWatcher e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        float a;
        float b;
        float c;
        int d;
        boolean e;
        String f;
        int g;
        float h;
    }

    public c(Context context, g gVar) {
        super(context);
        this.a = false;
        this.b = "";
        this.c = false;
        this.e = new TextWatcher() { // from class: tech.sud.runtime.component.e.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = c.this.getText().toString();
                if (!c.this.c && !obj.equals(c.this.b)) {
                    c.this.b = obj;
                    c.this.d.a(6, obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.d = gVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setImeOptions(268435456);
        setLineSpacing(0.0f, 1.0f);
    }

    public void a(String str, a aVar) {
        int i;
        setTextSize(0, aVar.c);
        if (aVar.g > 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(aVar.g)});
        } else {
            setFilters(new InputFilter[0]);
        }
        setIncludeFontPadding(false);
        setPadding(0, 0, 0, 0);
        setBackground(null);
        if (!this.a) {
            this.a = true;
            addTextChangedListener(this.e);
        }
        setWidth((int) aVar.a);
        a(str);
        this.c = true;
        if (aVar.e) {
            setImeOptions(1);
            setInputType(131073);
            setMaxHeight((int) aVar.b);
        } else {
            setImeOptions(6);
            if (aVar.f.equals("password")) {
                i = 129;
            } else {
                i = aVar.f.equals("tel") ? 12290 : 1;
            }
            setInputType(i);
            setMaxLines(1);
        }
        setHeight((int) aVar.b);
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float f = fontMetrics.bottom - fontMetrics.top;
        float f2 = aVar.h;
        setLineSpacing(f2 < f ? 0.0f : f2 - f, 1.0f);
        setGravity(aVar.d);
        this.c = false;
    }

    public void a(String str) {
        String obj = getText().toString();
        this.b = obj;
        if (obj.equals(str)) {
            return;
        }
        this.b = str;
        this.c = true;
        setText(str);
        this.c = false;
    }
}
