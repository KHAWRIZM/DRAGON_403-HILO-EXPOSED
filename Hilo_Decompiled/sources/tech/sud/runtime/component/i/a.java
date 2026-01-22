package tech.sud.runtime.component.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class a extends FrameLayout {
    Button a;
    WeakReference<c> b;
    private View.OnClickListener c;

    public a(Context context, c cVar) {
        super(context);
        this.c = new View.OnClickListener() { // from class: tech.sud.runtime.component.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeakReference<c> weakReference = a.this.b;
                if (weakReference != null && weakReference.get() != null) {
                    c cVar2 = a.this.b.get();
                    cVar2.b();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
                    cVar2.setLayoutParams(layoutParams);
                    a.this.setLayoutParams(layoutParams);
                }
            }
        };
        setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        Button button = new Button(context);
        this.a = button;
        button.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.a.setText("exit");
        this.a.setTextSize(24.0f);
        this.a.setTextColor(-12303292);
        this.a.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.setMargins(0, 20, 20, 0);
        this.a.setLayoutParams(layoutParams);
        this.a.setOnClickListener(this.c);
        addView(cVar);
        addView(this.a);
        this.b = new WeakReference<>(cVar);
    }

    public void a(boolean z) {
        FrameLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        setLayoutParams(layoutParams);
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }
}
