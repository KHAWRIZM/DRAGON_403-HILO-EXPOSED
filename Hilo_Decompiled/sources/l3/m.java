package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٤٩a;

    public m(ConstraintLayout constraintLayout) {
        this.f١٥٧٤٩a = constraintLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٤٩a) > 800 || (this.f١٥٧٤٩a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٤٩a, currentTimeMillis);
            cf.c.c().l(new LiveEvent(LiveEvent.OPEN_LUCKY_FRUIT, null, 2, null));
        }
    }
}
