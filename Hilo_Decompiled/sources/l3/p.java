package l3;

import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.TIMRoomEnvelope;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f١٥٧٥٥a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageAdapter f١٥٧٥٦b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TIMRoomEnvelope f١٥٧٥٧c;

    public p(ImageView imageView, RoomMessageAdapter roomMessageAdapter, TIMRoomEnvelope tIMRoomEnvelope) {
        this.f١٥٧٥٥a = imageView;
        this.f١٥٧٥٦b = roomMessageAdapter;
        this.f١٥٧٥٧c = tIMRoomEnvelope;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٥٥a) > 800 || (this.f١٥٧٥٥a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٥٥a, currentTimeMillis);
            RoomMessageItemListener mListener = this.f١٥٧٥٦b.getMListener();
            if (mListener != null) {
                mListener.onType(6, this.f١٥٧٥٧c.getLuckyBagId());
            }
        }
    }
}
