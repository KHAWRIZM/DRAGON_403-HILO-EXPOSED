package com.oudi.utils;

import java.math.BigDecimal;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/oudi/utils/AmountUtils;", "", "<init>", "()V", "fty", "", "fen", "", "scale", "", "(Ljava/lang/Long;I)Ljava/lang/String;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AmountUtils {
    public static final AmountUtils INSTANCE = new AmountUtils();

    private AmountUtils() {
    }

    public static /* synthetic */ String fty$default(AmountUtils amountUtils, Long l10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 2;
        }
        return amountUtils.fty(l10, i10);
    }

    public final String fty(Long fen, int scale) {
        if (fen == null) {
            return null;
        }
        try {
            BigDecimal divide = new BigDecimal(fen.toString()).divide(new BigDecimal("100"));
            divide.setScale(scale, 1);
            return divide.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
