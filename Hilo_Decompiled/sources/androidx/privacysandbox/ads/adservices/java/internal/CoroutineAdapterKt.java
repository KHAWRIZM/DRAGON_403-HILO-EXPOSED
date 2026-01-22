package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import m8.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lkotlinx/coroutines/Deferred;", "", ViewHierarchyConstants.TAG_KEY, "Lm8/d;", "asListenableFuture", "(Lkotlinx/coroutines/Deferred;Ljava/lang/Object;)Lm8/d;", "ads-adservices-java_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class CoroutineAdapterKt {
    @NotNull
    public static final <T> d asListenableFuture(@NotNull final Deferred<? extends T> deferred, @Nullable final Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        d a10 = c.a(new c.InterfaceC٠٠١٥c() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            @Override // androidx.concurrent.futures.c.InterfaceC٠٠١٥c
            public final Object a(c.a aVar) {
                Object asListenableFuture$lambda$0;
                asListenableFuture$lambda$0 = CoroutineAdapterKt.asListenableFuture$lambda$0(Deferred.this, obj, aVar);
                return asListenableFuture$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(a10, "getFuture { completer ->…      }\n        tag\n    }");
        return a10;
    }

    public static /* synthetic */ d asListenableFuture$default(Deferred deferred, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(deferred, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(final Deferred this_asListenableFuture, Object obj, final c.a completer) {
        Intrinsics.checkNotNullParameter(this_asListenableFuture, "$this_asListenableFuture");
        Intrinsics.checkNotNullParameter(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th != null) {
                    if (th instanceof CancellationException) {
                        c.a.this.c();
                        return;
                    } else {
                        c.a.this.e(th);
                        return;
                    }
                }
                c.a.this.b(this_asListenableFuture.getCompleted());
            }
        });
        return obj;
    }
}
