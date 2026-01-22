package a7;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements Configurator {

    /* renamed from: a, reason: collision with root package name */
    public static final Configurator f٢٣١a = new b();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final a f٢٣٢a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٣b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٤c = FieldDescriptor.of(DeviceRequestsHelper.DEVICE_INFO_MODEL);

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٥d = FieldDescriptor.of("hardware");

        /* renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٦e = FieldDescriptor.of(DeviceRequestsHelper.DEVICE_INFO_DEVICE);

        /* renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٧f = FieldDescriptor.of("product");

        /* renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٨g = FieldDescriptor.of("osBuild");

        /* renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f٢٣٩h = FieldDescriptor.of("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٠i = FieldDescriptor.of("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f٢٤١j = FieldDescriptor.of("locale");

        /* renamed from: k, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٢k = FieldDescriptor.of("country");

        /* renamed from: l, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٣l = FieldDescriptor.of("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٤m = FieldDescriptor.of("applicationBuild");

        private a() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(a7.a aVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٣٣b, aVar.m());
            objectEncoderContext.add(f٢٣٤c, aVar.j());
            objectEncoderContext.add(f٢٣٥d, aVar.f());
            objectEncoderContext.add(f٢٣٦e, aVar.d());
            objectEncoderContext.add(f٢٣٧f, aVar.l());
            objectEncoderContext.add(f٢٣٨g, aVar.k());
            objectEncoderContext.add(f٢٣٩h, aVar.h());
            objectEncoderContext.add(f٢٤٠i, aVar.e());
            objectEncoderContext.add(f٢٤١j, aVar.g());
            objectEncoderContext.add(f٢٤٢k, aVar.c());
            objectEncoderContext.add(f٢٤٣l, aVar.i());
            objectEncoderContext.add(f٢٤٤m, aVar.b());
        }
    }

    /* renamed from: a7.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class C٠٠٠٢b implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final C٠٠٠٢b f٢٤٥a = new C٠٠٠٢b();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٦b = FieldDescriptor.of("logRequest");

        private C٠٠٠٢b() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(n nVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٤٦b, nVar.c());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final c f٢٤٧a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٨b = FieldDescriptor.of("clientType");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٤٩c = FieldDescriptor.of("androidClientInfo");

        private c() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(o oVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٤٨b, oVar.c());
            objectEncoderContext.add(f٢٤٩c, oVar.b());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final d f٢٥٠a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٥١b = FieldDescriptor.of("privacyContext");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٥٢c = FieldDescriptor.of("productIdOrigin");

        private d() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(p pVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٥١b, pVar.b());
            objectEncoderContext.add(f٢٥٢c, pVar.c());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final e f٢٥٣a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٥٤b = FieldDescriptor.of("clearBlob");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٥٥c = FieldDescriptor.of("encryptedBlob");

        private e() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(q qVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٥٤b, qVar.b());
            objectEncoderContext.add(f٢٥٥c, qVar.c());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class f implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final f f٢٥٦a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٥٧b = FieldDescriptor.of("originAssociatedProductId");

        private f() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(r rVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٥٧b, rVar.b());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class g implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final g f٢٥٨a = new g();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٥٩b = FieldDescriptor.of("prequest");

        private g() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(s sVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٥٩b, sVar.b());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class h implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final h f٢٦٠a = new h();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٦١b = FieldDescriptor.of("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٢c = FieldDescriptor.of("eventCode");

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٣d = FieldDescriptor.of("complianceData");

        /* renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٤e = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٥f = FieldDescriptor.of("sourceExtension");

        /* renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٦g = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٧h = FieldDescriptor.of("timezoneOffsetSeconds");

        /* renamed from: i, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٨i = FieldDescriptor.of("networkConnectionInfo");

        /* renamed from: j, reason: collision with root package name */
        private static final FieldDescriptor f٢٦٩j = FieldDescriptor.of("experimentIds");

        private h() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(t tVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٦١b, tVar.d());
            objectEncoderContext.add(f٢٦٢c, tVar.c());
            objectEncoderContext.add(f٢٦٣d, tVar.b());
            objectEncoderContext.add(f٢٦٤e, tVar.e());
            objectEncoderContext.add(f٢٦٥f, tVar.h());
            objectEncoderContext.add(f٢٦٦g, tVar.i());
            objectEncoderContext.add(f٢٦٧h, tVar.j());
            objectEncoderContext.add(f٢٦٨i, tVar.g());
            objectEncoderContext.add(f٢٦٩j, tVar.f());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class i implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final i f٢٧٠a = new i();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٧١b = FieldDescriptor.of("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٢c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٣d = FieldDescriptor.of("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٤e = FieldDescriptor.of("logSource");

        /* renamed from: f, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٥f = FieldDescriptor.of("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٦g = FieldDescriptor.of("logEvent");

        /* renamed from: h, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٧h = FieldDescriptor.of("qosTier");

        private i() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(u uVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٧١b, uVar.g());
            objectEncoderContext.add(f٢٧٢c, uVar.h());
            objectEncoderContext.add(f٢٧٣d, uVar.b());
            objectEncoderContext.add(f٢٧٤e, uVar.d());
            objectEncoderContext.add(f٢٧٥f, uVar.e());
            objectEncoderContext.add(f٢٧٦g, uVar.c());
            objectEncoderContext.add(f٢٧٧h, uVar.f());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class j implements ObjectEncoder {

        /* renamed from: a, reason: collision with root package name */
        static final j f٢٧٨a = new j();

        /* renamed from: b, reason: collision with root package name */
        private static final FieldDescriptor f٢٧٩b = FieldDescriptor.of("networkType");

        /* renamed from: c, reason: collision with root package name */
        private static final FieldDescriptor f٢٨٠c = FieldDescriptor.of("mobileSubtype");

        private j() {
        }

        @Override // com.google.firebase.encoders.Encoder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(w wVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f٢٧٩b, wVar.c());
            objectEncoderContext.add(f٢٨٠c, wVar.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        C٠٠٠٢b r02 = C٠٠٠٢b.f٢٤٥a;
        encoderConfig.registerEncoder(n.class, r02);
        encoderConfig.registerEncoder(a7.d.class, r02);
        i iVar = i.f٢٧٠a;
        encoderConfig.registerEncoder(u.class, iVar);
        encoderConfig.registerEncoder(k.class, iVar);
        c cVar = c.f٢٤٧a;
        encoderConfig.registerEncoder(o.class, cVar);
        encoderConfig.registerEncoder(a7.e.class, cVar);
        a aVar = a.f٢٣٢a;
        encoderConfig.registerEncoder(a7.a.class, aVar);
        encoderConfig.registerEncoder(a7.c.class, aVar);
        h hVar = h.f٢٦٠a;
        encoderConfig.registerEncoder(t.class, hVar);
        encoderConfig.registerEncoder(a7.j.class, hVar);
        d dVar = d.f٢٥٠a;
        encoderConfig.registerEncoder(p.class, dVar);
        encoderConfig.registerEncoder(a7.f.class, dVar);
        g gVar = g.f٢٥٨a;
        encoderConfig.registerEncoder(s.class, gVar);
        encoderConfig.registerEncoder(a7.i.class, gVar);
        f fVar = f.f٢٥٦a;
        encoderConfig.registerEncoder(r.class, fVar);
        encoderConfig.registerEncoder(a7.h.class, fVar);
        j jVar = j.f٢٧٨a;
        encoderConfig.registerEncoder(w.class, jVar);
        encoderConfig.registerEncoder(m.class, jVar);
        e eVar = e.f٢٥٣a;
        encoderConfig.registerEncoder(q.class, eVar);
        encoderConfig.registerEncoder(a7.g.class, eVar);
    }
}
