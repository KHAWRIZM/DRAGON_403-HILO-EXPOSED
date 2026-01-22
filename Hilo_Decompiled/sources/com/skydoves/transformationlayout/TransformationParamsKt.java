package com.skydoves.transformationlayout;

import i8.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0004"}, d2 = {"getMaterialContainerTransform", "Lcom/google/android/material/transition/platform/MaterialContainerTransform;", "Lcom/skydoves/transformationlayout/TransformationParams;", "getMaterialFragmentTransform", "transformationlayout_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TransformationParamsKt {
    public static final /* synthetic */ j getMaterialContainerTransform(TransformationParams transformationParams) {
        Intrinsics.checkNotNullParameter(transformationParams, "<this>");
        j jVar = new j();
        jVar.addTarget(android.R.id.content);
        jVar.setDuration(transformationParams.getDuration());
        jVar.setPathMotion(transformationParams.getPathMotion().getPathMotion());
        jVar.n(transformationParams.getZOrder());
        jVar.m(transformationParams.getContainerColor());
        jVar.u(transformationParams.getScrimColor());
        jVar.x(transformationParams.getDirection().getValue());
        jVar.r(transformationParams.getFadeMode().getValue());
        jVar.s(transformationParams.getFitMode().getValue());
        return jVar;
    }

    public static final /* synthetic */ j getMaterialFragmentTransform(TransformationParams transformationParams) {
        Intrinsics.checkNotNullParameter(transformationParams, "<this>");
        j jVar = new j();
        jVar.setDuration(transformationParams.getDuration());
        jVar.setPathMotion(transformationParams.getPathMotion().getPathMotion());
        jVar.n(transformationParams.getZOrder());
        jVar.m(transformationParams.getContainerColor());
        jVar.u(transformationParams.getScrimColor());
        jVar.x(transformationParams.getDirection().getValue());
        jVar.r(transformationParams.getFadeMode().getValue());
        jVar.s(transformationParams.getFitMode().getValue());
        return jVar;
    }
}
