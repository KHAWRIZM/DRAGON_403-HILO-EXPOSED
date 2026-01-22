package m5;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    private int f١٥٩٨٧a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    private int f١٥٩٨٨b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f١٥٩٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private final WheelView f١٥٩٩٠d;

    public c(WheelView wheelView, int i10) {
        this.f١٥٩٩٠d = wheelView;
        this.f١٥٩٨٩c = i10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f١٥٩٨٧a == Integer.MAX_VALUE) {
            this.f١٥٩٨٧a = this.f١٥٩٨٩c;
        }
        int i10 = this.f١٥٩٨٧a;
        int i11 = (int) (i10 * 0.1f);
        this.f١٥٩٨٨b = i11;
        if (i11 == 0) {
            if (i10 < 0) {
                this.f١٥٩٨٨b = -1;
            } else {
                this.f١٥٩٨٨b = 1;
            }
        }
        if (Math.abs(i10) <= 1) {
            this.f١٥٩٩٠d.b();
            this.f١٥٩٩٠d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f١٥٩٩٠d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f١٥٩٨٨b);
        if (!this.f١٥٩٩٠d.j()) {
            float itemHeight = this.f١٥٩٩٠d.getItemHeight();
            float itemsCount = ((this.f١٥٩٩٠d.getItemsCount() - 1) - this.f١٥٩٩٠d.getInitPosition()) * itemHeight;
            if (this.f١٥٩٩٠d.getTotalScrollY() <= (-this.f١٥٩٩٠d.getInitPosition()) * itemHeight || this.f١٥٩٩٠d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f١٥٩٩٠d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f١٥٩٨٨b);
                this.f١٥٩٩٠d.b();
                this.f١٥٩٩٠d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f١٥٩٩٠d.getHandler().sendEmptyMessage(1000);
        this.f١٥٩٨٧a -= this.f١٥٩٨٨b;
    }
}
