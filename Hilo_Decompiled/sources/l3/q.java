package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f١٥٧٥٨a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٥٩b;

    public q(View view, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٥٨a = view;
        this.f١٥٧٥٩b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٥٨a) > 800 || (this.f١٥٧٥٨a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٥٨a, currentTimeMillis);
            if (Intrinsics.areEqual(this.f١٥٧٥٩b.getType(), "128")) {
                cf.c.c().l(new LiveEvent("open_game", this.f١٥٧٥٩b.getType()));
            }
        }
    }
}
