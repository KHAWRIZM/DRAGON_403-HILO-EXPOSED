package com.qhqc.core.feature.community;

import android.graphics.drawable.Drawable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/qhqc/core/feature/community/IUserInfoProvider;", "", "userInfo", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "getVipIcon", "Landroid/graphics/drawable/Drawable;", FirebaseAnalytics.Param.LEVEL, "", "getSVipIcon", "isSuperAdmin", "", "isCountryAdmin", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IUserInfoProvider {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static boolean isCountryAdmin(@NotNull IUserInfoProvider iUserInfoProvider) {
            return false;
        }
    }

    @Nullable
    Drawable getSVipIcon(int level);

    @Nullable
    Drawable getVipIcon(int level);

    boolean isCountryAdmin();

    boolean isSuperAdmin();

    @NotNull
    UserInfoBean userInfo();
}
