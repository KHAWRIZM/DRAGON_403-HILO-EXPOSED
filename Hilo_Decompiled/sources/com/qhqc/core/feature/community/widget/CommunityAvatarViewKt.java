package com.qhqc.core.feature.community.widget;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"imageCircle", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "feature_community_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityAvatarViewKt {
    @NotNull
    public static final String imageCircle(@Nullable String str, int i10) {
        if (str == null) {
            return "";
        }
        if (i10 <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("?x-oss-process=image/resize,");
        sb.append("m_lfit");
        sb.append(",w_" + i10);
        sb.append(",h_" + i10);
        sb.append("/format,png/rounded-corners,r_" + (i10 / 2));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
