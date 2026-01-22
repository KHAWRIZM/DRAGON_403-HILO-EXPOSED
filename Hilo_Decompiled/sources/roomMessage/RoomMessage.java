package roomMessage;

import com.google.protobuf.a;
import com.google.protobuf.b;
import com.google.protobuf.b1;
import com.google.protobuf.b2;
import com.google.protobuf.e1;
import com.google.protobuf.g1;
import com.google.protobuf.h0;
import com.google.protobuf.j0;
import com.google.protobuf.k0;
import com.google.protobuf.k2;
import com.google.protobuf.n;
import com.google.protobuf.r1;
import com.google.protobuf.t;
import com.google.protobuf.v;
import com.google.protobuf.x1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class RoomMessage {
    private static n.h descriptor = n.h.o(new String[]{"\n\u0012room_message.proto\u0012\u000broomMessage\"å\u0001\n\u0010GroupMessageSend\u0012\u000e\n\u0006msg_id\u0018\u0001 \u0001(\t\u0012\u0014\n\ffrom_account\u0018\u0002 \u0001(\t\u0012\u0018\n\u0010operator_account\u0018\u0003 \u0001(\t\u0012\u0010\n\bgroup_id\u0018\u0004 \u0001(\t\u0012&\n\bmsg_body\u0018\u0005 \u0003(\u000b2\u0014.roomMessage.MsgBody\u0012\u0017\n\nevent_time\u0018\u0006 \u0001(\u0003H\u0000\u0088\u0001\u0001\u0012\u0013\n\u0006status\u0018\u0007 \u0001(\u0005H\u0001\u0088\u0001\u0001\u0012\u000f\n\u0007msg_tab\u0018\b \u0001(\u0005B\r\n\u000b_event_timeB\t\n\u0007_status\"\u0086\u0003\n\u000fGroupMessageNew\u0012\u000e\n\u0006msg_id\u0018\u0001 \u0001(\t\u0012\u0014\n\ffrom_account\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bsender_nick\u0018\u0003 \u0001(\t\u0012\u0015\n\rsender_avatar\u0018\u0004 \u0001(\t\u0012\u0018\n\u0010operator_account\u0018\u0005 \u0001(\t\u0012\u0010\n\bgroup_id\u0018\u0006 \u0001(\t\u0012&\n\bmsg_body\u0018\u0007 \u0003(\u000b2\u0014.roomMessage.MsgBody\u0012<\n\u0011cloud_custom_data\u0018\b \u0001(\u000b2\u001c.roomMessage.CloudCustomDataH\u0000\u0088\u0001\u0001\u0012\u0017\n\nevent_time\u0018\t \u0001(\u0003H\u0001\u0088\u0001\u0001\u0012\u0014\n\u0007user_id\u0018\n \u0001(\u0004H\u0002\u0088\u0001\u0001\u0012\u0013\n\u0006status\u0018\u000b \u0001(\u0005H\u0003\u0088\u0001\u0001\u0012\u000f\n\u0007msg_tab\u0018\f \u0001(\u0005B\u0014\n\u0012_cloud_custom_dataB\r\n\u000b_event_timeB\n\n\b_user_idB\t\n\u0007_status\"H\n\u0013GroupMessageSendRsp\u0012\u000e\n\u0006msg_id\u0018\u0001 \u0001(\t\u0012\u0010\n\berr_code\u0018\u0002 \u0001(\r\u0012\u000f\n\u0007err_msg\u0018\u0003 \u0001(\t\"ó\u0001\n\u0007MsgBody\u0012\u0010\n\bmsg_type\u0018\u0001 \u0001(\t\u00126\n\u000ecustom_content\u0018\u0002 \u0001(\u000b2\u001e.roomMessage.CustomElemContent\u00122\n\ftext_content\u0018\u0003 \u0001(\u000b2\u001c.roomMessage.TextElemContent\u00124\n\rvideo_content\u0018\u0004 \u0001(\u000b2\u001d.roomMessage.VideoElemContent\u00124\n\rimage_content\u0018\u0005 \u0001(\u000b2\u001d.roomMessage.ImageElemContent\"N\n\fGMSvipDetail\u0012\u0012\n\nsvip_level\u0018\u0001 \u0001(\u0004\u0012\u0019\n\fmystery_code\u0018\u0002 \u0001(\tH\u0000\u0088\u0001\u0001B\u000f\n\r_mystery_code\"\u0097\u0002\n\u000fCloudCustomData\u0012\u0014\n\fwealth_grade\u0018\u0001 \u0001(\u0004\u0012\u0013\n\u000bcharm_grade\u0018\u0002 \u0001(\u0004\u0012\u000e\n\u0006is_vip\u0018\u0003 \u0001(\b\u0012\u0011\n\tis_pretty\u0018\u0004 \u0001(\b\u0012\u000e\n\u0006medals\u0018\u0005 \u0003(\u0004\u0012\u0012\n\npower_name\u0018\u0006 \u0001(\t\u0012\u0013\n\u000bnoble_level\u0018\u0007 \u0001(\u0004\u0012\u0012\n\nsvip_level\u0018\b \u0001(\u0004\u0012\u0017\n\u000fpower_nameplate\u0018\t \u0001(\t\u0012\u0013\n\u000bpower_grade\u0018\n \u0001(\u0004\u0012\u0012\n\ncornerMark\u0018\u000b \u0001(\r\u0012'\n\u0004svip\u0018\f \u0001(\u000b2\u0019.roomMessage.GMSvipDetail\"!\n\u0011CustomElemContent\u0012\f\n\u0004data\u0018\u0001 \u0001(\t\"S\n\u000fTextElemContent\u0012\f\n\u0004text\u0018\u0001 \u0001(\t\u00122\n\nat_account\u0018\u0002 \u0003(\u000b2\u001e.roomMessage.TextElemContentAt\"8\n\u0011TextElemContentAt\u0012\u0012\n\nat_account\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007at_nick\u0018\u0002 \u0001(\t\"m\n\tImageInfo\u0012\r\n\u0005width\u0018\u0001 \u0001(\u0005\u0012\u000e\n\u0006height\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004size\u0018\u0003 \u0001(\u0004\u0012\u000b\n\u0003url\u0018\u0005 \u0001(\t\u0012\u0017\n\nlocal_path\u0018\u0006 \u0001(\tH\u0000\u0088\u0001\u0001B\r\n\u000b_local_path\"D\n\u0010ImageElemContent\u00120\n\u0010image_info_array\u0018\u0001 \u0003(\u000b2\u0016.roomMessage.ImageInfo\"ý\u0001\n\u0010VideoElemContent\u0012\u0013\n\u000bthumb_width\u0018\u0001 \u0001(\u0005\u0012\u0014\n\fthumb_height\u0018\u0002 \u0001(\u0005\u0012\u0012\n\nthumb_size\u0018\u0003 \u0001(\u0004\u0012\u0011\n\tthumb_url\u0018\u0004 \u0001(\t\u0012\u0014\n\fvideo_second\u0018\u0005 \u0001(\u0005\u0012\u0012\n\nvideo_size\u0018\u0006 \u0001(\u0004\u0012\u0011\n\tvideo_url\u0018\u0007 \u0001(\t\u0012\u0017\n\nlocal_path\u0018\b \u0001(\tH\u0000\u0088\u0001\u0001\u0012\u001d\n\u0010local_thumb_path\u0018\t \u0001(\tH\u0001\u0088\u0001\u0001B\r\n\u000b_local_pathB\u0013\n\u0011_local_thumb_pathB\u001aZ\u0018biz/protocol/roomMessageb\u0006proto3"}, new n.h[0]);
    private static final n.b internal_static_roomMessage_CloudCustomData_descriptor;
    private static final h0.f internal_static_roomMessage_CloudCustomData_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_CustomElemContent_descriptor;
    private static final h0.f internal_static_roomMessage_CustomElemContent_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_GMSvipDetail_descriptor;
    private static final h0.f internal_static_roomMessage_GMSvipDetail_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_GroupMessageNew_descriptor;
    private static final h0.f internal_static_roomMessage_GroupMessageNew_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_GroupMessageSendRsp_descriptor;
    private static final h0.f internal_static_roomMessage_GroupMessageSendRsp_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_GroupMessageSend_descriptor;
    private static final h0.f internal_static_roomMessage_GroupMessageSend_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_ImageElemContent_descriptor;
    private static final h0.f internal_static_roomMessage_ImageElemContent_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_ImageInfo_descriptor;
    private static final h0.f internal_static_roomMessage_ImageInfo_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_MsgBody_descriptor;
    private static final h0.f internal_static_roomMessage_MsgBody_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_TextElemContentAt_descriptor;
    private static final h0.f internal_static_roomMessage_TextElemContentAt_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_TextElemContent_descriptor;
    private static final h0.f internal_static_roomMessage_TextElemContent_fieldAccessorTable;
    private static final n.b internal_static_roomMessage_VideoElemContent_descriptor;
    private static final h0.f internal_static_roomMessage_VideoElemContent_fieldAccessorTable;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class CloudCustomData extends h0 implements CloudCustomDataOrBuilder {
        public static final int CHARM_GRADE_FIELD_NUMBER = 2;
        public static final int CORNERMARK_FIELD_NUMBER = 11;
        public static final int IS_PRETTY_FIELD_NUMBER = 4;
        public static final int IS_VIP_FIELD_NUMBER = 3;
        public static final int MEDALS_FIELD_NUMBER = 5;
        public static final int NOBLE_LEVEL_FIELD_NUMBER = 7;
        public static final int POWER_GRADE_FIELD_NUMBER = 10;
        public static final int POWER_NAMEPLATE_FIELD_NUMBER = 9;
        public static final int POWER_NAME_FIELD_NUMBER = 6;
        public static final int SVIP_FIELD_NUMBER = 12;
        public static final int SVIP_LEVEL_FIELD_NUMBER = 8;
        public static final int WEALTH_GRADE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long charmGrade_;
        private int cornerMark_;
        private boolean isPretty_;
        private boolean isVip_;
        private int medalsMemoizedSerializedSize;
        private j0.h medals_;
        private byte memoizedIsInitialized;
        private long nobleLevel_;
        private long powerGrade_;
        private volatile Object powerName_;
        private volatile Object powerNameplate_;
        private long svipLevel_;
        private GMSvipDetail svip_;
        private long wealthGrade_;
        private static final CloudCustomData DEFAULT_INSTANCE = new CloudCustomData();
        private static final r1 PARSER = new a();

        public static /* synthetic */ j0.h access$1700() {
            return h0.emptyLongList();
        }

        public static /* synthetic */ j0.h access$1800() {
            return h0.emptyLongList();
        }

        public static /* synthetic */ j0.h access$2000() {
            return h0.emptyLongList();
        }

        public static CloudCustomData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_CloudCustomData_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٤٤٦toBuilder();
        }

        public static CloudCustomData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CloudCustomData parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CloudCustomData)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            CloudCustomData cloudCustomData = (CloudCustomData) obj;
            if (getWealthGrade() != cloudCustomData.getWealthGrade() || getCharmGrade() != cloudCustomData.getCharmGrade() || getIsVip() != cloudCustomData.getIsVip() || getIsPretty() != cloudCustomData.getIsPretty() || !getMedalsList().equals(cloudCustomData.getMedalsList()) || !getPowerName().equals(cloudCustomData.getPowerName()) || getNobleLevel() != cloudCustomData.getNobleLevel() || getSvipLevel() != cloudCustomData.getSvipLevel() || !getPowerNameplate().equals(cloudCustomData.getPowerNameplate()) || getPowerGrade() != cloudCustomData.getPowerGrade() || getCornerMark() != cloudCustomData.getCornerMark() || hasSvip() != cloudCustomData.hasSvip()) {
                return false;
            }
            if ((!hasSvip() || getSvip().equals(cloudCustomData.getSvip())) && getUnknownFields().equals(cloudCustomData.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getCharmGrade() {
            return this.charmGrade_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public int getCornerMark() {
            return this.cornerMark_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public boolean getIsPretty() {
            return this.isPretty_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public boolean getIsVip() {
            return this.isVip_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getMedals(int i) {
            return this.medals_.getLong(i);
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public int getMedalsCount() {
            return this.medals_.size();
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public List<Long> getMedalsList() {
            return this.medals_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getNobleLevel() {
            return this.nobleLevel_;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getPowerGrade() {
            return this.powerGrade_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public String getPowerName() {
            Object obj = this.powerName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.powerName_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public com.google.protobuf.h getPowerNameBytes() {
            Object obj = this.powerName_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.powerName_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public String getPowerNameplate() {
            Object obj = this.powerNameplate_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.powerNameplate_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public com.google.protobuf.h getPowerNameplateBytes() {
            Object obj = this.powerNameplate_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.powerNameplate_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            long j = this.wealthGrade_;
            if (j != 0) {
                i = com.google.protobuf.k.Z(1, j);
            } else {
                i = 0;
            }
            long j2 = this.charmGrade_;
            if (j2 != 0) {
                i += com.google.protobuf.k.Z(2, j2);
            }
            boolean z = this.isVip_;
            if (z) {
                i += com.google.protobuf.k.e(3, z);
            }
            boolean z2 = this.isPretty_;
            if (z2) {
                i += com.google.protobuf.k.e(4, z2);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.medals_.size(); i4++) {
                i3 += com.google.protobuf.k.a0(this.medals_.getLong(i4));
            }
            int i5 = i + i3;
            if (!getMedalsList().isEmpty()) {
                i5 = i5 + 1 + com.google.protobuf.k.y(i3);
            }
            this.medalsMemoizedSerializedSize = i3;
            if (!h0.isStringEmpty(this.powerName_)) {
                i5 += h0.computeStringSize(6, this.powerName_);
            }
            long j3 = this.nobleLevel_;
            if (j3 != 0) {
                i5 += com.google.protobuf.k.Z(7, j3);
            }
            long j4 = this.svipLevel_;
            if (j4 != 0) {
                i5 += com.google.protobuf.k.Z(8, j4);
            }
            if (!h0.isStringEmpty(this.powerNameplate_)) {
                i5 += h0.computeStringSize(9, this.powerNameplate_);
            }
            long j5 = this.powerGrade_;
            if (j5 != 0) {
                i5 += com.google.protobuf.k.Z(10, j5);
            }
            int i6 = this.cornerMark_;
            if (i6 != 0) {
                i5 += com.google.protobuf.k.X(11, i6);
            }
            if (this.svip_ != null) {
                i5 += com.google.protobuf.k.G(12, getSvip());
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i5;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public GMSvipDetail getSvip() {
            GMSvipDetail gMSvipDetail = this.svip_;
            if (gMSvipDetail == null) {
                return GMSvipDetail.getDefaultInstance();
            }
            return gMSvipDetail;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getSvipLevel() {
            return this.svipLevel_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public GMSvipDetailOrBuilder getSvipOrBuilder() {
            GMSvipDetail gMSvipDetail = this.svip_;
            if (gMSvipDetail == null) {
                return GMSvipDetail.getDefaultInstance();
            }
            return gMSvipDetail;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public long getWealthGrade() {
            return this.wealthGrade_;
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public boolean hasSvip() {
            if (this.svip_ != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int c = j0.c(getIsPretty()) + ((((j0.c(getIsVip()) + ((((j0.h(getCharmGrade()) + ((((j0.h(getWealthGrade()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53);
            if (getMedalsCount() > 0) {
                c = fd.g.a(c, 37, 5, 53) + getMedalsList().hashCode();
            }
            int cornerMark = getCornerMark() + ((((j0.h(getPowerGrade()) + ((((getPowerNameplate().hashCode() + ((((j0.h(getSvipLevel()) + ((((j0.h(getNobleLevel()) + ((((getPowerName().hashCode() + fd.g.a(c, 37, 6, 53)) * 37) + 7) * 53)) * 37) + 8) * 53)) * 37) + 9) * 53)) * 37) + 10) * 53)) * 37) + 11) * 53);
            if (hasSvip()) {
                cornerMark = fd.g.a(cornerMark, 37, 12, 53) + getSvip().hashCode();
            }
            int hashCode = getUnknownFields().hashCode() + (cornerMark * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode;
            return hashCode;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_CloudCustomData_fieldAccessorTable.d(CloudCustomData.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new CloudCustomData();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            getSerializedSize();
            long j = this.wealthGrade_;
            if (j != 0) {
                kVar.U0(1, j);
            }
            long j2 = this.charmGrade_;
            if (j2 != 0) {
                kVar.U0(2, j2);
            }
            boolean z = this.isVip_;
            if (z) {
                kVar.l0(3, z);
            }
            boolean z2 = this.isPretty_;
            if (z2) {
                kVar.l0(4, z2);
            }
            if (getMedalsList().size() > 0) {
                kVar.T0(42);
                kVar.T0(this.medalsMemoizedSerializedSize);
            }
            for (int i = 0; i < this.medals_.size(); i++) {
                kVar.V0(this.medals_.getLong(i));
            }
            if (!h0.isStringEmpty(this.powerName_)) {
                h0.writeString(kVar, 6, this.powerName_);
            }
            long j3 = this.nobleLevel_;
            if (j3 != 0) {
                kVar.U0(7, j3);
            }
            long j4 = this.svipLevel_;
            if (j4 != 0) {
                kVar.U0(8, j4);
            }
            if (!h0.isStringEmpty(this.powerNameplate_)) {
                h0.writeString(kVar, 9, this.powerNameplate_);
            }
            long j5 = this.powerGrade_;
            if (j5 != 0) {
                kVar.U0(10, j5);
            }
            int i2 = this.cornerMark_;
            if (i2 != 0) {
                kVar.S0(11, i2);
            }
            if (this.svip_ != null) {
                kVar.H0(12, getSvip());
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements CloudCustomDataOrBuilder {
            private int bitField0_;
            private long charmGrade_;
            private int cornerMark_;
            private boolean isPretty_;
            private boolean isVip_;
            private j0.h medals_;
            private long nobleLevel_;
            private long powerGrade_;
            private Object powerName_;
            private Object powerNameplate_;
            private b2 svipBuilder_;
            private long svipLevel_;
            private GMSvipDetail svip_;
            private long wealthGrade_;

            private void buildPartial0(CloudCustomData cloudCustomData) {
                GMSvipDetail b;
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    cloudCustomData.wealthGrade_ = this.wealthGrade_;
                }
                if ((i & 2) != 0) {
                    cloudCustomData.charmGrade_ = this.charmGrade_;
                }
                if ((i & 4) != 0) {
                    cloudCustomData.isVip_ = this.isVip_;
                }
                if ((i & 8) != 0) {
                    cloudCustomData.isPretty_ = this.isPretty_;
                }
                if ((i & 32) != 0) {
                    cloudCustomData.powerName_ = this.powerName_;
                }
                if ((i & 64) != 0) {
                    cloudCustomData.nobleLevel_ = this.nobleLevel_;
                }
                if ((i & 128) != 0) {
                    cloudCustomData.svipLevel_ = this.svipLevel_;
                }
                if ((i & 256) != 0) {
                    cloudCustomData.powerNameplate_ = this.powerNameplate_;
                }
                if ((i & 512) != 0) {
                    cloudCustomData.powerGrade_ = this.powerGrade_;
                }
                if ((i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
                    cloudCustomData.cornerMark_ = this.cornerMark_;
                }
                if ((i & 2048) != 0) {
                    b2 b2Var = this.svipBuilder_;
                    if (b2Var == null) {
                        b = this.svip_;
                    } else {
                        b = b2Var.b();
                    }
                    cloudCustomData.svip_ = b;
                }
            }

            private void buildPartialRepeatedFields(CloudCustomData cloudCustomData) {
                if ((this.bitField0_ & 16) != 0) {
                    this.medals_.b();
                    this.bitField0_ &= -17;
                }
                cloudCustomData.medals_ = this.medals_;
            }

            private void ensureMedalsIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.medals_ = h0.mutableCopy(this.medals_);
                    this.bitField0_ |= 16;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_CloudCustomData_descriptor;
            }

            private b2 getSvipFieldBuilder() {
                if (this.svipBuilder_ == null) {
                    this.svipBuilder_ = new b2(getSvip(), getParentForChildren(), isClean());
                    this.svip_ = null;
                }
                return this.svipBuilder_;
            }

            public Builder addAllMedals(Iterable<? extends Long> iterable) {
                ensureMedalsIsMutable();
                b.a.addAll(iterable, this.medals_);
                onChanged();
                return this;
            }

            public Builder addMedals(long j) {
                ensureMedalsIsMutable();
                this.medals_.I(j);
                onChanged();
                return this;
            }

            public Builder clearCharmGrade() {
                this.bitField0_ &= -3;
                this.charmGrade_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearCornerMark() {
                this.bitField0_ &= -1025;
                this.cornerMark_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsPretty() {
                this.bitField0_ &= -9;
                this.isPretty_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsVip() {
                this.bitField0_ &= -5;
                this.isVip_ = false;
                onChanged();
                return this;
            }

            public Builder clearMedals() {
                this.medals_ = CloudCustomData.access$2000();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            public Builder clearNobleLevel() {
                this.bitField0_ &= -65;
                this.nobleLevel_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearPowerGrade() {
                this.bitField0_ &= -513;
                this.powerGrade_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearPowerName() {
                this.powerName_ = CloudCustomData.getDefaultInstance().getPowerName();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public Builder clearPowerNameplate() {
                this.powerNameplate_ = CloudCustomData.getDefaultInstance().getPowerNameplate();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            public Builder clearSvip() {
                this.bitField0_ &= -2049;
                this.svip_ = null;
                b2 b2Var = this.svipBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.svipBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearSvipLevel() {
                this.bitField0_ &= -129;
                this.svipLevel_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearWealthGrade() {
                this.bitField0_ &= -2;
                this.wealthGrade_ = 0L;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getCharmGrade() {
                return this.charmGrade_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public int getCornerMark() {
                return this.cornerMark_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_CloudCustomData_descriptor;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public boolean getIsPretty() {
                return this.isPretty_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public boolean getIsVip() {
                return this.isVip_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getMedals(int i) {
                return this.medals_.getLong(i);
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public int getMedalsCount() {
                return this.medals_.size();
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public List<Long> getMedalsList() {
                if ((this.bitField0_ & 16) != 0) {
                    return Collections.unmodifiableList(this.medals_);
                }
                return this.medals_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getNobleLevel() {
                return this.nobleLevel_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getPowerGrade() {
                return this.powerGrade_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public String getPowerName() {
                Object obj = this.powerName_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.powerName_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public com.google.protobuf.h getPowerNameBytes() {
                Object obj = this.powerName_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.powerName_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public String getPowerNameplate() {
                Object obj = this.powerNameplate_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.powerNameplate_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public com.google.protobuf.h getPowerNameplateBytes() {
                Object obj = this.powerNameplate_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.powerNameplate_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public GMSvipDetail getSvip() {
                b2 b2Var = this.svipBuilder_;
                if (b2Var == null) {
                    GMSvipDetail gMSvipDetail = this.svip_;
                    if (gMSvipDetail == null) {
                        return GMSvipDetail.getDefaultInstance();
                    }
                    return gMSvipDetail;
                }
                return b2Var.e();
            }

            public GMSvipDetail.Builder getSvipBuilder() {
                this.bitField0_ |= 2048;
                onChanged();
                return getSvipFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getSvipLevel() {
                return this.svipLevel_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public GMSvipDetailOrBuilder getSvipOrBuilder() {
                b2 b2Var = this.svipBuilder_;
                if (b2Var != null) {
                    return (GMSvipDetailOrBuilder) b2Var.f();
                }
                GMSvipDetail gMSvipDetail = this.svip_;
                if (gMSvipDetail == null) {
                    return GMSvipDetail.getDefaultInstance();
                }
                return gMSvipDetail;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public long getWealthGrade() {
                return this.wealthGrade_;
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public boolean hasSvip() {
                if ((this.bitField0_ & 2048) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_CloudCustomData_fieldAccessorTable.d(CloudCustomData.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeSvip(GMSvipDetail gMSvipDetail) {
                GMSvipDetail gMSvipDetail2;
                b2 b2Var = this.svipBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 2048) != 0 && (gMSvipDetail2 = this.svip_) != null && gMSvipDetail2 != GMSvipDetail.getDefaultInstance()) {
                        getSvipBuilder().mergeFrom(gMSvipDetail);
                    } else {
                        this.svip_ = gMSvipDetail;
                    }
                } else {
                    b2Var.g(gMSvipDetail);
                }
                this.bitField0_ |= 2048;
                onChanged();
                return this;
            }

            public Builder setCharmGrade(long j) {
                this.charmGrade_ = j;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setCornerMark(int i) {
                this.cornerMark_ = i;
                this.bitField0_ |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                onChanged();
                return this;
            }

            public Builder setIsPretty(boolean z) {
                this.isPretty_ = z;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setIsVip(boolean z) {
                this.isVip_ = z;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setMedals(int i, long j) {
                ensureMedalsIsMutable();
                this.medals_.O(i, j);
                onChanged();
                return this;
            }

            public Builder setNobleLevel(long j) {
                this.nobleLevel_ = j;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setPowerGrade(long j) {
                this.powerGrade_ = j;
                this.bitField0_ |= 512;
                onChanged();
                return this;
            }

            public Builder setPowerName(String str) {
                str.getClass();
                this.powerName_ = str;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setPowerNameBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.powerName_ = hVar;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setPowerNameplate(String str) {
                str.getClass();
                this.powerNameplate_ = str;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setPowerNameplateBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.powerNameplate_ = hVar;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setSvip(GMSvipDetail gMSvipDetail) {
                b2 b2Var = this.svipBuilder_;
                if (b2Var == null) {
                    gMSvipDetail.getClass();
                    this.svip_ = gMSvipDetail;
                } else {
                    b2Var.i(gMSvipDetail);
                }
                this.bitField0_ |= 2048;
                onChanged();
                return this;
            }

            public Builder setSvipLevel(long j) {
                this.svipLevel_ = j;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setWealthGrade(long j) {
                this.wealthGrade_ = j;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.medals_ = CloudCustomData.access$1800();
                this.powerName_ = "";
                this.powerNameplate_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٤٩addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public CloudCustomData m٤٥١build() {
                CloudCustomData cloudCustomData = m٤٥٣buildPartial();
                if (cloudCustomData.isInitialized()) {
                    return cloudCustomData;
                }
                throw a.a.newUninitializedMessageException(cloudCustomData);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public CloudCustomData m٤٥٣buildPartial() {
                CloudCustomData cloudCustomData = new CloudCustomData(this);
                buildPartialRepeatedFields(cloudCustomData);
                if (this.bitField0_ != 0) {
                    buildPartial0(cloudCustomData);
                }
                onBuilt();
                return cloudCustomData;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٥٩clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
            public CloudCustomData mo٤٨٦getDefaultInstanceForType() {
                return CloudCustomData.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٨٠setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٨٢setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٤٨٤setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٦٢clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٤٧٨mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٥٧clear() {
                super.clear();
                this.bitField0_ = 0;
                this.wealthGrade_ = 0L;
                this.charmGrade_ = 0L;
                this.isVip_ = false;
                this.isPretty_ = false;
                this.medals_ = CloudCustomData.access$1700();
                this.powerName_ = "";
                this.nobleLevel_ = 0L;
                this.svipLevel_ = 0L;
                this.powerNameplate_ = "";
                this.powerGrade_ = 0L;
                this.cornerMark_ = 0;
                this.svip_ = null;
                b2 b2Var = this.svipBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.svipBuilder_ = null;
                }
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.medals_ = CloudCustomData.access$1800();
                this.powerName_ = "";
                this.powerNameplate_ = "";
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٦٨clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٧٢mergeFrom(b1 b1Var) {
                if (b1Var instanceof CloudCustomData) {
                    return mergeFrom((CloudCustomData) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setSvip(GMSvipDetail.Builder builder) {
                b2 b2Var = this.svipBuilder_;
                if (b2Var == null) {
                    this.svip_ = builder.m٥٤٣build();
                } else {
                    b2Var.i(builder.m٥٤٣build());
                }
                this.bitField0_ |= 2048;
                onChanged();
                return this;
            }

            public Builder mergeFrom(CloudCustomData cloudCustomData) {
                if (cloudCustomData == CloudCustomData.getDefaultInstance()) {
                    return this;
                }
                if (cloudCustomData.getWealthGrade() != 0) {
                    setWealthGrade(cloudCustomData.getWealthGrade());
                }
                if (cloudCustomData.getCharmGrade() != 0) {
                    setCharmGrade(cloudCustomData.getCharmGrade());
                }
                if (cloudCustomData.getIsVip()) {
                    setIsVip(cloudCustomData.getIsVip());
                }
                if (cloudCustomData.getIsPretty()) {
                    setIsPretty(cloudCustomData.getIsPretty());
                }
                if (!cloudCustomData.medals_.isEmpty()) {
                    if (this.medals_.isEmpty()) {
                        this.medals_ = cloudCustomData.medals_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureMedalsIsMutable();
                        this.medals_.addAll(cloudCustomData.medals_);
                    }
                    onChanged();
                }
                if (!cloudCustomData.getPowerName().isEmpty()) {
                    this.powerName_ = cloudCustomData.powerName_;
                    this.bitField0_ |= 32;
                    onChanged();
                }
                if (cloudCustomData.getNobleLevel() != 0) {
                    setNobleLevel(cloudCustomData.getNobleLevel());
                }
                if (cloudCustomData.getSvipLevel() != 0) {
                    setSvipLevel(cloudCustomData.getSvipLevel());
                }
                if (!cloudCustomData.getPowerNameplate().isEmpty()) {
                    this.powerNameplate_ = cloudCustomData.powerNameplate_;
                    this.bitField0_ |= 256;
                    onChanged();
                }
                if (cloudCustomData.getPowerGrade() != 0) {
                    setPowerGrade(cloudCustomData.getPowerGrade());
                }
                if (cloudCustomData.getCornerMark() != 0) {
                    setCornerMark(cloudCustomData.getCornerMark());
                }
                if (cloudCustomData.hasSvip()) {
                    mergeSvip(cloudCustomData.getSvip());
                }
                m٤٧٨mergeUnknownFields(cloudCustomData.getUnknownFields());
                onChanged();
                return this;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٧٤mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.wealthGrade_ = iVar.M();
                                    this.bitField0_ |= 1;
                                case 16:
                                    this.charmGrade_ = iVar.M();
                                    this.bitField0_ |= 2;
                                case 24:
                                    this.isVip_ = iVar.q();
                                    this.bitField0_ |= 4;
                                case 32:
                                    this.isPretty_ = iVar.q();
                                    this.bitField0_ |= 8;
                                case 40:
                                    long M = iVar.M();
                                    ensureMedalsIsMutable();
                                    this.medals_.I(M);
                                case 42:
                                    int p = iVar.p(iVar.C());
                                    ensureMedalsIsMutable();
                                    while (iVar.e() > 0) {
                                        this.medals_.I(iVar.M());
                                    }
                                    iVar.o(p);
                                case 50:
                                    this.powerName_ = iVar.J();
                                    this.bitField0_ |= 32;
                                case 56:
                                    this.nobleLevel_ = iVar.M();
                                    this.bitField0_ |= 64;
                                case 64:
                                    this.svipLevel_ = iVar.M();
                                    this.bitField0_ |= 128;
                                case 74:
                                    this.powerNameplate_ = iVar.J();
                                    this.bitField0_ |= 256;
                                case 80:
                                    this.powerGrade_ = iVar.M();
                                    this.bitField0_ |= 512;
                                case 88:
                                    this.cornerMark_ = iVar.L();
                                    this.bitField0_ |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                                case 98:
                                    iVar.B(getSvipFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 2048;
                                default:
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                        z = true;
                                    }
                            }
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private CloudCustomData(h0.b bVar) {
            super(bVar);
            this.wealthGrade_ = 0L;
            this.charmGrade_ = 0L;
            this.isVip_ = false;
            this.isPretty_ = false;
            this.medalsMemoizedSerializedSize = -1;
            this.powerName_ = "";
            this.nobleLevel_ = 0L;
            this.svipLevel_ = 0L;
            this.powerNameplate_ = "";
            this.powerGrade_ = 0L;
            this.cornerMark_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(CloudCustomData cloudCustomData) {
            return DEFAULT_INSTANCE.m٤٤٦toBuilder().mergeFrom(cloudCustomData);
        }

        public static CloudCustomData parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static CloudCustomData parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static CloudCustomData parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.CloudCustomDataOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public CloudCustomData mo٤٨٦getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٤٤٦toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CloudCustomData parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٤٤٣newBuilderForType() {
            return newBuilder();
        }

        public static CloudCustomData parseFrom(byte[] bArr) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static CloudCustomData parseFrom(byte[] bArr, v vVar) throws k0 {
            return (CloudCustomData) PARSER.parseFrom(bArr, vVar);
        }

        public static CloudCustomData parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static CloudCustomData parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static CloudCustomData parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static CloudCustomData parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }

        private CloudCustomData() {
            this.wealthGrade_ = 0L;
            this.charmGrade_ = 0L;
            this.isVip_ = false;
            this.isPretty_ = false;
            this.medalsMemoizedSerializedSize = -1;
            this.powerName_ = "";
            this.nobleLevel_ = 0L;
            this.svipLevel_ = 0L;
            this.powerNameplate_ = "";
            this.powerGrade_ = 0L;
            this.cornerMark_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.medals_ = h0.emptyLongList();
            this.powerName_ = "";
            this.powerNameplate_ = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface CloudCustomDataOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        long getCharmGrade();

        int getCornerMark();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٤٨٦getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٤٨٦getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        boolean getIsPretty();

        boolean getIsVip();

        long getMedals(int i);

        int getMedalsCount();

        List<Long> getMedalsList();

        long getNobleLevel();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        long getPowerGrade();

        String getPowerName();

        com.google.protobuf.h getPowerNameBytes();

        String getPowerNameplate();

        com.google.protobuf.h getPowerNameplateBytes();

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        GMSvipDetail getSvip();

        long getSvipLevel();

        GMSvipDetailOrBuilder getSvipOrBuilder();

        /* synthetic */ k2 getUnknownFields();

        long getWealthGrade();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        boolean hasSvip();

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class CustomElemContent extends h0 implements CustomElemContentOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final CustomElemContent DEFAULT_INSTANCE = new CustomElemContent();
        private static final r1 PARSER = new b();
        private static final long serialVersionUID = 0;
        private volatile Object data_;
        private byte memoizedIsInitialized;

        public static CustomElemContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_CustomElemContent_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٤٩٢toBuilder();
        }

        public static CustomElemContent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CustomElemContent parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CustomElemContent)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            CustomElemContent customElemContent = (CustomElemContent) obj;
            if (getData().equals(customElemContent.getData()) && getUnknownFields().equals(customElemContent.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
        public String getData() {
            Object obj = this.data_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.data_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
        public com.google.protobuf.h getDataBytes() {
            Object obj = this.data_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.data_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.data_)) {
                i = h0.computeStringSize(1, this.data_);
            } else {
                i = 0;
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getUnknownFields().hashCode() + ((getData().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode;
            return hashCode;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_CustomElemContent_fieldAccessorTable.d(CustomElemContent.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new CustomElemContent();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.data_)) {
                h0.writeString(kVar, 1, this.data_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements CustomElemContentOrBuilder {
            private int bitField0_;
            private Object data_;

            private void buildPartial0(CustomElemContent customElemContent) {
                if ((this.bitField0_ & 1) != 0) {
                    customElemContent.data_ = this.data_;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_CustomElemContent_descriptor;
            }

            public Builder clearData() {
                this.data_ = CustomElemContent.getDefaultInstance().getData();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
            public String getData() {
                Object obj = this.data_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.data_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
            public com.google.protobuf.h getDataBytes() {
                Object obj = this.data_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.data_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_CustomElemContent_descriptor;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_CustomElemContent_fieldAccessorTable.d(CustomElemContent.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setData(String str) {
                str.getClass();
                this.data_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setDataBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.data_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.data_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٤٩٥addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public CustomElemContent m٤٩٧build() {
                CustomElemContent customElemContent = m٤٩٩buildPartial();
                if (customElemContent.isInitialized()) {
                    return customElemContent;
                }
                throw a.a.newUninitializedMessageException(customElemContent);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public CustomElemContent m٤٩٩buildPartial() {
                CustomElemContent customElemContent = new CustomElemContent(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(customElemContent);
                }
                onBuilt();
                return customElemContent;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٠٥clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
            public CustomElemContent mo٥٣٢getDefaultInstanceForType() {
                return CustomElemContent.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٢٦setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٢٨setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٥٣٠setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٠٨clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٥٢٤mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.data_ = "";
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٠٣clear() {
                super.clear();
                this.bitField0_ = 0;
                this.data_ = "";
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥١٤clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥١٨mergeFrom(b1 b1Var) {
                if (b1Var instanceof CustomElemContent) {
                    return mergeFrom((CustomElemContent) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder mergeFrom(CustomElemContent customElemContent) {
                if (customElemContent == CustomElemContent.getDefaultInstance()) {
                    return this;
                }
                if (!customElemContent.getData().isEmpty()) {
                    this.data_ = customElemContent.data_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                m٥٢٤mergeUnknownFields(customElemContent.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٢٠mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.data_ = iVar.J();
                                    this.bitField0_ |= 1;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private CustomElemContent(h0.b bVar) {
            super(bVar);
            this.data_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(CustomElemContent customElemContent) {
            return DEFAULT_INSTANCE.m٤٩٢toBuilder().mergeFrom(customElemContent);
        }

        public static CustomElemContent parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static CustomElemContent parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static CustomElemContent parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.CustomElemContentOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public CustomElemContent mo٥٣٢getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٤٩٢toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CustomElemContent parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٤٨٩newBuilderForType() {
            return newBuilder();
        }

        private CustomElemContent() {
            this.data_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.data_ = "";
        }

        public static CustomElemContent parseFrom(byte[] bArr) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static CustomElemContent parseFrom(byte[] bArr, v vVar) throws k0 {
            return (CustomElemContent) PARSER.parseFrom(bArr, vVar);
        }

        public static CustomElemContent parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static CustomElemContent parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static CustomElemContent parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static CustomElemContent parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface CustomElemContentOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        String getData();

        com.google.protobuf.h getDataBytes();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٥٣٢getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٥٣٢getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class GMSvipDetail extends h0 implements GMSvipDetailOrBuilder {
        public static final int MYSTERY_CODE_FIELD_NUMBER = 2;
        public static final int SVIP_LEVEL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object mysteryCode_;
        private long svipLevel_;
        private static final GMSvipDetail DEFAULT_INSTANCE = new GMSvipDetail();
        private static final r1 PARSER = new c();

        public static GMSvipDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_GMSvipDetail_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٥٣٨toBuilder();
        }

        public static GMSvipDetail parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GMSvipDetail parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GMSvipDetail)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            GMSvipDetail gMSvipDetail = (GMSvipDetail) obj;
            if (getSvipLevel() != gMSvipDetail.getSvipLevel() || hasMysteryCode() != gMSvipDetail.hasMysteryCode()) {
                return false;
            }
            if ((!hasMysteryCode() || getMysteryCode().equals(gMSvipDetail.getMysteryCode())) && getUnknownFields().equals(gMSvipDetail.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public String getMysteryCode() {
            Object obj = this.mysteryCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.mysteryCode_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public com.google.protobuf.h getMysteryCodeBytes() {
            Object obj = this.mysteryCode_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.mysteryCode_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            long j = this.svipLevel_;
            if (j != 0) {
                i = com.google.protobuf.k.Z(1, j);
            } else {
                i = 0;
            }
            if ((this.bitField0_ & 1) != 0) {
                i += h0.computeStringSize(2, this.mysteryCode_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public long getSvipLevel() {
            return this.svipLevel_;
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public boolean hasMysteryCode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int h = j0.h(getSvipLevel()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
            if (hasMysteryCode()) {
                h = getMysteryCode().hashCode() + fd.g.a(h, 37, 2, 53);
            }
            int hashCode = getUnknownFields().hashCode() + (h * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode;
            return hashCode;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_GMSvipDetail_fieldAccessorTable.d(GMSvipDetail.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new GMSvipDetail();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            long j = this.svipLevel_;
            if (j != 0) {
                kVar.U0(1, j);
            }
            if ((this.bitField0_ & 1) != 0) {
                h0.writeString(kVar, 2, this.mysteryCode_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements GMSvipDetailOrBuilder {
            private int bitField0_;
            private Object mysteryCode_;
            private long svipLevel_;

            private void buildPartial0(GMSvipDetail gMSvipDetail) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    gMSvipDetail.svipLevel_ = this.svipLevel_;
                }
                if ((i2 & 2) != 0) {
                    gMSvipDetail.mysteryCode_ = this.mysteryCode_;
                    i = 1;
                } else {
                    i = 0;
                }
                gMSvipDetail.bitField0_ = i | gMSvipDetail.bitField0_;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_GMSvipDetail_descriptor;
            }

            public Builder clearMysteryCode() {
                this.mysteryCode_ = GMSvipDetail.getDefaultInstance().getMysteryCode();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearSvipLevel() {
                this.bitField0_ &= -2;
                this.svipLevel_ = 0L;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_GMSvipDetail_descriptor;
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public String getMysteryCode() {
                Object obj = this.mysteryCode_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.mysteryCode_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public com.google.protobuf.h getMysteryCodeBytes() {
                Object obj = this.mysteryCode_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.mysteryCode_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public long getSvipLevel() {
                return this.svipLevel_;
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public boolean hasMysteryCode() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_GMSvipDetail_fieldAccessorTable.d(GMSvipDetail.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setMysteryCode(String str) {
                str.getClass();
                this.mysteryCode_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setMysteryCodeBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.mysteryCode_ = hVar;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setSvipLevel(long j) {
                this.svipLevel_ = j;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.mysteryCode_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٤١addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GMSvipDetail m٥٤٣build() {
                GMSvipDetail gMSvipDetail = m٥٤٥buildPartial();
                if (gMSvipDetail.isInitialized()) {
                    return gMSvipDetail;
                }
                throw a.a.newUninitializedMessageException(gMSvipDetail);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GMSvipDetail m٥٤٥buildPartial() {
                GMSvipDetail gMSvipDetail = new GMSvipDetail(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(gMSvipDetail);
                }
                onBuilt();
                return gMSvipDetail;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٥١clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
            public GMSvipDetail mo٥٧٨getDefaultInstanceForType() {
                return GMSvipDetail.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٧٢setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٧٤setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٥٧٦setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٥٤clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٥٧٠mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.mysteryCode_ = "";
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٤٩clear() {
                super.clear();
                this.bitField0_ = 0;
                this.svipLevel_ = 0L;
                this.mysteryCode_ = "";
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٦٠clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٦٤mergeFrom(b1 b1Var) {
                if (b1Var instanceof GMSvipDetail) {
                    return mergeFrom((GMSvipDetail) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder mergeFrom(GMSvipDetail gMSvipDetail) {
                if (gMSvipDetail == GMSvipDetail.getDefaultInstance()) {
                    return this;
                }
                if (gMSvipDetail.getSvipLevel() != 0) {
                    setSvipLevel(gMSvipDetail.getSvipLevel());
                }
                if (gMSvipDetail.hasMysteryCode()) {
                    this.mysteryCode_ = gMSvipDetail.mysteryCode_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                m٥٧٠mergeUnknownFields(gMSvipDetail.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٦٦mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.svipLevel_ = iVar.M();
                                    this.bitField0_ |= 1;
                                } else if (K != 18) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.mysteryCode_ = iVar.J();
                                    this.bitField0_ |= 2;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private GMSvipDetail(h0.b bVar) {
            super(bVar);
            this.svipLevel_ = 0L;
            this.mysteryCode_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(GMSvipDetail gMSvipDetail) {
            return DEFAULT_INSTANCE.m٥٣٨toBuilder().mergeFrom(gMSvipDetail);
        }

        public static GMSvipDetail parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static GMSvipDetail parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static GMSvipDetail parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.GMSvipDetailOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public GMSvipDetail mo٥٧٨getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٥٣٨toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static GMSvipDetail parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٥٣٥newBuilderForType() {
            return newBuilder();
        }

        public static GMSvipDetail parseFrom(byte[] bArr) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        private GMSvipDetail() {
            this.svipLevel_ = 0L;
            this.mysteryCode_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.mysteryCode_ = "";
        }

        public static GMSvipDetail parseFrom(byte[] bArr, v vVar) throws k0 {
            return (GMSvipDetail) PARSER.parseFrom(bArr, vVar);
        }

        public static GMSvipDetail parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static GMSvipDetail parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static GMSvipDetail parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static GMSvipDetail parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface GMSvipDetailOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٥٧٨getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٥٧٨getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        String getMysteryCode();

        com.google.protobuf.h getMysteryCodeBytes();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        long getSvipLevel();

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        boolean hasMysteryCode();

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class GroupMessageNew extends h0 implements GroupMessageNewOrBuilder {
        public static final int CLOUD_CUSTOM_DATA_FIELD_NUMBER = 8;
        public static final int EVENT_TIME_FIELD_NUMBER = 9;
        public static final int FROM_ACCOUNT_FIELD_NUMBER = 2;
        public static final int GROUP_ID_FIELD_NUMBER = 6;
        public static final int MSG_BODY_FIELD_NUMBER = 7;
        public static final int MSG_ID_FIELD_NUMBER = 1;
        public static final int MSG_TAB_FIELD_NUMBER = 12;
        public static final int OPERATOR_ACCOUNT_FIELD_NUMBER = 5;
        public static final int SENDER_AVATAR_FIELD_NUMBER = 4;
        public static final int SENDER_NICK_FIELD_NUMBER = 3;
        public static final int STATUS_FIELD_NUMBER = 11;
        public static final int USER_ID_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private CloudCustomData cloudCustomData_;
        private long eventTime_;
        private volatile Object fromAccount_;
        private volatile Object groupId_;
        private byte memoizedIsInitialized;
        private List<MsgBody> msgBody_;
        private volatile Object msgId_;
        private int msgTab_;
        private volatile Object operatorAccount_;
        private volatile Object senderAvatar_;
        private volatile Object senderNick_;
        private int status_;
        private long userId_;
        private static final GroupMessageNew DEFAULT_INSTANCE = new GroupMessageNew();
        private static final r1 PARSER = new d();

        public static GroupMessageNew getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_GroupMessageNew_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٥٨٤toBuilder();
        }

        public static GroupMessageNew parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GroupMessageNew parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GroupMessageNew)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            GroupMessageNew groupMessageNew = (GroupMessageNew) obj;
            if (!getMsgId().equals(groupMessageNew.getMsgId()) || !getFromAccount().equals(groupMessageNew.getFromAccount()) || !getSenderNick().equals(groupMessageNew.getSenderNick()) || !getSenderAvatar().equals(groupMessageNew.getSenderAvatar()) || !getOperatorAccount().equals(groupMessageNew.getOperatorAccount()) || !getGroupId().equals(groupMessageNew.getGroupId()) || !getMsgBodyList().equals(groupMessageNew.getMsgBodyList()) || hasCloudCustomData() != groupMessageNew.hasCloudCustomData()) {
                return false;
            }
            if ((hasCloudCustomData() && !getCloudCustomData().equals(groupMessageNew.getCloudCustomData())) || hasEventTime() != groupMessageNew.hasEventTime()) {
                return false;
            }
            if ((hasEventTime() && getEventTime() != groupMessageNew.getEventTime()) || hasUserId() != groupMessageNew.hasUserId()) {
                return false;
            }
            if ((hasUserId() && getUserId() != groupMessageNew.getUserId()) || hasStatus() != groupMessageNew.hasStatus()) {
                return false;
            }
            if ((!hasStatus() || getStatus() == groupMessageNew.getStatus()) && getMsgTab() == groupMessageNew.getMsgTab() && getUnknownFields().equals(groupMessageNew.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public CloudCustomData getCloudCustomData() {
            CloudCustomData cloudCustomData = this.cloudCustomData_;
            if (cloudCustomData == null) {
                return CloudCustomData.getDefaultInstance();
            }
            return cloudCustomData;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public CloudCustomDataOrBuilder getCloudCustomDataOrBuilder() {
            CloudCustomData cloudCustomData = this.cloudCustomData_;
            if (cloudCustomData == null) {
                return CloudCustomData.getDefaultInstance();
            }
            return cloudCustomData;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public long getEventTime() {
            return this.eventTime_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getFromAccount() {
            Object obj = this.fromAccount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.fromAccount_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getFromAccountBytes() {
            Object obj = this.fromAccount_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.fromAccount_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getGroupId() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.groupId_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getGroupIdBytes() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.groupId_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public MsgBody getMsgBody(int i) {
            return this.msgBody_.get(i);
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public int getMsgBodyCount() {
            return this.msgBody_.size();
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public List<MsgBody> getMsgBodyList() {
            return this.msgBody_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public MsgBodyOrBuilder getMsgBodyOrBuilder(int i) {
            return this.msgBody_.get(i);
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList() {
            return this.msgBody_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getMsgId() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.msgId_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getMsgIdBytes() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.msgId_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public int getMsgTab() {
            return this.msgTab_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getOperatorAccount() {
            Object obj = this.operatorAccount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.operatorAccount_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getOperatorAccountBytes() {
            Object obj = this.operatorAccount_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.operatorAccount_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getSenderAvatar() {
            Object obj = this.senderAvatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.senderAvatar_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getSenderAvatarBytes() {
            Object obj = this.senderAvatar_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.senderAvatar_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public String getSenderNick() {
            Object obj = this.senderNick_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.senderNick_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public com.google.protobuf.h getSenderNickBytes() {
            Object obj = this.senderNick_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.senderNick_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.msgId_)) {
                i = h0.computeStringSize(1, this.msgId_);
            } else {
                i = 0;
            }
            if (!h0.isStringEmpty(this.fromAccount_)) {
                i += h0.computeStringSize(2, this.fromAccount_);
            }
            if (!h0.isStringEmpty(this.senderNick_)) {
                i += h0.computeStringSize(3, this.senderNick_);
            }
            if (!h0.isStringEmpty(this.senderAvatar_)) {
                i += h0.computeStringSize(4, this.senderAvatar_);
            }
            if (!h0.isStringEmpty(this.operatorAccount_)) {
                i += h0.computeStringSize(5, this.operatorAccount_);
            }
            if (!h0.isStringEmpty(this.groupId_)) {
                i += h0.computeStringSize(6, this.groupId_);
            }
            for (int i3 = 0; i3 < this.msgBody_.size(); i3++) {
                i += com.google.protobuf.k.G(7, this.msgBody_.get(i3));
            }
            if ((this.bitField0_ & 1) != 0) {
                i += com.google.protobuf.k.G(8, getCloudCustomData());
            }
            if ((this.bitField0_ & 2) != 0) {
                i += com.google.protobuf.k.z(9, this.eventTime_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i += com.google.protobuf.k.Z(10, this.userId_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i += com.google.protobuf.k.x(11, this.status_);
            }
            int i4 = this.msgTab_;
            if (i4 != 0) {
                i += com.google.protobuf.k.x(12, i4);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public long getUserId() {
            return this.userId_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public boolean hasCloudCustomData() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public boolean hasEventTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public boolean hasStatus() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public boolean hasUserId() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getGroupId().hashCode() + ((((getOperatorAccount().hashCode() + ((((getSenderAvatar().hashCode() + ((((getSenderNick().hashCode() + ((((getFromAccount().hashCode() + ((((getMsgId().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53);
            if (getMsgBodyCount() > 0) {
                hashCode = fd.g.a(hashCode, 37, 7, 53) + getMsgBodyList().hashCode();
            }
            if (hasCloudCustomData()) {
                hashCode = fd.g.a(hashCode, 37, 8, 53) + getCloudCustomData().hashCode();
            }
            if (hasEventTime()) {
                hashCode = fd.g.a(hashCode, 37, 9, 53) + j0.h(getEventTime());
            }
            if (hasUserId()) {
                hashCode = fd.g.a(hashCode, 37, 10, 53) + j0.h(getUserId());
            }
            if (hasStatus()) {
                hashCode = fd.g.a(hashCode, 37, 11, 53) + getStatus();
            }
            int hashCode2 = getUnknownFields().hashCode() + ((getMsgTab() + fd.g.a(hashCode, 37, 12, 53)) * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_GroupMessageNew_fieldAccessorTable.d(GroupMessageNew.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new GroupMessageNew();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.msgId_)) {
                h0.writeString(kVar, 1, this.msgId_);
            }
            if (!h0.isStringEmpty(this.fromAccount_)) {
                h0.writeString(kVar, 2, this.fromAccount_);
            }
            if (!h0.isStringEmpty(this.senderNick_)) {
                h0.writeString(kVar, 3, this.senderNick_);
            }
            if (!h0.isStringEmpty(this.senderAvatar_)) {
                h0.writeString(kVar, 4, this.senderAvatar_);
            }
            if (!h0.isStringEmpty(this.operatorAccount_)) {
                h0.writeString(kVar, 5, this.operatorAccount_);
            }
            if (!h0.isStringEmpty(this.groupId_)) {
                h0.writeString(kVar, 6, this.groupId_);
            }
            for (int i = 0; i < this.msgBody_.size(); i++) {
                kVar.H0(7, this.msgBody_.get(i));
            }
            if ((this.bitField0_ & 1) != 0) {
                kVar.H0(8, getCloudCustomData());
            }
            if ((this.bitField0_ & 2) != 0) {
                kVar.F0(9, this.eventTime_);
            }
            if ((this.bitField0_ & 4) != 0) {
                kVar.U0(10, this.userId_);
            }
            if ((this.bitField0_ & 8) != 0) {
                kVar.D0(11, this.status_);
            }
            int i2 = this.msgTab_;
            if (i2 != 0) {
                kVar.D0(12, i2);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements GroupMessageNewOrBuilder {
            private int bitField0_;
            private b2 cloudCustomDataBuilder_;
            private CloudCustomData cloudCustomData_;
            private long eventTime_;
            private Object fromAccount_;
            private Object groupId_;
            private x1 msgBodyBuilder_;
            private List<MsgBody> msgBody_;
            private Object msgId_;
            private int msgTab_;
            private Object operatorAccount_;
            private Object senderAvatar_;
            private Object senderNick_;
            private int status_;
            private long userId_;

            private void buildPartial0(GroupMessageNew groupMessageNew) {
                int i;
                CloudCustomData b;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    groupMessageNew.msgId_ = this.msgId_;
                }
                if ((i2 & 2) != 0) {
                    groupMessageNew.fromAccount_ = this.fromAccount_;
                }
                if ((i2 & 4) != 0) {
                    groupMessageNew.senderNick_ = this.senderNick_;
                }
                if ((i2 & 8) != 0) {
                    groupMessageNew.senderAvatar_ = this.senderAvatar_;
                }
                if ((i2 & 16) != 0) {
                    groupMessageNew.operatorAccount_ = this.operatorAccount_;
                }
                if ((i2 & 32) != 0) {
                    groupMessageNew.groupId_ = this.groupId_;
                }
                if ((i2 & 128) != 0) {
                    b2 b2Var = this.cloudCustomDataBuilder_;
                    if (b2Var == null) {
                        b = this.cloudCustomData_;
                    } else {
                        b = b2Var.b();
                    }
                    groupMessageNew.cloudCustomData_ = b;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 256) != 0) {
                    groupMessageNew.eventTime_ = this.eventTime_;
                    i |= 2;
                }
                if ((i2 & 512) != 0) {
                    groupMessageNew.userId_ = this.userId_;
                    i |= 4;
                }
                if ((i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
                    groupMessageNew.status_ = this.status_;
                    i |= 8;
                }
                if ((i2 & 2048) != 0) {
                    groupMessageNew.msgTab_ = this.msgTab_;
                }
                groupMessageNew.bitField0_ |= i;
            }

            private void buildPartialRepeatedFields(GroupMessageNew groupMessageNew) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var != null) {
                    groupMessageNew.msgBody_ = x1Var.g();
                    return;
                }
                if ((this.bitField0_ & 64) != 0) {
                    this.msgBody_ = Collections.unmodifiableList(this.msgBody_);
                    this.bitField0_ &= -65;
                }
                groupMessageNew.msgBody_ = this.msgBody_;
            }

            private void ensureMsgBodyIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.msgBody_ = new ArrayList(this.msgBody_);
                    this.bitField0_ |= 64;
                }
            }

            private b2 getCloudCustomDataFieldBuilder() {
                if (this.cloudCustomDataBuilder_ == null) {
                    this.cloudCustomDataBuilder_ = new b2(getCloudCustomData(), getParentForChildren(), isClean());
                    this.cloudCustomData_ = null;
                }
                return this.cloudCustomDataBuilder_;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_GroupMessageNew_descriptor;
            }

            private x1 getMsgBodyFieldBuilder() {
                boolean z;
                if (this.msgBodyBuilder_ == null) {
                    List<MsgBody> list = this.msgBody_;
                    if ((this.bitField0_ & 64) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.msgBodyBuilder_ = new x1(list, z, getParentForChildren(), isClean());
                    this.msgBody_ = null;
                }
                return this.msgBodyBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (h0.alwaysUseFieldBuilders) {
                    getMsgBodyFieldBuilder();
                    getCloudCustomDataFieldBuilder();
                }
            }

            public Builder addAllMsgBody(Iterable<? extends MsgBody> iterable) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    b.a.addAll(iterable, this.msgBody_);
                    onChanged();
                } else {
                    x1Var.b(iterable);
                }
                return this;
            }

            public Builder addMsgBody(MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(msgBody);
                    onChanged();
                } else {
                    x1Var.f(msgBody);
                }
                return this;
            }

            public MsgBody.Builder addMsgBodyBuilder() {
                return getMsgBodyFieldBuilder().d(MsgBody.getDefaultInstance());
            }

            public Builder clearCloudCustomData() {
                this.bitField0_ &= -129;
                this.cloudCustomData_ = null;
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.cloudCustomDataBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearEventTime() {
                this.bitField0_ &= -257;
                this.eventTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearFromAccount() {
                this.fromAccount_ = GroupMessageNew.getDefaultInstance().getFromAccount();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = GroupMessageNew.getDefaultInstance().getGroupId();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public Builder clearMsgBody() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    this.msgBody_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    x1Var.h();
                }
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = GroupMessageNew.getDefaultInstance().getMsgId();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearMsgTab() {
                this.bitField0_ &= -2049;
                this.msgTab_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOperatorAccount() {
                this.operatorAccount_ = GroupMessageNew.getDefaultInstance().getOperatorAccount();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            public Builder clearSenderAvatar() {
                this.senderAvatar_ = GroupMessageNew.getDefaultInstance().getSenderAvatar();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder clearSenderNick() {
                this.senderNick_ = GroupMessageNew.getDefaultInstance().getSenderNick();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= -1025;
                this.status_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.bitField0_ &= -513;
                this.userId_ = 0L;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public CloudCustomData getCloudCustomData() {
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var == null) {
                    CloudCustomData cloudCustomData = this.cloudCustomData_;
                    if (cloudCustomData == null) {
                        return CloudCustomData.getDefaultInstance();
                    }
                    return cloudCustomData;
                }
                return b2Var.e();
            }

            public CloudCustomData.Builder getCloudCustomDataBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return getCloudCustomDataFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public CloudCustomDataOrBuilder getCloudCustomDataOrBuilder() {
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var != null) {
                    return (CloudCustomDataOrBuilder) b2Var.f();
                }
                CloudCustomData cloudCustomData = this.cloudCustomData_;
                if (cloudCustomData == null) {
                    return CloudCustomData.getDefaultInstance();
                }
                return cloudCustomData;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_GroupMessageNew_descriptor;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public long getEventTime() {
                return this.eventTime_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getFromAccount() {
                Object obj = this.fromAccount_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.fromAccount_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getFromAccountBytes() {
                Object obj = this.fromAccount_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.fromAccount_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getGroupId() {
                Object obj = this.groupId_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.groupId_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getGroupIdBytes() {
                Object obj = this.groupId_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.groupId_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public MsgBody getMsgBody(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.get(i);
                }
                return x1Var.o(i);
            }

            public MsgBody.Builder getMsgBodyBuilder(int i) {
                return getMsgBodyFieldBuilder().l(i);
            }

            public List<MsgBody.Builder> getMsgBodyBuilderList() {
                return getMsgBodyFieldBuilder().m();
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public int getMsgBodyCount() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.size();
                }
                return x1Var.n();
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public List<MsgBody> getMsgBodyList() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return Collections.unmodifiableList(this.msgBody_);
                }
                return x1Var.q();
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public MsgBodyOrBuilder getMsgBodyOrBuilder(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.get(i);
                }
                return (MsgBodyOrBuilder) x1Var.r(i);
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var != null) {
                    return x1Var.s();
                }
                return Collections.unmodifiableList(this.msgBody_);
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getMsgId() {
                Object obj = this.msgId_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.msgId_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getMsgIdBytes() {
                Object obj = this.msgId_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.msgId_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public int getMsgTab() {
                return this.msgTab_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getOperatorAccount() {
                Object obj = this.operatorAccount_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.operatorAccount_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getOperatorAccountBytes() {
                Object obj = this.operatorAccount_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.operatorAccount_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getSenderAvatar() {
                Object obj = this.senderAvatar_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.senderAvatar_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getSenderAvatarBytes() {
                Object obj = this.senderAvatar_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.senderAvatar_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public String getSenderNick() {
                Object obj = this.senderNick_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.senderNick_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public com.google.protobuf.h getSenderNickBytes() {
                Object obj = this.senderNick_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.senderNick_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public int getStatus() {
                return this.status_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public long getUserId() {
                return this.userId_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public boolean hasCloudCustomData() {
                if ((this.bitField0_ & 128) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public boolean hasEventTime() {
                if ((this.bitField0_ & 256) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public boolean hasStatus() {
                if ((this.bitField0_ & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public boolean hasUserId() {
                if ((this.bitField0_ & 512) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_GroupMessageNew_fieldAccessorTable.d(GroupMessageNew.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCloudCustomData(CloudCustomData cloudCustomData) {
                CloudCustomData cloudCustomData2;
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 128) != 0 && (cloudCustomData2 = this.cloudCustomData_) != null && cloudCustomData2 != CloudCustomData.getDefaultInstance()) {
                        getCloudCustomDataBuilder().mergeFrom(cloudCustomData);
                    } else {
                        this.cloudCustomData_ = cloudCustomData;
                    }
                } else {
                    b2Var.g(cloudCustomData);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder removeMsgBody(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.remove(i);
                    onChanged();
                } else {
                    x1Var.w(i);
                }
                return this;
            }

            public Builder setCloudCustomData(CloudCustomData cloudCustomData) {
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var == null) {
                    cloudCustomData.getClass();
                    this.cloudCustomData_ = cloudCustomData;
                } else {
                    b2Var.i(cloudCustomData);
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setEventTime(long j) {
                this.eventTime_ = j;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setFromAccount(String str) {
                str.getClass();
                this.fromAccount_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setFromAccountBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.fromAccount_ = hVar;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setGroupId(String str) {
                str.getClass();
                this.groupId_ = str;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setGroupIdBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.groupId_ = hVar;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setMsgBody(int i, MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.set(i, msgBody);
                    onChanged();
                } else {
                    x1Var.x(i, msgBody);
                }
                return this;
            }

            public Builder setMsgId(String str) {
                str.getClass();
                this.msgId_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgIdBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.msgId_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgTab(int i) {
                this.msgTab_ = i;
                this.bitField0_ |= 2048;
                onChanged();
                return this;
            }

            public Builder setOperatorAccount(String str) {
                str.getClass();
                this.operatorAccount_ = str;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setOperatorAccountBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.operatorAccount_ = hVar;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setSenderAvatar(String str) {
                str.getClass();
                this.senderAvatar_ = str;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setSenderAvatarBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.senderAvatar_ = hVar;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setSenderNick(String str) {
                str.getClass();
                this.senderNick_ = str;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSenderNickBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.senderNick_ = hVar;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setStatus(int i) {
                this.status_ = i;
                this.bitField0_ |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                onChanged();
                return this;
            }

            public Builder setUserId(long j) {
                this.userId_ = j;
                this.bitField0_ |= 512;
                onChanged();
                return this;
            }

            private Builder() {
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.senderNick_ = "";
                this.senderAvatar_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                this.msgBody_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٨٧addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageNew m٥٨٩build() {
                GroupMessageNew groupMessageNew = m٥٩١buildPartial();
                if (groupMessageNew.isInitialized()) {
                    return groupMessageNew;
                }
                throw a.a.newUninitializedMessageException(groupMessageNew);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageNew m٥٩١buildPartial() {
                GroupMessageNew groupMessageNew = new GroupMessageNew(this);
                buildPartialRepeatedFields(groupMessageNew);
                if (this.bitField0_ != 0) {
                    buildPartial0(groupMessageNew);
                }
                onBuilt();
                return groupMessageNew;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٩٧clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
            public GroupMessageNew mo٦٢٤getDefaultInstanceForType() {
                return GroupMessageNew.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦١٨setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٢٠setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٦٢٢setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            public MsgBody.Builder addMsgBodyBuilder(int i) {
                return getMsgBodyFieldBuilder().c(i, MsgBody.getDefaultInstance());
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٠٠clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٦١٦mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٥٩٥clear() {
                super.clear();
                this.bitField0_ = 0;
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.senderNick_ = "";
                this.senderAvatar_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    this.msgBody_ = Collections.emptyList();
                } else {
                    this.msgBody_ = null;
                    x1Var.h();
                }
                this.bitField0_ &= -65;
                this.cloudCustomData_ = null;
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.cloudCustomDataBuilder_ = null;
                }
                this.eventTime_ = 0L;
                this.userId_ = 0L;
                this.status_ = 0;
                this.msgTab_ = 0;
                return this;
            }

            public Builder addMsgBody(int i, MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(i, msgBody);
                    onChanged();
                } else {
                    x1Var.e(i, msgBody);
                }
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٠٦clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦١٠mergeFrom(b1 b1Var) {
                if (b1Var instanceof GroupMessageNew) {
                    return mergeFrom((GroupMessageNew) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setCloudCustomData(CloudCustomData.Builder builder) {
                b2 b2Var = this.cloudCustomDataBuilder_;
                if (b2Var == null) {
                    this.cloudCustomData_ = builder.m٤٥١build();
                } else {
                    b2Var.i(builder.m٤٥١build());
                }
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setMsgBody(int i, MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.set(i, builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.x(i, builder.m٨١٩build());
                }
                return this;
            }

            public Builder mergeFrom(GroupMessageNew groupMessageNew) {
                if (groupMessageNew == GroupMessageNew.getDefaultInstance()) {
                    return this;
                }
                if (!groupMessageNew.getMsgId().isEmpty()) {
                    this.msgId_ = groupMessageNew.msgId_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (!groupMessageNew.getFromAccount().isEmpty()) {
                    this.fromAccount_ = groupMessageNew.fromAccount_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (!groupMessageNew.getSenderNick().isEmpty()) {
                    this.senderNick_ = groupMessageNew.senderNick_;
                    this.bitField0_ |= 4;
                    onChanged();
                }
                if (!groupMessageNew.getSenderAvatar().isEmpty()) {
                    this.senderAvatar_ = groupMessageNew.senderAvatar_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                if (!groupMessageNew.getOperatorAccount().isEmpty()) {
                    this.operatorAccount_ = groupMessageNew.operatorAccount_;
                    this.bitField0_ |= 16;
                    onChanged();
                }
                if (!groupMessageNew.getGroupId().isEmpty()) {
                    this.groupId_ = groupMessageNew.groupId_;
                    this.bitField0_ |= 32;
                    onChanged();
                }
                if (this.msgBodyBuilder_ == null) {
                    if (!groupMessageNew.msgBody_.isEmpty()) {
                        if (this.msgBody_.isEmpty()) {
                            this.msgBody_ = groupMessageNew.msgBody_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureMsgBodyIsMutable();
                            this.msgBody_.addAll(groupMessageNew.msgBody_);
                        }
                        onChanged();
                    }
                } else if (!groupMessageNew.msgBody_.isEmpty()) {
                    if (!this.msgBodyBuilder_.u()) {
                        this.msgBodyBuilder_.b(groupMessageNew.msgBody_);
                    } else {
                        this.msgBodyBuilder_.i();
                        this.msgBodyBuilder_ = null;
                        this.msgBody_ = groupMessageNew.msgBody_;
                        this.bitField0_ &= -65;
                        this.msgBodyBuilder_ = h0.alwaysUseFieldBuilders ? getMsgBodyFieldBuilder() : null;
                    }
                }
                if (groupMessageNew.hasCloudCustomData()) {
                    mergeCloudCustomData(groupMessageNew.getCloudCustomData());
                }
                if (groupMessageNew.hasEventTime()) {
                    setEventTime(groupMessageNew.getEventTime());
                }
                if (groupMessageNew.hasUserId()) {
                    setUserId(groupMessageNew.getUserId());
                }
                if (groupMessageNew.hasStatus()) {
                    setStatus(groupMessageNew.getStatus());
                }
                if (groupMessageNew.getMsgTab() != 0) {
                    setMsgTab(groupMessageNew.getMsgTab());
                }
                m٦١٦mergeUnknownFields(groupMessageNew.getUnknownFields());
                onChanged();
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.senderNick_ = "";
                this.senderAvatar_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                this.msgBody_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addMsgBody(MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.f(builder.m٨١٩build());
                }
                return this;
            }

            public Builder addMsgBody(int i, MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(i, builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.e(i, builder.m٨١٩build());
                }
                return this;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000b. Please report as an issue. */
            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦١٢mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            switch (K) {
                                case 0:
                                    z = true;
                                case 10:
                                    this.msgId_ = iVar.J();
                                    this.bitField0_ |= 1;
                                case 18:
                                    this.fromAccount_ = iVar.J();
                                    this.bitField0_ |= 2;
                                case 26:
                                    this.senderNick_ = iVar.J();
                                    this.bitField0_ |= 4;
                                case 34:
                                    this.senderAvatar_ = iVar.J();
                                    this.bitField0_ |= 8;
                                case 42:
                                    this.operatorAccount_ = iVar.J();
                                    this.bitField0_ |= 16;
                                case 50:
                                    this.groupId_ = iVar.J();
                                    this.bitField0_ |= 32;
                                case 58:
                                    MsgBody A = iVar.A(MsgBody.parser(), vVar);
                                    x1 x1Var = this.msgBodyBuilder_;
                                    if (x1Var == null) {
                                        ensureMsgBodyIsMutable();
                                        this.msgBody_.add(A);
                                    } else {
                                        x1Var.f(A);
                                    }
                                case 66:
                                    iVar.B(getCloudCustomDataFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 128;
                                case 72:
                                    this.eventTime_ = iVar.z();
                                    this.bitField0_ |= 256;
                                case 80:
                                    this.userId_ = iVar.M();
                                    this.bitField0_ |= 512;
                                case 88:
                                    this.status_ = iVar.y();
                                    this.bitField0_ |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                                case 96:
                                    this.msgTab_ = iVar.y();
                                    this.bitField0_ |= 2048;
                                default:
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                        z = true;
                                    }
                            }
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private GroupMessageNew(h0.b bVar) {
            super(bVar);
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.senderNick_ = "";
            this.senderAvatar_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.eventTime_ = 0L;
            this.userId_ = 0L;
            this.status_ = 0;
            this.msgTab_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(GroupMessageNew groupMessageNew) {
            return DEFAULT_INSTANCE.m٥٨٤toBuilder().mergeFrom(groupMessageNew);
        }

        public static GroupMessageNew parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static GroupMessageNew parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static GroupMessageNew parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.GroupMessageNewOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public GroupMessageNew mo٦٢٤getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٥٨٤toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static GroupMessageNew parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٥٨١newBuilderForType() {
            return newBuilder();
        }

        public static GroupMessageNew parseFrom(byte[] bArr) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static GroupMessageNew parseFrom(byte[] bArr, v vVar) throws k0 {
            return (GroupMessageNew) PARSER.parseFrom(bArr, vVar);
        }

        public static GroupMessageNew parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static GroupMessageNew parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static GroupMessageNew parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static GroupMessageNew parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }

        private GroupMessageNew() {
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.senderNick_ = "";
            this.senderAvatar_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.eventTime_ = 0L;
            this.userId_ = 0L;
            this.status_ = 0;
            this.msgTab_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.senderNick_ = "";
            this.senderAvatar_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.msgBody_ = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface GroupMessageNewOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        CloudCustomData getCloudCustomData();

        CloudCustomDataOrBuilder getCloudCustomDataOrBuilder();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٦٢٤getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٦٢٤getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        long getEventTime();

        /* synthetic */ Object getField(n.g gVar);

        String getFromAccount();

        com.google.protobuf.h getFromAccountBytes();

        String getGroupId();

        com.google.protobuf.h getGroupIdBytes();

        /* synthetic */ String getInitializationErrorString();

        MsgBody getMsgBody(int i);

        int getMsgBodyCount();

        List<MsgBody> getMsgBodyList();

        MsgBodyOrBuilder getMsgBodyOrBuilder(int i);

        List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList();

        String getMsgId();

        com.google.protobuf.h getMsgIdBytes();

        int getMsgTab();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        String getOperatorAccount();

        com.google.protobuf.h getOperatorAccountBytes();

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        String getSenderAvatar();

        com.google.protobuf.h getSenderAvatarBytes();

        String getSenderNick();

        com.google.protobuf.h getSenderNickBytes();

        int getStatus();

        /* synthetic */ k2 getUnknownFields();

        long getUserId();

        boolean hasCloudCustomData();

        boolean hasEventTime();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        boolean hasStatus();

        boolean hasUserId();

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class GroupMessageSend extends h0 implements GroupMessageSendOrBuilder {
        public static final int EVENT_TIME_FIELD_NUMBER = 6;
        public static final int FROM_ACCOUNT_FIELD_NUMBER = 2;
        public static final int GROUP_ID_FIELD_NUMBER = 4;
        public static final int MSG_BODY_FIELD_NUMBER = 5;
        public static final int MSG_ID_FIELD_NUMBER = 1;
        public static final int MSG_TAB_FIELD_NUMBER = 8;
        public static final int OPERATOR_ACCOUNT_FIELD_NUMBER = 3;
        public static final int STATUS_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long eventTime_;
        private volatile Object fromAccount_;
        private volatile Object groupId_;
        private byte memoizedIsInitialized;
        private List<MsgBody> msgBody_;
        private volatile Object msgId_;
        private int msgTab_;
        private volatile Object operatorAccount_;
        private int status_;
        private static final GroupMessageSend DEFAULT_INSTANCE = new GroupMessageSend();
        private static final r1 PARSER = new e();

        public static GroupMessageSend getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_GroupMessageSend_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٦٣٠toBuilder();
        }

        public static GroupMessageSend parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GroupMessageSend parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GroupMessageSend)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            GroupMessageSend groupMessageSend = (GroupMessageSend) obj;
            if (!getMsgId().equals(groupMessageSend.getMsgId()) || !getFromAccount().equals(groupMessageSend.getFromAccount()) || !getOperatorAccount().equals(groupMessageSend.getOperatorAccount()) || !getGroupId().equals(groupMessageSend.getGroupId()) || !getMsgBodyList().equals(groupMessageSend.getMsgBodyList()) || hasEventTime() != groupMessageSend.hasEventTime()) {
                return false;
            }
            if ((hasEventTime() && getEventTime() != groupMessageSend.getEventTime()) || hasStatus() != groupMessageSend.hasStatus()) {
                return false;
            }
            if ((!hasStatus() || getStatus() == groupMessageSend.getStatus()) && getMsgTab() == groupMessageSend.getMsgTab() && getUnknownFields().equals(groupMessageSend.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public long getEventTime() {
            return this.eventTime_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public String getFromAccount() {
            Object obj = this.fromAccount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.fromAccount_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public com.google.protobuf.h getFromAccountBytes() {
            Object obj = this.fromAccount_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.fromAccount_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public String getGroupId() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.groupId_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public com.google.protobuf.h getGroupIdBytes() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.groupId_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public MsgBody getMsgBody(int i) {
            return this.msgBody_.get(i);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public int getMsgBodyCount() {
            return this.msgBody_.size();
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public List<MsgBody> getMsgBodyList() {
            return this.msgBody_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public MsgBodyOrBuilder getMsgBodyOrBuilder(int i) {
            return this.msgBody_.get(i);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList() {
            return this.msgBody_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public String getMsgId() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.msgId_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public com.google.protobuf.h getMsgIdBytes() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.msgId_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public int getMsgTab() {
            return this.msgTab_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public String getOperatorAccount() {
            Object obj = this.operatorAccount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.operatorAccount_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public com.google.protobuf.h getOperatorAccountBytes() {
            Object obj = this.operatorAccount_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.operatorAccount_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.msgId_)) {
                i = h0.computeStringSize(1, this.msgId_);
            } else {
                i = 0;
            }
            if (!h0.isStringEmpty(this.fromAccount_)) {
                i += h0.computeStringSize(2, this.fromAccount_);
            }
            if (!h0.isStringEmpty(this.operatorAccount_)) {
                i += h0.computeStringSize(3, this.operatorAccount_);
            }
            if (!h0.isStringEmpty(this.groupId_)) {
                i += h0.computeStringSize(4, this.groupId_);
            }
            for (int i3 = 0; i3 < this.msgBody_.size(); i3++) {
                i += com.google.protobuf.k.G(5, this.msgBody_.get(i3));
            }
            if ((this.bitField0_ & 1) != 0) {
                i += com.google.protobuf.k.z(6, this.eventTime_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i += com.google.protobuf.k.x(7, this.status_);
            }
            int i4 = this.msgTab_;
            if (i4 != 0) {
                i += com.google.protobuf.k.x(8, i4);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public boolean hasEventTime() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public boolean hasStatus() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getGroupId().hashCode() + ((((getOperatorAccount().hashCode() + ((((getFromAccount().hashCode() + ((((getMsgId().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53);
            if (getMsgBodyCount() > 0) {
                hashCode = fd.g.a(hashCode, 37, 5, 53) + getMsgBodyList().hashCode();
            }
            if (hasEventTime()) {
                hashCode = fd.g.a(hashCode, 37, 6, 53) + j0.h(getEventTime());
            }
            if (hasStatus()) {
                hashCode = fd.g.a(hashCode, 37, 7, 53) + getStatus();
            }
            int hashCode2 = getUnknownFields().hashCode() + ((getMsgTab() + fd.g.a(hashCode, 37, 8, 53)) * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_GroupMessageSend_fieldAccessorTable.d(GroupMessageSend.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new GroupMessageSend();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.msgId_)) {
                h0.writeString(kVar, 1, this.msgId_);
            }
            if (!h0.isStringEmpty(this.fromAccount_)) {
                h0.writeString(kVar, 2, this.fromAccount_);
            }
            if (!h0.isStringEmpty(this.operatorAccount_)) {
                h0.writeString(kVar, 3, this.operatorAccount_);
            }
            if (!h0.isStringEmpty(this.groupId_)) {
                h0.writeString(kVar, 4, this.groupId_);
            }
            for (int i = 0; i < this.msgBody_.size(); i++) {
                kVar.H0(5, this.msgBody_.get(i));
            }
            if ((this.bitField0_ & 1) != 0) {
                kVar.F0(6, this.eventTime_);
            }
            if ((this.bitField0_ & 2) != 0) {
                kVar.D0(7, this.status_);
            }
            int i2 = this.msgTab_;
            if (i2 != 0) {
                kVar.D0(8, i2);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements GroupMessageSendOrBuilder {
            private int bitField0_;
            private long eventTime_;
            private Object fromAccount_;
            private Object groupId_;
            private x1 msgBodyBuilder_;
            private List<MsgBody> msgBody_;
            private Object msgId_;
            private int msgTab_;
            private Object operatorAccount_;
            private int status_;

            private void buildPartial0(GroupMessageSend groupMessageSend) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    groupMessageSend.msgId_ = this.msgId_;
                }
                if ((i2 & 2) != 0) {
                    groupMessageSend.fromAccount_ = this.fromAccount_;
                }
                if ((i2 & 4) != 0) {
                    groupMessageSend.operatorAccount_ = this.operatorAccount_;
                }
                if ((i2 & 8) != 0) {
                    groupMessageSend.groupId_ = this.groupId_;
                }
                if ((i2 & 32) != 0) {
                    groupMessageSend.eventTime_ = this.eventTime_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 64) != 0) {
                    groupMessageSend.status_ = this.status_;
                    i |= 2;
                }
                if ((i2 & 128) != 0) {
                    groupMessageSend.msgTab_ = this.msgTab_;
                }
                groupMessageSend.bitField0_ |= i;
            }

            private void buildPartialRepeatedFields(GroupMessageSend groupMessageSend) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var != null) {
                    groupMessageSend.msgBody_ = x1Var.g();
                    return;
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.msgBody_ = Collections.unmodifiableList(this.msgBody_);
                    this.bitField0_ &= -17;
                }
                groupMessageSend.msgBody_ = this.msgBody_;
            }

            private void ensureMsgBodyIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.msgBody_ = new ArrayList(this.msgBody_);
                    this.bitField0_ |= 16;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSend_descriptor;
            }

            private x1 getMsgBodyFieldBuilder() {
                boolean z;
                if (this.msgBodyBuilder_ == null) {
                    List<MsgBody> list = this.msgBody_;
                    if ((this.bitField0_ & 16) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.msgBodyBuilder_ = new x1(list, z, getParentForChildren(), isClean());
                    this.msgBody_ = null;
                }
                return this.msgBodyBuilder_;
            }

            public Builder addAllMsgBody(Iterable<? extends MsgBody> iterable) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    b.a.addAll(iterable, this.msgBody_);
                    onChanged();
                } else {
                    x1Var.b(iterable);
                }
                return this;
            }

            public Builder addMsgBody(MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(msgBody);
                    onChanged();
                } else {
                    x1Var.f(msgBody);
                }
                return this;
            }

            public MsgBody.Builder addMsgBodyBuilder() {
                return getMsgBodyFieldBuilder().d(MsgBody.getDefaultInstance());
            }

            public Builder clearEventTime() {
                this.bitField0_ &= -33;
                this.eventTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearFromAccount() {
                this.fromAccount_ = GroupMessageSend.getDefaultInstance().getFromAccount();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = GroupMessageSend.getDefaultInstance().getGroupId();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder clearMsgBody() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    this.msgBody_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    x1Var.h();
                }
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = GroupMessageSend.getDefaultInstance().getMsgId();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearMsgTab() {
                this.bitField0_ &= -129;
                this.msgTab_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOperatorAccount() {
                this.operatorAccount_ = GroupMessageSend.getDefaultInstance().getOperatorAccount();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.bitField0_ &= -65;
                this.status_ = 0;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSend_descriptor;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public long getEventTime() {
                return this.eventTime_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public String getFromAccount() {
                Object obj = this.fromAccount_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.fromAccount_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public com.google.protobuf.h getFromAccountBytes() {
                Object obj = this.fromAccount_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.fromAccount_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public String getGroupId() {
                Object obj = this.groupId_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.groupId_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public com.google.protobuf.h getGroupIdBytes() {
                Object obj = this.groupId_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.groupId_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public MsgBody getMsgBody(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.get(i);
                }
                return x1Var.o(i);
            }

            public MsgBody.Builder getMsgBodyBuilder(int i) {
                return getMsgBodyFieldBuilder().l(i);
            }

            public List<MsgBody.Builder> getMsgBodyBuilderList() {
                return getMsgBodyFieldBuilder().m();
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public int getMsgBodyCount() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.size();
                }
                return x1Var.n();
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public List<MsgBody> getMsgBodyList() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return Collections.unmodifiableList(this.msgBody_);
                }
                return x1Var.q();
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public MsgBodyOrBuilder getMsgBodyOrBuilder(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    return this.msgBody_.get(i);
                }
                return (MsgBodyOrBuilder) x1Var.r(i);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList() {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var != null) {
                    return x1Var.s();
                }
                return Collections.unmodifiableList(this.msgBody_);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public String getMsgId() {
                Object obj = this.msgId_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.msgId_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public com.google.protobuf.h getMsgIdBytes() {
                Object obj = this.msgId_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.msgId_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public int getMsgTab() {
                return this.msgTab_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public String getOperatorAccount() {
                Object obj = this.operatorAccount_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.operatorAccount_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public com.google.protobuf.h getOperatorAccountBytes() {
                Object obj = this.operatorAccount_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.operatorAccount_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public int getStatus() {
                return this.status_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public boolean hasEventTime() {
                if ((this.bitField0_ & 32) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public boolean hasStatus() {
                if ((this.bitField0_ & 64) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSend_fieldAccessorTable.d(GroupMessageSend.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder removeMsgBody(int i) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.remove(i);
                    onChanged();
                } else {
                    x1Var.w(i);
                }
                return this;
            }

            public Builder setEventTime(long j) {
                this.eventTime_ = j;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setFromAccount(String str) {
                str.getClass();
                this.fromAccount_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setFromAccountBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.fromAccount_ = hVar;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setGroupId(String str) {
                str.getClass();
                this.groupId_ = str;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setGroupIdBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.groupId_ = hVar;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setMsgBody(int i, MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.set(i, msgBody);
                    onChanged();
                } else {
                    x1Var.x(i, msgBody);
                }
                return this;
            }

            public Builder setMsgId(String str) {
                str.getClass();
                this.msgId_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgIdBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.msgId_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgTab(int i) {
                this.msgTab_ = i;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setOperatorAccount(String str) {
                str.getClass();
                this.operatorAccount_ = str;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setOperatorAccountBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.operatorAccount_ = hVar;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setStatus(int i) {
                this.status_ = i;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            private Builder() {
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                this.msgBody_ = Collections.emptyList();
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٣٣addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageSend m٦٣٥build() {
                GroupMessageSend groupMessageSend = m٦٣٧buildPartial();
                if (groupMessageSend.isInitialized()) {
                    return groupMessageSend;
                }
                throw a.a.newUninitializedMessageException(groupMessageSend);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageSend m٦٣٧buildPartial() {
                GroupMessageSend groupMessageSend = new GroupMessageSend(this);
                buildPartialRepeatedFields(groupMessageSend);
                if (this.bitField0_ != 0) {
                    buildPartial0(groupMessageSend);
                }
                onBuilt();
                return groupMessageSend;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٤٣clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
            public GroupMessageSend mo٦٧٠getDefaultInstanceForType() {
                return GroupMessageSend.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٦٤setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٦٦setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٦٦٨setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            public MsgBody.Builder addMsgBodyBuilder(int i) {
                return getMsgBodyFieldBuilder().c(i, MsgBody.getDefaultInstance());
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٤٦clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٦٦٢mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٤١clear() {
                super.clear();
                this.bitField0_ = 0;
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    this.msgBody_ = Collections.emptyList();
                } else {
                    this.msgBody_ = null;
                    x1Var.h();
                }
                this.bitField0_ &= -17;
                this.eventTime_ = 0L;
                this.status_ = 0;
                this.msgTab_ = 0;
                return this;
            }

            public Builder addMsgBody(int i, MsgBody msgBody) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    msgBody.getClass();
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(i, msgBody);
                    onChanged();
                } else {
                    x1Var.e(i, msgBody);
                }
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٥٢clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٥٦mergeFrom(b1 b1Var) {
                if (b1Var instanceof GroupMessageSend) {
                    return mergeFrom((GroupMessageSend) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setMsgBody(int i, MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.set(i, builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.x(i, builder.m٨١٩build());
                }
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.msgId_ = "";
                this.fromAccount_ = "";
                this.operatorAccount_ = "";
                this.groupId_ = "";
                this.msgBody_ = Collections.emptyList();
            }

            public Builder mergeFrom(GroupMessageSend groupMessageSend) {
                if (groupMessageSend == GroupMessageSend.getDefaultInstance()) {
                    return this;
                }
                if (!groupMessageSend.getMsgId().isEmpty()) {
                    this.msgId_ = groupMessageSend.msgId_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (!groupMessageSend.getFromAccount().isEmpty()) {
                    this.fromAccount_ = groupMessageSend.fromAccount_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (!groupMessageSend.getOperatorAccount().isEmpty()) {
                    this.operatorAccount_ = groupMessageSend.operatorAccount_;
                    this.bitField0_ |= 4;
                    onChanged();
                }
                if (!groupMessageSend.getGroupId().isEmpty()) {
                    this.groupId_ = groupMessageSend.groupId_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                if (this.msgBodyBuilder_ == null) {
                    if (!groupMessageSend.msgBody_.isEmpty()) {
                        if (this.msgBody_.isEmpty()) {
                            this.msgBody_ = groupMessageSend.msgBody_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureMsgBodyIsMutable();
                            this.msgBody_.addAll(groupMessageSend.msgBody_);
                        }
                        onChanged();
                    }
                } else if (!groupMessageSend.msgBody_.isEmpty()) {
                    if (!this.msgBodyBuilder_.u()) {
                        this.msgBodyBuilder_.b(groupMessageSend.msgBody_);
                    } else {
                        this.msgBodyBuilder_.i();
                        this.msgBodyBuilder_ = null;
                        this.msgBody_ = groupMessageSend.msgBody_;
                        this.bitField0_ &= -17;
                        this.msgBodyBuilder_ = h0.alwaysUseFieldBuilders ? getMsgBodyFieldBuilder() : null;
                    }
                }
                if (groupMessageSend.hasEventTime()) {
                    setEventTime(groupMessageSend.getEventTime());
                }
                if (groupMessageSend.hasStatus()) {
                    setStatus(groupMessageSend.getStatus());
                }
                if (groupMessageSend.getMsgTab() != 0) {
                    setMsgTab(groupMessageSend.getMsgTab());
                }
                m٦٦٢mergeUnknownFields(groupMessageSend.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder addMsgBody(MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.f(builder.m٨١٩build());
                }
                return this;
            }

            public Builder addMsgBody(int i, MsgBody.Builder builder) {
                x1 x1Var = this.msgBodyBuilder_;
                if (x1Var == null) {
                    ensureMsgBodyIsMutable();
                    this.msgBody_.add(i, builder.m٨١٩build());
                    onChanged();
                } else {
                    x1Var.e(i, builder.m٨١٩build());
                }
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٥٨mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    this.msgId_ = iVar.J();
                                    this.bitField0_ |= 1;
                                } else if (K == 18) {
                                    this.fromAccount_ = iVar.J();
                                    this.bitField0_ |= 2;
                                } else if (K == 26) {
                                    this.operatorAccount_ = iVar.J();
                                    this.bitField0_ |= 4;
                                } else if (K == 34) {
                                    this.groupId_ = iVar.J();
                                    this.bitField0_ |= 8;
                                } else if (K == 42) {
                                    MsgBody A = iVar.A(MsgBody.parser(), vVar);
                                    x1 x1Var = this.msgBodyBuilder_;
                                    if (x1Var == null) {
                                        ensureMsgBodyIsMutable();
                                        this.msgBody_.add(A);
                                    } else {
                                        x1Var.f(A);
                                    }
                                } else if (K == 48) {
                                    this.eventTime_ = iVar.z();
                                    this.bitField0_ |= 32;
                                } else if (K == 56) {
                                    this.status_ = iVar.y();
                                    this.bitField0_ |= 64;
                                } else if (K != 64) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.msgTab_ = iVar.y();
                                    this.bitField0_ |= 128;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private GroupMessageSend(h0.b bVar) {
            super(bVar);
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.eventTime_ = 0L;
            this.status_ = 0;
            this.msgTab_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(GroupMessageSend groupMessageSend) {
            return DEFAULT_INSTANCE.m٦٣٠toBuilder().mergeFrom(groupMessageSend);
        }

        public static GroupMessageSend parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static GroupMessageSend parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static GroupMessageSend parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public GroupMessageSend mo٦٧٠getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٦٣٠toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static GroupMessageSend parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٦٢٧newBuilderForType() {
            return newBuilder();
        }

        public static GroupMessageSend parseFrom(byte[] bArr) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static GroupMessageSend parseFrom(byte[] bArr, v vVar) throws k0 {
            return (GroupMessageSend) PARSER.parseFrom(bArr, vVar);
        }

        public static GroupMessageSend parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static GroupMessageSend parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        private GroupMessageSend() {
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.eventTime_ = 0L;
            this.status_ = 0;
            this.msgTab_ = 0;
            this.memoizedIsInitialized = (byte) -1;
            this.msgId_ = "";
            this.fromAccount_ = "";
            this.operatorAccount_ = "";
            this.groupId_ = "";
            this.msgBody_ = Collections.emptyList();
        }

        public static GroupMessageSend parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static GroupMessageSend parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface GroupMessageSendOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٦٧٠getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٦٧٠getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        long getEventTime();

        /* synthetic */ Object getField(n.g gVar);

        String getFromAccount();

        com.google.protobuf.h getFromAccountBytes();

        String getGroupId();

        com.google.protobuf.h getGroupIdBytes();

        /* synthetic */ String getInitializationErrorString();

        MsgBody getMsgBody(int i);

        int getMsgBodyCount();

        List<MsgBody> getMsgBodyList();

        MsgBodyOrBuilder getMsgBodyOrBuilder(int i);

        List<? extends MsgBodyOrBuilder> getMsgBodyOrBuilderList();

        String getMsgId();

        com.google.protobuf.h getMsgIdBytes();

        int getMsgTab();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        String getOperatorAccount();

        com.google.protobuf.h getOperatorAccountBytes();

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        int getStatus();

        /* synthetic */ k2 getUnknownFields();

        boolean hasEventTime();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        boolean hasStatus();

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class GroupMessageSendRsp extends h0 implements GroupMessageSendRspOrBuilder {
        public static final int ERR_CODE_FIELD_NUMBER = 2;
        public static final int ERR_MSG_FIELD_NUMBER = 3;
        public static final int MSG_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int errCode_;
        private volatile Object errMsg_;
        private byte memoizedIsInitialized;
        private volatile Object msgId_;
        private static final GroupMessageSendRsp DEFAULT_INSTANCE = new GroupMessageSendRsp();
        private static final r1 PARSER = new f();

        public static GroupMessageSendRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_GroupMessageSendRsp_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٦٧٦toBuilder();
        }

        public static GroupMessageSendRsp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static GroupMessageSendRsp parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GroupMessageSendRsp)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            GroupMessageSendRsp groupMessageSendRsp = (GroupMessageSendRsp) obj;
            if (getMsgId().equals(groupMessageSendRsp.getMsgId()) && getErrCode() == groupMessageSendRsp.getErrCode() && getErrMsg().equals(groupMessageSendRsp.getErrMsg()) && getUnknownFields().equals(groupMessageSendRsp.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public String getErrMsg() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.errMsg_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public com.google.protobuf.h getErrMsgBytes() {
            Object obj = this.errMsg_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.errMsg_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public String getMsgId() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.msgId_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public com.google.protobuf.h getMsgIdBytes() {
            Object obj = this.msgId_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.msgId_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.msgId_)) {
                i = h0.computeStringSize(1, this.msgId_);
            } else {
                i = 0;
            }
            int i3 = this.errCode_;
            if (i3 != 0) {
                i += com.google.protobuf.k.X(2, i3);
            }
            if (!h0.isStringEmpty(this.errMsg_)) {
                i += h0.computeStringSize(3, this.errMsg_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getUnknownFields().hashCode() + ((getErrMsg().hashCode() + ((((getErrCode() + ((((getMsgId().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode;
            return hashCode;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_GroupMessageSendRsp_fieldAccessorTable.d(GroupMessageSendRsp.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new GroupMessageSendRsp();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.msgId_)) {
                h0.writeString(kVar, 1, this.msgId_);
            }
            int i = this.errCode_;
            if (i != 0) {
                kVar.S0(2, i);
            }
            if (!h0.isStringEmpty(this.errMsg_)) {
                h0.writeString(kVar, 3, this.errMsg_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements GroupMessageSendRspOrBuilder {
            private int bitField0_;
            private int errCode_;
            private Object errMsg_;
            private Object msgId_;

            private void buildPartial0(GroupMessageSendRsp groupMessageSendRsp) {
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    groupMessageSendRsp.msgId_ = this.msgId_;
                }
                if ((i & 2) != 0) {
                    groupMessageSendRsp.errCode_ = this.errCode_;
                }
                if ((i & 4) != 0) {
                    groupMessageSendRsp.errMsg_ = this.errMsg_;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSendRsp_descriptor;
            }

            public Builder clearErrCode() {
                this.bitField0_ &= -3;
                this.errCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrMsg() {
                this.errMsg_ = GroupMessageSendRsp.getDefaultInstance().getErrMsg();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = GroupMessageSendRsp.getDefaultInstance().getMsgId();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSendRsp_descriptor;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public int getErrCode() {
                return this.errCode_;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public String getErrMsg() {
                Object obj = this.errMsg_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.errMsg_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public com.google.protobuf.h getErrMsgBytes() {
                Object obj = this.errMsg_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.errMsg_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public String getMsgId() {
                Object obj = this.msgId_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.msgId_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public com.google.protobuf.h getMsgIdBytes() {
                Object obj = this.msgId_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.msgId_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_GroupMessageSendRsp_fieldAccessorTable.d(GroupMessageSendRsp.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setErrCode(int i) {
                this.errCode_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setErrMsg(String str) {
                str.getClass();
                this.errMsg_ = str;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setErrMsgBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.errMsg_ = hVar;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setMsgId(String str) {
                str.getClass();
                this.msgId_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgIdBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.msgId_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.msgId_ = "";
                this.errMsg_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٧٩addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageSendRsp m٦٨١build() {
                GroupMessageSendRsp groupMessageSendRsp = m٦٨٣buildPartial();
                if (groupMessageSendRsp.isInitialized()) {
                    return groupMessageSendRsp;
                }
                throw a.a.newUninitializedMessageException(groupMessageSendRsp);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public GroupMessageSendRsp m٦٨٣buildPartial() {
                GroupMessageSendRsp groupMessageSendRsp = new GroupMessageSendRsp(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(groupMessageSendRsp);
                }
                onBuilt();
                return groupMessageSendRsp;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٨٩clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
            public GroupMessageSendRsp mo٧١٦getDefaultInstanceForType() {
                return GroupMessageSendRsp.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧١٠setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧١٢setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٧١٤setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٩٢clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٧٠٨mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٨٧clear() {
                super.clear();
                this.bitField0_ = 0;
                this.msgId_ = "";
                this.errCode_ = 0;
                this.errMsg_ = "";
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.msgId_ = "";
                this.errMsg_ = "";
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٦٩٨clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٠٢mergeFrom(b1 b1Var) {
                if (b1Var instanceof GroupMessageSendRsp) {
                    return mergeFrom((GroupMessageSendRsp) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder mergeFrom(GroupMessageSendRsp groupMessageSendRsp) {
                if (groupMessageSendRsp == GroupMessageSendRsp.getDefaultInstance()) {
                    return this;
                }
                if (!groupMessageSendRsp.getMsgId().isEmpty()) {
                    this.msgId_ = groupMessageSendRsp.msgId_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (groupMessageSendRsp.getErrCode() != 0) {
                    setErrCode(groupMessageSendRsp.getErrCode());
                }
                if (!groupMessageSendRsp.getErrMsg().isEmpty()) {
                    this.errMsg_ = groupMessageSendRsp.errMsg_;
                    this.bitField0_ |= 4;
                    onChanged();
                }
                m٧٠٨mergeUnknownFields(groupMessageSendRsp.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٠٤mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    this.msgId_ = iVar.J();
                                    this.bitField0_ |= 1;
                                } else if (K == 16) {
                                    this.errCode_ = iVar.L();
                                    this.bitField0_ |= 2;
                                } else if (K != 26) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.errMsg_ = iVar.J();
                                    this.bitField0_ |= 4;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private GroupMessageSendRsp(h0.b bVar) {
            super(bVar);
            this.msgId_ = "";
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(GroupMessageSendRsp groupMessageSendRsp) {
            return DEFAULT_INSTANCE.m٦٧٦toBuilder().mergeFrom(groupMessageSendRsp);
        }

        public static GroupMessageSendRsp parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static GroupMessageSendRsp parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static GroupMessageSendRsp parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.GroupMessageSendRspOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public GroupMessageSendRsp mo٧١٦getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٦٧٦toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static GroupMessageSendRsp parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٦٧٣newBuilderForType() {
            return newBuilder();
        }

        public static GroupMessageSendRsp parseFrom(byte[] bArr) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static GroupMessageSendRsp parseFrom(byte[] bArr, v vVar) throws k0 {
            return (GroupMessageSendRsp) PARSER.parseFrom(bArr, vVar);
        }

        private GroupMessageSendRsp() {
            this.msgId_ = "";
            this.errCode_ = 0;
            this.errMsg_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.msgId_ = "";
            this.errMsg_ = "";
        }

        public static GroupMessageSendRsp parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static GroupMessageSendRsp parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static GroupMessageSendRsp parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static GroupMessageSendRsp parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface GroupMessageSendRspOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٧١٦getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٧١٦getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        int getErrCode();

        String getErrMsg();

        com.google.protobuf.h getErrMsgBytes();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        String getMsgId();

        com.google.protobuf.h getMsgIdBytes();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class ImageElemContent extends h0 implements ImageElemContentOrBuilder {
        public static final int IMAGE_INFO_ARRAY_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<ImageInfo> imageInfoArray_;
        private byte memoizedIsInitialized;
        private static final ImageElemContent DEFAULT_INSTANCE = new ImageElemContent();
        private static final r1 PARSER = new g();

        public static ImageElemContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_ImageElemContent_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٧٢٢toBuilder();
        }

        public static ImageElemContent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImageElemContent parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImageElemContent)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            ImageElemContent imageElemContent = (ImageElemContent) obj;
            if (getImageInfoArrayList().equals(imageElemContent.getImageInfoArrayList()) && getUnknownFields().equals(imageElemContent.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public ImageInfo getImageInfoArray(int i) {
            return this.imageInfoArray_.get(i);
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public int getImageInfoArrayCount() {
            return this.imageInfoArray_.size();
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public List<ImageInfo> getImageInfoArrayList() {
            return this.imageInfoArray_;
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public ImageInfoOrBuilder getImageInfoArrayOrBuilder(int i) {
            return this.imageInfoArray_.get(i);
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public List<? extends ImageInfoOrBuilder> getImageInfoArrayOrBuilderList() {
            return this.imageInfoArray_;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = ((com.google.protobuf.a) this).memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.imageInfoArray_.size(); i3++) {
                i2 += com.google.protobuf.k.G(1, this.imageInfoArray_.get(i3));
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i2;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getDescriptor().hashCode() + 779;
            if (getImageInfoArrayCount() > 0) {
                hashCode = fd.g.a(hashCode, 37, 1, 53) + getImageInfoArrayList().hashCode();
            }
            int hashCode2 = getUnknownFields().hashCode() + (hashCode * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_ImageElemContent_fieldAccessorTable.d(ImageElemContent.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new ImageElemContent();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            for (int i = 0; i < this.imageInfoArray_.size(); i++) {
                kVar.H0(1, this.imageInfoArray_.get(i));
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements ImageElemContentOrBuilder {
            private int bitField0_;
            private x1 imageInfoArrayBuilder_;
            private List<ImageInfo> imageInfoArray_;

            private void buildPartial0(ImageElemContent imageElemContent) {
            }

            private void buildPartialRepeatedFields(ImageElemContent imageElemContent) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var != null) {
                    imageElemContent.imageInfoArray_ = x1Var.g();
                    return;
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.imageInfoArray_ = Collections.unmodifiableList(this.imageInfoArray_);
                    this.bitField0_ &= -2;
                }
                imageElemContent.imageInfoArray_ = this.imageInfoArray_;
            }

            private void ensureImageInfoArrayIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.imageInfoArray_ = new ArrayList(this.imageInfoArray_);
                    this.bitField0_ |= 1;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_ImageElemContent_descriptor;
            }

            private x1 getImageInfoArrayFieldBuilder() {
                if (this.imageInfoArrayBuilder_ == null) {
                    List<ImageInfo> list = this.imageInfoArray_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.imageInfoArrayBuilder_ = new x1(list, z, getParentForChildren(), isClean());
                    this.imageInfoArray_ = null;
                }
                return this.imageInfoArrayBuilder_;
            }

            public Builder addAllImageInfoArray(Iterable<? extends ImageInfo> iterable) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    ensureImageInfoArrayIsMutable();
                    b.a.addAll(iterable, this.imageInfoArray_);
                    onChanged();
                } else {
                    x1Var.b(iterable);
                }
                return this;
            }

            public Builder addImageInfoArray(ImageInfo imageInfo) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    imageInfo.getClass();
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.add(imageInfo);
                    onChanged();
                } else {
                    x1Var.f(imageInfo);
                }
                return this;
            }

            public ImageInfo.Builder addImageInfoArrayBuilder() {
                return getImageInfoArrayFieldBuilder().d(ImageInfo.getDefaultInstance());
            }

            public Builder clearImageInfoArray() {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    this.imageInfoArray_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    x1Var.h();
                }
                return this;
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_ImageElemContent_descriptor;
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public ImageInfo getImageInfoArray(int i) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    return this.imageInfoArray_.get(i);
                }
                return x1Var.o(i);
            }

            public ImageInfo.Builder getImageInfoArrayBuilder(int i) {
                return getImageInfoArrayFieldBuilder().l(i);
            }

            public List<ImageInfo.Builder> getImageInfoArrayBuilderList() {
                return getImageInfoArrayFieldBuilder().m();
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public int getImageInfoArrayCount() {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    return this.imageInfoArray_.size();
                }
                return x1Var.n();
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public List<ImageInfo> getImageInfoArrayList() {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    return Collections.unmodifiableList(this.imageInfoArray_);
                }
                return x1Var.q();
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public ImageInfoOrBuilder getImageInfoArrayOrBuilder(int i) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    return this.imageInfoArray_.get(i);
                }
                return (ImageInfoOrBuilder) x1Var.r(i);
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public List<? extends ImageInfoOrBuilder> getImageInfoArrayOrBuilderList() {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var != null) {
                    return x1Var.s();
                }
                return Collections.unmodifiableList(this.imageInfoArray_);
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_ImageElemContent_fieldAccessorTable.d(ImageElemContent.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder removeImageInfoArray(int i) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.remove(i);
                    onChanged();
                } else {
                    x1Var.w(i);
                }
                return this;
            }

            public Builder setImageInfoArray(int i, ImageInfo imageInfo) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    imageInfo.getClass();
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.set(i, imageInfo);
                    onChanged();
                } else {
                    x1Var.x(i, imageInfo);
                }
                return this;
            }

            private Builder() {
                this.imageInfoArray_ = Collections.emptyList();
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٢٥addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public ImageElemContent m٧٢٧build() {
                ImageElemContent imageElemContent = m٧٢٩buildPartial();
                if (imageElemContent.isInitialized()) {
                    return imageElemContent;
                }
                throw a.a.newUninitializedMessageException(imageElemContent);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public ImageElemContent m٧٢٩buildPartial() {
                ImageElemContent imageElemContent = new ImageElemContent(this);
                buildPartialRepeatedFields(imageElemContent);
                if (this.bitField0_ != 0) {
                    buildPartial0(imageElemContent);
                }
                onBuilt();
                return imageElemContent;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٣٥clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
            public ImageElemContent mo٧٦٢getDefaultInstanceForType() {
                return ImageElemContent.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٥٦setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٥٨setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٧٦٠setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            public ImageInfo.Builder addImageInfoArrayBuilder(int i) {
                return getImageInfoArrayFieldBuilder().c(i, ImageInfo.getDefaultInstance());
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٣٨clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٧٥٤mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.imageInfoArray_ = Collections.emptyList();
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٣٣clear() {
                super.clear();
                this.bitField0_ = 0;
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    this.imageInfoArray_ = Collections.emptyList();
                } else {
                    this.imageInfoArray_ = null;
                    x1Var.h();
                }
                this.bitField0_ &= -2;
                return this;
            }

            public Builder addImageInfoArray(int i, ImageInfo imageInfo) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    imageInfo.getClass();
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.add(i, imageInfo);
                    onChanged();
                } else {
                    x1Var.e(i, imageInfo);
                }
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٤٤clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٤٨mergeFrom(b1 b1Var) {
                if (b1Var instanceof ImageElemContent) {
                    return mergeFrom((ImageElemContent) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setImageInfoArray(int i, ImageInfo.Builder builder) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.set(i, builder.m٧٧٣build());
                    onChanged();
                } else {
                    x1Var.x(i, builder.m٧٧٣build());
                }
                return this;
            }

            public Builder mergeFrom(ImageElemContent imageElemContent) {
                if (imageElemContent == ImageElemContent.getDefaultInstance()) {
                    return this;
                }
                if (this.imageInfoArrayBuilder_ == null) {
                    if (!imageElemContent.imageInfoArray_.isEmpty()) {
                        if (this.imageInfoArray_.isEmpty()) {
                            this.imageInfoArray_ = imageElemContent.imageInfoArray_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureImageInfoArrayIsMutable();
                            this.imageInfoArray_.addAll(imageElemContent.imageInfoArray_);
                        }
                        onChanged();
                    }
                } else if (!imageElemContent.imageInfoArray_.isEmpty()) {
                    if (!this.imageInfoArrayBuilder_.u()) {
                        this.imageInfoArrayBuilder_.b(imageElemContent.imageInfoArray_);
                    } else {
                        this.imageInfoArrayBuilder_.i();
                        this.imageInfoArrayBuilder_ = null;
                        this.imageInfoArray_ = imageElemContent.imageInfoArray_;
                        this.bitField0_ &= -2;
                        this.imageInfoArrayBuilder_ = h0.alwaysUseFieldBuilders ? getImageInfoArrayFieldBuilder() : null;
                    }
                }
                m٧٥٤mergeUnknownFields(imageElemContent.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder addImageInfoArray(ImageInfo.Builder builder) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.add(builder.m٧٧٣build());
                    onChanged();
                } else {
                    x1Var.f(builder.m٧٧٣build());
                }
                return this;
            }

            public Builder addImageInfoArray(int i, ImageInfo.Builder builder) {
                x1 x1Var = this.imageInfoArrayBuilder_;
                if (x1Var == null) {
                    ensureImageInfoArrayIsMutable();
                    this.imageInfoArray_.add(i, builder.m٧٧٣build());
                    onChanged();
                } else {
                    x1Var.e(i, builder.m٧٧٣build());
                }
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٥٠mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    ImageInfo A = iVar.A(ImageInfo.parser(), vVar);
                                    x1 x1Var = this.imageInfoArrayBuilder_;
                                    if (x1Var == null) {
                                        ensureImageInfoArrayIsMutable();
                                        this.imageInfoArray_.add(A);
                                    } else {
                                        x1Var.f(A);
                                    }
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private ImageElemContent(h0.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(ImageElemContent imageElemContent) {
            return DEFAULT_INSTANCE.m٧٢٢toBuilder().mergeFrom(imageElemContent);
        }

        public static ImageElemContent parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static ImageElemContent parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static ImageElemContent parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.ImageElemContentOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public ImageElemContent mo٧٦٢getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٧٢٢toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        private ImageElemContent() {
            this.memoizedIsInitialized = (byte) -1;
            this.imageInfoArray_ = Collections.emptyList();
        }

        public static ImageElemContent parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٧١٩newBuilderForType() {
            return newBuilder();
        }

        public static ImageElemContent parseFrom(byte[] bArr) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static ImageElemContent parseFrom(byte[] bArr, v vVar) throws k0 {
            return (ImageElemContent) PARSER.parseFrom(bArr, vVar);
        }

        public static ImageElemContent parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static ImageElemContent parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static ImageElemContent parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static ImageElemContent parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface ImageElemContentOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٧٦٢getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٧٦٢getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        ImageInfo getImageInfoArray(int i);

        int getImageInfoArrayCount();

        List<ImageInfo> getImageInfoArrayList();

        ImageInfoOrBuilder getImageInfoArrayOrBuilder(int i);

        List<? extends ImageInfoOrBuilder> getImageInfoArrayOrBuilderList();

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class ImageInfo extends h0 implements ImageInfoOrBuilder {
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int LOCAL_PATH_FIELD_NUMBER = 6;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int URL_FIELD_NUMBER = 5;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int height_;
        private volatile Object localPath_;
        private byte memoizedIsInitialized;
        private long size_;
        private volatile Object url_;
        private int width_;
        private static final ImageInfo DEFAULT_INSTANCE = new ImageInfo();
        private static final r1 PARSER = new h();

        public static ImageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_ImageInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٧٦٨toBuilder();
        }

        public static ImageInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImageInfo parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (ImageInfo) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImageInfo)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            ImageInfo imageInfo = (ImageInfo) obj;
            if (getWidth() != imageInfo.getWidth() || getHeight() != imageInfo.getHeight() || getSize() != imageInfo.getSize() || !getUrl().equals(imageInfo.getUrl()) || hasLocalPath() != imageInfo.hasLocalPath()) {
                return false;
            }
            if ((!hasLocalPath() || getLocalPath().equals(imageInfo.getLocalPath())) && getUnknownFields().equals(imageInfo.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public String getLocalPath() {
            Object obj = this.localPath_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.localPath_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public com.google.protobuf.h getLocalPathBytes() {
            Object obj = this.localPath_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.localPath_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.width_;
            if (i3 != 0) {
                i = com.google.protobuf.k.x(1, i3);
            } else {
                i = 0;
            }
            int i4 = this.height_;
            if (i4 != 0) {
                i += com.google.protobuf.k.x(2, i4);
            }
            long j = this.size_;
            if (j != 0) {
                i += com.google.protobuf.k.Z(3, j);
            }
            if (!h0.isStringEmpty(this.url_)) {
                i += h0.computeStringSize(5, this.url_);
            }
            if ((1 & this.bitField0_) != 0) {
                i += h0.computeStringSize(6, this.localPath_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public long getSize() {
            return this.size_;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.url_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public com.google.protobuf.h getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.url_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public boolean hasLocalPath() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getUrl().hashCode() + ((((j0.h(getSize()) + ((((getHeight() + ((((getWidth() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 5) * 53);
            if (hasLocalPath()) {
                hashCode = fd.g.a(hashCode, 37, 6, 53) + getLocalPath().hashCode();
            }
            int hashCode2 = getUnknownFields().hashCode() + (hashCode * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_ImageInfo_fieldAccessorTable.d(ImageInfo.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new ImageInfo();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            int i = this.width_;
            if (i != 0) {
                kVar.D0(1, i);
            }
            int i2 = this.height_;
            if (i2 != 0) {
                kVar.D0(2, i2);
            }
            long j = this.size_;
            if (j != 0) {
                kVar.U0(3, j);
            }
            if (!h0.isStringEmpty(this.url_)) {
                h0.writeString(kVar, 5, this.url_);
            }
            if ((this.bitField0_ & 1) != 0) {
                h0.writeString(kVar, 6, this.localPath_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements ImageInfoOrBuilder {
            private int bitField0_;
            private int height_;
            private Object localPath_;
            private long size_;
            private Object url_;
            private int width_;

            private void buildPartial0(ImageInfo imageInfo) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    imageInfo.width_ = this.width_;
                }
                if ((i2 & 2) != 0) {
                    imageInfo.height_ = this.height_;
                }
                if ((i2 & 4) != 0) {
                    imageInfo.size_ = this.size_;
                }
                if ((i2 & 8) != 0) {
                    imageInfo.url_ = this.url_;
                }
                if ((i2 & 16) != 0) {
                    imageInfo.localPath_ = this.localPath_;
                    i = 1;
                } else {
                    i = 0;
                }
                imageInfo.bitField0_ = i | imageInfo.bitField0_;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_ImageInfo_descriptor;
            }

            public Builder clearHeight() {
                this.bitField0_ &= -3;
                this.height_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLocalPath() {
                this.localPath_ = ImageInfo.getDefaultInstance().getLocalPath();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            public Builder clearSize() {
                this.bitField0_ &= -5;
                this.size_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = ImageInfo.getDefaultInstance().getUrl();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.bitField0_ &= -2;
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_ImageInfo_descriptor;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public int getHeight() {
                return this.height_;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public String getLocalPath() {
                Object obj = this.localPath_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.localPath_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public com.google.protobuf.h getLocalPathBytes() {
                Object obj = this.localPath_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.localPath_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public long getSize() {
                return this.size_;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.url_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public com.google.protobuf.h getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.url_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public int getWidth() {
                return this.width_;
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public boolean hasLocalPath() {
                if ((this.bitField0_ & 16) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_ImageInfo_fieldAccessorTable.d(ImageInfo.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setHeight(int i) {
                this.height_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setLocalPath(String str) {
                str.getClass();
                this.localPath_ = str;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setLocalPathBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.localPath_ = hVar;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setSize(long j) {
                this.size_ = j;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setUrl(String str) {
                str.getClass();
                this.url_ = str;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setUrlBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.url_ = hVar;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setWidth(int i) {
                this.width_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.url_ = "";
                this.localPath_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٧١addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public ImageInfo m٧٧٣build() {
                ImageInfo imageInfo = m٧٧٥buildPartial();
                if (imageInfo.isInitialized()) {
                    return imageInfo;
                }
                throw a.a.newUninitializedMessageException(imageInfo);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public ImageInfo m٧٧٥buildPartial() {
                ImageInfo imageInfo = new ImageInfo(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(imageInfo);
                }
                onBuilt();
                return imageInfo;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٨١clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
            public ImageInfo mo٨٠٨getDefaultInstanceForType() {
                return ImageInfo.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٠٢setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٠٤setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٠٦setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٨٤clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٠٠mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٧٩clear() {
                super.clear();
                this.bitField0_ = 0;
                this.width_ = 0;
                this.height_ = 0;
                this.size_ = 0L;
                this.url_ = "";
                this.localPath_ = "";
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.url_ = "";
                this.localPath_ = "";
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٩٠clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٩٤mergeFrom(b1 b1Var) {
                if (b1Var instanceof ImageInfo) {
                    return mergeFrom((ImageInfo) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder mergeFrom(ImageInfo imageInfo) {
                if (imageInfo == ImageInfo.getDefaultInstance()) {
                    return this;
                }
                if (imageInfo.getWidth() != 0) {
                    setWidth(imageInfo.getWidth());
                }
                if (imageInfo.getHeight() != 0) {
                    setHeight(imageInfo.getHeight());
                }
                if (imageInfo.getSize() != 0) {
                    setSize(imageInfo.getSize());
                }
                if (!imageInfo.getUrl().isEmpty()) {
                    this.url_ = imageInfo.url_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                if (imageInfo.hasLocalPath()) {
                    this.localPath_ = imageInfo.localPath_;
                    this.bitField0_ |= 16;
                    onChanged();
                }
                m٨٠٠mergeUnknownFields(imageInfo.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٧٩٦mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.width_ = iVar.y();
                                    this.bitField0_ |= 1;
                                } else if (K == 16) {
                                    this.height_ = iVar.y();
                                    this.bitField0_ |= 2;
                                } else if (K == 24) {
                                    this.size_ = iVar.M();
                                    this.bitField0_ |= 4;
                                } else if (K == 42) {
                                    this.url_ = iVar.J();
                                    this.bitField0_ |= 8;
                                } else if (K != 50) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.localPath_ = iVar.J();
                                    this.bitField0_ |= 16;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private ImageInfo(h0.b bVar) {
            super(bVar);
            this.width_ = 0;
            this.height_ = 0;
            this.size_ = 0L;
            this.url_ = "";
            this.localPath_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(ImageInfo imageInfo) {
            return DEFAULT_INSTANCE.m٧٦٨toBuilder().mergeFrom(imageInfo);
        }

        public static ImageInfo parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (ImageInfo) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static ImageInfo parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static ImageInfo parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (ImageInfo) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.ImageInfoOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public ImageInfo mo٨٠٨getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٧٦٨toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ImageInfo parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (ImageInfo) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٧٦٥newBuilderForType() {
            return newBuilder();
        }

        public static ImageInfo parseFrom(byte[] bArr) throws k0 {
            return (ImageInfo) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static ImageInfo parseFrom(byte[] bArr, v vVar) throws k0 {
            return (ImageInfo) PARSER.parseFrom(bArr, vVar);
        }

        public static ImageInfo parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        private ImageInfo() {
            this.width_ = 0;
            this.height_ = 0;
            this.size_ = 0L;
            this.url_ = "";
            this.localPath_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.localPath_ = "";
        }

        public static ImageInfo parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static ImageInfo parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static ImageInfo parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface ImageInfoOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٨٠٨getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٨٠٨getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        int getHeight();

        /* synthetic */ String getInitializationErrorString();

        String getLocalPath();

        com.google.protobuf.h getLocalPathBytes();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        long getSize();

        /* synthetic */ k2 getUnknownFields();

        String getUrl();

        com.google.protobuf.h getUrlBytes();

        int getWidth();

        /* synthetic */ boolean hasField(n.g gVar);

        boolean hasLocalPath();

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class MsgBody extends h0 implements MsgBodyOrBuilder {
        public static final int CUSTOM_CONTENT_FIELD_NUMBER = 2;
        public static final int IMAGE_CONTENT_FIELD_NUMBER = 5;
        public static final int MSG_TYPE_FIELD_NUMBER = 1;
        public static final int TEXT_CONTENT_FIELD_NUMBER = 3;
        public static final int VIDEO_CONTENT_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private CustomElemContent customContent_;
        private ImageElemContent imageContent_;
        private byte memoizedIsInitialized;
        private volatile Object msgType_;
        private TextElemContent textContent_;
        private VideoElemContent videoContent_;
        private static final MsgBody DEFAULT_INSTANCE = new MsgBody();
        private static final r1 PARSER = new i();

        public static MsgBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_MsgBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٨١٤toBuilder();
        }

        public static MsgBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MsgBody parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (MsgBody) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MsgBody)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            MsgBody msgBody = (MsgBody) obj;
            if (!getMsgType().equals(msgBody.getMsgType()) || hasCustomContent() != msgBody.hasCustomContent()) {
                return false;
            }
            if ((hasCustomContent() && !getCustomContent().equals(msgBody.getCustomContent())) || hasTextContent() != msgBody.hasTextContent()) {
                return false;
            }
            if ((hasTextContent() && !getTextContent().equals(msgBody.getTextContent())) || hasVideoContent() != msgBody.hasVideoContent()) {
                return false;
            }
            if ((hasVideoContent() && !getVideoContent().equals(msgBody.getVideoContent())) || hasImageContent() != msgBody.hasImageContent()) {
                return false;
            }
            if ((!hasImageContent() || getImageContent().equals(msgBody.getImageContent())) && getUnknownFields().equals(msgBody.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public CustomElemContent getCustomContent() {
            CustomElemContent customElemContent = this.customContent_;
            if (customElemContent == null) {
                return CustomElemContent.getDefaultInstance();
            }
            return customElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public CustomElemContentOrBuilder getCustomContentOrBuilder() {
            CustomElemContent customElemContent = this.customContent_;
            if (customElemContent == null) {
                return CustomElemContent.getDefaultInstance();
            }
            return customElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public ImageElemContent getImageContent() {
            ImageElemContent imageElemContent = this.imageContent_;
            if (imageElemContent == null) {
                return ImageElemContent.getDefaultInstance();
            }
            return imageElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public ImageElemContentOrBuilder getImageContentOrBuilder() {
            ImageElemContent imageElemContent = this.imageContent_;
            if (imageElemContent == null) {
                return ImageElemContent.getDefaultInstance();
            }
            return imageElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public String getMsgType() {
            Object obj = this.msgType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.msgType_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public com.google.protobuf.h getMsgTypeBytes() {
            Object obj = this.msgType_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.msgType_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.msgType_)) {
                i = h0.computeStringSize(1, this.msgType_);
            } else {
                i = 0;
            }
            if (this.customContent_ != null) {
                i += com.google.protobuf.k.G(2, getCustomContent());
            }
            if (this.textContent_ != null) {
                i += com.google.protobuf.k.G(3, getTextContent());
            }
            if (this.videoContent_ != null) {
                i += com.google.protobuf.k.G(4, getVideoContent());
            }
            if (this.imageContent_ != null) {
                i += com.google.protobuf.k.G(5, getImageContent());
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public TextElemContent getTextContent() {
            TextElemContent textElemContent = this.textContent_;
            if (textElemContent == null) {
                return TextElemContent.getDefaultInstance();
            }
            return textElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public TextElemContentOrBuilder getTextContentOrBuilder() {
            TextElemContent textElemContent = this.textContent_;
            if (textElemContent == null) {
                return TextElemContent.getDefaultInstance();
            }
            return textElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public VideoElemContent getVideoContent() {
            VideoElemContent videoElemContent = this.videoContent_;
            if (videoElemContent == null) {
                return VideoElemContent.getDefaultInstance();
            }
            return videoElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public VideoElemContentOrBuilder getVideoContentOrBuilder() {
            VideoElemContent videoElemContent = this.videoContent_;
            if (videoElemContent == null) {
                return VideoElemContent.getDefaultInstance();
            }
            return videoElemContent;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public boolean hasCustomContent() {
            if (this.customContent_ != null) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public boolean hasImageContent() {
            if (this.imageContent_ != null) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public boolean hasTextContent() {
            if (this.textContent_ != null) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public boolean hasVideoContent() {
            if (this.videoContent_ != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getMsgType().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
            if (hasCustomContent()) {
                hashCode = getCustomContent().hashCode() + fd.g.a(hashCode, 37, 2, 53);
            }
            if (hasTextContent()) {
                hashCode = getTextContent().hashCode() + fd.g.a(hashCode, 37, 3, 53);
            }
            if (hasVideoContent()) {
                hashCode = getVideoContent().hashCode() + fd.g.a(hashCode, 37, 4, 53);
            }
            if (hasImageContent()) {
                hashCode = getImageContent().hashCode() + fd.g.a(hashCode, 37, 5, 53);
            }
            int hashCode2 = getUnknownFields().hashCode() + (hashCode * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_MsgBody_fieldAccessorTable.d(MsgBody.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new MsgBody();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.msgType_)) {
                h0.writeString(kVar, 1, this.msgType_);
            }
            if (this.customContent_ != null) {
                kVar.H0(2, getCustomContent());
            }
            if (this.textContent_ != null) {
                kVar.H0(3, getTextContent());
            }
            if (this.videoContent_ != null) {
                kVar.H0(4, getVideoContent());
            }
            if (this.imageContent_ != null) {
                kVar.H0(5, getImageContent());
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements MsgBodyOrBuilder {
            private int bitField0_;
            private b2 customContentBuilder_;
            private CustomElemContent customContent_;
            private b2 imageContentBuilder_;
            private ImageElemContent imageContent_;
            private Object msgType_;
            private b2 textContentBuilder_;
            private TextElemContent textContent_;
            private b2 videoContentBuilder_;
            private VideoElemContent videoContent_;

            private void buildPartial0(MsgBody msgBody) {
                ImageElemContent b;
                VideoElemContent b2;
                TextElemContent b3;
                CustomElemContent b4;
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    msgBody.msgType_ = this.msgType_;
                }
                if ((i & 2) != 0) {
                    b2 b2Var = this.customContentBuilder_;
                    if (b2Var == null) {
                        b4 = this.customContent_;
                    } else {
                        b4 = b2Var.b();
                    }
                    msgBody.customContent_ = b4;
                }
                if ((i & 4) != 0) {
                    b2 b2Var2 = this.textContentBuilder_;
                    if (b2Var2 == null) {
                        b3 = this.textContent_;
                    } else {
                        b3 = b2Var2.b();
                    }
                    msgBody.textContent_ = b3;
                }
                if ((i & 8) != 0) {
                    b2 b2Var3 = this.videoContentBuilder_;
                    if (b2Var3 == null) {
                        b2 = this.videoContent_;
                    } else {
                        b2 = b2Var3.b();
                    }
                    msgBody.videoContent_ = b2;
                }
                if ((i & 16) != 0) {
                    b2 b2Var4 = this.imageContentBuilder_;
                    if (b2Var4 == null) {
                        b = this.imageContent_;
                    } else {
                        b = b2Var4.b();
                    }
                    msgBody.imageContent_ = b;
                }
            }

            private b2 getCustomContentFieldBuilder() {
                if (this.customContentBuilder_ == null) {
                    this.customContentBuilder_ = new b2(getCustomContent(), getParentForChildren(), isClean());
                    this.customContent_ = null;
                }
                return this.customContentBuilder_;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_MsgBody_descriptor;
            }

            private b2 getImageContentFieldBuilder() {
                if (this.imageContentBuilder_ == null) {
                    this.imageContentBuilder_ = new b2(getImageContent(), getParentForChildren(), isClean());
                    this.imageContent_ = null;
                }
                return this.imageContentBuilder_;
            }

            private b2 getTextContentFieldBuilder() {
                if (this.textContentBuilder_ == null) {
                    this.textContentBuilder_ = new b2(getTextContent(), getParentForChildren(), isClean());
                    this.textContent_ = null;
                }
                return this.textContentBuilder_;
            }

            private b2 getVideoContentFieldBuilder() {
                if (this.videoContentBuilder_ == null) {
                    this.videoContentBuilder_ = new b2(getVideoContent(), getParentForChildren(), isClean());
                    this.videoContent_ = null;
                }
                return this.videoContentBuilder_;
            }

            public Builder clearCustomContent() {
                this.bitField0_ &= -3;
                this.customContent_ = null;
                b2 b2Var = this.customContentBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.customContentBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearImageContent() {
                this.bitField0_ &= -17;
                this.imageContent_ = null;
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.imageContentBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = MsgBody.getDefaultInstance().getMsgType();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearTextContent() {
                this.bitField0_ &= -5;
                this.textContent_ = null;
                b2 b2Var = this.textContentBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.textContentBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearVideoContent() {
                this.bitField0_ &= -9;
                this.videoContent_ = null;
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.videoContentBuilder_ = null;
                }
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public CustomElemContent getCustomContent() {
                b2 b2Var = this.customContentBuilder_;
                if (b2Var == null) {
                    CustomElemContent customElemContent = this.customContent_;
                    if (customElemContent == null) {
                        return CustomElemContent.getDefaultInstance();
                    }
                    return customElemContent;
                }
                return b2Var.e();
            }

            public CustomElemContent.Builder getCustomContentBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return getCustomContentFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public CustomElemContentOrBuilder getCustomContentOrBuilder() {
                b2 b2Var = this.customContentBuilder_;
                if (b2Var != null) {
                    return (CustomElemContentOrBuilder) b2Var.f();
                }
                CustomElemContent customElemContent = this.customContent_;
                if (customElemContent == null) {
                    return CustomElemContent.getDefaultInstance();
                }
                return customElemContent;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_MsgBody_descriptor;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public ImageElemContent getImageContent() {
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var == null) {
                    ImageElemContent imageElemContent = this.imageContent_;
                    if (imageElemContent == null) {
                        return ImageElemContent.getDefaultInstance();
                    }
                    return imageElemContent;
                }
                return b2Var.e();
            }

            public ImageElemContent.Builder getImageContentBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return getImageContentFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public ImageElemContentOrBuilder getImageContentOrBuilder() {
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var != null) {
                    return (ImageElemContentOrBuilder) b2Var.f();
                }
                ImageElemContent imageElemContent = this.imageContent_;
                if (imageElemContent == null) {
                    return ImageElemContent.getDefaultInstance();
                }
                return imageElemContent;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public String getMsgType() {
                Object obj = this.msgType_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.msgType_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public com.google.protobuf.h getMsgTypeBytes() {
                Object obj = this.msgType_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.msgType_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public TextElemContent getTextContent() {
                b2 b2Var = this.textContentBuilder_;
                if (b2Var == null) {
                    TextElemContent textElemContent = this.textContent_;
                    if (textElemContent == null) {
                        return TextElemContent.getDefaultInstance();
                    }
                    return textElemContent;
                }
                return b2Var.e();
            }

            public TextElemContent.Builder getTextContentBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return getTextContentFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public TextElemContentOrBuilder getTextContentOrBuilder() {
                b2 b2Var = this.textContentBuilder_;
                if (b2Var != null) {
                    return (TextElemContentOrBuilder) b2Var.f();
                }
                TextElemContent textElemContent = this.textContent_;
                if (textElemContent == null) {
                    return TextElemContent.getDefaultInstance();
                }
                return textElemContent;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public VideoElemContent getVideoContent() {
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var == null) {
                    VideoElemContent videoElemContent = this.videoContent_;
                    if (videoElemContent == null) {
                        return VideoElemContent.getDefaultInstance();
                    }
                    return videoElemContent;
                }
                return b2Var.e();
            }

            public VideoElemContent.Builder getVideoContentBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return getVideoContentFieldBuilder().d();
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public VideoElemContentOrBuilder getVideoContentOrBuilder() {
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var != null) {
                    return (VideoElemContentOrBuilder) b2Var.f();
                }
                VideoElemContent videoElemContent = this.videoContent_;
                if (videoElemContent == null) {
                    return VideoElemContent.getDefaultInstance();
                }
                return videoElemContent;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public boolean hasCustomContent() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public boolean hasImageContent() {
                if ((this.bitField0_ & 16) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public boolean hasTextContent() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public boolean hasVideoContent() {
                if ((this.bitField0_ & 8) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_MsgBody_fieldAccessorTable.d(MsgBody.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCustomContent(CustomElemContent customElemContent) {
                CustomElemContent customElemContent2;
                b2 b2Var = this.customContentBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 2) != 0 && (customElemContent2 = this.customContent_) != null && customElemContent2 != CustomElemContent.getDefaultInstance()) {
                        getCustomContentBuilder().mergeFrom(customElemContent);
                    } else {
                        this.customContent_ = customElemContent;
                    }
                } else {
                    b2Var.g(customElemContent);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder mergeImageContent(ImageElemContent imageElemContent) {
                ImageElemContent imageElemContent2;
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 16) != 0 && (imageElemContent2 = this.imageContent_) != null && imageElemContent2 != ImageElemContent.getDefaultInstance()) {
                        getImageContentBuilder().mergeFrom(imageElemContent);
                    } else {
                        this.imageContent_ = imageElemContent;
                    }
                } else {
                    b2Var.g(imageElemContent);
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder mergeTextContent(TextElemContent textElemContent) {
                TextElemContent textElemContent2;
                b2 b2Var = this.textContentBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 4) != 0 && (textElemContent2 = this.textContent_) != null && textElemContent2 != TextElemContent.getDefaultInstance()) {
                        getTextContentBuilder().mergeFrom(textElemContent);
                    } else {
                        this.textContent_ = textElemContent;
                    }
                } else {
                    b2Var.g(textElemContent);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder mergeVideoContent(VideoElemContent videoElemContent) {
                VideoElemContent videoElemContent2;
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var == null) {
                    if ((this.bitField0_ & 8) != 0 && (videoElemContent2 = this.videoContent_) != null && videoElemContent2 != VideoElemContent.getDefaultInstance()) {
                        getVideoContentBuilder().mergeFrom(videoElemContent);
                    } else {
                        this.videoContent_ = videoElemContent;
                    }
                } else {
                    b2Var.g(videoElemContent);
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setCustomContent(CustomElemContent customElemContent) {
                b2 b2Var = this.customContentBuilder_;
                if (b2Var == null) {
                    customElemContent.getClass();
                    this.customContent_ = customElemContent;
                } else {
                    b2Var.i(customElemContent);
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setImageContent(ImageElemContent imageElemContent) {
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var == null) {
                    imageElemContent.getClass();
                    this.imageContent_ = imageElemContent;
                } else {
                    b2Var.i(imageElemContent);
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setMsgType(String str) {
                str.getClass();
                this.msgType_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMsgTypeBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.msgType_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setTextContent(TextElemContent textElemContent) {
                b2 b2Var = this.textContentBuilder_;
                if (b2Var == null) {
                    textElemContent.getClass();
                    this.textContent_ = textElemContent;
                } else {
                    b2Var.i(textElemContent);
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setVideoContent(VideoElemContent videoElemContent) {
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var == null) {
                    videoElemContent.getClass();
                    this.videoContent_ = videoElemContent;
                } else {
                    b2Var.i(videoElemContent);
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            private Builder() {
                this.msgType_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨١٧addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public MsgBody m٨١٩build() {
                MsgBody msgBody = m٨٢١buildPartial();
                if (msgBody.isInitialized()) {
                    return msgBody;
                }
                throw a.a.newUninitializedMessageException(msgBody);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public MsgBody m٨٢١buildPartial() {
                MsgBody msgBody = new MsgBody(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(msgBody);
                }
                onBuilt();
                return msgBody;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٢٧clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
            public MsgBody mo٨٥٤getDefaultInstanceForType() {
                return MsgBody.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٤٨setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٥٠setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٥٢setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٣٠clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٤٦mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.msgType_ = "";
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٢٥clear() {
                super.clear();
                this.bitField0_ = 0;
                this.msgType_ = "";
                this.customContent_ = null;
                b2 b2Var = this.customContentBuilder_;
                if (b2Var != null) {
                    b2Var.c();
                    this.customContentBuilder_ = null;
                }
                this.textContent_ = null;
                b2 b2Var2 = this.textContentBuilder_;
                if (b2Var2 != null) {
                    b2Var2.c();
                    this.textContentBuilder_ = null;
                }
                this.videoContent_ = null;
                b2 b2Var3 = this.videoContentBuilder_;
                if (b2Var3 != null) {
                    b2Var3.c();
                    this.videoContentBuilder_ = null;
                }
                this.imageContent_ = null;
                b2 b2Var4 = this.imageContentBuilder_;
                if (b2Var4 != null) {
                    b2Var4.c();
                    this.imageContentBuilder_ = null;
                }
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٣٦clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٤٠mergeFrom(b1 b1Var) {
                if (b1Var instanceof MsgBody) {
                    return mergeFrom((MsgBody) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setCustomContent(CustomElemContent.Builder builder) {
                b2 b2Var = this.customContentBuilder_;
                if (b2Var == null) {
                    this.customContent_ = builder.m٤٩٧build();
                } else {
                    b2Var.i(builder.m٤٩٧build());
                }
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setImageContent(ImageElemContent.Builder builder) {
                b2 b2Var = this.imageContentBuilder_;
                if (b2Var == null) {
                    this.imageContent_ = builder.m٧٢٧build();
                } else {
                    b2Var.i(builder.m٧٢٧build());
                }
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setTextContent(TextElemContent.Builder builder) {
                b2 b2Var = this.textContentBuilder_;
                if (b2Var == null) {
                    this.textContent_ = builder.m٨٦٥build();
                } else {
                    b2Var.i(builder.m٨٦٥build());
                }
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setVideoContent(VideoElemContent.Builder builder) {
                b2 b2Var = this.videoContentBuilder_;
                if (b2Var == null) {
                    this.videoContent_ = builder.m٩٥٧build();
                } else {
                    b2Var.i(builder.m٩٥٧build());
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder mergeFrom(MsgBody msgBody) {
                if (msgBody == MsgBody.getDefaultInstance()) {
                    return this;
                }
                if (!msgBody.getMsgType().isEmpty()) {
                    this.msgType_ = msgBody.msgType_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (msgBody.hasCustomContent()) {
                    mergeCustomContent(msgBody.getCustomContent());
                }
                if (msgBody.hasTextContent()) {
                    mergeTextContent(msgBody.getTextContent());
                }
                if (msgBody.hasVideoContent()) {
                    mergeVideoContent(msgBody.getVideoContent());
                }
                if (msgBody.hasImageContent()) {
                    mergeImageContent(msgBody.getImageContent());
                }
                m٨٤٦mergeUnknownFields(msgBody.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٤٢mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    this.msgType_ = iVar.J();
                                    this.bitField0_ |= 1;
                                } else if (K == 18) {
                                    iVar.B(getCustomContentFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 2;
                                } else if (K == 26) {
                                    iVar.B(getTextContentFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 4;
                                } else if (K == 34) {
                                    iVar.B(getVideoContentFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 8;
                                } else if (K != 42) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    iVar.B(getImageContentFieldBuilder().d(), vVar);
                                    this.bitField0_ |= 16;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private MsgBody(h0.b bVar) {
            super(bVar);
            this.msgType_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(MsgBody msgBody) {
            return DEFAULT_INSTANCE.m٨١٤toBuilder().mergeFrom(msgBody);
        }

        public static MsgBody parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (MsgBody) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static MsgBody parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static MsgBody parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (MsgBody) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.MsgBodyOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public MsgBody mo٨٥٤getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٨١٤toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static MsgBody parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (MsgBody) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٨١١newBuilderForType() {
            return newBuilder();
        }

        private MsgBody() {
            this.msgType_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = "";
        }

        public static MsgBody parseFrom(byte[] bArr) throws k0 {
            return (MsgBody) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static MsgBody parseFrom(byte[] bArr, v vVar) throws k0 {
            return (MsgBody) PARSER.parseFrom(bArr, vVar);
        }

        public static MsgBody parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static MsgBody parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static MsgBody parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static MsgBody parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface MsgBodyOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        CustomElemContent getCustomContent();

        CustomElemContentOrBuilder getCustomContentOrBuilder();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٨٥٤getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٨٥٤getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        ImageElemContent getImageContent();

        ImageElemContentOrBuilder getImageContentOrBuilder();

        /* synthetic */ String getInitializationErrorString();

        String getMsgType();

        com.google.protobuf.h getMsgTypeBytes();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        TextElemContent getTextContent();

        TextElemContentOrBuilder getTextContentOrBuilder();

        /* synthetic */ k2 getUnknownFields();

        VideoElemContent getVideoContent();

        VideoElemContentOrBuilder getVideoContentOrBuilder();

        boolean hasCustomContent();

        /* synthetic */ boolean hasField(n.g gVar);

        boolean hasImageContent();

        /* synthetic */ boolean hasOneof(n.l lVar);

        boolean hasTextContent();

        boolean hasVideoContent();

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class TextElemContent extends h0 implements TextElemContentOrBuilder {
        public static final int AT_ACCOUNT_FIELD_NUMBER = 2;
        private static final TextElemContent DEFAULT_INSTANCE = new TextElemContent();
        private static final r1 PARSER = new j();
        public static final int TEXT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<TextElemContentAt> atAccount_;
        private byte memoizedIsInitialized;
        private volatile Object text_;

        public static TextElemContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_TextElemContent_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٨٦٠toBuilder();
        }

        public static TextElemContent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TextElemContent parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (TextElemContent) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TextElemContent)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            TextElemContent textElemContent = (TextElemContent) obj;
            if (getText().equals(textElemContent.getText()) && getAtAccountList().equals(textElemContent.getAtAccountList()) && getUnknownFields().equals(textElemContent.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public TextElemContentAt getAtAccount(int i) {
            return this.atAccount_.get(i);
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public int getAtAccountCount() {
            return this.atAccount_.size();
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public List<TextElemContentAt> getAtAccountList() {
            return this.atAccount_;
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public TextElemContentAtOrBuilder getAtAccountOrBuilder(int i) {
            return this.atAccount_.get(i);
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public List<? extends TextElemContentAtOrBuilder> getAtAccountOrBuilderList() {
            return this.atAccount_;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.text_)) {
                i = h0.computeStringSize(1, this.text_);
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < this.atAccount_.size(); i3++) {
                i += com.google.protobuf.k.G(2, this.atAccount_.get(i3));
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.text_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public com.google.protobuf.h getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.text_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getText().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
            if (getAtAccountCount() > 0) {
                hashCode = getAtAccountList().hashCode() + fd.g.a(hashCode, 37, 2, 53);
            }
            int hashCode2 = getUnknownFields().hashCode() + (hashCode * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_TextElemContent_fieldAccessorTable.d(TextElemContent.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new TextElemContent();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.text_)) {
                h0.writeString(kVar, 1, this.text_);
            }
            for (int i = 0; i < this.atAccount_.size(); i++) {
                kVar.H0(2, this.atAccount_.get(i));
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements TextElemContentOrBuilder {
            private x1 atAccountBuilder_;
            private List<TextElemContentAt> atAccount_;
            private int bitField0_;
            private Object text_;

            private void buildPartial0(TextElemContent textElemContent) {
                if ((this.bitField0_ & 1) != 0) {
                    textElemContent.text_ = this.text_;
                }
            }

            private void buildPartialRepeatedFields(TextElemContent textElemContent) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var != null) {
                    textElemContent.atAccount_ = x1Var.g();
                    return;
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.atAccount_ = Collections.unmodifiableList(this.atAccount_);
                    this.bitField0_ &= -3;
                }
                textElemContent.atAccount_ = this.atAccount_;
            }

            private void ensureAtAccountIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.atAccount_ = new ArrayList(this.atAccount_);
                    this.bitField0_ |= 2;
                }
            }

            private x1 getAtAccountFieldBuilder() {
                boolean z;
                if (this.atAccountBuilder_ == null) {
                    List<TextElemContentAt> list = this.atAccount_;
                    if ((this.bitField0_ & 2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.atAccountBuilder_ = new x1(list, z, getParentForChildren(), isClean());
                    this.atAccount_ = null;
                }
                return this.atAccountBuilder_;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_TextElemContent_descriptor;
            }

            public Builder addAllAtAccount(Iterable<? extends TextElemContentAt> iterable) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    ensureAtAccountIsMutable();
                    b.a.addAll(iterable, this.atAccount_);
                    onChanged();
                } else {
                    x1Var.b(iterable);
                }
                return this;
            }

            public Builder addAtAccount(TextElemContentAt textElemContentAt) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    textElemContentAt.getClass();
                    ensureAtAccountIsMutable();
                    this.atAccount_.add(textElemContentAt);
                    onChanged();
                } else {
                    x1Var.f(textElemContentAt);
                }
                return this;
            }

            public TextElemContentAt.Builder addAtAccountBuilder() {
                return getAtAccountFieldBuilder().d(TextElemContentAt.getDefaultInstance());
            }

            public Builder clearAtAccount() {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    this.atAccount_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    x1Var.h();
                }
                return this;
            }

            public Builder clearText() {
                this.text_ = TextElemContent.getDefaultInstance().getText();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public TextElemContentAt getAtAccount(int i) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    return this.atAccount_.get(i);
                }
                return x1Var.o(i);
            }

            public TextElemContentAt.Builder getAtAccountBuilder(int i) {
                return getAtAccountFieldBuilder().l(i);
            }

            public List<TextElemContentAt.Builder> getAtAccountBuilderList() {
                return getAtAccountFieldBuilder().m();
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public int getAtAccountCount() {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    return this.atAccount_.size();
                }
                return x1Var.n();
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public List<TextElemContentAt> getAtAccountList() {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    return Collections.unmodifiableList(this.atAccount_);
                }
                return x1Var.q();
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public TextElemContentAtOrBuilder getAtAccountOrBuilder(int i) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    return this.atAccount_.get(i);
                }
                return (TextElemContentAtOrBuilder) x1Var.r(i);
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public List<? extends TextElemContentAtOrBuilder> getAtAccountOrBuilderList() {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var != null) {
                    return x1Var.s();
                }
                return Collections.unmodifiableList(this.atAccount_);
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_TextElemContent_descriptor;
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public String getText() {
                Object obj = this.text_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.text_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public com.google.protobuf.h getTextBytes() {
                Object obj = this.text_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.text_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_TextElemContent_fieldAccessorTable.d(TextElemContent.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder removeAtAccount(int i) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    ensureAtAccountIsMutable();
                    this.atAccount_.remove(i);
                    onChanged();
                } else {
                    x1Var.w(i);
                }
                return this;
            }

            public Builder setAtAccount(int i, TextElemContentAt textElemContentAt) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    textElemContentAt.getClass();
                    ensureAtAccountIsMutable();
                    this.atAccount_.set(i, textElemContentAt);
                    onChanged();
                } else {
                    x1Var.x(i, textElemContentAt);
                }
                return this;
            }

            public Builder setText(String str) {
                str.getClass();
                this.text_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setTextBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.text_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            private Builder() {
                this.text_ = "";
                this.atAccount_ = Collections.emptyList();
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٦٣addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public TextElemContent m٨٦٥build() {
                TextElemContent textElemContent = m٨٦٧buildPartial();
                if (textElemContent.isInitialized()) {
                    return textElemContent;
                }
                throw a.a.newUninitializedMessageException(textElemContent);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public TextElemContent m٨٦٧buildPartial() {
                TextElemContent textElemContent = new TextElemContent(this);
                buildPartialRepeatedFields(textElemContent);
                if (this.bitField0_ != 0) {
                    buildPartial0(textElemContent);
                }
                onBuilt();
                return textElemContent;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٧٣clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
            public TextElemContent mo٩٤٦getDefaultInstanceForType() {
                return TextElemContent.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٩٤setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٩٦setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٩٨setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            public TextElemContentAt.Builder addAtAccountBuilder(int i) {
                return getAtAccountFieldBuilder().c(i, TextElemContentAt.getDefaultInstance());
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٧٦clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٨٩٢mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٧١clear() {
                super.clear();
                this.bitField0_ = 0;
                this.text_ = "";
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    this.atAccount_ = Collections.emptyList();
                } else {
                    this.atAccount_ = null;
                    x1Var.h();
                }
                this.bitField0_ &= -3;
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.text_ = "";
                this.atAccount_ = Collections.emptyList();
            }

            public Builder addAtAccount(int i, TextElemContentAt textElemContentAt) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    textElemContentAt.getClass();
                    ensureAtAccountIsMutable();
                    this.atAccount_.add(i, textElemContentAt);
                    onChanged();
                } else {
                    x1Var.e(i, textElemContentAt);
                }
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٨٢clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٨٦mergeFrom(b1 b1Var) {
                if (b1Var instanceof TextElemContent) {
                    return mergeFrom((TextElemContent) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder setAtAccount(int i, TextElemContentAt.Builder builder) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    ensureAtAccountIsMutable();
                    this.atAccount_.set(i, builder.m٩١٠build());
                    onChanged();
                } else {
                    x1Var.x(i, builder.m٩١٠build());
                }
                return this;
            }

            public Builder mergeFrom(TextElemContent textElemContent) {
                if (textElemContent == TextElemContent.getDefaultInstance()) {
                    return this;
                }
                if (!textElemContent.getText().isEmpty()) {
                    this.text_ = textElemContent.text_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (this.atAccountBuilder_ == null) {
                    if (!textElemContent.atAccount_.isEmpty()) {
                        if (this.atAccount_.isEmpty()) {
                            this.atAccount_ = textElemContent.atAccount_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAtAccountIsMutable();
                            this.atAccount_.addAll(textElemContent.atAccount_);
                        }
                        onChanged();
                    }
                } else if (!textElemContent.atAccount_.isEmpty()) {
                    if (!this.atAccountBuilder_.u()) {
                        this.atAccountBuilder_.b(textElemContent.atAccount_);
                    } else {
                        this.atAccountBuilder_.i();
                        this.atAccountBuilder_ = null;
                        this.atAccount_ = textElemContent.atAccount_;
                        this.bitField0_ &= -3;
                        this.atAccountBuilder_ = h0.alwaysUseFieldBuilders ? getAtAccountFieldBuilder() : null;
                    }
                }
                m٨٩٢mergeUnknownFields(textElemContent.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder addAtAccount(TextElemContentAt.Builder builder) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    ensureAtAccountIsMutable();
                    this.atAccount_.add(builder.m٩١٠build());
                    onChanged();
                } else {
                    x1Var.f(builder.m٩١٠build());
                }
                return this;
            }

            public Builder addAtAccount(int i, TextElemContentAt.Builder builder) {
                x1 x1Var = this.atAccountBuilder_;
                if (x1Var == null) {
                    ensureAtAccountIsMutable();
                    this.atAccount_.add(i, builder.m٩١٠build());
                    onChanged();
                } else {
                    x1Var.e(i, builder.m٩١٠build());
                }
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٨٨٨mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    this.text_ = iVar.J();
                                    this.bitField0_ |= 1;
                                } else if (K != 18) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    TextElemContentAt A = iVar.A(TextElemContentAt.parser(), vVar);
                                    x1 x1Var = this.atAccountBuilder_;
                                    if (x1Var == null) {
                                        ensureAtAccountIsMutable();
                                        this.atAccount_.add(A);
                                    } else {
                                        x1Var.f(A);
                                    }
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private TextElemContent(h0.b bVar) {
            super(bVar);
            this.text_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(TextElemContent textElemContent) {
            return DEFAULT_INSTANCE.m٨٦٠toBuilder().mergeFrom(textElemContent);
        }

        public static TextElemContent parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (TextElemContent) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static TextElemContent parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static TextElemContent parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (TextElemContent) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.TextElemContentOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public TextElemContent mo٩٤٦getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٨٦٠toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TextElemContent parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (TextElemContent) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٨٥٧newBuilderForType() {
            return newBuilder();
        }

        private TextElemContent() {
            this.text_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.text_ = "";
            this.atAccount_ = Collections.emptyList();
        }

        public static TextElemContent parseFrom(byte[] bArr) throws k0 {
            return (TextElemContent) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static TextElemContent parseFrom(byte[] bArr, v vVar) throws k0 {
            return (TextElemContent) PARSER.parseFrom(bArr, vVar);
        }

        public static TextElemContent parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static TextElemContent parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static TextElemContent parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static TextElemContent parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class TextElemContentAt extends h0 implements TextElemContentAtOrBuilder {
        public static final int AT_ACCOUNT_FIELD_NUMBER = 1;
        public static final int AT_NICK_FIELD_NUMBER = 2;
        private static final TextElemContentAt DEFAULT_INSTANCE = new TextElemContentAt();
        private static final r1 PARSER = new k();
        private static final long serialVersionUID = 0;
        private volatile Object atAccount_;
        private volatile Object atNick_;
        private byte memoizedIsInitialized;

        public static TextElemContentAt getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_TextElemContentAt_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٩٠٥toBuilder();
        }

        public static TextElemContentAt parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TextElemContentAt parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TextElemContentAt)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            TextElemContentAt textElemContentAt = (TextElemContentAt) obj;
            if (getAtAccount().equals(textElemContentAt.getAtAccount()) && getAtNick().equals(textElemContentAt.getAtNick()) && getUnknownFields().equals(textElemContentAt.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public String getAtAccount() {
            Object obj = this.atAccount_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.atAccount_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public com.google.protobuf.h getAtAccountBytes() {
            Object obj = this.atAccount_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.atAccount_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public String getAtNick() {
            Object obj = this.atNick_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.atNick_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public com.google.protobuf.h getAtNickBytes() {
            Object obj = this.atNick_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.atNick_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            if (!h0.isStringEmpty(this.atAccount_)) {
                i = h0.computeStringSize(1, this.atAccount_);
            } else {
                i = 0;
            }
            if (!h0.isStringEmpty(this.atNick_)) {
                i += h0.computeStringSize(2, this.atNick_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getUnknownFields().hashCode() + ((getAtNick().hashCode() + ((((getAtAccount().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode;
            return hashCode;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_TextElemContentAt_fieldAccessorTable.d(TextElemContentAt.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new TextElemContentAt();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            if (!h0.isStringEmpty(this.atAccount_)) {
                h0.writeString(kVar, 1, this.atAccount_);
            }
            if (!h0.isStringEmpty(this.atNick_)) {
                h0.writeString(kVar, 2, this.atNick_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements TextElemContentAtOrBuilder {
            private Object atAccount_;
            private Object atNick_;
            private int bitField0_;

            private void buildPartial0(TextElemContentAt textElemContentAt) {
                int i = this.bitField0_;
                if ((i & 1) != 0) {
                    textElemContentAt.atAccount_ = this.atAccount_;
                }
                if ((i & 2) != 0) {
                    textElemContentAt.atNick_ = this.atNick_;
                }
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_TextElemContentAt_descriptor;
            }

            public Builder clearAtAccount() {
                this.atAccount_ = TextElemContentAt.getDefaultInstance().getAtAccount();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearAtNick() {
                this.atNick_ = TextElemContentAt.getDefaultInstance().getAtNick();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public String getAtAccount() {
                Object obj = this.atAccount_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.atAccount_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public com.google.protobuf.h getAtAccountBytes() {
                Object obj = this.atAccount_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.atAccount_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public String getAtNick() {
                Object obj = this.atNick_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.atNick_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public com.google.protobuf.h getAtNickBytes() {
                Object obj = this.atNick_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.atNick_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_TextElemContentAt_descriptor;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_TextElemContentAt_fieldAccessorTable.d(TextElemContentAt.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setAtAccount(String str) {
                str.getClass();
                this.atAccount_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setAtAccountBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.atAccount_ = hVar;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setAtNick(String str) {
                str.getClass();
                this.atNick_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setAtNickBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.atNick_ = hVar;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private Builder() {
                this.atAccount_ = "";
                this.atNick_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٠٨addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public TextElemContentAt m٩١٠build() {
                TextElemContentAt textElemContentAt = m٩١٢buildPartial();
                if (textElemContentAt.isInitialized()) {
                    return textElemContentAt;
                }
                throw a.a.newUninitializedMessageException(textElemContentAt);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public TextElemContentAt m٩١٢buildPartial() {
                TextElemContentAt textElemContentAt = new TextElemContentAt(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(textElemContentAt);
                }
                onBuilt();
                return textElemContentAt;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩١٨clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
            public TextElemContentAt mo٩٤٥getDefaultInstanceForType() {
                return TextElemContentAt.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٣٩setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٤١setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٩٤٣setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٢١clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٩٣٧mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩١٦clear() {
                super.clear();
                this.bitField0_ = 0;
                this.atAccount_ = "";
                this.atNick_ = "";
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.atAccount_ = "";
                this.atNick_ = "";
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٢٧clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٣١mergeFrom(b1 b1Var) {
                if (b1Var instanceof TextElemContentAt) {
                    return mergeFrom((TextElemContentAt) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            public Builder mergeFrom(TextElemContentAt textElemContentAt) {
                if (textElemContentAt == TextElemContentAt.getDefaultInstance()) {
                    return this;
                }
                if (!textElemContentAt.getAtAccount().isEmpty()) {
                    this.atAccount_ = textElemContentAt.atAccount_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (!textElemContentAt.getAtNick().isEmpty()) {
                    this.atNick_ = textElemContentAt.atNick_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                m٩٣٧mergeUnknownFields(textElemContentAt.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٣٣mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    this.atAccount_ = iVar.J();
                                    this.bitField0_ |= 1;
                                } else if (K != 18) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.atNick_ = iVar.J();
                                    this.bitField0_ |= 2;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private TextElemContentAt(h0.b bVar) {
            super(bVar);
            this.atAccount_ = "";
            this.atNick_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(TextElemContentAt textElemContentAt) {
            return DEFAULT_INSTANCE.m٩٠٥toBuilder().mergeFrom(textElemContentAt);
        }

        public static TextElemContentAt parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static TextElemContentAt parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static TextElemContentAt parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.TextElemContentAtOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public TextElemContentAt mo٩٤٥getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٩٠٥toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static TextElemContentAt parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٩٠٢newBuilderForType() {
            return newBuilder();
        }

        public static TextElemContentAt parseFrom(byte[] bArr) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        private TextElemContentAt() {
            this.atAccount_ = "";
            this.atNick_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.atAccount_ = "";
            this.atNick_ = "";
        }

        public static TextElemContentAt parseFrom(byte[] bArr, v vVar) throws k0 {
            return (TextElemContentAt) PARSER.parseFrom(bArr, vVar);
        }

        public static TextElemContentAt parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static TextElemContentAt parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static TextElemContentAt parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        public static TextElemContentAt parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface TextElemContentAtOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        String getAtAccount();

        com.google.protobuf.h getAtAccountBytes();

        String getAtNick();

        com.google.protobuf.h getAtNickBytes();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٩٤٥getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٩٤٥getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface TextElemContentOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        TextElemContentAt getAtAccount(int i);

        int getAtAccountCount();

        List<TextElemContentAt> getAtAccountList();

        TextElemContentAtOrBuilder getAtAccountOrBuilder(int i);

        List<? extends TextElemContentAtOrBuilder> getAtAccountOrBuilderList();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٩٤٦getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٩٤٦getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        String getText();

        com.google.protobuf.h getTextBytes();

        /* synthetic */ k2 getUnknownFields();

        /* synthetic */ boolean hasField(n.g gVar);

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class VideoElemContent extends h0 implements VideoElemContentOrBuilder {
        public static final int LOCAL_PATH_FIELD_NUMBER = 8;
        public static final int LOCAL_THUMB_PATH_FIELD_NUMBER = 9;
        public static final int THUMB_HEIGHT_FIELD_NUMBER = 2;
        public static final int THUMB_SIZE_FIELD_NUMBER = 3;
        public static final int THUMB_URL_FIELD_NUMBER = 4;
        public static final int THUMB_WIDTH_FIELD_NUMBER = 1;
        public static final int VIDEO_SECOND_FIELD_NUMBER = 5;
        public static final int VIDEO_SIZE_FIELD_NUMBER = 6;
        public static final int VIDEO_URL_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object localPath_;
        private volatile Object localThumbPath_;
        private byte memoizedIsInitialized;
        private int thumbHeight_;
        private long thumbSize_;
        private volatile Object thumbUrl_;
        private int thumbWidth_;
        private int videoSecond_;
        private long videoSize_;
        private volatile Object videoUrl_;
        private static final VideoElemContent DEFAULT_INSTANCE = new VideoElemContent();
        private static final r1 PARSER = new l();

        public static VideoElemContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final n.b getDescriptor() {
            return RoomMessage.internal_static_roomMessage_VideoElemContent_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m٩٥٢toBuilder();
        }

        public static VideoElemContent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static VideoElemContent parseFrom(ByteBuffer byteBuffer) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(byteBuffer);
        }

        public static r1 parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VideoElemContent)) {
                return super/*com.google.protobuf.a*/.equals(obj);
            }
            VideoElemContent videoElemContent = (VideoElemContent) obj;
            if (getThumbWidth() != videoElemContent.getThumbWidth() || getThumbHeight() != videoElemContent.getThumbHeight() || getThumbSize() != videoElemContent.getThumbSize() || !getThumbUrl().equals(videoElemContent.getThumbUrl()) || getVideoSecond() != videoElemContent.getVideoSecond() || getVideoSize() != videoElemContent.getVideoSize() || !getVideoUrl().equals(videoElemContent.getVideoUrl()) || hasLocalPath() != videoElemContent.hasLocalPath()) {
                return false;
            }
            if ((hasLocalPath() && !getLocalPath().equals(videoElemContent.getLocalPath())) || hasLocalThumbPath() != videoElemContent.hasLocalThumbPath()) {
                return false;
            }
            if ((!hasLocalThumbPath() || getLocalThumbPath().equals(videoElemContent.getLocalThumbPath())) && getUnknownFields().equals(videoElemContent.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public String getLocalPath() {
            Object obj = this.localPath_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.localPath_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public com.google.protobuf.h getLocalPathBytes() {
            Object obj = this.localPath_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.localPath_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public String getLocalThumbPath() {
            Object obj = this.localThumbPath_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.localThumbPath_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public com.google.protobuf.h getLocalThumbPathBytes() {
            Object obj = this.localThumbPath_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.localThumbPath_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        public r1 getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2 = ((com.google.protobuf.a) this).memoizedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.thumbWidth_;
            if (i3 != 0) {
                i = com.google.protobuf.k.x(1, i3);
            } else {
                i = 0;
            }
            int i4 = this.thumbHeight_;
            if (i4 != 0) {
                i += com.google.protobuf.k.x(2, i4);
            }
            long j = this.thumbSize_;
            if (j != 0) {
                i += com.google.protobuf.k.Z(3, j);
            }
            if (!h0.isStringEmpty(this.thumbUrl_)) {
                i += h0.computeStringSize(4, this.thumbUrl_);
            }
            int i5 = this.videoSecond_;
            if (i5 != 0) {
                i += com.google.protobuf.k.x(5, i5);
            }
            long j2 = this.videoSize_;
            if (j2 != 0) {
                i += com.google.protobuf.k.Z(6, j2);
            }
            if (!h0.isStringEmpty(this.videoUrl_)) {
                i += h0.computeStringSize(7, this.videoUrl_);
            }
            if ((1 & this.bitField0_) != 0) {
                i += h0.computeStringSize(8, this.localPath_);
            }
            if ((this.bitField0_ & 2) != 0) {
                i += h0.computeStringSize(9, this.localThumbPath_);
            }
            int serializedSize = getUnknownFields().getSerializedSize() + i;
            ((com.google.protobuf.a) this).memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public int getThumbHeight() {
            return this.thumbHeight_;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public long getThumbSize() {
            return this.thumbSize_;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public String getThumbUrl() {
            Object obj = this.thumbUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.thumbUrl_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public com.google.protobuf.h getThumbUrlBytes() {
            Object obj = this.thumbUrl_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.thumbUrl_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public int getThumbWidth() {
            return this.thumbWidth_;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public final k2 getUnknownFields() {
            return ((h0) this).unknownFields;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public int getVideoSecond() {
            return this.videoSecond_;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public long getVideoSize() {
            return this.videoSize_;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public String getVideoUrl() {
            Object obj = this.videoUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String C = ((com.google.protobuf.h) obj).C();
            this.videoUrl_ = C;
            return C;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public com.google.protobuf.h getVideoUrlBytes() {
            Object obj = this.videoUrl_;
            if (obj instanceof String) {
                com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                this.videoUrl_ = o;
                return o;
            }
            return (com.google.protobuf.h) obj;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public boolean hasLocalPath() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public boolean hasLocalThumbPath() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((com.google.protobuf.b) this).memoizedHashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = getVideoUrl().hashCode() + ((((j0.h(getVideoSize()) + ((((getVideoSecond() + ((((getThumbUrl().hashCode() + ((((j0.h(getThumbSize()) + ((((getThumbHeight() + ((((getThumbWidth() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53)) * 37) + 7) * 53);
            if (hasLocalPath()) {
                hashCode = getLocalPath().hashCode() + fd.g.a(hashCode, 37, 8, 53);
            }
            if (hasLocalThumbPath()) {
                hashCode = getLocalThumbPath().hashCode() + fd.g.a(hashCode, 37, 9, 53);
            }
            int hashCode2 = getUnknownFields().hashCode() + (hashCode * 29);
            ((com.google.protobuf.b) this).memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public h0.f internalGetFieldAccessorTable() {
            return RoomMessage.internal_static_roomMessage_VideoElemContent_fieldAccessorTable.d(VideoElemContent.class, Builder.class);
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public Object newInstance(h0.g gVar) {
            return new VideoElemContent();
        }

        public void writeTo(com.google.protobuf.k kVar) throws IOException {
            int i = this.thumbWidth_;
            if (i != 0) {
                kVar.D0(1, i);
            }
            int i2 = this.thumbHeight_;
            if (i2 != 0) {
                kVar.D0(2, i2);
            }
            long j = this.thumbSize_;
            if (j != 0) {
                kVar.U0(3, j);
            }
            if (!h0.isStringEmpty(this.thumbUrl_)) {
                h0.writeString(kVar, 4, this.thumbUrl_);
            }
            int i3 = this.videoSecond_;
            if (i3 != 0) {
                kVar.D0(5, i3);
            }
            long j2 = this.videoSize_;
            if (j2 != 0) {
                kVar.U0(6, j2);
            }
            if (!h0.isStringEmpty(this.videoUrl_)) {
                h0.writeString(kVar, 7, this.videoUrl_);
            }
            if ((this.bitField0_ & 1) != 0) {
                h0.writeString(kVar, 8, this.localPath_);
            }
            if ((this.bitField0_ & 2) != 0) {
                h0.writeString(kVar, 9, this.localThumbPath_);
            }
            getUnknownFields().writeTo(kVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
        public static final class Builder extends h0.b implements VideoElemContentOrBuilder {
            private int bitField0_;
            private Object localPath_;
            private Object localThumbPath_;
            private int thumbHeight_;
            private long thumbSize_;
            private Object thumbUrl_;
            private int thumbWidth_;
            private int videoSecond_;
            private long videoSize_;
            private Object videoUrl_;

            private void buildPartial0(VideoElemContent videoElemContent) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    videoElemContent.thumbWidth_ = this.thumbWidth_;
                }
                if ((i2 & 2) != 0) {
                    videoElemContent.thumbHeight_ = this.thumbHeight_;
                }
                if ((i2 & 4) != 0) {
                    videoElemContent.thumbSize_ = this.thumbSize_;
                }
                if ((i2 & 8) != 0) {
                    videoElemContent.thumbUrl_ = this.thumbUrl_;
                }
                if ((i2 & 16) != 0) {
                    videoElemContent.videoSecond_ = this.videoSecond_;
                }
                if ((i2 & 32) != 0) {
                    videoElemContent.videoSize_ = this.videoSize_;
                }
                if ((i2 & 64) != 0) {
                    videoElemContent.videoUrl_ = this.videoUrl_;
                }
                if ((i2 & 128) != 0) {
                    videoElemContent.localPath_ = this.localPath_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 256) != 0) {
                    videoElemContent.localThumbPath_ = this.localThumbPath_;
                    i |= 2;
                }
                videoElemContent.bitField0_ |= i;
            }

            public static final n.b getDescriptor() {
                return RoomMessage.internal_static_roomMessage_VideoElemContent_descriptor;
            }

            public Builder clearLocalPath() {
                this.localPath_ = VideoElemContent.getDefaultInstance().getLocalPath();
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }

            public Builder clearLocalThumbPath() {
                this.localThumbPath_ = VideoElemContent.getDefaultInstance().getLocalThumbPath();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            public Builder clearThumbHeight() {
                this.bitField0_ &= -3;
                this.thumbHeight_ = 0;
                onChanged();
                return this;
            }

            public Builder clearThumbSize() {
                this.bitField0_ &= -5;
                this.thumbSize_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearThumbUrl() {
                this.thumbUrl_ = VideoElemContent.getDefaultInstance().getThumbUrl();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder clearThumbWidth() {
                this.bitField0_ &= -2;
                this.thumbWidth_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVideoSecond() {
                this.bitField0_ &= -17;
                this.videoSecond_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVideoSize() {
                this.bitField0_ &= -33;
                this.videoSize_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearVideoUrl() {
                this.videoUrl_ = VideoElemContent.getDefaultInstance().getVideoUrl();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public n.b getDescriptorForType() {
                return RoomMessage.internal_static_roomMessage_VideoElemContent_descriptor;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public String getLocalPath() {
                Object obj = this.localPath_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.localPath_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public com.google.protobuf.h getLocalPathBytes() {
                Object obj = this.localPath_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.localPath_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public String getLocalThumbPath() {
                Object obj = this.localThumbPath_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.localThumbPath_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public com.google.protobuf.h getLocalThumbPathBytes() {
                Object obj = this.localThumbPath_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.localThumbPath_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public int getThumbHeight() {
                return this.thumbHeight_;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public long getThumbSize() {
                return this.thumbSize_;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public String getThumbUrl() {
                Object obj = this.thumbUrl_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.thumbUrl_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public com.google.protobuf.h getThumbUrlBytes() {
                Object obj = this.thumbUrl_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.thumbUrl_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public int getThumbWidth() {
                return this.thumbWidth_;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public int getVideoSecond() {
                return this.videoSecond_;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public long getVideoSize() {
                return this.videoSize_;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public String getVideoUrl() {
                Object obj = this.videoUrl_;
                if (!(obj instanceof String)) {
                    String C = ((com.google.protobuf.h) obj).C();
                    this.videoUrl_ = C;
                    return C;
                }
                return (String) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public com.google.protobuf.h getVideoUrlBytes() {
                Object obj = this.videoUrl_;
                if (obj instanceof String) {
                    com.google.protobuf.h o = com.google.protobuf.h.o((String) obj);
                    this.videoUrl_ = o;
                    return o;
                }
                return (com.google.protobuf.h) obj;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public boolean hasLocalPath() {
                if ((this.bitField0_ & 128) != 0) {
                    return true;
                }
                return false;
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public boolean hasLocalThumbPath() {
                if ((this.bitField0_ & 256) != 0) {
                    return true;
                }
                return false;
            }

            public h0.f internalGetFieldAccessorTable() {
                return RoomMessage.internal_static_roomMessage_VideoElemContent_fieldAccessorTable.d(VideoElemContent.class, Builder.class);
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setLocalPath(String str) {
                str.getClass();
                this.localPath_ = str;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setLocalPathBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.localPath_ = hVar;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setLocalThumbPath(String str) {
                str.getClass();
                this.localThumbPath_ = str;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setLocalThumbPathBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.localThumbPath_ = hVar;
                this.bitField0_ |= 256;
                onChanged();
                return this;
            }

            public Builder setThumbHeight(int i) {
                this.thumbHeight_ = i;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setThumbSize(long j) {
                this.thumbSize_ = j;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setThumbUrl(String str) {
                str.getClass();
                this.thumbUrl_ = str;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setThumbUrlBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.thumbUrl_ = hVar;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setThumbWidth(int i) {
                this.thumbWidth_ = i;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setVideoSecond(int i) {
                this.videoSecond_ = i;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setVideoSize(long j) {
                this.videoSize_ = j;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setVideoUrl(String str) {
                str.getClass();
                this.videoUrl_ = str;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setVideoUrlBytes(com.google.protobuf.h hVar) {
                hVar.getClass();
                com.google.protobuf.b.checkByteStringIsUtf8(hVar);
                this.videoUrl_ = hVar;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            private Builder() {
                this.thumbUrl_ = "";
                this.videoUrl_ = "";
                this.localPath_ = "";
                this.localThumbPath_ = "";
            }

            /* renamed from: addRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٥٥addRepeatedField(n.g gVar, Object obj) {
                return (Builder) super.addRepeatedField(gVar, obj);
            }

            /* renamed from: build, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public VideoElemContent m٩٥٧build() {
                VideoElemContent videoElemContent = m٩٥٩buildPartial();
                if (videoElemContent.isInitialized()) {
                    return videoElemContent;
                }
                throw a.a.newUninitializedMessageException(videoElemContent);
            }

            /* renamed from: buildPartial, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public VideoElemContent m٩٥٩buildPartial() {
                VideoElemContent videoElemContent = new VideoElemContent(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(videoElemContent);
                }
                onBuilt();
                return videoElemContent;
            }

            /* renamed from: clearField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٦٥clearField(n.g gVar) {
                return (Builder) super.clearField(gVar);
            }

            @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
            public VideoElemContent mo٩٩٢getDefaultInstanceForType() {
                return VideoElemContent.getDefaultInstance();
            }

            /* renamed from: setField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٨٦setField(n.g gVar, Object obj) {
                return (Builder) super.setField(gVar, obj);
            }

            /* renamed from: setRepeatedField, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٨٨setRepeatedField(n.g gVar, int i, Object obj) {
                return (Builder) super.setRepeatedField(gVar, i, obj);
            }

            /* renamed from: setUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٩٩٠setUnknownFields(k2 k2Var) {
                return (Builder) super.setUnknownFields(k2Var);
            }

            /* renamed from: clearOneof, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٦٨clearOneof(n.l lVar) {
                return (Builder) super.clearOneof(lVar);
            }

            /* renamed from: mergeUnknownFields, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public final Builder m٩٨٤mergeUnknownFields(k2 k2Var) {
                return (Builder) super.mergeUnknownFields(k2Var);
            }

            /* renamed from: clear, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٦٣clear() {
                super.clear();
                this.bitField0_ = 0;
                this.thumbWidth_ = 0;
                this.thumbHeight_ = 0;
                this.thumbSize_ = 0L;
                this.thumbUrl_ = "";
                this.videoSecond_ = 0;
                this.videoSize_ = 0L;
                this.videoUrl_ = "";
                this.localPath_ = "";
                this.localThumbPath_ = "";
                return this;
            }

            /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٧٤clone() {
                return (Builder) super.clone();
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٧٨mergeFrom(b1 b1Var) {
                if (b1Var instanceof VideoElemContent) {
                    return mergeFrom((VideoElemContent) b1Var);
                }
                super/*com.google.protobuf.a.a*/.mergeFrom(b1Var);
                return this;
            }

            private Builder(h0.c cVar) {
                super(cVar);
                this.thumbUrl_ = "";
                this.videoUrl_ = "";
                this.localPath_ = "";
                this.localThumbPath_ = "";
            }

            public Builder mergeFrom(VideoElemContent videoElemContent) {
                if (videoElemContent == VideoElemContent.getDefaultInstance()) {
                    return this;
                }
                if (videoElemContent.getThumbWidth() != 0) {
                    setThumbWidth(videoElemContent.getThumbWidth());
                }
                if (videoElemContent.getThumbHeight() != 0) {
                    setThumbHeight(videoElemContent.getThumbHeight());
                }
                if (videoElemContent.getThumbSize() != 0) {
                    setThumbSize(videoElemContent.getThumbSize());
                }
                if (!videoElemContent.getThumbUrl().isEmpty()) {
                    this.thumbUrl_ = videoElemContent.thumbUrl_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                if (videoElemContent.getVideoSecond() != 0) {
                    setVideoSecond(videoElemContent.getVideoSecond());
                }
                if (videoElemContent.getVideoSize() != 0) {
                    setVideoSize(videoElemContent.getVideoSize());
                }
                if (!videoElemContent.getVideoUrl().isEmpty()) {
                    this.videoUrl_ = videoElemContent.videoUrl_;
                    this.bitField0_ |= 64;
                    onChanged();
                }
                if (videoElemContent.hasLocalPath()) {
                    this.localPath_ = videoElemContent.localPath_;
                    this.bitField0_ |= 128;
                    onChanged();
                }
                if (videoElemContent.hasLocalThumbPath()) {
                    this.localThumbPath_ = videoElemContent.localThumbPath_;
                    this.bitField0_ |= 256;
                    onChanged();
                }
                m٩٨٤mergeUnknownFields(videoElemContent.getUnknownFields());
                onChanged();
                return this;
            }

            /* renamed from: mergeFrom, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder m٩٨٠mergeFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
                vVar.getClass();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int K = iVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.thumbWidth_ = iVar.y();
                                    this.bitField0_ |= 1;
                                } else if (K == 16) {
                                    this.thumbHeight_ = iVar.y();
                                    this.bitField0_ |= 2;
                                } else if (K == 24) {
                                    this.thumbSize_ = iVar.M();
                                    this.bitField0_ |= 4;
                                } else if (K == 34) {
                                    this.thumbUrl_ = iVar.J();
                                    this.bitField0_ |= 8;
                                } else if (K == 40) {
                                    this.videoSecond_ = iVar.y();
                                    this.bitField0_ |= 16;
                                } else if (K == 48) {
                                    this.videoSize_ = iVar.M();
                                    this.bitField0_ |= 32;
                                } else if (K == 58) {
                                    this.videoUrl_ = iVar.J();
                                    this.bitField0_ |= 64;
                                } else if (K == 66) {
                                    this.localPath_ = iVar.J();
                                    this.bitField0_ |= 128;
                                } else if (K != 74) {
                                    if (!parseUnknownField(iVar, vVar, K)) {
                                    }
                                } else {
                                    this.localThumbPath_ = iVar.J();
                                    this.bitField0_ |= 256;
                                }
                            }
                            z = true;
                        } catch (k0 e) {
                            throw e.m();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private VideoElemContent(h0.b bVar) {
            super(bVar);
            this.thumbWidth_ = 0;
            this.thumbHeight_ = 0;
            this.thumbSize_ = 0L;
            this.thumbUrl_ = "";
            this.videoSecond_ = 0;
            this.videoSize_ = 0L;
            this.videoUrl_ = "";
            this.localPath_ = "";
            this.localThumbPath_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(VideoElemContent videoElemContent) {
            return DEFAULT_INSTANCE.m٩٥٢toBuilder().mergeFrom(videoElemContent);
        }

        public static VideoElemContent parseFrom(ByteBuffer byteBuffer, v vVar) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(byteBuffer, vVar);
        }

        public static VideoElemContent parseDelimitedFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseDelimitedWithIOException(PARSER, inputStream, vVar);
        }

        public static VideoElemContent parseFrom(com.google.protobuf.h hVar) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(hVar);
        }

        @Override // roomMessage.RoomMessage.VideoElemContentOrBuilder
        /* renamed from: getDefaultInstanceForType, reason: collision with other method in class and merged with bridge method [inline-methods] */
        public VideoElemContent mo٩٩٢getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* renamed from: toBuilder, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٩٥٢toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static VideoElemContent parseFrom(com.google.protobuf.h hVar, v vVar) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(hVar, vVar);
        }

        /* renamed from: newBuilderForType, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m٩٤٩newBuilderForType() {
            return newBuilder();
        }

        public static VideoElemContent parseFrom(byte[] bArr) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(bArr);
        }

        public Builder newBuilderForType(h0.c cVar) {
            return new Builder(cVar);
        }

        public static VideoElemContent parseFrom(byte[] bArr, v vVar) throws k0 {
            return (VideoElemContent) PARSER.parseFrom(bArr, vVar);
        }

        public static VideoElemContent parseFrom(InputStream inputStream) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream);
        }

        public static VideoElemContent parseFrom(InputStream inputStream, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, inputStream, vVar);
        }

        public static VideoElemContent parseFrom(com.google.protobuf.i iVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar);
        }

        private VideoElemContent() {
            this.thumbWidth_ = 0;
            this.thumbHeight_ = 0;
            this.thumbSize_ = 0L;
            this.thumbUrl_ = "";
            this.videoSecond_ = 0;
            this.videoSize_ = 0L;
            this.videoUrl_ = "";
            this.localPath_ = "";
            this.localThumbPath_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.thumbUrl_ = "";
            this.videoUrl_ = "";
            this.localPath_ = "";
            this.localThumbPath_ = "";
        }

        public static VideoElemContent parseFrom(com.google.protobuf.i iVar, v vVar) throws IOException {
            return h0.parseWithIOException(PARSER, iVar, vVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public interface VideoElemContentOrBuilder extends g1 {
        /* synthetic */ List findInitializationErrors();

        /* synthetic */ Map getAllFields();

        /* renamed from: getDefaultInstanceForType */
        /* synthetic */ b1 mo٩٩٢getDefaultInstanceForType();

        /* renamed from: getDefaultInstanceForType, reason: contains not printable characters */
        /* synthetic */ e1 mo٩٩٢getDefaultInstanceForType();

        /* synthetic */ n.b getDescriptorForType();

        /* synthetic */ Object getField(n.g gVar);

        /* synthetic */ String getInitializationErrorString();

        String getLocalPath();

        com.google.protobuf.h getLocalPathBytes();

        String getLocalThumbPath();

        com.google.protobuf.h getLocalThumbPathBytes();

        /* synthetic */ n.g getOneofFieldDescriptor(n.l lVar);

        /* synthetic */ Object getRepeatedField(n.g gVar, int i);

        /* synthetic */ int getRepeatedFieldCount(n.g gVar);

        int getThumbHeight();

        long getThumbSize();

        String getThumbUrl();

        com.google.protobuf.h getThumbUrlBytes();

        int getThumbWidth();

        /* synthetic */ k2 getUnknownFields();

        int getVideoSecond();

        long getVideoSize();

        String getVideoUrl();

        com.google.protobuf.h getVideoUrlBytes();

        /* synthetic */ boolean hasField(n.g gVar);

        boolean hasLocalPath();

        boolean hasLocalThumbPath();

        /* synthetic */ boolean hasOneof(n.l lVar);

        /* synthetic */ boolean isInitialized();
    }

    static {
        n.b bVar = (n.b) getDescriptor().j().get(0);
        internal_static_roomMessage_GroupMessageSend_descriptor = bVar;
        internal_static_roomMessage_GroupMessageSend_fieldAccessorTable = new h0.f(bVar, new String[]{"MsgId", "FromAccount", "OperatorAccount", "GroupId", "MsgBody", "EventTime", "Status", "MsgTab", "EventTime", "Status"});
        n.b bVar2 = (n.b) getDescriptor().j().get(1);
        internal_static_roomMessage_GroupMessageNew_descriptor = bVar2;
        internal_static_roomMessage_GroupMessageNew_fieldAccessorTable = new h0.f(bVar2, new String[]{"MsgId", "FromAccount", "SenderNick", "SenderAvatar", "OperatorAccount", "GroupId", "MsgBody", "CloudCustomData", "EventTime", "UserId", "Status", "MsgTab", "CloudCustomData", "EventTime", "UserId", "Status"});
        n.b bVar3 = (n.b) getDescriptor().j().get(2);
        internal_static_roomMessage_GroupMessageSendRsp_descriptor = bVar3;
        internal_static_roomMessage_GroupMessageSendRsp_fieldAccessorTable = new h0.f(bVar3, new String[]{"MsgId", "ErrCode", "ErrMsg"});
        n.b bVar4 = (n.b) getDescriptor().j().get(3);
        internal_static_roomMessage_MsgBody_descriptor = bVar4;
        internal_static_roomMessage_MsgBody_fieldAccessorTable = new h0.f(bVar4, new String[]{"MsgType", "CustomContent", "TextContent", "VideoContent", "ImageContent"});
        n.b bVar5 = (n.b) getDescriptor().j().get(4);
        internal_static_roomMessage_GMSvipDetail_descriptor = bVar5;
        internal_static_roomMessage_GMSvipDetail_fieldAccessorTable = new h0.f(bVar5, new String[]{"SvipLevel", "MysteryCode", "MysteryCode"});
        n.b bVar6 = (n.b) getDescriptor().j().get(5);
        internal_static_roomMessage_CloudCustomData_descriptor = bVar6;
        internal_static_roomMessage_CloudCustomData_fieldAccessorTable = new h0.f(bVar6, new String[]{"WealthGrade", "CharmGrade", "IsVip", "IsPretty", "Medals", "PowerName", "NobleLevel", "SvipLevel", "PowerNameplate", "PowerGrade", "CornerMark", "Svip"});
        n.b bVar7 = (n.b) getDescriptor().j().get(6);
        internal_static_roomMessage_CustomElemContent_descriptor = bVar7;
        internal_static_roomMessage_CustomElemContent_fieldAccessorTable = new h0.f(bVar7, new String[]{"Data"});
        n.b bVar8 = (n.b) getDescriptor().j().get(7);
        internal_static_roomMessage_TextElemContent_descriptor = bVar8;
        internal_static_roomMessage_TextElemContent_fieldAccessorTable = new h0.f(bVar8, new String[]{"Text", "AtAccount"});
        n.b bVar9 = (n.b) getDescriptor().j().get(8);
        internal_static_roomMessage_TextElemContentAt_descriptor = bVar9;
        internal_static_roomMessage_TextElemContentAt_fieldAccessorTable = new h0.f(bVar9, new String[]{"AtAccount", "AtNick"});
        n.b bVar10 = (n.b) getDescriptor().j().get(9);
        internal_static_roomMessage_ImageInfo_descriptor = bVar10;
        internal_static_roomMessage_ImageInfo_fieldAccessorTable = new h0.f(bVar10, new String[]{"Width", "Height", "Size", "Url", "LocalPath", "LocalPath"});
        n.b bVar11 = (n.b) getDescriptor().j().get(10);
        internal_static_roomMessage_ImageElemContent_descriptor = bVar11;
        internal_static_roomMessage_ImageElemContent_fieldAccessorTable = new h0.f(bVar11, new String[]{"ImageInfoArray"});
        n.b bVar12 = (n.b) getDescriptor().j().get(11);
        internal_static_roomMessage_VideoElemContent_descriptor = bVar12;
        internal_static_roomMessage_VideoElemContent_fieldAccessorTable = new h0.f(bVar12, new String[]{"ThumbWidth", "ThumbHeight", "ThumbSize", "ThumbUrl", "VideoSecond", "VideoSize", "VideoUrl", "LocalPath", "LocalThumbPath", "LocalPath", "LocalThumbPath"});
    }

    private RoomMessage() {
    }

    public static n.h getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(v vVar) {
    }

    public static void registerAllExtensions(t tVar) {
        registerAllExtensions((v) tVar);
    }
}
