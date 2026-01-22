package tech.sud.runtime.component.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayDeque;
import java.util.Iterator;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b extends LinearLayout {
    private ArrayDeque<c> a;
    private long b;

    public b(Context context, int i) {
        super(context);
        this.a = new ArrayDeque<>();
        this.b = 30000L;
        if (i > 0) {
            this.b = i * 1000;
        }
        setOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int childCount = getChildCount();
        if (childCount > 1 && getChildAt(childCount - 1).getBottom() > getContext().getResources().getDisplayMetrics().heightPixels - b()) {
            removeViewAt(0);
            post(new Runnable() { // from class: tech.sud.runtime.component.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ArrayDeque arrayDeque = new ArrayDeque();
        long currentTimeMillis = System.currentTimeMillis();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Long l = (Long) childAt.getTag();
            if (l != null && currentTimeMillis - l.longValue() >= this.b) {
                arrayDeque.addLast(childAt);
            }
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
        arrayDeque.clear();
    }

    private int b() {
        Context context = getContext();
        if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public void a(int i, String str) {
        if (str != null) {
            this.a.addLast(new c(i, str));
        }
    }

    public void a() {
        if (this.a.isEmpty()) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Iterator<c> it = this.a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            TextView a = a(next.a());
            a.setTag(valueOf);
            a.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            a.setAlpha(0.5f);
            addView(a);
            int b = next.b();
            if (b == 1) {
                a.setTextColor(-256);
            } else if (b == 2) {
                a.setTextColor(-65536);
            }
        }
        this.a.clear();
        post(new Runnable() { // from class: tech.sud.runtime.component.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.c();
            }
        });
        if (this.b > 0) {
            postDelayed(new Runnable() { // from class: tech.sud.runtime.component.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.d();
                }
            }, this.b);
        }
    }

    private TextView a(String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setBackgroundColor(-65536);
        textView.getBackground().setAlpha(a.a);
        textView.setText(str);
        textView.setTextSize(0, a.b);
        textView.setGravity(16);
        textView.setPadding(5, 0, 0, 0);
        return textView;
    }
}
