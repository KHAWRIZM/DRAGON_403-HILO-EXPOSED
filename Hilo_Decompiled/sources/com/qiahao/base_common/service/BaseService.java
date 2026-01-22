package com.qiahao.base_common.service;

import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.R;
import com.qiahao.base_common.model.MedalBean;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH&J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH&J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\fH&¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/service/BaseService;", "", "<init>", "()V", "getMedalList", "", "Lcom/qiahao/base_common/model/MedalBean;", "getLevelBg", "", FirebaseAnalytics.Param.LEVEL, "", "isCharm", "", "isWealth", "isActivity", "getNobleColor", "nobleLevel", "defaultColor", "getNobleDrawableRes", "getChatNobleBackGroupDrawable", "getUserHasOnMic", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BaseService {
    public static /* synthetic */ int getLevelBg$default(BaseService baseService, long j10, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        boolean z13;
        boolean z14;
        boolean z15;
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z13 = false;
            } else {
                z13 = z10;
            }
            if ((i10 & 4) != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if ((i10 & 8) != 0) {
                z15 = false;
            } else {
                z15 = z12;
            }
            return baseService.getLevelBg(j10, z13, z14, z15);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLevelBg");
    }

    public static /* synthetic */ int getNobleColor$default(BaseService baseService, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return baseService.getNobleColor(i10, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNobleColor");
    }

    public final int getChatNobleBackGroupDrawable(int nobleLevel) {
        switch (nobleLevel) {
            case 1:
                return R.drawable.ic_noble_chat_bg_v1;
            case 2:
                return R.drawable.ic_noble_chat_bg_v2;
            case 3:
                return R.drawable.ic_noble_chat_bg_v3;
            case 4:
                return R.drawable.ic_noble_chat_bg_v4;
            case 5:
                return R.drawable.ic_noble_chat_bg_v5;
            case 6:
                return R.drawable.ic_noble_chat_bg_v6;
            case 7:
                return R.drawable.ic_noble_chat_bg_v7;
            case 8:
                return R.drawable.ic_noble_chat_bg_v8;
            case 9:
                return R.drawable.ic_noble_chat_bg_v9;
            case 10:
                return R.drawable.ic_noble_chat_bg_v10;
            default:
                return R.drawable.ic_noble_chat_bg_v0;
        }
    }

    public abstract int getLevelBg(long level, boolean isCharm, boolean isWealth, boolean isActivity);

    @NotNull
    public abstract List<MedalBean> getMedalList();

    public abstract int getNobleColor(int nobleLevel, int defaultColor);

    public abstract int getNobleDrawableRes(int nobleLevel);

    public abstract boolean getUserHasOnMic();
}
