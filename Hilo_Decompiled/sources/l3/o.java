package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٥٣a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomMatchGame f١٥٧٥٤b;

    public o(ConstraintLayout constraintLayout, RoomMatchGame roomMatchGame) {
        this.f١٥٧٥٣a = constraintLayout;
        this.f١٥٧٥٤b = roomMatchGame;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٥٣a) > 800 || (this.f١٥٧٥٣a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٥٣a, currentTimeMillis);
            cf.c.c().l(new LiveEvent(LiveEvent.JOIN_MATCH_GAME, this.f١٥٧٥٤b));
        }
    }
}
