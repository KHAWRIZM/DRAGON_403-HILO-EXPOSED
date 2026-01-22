package com.qiahao.base_common.model.im;

import android.os.Parcel;
import android.os.Parcelable;
import com.liulishuo.okdownload.DownloadTask;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.svip.SvipData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u008e\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010OJ\u001e\u0010\u009d\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0013HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010©\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010OJ\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\u0012\u0010°\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010'HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010µ\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u000bHÆ\u0003Jî\u0003\u0010¸\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.2\b\b\u0002\u00100\u001a\u00020\u000bHÆ\u0001¢\u0006\u0003\u0010¹\u0001J\u0007\u0010º\u0001\u001a\u00020\u000bJ\u0016\u0010»\u0001\u001a\u00020\u00102\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001HÖ\u0003J\n\u0010¾\u0001\u001a\u00020\u000bHÖ\u0001J\n\u0010¿\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bM\u0010I\"\u0004\bN\u0010KR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\b\u000f\u0010O\"\u0004\bP\u0010QR.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00104\"\u0004\bX\u00106R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00104\"\u0004\b`\u00106R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00104\"\u0004\bb\u00106R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bc\u0010D\"\u0004\bd\u0010FR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\be\u0010D\"\u0004\bf\u0010FR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bg\u0010D\"\u0004\bh\u0010FR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00104\"\u0004\bj\u00106R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bk\u0010I\"\u0004\bl\u0010KR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bm\u0010D\"\u0004\bn\u0010FR\u001e\u0010 \u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bo\u0010I\"\u0004\bp\u0010KR\u001e\u0010!\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bq\u0010I\"\u0004\br\u0010KR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\b\"\u0010O\"\u0004\bs\u0010QR\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00104\"\u0004\bu\u00106R\u001c\u0010$\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00104\"\u0004\bw\u00106R\u001e\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bx\u0010D\"\u0004\by\u0010FR\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00104\"\u0004\b\u007f\u00106R \u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001e\u0010+\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u00104\"\u0005\b\u0085\u0001\u00106R \u0010,\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0086\u0001\u0010D\"\u0005\b\u0087\u0001\u0010FR \u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010/\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u0006\b\u008d\u0001\u0010\u008b\u0001R\u001e\u00100\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006Å\u0001"}, d2 = {"Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "Landroid/os/Parcelable;", "avatar", "", "externalId", "nick", "operatorAvatar", "operatorExternalId", "operatorNick", "type", "role", "", "giftId", "", "giftNumber", "isVip", "", "dices", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groupId", "senderCode", "receiverCode", "groupCode", "giftName", "h5", "awardType", "number", "contentType", "content", "diamondNum", "nobleLevel", "wealthGrade", "charmGrade", "isPrettyCode", "powerName", "powerNameplate", "powerGrade", "medalIds", "", "extString", "giftDetail", "Lcom/qiahao/base_common/model/GroupGiftDetail;", "msg", "svipLevel", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "receiveSvip", "cornerMark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/GroupGiftDetail;Ljava/lang/String;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;I)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getExternalId", "setExternalId", "getNick", "setNick", "getOperatorAvatar", "setOperatorAvatar", "getOperatorExternalId", "setOperatorExternalId", "getOperatorNick", "setOperatorNick", "getType", "setType", "getRole", "()Ljava/lang/Integer;", "setRole", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGiftId", "()Ljava/lang/Long;", "setGiftId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGiftNumber", "setGiftNumber", "()Ljava/lang/Boolean;", "setVip", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDices", "()Ljava/util/ArrayList;", "setDices", "(Ljava/util/ArrayList;)V", "getGroupId", "setGroupId", "getSenderCode", "setSenderCode", "getReceiverCode", "setReceiverCode", "getGroupCode", "setGroupCode", "getGiftName", "setGiftName", "getH5", "setH5", "getAwardType", "setAwardType", "getNumber", "setNumber", "getContentType", "setContentType", "getContent", "setContent", "getDiamondNum", "setDiamondNum", "getNobleLevel", "setNobleLevel", "getWealthGrade", "setWealthGrade", "getCharmGrade", "setCharmGrade", "setPrettyCode", "getPowerName", "setPowerName", "getPowerNameplate", "setPowerNameplate", "getPowerGrade", "setPowerGrade", "getMedalIds", "()Ljava/util/List;", "setMedalIds", "(Ljava/util/List;)V", "getExtString", "setExtString", "getGiftDetail", "()Lcom/qiahao/base_common/model/GroupGiftDetail;", "setGiftDetail", "(Lcom/qiahao/base_common/model/GroupGiftDetail;)V", "getMsg", "setMsg", "getSvipLevel", "setSvipLevel", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getReceiveSvip", "setReceiveSvip", "getCornerMark", "()I", "setCornerMark", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/GroupGiftDetail;Ljava/lang/String;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;I)Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupRoomImCustomBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GroupRoomImCustomBean> CREATOR = new Creator();

    @Nullable
    private String avatar;

    @Nullable
    private Integer awardType;

    @Nullable
    private Long charmGrade;

    @Nullable
    private String content;

    @Nullable
    private Integer contentType;
    private int cornerMark;

    @Nullable
    private Long diamondNum;

    @Nullable
    private ArrayList<Integer> dices;

    @Nullable
    private String extString;

    @Nullable
    private String externalId;

    @Nullable
    private GroupGiftDetail giftDetail;

    @Nullable
    private Long giftId;

    @Nullable
    private String giftName;

    @Nullable
    private Long giftNumber;

    @Nullable
    private String groupCode;

    @Nullable
    private String groupId;

    @Nullable
    private String h5;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private Boolean isVip;

    @Nullable
    private List<Integer> medalIds;

    @Nullable
    private String msg;

    @Nullable
    private String nick;

    @Nullable
    private Integer nobleLevel;

    @Nullable
    private Integer number;

    @Nullable
    private String operatorAvatar;

    @Nullable
    private String operatorExternalId;

    @Nullable
    private String operatorNick;

    @Nullable
    private Integer powerGrade;

    @Nullable
    private String powerName;

    @Nullable
    private String powerNameplate;

    @Nullable
    private SvipData receiveSvip;

    @Nullable
    private String receiverCode;

    @Nullable
    private Integer role;

    @Nullable
    private String senderCode;

    @Nullable
    private SvipData svip;

    @Nullable
    private Integer svipLevel;

    @Nullable
    private String type;

    @Nullable
    private Long wealthGrade;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<GroupRoomImCustomBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupRoomImCustomBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String str;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Boolean valueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList3.add(Integer.valueOf(parcel.readInt()));
                }
                arrayList = arrayList3;
            }
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString14 = parcel.readString();
            Long valueOf8 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf9 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf10 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf11 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Boolean valueOf12 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            Integer valueOf13 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                str = readString8;
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                str = readString8;
                int i11 = 0;
                while (i11 != readInt2) {
                    arrayList4.add(Integer.valueOf(parcel.readInt()));
                    i11++;
                    readInt2 = readInt2;
                }
                arrayList2 = arrayList4;
            }
            return new GroupRoomImCustomBean(readString, readString2, readString3, readString4, readString5, readString6, readString7, valueOf, valueOf2, valueOf3, valueOf4, arrayList, str, readString9, readString10, readString11, readString12, readString13, valueOf5, valueOf6, valueOf7, readString14, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, readString15, readString16, valueOf13, arrayList2, parcel.readString(), parcel.readInt() == 0 ? null : GroupGiftDetail.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : SvipData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SvipData.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupRoomImCustomBean[] newArray(int i10) {
            return new GroupRoomImCustomBean[i10];
        }
    }

    public GroupRoomImCustomBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num, @Nullable Long l10, @Nullable Long l11, @Nullable Boolean bool, @Nullable ArrayList<Integer> arrayList, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str14, @Nullable Long l12, @Nullable Integer num5, @Nullable Long l13, @Nullable Long l14, @Nullable Boolean bool2, @Nullable String str15, @Nullable String str16, @Nullable Integer num6, @Nullable List<Integer> list, @Nullable String str17, @Nullable GroupGiftDetail groupGiftDetail, @Nullable String str18, @Nullable Integer num7, @Nullable SvipData svipData, @Nullable SvipData svipData2, int i10) {
        this.avatar = str;
        this.externalId = str2;
        this.nick = str3;
        this.operatorAvatar = str4;
        this.operatorExternalId = str5;
        this.operatorNick = str6;
        this.type = str7;
        this.role = num;
        this.giftId = l10;
        this.giftNumber = l11;
        this.isVip = bool;
        this.dices = arrayList;
        this.groupId = str8;
        this.senderCode = str9;
        this.receiverCode = str10;
        this.groupCode = str11;
        this.giftName = str12;
        this.h5 = str13;
        this.awardType = num2;
        this.number = num3;
        this.contentType = num4;
        this.content = str14;
        this.diamondNum = l12;
        this.nobleLevel = num5;
        this.wealthGrade = l13;
        this.charmGrade = l14;
        this.isPrettyCode = bool2;
        this.powerName = str15;
        this.powerNameplate = str16;
        this.powerGrade = num6;
        this.medalIds = list;
        this.extString = str17;
        this.giftDetail = groupGiftDetail;
        this.msg = str18;
        this.svipLevel = num7;
        this.svip = svipData;
        this.receiveSvip = svipData2;
        this.cornerMark = i10;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getGiftNumber() {
        return this.giftNumber;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    public final ArrayList<Integer> component12() {
        return this.dices;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getSenderCode() {
        return this.senderCode;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getReceiverCode() {
        return this.receiverCode;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getGroupCode() {
        return this.groupCode;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getGiftName() {
        return this.giftName;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getH5() {
        return this.h5;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Integer getAwardType() {
        return this.awardType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getNumber() {
        return this.number;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Integer getContentType() {
        return this.contentType;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component30, reason: from getter */
    public final Integer getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    public final List<Integer> component31() {
        return this.medalIds;
    }

    @Nullable
    /* renamed from: component32, reason: from getter */
    public final String getExtString() {
        return this.extString;
    }

    @Nullable
    /* renamed from: component33, reason: from getter */
    public final GroupGiftDetail getGiftDetail() {
        return this.giftDetail;
    }

    @Nullable
    /* renamed from: component34, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component35, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    /* renamed from: component38, reason: from getter */
    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getOperatorAvatar() {
        return this.operatorAvatar;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getOperatorExternalId() {
        return this.operatorExternalId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getOperatorNick() {
        return this.operatorNick;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getGiftId() {
        return this.giftId;
    }

    @NotNull
    public final GroupRoomImCustomBean copy(@Nullable String avatar, @Nullable String externalId, @Nullable String nick, @Nullable String operatorAvatar, @Nullable String operatorExternalId, @Nullable String operatorNick, @Nullable String type, @Nullable Integer role, @Nullable Long giftId, @Nullable Long giftNumber, @Nullable Boolean isVip, @Nullable ArrayList<Integer> dices, @Nullable String groupId, @Nullable String senderCode, @Nullable String receiverCode, @Nullable String groupCode, @Nullable String giftName, @Nullable String h52, @Nullable Integer awardType, @Nullable Integer number, @Nullable Integer contentType, @Nullable String content, @Nullable Long diamondNum, @Nullable Integer nobleLevel, @Nullable Long wealthGrade, @Nullable Long charmGrade, @Nullable Boolean isPrettyCode, @Nullable String powerName, @Nullable String powerNameplate, @Nullable Integer powerGrade, @Nullable List<Integer> medalIds, @Nullable String extString, @Nullable GroupGiftDetail giftDetail, @Nullable String msg, @Nullable Integer svipLevel, @Nullable SvipData svip, @Nullable SvipData receiveSvip, int cornerMark) {
        return new GroupRoomImCustomBean(avatar, externalId, nick, operatorAvatar, operatorExternalId, operatorNick, type, role, giftId, giftNumber, isVip, dices, groupId, senderCode, receiverCode, groupCode, giftName, h52, awardType, number, contentType, content, diamondNum, nobleLevel, wealthGrade, charmGrade, isPrettyCode, powerName, powerNameplate, powerGrade, medalIds, extString, giftDetail, msg, svipLevel, svip, receiveSvip, cornerMark);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupRoomImCustomBean)) {
            return false;
        }
        GroupRoomImCustomBean groupRoomImCustomBean = (GroupRoomImCustomBean) other;
        return Intrinsics.areEqual(this.avatar, groupRoomImCustomBean.avatar) && Intrinsics.areEqual(this.externalId, groupRoomImCustomBean.externalId) && Intrinsics.areEqual(this.nick, groupRoomImCustomBean.nick) && Intrinsics.areEqual(this.operatorAvatar, groupRoomImCustomBean.operatorAvatar) && Intrinsics.areEqual(this.operatorExternalId, groupRoomImCustomBean.operatorExternalId) && Intrinsics.areEqual(this.operatorNick, groupRoomImCustomBean.operatorNick) && Intrinsics.areEqual(this.type, groupRoomImCustomBean.type) && Intrinsics.areEqual(this.role, groupRoomImCustomBean.role) && Intrinsics.areEqual(this.giftId, groupRoomImCustomBean.giftId) && Intrinsics.areEqual(this.giftNumber, groupRoomImCustomBean.giftNumber) && Intrinsics.areEqual(this.isVip, groupRoomImCustomBean.isVip) && Intrinsics.areEqual(this.dices, groupRoomImCustomBean.dices) && Intrinsics.areEqual(this.groupId, groupRoomImCustomBean.groupId) && Intrinsics.areEqual(this.senderCode, groupRoomImCustomBean.senderCode) && Intrinsics.areEqual(this.receiverCode, groupRoomImCustomBean.receiverCode) && Intrinsics.areEqual(this.groupCode, groupRoomImCustomBean.groupCode) && Intrinsics.areEqual(this.giftName, groupRoomImCustomBean.giftName) && Intrinsics.areEqual(this.h5, groupRoomImCustomBean.h5) && Intrinsics.areEqual(this.awardType, groupRoomImCustomBean.awardType) && Intrinsics.areEqual(this.number, groupRoomImCustomBean.number) && Intrinsics.areEqual(this.contentType, groupRoomImCustomBean.contentType) && Intrinsics.areEqual(this.content, groupRoomImCustomBean.content) && Intrinsics.areEqual(this.diamondNum, groupRoomImCustomBean.diamondNum) && Intrinsics.areEqual(this.nobleLevel, groupRoomImCustomBean.nobleLevel) && Intrinsics.areEqual(this.wealthGrade, groupRoomImCustomBean.wealthGrade) && Intrinsics.areEqual(this.charmGrade, groupRoomImCustomBean.charmGrade) && Intrinsics.areEqual(this.isPrettyCode, groupRoomImCustomBean.isPrettyCode) && Intrinsics.areEqual(this.powerName, groupRoomImCustomBean.powerName) && Intrinsics.areEqual(this.powerNameplate, groupRoomImCustomBean.powerNameplate) && Intrinsics.areEqual(this.powerGrade, groupRoomImCustomBean.powerGrade) && Intrinsics.areEqual(this.medalIds, groupRoomImCustomBean.medalIds) && Intrinsics.areEqual(this.extString, groupRoomImCustomBean.extString) && Intrinsics.areEqual(this.giftDetail, groupRoomImCustomBean.giftDetail) && Intrinsics.areEqual(this.msg, groupRoomImCustomBean.msg) && Intrinsics.areEqual(this.svipLevel, groupRoomImCustomBean.svipLevel) && Intrinsics.areEqual(this.svip, groupRoomImCustomBean.svip) && Intrinsics.areEqual(this.receiveSvip, groupRoomImCustomBean.receiveSvip) && this.cornerMark == groupRoomImCustomBean.cornerMark;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Integer getAwardType() {
        return this.awardType;
    }

    @Nullable
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getContentType() {
        return this.contentType;
    }

    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final ArrayList<Integer> getDices() {
        return this.dices;
    }

    @Nullable
    public final String getExtString() {
        return this.extString;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final GroupGiftDetail getGiftDetail() {
        return this.giftDetail;
    }

    @Nullable
    public final Long getGiftId() {
        return this.giftId;
    }

    @Nullable
    public final String getGiftName() {
        return this.giftName;
    }

    @Nullable
    public final Long getGiftNumber() {
        return this.giftNumber;
    }

    @Nullable
    public final String getGroupCode() {
        return this.groupCode;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getH5() {
        return this.h5;
    }

    @Nullable
    public final List<Integer> getMedalIds() {
        return this.medalIds;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final Integer getNumber() {
        return this.number;
    }

    @Nullable
    public final String getOperatorAvatar() {
        return this.operatorAvatar;
    }

    @Nullable
    public final String getOperatorExternalId() {
        return this.operatorExternalId;
    }

    @Nullable
    public final String getOperatorNick() {
        return this.operatorNick;
    }

    @Nullable
    public final Integer getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @Nullable
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @Nullable
    public final String getReceiverCode() {
        return this.receiverCode;
    }

    @Nullable
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    public final String getSenderCode() {
        return this.senderCode;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.externalId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nick;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.operatorAvatar;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.operatorExternalId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.operatorNick;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.type;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.role;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.giftId;
        int hashCode9 = (hashCode8 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.giftNumber;
        int hashCode10 = (hashCode9 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Boolean bool = this.isVip;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.dices;
        int hashCode12 = (hashCode11 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str8 = this.groupId;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.senderCode;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.receiverCode;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.groupCode;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.giftName;
        int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.h5;
        int hashCode18 = (hashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num2 = this.awardType;
        int hashCode19 = (hashCode18 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.number;
        int hashCode20 = (hashCode19 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.contentType;
        int hashCode21 = (hashCode20 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str14 = this.content;
        int hashCode22 = (hashCode21 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Long l12 = this.diamondNum;
        int hashCode23 = (hashCode22 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Integer num5 = this.nobleLevel;
        int hashCode24 = (hashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Long l13 = this.wealthGrade;
        int hashCode25 = (hashCode24 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.charmGrade;
        int hashCode26 = (hashCode25 + (l14 == null ? 0 : l14.hashCode())) * 31;
        Boolean bool2 = this.isPrettyCode;
        int hashCode27 = (hashCode26 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str15 = this.powerName;
        int hashCode28 = (hashCode27 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.powerNameplate;
        int hashCode29 = (hashCode28 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Integer num6 = this.powerGrade;
        int hashCode30 = (hashCode29 + (num6 == null ? 0 : num6.hashCode())) * 31;
        List<Integer> list = this.medalIds;
        int hashCode31 = (hashCode30 + (list == null ? 0 : list.hashCode())) * 31;
        String str17 = this.extString;
        int hashCode32 = (hashCode31 + (str17 == null ? 0 : str17.hashCode())) * 31;
        GroupGiftDetail groupGiftDetail = this.giftDetail;
        int hashCode33 = (hashCode32 + (groupGiftDetail == null ? 0 : groupGiftDetail.hashCode())) * 31;
        String str18 = this.msg;
        int hashCode34 = (hashCode33 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Integer num7 = this.svipLevel;
        int hashCode35 = (hashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode36 = (hashCode35 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        SvipData svipData2 = this.receiveSvip;
        return ((hashCode36 + (svipData2 != null ? svipData2.hashCode() : 0)) * 31) + this.cornerMark;
    }

    @Nullable
    public final Boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    public final Boolean isVip() {
        return this.isVip;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setAwardType(@Nullable Integer num) {
        this.awardType = num;
    }

    public final void setCharmGrade(@Nullable Long l10) {
        this.charmGrade = l10;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setContentType(@Nullable Integer num) {
        this.contentType = num;
    }

    public final void setCornerMark(int i10) {
        this.cornerMark = i10;
    }

    public final void setDiamondNum(@Nullable Long l10) {
        this.diamondNum = l10;
    }

    public final void setDices(@Nullable ArrayList<Integer> arrayList) {
        this.dices = arrayList;
    }

    public final void setExtString(@Nullable String str) {
        this.extString = str;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setGiftDetail(@Nullable GroupGiftDetail groupGiftDetail) {
        this.giftDetail = groupGiftDetail;
    }

    public final void setGiftId(@Nullable Long l10) {
        this.giftId = l10;
    }

    public final void setGiftName(@Nullable String str) {
        this.giftName = str;
    }

    public final void setGiftNumber(@Nullable Long l10) {
        this.giftNumber = l10;
    }

    public final void setGroupCode(@Nullable String str) {
        this.groupCode = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setH5(@Nullable String str) {
        this.h5 = str;
    }

    public final void setMedalIds(@Nullable List<Integer> list) {
        this.medalIds = list;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setNobleLevel(@Nullable Integer num) {
        this.nobleLevel = num;
    }

    public final void setNumber(@Nullable Integer num) {
        this.number = num;
    }

    public final void setOperatorAvatar(@Nullable String str) {
        this.operatorAvatar = str;
    }

    public final void setOperatorExternalId(@Nullable String str) {
        this.operatorExternalId = str;
    }

    public final void setOperatorNick(@Nullable String str) {
        this.operatorNick = str;
    }

    public final void setPowerGrade(@Nullable Integer num) {
        this.powerGrade = num;
    }

    public final void setPowerName(@Nullable String str) {
        this.powerName = str;
    }

    public final void setPowerNameplate(@Nullable String str) {
        this.powerNameplate = str;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setReceiveSvip(@Nullable SvipData svipData) {
        this.receiveSvip = svipData;
    }

    public final void setReceiverCode(@Nullable String str) {
        this.receiverCode = str;
    }

    public final void setRole(@Nullable Integer num) {
        this.role = num;
    }

    public final void setSenderCode(@Nullable String str) {
        this.senderCode = str;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setWealthGrade(@Nullable Long l10) {
        this.wealthGrade = l10;
    }

    @NotNull
    public String toString() {
        return "GroupRoomImCustomBean(avatar=" + this.avatar + ", externalId=" + this.externalId + ", nick=" + this.nick + ", operatorAvatar=" + this.operatorAvatar + ", operatorExternalId=" + this.operatorExternalId + ", operatorNick=" + this.operatorNick + ", type=" + this.type + ", role=" + this.role + ", giftId=" + this.giftId + ", giftNumber=" + this.giftNumber + ", isVip=" + this.isVip + ", dices=" + this.dices + ", groupId=" + this.groupId + ", senderCode=" + this.senderCode + ", receiverCode=" + this.receiverCode + ", groupCode=" + this.groupCode + ", giftName=" + this.giftName + ", h5=" + this.h5 + ", awardType=" + this.awardType + ", number=" + this.number + ", contentType=" + this.contentType + ", content=" + this.content + ", diamondNum=" + this.diamondNum + ", nobleLevel=" + this.nobleLevel + ", wealthGrade=" + this.wealthGrade + ", charmGrade=" + this.charmGrade + ", isPrettyCode=" + this.isPrettyCode + ", powerName=" + this.powerName + ", powerNameplate=" + this.powerNameplate + ", powerGrade=" + this.powerGrade + ", medalIds=" + this.medalIds + ", extString=" + this.extString + ", giftDetail=" + this.giftDetail + ", msg=" + this.msg + ", svipLevel=" + this.svipLevel + ", svip=" + this.svip + ", receiveSvip=" + this.receiveSvip + ", cornerMark=" + this.cornerMark + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.avatar);
        dest.writeString(this.externalId);
        dest.writeString(this.nick);
        dest.writeString(this.operatorAvatar);
        dest.writeString(this.operatorExternalId);
        dest.writeString(this.operatorNick);
        dest.writeString(this.type);
        Integer num = this.role;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l10 = this.giftId;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Long l11 = this.giftNumber;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        Boolean bool = this.isVip;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ArrayList<Integer> arrayList = this.dices;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        dest.writeString(this.groupId);
        dest.writeString(this.senderCode);
        dest.writeString(this.receiverCode);
        dest.writeString(this.groupCode);
        dest.writeString(this.giftName);
        dest.writeString(this.h5);
        Integer num2 = this.awardType;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.number;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.contentType;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        dest.writeString(this.content);
        Long l12 = this.diamondNum;
        if (l12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l12.longValue());
        }
        Integer num5 = this.nobleLevel;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
        Long l13 = this.wealthGrade;
        if (l13 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l13.longValue());
        }
        Long l14 = this.charmGrade;
        if (l14 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l14.longValue());
        }
        Boolean bool2 = this.isPrettyCode;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.powerName);
        dest.writeString(this.powerNameplate);
        Integer num6 = this.powerGrade;
        if (num6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num6.intValue());
        }
        List<Integer> list = this.medalIds;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                dest.writeInt(it2.next().intValue());
            }
        }
        dest.writeString(this.extString);
        GroupGiftDetail groupGiftDetail = this.giftDetail;
        if (groupGiftDetail == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            groupGiftDetail.writeToParcel(dest, flags);
        }
        dest.writeString(this.msg);
        Integer num7 = this.svipLevel;
        if (num7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num7.intValue());
        }
        SvipData svipData = this.svip;
        if (svipData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            svipData.writeToParcel(dest, flags);
        }
        SvipData svipData2 = this.receiveSvip;
        if (svipData2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            svipData2.writeToParcel(dest, flags);
        }
        dest.writeInt(this.cornerMark);
    }

    public /* synthetic */ GroupRoomImCustomBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Long l10, Long l11, Boolean bool, ArrayList arrayList, String str8, String str9, String str10, String str11, String str12, String str13, Integer num2, Integer num3, Integer num4, String str14, Long l12, Integer num5, Long l13, Long l14, Boolean bool2, String str15, String str16, Integer num6, List list, String str17, GroupGiftDetail groupGiftDetail, String str18, Integer num7, SvipData svipData, SvipData svipData2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : num, (i11 & 256) != 0 ? null : l10, (i11 & 512) != 0 ? null : l11, (i11 & 1024) != 0 ? Boolean.FALSE : bool, (i11 & 2048) != 0 ? null : arrayList, (i11 & 4096) != 0 ? null : str8, (i11 & 8192) != 0 ? null : str9, (i11 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : str10, (32768 & i11) != 0 ? null : str11, (65536 & i11) != 0 ? null : str12, (131072 & i11) != 0 ? null : str13, (262144 & i11) != 0 ? 0 : num2, (524288 & i11) != 0 ? 0 : num3, (1048576 & i11) != 0 ? 0 : num4, str14, (4194304 & i11) != 0 ? 0L : l12, (i11 & 8388608) != 0 ? 0 : num5, (i11 & 16777216) != 0 ? 0L : l13, (i11 & 33554432) != 0 ? 0L : l14, (i11 & 67108864) != 0 ? Boolean.FALSE : bool2, (i11 & 134217728) != 0 ? "" : str15, (i11 & 268435456) != 0 ? null : str16, (i11 & 536870912) != 0 ? null : num6, list, (i11 & Integer.MIN_VALUE) != 0 ? "" : str17, (i12 & 1) != 0 ? null : groupGiftDetail, (i12 & 2) != 0 ? null : str18, (i12 & 4) != 0 ? 0 : num7, (i12 & 8) != 0 ? null : svipData, (i12 & 16) != 0 ? null : svipData2, (i12 & 32) != 0 ? 0 : i10);
    }
}
