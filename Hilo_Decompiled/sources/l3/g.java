package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QMUIRadiusImageView f١٥٧٣٨a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٣٩b;

    public g(QMUIRadiusImageView qMUIRadiusImageView, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٣٨a = qMUIRadiusImageView;
        this.f١٥٧٣٩b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٣٨a) > 800 || (this.f١٥٧٣٨a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٣٨a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String operatorExternalId = this.f١٥٧٣٩b.getOperatorExternalId();
            if (operatorExternalId == null) {
                operatorExternalId = "";
            }
            baseControlUtils.roomOpenUserInfo(operatorExternalId);
        }
    }
}
