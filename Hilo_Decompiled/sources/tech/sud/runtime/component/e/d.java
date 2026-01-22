package tech.sud.runtime.component.e;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import org.json.JSONObject;
import tech.sud.gip.core.view.round.RoundedDrawable;
import tech.sud.runtime.component.e.c;
import tech.sud.runtime.component.h.f;
import tech.sud.runtime.core.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d extends ScrollView {
    private final c a;
    private int b;
    private double c;
    private double d;
    private final float e;
    private final g f;
    private final c.a g;
    private boolean h;

    public d(Context context, g gVar) {
        super(context);
        this.b = 0;
        this.g = new c.a();
        this.h = false;
        this.f = gVar;
        this.e = context.getApplicationContext().getResources().getDisplayMetrics().density;
        c cVar = new c(context, gVar);
        this.a = cVar;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setVerticalScrollBarEnabled(false);
        addView(cVar);
        setVisibility(4);
    }

    public void a() {
    }

    public void b() {
        if (!this.h) {
            return;
        }
        this.h = false;
        ((InputMethodManager) this.a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
        setVisibility(4);
        this.f.b(7, this.b);
    }

    public boolean c() {
        return this.h;
    }

    private void a(double d, double d2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins((getPaddingLeft() * (-1)) + ((int) (d + 0.5d)), (getPaddingTop() * (-1)) + ((int) d2), -1, -1);
        setLayoutParams(layoutParams);
    }

    public void a(String str, int i, float f, float f2, boolean z) {
        int i2;
        int i3;
        this.b = i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.g.f = jSONObject.getString("inputType");
            this.g.g = jSONObject.getInt("maxLength");
            String string = jSONObject.getString("text");
            this.c = jSONObject.getDouble("x") * this.e;
            this.d = jSONObject.getDouble("y") * this.e;
            this.g.a = ((float) jSONObject.getDouble("w")) * this.e;
            this.g.b = ((float) jSONObject.getDouble("h")) * this.e;
            this.g.c = ((float) jSONObject.getDouble("font_size")) * this.e;
            int i4 = jSONObject.getInt("font_color");
            if ((i4 & RoundedDrawable.DEFAULT_BORDER_COLOR) == 0) {
                i4 |= RoundedDrawable.DEFAULT_BORDER_COLOR;
            }
            String string2 = jSONObject.getString("textAlign");
            String string3 = jSONObject.getString("verticalAlign");
            if (string2.equals("center")) {
                i2 = 1;
            } else {
                i2 = string2.equals("right") ? 8388613 : 8388611;
            }
            if (string3.equals("middle")) {
                i3 = i2 | 16;
            } else {
                i3 = string3.equals("bottom") ? i2 | 80 : i2 | 48;
            }
            c.a aVar = this.g;
            aVar.d = i3;
            aVar.e = z;
            aVar.h = (float) (jSONObject.getDouble("lineHeight") * this.e);
            f.e("lineHeight", this.g.h + "");
            a(this.c, this.d);
            this.a.a(string, this.g);
            this.a.setTextColor(i4);
            setVisibility(0);
            this.a.requestFocus();
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = true;
    }

    public void a(String str, int i) {
        if ((i & RoundedDrawable.DEFAULT_BORDER_COLOR) == 0) {
            i |= RoundedDrawable.DEFAULT_BORDER_COLOR;
        }
        this.a.setTextColor(i);
        this.a.a(str);
        this.a.setSelection(str.length());
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            double optDouble = jSONObject.optDouble("y") * this.e;
            jSONObject.optDouble("height");
            a(this.c, optDouble);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
