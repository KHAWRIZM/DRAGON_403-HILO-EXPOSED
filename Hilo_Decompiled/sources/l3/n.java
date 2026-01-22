package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NickTextView f١٥٧٥٠a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageAdapter f١٥٧٥١b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٥٢c;

    public n(NickTextView nickTextView, RoomMessageAdapter roomMessageAdapter, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٥٠a = nickTextView;
        this.f١٥٧٥١b = roomMessageAdapter;
        this.f١٥٧٥٢c = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٥٠a) > 800 || (this.f١٥٧٥٠a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٥٠a, currentTimeMillis);
            RoomMessageItemListener mListener = this.f١٥٧٥١b.getMListener();
            if (mListener != null) {
                mListener.onType(5, this.f١٥٧٥٢c.getExternalId());
            }
        }
    }
}
