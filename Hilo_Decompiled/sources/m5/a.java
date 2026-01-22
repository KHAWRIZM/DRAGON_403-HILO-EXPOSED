package m5;

import com.contrarywind.view.WheelView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.TimerTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    private float f١٥٩٨٣a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    private final float f١٥٩٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private final WheelView f١٥٩٨٥c;

    public a(WheelView wheelView, float f10) {
        this.f١٥٩٨٥c = wheelView;
        this.f١٥٩٨٤b = f10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f١٥٩٨٣a == 2.1474836E9f) {
            float f10 = 2000.0f;
            if (Math.abs(this.f١٥٩٨٤b) > 2000.0f) {
                if (this.f١٥٩٨٤b <= DownloadProgress.UNKNOWN_PROGRESS) {
                    f10 = -2000.0f;
                }
                this.f١٥٩٨٣a = f10;
            } else {
                this.f١٥٩٨٣a = this.f١٥٩٨٤b;
            }
        }
        if (Math.abs(this.f١٥٩٨٣a) >= DownloadProgress.UNKNOWN_PROGRESS && Math.abs(this.f١٥٩٨٣a) <= 20.0f) {
            this.f١٥٩٨٥c.b();
            this.f١٥٩٨٥c.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i10 = (int) (this.f١٥٩٨٣a / 100.0f);
        WheelView wheelView = this.f١٥٩٨٥c;
        float f11 = i10;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f11);
        if (!this.f١٥٩٨٥c.j()) {
            float itemHeight = this.f١٥٩٨٥c.getItemHeight();
            float f12 = (-this.f١٥٩٨٥c.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f١٥٩٨٥c.getItemsCount() - 1) - this.f١٥٩٨٥c.getInitPosition()) * itemHeight;
            double d10 = itemHeight * 0.25d;
            if (this.f١٥٩٨٥c.getTotalScrollY() - d10 < f12) {
                f12 = this.f١٥٩٨٥c.getTotalScrollY() + f11;
            } else if (this.f١٥٩٨٥c.getTotalScrollY() + d10 > itemsCount) {
                itemsCount = this.f١٥٩٨٥c.getTotalScrollY() + f11;
            }
            if (this.f١٥٩٨٥c.getTotalScrollY() <= f12) {
                this.f١٥٩٨٣a = 40.0f;
                this.f١٥٩٨٥c.setTotalScrollY((int) f12);
            } else if (this.f١٥٩٨٥c.getTotalScrollY() >= itemsCount) {
                this.f١٥٩٨٥c.setTotalScrollY((int) itemsCount);
                this.f١٥٩٨٣a = -40.0f;
            }
        }
        float f13 = this.f١٥٩٨٣a;
        if (f13 < DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٥٩٨٣a = f13 + 20.0f;
        } else {
            this.f١٥٩٨٣a = f13 - 20.0f;
        }
        this.f١٥٩٨٥c.getHandler().sendEmptyMessage(1000);
    }
}
