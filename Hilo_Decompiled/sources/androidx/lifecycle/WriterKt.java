package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.model.AdapterClass;
import androidx.lifecycle.model.AdapterClassKt;
import androidx.lifecycle.model.EventMethod;
import androidx.lifecycle.model.EventMethodCall;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.NativeProtocol;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.StandardLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import yc.o;
import yc.s;

@Metadata(d1 = {"\u0000h\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0018\u001a\u00020\u0005*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010&\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010%\"\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u0014\u0010+\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010%\"\u0014\u0010,\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010%\"\u0014\u0010-\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010%\"\u0014\u0010.\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010%\"\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101\"\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101\"\u0014\u00103\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00101\"\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00101\"\u0014\u00105\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010%¨\u00066"}, d2 = {"", "Landroidx/lifecycle/model/AdapterClass;", "infos", "Ljavax/annotation/processing/ProcessingEnvironment;", "processingEnv", "", "writeModels", "(Ljava/util/List;Ljavax/annotation/processing/ProcessingEnvironment;)V", "adapter", "writeAdapter", "(Landroidx/lifecycle/model/AdapterClass;Ljavax/annotation/processing/ProcessingEnvironment;)V", "Lyc/s$b;", "adapterTypeSpecBuilder", "addGeneratedAnnotationIfAvailable", "(Lyc/s$b;Ljavax/annotation/processing/ProcessingEnvironment;)V", "Ljavax/lang/model/element/TypeElement;", "type", "generateKeepRule", "(Ljavax/lang/model/element/TypeElement;Ljavax/annotation/processing/ProcessingEnvironment;)V", "Lyc/o$b;", "Landroidx/lifecycle/model/EventMethodCall;", "calls", "Lyc/l;", "receiverField", "writeMethodCalls", "(Lyc/o$b;Ljava/util/List;Lyc/l;)V", "", "count", "", "", NativeProtocol.WEB_DIALOG_PARAMS, "takeParams", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "", "generateParamString", "(I)Ljava/lang/String;", "GENERATED_PACKAGE", "Ljava/lang/String;", "GENERATED_NAME", "Ljava/lang/Class;", "Landroidx/lifecycle/Lifecycle$Event;", "LIFECYCLE_EVENT", "Ljava/lang/Class;", "T", "N", "L", "S", "Lyc/p;", "OWNER_PARAM", "Lyc/p;", "EVENT_PARAM", "ON_ANY_PARAM", "METHODS_LOGGER", "HAS_LOGGER_VAR", "lifecycle-compiler"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nwriter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 writer.kt\nandroidx/lifecycle/WriterKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n1863#2,2:231\n1485#2:233\n1510#2,3:234\n1513#2,3:244\n1557#2:256\n1628#2,3:257\n1863#2,2:261\n381#3,7:237\n487#3,7:247\n216#4,2:254\n1#5:260\n37#6,2:263\n*S KotlinDebug\n*F\n+ 1 writer.kt\nandroidx/lifecycle/WriterKt\n*L\n36#1:231,2\n75#1:233\n75#1:234,3\n75#1:244,3\n98#1:256\n98#1:257,3\n190#1:261,2\n75#1:237,7\n86#1:247,7\n87#1:254,2\n227#1:263,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class WriterKt {

    @NotNull
    private static final yc.p EVENT_PARAM;

    @NotNull
    private static final String GENERATED_NAME = "Generated";

    @NotNull
    private static final String GENERATED_PACKAGE = "javax.annotation";

    @NotNull
    private static final String HAS_LOGGER_VAR = "hasLogger";

    @NotNull
    private static final String L = "$L";

    @NotNull
    private static final Class<Lifecycle.Event> LIFECYCLE_EVENT = Lifecycle.Event.class;

    @NotNull
    private static final yc.p METHODS_LOGGER;

    @NotNull
    private static final String N = "$N";

    @NotNull
    private static final yc.p ON_ANY_PARAM;

    @NotNull
    private static final yc.p OWNER_PARAM;

    @NotNull
    private static final String S = "$S";

    @NotNull
    private static final String T = "$T";

    static {
        yc.p e10 = yc.p.a(yc.e.q(LifecycleOwner.class), "owner", new Modifier[0]).e();
        Intrinsics.checkNotNullExpressionValue(e10, "build(...)");
        OWNER_PARAM = e10;
        yc.p e11 = yc.p.a(yc.e.q(Lifecycle.Event.class), "event", new Modifier[0]).e();
        Intrinsics.checkNotNullExpressionValue(e11, "build(...)");
        EVENT_PARAM = e11;
        yc.p e12 = yc.p.a(yc.r.e, "onAny", new Modifier[0]).e();
        Intrinsics.checkNotNullExpressionValue(e12, "build(...)");
        ON_ANY_PARAM = e12;
        yc.p e13 = yc.p.a(yc.e.q(MethodCallsLogger.class), "logger", new Modifier[0]).e();
        Intrinsics.checkNotNullExpressionValue(e13, "build(...)");
        METHODS_LOGGER = e13;
    }

    private static final void addGeneratedAnnotationIfAvailable(s.b bVar, ProcessingEnvironment processingEnvironment) {
        Elements elementUtils = processingEnvironment.getElementUtils();
        String str = GENERATED_PACKAGE;
        String str2 = GENERATED_NAME;
        if (elementUtils.getTypeElement(str + InstructionFileId.DOT + str2) != null) {
            bVar.h(yc.a.a(yc.e.r(str, str2, new String[0])).c("value", S, new Object[]{LifecycleProcessor.class.getCanonicalName()}).e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void generateKeepRule(TypeElement typeElement, ProcessingEnvironment processingEnvironment) {
        String str = Elements_extKt.getPackageQName((Element) typeElement) + InstructionFileId.DOT + AdapterClassKt.getAdapterName(typeElement);
        String obj = typeElement.toString();
        String trimMargin$default = StringsKt.trimMargin$default("# Generated keep rule for Lifecycle observer adapter.\n        |-if class " + obj + " {\n        |    <init>(...);\n        |}\n        |-keep class " + str + " {\n        |    <init>(...);\n        |}\n        |", null, 1, null);
        StringBuilder sb = new StringBuilder();
        sb.append("META-INF/proguard/");
        sb.append(obj);
        sb.append(".pro");
        Writer openWriter = processingEnvironment.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", sb.toString(), new Element[]{typeElement}).openWriter();
        try {
            openWriter.write(trimMargin$default);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(openWriter, null);
        } finally {
        }
    }

    private static final String generateParamString(int i10) {
        return CollectionsKt.joinToString$default(RangesKt.until(0, i10), ",", null, null, 0, null, new Function1() { // from class: androidx.lifecycle.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence generateParamString$lambda$10;
                generateParamString$lambda$10 = WriterKt.generateParamString$lambda$10(((Integer) obj).intValue());
                return generateParamString$lambda$10;
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateParamString$lambda$10(int i10) {
        return N;
    }

    private static final Object[] takeParams(int i10, Object... objArr) {
        return ArraysKt.take(objArr, i10).toArray(new Object[0]);
    }

    private static final void writeAdapter(AdapterClass adapterClass, ProcessingEnvironment processingEnvironment) {
        char c10 = 0;
        yc.l f10 = yc.l.a(yc.e.s(adapterClass.getType()), "mReceiver", new Modifier[]{Modifier.FINAL}).f();
        Intrinsics.checkNotNullExpressionValue(f10, "build(...)");
        o.b k10 = yc.o.g("callMethods").p(yc.r.d).k(OWNER_PARAM).k(EVENT_PARAM).k(ON_ANY_PARAM);
        yc.p pVar = METHODS_LOGGER;
        o.b h10 = k10.k(pVar).j(new Modifier[]{Modifier.PUBLIC}).h(Override.class);
        h10.l("boolean " + L + " = " + N + " != null", new Object[]{HAS_LOGGER_VAR, pVar});
        List<EventMethodCall> calls = adapterClass.getCalls();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : calls) {
            Lifecycle.Event value = ((EventMethodCall) obj).getMethod().getOnLifecycleEvent().value();
            Object obj2 = linkedHashMap.get(value);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(value, obj2);
            }
            ((List) obj2).add(obj);
        }
        o.b m10 = h10.m("if (" + N + ")", new Object[]{ON_ANY_PARAM});
        Intrinsics.checkNotNull(m10);
        List list = (List) linkedHashMap.get(Lifecycle.Event.ON_ANY);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        writeMethodCalls(m10, list, f10);
        m10.o();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Lifecycle.Event) entry.getKey()) != Lifecycle.Event.ON_ANY) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Lifecycle.Event event = (Lifecycle.Event) entry2.getKey();
            List list2 = (List) entry2.getValue();
            h10.m("if (" + N + " == " + T + InstructionFileId.DOT + L + ")", new Object[]{EVENT_PARAM, LIFECYCLE_EVENT, event});
            Intrinsics.checkNotNull(h10);
            writeMethodCalls(h10, list2, f10);
            h10.o();
        }
        yc.o n10 = h10.n();
        yc.p e10 = yc.p.a(yc.e.s(adapterClass.getType()), "receiver", new Modifier[0]).e();
        Set<ExecutableElement> syntheticMethods = adapterClass.getSyntheticMethods();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(syntheticMethods, 10));
        for (ExecutableElement executableElement : syntheticMethods) {
            o.b p10 = yc.o.g(Elements_extKt.syntheticName(executableElement)).p(yc.r.d);
            Modifier[] modifierArr = new Modifier[1];
            modifierArr[c10] = Modifier.PUBLIC;
            o.b j10 = p10.j(modifierArr);
            Modifier[] modifierArr2 = new Modifier[1];
            modifierArr2[c10] = Modifier.STATIC;
            o.b k11 = j10.j(modifierArr2).k(e10);
            if (executableElement.getParameters().size() >= 1) {
                k11.k(OWNER_PARAM);
            }
            if (executableElement.getParameters().size() == 2) {
                k11.k(EVENT_PARAM);
            }
            int size = executableElement.getParameters().size();
            String generateParamString = generateParamString(size);
            String str = N + InstructionFileId.DOT + L + "(" + generateParamString + ")";
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(e10);
            spreadBuilder.add(Elements_extKt.name(executableElement));
            spreadBuilder.addSpread(takeParams(size, OWNER_PARAM, EVENT_PARAM));
            k11.l(str, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            arrayList.add(k11.n());
            c10 = 0;
        }
        o.b k12 = yc.o.a().k(e10);
        String str2 = N;
        s.b m11 = yc.s.a(AdapterClassKt.getAdapterName(adapterClass.getType())).l(new Modifier[]{Modifier.PUBLIC}).n(yc.e.q(GeneratedAdapter.class)).i(f10).j(k12.l("this." + str2 + " = " + str2, new Object[]{f10, e10}).n()).j(n10).k(arrayList).m(adapterClass.getType());
        Intrinsics.checkNotNull(m11);
        addGeneratedAnnotationIfAvailable(m11, processingEnvironment);
        yc.m.b(Elements_extKt.getPackageQName(adapterClass.getType()), m11.o()).f().f(processingEnvironment.getFiler());
        generateKeepRule(adapterClass.getType(), processingEnvironment);
    }

    private static final void writeMethodCalls(o.b bVar, List<EventMethodCall> list, yc.l lVar) {
        int i10 = 1;
        for (EventMethodCall eventMethodCall : list) {
            EventMethod method = eventMethodCall.getMethod();
            Element syntheticAccess = eventMethodCall.getSyntheticAccess();
            int size = method.getMethod().getParameters().size();
            String name = Elements_extKt.name(method.getMethod());
            String str = L;
            String str2 = N;
            String str3 = "if (!" + str + " || " + str2 + ".approveCall(" + S + ", " + (i10 << size) + "))";
            Object[] objArr = new Object[3];
            objArr[0] = HAS_LOGGER_VAR;
            objArr[i10] = METHODS_LOGGER;
            objArr[2] = name;
            o.b m10 = bVar.m(str3, objArr);
            if (syntheticAccess == null) {
                String str4 = str2 + InstructionFileId.DOT + str + "(" + generateParamString(size) + ")";
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.add(lVar);
                spreadBuilder.add(name);
                Object[] objArr2 = new Object[2];
                objArr2[0] = OWNER_PARAM;
                objArr2[i10] = EVENT_PARAM;
                spreadBuilder.addSpread(takeParams(size, objArr2));
                m10.l(str4, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            } else {
                int i11 = size + i10;
                String generateParamString = generateParamString(i11);
                yc.e r10 = yc.e.r(Elements_extKt.getPackageQName(syntheticAccess), AdapterClassKt.getAdapterName(syntheticAccess), new String[0]);
                String str5 = T + InstructionFileId.DOT + str + "(" + generateParamString + ")";
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(3);
                spreadBuilder2.add(r10);
                spreadBuilder2.add(Elements_extKt.syntheticName(method.getMethod()));
                spreadBuilder2.addSpread(takeParams(i11, lVar, OWNER_PARAM, EVENT_PARAM));
                m10.l(str5, spreadBuilder2.toArray(new Object[spreadBuilder2.size()]));
            }
            m10.o();
            i10 = 1;
        }
        bVar.l("return", new Object[0]);
    }

    public static final void writeModels(@NotNull List<AdapterClass> infos, @NotNull ProcessingEnvironment processingEnv) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Iterator<T> it = infos.iterator();
        while (it.hasNext()) {
            writeAdapter((AdapterClass) it.next(), processingEnv);
        }
    }
}
