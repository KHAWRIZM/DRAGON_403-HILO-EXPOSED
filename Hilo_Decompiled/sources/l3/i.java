package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٤٢a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٤٣b;

    public i(ConstraintLayout constraintLayout, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٤٢a = constraintLayout;
        this.f١٥٧٤٣b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٤٢a) > 800 || (this.f١٥٧٤٢a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٤٢a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String groupId = this.f١٥٧٤٣b.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            baseControlUtils.openRoom(groupId);
        }
    }
}
