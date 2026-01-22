package com.qiahao.nextvideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.g;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.BoxLevel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKScore;
import com.qiahao.nextvideo.data.room.RoomPKScoreRes;
import com.qiahao.nextvideo.databinding.IncludePkLevelBinding;
import com.qiahao.nextvideo.databinding.ViewLevelPkBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/view/PKLevelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewLevelPkBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewLevelPkBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewLevelPkBinding;)V", "mWidth", "initView", "", "refreshLevel", "changeProgress", "progress", "", "refreshLevelView", "viewBinding", "Lcom/qiahao/nextvideo/databinding/IncludePkLevelBinding;", "isHighlight", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKLevelView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKLevelView.kt\ncom/qiahao/nextvideo/view/PKLevelView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1869#2,2:144\n1878#2,2:146\n1880#2:149\n1#3:148\n*S KotlinDebug\n*F\n+ 1 PKLevelView.kt\ncom/qiahao/nextvideo/view/PKLevelView\n*L\n58#1:144,2\n61#1:146,2\n61#1:149\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKLevelView extends FrameLayout {

    @Nullable
    private ViewLevelPkBinding binding;
    private final int mWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKLevelView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void changeProgress(double progress) {
        int i;
        View view;
        ViewGroup.LayoutParams layoutParams;
        View view2;
        View view3;
        View view4;
        if (progress <= 0.0d) {
            i = 0;
        } else if (progress >= 1.0d) {
            i = this.mWidth;
        } else {
            double d = progress * this.mWidth;
            if (d < 1.0d) {
                i = 1;
            } else {
                i = (int) d;
            }
        }
        if (i > 0) {
            ViewLevelPkBinding viewLevelPkBinding = this.binding;
            if (viewLevelPkBinding != null && (view4 = viewLevelPkBinding.progress) != null) {
                view4.setVisibility(0);
            }
            ViewLevelPkBinding viewLevelPkBinding2 = this.binding;
            if (viewLevelPkBinding2 != null && (view3 = viewLevelPkBinding2.progress) != null) {
                layoutParams = view3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).width = i;
            ViewLevelPkBinding viewLevelPkBinding3 = this.binding;
            if (viewLevelPkBinding3 != null && (view2 = viewLevelPkBinding3.progress) != null) {
                view2.setLayoutParams(bVar);
                return;
            }
            return;
        }
        ViewLevelPkBinding viewLevelPkBinding4 = this.binding;
        if (viewLevelPkBinding4 != null && (view = viewLevelPkBinding4.progress) != null) {
            view.setVisibility(8);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void initView() {
        View view;
        View view2;
        ViewLevelPkBinding viewLevelPkBinding = (ViewLevelPkBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_level_pk, this, true);
        this.binding = viewLevelPkBinding;
        if (viewLevelPkBinding != null && (view2 = viewLevelPkBinding.progress) != null) {
            view2.setBackground(ShapeUtil.INSTANCE.createShape("#FFC507", "#EAFCAA", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        ViewLevelPkBinding viewLevelPkBinding2 = this.binding;
        if (viewLevelPkBinding2 != null && (view = viewLevelPkBinding2.progressBg) != null) {
            view.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 6, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        refreshLevel();
    }

    private final void refreshLevelView(IncludePkLevelBinding viewBinding, boolean isHighlight) {
        if (isHighlight) {
            viewBinding.levelTitle.setTextColor(Color.parseColor("#EAFCAA"));
            viewBinding.levelDiamond.setTextColor(Color.parseColor("#EAFCAA"));
            viewBinding.centerView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#CB672A", "#CB672A", 9, (GradientDrawable.Orientation) null, 8, (Object) null));
        } else {
            viewBinding.levelTitle.setTextColor(Color.parseColor("#FCAAC0"));
            viewBinding.levelDiamond.setTextColor(Color.parseColor("#FCAAC0"));
            viewBinding.centerView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ccffffff", "#ccffffff", 9, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
    }

    @Nullable
    public final ViewLevelPkBinding getBinding() {
        return this.binding;
    }

    public final void refreshLevel() {
        double d;
        float f;
        float f2;
        IncludePkLevelBinding includePkLevelBinding;
        long j;
        IncludePkLevelBinding includePkLevelBinding2;
        TextView textView;
        long j2;
        IncludePkLevelBinding includePkLevelBinding3;
        TextView textView2;
        IncludePkLevelBinding includePkLevelBinding4;
        long j3;
        IncludePkLevelBinding includePkLevelBinding5;
        TextView textView3;
        long j4;
        IncludePkLevelBinding includePkLevelBinding6;
        TextView textView4;
        IncludePkLevelBinding includePkLevelBinding7;
        long j5;
        IncludePkLevelBinding includePkLevelBinding8;
        TextView textView5;
        long j6;
        IncludePkLevelBinding includePkLevelBinding9;
        TextView textView6;
        RoomPKScoreRes roomPKPro;
        ArrayList<RoomPKScore> scoreInfo;
        long j7;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && (roomPKPro = mpk.getRoomPKPro()) != null && (scoreInfo = roomPKPro.getScoreInfo()) != null) {
            Iterator<T> it = scoreInfo.iterator();
            d = 0.0d;
            while (it.hasNext()) {
                Long score = ((RoomPKScore) it.next()).getScore();
                if (score != null) {
                    j7 = score.longValue();
                } else {
                    j7 = 0;
                }
                d += j7;
            }
        } else {
            d = 0.0d;
        }
        Iterator<T> it2 = MeetingRoomManager.INSTANCE.getMBoxLevel().iterator();
        int i = 0;
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BoxLevel boxLevel = (BoxLevel) next;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ViewLevelPkBinding viewLevelPkBinding = this.binding;
                        if (viewLevelPkBinding != null && (includePkLevelBinding9 = viewLevelPkBinding.threeLevel) != null && (textView6 = includePkLevelBinding9.levelTitle) != null) {
                            textView6.setText("Lv.3");
                        }
                        ViewLevelPkBinding viewLevelPkBinding2 = this.binding;
                        if (viewLevelPkBinding2 != null && (includePkLevelBinding8 = viewLevelPkBinding2.threeLevel) != null && (textView5 = includePkLevelBinding8.levelDiamond) != null) {
                            Long diamond = boxLevel.getDiamond();
                            if (diamond != null) {
                                j6 = diamond.longValue();
                            } else {
                                j6 = 0;
                            }
                            textView5.setText(NumberUtilsKt.rankNumberFormat(j6));
                        }
                        ViewLevelPkBinding viewLevelPkBinding3 = this.binding;
                        if (viewLevelPkBinding3 != null && (includePkLevelBinding7 = viewLevelPkBinding3.threeLevel) != null) {
                            Long diamond2 = boxLevel.getDiamond();
                            if (diamond2 != null) {
                                j5 = diamond2.longValue();
                            } else {
                                j5 = 0;
                            }
                            if (d < j5) {
                                z = false;
                            }
                            refreshLevelView(includePkLevelBinding7, z);
                        }
                    }
                } else {
                    ViewLevelPkBinding viewLevelPkBinding4 = this.binding;
                    if (viewLevelPkBinding4 != null && (includePkLevelBinding6 = viewLevelPkBinding4.twoLevel) != null && (textView4 = includePkLevelBinding6.levelTitle) != null) {
                        textView4.setText("Lv.2");
                    }
                    ViewLevelPkBinding viewLevelPkBinding5 = this.binding;
                    if (viewLevelPkBinding5 != null && (includePkLevelBinding5 = viewLevelPkBinding5.twoLevel) != null && (textView3 = includePkLevelBinding5.levelDiamond) != null) {
                        Long diamond3 = boxLevel.getDiamond();
                        if (diamond3 != null) {
                            j4 = diamond3.longValue();
                        } else {
                            j4 = 0;
                        }
                        textView3.setText(NumberUtilsKt.rankNumberFormat(j4));
                    }
                    ViewLevelPkBinding viewLevelPkBinding6 = this.binding;
                    if (viewLevelPkBinding6 != null && (includePkLevelBinding4 = viewLevelPkBinding6.twoLevel) != null) {
                        Long diamond4 = boxLevel.getDiamond();
                        if (diamond4 != null) {
                            j3 = diamond4.longValue();
                        } else {
                            j3 = 0;
                        }
                        if (d < j3) {
                            z = false;
                        }
                        refreshLevelView(includePkLevelBinding4, z);
                    }
                }
            } else {
                ViewLevelPkBinding viewLevelPkBinding7 = this.binding;
                if (viewLevelPkBinding7 != null && (includePkLevelBinding3 = viewLevelPkBinding7.oneLevel) != null && (textView2 = includePkLevelBinding3.levelTitle) != null) {
                    textView2.setText("Lv.1");
                }
                ViewLevelPkBinding viewLevelPkBinding8 = this.binding;
                if (viewLevelPkBinding8 != null && (includePkLevelBinding2 = viewLevelPkBinding8.oneLevel) != null && (textView = includePkLevelBinding2.levelDiamond) != null) {
                    Long diamond5 = boxLevel.getDiamond();
                    if (diamond5 != null) {
                        j2 = diamond5.longValue();
                    } else {
                        j2 = 0;
                    }
                    textView.setText(NumberUtilsKt.rankNumberFormat(j2));
                }
                ViewLevelPkBinding viewLevelPkBinding9 = this.binding;
                if (viewLevelPkBinding9 != null && (includePkLevelBinding = viewLevelPkBinding9.oneLevel) != null) {
                    Long diamond6 = boxLevel.getDiamond();
                    if (diamond6 != null) {
                        j = diamond6.longValue();
                    } else {
                        j = 0;
                    }
                    if (d < j) {
                        z = false;
                    }
                    refreshLevelView(includePkLevelBinding, z);
                }
            }
            i = i2;
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMBoxLevel().size() < 3) {
            changeProgress(0.0d);
            return;
        }
        Long diamond7 = meetingRoomManager.getMBoxLevel().get(0).getDiamond();
        float f3 = 0.0f;
        if (diamond7 != null) {
            f = (float) diamond7.longValue();
        } else {
            f = 0.0f;
        }
        Long diamond8 = meetingRoomManager.getMBoxLevel().get(1).getDiamond();
        if (diamond8 != null) {
            f2 = (float) diamond8.longValue();
        } else {
            f2 = 0.0f;
        }
        Long diamond9 = meetingRoomManager.getMBoxLevel().get(2).getDiamond();
        if (diamond9 != null) {
            f3 = (float) diamond9.longValue();
        }
        double d2 = f;
        if (d < d2) {
            changeProgress((d / d2) / 11);
            return;
        }
        if (d >= d2) {
            double d3 = f2;
            if (d < d3) {
                changeProgress(((((d - d2) / d3) / 11) * 5) + 0.09f);
                return;
            }
        }
        double d4 = f2;
        if (d >= d4) {
            double d5 = f3;
            if (d < d5) {
                changeProgress(((((d - d4) / d5) / 11) * 5) + 0.5f);
                return;
            }
        }
        changeProgress(d / f3);
    }

    public final void setBinding(@Nullable ViewLevelPkBinding viewLevelPkBinding) {
        this.binding = viewLevelPkBinding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKLevelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKLevelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mWidth = UiKtxKt.toPX(UserProxyUtility.h5GameVoice);
        initView();
    }
}
