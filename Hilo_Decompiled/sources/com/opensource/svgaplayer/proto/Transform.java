package com.opensource.svgaplayer.proto;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new ProtoAdapter_Transform();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float f١٢١٠٤a;

    /* renamed from: b, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float f١٢١٠٥b;

    /* renamed from: c, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float f١٢١٠٦c;

    /* renamed from: d, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float f١٢١٠٧d;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder extends Message.Builder<Transform, Builder> {

        /* renamed from: a, reason: collision with root package name */
        public Float f١٢١٠٨a;

        /* renamed from: b, reason: collision with root package name */
        public Float f١٢١٠٩b;

        /* renamed from: c, reason: collision with root package name */
        public Float f١٢١١٠c;

        /* renamed from: d, reason: collision with root package name */
        public Float f١٢١١١d;
        public Float tx;
        public Float ty;

        public Builder a(Float f10) {
            this.f١٢١٠٨a = f10;
            return this;
        }

        public Builder b(Float f10) {
            this.f١٢١٠٩b = f10;
            return this;
        }

        public Builder c(Float f10) {
            this.f١٢١١٠c = f10;
            return this;
        }

        public Builder d(Float f10) {
            this.f١٢١١١d = f10;
            return this;
        }

        public Builder tx(Float f10) {
            this.tx = f10;
            return this;
        }

        public Builder ty(Float f10) {
            this.ty = f10;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public Transform m٥٠٩build() {
            return new Transform(this.f١٢١٠٨a, this.f١٢١٠٩b, this.f١٢١١٠c, this.f١٢١١١d, this.tx, this.ty, super.buildUnknownFields());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Transform m٥١٠decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.a((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 2:
                            builder.b((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 3:
                            builder.c((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 4:
                            builder.d((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 5:
                            builder.tx((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        case 6:
                            builder.ty((Float) ProtoAdapter.FLOAT.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.m٥٠٩build();
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Transform transform) throws IOException {
            Float f10 = transform.f١٢١٠٤a;
            if (f10 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
            }
            Float f11 = transform.f١٢١٠٥b;
            if (f11 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
            }
            Float f12 = transform.f١٢١٠٦c;
            if (f12 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
            }
            Float f13 = transform.f١٢١٠٧d;
            if (f13 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
            }
            Float f14 = transform.tx;
            if (f14 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, f14);
            }
            Float f15 = transform.ty;
            if (f15 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f15);
            }
            protoWriter.writeBytes(transform.unknownFields());
        }

        public int encodedSize(Transform transform) {
            Float f10 = transform.f١٢١٠٤a;
            int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
            Float f11 = transform.f١٢١٠٥b;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
            Float f12 = transform.f١٢١٠٦c;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
            Float f13 = transform.f١٢١٠٧d;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0);
            Float f14 = transform.tx;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f14 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f14) : 0);
            Float f15 = transform.ty;
            return encodedSizeWithTag5 + (f15 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f15) : 0) + transform.unknownFields().size();
        }

        public Transform redact(Transform transform) {
            Builder builder = transform.m٥٠٨newBuilder();
            builder.clearUnknownFields();
            return builder.m٥٠٩build();
        }
    }

    static {
        Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f10, Float f11, Float f12, Float f13, Float f14, Float f15) {
        this(f10, f11, f12, f13, f14, f15, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Transform)) {
            return false;
        }
        Transform transform = (Transform) obj;
        if (unknownFields().equals(transform.unknownFields()) && Internal.equals(this.f١٢١٠٤a, transform.f١٢١٠٤a) && Internal.equals(this.f١٢١٠٥b, transform.f١٢١٠٥b) && Internal.equals(this.f١٢١٠٦c, transform.f١٢١٠٦c) && Internal.equals(this.f١٢١٠٧d, transform.f١٢١٠٧d) && Internal.equals(this.tx, transform.tx) && Internal.equals(this.ty, transform.ty)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = ((Message) this).hashCode;
        if (i15 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f10 = this.f١٢١٠٤a;
            int i16 = 0;
            if (f10 != null) {
                i10 = f10.hashCode();
            } else {
                i10 = 0;
            }
            int i17 = (hashCode + i10) * 37;
            Float f11 = this.f١٢١٠٥b;
            if (f11 != null) {
                i11 = f11.hashCode();
            } else {
                i11 = 0;
            }
            int i18 = (i17 + i11) * 37;
            Float f12 = this.f١٢١٠٦c;
            if (f12 != null) {
                i12 = f12.hashCode();
            } else {
                i12 = 0;
            }
            int i19 = (i18 + i12) * 37;
            Float f13 = this.f١٢١٠٧d;
            if (f13 != null) {
                i13 = f13.hashCode();
            } else {
                i13 = 0;
            }
            int i20 = (i19 + i13) * 37;
            Float f14 = this.tx;
            if (f14 != null) {
                i14 = f14.hashCode();
            } else {
                i14 = 0;
            }
            int i21 = (i20 + i14) * 37;
            Float f15 = this.ty;
            if (f15 != null) {
                i16 = f15.hashCode();
            }
            int i22 = i21 + i16;
            ((Message) this).hashCode = i22;
            return i22;
        }
        return i15;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f١٢١٠٤a != null) {
            sb.append(", a=");
            sb.append(this.f١٢١٠٤a);
        }
        if (this.f١٢١٠٥b != null) {
            sb.append(", b=");
            sb.append(this.f١٢١٠٥b);
        }
        if (this.f١٢١٠٦c != null) {
            sb.append(", c=");
            sb.append(this.f١٢١٠٦c);
        }
        if (this.f١٢١٠٧d != null) {
            sb.append(", d=");
            sb.append(this.f١٢١٠٧d);
        }
        if (this.tx != null) {
            sb.append(", tx=");
            sb.append(this.tx);
        }
        if (this.ty != null) {
            sb.append(", ty=");
            sb.append(this.ty);
        }
        StringBuilder replace = sb.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }

    public Transform(Float f10, Float f11, Float f12, Float f13, Float f14, Float f15, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f١٢١٠٤a = f10;
        this.f١٢١٠٥b = f11;
        this.f١٢١٠٦c = f12;
        this.f١٢١٠٧d = f13;
        this.tx = f14;
        this.ty = f15;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m٥٠٨newBuilder() {
        Builder builder = new Builder();
        builder.f١٢١٠٨a = this.f١٢١٠٤a;
        builder.f١٢١٠٩b = this.f١٢١٠٥b;
        builder.f١٢١١٠c = this.f١٢١٠٦c;
        builder.f١٢١١١d = this.f١٢١٠٧d;
        builder.tx = this.tx;
        builder.ty = this.ty;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
