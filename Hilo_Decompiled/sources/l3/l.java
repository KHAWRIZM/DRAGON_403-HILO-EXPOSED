package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٤٨a;

    public l(ConstraintLayout constraintLayout) {
        this.f١٥٧٤٨a = constraintLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٤٨a) > 800 || (this.f١٥٧٤٨a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٤٨a, currentTimeMillis);
            cf.c.c().l(new LiveEvent(LiveEvent.OPEN_LUCKY_BOX, null, 2, null));
        }
    }
}
