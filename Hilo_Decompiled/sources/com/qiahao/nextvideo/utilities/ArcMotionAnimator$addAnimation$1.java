package com.qiahao.nextvideo.utilities;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.ArcMotionAnimator$addAnimation$1", f = "ArcMotionAnimator.kt", i = {0}, l = {UserProxyUtility.strangeChatMatch}, m = "invokeSuspend", n = {"index"}, s = {"I$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ArcMotionAnimator$addAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endX;
    final /* synthetic */ int $endY;
    final /* synthetic */ int $position;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    int I$0;
    int label;
    final /* synthetic */ ArcMotionAnimator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArcMotionAnimator$addAnimation$1(ArcMotionAnimator arcMotionAnimator, int i, int i2, int i3, int i4, int i5, Continuation<? super ArcMotionAnimator$addAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = arcMotionAnimator;
        this.$position = i;
        this.$startX = i2;
        this.$startY = i3;
        this.$endX = i4;
        this.$endY = i5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArcMotionAnimator$addAnimation$1(this.this$0, this.$position, this.$startX, this.$startY, this.$endX, this.$endY, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0040  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004c -> B:5:0x010a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:5:0x010a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0107 -> B:5:0x010a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0046 -> B:5:0x010a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HashMap hashMap;
        int i;
        Lifecycle lifecycle;
        Lifecycle.State currentState;
        float px;
        float f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
                i++;
                if (i < 8) {
                    lifecycle = this.this$0.lifecycle;
                    if (lifecycle != null && (currentState = lifecycle.getCurrentState()) != null && currentState.isAtLeast(Lifecycle.State.STARTED)) {
                        ImageView imageView = new ImageView(this.this$0.getParentView().getContext());
                        imageView.setImageDrawable(androidx.core.content.a.getDrawable(this.this$0.getParentView().getContext(), 2131231935));
                        imageView.setTag(this.$position + "_" + i);
                        imageView.setVisibility(8);
                        imageView.setRotation(((float) RangesKt.random(new IntRange(0, 60), Random.Default)) - 30.0f);
                        imageView.setLayoutParams(new ConstraintLayout.b(UiKtxKt.toPX(18), UiKtxKt.toPX(18)));
                        this.this$0.getParentView().addView(imageView);
                        ArcMotionAnimator arcMotionAnimator = this.this$0;
                        float f2 = this.$startX;
                        float f3 = this.$startY;
                        float f4 = this.$endX;
                        if (i % 2 == 0) {
                            px = this.$endY;
                        } else {
                            px = this.$endY - UiKtxKt.toPX(10);
                        }
                        float f5 = px;
                        if (this.$startY > this.$endY) {
                            f = -100.0f;
                        } else {
                            f = 100.0f;
                        }
                        arcMotionAnimator.createArcPath(f2, f3, f4, f5, f);
                        this.this$0.start(500L, 0, imageView);
                        this.I$0 = i;
                        this.label = 1;
                        if (DelayKt.delay(40L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    i++;
                    if (i < 8) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            hashMap = this.this$0.animatorList;
            hashMap.put(this.$position + "_7", null);
            i = 0;
            if (i < 8) {
            }
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
