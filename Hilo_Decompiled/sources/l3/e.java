package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QMUIRadiusImageView f١٥٧٣٤a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٣٥b;

    public e(QMUIRadiusImageView qMUIRadiusImageView, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٣٤a = qMUIRadiusImageView;
        this.f١٥٧٣٥b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٣٤a) > 800 || (this.f١٥٧٣٤a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٣٤a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String operatorExternalId = this.f١٥٧٣٥b.getOperatorExternalId();
            if (operatorExternalId == null) {
                operatorExternalId = "";
            }
            baseControlUtils.roomOpenUserInfo(operatorExternalId);
        }
    }
}
