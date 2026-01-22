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
public final class Layout extends Message<Layout, Builder> {
    public static final ProtoAdapter<Layout> ADAPTER = new ProtoAdapter_Layout();
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;

    /* renamed from: x, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float f١٢٠٨٢x;

    /* renamed from: y, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float f١٢٠٨٣y;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder extends Message.Builder<Layout, Builder> {
        public Float height;
        public Float width;

        /* renamed from: x, reason: collision with root package name */
        public Float f١٢٠٨٤x;

        /* renamed from: y, reason: collision with root package name */
        public Float f١٢٠٨٥y;

        public Builder height(Float f10) {
            this.height = f10;
            return this;
        }

        public Builder width(Float f10) {
            this.width = f10;
            return this;
        }

        public Builder x(Float f10) {
            this.f١٢٠٨٤x = f10;
            return this;
        }

        public Builder y(Float f10) {
            this.f١٢٠٨٥y = f10;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public Layout m٤٧٩build() {
            return new Layout(this.f١٢٠٨٤x, this.f١٢٠٨٥y, this.width, this.height, super.buildUnknownFields());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
        ProtoAdapter_Layout() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Layout m٤٨٠decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m٤٧٩build();
                }
                if (nextTag == 1) {
                    builder.x((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.y((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.width((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.height((Float) ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Layout layout) throws IOException {
            Float f10 = layout.f١٢٠٨٢x;
            if (f10 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f10);
            }
            Float f11 = layout.f١٢٠٨٣y;
            if (f11 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f11);
            }
            Float f12 = layout.width;
            if (f12 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f12);
            }
            Float f13 = layout.height;
            if (f13 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f13);
            }
            protoWriter.writeBytes(layout.unknownFields());
        }

        public int encodedSize(Layout layout) {
            Float f10 = layout.f١٢٠٨٢x;
            int encodedSizeWithTag = f10 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f10) : 0;
            Float f11 = layout.f١٢٠٨٣y;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f11 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f11) : 0);
            Float f12 = layout.width;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f12 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f12) : 0);
            Float f13 = layout.height;
            return encodedSizeWithTag3 + (f13 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f13) : 0) + layout.unknownFields().size();
        }

        public Layout redact(Layout layout) {
            Builder builder = layout.m٤٧٨newBuilder();
            builder.clearUnknownFields();
            return builder.m٤٧٩build();
        }
    }

    static {
        Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    public Layout(Float f10, Float f11, Float f12, Float f13) {
        this(f10, f11, f12, f13, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Layout)) {
            return false;
        }
        Layout layout = (Layout) obj;
        if (unknownFields().equals(layout.unknownFields()) && Internal.equals(this.f١٢٠٨٢x, layout.f١٢٠٨٢x) && Internal.equals(this.f١٢٠٨٣y, layout.f١٢٠٨٣y) && Internal.equals(this.width, layout.width) && Internal.equals(this.height, layout.height)) {
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
            Float f10 = this.f١٢٠٨٢x;
            int i14 = 0;
            if (f10 != null) {
                i10 = f10.hashCode();
            } else {
                i10 = 0;
            }
            int i15 = (hashCode + i10) * 37;
            Float f11 = this.f١٢٠٨٣y;
            if (f11 != null) {
                i11 = f11.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i15 + i11) * 37;
            Float f12 = this.width;
            if (f12 != null) {
                i12 = f12.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (i16 + i12) * 37;
            Float f13 = this.height;
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
        if (this.f١٢٠٨٢x != null) {
            sb.append(", x=");
            sb.append(this.f١٢٠٨٢x);
        }
        if (this.f١٢٠٨٣y != null) {
            sb.append(", y=");
            sb.append(this.f١٢٠٨٣y);
        }
        if (this.width != null) {
            sb.append(", width=");
            sb.append(this.width);
        }
        if (this.height != null) {
            sb.append(", height=");
            sb.append(this.height);
        }
        StringBuilder replace = sb.replace(0, 2, "Layout{");
        replace.append('}');
        return replace.toString();
    }

    public Layout(Float f10, Float f11, Float f12, Float f13, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f١٢٠٨٢x = f10;
        this.f١٢٠٨٣y = f11;
        this.width = f12;
        this.height = f13;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m٤٧٨newBuilder() {
        Builder builder = new Builder();
        builder.f١٢٠٨٤x = this.f١٢٠٨٢x;
        builder.f١٢٠٨٥y = this.f١٢٠٨٣y;
        builder.width = this.width;
        builder.height = this.height;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
