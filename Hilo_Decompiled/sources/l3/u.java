package l3;

import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f١٥٧٦٦a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageItemListener f١٥٧٦٧b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RoomMessageMulti f١٥٧٦٨c;

    public u(ImageView imageView, RoomMessageItemListener roomMessageItemListener, RoomMessageMulti roomMessageMulti) {
        this.f١٥٧٦٦a = imageView;
        this.f١٥٧٦٧b = roomMessageItemListener;
        this.f١٥٧٦٨c = roomMessageMulti;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٦٦a) > 800 || (this.f١٥٧٦٦a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٦٦a, currentTimeMillis);
            RoomMessageItemListener roomMessageItemListener = this.f١٥٧٦٧b;
            if (roomMessageItemListener != null) {
                roomMessageItemListener.onResendMessage(this.f١٥٧٦٨c);
            }
        }
    }
}
