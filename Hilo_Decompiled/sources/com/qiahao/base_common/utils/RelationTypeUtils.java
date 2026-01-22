package com.qiahao.base_common.utils;

import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b.\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J+\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010\"\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ+\u0010#\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010)\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010*\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010+\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010,\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010-\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010.\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010/\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00100\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00101\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00102\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00103\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00104\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00105\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u001f\u00106\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0002\u00107J\u0017\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u00109\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010:\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0017\u0010;\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u001f\u0010<\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005¢\u0006\u0002\u0010>R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/qiahao/base_common/utils/RelationTypeUtils;", "", "<init>", "()V", "RELATION_TYPE_CP", "", "RELATION_TYPE_SOUL", "RELATION_TYPE_BESTIE", "RELATION_TYPE_BROTHER", "checkRelation", "", "relationType", "getRelationMedal", "relationLevel", "show0", "(Ljava/lang/Integer;ZI)Ljava/lang/Integer;", "getRelationTitle", "", "(Ljava/lang/Integer;I)Ljava/lang/String;", "getRelationIDColor", "spaceRelationDefaultColor", "relationText", "spaceRelationTimeColor", "spaceRelationPointNumberColor", "spaceRelationPointTipColor", "spaceRelationPrivilegeTitleColor", "spaceRelationMyCpColor", "spaceRelationCurrentLevelColor", "spaceRelationLevelTextColor", "isSelect", "spaceRelationAvatarBorder", "(I)Ljava/lang/Integer;", "spaceRelationTobBg", "spaceRelationButtonBg", "spaceRelationUnbinding", "spaceRelationLeftOrRight", "isLeft", "isDefault", "(IZZ)Ljava/lang/Integer;", "spaceRelationIcon1", "spaceRelationIcon2", "spaceRelationIcon3", "spaceRelationIcon4", "spaceRelationIcon5", "spaceRelationIcon6", "spaceRelationIcon7", "spaceRelationIcon8", "spaceRelationIcon9", "spaceRelationIcon10", "spaceRelationIcon11", "spaceRelationIcon12", "spaceRelationIcon13", "spaceRelationIcon14", "spaceRelationIcon15", "spaceRelationIcon16", "(IZ)Ljava/lang/Integer;", "spaceRelationIcon17", "spaceRelationIcon18", "spaceRelationIcon19", "spaceRelationIcon20", "getUserEnter", FirebaseAnalytics.Param.LEVEL, "(II)Ljava/lang/Integer;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RelationTypeUtils {

    @NotNull
    public static final RelationTypeUtils INSTANCE = new RelationTypeUtils();
    public static final int RELATION_TYPE_BESTIE = 3;
    public static final int RELATION_TYPE_BROTHER = 4;
    public static final int RELATION_TYPE_CP = 1;
    public static final int RELATION_TYPE_SOUL = 2;

    private RelationTypeUtils() {
    }

    public static /* synthetic */ String getRelationIDColor$default(RelationTypeUtils relationTypeUtils, Integer num, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.getRelationIDColor(num, i10);
    }

    public static /* synthetic */ Integer getRelationMedal$default(RelationTypeUtils relationTypeUtils, Integer num, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.getRelationMedal(num, z10, i10);
    }

    public static /* synthetic */ String getRelationTitle$default(RelationTypeUtils relationTypeUtils, Integer num, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.getRelationTitle(num, i10);
    }

    public static /* synthetic */ Integer getUserEnter$default(RelationTypeUtils relationTypeUtils, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.getUserEnter(i10, i11);
    }

    public static /* synthetic */ int relationText$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.relationText(i10);
    }

    public static /* synthetic */ Integer spaceRelationAvatarBorder$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationAvatarBorder(i10);
    }

    public static /* synthetic */ Integer spaceRelationButtonBg$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationButtonBg(i10);
    }

    public static /* synthetic */ int spaceRelationCurrentLevelColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationCurrentLevelColor(i10);
    }

    public static /* synthetic */ int spaceRelationDefaultColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationDefaultColor(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon1$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon1(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon10$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon10(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon11$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon11(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon12$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon12(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon13$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon13(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon14$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon14(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon15$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon15(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon16$default(RelationTypeUtils relationTypeUtils, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon16(i10, z10);
    }

    public static /* synthetic */ Integer spaceRelationIcon17$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon17(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon18$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon18(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon19$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon19(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon2$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon2(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon20$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon20(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon3$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon3(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon4$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon4(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon5$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon5(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon6$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon6(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon7$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon7(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon8$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon8(i10);
    }

    public static /* synthetic */ Integer spaceRelationIcon9$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationIcon9(i10);
    }

    public static /* synthetic */ Integer spaceRelationLeftOrRight$default(RelationTypeUtils relationTypeUtils, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return relationTypeUtils.spaceRelationLeftOrRight(i10, z10, z11);
    }

    public static /* synthetic */ int spaceRelationLevelTextColor$default(RelationTypeUtils relationTypeUtils, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationLevelTextColor(i10, z10);
    }

    public static /* synthetic */ int spaceRelationMyCpColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationMyCpColor(i10);
    }

    public static /* synthetic */ int spaceRelationPointNumberColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationPointNumberColor(i10);
    }

    public static /* synthetic */ int spaceRelationPointTipColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationPointTipColor(i10);
    }

    public static /* synthetic */ int spaceRelationPrivilegeTitleColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationPrivilegeTitleColor(i10);
    }

    public static /* synthetic */ int spaceRelationTimeColor$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationTimeColor(i10);
    }

    public static /* synthetic */ Integer spaceRelationTobBg$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationTobBg(i10);
    }

    public static /* synthetic */ Integer spaceRelationUnbinding$default(RelationTypeUtils relationTypeUtils, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return relationTypeUtils.spaceRelationUnbinding(i10);
    }

    public final boolean checkRelation(int relationType) {
        return relationType == 1 || relationType == 2 || relationType == 3 || relationType == 4;
    }

    @NotNull
    public final String getRelationIDColor(@Nullable Integer relationLevel, int relationType) {
        String str;
        if (relationType != 1) {
            int i10 = 0;
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return "#ffffff";
                    }
                    str = "#8F4618";
                    if (relationLevel == null || relationLevel.intValue() != 1) {
                        if (relationLevel != null && relationLevel.intValue() == 2) {
                            return "#1D9293";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 3) {
                            return "#0D7149";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 4) {
                            return "#0099BD";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 5) {
                            return "#6648FF";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 6) {
                            return "#8400FF";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 7) {
                            return "#D60909";
                        }
                        if (relationLevel != null) {
                            i10 = relationLevel.intValue();
                        }
                        if (i10 > 7) {
                            return "#D60909";
                        }
                    }
                } else {
                    str = "#1F74FF";
                    if (relationLevel == null || relationLevel.intValue() != 1) {
                        if (relationLevel != null && relationLevel.intValue() == 2) {
                            return "#FA3683";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 3) {
                            return "#794FFB";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 4) {
                            return "#B90EBC";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 5) {
                            return "#FF0A10";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 6) {
                            return "#6E09D6";
                        }
                        if (relationLevel != null && relationLevel.intValue() == 7) {
                            return "#D60909";
                        }
                        if (relationLevel != null) {
                            i10 = relationLevel.intValue();
                        }
                        if (i10 > 7) {
                            return "#D60909";
                        }
                    }
                }
            } else {
                if (relationLevel != null && relationLevel.intValue() == 1) {
                    return "#1E7654";
                }
                if (relationLevel != null && relationLevel.intValue() == 2) {
                    return "#82331B";
                }
                if (relationLevel != null && relationLevel.intValue() == 3) {
                    return "#167226";
                }
                if (relationLevel != null && relationLevel.intValue() == 4) {
                    return "#1962C7";
                }
                str = "#D21B5C";
                if ((relationLevel == null || relationLevel.intValue() != 5) && (relationLevel == null || relationLevel.intValue() != 6)) {
                    str = "#B20F88";
                    if (relationLevel == null || relationLevel.intValue() != 7) {
                        if (relationLevel != null) {
                            i10 = relationLevel.intValue();
                        }
                        if (i10 <= 7) {
                            return "#1E7654";
                        }
                    }
                }
            }
        } else {
            if (relationLevel != null && relationLevel.intValue() == 1) {
                return "#3e75f1";
            }
            if (relationLevel != null && relationLevel.intValue() == 2) {
                return "#f02c68";
            }
            if (relationLevel != null && relationLevel.intValue() == 3) {
                return "#ff6e00";
            }
            if (relationLevel != null && relationLevel.intValue() == 4) {
                return "#b000aa";
            }
            str = "#eb2b2b";
            if (relationLevel == null || relationLevel.intValue() != 5) {
                if (relationLevel != null && relationLevel.intValue() == 6) {
                    return "#D60965";
                }
                if (relationLevel != null && relationLevel.intValue() == 7) {
                    return "#D60909";
                }
            }
        }
        return str;
    }

    @Nullable
    public final Integer getRelationMedal(@Nullable Integer relationLevel, boolean show0, int relationType) {
        int i10 = 0;
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType == 4) {
                        if (relationLevel != null && relationLevel.intValue() == 0) {
                            if (show0) {
                                return Integer.valueOf(R.drawable.brother_model0);
                            }
                        } else {
                            if (relationLevel != null && relationLevel.intValue() == 1) {
                                return Integer.valueOf(R.drawable.brother_model1);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 2) {
                                return Integer.valueOf(R.drawable.brother_model2);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 3) {
                                return Integer.valueOf(R.drawable.brother_model3);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 4) {
                                return Integer.valueOf(R.drawable.brother_model4);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 5) {
                                return Integer.valueOf(R.drawable.brother_model5);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 6) {
                                return Integer.valueOf(R.drawable.brother_model6);
                            }
                            if (relationLevel != null && relationLevel.intValue() == 7) {
                                return Integer.valueOf(R.drawable.brother_model7);
                            }
                            if (relationLevel != null) {
                                i10 = relationLevel.intValue();
                            }
                            if (i10 > 7) {
                                return Integer.valueOf(R.drawable.brother_model7);
                            }
                        }
                    }
                } else if (relationLevel != null && relationLevel.intValue() == 0) {
                    if (show0) {
                        return Integer.valueOf(R.drawable.bestie_model0);
                    }
                } else {
                    if (relationLevel != null && relationLevel.intValue() == 1) {
                        return Integer.valueOf(R.drawable.bestie_model1);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 2) {
                        return Integer.valueOf(R.drawable.bestie_model2);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 3) {
                        return Integer.valueOf(R.drawable.bestie_model3);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 4) {
                        return Integer.valueOf(R.drawable.bestie_model4);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 5) {
                        return Integer.valueOf(R.drawable.bestie_model5);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 6) {
                        return Integer.valueOf(R.drawable.bestie_model6);
                    }
                    if (relationLevel != null && relationLevel.intValue() == 7) {
                        return Integer.valueOf(R.drawable.bestie_model7);
                    }
                    if (relationLevel != null) {
                        i10 = relationLevel.intValue();
                    }
                    if (i10 > 7) {
                        return Integer.valueOf(R.drawable.bestie_model7);
                    }
                }
            } else if (relationLevel != null && relationLevel.intValue() == 0) {
                if (show0) {
                    return Integer.valueOf(R.drawable.soul_model0);
                }
            } else {
                if (relationLevel != null && relationLevel.intValue() == 1) {
                    return Integer.valueOf(R.drawable.soul_model1);
                }
                if (relationLevel != null && relationLevel.intValue() == 2) {
                    return Integer.valueOf(R.drawable.soul_model2);
                }
                if (relationLevel != null && relationLevel.intValue() == 3) {
                    return Integer.valueOf(R.drawable.soul_model3);
                }
                if (relationLevel != null && relationLevel.intValue() == 4) {
                    return Integer.valueOf(R.drawable.soul_model4);
                }
                if (relationLevel != null && relationLevel.intValue() == 5) {
                    return Integer.valueOf(R.drawable.soul_model5);
                }
                if (relationLevel != null && relationLevel.intValue() == 6) {
                    return Integer.valueOf(R.drawable.soul_model6);
                }
                if (relationLevel != null && relationLevel.intValue() == 7) {
                    return Integer.valueOf(R.drawable.soul_model7);
                }
                if (relationLevel != null) {
                    i10 = relationLevel.intValue();
                }
                if (i10 > 7) {
                    return Integer.valueOf(R.drawable.soul_model7);
                }
            }
        } else if (relationLevel != null && relationLevel.intValue() == 0) {
            if (show0) {
                return Integer.valueOf(R.drawable.cp_model0);
            }
        } else {
            if (relationLevel != null && relationLevel.intValue() == 1) {
                return Integer.valueOf(R.drawable.cp_model1);
            }
            if (relationLevel != null && relationLevel.intValue() == 2) {
                return Integer.valueOf(R.drawable.cp_model2);
            }
            if (relationLevel != null && relationLevel.intValue() == 3) {
                return Integer.valueOf(R.drawable.cp_model3);
            }
            if (relationLevel != null && relationLevel.intValue() == 4) {
                return Integer.valueOf(R.drawable.cp_model4);
            }
            if (relationLevel != null && relationLevel.intValue() == 5) {
                return Integer.valueOf(R.drawable.cp_model5);
            }
            if (relationLevel != null && relationLevel.intValue() == 6) {
                return Integer.valueOf(R.drawable.cp_model6);
            }
            if (relationLevel != null && relationLevel.intValue() == 7) {
                return Integer.valueOf(R.drawable.cp_model7);
            }
            if (relationLevel != null) {
                i10 = relationLevel.intValue();
            }
            if (i10 > 7) {
                return Integer.valueOf(R.drawable.cp_model7);
            }
        }
        return null;
    }

    @Nullable
    public final String getRelationTitle(@Nullable Integer relationLevel, int relationType) {
        int i10;
        if (relationType == 1) {
            if (relationLevel != null && relationLevel.intValue() == 1) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title1);
            }
            if (relationLevel != null && relationLevel.intValue() == 2) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title2);
            }
            if (relationLevel != null && relationLevel.intValue() == 3) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title3);
            }
            if (relationLevel != null && relationLevel.intValue() == 4) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title4);
            }
            if (relationLevel != null && relationLevel.intValue() == 5) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title5);
            }
            if (relationLevel != null && relationLevel.intValue() == 6) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title6);
            }
            if (relationLevel != null && relationLevel.intValue() == 7) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title7);
            }
            if (relationLevel != null) {
                i10 = relationLevel.intValue();
            } else {
                i10 = 0;
            }
            if (i10 > 7) {
                return ResourcesKtxKt.getStringById(this, R.string.cp_title7);
            }
        }
        return null;
    }

    @Nullable
    public final Integer getUserEnter(int relationType, int level) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType == 4) {
                        switch (level) {
                            case 2:
                                return Integer.valueOf(R.drawable.brother_enter_bg2);
                            case 3:
                                return Integer.valueOf(R.drawable.brother_enter_bg3);
                            case 4:
                                return Integer.valueOf(R.drawable.brother_enter_bg4);
                            case 5:
                                return Integer.valueOf(R.drawable.brother_enter_bg5);
                            case 6:
                                return Integer.valueOf(R.drawable.brother_enter_bg6);
                            case 7:
                                return Integer.valueOf(R.drawable.brother_enter_bg7);
                            default:
                                if (level > 7) {
                                    return Integer.valueOf(R.drawable.brother_enter_bg7);
                                }
                                break;
                        }
                    }
                } else {
                    switch (level) {
                        case 2:
                            return Integer.valueOf(R.drawable.bestie_enter_bg2);
                        case 3:
                            return Integer.valueOf(R.drawable.bestie_enter_bg3);
                        case 4:
                            return Integer.valueOf(R.drawable.bestie_enter_bg4);
                        case 5:
                            return Integer.valueOf(R.drawable.bestie_enter_bg5);
                        case 6:
                            return Integer.valueOf(R.drawable.bestie_enter_bg6);
                        case 7:
                            return Integer.valueOf(R.drawable.bestie_enter_bg7);
                        default:
                            if (level > 7) {
                                return Integer.valueOf(R.drawable.bestie_enter_bg7);
                            }
                            break;
                    }
                }
            } else {
                switch (level) {
                    case 2:
                        return Integer.valueOf(R.drawable.soul_enter_bg2);
                    case 3:
                        return Integer.valueOf(R.drawable.soul_enter_bg3);
                    case 4:
                        return Integer.valueOf(R.drawable.soul_enter_bg4);
                    case 5:
                        return Integer.valueOf(R.drawable.soul_enter_bg5);
                    case 6:
                        return Integer.valueOf(R.drawable.soul_enter_bg6);
                    case 7:
                        return Integer.valueOf(R.drawable.soul_enter_bg7);
                    default:
                        if (level > 7) {
                            return Integer.valueOf(R.drawable.soul_enter_bg7);
                        }
                        break;
                }
            }
        } else {
            switch (level) {
                case 2:
                    return Integer.valueOf(R.drawable.cp_enter_bg2);
                case 3:
                    return Integer.valueOf(R.drawable.cp_enter_bg3);
                case 4:
                    return Integer.valueOf(R.drawable.cp_enter_bg4);
                case 5:
                    return Integer.valueOf(R.drawable.cp_enter_bg5);
                case 6:
                    return Integer.valueOf(R.drawable.cp_enter_bg6);
                case 7:
                    return Integer.valueOf(R.drawable.cp_enter_bg7);
                default:
                    if (level > 7) {
                        return Integer.valueOf(R.drawable.cp_enter_bg7);
                    }
                    break;
            }
        }
        return null;
    }

    public final int relationText(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return R.string.cp_send_to;
                    }
                    return R.string.sent_homie;
                }
                return R.string.sent_bestie;
            }
            return R.string.sent_soulmate;
        }
        return R.string.cp_send_to;
    }

    @Nullable
    public final Integer spaceRelationAvatarBorder(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_space_default_heard);
                }
                return Integer.valueOf(R.drawable.bestie_space_default_heard);
            }
            return Integer.valueOf(R.drawable.soul_space_default_heard);
        }
        return Integer.valueOf(R.drawable.cp_space_default_heard);
    }

    @Nullable
    public final Integer spaceRelationButtonBg(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.shape_1bof12_3a1014);
                }
                return Integer.valueOf(R.drawable.shape_ff8dec_ffcbed);
            }
            return Integer.valueOf(R.drawable.shape_9fdcff_c8feff);
        }
        return Integer.valueOf(R.drawable.shape_ffabb8_ffcfc8);
    }

    public final int spaceRelationCurrentLevelColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#ff4a70");
                    }
                    return Color.parseColor("#FFF25E");
                }
                return Color.parseColor("#E932FF");
            }
            return Color.parseColor("#FFFFFF");
        }
        return Color.parseColor("#ff4a70");
    }

    public final int spaceRelationDefaultColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#d76800");
                    }
                    return Color.parseColor("#832018");
                }
                return Color.parseColor("#8800FF");
            }
            return Color.parseColor("#255af1");
        }
        return Color.parseColor("#d76800");
    }

    @Nullable
    public final Integer spaceRelationIcon1(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_top_icon);
                }
                return Integer.valueOf(R.drawable.bestie_top_icon);
            }
            return Integer.valueOf(R.drawable.soul_top_icon);
        }
        return Integer.valueOf(R.drawable.cp_top_icon);
    }

    @Nullable
    public final Integer spaceRelationIcon10(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.progressbar_brother);
                }
                return Integer.valueOf(R.drawable.progressbar_bestie);
            }
            return Integer.valueOf(R.drawable.progressbar_soul);
        }
        return Integer.valueOf(R.drawable.progressbar_cp);
    }

    @Nullable
    public final Integer spaceRelationIcon11(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.shape_8d3727_bord_2dp);
                }
                return Integer.valueOf(R.drawable.shape_f881ff_bord_2dp);
            }
            return Integer.valueOf(R.drawable.shape_59c6ff_bord_2dp);
        }
        return Integer.valueOf(R.drawable.shape_ff819f_bord_2dp);
    }

    @Nullable
    public final Integer spaceRelationIcon12(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_privilege_title_bg);
                }
                return Integer.valueOf(R.drawable.bestie_privilege_title_bg);
            }
            return Integer.valueOf(R.drawable.soul_privilege_title_bg);
        }
        return Integer.valueOf(R.drawable.cp_privilege_title_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon13(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(Color.parseColor("#DA755F"));
                }
                return Integer.valueOf(Color.parseColor("#FFBFFE"));
            }
            return Integer.valueOf(Color.parseColor("#68BEFF"));
        }
        return Integer.valueOf(Color.parseColor("#ffbfc1"));
    }

    @Nullable
    public final Integer spaceRelationIcon14(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_my_bg);
                }
                return Integer.valueOf(R.drawable.bestie_my_bg);
            }
            return Integer.valueOf(R.drawable.soul_my_bg);
        }
        return Integer.valueOf(R.drawable.cp_my_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon15(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_progress_bg);
                }
                return Integer.valueOf(R.drawable.bestie_progress_bg);
            }
            return Integer.valueOf(R.drawable.soul_progress_bg);
        }
        return Integer.valueOf(R.drawable.cp_progress_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon16(int relationType, boolean isSelect) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    if (isSelect) {
                        i13 = R.drawable.brother_level_icon_select;
                    } else {
                        i13 = R.drawable.brother_level_icon;
                    }
                    return Integer.valueOf(i13);
                }
                if (isSelect) {
                    i12 = R.drawable.bestie_level_icon_select;
                } else {
                    i12 = R.drawable.bestie_level_icon;
                }
                return Integer.valueOf(i12);
            }
            if (isSelect) {
                i11 = R.drawable.soul_level_icon_select;
            } else {
                i11 = R.drawable.soul_level_icon;
            }
            return Integer.valueOf(i11);
        }
        if (isSelect) {
            i10 = R.drawable.cp_level_icon_select;
        } else {
            i10 = R.drawable.cp_level_icon;
        }
        return Integer.valueOf(i10);
    }

    @Nullable
    public final Integer spaceRelationIcon17(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_current_level_icon);
                }
                return Integer.valueOf(R.drawable.bestie_current_level_icon);
            }
            return Integer.valueOf(R.drawable.soul_current_level_icon);
        }
        return Integer.valueOf(R.drawable.cp_current_level_icon);
    }

    @Nullable
    public final Integer spaceRelationIcon18(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_current_tip_bg);
                }
                return Integer.valueOf(R.drawable.bestie_current_tip_bg);
            }
            return Integer.valueOf(R.drawable.soul_current_tip_bg);
        }
        return Integer.valueOf(R.drawable.cp_current_tip_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon19(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_privilege_bg);
                }
                return Integer.valueOf(R.drawable.bestie_privilege_bg);
            }
            return Integer.valueOf(R.drawable.soul_privilege_bg);
        }
        return Integer.valueOf(R.drawable.cp_privilege_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon2(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_add_icon);
                }
                return Integer.valueOf(R.drawable.bestie_add_icon);
            }
            return Integer.valueOf(R.drawable.soul_add_icon);
        }
        return Integer.valueOf(R.drawable.cp_add_icon);
    }

    @Nullable
    public final Integer spaceRelationIcon20(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_no_bind_love);
                }
                return Integer.valueOf(R.drawable.bestie_no_bind_love);
            }
            return Integer.valueOf(R.drawable.soul_no_bind_love);
        }
        return Integer.valueOf(R.drawable.cp_no_bind_love);
    }

    @Nullable
    public final Integer spaceRelationIcon3(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_name_line);
                }
                return Integer.valueOf(R.drawable.bestie_name_line);
            }
            return Integer.valueOf(R.drawable.soul_name_line);
        }
        return Integer.valueOf(R.drawable.cp_name_line);
    }

    @Nullable
    public final Integer spaceRelationIcon4(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_space_bind_bg);
                }
                return Integer.valueOf(R.drawable.bestie_space_bind_bg);
            }
            return Integer.valueOf(R.drawable.soul_space_bind_bg);
        }
        return Integer.valueOf(R.drawable.cp_space_bind_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon5(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_day_line);
                }
                return Integer.valueOf(R.drawable.bestie_day_line);
            }
            return Integer.valueOf(R.drawable.soul_day_line);
        }
        return Integer.valueOf(R.drawable.cp_day_line);
    }

    @Nullable
    public final Integer spaceRelationIcon6(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_stage_bg);
                }
                return Integer.valueOf(R.drawable.bestie_stage_bg);
            }
            return Integer.valueOf(R.drawable.soul_stage_bg);
        }
        return Integer.valueOf(R.drawable.cp_stage_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon7(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_time_bg);
                }
                return Integer.valueOf(R.drawable.bestie_time_bg);
            }
            return Integer.valueOf(R.drawable.soul_time_bg);
        }
        return Integer.valueOf(R.drawable.cp_time_bg);
    }

    @Nullable
    public final Integer spaceRelationIcon8(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.shape_8d3727_bord_2dp);
                }
                return Integer.valueOf(R.drawable.shape_f881ff_bord_2dp);
            }
            return Integer.valueOf(R.drawable.shape_59c6ff_bord_2dp);
        }
        return Integer.valueOf(R.drawable.shape_ff819f_bord_2dp);
    }

    @Nullable
    public final Integer spaceRelationIcon9(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.shape_391a10_bord_1dp);
                }
                return Integer.valueOf(R.drawable.shape_e373ff_bord_1dp);
            }
            return Integer.valueOf(R.drawable.shape_59c6ff_bord_1dp);
        }
        return Integer.valueOf(R.drawable.shape_ff7395_bord_1dp);
    }

    @Nullable
    public final Integer spaceRelationLeftOrRight(int relationType, boolean isLeft, boolean isDefault) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    if (isLeft) {
                        if (isDefault) {
                            i13 = R.drawable.brother_left_icon_no;
                        } else {
                            i13 = R.drawable.brother_left_icon;
                        }
                    } else if (isDefault) {
                        i13 = R.drawable.brother_right_icon_no;
                    } else {
                        i13 = R.drawable.brother_right_icon;
                    }
                    return Integer.valueOf(i13);
                }
                if (isLeft) {
                    if (isDefault) {
                        i12 = R.drawable.bestie_left_icon_no;
                    } else {
                        i12 = R.drawable.bestie_left_icon;
                    }
                } else if (isDefault) {
                    i12 = R.drawable.bestie_right_icon_no;
                } else {
                    i12 = R.drawable.bestie_right_icon;
                }
                return Integer.valueOf(i12);
            }
            if (isLeft) {
                if (isDefault) {
                    i11 = R.drawable.soul_left_icon_no;
                } else {
                    i11 = R.drawable.soul_left_icon;
                }
            } else if (isDefault) {
                i11 = R.drawable.soul_right_icon_no;
            } else {
                i11 = R.drawable.soul_right_icon;
            }
            return Integer.valueOf(i11);
        }
        if (isLeft) {
            if (isDefault) {
                i10 = R.drawable.cp_left_icon_no;
            } else {
                i10 = R.drawable.cp_left_icon;
            }
        } else if (isDefault) {
            i10 = R.drawable.cp_right_icon_no;
        } else {
            i10 = R.drawable.cp_right_icon;
        }
        return Integer.valueOf(i10);
    }

    public final int spaceRelationLevelTextColor(int relationType, boolean isSelect) {
        String str;
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        if (isSelect) {
                            return Color.parseColor("#fff9d0");
                        }
                        return Color.parseColor("#ff4a70");
                    }
                    if (isSelect) {
                        return Color.parseColor("#FFF9D0");
                    }
                    return Color.parseColor("#F56059");
                }
                if (isSelect) {
                    return Color.parseColor("#FFF9D0");
                }
                return Color.parseColor("#E932FF");
            }
            if (isSelect) {
                str = "#FFFFFF";
            } else {
                str = "#308BE1";
            }
            return Color.parseColor(str);
        }
        if (isSelect) {
            return Color.parseColor("#fff9d0");
        }
        return Color.parseColor("#ff4a70");
    }

    public final int spaceRelationMyCpColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#ffffff");
                    }
                    return Color.parseColor("#ffffff");
                }
                return Color.parseColor("#ffffff");
            }
            return Color.parseColor("#ffffff");
        }
        return Color.parseColor("#ffffff");
    }

    public final int spaceRelationPointNumberColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#fffc9f");
                    }
                    return Color.parseColor("#fffc9f");
                }
                return Color.parseColor("#fffc9f");
            }
            return Color.parseColor("#fffc9f");
        }
        return Color.parseColor("#fffc9f");
    }

    public final int spaceRelationPointTipColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#FFFFFF");
                    }
                    return Color.parseColor("#FFFFFF");
                }
                return Color.parseColor("#FFFFFF");
            }
            return Color.parseColor("#FFFFFF");
        }
        return Color.parseColor("#FFFFFF");
    }

    public final int spaceRelationPrivilegeTitleColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#FFFC9F");
                    }
                    return Color.parseColor("#FFFC9F");
                }
                return Color.parseColor("#FFFC9F");
            }
            return Color.parseColor("#FFFC9F");
        }
        return Color.parseColor("#fffc9f");
    }

    public final int spaceRelationTimeColor(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return Color.parseColor("#ffffff");
                    }
                    return Color.parseColor("#ffffff");
                }
                return Color.parseColor("#ffffff");
            }
            return Color.parseColor("#ffffff");
        }
        return Color.parseColor("#ffffff");
    }

    @Nullable
    public final Integer spaceRelationTobBg(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_top_bg);
                }
                return Integer.valueOf(R.drawable.bestie_top_bg);
            }
            return Integer.valueOf(R.drawable.soul_top_bg);
        }
        return Integer.valueOf(R.drawable.cp_top_bg);
    }

    @Nullable
    public final Integer spaceRelationUnbinding(int relationType) {
        if (relationType != 1) {
            if (relationType != 2) {
                if (relationType != 3) {
                    if (relationType != 4) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.brother_space_empty_avatar);
                }
                return Integer.valueOf(R.drawable.bestie_space_empty_avatar);
            }
            return Integer.valueOf(R.drawable.soul_space_empty_avatar);
        }
        return Integer.valueOf(R.drawable.cp_space_empty_avatar);
    }
}
