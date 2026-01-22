package kotlinx.coroutines.channels;

import androidx.concurrent.futures.b;
import com.google.android.gms.appinvite.PreviewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b$\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004à\u0001á\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\u001f\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001J>\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\bJ/\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0019\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0089\u0001J\u001c\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@¢\u0006\u0006\b¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0082\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J8\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J\u001e\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J'\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J(\u0010Ë\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J5\u0010Ì\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Í\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Î\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001JK\u0010Ñ\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Õ\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÖ\u0001J$\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ú\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Û\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006â\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", FirebaseAnalytics.Param.INDEX, "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3086:1\n273#1,6:3089\n280#1,68:3096\n397#1,18:3187\n244#1:3205\n269#1,10:3206\n280#1,48:3217\n418#1:3265\n334#1,14:3266\n422#1,3:3281\n244#1:3294\n269#1,10:3295\n280#1,68:3306\n244#1:3384\n269#1,10:3385\n280#1,68:3396\n244#1:3468\n269#1,10:3469\n280#1,68:3480\n244#1:3549\n269#1,10:3550\n280#1,68:3561\n909#1,52:3631\n987#1,8:3687\n881#1:3695\n905#1,33:3696\n997#1:3729\n939#1,14:3730\n958#1,3:3745\n1002#1,6:3748\n909#1,52:3762\n987#1,8:3818\n881#1:3826\n905#1,33:3827\n997#1:3860\n939#1,14:3861\n958#1,3:3876\n1002#1,6:3879\n881#1:3894\n905#1,48:3895\n958#1,3:3944\n881#1:3947\n905#1,48:3948\n958#1,3:3997\n244#1:4009\n269#1,10:4010\n280#1,68:4021\n881#1:4090\n905#1,48:4091\n958#1,3:4140\n1#2:3087\n3069#3:3088\n3069#3:3095\n3069#3:3216\n3069#3:3305\n3069#3:3395\n3069#3:3467\n3069#3:3479\n3069#3:3560\n3069#3:3630\n3069#3:3893\n3069#3:4000\n3069#3:4001\n3083#3:4002\n3083#3:4003\n3082#3:4004\n3082#3:4005\n3082#3:4006\n3083#3:4007\n3082#3:4008\n3069#3:4020\n3070#3:4143\n3069#3:4144\n3069#3:4145\n3069#3:4146\n3070#3:4147\n3069#3:4148\n3070#3:4171\n3069#3:4172\n3069#3:4173\n3070#3:4174\n3069#3:4224\n3070#3:4225\n3070#3:4226\n3070#3:4244\n3070#3:4245\n318#4,9:3164\n327#4,2:3181\n336#4,4:3183\n340#4,8:3284\n318#4,9:3375\n327#4,2:3465\n336#4,4:3683\n340#4,8:3754\n336#4,4:3814\n340#4,8:3885\n216#5:3173\n217#5:3176\n216#5:3177\n217#5:3180\n57#6,2:3174\n57#6,2:3178\n57#6,2:3292\n269#7:3280\n269#7:3374\n269#7:3464\n269#7:3548\n269#7:3629\n269#7:4089\n905#8:3744\n905#8:3875\n905#8:3943\n905#8:3996\n905#8:4139\n33#9,11:4149\n33#9,11:4160\n68#10,3:4175\n42#10,8:4178\n68#10,3:4186\n42#10,8:4189\n42#10,8:4197\n68#10,3:4205\n42#10,8:4208\n42#10,8:4216\n766#11:4227\n857#11,2:4228\n2310#11,14:4230\n766#11:4246\n857#11,2:4247\n2310#11,14:4249\n766#11:4263\n857#11,2:4264\n2310#11,14:4266\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3089,6\n113#1:3096,68\n154#1:3187,18\n154#1:3205\n154#1:3206,10\n154#1:3217,48\n154#1:3265\n154#1:3266,14\n154#1:3281,3\n194#1:3294\n194#1:3295,10\n194#1:3306,68\n225#1:3384\n225#1:3385,10\n225#1:3396,68\n356#1:3468\n356#1:3469,10\n356#1:3480,68\n414#1:3549\n414#1:3550,10\n414#1:3561,68\n690#1:3631,52\n719#1:3687,8\n719#1:3695\n719#1:3696,33\n719#1:3729\n719#1:3730,14\n719#1:3745,3\n719#1:3748,6\n755#1:3762,52\n771#1:3818,8\n771#1:3826\n771#1:3827,33\n771#1:3860\n771#1:3861,14\n771#1:3876,3\n771#1:3879,6\n804#1:3894\n804#1:3895,48\n804#1:3944,3\n994#1:3947\n994#1:3948,48\n994#1:3997,3\n1487#1:4009\n1487#1:4010,10\n1487#1:4021,68\n1535#1:4090\n1535#1:4091,48\n1535#1:4140,3\n70#1:3088\n113#1:3095\n154#1:3216\n194#1:3305\n225#1:3395\n278#1:3467\n356#1:3479\n414#1:3560\n629#1:3630\n794#1:3893\n1030#1:4000\n1079#1:4001\n1397#1:4002\n1399#1:4003\n1429#1:4004\n1439#1:4005\n1448#1:4006\n1449#1:4007\n1456#1:4008\n1487#1:4020\n1896#1:4143\n1898#1:4144\n1900#1:4145\n1913#1:4146\n1924#1:4147\n1925#1:4148\n2227#1:4171\n2240#1:4172\n2250#1:4173\n2253#1:4174\n2570#1:4224\n2572#1:4225\n2597#1:4226\n2659#1:4244\n2660#1:4245\n134#1:3164,9\n134#1:3181,2\n153#1:3183,4\n153#1:3284,8\n221#1:3375,9\n221#1:3465,2\n718#1:3683,4\n718#1:3754,8\n769#1:3814,4\n769#1:3885,8\n138#1:3173\n138#1:3176\n141#1:3177\n141#1:3180\n138#1:3174,2\n141#1:3178,2\n183#1:3292,2\n154#1:3280\n194#1:3374\n225#1:3464\n356#1:3548\n414#1:3629\n1487#1:4089\n719#1:3744\n771#1:3875\n804#1:3943\n994#1:3996\n1535#1:4139\n2129#1:4149,11\n2184#1:4160,11\n2392#1:4175,3\n2392#1:4178,8\n2447#1:4186,3\n2447#1:4189,8\n2466#1:4197,8\n2496#1:4205,3\n2496#1:4208,8\n2557#1:4216,8\n2606#1:4227\n2606#1:4228,2\n2607#1:4230,14\n2671#1:4246\n2671#1:4247,2\n2672#1:4249,14\n2712#1:4263\n2712#1:4264,2\n2713#1:4266,14\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    @JvmField
    @Nullable
    public final Function1<E, Unit> onUndeliveredElement;

    @Nullable
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u0006H\u0096B¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", FirebaseAnalytics.Param.INDEX, "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3086:1\n909#2,52:3087\n987#2,8:3143\n881#2:3151\n905#2,33:3152\n997#2:3185\n939#2,14:3186\n958#2,3:3201\n1002#2,6:3204\n336#3,4:3139\n340#3,8:3210\n905#4:3200\n57#5,2:3218\n57#5,2:3221\n1#6:3220\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1618#1:3087,52\n1655#1:3143,8\n1655#1:3151\n1655#1:3152,33\n1655#1:3185\n1655#1:3186,14\n1655#1:3201,3\n1655#1:3204,6\n1653#1:3139,4\n1653#1:3210,8\n1655#1:3200\n1691#1:3218,2\n1739#1:3221,2\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {

        @Nullable
        private CancellableContinuationImpl<? super Boolean> continuation;

        @Nullable
        private Object receiveResult;

        public BufferedChannelIterator() {
            Symbol symbol;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            this.receiveResult = symbol;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i10, long j10, Continuation<? super Boolean> continuation) {
            Symbol symbol;
            Symbol symbol2;
            Boolean boxBoolean;
            Symbol symbol3;
            Symbol symbol4;
            Symbol symbol5;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i10, j10, this);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive == symbol) {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i10);
                } else {
                    symbol2 = BufferedChannelKt.FAILED;
                    Function1<? super Throwable, Unit> function1 = null;
                    if (updateCellReceive == symbol2) {
                        if (j10 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                                break;
                            }
                            long andIncrement = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                            int i11 = BufferedChannelKt.SEGMENT_SIZE;
                            long j11 = andIncrement / i11;
                            int i12 = (int) (andIncrement % i11);
                            if (((Segment) channelSegment2).id != j11) {
                                ChannelSegment findSegmentReceive = bufferedChannel.findSegmentReceive(j11, channelSegment2);
                                if (findSegmentReceive != null) {
                                    channelSegment2 = findSegmentReceive;
                                }
                            }
                            Object updateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i12, andIncrement, this);
                            symbol3 = BufferedChannelKt.SUSPEND;
                            if (updateCellReceive2 == symbol3) {
                                bufferedChannel.prepareReceiverForSuspension(this, channelSegment2, i12);
                                break;
                            }
                            symbol4 = BufferedChannelKt.FAILED;
                            if (updateCellReceive2 != symbol4) {
                                symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                if (updateCellReceive2 != symbol5) {
                                    channelSegment2.cleanPrev();
                                    this.receiveResult = updateCellReceive2;
                                    this.continuation = null;
                                    boxBoolean = Boxing.boxBoolean(true);
                                    Function1<E, Unit> function12 = bufferedChannel.onUndeliveredElement;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive2, orCreateCancellableContinuation.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        this.continuation = null;
                        boxBoolean = Boxing.boxBoolean(true);
                        Function1<E, Unit> function13 = bufferedChannel.onUndeliveredElement;
                        if (function13 != null) {
                            function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                        }
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, function1);
                }
                Object result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            ConcurrentLinkedListNode concurrentLinkedListNode;
            Symbol symbol;
            Symbol symbol2;
            Symbol symbol3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$volatile$FU().get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j10 = andIncrement / i10;
                int i11 = (int) (andIncrement % i10);
                if (((Segment) concurrentLinkedListNode2).id != j10) {
                    ConcurrentLinkedListNode findSegmentReceive = bufferedChannel.findSegmentReceive(j10, concurrentLinkedListNode2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        concurrentLinkedListNode = findSegmentReceive;
                    }
                } else {
                    concurrentLinkedListNode = concurrentLinkedListNode2;
                }
                Object updateCellReceive = bufferedChannel.updateCellReceive(concurrentLinkedListNode, i11, andIncrement, null);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol) {
                    symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol2) {
                        symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive == symbol3) {
                            return hasNextOnNoWaiterSuspend(concurrentLinkedListNode, i11, andIncrement, continuation);
                        }
                        concurrentLinkedListNode.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        return Boxing.boxBoolean(true);
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        concurrentLinkedListNode.cleanPrev();
                    }
                    concurrentLinkedListNode2 = concurrentLinkedListNode;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final boolean tryResumeHasNext(E element) {
            boolean tryResume0;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1 function1 = null;
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function12 = BufferedChannel.this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, element, cancellableContinuationImpl.getContext());
            }
            tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, function1);
            return tryResume0;
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            Symbol symbol;
            Symbol symbol2;
            E e10 = (E) this.receiveResult;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e10 != symbol) {
                symbol2 = BufferedChannelKt.NO_RECEIVE_RESULT;
                this.receiveResult = symbol2;
                if (e10 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e10;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", FirebaseAnalytics.Param.INDEX, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;

        @NotNull
        private final CancellableContinuation<Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(@NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
        }

        @NotNull
        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int i10, @Nullable Function1<? super E, Unit> function1) {
        long initialBufferEnd;
        Symbol symbol;
        this.capacity = i10;
        this.onUndeliveredElement = function1;
        if (i10 >= 0) {
            initialBufferEnd = BufferedChannelKt.initialBufferEnd(i10);
            this.bufferEnd$volatile = initialBufferEnd;
            this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
            ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
            this.sendSegment$volatile = channelSegment;
            this.receiveSegment$volatile = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = channelSegment;
            this.onUndeliveredElementReceiveCancellationConstructor = function1 != 0 ? new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                final /* synthetic */ BufferedChannel<E> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function3
                @NotNull
                public final Function1<Throwable, Unit> invoke(@NotNull final SelectInstance<?> selectInstance, @Nullable Object obj, @Nullable final Object obj2) {
                    final BufferedChannel<E> bufferedChannel = this.this$0;
                    return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable th) {
                            if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                                OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj2, selectInstance.getContext());
                            }
                        }
                    };
                }
            } : null;
            symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
            this._closeCause$volatile = symbol;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        if (curSenders >= getBufferEndCounter() && curSenders >= getReceiversCounter$kotlinx_coroutines_core() + this.capacity) {
            return false;
        }
        return true;
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        Symbol symbol;
        Object obj = InlineList.constructor-impl$default((Object) null, 1, (DefaultConstructorMarker) null);
        loop0: while (lastSegment != null) {
            for (int i10 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i10; i10--) {
                if ((((Segment) lastSegment).id * BufferedChannelKt.SEGMENT_SIZE) + i10 < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i10);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol) {
                            if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                                if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    obj = InlineList.plus-FjFbRPM(obj, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                    lastSegment.onCancelledRequest(i10, true);
                                    break;
                                }
                            } else {
                                if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                    break;
                                }
                                if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    obj = InlineList.plus-FjFbRPM(obj, state$kotlinx_coroutines_core);
                                    lastSegment.onCancelledRequest(i10, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        lastSegment.onSlotCleaned();
                        break;
                    }
                }
            }
            lastSegment = (ChannelSegment) lastSegment.getPrev();
        }
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) obj);
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) obj;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (((Segment) channelSegment).id > ((Segment) ((ChannelSegment) obj)).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (((Segment) channelSegment2).id > ((Segment) ((ChannelSegment) obj)).id) {
            obj = channelSegment2;
        }
        return ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, sendersCur);
        return closeLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (((Segment) channelSegment).id < j10 && channelSegment.getNext() != null) {
                    moveSegmentBufferEndToSpecifiedOrLast(j10, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (((Segment) channelSegment).id != j10) {
                ChannelSegment<E> findSegmentBufferEnd = findSegmentBufferEnd(j10, channelSegment, andIncrement);
                if (findSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = findSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % i10), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
                Segment segment = SegmentOrClosed.getSegment-impl(findSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment2.id >= segment.id) {
                        break loop0;
                    }
                    if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (b.a(atomicReferenceFieldUpdater, this, segment2, segment)) {
                        if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.getSegment-impl(findSegmentInternal);
        if (((Segment) channelSegment).id > id) {
            long j10 = ((Segment) channelSegment).id;
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            if (bufferEnd$volatile$FU.compareAndSet(this, currentBufferEndCounter + 1, j10 * i10)) {
                incCompletedExpandBufferAttempts((((Segment) channelSegment).id * i10) - currentBufferEndCounter);
                return null;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        return channelSegment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
                Segment segment = SegmentOrClosed.getSegment-impl(findSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment2.id >= segment.id) {
                        break loop0;
                    }
                    if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (b.a(atomicReferenceFieldUpdater, this, segment2, segment)) {
                        if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (((Segment) startFrom).id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.getSegment-impl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment segment3 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment3.id >= ((Segment) channelSegment).id || !channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (b.a(atomicReferenceFieldUpdater2, this, segment3, channelSegment)) {
                    if (segment3.decPointers$kotlinx_coroutines_core()) {
                        segment3.remove();
                    }
                } else if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                    channelSegment.remove();
                }
            }
        }
        long j10 = ((Segment) channelSegment).id;
        if (j10 > id) {
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            updateReceiversCounterIfLower(j10 * i10);
            if (((Segment) channelSegment).id * i10 >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        return channelSegment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
                Segment segment = SegmentOrClosed.getSegment-impl(findSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment2.id >= segment.id) {
                        break loop0;
                    }
                    if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (b.a(atomicReferenceFieldUpdater, this, segment2, segment)) {
                        if (segment2.decPointers$kotlinx_coroutines_core()) {
                            segment2.remove();
                        }
                    } else if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.isClosed-impl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (((Segment) startFrom).id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.getSegment-impl(findSegmentInternal);
        long j10 = ((Segment) channelSegment).id;
        if (j10 > id) {
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            updateSendersCounterIfLower(j10 * i10);
            if (((Segment) channelSegment).id * i10 >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        return channelSegment;
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!b.a(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
        return closeCause;
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, nAttempts) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 4611686018427387904L) != 0);
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(j10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!b.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                        if (state$kotlinx_coroutines_core != symbol3 && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            symbol4 = BufferedChannelKt.DONE_RCV;
                            if (state$kotlinx_coroutines_core != symbol4) {
                                symbol5 = BufferedChannelKt.POISONED;
                                if (state$kotlinx_coroutines_core != symbol5) {
                                    symbol6 = BufferedChannelKt.RESUMING_BY_EB;
                                    if (state$kotlinx_coroutines_core != symbol6) {
                                        symbol7 = BufferedChannelKt.RESUMING_BY_RCV;
                                        if (state$kotlinx_coroutines_core == symbol7 || globalIndex != getReceiversCounter$kotlinx_coroutines_core()) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }
            }
            symbol = BufferedChannelKt.POISONED;
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i10 = (int) (sendersAndCloseStatusCur >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
            } else {
                throw new IllegalStateException(("unexpected close status: " + i10).toString());
            }
        } else {
            completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
            if (isClosedForReceive && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        }
        return true;
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long j10) {
        return isClosed(j10, true);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j10) {
        return isClosed(j10, false);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        if (bufferEndCounter != 0 && bufferEndCounter != LongCompanionObject.MAX_VALUE) {
            return false;
        }
        return true;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r9 = (kotlinx.coroutines.channels.ChannelSegment) r9.getPrev();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> lastSegment) {
        Symbol symbol;
        do {
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i10--;
                if (-1 >= i10) {
                    break;
                }
                long j10 = (((Segment) lastSegment).id * BufferedChannelKt.SEGMENT_SIZE) + i10;
                if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i10);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol) {
                            if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                                return j10;
                            }
                        }
                    }
                    if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        lastSegment.onSlotCleaned();
                        break;
                    }
                }
            }
        } while (lastSegment != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long j10;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) == 0) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 1);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, constructSendersAndCloseStatus));
    }

    private final void markCancelled() {
        long j10;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, constructSendersAndCloseStatus));
    }

    private final void markClosed() {
        long j10;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j10 & 1152921504606846975L, 2);
            } else if (i10 == 1) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j10 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, constructSendersAndCloseStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2;
        while (((Segment) startFrom).id < id && (channelSegment2 = (ChannelSegment) startFrom.getNext()) != null) {
            startFrom = channelSegment2;
        }
        while (true) {
            if (startFrom.isRemoved() && (channelSegment = (ChannelSegment) startFrom.getNext()) != null) {
                startFrom = channelSegment;
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id < ((Segment) startFrom).id) {
                        if (!startFrom.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        if (b.a(atomicReferenceFieldUpdater, this, segment, startFrom)) {
                            if (segment.decPointers$kotlinx_coroutines_core()) {
                                segment.remove();
                                return;
                            }
                            return;
                        } else if (startFrom.decPointers$kotlinx_coroutines_core()) {
                            startFrom.remove();
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m٥٤٤constructorimpl(ChannelResult.m٢١٧١boximpl(ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getCloseCause()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onClosedSend(E e10, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e10, (UndeliveredElementException) null, 2, (Object) null)) != null) {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        } else {
            Throwable sendException = getSendException();
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(sendException)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        Throwable sendException = getSendException();
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i10) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i10) {
        waiter.invokeOnCancellation(channelSegment, i10 + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceive(Object ignoredParam, Object selectResult) {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        Object obj;
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            obj = ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getCloseCause());
        } else {
            obj = ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(selectResult);
        }
        return ChannelResult.m٢١٧١boximpl(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (getCloseCause() == null) {
                return null;
            }
            throw getReceiveException();
        }
        return selectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectSend(Object ignoredParam, Object selectResult) {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (((Segment) concurrentLinkedListNode).id != j10) {
                ConcurrentLinkedListNode findSegmentReceive = bufferedChannel.findSegmentReceive(j10, concurrentLinkedListNode);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    concurrentLinkedListNode = findSegmentReceive;
                }
            }
            Object updateCellReceive = bufferedChannel.updateCellReceive(concurrentLinkedListNode, i11, andIncrement, null);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive != symbol) {
                symbol2 = BufferedChannelKt.FAILED;
                if (updateCellReceive != symbol2) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    if (updateCellReceive == symbol3) {
                        return bufferedChannel.receiveOnNoWaiterSuspend(concurrentLinkedListNode, i11, andIncrement, continuation);
                    }
                    concurrentLinkedListNode.cleanPrev();
                    return updateCellReceive;
                }
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    concurrentLinkedListNode.cleanPrev();
                }
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object m٢١٥٨receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        int i10;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i11 = bufferedChannel$receiveCatching$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i11 - Integer.MIN_VALUE;
                BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$12 = bufferedChannel$receiveCatching$1;
                Object obj = bufferedChannel$receiveCatching$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = bufferedChannel$receiveCatching$12.label;
                if (i10 == 0) {
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return ((ChannelResult) obj).getHolder();
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ChannelSegment<E> channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                    int i12 = BufferedChannelKt.SEGMENT_SIZE;
                    long j10 = andIncrement / i12;
                    int i13 = (int) (andIncrement % i12);
                    if (((Segment) channelSegment).id != j10) {
                        ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j10, channelSegment);
                        if (findSegmentReceive == null) {
                            continue;
                        } else {
                            channelSegment = findSegmentReceive;
                        }
                    }
                    Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i13, andIncrement, null);
                    symbol = BufferedChannelKt.SUSPEND;
                    if (updateCellReceive != symbol) {
                        symbol2 = BufferedChannelKt.FAILED;
                        if (updateCellReceive != symbol2) {
                            symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                            if (updateCellReceive == symbol3) {
                                bufferedChannel$receiveCatching$12.label = 1;
                                Object obj2 = bufferedChannel.m٢١٥٩receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i13, andIncrement, bufferedChannel$receiveCatching$12);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return obj2;
                            }
                            channelSegment.cleanPrev();
                            return ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(updateCellReceive);
                        }
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                }
                return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(bufferedChannel.getCloseCause());
            }
        }
        bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$122 = bufferedChannel$receiveCatching$1;
        Object obj3 = bufferedChannel$receiveCatching$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = bufferedChannel$receiveCatching$122.label;
        if (i10 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m٢١٥٩receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> channelSegment, int i10, long j10, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        int i11;
        Symbol symbol;
        Symbol symbol2;
        ChannelResult channelResult;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            int i12 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i12 - Integer.MIN_VALUE;
                Object obj = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i11 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
                if (i11 == 0) {
                    if (i11 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = channelSegment;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = i10;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = j10;
                    bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
                    CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
                    try {
                        Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                        ReceiveCatching receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
                        Object updateCellReceive = updateCellReceive(channelSegment, i10, j10, receiveCatching);
                        symbol = BufferedChannelKt.SUSPEND;
                        if (updateCellReceive == symbol) {
                            prepareReceiverForSuspension(receiveCatching, channelSegment, i10);
                        } else {
                            symbol2 = BufferedChannelKt.FAILED;
                            Function1<? super Throwable, Unit> function1 = null;
                            if (updateCellReceive == symbol2) {
                                if (j10 < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                ChannelSegment channelSegment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
                                while (true) {
                                    if (isClosedForReceive()) {
                                        onClosedReceiveCatchingOnNoWaiterSuspend(orCreateCancellableContinuation);
                                        break;
                                    }
                                    long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
                                    int i13 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j11 = andIncrement / i13;
                                    int i14 = (int) (andIncrement % i13);
                                    if (((Segment) channelSegment2).id != j11) {
                                        ChannelSegment findSegmentReceive = findSegmentReceive(j11, channelSegment2);
                                        if (findSegmentReceive != null) {
                                            channelSegment2 = findSegmentReceive;
                                        }
                                    }
                                    Object updateCellReceive2 = updateCellReceive(channelSegment2, i14, andIncrement, receiveCatching);
                                    symbol3 = BufferedChannelKt.SUSPEND;
                                    if (updateCellReceive2 == symbol3) {
                                        prepareReceiverForSuspension(receiveCatching, channelSegment2, i14);
                                        break;
                                    }
                                    symbol4 = BufferedChannelKt.FAILED;
                                    if (updateCellReceive2 != symbol4) {
                                        symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                        if (updateCellReceive2 != symbol5) {
                                            channelSegment2.cleanPrev();
                                            channelResult = ChannelResult.m٢١٧١boximpl(ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(updateCellReceive2));
                                            Function1<E, Unit> function12 = this.onUndeliveredElement;
                                            if (function12 != null) {
                                                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive2, orCreateCancellableContinuation.getContext());
                                            }
                                        } else {
                                            throw new IllegalStateException("unexpected");
                                        }
                                    } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment2.cleanPrev();
                                    }
                                }
                            } else {
                                channelSegment.cleanPrev();
                                channelResult = ChannelResult.m٢١٧١boximpl(ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(updateCellReceive));
                                Function1<E, Unit> function13 = this.onUndeliveredElement;
                                if (function13 != null) {
                                    function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                                }
                            }
                            orCreateCancellableContinuation.resume(channelResult, function1);
                        }
                        obj = orCreateCancellableContinuation.getResult();
                        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th;
                    }
                }
                return ((ChannelResult) obj).getHolder();
            }
        }
        bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
        Object obj2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i11 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i11 == 0) {
        }
        return ((ChannelResult) obj2).getHolder();
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        Symbol symbol;
        Waiter waiter2;
        Symbol symbol2;
        Symbol symbol3;
        ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (((Segment) concurrentLinkedListNode).id != j10) {
                ConcurrentLinkedListNode findSegmentReceive = findSegmentReceive(j10, (ChannelSegment) concurrentLinkedListNode);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    concurrentLinkedListNode = (Object) findSegmentReceive;
                }
            }
            Symbol symbol4 = (Object) updateCellReceive(concurrentLinkedListNode, i11, andIncrement, waiter);
            symbol = BufferedChannelKt.SUSPEND;
            if (symbol4 != symbol) {
                symbol2 = BufferedChannelKt.FAILED;
                if (symbol4 != symbol2) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    if (symbol4 == symbol3) {
                        return onNoWaiterSuspend.invoke(concurrentLinkedListNode, Integer.valueOf(i11), Long.valueOf(andIncrement));
                    }
                    concurrentLinkedListNode.cleanPrev();
                    return onElementRetrieved.invoke(symbol4);
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    concurrentLinkedListNode.cleanPrev();
                }
            } else {
                if (waiter instanceof Waiter) {
                    waiter2 = (Waiter) waiter;
                } else {
                    waiter2 = null;
                }
                if (waiter2 != null) {
                    prepareReceiverForSuspension(waiter2, (ChannelSegment) concurrentLinkedListNode, i11);
                }
                return onSuspend.invoke(concurrentLinkedListNode, Integer.valueOf(i11), Long.valueOf(andIncrement));
            }
        }
        return onClosed.invoke();
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i10, Object obj2) {
        Symbol symbol;
        Waiter waiter;
        Symbol symbol2;
        Symbol symbol3;
        if (obj2 == null) {
            if ((i10 & 16) != 0) {
                function32 = new Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel$receiveImpl$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                        return invoke((ChannelSegment) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                    }

                    @NotNull
                    public final Void invoke(@NotNull ChannelSegment<E> channelSegment, int i11, long j10) {
                        throw new IllegalStateException("unexpected");
                    }
                };
            }
            ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                int i11 = BufferedChannelKt.SEGMENT_SIZE;
                long j10 = andIncrement / i11;
                int i12 = (int) (andIncrement % i11);
                if (((Segment) channelSegment).id != j10) {
                    ChannelSegment findSegmentReceive = bufferedChannel.findSegmentReceive(j10, channelSegment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                }
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i12, andIncrement, obj);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol) {
                    symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol2) {
                        symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive == symbol3) {
                            return function32.invoke(channelSegment, Integer.valueOf(i12), Long.valueOf(andIncrement));
                        }
                        channelSegment.cleanPrev();
                        return function1.invoke(updateCellReceive);
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    if (obj instanceof Waiter) {
                        waiter = (Waiter) obj;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        bufferedChannel.prepareReceiverForSuspension(waiter, channelSegment, i12);
                    }
                    return function3.invoke(channelSegment, Integer.valueOf(i12), Long.valueOf(andIncrement));
                }
            }
            return function0.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> segment, int index, long r10, Waiter waiter, Function1<? super E, Unit> onElementRetrieved, Function0<Unit> onClosed) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6 = (Object) updateCellReceive(segment, index, r10, waiter);
        symbol = BufferedChannelKt.SUSPEND;
        if (symbol6 == symbol) {
            prepareReceiverForSuspension(waiter, segment, index);
            return;
        }
        symbol2 = BufferedChannelKt.FAILED;
        if (symbol6 == symbol2) {
            if (r10 < getSendersCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
            while (!isClosedForReceive()) {
                long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j10 = andIncrement / i10;
                int i11 = (int) (andIncrement % i10);
                if (((Segment) channelSegment).id != j10) {
                    ChannelSegment findSegmentReceive = findSegmentReceive(j10, channelSegment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                }
                Symbol symbol7 = (Object) updateCellReceive(channelSegment, i11, andIncrement, waiter);
                symbol3 = BufferedChannelKt.SUSPEND;
                if (symbol7 != symbol3) {
                    symbol4 = BufferedChannelKt.FAILED;
                    if (symbol7 != symbol4) {
                        symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (symbol7 != symbol5) {
                            channelSegment.cleanPrev();
                            onElementRetrieved.invoke(symbol7);
                            return;
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    if (!(waiter instanceof Waiter)) {
                        waiter = null;
                    }
                    if (waiter != null) {
                        prepareReceiverForSuspension(waiter, channelSegment, i11);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
            onClosed.invoke();
            return;
        }
        segment.cleanPrev();
        onElementRetrieved.invoke(symbol6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i10, long j10, Continuation<? super E> continuation) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            Object updateCellReceive = updateCellReceive(channelSegment, i10, j10, orCreateCancellableContinuation);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive == symbol) {
                prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i10);
            } else {
                symbol2 = BufferedChannelKt.FAILED;
                Function1<? super Throwable, Unit> function1 = null;
                function1 = null;
                CancellableContinuationImpl cancellableContinuationImpl = null;
                if (updateCellReceive == symbol2) {
                    if (j10 < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
                        int i11 = BufferedChannelKt.SEGMENT_SIZE;
                        long j11 = andIncrement / i11;
                        int i12 = (int) (andIncrement % i11);
                        if (((Segment) channelSegment2).id != j11) {
                            ChannelSegment findSegmentReceive = findSegmentReceive(j11, channelSegment2);
                            if (findSegmentReceive != null) {
                                channelSegment2 = findSegmentReceive;
                            }
                        }
                        updateCellReceive = updateCellReceive(channelSegment2, i12, andIncrement, orCreateCancellableContinuation);
                        symbol3 = BufferedChannelKt.SUSPEND;
                        if (updateCellReceive != symbol3) {
                            symbol4 = BufferedChannelKt.FAILED;
                            if (updateCellReceive != symbol4) {
                                symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                if (updateCellReceive != symbol5) {
                                    channelSegment2.cleanPrev();
                                    Function1<E, Unit> function12 = this.onUndeliveredElement;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive, orCreateCancellableContinuation.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        } else {
                            if (orCreateCancellableContinuation instanceof Waiter) {
                                cancellableContinuationImpl = orCreateCancellableContinuation;
                            }
                            if (cancellableContinuationImpl != null) {
                                prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment2, i12);
                            }
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function13 = this.onUndeliveredElement;
                    if (function13 != null) {
                        function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                    }
                }
                orCreateCancellableContinuation.resume(updateCellReceive, function1);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        Symbol symbol;
        Waiter waiter;
        Symbol symbol2;
        Symbol symbol3;
        ChannelSegment channelSegment = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (((Segment) channelSegment).id != j10) {
                ChannelSegment findSegmentReceive = findSegmentReceive(j10, channelSegment);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            }
            Object updateCellReceive = updateCellReceive(channelSegment, i11, andIncrement, select);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive != symbol) {
                symbol2 = BufferedChannelKt.FAILED;
                if (updateCellReceive != symbol2) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    if (updateCellReceive != symbol3) {
                        channelSegment.cleanPrev();
                        select.selectInRegistrationPhase(updateCellReceive);
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (select instanceof Waiter) {
                    waiter = (Waiter) select;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i11);
                    return;
                }
                return;
            }
        }
        onClosedSelectOnReceive(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b4, code lost:
    
        r13 = (kotlinx.coroutines.channels.ChannelSegment) r13.getPrev();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeUnprocessedElements(ChannelSegment<E> lastSegment) {
        Symbol symbol;
        Symbol symbol2;
        Waiter waiter;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementException = null;
        Object obj = InlineList.constructor-impl$default((Object) null, 1, (DefaultConstructorMarker) null);
        loop0: do {
            int i10 = BufferedChannelKt.SEGMENT_SIZE - 1;
            while (true) {
                if (-1 >= i10) {
                    break;
                }
                long j10 = (((Segment) lastSegment).id * BufferedChannelKt.SEGMENT_SIZE) + i10;
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i10);
                    symbol = BufferedChannelKt.DONE_RCV;
                    if (state$kotlinx_coroutines_core == symbol) {
                        break loop0;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        symbol2 = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol2 && state$kotlinx_coroutines_core != null) {
                            if (!(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                                symbol3 = BufferedChannelKt.RESUMING_BY_EB;
                                if (state$kotlinx_coroutines_core == symbol3) {
                                    break loop0;
                                }
                                symbol4 = BufferedChannelKt.RESUMING_BY_RCV;
                                if (state$kotlinx_coroutines_core == symbol4) {
                                    break loop0;
                                }
                                symbol5 = BufferedChannelKt.RESUMING_BY_EB;
                                if (state$kotlinx_coroutines_core != symbol5) {
                                    break;
                                }
                            } else {
                                if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    break loop0;
                                }
                                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                                    waiter = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                                } else {
                                    waiter = (Waiter) state$kotlinx_coroutines_core;
                                }
                                if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    if (function1 != null) {
                                        undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i10), undeliveredElementException);
                                    }
                                    obj = InlineList.plus-FjFbRPM(obj, waiter);
                                    lastSegment.cleanElement$kotlinx_coroutines_core(i10);
                                    lastSegment.onSlotCleaned();
                                }
                            }
                        } else if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    } else {
                        if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (function1 != null) {
                                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i10), undeliveredElementException);
                            }
                            lastSegment.cleanElement$kotlinx_coroutines_core(i10);
                            lastSegment.onSlotCleaned();
                        }
                    }
                }
                i10--;
            }
        } while (lastSegment != null);
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                resumeSenderOnCancelledChannel((Waiter) obj);
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) obj;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    resumeSenderOnCancelledChannel((Waiter) arrayList.get(size));
                }
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z10) {
        Throwable sendException;
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation<Boolean> cont = ((SendBroadcast) waiter).getCont();
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m٥٤٤constructorimpl(Boolean.FALSE));
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.INSTANCE;
            if (z10) {
                sendException = getReceiveException();
            } else {
                sendException = getSendException();
            }
            continuation.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(sendException)));
            return;
        }
        if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) waiter).cont;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ChannelResult.m٢١٧١boximpl(ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else {
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e10, Continuation<? super Unit> continuation) {
        ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j10 = 1152921504606846975L & andIncrement;
            boolean isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (((Segment) concurrentLinkedListNode).id != j11) {
                ConcurrentLinkedListNode findSegmentSend = bufferedChannel.findSegmentSend(j11, concurrentLinkedListNode);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        Object onClosedSend = bufferedChannel.onClosedSend(e10, continuation);
                        if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return onClosedSend;
                        }
                    }
                } else {
                    concurrentLinkedListNode = findSegmentSend;
                }
            }
            int updateCellSend = bufferedChannel.updateCellSend(concurrentLinkedListNode, i11, e10, j10, null, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend == 1) {
                    break;
                }
                if (updateCellSend != 2) {
                    if (updateCellSend != 3) {
                        if (updateCellSend != 4) {
                            if (updateCellSend == 5) {
                                concurrentLinkedListNode.cleanPrev();
                            }
                        } else {
                            if (j10 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                concurrentLinkedListNode.cleanPrev();
                            }
                            Object onClosedSend2 = bufferedChannel.onClosedSend(e10, continuation);
                            if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return onClosedSend2;
                            }
                        }
                    } else {
                        Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(concurrentLinkedListNode, i11, e10, j10, continuation);
                        if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return sendOnNoWaiterSuspend;
                        }
                    }
                } else if (isClosedForSend0) {
                    concurrentLinkedListNode.onSlotCleaned();
                    Object onClosedSend3 = bufferedChannel.onClosedSend(e10, continuation);
                    if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend3;
                    }
                }
            } else {
                concurrentLinkedListNode.cleanPrev();
                break;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a7, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r9.resumeWith(kotlin.Result.m٥٤٤constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> bufferedChannel, E e10, Continuation<? super Boolean> continuation) {
        ChannelSegment channelSegment;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (bufferedChannel.onUndeliveredElement == null) {
            SendBroadcast sendBroadcast = new SendBroadcast(cancellableContinuationImpl);
            ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
                long j10 = andIncrement & 1152921504606846975L;
                boolean isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j11 = j10 / i10;
                int i11 = (int) (j10 % i10);
                if (((Segment) channelSegment2).id != j11) {
                    ChannelSegment findSegmentSend = bufferedChannel.findSegmentSend(j11, channelSegment2);
                    if (findSegmentSend == null) {
                        if (isClosedForSend0) {
                            break;
                        }
                    } else {
                        channelSegment = findSegmentSend;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                ChannelSegment channelSegment3 = channelSegment;
                int updateCellSend = bufferedChannel.updateCellSend(channelSegment, i11, e10, j10, sendBroadcast, isClosedForSend0);
                if (updateCellSend != 0) {
                    if (updateCellSend == 1) {
                        break;
                    }
                    if (updateCellSend != 2) {
                        if (updateCellSend != 3) {
                            if (updateCellSend != 4) {
                                if (updateCellSend == 5) {
                                    channelSegment3.cleanPrev();
                                }
                                channelSegment2 = channelSegment3;
                            } else if (j10 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment3.cleanPrev();
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else if (!isClosedForSend0) {
                        bufferedChannel.prepareSenderForSuspension(sendBroadcast, channelSegment3, i11);
                    } else {
                        channelSegment3.onSlotCleaned();
                    }
                } else {
                    channelSegment3.cleanPrev();
                    break;
                }
            }
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(Boxing.boxBoolean(false)));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
    }

    private final <R> R sendImpl(E element, Object waiter, Function0<? extends R> onRendezvousOrBuffered, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, Function0<? extends R> onClosed, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        ConcurrentLinkedListNode concurrentLinkedListNode;
        Waiter waiter2;
        ConcurrentLinkedListNode concurrentLinkedListNode2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (((Segment) concurrentLinkedListNode2).id != j11) {
                ConcurrentLinkedListNode findSegmentSend = findSegmentSend(j11, concurrentLinkedListNode2);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        return onClosed.invoke();
                    }
                } else {
                    concurrentLinkedListNode = findSegmentSend;
                }
            } else {
                concurrentLinkedListNode = concurrentLinkedListNode2;
            }
            int updateCellSend = updateCellSend(concurrentLinkedListNode, i11, element, j10, waiter, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend != 1) {
                    if (updateCellSend != 2) {
                        if (updateCellSend != 3) {
                            if (updateCellSend != 4) {
                                if (updateCellSend == 5) {
                                    concurrentLinkedListNode.cleanPrev();
                                }
                                concurrentLinkedListNode2 = concurrentLinkedListNode;
                            } else {
                                if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    concurrentLinkedListNode.cleanPrev();
                                }
                                return onClosed.invoke();
                            }
                        } else {
                            return onNoWaiterSuspend.invoke(concurrentLinkedListNode, Integer.valueOf(i11), element, Long.valueOf(j10));
                        }
                    } else {
                        if (isClosedForSend0) {
                            concurrentLinkedListNode.onSlotCleaned();
                            return onClosed.invoke();
                        }
                        if (waiter instanceof Waiter) {
                            waiter2 = (Waiter) waiter;
                        } else {
                            waiter2 = null;
                        }
                        if (waiter2 != null) {
                            prepareSenderForSuspension(waiter2, concurrentLinkedListNode, i11);
                        }
                        return onSuspend.invoke(concurrentLinkedListNode, Integer.valueOf(i11));
                    }
                } else {
                    return onRendezvousOrBuffered.invoke();
                }
            } else {
                concurrentLinkedListNode.cleanPrev();
                return onRendezvousOrBuffered.invoke();
            }
        }
    }

    static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i10, Object obj3) {
        Function4 function42;
        ConcurrentLinkedListNode concurrentLinkedListNode;
        Waiter waiter;
        if (obj3 == null) {
            if ((i10 & 32) != 0) {
                function42 = new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                        return invoke((ChannelSegment<int>) obj4, ((Number) obj5).intValue(), (int) obj6, ((Number) obj7).longValue());
                    }

                    @NotNull
                    public final Void invoke(@NotNull ChannelSegment<E> channelSegment, int i11, E e10, long j10) {
                        throw new IllegalStateException("unexpected");
                    }
                };
            } else {
                function42 = function4;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
                long j10 = andIncrement & 1152921504606846975L;
                boolean isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
                int i11 = BufferedChannelKt.SEGMENT_SIZE;
                long j11 = j10 / i11;
                int i12 = (int) (j10 % i11);
                if (((Segment) concurrentLinkedListNode2).id != j11) {
                    ConcurrentLinkedListNode findSegmentSend = bufferedChannel.findSegmentSend(j11, concurrentLinkedListNode2);
                    if (findSegmentSend == null) {
                        if (isClosedForSend0) {
                            return function02.invoke();
                        }
                    } else {
                        concurrentLinkedListNode = findSegmentSend;
                    }
                } else {
                    concurrentLinkedListNode = concurrentLinkedListNode2;
                }
                int updateCellSend = bufferedChannel.updateCellSend(concurrentLinkedListNode, i12, obj, j10, obj2, isClosedForSend0);
                if (updateCellSend != 0) {
                    if (updateCellSend != 1) {
                        if (updateCellSend != 2) {
                            if (updateCellSend != 3) {
                                if (updateCellSend != 4) {
                                    if (updateCellSend == 5) {
                                        concurrentLinkedListNode.cleanPrev();
                                    }
                                    concurrentLinkedListNode2 = concurrentLinkedListNode;
                                } else {
                                    if (j10 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                        concurrentLinkedListNode.cleanPrev();
                                    }
                                    return function02.invoke();
                                }
                            } else {
                                return function42.invoke(concurrentLinkedListNode, Integer.valueOf(i12), obj, Long.valueOf(j10));
                            }
                        } else {
                            if (isClosedForSend0) {
                                concurrentLinkedListNode.onSlotCleaned();
                                return function02.invoke();
                            }
                            if (obj2 instanceof Waiter) {
                                waiter = (Waiter) obj2;
                            } else {
                                waiter = null;
                            }
                            if (waiter != null) {
                                bufferedChannel.prepareSenderForSuspension(waiter, concurrentLinkedListNode, i12);
                            }
                            return function2.invoke(concurrentLinkedListNode, Integer.valueOf(i12));
                        }
                    } else {
                        return function0.invoke();
                    }
                } else {
                    concurrentLinkedListNode.cleanPrev();
                    return function0.invoke();
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> segment, int index, E element, long s10, Waiter waiter, Function0<Unit> onRendezvousOrBuffered, Function0<Unit> onClosed) {
        ChannelSegment channelSegment;
        Unit unit;
        Waiter waiter2 = waiter;
        int updateCellSend = updateCellSend(segment, index, element, s10, waiter, false);
        if (updateCellSend != 0) {
            if (updateCellSend != 1) {
                if (updateCellSend == 2) {
                    prepareSenderForSuspension(waiter2, segment, index);
                    return;
                }
                if (updateCellSend != 4) {
                    if (updateCellSend == 5) {
                        segment.cleanPrev();
                        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                        while (true) {
                            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                            long j10 = andIncrement & 1152921504606846975L;
                            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
                            int i10 = BufferedChannelKt.SEGMENT_SIZE;
                            long j11 = j10 / i10;
                            int i11 = (int) (j10 % i10);
                            if (((Segment) channelSegment2).id != j11) {
                                ChannelSegment findSegmentSend = findSegmentSend(j11, channelSegment2);
                                if (findSegmentSend == null) {
                                    if (isClosedForSend0) {
                                        unit = onClosed.invoke();
                                        break;
                                    }
                                } else {
                                    channelSegment = findSegmentSend;
                                }
                            } else {
                                channelSegment = channelSegment2;
                            }
                            ChannelSegment channelSegment3 = channelSegment;
                            int updateCellSend2 = updateCellSend(channelSegment, i11, element, j10, waiter, isClosedForSend0);
                            if (updateCellSend2 != 0) {
                                if (updateCellSend2 != 1) {
                                    if (updateCellSend2 != 2) {
                                        if (updateCellSend2 != 3) {
                                            if (updateCellSend2 != 4) {
                                                if (updateCellSend2 == 5) {
                                                    channelSegment3.cleanPrev();
                                                }
                                                channelSegment2 = channelSegment3;
                                            } else {
                                                if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                                                    channelSegment3.cleanPrev();
                                                }
                                                unit = onClosed.invoke();
                                            }
                                        } else {
                                            throw new IllegalStateException("unexpected");
                                        }
                                    } else if (isClosedForSend0) {
                                        channelSegment3.onSlotCleaned();
                                        unit = onClosed.invoke();
                                    } else {
                                        if (!(waiter2 instanceof Waiter)) {
                                            waiter2 = null;
                                        }
                                        if (waiter2 != null) {
                                            prepareSenderForSuspension(waiter2, channelSegment3, i11);
                                        }
                                        unit = Unit.INSTANCE;
                                    }
                                } else {
                                    unit = onRendezvousOrBuffered.invoke();
                                    break;
                                }
                            } else {
                                channelSegment3.cleanPrev();
                                unit = onRendezvousOrBuffered.invoke();
                                break;
                            }
                        }
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (s10 < getReceiversCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                onClosed.invoke();
                return;
            }
            onRendezvousOrBuffered.invoke();
            return;
        }
        segment.cleanPrev();
        onRendezvousOrBuffered.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i10, E e10, long j10, Continuation<? super Unit> continuation) {
        Object obj;
        Object result;
        ChannelSegment channelSegment2;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            int updateCellSend = updateCellSend(channelSegment, i10, e10, j10, orCreateCancellableContinuation, false);
            if (updateCellSend != 0) {
                if (updateCellSend != 1) {
                    if (updateCellSend == 2) {
                        prepareSenderForSuspension(orCreateCancellableContinuation, channelSegment, i10);
                    } else {
                        if (updateCellSend != 4) {
                            if (updateCellSend == 5) {
                                channelSegment.cleanPrev();
                                ChannelSegment channelSegment3 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                                while (true) {
                                    long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                                    long j11 = andIncrement & 1152921504606846975L;
                                    boolean isClosedForSend0 = isClosedForSend0(andIncrement);
                                    int i11 = BufferedChannelKt.SEGMENT_SIZE;
                                    long j12 = j11 / i11;
                                    int i12 = (int) (j11 % i11);
                                    if (((Segment) channelSegment3).id != j12) {
                                        ChannelSegment findSegmentSend = findSegmentSend(j12, channelSegment3);
                                        if (findSegmentSend == null) {
                                            if (isClosedForSend0) {
                                                break;
                                            }
                                        } else {
                                            channelSegment2 = findSegmentSend;
                                        }
                                    } else {
                                        channelSegment2 = channelSegment3;
                                    }
                                    ChannelSegment channelSegment4 = channelSegment2;
                                    int updateCellSend2 = updateCellSend(channelSegment2, i12, e10, j11, orCreateCancellableContinuation, isClosedForSend0);
                                    if (updateCellSend2 != 0) {
                                        if (updateCellSend2 != 1) {
                                            if (updateCellSend2 != 2) {
                                                if (updateCellSend2 != 3) {
                                                    if (updateCellSend2 != 4) {
                                                        if (updateCellSend2 == 5) {
                                                            channelSegment4.cleanPrev();
                                                        }
                                                        channelSegment3 = channelSegment4;
                                                    } else if (j11 < getReceiversCounter$kotlinx_coroutines_core()) {
                                                        channelSegment4.cleanPrev();
                                                    }
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            } else if (isClosedForSend0) {
                                                channelSegment4.onSlotCleaned();
                                            } else {
                                                if (orCreateCancellableContinuation instanceof Waiter) {
                                                    cancellableContinuationImpl = orCreateCancellableContinuation;
                                                } else {
                                                    cancellableContinuationImpl = null;
                                                }
                                                if (cancellableContinuationImpl != null) {
                                                    prepareSenderForSuspension(cancellableContinuationImpl, channelSegment4, i12);
                                                }
                                            }
                                        } else {
                                            Result.Companion companion = Result.INSTANCE;
                                            obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
                                            break;
                                        }
                                    } else {
                                        channelSegment4.cleanPrev();
                                        Result.Companion companion2 = Result.INSTANCE;
                                        obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
                                        break;
                                    }
                                }
                            } else {
                                throw new IllegalStateException("unexpected");
                            }
                        } else if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        onClosedSendOnNoWaiterSuspend(e10, orCreateCancellableContinuation);
                    }
                    result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return result;
                    }
                    return Unit.INSTANCE;
                }
                Result.Companion companion3 = Result.INSTANCE;
                obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
            } else {
                channelSegment.cleanPrev();
                Result.Companion companion4 = Result.INSTANCE;
                obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
            }
            orCreateCancellableContinuation.resumeWith(obj);
            result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j10) {
        this.bufferEnd$volatile = j10;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j10) {
        this.completedExpandBuffersAndPauseFlag$volatile = j10;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j10) {
        this.receivers$volatile = j10;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j10) {
        this.sendersAndCloseStatus$volatile = j10;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e10) {
        boolean tryResume0;
        boolean tryResume02;
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e10);
        }
        Function1 function1 = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = receiveCatching.cont;
            ChannelResult channelResult = ChannelResult.m٢١٧١boximpl(ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(e10));
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e10, receiveCatching.cont.getContext());
            }
            tryResume02 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResult, function1);
            return tryResume02;
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e10);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1<E, Unit> function13 = this.onUndeliveredElement;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function13, e10, cancellableContinuation.getContext());
            }
            tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuation, e10, function1);
            return tryResume0;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i10) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i10);
            }
            if (trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j10;
        do {
            j10 = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j10, function1.invoke(Long.valueOf(j10)).longValue()));
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b10) {
        Symbol symbol;
        Symbol symbol2;
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if ((state$kotlinx_coroutines_core instanceof Waiter) && b10 >= receivers$volatile$FU.get(this)) {
            symbol = BufferedChannelKt.RESUMING_BY_EB;
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                if (!tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                    symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                    segment.setState$kotlinx_coroutines_core(index, symbol2);
                    segment.onCancelledRequest(index, false);
                    return false;
                }
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                return true;
            }
        }
        return updateCellExpandBufferSlow(segment, index, b10);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b10) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                if (state$kotlinx_coroutines_core == symbol3) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    symbol4 = BufferedChannelKt.IN_BUFFER;
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol4)) {
                        return true;
                    }
                } else if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    symbol5 = BufferedChannelKt.POISONED;
                    if (state$kotlinx_coroutines_core == symbol5) {
                        break;
                    }
                    symbol6 = BufferedChannelKt.DONE_RCV;
                    if (state$kotlinx_coroutines_core == symbol6) {
                        break;
                    }
                    symbol7 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core != symbol7 && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                        symbol8 = BufferedChannelKt.RESUMING_BY_RCV;
                        if (state$kotlinx_coroutines_core != symbol8) {
                            throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (b10 >= receivers$volatile$FU.get(this)) {
                symbol = BufferedChannelKt.RESUMING_BY_EB;
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                    if (!tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                        segment.setState$kotlinx_coroutines_core(index, symbol2);
                        segment.onCancelledRequest(index, false);
                        return false;
                    }
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                    return true;
                }
            } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> segment, int index, long r10, Object waiter) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r10 >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    return symbol3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.SUSPEND;
                    return symbol2;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
            symbol = BufferedChannelKt.DONE_RCV;
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                expandBuffer();
                return segment.retrieveElement$kotlinx_coroutines_core(index);
            }
        }
        return updateCellReceiveSlow(segment, index, r10, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r10, Object waiter) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        Symbol symbol9;
        Symbol symbol10;
        Symbol symbol11;
        Symbol symbol12;
        Symbol symbol13;
        Symbol symbol14;
        Symbol symbol15;
        Symbol symbol16;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol5 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol5) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        symbol6 = BufferedChannelKt.DONE_RCV;
                        if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol6)) {
                            expandBuffer();
                            return segment.retrieveElement$kotlinx_coroutines_core(index);
                        }
                    } else {
                        symbol7 = BufferedChannelKt.INTERRUPTED_SEND;
                        if (state$kotlinx_coroutines_core == symbol7) {
                            symbol8 = BufferedChannelKt.FAILED;
                            return symbol8;
                        }
                        symbol9 = BufferedChannelKt.POISONED;
                        if (state$kotlinx_coroutines_core == symbol9) {
                            symbol10 = BufferedChannelKt.FAILED;
                            return symbol10;
                        }
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            symbol12 = BufferedChannelKt.RESUMING_BY_EB;
                            if (state$kotlinx_coroutines_core != symbol12) {
                                symbol13 = BufferedChannelKt.RESUMING_BY_RCV;
                                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol13)) {
                                    boolean z10 = state$kotlinx_coroutines_core instanceof WaiterEB;
                                    if (z10) {
                                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                                    }
                                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                                        symbol16 = BufferedChannelKt.DONE_RCV;
                                        segment.setState$kotlinx_coroutines_core(index, symbol16);
                                        expandBuffer();
                                        return segment.retrieveElement$kotlinx_coroutines_core(index);
                                    }
                                    symbol14 = BufferedChannelKt.INTERRUPTED_SEND;
                                    segment.setState$kotlinx_coroutines_core(index, symbol14);
                                    segment.onCancelledRequest(index, false);
                                    if (z10) {
                                        expandBuffer();
                                    }
                                    symbol15 = BufferedChannelKt.FAILED;
                                    return symbol15;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            expandBuffer();
                            symbol11 = BufferedChannelKt.FAILED;
                            return symbol11;
                        }
                    }
                }
            }
            if (r10 < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                symbol = BufferedChannelKt.POISONED;
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, symbol)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.FAILED;
                    return symbol2;
                }
            } else {
                if (waiter == null) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    return symbol3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    symbol4 = BufferedChannelKt.SUSPEND;
                    return symbol4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s10, waiter, closed);
        }
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s10)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                symbol3 = BufferedChannelKt.DONE_RCV;
                segment.setState$kotlinx_coroutines_core(index, symbol3);
                onReceiveDequeued();
                return 0;
            }
            symbol = BufferedChannelKt.INTERRUPTED_RCV;
            Object andSetState$kotlinx_coroutines_core = segment.getAndSetState$kotlinx_coroutines_core(index, symbol);
            symbol2 = BufferedChannelKt.INTERRUPTED_RCV;
            if (andSetState$kotlinx_coroutines_core != symbol2) {
                segment.onCancelledRequest(index, true);
            }
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s10, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    symbol3 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core != symbol3) {
                        symbol4 = BufferedChannelKt.POISONED;
                        if (state$kotlinx_coroutines_core == symbol4) {
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            return 5;
                        }
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            completeCloseOrCancel();
                            return 4;
                        }
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                            state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                        }
                        if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                            symbol7 = BufferedChannelKt.DONE_RCV;
                            segment.setState$kotlinx_coroutines_core(index, symbol7);
                            onReceiveDequeued();
                            return 0;
                        }
                        symbol5 = BufferedChannelKt.INTERRUPTED_RCV;
                        Object andSetState$kotlinx_coroutines_core = segment.getAndSetState$kotlinx_coroutines_core(index, symbol5);
                        symbol6 = BufferedChannelKt.INTERRUPTED_RCV;
                        if (andSetState$kotlinx_coroutines_core != symbol6) {
                            segment.onCancelledRequest(index, true);
                        }
                        return 5;
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (bufferOrRendezvousSend(s10) && !closed) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (closed) {
                symbol = BufferedChannelKt.INTERRUPTED_SEND;
                if (segment.casState$kotlinx_coroutines_core(index, null, symbol)) {
                    segment.onCancelledRequest(index, false);
                    return 4;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long value) {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (j10 >= value) {
                return;
            }
        } while (!receivers$volatile$FU.compareAndSet(this, j10, value));
    }

    private final void updateSendersCounterIfLower(long value) {
        long j10;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            long j11 = 1152921504606846975L & j10;
            if (j11 < value) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j11, (int) (j10 >> 60));
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j10, constructSendersAndCloseStatus));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(@Nullable Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        boolean z10;
        Symbol symbol;
        Symbol symbol2;
        boolean areEqual;
        boolean areEqual2;
        Symbol symbol3;
        Symbol symbol4;
        boolean areEqual3;
        boolean z11;
        boolean z12;
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2;
        if (isRendezvousOrUnlimited()) {
            Object obj = bufferEndSegment$volatile$FU.get(this);
            channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
            if (obj != channelSegment2) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((Segment) ((ChannelSegment) receiveSegment$volatile$FU.get(this))).id > ((Segment) ((ChannelSegment) bufferEndSegment$volatile$FU.get(this))).id) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            ChannelSegment channelSegment3 = (ChannelSegment) obj2;
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            if (channelSegment3 != channelSegment) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j10 = ((Segment) ((ChannelSegment) next)).id;
                do {
                    Object next2 = it.next();
                    long j11 = ((Segment) ((ChannelSegment) next2)).id;
                    if (j10 > j11) {
                        next = next2;
                        j10 = j11;
                    }
                } while (it.hasNext());
            }
            ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) next;
            if (concurrentLinkedListNode.getPrev() == null) {
                while (concurrentLinkedListNode.getNext() != null) {
                    ChannelSegment next3 = concurrentLinkedListNode.getNext();
                    Intrinsics.checkNotNull(next3);
                    if (next3.getPrev() != null) {
                        ChannelSegment next4 = concurrentLinkedListNode.getNext();
                        Intrinsics.checkNotNull(next4);
                        if (next4.getPrev() != concurrentLinkedListNode) {
                            throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                        }
                    }
                    int i10 = BufferedChannelKt.SEGMENT_SIZE;
                    int i11 = 0;
                    for (int i12 = 0; i12 < i10; i12++) {
                        Object state$kotlinx_coroutines_core = concurrentLinkedListNode.getState$kotlinx_coroutines_core(i12);
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED) && !(state$kotlinx_coroutines_core instanceof Waiter)) {
                            symbol = BufferedChannelKt.INTERRUPTED_RCV;
                            if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol)) {
                                symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                                areEqual = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol2);
                            } else {
                                areEqual = true;
                            }
                            if (areEqual) {
                                areEqual2 = true;
                            } else {
                                areEqual2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                            }
                            if (!areEqual2) {
                                symbol3 = BufferedChannelKt.POISONED;
                                if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol3)) {
                                    symbol4 = BufferedChannelKt.DONE_RCV;
                                    areEqual3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol4);
                                } else {
                                    areEqual3 = true;
                                }
                                if (areEqual3) {
                                    if (concurrentLinkedListNode.getElement$kotlinx_coroutines_core(i12) == null) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    if (!z11) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } else {
                                    throw new IllegalStateException(("Unexpected segment cell state: " + state$kotlinx_coroutines_core + ".\nChannel state: " + this).toString());
                                }
                            } else {
                                if (concurrentLinkedListNode.getElement$kotlinx_coroutines_core(i12) == null) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (z12) {
                                    i11++;
                                } else {
                                    throw new IllegalStateException("Check failed.");
                                }
                            }
                        }
                    }
                    if (i11 == BufferedChannelKt.SEGMENT_SIZE) {
                        if (concurrentLinkedListNode != receiveSegment$volatile$FU.get(this) && concurrentLinkedListNode != sendSegment$volatile$FU.get(this) && concurrentLinkedListNode != bufferEndSegment$volatile$FU.get(this)) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (!z10) {
                            throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                        }
                    }
                    ConcurrentLinkedListNode next5 = concurrentLinkedListNode.getNext();
                    Intrinsics.checkNotNull(next5);
                    concurrentLinkedListNode = (ChannelSegment) next5;
                }
                return;
            }
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        throw new NoSuchElementException();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    protected boolean closeOrCancelImpl(@Nullable Throwable cause, boolean cancel) {
        Symbol symbol;
        if (cancel) {
            markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$volatile$FU;
        symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        boolean a10 = b.a(atomicReferenceFieldUpdater, this, symbol, cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (a10) {
            invokeCloseHandler();
        }
        return a10;
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        Symbol symbol;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long j10 = receivers$volatile$FU.get(this);
            if (globalCellIndex < Math.max(this.capacity + j10, getBufferEndCounter())) {
                return;
            }
            if (receivers$volatile$FU.compareAndSet(this, j10, j10 + 1)) {
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j11 = j10 / i10;
                int i11 = (int) (j10 % i10);
                if (((Segment) concurrentLinkedListNode).id != j11) {
                    ConcurrentLinkedListNode findSegmentReceive = findSegmentReceive(j11, concurrentLinkedListNode);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        concurrentLinkedListNode = findSegmentReceive;
                    }
                }
                Object updateCellReceive = updateCellReceive(concurrentLinkedListNode, i11, j10, null);
                symbol = BufferedChannelKt.FAILED;
                if (updateCellReceive == symbol) {
                    if (j10 < getSendersCounter$kotlinx_coroutines_core()) {
                        concurrentLinkedListNode.cleanPrev();
                    }
                } else {
                    concurrentLinkedListNode.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, (UndeliveredElementException) null, 2, (Object) null)) != null) {
                        throw callUndeliveredElementCatchingException$default;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
        return closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = receiversCounter$kotlinx_coroutines_core / i10;
            if (((Segment) channelSegment).id != j10 && (channelSegment = findSegmentReceive(j10, channelSegment)) == null) {
                if (((Segment) ((ChannelSegment) receiveSegment$volatile$FU.get(this))).id < j10) {
                    return false;
                }
            } else {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % i10), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol symbol3;
        Symbol symbol4;
        if (b.a(closeHandler$volatile$FU, this, null, handler)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$volatile$FU;
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            if (obj != symbol) {
                symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                if (obj == symbol2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = closeHandler$volatile$FU;
            symbol3 = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            symbol4 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
        } while (!b.a(atomicReferenceFieldUpdater, this, symbol3, symbol4));
        handler.invoke(getCloseCause());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return Channel.DefaultImpls.offer(this, e10);
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo٢١٩٢receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        return m٢١٥٨receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        r14.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        Waiter waiter;
        ConcurrentLinkedListNode concurrentLinkedListNode = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j10 = 1152921504606846975L & andIncrement;
            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (((Segment) concurrentLinkedListNode).id != j11) {
                ConcurrentLinkedListNode findSegmentSend = findSegmentSend(j11, concurrentLinkedListNode);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        break;
                    }
                } else {
                    concurrentLinkedListNode = findSegmentSend;
                }
            }
            int updateCellSend = updateCellSend(concurrentLinkedListNode, i11, element, j10, select, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend == 1) {
                    break;
                }
                if (updateCellSend != 2) {
                    if (updateCellSend != 3) {
                        if (updateCellSend != 4) {
                            if (updateCellSend == 5) {
                                concurrentLinkedListNode.cleanPrev();
                            }
                        } else if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                            concurrentLinkedListNode.cleanPrev();
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                } else if (isClosedForSend0) {
                    concurrentLinkedListNode.onSlotCleaned();
                } else {
                    if (select instanceof Waiter) {
                        waiter = (Waiter) select;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, concurrentLinkedListNode, i11);
                        return;
                    }
                    return;
                }
            } else {
                concurrentLinkedListNode.cleanPrev();
                break;
            }
        }
        onClosedSelectOnSend(element, select);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e10, @NotNull Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e10, continuation);
    }

    @Nullable
    public Object sendBroadcast$kotlinx_coroutines_core(E e10, @NotNull Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e10, continuation);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e3, code lost:
    
        r3 = r3.getNext();
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        Symbol symbol;
        Symbol symbol2;
        boolean areEqual;
        Symbol symbol3;
        boolean areEqual2;
        Symbol symbol4;
        boolean areEqual3;
        Symbol symbol5;
        boolean areEqual4;
        Symbol symbol6;
        boolean areEqual5;
        Symbol symbol7;
        boolean areEqual6;
        boolean areEqual7;
        String obj;
        ChannelSegment channelSegment;
        StringBuilder sb = new StringBuilder();
        int i10 = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i10 != 2) {
            if (i10 == 3) {
                sb.append("cancelled,");
            }
        } else {
            sb.append("closed,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listOf) {
            ChannelSegment channelSegment2 = (ChannelSegment) obj2;
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            if (channelSegment2 != channelSegment) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j10 = ((Segment) ((ChannelSegment) next)).id;
                do {
                    Object next2 = it.next();
                    long j11 = ((Segment) ((ChannelSegment) next2)).id;
                    if (j10 > j11) {
                        next = next2;
                        j10 = j11;
                    }
                } while (it.hasNext());
            }
            ChannelSegment channelSegment3 = (ChannelSegment) next;
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
            loop2: do {
                int i11 = BufferedChannelKt.SEGMENT_SIZE;
                int i12 = 0;
                while (true) {
                    if (i12 >= i11) {
                        break;
                    }
                    long j12 = (((Segment) channelSegment3).id * BufferedChannelKt.SEGMENT_SIZE) + i12;
                    if (j12 >= sendersCounter$kotlinx_coroutines_core && j12 >= receiversCounter$kotlinx_coroutines_core) {
                        break loop2;
                    }
                    Object state$kotlinx_coroutines_core = channelSegment3.getState$kotlinx_coroutines_core(i12);
                    Object element$kotlinx_coroutines_core = channelSegment3.getElement$kotlinx_coroutines_core(i12);
                    if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                        if (j12 < receiversCounter$kotlinx_coroutines_core && j12 >= sendersCounter$kotlinx_coroutines_core) {
                            obj = "receive";
                        } else if (j12 < sendersCounter$kotlinx_coroutines_core && j12 >= receiversCounter$kotlinx_coroutines_core) {
                            obj = "send";
                        } else {
                            obj = "cont";
                        }
                    } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                        if (j12 < receiversCounter$kotlinx_coroutines_core && j12 >= sendersCounter$kotlinx_coroutines_core) {
                            obj = "onReceive";
                        } else if (j12 < sendersCounter$kotlinx_coroutines_core && j12 >= receiversCounter$kotlinx_coroutines_core) {
                            obj = "onSend";
                        } else {
                            obj = "select";
                        }
                    } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                        obj = "receiveCatching";
                    } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                        obj = "sendBroadcast";
                    } else if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                        symbol = BufferedChannelKt.RESUMING_BY_RCV;
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol)) {
                            symbol2 = BufferedChannelKt.RESUMING_BY_EB;
                            areEqual = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol2);
                        } else {
                            areEqual = true;
                        }
                        if (areEqual) {
                            obj = "resuming_sender";
                        } else {
                            if (state$kotlinx_coroutines_core != null) {
                                symbol3 = BufferedChannelKt.IN_BUFFER;
                                areEqual2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol3);
                            } else {
                                areEqual2 = true;
                            }
                            if (!areEqual2) {
                                symbol4 = BufferedChannelKt.DONE_RCV;
                                areEqual3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol4);
                            } else {
                                areEqual3 = true;
                            }
                            if (!areEqual3) {
                                symbol5 = BufferedChannelKt.POISONED;
                                areEqual4 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol5);
                            } else {
                                areEqual4 = true;
                            }
                            if (!areEqual4) {
                                symbol6 = BufferedChannelKt.INTERRUPTED_RCV;
                                areEqual5 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol6);
                            } else {
                                areEqual5 = true;
                            }
                            if (!areEqual5) {
                                symbol7 = BufferedChannelKt.INTERRUPTED_SEND;
                                areEqual6 = Intrinsics.areEqual(state$kotlinx_coroutines_core, symbol7);
                            } else {
                                areEqual6 = true;
                            }
                            if (areEqual6) {
                                areEqual7 = true;
                            } else {
                                areEqual7 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                            }
                            if (!areEqual7) {
                                obj = state$kotlinx_coroutines_core.toString();
                            } else {
                                i12++;
                            }
                        }
                    } else {
                        obj = "EB(" + state$kotlinx_coroutines_core + ')';
                    }
                    if (element$kotlinx_coroutines_core != null) {
                        sb.append('(' + obj + ',' + element$kotlinx_coroutines_core + "),");
                    } else {
                        sb.append(obj + ',');
                    }
                    i12++;
                }
            } while (channelSegment3 != null);
            if (StringsKt.last(sb) == ',') {
                Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
            }
            sb.append("]");
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String toStringDebug$kotlinx_coroutines_core() {
        String str;
        String str2;
        String valueOf;
        ChannelSegment channelSegment;
        StringBuilder sb = new StringBuilder();
        sb.append("S=" + getSendersCounter$kotlinx_coroutines_core() + ",R=" + getReceiversCounter$kotlinx_coroutines_core() + ",B=" + getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$volatile$FU.get(this) + ",C=" + ((int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60)) + ',');
        int i10 = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    sb.append("CANCELLED,");
                }
            } else {
                sb.append("CLOSED,");
            }
        } else {
            sb.append("CANCELLATION_STARTED,");
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$volatile$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$volatile$FU.get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$volatile$FU.get(this)));
        }
        sb.append("  ");
        List listOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            ChannelSegment channelSegment2 = (ChannelSegment) obj;
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            if (channelSegment2 != channelSegment) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j10 = ((Segment) ((ChannelSegment) next)).id;
                do {
                    Object next2 = it.next();
                    long j11 = ((Segment) ((ChannelSegment) next2)).id;
                    if (j10 > j11) {
                        next = next2;
                        j10 = j11;
                    }
                } while (it.hasNext());
            }
            ChannelSegment channelSegment3 = (ChannelSegment) next;
            do {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(DebugStringsKt.getHexAddress(channelSegment3));
                sb2.append("=[");
                if (channelSegment3.isRemoved()) {
                    str = "*";
                } else {
                    str = "";
                }
                sb2.append(str);
                sb2.append(((Segment) channelSegment3).id);
                sb2.append(",prev=");
                ChannelSegment prev = channelSegment3.getPrev();
                String str3 = null;
                if (prev != null) {
                    str2 = DebugStringsKt.getHexAddress(prev);
                } else {
                    str2 = null;
                }
                sb2.append(str2);
                sb2.append(',');
                sb.append(sb2.toString());
                int i11 = BufferedChannelKt.SEGMENT_SIZE;
                for (int i12 = 0; i12 < i11; i12++) {
                    Object state$kotlinx_coroutines_core = channelSegment3.getState$kotlinx_coroutines_core(i12);
                    Object element$kotlinx_coroutines_core = channelSegment3.getElement$kotlinx_coroutines_core(i12);
                    if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                        valueOf = "cont";
                    } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                        valueOf = "select";
                    } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                        valueOf = "receiveCatching";
                    } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                        valueOf = "send(broadcast)";
                    } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        valueOf = "EB(" + state$kotlinx_coroutines_core + ')';
                    } else {
                        valueOf = String.valueOf(state$kotlinx_coroutines_core);
                    }
                    sb.append('[' + i12 + "]=(" + valueOf + ',' + element$kotlinx_coroutines_core + "),");
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("next=");
                ChannelSegment next3 = channelSegment3.getNext();
                if (next3 != null) {
                    str3 = DebugStringsKt.getHexAddress(next3);
                }
                sb3.append(str3);
                sb3.append("]  ");
                sb.append(sb3.toString());
                channelSegment3 = (ChannelSegment) channelSegment3.getNext();
            } while (channelSegment3 != null);
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo٢١٩٣tryReceivePtdJZtk() {
        Waiter waiter;
        ChannelSegment channelSegment;
        Symbol symbol;
        Waiter waiter2;
        Symbol symbol2;
        Symbol symbol3;
        long j10 = receivers$volatile$FU.get(this);
        long j11 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j11)) {
            return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getCloseCause());
        }
        if (j10 < (j11 & 1152921504606846975L)) {
            waiter = BufferedChannelKt.INTERRUPTED_RCV;
            ChannelSegment channelSegment2 = (ChannelSegment) access$getReceiveSegment$volatile$FU().get(this);
            while (!isClosedForReceive()) {
                long andIncrement = access$getReceivers$volatile$FU().getAndIncrement(this);
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j12 = andIncrement / i10;
                int i11 = (int) (andIncrement % i10);
                if (((Segment) channelSegment2).id != j12) {
                    ChannelSegment findSegmentReceive = findSegmentReceive(j12, channelSegment2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object updateCellReceive = updateCellReceive(channelSegment, i11, andIncrement, waiter);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol) {
                    symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol2) {
                        symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive != symbol3) {
                            channelSegment.cleanPrev();
                            return ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(updateCellReceive);
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else {
                    if (waiter instanceof Waiter) {
                        waiter2 = waiter;
                    } else {
                        waiter2 = null;
                    }
                    if (waiter2 != null) {
                        prepareReceiverForSuspension(waiter2, channelSegment, i11);
                    }
                    waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m٢١٨٥failurePtdJZtk();
                }
            }
            return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getCloseCause());
        }
        return ChannelResult.INSTANCE.m٢١٨٥failurePtdJZtk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo٢١٩٤trySendJP2dKIU(E element) {
        Waiter waiter;
        ConcurrentLinkedListNode concurrentLinkedListNode;
        Waiter waiter2;
        if (!shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            waiter = BufferedChannelKt.INTERRUPTED_SEND;
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                long j10 = andIncrement & 1152921504606846975L;
                boolean isClosedForSend0 = isClosedForSend0(andIncrement);
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j11 = j10 / i10;
                int i11 = (int) (j10 % i10);
                if (((Segment) concurrentLinkedListNode2).id != j11) {
                    ConcurrentLinkedListNode findSegmentSend = findSegmentSend(j11, concurrentLinkedListNode2);
                    if (findSegmentSend == null) {
                        if (isClosedForSend0) {
                            break;
                        }
                    } else {
                        concurrentLinkedListNode = findSegmentSend;
                    }
                } else {
                    concurrentLinkedListNode = concurrentLinkedListNode2;
                }
                int updateCellSend = updateCellSend(concurrentLinkedListNode, i11, element, j10, waiter, isClosedForSend0);
                if (updateCellSend != 0) {
                    if (updateCellSend == 1) {
                        break;
                    }
                    if (updateCellSend != 2) {
                        if (updateCellSend != 3) {
                            if (updateCellSend != 4) {
                                if (updateCellSend == 5) {
                                    concurrentLinkedListNode.cleanPrev();
                                }
                                concurrentLinkedListNode2 = concurrentLinkedListNode;
                            } else if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                                concurrentLinkedListNode.cleanPrev();
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else if (isClosedForSend0) {
                        concurrentLinkedListNode.onSlotCleaned();
                    } else {
                        if (waiter instanceof Waiter) {
                            waiter2 = waiter;
                        } else {
                            waiter2 = null;
                        }
                        if (waiter2 != null) {
                            prepareSenderForSuspension(waiter2, concurrentLinkedListNode, i11);
                        }
                        concurrentLinkedListNode.onSlotCleaned();
                        return ChannelResult.INSTANCE.m٢١٨٥failurePtdJZtk();
                    }
                } else {
                    concurrentLinkedListNode.cleanPrev();
                    break;
                }
            }
            return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getSendException());
        }
        return ChannelResult.INSTANCE.m٢١٨٥failurePtdJZtk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    public final Object m٢١٦٣trySendDropOldestJP2dKIU(E element) {
        ConcurrentLinkedListNode concurrentLinkedListNode;
        Waiter waiter;
        Waiter waiter2 = BufferedChannelKt.BUFFERED;
        ConcurrentLinkedListNode concurrentLinkedListNode2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (((Segment) concurrentLinkedListNode2).id != j11) {
                ConcurrentLinkedListNode findSegmentSend = findSegmentSend(j11, concurrentLinkedListNode2);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getSendException());
                    }
                } else {
                    concurrentLinkedListNode = findSegmentSend;
                }
            } else {
                concurrentLinkedListNode = concurrentLinkedListNode2;
            }
            int updateCellSend = updateCellSend(concurrentLinkedListNode, i11, element, j10, waiter2, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend != 1) {
                    if (updateCellSend != 2) {
                        if (updateCellSend != 3) {
                            if (updateCellSend != 4) {
                                if (updateCellSend == 5) {
                                    concurrentLinkedListNode.cleanPrev();
                                }
                                concurrentLinkedListNode2 = concurrentLinkedListNode;
                            } else {
                                if (j10 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    concurrentLinkedListNode.cleanPrev();
                                }
                                return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getSendException());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (isClosedForSend0) {
                            concurrentLinkedListNode.onSlotCleaned();
                            return ChannelResult.INSTANCE.m٢١٨٤closedJP2dKIU(getSendException());
                        }
                        if (waiter2 instanceof Waiter) {
                            waiter = waiter2;
                        } else {
                            waiter = null;
                        }
                        if (waiter != null) {
                            prepareSenderForSuspension(waiter, concurrentLinkedListNode, i11);
                        }
                        dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((((Segment) concurrentLinkedListNode).id * i10) + i11);
                        return ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(Unit.INSTANCE);
                    }
                } else {
                    return ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(Unit.INSTANCE);
                }
            } else {
                concurrentLinkedListNode.cleanPrev();
                return ChannelResult.INSTANCE.m٢١٨٦successJP2dKIU(Unit.INSTANCE);
            }
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        int i10;
        long j10;
        long constructEBCompletedAndPauseFlag;
        boolean z10;
        long constructEBCompletedAndPauseFlag2;
        long j11;
        long constructEBCompletedAndPauseFlag3;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        do {
        } while (getBufferEndCounter() <= globalIndex);
        i10 = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i11 = 0; i11 < i10; i11++) {
            long bufferEndCounter = getBufferEndCounter();
            if (bufferEndCounter == (completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & DurationKt.MAX_MILLIS) && bufferEndCounter == getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            constructEBCompletedAndPauseFlag = BufferedChannelKt.constructEBCompletedAndPauseFlag(j10 & DurationKt.MAX_MILLIS, true);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, constructEBCompletedAndPauseFlag));
        while (true) {
            long bufferEndCounter2 = getBufferEndCounter();
            long j12 = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
            long j13 = j12 & DurationKt.MAX_MILLIS;
            if ((4611686018427387904L & j12) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (bufferEndCounter2 == j13 && bufferEndCounter2 == getBufferEndCounter()) {
                break;
            }
            if (!z10) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
                constructEBCompletedAndPauseFlag2 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j13, true);
                atomicLongFieldUpdater2.compareAndSet(this, j12, constructEBCompletedAndPauseFlag2);
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater3 = completedExpandBuffersAndPauseFlag$volatile$FU;
        do {
            j11 = atomicLongFieldUpdater3.get(this);
            constructEBCompletedAndPauseFlag3 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j11 & DurationKt.MAX_MILLIS, false);
        } while (!atomicLongFieldUpdater3.compareAndSet(this, j11, constructEBCompletedAndPauseFlag3));
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public /* synthetic */ BufferedChannel(int i10, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : function1);
    }
}
