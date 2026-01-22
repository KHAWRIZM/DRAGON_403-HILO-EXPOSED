package l3;

import android.view.View;
import android.widget.Checkable;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.support.BaseControlUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f١٥٧٣٠a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityDetailData f١٥٧٣١b;

    public c(ActivityDetailData activityDetailData, View view) {
        this.f١٥٧٣٠a = view;
        this.f١٥٧٣١b = activityDetailData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ViewKtxKt.getLastClickTime(this.f١٥٧٣٠a) > 800 || (this.f١٥٧٣٠a instanceof Checkable)) {
            ViewKtxKt.setLastClickTime(this.f١٥٧٣٠a, currentTimeMillis);
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            ActivityDetailData activityDetailData = this.f١٥٧٣١b;
            if (activityDetailData == null || (str = activityDetailData.getId()) == null) {
                str = "";
            }
            baseControlUtils.openActivityDetail(str);
        }
    }
}
