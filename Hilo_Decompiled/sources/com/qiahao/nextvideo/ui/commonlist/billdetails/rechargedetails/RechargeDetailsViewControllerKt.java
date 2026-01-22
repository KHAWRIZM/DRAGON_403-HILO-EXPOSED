package com.qiahao.nextvideo.ui.commonlist.billdetails.rechargedetails;

import android.content.Context;
import android.content.res.Resources;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.model.PurchaseItem;
import com.qiahao.nextvideo.ui.commonlist.CommonListCellUIModel;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.StringUtilityKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"init", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel$Companion;", "context", "Landroid/content/Context;", "it", "Lcom/qiahao/nextvideo/data/model/PurchaseItem;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RechargeDetailsViewControllerKt {
    @NotNull
    public static final CommonListCellUIModel init(@NotNull CommonListCellUIModel.Companion companion, @NotNull Context context, @NotNull PurchaseItem purchaseItem) {
        String str;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(purchaseItem, "it");
        String id2 = purchaseItem.getId();
        String string = context.getString(2131953850);
        String dateHmsInSecond$default = DateTimeUtilityKt.getDateHmsInSecond$default(purchaseItem.getCreatedAt(), (Locale) null, (String) null, 6, (Object) null);
        Float diamonds = purchaseItem.getDiamonds();
        if (diamonds != null) {
            str = StringUtilityKt.format2Bit(diamonds.floatValue());
        } else {
            str = null;
        }
        String str2 = "+" + str + " " + context.getString(2131952567);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Integer valueOf = Integer.valueOf(ResourceUtilsKt.getColor(resources, 2131099840));
        Resources resources2 = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        return new CommonListCellUIModel(null, null, id2, string, null, null, null, null, null, dateHmsInSecond$default, str2, valueOf, null, null, null, null, Integer.valueOf(ResourceUtilsKt.getColor(resources2, 2131101170)), 13, null, null, 848371, null);
    }
}
