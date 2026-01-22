package kotlin.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {280, 288, 292}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "$this$sequence", "matcher", "nextStart", "splitCount", "$this$sequence", "matcher", "nextStart", "splitCount"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i10, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0075 -> B:13:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Pattern pattern;
        int i10;
        Matcher matcher;
        int i11;
        String obj2;
        String obj3;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = this.label;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i13 = this.I$1;
                matcher = (Matcher) this.L$1;
                ResultKt.throwOnFailure(obj);
                int end = matcher.end();
                int i14 = i13 + 1;
                if (i14 == this.$limit - 1 && matcher.find()) {
                    i10 = end;
                    i11 = i14;
                    obj2 = this.$input.subSequence(i10, matcher.start()).toString();
                    this.L$0 = sequenceScope;
                    this.L$1 = matcher;
                    this.I$0 = i10;
                    this.I$1 = i11;
                    this.label = 2;
                    if (sequenceScope.yield(obj2, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i13 = i11;
                    int end2 = matcher.end();
                    int i142 = i13 + 1;
                    if (i142 == this.$limit - 1) {
                    }
                    CharSequence charSequence = this.$input;
                    obj3 = charSequence.subSequence(end2, charSequence.length()).toString();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                    this.I$0 = end2;
                    this.I$1 = i142;
                    this.label = 3;
                    if (sequenceScope.yield(obj3, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                CharSequence charSequence2 = this.$input;
                obj3 = charSequence2.subSequence(end2, charSequence2.length()).toString();
                this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(matcher);
                this.I$0 = end2;
                this.I$1 = i142;
                this.label = 3;
                if (sequenceScope.yield(obj3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            pattern = this.this$0.nativePattern;
            Matcher matcher2 = pattern.matcher(this.$input);
            if (this.$limit != 1 && matcher2.find()) {
                i10 = 0;
                matcher = matcher2;
                i11 = 0;
                obj2 = this.$input.subSequence(i10, matcher.start()).toString();
                this.L$0 = sequenceScope;
                this.L$1 = matcher;
                this.I$0 = i10;
                this.I$1 = i11;
                this.label = 2;
                if (sequenceScope.yield(obj2, this) != coroutine_suspended) {
                }
            } else {
                String obj4 = this.$input.toString();
                this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(matcher2);
                this.label = 1;
                if (sequenceScope.yield(obj4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
