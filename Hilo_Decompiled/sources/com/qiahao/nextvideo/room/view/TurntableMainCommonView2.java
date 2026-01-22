package com.qiahao.nextvideo.room.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.TurntableMainCommonView2;
import com.qiahao.nextvideo.room.view.TurntableMainCommonView2.BaseBean;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002jkB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u0019J#\u0010\u001f\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u00020\u000e2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0019J\r\u0010&\u001a\u00020\u000e¢\u0006\u0004\b&\u0010\u0019J\u0015\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0014¢\u0006\u0004\b(\u0010)J\u001b\u0010(\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0004\b(\u0010*J\u000f\u0010+\u001a\u00020\u001dH\u0016¢\u0006\u0004\b+\u0010,J\u0011\u0010.\u001a\u0004\u0018\u00010-H&¢\u0006\u0004\b.\u0010/J!\u00102\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010-2\u0006\u00101\u001a\u00028\u0000H&¢\u0006\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010:\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00109\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\"\u0010B\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bH\u0010,\"\u0004\bJ\u0010KR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR(\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010*R\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010)R$\u0010Y\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010QR\"\u0010`\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b`\u0010C\u001a\u0004\ba\u0010E\"\u0004\bb\u0010GR\"\u0010c\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bc\u0010C\u001a\u0004\bd\u0010E\"\u0004\be\u0010GR\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020-0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010QR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006l"}, d2 = {"Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2;", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "T", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "init", "pos", "bean", "startRotate", "(ILcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;)V", "", TUIConstants.TUILive.USER_ID, "getIndexOfOut", "(Ljava/lang/String;)I", "clearListeners", "()V", "initViews", "", "list", "", "isInitViews", "setList", "(Ljava/util/List;Z)V", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$OnResultListener;", "turnTableListener", "setTurnTableListener", "(Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$OnResultListener;)V", "resetData", "release", "result", "setResultAndStart", "(Ljava/lang/String;)V", "(Ljava/util/List;)V", "postNext", "()Z", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "view", "baseBean", "viewLoader", "(Landroid/view/View;Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;)V", "Lcom/qiahao/nextvideo/room/view/TurnTableView;", "turnTableView", "Lcom/qiahao/nextvideo/room/view/TurnTableView;", "", "imageSize", "F", ImageSelectActivity.ITEM_WIDTH, "getItemWidth", "()F", "setItemWidth", "(F)V", ImageSelectActivity.ITEM_HEIGHT, "getItemHeight", "setItemHeight", "rotateTime", "I", "getRotateTime", "()I", "setRotateTime", "(I)V", "isRotating", "Z", "setRotating", "(Z)V", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$OnResultListener;", "Landroid/animation/ObjectAnimator;", "anim", "Landroid/animation/ObjectAnimator;", "listData", "Ljava/util/List;", "getListData", "()Ljava/util/List;", "setListData", "Ljava/lang/String;", "getResult", "()Ljava/lang/String;", "setResult", "resultBean", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "getResultBean", "()Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "setResultBean", "(Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;)V", "resultList", "additionalAngle", "getAdditionalAngle", "setAdditionalAngle", "centrifugal", "getCentrifugal", "setCentrifugal", "listImage", "Lcom/bumptech/glide/j;", "requestManager", "Lcom/bumptech/glide/j;", "OnResultListener", "BaseBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class TurntableMainCommonView2<T extends BaseBean> extends RelativeLayout {
    private int additionalAngle;

    @Nullable
    private ObjectAnimator anim;
    private int centrifugal;
    private float imageSize;
    private boolean isRotating;
    private float itemHeight;
    private float itemWidth;

    @NotNull
    private List<T> listData;

    @NotNull
    private List<View> listImage;

    @Nullable
    private com.bumptech.glide.j requestManager;

    @NotNull
    private String result;

    @Nullable
    private T resultBean;

    @NotNull
    private List<String> resultList;
    private int rotateTime;

    @Nullable
    private OnResultListener<T> turnTableListener;
    private TurnTableView turnTableView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "", "getId", "", "getImage", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface BaseBean {
        @NotNull
        String getId();

        @NotNull
        String getImage();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$OnResultListener;", "T", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;", "", "onAnimationEnd", "", "status", "", "onSelectOption", "data", "sumHas", "(Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;I)V", "onWinOption", "(Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$BaseBean;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface OnResultListener<T extends BaseBean> {
        void onAnimationEnd(int status);

        void onSelectOption(@NotNull T data, int sumHas);

        void onWinOption(@NotNull T data);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TurntableMainCommonView2(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rotateTime = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.listData = new ArrayList();
        this.result = "";
        this.resultList = new ArrayList();
        this.centrifugal = 5;
        this.listImage = new ArrayList();
        init(context, null);
    }

    private final void clearListeners() {
        ObjectAnimator objectAnimator = this.anim;
        if (objectAnimator != null) {
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimator2 = this.anim;
            if (objectAnimator2 != null) {
                objectAnimator2.removeAllListeners();
            }
        }
        clearAnimation();
    }

    private final int getIndexOfOut(String userId) {
        int size = this.listData.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.listData.get(i).getId(), userId)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressLint({"CustomViewStyleable"})
    private final void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.TurnTableView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            obtainStyledAttributes.getResourceId(9, 0);
            this.imageSize = obtainStyledAttributes.getDimension(0, 40.0f);
            this.rotateTime = obtainStyledAttributes.getInt(6, HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS);
            this.itemWidth = obtainStyledAttributes.getDimension(14, 40.0f);
            this.itemHeight = obtainStyledAttributes.getDimension(13, 40.0f);
            obtainStyledAttributes.recycle();
        }
        this.turnTableView = new TurnTableView(context, attrs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        TurnTableView turnTableView = this.turnTableView;
        TurnTableView turnTableView2 = null;
        if (turnTableView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
            turnTableView = null;
        }
        turnTableView.setLayoutParams(layoutParams);
        TurnTableView turnTableView3 = this.turnTableView;
        if (turnTableView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
        } else {
            turnTableView2 = turnTableView3;
        }
        addView(turnTableView2);
    }

    private final void startRotate(int pos, final T bean) {
        float f;
        if (!this.isRotating && pos > 0 && pos <= this.listData.size()) {
            this.isRotating = true;
            TurnTableView turnTableView = this.turnTableView;
            TurnTableView turnTableView2 = null;
            if (turnTableView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
                turnTableView = null;
            }
            int minTimes = turnTableView.getMinTimes();
            TurnTableView turnTableView3 = this.turnTableView;
            if (turnTableView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
                turnTableView3 = null;
            }
            float angle = turnTableView3.getAngle();
            TurnTableView turnTableView4 = this.turnTableView;
            if (turnTableView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
                turnTableView4 = null;
            }
            float currAngle = turnTableView4.getCurrAngle();
            TurnTableView turnTableView5 = this.turnTableView;
            if (turnTableView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
                turnTableView5 = null;
            }
            float f2 = ((minTimes * 360) - ((pos - 1) * angle)) + currAngle;
            if (turnTableView5.getLastPosition() == 0) {
                f = 0 - (angle / 2);
            } else {
                f = (r8 - 1) * angle;
            }
            int i = (int) (f2 + f);
            ObjectAnimator objectAnimator = this.anim;
            if (objectAnimator == null) {
                this.anim = ObjectAnimator.ofFloat(this, "rotation", currAngle, i);
            } else if (objectAnimator != null) {
                objectAnimator.setFloatValues(currAngle, i);
            }
            TurnTableView turnTableView6 = this.turnTableView;
            if (turnTableView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
                turnTableView6 = null;
            }
            turnTableView6.setCurrAngle(i);
            TurnTableView turnTableView7 = this.turnTableView;
            if (turnTableView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
            } else {
                turnTableView2 = turnTableView7;
            }
            turnTableView2.setLastPosition(pos);
            ObjectAnimator objectAnimator2 = this.anim;
            if (objectAnimator2 != null) {
                objectAnimator2.setDuration(this.rotateTime);
            }
            final float[] fArr = {0.0f};
            ObjectAnimator objectAnimator3 = this.anim;
            if (objectAnimator3 != null) {
                objectAnimator3.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.view.y
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f3) {
                        float startRotate$lambda$1;
                        startRotate$lambda$1 = TurntableMainCommonView2.startRotate$lambda$1(fArr, f3);
                        return startRotate$lambda$1;
                    }
                });
            }
            ObjectAnimator objectAnimator4 = this.anim;
            if (objectAnimator4 != null) {
                objectAnimator4.removeAllListeners();
            }
            ObjectAnimator objectAnimator5 = this.anim;
            if (objectAnimator5 != null) {
                objectAnimator5.addListener(new AnimatorListenerAdapter() { // from class: com.qiahao.nextvideo.room.view.TurntableMainCommonView2$startRotate$2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationCancel(animation);
                        TurntableMainCommonView2.this.setRotating(false);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        TurntableMainCommonView2.OnResultListener onResultListener;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationEnd(animation);
                        TurntableMainCommonView2.this.setRotating(false);
                        onResultListener = ((TurntableMainCommonView2) TurntableMainCommonView2.this).turnTableListener;
                        if (onResultListener != null) {
                            TurntableMainCommonView2.BaseBean baseBean = bean;
                            TurntableMainCommonView2<T> turntableMainCommonView2 = TurntableMainCommonView2.this;
                            onResultListener.onAnimationEnd(0);
                            onResultListener.onSelectOption(baseBean, turntableMainCommonView2.getListData().size());
                            if (turntableMainCommonView2.getListData().size() == 1) {
                                onResultListener.onWinOption((TurntableMainCommonView2.BaseBean) turntableMainCommonView2.getListData().get(0));
                            }
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationStart(animation);
                    }
                });
            }
            ObjectAnimator objectAnimator6 = this.anim;
            if (objectAnimator6 != null) {
                objectAnimator6.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startRotate$lambda$1(float[] fArr, float f) {
        float cos = ((float) (Math.cos((f + 1) * 3.141592653589793d) / 2.0f)) + 0.5f;
        fArr[0] = cos;
        return cos;
    }

    protected final int getAdditionalAngle() {
        return this.additionalAngle;
    }

    protected final int getCentrifugal() {
        return this.centrifugal;
    }

    public final float getItemHeight() {
        return this.itemHeight;
    }

    @Nullable
    public abstract View getItemView();

    public final float getItemWidth() {
        return this.itemWidth;
    }

    @NotNull
    public final List<T> getListData() {
        return this.listData;
    }

    @NotNull
    public final String getResult() {
        return this.result;
    }

    @Nullable
    public final T getResultBean() {
        return this.resultBean;
    }

    public final int getRotateTime() {
        return this.rotateTime;
    }

    public final void initViews() {
        int size;
        int i;
        float f;
        int i2;
        int i3;
        double d;
        setRotation(0.0f);
        TurnTableView turnTableView = this.turnTableView;
        TurnTableView turnTableView2 = null;
        if (turnTableView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
            turnTableView = null;
        }
        int i4 = 1;
        if (this.listData.size() == 0) {
            size = 1;
        } else {
            size = this.listData.size();
        }
        turnTableView.setSum(size);
        TurnTableView turnTableView3 = this.turnTableView;
        if (turnTableView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
            turnTableView3 = null;
        }
        turnTableView3.b();
        Iterator<View> it = this.listImage.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.listImage.clear();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        TurnTableView turnTableView4 = this.turnTableView;
        if (turnTableView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
            turnTableView4 = null;
        }
        int radius = turnTableView4.getRadius();
        TurnTableView turnTableView5 = this.turnTableView;
        if (turnTableView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("turnTableView");
        } else {
            turnTableView2 = turnTableView5;
        }
        float angle = turnTableView2.getAngle();
        int size2 = this.listData.size();
        float f2 = -90.0f;
        int i5 = 0;
        while (i5 < size2) {
            View itemView = getItemView();
            if (itemView != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.listData.size() == i4) {
                    d = 0.0d;
                } else {
                    d = f2 + (angle / 2.0d);
                }
                int i6 = radius / 2;
                i = width;
                f = angle;
                double radians = (float) Math.toRadians(d);
                float cos = (float) ((width / 2) + (((radius / this.centrifugal) + i6) * Math.cos(radians)));
                i2 = size2;
                i3 = height;
                float sin = (float) ((height / 2) + ((i6 + (radius / this.centrifugal)) * Math.sin(radians)));
                float f3 = this.itemWidth;
                layoutParams.width = (int) (f3 + 0.5f);
                float f4 = this.itemHeight;
                layoutParams.height = (int) (f4 + 0.5f);
                float f5 = 2;
                layoutParams.leftMargin = (int) ((cos - (f3 / f5)) + 0.5f);
                layoutParams.topMargin = (int) ((sin - (f4 / f5)) + 0.5f);
                itemView.setLayoutParams(layoutParams);
                viewLoader(itemView, this.listData.get(i5));
                if (this.listData.size() != 1) {
                    itemView.setRotation((((i5 + 1) * f) - (f / f5)) + this.additionalAngle);
                }
                addView(itemView);
                this.listImage.add(itemView);
                f2 += f;
            } else {
                i = width;
                f = angle;
                i2 = size2;
                i3 = height;
            }
            i5++;
            width = i;
            angle = f;
            size2 = i2;
            height = i3;
            i4 = 1;
        }
    }

    /* renamed from: isRotating, reason: from getter */
    public final boolean getIsRotating() {
        return this.isRotating;
    }

    public boolean postNext() {
        if (this.resultList.size() > 1) {
            initViews();
            setResultAndStart(this.resultList);
        }
        if (this.resultList.size() > 1) {
            return true;
        }
        return false;
    }

    public final void release() {
        resetData();
        this.turnTableListener = null;
    }

    public final void resetData() {
        clearListeners();
        this.listData = new ArrayList();
        this.isRotating = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setAdditionalAngle(int i) {
        this.additionalAngle = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCentrifugal(int i) {
        this.centrifugal = i;
    }

    public final void setItemHeight(float f) {
        this.itemHeight = f;
    }

    public final void setItemWidth(float f) {
        this.itemWidth = f;
    }

    public final void setList(@NotNull List<T> list, boolean isInitViews) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.listData = new ArrayList(list);
        if (isInitViews) {
            initViews();
        }
    }

    public final void setListData(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listData = list;
    }

    public final void setResult(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.result = str;
    }

    public final synchronized void setResultAndStart(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.isRotating = false;
        this.result = result;
        int indexOfOut = getIndexOfOut(result);
        if (TextUtils.isEmpty(result)) {
            OnResultListener<T> onResultListener = this.turnTableListener;
            if (onResultListener != null) {
                onResultListener.onAnimationEnd(1);
            }
        } else if (indexOfOut < 0) {
            OnResultListener<T> onResultListener2 = this.turnTableListener;
            if (onResultListener2 != null) {
                onResultListener2.onAnimationEnd(2);
            }
        } else {
            startRotate(indexOfOut + 1, this.listData.get(indexOfOut));
        }
    }

    public final void setResultBean(@Nullable T t) {
        this.resultBean = t;
    }

    public final void setRotateTime(int i) {
        this.rotateTime = i;
    }

    public final void setRotating(boolean z) {
        this.isRotating = z;
    }

    public final void setTurnTableListener(@Nullable OnResultListener<T> turnTableListener) {
        this.turnTableListener = turnTableListener;
    }

    public abstract void viewLoader(@Nullable View view, @NotNull T baseBean);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TurntableMainCommonView2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rotateTime = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.listData = new ArrayList();
        this.result = "";
        this.resultList = new ArrayList();
        this.centrifugal = 5;
        this.listImage = new ArrayList();
        init(context, attributeSet);
    }

    public final synchronized void setResultAndStart(@NotNull List<String> result) {
        try {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.size() != this.listData.size()) {
                return;
            }
            if (result.size() < 2) {
                return;
            }
            this.resultList = result;
            this.isRotating = false;
            int indexOfOut = getIndexOfOut(result.get(0));
            if (indexOfOut < 0) {
                return;
            }
            T t = this.listData.get(indexOfOut);
            this.resultBean = t;
            startRotate(indexOfOut + 1, t);
            if (!result.isEmpty()) {
                result.remove(0);
            }
            this.listData.remove(indexOfOut);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TurntableMainCommonView2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rotateTime = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
        this.listData = new ArrayList();
        this.result = "";
        this.resultList = new ArrayList();
        this.centrifugal = 5;
        this.listImage = new ArrayList();
        init(context, attributeSet);
    }
}
