package w7;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final Dialog f١٨٧٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٨٧٢١b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٨٧٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٨٧٢٣d;

    public a(Dialog dialog, Rect rect) {
        this.f١٨٧٢٠a = dialog;
        this.f١٨٧٢١b = rect.left;
        this.f١٨٧٢٢c = rect.top;
        this.f١٨٧٢٣d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f١٨٧٢١b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f١٨٧٢٢c + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i10 = this.f١٨٧٢٣d;
            obtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f١٨٧٢٠a.onTouchEvent(obtain);
    }
}
