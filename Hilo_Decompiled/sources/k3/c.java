package k3;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٨٣a;

    public c(MediaDetailActivity mediaDetailActivity) {
        this.f١٥٤٨٣a = mediaDetailActivity;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent e10) {
        int i10;
        Intrinsics.checkNotNullParameter(e10, "e");
        i10 = this.f١٥٤٨٣a.mediaType;
        if (i10 == 0) {
            return true;
        }
        return super.onDoubleTap(e10);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent e10) {
        int i10;
        Intrinsics.checkNotNullParameter(e10, "e");
        i10 = this.f١٥٤٨٣a.mediaType;
        if (i10 == 0) {
            return true;
        }
        return super.onSingleTapConfirmed(e10);
    }
}
