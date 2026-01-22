package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
/* synthetic */ class BaseLayer$1$1 extends FunctionReferenceImpl implements Function4<Context, List<? extends Rect>, Canvas, Paint, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLayer$1$1(Object obj) {
        super(4, obj, IPainter.class, "onDraw", "onDraw(Landroid/content/Context;Ljava/util/List;Landroid/graphics/Canvas;Landroid/graphics/Paint;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Context context, List<? extends Rect> list, Canvas canvas, Paint paint) {
        invoke2(context, (List<Rect>) list, canvas, paint);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context p02, List<Rect> p12, Canvas p22, Paint p32) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        Intrinsics.checkNotNullParameter(p22, "p2");
        Intrinsics.checkNotNullParameter(p32, "p3");
        ((IPainter) this.receiver).onDraw(p02, p12, p22, p32);
    }
}
