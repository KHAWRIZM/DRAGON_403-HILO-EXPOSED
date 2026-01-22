package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.hilo_message.data.CustomElemContent;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f١٥٧٦٤a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMessageMulti f١٥٧٦٥b;

    public t(View view, RoomMessageMulti roomMessageMulti) {
        this.f١٥٧٦٤a = view;
        this.f١٥٧٦٥b = roomMessageMulti;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        CustomElemContent customElemContent;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٦٤a) > 800 || (this.f١٥٧٦٤a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٦٤a, currentTimeMillis);
            cf.c c10 = cf.c.c();
            GroupMessageNew data = this.f١٥٧٦٥b.getData();
            if (data == null || (customElemContent = BuildMessageUtilsKt.getCustomElemContent(data)) == null || (str = customElemContent.getData()) == null) {
                str = "";
            }
            c10.l(new LiveEvent("open_game", BuildMessageUtilsKt.checkRoomMessageType(str)));
        }
    }
}
