package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QMUIRadiusImageView f١٥٧٦٩a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageItemListener f١٥٧٧٠b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RoomMessageMulti f١٥٧٧١c;

    public v(QMUIRadiusImageView qMUIRadiusImageView, RoomMessageItemListener roomMessageItemListener, RoomMessageMulti roomMessageMulti) {
        this.f١٥٧٦٩a = qMUIRadiusImageView;
        this.f١٥٧٧٠b = roomMessageItemListener;
        this.f١٥٧٧١c = roomMessageMulti;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٦٩a) > 800 || (this.f١٥٧٦٩a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٦٩a, currentTimeMillis);
            RoomMessageItemListener roomMessageItemListener = this.f١٥٧٧٠b;
            if (roomMessageItemListener != null) {
                roomMessageItemListener.onUserIconClick(this.f١٥٧٧١c);
            }
        }
    }
}
