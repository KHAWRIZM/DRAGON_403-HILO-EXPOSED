package com.qiahao.nextvideo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.databinding.g;
import androidx.transition.x;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewCpLevelBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\nJ\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u0010J\u0010\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\nH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\nH\u0002J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/view/CpLevelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewCpLevelBinding;", "mCurrentLevel", "isMyCp", "", "mSelect", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "mRelationType", "init", "changeSelect", "refreshText", "changeLevel", "level", "myCp", "getLevelId", "getLevelText", "Landroid/widget/TextView;", "getLevelImage", "Landroid/widget/ImageView;", "setRelationType", CpSpaceActivity.RELATION_TYPE, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpLevelView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpLevelView.kt\ncom/qiahao/nextvideo/view/CpLevelView\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n61#2,9:190\n61#2,9:199\n1#3:208\n*S KotlinDebug\n*F\n+ 1 CpLevelView.kt\ncom/qiahao/nextvideo/view/CpLevelView\n*L\n60#1:190,9\n67#1:199,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpLevelView extends FrameLayout {

    @Nullable
    private ViewCpLevelBinding binding;
    private boolean isMyCp;

    @Nullable
    private Function1<? super Integer, Unit> listener;
    private int mCurrentLevel;
    private int mRelationType;
    private int mSelect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpLevelView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelect = -1;
        this.mRelationType = 1;
        init();
    }

    public static /* synthetic */ void changeLevel$default(CpLevelView cpLevelView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        cpLevelView.changeLevel(i, z);
    }

    private final int getLevelId(int level) {
        switch (level) {
            case 0:
                return R.id.level0;
            case 1:
                return R.id.level1;
            case 2:
                return R.id.level2;
            case 3:
                return R.id.level3;
            case 4:
                return R.id.level4;
            case 5:
                return R.id.level5;
            case 6:
                return R.id.level6;
            case 7:
            default:
                return R.id.level7;
        }
    }

    private final ImageView getLevelImage(int level) {
        switch (level) {
            case 0:
                ViewCpLevelBinding viewCpLevelBinding = this.binding;
                if (viewCpLevelBinding == null) {
                    return null;
                }
                return viewCpLevelBinding.level0;
            case 1:
                ViewCpLevelBinding viewCpLevelBinding2 = this.binding;
                if (viewCpLevelBinding2 == null) {
                    return null;
                }
                return viewCpLevelBinding2.level1;
            case 2:
                ViewCpLevelBinding viewCpLevelBinding3 = this.binding;
                if (viewCpLevelBinding3 == null) {
                    return null;
                }
                return viewCpLevelBinding3.level2;
            case 3:
                ViewCpLevelBinding viewCpLevelBinding4 = this.binding;
                if (viewCpLevelBinding4 == null) {
                    return null;
                }
                return viewCpLevelBinding4.level3;
            case 4:
                ViewCpLevelBinding viewCpLevelBinding5 = this.binding;
                if (viewCpLevelBinding5 == null) {
                    return null;
                }
                return viewCpLevelBinding5.level4;
            case 5:
                ViewCpLevelBinding viewCpLevelBinding6 = this.binding;
                if (viewCpLevelBinding6 == null) {
                    return null;
                }
                return viewCpLevelBinding6.level5;
            case 6:
                ViewCpLevelBinding viewCpLevelBinding7 = this.binding;
                if (viewCpLevelBinding7 == null) {
                    return null;
                }
                return viewCpLevelBinding7.level6;
            case 7:
                ViewCpLevelBinding viewCpLevelBinding8 = this.binding;
                if (viewCpLevelBinding8 == null) {
                    return null;
                }
                return viewCpLevelBinding8.level7;
            default:
                ViewCpLevelBinding viewCpLevelBinding9 = this.binding;
                if (viewCpLevelBinding9 == null) {
                    return null;
                }
                return viewCpLevelBinding9.level7;
        }
    }

    private final TextView getLevelText(int level) {
        switch (level) {
            case 0:
                ViewCpLevelBinding viewCpLevelBinding = this.binding;
                if (viewCpLevelBinding == null) {
                    return null;
                }
                return viewCpLevelBinding.levelText0;
            case 1:
                ViewCpLevelBinding viewCpLevelBinding2 = this.binding;
                if (viewCpLevelBinding2 == null) {
                    return null;
                }
                return viewCpLevelBinding2.levelText1;
            case 2:
                ViewCpLevelBinding viewCpLevelBinding3 = this.binding;
                if (viewCpLevelBinding3 == null) {
                    return null;
                }
                return viewCpLevelBinding3.levelText2;
            case 3:
                ViewCpLevelBinding viewCpLevelBinding4 = this.binding;
                if (viewCpLevelBinding4 == null) {
                    return null;
                }
                return viewCpLevelBinding4.levelText3;
            case 4:
                ViewCpLevelBinding viewCpLevelBinding5 = this.binding;
                if (viewCpLevelBinding5 == null) {
                    return null;
                }
                return viewCpLevelBinding5.levelText4;
            case 5:
                ViewCpLevelBinding viewCpLevelBinding6 = this.binding;
                if (viewCpLevelBinding6 == null) {
                    return null;
                }
                return viewCpLevelBinding6.levelText5;
            case 6:
                ViewCpLevelBinding viewCpLevelBinding7 = this.binding;
                if (viewCpLevelBinding7 == null) {
                    return null;
                }
                return viewCpLevelBinding7.levelText6;
            case 7:
                ViewCpLevelBinding viewCpLevelBinding8 = this.binding;
                if (viewCpLevelBinding8 == null) {
                    return null;
                }
                return viewCpLevelBinding8.levelText7;
            default:
                ViewCpLevelBinding viewCpLevelBinding9 = this.binding;
                if (viewCpLevelBinding9 == null) {
                    return null;
                }
                return viewCpLevelBinding9.levelText7;
        }
    }

    private final void init() {
        this.binding = (ViewCpLevelBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_cp_level, this, true);
        changeLevel$default(this, 0, false, 2, null);
        for (int i = 0; i < 8; i++) {
            final TextView levelText = getLevelText(i);
            if (levelText != null) {
                final long j = 800;
                final int i2 = i;
                levelText.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.CpLevelView$init$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        boolean z;
                        int i3;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(levelText) > j || (levelText instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(levelText, currentTimeMillis);
                            z = this.isMyCp;
                            if (z) {
                                this.mSelect = i2;
                                this.refreshText();
                                Function1<Integer, Unit> listener = this.getListener();
                                if (listener != null) {
                                    i3 = this.mSelect;
                                    listener.invoke(Integer.valueOf(i3));
                                }
                            }
                        }
                    }
                });
            }
            final ImageView levelImage = getLevelImage(i);
            if (levelImage != null) {
                final long j2 = 800;
                final int i3 = i;
                levelImage.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.CpLevelView$init$$inlined$singleClick$default$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        boolean z;
                        int i4;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(levelImage) > j2 || (levelImage instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(levelImage, currentTimeMillis);
                            z = this.isMyCp;
                            if (z) {
                                this.mSelect = i3;
                                this.refreshText();
                                Function1<Integer, Unit> listener = this.getListener();
                                if (listener != null) {
                                    i4 = this.mSelect;
                                    listener.invoke(Integer.valueOf(i4));
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshText() {
        boolean z;
        Drawable drawable;
        boolean z2;
        for (int i = 0; i < 8; i++) {
            TextView levelText = getLevelText(i);
            if (levelText != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131952422), Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                levelText.setText(format);
            }
            if (this.isMyCp && this.mCurrentLevel != i) {
                TextView levelText2 = getLevelText(i);
                if (levelText2 != null) {
                    levelText2.setVisibility(0);
                }
            } else {
                TextView levelText3 = getLevelText(i);
                if (levelText3 != null) {
                    levelText3.setVisibility(8);
                }
            }
            TextView levelText4 = getLevelText(i);
            if (levelText4 != null) {
                RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
                int i2 = this.mRelationType;
                if (this.mSelect == i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                levelText4.setTextColor(relationTypeUtils.spaceRelationLevelTextColor(i2, z2));
            }
            ImageView levelImage = getLevelImage(i);
            if (levelImage != null) {
                RelationTypeUtils relationTypeUtils2 = RelationTypeUtils.INSTANCE;
                int i3 = this.mRelationType;
                if (this.mSelect == i) {
                    z = true;
                } else {
                    z = false;
                }
                Integer spaceRelationIcon16 = relationTypeUtils2.spaceRelationIcon16(i3, z);
                if (spaceRelationIcon16 != null) {
                    drawable = androidx.core.content.a.getDrawable(getContext(), spaceRelationIcon16.intValue());
                } else {
                    drawable = null;
                }
                levelImage.setImageDrawable(drawable);
            }
        }
    }

    public final void changeLevel(int level, boolean myCp) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        TextView textView;
        this.isMyCp = myCp;
        this.mCurrentLevel = level;
        ViewCpLevelBinding viewCpLevelBinding = this.binding;
        if (viewCpLevelBinding != null && (textView = viewCpLevelBinding.currentLevel) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952422), Arrays.copyOf(new Object[]{Integer.valueOf(level)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        int levelId = getLevelId(level);
        c cVar = new c();
        ViewCpLevelBinding viewCpLevelBinding2 = this.binding;
        ConstraintLayout constraintLayout3 = null;
        if (viewCpLevelBinding2 != null) {
            constraintLayout = viewCpLevelBinding2.rootLayout;
        } else {
            constraintLayout = null;
        }
        cVar.o(constraintLayout);
        cVar.r(R.id.currentLevel, 3, levelId, 3);
        cVar.r(R.id.currentLevel, 4, levelId, 4);
        cVar.r(R.id.currentLevel, 6, levelId, 6);
        cVar.r(R.id.currentLevel, 7, levelId, 7);
        ViewCpLevelBinding viewCpLevelBinding3 = this.binding;
        if (viewCpLevelBinding3 != null && (constraintLayout2 = viewCpLevelBinding3.rootLayout) != null) {
            x.a(constraintLayout2);
        }
        ViewCpLevelBinding viewCpLevelBinding4 = this.binding;
        if (viewCpLevelBinding4 != null) {
            constraintLayout3 = viewCpLevelBinding4.rootLayout;
        }
        cVar.i(constraintLayout3);
        refreshText();
    }

    public final void changeSelect(int position) {
        if (position > 7) {
            return;
        }
        this.mSelect = position;
        refreshText();
    }

    @Nullable
    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    public final void setRelationType(int relationType) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Drawable drawable;
        View view;
        Drawable drawable2;
        this.mRelationType = relationType;
        refreshText();
        ViewCpLevelBinding viewCpLevelBinding = this.binding;
        Drawable drawable3 = null;
        if (viewCpLevelBinding != null && (view = viewCpLevelBinding.levelBg) != null) {
            Integer spaceRelationIcon15 = RelationTypeUtils.INSTANCE.spaceRelationIcon15(this.mRelationType);
            if (spaceRelationIcon15 != null) {
                drawable2 = androidx.core.content.a.getDrawable(getContext(), spaceRelationIcon15.intValue());
            } else {
                drawable2 = null;
            }
            view.setBackground(drawable2);
        }
        ViewCpLevelBinding viewCpLevelBinding2 = this.binding;
        if (viewCpLevelBinding2 != null && (textView3 = viewCpLevelBinding2.currentLevel) != null) {
            Integer spaceRelationIcon17 = RelationTypeUtils.INSTANCE.spaceRelationIcon17(this.mRelationType);
            if (spaceRelationIcon17 != null) {
                drawable = androidx.core.content.a.getDrawable(getContext(), spaceRelationIcon17.intValue());
            } else {
                drawable = null;
            }
            textView3.setBackground(drawable);
        }
        ViewCpLevelBinding viewCpLevelBinding3 = this.binding;
        if (viewCpLevelBinding3 != null && (textView2 = viewCpLevelBinding3.currentLevel) != null) {
            textView2.setTextColor(RelationTypeUtils.INSTANCE.spaceRelationCurrentLevelColor(this.mRelationType));
        }
        ViewCpLevelBinding viewCpLevelBinding4 = this.binding;
        if (viewCpLevelBinding4 != null && (textView = viewCpLevelBinding4.currentLevelTip) != null) {
            Integer spaceRelationIcon18 = RelationTypeUtils.INSTANCE.spaceRelationIcon18(this.mRelationType);
            if (spaceRelationIcon18 != null) {
                drawable3 = androidx.core.content.a.getDrawable(getContext(), spaceRelationIcon18.intValue());
            }
            textView.setBackground(drawable3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpLevelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelect = -1;
        this.mRelationType = 1;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpLevelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelect = -1;
        this.mRelationType = 1;
        init();
    }
}
