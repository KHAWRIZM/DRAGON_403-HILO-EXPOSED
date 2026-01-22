package com.qiahao.base_common.utils;

import android.util.Log;
import com.opensource.svgaplayer.SVGAParser;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.SafeSVGAParser$decodeFromURL$job$1", f = "SafeSVGAParser.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class SafeSVGAParser$decodeFromURL$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SVGAParser.ParseCompletion $completion;
    final /* synthetic */ long $timeoutSeconds;
    final /* synthetic */ URL $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.base_common.utils.SafeSVGAParser$decodeFromURL$job$1$1", f = "SafeSVGAParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.base_common.utils.SafeSVGAParser$decodeFromURL$job$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Function0<? extends Unit>>, Object> {
        final /* synthetic */ SVGAParser.ParseCompletion $completion;
        final /* synthetic */ URL $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(URL url, SVGAParser.ParseCompletion parseCompletion, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$url = url;
            this.$completion = parseCompletion;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$url, this.$completion, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Function0<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Function0<Unit>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return SVGAParser.INSTANCE.shareParser().decodeFromURL(this.$url, this.$completion);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Function0<Unit>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeSVGAParser$decodeFromURL$job$1(long j10, URL url, SVGAParser.ParseCompletion parseCompletion, Continuation<? super SafeSVGAParser$decodeFromURL$job$1> continuation) {
        super(2, continuation);
        this.$timeoutSeconds = j10;
        this.$url = url;
        this.$completion = parseCompletion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SafeSVGAParser$decodeFromURL$job$1(this.$timeoutSeconds, this.$url, this.$completion, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 != 0) {
                if (i10 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long j10 = this.$timeoutSeconds * 1000;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$url, this.$completion, null);
                this.label = 1;
                if (TimeoutKt.withTimeout(j10, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (StackOverflowError e10) {
            Log.e("SafeSVGAParser", "StackOverflowError while parsing SVG from URL: " + this.$url, e10);
            this.$completion.onError();
        } catch (TimeoutCancellationException unused) {
            Log.e("SafeSVGAParser", "Timeout while parsing SVG from URL: " + this.$url);
            this.$completion.onError();
        } catch (Throwable th) {
            Log.e("SafeSVGAParser", "Error while parsing SVG from URL: " + this.$url, th);
            this.$completion.onError();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SafeSVGAParser$decodeFromURL$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
