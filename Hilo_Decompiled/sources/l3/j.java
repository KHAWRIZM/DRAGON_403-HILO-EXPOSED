package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٤٤a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٤٥b;

    public j(ConstraintLayout constraintLayout, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٤٤a = constraintLayout;
        this.f١٥٧٤٥b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٤٤a) > 800 || (this.f١٥٧٤٤a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٤٤a, currentTimeMillis);
            String h52 = this.f١٥٧٤٥b.getH5();
            if (h52 != null && h52.length() != 0) {
                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                String h53 = this.f١٥٧٤٥b.getH5();
                if (h53 == null) {
                    h53 = "";
                }
                baseControlUtils.openLevelActivity(h53);
            }
        }
    }
}
