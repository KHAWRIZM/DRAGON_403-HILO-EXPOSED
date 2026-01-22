package l3;

import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f١٥٧٣٢a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageAdapter f١٥٧٣٣b;

    public d(LinearLayout linearLayout, RoomMessageAdapter roomMessageAdapter) {
        this.f١٥٧٣٢a = linearLayout;
        this.f١٥٧٣٣b = roomMessageAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٣٢a) > 800 || (this.f١٥٧٣٢a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٣٢a, currentTimeMillis);
            RoomMessageItemListener mListener = this.f١٥٧٣٣b.getMListener();
            if (mListener != null) {
                mListener.onType(8, new Object());
            }
        }
    }
}
