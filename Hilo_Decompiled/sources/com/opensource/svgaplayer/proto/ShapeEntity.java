package com.opensource.svgaplayer.proto;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ShapeEntity extends Message<ShapeEntity, Builder> {
    public static final ProtoAdapter<ShapeEntity> ADAPTER = new ProtoAdapter_ShapeEntity();
    public static final ShapeType DEFAULT_TYPE = ShapeType.SHAPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs#ADAPTER", tag = 4)
    public final EllipseArgs ellipse;

    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$RectArgs#ADAPTER", tag = 3)
    public final RectArgs rect;

    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs#ADAPTER", tag = 2)
    public final ShapeArgs shape;

    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle#ADAPTER", tag = 10)
    public final ShapeStyle styles;

    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 11)
    public final Transform transform;

    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeType#ADAPTER", tag = 1)
    public final ShapeType type;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder extends Message.Builder<ShapeEntity, Builder> {
        public EllipseArgs ellipse;
        public RectArgs rect;
        public ShapeArgs shape;
        public ShapeStyle styles;
        public Transform transform;
        public ShapeType type;

        public Builder ellipse(EllipseArgs ellipseArgs) {
            this.ellipse = ellipseArgs;
            this.shape = null;
            this.rect = null;
            return this;
        }

        public Builder rect(RectArgs rectArgs) {
            this.rect = rectArgs;
            this.shape = null;
            this.ellipse = null;
            return this;
        }

        public Builder shape(ShapeArgs shapeArgs) {
            this.shape = shapeArgs;
            this.rect = null;
            this.ellipse = null;
            return this;
        }

        public Builder styles(ShapeStyle shapeStyle) {
            this.styles = shapeStyle;
            return this;
        }

        public Builder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        public Builder type(ShapeType shapeType) {
            this.type = shapeType;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public ShapeEntity m٤٨٨build() {
            return new ShapeEntity(this.type, this.styles, this.transform, this.shape, this.rect, this.ellipse, super.buildUnknownFields());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class EllipseArgs extends Message<EllipseArgs, Builder> {
        public static final ProtoAdapter<EllipseArgs> ADAPTER = new ProtoAdapter_EllipseArgs();
        public static final Float DEFAULT_RADIUSX;
        public static final Float DEFAULT_RADIUSY;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float radiusX;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float radiusY;

        /* renamed from: x, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float f١٢٠٨٦x;

        /* renamed from: y, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float f١٢٠٨٧y;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class Builder extends Message.Builder<EllipseArgs, Builder> {
            public Float radiusX;
            public Float radiusY;

            /* renamed from: x, reason: collision with root package name */
            public Float f١٢٠٨٨x;

            /* renamed from: y, reason: collision with root package name */
            public Float f١٢٠٨٩y;

            public Builder radiusX(Float f10) {
                this.radiusX = f10;
                return this;
            }

            public Builder radiusY(Float f10) {
                this.radiusY = f10;
                return this;
            }

            public Builder x(Float f10) {
                this.f١٢٠٨٨x = f10;
                return this;
            }

            public Builder y(Float f10) {
                this.f١٢٠٨٩y = f10;
                return this;
            }

            /* renamed from: build, reason: merged with bridge method [inline-methods] */
            public EllipseArgs m٤٩٠build() {
                return new EllipseArgs(this.f١٢٠٨٨x, this.f١٢٠٨٩y, this.radiusX, this.radiusY, super.buildUnknownFields());
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class ProtoAdapter_EllipseArgs extends ProtoAdapter<EllipseArgs> {
            ProtoAdapter_EllipseArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
            }

            /* renamed from: decode, reason: merged with bridge method [inline-methods] */
            public EllipseArgs m٤٩١decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.m٤٩٠build();
                    }
                    if (nextTag == 1) {
                        builder.x((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 2) {
                        builder.y((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 3) {
                        builder.radiusX((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag != 4) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.radiusY((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    }
                }
            }

            public void encode(ProtoWriter protoWriter, EllipseArgs ellipseArgs) throws IOException {
                Float f10 = ellipseArgs.f١٢٠٨٦x;
                if (f10 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
                }
                Float f11 = ellipseArgs.f١٢٠٨٧y;
                if (f11 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
                }
                Float f12 = ellipseArgs.radiusX;
                if (f12 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
                }
                Float f13 = ellipseArgs.radiusY;
                if (f13 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
                }
                protoWriter.writeBytes(ellipseArgs.unknownFields());
            }

            public int encodedSize(EllipseArgs ellipseArgs) {
                Float f10 = ellipseArgs.f١٢٠٨٦x;
                int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
                Float f11 = ellipseArgs.f١٢٠٨٧y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
                Float f12 = ellipseArgs.radiusX;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
                Float f13 = ellipseArgs.radiusY;
                return encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0) + ellipseArgs.unknownFields().size();
            }

            public EllipseArgs redact(EllipseArgs ellipseArgs) {
                Builder builder = ellipseArgs.m٤٨٩newBuilder();
                builder.clearUnknownFields();
                return builder.m٤٩٠build();
            }
        }

        static {
            Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_RADIUSX = valueOf;
            DEFAULT_RADIUSY = valueOf;
        }

        public EllipseArgs(Float f10, Float f11, Float f12, Float f13) {
            this(f10, f11, f12, f13, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EllipseArgs)) {
                return false;
            }
            EllipseArgs ellipseArgs = (EllipseArgs) obj;
            if (unknownFields().equals(ellipseArgs.unknownFields()) && Internal.equals(this.f١٢٠٨٦x, ellipseArgs.f١٢٠٨٦x) && Internal.equals(this.f١٢٠٨٧y, ellipseArgs.f١٢٠٨٧y) && Internal.equals(this.radiusX, ellipseArgs.radiusX) && Internal.equals(this.radiusY, ellipseArgs.radiusY)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13 = ((Message) this).hashCode;
            if (i13 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f10 = this.f١٢٠٨٦x;
                int i14 = 0;
                if (f10 != null) {
                    i10 = f10.hashCode();
                } else {
                    i10 = 0;
                }
                int i15 = (hashCode + i10) * 37;
                Float f11 = this.f١٢٠٨٧y;
                if (f11 != null) {
                    i11 = f11.hashCode();
                } else {
                    i11 = 0;
                }
                int i16 = (i15 + i11) * 37;
                Float f12 = this.radiusX;
                if (f12 != null) {
                    i12 = f12.hashCode();
                } else {
                    i12 = 0;
                }
                int i17 = (i16 + i12) * 37;
                Float f13 = this.radiusY;
                if (f13 != null) {
                    i14 = f13.hashCode();
                }
                int i18 = i17 + i14;
                ((Message) this).hashCode = i18;
                return i18;
            }
            return i13;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f١٢٠٨٦x != null) {
                sb.append(", x=");
                sb.append(this.f١٢٠٨٦x);
            }
            if (this.f١٢٠٨٧y != null) {
                sb.append(", y=");
                sb.append(this.f١٢٠٨٧y);
            }
            if (this.radiusX != null) {
                sb.append(", radiusX=");
                sb.append(this.radiusX);
            }
            if (this.radiusY != null) {
                sb.append(", radiusY=");
                sb.append(this.radiusY);
            }
            StringBuilder replace = sb.replace(0, 2, "EllipseArgs{");
            replace.append('}');
            return replace.toString();
        }

        public EllipseArgs(Float f10, Float f11, Float f12, Float f13, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f١٢٠٨٦x = f10;
            this.f١٢٠٨٧y = f11;
            this.radiusX = f12;
            this.radiusY = f13;
        }

        /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
        public Builder m٤٨٩newBuilder() {
            Builder builder = new Builder();
            builder.f١٢٠٨٨x = this.f١٢٠٨٦x;
            builder.f١٢٠٨٩y = this.f١٢٠٨٧y;
            builder.radiusX = this.radiusX;
            builder.radiusY = this.radiusY;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class ProtoAdapter_ShapeEntity extends ProtoAdapter<ShapeEntity> {
        ProtoAdapter_ShapeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ShapeEntity m٤٩٢decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m٤٨٨build();
                }
                if (nextTag == 1) {
                    try {
                        builder.type((ShapeType) ShapeType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e10) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e10.value));
                    }
                } else if (nextTag == 2) {
                    builder.shape((ShapeArgs) ShapeArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.rect((RectArgs) RectArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.ellipse((EllipseArgs) EllipseArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 10) {
                    builder.styles((ShapeStyle) ShapeStyle.ADAPTER.decode(protoReader));
                } else if (nextTag != 11) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.transform((Transform) Transform.ADAPTER.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ShapeEntity shapeEntity) throws IOException {
            ShapeType shapeType = shapeEntity.type;
            if (shapeType != null) {
                ShapeType.ADAPTER.encodeWithTag(protoWriter, 1, shapeType);
            }
            ShapeStyle shapeStyle = shapeEntity.styles;
            if (shapeStyle != null) {
                ShapeStyle.ADAPTER.encodeWithTag(protoWriter, 10, shapeStyle);
            }
            Transform transform = shapeEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.encodeWithTag(protoWriter, 11, transform);
            }
            ShapeArgs shapeArgs = shapeEntity.shape;
            if (shapeArgs != null) {
                ShapeArgs.ADAPTER.encodeWithTag(protoWriter, 2, shapeArgs);
            }
            RectArgs rectArgs = shapeEntity.rect;
            if (rectArgs != null) {
                RectArgs.ADAPTER.encodeWithTag(protoWriter, 3, rectArgs);
            }
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                EllipseArgs.ADAPTER.encodeWithTag(protoWriter, 4, ellipseArgs);
            }
            protoWriter.writeBytes(shapeEntity.unknownFields());
        }

        public int encodedSize(ShapeEntity shapeEntity) {
            ShapeType shapeType = shapeEntity.type;
            int encodedSizeWithTag = shapeType != null ? ShapeType.ADAPTER.encodedSizeWithTag(1, shapeType) : 0;
            ShapeStyle shapeStyle = shapeEntity.styles;
            int encodedSizeWithTag2 = encodedSizeWithTag + (shapeStyle != null ? ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeStyle) : 0);
            Transform transform = shapeEntity.transform;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(11, transform) : 0);
            ShapeArgs shapeArgs = shapeEntity.shape;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (shapeArgs != null ? ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeArgs) : 0);
            RectArgs rectArgs = shapeEntity.rect;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (rectArgs != null ? RectArgs.ADAPTER.encodedSizeWithTag(3, rectArgs) : 0);
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            return encodedSizeWithTag5 + (ellipseArgs != null ? EllipseArgs.ADAPTER.encodedSizeWithTag(4, ellipseArgs) : 0) + shapeEntity.unknownFields().size();
        }

        public ShapeEntity redact(ShapeEntity shapeEntity) {
            Builder builder = shapeEntity.m٤٨٧newBuilder();
            ShapeStyle shapeStyle = builder.styles;
            if (shapeStyle != null) {
                builder.styles = (ShapeStyle) ShapeStyle.ADAPTER.redact(shapeStyle);
            }
            Transform transform = builder.transform;
            if (transform != null) {
                builder.transform = (Transform) Transform.ADAPTER.redact(transform);
            }
            ShapeArgs shapeArgs = builder.shape;
            if (shapeArgs != null) {
                builder.shape = (ShapeArgs) ShapeArgs.ADAPTER.redact(shapeArgs);
            }
            RectArgs rectArgs = builder.rect;
            if (rectArgs != null) {
                builder.rect = (RectArgs) RectArgs.ADAPTER.redact(rectArgs);
            }
            EllipseArgs ellipseArgs = builder.ellipse;
            if (ellipseArgs != null) {
                builder.ellipse = (EllipseArgs) EllipseArgs.ADAPTER.redact(ellipseArgs);
            }
            builder.clearUnknownFields();
            return builder.m٤٨٨build();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class RectArgs extends Message<RectArgs, Builder> {
        public static final ProtoAdapter<RectArgs> ADAPTER = new ProtoAdapter_RectArgs();
        public static final Float DEFAULT_CORNERRADIUS;
        public static final Float DEFAULT_HEIGHT;
        public static final Float DEFAULT_WIDTH;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        public final Float cornerRadius;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float height;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float width;

        /* renamed from: x, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float f١٢٠٩٠x;

        /* renamed from: y, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float f١٢٠٩١y;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class Builder extends Message.Builder<RectArgs, Builder> {
            public Float cornerRadius;
            public Float height;
            public Float width;

            /* renamed from: x, reason: collision with root package name */
            public Float f١٢٠٩٢x;

            /* renamed from: y, reason: collision with root package name */
            public Float f١٢٠٩٣y;

            public Builder cornerRadius(Float f10) {
                this.cornerRadius = f10;
                return this;
            }

            public Builder height(Float f10) {
                this.height = f10;
                return this;
            }

            public Builder width(Float f10) {
                this.width = f10;
                return this;
            }

            public Builder x(Float f10) {
                this.f١٢٠٩٢x = f10;
                return this;
            }

            public Builder y(Float f10) {
                this.f١٢٠٩٣y = f10;
                return this;
            }

            /* renamed from: build, reason: merged with bridge method [inline-methods] */
            public RectArgs m٤٩٤build() {
                return new RectArgs(this.f١٢٠٩٢x, this.f١٢٠٩٣y, this.width, this.height, this.cornerRadius, super.buildUnknownFields());
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class ProtoAdapter_RectArgs extends ProtoAdapter<RectArgs> {
            ProtoAdapter_RectArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
            }

            /* renamed from: decode, reason: merged with bridge method [inline-methods] */
            public RectArgs m٤٩٥decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.m٤٩٤build();
                    }
                    if (nextTag == 1) {
                        builder.x((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 2) {
                        builder.y((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 3) {
                        builder.width((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 4) {
                        builder.height((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag != 5) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.cornerRadius((Float) ProtoAdapter.FLOAT.decode(protoReader));
                    }
                }
            }

            public void encode(ProtoWriter protoWriter, RectArgs rectArgs) throws IOException {
                Float f10 = rectArgs.f١٢٠٩٠x;
                if (f10 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
                }
                Float f11 = rectArgs.f١٢٠٩١y;
                if (f11 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
                }
                Float f12 = rectArgs.width;
                if (f12 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
                }
                Float f13 = rectArgs.height;
                if (f13 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
                }
                Float f14 = rectArgs.cornerRadius;
                if (f14 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, f14);
                }
                protoWriter.writeBytes(rectArgs.unknownFields());
            }

            public int encodedSize(RectArgs rectArgs) {
                Float f10 = rectArgs.f١٢٠٩٠x;
                int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
                Float f11 = rectArgs.f١٢٠٩١y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
                Float f12 = rectArgs.width;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
                Float f13 = rectArgs.height;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0);
                Float f14 = rectArgs.cornerRadius;
                return encodedSizeWithTag4 + (f14 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f14) : 0) + rectArgs.unknownFields().size();
            }

            public RectArgs redact(RectArgs rectArgs) {
                Builder builder = rectArgs.m٤٩٣newBuilder();
                builder.clearUnknownFields();
                return builder.m٤٩٤build();
            }
        }

        static {
            Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_WIDTH = valueOf;
            DEFAULT_HEIGHT = valueOf;
            DEFAULT_CORNERRADIUS = valueOf;
        }

        public RectArgs(Float f10, Float f11, Float f12, Float f13, Float f14) {
            this(f10, f11, f12, f13, f14, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RectArgs)) {
                return false;
            }
            RectArgs rectArgs = (RectArgs) obj;
            if (unknownFields().equals(rectArgs.unknownFields()) && Internal.equals(this.f١٢٠٩٠x, rectArgs.f١٢٠٩٠x) && Internal.equals(this.f١٢٠٩١y, rectArgs.f١٢٠٩١y) && Internal.equals(this.width, rectArgs.width) && Internal.equals(this.height, rectArgs.height) && Internal.equals(this.cornerRadius, rectArgs.cornerRadius)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14 = ((Message) this).hashCode;
            if (i14 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f10 = this.f١٢٠٩٠x;
                int i15 = 0;
                if (f10 != null) {
                    i10 = f10.hashCode();
                } else {
                    i10 = 0;
                }
                int i16 = (hashCode + i10) * 37;
                Float f11 = this.f١٢٠٩١y;
                if (f11 != null) {
                    i11 = f11.hashCode();
                } else {
                    i11 = 0;
                }
                int i17 = (i16 + i11) * 37;
                Float f12 = this.width;
                if (f12 != null) {
                    i12 = f12.hashCode();
                } else {
                    i12 = 0;
                }
                int i18 = (i17 + i12) * 37;
                Float f13 = this.height;
                if (f13 != null) {
                    i13 = f13.hashCode();
                } else {
                    i13 = 0;
                }
                int i19 = (i18 + i13) * 37;
                Float f14 = this.cornerRadius;
                if (f14 != null) {
                    i15 = f14.hashCode();
                }
                int i20 = i19 + i15;
                ((Message) this).hashCode = i20;
                return i20;
            }
            return i14;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f١٢٠٩٠x != null) {
                sb.append(", x=");
                sb.append(this.f١٢٠٩٠x);
            }
            if (this.f١٢٠٩١y != null) {
                sb.append(", y=");
                sb.append(this.f١٢٠٩١y);
            }
            if (this.width != null) {
                sb.append(", width=");
                sb.append(this.width);
            }
            if (this.height != null) {
                sb.append(", height=");
                sb.append(this.height);
            }
            if (this.cornerRadius != null) {
                sb.append(", cornerRadius=");
                sb.append(this.cornerRadius);
            }
            StringBuilder replace = sb.replace(0, 2, "RectArgs{");
            replace.append('}');
            return replace.toString();
        }

        public RectArgs(Float f10, Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f١٢٠٩٠x = f10;
            this.f١٢٠٩١y = f11;
            this.width = f12;
            this.height = f13;
            this.cornerRadius = f14;
        }

        /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
        public Builder m٤٩٣newBuilder() {
            Builder builder = new Builder();
            builder.f١٢٠٩٢x = this.f١٢٠٩٠x;
            builder.f١٢٠٩٣y = this.f١٢٠٩١y;
            builder.width = this.width;
            builder.height = this.height;
            builder.cornerRadius = this.cornerRadius;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static final ProtoAdapter<ShapeArgs> ADAPTER = new ProtoAdapter_ShapeArgs();
        public static final String DEFAULT_D = "";
        private static final long serialVersionUID = 0;

        /* renamed from: d, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String f١٢٠٩٤d;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class Builder extends Message.Builder<ShapeArgs, Builder> {

            /* renamed from: d, reason: collision with root package name */
            public String f١٢٠٩٥d;

            public Builder d(String str) {
                this.f١٢٠٩٥d = str;
                return this;
            }

            /* renamed from: build, reason: merged with bridge method [inline-methods] */
            public ShapeArgs m٤٩٧build() {
                return new ShapeArgs(this.f١٢٠٩٥d, super.buildUnknownFields());
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class ProtoAdapter_ShapeArgs extends ProtoAdapter<ShapeArgs> {
            ProtoAdapter_ShapeArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
            }

            /* renamed from: decode, reason: merged with bridge method [inline-methods] */
            public ShapeArgs m٤٩٨decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.m٤٩٧build();
                    }
                    if (nextTag != 1) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        builder.d((String) ProtoAdapter.STRING.decode(protoReader));
                    }
                }
            }

            public void encode(ProtoWriter protoWriter, ShapeArgs shapeArgs) throws IOException {
                String str = shapeArgs.f١٢٠٩٤d;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
                }
                protoWriter.writeBytes(shapeArgs.unknownFields());
            }

            public int encodedSize(ShapeArgs shapeArgs) {
                String str = shapeArgs.f١٢٠٩٤d;
                return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + shapeArgs.unknownFields().size();
            }

            public ShapeArgs redact(ShapeArgs shapeArgs) {
                Builder builder = shapeArgs.m٤٩٦newBuilder();
                builder.clearUnknownFields();
                return builder.m٤٩٧build();
            }
        }

        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShapeArgs)) {
                return false;
            }
            ShapeArgs shapeArgs = (ShapeArgs) obj;
            if (unknownFields().equals(shapeArgs.unknownFields()) && Internal.equals(this.f١٢٠٩٤d, shapeArgs.f١٢٠٩٤d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11 = ((Message) this).hashCode;
            if (i11 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.f١٢٠٩٤d;
                if (str != null) {
                    i10 = str.hashCode();
                } else {
                    i10 = 0;
                }
                int i12 = hashCode + i10;
                ((Message) this).hashCode = i12;
                return i12;
            }
            return i11;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f١٢٠٩٤d != null) {
                sb.append(", d=");
                sb.append(this.f١٢٠٩٤d);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeArgs{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f١٢٠٩٤d = str;
        }

        /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
        public Builder m٤٩٦newBuilder() {
            Builder builder = new Builder();
            builder.f١٢٠٩٥d = this.f١٢٠٩٤d;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class ShapeStyle extends Message<ShapeStyle, Builder> {
        public static final ProtoAdapter<ShapeStyle> ADAPTER = new ProtoAdapter_ShapeStyle();
        public static final LineCap DEFAULT_LINECAP;
        public static final Float DEFAULT_LINEDASHI;
        public static final Float DEFAULT_LINEDASHII;
        public static final Float DEFAULT_LINEDASHIII;
        public static final LineJoin DEFAULT_LINEJOIN;
        public static final Float DEFAULT_MITERLIMIT;
        public static final Float DEFAULT_STROKEWIDTH;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 1)
        public final RGBAColor fill;

        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineCap#ADAPTER", tag = 4)
        public final LineCap lineCap;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
        public final Float lineDashI;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
        public final Float lineDashII;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
        public final Float lineDashIII;

        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineJoin#ADAPTER", tag = 5)
        public final LineJoin lineJoin;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
        public final Float miterLimit;

        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 2)
        public final RGBAColor stroke;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float strokeWidth;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class Builder extends Message.Builder<ShapeStyle, Builder> {
            public RGBAColor fill;
            public LineCap lineCap;
            public Float lineDashI;
            public Float lineDashII;
            public Float lineDashIII;
            public LineJoin lineJoin;
            public Float miterLimit;
            public RGBAColor stroke;
            public Float strokeWidth;

            public Builder fill(RGBAColor rGBAColor) {
                this.fill = rGBAColor;
                return this;
            }

            public Builder lineCap(LineCap lineCap) {
                this.lineCap = lineCap;
                return this;
            }

            public Builder lineDashI(Float f10) {
                this.lineDashI = f10;
                return this;
            }

            public Builder lineDashII(Float f10) {
                this.lineDashII = f10;
                return this;
            }

            public Builder lineDashIII(Float f10) {
                this.lineDashIII = f10;
                return this;
            }

            public Builder lineJoin(LineJoin lineJoin) {
                this.lineJoin = lineJoin;
                return this;
            }

            public Builder miterLimit(Float f10) {
                this.miterLimit = f10;
                return this;
            }

            public Builder stroke(RGBAColor rGBAColor) {
                this.stroke = rGBAColor;
                return this;
            }

            public Builder strokeWidth(Float f10) {
                this.strokeWidth = f10;
                return this;
            }

            /* renamed from: build, reason: merged with bridge method [inline-methods] */
            public ShapeStyle m٥٠٠build() {
                return new ShapeStyle(this.fill, this.stroke, this.strokeWidth, this.lineCap, this.lineJoin, this.miterLimit, this.lineDashI, this.lineDashII, this.lineDashIII, super.buildUnknownFields());
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum LineCap implements WireEnum {
            LineCap_BUTT(0),
            LineCap_ROUND(1),
            LineCap_SQUARE(2);

            public static final ProtoAdapter<LineCap> ADAPTER = ProtoAdapter.newEnumAdapter(LineCap.class);
            private final int value;

            LineCap(int i10) {
                this.value = i10;
            }

            public static LineCap fromValue(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            return null;
                        }
                        return LineCap_SQUARE;
                    }
                    return LineCap_ROUND;
                }
                return LineCap_BUTT;
            }

            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum LineJoin implements WireEnum {
            LineJoin_MITER(0),
            LineJoin_ROUND(1),
            LineJoin_BEVEL(2);

            public static final ProtoAdapter<LineJoin> ADAPTER = ProtoAdapter.newEnumAdapter(LineJoin.class);
            private final int value;

            LineJoin(int i10) {
                this.value = i10;
            }

            public static LineJoin fromValue(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            return null;
                        }
                        return LineJoin_BEVEL;
                    }
                    return LineJoin_ROUND;
                }
                return LineJoin_MITER;
            }

            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class ProtoAdapter_ShapeStyle extends ProtoAdapter<ShapeStyle> {
            ProtoAdapter_ShapeStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
            }

            /* renamed from: decode, reason: merged with bridge method [inline-methods] */
            public ShapeStyle m٥٠١decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                builder.fill((RGBAColor) RGBAColor.ADAPTER.decode(protoReader));
                                break;
                            case 2:
                                builder.stroke((RGBAColor) RGBAColor.ADAPTER.decode(protoReader));
                                break;
                            case 3:
                                builder.strokeWidth((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 4:
                                try {
                                    builder.lineCap((LineCap) LineCap.ADAPTER.decode(protoReader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e10) {
                                    builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e10.value));
                                    break;
                                }
                            case 5:
                                try {
                                    builder.lineJoin((LineJoin) LineJoin.ADAPTER.decode(protoReader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e11) {
                                    builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e11.value));
                                    break;
                                }
                            case 6:
                                builder.miterLimit((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 7:
                                builder.lineDashI((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 8:
                                builder.lineDashII((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 9:
                                builder.lineDashIII((Float) ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            default:
                                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                break;
                        }
                    } else {
                        protoReader.endMessage(beginMessage);
                        return builder.m٥٠٠build();
                    }
                }
            }

            public void encode(ProtoWriter protoWriter, ShapeStyle shapeStyle) throws IOException {
                RGBAColor rGBAColor = shapeStyle.fill;
                if (rGBAColor != null) {
                    RGBAColor.ADAPTER.encodeWithTag(protoWriter, 1, rGBAColor);
                }
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                if (rGBAColor2 != null) {
                    RGBAColor.ADAPTER.encodeWithTag(protoWriter, 2, rGBAColor2);
                }
                Float f10 = shapeStyle.strokeWidth;
                if (f10 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f10);
                }
                LineCap lineCap = shapeStyle.lineCap;
                if (lineCap != null) {
                    LineCap.ADAPTER.encodeWithTag(protoWriter, 4, lineCap);
                }
                LineJoin lineJoin = shapeStyle.lineJoin;
                if (lineJoin != null) {
                    LineJoin.ADAPTER.encodeWithTag(protoWriter, 5, lineJoin);
                }
                Float f11 = shapeStyle.miterLimit;
                if (f11 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f11);
                }
                Float f12 = shapeStyle.lineDashI;
                if (f12 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 7, f12);
                }
                Float f13 = shapeStyle.lineDashII;
                if (f13 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 8, f13);
                }
                Float f14 = shapeStyle.lineDashIII;
                if (f14 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 9, f14);
                }
                protoWriter.writeBytes(shapeStyle.unknownFields());
            }

            public int encodedSize(ShapeStyle shapeStyle) {
                RGBAColor rGBAColor = shapeStyle.fill;
                int encodedSizeWithTag = rGBAColor != null ? RGBAColor.ADAPTER.encodedSizeWithTag(1, rGBAColor) : 0;
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                int encodedSizeWithTag2 = encodedSizeWithTag + (rGBAColor2 != null ? RGBAColor.ADAPTER.encodedSizeWithTag(2, rGBAColor2) : 0);
                Float f10 = shapeStyle.strokeWidth;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f10) : 0);
                LineCap lineCap = shapeStyle.lineCap;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (lineCap != null ? LineCap.ADAPTER.encodedSizeWithTag(4, lineCap) : 0);
                LineJoin lineJoin = shapeStyle.lineJoin;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (lineJoin != null ? LineJoin.ADAPTER.encodedSizeWithTag(5, lineJoin) : 0);
                Float f11 = shapeStyle.miterLimit;
                int encodedSizeWithTag6 = encodedSizeWithTag5 + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f11) : 0);
                Float f12 = shapeStyle.lineDashI;
                int encodedSizeWithTag7 = encodedSizeWithTag6 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, f12) : 0);
                Float f13 = shapeStyle.lineDashII;
                int encodedSizeWithTag8 = encodedSizeWithTag7 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, f13) : 0);
                Float f14 = shapeStyle.lineDashIII;
                return encodedSizeWithTag8 + (f14 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, f14) : 0) + shapeStyle.unknownFields().size();
            }

            public ShapeStyle redact(ShapeStyle shapeStyle) {
                Builder builder = shapeStyle.m٤٩٩newBuilder();
                RGBAColor rGBAColor = builder.fill;
                if (rGBAColor != null) {
                    builder.fill = (RGBAColor) RGBAColor.ADAPTER.redact(rGBAColor);
                }
                RGBAColor rGBAColor2 = builder.stroke;
                if (rGBAColor2 != null) {
                    builder.stroke = (RGBAColor) RGBAColor.ADAPTER.redact(rGBAColor2);
                }
                builder.clearUnknownFields();
                return builder.m٥٠٠build();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class RGBAColor extends Message<RGBAColor, Builder> {
            public static final ProtoAdapter<RGBAColor> ADAPTER = new ProtoAdapter_RGBAColor();
            public static final Float DEFAULT_A;
            public static final Float DEFAULT_B;
            public static final Float DEFAULT_G;
            public static final Float DEFAULT_R;
            private static final long serialVersionUID = 0;

            /* renamed from: a, reason: collision with root package name */
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
            public final Float f١٢٠٩٦a;

            /* renamed from: b, reason: collision with root package name */
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
            public final Float f١٢٠٩٧b;

            /* renamed from: g, reason: collision with root package name */
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
            public final Float f١٢٠٩٨g;

            /* renamed from: r, reason: collision with root package name */
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float f١٢٠٩٩r;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public static final class Builder extends Message.Builder<RGBAColor, Builder> {

                /* renamed from: a, reason: collision with root package name */
                public Float f١٢١٠٠a;

                /* renamed from: b, reason: collision with root package name */
                public Float f١٢١٠١b;

                /* renamed from: g, reason: collision with root package name */
                public Float f١٢١٠٢g;

                /* renamed from: r, reason: collision with root package name */
                public Float f١٢١٠٣r;

                public Builder a(Float f10) {
                    this.f١٢١٠٠a = f10;
                    return this;
                }

                public Builder b(Float f10) {
                    this.f١٢١٠١b = f10;
                    return this;
                }

                public Builder g(Float f10) {
                    this.f١٢١٠٢g = f10;
                    return this;
                }

                public Builder r(Float f10) {
                    this.f١٢١٠٣r = f10;
                    return this;
                }

                /* renamed from: build, reason: merged with bridge method [inline-methods] */
                public RGBAColor m٥٠٣build() {
                    return new RGBAColor(this.f١٢١٠٣r, this.f١٢١٠٢g, this.f١٢١٠١b, this.f١٢١٠٠a, super.buildUnknownFields());
                }
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            private static final class ProtoAdapter_RGBAColor extends ProtoAdapter<RGBAColor> {
                ProtoAdapter_RGBAColor() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                }

                /* renamed from: decode, reason: merged with bridge method [inline-methods] */
                public RGBAColor m٥٠٤decode(ProtoReader protoReader) throws IOException {
                    Builder builder = new Builder();
                    long beginMessage = protoReader.beginMessage();
                    while (true) {
                        int nextTag = protoReader.nextTag();
                        if (nextTag == -1) {
                            protoReader.endMessage(beginMessage);
                            return builder.m٥٠٣build();
                        }
                        if (nextTag == 1) {
                            builder.r((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag == 2) {
                            builder.g((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag == 3) {
                            builder.b((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag != 4) {
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        } else {
                            builder.a((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        }
                    }
                }

                public void encode(ProtoWriter protoWriter, RGBAColor rGBAColor) throws IOException {
                    Float f10 = rGBAColor.f١٢٠٩٩r;
                    if (f10 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
                    }
                    Float f11 = rGBAColor.f١٢٠٩٨g;
                    if (f11 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
                    }
                    Float f12 = rGBAColor.f١٢٠٩٧b;
                    if (f12 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
                    }
                    Float f13 = rGBAColor.f١٢٠٩٦a;
                    if (f13 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
                    }
                    protoWriter.writeBytes(rGBAColor.unknownFields());
                }

                public int encodedSize(RGBAColor rGBAColor) {
                    Float f10 = rGBAColor.f١٢٠٩٩r;
                    int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
                    Float f11 = rGBAColor.f١٢٠٩٨g;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
                    Float f12 = rGBAColor.f١٢٠٩٧b;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
                    Float f13 = rGBAColor.f١٢٠٩٦a;
                    return encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0) + rGBAColor.unknownFields().size();
                }

                public RGBAColor redact(RGBAColor rGBAColor) {
                    Builder builder = rGBAColor.m٥٠٢newBuilder();
                    builder.clearUnknownFields();
                    return builder.m٥٠٣build();
                }
            }

            static {
                Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
                DEFAULT_R = valueOf;
                DEFAULT_G = valueOf;
                DEFAULT_B = valueOf;
                DEFAULT_A = valueOf;
            }

            public RGBAColor(Float f10, Float f11, Float f12, Float f13) {
                this(f10, f11, f12, f13, ByteString.EMPTY);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RGBAColor)) {
                    return false;
                }
                RGBAColor rGBAColor = (RGBAColor) obj;
                if (unknownFields().equals(rGBAColor.unknownFields()) && Internal.equals(this.f١٢٠٩٩r, rGBAColor.f١٢٠٩٩r) && Internal.equals(this.f١٢٠٩٨g, rGBAColor.f١٢٠٩٨g) && Internal.equals(this.f١٢٠٩٧b, rGBAColor.f١٢٠٩٧b) && Internal.equals(this.f١٢٠٩٦a, rGBAColor.f١٢٠٩٦a)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int i10;
                int i11;
                int i12;
                int i13 = ((Message) this).hashCode;
                if (i13 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f10 = this.f١٢٠٩٩r;
                    int i14 = 0;
                    if (f10 != null) {
                        i10 = f10.hashCode();
                    } else {
                        i10 = 0;
                    }
                    int i15 = (hashCode + i10) * 37;
                    Float f11 = this.f١٢٠٩٨g;
                    if (f11 != null) {
                        i11 = f11.hashCode();
                    } else {
                        i11 = 0;
                    }
                    int i16 = (i15 + i11) * 37;
                    Float f12 = this.f١٢٠٩٧b;
                    if (f12 != null) {
                        i12 = f12.hashCode();
                    } else {
                        i12 = 0;
                    }
                    int i17 = (i16 + i12) * 37;
                    Float f13 = this.f١٢٠٩٦a;
                    if (f13 != null) {
                        i14 = f13.hashCode();
                    }
                    int i18 = i17 + i14;
                    ((Message) this).hashCode = i18;
                    return i18;
                }
                return i13;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                if (this.f١٢٠٩٩r != null) {
                    sb.append(", r=");
                    sb.append(this.f١٢٠٩٩r);
                }
                if (this.f١٢٠٩٨g != null) {
                    sb.append(", g=");
                    sb.append(this.f١٢٠٩٨g);
                }
                if (this.f١٢٠٩٧b != null) {
                    sb.append(", b=");
                    sb.append(this.f١٢٠٩٧b);
                }
                if (this.f١٢٠٩٦a != null) {
                    sb.append(", a=");
                    sb.append(this.f١٢٠٩٦a);
                }
                StringBuilder replace = sb.replace(0, 2, "RGBAColor{");
                replace.append('}');
                return replace.toString();
            }

            public RGBAColor(Float f10, Float f11, Float f12, Float f13, ByteString byteString) {
                super(ADAPTER, byteString);
                this.f١٢٠٩٩r = f10;
                this.f١٢٠٩٨g = f11;
                this.f١٢٠٩٧b = f12;
                this.f١٢٠٩٦a = f13;
            }

            /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
            public Builder m٥٠٢newBuilder() {
                Builder builder = new Builder();
                builder.f١٢١٠٣r = this.f١٢٠٩٩r;
                builder.f١٢١٠٢g = this.f١٢٠٩٨g;
                builder.f١٢١٠١b = this.f١٢٠٩٧b;
                builder.f١٢١٠٠a = this.f١٢٠٩٦a;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
        }

        static {
            Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
            DEFAULT_STROKEWIDTH = valueOf;
            DEFAULT_LINECAP = LineCap.LineCap_BUTT;
            DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
            DEFAULT_MITERLIMIT = valueOf;
            DEFAULT_LINEDASHI = valueOf;
            DEFAULT_LINEDASHII = valueOf;
            DEFAULT_LINEDASHIII = valueOf;
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f10, LineCap lineCap, LineJoin lineJoin, Float f11, Float f12, Float f13, Float f14) {
            this(rGBAColor, rGBAColor2, f10, lineCap, lineJoin, f11, f12, f13, f14, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShapeStyle)) {
                return false;
            }
            ShapeStyle shapeStyle = (ShapeStyle) obj;
            if (unknownFields().equals(shapeStyle.unknownFields()) && Internal.equals(this.fill, shapeStyle.fill) && Internal.equals(this.stroke, shapeStyle.stroke) && Internal.equals(this.strokeWidth, shapeStyle.strokeWidth) && Internal.equals(this.lineCap, shapeStyle.lineCap) && Internal.equals(this.lineJoin, shapeStyle.lineJoin) && Internal.equals(this.miterLimit, shapeStyle.miterLimit) && Internal.equals(this.lineDashI, shapeStyle.lineDashI) && Internal.equals(this.lineDashII, shapeStyle.lineDashII) && Internal.equals(this.lineDashIII, shapeStyle.lineDashIII)) {
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
            int i15;
            int i16;
            int i17;
            int i18 = ((Message) this).hashCode;
            if (i18 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                RGBAColor rGBAColor = this.fill;
                int i19 = 0;
                if (rGBAColor != null) {
                    i10 = rGBAColor.hashCode();
                } else {
                    i10 = 0;
                }
                int i20 = (hashCode + i10) * 37;
                RGBAColor rGBAColor2 = this.stroke;
                if (rGBAColor2 != null) {
                    i11 = rGBAColor2.hashCode();
                } else {
                    i11 = 0;
                }
                int i21 = (i20 + i11) * 37;
                Float f10 = this.strokeWidth;
                if (f10 != null) {
                    i12 = f10.hashCode();
                } else {
                    i12 = 0;
                }
                int i22 = (i21 + i12) * 37;
                LineCap lineCap = this.lineCap;
                if (lineCap != null) {
                    i13 = lineCap.hashCode();
                } else {
                    i13 = 0;
                }
                int i23 = (i22 + i13) * 37;
                LineJoin lineJoin = this.lineJoin;
                if (lineJoin != null) {
                    i14 = lineJoin.hashCode();
                } else {
                    i14 = 0;
                }
                int i24 = (i23 + i14) * 37;
                Float f11 = this.miterLimit;
                if (f11 != null) {
                    i15 = f11.hashCode();
                } else {
                    i15 = 0;
                }
                int i25 = (i24 + i15) * 37;
                Float f12 = this.lineDashI;
                if (f12 != null) {
                    i16 = f12.hashCode();
                } else {
                    i16 = 0;
                }
                int i26 = (i25 + i16) * 37;
                Float f13 = this.lineDashII;
                if (f13 != null) {
                    i17 = f13.hashCode();
                } else {
                    i17 = 0;
                }
                int i27 = (i26 + i17) * 37;
                Float f14 = this.lineDashIII;
                if (f14 != null) {
                    i19 = f14.hashCode();
                }
                int i28 = i27 + i19;
                ((Message) this).hashCode = i28;
                return i28;
            }
            return i18;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.fill != null) {
                sb.append(", fill=");
                sb.append(this.fill);
            }
            if (this.stroke != null) {
                sb.append(", stroke=");
                sb.append(this.stroke);
            }
            if (this.strokeWidth != null) {
                sb.append(", strokeWidth=");
                sb.append(this.strokeWidth);
            }
            if (this.lineCap != null) {
                sb.append(", lineCap=");
                sb.append(this.lineCap);
            }
            if (this.lineJoin != null) {
                sb.append(", lineJoin=");
                sb.append(this.lineJoin);
            }
            if (this.miterLimit != null) {
                sb.append(", miterLimit=");
                sb.append(this.miterLimit);
            }
            if (this.lineDashI != null) {
                sb.append(", lineDashI=");
                sb.append(this.lineDashI);
            }
            if (this.lineDashII != null) {
                sb.append(", lineDashII=");
                sb.append(this.lineDashII);
            }
            if (this.lineDashIII != null) {
                sb.append(", lineDashIII=");
                sb.append(this.lineDashIII);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeStyle{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f10, LineCap lineCap, LineJoin lineJoin, Float f11, Float f12, Float f13, Float f14, ByteString byteString) {
            super(ADAPTER, byteString);
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f10;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f11;
            this.lineDashI = f12;
            this.lineDashII = f13;
            this.lineDashIII = f14;
        }

        /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
        public Builder m٤٩٩newBuilder() {
            Builder builder = new Builder();
            builder.fill = this.fill;
            builder.stroke = this.stroke;
            builder.strokeWidth = this.strokeWidth;
            builder.lineCap = this.lineCap;
            builder.lineJoin = this.lineJoin;
            builder.miterLimit = this.miterLimit;
            builder.lineDashI = this.lineDashI;
            builder.lineDashII = this.lineDashII;
            builder.lineDashIII = this.lineDashIII;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum ShapeType implements WireEnum {
        SHAPE(0),
        RECT(1),
        ELLIPSE(2),
        KEEP(3);

        public static final ProtoAdapter<ShapeType> ADAPTER = ProtoAdapter.newEnumAdapter(ShapeType.class);
        private final int value;

        ShapeType(int i10) {
            this.value = i10;
        }

        public static ShapeType fromValue(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return KEEP;
                    }
                    return ELLIPSE;
                }
                return RECT;
            }
            return SHAPE;
        }

        public int getValue() {
            return this.value;
        }
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShapeEntity)) {
            return false;
        }
        ShapeEntity shapeEntity = (ShapeEntity) obj;
        if (unknownFields().equals(shapeEntity.unknownFields()) && Internal.equals(this.type, shapeEntity.type) && Internal.equals(this.styles, shapeEntity.styles) && Internal.equals(this.transform, shapeEntity.transform) && Internal.equals(this.shape, shapeEntity.shape) && Internal.equals(this.rect, shapeEntity.rect) && Internal.equals(this.ellipse, shapeEntity.ellipse)) {
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
            ShapeType shapeType = this.type;
            int i16 = 0;
            if (shapeType != null) {
                i10 = shapeType.hashCode();
            } else {
                i10 = 0;
            }
            int i17 = (hashCode + i10) * 37;
            ShapeStyle shapeStyle = this.styles;
            if (shapeStyle != null) {
                i11 = shapeStyle.hashCode();
            } else {
                i11 = 0;
            }
            int i18 = (i17 + i11) * 37;
            Transform transform = this.transform;
            if (transform != null) {
                i12 = transform.hashCode();
            } else {
                i12 = 0;
            }
            int i19 = (i18 + i12) * 37;
            ShapeArgs shapeArgs = this.shape;
            if (shapeArgs != null) {
                i13 = shapeArgs.hashCode();
            } else {
                i13 = 0;
            }
            int i20 = (i19 + i13) * 37;
            RectArgs rectArgs = this.rect;
            if (rectArgs != null) {
                i14 = rectArgs.hashCode();
            } else {
                i14 = 0;
            }
            int i21 = (i20 + i14) * 37;
            EllipseArgs ellipseArgs = this.ellipse;
            if (ellipseArgs != null) {
                i16 = ellipseArgs.hashCode();
            }
            int i22 = i21 + i16;
            ((Message) this).hashCode = i22;
            return i22;
        }
        return i15;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.styles != null) {
            sb.append(", styles=");
            sb.append(this.styles);
        }
        if (this.transform != null) {
            sb.append(", transform=");
            sb.append(this.transform);
        }
        if (this.shape != null) {
            sb.append(", shape=");
            sb.append(this.shape);
        }
        if (this.rect != null) {
            sb.append(", rect=");
            sb.append(this.rect);
        }
        if (this.ellipse != null) {
            sb.append(", ellipse=");
            sb.append(this.ellipse);
        }
        StringBuilder replace = sb.replace(0, 2, "ShapeEntity{");
        replace.append('}');
        return replace.toString();
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        if (Internal.countNonNull(shapeArgs, rectArgs, ellipseArgs) <= 1) {
            this.type = shapeType;
            this.styles = shapeStyle;
            this.transform = transform;
            this.shape = shapeArgs;
            this.rect = rectArgs;
            this.ellipse = ellipseArgs;
            return;
        }
        throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m٤٨٧newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.styles = this.styles;
        builder.transform = this.transform;
        builder.shape = this.shape;
        builder.rect = this.rect;
        builder.ellipse = this.ellipse;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
