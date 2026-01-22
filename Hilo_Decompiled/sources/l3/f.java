package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QMUIRadiusImageView f١٥٧٣٦a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٣٧b;

    public f(QMUIRadiusImageView qMUIRadiusImageView, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٣٦a = qMUIRadiusImageView;
        this.f١٥٧٣٧b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٣٦a) > 800 || (this.f١٥٧٣٦a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٣٦a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String externalId = this.f١٥٧٣٧b.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            baseControlUtils.roomOpenUserInfo(externalId);
        }
    }
}
