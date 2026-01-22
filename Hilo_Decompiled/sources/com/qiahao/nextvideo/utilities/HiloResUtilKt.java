package com.qiahao.nextvideo.utilities;

import com.qiahao.base_common.model.common.FamilyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getGradeRes", "", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloResUtilKt {
    public static final int getGradeRes(@NotNull FamilyInfo familyInfo) {
        Intrinsics.checkNotNullParameter(familyInfo, "<this>");
        Integer grade = familyInfo.getGrade();
        if (grade != null && grade.intValue() == 0) {
            return 2131231719;
        }
        if (grade != null && grade.intValue() == 1) {
            return 2131231720;
        }
        if (grade != null && grade.intValue() == 2) {
            return 2131231721;
        }
        if (grade != null && grade.intValue() == 3) {
            return 2131231722;
        }
        if (grade != null && grade.intValue() == 4) {
            return 2131231723;
        }
        if (grade != null && grade.intValue() == 5) {
            return 2131231724;
        }
        if (grade != null) {
            grade.intValue();
        }
        return 2131231725;
    }
}
