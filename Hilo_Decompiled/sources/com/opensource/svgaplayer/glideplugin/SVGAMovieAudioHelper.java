package com.opensource.svgaplayer.glideplugin;

import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAMovieAudioHelper;", "", "()V", "setupAudiosMethod", "Ljava/lang/reflect/Method;", "getSetupAudiosMethod", "()Ljava/lang/reflect/Method;", "setupAudiosMethod$delegate", "Lkotlin/Lazy;", "setupAudios", "", "entity", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAMovieAudioHelper {

    @NotNull
    public static final SVGAMovieAudioHelper INSTANCE = new SVGAMovieAudioHelper();

    /* renamed from: setupAudiosMethod$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy setupAudiosMethod = LazyKt.lazy(new Function0<Method>() { // from class: com.opensource.svgaplayer.glideplugin.SVGAMovieAudioHelper$setupAudiosMethod$2
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Method invoke() {
            Method method;
            try {
                try {
                    method = SVGAVideoEntity.class.getDeclaredMethod("setupAudios", MovieEntity.class, Function0.class);
                } catch (Throwable unused) {
                    method = null;
                }
            } catch (Throwable unused2) {
                method = SVGAVideoEntity.class.getDeclaredMethod("resetAudios", MovieEntity.class, Function0.class);
            }
            if (method != null) {
                method.setAccessible(true);
            }
            return method;
        }
    });

    private SVGAMovieAudioHelper() {
    }

    private final Method getSetupAudiosMethod() {
        return (Method) setupAudiosMethod.getValue();
    }

    public final void setupAudios(@NotNull SVGAVideoEntity entity) {
        Method setupAudiosMethod2;
        Intrinsics.checkNotNullParameter(entity, "entity");
        MovieEntity movieItem = entity.getMovieItem();
        if (movieItem != null && (setupAudiosMethod2 = getSetupAudiosMethod()) != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                setupAudiosMethod2.invoke(entity, movieItem, new Function0<Unit>() { // from class: com.opensource.svgaplayer.glideplugin.SVGAMovieAudioHelper$setupAudios$callback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
            } catch (Throwable unused) {
            }
        }
    }
}
