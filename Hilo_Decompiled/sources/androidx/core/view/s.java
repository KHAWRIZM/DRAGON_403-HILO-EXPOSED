package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f٣٠٤٥a;

    public s(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f٣٠٤٥a.onTouchEvent(motionEvent);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f٣٠٤٥a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public s(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f٣٠٤٥a = new GestureDetector(context, onGestureListener, handler);
    }
}
