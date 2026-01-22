package m5;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final WheelView f١٥٩٨٦a;

    public b(WheelView wheelView) {
        this.f١٥٩٨٦a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1000) {
            if (i10 != 2000) {
                if (i10 == 3000) {
                    this.f١٥٩٨٦a.o();
                    return;
                }
                return;
            }
            this.f١٥٩٨٦a.t(WheelView.b.FLING);
            return;
        }
        this.f١٥٩٨٦a.invalidate();
    }
}
