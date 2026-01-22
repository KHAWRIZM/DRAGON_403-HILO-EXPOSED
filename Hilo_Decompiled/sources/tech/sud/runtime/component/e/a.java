package tech.sud.runtime.component.e;

import android.R;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import tech.sud.gip.core.view.round.RoundedDrawable;
import tech.sud.runtime.component.h.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a extends LinearLayout {
    private LinearLayout a;
    private EditText b;
    private Button c;
    private View d;
    private final Window e;
    private final View f;
    private boolean g;
    private final InterfaceC٠٠٥٨a h;
    private boolean i;
    private String j;
    private Integer k;
    private TextWatcher l;
    private View.OnClickListener m;
    private TextView.OnEditorActionListener n;
    private View.OnFocusChangeListener o;
    private e.a p;

    /* renamed from: tech.sud.runtime.component.e.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface InterfaceC٠٠٥٨a {
        void a(int i);

        void a(String str);

        void b(String str);

        void c(String str);
    }

    public a(Context context, InterfaceC٠٠٥٨a r3, Integer num) {
        super(context);
        this.i = false;
        this.j = "";
        this.l = new TextWatcher() { // from class: tech.sud.runtime.component.e.a.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (!obj.equals(a.this.j)) {
                    a.this.j = obj;
                    a.this.h.a(obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.m = new View.OnClickListener() { // from class: tech.sud.runtime.component.e.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.h.b(a.this.getInputString());
                if (!a.this.g) {
                    e.b(a.this.getContext(), a.this.b);
                }
            }
        };
        this.n = new TextView.OnEditorActionListener() { // from class: tech.sud.runtime.component.e.a.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                a.this.h.b(a.this.getInputString());
                boolean unused = a.this.g;
                return false;
            }
        };
        this.o = new View.OnFocusChangeListener() { // from class: tech.sud.runtime.component.e.a.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    e.b(a.this.getContext(), a.this.b);
                }
            }
        };
        this.p = new e.a() { // from class: tech.sud.runtime.component.e.a.7
            @Override // tech.sud.runtime.component.h.e.a
            public void a(int i) {
                if (i > 0) {
                    Integer num2 = a.this.k;
                    if (num2 != null) {
                        i += num2.intValue();
                    }
                    a.this.a(i);
                } else if (i == 0) {
                    a.this.c();
                }
                a.this.setPadding(0, 0, 0, i);
            }
        };
        setOrientation(1);
        this.k = num;
        this.h = r3;
        Window window = tech.sud.runtime.component.h.c.a(context).getWindow();
        this.e = window;
        this.f = window.getDecorView();
        e.a(getContext(), window, this.p);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInputString() {
        Editable text = this.b.getText();
        if (text == null) {
            return "";
        }
        return text.toString();
    }

    private void d() {
        this.d = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.d.setLayoutParams(layoutParams);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: tech.sud.runtime.component.e.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.c();
                e.b(a.this.getContext(), a.this.b);
            }
        });
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.a = linearLayout;
        linearLayout.setOrientation(0);
        this.a.setGravity(17);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b = new EditText(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.b.setLayoutParams(layoutParams2);
        this.b.setImeActionLabel("完成", 6);
        this.b.setImeActionLabel("下一个", 5);
        this.b.setImeActionLabel("搜索", 3);
        this.b.setImeActionLabel("前往", 2);
        this.b.setImeActionLabel("发送", 4);
        this.b.addTextChangedListener(this.l);
        this.b.setOnFocusChangeListener(this.o);
        int a = tech.sud.runtime.component.h.d.a(getContext(), 16.0f);
        int a2 = tech.sud.runtime.component.h.d.a(getContext(), 13.0f);
        this.b.setPadding(a, a2, a, a2);
        this.b.setBackgroundColor(-1);
        this.b.setTextSize(16.0f);
        this.b.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        Button button = new Button(getContext());
        this.c = button;
        button.setText(R.string.ok);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.c.setOnClickListener(this.m);
    }

    public void b() {
        EditText editText = this.b;
        if (editText == null || editText.getParent() == null) {
            return;
        }
        this.a.removeAllViews();
        removeAllViews();
        this.h.c(getInputString());
    }

    public void c() {
        if (this.i) {
            this.i = false;
            e.b(getContext(), this.b);
            b();
        }
    }

    public void a() {
        e.a(this.e);
    }

    public void a(String str, int i, boolean z, boolean z2, int i2) {
        this.b.setText(str);
        if (i > 0) {
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        } else {
            this.b.setFilters(new InputFilter[0]);
        }
        if (z) {
            this.b.setMaxLines(8);
            this.b.setInputType(131073);
            this.b.setImeOptions(1);
        } else {
            int i3 = 6;
            if (i2 != 0) {
                if (i2 == 1) {
                    i3 = 5;
                } else if (i2 == 2) {
                    i3 = 3;
                } else if (i2 == 3) {
                    i3 = 2;
                } else if (i2 == 4) {
                    i3 = 4;
                }
            }
            this.b.setSingleLine(true);
            this.b.setInputType(1);
            this.b.setImeOptions(i3 | 33554432);
        }
        if (this.b.getParent() == null) {
            addView(this.d);
            addView(this.a);
            this.a.addView(this.b);
            if (z) {
                this.a.addView(this.c);
                this.b.setOnEditorActionListener(null);
            } else {
                this.b.setOnEditorActionListener(this.n);
            }
        }
        this.g = z2;
        post(new Runnable() { // from class: tech.sud.runtime.component.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.b.requestFocus();
                a.this.b.setSelection(a.this.b.getText().length());
                a.this.a(0);
                e.a(a.this.getContext(), a.this.b);
            }
        });
    }

    public void a(String str) {
        this.b.setText(str);
        this.b.setSelection(str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.i || this.b.getParent() == null) {
            return;
        }
        this.i = true;
        this.h.a(i);
    }
}
