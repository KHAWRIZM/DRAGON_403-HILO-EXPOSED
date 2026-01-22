package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QMUIRadiusImageView f١٥٧٦٢a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٦٣b;

    public s(QMUIRadiusImageView qMUIRadiusImageView, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٦٢a = qMUIRadiusImageView;
        this.f١٥٧٦٣b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٦٢a) > 800 || (this.f١٥٧٦٢a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٦٢a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String externalId = this.f١٥٧٦٣b.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            baseControlUtils.roomOpenUserInfo(externalId);
        }
    }
}
