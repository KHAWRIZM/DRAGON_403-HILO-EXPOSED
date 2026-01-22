package l3;

import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f١٥٧٤٦a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupRoomImCustomBean f١٥٧٤٧b;

    public k(ConstraintLayout constraintLayout, GroupRoomImCustomBean groupRoomImCustomBean) {
        this.f١٥٧٤٦a = constraintLayout;
        this.f١٥٧٤٧b = groupRoomImCustomBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10;
        String groupId;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٤٦a) > 800 || (this.f١٥٧٤٦a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٤٦a, currentTimeMillis);
            Integer contentType = this.f١٥٧٤٧b.getContentType();
            if (contentType != null) {
                i10 = contentType.intValue();
            } else {
                i10 = 0;
            }
            String str = "";
            if (i10 != 1) {
                if (i10 == 2 && (groupId = this.f١٥٧٤٧b.getGroupId()) != null && groupId.length() > 0) {
                    BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                    String groupId2 = this.f١٥٧٤٧b.getGroupId();
                    if (groupId2 != null) {
                        str = groupId2;
                    }
                    baseControlUtils.openRoom(str);
                    return;
                }
                return;
            }
            String h52 = this.f١٥٧٤٧b.getH5();
            if (h52 != null && h52.length() != 0) {
                BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                String h53 = this.f١٥٧٤٧b.getH5();
                if (h53 != null) {
                    str = h53;
                }
                baseControlUtils2.openLevelActivity(str);
            }
        }
    }
}
