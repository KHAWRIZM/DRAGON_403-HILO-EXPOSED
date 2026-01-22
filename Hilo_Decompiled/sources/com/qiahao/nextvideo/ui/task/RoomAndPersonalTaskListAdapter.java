package com.qiahao.nextvideo.ui.task;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ScoreStageListBean;
import com.qiahao.nextvideo.data.model.TasksListBean;
import com.qiahao.nextvideo.databinding.ItemRoomPersonalTaskListAdapterBinding;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0014J\u001e\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0015J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u000fRL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/TasksListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomPersonalTaskListAdapterBinding;", "layout", "", "<init>", "(I)V", "onGoBtnClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "position", "", "getOnGoBtnClick", "()Lkotlin/jvm/functions/Function2;", "setOnGoBtnClick", "(Lkotlin/jvm/functions/Function2;)V", "rewardDiamonds", "", "getRewardDiamonds", "()J", "setRewardDiamonds", "(J)V", "animatorSet", "Landroid/animation/AnimatorSet;", "convert", "holder", "payloads", "", "", "startAnimation", "view", "Landroid/view/View;", "clearAnimation", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomAndPersonalTaskListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomAndPersonalTaskListAdapter.kt\ncom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,295:1\n1869#2,2:296\n1878#2,3:310\n439#3:298\n439#3:299\n439#3:300\n61#4,9:301\n*S KotlinDebug\n*F\n+ 1 RoomAndPersonalTaskListAdapter.kt\ncom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskListAdapter\n*L\n49#1:296,2\n287#1:310,3\n93#1:298\n103#1:299\n108#1:300\n113#1:301,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAndPersonalTaskListAdapter extends BaseQuickAdapter<TasksListBean, BaseDataBindingHolder<ItemRoomPersonalTaskListAdapterBinding>> {

    @NotNull
    public static final String TASK_START_ANIMATION = "taskStartAnimation";

    @Nullable
    private AnimatorSet animatorSet;

    @Nullable
    private Function2<? super TasksListBean, ? super Integer, Unit> onGoBtnClick;
    private long rewardDiamonds;

    public RoomAndPersonalTaskListAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$19$lambda$3$lambda$2(ItemRoomPersonalTaskListAdapterBinding itemRoomPersonalTaskListAdapterBinding, ScoreStageListBean scoreStageListBean, TasksListBean tasksListBean) {
        if (itemRoomPersonalTaskListAdapterBinding.taskProgress.getWidth() > 0) {
            int score = (int) ((((float) scoreStageListBean.getScore()) / ((float) tasksListBean.getTotalScore())) * itemRoomPersonalTaskListAdapterBinding.taskProgress.getWidth());
            Dimens dimens = Dimens.INSTANCE;
            int dpToPx = score - (dimens.dpToPx(12) / 2);
            Log.e("progressWidth", String.valueOf(dpToPx));
            ConstraintLayout.b layoutParams = itemRoomPersonalTaskListAdapterBinding.startDotView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams;
            if (dpToPx <= 0) {
                dpToPx = dimens.dpToPx(1);
            }
            bVar.setMarginStart(dpToPx);
            itemRoomPersonalTaskListAdapterBinding.startDotView.setLayoutParams(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$19$lambda$6$lambda$5(ItemRoomPersonalTaskListAdapterBinding itemRoomPersonalTaskListAdapterBinding, ScoreStageListBean scoreStageListBean, TasksListBean tasksListBean) {
        if (itemRoomPersonalTaskListAdapterBinding.taskProgress.getWidth() > 0) {
            int score = (int) ((((float) scoreStageListBean.getScore()) / ((float) tasksListBean.getTotalScore())) * itemRoomPersonalTaskListAdapterBinding.taskProgress.getWidth());
            Dimens dimens = Dimens.INSTANCE;
            int dpToPx = score - (dimens.dpToPx(12) / 2);
            ConstraintLayout.b layoutParams = itemRoomPersonalTaskListAdapterBinding.centerDotView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams;
            if (dpToPx <= 0) {
                dpToPx = dimens.dpToPx(1);
            }
            bVar.setMarginStart(dpToPx);
            itemRoomPersonalTaskListAdapterBinding.centerDotView.setLayoutParams(bVar);
        }
    }

    private final void startAnimation(final View view) {
        clearAnimation();
        this.animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationUtilitiesKt.propertyNameInScaleY, 1.0f, 1.5f);
        ofFloat.setDuration(50L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationUtilitiesKt.propertyNameInScaleX, 1.0f, 1.5f);
        ofFloat2.setDuration(50L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 100.0f, -50.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setDuration(800L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(50L);
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.setDuration(800L);
        }
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        }
        AnimatorSet animatorSet3 = this.animatorSet;
        if (animatorSet3 != null) {
            animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskListAdapter$startAnimation$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    view.setVisibility(8);
                    this.clearAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    view.setVisibility(0);
                }
            });
        }
        AnimatorSet animatorSet4 = this.animatorSet;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    public final void clearAnimation() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            ArrayList<Animator> childAnimations = animatorSet.getChildAnimations();
            Intrinsics.checkNotNullExpressionValue(childAnimations, "getChildAnimations(...)");
            if (!childAnimations.isEmpty()) {
                ArrayList<Animator> childAnimations2 = animatorSet.getChildAnimations();
                Intrinsics.checkNotNullExpressionValue(childAnimations2, "getChildAnimations(...)");
                int i = 0;
                for (Object obj : childAnimations2) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((Animator) obj).cancel();
                    i = i2;
                }
            }
            animatorSet.removeAllListeners();
        }
        this.animatorSet = null;
    }

    @Nullable
    public final Function2<TasksListBean, Integer, Unit> getOnGoBtnClick() {
        return this.onGoBtnClick;
    }

    public final long getRewardDiamonds() {
        return this.rewardDiamonds;
    }

    public final void setOnGoBtnClick(@Nullable Function2<? super TasksListBean, ? super Integer, Unit> function2) {
        this.onGoBtnClick = function2;
    }

    public final void setRewardDiamonds(long j) {
        this.rewardDiamonds = j;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemRoomPersonalTaskListAdapterBinding>) baseViewHolder, (TasksListBean) obj, (List<? extends Object>) list);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemRoomPersonalTaskListAdapterBinding> holder, @NotNull TasksListBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.convert(holder, item, payloads);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomPersonalTaskListAdapterBinding");
        ItemRoomPersonalTaskListAdapterBinding itemRoomPersonalTaskListAdapterBinding = (ItemRoomPersonalTaskListAdapterBinding) dataBinding;
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), TASK_START_ANIMATION)) {
                long j = this.rewardDiamonds;
                if (j > 0) {
                    itemRoomPersonalTaskListAdapterBinding.animDiamond.setText("+" + NumberUtilsKt.rankNumberFormat(j));
                    TextView textView = itemRoomPersonalTaskListAdapterBinding.animDiamond;
                    Intrinsics.checkNotNullExpressionValue(textView, "animDiamond");
                    startAnimation(textView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f6  */
    @SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convert(@NotNull final BaseDataBindingHolder<ItemRoomPersonalTaskListAdapterBinding> holder, @NotNull final TasksListBean item) {
        ScoreStageListBean scoreStageListBean;
        final ScoreStageListBean scoreStageListBean2;
        int type;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomPersonalTaskListAdapterBinding");
        final ItemRoomPersonalTaskListAdapterBinding itemRoomPersonalTaskListAdapterBinding = (ItemRoomPersonalTaskListAdapterBinding) dataBinding;
        ImageView imageView = itemRoomPersonalTaskListAdapterBinding.ivTaskIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivTaskIcon");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image200(item.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemRoomPersonalTaskListAdapterBinding.tvTaskName.setText(item.getName());
        itemRoomPersonalTaskListAdapterBinding.taskProgress.setEnabled(false);
        if (item.getType() == 3) {
            if (item.getCurrentScore() >= item.getTotalScore()) {
                itemRoomPersonalTaskListAdapterBinding.tvScore.setText("(" + (((float) item.getTotalScore()) / 100.0f) + "/" + (((float) item.getTotalScore()) / 100.0f) + ")");
            } else if (item.getCurrentScore() > 0) {
                itemRoomPersonalTaskListAdapterBinding.tvScore.setText("(" + (((float) item.getCurrentScore()) / 100.0f) + "/" + (((float) item.getTotalScore()) / 100.0f) + ")");
            } else {
                itemRoomPersonalTaskListAdapterBinding.tvScore.setText("(" + item.getCurrentScore() + "/" + (((float) item.getTotalScore()) / 100.0f) + ")");
            }
        } else if (item.getCurrentScore() >= item.getTotalScore()) {
            itemRoomPersonalTaskListAdapterBinding.tvScore.setText("(" + NumberUtilsKt.rankNumberFormat(item.getTotalScore()) + "/" + NumberUtilsKt.rankNumberFormat(item.getTotalScore()) + ")");
        } else {
            itemRoomPersonalTaskListAdapterBinding.tvScore.setText("(" + NumberUtilsKt.rankNumberFormat(item.getCurrentScore()) + "/" + NumberUtilsKt.rankNumberFormat(item.getTotalScore()) + ")");
        }
        int taskStatus = item.getTaskStatus();
        if (taskStatus == 0) {
            itemRoomPersonalTaskListAdapterBinding.goBtn.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8833FF", 13, 1.0f, false, "#FFFFFF", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setTextColor(Color.parseColor("#8833FF"));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setText(ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131952906));
        } else if (taskStatus == 1) {
            itemRoomPersonalTaskListAdapterBinding.goBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#8833FF", "#8833FF", 13, (GradientDrawable.Orientation) null, 8, (Object) null));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setText(ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131952873));
        } else if (taskStatus != 2) {
            itemRoomPersonalTaskListAdapterBinding.goBtn.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8833FF", 13, 1.0f, false, "#FFFFFF", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setTextColor(Color.parseColor("#8833FF"));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setText(ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131952906));
        } else {
            itemRoomPersonalTaskListAdapterBinding.goBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#198833FF", "#198833FF", 13, (GradientDrawable.Orientation) null, 8, (Object) null));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setTextColor(Color.parseColor("#8833FF"));
            itemRoomPersonalTaskListAdapterBinding.goBtn.setText(ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131952587));
        }
        final TextView textView = itemRoomPersonalTaskListAdapterBinding.goBtn;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskListAdapter$convert$lambda$19$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Function2<TasksListBean, Integer, Unit> onGoBtnClick = this.getOnGoBtnClick();
                    if (onGoBtnClick != null) {
                        onGoBtnClick.invoke(item, Integer.valueOf(holder.getAdapterPosition()));
                    }
                }
            }
        });
        List<ScoreStageListBean> scoreStage = item.getScoreStage();
        final ScoreStageListBean scoreStageListBean3 = null;
        if (scoreStage != null && !scoreStage.isEmpty()) {
            if (scoreStage.size() == 1) {
                scoreStageListBean = scoreStage.get(0);
                scoreStageListBean2 = null;
            } else if (scoreStage.size() == 2) {
                ScoreStageListBean scoreStageListBean4 = scoreStage.get(0);
                scoreStageListBean = scoreStage.get(1);
                scoreStageListBean2 = null;
                scoreStageListBean3 = scoreStageListBean4;
            } else if (scoreStage.size() == 3) {
                scoreStageListBean3 = scoreStage.get(0);
                scoreStageListBean2 = scoreStage.get(1);
                scoreStageListBean = scoreStage.get(2);
            }
            if (scoreStageListBean3 == null) {
                itemRoomPersonalTaskListAdapterBinding.startDiamondContainer.setVisibility(0);
                itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setVisibility(0);
                itemRoomPersonalTaskListAdapterBinding.tvStartDiamond.setText("+" + NumberUtilsKt.rankNumberFormat(scoreStageListBean3.getAwardDiamonds()));
                View view = itemRoomPersonalTaskListAdapterBinding.startDotView;
                Intrinsics.checkNotNullExpressionValue(view, "startDotView");
                ViewKtxKt.visibleOrGone(view, true);
                itemRoomPersonalTaskListAdapterBinding.taskProgress.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.task.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomAndPersonalTaskListAdapter.convert$lambda$19$lambda$3$lambda$2(ItemRoomPersonalTaskListAdapterBinding.this, scoreStageListBean3, item);
                    }
                });
                if (item.getCurrentScore() >= scoreStageListBean3.getScore()) {
                    itemRoomPersonalTaskListAdapterBinding.startDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_thumb);
                } else {
                    itemRoomPersonalTaskListAdapterBinding.startDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_end_dot);
                }
            } else {
                itemRoomPersonalTaskListAdapterBinding.startDiamondContainer.setVisibility(4);
                itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setVisibility(4);
                View view2 = itemRoomPersonalTaskListAdapterBinding.startDotView;
                Intrinsics.checkNotNullExpressionValue(view2, "startDotView");
                ViewKtxKt.visibleOrGone(view2, false);
            }
            if (scoreStageListBean2 == null) {
                itemRoomPersonalTaskListAdapterBinding.centerDiamondContainer.setVisibility(0);
                itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setVisibility(0);
                itemRoomPersonalTaskListAdapterBinding.tvCenterDiamond.setText("+" + NumberUtilsKt.rankNumberFormat(scoreStageListBean2.getAwardDiamonds()));
                View view3 = itemRoomPersonalTaskListAdapterBinding.centerDotView;
                Intrinsics.checkNotNullExpressionValue(view3, "centerDotView");
                ViewKtxKt.visibleOrGone(view3, true);
                itemRoomPersonalTaskListAdapterBinding.taskProgress.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.task.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomAndPersonalTaskListAdapter.convert$lambda$19$lambda$6$lambda$5(ItemRoomPersonalTaskListAdapterBinding.this, scoreStageListBean2, item);
                    }
                });
                if (item.getCurrentScore() >= scoreStageListBean2.getScore()) {
                    itemRoomPersonalTaskListAdapterBinding.centerDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_thumb);
                } else {
                    itemRoomPersonalTaskListAdapterBinding.centerDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_end_dot);
                }
            } else {
                itemRoomPersonalTaskListAdapterBinding.centerDiamondContainer.setVisibility(4);
                itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setVisibility(4);
                View view4 = itemRoomPersonalTaskListAdapterBinding.centerDotView;
                Intrinsics.checkNotNullExpressionValue(view4, "centerDotView");
                ViewKtxKt.visibleOrGone(view4, false);
            }
            if (scoreStageListBean != null) {
                itemRoomPersonalTaskListAdapterBinding.tvEndDiamond.setText("+" + NumberUtilsKt.rankNumberFormat(scoreStageListBean.getAwardDiamonds()));
                if (item.getCurrentScore() >= scoreStageListBean.getScore()) {
                    itemRoomPersonalTaskListAdapterBinding.endDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_thumb);
                } else {
                    itemRoomPersonalTaskListAdapterBinding.endDotView.setBackgroundResource(R.drawable.style_room_personal_task_list_seekbar_end_dot);
                }
            }
            itemRoomPersonalTaskListAdapterBinding.taskProgress.setMax(100);
            itemRoomPersonalTaskListAdapterBinding.taskProgress.setProgress((int) ((((float) item.getCurrentScore()) / ((float) item.getTotalScore())) * 100));
            type = item.getType();
            if (type != 1) {
                itemRoomPersonalTaskListAdapterBinding.tvEndTimeText.setText(NumberUtilsKt.rankNumberFormat(item.getTotalScore()) + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954230));
                if (scoreStageListBean3 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setText(NumberUtilsKt.rankNumberFormat(scoreStageListBean3.getScore()) + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954230));
                }
                if (scoreStageListBean2 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setText(NumberUtilsKt.rankNumberFormat(scoreStageListBean2.getScore()) + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954230));
                    return;
                }
                return;
            }
            if (type == 2) {
                itemRoomPersonalTaskListAdapterBinding.tvEndTimeText.setText(item.getTotalScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954231));
                if (scoreStageListBean3 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setText(scoreStageListBean3.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954231));
                }
                if (scoreStageListBean2 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setText(scoreStageListBean2.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954231));
                    return;
                }
                return;
            }
            if (type == 3) {
                itemRoomPersonalTaskListAdapterBinding.tvEndTimeText.setText("$ " + (((float) item.getTotalScore()) / 100.0f));
                if (scoreStageListBean3 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setText("$ " + (((float) scoreStageListBean3.getScore()) / 100.0f));
                }
                if (scoreStageListBean2 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setText("$ " + (((float) scoreStageListBean2.getScore()) / 100.0f));
                    return;
                }
                return;
            }
            if (type == 4) {
                itemRoomPersonalTaskListAdapterBinding.tvEndTimeText.setText(item.getTotalScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954233));
                if (scoreStageListBean3 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setText(scoreStageListBean3.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954233));
                }
                if (scoreStageListBean2 != null) {
                    itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setText(scoreStageListBean2.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954233));
                    return;
                }
                return;
            }
            if (type != 5) {
                return;
            }
            itemRoomPersonalTaskListAdapterBinding.tvEndTimeText.setText(item.getTotalScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954232));
            if (scoreStageListBean3 != null) {
                itemRoomPersonalTaskListAdapterBinding.tvStartTimeText.setText(scoreStageListBean3.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954232));
            }
            if (scoreStageListBean2 != null) {
                itemRoomPersonalTaskListAdapterBinding.tvCenterTimeText.setText(scoreStageListBean2.getScore() + " " + ResourcesKtxKt.getStringById(itemRoomPersonalTaskListAdapterBinding, 2131954232));
                return;
            }
            return;
        }
        scoreStageListBean = null;
        scoreStageListBean2 = null;
        if (scoreStageListBean3 == null) {
        }
        if (scoreStageListBean2 == null) {
        }
        if (scoreStageListBean != null) {
        }
        itemRoomPersonalTaskListAdapterBinding.taskProgress.setMax(100);
        itemRoomPersonalTaskListAdapterBinding.taskProgress.setProgress((int) ((((float) item.getCurrentScore()) / ((float) item.getTotalScore())) * 100));
        type = item.getType();
        if (type != 1) {
        }
    }
}
