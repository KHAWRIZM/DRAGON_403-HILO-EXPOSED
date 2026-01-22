package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\f\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\f\u001a\u0014\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0010\u0010\f\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0087@¢\u0006\u0004\b\u0017\u0010\u001b\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\u0086@¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0087@¢\u0006\u0004\b\u001e\u0010\u001b\u001a\u001c\u0010\"\u001a\u00020!*\u00020\u00002\u0006\u0010\u0002\u001a\u00020 H\u0087@¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/android/billingclient/api/g;", "Lcom/android/billingclient/api/a;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/android/billingclient/api/w;", "acknowledgePurchase", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/x;", "Lcom/android/billingclient/api/ConsumeResult;", "consumePurchase", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/x;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "createAlternativeBillingOnlyReportingDetails", "(Lcom/android/billingclient/api/g;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "createExternalOfferReportingDetails", "isAlternativeBillingOnlyAvailable", "isExternalOfferAvailable", "Lcom/android/billingclient/api/j0;", "Lcom/android/billingclient/api/ProductDetailsResult;", "queryProductDetails", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/j0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/k0;", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "queryPurchaseHistory", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/k0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "skuType", "(Lcom/android/billingclient/api/g;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/l0;", "Lcom/android/billingclient/api/PurchasesResult;", "queryPurchasesAsync", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/l0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/m0;", "Lcom/android/billingclient/api/SkuDetailsResult;", "querySkuDetails", "(Lcom/android/billingclient/api/g;Lcom/android/billingclient/api/m0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class BillingClientKotlinKt {
    public static /* synthetic */ void $r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(wVar);
    }

    public static /* synthetic */ void $r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new SkuDetailsResult(wVar, list));
    }

    /* renamed from: $r8$lambda$BC2cAL2vk_I3dV-pkSAsSywRIek, reason: not valid java name */
    public static /* synthetic */ void m٢٧٠$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull String str) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new ConsumeResult(wVar, str));
    }

    public static /* synthetic */ void $r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull a0 a0Var) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new CreateExternalOfferReportingDetailsResult(wVar, a0Var));
    }

    /* renamed from: $r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA, reason: not valid java name */
    public static /* synthetic */ void m٢٧١$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        Intrinsics.checkNotNull(list);
        deferred.complete(new PurchasesResult(wVar, list));
    }

    /* renamed from: $r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0, reason: not valid java name */
    public static /* synthetic */ void m٢٧٢$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new PurchaseHistoryResult(wVar, list));
    }

    /* renamed from: $r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25-w, reason: not valid java name */
    public static /* synthetic */ void m٢٧٣$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull e eVar) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(wVar, eVar));
    }

    /* renamed from: $r8$lambda$OmYoMPMU8NG-G-TTJRupXijq_ag, reason: not valid java name */
    public static /* synthetic */ void m٢٧٤$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(wVar);
    }

    public static /* synthetic */ void $r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new PurchaseHistoryResult(wVar, list));
    }

    /* renamed from: $r8$lambda$_HjOTKlijnqR-5v_YY-SPcvW1bw, reason: not valid java name */
    public static /* synthetic */ void m٢٧٥$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(new ProductDetailsResult(wVar, list));
    }

    public static /* synthetic */ void $r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        deferred.complete(wVar);
    }

    public static /* synthetic */ void $r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(@RecentlyNonNull CompletableDeferred deferred, @RecentlyNonNull w wVar, @RecentlyNonNull List list) {
        Intrinsics.checkNotNullParameter(deferred, "$deferred");
        Intrinsics.checkNotNull(wVar);
        Intrinsics.checkNotNull(list);
        deferred.complete(new PurchasesResult(wVar, list));
    }

    @RecentlyNullable
    public static final Object acknowledgePurchase(@RecentlyNonNull g gVar, @RecentlyNonNull a aVar, @RecentlyNonNull Continuation<? super w> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.a(aVar, new b() { // from class: com.android.billingclient.api.o
            @Override // com.android.billingclient.api.b
            public final void a(w wVar) {
                BillingClientKotlinKt.$r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(CompletableDeferred.this, wVar);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object consumePurchase(@RecentlyNonNull g gVar, @RecentlyNonNull x xVar, @RecentlyNonNull Continuation<? super ConsumeResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.b(xVar, new y() { // from class: com.android.billingclient.api.l
            @Override // com.android.billingclient.api.y
            public final void a(w wVar, String str) {
                BillingClientKotlinKt.m٢٧٠$r8$lambda$BC2cAL2vk_I3dVpkSAsSywRIek(CompletableDeferred.this, wVar, str);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object createAlternativeBillingOnlyReportingDetails(@RecentlyNonNull g gVar, @RecentlyNonNull Continuation<? super CreateAlternativeBillingOnlyReportingDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.createAlternativeBillingOnlyReportingDetailsAsync(new f() { // from class: com.android.billingclient.api.t
            @Override // com.android.billingclient.api.f
            public final void a(w wVar, e eVar) {
                BillingClientKotlinKt.m٢٧٣$r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25w(CompletableDeferred.this, wVar, eVar);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object createExternalOfferReportingDetails(@RecentlyNonNull g gVar, @RecentlyNonNull Continuation<? super CreateExternalOfferReportingDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.c(new b0() { // from class: com.android.billingclient.api.p
            @Override // com.android.billingclient.api.b0
            public final void a(w wVar, a0 a0Var) {
                BillingClientKotlinKt.$r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(CompletableDeferred.this, wVar, a0Var);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object isAlternativeBillingOnlyAvailable(@RecentlyNonNull g gVar, @RecentlyNonNull Continuation<? super w> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.isAlternativeBillingOnlyAvailableAsync(new c() { // from class: com.android.billingclient.api.r
            @Override // com.android.billingclient.api.c
            public final void a(w wVar) {
                BillingClientKotlinKt.$r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(CompletableDeferred.this, wVar);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object isExternalOfferAvailable(@RecentlyNonNull g gVar, @RecentlyNonNull Continuation<? super w> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.e(new z() { // from class: com.android.billingclient.api.m
            @Override // com.android.billingclient.api.z
            public final void a(w wVar) {
                BillingClientKotlinKt.m٢٧٤$r8$lambda$OmYoMPMU8NGGTTJRupXijq_ag(CompletableDeferred.this, wVar);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object queryProductDetails(@RecentlyNonNull g gVar, @RecentlyNonNull j0 j0Var, @RecentlyNonNull Continuation<? super ProductDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.j(j0Var, new f0() { // from class: com.android.billingclient.api.n
            @Override // com.android.billingclient.api.f0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.m٢٧٥$r8$lambda$_HjOTKlijnqR5v_YYSPcvW1bw(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object queryPurchaseHistory(@RecentlyNonNull g gVar, @RecentlyNonNull k0 k0Var, @RecentlyNonNull Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.k(k0Var, new g0() { // from class: com.android.billingclient.api.q
            @Override // com.android.billingclient.api.g0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.m٢٧٢$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    public static final Object queryPurchasesAsync(@RecentlyNonNull g gVar, @RecentlyNonNull l0 l0Var, @RecentlyNonNull Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.m(l0Var, new h0() { // from class: com.android.billingclient.api.j
            @Override // com.android.billingclient.api.h0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.m٢٧١$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    @Deprecated(message = "Use [BillingClient.queryProductDetails] instead")
    public static final Object querySkuDetails(@RecentlyNonNull g gVar, @RecentlyNonNull m0 m0Var, @RecentlyNonNull Continuation<? super SkuDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.o(m0Var, new n0() { // from class: com.android.billingclient.api.k
            @Override // com.android.billingclient.api.n0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.$r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    @Deprecated(message = "Use [BillingClient.queryPurchaseHistory(QueryPurchaseHistoryParams)] instead")
    public static final Object queryPurchaseHistory(@RecentlyNonNull g gVar, @RecentlyNonNull String str, @RecentlyNonNull Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.l(str, new g0() { // from class: com.android.billingclient.api.s
            @Override // com.android.billingclient.api.g0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.$r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNullable
    @Deprecated(message = "Use [BillingClient.queryPurchasesAsync(QueryPurchasesParams)] instead")
    public static final Object queryPurchasesAsync(@RecentlyNonNull g gVar, @RecentlyNonNull String str, @RecentlyNonNull Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        gVar.n(str, new h0() { // from class: com.android.billingclient.api.i
            @Override // com.android.billingclient.api.h0
            public final void a(w wVar, List list) {
                BillingClientKotlinKt.$r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(CompletableDeferred.this, wVar, list);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }
}
