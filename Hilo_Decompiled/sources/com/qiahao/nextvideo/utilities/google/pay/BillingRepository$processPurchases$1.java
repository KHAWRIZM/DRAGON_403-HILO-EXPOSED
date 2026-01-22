package com.qiahao.nextvideo.utilities.google.pay;

import com.android.billingclient.api.Purchase;
import com.oudi.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.google.pay.BillingRepository$processPurchases$1", f = "BillingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBillingRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillingRepository.kt\ncom/qiahao/nextvideo/utilities/google/pay/BillingRepository$processPurchases$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,538:1\n1869#2,2:539\n3301#2,10:541\n1869#2,2:551\n*S KotlinDebug\n*F\n+ 1 BillingRepository.kt\ncom/qiahao/nextvideo/utilities/google/pay/BillingRepository$processPurchases$1\n*L\n278#1:539,2\n289#1:541,10\n302#1:551,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BillingRepository$processPurchases$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<Purchase> $purchasesResult;
    int label;
    final /* synthetic */ BillingRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingRepository$processPurchases$1(Set<? extends Purchase> set, BillingRepository billingRepository, Continuation<? super BillingRepository$processPurchases$1> continuation) {
        super(2, continuation);
        this.$purchasesResult = set;
        this.this$0 = billingRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingRepository$processPurchases$1(this.$purchasesResult, this.this$0, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        boolean isConsumable;
        boolean isSignatureValid;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogUtil logUtil = LogUtil.INSTANCE;
            LogUtil.e$default(logUtil, "BillingRepository", "processPurchases called", false, 4, (Object) null);
            HashSet hashSet = new HashSet(this.$purchasesResult.size());
            LogUtil.e$default(logUtil, "BillingRepository", "processPurchases newBatch content " + this.$purchasesResult, false, 4, (Object) null);
            Set<Purchase> set = this.$purchasesResult;
            BillingRepository billingRepository = this.this$0;
            for (Purchase purchase : set) {
                if (purchase.d() == 1) {
                    isSignatureValid = billingRepository.isSignatureValid(purchase);
                    if (isSignatureValid) {
                        hashSet.add(purchase);
                    }
                } else if (purchase.d() == 2) {
                    LogUtil.e$default(LogUtil.INSTANCE, "BillingRepository", "Received a pending purchase of SKU: " + purchase.g(), false, 4, (Object) null);
                }
            }
            BillingRepository billingRepository2 = this.this$0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : hashSet) {
                isConsumable = billingRepository2.isConsumable((Purchase) obj2);
                if (isConsumable) {
                    arrayList.add(obj2);
                } else {
                    arrayList2.add(obj2);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            List<Purchase> list = (List) pair.component1();
            List list2 = (List) pair.component2();
            BillingRepository billingRepository3 = this.this$0;
            for (Purchase purchase2 : list) {
                GooglePayConsumeListener delegate = billingRepository3.getDelegate();
                if (delegate != null) {
                    delegate.purchaseSuccess(purchase2);
                }
            }
            this.this$0.askResponsePurchaseThenAcknowledge(list2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
