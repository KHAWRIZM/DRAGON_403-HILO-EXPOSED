package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"isMuted", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class YouTubePlayerExtKt {
    @Nullable
    public static final Object isMuted(@NotNull YouTubePlayer youTubePlayer, @NotNull Continuation<? super Boolean> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        youTubePlayer.isMutedAsync(new BooleanProvider() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerExtKt$isMuted$2$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.BooleanProvider
            public final void accept(boolean z10) {
                safeContinuation.resumeWith(Result.m٥٤٤constructorimpl(Boolean.valueOf(z10)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
