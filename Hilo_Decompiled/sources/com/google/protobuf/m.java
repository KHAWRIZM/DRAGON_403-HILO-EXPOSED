package com.google.protobuf;

import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.a;
import com.google.protobuf.h0;
import com.google.protobuf.j0;
import com.google.protobuf.n;
import com.liulishuo.okdownload.DownloadTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class m {
    private static final n.b A;

    /* renamed from: B, reason: collision with root package name */
    private static final h0.f f١١٢٣٦B;
    private static final n.b C;
    private static final h0.f D;
    private static final n.b E;
    private static final h0.f F;
    private static final n.b G;
    private static final h0.f H;
    private static final n.b I;
    private static final h0.f J;
    private static final n.b K;
    private static final h0.f L;
    private static final n.b M;
    private static final h0.f N;
    private static final n.b O;
    private static final h0.f P;
    private static final n.b Q;
    private static final h0.f R;
    private static final n.b S;
    private static final h0.f T;
    private static final n.b U;
    private static final h0.f V;
    private static final n.b W;
    private static final h0.f X;
    private static final n.b Y;
    private static final h0.f Z;

    /* renamed from: a, reason: collision with root package name */
    private static final n.b f١١٢٣٧a;

    /* renamed from: a0, reason: collision with root package name */
    private static final n.b f١١٢٣٨a0;

    /* renamed from: b, reason: collision with root package name */
    private static final h0.f f١١٢٣٩b;

    /* renamed from: b0, reason: collision with root package name */
    private static final h0.f f١١٢٤٠b0;

    /* renamed from: c, reason: collision with root package name */
    private static final n.b f١١٢٤١c;

    /* renamed from: c0, reason: collision with root package name */
    private static n.h f١١٢٤٢c0 = n.h.o(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"©\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"Õ\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\u0012\u0017\n\u000fproto3_optional\u0018\u0011 \u0001(\b\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"¤\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"¥\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001e\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0004true\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b&\u0010'\"\u0084\u0002\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0004\u0010\u0005J\u0004\b\u0005\u0010\u0006J\u0004\b\u0006\u0010\u0007J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"¾\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u001e\n\u000funverified_lazy\u0018\u000f \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u0093\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u00ad\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0086\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B~\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z-google.golang.org/protobuf/types/descriptorpbø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new n.h[0]);

    /* renamed from: d, reason: collision with root package name */
    private static final h0.f f١١٢٤٣d;

    /* renamed from: e, reason: collision with root package name */
    private static final n.b f١١٢٤٤e;

    /* renamed from: f, reason: collision with root package name */
    private static final h0.f f١١٢٤٥f;

    /* renamed from: g, reason: collision with root package name */
    private static final n.b f١١٢٤٦g;

    /* renamed from: h, reason: collision with root package name */
    private static final h0.f f١١٢٤٧h;

    /* renamed from: i, reason: collision with root package name */
    private static final n.b f١١٢٤٨i;

    /* renamed from: j, reason: collision with root package name */
    private static final h0.f f١١٢٤٩j;

    /* renamed from: k, reason: collision with root package name */
    private static final n.b f١١٢٥٠k;

    /* renamed from: l, reason: collision with root package name */
    private static final h0.f f١١٢٥١l;

    /* renamed from: m, reason: collision with root package name */
    private static final n.b f١١٢٥٢m;

    /* renamed from: n, reason: collision with root package name */
    private static final h0.f f١١٢٥٣n;

    /* renamed from: o, reason: collision with root package name */
    private static final n.b f١١٢٥٤o;

    /* renamed from: p, reason: collision with root package name */
    private static final h0.f f١١٢٥٥p;

    /* renamed from: q, reason: collision with root package name */
    private static final n.b f١١٢٥٦q;

    /* renamed from: r, reason: collision with root package name */
    private static final h0.f f١١٢٥٧r;

    /* renamed from: s, reason: collision with root package name */
    private static final n.b f١١٢٥٨s;

    /* renamed from: t, reason: collision with root package name */
    private static final h0.f f١١٢٥٩t;

    /* renamed from: u, reason: collision with root package name */
    private static final n.b f١١٢٦٠u;

    /* renamed from: v, reason: collision with root package name */
    private static final h0.f f١١٢٦١v;

    /* renamed from: w, reason: collision with root package name */
    private static final n.b f١١٢٦٢w;

    /* renamed from: x, reason: collision with root package name */
    private static final h0.f f١١٢٦٣x;

    /* renamed from: y, reason: collision with root package name */
    private static final n.b f١١٢٦٤y;

    /* renamed from: z, reason: collision with root package name */
    private static final h0.f f١١٢٦٥z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends h0 implements g1 {

        /* renamed from: m, reason: collision with root package name */
        private static final b f١١٢٦٦m = new b();

        /* renamed from: n, reason: collision with root package name */
        public static final r1 f١١٢٦٧n = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٢٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٢٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private List f١١٢٧٠c;

        /* renamed from: d, reason: collision with root package name */
        private List f١١٢٧١d;

        /* renamed from: e, reason: collision with root package name */
        private List f١١٢٧٢e;

        /* renamed from: f, reason: collision with root package name */
        private List f١١٢٧٣f;

        /* renamed from: g, reason: collision with root package name */
        private List f١١٢٧٤g;

        /* renamed from: h, reason: collision with root package name */
        private List f١١٢٧٥h;

        /* renamed from: i, reason: collision with root package name */
        private l f١١٢٧٦i;

        /* renamed from: j, reason: collision with root package name */
        private List f١١٢٧٧j;

        /* renamed from: k, reason: collision with root package name */
        private p0 f١١٢٧٨k;

        /* renamed from: l, reason: collision with root package name */
        private byte f١١٢٧٩l;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                C٠١٣٧b h02 = b.h0();
                try {
                    h02.mergeFrom(iVar, vVar);
                    return h02.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(h02.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(h02.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(h02.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class c extends h0 implements g1 {

            /* renamed from: f, reason: collision with root package name */
            private static final c f١١٢٩٩f = new c();

            /* renamed from: g, reason: collision with root package name */
            public static final r1 f١١٣٠٠g = new a();
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f١١٣٠١a;

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣٠٢b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٣٠٣c;

            /* renamed from: d, reason: collision with root package name */
            private g f١١٣٠٤d;

            /* renamed from: e, reason: collision with root package name */
            private byte f١١٣٠٥e;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a extends com.google.protobuf.c {
                a() {
                }

                @Override // com.google.protobuf.r1
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public c parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                    C٠١٣٨b y10 = c.y();
                    try {
                        y10.mergeFrom(iVar, vVar);
                        return y10.buildPartial();
                    } catch (i2 e10) {
                        throw e10.a().j(y10.buildPartial());
                    } catch (k0 e11) {
                        throw e11.j(y10.buildPartial());
                    } catch (IOException e12) {
                        throw new k0(e12).j(y10.buildPartial());
                    }
                }
            }

            public static final n.b getDescriptor() {
                return m.f١١٢٤٦g;
            }

            static /* synthetic */ int p(c cVar, int i10) {
                int i11 = i10 | cVar.f١١٣٠١a;
                cVar.f١١٣٠١a = i11;
                return i11;
            }

            public static c q() {
                return f١١٢٩٩f;
            }

            public static C٠١٣٨b y() {
                return f١١٢٩٩f.toBuilder();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public C٠١٣٨b newBuilderForType(h0.c cVar) {
                return new C٠١٣٨b(cVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public C٠١٣٨b toBuilder() {
                if (this == f١١٢٩٩f) {
                    return new C٠١٣٨b();
                }
                return new C٠١٣٨b().p(this);
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (x() != cVar.x()) {
                    return false;
                }
                if ((x() && u() != cVar.u()) || v() != cVar.v()) {
                    return false;
                }
                if ((v() && s() != cVar.s()) || w() != cVar.w()) {
                    return false;
                }
                if ((!w() || t().equals(cVar.t())) && getUnknownFields().equals(cVar.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                if ((this.f١١٣٠١a & 1) != 0) {
                    i10 = com.google.protobuf.k.x(1, this.f١١٣٠٢b);
                } else {
                    i10 = 0;
                }
                if ((this.f١١٣٠١a & 2) != 0) {
                    i10 += com.google.protobuf.k.x(2, this.f١١٣٠٣c);
                }
                if ((this.f١١٣٠١a & 4) != 0) {
                    i10 += com.google.protobuf.k.G(3, t());
                }
                int serializedSize = i10 + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.g1
            public final k2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (x()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + u();
                }
                if (v()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + s();
                }
                if (w()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + t().hashCode();
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.h0
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٤٧h.d(c.class, C٠١٣٨b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                byte b10 = this.f١١٣٠٥e;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (w() && !t().isInitialized()) {
                    this.f١١٣٠٥e = (byte) 0;
                    return false;
                }
                this.f١١٣٠٥e = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            public Object newInstance(h0.g gVar) {
                return new c();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public c getDefaultInstanceForType() {
                return f١١٢٩٩f;
            }

            public int s() {
                return this.f١١٣٠٣c;
            }

            public g t() {
                g gVar = this.f١١٣٠٤d;
                if (gVar == null) {
                    return g.u();
                }
                return gVar;
            }

            public int u() {
                return this.f١١٣٠٢b;
            }

            public boolean v() {
                if ((this.f١١٣٠١a & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean w() {
                if ((this.f١١٣٠١a & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public void writeTo(com.google.protobuf.k kVar) {
                if ((this.f١١٣٠١a & 1) != 0) {
                    kVar.D0(1, this.f١١٣٠٢b);
                }
                if ((this.f١١٣٠١a & 2) != 0) {
                    kVar.D0(2, this.f١١٣٠٣c);
                }
                if ((this.f١١٣٠١a & 4) != 0) {
                    kVar.H0(3, t());
                }
                getUnknownFields().writeTo(kVar);
            }

            public boolean x() {
                if ((this.f١١٣٠١a & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public C٠١٣٨b newBuilderForType() {
                return y();
            }

            /* renamed from: com.google.protobuf.m$b$c$b, reason: collision with other inner class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class C٠١٣٨b extends h0.b implements g1 {

                /* renamed from: a, reason: collision with root package name */
                private int f١١٣٠٦a;

                /* renamed from: b, reason: collision with root package name */
                private int f١١٣٠٧b;

                /* renamed from: c, reason: collision with root package name */
                private int f١١٣٠٨c;

                /* renamed from: d, reason: collision with root package name */
                private g f١١٣٠٩d;

                /* renamed from: e, reason: collision with root package name */
                private b2 f١١٣١٠e;

                private void h(c cVar) {
                    int i10;
                    g gVar;
                    int i11 = this.f١١٣٠٦a;
                    if ((i11 & 1) != 0) {
                        cVar.f١١٣٠٢b = this.f١١٣٠٧b;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 2) != 0) {
                        cVar.f١١٣٠٣c = this.f١١٣٠٨c;
                        i10 |= 2;
                    }
                    if ((i11 & 4) != 0) {
                        b2 b2Var = this.f١١٣١٠e;
                        if (b2Var == null) {
                            gVar = this.f١١٣٠٩d;
                        } else {
                            gVar = (g) b2Var.b();
                        }
                        cVar.f١١٣٠٤d = gVar;
                        i10 |= 4;
                    }
                    c.p(cVar, i10);
                }

                private b2 m() {
                    if (this.f١١٣١٠e == null) {
                        this.f١١٣١٠e = new b2(k(), getParentForChildren(), isClean());
                        this.f١١٣٠٩d = null;
                    }
                    return this.f١١٣١٠e;
                }

                private void maybeForceBuilderInitialization() {
                    if (h0.alwaysUseFieldBuilders) {
                        m();
                    }
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public C٠١٣٨b addRepeatedField(n.g gVar, Object obj) {
                    return (C٠١٣٨b) super.addRepeatedField(gVar, obj);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public c buildPartial() {
                    c cVar = new c(this);
                    if (this.f١١٣٠٦a != 0) {
                        h(cVar);
                    }
                    onBuilt();
                    return cVar;
                }

                @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
                public n.b getDescriptorForType() {
                    return m.f١١٢٤٦g;
                }

                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public C٠١٣٨b clone() {
                    return (C٠١٣٨b) super.clone();
                }

                @Override // com.google.protobuf.h0.b
                protected h0.f internalGetFieldAccessorTable() {
                    return m.f١١٢٤٧h.d(c.class, C٠١٣٨b.class);
                }

                @Override // com.google.protobuf.f1
                public final boolean isInitialized() {
                    if (n() && !k().isInitialized()) {
                        return false;
                    }
                    return true;
                }

                @Override // com.google.protobuf.f1
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public c getDefaultInstanceForType() {
                    return c.q();
                }

                public g k() {
                    b2 b2Var = this.f١١٣١٠e;
                    if (b2Var == null) {
                        g gVar = this.f١١٣٠٩d;
                        if (gVar == null) {
                            return g.u();
                        }
                        return gVar;
                    }
                    return (g) b2Var.e();
                }

                public g.b l() {
                    this.f١١٣٠٦a |= 4;
                    onChanged();
                    return (g.b) m().d();
                }

                public boolean n() {
                    if ((this.f١١٣٠٦a & 4) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public C٠١٣٨b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                    vVar.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int K = iVar.K();
                                if (K != 0) {
                                    if (K != 8) {
                                        if (K != 16) {
                                            if (K != 26) {
                                                if (!super.parseUnknownField(iVar, vVar, K)) {
                                                }
                                            } else {
                                                iVar.B(m().d(), vVar);
                                                this.f١١٣٠٦a |= 4;
                                            }
                                        } else {
                                            this.f١١٣٠٨c = iVar.y();
                                            this.f١١٣٠٦a |= 2;
                                        }
                                    } else {
                                        this.f١١٣٠٧b = iVar.y();
                                        this.f١١٣٠٦a |= 1;
                                    }
                                }
                                z10 = true;
                            } catch (k0 e10) {
                                throw e10.m();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                public C٠١٣٨b p(c cVar) {
                    if (cVar == c.q()) {
                        return this;
                    }
                    if (cVar.x()) {
                        v(cVar.u());
                    }
                    if (cVar.v()) {
                        t(cVar.s());
                    }
                    if (cVar.w()) {
                        r(cVar.t());
                    }
                    mergeUnknownFields(cVar.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public C٠١٣٨b mergeFrom(b1 b1Var) {
                    if (b1Var instanceof c) {
                        return p((c) b1Var);
                    }
                    super.mergeFrom(b1Var);
                    return this;
                }

                public C٠١٣٨b r(g gVar) {
                    g gVar2;
                    b2 b2Var = this.f١١٣١٠e;
                    if (b2Var == null) {
                        if ((this.f١١٣٠٦a & 4) != 0 && (gVar2 = this.f١١٣٠٩d) != null && gVar2 != g.u()) {
                            l().y(gVar);
                        } else {
                            this.f١١٣٠٩d = gVar;
                        }
                    } else {
                        b2Var.g(gVar);
                    }
                    this.f١١٣٠٦a |= 4;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public final C٠١٣٨b mergeUnknownFields(k2 k2Var) {
                    return (C٠١٣٨b) super.mergeUnknownFields(k2Var);
                }

                public C٠١٣٨b t(int i10) {
                    this.f١١٣٠٨c = i10;
                    this.f١١٣٠٦a |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public C٠١٣٨b setField(n.g gVar, Object obj) {
                    return (C٠١٣٨b) super.setField(gVar, obj);
                }

                public C٠١٣٨b v(int i10) {
                    this.f١١٣٠٧b = i10;
                    this.f١١٣٠٦a |= 1;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final C٠١٣٨b setUnknownFields(k2 k2Var) {
                    return (C٠١٣٨b) super.setUnknownFields(k2Var);
                }

                private C٠١٣٨b() {
                    maybeForceBuilderInitialization();
                }

                private C٠١٣٨b(h0.c cVar) {
                    super(cVar);
                    maybeForceBuilderInitialization();
                }
            }

            private c(h0.b bVar) {
                super(bVar);
                this.f١١٣٠٢b = 0;
                this.f١١٣٠٣c = 0;
                this.f١١٣٠٥e = (byte) -1;
            }

            private c() {
                this.f١١٣٠٢b = 0;
                this.f١١٣٠٣c = 0;
                this.f١١٣٠٥e = (byte) -1;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class d extends h0 implements g1 {

            /* renamed from: e, reason: collision with root package name */
            private static final d f١١٣١١e = new d();

            /* renamed from: f, reason: collision with root package name */
            public static final r1 f١١٣١٢f = new a();
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f١١٣١٣a;

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣١٤b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٣١٥c;

            /* renamed from: d, reason: collision with root package name */
            private byte f١١٣١٦d;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a extends com.google.protobuf.c {
                a() {
                }

                @Override // com.google.protobuf.r1
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public d parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                    C٠١٣٩b v10 = d.v();
                    try {
                        v10.mergeFrom(iVar, vVar);
                        return v10.buildPartial();
                    } catch (i2 e10) {
                        throw e10.a().j(v10.buildPartial());
                    } catch (k0 e11) {
                        throw e11.j(v10.buildPartial());
                    } catch (IOException e12) {
                        throw new k0(e12).j(v10.buildPartial());
                    }
                }
            }

            public static final n.b getDescriptor() {
                return m.f١١٢٤٨i;
            }

            static /* synthetic */ int o(d dVar, int i10) {
                int i11 = i10 | dVar.f١١٣١٣a;
                dVar.f١١٣١٣a = i11;
                return i11;
            }

            public static d p() {
                return f١١٣١١e;
            }

            public static C٠١٣٩b v() {
                return f١١٣١١e.toBuilder();
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return super.equals(obj);
                }
                d dVar = (d) obj;
                if (u() != dVar.u()) {
                    return false;
                }
                if ((u() && s() != dVar.s()) || t() != dVar.t()) {
                    return false;
                }
                if ((!t() || r() == dVar.r()) && getUnknownFields().equals(dVar.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                if ((this.f١١٣١٣a & 1) != 0) {
                    i10 = com.google.protobuf.k.x(1, this.f١١٣١٤b);
                } else {
                    i10 = 0;
                }
                if ((this.f١١٣١٣a & 2) != 0) {
                    i10 += com.google.protobuf.k.x(2, this.f١١٣١٥c);
                }
                int serializedSize = i10 + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.g1
            public final k2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (u()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + s();
                }
                if (t()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + r();
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.h0
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٤٩j.d(d.class, C٠١٣٩b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                byte b10 = this.f١١٣١٦d;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f١١٣١٦d = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            public Object newInstance(h0.g gVar) {
                return new d();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public d getDefaultInstanceForType() {
                return f١١٣١١e;
            }

            public int r() {
                return this.f١١٣١٥c;
            }

            public int s() {
                return this.f١١٣١٤b;
            }

            public boolean t() {
                if ((this.f١١٣١٣a & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean u() {
                if ((this.f١١٣١٣a & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public C٠١٣٩b newBuilderForType() {
                return v();
            }

            @Override // com.google.protobuf.e1
            public void writeTo(com.google.protobuf.k kVar) {
                if ((this.f١١٣١٣a & 1) != 0) {
                    kVar.D0(1, this.f١١٣١٤b);
                }
                if ((this.f١١٣١٣a & 2) != 0) {
                    kVar.D0(2, this.f١١٣١٥c);
                }
                getUnknownFields().writeTo(kVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public C٠١٣٩b newBuilderForType(h0.c cVar) {
                return new C٠١٣٩b(cVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public C٠١٣٩b toBuilder() {
                if (this == f١١٣١١e) {
                    return new C٠١٣٩b();
                }
                return new C٠١٣٩b().l(this);
            }

            /* renamed from: com.google.protobuf.m$b$d$b, reason: collision with other inner class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class C٠١٣٩b extends h0.b implements g1 {

                /* renamed from: a, reason: collision with root package name */
                private int f١١٣١٧a;

                /* renamed from: b, reason: collision with root package name */
                private int f١١٣١٨b;

                /* renamed from: c, reason: collision with root package name */
                private int f١١٣١٩c;

                private void h(d dVar) {
                    int i10;
                    int i11 = this.f١١٣١٧a;
                    if ((i11 & 1) != 0) {
                        dVar.f١١٣١٤b = this.f١١٣١٨b;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 2) != 0) {
                        dVar.f١١٣١٥c = this.f١١٣١٩c;
                        i10 |= 2;
                    }
                    d.o(dVar, i10);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public C٠١٣٩b addRepeatedField(n.g gVar, Object obj) {
                    return (C٠١٣٩b) super.addRepeatedField(gVar, obj);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public d build() {
                    d buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public d buildPartial() {
                    d dVar = new d(this);
                    if (this.f١١٣١٧a != 0) {
                        h(dVar);
                    }
                    onBuilt();
                    return dVar;
                }

                @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
                public n.b getDescriptorForType() {
                    return m.f١١٢٤٨i;
                }

                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public C٠١٣٩b clone() {
                    return (C٠١٣٩b) super.clone();
                }

                @Override // com.google.protobuf.h0.b
                protected h0.f internalGetFieldAccessorTable() {
                    return m.f١١٢٤٩j.d(d.class, C٠١٣٩b.class);
                }

                @Override // com.google.protobuf.f1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.f1
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public d getDefaultInstanceForType() {
                    return d.p();
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
                /* renamed from: k, reason: merged with bridge method [inline-methods] */
                public C٠١٣٩b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                    vVar.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int K = iVar.K();
                                if (K != 0) {
                                    if (K != 8) {
                                        if (K != 16) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            this.f١١٣١٩c = iVar.y();
                                            this.f١١٣١٧a |= 2;
                                        }
                                    } else {
                                        this.f١١٣١٨b = iVar.y();
                                        this.f١١٣١٧a |= 1;
                                    }
                                }
                                z10 = true;
                            } catch (k0 e10) {
                                throw e10.m();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                public C٠١٣٩b l(d dVar) {
                    if (dVar == d.p()) {
                        return this;
                    }
                    if (dVar.u()) {
                        q(dVar.s());
                    }
                    if (dVar.t()) {
                        o(dVar.r());
                    }
                    mergeUnknownFields(dVar.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public C٠١٣٩b mergeFrom(b1 b1Var) {
                    if (b1Var instanceof d) {
                        return l((d) b1Var);
                    }
                    super.mergeFrom(b1Var);
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final C٠١٣٩b mergeUnknownFields(k2 k2Var) {
                    return (C٠١٣٩b) super.mergeUnknownFields(k2Var);
                }

                public C٠١٣٩b o(int i10) {
                    this.f١١٣١٩c = i10;
                    this.f١١٣١٧a |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public C٠١٣٩b setField(n.g gVar, Object obj) {
                    return (C٠١٣٩b) super.setField(gVar, obj);
                }

                public C٠١٣٩b q(int i10) {
                    this.f١١٣١٨b = i10;
                    this.f١١٣١٧a |= 1;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public final C٠١٣٩b setUnknownFields(k2 k2Var) {
                    return (C٠١٣٩b) super.setUnknownFields(k2Var);
                }

                private C٠١٣٩b() {
                }

                private C٠١٣٩b(h0.c cVar) {
                    super(cVar);
                }
            }

            private d(h0.b bVar) {
                super(bVar);
                this.f١١٣١٤b = 0;
                this.f١١٣١٥c = 0;
                this.f١١٣١٦d = (byte) -1;
            }

            private d() {
                this.f١١٣١٤b = 0;
                this.f١١٣١٥c = 0;
                this.f١١٣١٦d = (byte) -1;
            }
        }

        static /* synthetic */ int F(b bVar, int i10) {
            int i11 = i10 | bVar.f١١٢٦٨a;
            bVar.f١١٢٦٨a = i11;
            return i11;
        }

        public static b G() {
            return f١١٢٦٦m;
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٤٤e;
        }

        public static C٠١٣٧b h0() {
            return f١١٢٦٦m.toBuilder();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b getDefaultInstanceForType() {
            return f١١٢٦٦m;
        }

        public c I(int i10) {
            return (c) this.f١١٢٧٣f.get(i10);
        }

        public int J() {
            return this.f١١٢٧٣f.size();
        }

        public List K() {
            return this.f١١٢٧٣f;
        }

        public h L(int i10) {
            return (h) this.f١١٢٧١d.get(i10);
        }

        public int M() {
            return this.f١١٢٧١d.size();
        }

        public List N() {
            return this.f١١٢٧١d;
        }

        public c O(int i10) {
            return (c) this.f١١٢٧٤g.get(i10);
        }

        public int P() {
            return this.f١١٢٧٤g.size();
        }

        public List Q() {
            return this.f١١٢٧٤g;
        }

        public h R(int i10) {
            return (h) this.f١١٢٧٠c.get(i10);
        }

        public int S() {
            return this.f١١٢٧٠c.size();
        }

        public List T() {
            return this.f١١٢٧٠c;
        }

        public b U(int i10) {
            return (b) this.f١١٢٧٢e.get(i10);
        }

        public int V() {
            return this.f١١٢٧٢e.size();
        }

        public List W() {
            return this.f١١٢٧٢e;
        }

        public o X(int i10) {
            return (o) this.f١١٢٧٥h.get(i10);
        }

        public int Y() {
            return this.f١١٢٧٥h.size();
        }

        public List Z() {
            return this.f١١٢٧٥h;
        }

        public l a0() {
            l lVar = this.f١١٢٧٦i;
            if (lVar == null) {
                return l.z();
            }
            return lVar;
        }

        public int b0() {
            return this.f١١٢٧٨k.size();
        }

        public v1 c0() {
            return this.f١١٢٧٨k;
        }

        public int d0() {
            return this.f١١٢٧٧j.size();
        }

        public List e0() {
            return this.f١١٢٧٧j;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return super.equals(obj);
            }
            b bVar = (b) obj;
            if (f0() != bVar.f0()) {
                return false;
            }
            if ((f0() && !getName().equals(bVar.getName())) || !T().equals(bVar.T()) || !N().equals(bVar.N()) || !W().equals(bVar.W()) || !K().equals(bVar.K()) || !Q().equals(bVar.Q()) || !Z().equals(bVar.Z()) || g0() != bVar.g0()) {
                return false;
            }
            if ((!g0() || a0().equals(bVar.a0())) && e0().equals(bVar.e0()) && c0().equals(bVar.c0()) && getUnknownFields().equals(bVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public boolean f0() {
            if ((this.f١١٢٦٨a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean g0() {
            if ((this.f١١٢٦٨a & 2) != 0) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٢٦٩b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٢٦٩b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٢٦٨a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٢٦٩b);
            } else {
                i10 = 0;
            }
            for (int i12 = 0; i12 < this.f١١٢٧٠c.size(); i12++) {
                i10 += com.google.protobuf.k.G(2, (e1) this.f١١٢٧٠c.get(i12));
            }
            for (int i13 = 0; i13 < this.f١١٢٧٢e.size(); i13++) {
                i10 += com.google.protobuf.k.G(3, (e1) this.f١١٢٧٢e.get(i13));
            }
            for (int i14 = 0; i14 < this.f١١٢٧٣f.size(); i14++) {
                i10 += com.google.protobuf.k.G(4, (e1) this.f١١٢٧٣f.get(i14));
            }
            for (int i15 = 0; i15 < this.f١١٢٧٤g.size(); i15++) {
                i10 += com.google.protobuf.k.G(5, (e1) this.f١١٢٧٤g.get(i15));
            }
            for (int i16 = 0; i16 < this.f١١٢٧١d.size(); i16++) {
                i10 += com.google.protobuf.k.G(6, (e1) this.f١١٢٧١d.get(i16));
            }
            if ((this.f١١٢٦٨a & 2) != 0) {
                i10 += com.google.protobuf.k.G(7, a0());
            }
            for (int i17 = 0; i17 < this.f١١٢٧٥h.size(); i17++) {
                i10 += com.google.protobuf.k.G(8, (e1) this.f١١٢٧٥h.get(i17));
            }
            for (int i18 = 0; i18 < this.f١١٢٧٧j.size(); i18++) {
                i10 += com.google.protobuf.k.G(9, (e1) this.f١١٢٧٧j.get(i18));
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.f١١٢٧٨k.size(); i20++) {
                i19 += h0.computeStringSizeNoTag(this.f١١٢٧٨k.S(i20));
            }
            int size = i10 + i19 + c0().size() + getUnknownFields().getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (f0()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (S() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + T().hashCode();
            }
            if (M() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + N().hashCode();
            }
            if (V() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + W().hashCode();
            }
            if (J() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + K().hashCode();
            }
            if (P() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + Q().hashCode();
            }
            if (Y() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + Z().hashCode();
            }
            if (g0()) {
                hashCode = (((hashCode * 37) + 7) * 53) + a0().hashCode();
            }
            if (d0() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + e0().hashCode();
            }
            if (b0() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + c0().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public C٠١٣٧b newBuilderForType() {
            return h0();
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٤٥f.d(b.class, C٠١٣٧b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٢٧٩l;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < S(); i10++) {
                if (!R(i10).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < M(); i11++) {
                if (!L(i11).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < V(); i12++) {
                if (!U(i12).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < J(); i13++) {
                if (!I(i13).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            for (int i14 = 0; i14 < P(); i14++) {
                if (!O(i14).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            for (int i15 = 0; i15 < Y(); i15++) {
                if (!X(i15).isInitialized()) {
                    this.f١١٢٧٩l = (byte) 0;
                    return false;
                }
            }
            if (g0() && !a0().isInitialized()) {
                this.f١١٢٧٩l = (byte) 0;
                return false;
            }
            this.f١١٢٧٩l = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public C٠١٣٧b newBuilderForType(h0.c cVar) {
            return new C٠١٣٧b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public C٠١٣٧b toBuilder() {
            if (this == f١١٢٦٦m) {
                return new C٠١٣٧b();
            }
            return new C٠١٣٧b().S(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new b();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٢٦٨a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٢٦٩b);
            }
            for (int i10 = 0; i10 < this.f١١٢٧٠c.size(); i10++) {
                kVar.H0(2, (e1) this.f١١٢٧٠c.get(i10));
            }
            for (int i11 = 0; i11 < this.f١١٢٧٢e.size(); i11++) {
                kVar.H0(3, (e1) this.f١١٢٧٢e.get(i11));
            }
            for (int i12 = 0; i12 < this.f١١٢٧٣f.size(); i12++) {
                kVar.H0(4, (e1) this.f١١٢٧٣f.get(i12));
            }
            for (int i13 = 0; i13 < this.f١١٢٧٤g.size(); i13++) {
                kVar.H0(5, (e1) this.f١١٢٧٤g.get(i13));
            }
            for (int i14 = 0; i14 < this.f١١٢٧١d.size(); i14++) {
                kVar.H0(6, (e1) this.f١١٢٧١d.get(i14));
            }
            if ((this.f١١٢٦٨a & 2) != 0) {
                kVar.H0(7, a0());
            }
            for (int i15 = 0; i15 < this.f١١٢٧٥h.size(); i15++) {
                kVar.H0(8, (e1) this.f١١٢٧٥h.get(i15));
            }
            for (int i16 = 0; i16 < this.f١١٢٧٧j.size(); i16++) {
                kVar.H0(9, (e1) this.f١١٢٧٧j.get(i16));
            }
            for (int i17 = 0; i17 < this.f١١٢٧٨k.size(); i17++) {
                h0.writeString(kVar, 10, this.f١١٢٧٨k.S(i17));
            }
            getUnknownFields().writeTo(kVar);
        }

        /* renamed from: com.google.protobuf.m$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class C٠١٣٧b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٢٨٠a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٢٨١b;

            /* renamed from: c, reason: collision with root package name */
            private List f١١٢٨٢c;

            /* renamed from: d, reason: collision with root package name */
            private x1 f١١٢٨٣d;

            /* renamed from: e, reason: collision with root package name */
            private List f١١٢٨٤e;

            /* renamed from: f, reason: collision with root package name */
            private x1 f١١٢٨٥f;

            /* renamed from: g, reason: collision with root package name */
            private List f١١٢٨٦g;

            /* renamed from: h, reason: collision with root package name */
            private x1 f١١٢٨٧h;

            /* renamed from: i, reason: collision with root package name */
            private List f١١٢٨٨i;

            /* renamed from: j, reason: collision with root package name */
            private x1 f١١٢٨٩j;

            /* renamed from: k, reason: collision with root package name */
            private List f١١٢٩٠k;

            /* renamed from: l, reason: collision with root package name */
            private x1 f١١٢٩١l;

            /* renamed from: m, reason: collision with root package name */
            private List f١١٢٩٢m;

            /* renamed from: n, reason: collision with root package name */
            private x1 f١١٢٩٣n;

            /* renamed from: o, reason: collision with root package name */
            private l f١١٢٩٤o;

            /* renamed from: p, reason: collision with root package name */
            private b2 f١١٢٩٥p;

            /* renamed from: q, reason: collision with root package name */
            private List f١١٢٩٦q;

            /* renamed from: r, reason: collision with root package name */
            private x1 f١١٢٩٧r;

            /* renamed from: s, reason: collision with root package name */
            private p0 f١١٢٩٨s;

            private x1 C() {
                boolean z10;
                if (this.f١١٢٩١l == null) {
                    List list = this.f١١٢٩٠k;
                    if ((this.f١١٢٨٠a & 32) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٩١l = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٩٠k = null;
                }
                return this.f١١٢٩١l;
            }

            private x1 F() {
                boolean z10;
                if (this.f١١٢٨٣d == null) {
                    List list = this.f١١٢٨٢c;
                    if ((this.f١١٢٨٠a & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٨٣d = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٨٢c = null;
                }
                return this.f١١٢٨٣d;
            }

            private x1 I() {
                boolean z10;
                if (this.f١١٢٨٧h == null) {
                    List list = this.f١١٢٨٦g;
                    if ((this.f١١٢٨٠a & 8) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٨٧h = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٨٦g = null;
                }
                return this.f١١٢٨٧h;
            }

            private x1 L() {
                boolean z10;
                if (this.f١١٢٩٣n == null) {
                    List list = this.f١١٢٩٢m;
                    if ((this.f١١٢٨٠a & 64) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٩٣n = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٩٢m = null;
                }
                return this.f١١٢٩٣n;
            }

            private b2 O() {
                if (this.f١١٢٩٥p == null) {
                    this.f١١٢٩٥p = new b2(M(), getParentForChildren(), isClean());
                    this.f١١٢٩٤o = null;
                }
                return this.f١١٢٩٥p;
            }

            private x1 P() {
                boolean z10;
                if (this.f١١٢٩٧r == null) {
                    List list = this.f١١٢٩٦q;
                    if ((this.f١١٢٨٠a & 256) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٩٧r = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٩٦q = null;
                }
                return this.f١١٢٩٧r;
            }

            private void i(b bVar) {
                int i10;
                l lVar;
                int i11 = this.f١١٢٨٠a;
                if ((i11 & 1) != 0) {
                    bVar.f١١٢٦٩b = this.f١١٢٨١b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 128) != 0) {
                    b2 b2Var = this.f١١٢٩٥p;
                    if (b2Var == null) {
                        lVar = this.f١١٢٩٤o;
                    } else {
                        lVar = (l) b2Var.b();
                    }
                    bVar.f١١٢٧٦i = lVar;
                    i10 |= 2;
                }
                b.F(bVar, i10);
            }

            private void j(b bVar) {
                x1 x1Var = this.f١١٢٨٣d;
                if (x1Var != null) {
                    bVar.f١١٢٧٠c = x1Var.g();
                } else {
                    if ((this.f١١٢٨٠a & 2) != 0) {
                        this.f١١٢٨٢c = Collections.unmodifiableList(this.f١١٢٨٢c);
                        this.f١١٢٨٠a &= -3;
                    }
                    bVar.f١١٢٧٠c = this.f١١٢٨٢c;
                }
                x1 x1Var2 = this.f١١٢٨٥f;
                if (x1Var2 != null) {
                    bVar.f١١٢٧١d = x1Var2.g();
                } else {
                    if ((this.f١١٢٨٠a & 4) != 0) {
                        this.f١١٢٨٤e = Collections.unmodifiableList(this.f١١٢٨٤e);
                        this.f١١٢٨٠a &= -5;
                    }
                    bVar.f١١٢٧١d = this.f١١٢٨٤e;
                }
                x1 x1Var3 = this.f١١٢٨٧h;
                if (x1Var3 != null) {
                    bVar.f١١٢٧٢e = x1Var3.g();
                } else {
                    if ((this.f١١٢٨٠a & 8) != 0) {
                        this.f١١٢٨٦g = Collections.unmodifiableList(this.f١١٢٨٦g);
                        this.f١١٢٨٠a &= -9;
                    }
                    bVar.f١١٢٧٢e = this.f١١٢٨٦g;
                }
                x1 x1Var4 = this.f١١٢٨٩j;
                if (x1Var4 != null) {
                    bVar.f١١٢٧٣f = x1Var4.g();
                } else {
                    if ((this.f١١٢٨٠a & 16) != 0) {
                        this.f١١٢٨٨i = Collections.unmodifiableList(this.f١١٢٨٨i);
                        this.f١١٢٨٠a &= -17;
                    }
                    bVar.f١١٢٧٣f = this.f١١٢٨٨i;
                }
                x1 x1Var5 = this.f١١٢٩١l;
                if (x1Var5 != null) {
                    bVar.f١١٢٧٤g = x1Var5.g();
                } else {
                    if ((this.f١١٢٨٠a & 32) != 0) {
                        this.f١١٢٩٠k = Collections.unmodifiableList(this.f١١٢٩٠k);
                        this.f١١٢٨٠a &= -33;
                    }
                    bVar.f١١٢٧٤g = this.f١١٢٩٠k;
                }
                x1 x1Var6 = this.f١١٢٩٣n;
                if (x1Var6 != null) {
                    bVar.f١١٢٧٥h = x1Var6.g();
                } else {
                    if ((this.f١١٢٨٠a & 64) != 0) {
                        this.f١١٢٩٢m = Collections.unmodifiableList(this.f١١٢٩٢m);
                        this.f١١٢٨٠a &= -65;
                    }
                    bVar.f١١٢٧٥h = this.f١١٢٩٢m;
                }
                x1 x1Var7 = this.f١١٢٩٧r;
                if (x1Var7 != null) {
                    bVar.f١١٢٧٧j = x1Var7.g();
                } else {
                    if ((this.f١١٢٨٠a & 256) != 0) {
                        this.f١١٢٩٦q = Collections.unmodifiableList(this.f١١٢٩٦q);
                        this.f١١٢٨٠a &= -257;
                    }
                    bVar.f١١٢٧٧j = this.f١١٢٩٦q;
                }
                if ((this.f١١٢٨٠a & 512) != 0) {
                    this.f١١٢٩٨s = this.f١١٢٩٨s.getUnmodifiableView();
                    this.f١١٢٨٠a &= -513;
                }
                bVar.f١١٢٧٨k = this.f١١٢٩٨s;
            }

            private void l() {
                if ((this.f١١٢٨٠a & 16) == 0) {
                    this.f١١٢٨٨i = new ArrayList(this.f١١٢٨٨i);
                    this.f١١٢٨٠a |= 16;
                }
            }

            private void m() {
                if ((this.f١١٢٨٠a & 4) == 0) {
                    this.f١١٢٨٤e = new ArrayList(this.f١١٢٨٤e);
                    this.f١١٢٨٠a |= 4;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    F();
                    z();
                    I();
                    w();
                    C();
                    L();
                    O();
                    P();
                }
            }

            private void n() {
                if ((this.f١١٢٨٠a & 32) == 0) {
                    this.f١١٢٩٠k = new ArrayList(this.f١١٢٩٠k);
                    this.f١١٢٨٠a |= 32;
                }
            }

            private void o() {
                if ((this.f١١٢٨٠a & 2) == 0) {
                    this.f١١٢٨٢c = new ArrayList(this.f١١٢٨٢c);
                    this.f١١٢٨٠a |= 2;
                }
            }

            private void p() {
                if ((this.f١١٢٨٠a & 8) == 0) {
                    this.f١١٢٨٦g = new ArrayList(this.f١١٢٨٦g);
                    this.f١١٢٨٠a |= 8;
                }
            }

            private void q() {
                if ((this.f١١٢٨٠a & 64) == 0) {
                    this.f١١٢٩٢m = new ArrayList(this.f١١٢٩٢m);
                    this.f١١٢٨٠a |= 64;
                }
            }

            private void r() {
                if ((this.f١١٢٨٠a & 512) == 0) {
                    this.f١١٢٩٨s = new o0(this.f١١٢٩٨s);
                    this.f١١٢٨٠a |= 512;
                }
            }

            private void s() {
                if ((this.f١١٢٨٠a & 256) == 0) {
                    this.f١١٢٩٦q = new ArrayList(this.f١١٢٩٦q);
                    this.f١١٢٨٠a |= 256;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٢٨٩j == null) {
                    List list = this.f١١٢٨٨i;
                    if ((this.f١١٢٨٠a & 16) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٨٩j = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٨٨i = null;
                }
                return this.f١١٢٨٩j;
            }

            private x1 z() {
                boolean z10;
                if (this.f١١٢٨٥f == null) {
                    List list = this.f١١٢٨٤e;
                    if ((this.f١١٢٨٠a & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٢٨٥f = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٢٨٤e = null;
                }
                return this.f١١٢٨٥f;
            }

            public c A(int i10) {
                x1 x1Var = this.f١١٢٩١l;
                if (x1Var == null) {
                    return (c) this.f١١٢٩٠k.get(i10);
                }
                return (c) x1Var.o(i10);
            }

            public int B() {
                x1 x1Var = this.f١١٢٩١l;
                if (x1Var == null) {
                    return this.f١١٢٩٠k.size();
                }
                return x1Var.n();
            }

            public h D(int i10) {
                x1 x1Var = this.f١١٢٨٣d;
                if (x1Var == null) {
                    return (h) this.f١١٢٨٢c.get(i10);
                }
                return (h) x1Var.o(i10);
            }

            public int E() {
                x1 x1Var = this.f١١٢٨٣d;
                if (x1Var == null) {
                    return this.f١١٢٨٢c.size();
                }
                return x1Var.n();
            }

            public b G(int i10) {
                x1 x1Var = this.f١١٢٨٧h;
                if (x1Var == null) {
                    return (b) this.f١١٢٨٦g.get(i10);
                }
                return (b) x1Var.o(i10);
            }

            public int H() {
                x1 x1Var = this.f١١٢٨٧h;
                if (x1Var == null) {
                    return this.f١١٢٨٦g.size();
                }
                return x1Var.n();
            }

            public o J(int i10) {
                x1 x1Var = this.f١١٢٩٣n;
                if (x1Var == null) {
                    return (o) this.f١١٢٩٢m.get(i10);
                }
                return (o) x1Var.o(i10);
            }

            public int K() {
                x1 x1Var = this.f١١٢٩٣n;
                if (x1Var == null) {
                    return this.f١١٢٩٢m.size();
                }
                return x1Var.n();
            }

            public l M() {
                b2 b2Var = this.f١١٢٩٥p;
                if (b2Var == null) {
                    l lVar = this.f١١٢٩٤o;
                    if (lVar == null) {
                        return l.z();
                    }
                    return lVar;
                }
                return (l) b2Var.e();
            }

            public l.b N() {
                this.f١١٢٨٠a |= 128;
                onChanged();
                return (l.b) O().d();
            }

            public boolean Q() {
                if ((this.f١١٢٨٠a & 128) != 0) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: R, reason: merged with bridge method [inline-methods] */
            public C٠١٣٧b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.f١١٢٨١b = iVar.r();
                                    this.f١١٢٨٠a |= 1;
                                case 18:
                                    h hVar = (h) iVar.A(h.f١١٣٨٩o, vVar);
                                    x1 x1Var = this.f١١٢٨٣d;
                                    if (x1Var == null) {
                                        o();
                                        this.f١١٢٨٢c.add(hVar);
                                    } else {
                                        x1Var.f(hVar);
                                    }
                                case 26:
                                    b bVar = (b) iVar.A(b.f١١٢٦٧n, vVar);
                                    x1 x1Var2 = this.f١١٢٨٧h;
                                    if (x1Var2 == null) {
                                        p();
                                        this.f١١٢٨٦g.add(bVar);
                                    } else {
                                        x1Var2.f(bVar);
                                    }
                                case 34:
                                    c cVar = (c) iVar.A(c.f١١٣٢١i, vVar);
                                    x1 x1Var3 = this.f١١٢٨٩j;
                                    if (x1Var3 == null) {
                                        l();
                                        this.f١١٢٨٨i.add(cVar);
                                    } else {
                                        x1Var3.f(cVar);
                                    }
                                case 42:
                                    c cVar2 = (c) iVar.A(c.f١١٣٠٠g, vVar);
                                    x1 x1Var4 = this.f١١٢٩١l;
                                    if (x1Var4 == null) {
                                        n();
                                        this.f١١٢٩٠k.add(cVar2);
                                    } else {
                                        x1Var4.f(cVar2);
                                    }
                                case 50:
                                    h hVar2 = (h) iVar.A(h.f١١٣٨٩o, vVar);
                                    x1 x1Var5 = this.f١١٢٨٥f;
                                    if (x1Var5 == null) {
                                        m();
                                        this.f١١٢٨٤e.add(hVar2);
                                    } else {
                                        x1Var5.f(hVar2);
                                    }
                                case 58:
                                    iVar.B(O().d(), vVar);
                                    this.f١١٢٨٠a |= 128;
                                case 66:
                                    o oVar = (o) iVar.A(o.f١١٦٢٥f, vVar);
                                    x1 x1Var6 = this.f١١٢٩٣n;
                                    if (x1Var6 == null) {
                                        q();
                                        this.f١١٢٩٢m.add(oVar);
                                    } else {
                                        x1Var6.f(oVar);
                                    }
                                case 74:
                                    d dVar = (d) iVar.A(d.f١١٣١٢f, vVar);
                                    x1 x1Var7 = this.f١١٢٩٧r;
                                    if (x1Var7 == null) {
                                        s();
                                        this.f١١٢٩٦q.add(dVar);
                                    } else {
                                        x1Var7.f(dVar);
                                    }
                                case 82:
                                    com.google.protobuf.h r10 = iVar.r();
                                    r();
                                    this.f١١٢٩٨s.j(r10);
                                default:
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                        z10 = true;
                                    }
                            }
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public C٠١٣٧b S(b bVar) {
                x1 x1Var;
                x1 x1Var2;
                x1 x1Var3;
                x1 x1Var4;
                x1 x1Var5;
                x1 x1Var6;
                if (bVar == b.G()) {
                    return this;
                }
                if (bVar.f0()) {
                    this.f١١٢٨١b = bVar.f١١٢٦٩b;
                    this.f١١٢٨٠a |= 1;
                    onChanged();
                }
                x1 x1Var7 = null;
                if (this.f١١٢٨٣d == null) {
                    if (!bVar.f١١٢٧٠c.isEmpty()) {
                        if (this.f١١٢٨٢c.isEmpty()) {
                            this.f١١٢٨٢c = bVar.f١١٢٧٠c;
                            this.f١١٢٨٠a &= -3;
                        } else {
                            o();
                            this.f١١٢٨٢c.addAll(bVar.f١١٢٧٠c);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٠c.isEmpty()) {
                    if (this.f١١٢٨٣d.u()) {
                        this.f١١٢٨٣d.i();
                        this.f١١٢٨٣d = null;
                        this.f١١٢٨٢c = bVar.f١١٢٧٠c;
                        this.f١١٢٨٠a &= -3;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = F();
                        } else {
                            x1Var = null;
                        }
                        this.f١١٢٨٣d = x1Var;
                    } else {
                        this.f١١٢٨٣d.b(bVar.f١١٢٧٠c);
                    }
                }
                if (this.f١١٢٨٥f == null) {
                    if (!bVar.f١١٢٧١d.isEmpty()) {
                        if (this.f١١٢٨٤e.isEmpty()) {
                            this.f١١٢٨٤e = bVar.f١١٢٧١d;
                            this.f١١٢٨٠a &= -5;
                        } else {
                            m();
                            this.f١١٢٨٤e.addAll(bVar.f١١٢٧١d);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧١d.isEmpty()) {
                    if (this.f١١٢٨٥f.u()) {
                        this.f١١٢٨٥f.i();
                        this.f١١٢٨٥f = null;
                        this.f١١٢٨٤e = bVar.f١١٢٧١d;
                        this.f١١٢٨٠a &= -5;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var2 = z();
                        } else {
                            x1Var2 = null;
                        }
                        this.f١١٢٨٥f = x1Var2;
                    } else {
                        this.f١١٢٨٥f.b(bVar.f١١٢٧١d);
                    }
                }
                if (this.f١١٢٨٧h == null) {
                    if (!bVar.f١١٢٧٢e.isEmpty()) {
                        if (this.f١١٢٨٦g.isEmpty()) {
                            this.f١١٢٨٦g = bVar.f١١٢٧٢e;
                            this.f١١٢٨٠a &= -9;
                        } else {
                            p();
                            this.f١١٢٨٦g.addAll(bVar.f١١٢٧٢e);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٢e.isEmpty()) {
                    if (this.f١١٢٨٧h.u()) {
                        this.f١١٢٨٧h.i();
                        this.f١١٢٨٧h = null;
                        this.f١١٢٨٦g = bVar.f١١٢٧٢e;
                        this.f١١٢٨٠a &= -9;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var3 = I();
                        } else {
                            x1Var3 = null;
                        }
                        this.f١١٢٨٧h = x1Var3;
                    } else {
                        this.f١١٢٨٧h.b(bVar.f١١٢٧٢e);
                    }
                }
                if (this.f١١٢٨٩j == null) {
                    if (!bVar.f١١٢٧٣f.isEmpty()) {
                        if (this.f١١٢٨٨i.isEmpty()) {
                            this.f١١٢٨٨i = bVar.f١١٢٧٣f;
                            this.f١١٢٨٠a &= -17;
                        } else {
                            l();
                            this.f١١٢٨٨i.addAll(bVar.f١١٢٧٣f);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٣f.isEmpty()) {
                    if (this.f١١٢٨٩j.u()) {
                        this.f١١٢٨٩j.i();
                        this.f١١٢٨٩j = null;
                        this.f١١٢٨٨i = bVar.f١١٢٧٣f;
                        this.f١١٢٨٠a &= -17;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var4 = w();
                        } else {
                            x1Var4 = null;
                        }
                        this.f١١٢٨٩j = x1Var4;
                    } else {
                        this.f١١٢٨٩j.b(bVar.f١١٢٧٣f);
                    }
                }
                if (this.f١١٢٩١l == null) {
                    if (!bVar.f١١٢٧٤g.isEmpty()) {
                        if (this.f١١٢٩٠k.isEmpty()) {
                            this.f١١٢٩٠k = bVar.f١١٢٧٤g;
                            this.f١١٢٨٠a &= -33;
                        } else {
                            n();
                            this.f١١٢٩٠k.addAll(bVar.f١١٢٧٤g);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٤g.isEmpty()) {
                    if (this.f١١٢٩١l.u()) {
                        this.f١١٢٩١l.i();
                        this.f١١٢٩١l = null;
                        this.f١١٢٩٠k = bVar.f١١٢٧٤g;
                        this.f١١٢٨٠a &= -33;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var5 = C();
                        } else {
                            x1Var5 = null;
                        }
                        this.f١١٢٩١l = x1Var5;
                    } else {
                        this.f١١٢٩١l.b(bVar.f١١٢٧٤g);
                    }
                }
                if (this.f١١٢٩٣n == null) {
                    if (!bVar.f١١٢٧٥h.isEmpty()) {
                        if (this.f١١٢٩٢m.isEmpty()) {
                            this.f١١٢٩٢m = bVar.f١١٢٧٥h;
                            this.f١١٢٨٠a &= -65;
                        } else {
                            q();
                            this.f١١٢٩٢m.addAll(bVar.f١١٢٧٥h);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٥h.isEmpty()) {
                    if (this.f١١٢٩٣n.u()) {
                        this.f١١٢٩٣n.i();
                        this.f١١٢٩٣n = null;
                        this.f١١٢٩٢m = bVar.f١١٢٧٥h;
                        this.f١١٢٨٠a &= -65;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var6 = L();
                        } else {
                            x1Var6 = null;
                        }
                        this.f١١٢٩٣n = x1Var6;
                    } else {
                        this.f١١٢٩٣n.b(bVar.f١١٢٧٥h);
                    }
                }
                if (bVar.g0()) {
                    U(bVar.a0());
                }
                if (this.f١١٢٩٧r == null) {
                    if (!bVar.f١١٢٧٧j.isEmpty()) {
                        if (this.f١١٢٩٦q.isEmpty()) {
                            this.f١١٢٩٦q = bVar.f١١٢٧٧j;
                            this.f١١٢٨٠a &= -257;
                        } else {
                            s();
                            this.f١١٢٩٦q.addAll(bVar.f١١٢٧٧j);
                        }
                        onChanged();
                    }
                } else if (!bVar.f١١٢٧٧j.isEmpty()) {
                    if (this.f١١٢٩٧r.u()) {
                        this.f١١٢٩٧r.i();
                        this.f١١٢٩٧r = null;
                        this.f١١٢٩٦q = bVar.f١١٢٧٧j;
                        this.f١١٢٨٠a &= -257;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var7 = P();
                        }
                        this.f١١٢٩٧r = x1Var7;
                    } else {
                        this.f١١٢٩٧r.b(bVar.f١١٢٧٧j);
                    }
                }
                if (!bVar.f١١٢٧٨k.isEmpty()) {
                    if (this.f١١٢٩٨s.isEmpty()) {
                        this.f١١٢٩٨s = bVar.f١١٢٧٨k;
                        this.f١١٢٨٠a &= -513;
                    } else {
                        r();
                        this.f١١٢٩٨s.addAll(bVar.f١١٢٧٨k);
                    }
                    onChanged();
                }
                mergeUnknownFields(bVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: T, reason: merged with bridge method [inline-methods] */
            public C٠١٣٧b mergeFrom(b1 b1Var) {
                if (b1Var instanceof b) {
                    return S((b) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public C٠١٣٧b U(l lVar) {
                l lVar2;
                b2 b2Var = this.f١١٢٩٥p;
                if (b2Var == null) {
                    if ((this.f١١٢٨٠a & 128) != 0 && (lVar2 = this.f١١٢٩٤o) != null && lVar2 != l.z()) {
                        N().y(lVar);
                    } else {
                        this.f١١٢٩٤o = lVar;
                    }
                } else {
                    b2Var.g(lVar);
                }
                this.f١١٢٨٠a |= 128;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: V, reason: merged with bridge method [inline-methods] */
            public final C٠١٣٧b mergeUnknownFields(k2 k2Var) {
                return (C٠١٣٧b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: W, reason: merged with bridge method [inline-methods] */
            public C٠١٣٧b setField(n.g gVar, Object obj) {
                return (C٠١٣٧b) super.setField(gVar, obj);
            }

            public C٠١٣٧b X(String str) {
                str.getClass();
                this.f١١٢٨١b = str;
                this.f١١٢٨٠a |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: Y, reason: merged with bridge method [inline-methods] */
            public final C٠١٣٧b setUnknownFields(k2 k2Var) {
                return (C٠١٣٧b) super.setUnknownFields(k2Var);
            }

            public C٠١٣٧b e(c cVar) {
                x1 x1Var = this.f١١٢٩١l;
                if (x1Var == null) {
                    cVar.getClass();
                    n();
                    this.f١١٢٩٠k.add(cVar);
                    onChanged();
                } else {
                    x1Var.f(cVar);
                }
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public C٠١٣٧b addRepeatedField(n.g gVar, Object obj) {
                return (C٠١٣٧b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public b build() {
                b buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٤٤e;
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public b buildPartial() {
                b bVar = new b(this);
                j(bVar);
                if (this.f١١٢٨٠a != 0) {
                    i(bVar);
                }
                onBuilt();
                return bVar;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٤٥f.d(b.class, C٠١٣٧b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < E(); i10++) {
                    if (!D(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < y(); i11++) {
                    if (!x(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < H(); i12++) {
                    if (!G(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < v(); i13++) {
                    if (!u(i13).isInitialized()) {
                        return false;
                    }
                }
                for (int i14 = 0; i14 < B(); i14++) {
                    if (!A(i14).isInitialized()) {
                        return false;
                    }
                }
                for (int i15 = 0; i15 < K(); i15++) {
                    if (!J(i15).isInitialized()) {
                        return false;
                    }
                }
                if (Q() && !M().isInitialized()) {
                    return false;
                }
                return true;
            }

            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public C٠١٣٧b clone() {
                return (C٠١٣٧b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b getDefaultInstanceForType() {
                return b.G();
            }

            public c u(int i10) {
                x1 x1Var = this.f١١٢٨٩j;
                if (x1Var == null) {
                    return (c) this.f١١٢٨٨i.get(i10);
                }
                return (c) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٢٨٩j;
                if (x1Var == null) {
                    return this.f١١٢٨٨i.size();
                }
                return x1Var.n();
            }

            public h x(int i10) {
                x1 x1Var = this.f١١٢٨٥f;
                if (x1Var == null) {
                    return (h) this.f١١٢٨٤e.get(i10);
                }
                return (h) x1Var.o(i10);
            }

            public int y() {
                x1 x1Var = this.f١١٢٨٥f;
                if (x1Var == null) {
                    return this.f١١٢٨٤e.size();
                }
                return x1Var.n();
            }

            private C٠١٣٧b() {
                this.f١١٢٨١b = "";
                this.f١١٢٨٢c = Collections.emptyList();
                this.f١١٢٨٤e = Collections.emptyList();
                this.f١١٢٨٦g = Collections.emptyList();
                this.f١١٢٨٨i = Collections.emptyList();
                this.f١١٢٩٠k = Collections.emptyList();
                this.f١١٢٩٢m = Collections.emptyList();
                this.f١١٢٩٦q = Collections.emptyList();
                this.f١١٢٩٨s = o0.f١١٨٥٤d;
                maybeForceBuilderInitialization();
            }

            private C٠١٣٧b(h0.c cVar) {
                super(cVar);
                this.f١١٢٨١b = "";
                this.f١١٢٨٢c = Collections.emptyList();
                this.f١١٢٨٤e = Collections.emptyList();
                this.f١١٢٨٦g = Collections.emptyList();
                this.f١١٢٨٨i = Collections.emptyList();
                this.f١١٢٩٠k = Collections.emptyList();
                this.f١١٢٩٢m = Collections.emptyList();
                this.f١١٢٩٦q = Collections.emptyList();
                this.f١١٢٩٨s = o0.f١١٨٥٤d;
                maybeForceBuilderInitialization();
            }
        }

        private b(h0.b bVar) {
            super(bVar);
            this.f١١٢٦٩b = "";
            this.f١١٢٧٩l = (byte) -1;
        }

        private b() {
            this.f١١٢٦٩b = "";
            this.f١١٢٧٩l = (byte) -1;
            this.f١١٢٦٩b = "";
            this.f١١٢٧٠c = Collections.emptyList();
            this.f١١٢٧١d = Collections.emptyList();
            this.f١١٢٧٢e = Collections.emptyList();
            this.f١١٢٧٣f = Collections.emptyList();
            this.f١١٢٧٤g = Collections.emptyList();
            this.f١١٢٧٥h = Collections.emptyList();
            this.f١١٢٧٧j = Collections.emptyList();
            this.f١١٢٧٨k = o0.f١١٨٥٤d;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c extends h0 implements g1 {

        /* renamed from: h, reason: collision with root package name */
        private static final c f١١٣٢٠h = new c();

        /* renamed from: i, reason: collision with root package name */
        public static final r1 f١١٣٢١i = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٣٢٢a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٣٢٣b;

        /* renamed from: c, reason: collision with root package name */
        private List f١١٣٢٤c;

        /* renamed from: d, reason: collision with root package name */
        private d f١١٣٢٥d;

        /* renamed from: e, reason: collision with root package name */
        private List f١١٣٢٦e;

        /* renamed from: f, reason: collision with root package name */
        private p0 f١١٣٢٧f;

        /* renamed from: g, reason: collision with root package name */
        private byte f١١٣٢٨g;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public c parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b I = c.I();
                try {
                    I.mergeFrom(iVar, vVar);
                    return I.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(I.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(I.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(I.buildPartial());
                }
            }
        }

        /* renamed from: com.google.protobuf.m$c$c, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class C٠١٤٠c extends h0 implements g1 {

            /* renamed from: e, reason: collision with root package name */
            private static final C٠١٤٠c f١١٣٣٨e = new C٠١٤٠c();

            /* renamed from: f, reason: collision with root package name */
            public static final r1 f١١٣٣٩f = new a();
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f١١٣٤٠a;

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣٤١b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٣٤٢c;

            /* renamed from: d, reason: collision with root package name */
            private byte f١١٣٤٣d;

            /* renamed from: com.google.protobuf.m$c$c$a */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a extends com.google.protobuf.c {
                a() {
                }

                @Override // com.google.protobuf.r1
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public C٠١٤٠c parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                    b v10 = C٠١٤٠c.v();
                    try {
                        v10.mergeFrom(iVar, vVar);
                        return v10.buildPartial();
                    } catch (i2 e10) {
                        throw e10.a().j(v10.buildPartial());
                    } catch (k0 e11) {
                        throw e11.j(v10.buildPartial());
                    } catch (IOException e12) {
                        throw new k0(e12).j(v10.buildPartial());
                    }
                }
            }

            public static final n.b getDescriptor() {
                return m.f١١٢٥٨s;
            }

            static /* synthetic */ int o(C٠١٤٠c r12, int i10) {
                int i11 = i10 | r12.f١١٣٤٠a;
                r12.f١١٣٤٠a = i11;
                return i11;
            }

            public static C٠١٤٠c p() {
                return f١١٣٣٨e;
            }

            public static b v() {
                return f١١٣٣٨e.toBuilder();
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C٠١٤٠c)) {
                    return super.equals(obj);
                }
                C٠١٤٠c r52 = (C٠١٤٠c) obj;
                if (u() != r52.u()) {
                    return false;
                }
                if ((u() && s() != r52.s()) || t() != r52.t()) {
                    return false;
                }
                if ((!t() || r() == r52.r()) && getUnknownFields().equals(r52.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                if ((this.f١١٣٤٠a & 1) != 0) {
                    i10 = com.google.protobuf.k.x(1, this.f١١٣٤١b);
                } else {
                    i10 = 0;
                }
                if ((this.f١١٣٤٠a & 2) != 0) {
                    i10 += com.google.protobuf.k.x(2, this.f١١٣٤٢c);
                }
                int serializedSize = i10 + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.g1
            public final k2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (u()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + s();
                }
                if (t()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + r();
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.h0
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٥٩t.d(C٠١٤٠c.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                byte b10 = this.f١١٣٤٣d;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f١١٣٤٣d = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            public Object newInstance(h0.g gVar) {
                return new C٠١٤٠c();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public C٠١٤٠c getDefaultInstanceForType() {
                return f١١٣٣٨e;
            }

            public int r() {
                return this.f١١٣٤٢c;
            }

            public int s() {
                return this.f١١٣٤١b;
            }

            public boolean t() {
                if ((this.f١١٣٤٠a & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean u() {
                if ((this.f١١٣٤٠a & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return v();
            }

            @Override // com.google.protobuf.e1
            public void writeTo(com.google.protobuf.k kVar) {
                if ((this.f١١٣٤٠a & 1) != 0) {
                    kVar.D0(1, this.f١١٣٤١b);
                }
                if ((this.f١١٣٤٠a & 2) != 0) {
                    kVar.D0(2, this.f١١٣٤٢c);
                }
                getUnknownFields().writeTo(kVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType(h0.c cVar) {
                return new b(cVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                if (this == f١١٣٣٨e) {
                    return new b();
                }
                return new b().l(this);
            }

            /* renamed from: com.google.protobuf.m$c$c$b */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class b extends h0.b implements g1 {

                /* renamed from: a, reason: collision with root package name */
                private int f١١٣٤٤a;

                /* renamed from: b, reason: collision with root package name */
                private int f١١٣٤٥b;

                /* renamed from: c, reason: collision with root package name */
                private int f١١٣٤٦c;

                private void h(C٠١٤٠c r32) {
                    int i10;
                    int i11 = this.f١١٣٤٤a;
                    if ((i11 & 1) != 0) {
                        r32.f١١٣٤١b = this.f١١٣٤٥b;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 2) != 0) {
                        r32.f١١٣٤٢c = this.f١١٣٤٦c;
                        i10 |= 2;
                    }
                    C٠١٤٠c.o(r32, i10);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(n.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public C٠١٤٠c build() {
                    C٠١٤٠c buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public C٠١٤٠c buildPartial() {
                    C٠١٤٠c r02 = new C٠١٤٠c(this);
                    if (this.f١١٣٤٤a != 0) {
                        h(r02);
                    }
                    onBuilt();
                    return r02;
                }

                @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
                public n.b getDescriptorForType() {
                    return m.f١١٢٥٨s;
                }

                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return (b) super.clone();
                }

                @Override // com.google.protobuf.h0.b
                protected h0.f internalGetFieldAccessorTable() {
                    return m.f١١٢٥٩t.d(C٠١٤٠c.class, b.class);
                }

                @Override // com.google.protobuf.f1
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.f1
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public C٠١٤٠c getDefaultInstanceForType() {
                    return C٠١٤٠c.p();
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
                /* renamed from: k, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                    vVar.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int K = iVar.K();
                                if (K != 0) {
                                    if (K != 8) {
                                        if (K != 16) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            this.f١١٣٤٦c = iVar.y();
                                            this.f١١٣٤٤a |= 2;
                                        }
                                    } else {
                                        this.f١١٣٤٥b = iVar.y();
                                        this.f١١٣٤٤a |= 1;
                                    }
                                }
                                z10 = true;
                            } catch (k0 e10) {
                                throw e10.m();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                public b l(C٠١٤٠c r22) {
                    if (r22 == C٠١٤٠c.p()) {
                        return this;
                    }
                    if (r22.u()) {
                        q(r22.s());
                    }
                    if (r22.t()) {
                        o(r22.r());
                    }
                    mergeUnknownFields(r22.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(b1 b1Var) {
                    if (b1Var instanceof C٠١٤٠c) {
                        return l((C٠١٤٠c) b1Var);
                    }
                    super.mergeFrom(b1Var);
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final b mergeUnknownFields(k2 k2Var) {
                    return (b) super.mergeUnknownFields(k2Var);
                }

                public b o(int i10) {
                    this.f١١٣٤٦c = i10;
                    this.f١١٣٤٤a |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public b setField(n.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                public b q(int i10) {
                    this.f١١٣٤٥b = i10;
                    this.f١١٣٤٤a |= 1;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(k2 k2Var) {
                    return (b) super.setUnknownFields(k2Var);
                }

                private b() {
                }

                private b(h0.c cVar) {
                    super(cVar);
                }
            }

            private C٠١٤٠c(h0.b bVar) {
                super(bVar);
                this.f١١٣٤١b = 0;
                this.f١١٣٤٢c = 0;
                this.f١١٣٤٣d = (byte) -1;
            }

            private C٠١٤٠c() {
                this.f١١٣٤١b = 0;
                this.f١١٣٤٢c = 0;
                this.f١١٣٤٣d = (byte) -1;
            }
        }

        public static b I() {
            return f١١٣٢٠h.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٥٦q;
        }

        static /* synthetic */ int v(c cVar, int i10) {
            int i11 = i10 | cVar.f١١٣٢٢a;
            cVar.f١١٣٢٢a = i11;
            return i11;
        }

        public static c w() {
            return f١١٣٢٠h;
        }

        public v1 A() {
            return this.f١١٣٢٧f;
        }

        public int B() {
            return this.f١١٣٢٦e.size();
        }

        public List C() {
            return this.f١١٣٢٦e;
        }

        public e D(int i10) {
            return (e) this.f١١٣٢٤c.get(i10);
        }

        public int E() {
            return this.f١١٣٢٤c.size();
        }

        public List F() {
            return this.f١١٣٢٤c;
        }

        public boolean G() {
            if ((this.f١١٣٢٢a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean H() {
            if ((this.f١١٣٢٢a & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return I();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٢٠h) {
                return new b();
            }
            return new b().x(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            if (G() != cVar.G()) {
                return false;
            }
            if ((G() && !getName().equals(cVar.getName())) || !F().equals(cVar.F()) || H() != cVar.H()) {
                return false;
            }
            if ((!H() || y().equals(cVar.y())) && C().equals(cVar.C()) && A().equals(cVar.A()) && getUnknownFields().equals(cVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٣٢٣b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٢٣b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٣٢٢a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٣٢٣b);
            } else {
                i10 = 0;
            }
            for (int i12 = 0; i12 < this.f١١٣٢٤c.size(); i12++) {
                i10 += com.google.protobuf.k.G(2, (e1) this.f١١٣٢٤c.get(i12));
            }
            if ((this.f١١٣٢٢a & 2) != 0) {
                i10 += com.google.protobuf.k.G(3, y());
            }
            for (int i13 = 0; i13 < this.f١١٣٢٦e.size(); i13++) {
                i10 += com.google.protobuf.k.G(4, (e1) this.f١١٣٢٦e.get(i13));
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f١١٣٢٧f.size(); i15++) {
                i14 += h0.computeStringSizeNoTag(this.f١١٣٢٧f.S(i15));
            }
            int size = i10 + i14 + A().size() + getUnknownFields().getSerializedSize();
            this.memoizedSize = size;
            return size;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (G()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (E() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + F().hashCode();
            }
            if (H()) {
                hashCode = (((hashCode * 37) + 3) * 53) + y().hashCode();
            }
            if (B() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + C().hashCode();
            }
            if (z() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + A().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٥٧r.d(c.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٣٢٨g;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < E(); i10++) {
                if (!D(i10).isInitialized()) {
                    this.f١١٣٢٨g = (byte) 0;
                    return false;
                }
            }
            if (H() && !y().isInitialized()) {
                this.f١١٣٢٨g = (byte) 0;
                return false;
            }
            this.f١١٣٢٨g = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new c();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٣٢٢a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٣٢٣b);
            }
            for (int i10 = 0; i10 < this.f١١٣٢٤c.size(); i10++) {
                kVar.H0(2, (e1) this.f١١٣٢٤c.get(i10));
            }
            if ((this.f١١٣٢٢a & 2) != 0) {
                kVar.H0(3, y());
            }
            for (int i11 = 0; i11 < this.f١١٣٢٦e.size(); i11++) {
                kVar.H0(4, (e1) this.f١١٣٢٦e.get(i11));
            }
            for (int i12 = 0; i12 < this.f١١٣٢٧f.size(); i12++) {
                h0.writeString(kVar, 5, this.f١١٣٢٧f.S(i12));
            }
            getUnknownFields().writeTo(kVar);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public c getDefaultInstanceForType() {
            return f١١٣٢٠h;
        }

        public d y() {
            d dVar = this.f١١٣٢٥d;
            if (dVar == null) {
                return d.y();
            }
            return dVar;
        }

        public int z() {
            return this.f١١٣٢٧f.size();
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٣٢٩a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٣٣٠b;

            /* renamed from: c, reason: collision with root package name */
            private List f١١٣٣١c;

            /* renamed from: d, reason: collision with root package name */
            private x1 f١١٣٣٢d;

            /* renamed from: e, reason: collision with root package name */
            private d f١١٣٣٣e;

            /* renamed from: f, reason: collision with root package name */
            private b2 f١١٣٣٤f;

            /* renamed from: g, reason: collision with root package name */
            private List f١١٣٣٥g;

            /* renamed from: h, reason: collision with root package name */
            private x1 f١١٣٣٦h;

            /* renamed from: i, reason: collision with root package name */
            private p0 f١١٣٣٧i;

            private void h(c cVar) {
                int i10;
                d dVar;
                int i11 = this.f١١٣٢٩a;
                if ((i11 & 1) != 0) {
                    cVar.f١١٣٢٣b = this.f١١٣٣٠b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 4) != 0) {
                    b2 b2Var = this.f١١٣٣٤f;
                    if (b2Var == null) {
                        dVar = this.f١١٣٣٣e;
                    } else {
                        dVar = (d) b2Var.b();
                    }
                    cVar.f١١٣٢٥d = dVar;
                    i10 |= 2;
                }
                c.v(cVar, i10);
            }

            private void i(c cVar) {
                x1 x1Var = this.f١١٣٣٢d;
                if (x1Var != null) {
                    cVar.f١١٣٢٤c = x1Var.g();
                } else {
                    if ((this.f١١٣٢٩a & 2) != 0) {
                        this.f١١٣٣١c = Collections.unmodifiableList(this.f١١٣٣١c);
                        this.f١١٣٢٩a &= -3;
                    }
                    cVar.f١١٣٢٤c = this.f١١٣٣١c;
                }
                x1 x1Var2 = this.f١١٣٣٦h;
                if (x1Var2 != null) {
                    cVar.f١١٣٢٦e = x1Var2.g();
                } else {
                    if ((this.f١١٣٢٩a & 8) != 0) {
                        this.f١١٣٣٥g = Collections.unmodifiableList(this.f١١٣٣٥g);
                        this.f١١٣٢٩a &= -9;
                    }
                    cVar.f١١٣٢٦e = this.f١١٣٣٥g;
                }
                if ((this.f١١٣٢٩a & 16) != 0) {
                    this.f١١٣٣٧i = this.f١١٣٣٧i.getUnmodifiableView();
                    this.f١١٣٢٩a &= -17;
                }
                cVar.f١١٣٢٧f = this.f١١٣٣٧i;
            }

            private void k() {
                if ((this.f١١٣٢٩a & 16) == 0) {
                    this.f١١٣٣٧i = new o0(this.f١١٣٣٧i);
                    this.f١١٣٢٩a |= 16;
                }
            }

            private void l() {
                if ((this.f١١٣٢٩a & 8) == 0) {
                    this.f١١٣٣٥g = new ArrayList(this.f١١٣٣٥g);
                    this.f١١٣٢٩a |= 8;
                }
            }

            private void m() {
                if ((this.f١١٣٢٩a & 2) == 0) {
                    this.f١١٣٣١c = new ArrayList(this.f١١٣٣١c);
                    this.f١١٣٢٩a |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    u();
                    q();
                    r();
                }
            }

            private b2 q() {
                if (this.f١١٣٣٤f == null) {
                    this.f١١٣٣٤f = new b2(o(), getParentForChildren(), isClean());
                    this.f١١٣٣٣e = null;
                }
                return this.f١١٣٣٤f;
            }

            private x1 r() {
                boolean z10;
                if (this.f١١٣٣٦h == null) {
                    List list = this.f١١٣٣٥g;
                    if ((this.f١١٣٢٩a & 8) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٣٣٦h = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٣٣٥g = null;
                }
                return this.f١١٣٣٦h;
            }

            private x1 u() {
                boolean z10;
                if (this.f١١٣٣٢d == null) {
                    List list = this.f١١٣٣١c;
                    if ((this.f١١٣٢٩a & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٣٣٢d = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٣٣١c = null;
                }
                return this.f١١٣٣٢d;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public c build() {
                c buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public c buildPartial() {
                c cVar = new c(this);
                i(cVar);
                if (this.f١١٣٢٩a != 0) {
                    h(cVar);
                }
                onBuilt();
                return cVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٥٦q;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٥٧r.d(c.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < t(); i10++) {
                    if (!s(i10).isInitialized()) {
                        return false;
                    }
                }
                if (v() && !o().isInitialized()) {
                    return false;
                }
                return true;
            }

            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public c getDefaultInstanceForType() {
                return c.w();
            }

            public d o() {
                b2 b2Var = this.f١١٣٣٤f;
                if (b2Var == null) {
                    d dVar = this.f١١٣٣٣e;
                    if (dVar == null) {
                        return d.y();
                    }
                    return dVar;
                }
                return (d) b2Var.e();
            }

            public d.b p() {
                this.f١١٣٢٩a |= 4;
                onChanged();
                return (d.b) q().d();
            }

            public e s(int i10) {
                x1 x1Var = this.f١١٣٣٢d;
                if (x1Var == null) {
                    return (e) this.f١١٣٣١c.get(i10);
                }
                return (e) x1Var.o(i10);
            }

            public int t() {
                x1 x1Var = this.f١١٣٣٢d;
                if (x1Var == null) {
                    return this.f١١٣٣١c.size();
                }
                return x1Var.n();
            }

            public boolean v() {
                if ((this.f١١٣٢٩a & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K != 18) {
                                        if (K != 26) {
                                            if (K != 34) {
                                                if (K != 42) {
                                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                                    }
                                                } else {
                                                    com.google.protobuf.h r10 = iVar.r();
                                                    k();
                                                    this.f١١٣٣٧i.j(r10);
                                                }
                                            } else {
                                                C٠١٤٠c r12 = (C٠١٤٠c) iVar.A(C٠١٤٠c.f١١٣٣٩f, vVar);
                                                x1 x1Var = this.f١١٣٣٦h;
                                                if (x1Var == null) {
                                                    l();
                                                    this.f١١٣٣٥g.add(r12);
                                                } else {
                                                    x1Var.f(r12);
                                                }
                                            }
                                        } else {
                                            iVar.B(q().d(), vVar);
                                            this.f١١٣٢٩a |= 4;
                                        }
                                    } else {
                                        e eVar = (e) iVar.A(e.f١١٣٦٠g, vVar);
                                        x1 x1Var2 = this.f١١٣٣٢d;
                                        if (x1Var2 == null) {
                                            m();
                                            this.f١١٣٣١c.add(eVar);
                                        } else {
                                            x1Var2.f(eVar);
                                        }
                                    }
                                } else {
                                    this.f١١٣٣٠b = iVar.r();
                                    this.f١١٣٢٩a |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b x(c cVar) {
                x1 x1Var;
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.G()) {
                    this.f١١٣٣٠b = cVar.f١١٣٢٣b;
                    this.f١١٣٢٩a |= 1;
                    onChanged();
                }
                x1 x1Var2 = null;
                if (this.f١١٣٣٢d == null) {
                    if (!cVar.f١١٣٢٤c.isEmpty()) {
                        if (this.f١١٣٣١c.isEmpty()) {
                            this.f١١٣٣١c = cVar.f١١٣٢٤c;
                            this.f١١٣٢٩a &= -3;
                        } else {
                            m();
                            this.f١١٣٣١c.addAll(cVar.f١١٣٢٤c);
                        }
                        onChanged();
                    }
                } else if (!cVar.f١١٣٢٤c.isEmpty()) {
                    if (this.f١١٣٣٢d.u()) {
                        this.f١١٣٣٢d.i();
                        this.f١١٣٣٢d = null;
                        this.f١١٣٣١c = cVar.f١١٣٢٤c;
                        this.f١١٣٢٩a &= -3;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = u();
                        } else {
                            x1Var = null;
                        }
                        this.f١١٣٣٢d = x1Var;
                    } else {
                        this.f١١٣٣٢d.b(cVar.f١١٣٢٤c);
                    }
                }
                if (cVar.H()) {
                    z(cVar.y());
                }
                if (this.f١١٣٣٦h == null) {
                    if (!cVar.f١١٣٢٦e.isEmpty()) {
                        if (this.f١١٣٣٥g.isEmpty()) {
                            this.f١١٣٣٥g = cVar.f١١٣٢٦e;
                            this.f١١٣٢٩a &= -9;
                        } else {
                            l();
                            this.f١١٣٣٥g.addAll(cVar.f١١٣٢٦e);
                        }
                        onChanged();
                    }
                } else if (!cVar.f١١٣٢٦e.isEmpty()) {
                    if (this.f١١٣٣٦h.u()) {
                        this.f١١٣٣٦h.i();
                        this.f١١٣٣٦h = null;
                        this.f١١٣٣٥g = cVar.f١١٣٢٦e;
                        this.f١١٣٢٩a &= -9;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var2 = r();
                        }
                        this.f١١٣٣٦h = x1Var2;
                    } else {
                        this.f١١٣٣٦h.b(cVar.f١١٣٢٦e);
                    }
                }
                if (!cVar.f١١٣٢٧f.isEmpty()) {
                    if (this.f١١٣٣٧i.isEmpty()) {
                        this.f١١٣٣٧i = cVar.f١١٣٢٧f;
                        this.f١١٣٢٩a &= -17;
                    } else {
                        k();
                        this.f١١٣٣٧i.addAll(cVar.f١١٣٢٧f);
                    }
                    onChanged();
                }
                mergeUnknownFields(cVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof c) {
                    return x((c) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b z(d dVar) {
                d dVar2;
                b2 b2Var = this.f١١٣٣٤f;
                if (b2Var == null) {
                    if ((this.f١١٣٢٩a & 4) != 0 && (dVar2 = this.f١١٣٣٣e) != null && dVar2 != d.y()) {
                        p().y(dVar);
                    } else {
                        this.f١١٣٣٣e = dVar;
                    }
                } else {
                    b2Var.g(dVar);
                }
                this.f١١٣٢٩a |= 4;
                onChanged();
                return this;
            }

            private b() {
                this.f١١٣٣٠b = "";
                this.f١١٣٣١c = Collections.emptyList();
                this.f١١٣٣٥g = Collections.emptyList();
                this.f١١٣٣٧i = o0.f١١٨٥٤d;
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٣٣٠b = "";
                this.f١١٣٣١c = Collections.emptyList();
                this.f١١٣٣٥g = Collections.emptyList();
                this.f١١٣٣٧i = o0.f١١٨٥٤d;
                maybeForceBuilderInitialization();
            }
        }

        private c(h0.b bVar) {
            super(bVar);
            this.f١١٣٢٣b = "";
            this.f١١٣٢٨g = (byte) -1;
        }

        private c() {
            this.f١١٣٢٣b = "";
            this.f١١٣٢٨g = (byte) -1;
            this.f١١٣٢٣b = "";
            this.f١١٣٢٤c = Collections.emptyList();
            this.f١١٣٢٦e = Collections.emptyList();
            this.f١١٣٢٧f = o0.f١١٨٥٤d;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d extends h0.e implements g1 {

        /* renamed from: g, reason: collision with root package name */
        private static final d f١١٣٤٧g = new d();

        /* renamed from: h, reason: collision with root package name */
        public static final r1 f١١٣٤٨h = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٣٤٩b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١١٣٥٠c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١١٣٥١d;

        /* renamed from: e, reason: collision with root package name */
        private List f١١٣٥٢e;

        /* renamed from: f, reason: collision with root package name */
        private byte f١١٣٥٣f;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public d parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b G = d.G();
                try {
                    G.mergeFrom(iVar, vVar);
                    return G.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(G.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(G.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(G.buildPartial());
                }
            }
        }

        public static b G() {
            return f١١٣٤٧g.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.I;
        }

        static /* synthetic */ int w(d dVar, int i10) {
            int i11 = i10 | dVar.f١١٣٤٩b;
            dVar.f١١٣٤٩b = i11;
            return i11;
        }

        public static d y() {
            return f١١٣٤٧g;
        }

        public boolean A() {
            return this.f١١٣٥١d;
        }

        public t B(int i10) {
            return (t) this.f١١٣٥٢e.get(i10);
        }

        public int C() {
            return this.f١١٣٥٢e.size();
        }

        public List D() {
            return this.f١١٣٥٢e;
        }

        public boolean E() {
            if ((this.f١١٣٤٩b & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean F() {
            if ((this.f١١٣٤٩b & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return G();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٤٧g) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return super.equals(obj);
            }
            d dVar = (d) obj;
            if (E() != dVar.E()) {
                return false;
            }
            if ((E() && x() != dVar.x()) || F() != dVar.F()) {
                return false;
            }
            if ((!F() || A() == dVar.A()) && D().equals(dVar.D()) && getUnknownFields().equals(dVar.getUnknownFields()) && p().equals(dVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٣٤٩b & 1) != 0) {
                i10 = com.google.protobuf.k.e(2, this.f١١٣٥٠c);
            } else {
                i10 = 0;
            }
            if ((2 & this.f١١٣٤٩b) != 0) {
                i10 += com.google.protobuf.k.e(3, this.f١١٣٥١d);
            }
            for (int i12 = 0; i12 < this.f١١٣٥٢e.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٣٥٢e.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (E()) {
                hashCode = (((hashCode * 37) + 2) * 53) + j0.c(x());
            }
            if (F()) {
                hashCode = (((hashCode * 37) + 3) * 53) + j0.c(A());
            }
            if (C() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + D().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.J.d(d.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٣٥٣f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < C(); i10++) {
                if (!B(i10).isInitialized()) {
                    this.f١١٣٥٣f = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٣٥٣f = (byte) 0;
                return false;
            }
            this.f١١٣٥٣f = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new d();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٣٤٩b & 1) != 0) {
                kVar.l0(2, this.f١١٣٥٠c);
            }
            if ((this.f١١٣٤٩b & 2) != 0) {
                kVar.l0(3, this.f١١٣٥١d);
            }
            for (int i10 = 0; i10 < this.f١١٣٥٢e.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٣٥٢e.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        public boolean x() {
            return this.f١١٣٥٠c;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public d getDefaultInstanceForType() {
            return f١١٣٤٧g;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣٥٤b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٣٥٥c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f١١٣٥٦d;

            /* renamed from: e, reason: collision with root package name */
            private List f١١٣٥٧e;

            /* renamed from: f, reason: collision with root package name */
            private x1 f١١٣٥٨f;

            private void p(d dVar) {
                int i10;
                int i11 = this.f١١٣٥٤b;
                if ((i11 & 1) != 0) {
                    dVar.f١١٣٥٠c = this.f١١٣٥٥c;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    dVar.f١١٣٥١d = this.f١١٣٥٦d;
                    i10 |= 2;
                }
                d.w(dVar, i10);
            }

            private void q(d dVar) {
                x1 x1Var = this.f١١٣٥٨f;
                if (x1Var != null) {
                    dVar.f١١٣٥٢e = x1Var.g();
                    return;
                }
                if ((this.f١١٣٥٤b & 4) != 0) {
                    this.f١١٣٥٧e = Collections.unmodifiableList(this.f١١٣٥٧e);
                    this.f١١٣٥٤b &= -5;
                }
                dVar.f١١٣٥٢e = this.f١١٣٥٧e;
            }

            private void s() {
                if ((this.f١١٣٥٤b & 4) == 0) {
                    this.f١١٣٥٧e = new ArrayList(this.f١١٣٥٧e);
                    this.f١١٣٥٤b |= 4;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٣٥٨f == null) {
                    List list = this.f١١٣٥٧e;
                    if ((this.f١١٣٥٤b & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٣٥٨f = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٣٥٧e = null;
                }
                return this.f١١٣٥٨f;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٣٥٥c = z10;
                this.f١١٣٥٤b |= 1;
                onChanged();
                return this;
            }

            public b C(boolean z10) {
                this.f١١٣٥٦d = z10;
                this.f١١٣٥٤b |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.I;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.J.d(d.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public d build() {
                d buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public d buildPartial() {
                d dVar = new d(this);
                q(dVar);
                if (this.f١١٣٥٤b != 0) {
                    p(dVar);
                }
                onBuilt();
                return dVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public d getDefaultInstanceForType() {
                return d.y();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٣٥٨f;
                if (x1Var == null) {
                    return (t) this.f١١٣٥٧e.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٣٥٨f;
                if (x1Var == null) {
                    return this.f١١٣٥٧e.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 16) {
                                    if (K != 24) {
                                        if (K != 7994) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                            x1 x1Var = this.f١١٣٥٨f;
                                            if (x1Var == null) {
                                                s();
                                                this.f١١٣٥٧e.add(tVar);
                                            } else {
                                                x1Var.f(tVar);
                                            }
                                        }
                                    } else {
                                        this.f١١٣٥٦d = iVar.q();
                                        this.f١١٣٥٤b |= 2;
                                    }
                                } else {
                                    this.f١١٣٥٥c = iVar.q();
                                    this.f١١٣٥٤b |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(d dVar) {
                if (dVar == d.y()) {
                    return this;
                }
                if (dVar.E()) {
                    B(dVar.x());
                }
                if (dVar.F()) {
                    C(dVar.A());
                }
                if (this.f١١٣٥٨f == null) {
                    if (!dVar.f١١٣٥٢e.isEmpty()) {
                        if (this.f١١٣٥٧e.isEmpty()) {
                            this.f١١٣٥٧e = dVar.f١١٣٥٢e;
                            this.f١١٣٥٤b &= -5;
                        } else {
                            s();
                            this.f١١٣٥٧e.addAll(dVar.f١١٣٥٢e);
                        }
                        onChanged();
                    }
                } else if (!dVar.f١١٣٥٢e.isEmpty()) {
                    if (this.f١١٣٥٨f.u()) {
                        this.f١١٣٥٨f.i();
                        x1 x1Var = null;
                        this.f١١٣٥٨f = null;
                        this.f١١٣٥٧e = dVar.f١١٣٥٢e;
                        this.f١١٣٥٤b &= -5;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٣٥٨f = x1Var;
                    } else {
                        this.f١١٣٥٨f.b(dVar.f١١٣٥٢e);
                    }
                }
                j(dVar);
                mergeUnknownFields(dVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof d) {
                    return y((d) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٣٥٧e = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٣٥٧e = Collections.emptyList();
            }
        }

        private d(h0.d dVar) {
            super(dVar);
            this.f١١٣٥٠c = false;
            this.f١١٣٥١d = false;
            this.f١١٣٥٣f = (byte) -1;
        }

        private d() {
            this.f١١٣٥٠c = false;
            this.f١١٣٥١d = false;
            this.f١١٣٥٣f = (byte) -1;
            this.f١١٣٥٢e = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e extends h0 implements g1 {

        /* renamed from: f, reason: collision with root package name */
        private static final e f١١٣٥٩f = new e();

        /* renamed from: g, reason: collision with root package name */
        public static final r1 f١١٣٦٠g = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٣٦١a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٣٦٢b;

        /* renamed from: c, reason: collision with root package name */
        private int f١١٣٦٣c;

        /* renamed from: d, reason: collision with root package name */
        private f f١١٣٦٤d;

        /* renamed from: e, reason: collision with root package name */
        private byte f١١٣٦٥e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public e parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b y10 = e.y();
                try {
                    y10.mergeFrom(iVar, vVar);
                    return y10.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(y10.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(y10.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(y10.buildPartial());
                }
            }
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٦٠u;
        }

        static /* synthetic */ int q(e eVar, int i10) {
            int i11 = i10 | eVar.f١١٣٦١a;
            eVar.f١١٣٦١a = i11;
            return i11;
        }

        public static e r() {
            return f١١٣٥٩f;
        }

        public static b y() {
            return f١١٣٥٩f.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٥٩f) {
                return new b();
            }
            return new b().p(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return super.equals(obj);
            }
            e eVar = (e) obj;
            if (v() != eVar.v()) {
                return false;
            }
            if ((v() && !getName().equals(eVar.getName())) || w() != eVar.w()) {
                return false;
            }
            if ((w() && t() != eVar.t()) || x() != eVar.x()) {
                return false;
            }
            if ((!x() || u().equals(eVar.u())) && getUnknownFields().equals(eVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٣٦٢b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٦٢b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٣٦١a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٣٦٢b);
            } else {
                i10 = 0;
            }
            if ((this.f١١٣٦١a & 2) != 0) {
                i10 += com.google.protobuf.k.x(2, this.f١١٣٦٣c);
            }
            if ((this.f١١٣٦١a & 4) != 0) {
                i10 += com.google.protobuf.k.G(3, u());
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (v()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (w()) {
                hashCode = (((hashCode * 37) + 2) * 53) + t();
            }
            if (x()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٦١v.d(e.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٣٦٥e;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (x() && !u().isInitialized()) {
                this.f١١٣٦٥e = (byte) 0;
                return false;
            }
            this.f١١٣٦٥e = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new e();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public e getDefaultInstanceForType() {
            return f١١٣٥٩f;
        }

        public int t() {
            return this.f١١٣٦٣c;
        }

        public f u() {
            f fVar = this.f١١٣٦٤d;
            if (fVar == null) {
                return f.w();
            }
            return fVar;
        }

        public boolean v() {
            if ((this.f١١٣٦١a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean w() {
            if ((this.f١١٣٦١a & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٣٦١a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٣٦٢b);
            }
            if ((this.f١١٣٦١a & 2) != 0) {
                kVar.D0(2, this.f١١٣٦٣c);
            }
            if ((this.f١١٣٦١a & 4) != 0) {
                kVar.H0(3, u());
            }
            getUnknownFields().writeTo(kVar);
        }

        public boolean x() {
            if ((this.f١١٣٦١a & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return y();
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٣٦٦a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٣٦٧b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٣٦٨c;

            /* renamed from: d, reason: collision with root package name */
            private f f١١٣٦٩d;

            /* renamed from: e, reason: collision with root package name */
            private b2 f١١٣٧٠e;

            private void h(e eVar) {
                int i10;
                f fVar;
                int i11 = this.f١١٣٦٦a;
                if ((i11 & 1) != 0) {
                    eVar.f١١٣٦٢b = this.f١١٣٦٧b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    eVar.f١١٣٦٣c = this.f١١٣٦٨c;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    b2 b2Var = this.f١١٣٧٠e;
                    if (b2Var == null) {
                        fVar = this.f١١٣٦٩d;
                    } else {
                        fVar = (f) b2Var.b();
                    }
                    eVar.f١١٣٦٤d = fVar;
                    i10 |= 4;
                }
                e.q(eVar, i10);
            }

            private b2 m() {
                if (this.f١١٣٧٠e == null) {
                    this.f١١٣٧٠e = new b2(k(), getParentForChildren(), isClean());
                    this.f١١٣٦٩d = null;
                }
                return this.f١١٣٧٠e;
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public e build() {
                e buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public e buildPartial() {
                e eVar = new e(this);
                if (this.f١١٣٦٦a != 0) {
                    h(eVar);
                }
                onBuilt();
                return eVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٦٠u;
            }

            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٦١v.d(e.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                if (n() && !k().isInitialized()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.f1
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public e getDefaultInstanceForType() {
                return e.r();
            }

            public f k() {
                b2 b2Var = this.f١١٣٧٠e;
                if (b2Var == null) {
                    f fVar = this.f١١٣٦٩d;
                    if (fVar == null) {
                        return f.w();
                    }
                    return fVar;
                }
                return (f) b2Var.e();
            }

            public f.b l() {
                this.f١١٣٦٦a |= 4;
                onChanged();
                return (f.b) m().d();
            }

            public boolean n() {
                if ((this.f١١٣٦٦a & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K != 16) {
                                        if (K != 26) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            iVar.B(m().d(), vVar);
                                            this.f١١٣٦٦a |= 4;
                                        }
                                    } else {
                                        this.f١١٣٦٨c = iVar.y();
                                        this.f١١٣٦٦a |= 2;
                                    }
                                } else {
                                    this.f١١٣٦٧b = iVar.r();
                                    this.f١١٣٦٦a |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b p(e eVar) {
                if (eVar == e.r()) {
                    return this;
                }
                if (eVar.v()) {
                    this.f١١٣٦٧b = eVar.f١١٣٦٢b;
                    this.f١١٣٦٦a |= 1;
                    onChanged();
                }
                if (eVar.w()) {
                    v(eVar.t());
                }
                if (eVar.x()) {
                    r(eVar.u());
                }
                mergeUnknownFields(eVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof e) {
                    return p((e) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b r(f fVar) {
                f fVar2;
                b2 b2Var = this.f١١٣٧٠e;
                if (b2Var == null) {
                    if ((this.f١١٣٦٦a & 4) != 0 && (fVar2 = this.f١١٣٦٩d) != null && fVar2 != f.w()) {
                        l().y(fVar);
                    } else {
                        this.f١١٣٦٩d = fVar;
                    }
                } else {
                    b2Var.g(fVar);
                }
                this.f١١٣٦٦a |= 4;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            public b u(String str) {
                str.getClass();
                this.f١١٣٦٧b = str;
                this.f١١٣٦٦a |= 1;
                onChanged();
                return this;
            }

            public b v(int i10) {
                this.f١١٣٦٨c = i10;
                this.f١١٣٦٦a |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٣٦٧b = "";
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٣٦٧b = "";
                maybeForceBuilderInitialization();
            }
        }

        private e(h0.b bVar) {
            super(bVar);
            this.f١١٣٦٢b = "";
            this.f١١٣٦٣c = 0;
            this.f١١٣٦٥e = (byte) -1;
        }

        private e() {
            this.f١١٣٦٢b = "";
            this.f١١٣٦٣c = 0;
            this.f١١٣٦٥e = (byte) -1;
            this.f١١٣٦٢b = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class f extends h0.e implements g1 {

        /* renamed from: f, reason: collision with root package name */
        private static final f f١١٣٧١f = new f();

        /* renamed from: g, reason: collision with root package name */
        public static final r1 f١١٣٧٢g = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٣٧٣b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١١٣٧٤c;

        /* renamed from: d, reason: collision with root package name */
        private List f١١٣٧٥d;

        /* renamed from: e, reason: collision with root package name */
        private byte f١١٣٧٦e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public f parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b D = f.D();
                try {
                    D.mergeFrom(iVar, vVar);
                    return D.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(D.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(D.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(D.buildPartial());
                }
            }
        }

        public static b D() {
            return f١١٣٧١f.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.K;
        }

        static /* synthetic */ int v(f fVar, int i10) {
            int i11 = i10 | fVar.f١١٣٧٣b;
            fVar.f١١٣٧٣b = i11;
            return i11;
        }

        public static f w() {
            return f١١٣٧١f;
        }

        public int A() {
            return this.f١١٣٧٥d.size();
        }

        public List B() {
            return this.f١١٣٧٥d;
        }

        public boolean C() {
            if ((this.f١١٣٧٣b & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return D();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٧١f) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return super.equals(obj);
            }
            f fVar = (f) obj;
            if (C() != fVar.C()) {
                return false;
            }
            if ((!C() || y() == fVar.y()) && B().equals(fVar.B()) && getUnknownFields().equals(fVar.getUnknownFields()) && p().equals(fVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٣٧٣b & 1) != 0) {
                i10 = com.google.protobuf.k.e(1, this.f١١٣٧٤c);
            } else {
                i10 = 0;
            }
            for (int i12 = 0; i12 < this.f١١٣٧٥d.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٣٧٥d.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (C()) {
                hashCode = (((hashCode * 37) + 1) * 53) + j0.c(y());
            }
            if (A() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + B().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.L.d(f.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٣٧٦e;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < A(); i10++) {
                if (!z(i10).isInitialized()) {
                    this.f١١٣٧٦e = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٣٧٦e = (byte) 0;
                return false;
            }
            this.f١١٣٧٦e = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new f();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٣٧٣b & 1) != 0) {
                kVar.l0(1, this.f١١٣٧٤c);
            }
            for (int i10 = 0; i10 < this.f١١٣٧٥d.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٣٧٥d.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public f getDefaultInstanceForType() {
            return f١١٣٧١f;
        }

        public boolean y() {
            return this.f١١٣٧٤c;
        }

        public t z(int i10) {
            return (t) this.f١١٣٧٥d.get(i10);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣٧٧b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٣٧٨c;

            /* renamed from: d, reason: collision with root package name */
            private List f١١٣٧٩d;

            /* renamed from: e, reason: collision with root package name */
            private x1 f١١٣٨٠e;

            private void p(f fVar) {
                int i10 = 1;
                if ((this.f١١٣٧٧b & 1) != 0) {
                    fVar.f١١٣٧٤c = this.f١١٣٧٨c;
                } else {
                    i10 = 0;
                }
                f.v(fVar, i10);
            }

            private void q(f fVar) {
                x1 x1Var = this.f١١٣٨٠e;
                if (x1Var != null) {
                    fVar.f١١٣٧٥d = x1Var.g();
                    return;
                }
                if ((this.f١١٣٧٧b & 2) != 0) {
                    this.f١١٣٧٩d = Collections.unmodifiableList(this.f١١٣٧٩d);
                    this.f١١٣٧٧b &= -3;
                }
                fVar.f١١٣٧٥d = this.f١١٣٧٩d;
            }

            private void s() {
                if ((this.f١١٣٧٧b & 2) == 0) {
                    this.f١١٣٧٩d = new ArrayList(this.f١١٣٧٩d);
                    this.f١١٣٧٧b |= 2;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٣٨٠e == null) {
                    List list = this.f١١٣٧٩d;
                    if ((this.f١١٣٧٧b & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٣٨٠e = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٣٧٩d = null;
                }
                return this.f١١٣٨٠e;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٣٧٨c = z10;
                this.f١١٣٧٧b |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.K;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.L.d(f.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public f build() {
                f buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public f buildPartial() {
                f fVar = new f(this);
                q(fVar);
                if (this.f١١٣٧٧b != 0) {
                    p(fVar);
                }
                onBuilt();
                return fVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public f getDefaultInstanceForType() {
                return f.w();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٣٨٠e;
                if (x1Var == null) {
                    return (t) this.f١١٣٧٩d.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٣٨٠e;
                if (x1Var == null) {
                    return this.f١١٣٧٩d.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 8) {
                                    if (K != 7994) {
                                        if (!super.parseUnknownField(iVar, vVar, K)) {
                                        }
                                    } else {
                                        t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                        x1 x1Var = this.f١١٣٨٠e;
                                        if (x1Var == null) {
                                            s();
                                            this.f١١٣٧٩d.add(tVar);
                                        } else {
                                            x1Var.f(tVar);
                                        }
                                    }
                                } else {
                                    this.f١١٣٧٨c = iVar.q();
                                    this.f١١٣٧٧b |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(f fVar) {
                if (fVar == f.w()) {
                    return this;
                }
                if (fVar.C()) {
                    B(fVar.y());
                }
                if (this.f١١٣٨٠e == null) {
                    if (!fVar.f١١٣٧٥d.isEmpty()) {
                        if (this.f١١٣٧٩d.isEmpty()) {
                            this.f١١٣٧٩d = fVar.f١١٣٧٥d;
                            this.f١١٣٧٧b &= -3;
                        } else {
                            s();
                            this.f١١٣٧٩d.addAll(fVar.f١١٣٧٥d);
                        }
                        onChanged();
                    }
                } else if (!fVar.f١١٣٧٥d.isEmpty()) {
                    if (this.f١١٣٨٠e.u()) {
                        this.f١١٣٨٠e.i();
                        x1 x1Var = null;
                        this.f١١٣٨٠e = null;
                        this.f١١٣٧٩d = fVar.f١١٣٧٥d;
                        this.f١١٣٧٧b &= -3;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٣٨٠e = x1Var;
                    } else {
                        this.f١١٣٨٠e.b(fVar.f١١٣٧٥d);
                    }
                }
                j(fVar);
                mergeUnknownFields(fVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof f) {
                    return y((f) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٣٧٩d = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٣٧٩d = Collections.emptyList();
            }
        }

        private f(h0.d dVar) {
            super(dVar);
            this.f١١٣٧٤c = false;
            this.f١١٣٧٦e = (byte) -1;
        }

        private f() {
            this.f١١٣٧٤c = false;
            this.f١١٣٧٦e = (byte) -1;
            this.f١١٣٧٥d = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class g extends h0.e implements g1 {

        /* renamed from: d, reason: collision with root package name */
        private static final g f١١٣٨١d = new g();

        /* renamed from: e, reason: collision with root package name */
        public static final r1 f١١٣٨٢e = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private List f١١٣٨٣b;

        /* renamed from: c, reason: collision with root package name */
        private byte f١١٣٨٤c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public g parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b z10 = g.z();
                try {
                    z10.mergeFrom(iVar, vVar);
                    return z10.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(z10.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(z10.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(z10.buildPartial());
                }
            }
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٥٠k;
        }

        public static g u() {
            return f١١٣٨١d;
        }

        public static b z() {
            return f١١٣٨١d.toBuilder();
        }

        @Override // com.google.protobuf.e1
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return z();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٨١d) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return super.equals(obj);
            }
            g gVar = (g) obj;
            if (y().equals(gVar.y()) && getUnknownFields().equals(gVar.getUnknownFields()) && p().equals(gVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f١١٣٨٣b.size(); i12++) {
                i11 += com.google.protobuf.k.G(999, (e1) this.f١١٣٨٣b.get(i12));
            }
            int o10 = i11 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (x() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + y().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٥١l.d(g.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٣٨٤c;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < x(); i10++) {
                if (!w(i10).isInitialized()) {
                    this.f١١٣٨٤c = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٣٨٤c = (byte) 0;
                return false;
            }
            this.f١١٣٨٤c = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new g();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public g getDefaultInstanceForType() {
            return f١١٣٨١d;
        }

        public t w(int i10) {
            return (t) this.f١١٣٨٣b.get(i10);
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            for (int i10 = 0; i10 < this.f١١٣٨٣b.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٣٨٣b.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        public int x() {
            return this.f١١٣٨٣b.size();
        }

        public List y() {
            return this.f١١٣٨٣b;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٣٨٥b;

            /* renamed from: c, reason: collision with root package name */
            private List f١١٣٨٦c;

            /* renamed from: d, reason: collision with root package name */
            private x1 f١١٣٨٧d;

            private void p(g gVar) {
            }

            private void q(g gVar) {
                x1 x1Var = this.f١١٣٨٧d;
                if (x1Var != null) {
                    gVar.f١١٣٨٣b = x1Var.g();
                    return;
                }
                if ((this.f١١٣٨٥b & 1) != 0) {
                    this.f١١٣٨٦c = Collections.unmodifiableList(this.f١١٣٨٦c);
                    this.f١١٣٨٥b &= -2;
                }
                gVar.f١١٣٨٣b = this.f١١٣٨٦c;
            }

            private void s() {
                if ((this.f١١٣٨٥b & 1) == 0) {
                    this.f١١٣٨٦c = new ArrayList(this.f١١٣٨٦c);
                    this.f١١٣٨٥b |= 1;
                }
            }

            private x1 w() {
                if (this.f١١٣٨٧d == null) {
                    List list = this.f١١٣٨٦c;
                    boolean z10 = true;
                    if ((this.f١١٣٨٥b & 1) == 0) {
                        z10 = false;
                    }
                    this.f١١٣٨٧d = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٣٨٦c = null;
                }
                return this.f١١٣٨٧d;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٥٠k;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٥١l.d(g.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public g build() {
                g buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public g buildPartial() {
                g gVar = new g(this);
                q(gVar);
                if (this.f١١٣٨٥b != 0) {
                    p(gVar);
                }
                onBuilt();
                return gVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public g getDefaultInstanceForType() {
                return g.u();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٣٨٧d;
                if (x1Var == null) {
                    return (t) this.f١١٣٨٦c.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٣٨٧d;
                if (x1Var == null) {
                    return this.f١١٣٨٦c.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 7994) {
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                    x1 x1Var = this.f١١٣٨٧d;
                                    if (x1Var == null) {
                                        s();
                                        this.f١١٣٨٦c.add(tVar);
                                    } else {
                                        x1Var.f(tVar);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(g gVar) {
                if (gVar == g.u()) {
                    return this;
                }
                if (this.f١١٣٨٧d == null) {
                    if (!gVar.f١١٣٨٣b.isEmpty()) {
                        if (this.f١١٣٨٦c.isEmpty()) {
                            this.f١١٣٨٦c = gVar.f١١٣٨٣b;
                            this.f١١٣٨٥b &= -2;
                        } else {
                            s();
                            this.f١١٣٨٦c.addAll(gVar.f١١٣٨٣b);
                        }
                        onChanged();
                    }
                } else if (!gVar.f١١٣٨٣b.isEmpty()) {
                    if (this.f١١٣٨٧d.u()) {
                        this.f١١٣٨٧d.i();
                        x1 x1Var = null;
                        this.f١١٣٨٧d = null;
                        this.f١١٣٨٦c = gVar.f١١٣٨٣b;
                        this.f١١٣٨٥b &= -2;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٣٨٧d = x1Var;
                    } else {
                        this.f١١٣٨٧d.b(gVar.f١١٣٨٣b);
                    }
                }
                j(gVar);
                mergeUnknownFields(gVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof g) {
                    return y((g) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٣٨٦c = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٣٨٦c = Collections.emptyList();
            }
        }

        private g(h0.d dVar) {
            super(dVar);
            this.f١١٣٨٤c = (byte) -1;
        }

        private g() {
            this.f١١٣٨٤c = (byte) -1;
            this.f١١٣٨٣b = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class h extends h0 implements g1 {

        /* renamed from: n, reason: collision with root package name */
        private static final h f١١٣٨٨n = new h();

        /* renamed from: o, reason: collision with root package name */
        public static final r1 f١١٣٨٩o = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٣٩٠a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٣٩١b;

        /* renamed from: c, reason: collision with root package name */
        private int f١١٣٩٢c;

        /* renamed from: d, reason: collision with root package name */
        private int f١١٣٩٣d;

        /* renamed from: e, reason: collision with root package name */
        private int f١١٣٩٤e;

        /* renamed from: f, reason: collision with root package name */
        private volatile Object f١١٣٩٥f;

        /* renamed from: g, reason: collision with root package name */
        private volatile Object f١١٣٩٦g;

        /* renamed from: h, reason: collision with root package name */
        private volatile Object f١١٣٩٧h;

        /* renamed from: i, reason: collision with root package name */
        private int f١١٣٩٨i;

        /* renamed from: j, reason: collision with root package name */
        private volatile Object f١١٣٩٩j;

        /* renamed from: k, reason: collision with root package name */
        private i f١١٤٠٠k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f١١٤٠١l;

        /* renamed from: m, reason: collision with root package name */
        private byte f١١٤٠٢m;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b a02 = h.a0();
                try {
                    a02.mergeFrom(iVar, vVar);
                    return a02.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(a02.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(a02.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(a02.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum c implements j0.c {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);


            /* renamed from: e, reason: collision with root package name */
            private static final j0.d f١١٤١٩e = new a();

            /* renamed from: f, reason: collision with root package name */
            private static final c[] f١١٤٢٠f = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٤٢٢a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            c(int i10) {
                this.f١١٤٢٢a = i10;
            }

            public static c c(int i10) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return LABEL_REPEATED;
                    }
                    return LABEL_REQUIRED;
                }
                return LABEL_OPTIONAL;
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٤٢٢a;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum d implements j0.c {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);


            /* renamed from: t, reason: collision with root package name */
            private static final j0.d f١١٤٤١t = new a();

            /* renamed from: u, reason: collision with root package name */
            private static final d[] f١١٤٤٢u = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٤٤٤a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            d(int i10) {
                this.f١١٤٤٤a = i10;
            }

            public static d c(int i10) {
                switch (i10) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٤٤٤a;
            }
        }

        static /* synthetic */ int C(h hVar, int i10) {
            int i11 = i10 | hVar.f١١٣٩٠a;
            hVar.f١١٣٩٠a = i11;
            return i11;
        }

        public static h D() {
            return f١١٣٨٨n;
        }

        public static b a0() {
            return f١١٣٨٨n.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٥٢m;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public h getDefaultInstanceForType() {
            return f١١٣٨٨n;
        }

        public String F() {
            Object obj = this.f١١٣٩٧h;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٩٧h = C;
            }
            return C;
        }

        public String G() {
            Object obj = this.f١١٣٩٦g;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٩٦g = C;
            }
            return C;
        }

        public String H() {
            Object obj = this.f١١٣٩٩j;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٩٩j = C;
            }
            return C;
        }

        public c I() {
            c c10 = c.c(this.f١١٣٩٣d);
            if (c10 == null) {
                return c.LABEL_OPTIONAL;
            }
            return c10;
        }

        public int J() {
            return this.f١١٣٩٢c;
        }

        public int K() {
            return this.f١١٣٩٨i;
        }

        public i L() {
            i iVar = this.f١١٤٠٠k;
            if (iVar == null) {
                return i.D();
            }
            return iVar;
        }

        public boolean M() {
            return this.f١١٤٠١l;
        }

        public d N() {
            d c10 = d.c(this.f١١٣٩٤e);
            if (c10 == null) {
                return d.TYPE_DOUBLE;
            }
            return c10;
        }

        public String O() {
            Object obj = this.f١١٣٩٥f;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٩٥f = C;
            }
            return C;
        }

        public boolean P() {
            if ((this.f١١٣٩٠a & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean Q() {
            if ((this.f١١٣٩٠a & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean R() {
            if ((this.f١١٣٩٠a & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean S() {
            if ((this.f١١٣٩٠a & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean T() {
            if ((this.f١١٣٩٠a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean U() {
            if ((this.f١١٣٩٠a & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean V() {
            if ((this.f١١٣٩٠a & 128) != 0) {
                return true;
            }
            return false;
        }

        public boolean W() {
            if ((this.f١١٣٩٠a & 512) != 0) {
                return true;
            }
            return false;
        }

        public boolean X() {
            if ((this.f١١٣٩٠a & 1024) != 0) {
                return true;
            }
            return false;
        }

        public boolean Y() {
            if ((this.f١١٣٩٠a & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean Z() {
            if ((this.f١١٣٩٠a & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: b0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return a0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: c0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٣٨٨n) {
                return new b();
            }
            return new b().p(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof h)) {
                return super.equals(obj);
            }
            h hVar = (h) obj;
            if (T() != hVar.T()) {
                return false;
            }
            if ((T() && !getName().equals(hVar.getName())) || U() != hVar.U()) {
                return false;
            }
            if ((U() && J() != hVar.J()) || S() != hVar.S()) {
                return false;
            }
            if ((S() && this.f١١٣٩٣d != hVar.f١١٣٩٣d) || Y() != hVar.Y()) {
                return false;
            }
            if ((Y() && this.f١١٣٩٤e != hVar.f١١٣٩٤e) || Z() != hVar.Z()) {
                return false;
            }
            if ((Z() && !O().equals(hVar.O())) || Q() != hVar.Q()) {
                return false;
            }
            if ((Q() && !G().equals(hVar.G())) || P() != hVar.P()) {
                return false;
            }
            if ((P() && !F().equals(hVar.F())) || V() != hVar.V()) {
                return false;
            }
            if ((V() && K() != hVar.K()) || R() != hVar.R()) {
                return false;
            }
            if ((R() && !H().equals(hVar.H())) || W() != hVar.W()) {
                return false;
            }
            if ((W() && !L().equals(hVar.L())) || X() != hVar.X()) {
                return false;
            }
            if ((!X() || M() == hVar.M()) && getUnknownFields().equals(hVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٣٩١b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٣٩١b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٣٩٠a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٣٩١b);
            } else {
                i10 = 0;
            }
            if ((this.f١١٣٩٠a & 32) != 0) {
                i10 += h0.computeStringSize(2, this.f١١٣٩٦g);
            }
            if ((this.f١١٣٩٠a & 2) != 0) {
                i10 += com.google.protobuf.k.x(3, this.f١١٣٩٢c);
            }
            if ((this.f١١٣٩٠a & 4) != 0) {
                i10 += com.google.protobuf.k.l(4, this.f١١٣٩٣d);
            }
            if ((this.f١١٣٩٠a & 8) != 0) {
                i10 += com.google.protobuf.k.l(5, this.f١١٣٩٤e);
            }
            if ((this.f١١٣٩٠a & 16) != 0) {
                i10 += h0.computeStringSize(6, this.f١١٣٩٥f);
            }
            if ((this.f١١٣٩٠a & 64) != 0) {
                i10 += h0.computeStringSize(7, this.f١١٣٩٧h);
            }
            if ((this.f١١٣٩٠a & 512) != 0) {
                i10 += com.google.protobuf.k.G(8, L());
            }
            if ((this.f١١٣٩٠a & 128) != 0) {
                i10 += com.google.protobuf.k.x(9, this.f١١٣٩٨i);
            }
            if ((this.f١١٣٩٠a & 256) != 0) {
                i10 += h0.computeStringSize(10, this.f١١٣٩٩j);
            }
            if ((this.f١١٣٩٠a & 1024) != 0) {
                i10 += com.google.protobuf.k.e(17, this.f١١٤٠١l);
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (T()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (U()) {
                hashCode = (((hashCode * 37) + 3) * 53) + J();
            }
            if (S()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.f١١٣٩٣d;
            }
            if (Y()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.f١١٣٩٤e;
            }
            if (Z()) {
                hashCode = (((hashCode * 37) + 6) * 53) + O().hashCode();
            }
            if (Q()) {
                hashCode = (((hashCode * 37) + 2) * 53) + G().hashCode();
            }
            if (P()) {
                hashCode = (((hashCode * 37) + 7) * 53) + F().hashCode();
            }
            if (V()) {
                hashCode = (((hashCode * 37) + 9) * 53) + K();
            }
            if (R()) {
                hashCode = (((hashCode * 37) + 10) * 53) + H().hashCode();
            }
            if (W()) {
                hashCode = (((hashCode * 37) + 8) * 53) + L().hashCode();
            }
            if (X()) {
                hashCode = (((hashCode * 37) + 17) * 53) + j0.c(M());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٥٣n.d(h.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٤٠٢m;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (W() && !L().isInitialized()) {
                this.f١١٤٠٢m = (byte) 0;
                return false;
            }
            this.f١١٤٠٢m = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new h();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٣٩٠a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٣٩١b);
            }
            if ((this.f١١٣٩٠a & 32) != 0) {
                h0.writeString(kVar, 2, this.f١١٣٩٦g);
            }
            if ((this.f١١٣٩٠a & 2) != 0) {
                kVar.D0(3, this.f١١٣٩٢c);
            }
            if ((this.f١١٣٩٠a & 4) != 0) {
                kVar.t0(4, this.f١١٣٩٣d);
            }
            if ((this.f١١٣٩٠a & 8) != 0) {
                kVar.t0(5, this.f١١٣٩٤e);
            }
            if ((this.f١١٣٩٠a & 16) != 0) {
                h0.writeString(kVar, 6, this.f١١٣٩٥f);
            }
            if ((this.f١١٣٩٠a & 64) != 0) {
                h0.writeString(kVar, 7, this.f١١٣٩٧h);
            }
            if ((this.f١١٣٩٠a & 512) != 0) {
                kVar.H0(8, L());
            }
            if ((this.f١١٣٩٠a & 128) != 0) {
                kVar.D0(9, this.f١١٣٩٨i);
            }
            if ((this.f١١٣٩٠a & 256) != 0) {
                h0.writeString(kVar, 10, this.f١١٣٩٩j);
            }
            if ((this.f١١٣٩٠a & 1024) != 0) {
                kVar.l0(17, this.f١١٤٠١l);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٤٠٣a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٤٠٤b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٤٠٥c;

            /* renamed from: d, reason: collision with root package name */
            private int f١١٤٠٦d;

            /* renamed from: e, reason: collision with root package name */
            private int f١١٤٠٧e;

            /* renamed from: f, reason: collision with root package name */
            private Object f١١٤٠٨f;

            /* renamed from: g, reason: collision with root package name */
            private Object f١١٤٠٩g;

            /* renamed from: h, reason: collision with root package name */
            private Object f١١٤١٠h;

            /* renamed from: i, reason: collision with root package name */
            private int f١١٤١١i;

            /* renamed from: j, reason: collision with root package name */
            private Object f١١٤١٢j;

            /* renamed from: k, reason: collision with root package name */
            private i f١١٤١٣k;

            /* renamed from: l, reason: collision with root package name */
            private b2 f١١٤١٤l;

            /* renamed from: m, reason: collision with root package name */
            private boolean f١١٤١٥m;

            private void h(h hVar) {
                int i10;
                i iVar;
                int i11 = this.f١١٤٠٣a;
                if ((i11 & 1) != 0) {
                    hVar.f١١٣٩١b = this.f١١٤٠٤b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    hVar.f١١٣٩٢c = this.f١١٤٠٥c;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    hVar.f١١٣٩٣d = this.f١١٤٠٦d;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    hVar.f١١٣٩٤e = this.f١١٤٠٧e;
                    i10 |= 8;
                }
                if ((i11 & 16) != 0) {
                    hVar.f١١٣٩٥f = this.f١١٤٠٨f;
                    i10 |= 16;
                }
                if ((i11 & 32) != 0) {
                    hVar.f١١٣٩٦g = this.f١١٤٠٩g;
                    i10 |= 32;
                }
                if ((i11 & 64) != 0) {
                    hVar.f١١٣٩٧h = this.f١١٤١٠h;
                    i10 |= 64;
                }
                if ((i11 & 128) != 0) {
                    hVar.f١١٣٩٨i = this.f١١٤١١i;
                    i10 |= 128;
                }
                if ((i11 & 256) != 0) {
                    hVar.f١١٣٩٩j = this.f١١٤١٢j;
                    i10 |= 256;
                }
                if ((i11 & 512) != 0) {
                    b2 b2Var = this.f١١٤١٤l;
                    if (b2Var == null) {
                        iVar = this.f١١٤١٣k;
                    } else {
                        iVar = (i) b2Var.b();
                    }
                    hVar.f١١٤٠٠k = iVar;
                    i10 |= 512;
                }
                if ((i11 & 1024) != 0) {
                    hVar.f١١٤٠١l = this.f١١٤١٥m;
                    i10 |= 1024;
                }
                h.C(hVar, i10);
            }

            private b2 m() {
                if (this.f١١٤١٤l == null) {
                    this.f١١٤١٤l = new b2(k(), getParentForChildren(), isClean());
                    this.f١١٤١٣k = null;
                }
                return this.f١١٤١٤l;
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public h build() {
                h buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public h buildPartial() {
                h hVar = new h(this);
                if (this.f١١٤٠٣a != 0) {
                    h(hVar);
                }
                onBuilt();
                return hVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٥٢m;
            }

            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٥٣n.d(h.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                if (n() && !k().isInitialized()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.f1
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public h getDefaultInstanceForType() {
                return h.D();
            }

            public i k() {
                b2 b2Var = this.f١١٤١٤l;
                if (b2Var == null) {
                    i iVar = this.f١١٤١٣k;
                    if (iVar == null) {
                        return i.D();
                    }
                    return iVar;
                }
                return (i) b2Var.e();
            }

            public i.b l() {
                this.f١١٤٠٣a |= 512;
                onChanged();
                return (i.b) m().d();
            }

            public boolean n() {
                if ((this.f١١٤٠٣a & 512) != 0) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.f١١٤٠٤b = iVar.r();
                                    this.f١١٤٠٣a |= 1;
                                case 18:
                                    this.f١١٤٠٩g = iVar.r();
                                    this.f١١٤٠٣a |= 32;
                                case 24:
                                    this.f١١٤٠٥c = iVar.y();
                                    this.f١١٤٠٣a |= 2;
                                case 32:
                                    int t10 = iVar.t();
                                    if (c.c(t10) == null) {
                                        mergeUnknownVarintField(4, t10);
                                    } else {
                                        this.f١١٤٠٦d = t10;
                                        this.f١١٤٠٣a |= 4;
                                    }
                                case 40:
                                    int t11 = iVar.t();
                                    if (d.c(t11) == null) {
                                        mergeUnknownVarintField(5, t11);
                                    } else {
                                        this.f١١٤٠٧e = t11;
                                        this.f١١٤٠٣a |= 8;
                                    }
                                case 50:
                                    this.f١١٤٠٨f = iVar.r();
                                    this.f١١٤٠٣a |= 16;
                                case 58:
                                    this.f١١٤١٠h = iVar.r();
                                    this.f١١٤٠٣a |= 64;
                                case 66:
                                    iVar.B(m().d(), vVar);
                                    this.f١١٤٠٣a |= 512;
                                case 72:
                                    this.f١١٤١١i = iVar.y();
                                    this.f١١٤٠٣a |= 128;
                                case 82:
                                    this.f١١٤١٢j = iVar.r();
                                    this.f١١٤٠٣a |= 256;
                                case 136:
                                    this.f١١٤١٥m = iVar.q();
                                    this.f١١٤٠٣a |= 1024;
                                default:
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                        z10 = true;
                                    }
                            }
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b p(h hVar) {
                if (hVar == h.D()) {
                    return this;
                }
                if (hVar.T()) {
                    this.f١١٤٠٤b = hVar.f١١٣٩١b;
                    this.f١١٤٠٣a |= 1;
                    onChanged();
                }
                if (hVar.U()) {
                    v(hVar.J());
                }
                if (hVar.S()) {
                    u(hVar.I());
                }
                if (hVar.Y()) {
                    y(hVar.N());
                }
                if (hVar.Z()) {
                    this.f١١٤٠٨f = hVar.f١١٣٩٥f;
                    this.f١١٤٠٣a |= 16;
                    onChanged();
                }
                if (hVar.Q()) {
                    this.f١١٤٠٩g = hVar.f١١٣٩٦g;
                    this.f١١٤٠٣a |= 32;
                    onChanged();
                }
                if (hVar.P()) {
                    this.f١١٤١٠h = hVar.f١١٣٩٧h;
                    this.f١١٤٠٣a |= 64;
                    onChanged();
                }
                if (hVar.V()) {
                    w(hVar.K());
                }
                if (hVar.R()) {
                    this.f١١٤١٢j = hVar.f١١٣٩٩j;
                    this.f١١٤٠٣a |= 256;
                    onChanged();
                }
                if (hVar.W()) {
                    r(hVar.L());
                }
                if (hVar.X()) {
                    x(hVar.M());
                }
                mergeUnknownFields(hVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof h) {
                    return p((h) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b r(i iVar) {
                i iVar2;
                b2 b2Var = this.f١١٤١٤l;
                if (b2Var == null) {
                    if ((this.f١١٤٠٣a & 512) != 0 && (iVar2 = this.f١١٤١٣k) != null && iVar2 != i.D()) {
                        l().y(iVar);
                    } else {
                        this.f١١٤١٣k = iVar;
                    }
                } else {
                    b2Var.g(iVar);
                }
                this.f١١٤٠٣a |= 512;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            public b u(c cVar) {
                cVar.getClass();
                this.f١١٤٠٣a |= 4;
                this.f١١٤٠٦d = cVar.getNumber();
                onChanged();
                return this;
            }

            public b v(int i10) {
                this.f١١٤٠٥c = i10;
                this.f١١٤٠٣a |= 2;
                onChanged();
                return this;
            }

            public b w(int i10) {
                this.f١١٤١١i = i10;
                this.f١١٤٠٣a |= 128;
                onChanged();
                return this;
            }

            public b x(boolean z10) {
                this.f١١٤١٥m = z10;
                this.f١١٤٠٣a |= 1024;
                onChanged();
                return this;
            }

            public b y(d dVar) {
                dVar.getClass();
                this.f١١٤٠٣a |= 8;
                this.f١١٤٠٧e = dVar.getNumber();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٤٠٤b = "";
                this.f١١٤٠٦d = 1;
                this.f١١٤٠٧e = 1;
                this.f١١٤٠٨f = "";
                this.f١١٤٠٩g = "";
                this.f١١٤١٠h = "";
                this.f١١٤١٢j = "";
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٤٠٤b = "";
                this.f١١٤٠٦d = 1;
                this.f١١٤٠٧e = 1;
                this.f١١٤٠٨f = "";
                this.f١١٤٠٩g = "";
                this.f١١٤١٠h = "";
                this.f١١٤١٢j = "";
                maybeForceBuilderInitialization();
            }
        }

        private h(h0.b bVar) {
            super(bVar);
            this.f١١٣٩١b = "";
            this.f١١٣٩٢c = 0;
            this.f١١٣٩٣d = 1;
            this.f١١٣٩٤e = 1;
            this.f١١٣٩٥f = "";
            this.f١١٣٩٦g = "";
            this.f١١٣٩٧h = "";
            this.f١١٣٩٨i = 0;
            this.f١١٣٩٩j = "";
            this.f١١٤٠١l = false;
            this.f١١٤٠٢m = (byte) -1;
        }

        private h() {
            this.f١١٣٩١b = "";
            this.f١١٣٩٢c = 0;
            this.f١١٣٩٣d = 1;
            this.f١١٣٩٤e = 1;
            this.f١١٣٩٥f = "";
            this.f١١٣٩٦g = "";
            this.f١١٣٩٧h = "";
            this.f١١٣٩٨i = 0;
            this.f١١٣٩٩j = "";
            this.f١١٤٠١l = false;
            this.f١١٤٠٢m = (byte) -1;
            this.f١١٣٩١b = "";
            this.f١١٣٩٣d = 1;
            this.f١١٣٩٤e = 1;
            this.f١١٣٩٥f = "";
            this.f١١٣٩٦g = "";
            this.f١١٣٩٧h = "";
            this.f١١٣٩٩j = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class i extends h0.e implements g1 {

        /* renamed from: l, reason: collision with root package name */
        private static final i f١١٤٤٥l = new i();

        /* renamed from: m, reason: collision with root package name */
        public static final r1 f١١٤٤٦m = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٤٤٧b;

        /* renamed from: c, reason: collision with root package name */
        private int f١١٤٤٨c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١١٤٤٩d;

        /* renamed from: e, reason: collision with root package name */
        private int f١١٤٥٠e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f١١٤٥١f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١١٤٥٢g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f١١٤٥٣h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f١١٤٥٤i;

        /* renamed from: j, reason: collision with root package name */
        private List f١١٤٥٥j;

        /* renamed from: k, reason: collision with root package name */
        private byte f١١٤٥٦k;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public i parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b V = i.V();
                try {
                    V.mergeFrom(iVar, vVar);
                    return V.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(V.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(V.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(V.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum c implements j0.c {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);


            /* renamed from: e, reason: collision with root package name */
            private static final j0.d f١١٤٧٠e = new a();

            /* renamed from: f, reason: collision with root package name */
            private static final c[] f١١٤٧١f = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٤٧٣a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            c(int i10) {
                this.f١١٤٧٣a = i10;
            }

            public static c c(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            return null;
                        }
                        return STRING_PIECE;
                    }
                    return CORD;
                }
                return STRING;
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٤٧٣a;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum d implements j0.c {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);


            /* renamed from: e, reason: collision with root package name */
            private static final j0.d f١١٤٧٧e = new a();

            /* renamed from: f, reason: collision with root package name */
            private static final d[] f١١٤٧٨f = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٤٨٠a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            d(int i10) {
                this.f١١٤٨٠a = i10;
            }

            public static d c(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            return null;
                        }
                        return JS_NUMBER;
                    }
                    return JS_STRING;
                }
                return JS_NORMAL;
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٤٨٠a;
            }
        }

        static /* synthetic */ int B(i iVar, int i10) {
            int i11 = i10 | iVar.f١١٤٤٧b;
            iVar.f١١٤٤٧b = i11;
            return i11;
        }

        public static i D() {
            return f١١٤٤٥l;
        }

        public static b V() {
            return f١١٤٤٥l.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.E;
        }

        public c C() {
            c c10 = c.c(this.f١١٤٤٨c);
            if (c10 == null) {
                return c.STRING;
            }
            return c10;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public i getDefaultInstanceForType() {
            return f١١٤٤٥l;
        }

        public boolean F() {
            return this.f١١٤٥٣h;
        }

        public d G() {
            d c10 = d.c(this.f١١٤٥٠e);
            if (c10 == null) {
                return d.JS_NORMAL;
            }
            return c10;
        }

        public boolean H() {
            return this.f١١٤٥١f;
        }

        public boolean I() {
            return this.f١١٤٤٩d;
        }

        public t J(int i10) {
            return (t) this.f١١٤٥٥j.get(i10);
        }

        public int K() {
            return this.f١١٤٥٥j.size();
        }

        public List L() {
            return this.f١١٤٥٥j;
        }

        public boolean M() {
            return this.f١١٤٥٢g;
        }

        public boolean N() {
            return this.f١١٤٥٤i;
        }

        public boolean O() {
            if ((this.f١١٤٤٧b & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean P() {
            if ((this.f١١٤٤٧b & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean Q() {
            if ((this.f١١٤٤٧b & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean R() {
            if ((this.f١١٤٤٧b & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean S() {
            if ((this.f١١٤٤٧b & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean T() {
            if ((this.f١١٤٤٧b & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean U() {
            if ((this.f١١٤٤٧b & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return V();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: X, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: Y, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٤٤٥l) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i)) {
                return super.equals(obj);
            }
            i iVar = (i) obj;
            if (O() != iVar.O()) {
                return false;
            }
            if ((O() && this.f١١٤٤٨c != iVar.f١١٤٤٨c) || S() != iVar.S()) {
                return false;
            }
            if ((S() && I() != iVar.I()) || Q() != iVar.Q()) {
                return false;
            }
            if ((Q() && this.f١١٤٥٠e != iVar.f١١٤٥٠e) || R() != iVar.R()) {
                return false;
            }
            if ((R() && H() != iVar.H()) || T() != iVar.T()) {
                return false;
            }
            if ((T() && M() != iVar.M()) || P() != iVar.P()) {
                return false;
            }
            if ((P() && F() != iVar.F()) || U() != iVar.U()) {
                return false;
            }
            if ((!U() || N() == iVar.N()) && L().equals(iVar.L()) && getUnknownFields().equals(iVar.getUnknownFields()) && p().equals(iVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٤٤٧b & 1) != 0) {
                i10 = com.google.protobuf.k.l(1, this.f١١٤٤٨c);
            } else {
                i10 = 0;
            }
            if ((this.f١١٤٤٧b & 2) != 0) {
                i10 += com.google.protobuf.k.e(2, this.f١١٤٤٩d);
            }
            if ((this.f١١٤٤٧b & 32) != 0) {
                i10 += com.google.protobuf.k.e(3, this.f١١٤٥٣h);
            }
            if ((this.f١١٤٤٧b & 8) != 0) {
                i10 += com.google.protobuf.k.e(5, this.f١١٤٥١f);
            }
            if ((this.f١١٤٤٧b & 4) != 0) {
                i10 += com.google.protobuf.k.l(6, this.f١١٤٥٠e);
            }
            if ((this.f١١٤٤٧b & 64) != 0) {
                i10 += com.google.protobuf.k.e(10, this.f١١٤٥٤i);
            }
            if ((this.f١١٤٤٧b & 16) != 0) {
                i10 += com.google.protobuf.k.e(15, this.f١١٤٥٢g);
            }
            for (int i12 = 0; i12 < this.f١١٤٥٥j.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٤٥٥j.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (O()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.f١١٤٤٨c;
            }
            if (S()) {
                hashCode = (((hashCode * 37) + 2) * 53) + j0.c(I());
            }
            if (Q()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.f١١٤٥٠e;
            }
            if (R()) {
                hashCode = (((hashCode * 37) + 5) * 53) + j0.c(H());
            }
            if (T()) {
                hashCode = (((hashCode * 37) + 15) * 53) + j0.c(M());
            }
            if (P()) {
                hashCode = (((hashCode * 37) + 3) * 53) + j0.c(F());
            }
            if (U()) {
                hashCode = (((hashCode * 37) + 10) * 53) + j0.c(N());
            }
            if (K() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + L().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.F.d(i.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٤٥٦k;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < K(); i10++) {
                if (!J(i10).isInitialized()) {
                    this.f١١٤٥٦k = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٤٥٦k = (byte) 0;
                return false;
            }
            this.f١١٤٥٦k = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new i();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٤٤٧b & 1) != 0) {
                kVar.t0(1, this.f١١٤٤٨c);
            }
            if ((this.f١١٤٤٧b & 2) != 0) {
                kVar.l0(2, this.f١١٤٤٩d);
            }
            if ((this.f١١٤٤٧b & 32) != 0) {
                kVar.l0(3, this.f١١٤٥٣h);
            }
            if ((this.f١١٤٤٧b & 8) != 0) {
                kVar.l0(5, this.f١١٤٥١f);
            }
            if ((this.f١١٤٤٧b & 4) != 0) {
                kVar.t0(6, this.f١١٤٥٠e);
            }
            if ((this.f١١٤٤٧b & 64) != 0) {
                kVar.l0(10, this.f١١٤٥٤i);
            }
            if ((this.f١١٤٤٧b & 16) != 0) {
                kVar.l0(15, this.f١١٤٥٢g);
            }
            for (int i10 = 0; i10 < this.f١١٤٥٥j.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٤٥٥j.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٤٥٧b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٤٥٨c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f١١٤٥٩d;

            /* renamed from: e, reason: collision with root package name */
            private int f١١٤٦٠e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f١١٤٦١f;

            /* renamed from: g, reason: collision with root package name */
            private boolean f١١٤٦٢g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f١١٤٦٣h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f١١٤٦٤i;

            /* renamed from: j, reason: collision with root package name */
            private List f١١٤٦٥j;

            /* renamed from: k, reason: collision with root package name */
            private x1 f١١٤٦٦k;

            private void p(i iVar) {
                int i10;
                int i11 = this.f١١٤٥٧b;
                if ((i11 & 1) != 0) {
                    iVar.f١١٤٤٨c = this.f١١٤٥٨c;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    iVar.f١١٤٤٩d = this.f١١٤٥٩d;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    iVar.f١١٤٥٠e = this.f١١٤٦٠e;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    iVar.f١١٤٥١f = this.f١١٤٦١f;
                    i10 |= 8;
                }
                if ((i11 & 16) != 0) {
                    iVar.f١١٤٥٢g = this.f١١٤٦٢g;
                    i10 |= 16;
                }
                if ((i11 & 32) != 0) {
                    iVar.f١١٤٥٣h = this.f١١٤٦٣h;
                    i10 |= 32;
                }
                if ((i11 & 64) != 0) {
                    iVar.f١١٤٥٤i = this.f١١٤٦٤i;
                    i10 |= 64;
                }
                i.B(iVar, i10);
            }

            private void q(i iVar) {
                x1 x1Var = this.f١١٤٦٦k;
                if (x1Var != null) {
                    iVar.f١١٤٥٥j = x1Var.g();
                    return;
                }
                if ((this.f١١٤٥٧b & 128) != 0) {
                    this.f١١٤٦٥j = Collections.unmodifiableList(this.f١١٤٦٥j);
                    this.f١١٤٥٧b &= -129;
                }
                iVar.f١١٤٥٥j = this.f١١٤٦٥j;
            }

            private void s() {
                if ((this.f١١٤٥٧b & 128) == 0) {
                    this.f١١٤٦٥j = new ArrayList(this.f١١٤٦٥j);
                    this.f١١٤٥٧b |= 128;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٤٦٦k == null) {
                    List list = this.f١١٤٦٥j;
                    if ((this.f١١٤٥٧b & 128) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٤٦٦k = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٤٦٥j = null;
                }
                return this.f١١٤٦٦k;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(c cVar) {
                cVar.getClass();
                this.f١١٤٥٧b |= 1;
                this.f١١٤٥٨c = cVar.getNumber();
                onChanged();
                return this;
            }

            public b C(boolean z10) {
                this.f١١٤٦٣h = z10;
                this.f١١٤٥٧b |= 32;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            public b E(d dVar) {
                dVar.getClass();
                this.f١١٤٥٧b |= 4;
                this.f١١٤٦٠e = dVar.getNumber();
                onChanged();
                return this;
            }

            public b F(boolean z10) {
                this.f١١٤٦١f = z10;
                this.f١١٤٥٧b |= 8;
                onChanged();
                return this;
            }

            public b G(boolean z10) {
                this.f١١٤٥٩d = z10;
                this.f١١٤٥٧b |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: H, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            public b I(boolean z10) {
                this.f١١٤٦٢g = z10;
                this.f١١٤٥٧b |= 16;
                onChanged();
                return this;
            }

            public b J(boolean z10) {
                this.f١١٤٦٤i = z10;
                this.f١١٤٥٧b |= 64;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.E;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.F.d(i.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public i build() {
                i buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public i buildPartial() {
                i iVar = new i(this);
                q(iVar);
                if (this.f١١٤٥٧b != 0) {
                    p(iVar);
                }
                onBuilt();
                return iVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public i getDefaultInstanceForType() {
                return i.D();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٤٦٦k;
                if (x1Var == null) {
                    return (t) this.f١١٤٦٥j.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٤٦٦k;
                if (x1Var == null) {
                    return this.f١١٤٦٥j.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 8) {
                                    if (K != 16) {
                                        if (K != 24) {
                                            if (K != 40) {
                                                if (K != 48) {
                                                    if (K != 80) {
                                                        if (K != 120) {
                                                            if (K != 7994) {
                                                                if (!super.parseUnknownField(iVar, vVar, K)) {
                                                                }
                                                            } else {
                                                                t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                                                x1 x1Var = this.f١١٤٦٦k;
                                                                if (x1Var == null) {
                                                                    s();
                                                                    this.f١١٤٦٥j.add(tVar);
                                                                } else {
                                                                    x1Var.f(tVar);
                                                                }
                                                            }
                                                        } else {
                                                            this.f١١٤٦٢g = iVar.q();
                                                            this.f١١٤٥٧b |= 16;
                                                        }
                                                    } else {
                                                        this.f١١٤٦٤i = iVar.q();
                                                        this.f١١٤٥٧b |= 64;
                                                    }
                                                } else {
                                                    int t10 = iVar.t();
                                                    if (d.c(t10) == null) {
                                                        mergeUnknownVarintField(6, t10);
                                                    } else {
                                                        this.f١١٤٦٠e = t10;
                                                        this.f١١٤٥٧b |= 4;
                                                    }
                                                }
                                            } else {
                                                this.f١١٤٦١f = iVar.q();
                                                this.f١١٤٥٧b |= 8;
                                            }
                                        } else {
                                            this.f١١٤٦٣h = iVar.q();
                                            this.f١١٤٥٧b |= 32;
                                        }
                                    } else {
                                        this.f١١٤٥٩d = iVar.q();
                                        this.f١١٤٥٧b |= 2;
                                    }
                                } else {
                                    int t11 = iVar.t();
                                    if (c.c(t11) == null) {
                                        mergeUnknownVarintField(1, t11);
                                    } else {
                                        this.f١١٤٥٨c = t11;
                                        this.f١١٤٥٧b |= 1;
                                    }
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(i iVar) {
                if (iVar == i.D()) {
                    return this;
                }
                if (iVar.O()) {
                    B(iVar.C());
                }
                if (iVar.S()) {
                    G(iVar.I());
                }
                if (iVar.Q()) {
                    E(iVar.G());
                }
                if (iVar.R()) {
                    F(iVar.H());
                }
                if (iVar.T()) {
                    I(iVar.M());
                }
                if (iVar.P()) {
                    C(iVar.F());
                }
                if (iVar.U()) {
                    J(iVar.N());
                }
                if (this.f١١٤٦٦k == null) {
                    if (!iVar.f١١٤٥٥j.isEmpty()) {
                        if (this.f١١٤٦٥j.isEmpty()) {
                            this.f١١٤٦٥j = iVar.f١١٤٥٥j;
                            this.f١١٤٥٧b &= -129;
                        } else {
                            s();
                            this.f١١٤٦٥j.addAll(iVar.f١١٤٥٥j);
                        }
                        onChanged();
                    }
                } else if (!iVar.f١١٤٥٥j.isEmpty()) {
                    if (this.f١١٤٦٦k.u()) {
                        this.f١١٤٦٦k.i();
                        x1 x1Var = null;
                        this.f١١٤٦٦k = null;
                        this.f١١٤٦٥j = iVar.f١١٤٥٥j;
                        this.f١١٤٥٧b &= -129;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٤٦٦k = x1Var;
                    } else {
                        this.f١١٤٦٦k.b(iVar.f١١٤٥٥j);
                    }
                }
                j(iVar);
                mergeUnknownFields(iVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof i) {
                    return y((i) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٤٥٨c = 0;
                this.f١١٤٦٠e = 0;
                this.f١١٤٦٥j = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٤٥٨c = 0;
                this.f١١٤٦٠e = 0;
                this.f١١٤٦٥j = Collections.emptyList();
            }
        }

        private i(h0.d dVar) {
            super(dVar);
            this.f١١٤٤٨c = 0;
            this.f١١٤٤٩d = false;
            this.f١١٤٥٠e = 0;
            this.f١١٤٥١f = false;
            this.f١١٤٥٢g = false;
            this.f١١٤٥٣h = false;
            this.f١١٤٥٤i = false;
            this.f١١٤٥٦k = (byte) -1;
        }

        private i() {
            this.f١١٤٤٩d = false;
            this.f١١٤٥١f = false;
            this.f١١٤٥٢g = false;
            this.f١١٤٥٣h = false;
            this.f١١٤٥٤i = false;
            this.f١١٤٥٦k = (byte) -1;
            this.f١١٤٤٨c = 0;
            this.f١١٤٥٠e = 0;
            this.f١١٤٥٥j = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class j extends h0 implements g1 {

        /* renamed from: o, reason: collision with root package name */
        private static final j f١١٤٨١o = new j();

        /* renamed from: p, reason: collision with root package name */
        public static final r1 f١١٤٨٢p = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٤٨٣a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٤٨٤b;

        /* renamed from: c, reason: collision with root package name */
        private volatile Object f١١٤٨٥c;

        /* renamed from: d, reason: collision with root package name */
        private p0 f١١٤٨٦d;

        /* renamed from: e, reason: collision with root package name */
        private j0.g f١١٤٨٧e;

        /* renamed from: f, reason: collision with root package name */
        private j0.g f١١٤٨٨f;

        /* renamed from: g, reason: collision with root package name */
        private List f١١٤٨٩g;

        /* renamed from: h, reason: collision with root package name */
        private List f١١٤٩٠h;

        /* renamed from: i, reason: collision with root package name */
        private List f١١٤٩١i;

        /* renamed from: j, reason: collision with root package name */
        private List f١١٤٩٢j;

        /* renamed from: k, reason: collision with root package name */
        private k f١١٤٩٣k;

        /* renamed from: l, reason: collision with root package name */
        private s f١١٤٩٤l;

        /* renamed from: m, reason: collision with root package name */
        private volatile Object f١١٤٩٥m;

        /* renamed from: n, reason: collision with root package name */
        private byte f١١٤٩٦n;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public j parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b o02 = j.o0();
                try {
                    o02.mergeFrom(iVar, vVar);
                    return o02.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(o02.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(o02.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(o02.buildPartial());
                }
            }
        }

        static /* synthetic */ int I(j jVar, int i10) {
            int i11 = i10 | jVar.f١١٤٨٣a;
            jVar.f١١٤٨٣a = i11;
            return i11;
        }

        public static j J() {
            return f١١٤٨١o;
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٤١c;
        }

        public static b o0() {
            return f١١٤٨١o.toBuilder();
        }

        public static j r0(byte[] bArr) {
            return (j) f١١٤٨٢p.parseFrom(bArr);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public j getDefaultInstanceForType() {
            return f١١٤٨١o;
        }

        public String L(int i10) {
            return (String) this.f١١٤٨٦d.get(i10);
        }

        public int M() {
            return this.f١١٤٨٦d.size();
        }

        public v1 N() {
            return this.f١١٤٨٦d;
        }

        public c O(int i10) {
            return (c) this.f١١٤٩٠h.get(i10);
        }

        public int P() {
            return this.f١١٤٩٠h.size();
        }

        public List Q() {
            return this.f١١٤٩٠h;
        }

        public h R(int i10) {
            return (h) this.f١١٤٩٢j.get(i10);
        }

        public int S() {
            return this.f١١٤٩٢j.size();
        }

        public List T() {
            return this.f١١٤٩٢j;
        }

        public b U(int i10) {
            return (b) this.f١١٤٨٩g.get(i10);
        }

        public int V() {
            return this.f١١٤٨٩g.size();
        }

        public List W() {
            return this.f١١٤٨٩g;
        }

        public k X() {
            k kVar = this.f١١٤٩٣k;
            if (kVar == null) {
                return k.c0();
            }
            return kVar;
        }

        public String Y() {
            Object obj = this.f١١٤٨٥c;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٤٨٥c = C;
            }
            return C;
        }

        public int Z(int i10) {
            return this.f١١٤٨٧e.getInt(i10);
        }

        public int a0() {
            return this.f١١٤٨٧e.size();
        }

        public List b0() {
            return this.f١١٤٨٧e;
        }

        public q c0(int i10) {
            return (q) this.f١١٤٩١i.get(i10);
        }

        public int d0() {
            return this.f١١٤٩١i.size();
        }

        public List e0() {
            return this.f١١٤٩١i;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof j)) {
                return super.equals(obj);
            }
            j jVar = (j) obj;
            if (j0() != jVar.j0()) {
                return false;
            }
            if ((j0() && !getName().equals(jVar.getName())) || l0() != jVar.l0()) {
                return false;
            }
            if ((l0() && !Y().equals(jVar.Y())) || !N().equals(jVar.N()) || !b0().equals(jVar.b0()) || !i0().equals(jVar.i0()) || !W().equals(jVar.W()) || !Q().equals(jVar.Q()) || !e0().equals(jVar.e0()) || !T().equals(jVar.T()) || k0() != jVar.k0()) {
                return false;
            }
            if ((k0() && !X().equals(jVar.X())) || m0() != jVar.m0()) {
                return false;
            }
            if ((m0() && !f0().equals(jVar.f0())) || n0() != jVar.n0()) {
                return false;
            }
            if ((!n0() || g0().equals(jVar.g0())) && getUnknownFields().equals(jVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public s f0() {
            s sVar = this.f١١٤٩٤l;
            if (sVar == null) {
                return s.o();
            }
            return sVar;
        }

        public String g0() {
            Object obj = this.f١١٤٩٥m;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٤٩٥m = C;
            }
            return C;
        }

        public String getName() {
            Object obj = this.f١١٤٨٤b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٤٨٤b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٤٨٣a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٤٨٤b);
            } else {
                i10 = 0;
            }
            if ((this.f١١٤٨٣a & 2) != 0) {
                i10 += h0.computeStringSize(2, this.f١١٤٨٥c);
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.f١١٤٨٦d.size(); i13++) {
                i12 += h0.computeStringSizeNoTag(this.f١١٤٨٦d.S(i13));
            }
            int size = i10 + i12 + N().size();
            for (int i14 = 0; i14 < this.f١١٤٨٩g.size(); i14++) {
                size += com.google.protobuf.k.G(4, (e1) this.f١١٤٨٩g.get(i14));
            }
            for (int i15 = 0; i15 < this.f١١٤٩٠h.size(); i15++) {
                size += com.google.protobuf.k.G(5, (e1) this.f١١٤٩٠h.get(i15));
            }
            for (int i16 = 0; i16 < this.f١١٤٩١i.size(); i16++) {
                size += com.google.protobuf.k.G(6, (e1) this.f١١٤٩١i.get(i16));
            }
            for (int i17 = 0; i17 < this.f١١٤٩٢j.size(); i17++) {
                size += com.google.protobuf.k.G(7, (e1) this.f١١٤٩٢j.get(i17));
            }
            if ((this.f١١٤٨٣a & 4) != 0) {
                size += com.google.protobuf.k.G(8, X());
            }
            if ((this.f١١٤٨٣a & 8) != 0) {
                size += com.google.protobuf.k.G(9, f0());
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.f١١٤٨٧e.size(); i19++) {
                i18 += com.google.protobuf.k.y(this.f١١٤٨٧e.getInt(i19));
            }
            int size2 = size + i18 + b0().size();
            int i20 = 0;
            for (int i21 = 0; i21 < this.f١١٤٨٨f.size(); i21++) {
                i20 += com.google.protobuf.k.y(this.f١١٤٨٨f.getInt(i21));
            }
            int size3 = size2 + i20 + i0().size();
            if ((this.f١١٤٨٣a & 16) != 0) {
                size3 += h0.computeStringSize(12, this.f١١٤٩٥m);
            }
            int serializedSize = size3 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        public int h0() {
            return this.f١١٤٨٨f.size();
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (j0()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (l0()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Y().hashCode();
            }
            if (M() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + N().hashCode();
            }
            if (a0() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + b0().hashCode();
            }
            if (h0() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + i0().hashCode();
            }
            if (V() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + W().hashCode();
            }
            if (P() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + Q().hashCode();
            }
            if (d0() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + e0().hashCode();
            }
            if (S() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + T().hashCode();
            }
            if (k0()) {
                hashCode = (((hashCode * 37) + 8) * 53) + X().hashCode();
            }
            if (m0()) {
                hashCode = (((hashCode * 37) + 9) * 53) + f0().hashCode();
            }
            if (n0()) {
                hashCode = (((hashCode * 37) + 12) * 53) + g0().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public List i0() {
            return this.f١١٤٨٨f;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٤٣d.d(j.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٤٩٦n;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < V(); i10++) {
                if (!U(i10).isInitialized()) {
                    this.f١١٤٩٦n = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < P(); i11++) {
                if (!O(i11).isInitialized()) {
                    this.f١١٤٩٦n = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < d0(); i12++) {
                if (!c0(i12).isInitialized()) {
                    this.f١١٤٩٦n = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < S(); i13++) {
                if (!R(i13).isInitialized()) {
                    this.f١١٤٩٦n = (byte) 0;
                    return false;
                }
            }
            if (k0() && !X().isInitialized()) {
                this.f١١٤٩٦n = (byte) 0;
                return false;
            }
            this.f١١٤٩٦n = (byte) 1;
            return true;
        }

        public boolean j0() {
            if ((this.f١١٤٨٣a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean k0() {
            if ((this.f١١٤٨٣a & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean l0() {
            if ((this.f١١٤٨٣a & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean m0() {
            if ((this.f١١٤٨٣a & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean n0() {
            if ((this.f١١٤٨٣a & 16) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new j();
        }

        @Override // com.google.protobuf.e1
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return o0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: s0, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٤٨١o) {
                return new b();
            }
            return new b().N(this);
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٤٨٣a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٤٨٤b);
            }
            if ((this.f١١٤٨٣a & 2) != 0) {
                h0.writeString(kVar, 2, this.f١١٤٨٥c);
            }
            for (int i10 = 0; i10 < this.f١١٤٨٦d.size(); i10++) {
                h0.writeString(kVar, 3, this.f١١٤٨٦d.S(i10));
            }
            for (int i11 = 0; i11 < this.f١١٤٨٩g.size(); i11++) {
                kVar.H0(4, (e1) this.f١١٤٨٩g.get(i11));
            }
            for (int i12 = 0; i12 < this.f١١٤٩٠h.size(); i12++) {
                kVar.H0(5, (e1) this.f١١٤٩٠h.get(i12));
            }
            for (int i13 = 0; i13 < this.f١١٤٩١i.size(); i13++) {
                kVar.H0(6, (e1) this.f١١٤٩١i.get(i13));
            }
            for (int i14 = 0; i14 < this.f١١٤٩٢j.size(); i14++) {
                kVar.H0(7, (e1) this.f١١٤٩٢j.get(i14));
            }
            if ((this.f١١٤٨٣a & 4) != 0) {
                kVar.H0(8, X());
            }
            if ((this.f١١٤٨٣a & 8) != 0) {
                kVar.H0(9, f0());
            }
            for (int i15 = 0; i15 < this.f١١٤٨٧e.size(); i15++) {
                kVar.D0(10, this.f١١٤٨٧e.getInt(i15));
            }
            for (int i16 = 0; i16 < this.f١١٤٨٨f.size(); i16++) {
                kVar.D0(11, this.f١١٤٨٨f.getInt(i16));
            }
            if ((this.f١١٤٨٣a & 16) != 0) {
                h0.writeString(kVar, 12, this.f١١٤٩٥m);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٤٩٧a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٤٩٨b;

            /* renamed from: c, reason: collision with root package name */
            private Object f١١٤٩٩c;

            /* renamed from: d, reason: collision with root package name */
            private p0 f١١٥٠٠d;

            /* renamed from: e, reason: collision with root package name */
            private j0.g f١١٥٠١e;

            /* renamed from: f, reason: collision with root package name */
            private j0.g f١١٥٠٢f;

            /* renamed from: g, reason: collision with root package name */
            private List f١١٥٠٣g;

            /* renamed from: h, reason: collision with root package name */
            private x1 f١١٥٠٤h;

            /* renamed from: i, reason: collision with root package name */
            private List f١١٥٠٥i;

            /* renamed from: j, reason: collision with root package name */
            private x1 f١١٥٠٦j;

            /* renamed from: k, reason: collision with root package name */
            private List f١١٥٠٧k;

            /* renamed from: l, reason: collision with root package name */
            private x1 f١١٥٠٨l;

            /* renamed from: m, reason: collision with root package name */
            private List f١١٥٠٩m;

            /* renamed from: n, reason: collision with root package name */
            private x1 f١١٥١٠n;

            /* renamed from: o, reason: collision with root package name */
            private k f١١٥١١o;

            /* renamed from: p, reason: collision with root package name */
            private b2 f١١٥١٢p;

            /* renamed from: q, reason: collision with root package name */
            private s f١١٥١٣q;

            /* renamed from: r, reason: collision with root package name */
            private b2 f١١٥١٤r;

            /* renamed from: s, reason: collision with root package name */
            private Object f١١٥١٥s;

            private x1 B() {
                boolean z10;
                if (this.f١١٥٠٤h == null) {
                    List list = this.f١١٥٠٣g;
                    if ((this.f١١٤٩٧a & 32) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥٠٤h = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٠٣g = null;
                }
                return this.f١١٥٠٤h;
            }

            private b2 E() {
                if (this.f١١٥١٢p == null) {
                    this.f١١٥١٢p = new b2(C(), getParentForChildren(), isClean());
                    this.f١١٥١١o = null;
                }
                return this.f١١٥١٢p;
            }

            private x1 H() {
                boolean z10;
                if (this.f١١٥٠٨l == null) {
                    List list = this.f١١٥٠٧k;
                    if ((this.f١١٤٩٧a & 128) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥٠٨l = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٠٧k = null;
                }
                return this.f١١٥٠٨l;
            }

            private b2 K() {
                if (this.f١١٥١٤r == null) {
                    this.f١١٥١٤r = new b2(I(), getParentForChildren(), isClean());
                    this.f١١٥١٣q = null;
                }
                return this.f١١٥١٤r;
            }

            private void i(j jVar) {
                int i10;
                s sVar;
                k kVar;
                int i11 = this.f١١٤٩٧a;
                if ((i11 & 1) != 0) {
                    jVar.f١١٤٨٤b = this.f١١٤٩٨b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    jVar.f١١٤٨٥c = this.f١١٤٩٩c;
                    i10 |= 2;
                }
                if ((i11 & 512) != 0) {
                    b2 b2Var = this.f١١٥١٢p;
                    if (b2Var == null) {
                        kVar = this.f١١٥١١o;
                    } else {
                        kVar = (k) b2Var.b();
                    }
                    jVar.f١١٤٩٣k = kVar;
                    i10 |= 4;
                }
                if ((i11 & 1024) != 0) {
                    b2 b2Var2 = this.f١١٥١٤r;
                    if (b2Var2 == null) {
                        sVar = this.f١١٥١٣q;
                    } else {
                        sVar = (s) b2Var2.b();
                    }
                    jVar.f١١٤٩٤l = sVar;
                    i10 |= 8;
                }
                if ((i11 & 2048) != 0) {
                    jVar.f١١٤٩٥m = this.f١١٥١٥s;
                    i10 |= 16;
                }
                j.I(jVar, i10);
            }

            private void j(j jVar) {
                if ((this.f١١٤٩٧a & 4) != 0) {
                    this.f١١٥٠٠d = this.f١١٥٠٠d.getUnmodifiableView();
                    this.f١١٤٩٧a &= -5;
                }
                jVar.f١١٤٨٦d = this.f١١٥٠٠d;
                if ((this.f١١٤٩٧a & 8) != 0) {
                    this.f١١٥٠١e.b();
                    this.f١١٤٩٧a &= -9;
                }
                jVar.f١١٤٨٧e = this.f١١٥٠١e;
                if ((this.f١١٤٩٧a & 16) != 0) {
                    this.f١١٥٠٢f.b();
                    this.f١١٤٩٧a &= -17;
                }
                jVar.f١١٤٨٨f = this.f١١٥٠٢f;
                x1 x1Var = this.f١١٥٠٤h;
                if (x1Var != null) {
                    jVar.f١١٤٨٩g = x1Var.g();
                } else {
                    if ((this.f١١٤٩٧a & 32) != 0) {
                        this.f١١٥٠٣g = Collections.unmodifiableList(this.f١١٥٠٣g);
                        this.f١١٤٩٧a &= -33;
                    }
                    jVar.f١١٤٨٩g = this.f١١٥٠٣g;
                }
                x1 x1Var2 = this.f١١٥٠٦j;
                if (x1Var2 != null) {
                    jVar.f١١٤٩٠h = x1Var2.g();
                } else {
                    if ((this.f١١٤٩٧a & 64) != 0) {
                        this.f١١٥٠٥i = Collections.unmodifiableList(this.f١١٥٠٥i);
                        this.f١١٤٩٧a &= -65;
                    }
                    jVar.f١١٤٩٠h = this.f١١٥٠٥i;
                }
                x1 x1Var3 = this.f١١٥٠٨l;
                if (x1Var3 != null) {
                    jVar.f١١٤٩١i = x1Var3.g();
                } else {
                    if ((this.f١١٤٩٧a & 128) != 0) {
                        this.f١١٥٠٧k = Collections.unmodifiableList(this.f١١٥٠٧k);
                        this.f١١٤٩٧a &= -129;
                    }
                    jVar.f١١٤٩١i = this.f١١٥٠٧k;
                }
                x1 x1Var4 = this.f١١٥١٠n;
                if (x1Var4 != null) {
                    jVar.f١١٤٩٢j = x1Var4.g();
                    return;
                }
                if ((this.f١١٤٩٧a & 256) != 0) {
                    this.f١١٥٠٩m = Collections.unmodifiableList(this.f١١٥٠٩m);
                    this.f١١٤٩٧a &= -257;
                }
                jVar.f١١٤٩٢j = this.f١١٥٠٩m;
            }

            private void l() {
                if ((this.f١١٤٩٧a & 4) == 0) {
                    this.f١١٥٠٠d = new o0(this.f١١٥٠٠d);
                    this.f١١٤٩٧a |= 4;
                }
            }

            private void m() {
                if ((this.f١١٤٩٧a & 64) == 0) {
                    this.f١١٥٠٥i = new ArrayList(this.f١١٥٠٥i);
                    this.f١١٤٩٧a |= 64;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    B();
                    v();
                    H();
                    y();
                    E();
                    K();
                }
            }

            private void n() {
                if ((this.f١١٤٩٧a & 256) == 0) {
                    this.f١١٥٠٩m = new ArrayList(this.f١١٥٠٩m);
                    this.f١١٤٩٧a |= 256;
                }
            }

            private void o() {
                if ((this.f١١٤٩٧a & 32) == 0) {
                    this.f١١٥٠٣g = new ArrayList(this.f١١٥٠٣g);
                    this.f١١٤٩٧a |= 32;
                }
            }

            private void p() {
                if ((this.f١١٤٩٧a & 8) == 0) {
                    this.f١١٥٠١e = h0.mutableCopy(this.f١١٥٠١e);
                    this.f١١٤٩٧a |= 8;
                }
            }

            private void q() {
                if ((this.f١١٤٩٧a & 128) == 0) {
                    this.f١١٥٠٧k = new ArrayList(this.f١١٥٠٧k);
                    this.f١١٤٩٧a |= 128;
                }
            }

            private void r() {
                if ((this.f١١٤٩٧a & 16) == 0) {
                    this.f١١٥٠٢f = h0.mutableCopy(this.f١١٥٠٢f);
                    this.f١١٤٩٧a |= 16;
                }
            }

            private x1 v() {
                boolean z10;
                if (this.f١١٥٠٦j == null) {
                    List list = this.f١١٥٠٥i;
                    if ((this.f١١٤٩٧a & 64) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥٠٦j = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٠٥i = null;
                }
                return this.f١١٥٠٦j;
            }

            private x1 y() {
                boolean z10;
                if (this.f١١٥١٠n == null) {
                    List list = this.f١١٥٠٩m;
                    if ((this.f١١٤٩٧a & 256) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥١٠n = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٠٩m = null;
                }
                return this.f١١٥١٠n;
            }

            public int A() {
                x1 x1Var = this.f١١٥٠٤h;
                if (x1Var == null) {
                    return this.f١١٥٠٣g.size();
                }
                return x1Var.n();
            }

            public k C() {
                b2 b2Var = this.f١١٥١٢p;
                if (b2Var == null) {
                    k kVar = this.f١١٥١١o;
                    if (kVar == null) {
                        return k.c0();
                    }
                    return kVar;
                }
                return (k) b2Var.e();
            }

            public k.b D() {
                this.f١١٤٩٧a |= 512;
                onChanged();
                return (k.b) E().d();
            }

            public q F(int i10) {
                x1 x1Var = this.f١١٥٠٨l;
                if (x1Var == null) {
                    return (q) this.f١١٥٠٧k.get(i10);
                }
                return (q) x1Var.o(i10);
            }

            public int G() {
                x1 x1Var = this.f١١٥٠٨l;
                if (x1Var == null) {
                    return this.f١١٥٠٧k.size();
                }
                return x1Var.n();
            }

            public s I() {
                b2 b2Var = this.f١١٥١٤r;
                if (b2Var == null) {
                    s sVar = this.f١١٥١٣q;
                    if (sVar == null) {
                        return s.o();
                    }
                    return sVar;
                }
                return (s) b2Var.e();
            }

            public s.b J() {
                this.f١١٤٩٧a |= 1024;
                onChanged();
                return (s.b) K().d();
            }

            public boolean L() {
                if ((this.f١١٤٩٧a & 512) != 0) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.f١١٤٩٨b = iVar.r();
                                    this.f١١٤٩٧a |= 1;
                                case 18:
                                    this.f١١٤٩٩c = iVar.r();
                                    this.f١١٤٩٧a |= 2;
                                case 26:
                                    com.google.protobuf.h r10 = iVar.r();
                                    l();
                                    this.f١١٥٠٠d.j(r10);
                                case 34:
                                    b bVar = (b) iVar.A(b.f١١٢٦٧n, vVar);
                                    x1 x1Var = this.f١١٥٠٤h;
                                    if (x1Var == null) {
                                        o();
                                        this.f١١٥٠٣g.add(bVar);
                                    } else {
                                        x1Var.f(bVar);
                                    }
                                case 42:
                                    c cVar = (c) iVar.A(c.f١١٣٢١i, vVar);
                                    x1 x1Var2 = this.f١١٥٠٦j;
                                    if (x1Var2 == null) {
                                        m();
                                        this.f١١٥٠٥i.add(cVar);
                                    } else {
                                        x1Var2.f(cVar);
                                    }
                                case 50:
                                    q qVar = (q) iVar.A(q.f١١٦٤٢g, vVar);
                                    x1 x1Var3 = this.f١١٥٠٨l;
                                    if (x1Var3 == null) {
                                        q();
                                        this.f١١٥٠٧k.add(qVar);
                                    } else {
                                        x1Var3.f(qVar);
                                    }
                                case 58:
                                    h hVar = (h) iVar.A(h.f١١٣٨٩o, vVar);
                                    x1 x1Var4 = this.f١١٥١٠n;
                                    if (x1Var4 == null) {
                                        n();
                                        this.f١١٥٠٩m.add(hVar);
                                    } else {
                                        x1Var4.f(hVar);
                                    }
                                case 66:
                                    iVar.B(E().d(), vVar);
                                    this.f١١٤٩٧a |= 512;
                                case 74:
                                    iVar.B(K().d(), vVar);
                                    this.f١١٤٩٧a |= 1024;
                                case 80:
                                    int y10 = iVar.y();
                                    p();
                                    this.f١١٥٠١e.E(y10);
                                case 82:
                                    int p10 = iVar.p(iVar.C());
                                    p();
                                    while (iVar.e() > 0) {
                                        this.f١١٥٠١e.E(iVar.y());
                                    }
                                    iVar.o(p10);
                                case 88:
                                    int y11 = iVar.y();
                                    r();
                                    this.f١١٥٠٢f.E(y11);
                                case 90:
                                    int p11 = iVar.p(iVar.C());
                                    r();
                                    while (iVar.e() > 0) {
                                        this.f١١٥٠٢f.E(iVar.y());
                                    }
                                    iVar.o(p11);
                                case 98:
                                    this.f١١٥١٥s = iVar.r();
                                    this.f١١٤٩٧a |= 2048;
                                default:
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                        z10 = true;
                                    }
                            }
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b N(j jVar) {
                x1 x1Var;
                x1 x1Var2;
                x1 x1Var3;
                if (jVar == j.J()) {
                    return this;
                }
                if (jVar.j0()) {
                    this.f١١٤٩٨b = jVar.f١١٤٨٤b;
                    this.f١١٤٩٧a |= 1;
                    onChanged();
                }
                if (jVar.l0()) {
                    this.f١١٤٩٩c = jVar.f١١٤٨٥c;
                    this.f١١٤٩٧a |= 2;
                    onChanged();
                }
                if (!jVar.f١١٤٨٦d.isEmpty()) {
                    if (this.f١١٥٠٠d.isEmpty()) {
                        this.f١١٥٠٠d = jVar.f١١٤٨٦d;
                        this.f١١٤٩٧a &= -5;
                    } else {
                        l();
                        this.f١١٥٠٠d.addAll(jVar.f١١٤٨٦d);
                    }
                    onChanged();
                }
                if (!jVar.f١١٤٨٧e.isEmpty()) {
                    if (this.f١١٥٠١e.isEmpty()) {
                        this.f١١٥٠١e = jVar.f١١٤٨٧e;
                        this.f١١٤٩٧a &= -9;
                    } else {
                        p();
                        this.f١١٥٠١e.addAll(jVar.f١١٤٨٧e);
                    }
                    onChanged();
                }
                if (!jVar.f١١٤٨٨f.isEmpty()) {
                    if (this.f١١٥٠٢f.isEmpty()) {
                        this.f١١٥٠٢f = jVar.f١١٤٨٨f;
                        this.f١١٤٩٧a &= -17;
                    } else {
                        r();
                        this.f١١٥٠٢f.addAll(jVar.f١١٤٨٨f);
                    }
                    onChanged();
                }
                x1 x1Var4 = null;
                if (this.f١١٥٠٤h == null) {
                    if (!jVar.f١١٤٨٩g.isEmpty()) {
                        if (this.f١١٥٠٣g.isEmpty()) {
                            this.f١١٥٠٣g = jVar.f١١٤٨٩g;
                            this.f١١٤٩٧a &= -33;
                        } else {
                            o();
                            this.f١١٥٠٣g.addAll(jVar.f١١٤٨٩g);
                        }
                        onChanged();
                    }
                } else if (!jVar.f١١٤٨٩g.isEmpty()) {
                    if (this.f١١٥٠٤h.u()) {
                        this.f١١٥٠٤h.i();
                        this.f١١٥٠٤h = null;
                        this.f١١٥٠٣g = jVar.f١١٤٨٩g;
                        this.f١١٤٩٧a &= -33;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = B();
                        } else {
                            x1Var = null;
                        }
                        this.f١١٥٠٤h = x1Var;
                    } else {
                        this.f١١٥٠٤h.b(jVar.f١١٤٨٩g);
                    }
                }
                if (this.f١١٥٠٦j == null) {
                    if (!jVar.f١١٤٩٠h.isEmpty()) {
                        if (this.f١١٥٠٥i.isEmpty()) {
                            this.f١١٥٠٥i = jVar.f١١٤٩٠h;
                            this.f١١٤٩٧a &= -65;
                        } else {
                            m();
                            this.f١١٥٠٥i.addAll(jVar.f١١٤٩٠h);
                        }
                        onChanged();
                    }
                } else if (!jVar.f١١٤٩٠h.isEmpty()) {
                    if (this.f١١٥٠٦j.u()) {
                        this.f١١٥٠٦j.i();
                        this.f١١٥٠٦j = null;
                        this.f١١٥٠٥i = jVar.f١١٤٩٠h;
                        this.f١١٤٩٧a &= -65;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var2 = v();
                        } else {
                            x1Var2 = null;
                        }
                        this.f١١٥٠٦j = x1Var2;
                    } else {
                        this.f١١٥٠٦j.b(jVar.f١١٤٩٠h);
                    }
                }
                if (this.f١١٥٠٨l == null) {
                    if (!jVar.f١١٤٩١i.isEmpty()) {
                        if (this.f١١٥٠٧k.isEmpty()) {
                            this.f١١٥٠٧k = jVar.f١١٤٩١i;
                            this.f١١٤٩٧a &= -129;
                        } else {
                            q();
                            this.f١١٥٠٧k.addAll(jVar.f١١٤٩١i);
                        }
                        onChanged();
                    }
                } else if (!jVar.f١١٤٩١i.isEmpty()) {
                    if (this.f١١٥٠٨l.u()) {
                        this.f١١٥٠٨l.i();
                        this.f١١٥٠٨l = null;
                        this.f١١٥٠٧k = jVar.f١١٤٩١i;
                        this.f١١٤٩٧a &= -129;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var3 = H();
                        } else {
                            x1Var3 = null;
                        }
                        this.f١١٥٠٨l = x1Var3;
                    } else {
                        this.f١١٥٠٨l.b(jVar.f١١٤٩١i);
                    }
                }
                if (this.f١١٥١٠n == null) {
                    if (!jVar.f١١٤٩٢j.isEmpty()) {
                        if (this.f١١٥٠٩m.isEmpty()) {
                            this.f١١٥٠٩m = jVar.f١١٤٩٢j;
                            this.f١١٤٩٧a &= -257;
                        } else {
                            n();
                            this.f١١٥٠٩m.addAll(jVar.f١١٤٩٢j);
                        }
                        onChanged();
                    }
                } else if (!jVar.f١١٤٩٢j.isEmpty()) {
                    if (this.f١١٥١٠n.u()) {
                        this.f١١٥١٠n.i();
                        this.f١١٥١٠n = null;
                        this.f١١٥٠٩m = jVar.f١١٤٩٢j;
                        this.f١١٤٩٧a &= -257;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var4 = y();
                        }
                        this.f١١٥١٠n = x1Var4;
                    } else {
                        this.f١١٥١٠n.b(jVar.f١١٤٩٢j);
                    }
                }
                if (jVar.k0()) {
                    P(jVar.X());
                }
                if (jVar.m0()) {
                    Q(jVar.f0());
                }
                if (jVar.n0()) {
                    this.f١١٥١٥s = jVar.f١١٤٩٥m;
                    this.f١١٤٩٧a |= 2048;
                    onChanged();
                }
                mergeUnknownFields(jVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: O, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof j) {
                    return N((j) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b P(k kVar) {
                k kVar2;
                b2 b2Var = this.f١١٥١٢p;
                if (b2Var == null) {
                    if ((this.f١١٤٩٧a & 512) != 0 && (kVar2 = this.f١١٥١١o) != null && kVar2 != k.c0()) {
                        D().y(kVar);
                    } else {
                        this.f١١٥١١o = kVar;
                    }
                } else {
                    b2Var.g(kVar);
                }
                this.f١١٤٩٧a |= 512;
                onChanged();
                return this;
            }

            public b Q(s sVar) {
                s sVar2;
                b2 b2Var = this.f١١٥١٤r;
                if (b2Var == null) {
                    if ((this.f١١٤٩٧a & 1024) != 0 && (sVar2 = this.f١١٥١٣q) != null && sVar2 != s.o()) {
                        J().o(sVar);
                    } else {
                        this.f١١٥١٣q = sVar;
                    }
                } else {
                    b2Var.g(sVar);
                }
                this.f١١٤٩٧a |= 1024;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: R, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: S, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            public b T(String str) {
                str.getClass();
                this.f١١٤٩٨b = str;
                this.f١١٤٩٧a |= 1;
                onChanged();
                return this;
            }

            public b U(String str) {
                str.getClass();
                this.f١١٤٩٩c = str;
                this.f١١٤٩٧a |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: V, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            public b e(b bVar) {
                x1 x1Var = this.f١١٥٠٤h;
                if (x1Var == null) {
                    bVar.getClass();
                    o();
                    this.f١١٥٠٣g.add(bVar);
                    onChanged();
                } else {
                    x1Var.f(bVar);
                }
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public j build() {
                j buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٤١c;
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public j buildPartial() {
                j jVar = new j(this);
                j(jVar);
                if (this.f١١٤٩٧a != 0) {
                    i(jVar);
                }
                onBuilt();
                return jVar;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٤٣d.d(j.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < A(); i10++) {
                    if (!z(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < u(); i11++) {
                    if (!t(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < G(); i12++) {
                    if (!F(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < x(); i13++) {
                    if (!w(i13).isInitialized()) {
                        return false;
                    }
                }
                if (L() && !C().isInitialized()) {
                    return false;
                }
                return true;
            }

            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public j getDefaultInstanceForType() {
                return j.J();
            }

            public c t(int i10) {
                x1 x1Var = this.f١١٥٠٦j;
                if (x1Var == null) {
                    return (c) this.f١١٥٠٥i.get(i10);
                }
                return (c) x1Var.o(i10);
            }

            public int u() {
                x1 x1Var = this.f١١٥٠٦j;
                if (x1Var == null) {
                    return this.f١١٥٠٥i.size();
                }
                return x1Var.n();
            }

            public h w(int i10) {
                x1 x1Var = this.f١١٥١٠n;
                if (x1Var == null) {
                    return (h) this.f١١٥٠٩m.get(i10);
                }
                return (h) x1Var.o(i10);
            }

            public int x() {
                x1 x1Var = this.f١١٥١٠n;
                if (x1Var == null) {
                    return this.f١١٥٠٩m.size();
                }
                return x1Var.n();
            }

            public b z(int i10) {
                x1 x1Var = this.f١١٥٠٤h;
                if (x1Var == null) {
                    return (b) this.f١١٥٠٣g.get(i10);
                }
                return (b) x1Var.o(i10);
            }

            private b() {
                this.f١١٤٩٨b = "";
                this.f١١٤٩٩c = "";
                this.f١١٥٠٠d = o0.f١١٨٥٤d;
                this.f١١٥٠١e = h0.emptyIntList();
                this.f١١٥٠٢f = h0.emptyIntList();
                this.f١١٥٠٣g = Collections.emptyList();
                this.f١١٥٠٥i = Collections.emptyList();
                this.f١١٥٠٧k = Collections.emptyList();
                this.f١١٥٠٩m = Collections.emptyList();
                this.f١١٥١٥s = "";
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٤٩٨b = "";
                this.f١١٤٩٩c = "";
                this.f١١٥٠٠d = o0.f١١٨٥٤d;
                this.f١١٥٠١e = h0.emptyIntList();
                this.f١١٥٠٢f = h0.emptyIntList();
                this.f١١٥٠٣g = Collections.emptyList();
                this.f١١٥٠٥i = Collections.emptyList();
                this.f١١٥٠٧k = Collections.emptyList();
                this.f١١٥٠٩m = Collections.emptyList();
                this.f١١٥١٥s = "";
                maybeForceBuilderInitialization();
            }
        }

        private j(h0.b bVar) {
            super(bVar);
            this.f١١٤٨٤b = "";
            this.f١١٤٨٥c = "";
            this.f١١٤٩٥m = "";
            this.f١١٤٩٦n = (byte) -1;
        }

        private j() {
            this.f١١٤٨٤b = "";
            this.f١١٤٨٥c = "";
            this.f١١٤٩٥m = "";
            this.f١١٤٩٦n = (byte) -1;
            this.f١١٤٨٤b = "";
            this.f١١٤٨٥c = "";
            this.f١١٤٨٦d = o0.f١١٨٥٤d;
            this.f١١٤٨٧e = h0.emptyIntList();
            this.f١١٤٨٨f = h0.emptyIntList();
            this.f١١٤٨٩g = Collections.emptyList();
            this.f١١٤٩٠h = Collections.emptyList();
            this.f١١٤٩١i = Collections.emptyList();
            this.f١١٤٩٢j = Collections.emptyList();
            this.f١١٤٩٥m = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class k extends h0.e implements g1 {
        private static final long serialVersionUID = 0;

        /* renamed from: y, reason: collision with root package name */
        private static final k f١١٥١٦y = new k();

        /* renamed from: z, reason: collision with root package name */
        public static final r1 f١١٥١٧z = new a();

        /* renamed from: b, reason: collision with root package name */
        private int f١١٥١٨b;

        /* renamed from: c, reason: collision with root package name */
        private volatile Object f١١٥١٩c;

        /* renamed from: d, reason: collision with root package name */
        private volatile Object f١١٥٢٠d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١١٥٢١e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f١١٥٢٢f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١١٥٢٣g;

        /* renamed from: h, reason: collision with root package name */
        private int f١١٥٢٤h;

        /* renamed from: i, reason: collision with root package name */
        private volatile Object f١١٥٢٥i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f١١٥٢٦j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f١١٥٢٧k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f١١٥٢٨l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f١١٥٢٩m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f١١٥٣٠n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f١١٥٣١o;

        /* renamed from: p, reason: collision with root package name */
        private volatile Object f١١٥٣٢p;

        /* renamed from: q, reason: collision with root package name */
        private volatile Object f١١٥٣٣q;

        /* renamed from: r, reason: collision with root package name */
        private volatile Object f١١٥٣٤r;

        /* renamed from: s, reason: collision with root package name */
        private volatile Object f١١٥٣٥s;

        /* renamed from: t, reason: collision with root package name */
        private volatile Object f١١٥٣٦t;

        /* renamed from: u, reason: collision with root package name */
        private volatile Object f١١٥٣٧u;

        /* renamed from: v, reason: collision with root package name */
        private volatile Object f١١٥٣٨v;

        /* renamed from: w, reason: collision with root package name */
        private List f١١٥٣٩w;

        /* renamed from: x, reason: collision with root package name */
        private byte f١١٥٤٠x;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public k parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b S0 = k.S0();
                try {
                    S0.mergeFrom(iVar, vVar);
                    return S0.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(S0.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(S0.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(S0.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum c implements j0.c {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);


            /* renamed from: e, reason: collision with root package name */
            private static final j0.d f١١٥٦٧e = new a();

            /* renamed from: f, reason: collision with root package name */
            private static final c[] f١١٥٦٨f = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٥٧٠a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            c(int i10) {
                this.f١١٥٧٠a = i10;
            }

            public static c c(int i10) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return LITE_RUNTIME;
                    }
                    return CODE_SIZE;
                }
                return SPEED;
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٥٧٠a;
            }
        }

        public static b S0() {
            return f١١٥١٦y.toBuilder();
        }

        static /* synthetic */ int Y(k kVar, int i10) {
            int i11 = i10 | kVar.f١١٥١٨b;
            kVar.f١١٥١٨b = i11;
            return i11;
        }

        public static k c0() {
            return f١١٥١٦y;
        }

        public static final n.b getDescriptor() {
            return m.A;
        }

        public boolean A0() {
            if ((this.f١١٥١٨b & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0) {
                return true;
            }
            return false;
        }

        public boolean B0() {
            if ((this.f١١٥١٨b & 2048) != 0) {
                return true;
            }
            return false;
        }

        public boolean C0() {
            if ((this.f١١٥١٨b & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean D0() {
            if ((this.f١١٥١٨b & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean E0() {
            if ((this.f١١٥١٨b & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean F0() {
            if ((this.f١١٥١٨b & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean G0() {
            if ((this.f١١٥١٨b & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean H0() {
            if ((this.f١١٥١٨b & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean I0() {
            if ((this.f١١٥١٨b & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean J0() {
            if ((this.f١١٥١٨b & 8192) != 0) {
                return true;
            }
            return false;
        }

        public boolean K0() {
            if ((this.f١١٥١٨b & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean L0() {
            if ((this.f١١٥١٨b & 65536) != 0) {
                return true;
            }
            return false;
        }

        public boolean M0() {
            if ((this.f١١٥١٨b & 1024) != 0) {
                return true;
            }
            return false;
        }

        public boolean N0() {
            if ((this.f١١٥١٨b & 262144) != 0) {
                return true;
            }
            return false;
        }

        public boolean O0() {
            if ((this.f١١٥١٨b & anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH) != 0) {
                return true;
            }
            return false;
        }

        public boolean P0() {
            if ((this.f١١٥١٨b & 512) != 0) {
                return true;
            }
            return false;
        }

        public boolean Q0() {
            if ((this.f١١٥١٨b & anet.channel.bytes.a.MAX_POOL_SIZE) != 0) {
                return true;
            }
            return false;
        }

        public boolean R0() {
            if ((this.f١١٥١٨b & 32768) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: T0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return S0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: U0, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: V0, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٥١٦y) {
                return new b();
            }
            return new b().y(this);
        }

        public boolean Z() {
            return this.f١١٥٣١o;
        }

        public boolean a0() {
            return this.f١١٥٢٦j;
        }

        public String b0() {
            Object obj = this.f١١٥٣٣q;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٣q = C;
            }
            return C;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public k getDefaultInstanceForType() {
            return f١١٥١٦y;
        }

        public boolean e0() {
            return this.f١١٥٣٠n;
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof k)) {
                return super.equals(obj);
            }
            k kVar = (k) obj;
            if (H0() != kVar.H0()) {
                return false;
            }
            if ((H0() && !k0().equals(kVar.k0())) || G0() != kVar.G0()) {
                return false;
            }
            if ((G0() && !j0().equals(kVar.j0())) || F0() != kVar.F0()) {
                return false;
            }
            if ((F0() && i0() != kVar.i0()) || D0() != kVar.D0()) {
                return false;
            }
            if ((D0() && g0() != kVar.g0()) || I0() != kVar.I0()) {
                return false;
            }
            if ((I0() && l0() != kVar.l0()) || K0() != kVar.K0()) {
                return false;
            }
            if ((K0() && this.f١١٥٢٤h != kVar.f١١٥٢٤h) || C0() != kVar.C0()) {
                return false;
            }
            if ((C0() && !f0().equals(kVar.f0())) || z0() != kVar.z0()) {
                return false;
            }
            if ((z0() && a0() != kVar.a0()) || E0() != kVar.E0()) {
                return false;
            }
            if ((E0() && h0() != kVar.h0()) || P0() != kVar.P0()) {
                return false;
            }
            if ((P0() && s0() != kVar.s0()) || M0() != kVar.M0()) {
                return false;
            }
            if ((M0() && p0() != kVar.p0()) || B0() != kVar.B0()) {
                return false;
            }
            if ((B0() && e0() != kVar.e0()) || y0() != kVar.y0()) {
                return false;
            }
            if ((y0() && Z() != kVar.Z()) || J0() != kVar.J0()) {
                return false;
            }
            if ((J0() && !m0().equals(kVar.m0())) || A0() != kVar.A0()) {
                return false;
            }
            if ((A0() && !b0().equals(kVar.b0())) || R0() != kVar.R0()) {
                return false;
            }
            if ((R0() && !u0().equals(kVar.u0())) || L0() != kVar.L0()) {
                return false;
            }
            if ((L0() && !o0().equals(kVar.o0())) || O0() != kVar.O0()) {
                return false;
            }
            if ((O0() && !r0().equals(kVar.r0())) || N0() != kVar.N0()) {
                return false;
            }
            if ((N0() && !q0().equals(kVar.q0())) || Q0() != kVar.Q0()) {
                return false;
            }
            if ((!Q0() || t0().equals(kVar.t0())) && x0().equals(kVar.x0()) && getUnknownFields().equals(kVar.getUnknownFields()) && p().equals(kVar.p())) {
                return true;
            }
            return false;
        }

        public String f0() {
            Object obj = this.f١١٥٢٥i;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٢٥i = C;
            }
            return C;
        }

        public boolean g0() {
            return this.f١١٥٢٢f;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٥١٨b & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٥١٩c);
            } else {
                i10 = 0;
            }
            if ((this.f١١٥١٨b & 2) != 0) {
                i10 += h0.computeStringSize(8, this.f١١٥٢٠d);
            }
            if ((this.f١١٥١٨b & 32) != 0) {
                i10 += com.google.protobuf.k.l(9, this.f١١٥٢٤h);
            }
            if ((this.f١١٥١٨b & 4) != 0) {
                i10 += com.google.protobuf.k.e(10, this.f١١٥٢١e);
            }
            if ((this.f١١٥١٨b & 64) != 0) {
                i10 += h0.computeStringSize(11, this.f١١٥٢٥i);
            }
            if ((this.f١١٥١٨b & 128) != 0) {
                i10 += com.google.protobuf.k.e(16, this.f١١٥٢٦j);
            }
            if ((this.f١١٥١٨b & 256) != 0) {
                i10 += com.google.protobuf.k.e(17, this.f١١٥٢٧k);
            }
            if ((this.f١١٥١٨b & 512) != 0) {
                i10 += com.google.protobuf.k.e(18, this.f١١٥٢٨l);
            }
            if ((this.f١١٥١٨b & 8) != 0) {
                i10 += com.google.protobuf.k.e(20, this.f١١٥٢٢f);
            }
            if ((this.f١١٥١٨b & 2048) != 0) {
                i10 += com.google.protobuf.k.e(23, this.f١١٥٣٠n);
            }
            if ((this.f١١٥١٨b & 16) != 0) {
                i10 += com.google.protobuf.k.e(27, this.f١١٥٢٣g);
            }
            if ((this.f١١٥١٨b & 4096) != 0) {
                i10 += com.google.protobuf.k.e(31, this.f١١٥٣١o);
            }
            if ((this.f١١٥١٨b & 8192) != 0) {
                i10 += h0.computeStringSize(36, this.f١١٥٣٢p);
            }
            if ((this.f١١٥١٨b & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0) {
                i10 += h0.computeStringSize(37, this.f١١٥٣٣q);
            }
            if ((this.f١١٥١٨b & 32768) != 0) {
                i10 += h0.computeStringSize(39, this.f١١٥٣٤r);
            }
            if ((this.f١١٥١٨b & 65536) != 0) {
                i10 += h0.computeStringSize(40, this.f١١٥٣٥s);
            }
            if ((this.f١١٥١٨b & anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH) != 0) {
                i10 += h0.computeStringSize(41, this.f١١٥٣٦t);
            }
            if ((this.f١١٥١٨b & 1024) != 0) {
                i10 += com.google.protobuf.k.e(42, this.f١١٥٢٩m);
            }
            if ((this.f١١٥١٨b & 262144) != 0) {
                i10 += h0.computeStringSize(44, this.f١١٥٣٧u);
            }
            if ((this.f١١٥١٨b & anet.channel.bytes.a.MAX_POOL_SIZE) != 0) {
                i10 += h0.computeStringSize(45, this.f١١٥٣٨v);
            }
            for (int i12 = 0; i12 < this.f١١٥٣٩w.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٥٣٩w.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        public boolean h0() {
            return this.f١١٥٢٧k;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (H0()) {
                hashCode = (((hashCode * 37) + 1) * 53) + k0().hashCode();
            }
            if (G0()) {
                hashCode = (((hashCode * 37) + 8) * 53) + j0().hashCode();
            }
            if (F0()) {
                hashCode = (((hashCode * 37) + 10) * 53) + j0.c(i0());
            }
            if (D0()) {
                hashCode = (((hashCode * 37) + 20) * 53) + j0.c(g0());
            }
            if (I0()) {
                hashCode = (((hashCode * 37) + 27) * 53) + j0.c(l0());
            }
            if (K0()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.f١١٥٢٤h;
            }
            if (C0()) {
                hashCode = (((hashCode * 37) + 11) * 53) + f0().hashCode();
            }
            if (z0()) {
                hashCode = (((hashCode * 37) + 16) * 53) + j0.c(a0());
            }
            if (E0()) {
                hashCode = (((hashCode * 37) + 17) * 53) + j0.c(h0());
            }
            if (P0()) {
                hashCode = (((hashCode * 37) + 18) * 53) + j0.c(s0());
            }
            if (M0()) {
                hashCode = (((hashCode * 37) + 42) * 53) + j0.c(p0());
            }
            if (B0()) {
                hashCode = (((hashCode * 37) + 23) * 53) + j0.c(e0());
            }
            if (y0()) {
                hashCode = (((hashCode * 37) + 31) * 53) + j0.c(Z());
            }
            if (J0()) {
                hashCode = (((hashCode * 37) + 36) * 53) + m0().hashCode();
            }
            if (A0()) {
                hashCode = (((hashCode * 37) + 37) * 53) + b0().hashCode();
            }
            if (R0()) {
                hashCode = (((hashCode * 37) + 39) * 53) + u0().hashCode();
            }
            if (L0()) {
                hashCode = (((hashCode * 37) + 40) * 53) + o0().hashCode();
            }
            if (O0()) {
                hashCode = (((hashCode * 37) + 41) * 53) + r0().hashCode();
            }
            if (N0()) {
                hashCode = (((hashCode * 37) + 44) * 53) + q0().hashCode();
            }
            if (Q0()) {
                hashCode = (((hashCode * 37) + 45) * 53) + t0().hashCode();
            }
            if (w0() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + x0().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        public boolean i0() {
            return this.f١١٥٢١e;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٣٦B.d(k.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٥٤٠x;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < w0(); i10++) {
                if (!v0(i10).isInitialized()) {
                    this.f١١٥٤٠x = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٥٤٠x = (byte) 0;
                return false;
            }
            this.f١١٥٤٠x = (byte) 1;
            return true;
        }

        public String j0() {
            Object obj = this.f١١٥٢٠d;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٢٠d = C;
            }
            return C;
        }

        public String k0() {
            Object obj = this.f١١٥١٩c;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥١٩c = C;
            }
            return C;
        }

        public boolean l0() {
            return this.f١١٥٢٣g;
        }

        public String m0() {
            Object obj = this.f١١٥٣٢p;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٢p = C;
            }
            return C;
        }

        public c n0() {
            c c10 = c.c(this.f١١٥٢٤h);
            if (c10 == null) {
                return c.SPEED;
            }
            return c10;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new k();
        }

        public String o0() {
            Object obj = this.f١١٥٣٥s;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٥s = C;
            }
            return C;
        }

        public boolean p0() {
            return this.f١١٥٢٩m;
        }

        public String q0() {
            Object obj = this.f١١٥٣٧u;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٧u = C;
            }
            return C;
        }

        public String r0() {
            Object obj = this.f١١٥٣٦t;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٦t = C;
            }
            return C;
        }

        public boolean s0() {
            return this.f١١٥٢٨l;
        }

        public String t0() {
            Object obj = this.f١١٥٣٨v;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٨v = C;
            }
            return C;
        }

        public String u0() {
            Object obj = this.f١١٥٣٤r;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٣٤r = C;
            }
            return C;
        }

        public t v0(int i10) {
            return (t) this.f١١٥٣٩w.get(i10);
        }

        public int w0() {
            return this.f١١٥٣٩w.size();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٥١٨b & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٥١٩c);
            }
            if ((this.f١١٥١٨b & 2) != 0) {
                h0.writeString(kVar, 8, this.f١١٥٢٠d);
            }
            if ((this.f١١٥١٨b & 32) != 0) {
                kVar.t0(9, this.f١١٥٢٤h);
            }
            if ((this.f١١٥١٨b & 4) != 0) {
                kVar.l0(10, this.f١١٥٢١e);
            }
            if ((this.f١١٥١٨b & 64) != 0) {
                h0.writeString(kVar, 11, this.f١١٥٢٥i);
            }
            if ((this.f١١٥١٨b & 128) != 0) {
                kVar.l0(16, this.f١١٥٢٦j);
            }
            if ((this.f١١٥١٨b & 256) != 0) {
                kVar.l0(17, this.f١١٥٢٧k);
            }
            if ((this.f١١٥١٨b & 512) != 0) {
                kVar.l0(18, this.f١١٥٢٨l);
            }
            if ((this.f١١٥١٨b & 8) != 0) {
                kVar.l0(20, this.f١١٥٢٢f);
            }
            if ((this.f١١٥١٨b & 2048) != 0) {
                kVar.l0(23, this.f١١٥٣٠n);
            }
            if ((this.f١١٥١٨b & 16) != 0) {
                kVar.l0(27, this.f١١٥٢٣g);
            }
            if ((this.f١١٥١٨b & 4096) != 0) {
                kVar.l0(31, this.f١١٥٣١o);
            }
            if ((this.f١١٥١٨b & 8192) != 0) {
                h0.writeString(kVar, 36, this.f١١٥٣٢p);
            }
            if ((this.f١١٥١٨b & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0) {
                h0.writeString(kVar, 37, this.f١١٥٣٣q);
            }
            if ((this.f١١٥١٨b & 32768) != 0) {
                h0.writeString(kVar, 39, this.f١١٥٣٤r);
            }
            if ((this.f١١٥١٨b & 65536) != 0) {
                h0.writeString(kVar, 40, this.f١١٥٣٥s);
            }
            if ((this.f١١٥١٨b & anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH) != 0) {
                h0.writeString(kVar, 41, this.f١١٥٣٦t);
            }
            if ((this.f١١٥١٨b & 1024) != 0) {
                kVar.l0(42, this.f١١٥٢٩m);
            }
            if ((this.f١١٥١٨b & 262144) != 0) {
                h0.writeString(kVar, 44, this.f١١٥٣٧u);
            }
            if ((this.f١١٥١٨b & anet.channel.bytes.a.MAX_POOL_SIZE) != 0) {
                h0.writeString(kVar, 45, this.f١١٥٣٨v);
            }
            for (int i10 = 0; i10 < this.f١١٥٣٩w.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٥٣٩w.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        public List x0() {
            return this.f١١٥٣٩w;
        }

        public boolean y0() {
            if ((this.f١١٥١٨b & 4096) != 0) {
                return true;
            }
            return false;
        }

        public boolean z0() {
            if ((this.f١١٥١٨b & 128) != 0) {
                return true;
            }
            return false;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٥٤١b;

            /* renamed from: c, reason: collision with root package name */
            private Object f١١٥٤٢c;

            /* renamed from: d, reason: collision with root package name */
            private Object f١١٥٤٣d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f١١٥٤٤e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f١١٥٤٥f;

            /* renamed from: g, reason: collision with root package name */
            private boolean f١١٥٤٦g;

            /* renamed from: h, reason: collision with root package name */
            private int f١١٥٤٧h;

            /* renamed from: i, reason: collision with root package name */
            private Object f١١٥٤٨i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f١١٥٤٩j;

            /* renamed from: k, reason: collision with root package name */
            private boolean f١١٥٥٠k;

            /* renamed from: l, reason: collision with root package name */
            private boolean f١١٥٥١l;

            /* renamed from: m, reason: collision with root package name */
            private boolean f١١٥٥٢m;

            /* renamed from: n, reason: collision with root package name */
            private boolean f١١٥٥٣n;

            /* renamed from: o, reason: collision with root package name */
            private boolean f١١٥٥٤o;

            /* renamed from: p, reason: collision with root package name */
            private Object f١١٥٥٥p;

            /* renamed from: q, reason: collision with root package name */
            private Object f١١٥٥٦q;

            /* renamed from: r, reason: collision with root package name */
            private Object f١١٥٥٧r;

            /* renamed from: s, reason: collision with root package name */
            private Object f١١٥٥٨s;

            /* renamed from: t, reason: collision with root package name */
            private Object f١١٥٥٩t;

            /* renamed from: u, reason: collision with root package name */
            private Object f١١٥٦٠u;

            /* renamed from: v, reason: collision with root package name */
            private Object f١١٥٦١v;

            /* renamed from: w, reason: collision with root package name */
            private List f١١٥٦٢w;

            /* renamed from: x, reason: collision with root package name */
            private x1 f١١٥٦٣x;

            private void p(k kVar) {
                int i10;
                int i11 = this.f١١٥٤١b;
                if ((i11 & 1) != 0) {
                    kVar.f١١٥١٩c = this.f١١٥٤٢c;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    kVar.f١١٥٢٠d = this.f١١٥٤٣d;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    kVar.f١١٥٢١e = this.f١١٥٤٤e;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    kVar.f١١٥٢٢f = this.f١١٥٤٥f;
                    i10 |= 8;
                }
                if ((i11 & 16) != 0) {
                    kVar.f١١٥٢٣g = this.f١١٥٤٦g;
                    i10 |= 16;
                }
                if ((i11 & 32) != 0) {
                    kVar.f١١٥٢٤h = this.f١١٥٤٧h;
                    i10 |= 32;
                }
                if ((i11 & 64) != 0) {
                    kVar.f١١٥٢٥i = this.f١١٥٤٨i;
                    i10 |= 64;
                }
                if ((i11 & 128) != 0) {
                    kVar.f١١٥٢٦j = this.f١١٥٤٩j;
                    i10 |= 128;
                }
                if ((i11 & 256) != 0) {
                    kVar.f١١٥٢٧k = this.f١١٥٥٠k;
                    i10 |= 256;
                }
                if ((i11 & 512) != 0) {
                    kVar.f١١٥٢٨l = this.f١١٥٥١l;
                    i10 |= 512;
                }
                if ((i11 & 1024) != 0) {
                    kVar.f١١٥٢٩m = this.f١١٥٥٢m;
                    i10 |= 1024;
                }
                if ((i11 & 2048) != 0) {
                    kVar.f١١٥٣٠n = this.f١١٥٥٣n;
                    i10 |= 2048;
                }
                if ((i11 & 4096) != 0) {
                    kVar.f١١٥٣١o = this.f١١٥٥٤o;
                    i10 |= 4096;
                }
                if ((i11 & 8192) != 0) {
                    kVar.f١١٥٣٢p = this.f١١٥٥٥p;
                    i10 |= 8192;
                }
                if ((i11 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0) {
                    kVar.f١١٥٣٣q = this.f١١٥٥٦q;
                    i10 |= DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE;
                }
                if ((i11 & 32768) != 0) {
                    kVar.f١١٥٣٤r = this.f١١٥٥٧r;
                    i10 |= 32768;
                }
                if ((i11 & 65536) != 0) {
                    kVar.f١١٥٣٥s = this.f١١٥٥٨s;
                    i10 |= 65536;
                }
                if ((i11 & anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH) != 0) {
                    kVar.f١١٥٣٦t = this.f١١٥٥٩t;
                    i10 |= anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH;
                }
                if ((i11 & 262144) != 0) {
                    kVar.f١١٥٣٧u = this.f١١٥٦٠u;
                    i10 |= 262144;
                }
                if ((i11 & anet.channel.bytes.a.MAX_POOL_SIZE) != 0) {
                    kVar.f١١٥٣٨v = this.f١١٥٦١v;
                    i10 |= anet.channel.bytes.a.MAX_POOL_SIZE;
                }
                k.Y(kVar, i10);
            }

            private void q(k kVar) {
                x1 x1Var = this.f١١٥٦٣x;
                if (x1Var != null) {
                    kVar.f١١٥٣٩w = x1Var.g();
                    return;
                }
                if ((this.f١١٥٤١b & Constants.MB) != 0) {
                    this.f١١٥٦٢w = Collections.unmodifiableList(this.f١١٥٦٢w);
                    this.f١١٥٤١b &= -1048577;
                }
                kVar.f١١٥٣٩w = this.f١١٥٦٢w;
            }

            private void s() {
                if ((this.f١١٥٤١b & Constants.MB) == 0) {
                    this.f١١٥٦٢w = new ArrayList(this.f١١٥٦٢w);
                    this.f١١٥٤١b |= Constants.MB;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٥٦٣x == null) {
                    List list = this.f١١٥٦٢w;
                    if ((this.f١١٥٤١b & Constants.MB) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥٦٣x = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٦٢w = null;
                }
                return this.f١١٥٦٣x;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٥٥٤o = z10;
                this.f١١٥٤١b |= 4096;
                onChanged();
                return this;
            }

            public b C(boolean z10) {
                this.f١١٥٤٩j = z10;
                this.f١١٥٤١b |= 128;
                onChanged();
                return this;
            }

            public b D(boolean z10) {
                this.f١١٥٥٣n = z10;
                this.f١١٥٤١b |= 2048;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            public b F(boolean z10) {
                this.f١١٥٤٥f = z10;
                this.f١١٥٤١b |= 8;
                onChanged();
                return this;
            }

            public b G(boolean z10) {
                this.f١١٥٥٠k = z10;
                this.f١١٥٤١b |= 256;
                onChanged();
                return this;
            }

            public b H(boolean z10) {
                this.f١١٥٤٤e = z10;
                this.f١١٥٤١b |= 4;
                onChanged();
                return this;
            }

            public b I(boolean z10) {
                this.f١١٥٤٦g = z10;
                this.f١١٥٤١b |= 16;
                onChanged();
                return this;
            }

            public b J(c cVar) {
                cVar.getClass();
                this.f١١٥٤١b |= 32;
                this.f١١٥٤٧h = cVar.getNumber();
                onChanged();
                return this;
            }

            public b K(boolean z10) {
                this.f١١٥٥٢m = z10;
                this.f١١٥٤١b |= 1024;
                onChanged();
                return this;
            }

            public b L(boolean z10) {
                this.f١١٥٥١l = z10;
                this.f١١٥٤١b |= 512;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.A;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٣٦B.d(k.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public k build() {
                k buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public k buildPartial() {
                k kVar = new k(this);
                q(kVar);
                if (this.f١١٥٤١b != 0) {
                    p(kVar);
                }
                onBuilt();
                return kVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public k getDefaultInstanceForType() {
                return k.c0();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٥٦٣x;
                if (x1Var == null) {
                    return (t) this.f١١٥٦٢w.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٥٦٣x;
                if (x1Var == null) {
                    return this.f١١٥٦٢w.size();
                }
                return x1Var.n();
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.f١١٥٤٢c = iVar.r();
                                    this.f١١٥٤١b |= 1;
                                case 66:
                                    this.f١١٥٤٣d = iVar.r();
                                    this.f١١٥٤١b |= 2;
                                case 72:
                                    int t10 = iVar.t();
                                    if (c.c(t10) == null) {
                                        mergeUnknownVarintField(9, t10);
                                    } else {
                                        this.f١١٥٤٧h = t10;
                                        this.f١١٥٤١b |= 32;
                                    }
                                case 80:
                                    this.f١١٥٤٤e = iVar.q();
                                    this.f١١٥٤١b |= 4;
                                case 90:
                                    this.f١١٥٤٨i = iVar.r();
                                    this.f١١٥٤١b |= 64;
                                case 128:
                                    this.f١١٥٤٩j = iVar.q();
                                    this.f١١٥٤١b |= 128;
                                case 136:
                                    this.f١١٥٥٠k = iVar.q();
                                    this.f١١٥٤١b |= 256;
                                case 144:
                                    this.f١١٥٥١l = iVar.q();
                                    this.f١١٥٤١b |= 512;
                                case io.agora.rtc.Constants.ERR_ALREADY_IN_RECORDING /* 160 */:
                                    this.f١١٥٤٥f = iVar.q();
                                    this.f١١٥٤١b |= 8;
                                case 184:
                                    this.f١١٥٥٣n = iVar.q();
                                    this.f١١٥٤١b |= 2048;
                                case 216:
                                    this.f١١٥٤٦g = iVar.q();
                                    this.f١١٥٤١b |= 16;
                                case 248:
                                    this.f١١٥٥٤o = iVar.q();
                                    this.f١١٥٤١b |= 4096;
                                case 290:
                                    this.f١١٥٥٥p = iVar.r();
                                    this.f١١٥٤١b |= 8192;
                                case 298:
                                    this.f١١٥٥٦q = iVar.r();
                                    this.f١١٥٤١b |= DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE;
                                case 314:
                                    this.f١١٥٥٧r = iVar.r();
                                    this.f١١٥٤١b |= 32768;
                                case 322:
                                    this.f١١٥٥٨s = iVar.r();
                                    this.f١١٥٤١b |= 65536;
                                case 330:
                                    this.f١١٥٥٩t = iVar.r();
                                    this.f١١٥٤١b |= anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH;
                                case 336:
                                    this.f١١٥٥٢m = iVar.q();
                                    this.f١١٥٤١b |= 1024;
                                case 354:
                                    this.f١١٥٦٠u = iVar.r();
                                    this.f١١٥٤١b |= 262144;
                                case 362:
                                    this.f١١٥٦١v = iVar.r();
                                    this.f١١٥٤١b |= anet.channel.bytes.a.MAX_POOL_SIZE;
                                case 7994:
                                    t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                    x1 x1Var = this.f١١٥٦٣x;
                                    if (x1Var == null) {
                                        s();
                                        this.f١١٥٦٢w.add(tVar);
                                    } else {
                                        x1Var.f(tVar);
                                    }
                                default:
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                        z10 = true;
                                    }
                            }
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(k kVar) {
                if (kVar == k.c0()) {
                    return this;
                }
                if (kVar.H0()) {
                    this.f١١٥٤٢c = kVar.f١١٥١٩c;
                    this.f١١٥٤١b |= 1;
                    onChanged();
                }
                if (kVar.G0()) {
                    this.f١١٥٤٣d = kVar.f١١٥٢٠d;
                    this.f١١٥٤١b |= 2;
                    onChanged();
                }
                if (kVar.F0()) {
                    H(kVar.i0());
                }
                if (kVar.D0()) {
                    F(kVar.g0());
                }
                if (kVar.I0()) {
                    I(kVar.l0());
                }
                if (kVar.K0()) {
                    J(kVar.n0());
                }
                if (kVar.C0()) {
                    this.f١١٥٤٨i = kVar.f١١٥٢٥i;
                    this.f١١٥٤١b |= 64;
                    onChanged();
                }
                if (kVar.z0()) {
                    C(kVar.a0());
                }
                if (kVar.E0()) {
                    G(kVar.h0());
                }
                if (kVar.P0()) {
                    L(kVar.s0());
                }
                if (kVar.M0()) {
                    K(kVar.p0());
                }
                if (kVar.B0()) {
                    D(kVar.e0());
                }
                if (kVar.y0()) {
                    B(kVar.Z());
                }
                if (kVar.J0()) {
                    this.f١١٥٥٥p = kVar.f١١٥٣٢p;
                    this.f١١٥٤١b |= 8192;
                    onChanged();
                }
                if (kVar.A0()) {
                    this.f١١٥٥٦q = kVar.f١١٥٣٣q;
                    this.f١١٥٤١b |= DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE;
                    onChanged();
                }
                if (kVar.R0()) {
                    this.f١١٥٥٧r = kVar.f١١٥٣٤r;
                    this.f١١٥٤١b |= 32768;
                    onChanged();
                }
                if (kVar.L0()) {
                    this.f١١٥٥٨s = kVar.f١١٥٣٥s;
                    this.f١١٥٤١b |= 65536;
                    onChanged();
                }
                if (kVar.O0()) {
                    this.f١١٥٥٩t = kVar.f١١٥٣٦t;
                    this.f١١٥٤١b |= anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH;
                    onChanged();
                }
                if (kVar.N0()) {
                    this.f١١٥٦٠u = kVar.f١١٥٣٧u;
                    this.f١١٥٤١b |= 262144;
                    onChanged();
                }
                if (kVar.Q0()) {
                    this.f١١٥٦١v = kVar.f١١٥٣٨v;
                    this.f١١٥٤١b |= anet.channel.bytes.a.MAX_POOL_SIZE;
                    onChanged();
                }
                if (this.f١١٥٦٣x == null) {
                    if (!kVar.f١١٥٣٩w.isEmpty()) {
                        if (this.f١١٥٦٢w.isEmpty()) {
                            this.f١١٥٦٢w = kVar.f١١٥٣٩w;
                            this.f١١٥٤١b &= -1048577;
                        } else {
                            s();
                            this.f١١٥٦٢w.addAll(kVar.f١١٥٣٩w);
                        }
                        onChanged();
                    }
                } else if (!kVar.f١١٥٣٩w.isEmpty()) {
                    if (this.f١١٥٦٣x.u()) {
                        this.f١١٥٦٣x.i();
                        x1 x1Var = null;
                        this.f١١٥٦٣x = null;
                        this.f١١٥٦٢w = kVar.f١١٥٣٩w;
                        this.f١١٥٤١b = (-1048577) & this.f١١٥٤١b;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٥٦٣x = x1Var;
                    } else {
                        this.f١١٥٦٣x.b(kVar.f١١٥٣٩w);
                    }
                }
                j(kVar);
                mergeUnknownFields(kVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof k) {
                    return y((k) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٥٤٢c = "";
                this.f١١٥٤٣d = "";
                this.f١١٥٤٧h = 1;
                this.f١١٥٤٨i = "";
                this.f١١٥٥٤o = true;
                this.f١١٥٥٥p = "";
                this.f١١٥٥٦q = "";
                this.f١١٥٥٧r = "";
                this.f١١٥٥٨s = "";
                this.f١١٥٥٩t = "";
                this.f١١٥٦٠u = "";
                this.f١١٥٦١v = "";
                this.f١١٥٦٢w = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٥٤٢c = "";
                this.f١١٥٤٣d = "";
                this.f١١٥٤٧h = 1;
                this.f١١٥٤٨i = "";
                this.f١١٥٥٤o = true;
                this.f١١٥٥٥p = "";
                this.f١١٥٥٦q = "";
                this.f١١٥٥٧r = "";
                this.f١١٥٥٨s = "";
                this.f١١٥٥٩t = "";
                this.f١١٥٦٠u = "";
                this.f١١٥٦١v = "";
                this.f١١٥٦٢w = Collections.emptyList();
            }
        }

        private k(h0.d dVar) {
            super(dVar);
            this.f١١٥١٩c = "";
            this.f١١٥٢٠d = "";
            this.f١١٥٢١e = false;
            this.f١١٥٢٢f = false;
            this.f١١٥٢٣g = false;
            this.f١١٥٢٤h = 1;
            this.f١١٥٢٥i = "";
            this.f١١٥٢٦j = false;
            this.f١١٥٢٧k = false;
            this.f١١٥٢٨l = false;
            this.f١١٥٢٩m = false;
            this.f١١٥٣٠n = false;
            this.f١١٥٣١o = true;
            this.f١١٥٣٢p = "";
            this.f١١٥٣٣q = "";
            this.f١١٥٣٤r = "";
            this.f١١٥٣٥s = "";
            this.f١١٥٣٦t = "";
            this.f١١٥٣٧u = "";
            this.f١١٥٣٨v = "";
            this.f١١٥٤٠x = (byte) -1;
        }

        private k() {
            this.f١١٥١٩c = "";
            this.f١١٥٢٠d = "";
            this.f١١٥٢١e = false;
            this.f١١٥٢٢f = false;
            this.f١١٥٢٣g = false;
            this.f١١٥٢٤h = 1;
            this.f١١٥٢٥i = "";
            this.f١١٥٢٦j = false;
            this.f١١٥٢٧k = false;
            this.f١١٥٢٨l = false;
            this.f١١٥٢٩m = false;
            this.f١١٥٣٠n = false;
            this.f١١٥٣١o = true;
            this.f١١٥٣٢p = "";
            this.f١١٥٣٣q = "";
            this.f١١٥٣٤r = "";
            this.f١١٥٣٥s = "";
            this.f١١٥٣٦t = "";
            this.f١١٥٣٧u = "";
            this.f١١٥٣٨v = "";
            this.f١١٥٤٠x = (byte) -1;
            this.f١١٥١٩c = "";
            this.f١١٥٢٠d = "";
            this.f١١٥٢٤h = 1;
            this.f١١٥٢٥i = "";
            this.f١١٥٣١o = true;
            this.f١١٥٣٢p = "";
            this.f١١٥٣٣q = "";
            this.f١١٥٣٤r = "";
            this.f١١٥٣٥s = "";
            this.f١١٥٣٦t = "";
            this.f١١٥٣٧u = "";
            this.f١١٥٣٨v = "";
            this.f١١٥٣٩w = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class l extends h0.e implements g1 {

        /* renamed from: i, reason: collision with root package name */
        private static final l f١١٥٧١i = new l();

        /* renamed from: j, reason: collision with root package name */
        public static final r1 f١١٥٧٢j = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٥٧٣b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١١٥٧٤c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١١٥٧٥d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١١٥٧٦e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f١١٥٧٧f;

        /* renamed from: g, reason: collision with root package name */
        private List f١١٥٧٨g;

        /* renamed from: h, reason: collision with root package name */
        private byte f١١٥٧٩h;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public l parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b M = l.M();
                try {
                    M.mergeFrom(iVar, vVar);
                    return M.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(M.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(M.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(M.buildPartial());
                }
            }
        }

        public static b M() {
            return f١١٥٧١i.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.C;
        }

        static /* synthetic */ int y(l lVar, int i10) {
            int i11 = i10 | lVar.f١١٥٧٣b;
            lVar.f١١٥٧٣b = i11;
            return i11;
        }

        public static l z() {
            return f١١٥٧١i;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public l getDefaultInstanceForType() {
            return f١١٥٧١i;
        }

        public boolean B() {
            return this.f١١٥٧٦e;
        }

        public boolean C() {
            return this.f١١٥٧٧f;
        }

        public boolean D() {
            return this.f١١٥٧٤c;
        }

        public boolean E() {
            return this.f١١٥٧٥d;
        }

        public t F(int i10) {
            return (t) this.f١١٥٧٨g.get(i10);
        }

        public int G() {
            return this.f١١٥٧٨g.size();
        }

        public List H() {
            return this.f١١٥٧٨g;
        }

        public boolean I() {
            if ((this.f١١٥٧٣b & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean J() {
            if ((this.f١١٥٧٣b & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean K() {
            if ((this.f١١٥٧٣b & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean L() {
            if ((this.f١١٥٧٣b & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return M();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٥٧١i) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof l)) {
                return super.equals(obj);
            }
            l lVar = (l) obj;
            if (K() != lVar.K()) {
                return false;
            }
            if ((K() && D() != lVar.D()) || L() != lVar.L()) {
                return false;
            }
            if ((L() && E() != lVar.E()) || I() != lVar.I()) {
                return false;
            }
            if ((I() && B() != lVar.B()) || J() != lVar.J()) {
                return false;
            }
            if ((!J() || C() == lVar.C()) && H().equals(lVar.H()) && getUnknownFields().equals(lVar.getUnknownFields()) && p().equals(lVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٥٧٣b & 1) != 0) {
                i10 = com.google.protobuf.k.e(1, this.f١١٥٧٤c);
            } else {
                i10 = 0;
            }
            if ((this.f١١٥٧٣b & 2) != 0) {
                i10 += com.google.protobuf.k.e(2, this.f١١٥٧٥d);
            }
            if ((this.f١١٥٧٣b & 4) != 0) {
                i10 += com.google.protobuf.k.e(3, this.f١١٥٧٦e);
            }
            if ((this.f١١٥٧٣b & 8) != 0) {
                i10 += com.google.protobuf.k.e(7, this.f١١٥٧٧f);
            }
            for (int i12 = 0; i12 < this.f١١٥٧٨g.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٥٧٨g.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (K()) {
                hashCode = (((hashCode * 37) + 1) * 53) + j0.c(D());
            }
            if (L()) {
                hashCode = (((hashCode * 37) + 2) * 53) + j0.c(E());
            }
            if (I()) {
                hashCode = (((hashCode * 37) + 3) * 53) + j0.c(B());
            }
            if (J()) {
                hashCode = (((hashCode * 37) + 7) * 53) + j0.c(C());
            }
            if (G() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + H().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.D.d(l.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٥٧٩h;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < G(); i10++) {
                if (!F(i10).isInitialized()) {
                    this.f١١٥٧٩h = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٥٧٩h = (byte) 0;
                return false;
            }
            this.f١١٥٧٩h = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new l();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٥٧٣b & 1) != 0) {
                kVar.l0(1, this.f١١٥٧٤c);
            }
            if ((this.f١١٥٧٣b & 2) != 0) {
                kVar.l0(2, this.f١١٥٧٥d);
            }
            if ((this.f١١٥٧٣b & 4) != 0) {
                kVar.l0(3, this.f١١٥٧٦e);
            }
            if ((this.f١١٥٧٣b & 8) != 0) {
                kVar.l0(7, this.f١١٥٧٧f);
            }
            for (int i10 = 0; i10 < this.f١١٥٧٨g.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٥٧٨g.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٥٨٠b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٥٨١c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f١١٥٨٢d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f١١٥٨٣e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f١١٥٨٤f;

            /* renamed from: g, reason: collision with root package name */
            private List f١١٥٨٥g;

            /* renamed from: h, reason: collision with root package name */
            private x1 f١١٥٨٦h;

            private void p(l lVar) {
                int i10;
                int i11 = this.f١١٥٨٠b;
                if ((i11 & 1) != 0) {
                    lVar.f١١٥٧٤c = this.f١١٥٨١c;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    lVar.f١١٥٧٥d = this.f١١٥٨٢d;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    lVar.f١١٥٧٦e = this.f١١٥٨٣e;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    lVar.f١١٥٧٧f = this.f١١٥٨٤f;
                    i10 |= 8;
                }
                l.y(lVar, i10);
            }

            private void q(l lVar) {
                x1 x1Var = this.f١١٥٨٦h;
                if (x1Var != null) {
                    lVar.f١١٥٧٨g = x1Var.g();
                    return;
                }
                if ((this.f١١٥٨٠b & 16) != 0) {
                    this.f١١٥٨٥g = Collections.unmodifiableList(this.f١١٥٨٥g);
                    this.f١١٥٨٠b &= -17;
                }
                lVar.f١١٥٧٨g = this.f١١٥٨٥g;
            }

            private void s() {
                if ((this.f١١٥٨٠b & 16) == 0) {
                    this.f١١٥٨٥g = new ArrayList(this.f١١٥٨٥g);
                    this.f١١٥٨٠b |= 16;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٥٨٦h == null) {
                    List list = this.f١١٥٨٥g;
                    if ((this.f١١٥٨٠b & 16) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٥٨٦h = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٥٨٥g = null;
                }
                return this.f١١٥٨٦h;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٥٨٣e = z10;
                this.f١١٥٨٠b |= 4;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            public b D(boolean z10) {
                this.f١١٥٨٤f = z10;
                this.f١١٥٨٠b |= 8;
                onChanged();
                return this;
            }

            public b E(boolean z10) {
                this.f١١٥٨١c = z10;
                this.f١١٥٨٠b |= 1;
                onChanged();
                return this;
            }

            public b F(boolean z10) {
                this.f١١٥٨٢d = z10;
                this.f١١٥٨٠b |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: G, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.C;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.D.d(l.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public l build() {
                l buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public l buildPartial() {
                l lVar = new l(this);
                q(lVar);
                if (this.f١١٥٨٠b != 0) {
                    p(lVar);
                }
                onBuilt();
                return lVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public l getDefaultInstanceForType() {
                return l.z();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٥٨٦h;
                if (x1Var == null) {
                    return (t) this.f١١٥٨٥g.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٥٨٦h;
                if (x1Var == null) {
                    return this.f١١٥٨٥g.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 8) {
                                    if (K != 16) {
                                        if (K != 24) {
                                            if (K != 56) {
                                                if (K != 7994) {
                                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                                    }
                                                } else {
                                                    t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                                    x1 x1Var = this.f١١٥٨٦h;
                                                    if (x1Var == null) {
                                                        s();
                                                        this.f١١٥٨٥g.add(tVar);
                                                    } else {
                                                        x1Var.f(tVar);
                                                    }
                                                }
                                            } else {
                                                this.f١١٥٨٤f = iVar.q();
                                                this.f١١٥٨٠b |= 8;
                                            }
                                        } else {
                                            this.f١١٥٨٣e = iVar.q();
                                            this.f١١٥٨٠b |= 4;
                                        }
                                    } else {
                                        this.f١١٥٨٢d = iVar.q();
                                        this.f١١٥٨٠b |= 2;
                                    }
                                } else {
                                    this.f١١٥٨١c = iVar.q();
                                    this.f١١٥٨٠b |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(l lVar) {
                if (lVar == l.z()) {
                    return this;
                }
                if (lVar.K()) {
                    E(lVar.D());
                }
                if (lVar.L()) {
                    F(lVar.E());
                }
                if (lVar.I()) {
                    B(lVar.B());
                }
                if (lVar.J()) {
                    D(lVar.C());
                }
                if (this.f١١٥٨٦h == null) {
                    if (!lVar.f١١٥٧٨g.isEmpty()) {
                        if (this.f١١٥٨٥g.isEmpty()) {
                            this.f١١٥٨٥g = lVar.f١١٥٧٨g;
                            this.f١١٥٨٠b &= -17;
                        } else {
                            s();
                            this.f١١٥٨٥g.addAll(lVar.f١١٥٧٨g);
                        }
                        onChanged();
                    }
                } else if (!lVar.f١١٥٧٨g.isEmpty()) {
                    if (this.f١١٥٨٦h.u()) {
                        this.f١١٥٨٦h.i();
                        x1 x1Var = null;
                        this.f١١٥٨٦h = null;
                        this.f١١٥٨٥g = lVar.f١١٥٧٨g;
                        this.f١١٥٨٠b &= -17;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٥٨٦h = x1Var;
                    } else {
                        this.f١١٥٨٦h.b(lVar.f١١٥٧٨g);
                    }
                }
                j(lVar);
                mergeUnknownFields(lVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof l) {
                    return y((l) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٥٨٥g = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٥٨٥g = Collections.emptyList();
            }
        }

        private l(h0.d dVar) {
            super(dVar);
            this.f١١٥٧٤c = false;
            this.f١١٥٧٥d = false;
            this.f١١٥٧٦e = false;
            this.f١١٥٧٧f = false;
            this.f١١٥٧٩h = (byte) -1;
        }

        private l() {
            this.f١١٥٧٤c = false;
            this.f١١٥٧٥d = false;
            this.f١١٥٧٦e = false;
            this.f١١٥٧٧f = false;
            this.f١١٥٧٩h = (byte) -1;
            this.f١١٥٧٨g = Collections.emptyList();
        }
    }

    /* renamed from: com.google.protobuf.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class C٠١٤١m extends h0 implements g1 {

        /* renamed from: i, reason: collision with root package name */
        private static final C٠١٤١m f١١٥٨٧i = new C٠١٤١m();

        /* renamed from: j, reason: collision with root package name */
        public static final r1 f١١٥٨٨j = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٥٨٩a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٥٩٠b;

        /* renamed from: c, reason: collision with root package name */
        private volatile Object f١١٥٩١c;

        /* renamed from: d, reason: collision with root package name */
        private volatile Object f١١٥٩٢d;

        /* renamed from: e, reason: collision with root package name */
        private n f١١٥٩٣e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f١١٥٩٤f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١١٥٩٥g;

        /* renamed from: h, reason: collision with root package name */
        private byte f١١٥٩٦h;

        /* renamed from: com.google.protobuf.m$m$a */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public C٠١٤١m parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b J = C٠١٤١m.J();
                try {
                    J.mergeFrom(iVar, vVar);
                    return J.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(J.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(J.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(J.buildPartial());
                }
            }
        }

        public static b J() {
            return f١١٥٨٧i.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٦٤y;
        }

        static /* synthetic */ int v(C٠١٤١m r12, int i10) {
            int i11 = i10 | r12.f١١٥٨٩a;
            r12.f١١٥٨٩a = i11;
            return i11;
        }

        public static C٠١٤١m x() {
            return f١١٥٨٧i;
        }

        public n A() {
            n nVar = this.f١١٥٩٣e;
            if (nVar == null) {
                return n.x();
            }
            return nVar;
        }

        public String B() {
            Object obj = this.f١١٥٩٢d;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٩٢d = C;
            }
            return C;
        }

        public boolean C() {
            return this.f١١٥٩٥g;
        }

        public boolean D() {
            if ((this.f١١٥٨٩a & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean E() {
            if ((this.f١١٥٨٩a & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean F() {
            if ((this.f١١٥٨٩a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean G() {
            if ((this.f١١٥٨٩a & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean H() {
            if ((this.f١١٥٨٩a & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean I() {
            if ((this.f١١٥٨٩a & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return J();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٥٨٧i) {
                return new b();
            }
            return new b().p(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C٠١٤١m)) {
                return super.equals(obj);
            }
            C٠١٤١m r52 = (C٠١٤١m) obj;
            if (F() != r52.F()) {
                return false;
            }
            if ((F() && !getName().equals(r52.getName())) || E() != r52.E()) {
                return false;
            }
            if ((E() && !z().equals(r52.z())) || H() != r52.H()) {
                return false;
            }
            if ((H() && !B().equals(r52.B())) || G() != r52.G()) {
                return false;
            }
            if ((G() && !A().equals(r52.A())) || D() != r52.D()) {
                return false;
            }
            if ((D() && w() != r52.w()) || I() != r52.I()) {
                return false;
            }
            if ((!I() || C() == r52.C()) && getUnknownFields().equals(r52.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٥٩٠b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٩٠b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٥٨٩a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٥٩٠b);
            } else {
                i10 = 0;
            }
            if ((this.f١١٥٨٩a & 2) != 0) {
                i10 += h0.computeStringSize(2, this.f١١٥٩١c);
            }
            if ((this.f١١٥٨٩a & 4) != 0) {
                i10 += h0.computeStringSize(3, this.f١١٥٩٢d);
            }
            if ((this.f١١٥٨٩a & 8) != 0) {
                i10 += com.google.protobuf.k.G(4, A());
            }
            if ((this.f١١٥٨٩a & 16) != 0) {
                i10 += com.google.protobuf.k.e(5, this.f١١٥٩٤f);
            }
            if ((this.f١١٥٨٩a & 32) != 0) {
                i10 += com.google.protobuf.k.e(6, this.f١١٥٩٥g);
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (F()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (E()) {
                hashCode = (((hashCode * 37) + 2) * 53) + z().hashCode();
            }
            if (H()) {
                hashCode = (((hashCode * 37) + 3) * 53) + B().hashCode();
            }
            if (G()) {
                hashCode = (((hashCode * 37) + 4) * 53) + A().hashCode();
            }
            if (D()) {
                hashCode = (((hashCode * 37) + 5) * 53) + j0.c(w());
            }
            if (I()) {
                hashCode = (((hashCode * 37) + 6) * 53) + j0.c(C());
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٦٥z.d(C٠١٤١m.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٥٩٦h;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (G() && !A().isInitialized()) {
                this.f١١٥٩٦h = (byte) 0;
                return false;
            }
            this.f١١٥٩٦h = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new C٠١٤١m();
        }

        public boolean w() {
            return this.f١١٥٩٤f;
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٥٨٩a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٥٩٠b);
            }
            if ((this.f١١٥٨٩a & 2) != 0) {
                h0.writeString(kVar, 2, this.f١١٥٩١c);
            }
            if ((this.f١١٥٨٩a & 4) != 0) {
                h0.writeString(kVar, 3, this.f١١٥٩٢d);
            }
            if ((this.f١١٥٨٩a & 8) != 0) {
                kVar.H0(4, A());
            }
            if ((this.f١١٥٨٩a & 16) != 0) {
                kVar.l0(5, this.f١١٥٩٤f);
            }
            if ((this.f١١٥٨٩a & 32) != 0) {
                kVar.l0(6, this.f١١٥٩٥g);
            }
            getUnknownFields().writeTo(kVar);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public C٠١٤١m getDefaultInstanceForType() {
            return f١١٥٨٧i;
        }

        public String z() {
            Object obj = this.f١١٥٩١c;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٥٩١c = C;
            }
            return C;
        }

        /* renamed from: com.google.protobuf.m$m$b */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٥٩٧a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٥٩٨b;

            /* renamed from: c, reason: collision with root package name */
            private Object f١١٥٩٩c;

            /* renamed from: d, reason: collision with root package name */
            private Object f١١٦٠٠d;

            /* renamed from: e, reason: collision with root package name */
            private n f١١٦٠١e;

            /* renamed from: f, reason: collision with root package name */
            private b2 f١١٦٠٢f;

            /* renamed from: g, reason: collision with root package name */
            private boolean f١١٦٠٣g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f١١٦٠٤h;

            private void h(C٠١٤١m r42) {
                int i10;
                n nVar;
                int i11 = this.f١١٥٩٧a;
                if ((i11 & 1) != 0) {
                    r42.f١١٥٩٠b = this.f١١٥٩٨b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    r42.f١١٥٩١c = this.f١١٥٩٩c;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    r42.f١١٥٩٢d = this.f١١٦٠٠d;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    b2 b2Var = this.f١١٦٠٢f;
                    if (b2Var == null) {
                        nVar = this.f١١٦٠١e;
                    } else {
                        nVar = (n) b2Var.b();
                    }
                    r42.f١١٥٩٣e = nVar;
                    i10 |= 8;
                }
                if ((i11 & 16) != 0) {
                    r42.f١١٥٩٤f = this.f١١٦٠٣g;
                    i10 |= 16;
                }
                if ((i11 & 32) != 0) {
                    r42.f١١٥٩٥g = this.f١١٦٠٤h;
                    i10 |= 32;
                }
                C٠١٤١m.v(r42, i10);
            }

            private b2 m() {
                if (this.f١١٦٠٢f == null) {
                    this.f١١٦٠٢f = new b2(k(), getParentForChildren(), isClean());
                    this.f١١٦٠١e = null;
                }
                return this.f١١٦٠٢f;
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public C٠١٤١m build() {
                C٠١٤١m buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public C٠١٤١m buildPartial() {
                C٠١٤١m r02 = new C٠١٤١m(this);
                if (this.f١١٥٩٧a != 0) {
                    h(r02);
                }
                onBuilt();
                return r02;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٦٤y;
            }

            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٦٥z.d(C٠١٤١m.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                if (n() && !k().isInitialized()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.f1
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public C٠١٤١m getDefaultInstanceForType() {
                return C٠١٤١m.x();
            }

            public n k() {
                b2 b2Var = this.f١١٦٠٢f;
                if (b2Var == null) {
                    n nVar = this.f١١٦٠١e;
                    if (nVar == null) {
                        return n.x();
                    }
                    return nVar;
                }
                return (n) b2Var.e();
            }

            public n.b l() {
                this.f١١٥٩٧a |= 8;
                onChanged();
                return (n.b) m().d();
            }

            public boolean n() {
                if ((this.f١١٥٩٧a & 8) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K != 18) {
                                        if (K != 26) {
                                            if (K != 34) {
                                                if (K != 40) {
                                                    if (K != 48) {
                                                        if (!super.parseUnknownField(iVar, vVar, K)) {
                                                        }
                                                    } else {
                                                        this.f١١٦٠٤h = iVar.q();
                                                        this.f١١٥٩٧a |= 32;
                                                    }
                                                } else {
                                                    this.f١١٦٠٣g = iVar.q();
                                                    this.f١١٥٩٧a |= 16;
                                                }
                                            } else {
                                                iVar.B(m().d(), vVar);
                                                this.f١١٥٩٧a |= 8;
                                            }
                                        } else {
                                            this.f١١٦٠٠d = iVar.r();
                                            this.f١١٥٩٧a |= 4;
                                        }
                                    } else {
                                        this.f١١٥٩٩c = iVar.r();
                                        this.f١١٥٩٧a |= 2;
                                    }
                                } else {
                                    this.f١١٥٩٨b = iVar.r();
                                    this.f١١٥٩٧a |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b p(C٠١٤١m r22) {
                if (r22 == C٠١٤١m.x()) {
                    return this;
                }
                if (r22.F()) {
                    this.f١١٥٩٨b = r22.f١١٥٩٠b;
                    this.f١١٥٩٧a |= 1;
                    onChanged();
                }
                if (r22.E()) {
                    this.f١١٥٩٩c = r22.f١١٥٩١c;
                    this.f١١٥٩٧a |= 2;
                    onChanged();
                }
                if (r22.H()) {
                    this.f١١٦٠٠d = r22.f١١٥٩٢d;
                    this.f١١٥٩٧a |= 4;
                    onChanged();
                }
                if (r22.G()) {
                    r(r22.A());
                }
                if (r22.D()) {
                    t(r22.w());
                }
                if (r22.I()) {
                    v(r22.C());
                }
                mergeUnknownFields(r22.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof C٠١٤١m) {
                    return p((C٠١٤١m) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b r(n nVar) {
                n nVar2;
                b2 b2Var = this.f١١٦٠٢f;
                if (b2Var == null) {
                    if ((this.f١١٥٩٧a & 8) != 0 && (nVar2 = this.f١١٦٠١e) != null && nVar2 != n.x()) {
                        l().y(nVar);
                    } else {
                        this.f١١٦٠١e = nVar;
                    }
                } else {
                    b2Var.g(nVar);
                }
                this.f١١٥٩٧a |= 8;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b t(boolean z10) {
                this.f١١٦٠٣g = z10;
                this.f١١٥٩٧a |= 16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            public b v(boolean z10) {
                this.f١١٦٠٤h = z10;
                this.f١١٥٩٧a |= 32;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٥٩٨b = "";
                this.f١١٥٩٩c = "";
                this.f١١٦٠٠d = "";
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٥٩٨b = "";
                this.f١١٥٩٩c = "";
                this.f١١٦٠٠d = "";
                maybeForceBuilderInitialization();
            }
        }

        private C٠١٤١m(h0.b bVar) {
            super(bVar);
            this.f١١٥٩٠b = "";
            this.f١١٥٩١c = "";
            this.f١١٥٩٢d = "";
            this.f١١٥٩٤f = false;
            this.f١١٥٩٥g = false;
            this.f١١٥٩٦h = (byte) -1;
        }

        private C٠١٤١m() {
            this.f١١٥٩٠b = "";
            this.f١١٥٩١c = "";
            this.f١١٥٩٢d = "";
            this.f١١٥٩٤f = false;
            this.f١١٥٩٥g = false;
            this.f١١٥٩٦h = (byte) -1;
            this.f١١٥٩٠b = "";
            this.f١١٥٩١c = "";
            this.f١١٥٩٢d = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class n extends h0.e implements g1 {

        /* renamed from: g, reason: collision with root package name */
        private static final n f١١٦٠٥g = new n();

        /* renamed from: h, reason: collision with root package name */
        public static final r1 f١١٦٠٦h = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٦٠٧b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١١٦٠٨c;

        /* renamed from: d, reason: collision with root package name */
        private int f١١٦٠٩d;

        /* renamed from: e, reason: collision with root package name */
        private List f١١٦١٠e;

        /* renamed from: f, reason: collision with root package name */
        private byte f١١٦١١f;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public n parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b G = n.G();
                try {
                    G.mergeFrom(iVar, vVar);
                    return G.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(G.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(G.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(G.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum c implements j0.c {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);


            /* renamed from: e, reason: collision with root package name */
            private static final j0.d f١١٦٢٠e = new a();

            /* renamed from: f, reason: collision with root package name */
            private static final c[] f١١٦٢١f = values();

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٦٢٣a;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a implements j0.d {
                a() {
                }
            }

            c(int i10) {
                this.f١١٦٢٣a = i10;
            }

            public static c c(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            return null;
                        }
                        return IDEMPOTENT;
                    }
                    return NO_SIDE_EFFECTS;
                }
                return IDEMPOTENCY_UNKNOWN;
            }

            @Override // com.google.protobuf.j0.c
            public final int getNumber() {
                return this.f١١٦٢٣a;
            }
        }

        public static b G() {
            return f١١٦٠٥g.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.O;
        }

        static /* synthetic */ int w(n nVar, int i10) {
            int i11 = i10 | nVar.f١١٦٠٧b;
            nVar.f١١٦٠٧b = i11;
            return i11;
        }

        public static n x() {
            return f١١٦٠٥g;
        }

        public c A() {
            c c10 = c.c(this.f١١٦٠٩d);
            if (c10 == null) {
                return c.IDEMPOTENCY_UNKNOWN;
            }
            return c10;
        }

        public t B(int i10) {
            return (t) this.f١١٦١٠e.get(i10);
        }

        public int C() {
            return this.f١١٦١٠e.size();
        }

        public List D() {
            return this.f١١٦١٠e;
        }

        public boolean E() {
            if ((this.f١١٦٠٧b & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean F() {
            if ((this.f١١٦٠٧b & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return G();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٠٥g) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof n)) {
                return super.equals(obj);
            }
            n nVar = (n) obj;
            if (E() != nVar.E()) {
                return false;
            }
            if ((E() && z() != nVar.z()) || F() != nVar.F()) {
                return false;
            }
            if ((!F() || this.f١١٦٠٩d == nVar.f١١٦٠٩d) && D().equals(nVar.D()) && getUnknownFields().equals(nVar.getUnknownFields()) && p().equals(nVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٦٠٧b & 1) != 0) {
                i10 = com.google.protobuf.k.e(33, this.f١١٦٠٨c);
            } else {
                i10 = 0;
            }
            if ((this.f١١٦٠٧b & 2) != 0) {
                i10 += com.google.protobuf.k.l(34, this.f١١٦٠٩d);
            }
            for (int i12 = 0; i12 < this.f١١٦١٠e.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٦١٠e.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (E()) {
                hashCode = (((hashCode * 37) + 33) * 53) + j0.c(z());
            }
            if (F()) {
                hashCode = (((hashCode * 37) + 34) * 53) + this.f١١٦٠٩d;
            }
            if (C() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + D().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.P.d(n.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦١١f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < C(); i10++) {
                if (!B(i10).isInitialized()) {
                    this.f١١٦١١f = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٦١١f = (byte) 0;
                return false;
            }
            this.f١١٦١١f = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new n();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٦٠٧b & 1) != 0) {
                kVar.l0(33, this.f١١٦٠٨c);
            }
            if ((this.f١١٦٠٧b & 2) != 0) {
                kVar.t0(34, this.f١١٦٠٩d);
            }
            for (int i10 = 0; i10 < this.f١١٦١٠e.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٦١٠e.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public n getDefaultInstanceForType() {
            return f١١٦٠٥g;
        }

        public boolean z() {
            return this.f١١٦٠٨c;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٦١٢b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٦١٣c;

            /* renamed from: d, reason: collision with root package name */
            private int f١١٦١٤d;

            /* renamed from: e, reason: collision with root package name */
            private List f١١٦١٥e;

            /* renamed from: f, reason: collision with root package name */
            private x1 f١١٦١٦f;

            private void p(n nVar) {
                int i10;
                int i11 = this.f١١٦١٢b;
                if ((i11 & 1) != 0) {
                    nVar.f١١٦٠٨c = this.f١١٦١٣c;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    nVar.f١١٦٠٩d = this.f١١٦١٤d;
                    i10 |= 2;
                }
                n.w(nVar, i10);
            }

            private void q(n nVar) {
                x1 x1Var = this.f١١٦١٦f;
                if (x1Var != null) {
                    nVar.f١١٦١٠e = x1Var.g();
                    return;
                }
                if ((this.f١١٦١٢b & 4) != 0) {
                    this.f١١٦١٥e = Collections.unmodifiableList(this.f١١٦١٥e);
                    this.f١١٦١٢b &= -5;
                }
                nVar.f١١٦١٠e = this.f١١٦١٥e;
            }

            private void s() {
                if ((this.f١١٦١٢b & 4) == 0) {
                    this.f١١٦١٥e = new ArrayList(this.f١١٦١٥e);
                    this.f١١٦١٢b |= 4;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٦١٦f == null) {
                    List list = this.f١١٦١٥e;
                    if ((this.f١١٦١٢b & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٦١٦f = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٦١٥e = null;
                }
                return this.f١١٦١٦f;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٦١٣c = z10;
                this.f١١٦١٢b |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            public b D(c cVar) {
                cVar.getClass();
                this.f١١٦١٢b |= 2;
                this.f١١٦١٤d = cVar.getNumber();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: E, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.O;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.P.d(n.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public n build() {
                n buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public n buildPartial() {
                n nVar = new n(this);
                q(nVar);
                if (this.f١١٦١٢b != 0) {
                    p(nVar);
                }
                onBuilt();
                return nVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public n getDefaultInstanceForType() {
                return n.x();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٦١٦f;
                if (x1Var == null) {
                    return (t) this.f١١٦١٥e.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٦١٦f;
                if (x1Var == null) {
                    return this.f١١٦١٥e.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 264) {
                                    if (K != 272) {
                                        if (K != 7994) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                            x1 x1Var = this.f١١٦١٦f;
                                            if (x1Var == null) {
                                                s();
                                                this.f١١٦١٥e.add(tVar);
                                            } else {
                                                x1Var.f(tVar);
                                            }
                                        }
                                    } else {
                                        int t10 = iVar.t();
                                        if (c.c(t10) == null) {
                                            mergeUnknownVarintField(34, t10);
                                        } else {
                                            this.f١١٦١٤d = t10;
                                            this.f١١٦١٢b |= 2;
                                        }
                                    }
                                } else {
                                    this.f١١٦١٣c = iVar.q();
                                    this.f١١٦١٢b |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(n nVar) {
                if (nVar == n.x()) {
                    return this;
                }
                if (nVar.E()) {
                    B(nVar.z());
                }
                if (nVar.F()) {
                    D(nVar.A());
                }
                if (this.f١١٦١٦f == null) {
                    if (!nVar.f١١٦١٠e.isEmpty()) {
                        if (this.f١١٦١٥e.isEmpty()) {
                            this.f١١٦١٥e = nVar.f١١٦١٠e;
                            this.f١١٦١٢b &= -5;
                        } else {
                            s();
                            this.f١١٦١٥e.addAll(nVar.f١١٦١٠e);
                        }
                        onChanged();
                    }
                } else if (!nVar.f١١٦١٠e.isEmpty()) {
                    if (this.f١١٦١٦f.u()) {
                        this.f١١٦١٦f.i();
                        x1 x1Var = null;
                        this.f١١٦١٦f = null;
                        this.f١١٦١٥e = nVar.f١١٦١٠e;
                        this.f١١٦١٢b &= -5;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٦١٦f = x1Var;
                    } else {
                        this.f١١٦١٦f.b(nVar.f١١٦١٠e);
                    }
                }
                j(nVar);
                mergeUnknownFields(nVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof n) {
                    return y((n) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٦١٤d = 0;
                this.f١١٦١٥e = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦١٤d = 0;
                this.f١١٦١٥e = Collections.emptyList();
            }
        }

        private n(h0.d dVar) {
            super(dVar);
            this.f١١٦٠٨c = false;
            this.f١١٦٠٩d = 0;
            this.f١١٦١١f = (byte) -1;
        }

        private n() {
            this.f١١٦٠٨c = false;
            this.f١١٦١١f = (byte) -1;
            this.f١١٦٠٩d = 0;
            this.f١١٦١٠e = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class o extends h0 implements g1 {

        /* renamed from: e, reason: collision with root package name */
        private static final o f١١٦٢٤e = new o();

        /* renamed from: f, reason: collision with root package name */
        public static final r1 f١١٦٢٥f = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٦٢٦a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٦٢٧b;

        /* renamed from: c, reason: collision with root package name */
        private p f١١٦٢٨c;

        /* renamed from: d, reason: collision with root package name */
        private byte f١١٦٢٩d;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public o parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b v10 = o.v();
                try {
                    v10.mergeFrom(iVar, vVar);
                    return v10.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(v10.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(v10.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(v10.buildPartial());
                }
            }
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٥٤o;
        }

        static /* synthetic */ int p(o oVar, int i10) {
            int i11 = i10 | oVar.f١١٦٢٦a;
            oVar.f١١٦٢٦a = i11;
            return i11;
        }

        public static o q() {
            return f١١٦٢٤e;
        }

        public static b v() {
            return f١١٦٢٤e.toBuilder();
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof o)) {
                return super.equals(obj);
            }
            o oVar = (o) obj;
            if (t() != oVar.t()) {
                return false;
            }
            if ((t() && !getName().equals(oVar.getName())) || u() != oVar.u()) {
                return false;
            }
            if ((!u() || s().equals(oVar.s())) && getUnknownFields().equals(oVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٦٢٧b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٦٢٧b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٦٢٦a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٦٢٧b);
            } else {
                i10 = 0;
            }
            if ((this.f١١٦٢٦a & 2) != 0) {
                i10 += com.google.protobuf.k.G(2, s());
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (t()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (u()) {
                hashCode = (((hashCode * 37) + 2) * 53) + s().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٥٥p.d(o.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٢٩d;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (u() && !s().isInitialized()) {
                this.f١١٦٢٩d = (byte) 0;
                return false;
            }
            this.f١١٦٢٩d = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new o();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public o getDefaultInstanceForType() {
            return f١١٦٢٤e;
        }

        public p s() {
            p pVar = this.f١١٦٢٨c;
            if (pVar == null) {
                return p.u();
            }
            return pVar;
        }

        public boolean t() {
            if ((this.f١١٦٢٦a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean u() {
            if ((this.f١١٦٢٦a & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return v();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٦٢٦a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٦٢٧b);
            }
            if ((this.f١١٦٢٦a & 2) != 0) {
                kVar.H0(2, s());
            }
            getUnknownFields().writeTo(kVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٢٤e) {
                return new b();
            }
            return new b().p(this);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٦٣٠a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٦٣١b;

            /* renamed from: c, reason: collision with root package name */
            private p f١١٦٣٢c;

            /* renamed from: d, reason: collision with root package name */
            private b2 f١١٦٣٣d;

            private void h(o oVar) {
                int i10;
                p pVar;
                int i11 = this.f١١٦٣٠a;
                if ((i11 & 1) != 0) {
                    oVar.f١١٦٢٧b = this.f١١٦٣١b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    b2 b2Var = this.f١١٦٣٣d;
                    if (b2Var == null) {
                        pVar = this.f١١٦٣٢c;
                    } else {
                        pVar = (p) b2Var.b();
                    }
                    oVar.f١١٦٢٨c = pVar;
                    i10 |= 2;
                }
                o.p(oVar, i10);
            }

            private b2 m() {
                if (this.f١١٦٣٣d == null) {
                    this.f١١٦٣٣d = new b2(k(), getParentForChildren(), isClean());
                    this.f١١٦٣٢c = null;
                }
                return this.f١١٦٣٣d;
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    m();
                }
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public o build() {
                o buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public o buildPartial() {
                o oVar = new o(this);
                if (this.f١١٦٣٠a != 0) {
                    h(oVar);
                }
                onBuilt();
                return oVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٥٤o;
            }

            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٥٥p.d(o.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                if (n() && !k().isInitialized()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.f1
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public o getDefaultInstanceForType() {
                return o.q();
            }

            public p k() {
                b2 b2Var = this.f١١٦٣٣d;
                if (b2Var == null) {
                    p pVar = this.f١١٦٣٢c;
                    if (pVar == null) {
                        return p.u();
                    }
                    return pVar;
                }
                return (p) b2Var.e();
            }

            public p.b l() {
                this.f١١٦٣٠a |= 2;
                onChanged();
                return (p.b) m().d();
            }

            public boolean n() {
                if ((this.f١١٦٣٠a & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K != 18) {
                                        if (!super.parseUnknownField(iVar, vVar, K)) {
                                        }
                                    } else {
                                        iVar.B(m().d(), vVar);
                                        this.f١١٦٣٠a |= 2;
                                    }
                                } else {
                                    this.f١١٦٣١b = iVar.r();
                                    this.f١١٦٣٠a |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b p(o oVar) {
                if (oVar == o.q()) {
                    return this;
                }
                if (oVar.t()) {
                    this.f١١٦٣١b = oVar.f١١٦٢٧b;
                    this.f١١٦٣٠a |= 1;
                    onChanged();
                }
                if (oVar.u()) {
                    r(oVar.s());
                }
                mergeUnknownFields(oVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof o) {
                    return p((o) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b r(p pVar) {
                p pVar2;
                b2 b2Var = this.f١١٦٣٣d;
                if (b2Var == null) {
                    if ((this.f١١٦٣٠a & 2) != 0 && (pVar2 = this.f١١٦٣٢c) != null && pVar2 != p.u()) {
                        l().y(pVar);
                    } else {
                        this.f١١٦٣٢c = pVar;
                    }
                } else {
                    b2Var.g(pVar);
                }
                this.f١١٦٣٠a |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٦٣١b = "";
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦٣١b = "";
                maybeForceBuilderInitialization();
            }
        }

        private o(h0.b bVar) {
            super(bVar);
            this.f١١٦٢٧b = "";
            this.f١١٦٢٩d = (byte) -1;
        }

        private o() {
            this.f١١٦٢٧b = "";
            this.f١١٦٢٩d = (byte) -1;
            this.f١١٦٢٧b = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class p extends h0.e implements g1 {

        /* renamed from: d, reason: collision with root package name */
        private static final p f١١٦٣٤d = new p();

        /* renamed from: e, reason: collision with root package name */
        public static final r1 f١١٦٣٥e = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private List f١١٦٣٦b;

        /* renamed from: c, reason: collision with root package name */
        private byte f١١٦٣٧c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public p parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b z10 = p.z();
                try {
                    z10.mergeFrom(iVar, vVar);
                    return z10.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(z10.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(z10.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(z10.buildPartial());
                }
            }
        }

        public static final n.b getDescriptor() {
            return m.G;
        }

        public static p u() {
            return f١١٦٣٤d;
        }

        public static b z() {
            return f١١٦٣٤d.toBuilder();
        }

        @Override // com.google.protobuf.e1
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return z();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٣٤d) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof p)) {
                return super.equals(obj);
            }
            p pVar = (p) obj;
            if (y().equals(pVar.y()) && getUnknownFields().equals(pVar.getUnknownFields()) && p().equals(pVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f١١٦٣٦b.size(); i12++) {
                i11 += com.google.protobuf.k.G(999, (e1) this.f١١٦٣٦b.get(i12));
            }
            int o10 = i11 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (x() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + y().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.H.d(p.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٣٧c;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < x(); i10++) {
                if (!w(i10).isInitialized()) {
                    this.f١١٦٣٧c = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٦٣٧c = (byte) 0;
                return false;
            }
            this.f١١٦٣٧c = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new p();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public p getDefaultInstanceForType() {
            return f١١٦٣٤d;
        }

        public t w(int i10) {
            return (t) this.f١١٦٣٦b.get(i10);
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            for (int i10 = 0; i10 < this.f١١٦٣٦b.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٦٣٦b.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        public int x() {
            return this.f١١٦٣٦b.size();
        }

        public List y() {
            return this.f١١٦٣٦b;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٦٣٨b;

            /* renamed from: c, reason: collision with root package name */
            private List f١١٦٣٩c;

            /* renamed from: d, reason: collision with root package name */
            private x1 f١١٦٤٠d;

            private void p(p pVar) {
            }

            private void q(p pVar) {
                x1 x1Var = this.f١١٦٤٠d;
                if (x1Var != null) {
                    pVar.f١١٦٣٦b = x1Var.g();
                    return;
                }
                if ((this.f١١٦٣٨b & 1) != 0) {
                    this.f١١٦٣٩c = Collections.unmodifiableList(this.f١١٦٣٩c);
                    this.f١١٦٣٨b &= -2;
                }
                pVar.f١١٦٣٦b = this.f١١٦٣٩c;
            }

            private void s() {
                if ((this.f١١٦٣٨b & 1) == 0) {
                    this.f١١٦٣٩c = new ArrayList(this.f١١٦٣٩c);
                    this.f١١٦٣٨b |= 1;
                }
            }

            private x1 w() {
                if (this.f١١٦٤٠d == null) {
                    List list = this.f١١٦٣٩c;
                    boolean z10 = true;
                    if ((this.f١١٦٣٨b & 1) == 0) {
                        z10 = false;
                    }
                    this.f١١٦٤٠d = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٦٣٩c = null;
                }
                return this.f١١٦٤٠d;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.G;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.H.d(p.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public p build() {
                p buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public p buildPartial() {
                p pVar = new p(this);
                q(pVar);
                if (this.f١١٦٣٨b != 0) {
                    p(pVar);
                }
                onBuilt();
                return pVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public p getDefaultInstanceForType() {
                return p.u();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٦٤٠d;
                if (x1Var == null) {
                    return (t) this.f١١٦٣٩c.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٦٤٠d;
                if (x1Var == null) {
                    return this.f١١٦٣٩c.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 7994) {
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                    x1 x1Var = this.f١١٦٤٠d;
                                    if (x1Var == null) {
                                        s();
                                        this.f١١٦٣٩c.add(tVar);
                                    } else {
                                        x1Var.f(tVar);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(p pVar) {
                if (pVar == p.u()) {
                    return this;
                }
                if (this.f١١٦٤٠d == null) {
                    if (!pVar.f١١٦٣٦b.isEmpty()) {
                        if (this.f١١٦٣٩c.isEmpty()) {
                            this.f١١٦٣٩c = pVar.f١١٦٣٦b;
                            this.f١١٦٣٨b &= -2;
                        } else {
                            s();
                            this.f١١٦٣٩c.addAll(pVar.f١١٦٣٦b);
                        }
                        onChanged();
                    }
                } else if (!pVar.f١١٦٣٦b.isEmpty()) {
                    if (this.f١١٦٤٠d.u()) {
                        this.f١١٦٤٠d.i();
                        x1 x1Var = null;
                        this.f١١٦٤٠d = null;
                        this.f١١٦٣٩c = pVar.f١١٦٣٦b;
                        this.f١١٦٣٨b &= -2;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٦٤٠d = x1Var;
                    } else {
                        this.f١١٦٤٠d.b(pVar.f١١٦٣٦b);
                    }
                }
                j(pVar);
                mergeUnknownFields(pVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof p) {
                    return y((p) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٦٣٩c = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦٣٩c = Collections.emptyList();
            }
        }

        private p(h0.d dVar) {
            super(dVar);
            this.f١١٦٣٧c = (byte) -1;
        }

        private p() {
            this.f١١٦٣٧c = (byte) -1;
            this.f١١٦٣٦b = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class q extends h0 implements g1 {

        /* renamed from: f, reason: collision with root package name */
        private static final q f١١٦٤١f = new q();

        /* renamed from: g, reason: collision with root package name */
        public static final r1 f١١٦٤٢g = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٦٤٣a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f١١٦٤٤b;

        /* renamed from: c, reason: collision with root package name */
        private List f١١٦٤٥c;

        /* renamed from: d, reason: collision with root package name */
        private r f١١٦٤٦d;

        /* renamed from: e, reason: collision with root package name */
        private byte f١١٦٤٧e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public q parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b A = q.A();
                try {
                    A.mergeFrom(iVar, vVar);
                    return A.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(A.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(A.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(A.buildPartial());
                }
            }
        }

        public static b A() {
            return f١١٦٤١f.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.f١١٢٦٢w;
        }

        static /* synthetic */ int r(q qVar, int i10) {
            int i11 = i10 | qVar.f١١٦٤٣a;
            qVar.f١١٦٤٣a = i11;
            return i11;
        }

        public static q s() {
            return f١١٦٤١f;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return A();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٤١f) {
                return new b();
            }
            return new b().u(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof q)) {
                return super.equals(obj);
            }
            q qVar = (q) obj;
            if (y() != qVar.y()) {
                return false;
            }
            if ((y() && !getName().equals(qVar.getName())) || !w().equals(qVar.w()) || z() != qVar.z()) {
                return false;
            }
            if ((!z() || x().equals(qVar.x())) && getUnknownFields().equals(qVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        public String getName() {
            Object obj = this.f١١٦٤٤b;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٦٤٤b = C;
            }
            return C;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٦٤٣a & 1) != 0) {
                i10 = h0.computeStringSize(1, this.f١١٦٤٤b);
            } else {
                i10 = 0;
            }
            for (int i12 = 0; i12 < this.f١١٦٤٥c.size(); i12++) {
                i10 += com.google.protobuf.k.G(2, (e1) this.f١١٦٤٥c.get(i12));
            }
            if ((this.f١١٦٤٣a & 2) != 0) {
                i10 += com.google.protobuf.k.G(3, x());
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (y()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (v() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + w().hashCode();
            }
            if (z()) {
                hashCode = (((hashCode * 37) + 3) * 53) + x().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.f١١٢٦٣x.d(q.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٤٧e;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < v(); i10++) {
                if (!u(i10).isInitialized()) {
                    this.f١١٦٤٧e = (byte) 0;
                    return false;
                }
            }
            if (z() && !x().isInitialized()) {
                this.f١١٦٤٧e = (byte) 0;
                return false;
            }
            this.f١١٦٤٧e = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new q();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public q getDefaultInstanceForType() {
            return f١١٦٤١f;
        }

        public C٠١٤١m u(int i10) {
            return (C٠١٤١m) this.f١١٦٤٥c.get(i10);
        }

        public int v() {
            return this.f١١٦٤٥c.size();
        }

        public List w() {
            return this.f١١٦٤٥c;
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            if ((this.f١١٦٤٣a & 1) != 0) {
                h0.writeString(kVar, 1, this.f١١٦٤٤b);
            }
            for (int i10 = 0; i10 < this.f١١٦٤٥c.size(); i10++) {
                kVar.H0(2, (e1) this.f١١٦٤٥c.get(i10));
            }
            if ((this.f١١٦٤٣a & 2) != 0) {
                kVar.H0(3, x());
            }
            getUnknownFields().writeTo(kVar);
        }

        public r x() {
            r rVar = this.f١١٦٤٦d;
            if (rVar == null) {
                return r.w();
            }
            return rVar;
        }

        public boolean y() {
            if ((this.f١١٦٤٣a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean z() {
            if ((this.f١١٦٤٣a & 2) != 0) {
                return true;
            }
            return false;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٦٤٨a;

            /* renamed from: b, reason: collision with root package name */
            private Object f١١٦٤٩b;

            /* renamed from: c, reason: collision with root package name */
            private List f١١٦٥٠c;

            /* renamed from: d, reason: collision with root package name */
            private x1 f١١٦٥١d;

            /* renamed from: e, reason: collision with root package name */
            private r f١١٦٥٢e;

            /* renamed from: f, reason: collision with root package name */
            private b2 f١١٦٥٣f;

            private void h(q qVar) {
                int i10;
                r rVar;
                int i11 = this.f١١٦٤٨a;
                if ((i11 & 1) != 0) {
                    qVar.f١١٦٤٤b = this.f١١٦٤٩b;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 4) != 0) {
                    b2 b2Var = this.f١١٦٥٣f;
                    if (b2Var == null) {
                        rVar = this.f١١٦٥٢e;
                    } else {
                        rVar = (r) b2Var.b();
                    }
                    qVar.f١١٦٤٦d = rVar;
                    i10 |= 2;
                }
                q.r(qVar, i10);
            }

            private void i(q qVar) {
                x1 x1Var = this.f١١٦٥١d;
                if (x1Var != null) {
                    qVar.f١١٦٤٥c = x1Var.g();
                    return;
                }
                if ((this.f١١٦٤٨a & 2) != 0) {
                    this.f١١٦٥٠c = Collections.unmodifiableList(this.f١١٦٥٠c);
                    this.f١١٦٤٨a &= -3;
                }
                qVar.f١١٦٤٥c = this.f١١٦٥٠c;
            }

            private void k() {
                if ((this.f١١٦٤٨a & 2) == 0) {
                    this.f١١٦٥٠c = new ArrayList(this.f١١٦٥٠c);
                    this.f١١٦٤٨a |= 2;
                }
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    o();
                    r();
                }
            }

            private x1 o() {
                boolean z10;
                if (this.f١١٦٥١d == null) {
                    List list = this.f١١٦٥٠c;
                    if ((this.f١١٦٤٨a & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٦٥١d = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٦٥٠c = null;
                }
                return this.f١١٦٥١d;
            }

            private b2 r() {
                if (this.f١١٦٥٣f == null) {
                    this.f١١٦٥٣f = new b2(p(), getParentForChildren(), isClean());
                    this.f١١٦٥٢e = null;
                }
                return this.f١١٦٥٣f;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public q build() {
                q buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public q buildPartial() {
                q qVar = new q(this);
                i(qVar);
                if (this.f١١٦٤٨a != 0) {
                    h(qVar);
                }
                onBuilt();
                return qVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.f١١٢٦٢w;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.f١١٢٦٣x.d(q.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < n(); i10++) {
                    if (!m(i10).isInitialized()) {
                        return false;
                    }
                }
                if (s() && !p().isInitialized()) {
                    return false;
                }
                return true;
            }

            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public q getDefaultInstanceForType() {
                return q.s();
            }

            public C٠١٤١m m(int i10) {
                x1 x1Var = this.f١١٦٥١d;
                if (x1Var == null) {
                    return (C٠١٤١m) this.f١١٦٥٠c.get(i10);
                }
                return (C٠١٤١m) x1Var.o(i10);
            }

            public int n() {
                x1 x1Var = this.f١١٦٥١d;
                if (x1Var == null) {
                    return this.f١١٦٥٠c.size();
                }
                return x1Var.n();
            }

            public r p() {
                b2 b2Var = this.f١١٦٥٣f;
                if (b2Var == null) {
                    r rVar = this.f١١٦٥٢e;
                    if (rVar == null) {
                        return r.w();
                    }
                    return rVar;
                }
                return (r) b2Var.e();
            }

            public r.b q() {
                this.f١١٦٤٨a |= 4;
                onChanged();
                return (r.b) r().d();
            }

            public boolean s() {
                if ((this.f١١٦٤٨a & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K != 18) {
                                        if (K != 26) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            iVar.B(r().d(), vVar);
                                            this.f١١٦٤٨a |= 4;
                                        }
                                    } else {
                                        C٠١٤١m r12 = (C٠١٤١m) iVar.A(C٠١٤١m.f١١٥٨٨j, vVar);
                                        x1 x1Var = this.f١١٦٥١d;
                                        if (x1Var == null) {
                                            k();
                                            this.f١١٦٥٠c.add(r12);
                                        } else {
                                            x1Var.f(r12);
                                        }
                                    }
                                } else {
                                    this.f١١٦٤٩b = iVar.r();
                                    this.f١١٦٤٨a |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b u(q qVar) {
                if (qVar == q.s()) {
                    return this;
                }
                if (qVar.y()) {
                    this.f١١٦٤٩b = qVar.f١١٦٤٤b;
                    this.f١١٦٤٨a |= 1;
                    onChanged();
                }
                if (this.f١١٦٥١d == null) {
                    if (!qVar.f١١٦٤٥c.isEmpty()) {
                        if (this.f١١٦٥٠c.isEmpty()) {
                            this.f١١٦٥٠c = qVar.f١١٦٤٥c;
                            this.f١١٦٤٨a &= -3;
                        } else {
                            k();
                            this.f١١٦٥٠c.addAll(qVar.f١١٦٤٥c);
                        }
                        onChanged();
                    }
                } else if (!qVar.f١١٦٤٥c.isEmpty()) {
                    if (this.f١١٦٥١d.u()) {
                        this.f١١٦٥١d.i();
                        x1 x1Var = null;
                        this.f١١٦٥١d = null;
                        this.f١١٦٥٠c = qVar.f١١٦٤٥c;
                        this.f١١٦٤٨a &= -3;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = o();
                        }
                        this.f١١٦٥١d = x1Var;
                    } else {
                        this.f١١٦٥١d.b(qVar.f١١٦٤٥c);
                    }
                }
                if (qVar.z()) {
                    w(qVar.x());
                }
                mergeUnknownFields(qVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof q) {
                    return u((q) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            public b w(r rVar) {
                r rVar2;
                b2 b2Var = this.f١١٦٥٣f;
                if (b2Var == null) {
                    if ((this.f١١٦٤٨a & 4) != 0 && (rVar2 = this.f١١٦٥٢e) != null && rVar2 != r.w()) {
                        q().y(rVar);
                    } else {
                        this.f١١٦٥٢e = rVar;
                    }
                } else {
                    b2Var.g(rVar);
                }
                this.f١١٦٤٨a |= 4;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٦٤٩b = "";
                this.f١١٦٥٠c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦٤٩b = "";
                this.f١١٦٥٠c = Collections.emptyList();
                maybeForceBuilderInitialization();
            }
        }

        private q(h0.b bVar) {
            super(bVar);
            this.f١١٦٤٤b = "";
            this.f١١٦٤٧e = (byte) -1;
        }

        private q() {
            this.f١١٦٤٤b = "";
            this.f١١٦٤٧e = (byte) -1;
            this.f١١٦٤٤b = "";
            this.f١١٦٤٥c = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class r extends h0.e implements g1 {

        /* renamed from: f, reason: collision with root package name */
        private static final r f١١٦٥٤f = new r();

        /* renamed from: g, reason: collision with root package name */
        public static final r1 f١١٦٥٥g = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f١١٦٥٦b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١١٦٥٧c;

        /* renamed from: d, reason: collision with root package name */
        private List f١١٦٥٨d;

        /* renamed from: e, reason: collision with root package name */
        private byte f١١٦٥٩e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public r parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b D = r.D();
                try {
                    D.mergeFrom(iVar, vVar);
                    return D.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(D.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(D.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(D.buildPartial());
                }
            }
        }

        public static b D() {
            return f١١٦٥٤f.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.M;
        }

        static /* synthetic */ int v(r rVar, int i10) {
            int i11 = i10 | rVar.f١١٦٥٦b;
            rVar.f١١٦٥٦b = i11;
            return i11;
        }

        public static r w() {
            return f١١٦٥٤f;
        }

        public int A() {
            return this.f١١٦٥٨d.size();
        }

        public List B() {
            return this.f١١٦٥٨d;
        }

        public boolean C() {
            if ((this.f١١٦٥٦b & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return D();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٥٤f) {
                return new b();
            }
            return new b().y(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof r)) {
                return super.equals(obj);
            }
            r rVar = (r) obj;
            if (C() != rVar.C()) {
                return false;
            }
            if ((!C() || y() == rVar.y()) && B().equals(rVar.B()) && getUnknownFields().equals(rVar.getUnknownFields()) && p().equals(rVar.p())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.f١١٦٥٦b & 1) != 0) {
                i10 = com.google.protobuf.k.e(33, this.f١١٦٥٧c);
            } else {
                i10 = 0;
            }
            for (int i12 = 0; i12 < this.f١١٦٥٨d.size(); i12++) {
                i10 += com.google.protobuf.k.G(999, (e1) this.f١١٦٥٨d.get(i12));
            }
            int o10 = i10 + o() + getUnknownFields().getSerializedSize();
            this.memoizedSize = o10;
            return o10;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (C()) {
                hashCode = (((hashCode * 37) + 33) * 53) + j0.c(y());
            }
            if (A() > 0) {
                hashCode = (((hashCode * 37) + 999) * 53) + B().hashCode();
            }
            int hashFields = (com.google.protobuf.a.hashFields(hashCode, p()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.N.d(r.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٥٩e;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < A(); i10++) {
                if (!z(i10).isInitialized()) {
                    this.f١١٦٥٩e = (byte) 0;
                    return false;
                }
            }
            if (!n()) {
                this.f١١٦٥٩e = (byte) 0;
                return false;
            }
            this.f١١٦٥٩e = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new r();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            h0.e.a q10 = q();
            if ((this.f١١٦٥٦b & 1) != 0) {
                kVar.l0(33, this.f١١٦٥٧c);
            }
            for (int i10 = 0; i10 < this.f١١٦٥٨d.size(); i10++) {
                kVar.H0(999, (e1) this.f١١٦٥٨d.get(i10));
            }
            q10.a(536870912, kVar);
            getUnknownFields().writeTo(kVar);
        }

        @Override // com.google.protobuf.f1
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public r getDefaultInstanceForType() {
            return f١١٦٥٤f;
        }

        public boolean y() {
            return this.f١١٦٥٧c;
        }

        public t z(int i10) {
            return (t) this.f١١٦٥٨d.get(i10);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.d implements g1 {

            /* renamed from: b, reason: collision with root package name */
            private int f١١٦٦٠b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٦٦١c;

            /* renamed from: d, reason: collision with root package name */
            private List f١١٦٦٢d;

            /* renamed from: e, reason: collision with root package name */
            private x1 f١١٦٦٣e;

            private void p(r rVar) {
                int i10 = 1;
                if ((this.f١١٦٦٠b & 1) != 0) {
                    rVar.f١١٦٥٧c = this.f١١٦٦١c;
                } else {
                    i10 = 0;
                }
                r.v(rVar, i10);
            }

            private void q(r rVar) {
                x1 x1Var = this.f١١٦٦٣e;
                if (x1Var != null) {
                    rVar.f١١٦٥٨d = x1Var.g();
                    return;
                }
                if ((this.f١١٦٦٠b & 2) != 0) {
                    this.f١١٦٦٢d = Collections.unmodifiableList(this.f١١٦٦٢d);
                    this.f١١٦٦٠b &= -3;
                }
                rVar.f١١٦٥٨d = this.f١١٦٦٢d;
            }

            private void s() {
                if ((this.f١١٦٦٠b & 2) == 0) {
                    this.f١١٦٦٢d = new ArrayList(this.f١١٦٦٢d);
                    this.f١١٦٦٠b |= 2;
                }
            }

            private x1 w() {
                boolean z10;
                if (this.f١١٦٦٣e == null) {
                    List list = this.f١١٦٦٢d;
                    if ((this.f١١٦٦٠b & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f١١٦٦٣e = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٦٦٢d = null;
                }
                return this.f١١٦٦٣e;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b B(boolean z10) {
                this.f١١٦٦١c = z10;
                this.f١١٦٦٠b |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: C, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.k(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.M;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.N.d(r.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < v(); i10++) {
                    if (!u(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!i()) {
                    return false;
                }
                return true;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.f(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public r build() {
                r buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public r buildPartial() {
                r rVar = new r(this);
                q(rVar);
                if (this.f١١٦٦٠b != 0) {
                    p(rVar);
                }
                onBuilt();
                return rVar;
            }

            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public r getDefaultInstanceForType() {
                return r.w();
            }

            public t u(int i10) {
                x1 x1Var = this.f١١٦٦٣e;
                if (x1Var == null) {
                    return (t) this.f١١٦٦٢d.get(i10);
                }
                return (t) x1Var.o(i10);
            }

            public int v() {
                x1 x1Var = this.f١١٦٦٣e;
                if (x1Var == null) {
                    return this.f١١٦٦٢d.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 264) {
                                    if (K != 7994) {
                                        if (!super.parseUnknownField(iVar, vVar, K)) {
                                        }
                                    } else {
                                        t tVar = (t) iVar.A(t.f١١٦٨٩k, vVar);
                                        x1 x1Var = this.f١١٦٦٣e;
                                        if (x1Var == null) {
                                            s();
                                            this.f١١٦٦٢d.add(tVar);
                                        } else {
                                            x1Var.f(tVar);
                                        }
                                    }
                                } else {
                                    this.f١١٦٦١c = iVar.q();
                                    this.f١١٦٦٠b |= 1;
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b y(r rVar) {
                if (rVar == r.w()) {
                    return this;
                }
                if (rVar.C()) {
                    B(rVar.y());
                }
                if (this.f١١٦٦٣e == null) {
                    if (!rVar.f١١٦٥٨d.isEmpty()) {
                        if (this.f١١٦٦٢d.isEmpty()) {
                            this.f١١٦٦٢d = rVar.f١١٦٥٨d;
                            this.f١١٦٦٠b &= -3;
                        } else {
                            s();
                            this.f١١٦٦٢d.addAll(rVar.f١١٦٥٨d);
                        }
                        onChanged();
                    }
                } else if (!rVar.f١١٦٥٨d.isEmpty()) {
                    if (this.f١١٦٦٣e.u()) {
                        this.f١١٦٦٣e.i();
                        x1 x1Var = null;
                        this.f١١٦٦٣e = null;
                        this.f١١٦٦٢d = rVar.f١١٦٥٨d;
                        this.f١١٦٦٠b &= -3;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = w();
                        }
                        this.f١١٦٦٣e = x1Var;
                    } else {
                        this.f١١٦٦٣e.b(rVar.f١١٦٥٨d);
                    }
                }
                j(rVar);
                mergeUnknownFields(rVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof r) {
                    return y((r) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            private b() {
                this.f١١٦٦٢d = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦٦٢d = Collections.emptyList();
            }
        }

        private r(h0.d dVar) {
            super(dVar);
            this.f١١٦٥٧c = false;
            this.f١١٦٥٩e = (byte) -1;
        }

        private r() {
            this.f١١٦٥٧c = false;
            this.f١١٦٥٩e = (byte) -1;
            this.f١١٦٥٨d = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class s extends h0 implements g1 {

        /* renamed from: c, reason: collision with root package name */
        private static final s f١١٦٦٤c = new s();

        /* renamed from: d, reason: collision with root package name */
        public static final r1 f١١٦٦٥d = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private List f١١٦٦٦a;

        /* renamed from: b, reason: collision with root package name */
        private byte f١١٦٦٧b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public s parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b s10 = s.s();
                try {
                    s10.mergeFrom(iVar, vVar);
                    return s10.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(s10.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(s10.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(s10.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class c extends h0 implements g1 {

            /* renamed from: j, reason: collision with root package name */
            private static final c f١١٦٧١j = new c();

            /* renamed from: k, reason: collision with root package name */
            public static final r1 f١١٦٧٢k = new a();
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f١١٦٧٣a;

            /* renamed from: b, reason: collision with root package name */
            private j0.g f١١٦٧٤b;

            /* renamed from: c, reason: collision with root package name */
            private int f١١٦٧٥c;

            /* renamed from: d, reason: collision with root package name */
            private j0.g f١١٦٧٦d;

            /* renamed from: e, reason: collision with root package name */
            private int f١١٦٧٧e;

            /* renamed from: f, reason: collision with root package name */
            private volatile Object f١١٦٧٨f;

            /* renamed from: g, reason: collision with root package name */
            private volatile Object f١١٦٧٩g;

            /* renamed from: h, reason: collision with root package name */
            private p0 f١١٦٨٠h;

            /* renamed from: i, reason: collision with root package name */
            private byte f١١٦٨١i;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a extends com.google.protobuf.c {
                a() {
                }

                @Override // com.google.protobuf.r1
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public c parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                    b J = c.J();
                    try {
                        J.mergeFrom(iVar, vVar);
                        return J.buildPartial();
                    } catch (i2 e10) {
                        throw e10.a().j(J.buildPartial());
                    } catch (k0 e11) {
                        throw e11.j(J.buildPartial());
                    } catch (IOException e12) {
                        throw new k0(e12).j(J.buildPartial());
                    }
                }
            }

            public static b J() {
                return f١١٦٧١j.toBuilder();
            }

            public static final n.b getDescriptor() {
                return m.W;
            }

            static /* synthetic */ int w(c cVar, int i10) {
                int i11 = i10 | cVar.f١١٦٧٣a;
                cVar.f١١٦٧٣a = i11;
                return i11;
            }

            public static c x() {
                return f١١٦٧١j;
            }

            public int A() {
                return this.f١١٦٨٠h.size();
            }

            public v1 B() {
                return this.f١١٦٨٠h;
            }

            public int C() {
                return this.f١١٦٧٤b.size();
            }

            public List D() {
                return this.f١١٦٧٤b;
            }

            public int E() {
                return this.f١١٦٧٦d.size();
            }

            public List F() {
                return this.f١١٦٧٦d;
            }

            public String G() {
                Object obj = this.f١١٦٧٩g;
                if (obj instanceof String) {
                    return (String) obj;
                }
                com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
                String C = hVar.C();
                if (hVar.r()) {
                    this.f١١٦٧٩g = C;
                }
                return C;
            }

            public boolean H() {
                if ((this.f١١٦٧٣a & 1) != 0) {
                    return true;
                }
                return false;
            }

            public boolean I() {
                if ((this.f١١٦٧٣a & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            /* renamed from: K, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return J();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType(h0.c cVar) {
                return new b(cVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: M, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                if (this == f١١٦٧١j) {
                    return new b();
                }
                return new b().p(this);
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (!D().equals(cVar.D()) || !F().equals(cVar.F()) || H() != cVar.H()) {
                    return false;
                }
                if ((H() && !z().equals(cVar.z())) || I() != cVar.I()) {
                    return false;
                }
                if ((!I() || G().equals(cVar.G())) && B().equals(cVar.B()) && getUnknownFields().equals(cVar.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                int i12 = 0;
                for (int i13 = 0; i13 < this.f١١٦٧٤b.size(); i13++) {
                    i12 += com.google.protobuf.k.y(this.f١١٦٧٤b.getInt(i13));
                }
                if (!D().isEmpty()) {
                    i10 = i12 + 1 + com.google.protobuf.k.y(i12);
                } else {
                    i10 = i12;
                }
                this.f١١٦٧٥c = i12;
                int i14 = 0;
                for (int i15 = 0; i15 < this.f١١٦٧٦d.size(); i15++) {
                    i14 += com.google.protobuf.k.y(this.f١١٦٧٦d.getInt(i15));
                }
                int i16 = i10 + i14;
                if (!F().isEmpty()) {
                    i16 = i16 + 1 + com.google.protobuf.k.y(i14);
                }
                this.f١١٦٧٧e = i14;
                if ((this.f١١٦٧٣a & 1) != 0) {
                    i16 += h0.computeStringSize(3, this.f١١٦٧٨f);
                }
                if ((this.f١١٦٧٣a & 2) != 0) {
                    i16 += h0.computeStringSize(4, this.f١١٦٧٩g);
                }
                int i17 = 0;
                for (int i18 = 0; i18 < this.f١١٦٨٠h.size(); i18++) {
                    i17 += h0.computeStringSizeNoTag(this.f١١٦٨٠h.S(i18));
                }
                int size = i16 + i17 + B().size() + getUnknownFields().getSerializedSize();
                this.memoizedSize = size;
                return size;
            }

            @Override // com.google.protobuf.g1
            public final k2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (C() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + D().hashCode();
                }
                if (E() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + F().hashCode();
                }
                if (H()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + z().hashCode();
                }
                if (I()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + G().hashCode();
                }
                if (A() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + B().hashCode();
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.h0
            protected h0.f internalGetFieldAccessorTable() {
                return m.X.d(c.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                byte b10 = this.f١١٦٨١i;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f١١٦٨١i = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            public Object newInstance(h0.g gVar) {
                return new c();
            }

            @Override // com.google.protobuf.e1
            public void writeTo(com.google.protobuf.k kVar) {
                getSerializedSize();
                if (D().size() > 0) {
                    kVar.T0(10);
                    kVar.T0(this.f١١٦٧٥c);
                }
                for (int i10 = 0; i10 < this.f١١٦٧٤b.size(); i10++) {
                    kVar.E0(this.f١١٦٧٤b.getInt(i10));
                }
                if (F().size() > 0) {
                    kVar.T0(18);
                    kVar.T0(this.f١١٦٧٧e);
                }
                for (int i11 = 0; i11 < this.f١١٦٧٦d.size(); i11++) {
                    kVar.E0(this.f١١٦٧٦d.getInt(i11));
                }
                if ((this.f١١٦٧٣a & 1) != 0) {
                    h0.writeString(kVar, 3, this.f١١٦٧٨f);
                }
                if ((this.f١١٦٧٣a & 2) != 0) {
                    h0.writeString(kVar, 4, this.f١١٦٧٩g);
                }
                for (int i12 = 0; i12 < this.f١١٦٨٠h.size(); i12++) {
                    h0.writeString(kVar, 6, this.f١١٦٨٠h.S(i12));
                }
                getUnknownFields().writeTo(kVar);
            }

            @Override // com.google.protobuf.f1
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public c getDefaultInstanceForType() {
                return f١١٦٧١j;
            }

            public String z() {
                Object obj = this.f١١٦٧٨f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
                String C = hVar.C();
                if (hVar.r()) {
                    this.f١١٦٧٨f = C;
                }
                return C;
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class b extends h0.b implements g1 {

                /* renamed from: a, reason: collision with root package name */
                private int f١١٦٨٢a;

                /* renamed from: b, reason: collision with root package name */
                private j0.g f١١٦٨٣b;

                /* renamed from: c, reason: collision with root package name */
                private j0.g f١١٦٨٤c;

                /* renamed from: d, reason: collision with root package name */
                private Object f١١٦٨٥d;

                /* renamed from: e, reason: collision with root package name */
                private Object f١١٦٨٦e;

                /* renamed from: f, reason: collision with root package name */
                private p0 f١١٦٨٧f;

                private void h(c cVar) {
                    int i10;
                    int i11 = this.f١١٦٨٢a;
                    if ((i11 & 4) != 0) {
                        cVar.f١١٦٧٨f = this.f١١٦٨٥d;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 8) != 0) {
                        cVar.f١١٦٧٩g = this.f١١٦٨٦e;
                        i10 |= 2;
                    }
                    c.w(cVar, i10);
                }

                private void i(c cVar) {
                    if ((this.f١١٦٨٢a & 1) != 0) {
                        this.f١١٦٨٣b.b();
                        this.f١١٦٨٢a &= -2;
                    }
                    cVar.f١١٦٧٤b = this.f١١٦٨٣b;
                    if ((this.f١١٦٨٢a & 2) != 0) {
                        this.f١١٦٨٤c.b();
                        this.f١١٦٨٢a &= -3;
                    }
                    cVar.f١١٦٧٦d = this.f١١٦٨٤c;
                    if ((this.f١١٦٨٢a & 16) != 0) {
                        this.f١١٦٨٧f = this.f١١٦٨٧f.getUnmodifiableView();
                        this.f١١٦٨٢a &= -17;
                    }
                    cVar.f١١٦٨٠h = this.f١١٦٨٧f;
                }

                private void k() {
                    if ((this.f١١٦٨٢a & 16) == 0) {
                        this.f١١٦٨٧f = new o0(this.f١١٦٨٧f);
                        this.f١١٦٨٢a |= 16;
                    }
                }

                private void l() {
                    if ((this.f١١٦٨٢a & 1) == 0) {
                        this.f١١٦٨٣b = h0.mutableCopy(this.f١١٦٨٣b);
                        this.f١١٦٨٢a |= 1;
                    }
                }

                private void m() {
                    if ((this.f١١٦٨٢a & 2) == 0) {
                        this.f١١٦٨٤c = h0.mutableCopy(this.f١١٦٨٤c);
                        this.f١١٦٨٢a |= 2;
                    }
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(n.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public c buildPartial() {
                    c cVar = new c(this);
                    i(cVar);
                    if (this.f١١٦٨٢a != 0) {
                        h(cVar);
                    }
                    onBuilt();
                    return cVar;
                }

                @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
                public n.b getDescriptorForType() {
                    return m.W;
                }

                @Override // com.google.protobuf.h0.b
                protected h0.f internalGetFieldAccessorTable() {
                    return m.X.d(c.class, b.class);
                }

                @Override // com.google.protobuf.f1
                public final boolean isInitialized() {
                    return true;
                }

                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return (b) super.clone();
                }

                @Override // com.google.protobuf.f1
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public c getDefaultInstanceForType() {
                    return c.x();
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                    vVar.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int K = iVar.K();
                                if (K != 0) {
                                    if (K != 8) {
                                        if (K != 10) {
                                            if (K != 16) {
                                                if (K != 18) {
                                                    if (K != 26) {
                                                        if (K != 34) {
                                                            if (K != 50) {
                                                                if (!super.parseUnknownField(iVar, vVar, K)) {
                                                                }
                                                            } else {
                                                                com.google.protobuf.h r10 = iVar.r();
                                                                k();
                                                                this.f١١٦٨٧f.j(r10);
                                                            }
                                                        } else {
                                                            this.f١١٦٨٦e = iVar.r();
                                                            this.f١١٦٨٢a |= 8;
                                                        }
                                                    } else {
                                                        this.f١١٦٨٥d = iVar.r();
                                                        this.f١١٦٨٢a |= 4;
                                                    }
                                                } else {
                                                    int p10 = iVar.p(iVar.C());
                                                    m();
                                                    while (iVar.e() > 0) {
                                                        this.f١١٦٨٤c.E(iVar.y());
                                                    }
                                                    iVar.o(p10);
                                                }
                                            } else {
                                                int y10 = iVar.y();
                                                m();
                                                this.f١١٦٨٤c.E(y10);
                                            }
                                        } else {
                                            int p11 = iVar.p(iVar.C());
                                            l();
                                            while (iVar.e() > 0) {
                                                this.f١١٦٨٣b.E(iVar.y());
                                            }
                                            iVar.o(p11);
                                        }
                                    } else {
                                        int y11 = iVar.y();
                                        l();
                                        this.f١١٦٨٣b.E(y11);
                                    }
                                }
                                z10 = true;
                            } catch (k0 e10) {
                                throw e10.m();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                public b p(c cVar) {
                    if (cVar == c.x()) {
                        return this;
                    }
                    if (!cVar.f١١٦٧٤b.isEmpty()) {
                        if (this.f١١٦٨٣b.isEmpty()) {
                            this.f١١٦٨٣b = cVar.f١١٦٧٤b;
                            this.f١١٦٨٢a &= -2;
                        } else {
                            l();
                            this.f١١٦٨٣b.addAll(cVar.f١١٦٧٤b);
                        }
                        onChanged();
                    }
                    if (!cVar.f١١٦٧٦d.isEmpty()) {
                        if (this.f١١٦٨٤c.isEmpty()) {
                            this.f١١٦٨٤c = cVar.f١١٦٧٦d;
                            this.f١١٦٨٢a &= -3;
                        } else {
                            m();
                            this.f١١٦٨٤c.addAll(cVar.f١١٦٧٦d);
                        }
                        onChanged();
                    }
                    if (cVar.H()) {
                        this.f١١٦٨٥d = cVar.f١١٦٧٨f;
                        this.f١١٦٨٢a |= 4;
                        onChanged();
                    }
                    if (cVar.I()) {
                        this.f١١٦٨٦e = cVar.f١١٦٧٩g;
                        this.f١١٦٨٢a |= 8;
                        onChanged();
                    }
                    if (!cVar.f١١٦٨٠h.isEmpty()) {
                        if (this.f١١٦٨٧f.isEmpty()) {
                            this.f١١٦٨٧f = cVar.f١١٦٨٠h;
                            this.f١١٦٨٢a &= -17;
                        } else {
                            k();
                            this.f١١٦٨٧f.addAll(cVar.f١١٦٨٠h);
                        }
                        onChanged();
                    }
                    mergeUnknownFields(cVar.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(b1 b1Var) {
                    if (b1Var instanceof c) {
                        return p((c) b1Var);
                    }
                    super.mergeFrom(b1Var);
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public final b mergeUnknownFields(k2 k2Var) {
                    return (b) super.mergeUnknownFields(k2Var);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public b setField(n.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: t, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(k2 k2Var) {
                    return (b) super.setUnknownFields(k2Var);
                }

                private b() {
                    this.f١١٦٨٣b = h0.emptyIntList();
                    this.f١١٦٨٤c = h0.emptyIntList();
                    this.f١١٦٨٥d = "";
                    this.f١١٦٨٦e = "";
                    this.f١١٦٨٧f = o0.f١١٨٥٤d;
                }

                private b(h0.c cVar) {
                    super(cVar);
                    this.f١١٦٨٣b = h0.emptyIntList();
                    this.f١١٦٨٤c = h0.emptyIntList();
                    this.f١١٦٨٥d = "";
                    this.f١١٦٨٦e = "";
                    this.f١١٦٨٧f = o0.f١١٨٥٤d;
                }
            }

            private c(h0.b bVar) {
                super(bVar);
                this.f١١٦٧٥c = -1;
                this.f١١٦٧٧e = -1;
                this.f١١٦٧٨f = "";
                this.f١١٦٧٩g = "";
                this.f١١٦٨١i = (byte) -1;
            }

            private c() {
                this.f١١٦٧٥c = -1;
                this.f١١٦٧٧e = -1;
                this.f١١٦٧٨f = "";
                this.f١١٦٧٩g = "";
                this.f١١٦٨١i = (byte) -1;
                this.f١١٦٧٤b = h0.emptyIntList();
                this.f١١٦٧٦d = h0.emptyIntList();
                this.f١١٦٧٨f = "";
                this.f١١٦٧٩g = "";
                this.f١١٦٨٠h = o0.f١١٨٥٤d;
            }
        }

        public static final n.b getDescriptor() {
            return m.U;
        }

        public static s o() {
            return f١١٦٦٤c;
        }

        public static b s() {
            return f١١٦٦٤c.toBuilder();
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof s)) {
                return super.equals(obj);
            }
            s sVar = (s) obj;
            if (r().equals(sVar.r()) && getUnknownFields().equals(sVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f١١٦٦٦a.size(); i12++) {
                i11 += com.google.protobuf.k.G(1, (e1) this.f١١٦٦٦a.get(i12));
            }
            int serializedSize = i11 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (q() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + r().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.V.d(s.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٦٧b;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f١١٦٦٧b = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new s();
        }

        @Override // com.google.protobuf.f1
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public s getDefaultInstanceForType() {
            return f١١٦٦٤c;
        }

        public int q() {
            return this.f١١٦٦٦a.size();
        }

        public List r() {
            return this.f١١٦٦٦a;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return s();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٦٤c) {
                return new b();
            }
            return new b().o(this);
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            for (int i10 = 0; i10 < this.f١١٦٦٦a.size(); i10++) {
                kVar.H0(1, (e1) this.f١١٦٦٦a.get(i10));
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٦٦٨a;

            /* renamed from: b, reason: collision with root package name */
            private List f١١٦٦٩b;

            /* renamed from: c, reason: collision with root package name */
            private x1 f١١٦٧٠c;

            private void h(s sVar) {
            }

            private void i(s sVar) {
                x1 x1Var = this.f١١٦٧٠c;
                if (x1Var != null) {
                    sVar.f١١٦٦٦a = x1Var.g();
                    return;
                }
                if ((this.f١١٦٦٨a & 1) != 0) {
                    this.f١١٦٦٩b = Collections.unmodifiableList(this.f١١٦٦٩b);
                    this.f١١٦٦٨a &= -2;
                }
                sVar.f١١٦٦٦a = this.f١١٦٦٩b;
            }

            private void k() {
                if ((this.f١١٦٦٨a & 1) == 0) {
                    this.f١١٦٦٩b = new ArrayList(this.f١١٦٦٩b);
                    this.f١١٦٦٨a |= 1;
                }
            }

            private x1 m() {
                if (this.f١١٦٧٠c == null) {
                    List list = this.f١١٦٦٩b;
                    boolean z10 = true;
                    if ((this.f١١٦٦٨a & 1) == 0) {
                        z10 = false;
                    }
                    this.f١١٦٧٠c = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٦٦٩b = null;
                }
                return this.f١١٦٧٠c;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public s build() {
                s buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public s buildPartial() {
                s sVar = new s(this);
                i(sVar);
                if (this.f١١٦٦٨a != 0) {
                    h(sVar);
                }
                onBuilt();
                return sVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.U;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.V.d(s.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                return true;
            }

            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public s getDefaultInstanceForType() {
                return s.o();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (!super.parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    c cVar = (c) iVar.A(c.f١١٦٧٢k, vVar);
                                    x1 x1Var = this.f١١٦٧٠c;
                                    if (x1Var == null) {
                                        k();
                                        this.f١١٦٦٩b.add(cVar);
                                    } else {
                                        x1Var.f(cVar);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b o(s sVar) {
                if (sVar == s.o()) {
                    return this;
                }
                if (this.f١١٦٧٠c == null) {
                    if (!sVar.f١١٦٦٦a.isEmpty()) {
                        if (this.f١١٦٦٩b.isEmpty()) {
                            this.f١١٦٦٩b = sVar.f١١٦٦٦a;
                            this.f١١٦٦٨a &= -2;
                        } else {
                            k();
                            this.f١١٦٦٩b.addAll(sVar.f١١٦٦٦a);
                        }
                        onChanged();
                    }
                } else if (!sVar.f١١٦٦٦a.isEmpty()) {
                    if (this.f١١٦٧٠c.u()) {
                        this.f١١٦٧٠c.i();
                        x1 x1Var = null;
                        this.f١١٦٧٠c = null;
                        this.f١١٦٦٩b = sVar.f١١٦٦٦a;
                        this.f١١٦٦٨a &= -2;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = m();
                        }
                        this.f١١٦٧٠c = x1Var;
                    } else {
                        this.f١١٦٧٠c.b(sVar.f١١٦٦٦a);
                    }
                }
                mergeUnknownFields(sVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof s) {
                    return o((s) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: q, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٦٦٩b = Collections.emptyList();
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٦٦٩b = Collections.emptyList();
            }
        }

        private s(h0.b bVar) {
            super(bVar);
            this.f١١٦٦٧b = (byte) -1;
        }

        private s() {
            this.f١١٦٦٧b = (byte) -1;
            this.f١١٦٦٦a = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class t extends h0 implements g1 {

        /* renamed from: j, reason: collision with root package name */
        private static final t f١١٦٨٨j = new t();

        /* renamed from: k, reason: collision with root package name */
        public static final r1 f١١٦٨٩k = new a();
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f١١٦٩٠a;

        /* renamed from: b, reason: collision with root package name */
        private List f١١٦٩١b;

        /* renamed from: c, reason: collision with root package name */
        private volatile Object f١١٦٩٢c;

        /* renamed from: d, reason: collision with root package name */
        private long f١١٦٩٣d;

        /* renamed from: e, reason: collision with root package name */
        private long f١١٦٩٤e;

        /* renamed from: f, reason: collision with root package name */
        private double f١١٦٩٥f;

        /* renamed from: g, reason: collision with root package name */
        private com.google.protobuf.h f١١٦٩٦g;

        /* renamed from: h, reason: collision with root package name */
        private volatile Object f١١٦٩٧h;

        /* renamed from: i, reason: collision with root package name */
        private byte f١١٦٩٨i;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends com.google.protobuf.c {
            a() {
            }

            @Override // com.google.protobuf.r1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public t parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                b O = t.O();
                try {
                    O.mergeFrom(iVar, vVar);
                    return O.buildPartial();
                } catch (i2 e10) {
                    throw e10.a().j(O.buildPartial());
                } catch (k0 e11) {
                    throw e11.j(O.buildPartial());
                } catch (IOException e12) {
                    throw new k0(e12).j(O.buildPartial());
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class c extends h0 implements g1 {

            /* renamed from: e, reason: collision with root package name */
            private static final c f١١٧٠٨e = new c();

            /* renamed from: f, reason: collision with root package name */
            public static final r1 f١١٧٠٩f = new a();
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            private int f١١٧١٠a;

            /* renamed from: b, reason: collision with root package name */
            private volatile Object f١١٧١١b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f١١٧١٢c;

            /* renamed from: d, reason: collision with root package name */
            private byte f١١٧١٣d;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            class a extends com.google.protobuf.c {
                a() {
                }

                @Override // com.google.protobuf.r1
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public c parsePartialFrom(com.google.protobuf.i iVar, v vVar) {
                    b w10 = c.w();
                    try {
                        w10.mergeFrom(iVar, vVar);
                        return w10.buildPartial();
                    } catch (i2 e10) {
                        throw e10.a().j(w10.buildPartial());
                    } catch (k0 e11) {
                        throw e11.j(w10.buildPartial());
                    } catch (IOException e12) {
                        throw new k0(e12).j(w10.buildPartial());
                    }
                }
            }

            public static final n.b getDescriptor() {
                return m.S;
            }

            static /* synthetic */ int p(c cVar, int i10) {
                int i11 = i10 | cVar.f١١٧١٠a;
                cVar.f١١٧١٠a = i11;
                return i11;
            }

            public static c q() {
                return f١١٧٠٨e;
            }

            public static b w() {
                return f١١٧٠٨e.toBuilder();
            }

            @Override // com.google.protobuf.a
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return super.equals(obj);
                }
                c cVar = (c) obj;
                if (v() != cVar.v()) {
                    return false;
                }
                if ((v() && !t().equals(cVar.t())) || u() != cVar.u()) {
                    return false;
                }
                if ((!u() || s() == cVar.s()) && getUnknownFields().equals(cVar.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                if ((this.f١١٧١٠a & 1) != 0) {
                    i10 = h0.computeStringSize(1, this.f١١٧١١b);
                } else {
                    i10 = 0;
                }
                if ((this.f١١٧١٠a & 2) != 0) {
                    i10 += com.google.protobuf.k.e(2, this.f١١٧١٢c);
                }
                int serializedSize = i10 + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.g1
            public final k2 getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.protobuf.a
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (v()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + t().hashCode();
                }
                if (u()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + j0.c(s());
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.h0
            protected h0.f internalGetFieldAccessorTable() {
                return m.T.d(c.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                byte b10 = this.f١١٧١٣d;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (!v()) {
                    this.f١١٧١٣d = (byte) 0;
                    return false;
                }
                if (!u()) {
                    this.f١١٧١٣d = (byte) 0;
                    return false;
                }
                this.f١١٧١٣d = (byte) 1;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            public Object newInstance(h0.g gVar) {
                return new c();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public c getDefaultInstanceForType() {
                return f١١٧٠٨e;
            }

            public boolean s() {
                return this.f١١٧١٢c;
            }

            public String t() {
                Object obj = this.f١١٧١١b;
                if (obj instanceof String) {
                    return (String) obj;
                }
                com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
                String C = hVar.C();
                if (hVar.r()) {
                    this.f١١٧١١b = C;
                }
                return C;
            }

            public boolean u() {
                if ((this.f١١٧١٠a & 2) != 0) {
                    return true;
                }
                return false;
            }

            public boolean v() {
                if ((this.f١١٧١٠a & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.e1
            public void writeTo(com.google.protobuf.k kVar) {
                if ((this.f١١٧١٠a & 1) != 0) {
                    h0.writeString(kVar, 1, this.f١١٧١١b);
                }
                if ((this.f١١٧١٠a & 2) != 0) {
                    kVar.l0(2, this.f١١٧١٢c);
                }
                getUnknownFields().writeTo(kVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType() {
                return w();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.h0
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b newBuilderForType(h0.c cVar) {
                return new b(cVar);
            }

            @Override // com.google.protobuf.e1
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b toBuilder() {
                if (this == f١١٧٠٨e) {
                    return new b();
                }
                return new b().n(this);
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class b extends h0.b implements g1 {

                /* renamed from: a, reason: collision with root package name */
                private int f١١٧١٤a;

                /* renamed from: b, reason: collision with root package name */
                private Object f١١٧١٥b;

                /* renamed from: c, reason: collision with root package name */
                private boolean f١١٧١٦c;

                private void h(c cVar) {
                    int i10;
                    int i11 = this.f١١٧١٤a;
                    if ((i11 & 1) != 0) {
                        cVar.f١١٧١١b = this.f١١٧١٥b;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 2) != 0) {
                        cVar.f١١٧١٢c = this.f١١٧١٦c;
                        i10 |= 2;
                    }
                    c.p(cVar, i10);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public b addRepeatedField(n.g gVar, Object obj) {
                    return (b) super.addRepeatedField(gVar, obj);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
                }

                @Override // com.google.protobuf.e1.a
                /* renamed from: g, reason: merged with bridge method [inline-methods] */
                public c buildPartial() {
                    c cVar = new c(this);
                    if (this.f١١٧١٤a != 0) {
                        h(cVar);
                    }
                    onBuilt();
                    return cVar;
                }

                @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
                public n.b getDescriptorForType() {
                    return m.S;
                }

                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return (b) super.clone();
                }

                @Override // com.google.protobuf.h0.b
                protected h0.f internalGetFieldAccessorTable() {
                    return m.T.d(c.class, b.class);
                }

                @Override // com.google.protobuf.f1
                public final boolean isInitialized() {
                    if (!l() || !k()) {
                        return false;
                    }
                    return true;
                }

                @Override // com.google.protobuf.f1
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public c getDefaultInstanceForType() {
                    return c.q();
                }

                public boolean k() {
                    if ((this.f١١٧١٤a & 2) != 0) {
                        return true;
                    }
                    return false;
                }

                public boolean l() {
                    if ((this.f١١٧١٤a & 1) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                    vVar.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int K = iVar.K();
                                if (K != 0) {
                                    if (K != 10) {
                                        if (K != 16) {
                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                            }
                                        } else {
                                            this.f١١٧١٦c = iVar.q();
                                            this.f١١٧١٤a |= 2;
                                        }
                                    } else {
                                        this.f١١٧١٥b = iVar.r();
                                        this.f١١٧١٤a |= 1;
                                    }
                                }
                                z10 = true;
                            } catch (k0 e10) {
                                throw e10.m();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }

                public b n(c cVar) {
                    if (cVar == c.q()) {
                        return this;
                    }
                    if (cVar.v()) {
                        this.f١١٧١٥b = cVar.f١١٧١١b;
                        this.f١١٧١٤a |= 1;
                        onChanged();
                    }
                    if (cVar.u()) {
                        r(cVar.s());
                    }
                    mergeUnknownFields(cVar.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: o, reason: merged with bridge method [inline-methods] */
                public b mergeFrom(b1 b1Var) {
                    if (b1Var instanceof c) {
                        return n((c) b1Var);
                    }
                    super.mergeFrom(b1Var);
                    return this;
                }

                @Override // com.google.protobuf.a.AbstractC٠١٣٢a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public final b mergeUnknownFields(k2 k2Var) {
                    return (b) super.mergeUnknownFields(k2Var);
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public b setField(n.g gVar, Object obj) {
                    return (b) super.setField(gVar, obj);
                }

                public b r(boolean z10) {
                    this.f١١٧١٦c = z10;
                    this.f١١٧١٤a |= 2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.b1.a
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public final b setUnknownFields(k2 k2Var) {
                    return (b) super.setUnknownFields(k2Var);
                }

                private b() {
                    this.f١١٧١٥b = "";
                }

                private b(h0.c cVar) {
                    super(cVar);
                    this.f١١٧١٥b = "";
                }
            }

            private c(h0.b bVar) {
                super(bVar);
                this.f١١٧١١b = "";
                this.f١١٧١٢c = false;
                this.f١١٧١٣d = (byte) -1;
            }

            private c() {
                this.f١١٧١١b = "";
                this.f١١٧١٢c = false;
                this.f١١٧١٣d = (byte) -1;
                this.f١١٧١١b = "";
            }
        }

        public static b O() {
            return f١١٦٨٨j.toBuilder();
        }

        public static final n.b getDescriptor() {
            return m.Q;
        }

        static /* synthetic */ int w(t tVar, int i10) {
            int i11 = i10 | tVar.f١١٦٩٠a;
            tVar.f١١٦٩٠a = i11;
            return i11;
        }

        public static t y() {
            return f١١٦٨٨j;
        }

        public double A() {
            return this.f١١٦٩٥f;
        }

        public String B() {
            Object obj = this.f١١٦٩٢c;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٦٩٢c = C;
            }
            return C;
        }

        public c C(int i10) {
            return (c) this.f١١٦٩١b.get(i10);
        }

        public int D() {
            return this.f١١٦٩١b.size();
        }

        public List E() {
            return this.f١١٦٩١b;
        }

        public long F() {
            return this.f١١٦٩٤e;
        }

        public long G() {
            return this.f١١٦٩٣d;
        }

        public com.google.protobuf.h H() {
            return this.f١١٦٩٦g;
        }

        public boolean I() {
            if ((this.f١١٦٩٠a & 32) != 0) {
                return true;
            }
            return false;
        }

        public boolean J() {
            if ((this.f١١٦٩٠a & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean K() {
            if ((this.f١١٦٩٠a & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean L() {
            if ((this.f١١٦٩٠a & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean M() {
            if ((this.f١١٦٩٠a & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean N() {
            if ((this.f١١٦٩٠a & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType() {
            return O();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public b newBuilderForType(h0.c cVar) {
            return new b(cVar);
        }

        @Override // com.google.protobuf.e1
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public b toBuilder() {
            if (this == f١١٦٨٨j) {
                return new b();
            }
            return new b().q(this);
        }

        @Override // com.google.protobuf.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof t)) {
                return super.equals(obj);
            }
            t tVar = (t) obj;
            if (!E().equals(tVar.E()) || K() != tVar.K()) {
                return false;
            }
            if ((K() && !B().equals(tVar.B())) || M() != tVar.M()) {
                return false;
            }
            if ((M() && G() != tVar.G()) || L() != tVar.L()) {
                return false;
            }
            if ((L() && F() != tVar.F()) || J() != tVar.J()) {
                return false;
            }
            if ((J() && Double.doubleToLongBits(A()) != Double.doubleToLongBits(tVar.A())) || N() != tVar.N()) {
                return false;
            }
            if ((N() && !H().equals(tVar.H())) || I() != tVar.I()) {
                return false;
            }
            if ((!I() || x().equals(tVar.x())) && getUnknownFields().equals(tVar.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.e1
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f١١٦٩١b.size(); i12++) {
                i11 += com.google.protobuf.k.G(2, (e1) this.f١١٦٩١b.get(i12));
            }
            if ((this.f١١٦٩٠a & 1) != 0) {
                i11 += h0.computeStringSize(3, this.f١١٦٩٢c);
            }
            if ((this.f١١٦٩٠a & 2) != 0) {
                i11 += com.google.protobuf.k.Z(4, this.f١١٦٩٣d);
            }
            if ((this.f١١٦٩٠a & 4) != 0) {
                i11 += com.google.protobuf.k.z(5, this.f١١٦٩٤e);
            }
            if ((this.f١١٦٩٠a & 8) != 0) {
                i11 += com.google.protobuf.k.j(6, this.f١١٦٩٥f);
            }
            if ((this.f١١٦٩٠a & 16) != 0) {
                i11 += com.google.protobuf.k.h(7, this.f١١٦٩٦g);
            }
            if ((this.f١١٦٩٠a & 32) != 0) {
                i11 += h0.computeStringSize(8, this.f١١٦٩٧h);
            }
            int serializedSize = i11 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.a
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (D() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + E().hashCode();
            }
            if (K()) {
                hashCode = (((hashCode * 37) + 3) * 53) + B().hashCode();
            }
            if (M()) {
                hashCode = (((hashCode * 37) + 4) * 53) + j0.h(G());
            }
            if (L()) {
                hashCode = (((hashCode * 37) + 5) * 53) + j0.h(F());
            }
            if (J()) {
                hashCode = (((hashCode * 37) + 6) * 53) + j0.h(Double.doubleToLongBits(A()));
            }
            if (N()) {
                hashCode = (((hashCode * 37) + 7) * 53) + H().hashCode();
            }
            if (I()) {
                hashCode = (((hashCode * 37) + 8) * 53) + x().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.h0
        protected h0.f internalGetFieldAccessorTable() {
            return m.R.d(t.class, b.class);
        }

        @Override // com.google.protobuf.f1
        public final boolean isInitialized() {
            byte b10 = this.f١١٦٩٨i;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            for (int i10 = 0; i10 < D(); i10++) {
                if (!C(i10).isInitialized()) {
                    this.f١١٦٩٨i = (byte) 0;
                    return false;
                }
            }
            this.f١١٦٩٨i = (byte) 1;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0
        public Object newInstance(h0.g gVar) {
            return new t();
        }

        @Override // com.google.protobuf.e1
        public void writeTo(com.google.protobuf.k kVar) {
            for (int i10 = 0; i10 < this.f١١٦٩١b.size(); i10++) {
                kVar.H0(2, (e1) this.f١١٦٩١b.get(i10));
            }
            if ((this.f١١٦٩٠a & 1) != 0) {
                h0.writeString(kVar, 3, this.f١١٦٩٢c);
            }
            if ((this.f١١٦٩٠a & 2) != 0) {
                kVar.U0(4, this.f١١٦٩٣d);
            }
            if ((this.f١١٦٩٠a & 4) != 0) {
                kVar.F0(5, this.f١١٦٩٤e);
            }
            if ((this.f١١٦٩٠a & 8) != 0) {
                kVar.r0(6, this.f١١٦٩٥f);
            }
            if ((this.f١١٦٩٠a & 16) != 0) {
                kVar.p0(7, this.f١١٦٩٦g);
            }
            if ((this.f١١٦٩٠a & 32) != 0) {
                h0.writeString(kVar, 8, this.f١١٦٩٧h);
            }
            getUnknownFields().writeTo(kVar);
        }

        public String x() {
            Object obj = this.f١١٦٩٧h;
            if (obj instanceof String) {
                return (String) obj;
            }
            com.google.protobuf.h hVar = (com.google.protobuf.h) obj;
            String C = hVar.C();
            if (hVar.r()) {
                this.f١١٦٩٧h = C;
            }
            return C;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public t getDefaultInstanceForType() {
            return f١١٦٨٨j;
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class b extends h0.b implements g1 {

            /* renamed from: a, reason: collision with root package name */
            private int f١١٦٩٩a;

            /* renamed from: b, reason: collision with root package name */
            private List f١١٧٠٠b;

            /* renamed from: c, reason: collision with root package name */
            private x1 f١١٧٠١c;

            /* renamed from: d, reason: collision with root package name */
            private Object f١١٧٠٢d;

            /* renamed from: e, reason: collision with root package name */
            private long f١١٧٠٣e;

            /* renamed from: f, reason: collision with root package name */
            private long f١١٧٠٤f;

            /* renamed from: g, reason: collision with root package name */
            private double f١١٧٠٥g;

            /* renamed from: h, reason: collision with root package name */
            private com.google.protobuf.h f١١٧٠٦h;

            /* renamed from: i, reason: collision with root package name */
            private Object f١١٧٠٧i;

            private void h(t tVar) {
                int i10;
                int i11 = this.f١١٦٩٩a;
                if ((i11 & 2) != 0) {
                    tVar.f١١٦٩٢c = this.f١١٧٠٢d;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 4) != 0) {
                    tVar.f١١٦٩٣d = this.f١١٧٠٣e;
                    i10 |= 2;
                }
                if ((i11 & 8) != 0) {
                    tVar.f١١٦٩٤e = this.f١١٧٠٤f;
                    i10 |= 4;
                }
                if ((i11 & 16) != 0) {
                    tVar.f١١٦٩٥f = this.f١١٧٠٥g;
                    i10 |= 8;
                }
                if ((i11 & 32) != 0) {
                    tVar.f١١٦٩٦g = this.f١١٧٠٦h;
                    i10 |= 16;
                }
                if ((i11 & 64) != 0) {
                    tVar.f١١٦٩٧h = this.f١١٧٠٧i;
                    i10 |= 32;
                }
                t.w(tVar, i10);
            }

            private void i(t tVar) {
                x1 x1Var = this.f١١٧٠١c;
                if (x1Var != null) {
                    tVar.f١١٦٩١b = x1Var.g();
                    return;
                }
                if ((this.f١١٦٩٩a & 1) != 0) {
                    this.f١١٧٠٠b = Collections.unmodifiableList(this.f١١٧٠٠b);
                    this.f١١٦٩٩a &= -2;
                }
                tVar.f١١٦٩١b = this.f١١٧٠٠b;
            }

            private void k() {
                if ((this.f١١٦٩٩a & 1) == 0) {
                    this.f١١٧٠٠b = new ArrayList(this.f١١٧٠٠b);
                    this.f١١٦٩٩a |= 1;
                }
            }

            private x1 o() {
                if (this.f١١٧٠١c == null) {
                    List list = this.f١١٧٠٠b;
                    boolean z10 = true;
                    if ((this.f١١٦٩٩a & 1) == 0) {
                        z10 = false;
                    }
                    this.f١١٧٠١c = new x1(list, z10, getParentForChildren(), isClean());
                    this.f١١٧٠٠b = null;
                }
                return this.f١١٧٠١c;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public b addRepeatedField(n.g gVar, Object obj) {
                return (b) super.addRepeatedField(gVar, obj);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public t build() {
                t buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) buildPartial);
            }

            @Override // com.google.protobuf.e1.a
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public t buildPartial() {
                t tVar = new t(this);
                i(tVar);
                if (this.f١١٦٩٩a != 0) {
                    h(tVar);
                }
                onBuilt();
                return tVar;
            }

            @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a, com.google.protobuf.g1
            public n.b getDescriptorForType() {
                return m.Q;
            }

            @Override // com.google.protobuf.h0.b
            protected h0.f internalGetFieldAccessorTable() {
                return m.R.d(t.class, b.class);
            }

            @Override // com.google.protobuf.f1
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < n(); i10++) {
                    if (!m(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return (b) super.clone();
            }

            @Override // com.google.protobuf.f1
            /* renamed from: l, reason: merged with bridge method [inline-methods] */
            public t getDefaultInstanceForType() {
                return t.y();
            }

            public c m(int i10) {
                x1 x1Var = this.f١١٧٠١c;
                if (x1Var == null) {
                    return (c) this.f١١٧٠٠b.get(i10);
                }
                return (c) x1Var.o(i10);
            }

            public int n() {
                x1 x1Var = this.f١١٧٠١c;
                if (x1Var == null) {
                    return this.f١١٧٠٠b.size();
                }
                return x1Var.n();
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a, com.google.protobuf.e1.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(com.google.protobuf.i iVar, v vVar) {
                vVar.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 18) {
                                    if (K != 26) {
                                        if (K != 32) {
                                            if (K != 40) {
                                                if (K != 49) {
                                                    if (K != 58) {
                                                        if (K != 66) {
                                                            if (!super.parseUnknownField(iVar, vVar, K)) {
                                                            }
                                                        } else {
                                                            this.f١١٧٠٧i = iVar.r();
                                                            this.f١١٦٩٩a |= 64;
                                                        }
                                                    } else {
                                                        this.f١١٧٠٦h = iVar.r();
                                                        this.f١١٦٩٩a |= 32;
                                                    }
                                                } else {
                                                    this.f١١٧٠٥g = iVar.s();
                                                    this.f١١٦٩٩a |= 16;
                                                }
                                            } else {
                                                this.f١١٧٠٤f = iVar.z();
                                                this.f١١٦٩٩a |= 8;
                                            }
                                        } else {
                                            this.f١١٧٠٣e = iVar.M();
                                            this.f١١٦٩٩a |= 4;
                                        }
                                    } else {
                                        this.f١١٧٠٢d = iVar.r();
                                        this.f١١٦٩٩a |= 2;
                                    }
                                } else {
                                    c cVar = (c) iVar.A(c.f١١٧٠٩f, vVar);
                                    x1 x1Var = this.f١١٧٠١c;
                                    if (x1Var == null) {
                                        k();
                                        this.f١١٧٠٠b.add(cVar);
                                    } else {
                                        x1Var.f(cVar);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (k0 e10) {
                            throw e10.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }

            public b q(t tVar) {
                if (tVar == t.y()) {
                    return this;
                }
                if (this.f١١٧٠١c == null) {
                    if (!tVar.f١١٦٩١b.isEmpty()) {
                        if (this.f١١٧٠٠b.isEmpty()) {
                            this.f١١٧٠٠b = tVar.f١١٦٩١b;
                            this.f١١٦٩٩a &= -2;
                        } else {
                            k();
                            this.f١١٧٠٠b.addAll(tVar.f١١٦٩١b);
                        }
                        onChanged();
                    }
                } else if (!tVar.f١١٦٩١b.isEmpty()) {
                    if (this.f١١٧٠١c.u()) {
                        this.f١١٧٠١c.i();
                        x1 x1Var = null;
                        this.f١١٧٠١c = null;
                        this.f١١٧٠٠b = tVar.f١١٦٩١b;
                        this.f١١٦٩٩a &= -2;
                        if (h0.alwaysUseFieldBuilders) {
                            x1Var = o();
                        }
                        this.f١١٧٠١c = x1Var;
                    } else {
                        this.f١١٧٠١c.b(tVar.f١١٦٩١b);
                    }
                }
                if (tVar.K()) {
                    this.f١١٧٠٢d = tVar.f١١٦٩٢c;
                    this.f١١٦٩٩a |= 2;
                    onChanged();
                }
                if (tVar.M()) {
                    w(tVar.G());
                }
                if (tVar.L()) {
                    v(tVar.F());
                }
                if (tVar.J()) {
                    t(tVar.A());
                }
                if (tVar.N()) {
                    x(tVar.H());
                }
                if (tVar.I()) {
                    this.f١١٧٠٧i = tVar.f١١٦٩٧h;
                    this.f١١٦٩٩a |= 64;
                    onChanged();
                }
                mergeUnknownFields(tVar.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b mergeFrom(b1 b1Var) {
                if (b1Var instanceof t) {
                    return q((t) b1Var);
                }
                super.mergeFrom(b1Var);
                return this;
            }

            @Override // com.google.protobuf.a.AbstractC٠١٣٢a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public final b mergeUnknownFields(k2 k2Var) {
                return (b) super.mergeUnknownFields(k2Var);
            }

            public b t(double d10) {
                this.f١١٧٠٥g = d10;
                this.f١١٦٩٩a |= 16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b setField(n.g gVar, Object obj) {
                return (b) super.setField(gVar, obj);
            }

            public b v(long j10) {
                this.f١١٧٠٤f = j10;
                this.f١١٦٩٩a |= 8;
                onChanged();
                return this;
            }

            public b w(long j10) {
                this.f١١٧٠٣e = j10;
                this.f١١٦٩٩a |= 4;
                onChanged();
                return this;
            }

            public b x(com.google.protobuf.h hVar) {
                hVar.getClass();
                this.f١١٧٠٦h = hVar;
                this.f١١٦٩٩a |= 32;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.b1.a
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final b setUnknownFields(k2 k2Var) {
                return (b) super.setUnknownFields(k2Var);
            }

            private b() {
                this.f١١٧٠٠b = Collections.emptyList();
                this.f١١٧٠٢d = "";
                this.f١١٧٠٦h = com.google.protobuf.h.f١١٠١١b;
                this.f١١٧٠٧i = "";
            }

            private b(h0.c cVar) {
                super(cVar);
                this.f١١٧٠٠b = Collections.emptyList();
                this.f١١٧٠٢d = "";
                this.f١١٧٠٦h = com.google.protobuf.h.f١١٠١١b;
                this.f١١٧٠٧i = "";
            }
        }

        private t(h0.b bVar) {
            super(bVar);
            this.f١١٦٩٢c = "";
            this.f١١٦٩٣d = 0L;
            this.f١١٦٩٤e = 0L;
            this.f١١٦٩٥f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.f١١٦٩٦g = com.google.protobuf.h.f١١٠١١b;
            this.f١١٦٩٧h = "";
            this.f١١٦٩٨i = (byte) -1;
        }

        private t() {
            this.f١١٦٩٢c = "";
            this.f١١٦٩٣d = 0L;
            this.f١١٦٩٤e = 0L;
            this.f١١٦٩٥f = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            com.google.protobuf.h hVar = com.google.protobuf.h.f١١٠١١b;
            this.f١١٦٩٦g = hVar;
            this.f١١٦٩٧h = "";
            this.f١١٦٩٨i = (byte) -1;
            this.f١١٦٩١b = Collections.emptyList();
            this.f١١٦٩٢c = "";
            this.f١١٦٩٦g = hVar;
            this.f١١٦٩٧h = "";
        }
    }

    static {
        n.b bVar = (n.b) W().j().get(0);
        f١١٢٣٧a = bVar;
        f١١٢٣٩b = new h0.f(bVar, new String[]{"File"});
        n.b bVar2 = (n.b) W().j().get(1);
        f١١٢٤١c = bVar2;
        f١١٢٤٣d = new h0.f(bVar2, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        n.b bVar3 = (n.b) W().j().get(2);
        f١١٢٤٤e = bVar3;
        f١١٢٤٥f = new h0.f(bVar3, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        n.b bVar4 = (n.b) bVar3.k().get(0);
        f١١٢٤٦g = bVar4;
        f١١٢٤٧h = new h0.f(bVar4, new String[]{"Start", "End", "Options"});
        n.b bVar5 = (n.b) bVar3.k().get(1);
        f١١٢٤٨i = bVar5;
        f١١٢٤٩j = new h0.f(bVar5, new String[]{"Start", "End"});
        n.b bVar6 = (n.b) W().j().get(3);
        f١١٢٥٠k = bVar6;
        f١١٢٥١l = new h0.f(bVar6, new String[]{"UninterpretedOption"});
        n.b bVar7 = (n.b) W().j().get(4);
        f١١٢٥٢m = bVar7;
        f١١٢٥٣n = new h0.f(bVar7, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options", "Proto3Optional"});
        n.b bVar8 = (n.b) W().j().get(5);
        f١١٢٥٤o = bVar8;
        f١١٢٥٥p = new h0.f(bVar8, new String[]{"Name", "Options"});
        n.b bVar9 = (n.b) W().j().get(6);
        f١١٢٥٦q = bVar9;
        f١١٢٥٧r = new h0.f(bVar9, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
        n.b bVar10 = (n.b) bVar9.k().get(0);
        f١١٢٥٨s = bVar10;
        f١١٢٥٩t = new h0.f(bVar10, new String[]{"Start", "End"});
        n.b bVar11 = (n.b) W().j().get(7);
        f١١٢٦٠u = bVar11;
        f١١٢٦١v = new h0.f(bVar11, new String[]{"Name", "Number", "Options"});
        n.b bVar12 = (n.b) W().j().get(8);
        f١١٢٦٢w = bVar12;
        f١١٢٦٣x = new h0.f(bVar12, new String[]{"Name", "Method", "Options"});
        n.b bVar13 = (n.b) W().j().get(9);
        f١١٢٦٤y = bVar13;
        f١١٢٦٥z = new h0.f(bVar13, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        n.b bVar14 = (n.b) W().j().get(10);
        A = bVar14;
        f١١٢٣٦B = new h0.f(bVar14, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
        n.b bVar15 = (n.b) W().j().get(11);
        C = bVar15;
        D = new h0.f(bVar15, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        n.b bVar16 = (n.b) W().j().get(12);
        E = bVar16;
        F = new h0.f(bVar16, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "UnverifiedLazy", "Deprecated", "Weak", "UninterpretedOption"});
        n.b bVar17 = (n.b) W().j().get(13);
        G = bVar17;
        H = new h0.f(bVar17, new String[]{"UninterpretedOption"});
        n.b bVar18 = (n.b) W().j().get(14);
        I = bVar18;
        J = new h0.f(bVar18, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        n.b bVar19 = (n.b) W().j().get(15);
        K = bVar19;
        L = new h0.f(bVar19, new String[]{"Deprecated", "UninterpretedOption"});
        n.b bVar20 = (n.b) W().j().get(16);
        M = bVar20;
        N = new h0.f(bVar20, new String[]{"Deprecated", "UninterpretedOption"});
        n.b bVar21 = (n.b) W().j().get(17);
        O = bVar21;
        P = new h0.f(bVar21, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
        n.b bVar22 = (n.b) W().j().get(18);
        Q = bVar22;
        R = new h0.f(bVar22, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        n.b bVar23 = (n.b) bVar22.k().get(0);
        S = bVar23;
        T = new h0.f(bVar23, new String[]{"NamePart", "IsExtension"});
        n.b bVar24 = (n.b) W().j().get(19);
        U = bVar24;
        V = new h0.f(bVar24, new String[]{"Location"});
        n.b bVar25 = (n.b) bVar24.k().get(0);
        W = bVar25;
        X = new h0.f(bVar25, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        n.b bVar26 = (n.b) W().j().get(20);
        Y = bVar26;
        Z = new h0.f(bVar26, new String[]{"Annotation"});
        n.b bVar27 = (n.b) bVar26.k().get(0);
        f١١٢٣٨a0 = bVar27;
        f١١٢٤٠b0 = new h0.f(bVar27, new String[]{"Path", "SourceFile", "Begin", "End"});
    }

    public static n.h W() {
        return f١١٢٤٢c0;
    }
}
