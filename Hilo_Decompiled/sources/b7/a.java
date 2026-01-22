package b7;

import androidx.appcompat.app.a0;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final Configurator f٥٤٤٨a = new a();

    /* renamed from: b7.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class C٠٠٦٨a implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final C٠٠٦٨a f٥٤٤٩a = new C٠٠٦٨a();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٠b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥١c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٢d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٣e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        private C٠٠٦٨a() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.a aVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٥٠b, aVar.d());
            objectEncoderContext.add(f٥٤٥١c, aVar.c());
            objectEncoderContext.add(f٥٤٥٢d, aVar.b());
            objectEncoderContext.add(f٥٤٥٣e, aVar.a());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final b f٥٤٥٤a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٥b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private b() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.b bVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٥٥b, bVar.a());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final c f٥٤٥٦a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٧b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٥٨c = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();

        private c() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.c cVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٥٧b, cVar.a());
            objectEncoderContext.add(f٥٤٥٨c, cVar.b());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final d f٥٤٥٩a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٠b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦١c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private d() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.d dVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٦٠b, dVar.b());
            objectEncoderContext.add(f٥٤٦١c, dVar.a());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final e f٥٤٦٢a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٣b = FieldDescriptor.of("clientMetrics");

        private e() {
        }

        public void a(m mVar, ObjectEncoderContext objectEncoderContext) {
            throw null;
        }

        @Override // com.google.firebase.encoders.Encoder
        public /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            a0.a(obj);
            a(null, objectEncoderContext);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class f implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final f f٥٤٦٤a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٥b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٦c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private f() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.e eVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٦٥b, eVar.a());
            objectEncoderContext.add(f٥٤٦٦c, eVar.b());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class g implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final g f٥٤٦٧a = new g();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٨b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٥٤٦٩c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private g() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(e7.f fVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٥٤٦٨b, fVar.b());
            objectEncoderContext.add(f٥٤٦٩c, fVar.a());
        }
    }

    private a() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(m.class, e.f٥٤٦٢a);
        encoderConfig.registerEncoder(e7.a.class, C٠٠٦٨a.f٥٤٤٩a);
        encoderConfig.registerEncoder(e7.f.class, g.f٥٤٦٧a);
        encoderConfig.registerEncoder(e7.d.class, d.f٥٤٥٩a);
        encoderConfig.registerEncoder(e7.c.class, c.f٥٤٥٦a);
        encoderConfig.registerEncoder(e7.b.class, b.f٥٤٥٤a);
        encoderConfig.registerEncoder(e7.e.class, f.f٥٤٦٤a);
    }
}
