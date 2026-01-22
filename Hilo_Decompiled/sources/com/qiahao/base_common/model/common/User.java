package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.c;
import anet.channel.bytes.a;
import anetwork.channel.unified.e;
import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.liulishuo.okdownload.DownloadTask;
import com.qiahao.base_common.model.cp.MyCp;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b°\u0001\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ä\u00022\u00020\u0001:\u0002ä\u0002B\u009d\u0006\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0016\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010(\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00105\u001a\u00020\u0016\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\u001c\b\u0002\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`<\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010H\u001a\u00020\u000e\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010W\u001a\u00020\u000e\u0012\b\b\u0002\u0010X\u001a\u00020\u000e¢\u0006\u0004\bY\u0010ZJ\u0007\u0010\u0083\u0002\u001a\u00020\u0016J\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0003J\u0007\u0010\u008b\u0002\u001a\u00020\u0016J\u0007\u0010\u008c\u0002\u001a\u00020\u0016J\u0007\u0010\u008d\u0002\u001a\u00020\u0016J\u0007\u0010\u008e\u0002\u001a\u00020\u0016J\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002J\u0019\u0010\u0091\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u0090\u00020;j\t\u0012\u0005\u0012\u00030\u0090\u0002`<J\f\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0098\u0002\u001a\u00020\tHÆ\u0003J\n\u0010\u0099\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009b\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009c\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u009d\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u009e\u0002\u001a\u00020\u000eHÆ\u0003J\f\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010 \u0002\u001a\u00020\u000eHÆ\u0003J\f\u0010¡\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¢\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010£\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010¤\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010¥\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010¦\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010§\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010¨\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010©\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010ª\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\n\u0010«\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010¬\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010\u00ad\u0002\u001a\u00020\u000eHÆ\u0003J\u0012\u0010®\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\n\u0010¯\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010°\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010±\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010²\u0002\u001a\u00020\u0016HÆ\u0003J\n\u0010³\u0002\u001a\u00020\u0005HÆ\u0003J\u0012\u0010´\u0002\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010(HÆ\u0003J\u0012\u0010µ\u0002\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010(HÆ\u0003J\f\u0010¶\u0002\u001a\u0004\u0018\u00010,HÆ\u0003J\u0012\u0010·\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\f\u0010¸\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010¹\u0002\u001a\u00020\u0005HÆ\u0003J\f\u0010º\u0002\u001a\u0004\u0018\u000101HÆ\u0003J\f\u0010»\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0002\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010½\u0002\u001a\u00020\u0016HÆ\u0003J\f\u0010¾\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¿\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0003\u0010Â\u0001J\f\u0010À\u0002\u001a\u0004\u0018\u000109HÆ\u0003J\u001e\u0010Á\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`<HÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010>HÆ\u0003J\u0012\u0010Ã\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0003\u0010Â\u0001J\u0012\u0010Ä\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\f\u0010Å\u0002\u001a\u0004\u0018\u00010BHÆ\u0003J\f\u0010Æ\u0002\u001a\u0004\u0018\u00010DHÆ\u0003J\f\u0010Ç\u0002\u001a\u0004\u0018\u00010FHÆ\u0003J\u0012\u0010È\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\n\u0010É\u0002\u001a\u00020\u000eHÆ\u0003J\u0012\u0010Ê\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010Ë\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\f\u0010Ì\u0002\u001a\u0004\u0018\u00010LHÆ\u0003J\f\u0010Í\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Î\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ï\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ñ\u0002\u001a\u0004\u0018\u00010RHÆ\u0003J\f\u0010Ò\u0002\u001a\u0004\u0018\u00010THÆ\u0003J\u0012\u0010Ó\u0002\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010Ô\u0002\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0003\u0010\u0086\u0001J\n\u0010Õ\u0002\u001a\u00020\u000eHÆ\u0003J\n\u0010Ö\u0002\u001a\u00020\u000eHÆ\u0003J¨\u0006\u0010×\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020\u00052\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010(2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u00020\u00162\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u001c\b\u0002\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010H\u001a\u00020\u000e2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010W\u001a\u00020\u000e2\b\b\u0002\u0010X\u001a\u00020\u000eHÆ\u0001¢\u0006\u0003\u0010Ø\u0002J\u0007\u0010Ù\u0002\u001a\u00020\u000eJ\u0016\u0010Ú\u0002\u001a\u00020\u00162\n\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u0002HÖ\u0003J\n\u0010Ý\u0002\u001a\u00020\u000eHÖ\u0001J\n\u0010Þ\u0002\u001a\u00020\u0003HÖ\u0001J\u001b\u0010ß\u0002\u001a\u00030à\u00022\b\u0010á\u0002\u001a\u00030â\u00022\u0007\u0010ã\u0002\u001a\u00020\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010c\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\\\"\u0004\be\u0010^R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010^R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\\\"\u0004\bm\u0010^R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\\\"\u0004\bs\u0010^R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010u\"\u0004\by\u0010wR\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010u\"\u0004\b{\u0010wR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\\\"\u0004\b}\u0010^R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010u\"\u0004\b\u007f\u0010wR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\\\"\u0005\b\u0081\u0001\u0010^R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0085\u0001\u001a\u0005\b\u0014\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\"\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u0015\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0085\u0001\u001a\u0005\b\u0017\u0010\u0082\u0001\"\u0006\b\u008a\u0001\u0010\u0084\u0001R\"\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u0018\u0010\u0086\u0001\"\u0006\b\u008b\u0001\u0010\u0088\u0001R\"\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u0019\u0010\u0086\u0001\"\u0006\b\u008c\u0001\u0010\u0088\u0001R\"\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u001a\u0010\u0086\u0001\"\u0006\b\u008d\u0001\u0010\u0088\u0001R\"\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u001b\u0010\u0086\u0001\"\u0006\b\u008e\u0001\u0010\u0088\u0001R\"\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b\u001c\u0010\u0086\u0001\"\u0006\b\u008f\u0001\u0010\u0088\u0001R#\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0089\u0001\u001a\u0006\b\u0090\u0001\u0010\u0086\u0001\"\u0006\b\u0091\u0001\u0010\u0088\u0001R\u001c\u0010\u001e\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010u\"\u0005\b\u0093\u0001\u0010wR\u001c\u0010\u001f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010u\"\u0005\b\u0095\u0001\u0010wR\u001c\u0010 \u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010u\"\u0005\b\u0097\u0001\u0010wR#\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0085\u0001\u001a\u0006\b\u0098\u0001\u0010\u0082\u0001\"\u0006\b\u0099\u0001\u0010\u0084\u0001R\u001c\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010o\"\u0005\b\u009b\u0001\u0010qR\u001c\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010o\"\u0005\b\u009d\u0001\u0010qR\u001c\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010o\"\u0005\b\u009f\u0001\u0010qR\u001d\u0010%\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b%\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010o\"\u0005\b¤\u0001\u0010qR&\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010(X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R&\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010(X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010¦\u0001\"\u0006\bª\u0001\u0010¨\u0001R \u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\"\u0010-\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\b-\u0010\u0086\u0001\"\u0006\b¯\u0001\u0010\u0088\u0001R\u001e\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010\\\"\u0005\b±\u0001\u0010^R\u001c\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010o\"\u0005\b³\u0001\u0010qR \u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\\\"\u0005\b¹\u0001\u0010^R \u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001d\u00105\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b5\u0010 \u0001\"\u0006\b¾\u0001\u0010¢\u0001R\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010\\\"\u0005\bÀ\u0001\u0010^R#\u00107\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010Å\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R \u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R2\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`<X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R \u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R#\u0010?\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010Å\u0001\u001a\u0006\bÒ\u0001\u0010Â\u0001\"\u0006\bÓ\u0001\u0010Ä\u0001R#\u0010@\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0085\u0001\u001a\u0006\bÔ\u0001\u0010\u0082\u0001\"\u0006\bÕ\u0001\u0010\u0084\u0001R \u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R \u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R \u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\"\u0010G\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\bG\u0010\u0086\u0001\"\u0006\bâ\u0001\u0010\u0088\u0001R\u001c\u0010H\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010u\"\u0005\bä\u0001\u0010wR\"\u0010I\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0089\u0001\u001a\u0005\bI\u0010\u0086\u0001\"\u0006\bå\u0001\u0010\u0088\u0001R#\u0010J\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0085\u0001\u001a\u0006\bæ\u0001\u0010\u0082\u0001\"\u0006\bç\u0001\u0010\u0084\u0001R \u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010ë\u0001R\u001e\u0010M\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0001\u0010\\\"\u0005\bí\u0001\u0010^R\u001e\u0010N\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bî\u0001\u0010\\\"\u0005\bï\u0001\u0010^R\u001e\u0010O\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0001\u0010\\\"\u0005\bñ\u0001\u0010^R\u001e\u0010P\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bò\u0001\u0010\\\"\u0005\bó\u0001\u0010^R \u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R \u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R\"\u0010U\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0014\n\u0003\u0010\u0085\u0001\u001a\u0005\bU\u0010\u0082\u0001\"\u0006\bü\u0001\u0010\u0084\u0001R#\u0010V\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0089\u0001\u001a\u0006\bý\u0001\u0010\u0086\u0001\"\u0006\bþ\u0001\u0010\u0088\u0001R\u001c\u0010W\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0001\u0010u\"\u0005\b\u0080\u0002\u0010wR\u001c\u0010X\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0002\u0010u\"\u0005\b\u0082\u0002\u0010wR\u0015\u0010\u0084\u0002\u001a\u00030\u0085\u00028F¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0013\u0010\u0088\u0002\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b\u0089\u0002\u0010\\R\u0013\u0010\u0092\u0002\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b\u0093\u0002\u0010u¨\u0006å\u0002"}, d2 = {"Lcom/qiahao/base_common/model/common/User;", "Landroid/os/Parcelable;", "avatar", "", "birthday", "", "country", "countryIcon", "diamondNum", "", "externalId", "id", "code", "likeCount", "", "iLikeCount", "videoLikeCount", "nick", "sex", "description", "isShowAge", "isTradeUnion", "", "isPush", "isTradeUnionMatchNotification", "isAgentMgr", "isLike", "isLikeMe", "isSession", "defaultAvatar", "visitCount", "heartValue", "heartValueMax", "meetDays", "wealthUserGrade", "charmUserGrade", "activityUserGrade", "isVip", "vipExpireTime", "medals", "", "medalInfo", "Lcom/qiahao/base_common/model/common/MedalInfo;", "headwear", "Lcom/qiahao/base_common/model/common/HeadWearBean;", "isPrettyCode", "currentRoom", "myGroupPower", "ride", "Lcom/qiahao/base_common/model/common/RideBean;", "myGroupPowerName", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "isOfficialStaff", "groupId", "diamond", "phoneInfo", "Lcom/qiahao/base_common/model/common/PhoneInfo;", "thirdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "countryManager", "Lcom/qiahao/base_common/model/common/CountryManager;", "pinkDiamondNum", "groupRole", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "groupPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "cp", "Lcom/qiahao/base_common/model/cp/MyCp;", "isNew", "area", "isCountryId", "idFrameType", "mRelationData", "Lcom/qiahao/base_common/model/common/RelationUserData;", "cardEffect", "cardEffectV2", "maskAvatar", "maskNick", "chat", "Lcom/qiahao/base_common/model/common/CanChat;", "gameLevel", "Lcom/qiahao/base_common/model/common/MyGameLevel;", "isRealCertification", "hasGroupCountryManagerPower", "notRecommend", "cornerMark", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;JLjava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;IIILjava/lang/Integer;JJJZJLjava/util/List;Ljava/util/List;Lcom/qiahao/base_common/model/common/HeadWearBean;Ljava/lang/Boolean;Ljava/lang/String;JLcom/qiahao/base_common/model/common/RideBean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/NobleInfo;ZLjava/lang/String;Ljava/lang/Double;Lcom/qiahao/base_common/model/common/PhoneInfo;Ljava/util/ArrayList;Lcom/qiahao/base_common/model/common/CountryManager;Ljava/lang/Double;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/common/FamilyInfo;Lcom/qiahao/base_common/model/cp/MyCp;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/RelationUserData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/common/CanChat;Lcom/qiahao/base_common/model/common/MyGameLevel;Ljava/lang/Integer;Ljava/lang/Boolean;II)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCountry", "setCountry", "getCountryIcon", "setCountryIcon", "getDiamondNum", "()D", "setDiamondNum", "(D)V", "getExternalId", "setExternalId", "getId", "()J", "setId", "(J)V", "getCode", "setCode", "getLikeCount", "()I", "setLikeCount", "(I)V", "getILikeCount", "setILikeCount", "getVideoLikeCount", "setVideoLikeCount", "getNick", "setNick", "getSex", "setSex", "getDescription", "setDescription", "()Ljava/lang/Integer;", "setShowAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setTradeUnion", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setPush", "setTradeUnionMatchNotification", "setAgentMgr", "setLike", "setLikeMe", "setSession", "getDefaultAvatar", "setDefaultAvatar", "getVisitCount", "setVisitCount", "getHeartValue", "setHeartValue", "getHeartValueMax", "setHeartValueMax", "getMeetDays", "setMeetDays", "getWealthUserGrade", "setWealthUserGrade", "getCharmUserGrade", "setCharmUserGrade", "getActivityUserGrade", "setActivityUserGrade", "()Z", "setVip", "(Z)V", "getVipExpireTime", "setVipExpireTime", "getMedals", "()Ljava/util/List;", "setMedals", "(Ljava/util/List;)V", "getMedalInfo", "setMedalInfo", "getHeadwear", "()Lcom/qiahao/base_common/model/common/HeadWearBean;", "setHeadwear", "(Lcom/qiahao/base_common/model/common/HeadWearBean;)V", "setPrettyCode", "getCurrentRoom", "setCurrentRoom", "getMyGroupPower", "setMyGroupPower", "getRide", "()Lcom/qiahao/base_common/model/common/RideBean;", "setRide", "(Lcom/qiahao/base_common/model/common/RideBean;)V", "getMyGroupPowerName", "setMyGroupPowerName", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "setOfficialStaff", "getGroupId", "setGroupId", "getDiamond", "()Ljava/lang/Double;", "setDiamond", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPhoneInfo", "()Lcom/qiahao/base_common/model/common/PhoneInfo;", "setPhoneInfo", "(Lcom/qiahao/base_common/model/common/PhoneInfo;)V", "getThirdList", "()Ljava/util/ArrayList;", "setThirdList", "(Ljava/util/ArrayList;)V", "getCountryManager", "()Lcom/qiahao/base_common/model/common/CountryManager;", "setCountryManager", "(Lcom/qiahao/base_common/model/common/CountryManager;)V", "getPinkDiamondNum", "setPinkDiamondNum", "getGroupRole", "setGroupRole", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getGroupPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setGroupPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getCp", "()Lcom/qiahao/base_common/model/cp/MyCp;", "setCp", "(Lcom/qiahao/base_common/model/cp/MyCp;)V", "setNew", "getArea", "setArea", "setCountryId", "getIdFrameType", "setIdFrameType", "getMRelationData", "()Lcom/qiahao/base_common/model/common/RelationUserData;", "setMRelationData", "(Lcom/qiahao/base_common/model/common/RelationUserData;)V", "getCardEffect", "setCardEffect", "getCardEffectV2", "setCardEffectV2", "getMaskAvatar", "setMaskAvatar", "getMaskNick", "setMaskNick", "getChat", "()Lcom/qiahao/base_common/model/common/CanChat;", "setChat", "(Lcom/qiahao/base_common/model/common/CanChat;)V", "getGameLevel", "()Lcom/qiahao/base_common/model/common/MyGameLevel;", "setGameLevel", "(Lcom/qiahao/base_common/model/common/MyGameLevel;)V", "setRealCertification", "getHasGroupCountryManagerPower", "setHasGroupCountryManagerPower", "getNotRecommend", "setNotRecommend", "getCornerMark", "setCornerMark", "isCompleteMaterial", "countryInfo", "Lcom/qiahao/base_common/model/common/Country;", "getCountryInfo", "()Lcom/qiahao/base_common/model/common/Country;", "age", "getAge", "getSmallAvatar", "checkLevelMoreThree", "checkNotOfficialStaff", "isAr", "checkCP", "getCP", "Lcom/qiahao/base_common/model/common/Special;", "getOtherRelation", "heartPer", "getHeartPer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;JLjava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;IIILjava/lang/Integer;JJJZJLjava/util/List;Ljava/util/List;Lcom/qiahao/base_common/model/common/HeadWearBean;Ljava/lang/Boolean;Ljava/lang/String;JLcom/qiahao/base_common/model/common/RideBean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/NobleInfo;ZLjava/lang/String;Ljava/lang/Double;Lcom/qiahao/base_common/model/common/PhoneInfo;Ljava/util/ArrayList;Lcom/qiahao/base_common/model/common/CountryManager;Ljava/lang/Double;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/common/FamilyInfo;Lcom/qiahao/base_common/model/cp/MyCp;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/RelationUserData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/common/CanChat;Lcom/qiahao/base_common/model/common/MyGameLevel;Ljava/lang/Integer;Ljava/lang/Boolean;II)Lcom/qiahao/base_common/model/common/User;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 User.kt\ncom/qiahao/base_common/model/common/User\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n1869#2,2:215\n*S KotlinDebug\n*F\n+ 1 User.kt\ncom/qiahao/base_common/model/common/User\n*L\n196#1:215,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class User implements Parcelable {
    private long activityUserGrade;
    private int area;

    @Nullable
    private String avatar;

    @Nullable
    private Long birthday;

    @Nullable
    private String cardEffect;

    @Nullable
    private String cardEffectV2;
    private long charmUserGrade;

    @Nullable
    private CanChat chat;

    @NotNull
    private String code;
    private int cornerMark;

    @Nullable
    private String country;

    @Nullable
    private String countryIcon;

    @Nullable
    private CountryManager countryManager;

    @Nullable
    private MyCp cp;

    @Nullable
    private String currentRoom;

    @Nullable
    private Boolean defaultAvatar;

    @Nullable
    private String description;

    @Nullable
    private Double diamond;
    private double diamondNum;

    @NotNull
    private String externalId;

    @Nullable
    private MyGameLevel gameLevel;

    @Nullable
    private String groupId;

    @Nullable
    private FamilyInfo groupPower;

    @Nullable
    private Integer groupRole;

    @Nullable
    private Boolean hasGroupCountryManagerPower;

    @Nullable
    private HeadWearBean headwear;
    private int heartValue;
    private int heartValueMax;
    private int iLikeCount;
    private long id;

    @Nullable
    private Integer idFrameType;

    @Nullable
    private Boolean isAgentMgr;

    @Nullable
    private Boolean isCountryId;

    @Nullable
    private Boolean isLike;

    @Nullable
    private Boolean isLikeMe;

    @Nullable
    private Boolean isNew;
    private boolean isOfficialStaff;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private Integer isPush;

    @Nullable
    private Integer isRealCertification;

    @Nullable
    private Boolean isSession;

    @Nullable
    private Integer isShowAge;

    @Nullable
    private Boolean isTradeUnion;

    @Nullable
    private Boolean isTradeUnionMatchNotification;
    private boolean isVip;
    private int likeCount;

    @Nullable
    private RelationUserData mRelationData;

    @Nullable
    private String maskAvatar;

    @Nullable
    private String maskNick;

    @Nullable
    private List<MedalInfo> medalInfo;

    @Nullable
    private List<Integer> medals;

    @Nullable
    private Integer meetDays;
    private long myGroupPower;

    @Nullable
    private String myGroupPowerName;

    @Nullable
    private String nick;

    @Nullable
    private NobleInfo noble;
    private int notRecommend;

    @Nullable
    private PhoneInfo phoneInfo;

    @Nullable
    private Double pinkDiamondNum;

    @Nullable
    private RideBean ride;
    private int sex;

    @Nullable
    private SvipData svip;

    @Nullable
    private ArrayList<Integer> thirdList;
    private int videoLikeCount;
    private long vipExpireTime;
    private int visitCount;
    private long wealthUserGrade;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<User> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/model/common/User$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/base_common/model/common/User;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final User fake() {
            Country fake = Country.INSTANCE.fake();
            Long valueOf = Long.valueOf(DateTimeUtilityKt.currentTimeSecs());
            String name = fake.getName();
            String icon = fake.getIcon();
            IntRange intRange = new IntRange(15200000, 153000000);
            Random.Companion companion = Random.INSTANCE;
            return new User("", valueOf, name, icon, RangesKt.random(intRange, companion), String.valueOf(RangesKt.random(new IntRange(100000, 999999), companion)), 0L, String.valueOf(System.currentTimeMillis()), RangesKt.random(new IntRange(100000, 999999), companion), 0, 0, "name", RangesKt.random(new IntRange(1, 2), companion), "description", Integer.valueOf(RangesKt.random(new IntRange(0, 1), companion)), null, null, null, null, null, null, null, null, RangesKt.random(new IntRange(100000, 999999), companion), ((Number) CollectionsKt.random(CollectionsKt.listOf((Object[]) new Integer[]{0, 25, 50, 75, 100}), companion)).intValue(), 100, null, 0L, 0L, 0L, false, 0L, null, null, null, null, null, 0L, new RideBean(0, "", "", false, 0, null, null, null, null, null, 1016, null), null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, 0, 0, -58915264, -65, 7, null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<User> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final User createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Boolean valueOf6;
            Boolean valueOf7;
            Boolean bool;
            ArrayList arrayList;
            int i10;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Boolean valueOf8;
            ArrayList arrayList4;
            ArrayList arrayList5;
            Boolean valueOf9;
            Boolean valueOf10;
            Boolean valueOf11;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Long valueOf12 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            double readDouble = parcel.readDouble();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            String readString6 = parcel.readString();
            int readInt4 = parcel.readInt();
            String readString7 = parcel.readString();
            Integer valueOf13 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Integer valueOf14 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf6 = null;
            } else {
                valueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf7 = null;
            } else {
                valueOf7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            int readInt7 = parcel.readInt();
            Integer valueOf15 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            long readLong4 = parcel.readLong();
            boolean z10 = parcel.readInt() != 0;
            long readLong5 = parcel.readLong();
            if (parcel.readInt() == 0) {
                bool = valueOf;
                i10 = readInt3;
                arrayList = null;
            } else {
                int readInt8 = parcel.readInt();
                bool = valueOf;
                arrayList = new ArrayList(readInt8);
                i10 = readInt3;
                int i11 = 0;
                while (i11 != readInt8) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    i11++;
                    readInt8 = readInt8;
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = arrayList;
                arrayList3 = null;
            } else {
                int readInt9 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(readInt9);
                arrayList2 = arrayList;
                int i12 = 0;
                while (i12 != readInt9) {
                    arrayList6.add(MedalInfo.CREATOR.createFromParcel(parcel));
                    i12++;
                    readInt9 = readInt9;
                }
                arrayList3 = arrayList6;
            }
            HeadWearBean createFromParcel = parcel.readInt() == 0 ? null : HeadWearBean.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                valueOf8 = null;
            } else {
                valueOf8 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString8 = parcel.readString();
            long readLong6 = parcel.readLong();
            RideBean createFromParcel2 = parcel.readInt() == 0 ? null : RideBean.CREATOR.createFromParcel(parcel);
            String readString9 = parcel.readString();
            NobleInfo createFromParcel3 = parcel.readInt() == 0 ? null : NobleInfo.CREATOR.createFromParcel(parcel);
            boolean z11 = parcel.readInt() != 0;
            String readString10 = parcel.readString();
            Double valueOf16 = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            PhoneInfo createFromParcel4 = parcel.readInt() == 0 ? null : PhoneInfo.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList4 = arrayList3;
                arrayList5 = null;
            } else {
                int readInt10 = parcel.readInt();
                ArrayList arrayList7 = new ArrayList(readInt10);
                arrayList4 = arrayList3;
                int i13 = 0;
                while (i13 != readInt10) {
                    arrayList7.add(Integer.valueOf(parcel.readInt()));
                    i13++;
                    readInt10 = readInt10;
                }
                arrayList5 = arrayList7;
            }
            CountryManager createFromParcel5 = parcel.readInt() == 0 ? null : CountryManager.CREATOR.createFromParcel(parcel);
            Double valueOf17 = parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble());
            Integer valueOf18 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            SvipData createFromParcel6 = parcel.readInt() == 0 ? null : SvipData.CREATOR.createFromParcel(parcel);
            FamilyInfo createFromParcel7 = parcel.readInt() == 0 ? null : FamilyInfo.CREATOR.createFromParcel(parcel);
            MyCp createFromParcel8 = parcel.readInt() == 0 ? null : MyCp.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                valueOf9 = null;
            } else {
                valueOf9 = Boolean.valueOf(parcel.readInt() != 0);
            }
            int readInt11 = parcel.readInt();
            if (parcel.readInt() == 0) {
                valueOf10 = null;
            } else {
                valueOf10 = Boolean.valueOf(parcel.readInt() != 0);
            }
            Integer valueOf19 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            RelationUserData createFromParcel9 = parcel.readInt() == 0 ? null : RelationUserData.CREATOR.createFromParcel(parcel);
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            CanChat createFromParcel10 = parcel.readInt() == 0 ? null : CanChat.CREATOR.createFromParcel(parcel);
            MyGameLevel createFromParcel11 = parcel.readInt() == 0 ? null : MyGameLevel.CREATOR.createFromParcel(parcel);
            Integer valueOf20 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf11 = null;
            } else {
                valueOf11 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new User(readString, valueOf12, readString2, readString3, readDouble, readString4, readLong, readString5, readInt, readInt2, i10, readString6, readInt4, readString7, valueOf13, bool, valueOf14, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, readInt5, readInt6, readInt7, valueOf15, readLong2, readLong3, readLong4, z10, readLong5, arrayList2, arrayList4, createFromParcel, valueOf8, readString8, readLong6, createFromParcel2, readString9, createFromParcel3, z11, readString10, valueOf16, createFromParcel4, arrayList5, createFromParcel5, valueOf17, valueOf18, createFromParcel6, createFromParcel7, createFromParcel8, valueOf9, readInt11, valueOf10, valueOf19, createFromParcel9, readString11, readString12, readString13, readString14, createFromParcel10, createFromParcel11, valueOf20, valueOf11, parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final User[] newArray(int i10) {
            return new User[i10];
        }
    }

    public User(@Nullable String str, @Nullable Long l10, @Nullable String str2, @Nullable String str3, double d10, @NotNull String externalId, long j10, @NotNull String code, int i10, int i11, int i12, @Nullable String str4, int i13, @Nullable String str5, @Nullable Integer num, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, int i14, int i15, int i16, @Nullable Integer num3, long j11, long j12, long j13, boolean z10, long j14, @Nullable List<Integer> list, @Nullable List<MedalInfo> list2, @Nullable HeadWearBean headWearBean, @Nullable Boolean bool8, @Nullable String str6, long j15, @Nullable RideBean rideBean, @Nullable String str7, @Nullable NobleInfo nobleInfo, boolean z11, @Nullable String str8, @Nullable Double d11, @Nullable PhoneInfo phoneInfo, @Nullable ArrayList<Integer> arrayList, @Nullable CountryManager countryManager, @Nullable Double d12, @Nullable Integer num4, @Nullable SvipData svipData, @Nullable FamilyInfo familyInfo, @Nullable MyCp myCp, @Nullable Boolean bool9, int i17, @Nullable Boolean bool10, @Nullable Integer num5, @Nullable RelationUserData relationUserData, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable CanChat canChat, @Nullable MyGameLevel myGameLevel, @Nullable Integer num6, @Nullable Boolean bool11, int i18, int i19) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(code, "code");
        this.avatar = str;
        this.birthday = l10;
        this.country = str2;
        this.countryIcon = str3;
        this.diamondNum = d10;
        this.externalId = externalId;
        this.id = j10;
        this.code = code;
        this.likeCount = i10;
        this.iLikeCount = i11;
        this.videoLikeCount = i12;
        this.nick = str4;
        this.sex = i13;
        this.description = str5;
        this.isShowAge = num;
        this.isTradeUnion = bool;
        this.isPush = num2;
        this.isTradeUnionMatchNotification = bool2;
        this.isAgentMgr = bool3;
        this.isLike = bool4;
        this.isLikeMe = bool5;
        this.isSession = bool6;
        this.defaultAvatar = bool7;
        this.visitCount = i14;
        this.heartValue = i15;
        this.heartValueMax = i16;
        this.meetDays = num3;
        this.wealthUserGrade = j11;
        this.charmUserGrade = j12;
        this.activityUserGrade = j13;
        this.isVip = z10;
        this.vipExpireTime = j14;
        this.medals = list;
        this.medalInfo = list2;
        this.headwear = headWearBean;
        this.isPrettyCode = bool8;
        this.currentRoom = str6;
        this.myGroupPower = j15;
        this.ride = rideBean;
        this.myGroupPowerName = str7;
        this.noble = nobleInfo;
        this.isOfficialStaff = z11;
        this.groupId = str8;
        this.diamond = d11;
        this.phoneInfo = phoneInfo;
        this.thirdList = arrayList;
        this.countryManager = countryManager;
        this.pinkDiamondNum = d12;
        this.groupRole = num4;
        this.svip = svipData;
        this.groupPower = familyInfo;
        this.cp = myCp;
        this.isNew = bool9;
        this.area = i17;
        this.isCountryId = bool10;
        this.idFrameType = num5;
        this.mRelationData = relationUserData;
        this.cardEffect = str9;
        this.cardEffectV2 = str10;
        this.maskAvatar = str11;
        this.maskNick = str12;
        this.chat = canChat;
        this.gameLevel = myGameLevel;
        this.isRealCertification = num6;
        this.hasGroupCountryManagerPower = bool11;
        this.notRecommend = i18;
        this.cornerMark = i19;
    }

    public static /* synthetic */ User copy$default(User user, String str, Long l10, String str2, String str3, double d10, String str4, long j10, String str5, int i10, int i11, int i12, String str6, int i13, String str7, Integer num, Boolean bool, Integer num2, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i14, int i15, int i16, Integer num3, long j11, long j12, long j13, boolean z10, long j14, List list, List list2, HeadWearBean headWearBean, Boolean bool8, String str8, long j15, RideBean rideBean, String str9, NobleInfo nobleInfo, boolean z11, String str10, Double d11, PhoneInfo phoneInfo, ArrayList arrayList, CountryManager countryManager, Double d12, Integer num4, SvipData svipData, FamilyInfo familyInfo, MyCp myCp, Boolean bool9, int i17, Boolean bool10, Integer num5, RelationUserData relationUserData, String str11, String str12, String str13, String str14, CanChat canChat, MyGameLevel myGameLevel, Integer num6, Boolean bool11, int i18, int i19, int i20, int i21, int i22, Object obj) {
        String str15 = (i20 & 1) != 0 ? user.avatar : str;
        Long l11 = (i20 & 2) != 0 ? user.birthday : l10;
        String str16 = (i20 & 4) != 0 ? user.country : str2;
        String str17 = (i20 & 8) != 0 ? user.countryIcon : str3;
        double d13 = (i20 & 16) != 0 ? user.diamondNum : d10;
        String str18 = (i20 & 32) != 0 ? user.externalId : str4;
        long j16 = (i20 & 64) != 0 ? user.id : j10;
        String str19 = (i20 & 128) != 0 ? user.code : str5;
        int i23 = (i20 & 256) != 0 ? user.likeCount : i10;
        int i24 = (i20 & 512) != 0 ? user.iLikeCount : i11;
        return user.copy(str15, l11, str16, str17, d13, str18, j16, str19, i23, i24, (i20 & 1024) != 0 ? user.videoLikeCount : i12, (i20 & 2048) != 0 ? user.nick : str6, (i20 & 4096) != 0 ? user.sex : i13, (i20 & 8192) != 0 ? user.description : str7, (i20 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? user.isShowAge : num, (i20 & 32768) != 0 ? user.isTradeUnion : bool, (i20 & 65536) != 0 ? user.isPush : num2, (i20 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? user.isTradeUnionMatchNotification : bool2, (i20 & 262144) != 0 ? user.isAgentMgr : bool3, (i20 & a.MAX_POOL_SIZE) != 0 ? user.isLike : bool4, (i20 & Constants.MB) != 0 ? user.isLikeMe : bool5, (i20 & 2097152) != 0 ? user.isSession : bool6, (i20 & 4194304) != 0 ? user.defaultAvatar : bool7, (i20 & 8388608) != 0 ? user.visitCount : i14, (i20 & 16777216) != 0 ? user.heartValue : i15, (i20 & 33554432) != 0 ? user.heartValueMax : i16, (i20 & 67108864) != 0 ? user.meetDays : num3, (i20 & 134217728) != 0 ? user.wealthUserGrade : j11, (i20 & 268435456) != 0 ? user.charmUserGrade : j12, (i20 & 536870912) != 0 ? user.activityUserGrade : j13, (i20 & 1073741824) != 0 ? user.isVip : z10, (i20 & Integer.MIN_VALUE) != 0 ? user.vipExpireTime : j14, (i21 & 1) != 0 ? user.medals : list, (i21 & 2) != 0 ? user.medalInfo : list2, (i21 & 4) != 0 ? user.headwear : headWearBean, (i21 & 8) != 0 ? user.isPrettyCode : bool8, (i21 & 16) != 0 ? user.currentRoom : str8, (i21 & 32) != 0 ? user.myGroupPower : j15, (i21 & 64) != 0 ? user.ride : rideBean, (i21 & 128) != 0 ? user.myGroupPowerName : str9, (i21 & 256) != 0 ? user.noble : nobleInfo, (i21 & 512) != 0 ? user.isOfficialStaff : z11, (i21 & 1024) != 0 ? user.groupId : str10, (i21 & 2048) != 0 ? user.diamond : d11, (i21 & 4096) != 0 ? user.phoneInfo : phoneInfo, (i21 & 8192) != 0 ? user.thirdList : arrayList, (i21 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? user.countryManager : countryManager, (i21 & 32768) != 0 ? user.pinkDiamondNum : d12, (i21 & 65536) != 0 ? user.groupRole : num4, (i21 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? user.svip : svipData, (i21 & 262144) != 0 ? user.groupPower : familyInfo, (i21 & a.MAX_POOL_SIZE) != 0 ? user.cp : myCp, (i21 & Constants.MB) != 0 ? user.isNew : bool9, (i21 & 2097152) != 0 ? user.area : i17, (i21 & 4194304) != 0 ? user.isCountryId : bool10, (i21 & 8388608) != 0 ? user.idFrameType : num5, (i21 & 16777216) != 0 ? user.mRelationData : relationUserData, (i21 & 33554432) != 0 ? user.cardEffect : str11, (i21 & 67108864) != 0 ? user.cardEffectV2 : str12, (i21 & 134217728) != 0 ? user.maskAvatar : str13, (i21 & 268435456) != 0 ? user.maskNick : str14, (i21 & 536870912) != 0 ? user.chat : canChat, (i21 & 1073741824) != 0 ? user.gameLevel : myGameLevel, (i21 & Integer.MIN_VALUE) != 0 ? user.isRealCertification : num6, (i22 & 1) != 0 ? user.hasGroupCountryManagerPower : bool11, (i22 & 2) != 0 ? user.notRecommend : i18, (i22 & 4) != 0 ? user.cornerMark : i19);
    }

    public final boolean checkCP() {
        ArrayList<Special> arrayList;
        int i10;
        int i11;
        ArrayList<Special> specialList;
        Special special;
        Integer type;
        ArrayList<Special> specialList2;
        RelationUserData relationUserData = this.mRelationData;
        if (relationUserData != null) {
            arrayList = relationUserData.getSpecialList();
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return false;
        }
        RelationUserData relationUserData2 = this.mRelationData;
        if (relationUserData2 != null && (specialList2 = relationUserData2.getSpecialList()) != null) {
            i10 = specialList2.size();
        } else {
            i10 = 0;
        }
        if (i10 <= 0) {
            return false;
        }
        RelationUserData relationUserData3 = this.mRelationData;
        if (relationUserData3 != null && (specialList = relationUserData3.getSpecialList()) != null && (special = specialList.get(0)) != null && (type = special.getType()) != null) {
            i11 = type.intValue();
        } else {
            i11 = 0;
        }
        if (i11 != 1) {
            return false;
        }
        return true;
    }

    public final boolean checkLevelMoreThree() {
        if (this.activityUserGrade < 3 && this.charmUserGrade < 3 && this.wealthUserGrade < 3) {
            return false;
        }
        return true;
    }

    public final boolean checkNotOfficialStaff() {
        return !this.isOfficialStaff;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component10, reason: from getter */
    public final int getILikeCount() {
        return this.iLikeCount;
    }

    /* renamed from: component11, reason: from getter */
    public final int getVideoLikeCount() {
        return this.videoLikeCount;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component13, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Boolean getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getIsPush() {
        return this.isPush;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Boolean getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Boolean getIsAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Boolean getIsSession() {
        return this.isSession;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    /* renamed from: component24, reason: from getter */
    public final int getVisitCount() {
        return this.visitCount;
    }

    /* renamed from: component25, reason: from getter */
    public final int getHeartValue() {
        return this.heartValue;
    }

    /* renamed from: component26, reason: from getter */
    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final Integer getMeetDays() {
        return this.meetDays;
    }

    /* renamed from: component28, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component29, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component30, reason: from getter */
    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    /* renamed from: component31, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component32, reason: from getter */
    public final long getVipExpireTime() {
        return this.vipExpireTime;
    }

    @Nullable
    public final List<Integer> component33() {
        return this.medals;
    }

    @Nullable
    public final List<MedalInfo> component34() {
        return this.medalInfo;
    }

    @Nullable
    /* renamed from: component35, reason: from getter */
    public final HeadWearBean getHeadwear() {
        return this.headwear;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    /* renamed from: component38, reason: from getter */
    public final long getMyGroupPower() {
        return this.myGroupPower;
    }

    @Nullable
    /* renamed from: component39, reason: from getter */
    public final RideBean getRide() {
        return this.ride;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component40, reason: from getter */
    public final String getMyGroupPowerName() {
        return this.myGroupPowerName;
    }

    @Nullable
    /* renamed from: component41, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    /* renamed from: component42, reason: from getter */
    public final boolean getIsOfficialStaff() {
        return this.isOfficialStaff;
    }

    @Nullable
    /* renamed from: component43, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component44, reason: from getter */
    public final Double getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component45, reason: from getter */
    public final PhoneInfo getPhoneInfo() {
        return this.phoneInfo;
    }

    @Nullable
    public final ArrayList<Integer> component46() {
        return this.thirdList;
    }

    @Nullable
    /* renamed from: component47, reason: from getter */
    public final CountryManager getCountryManager() {
        return this.countryManager;
    }

    @Nullable
    /* renamed from: component48, reason: from getter */
    public final Double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    @Nullable
    /* renamed from: component49, reason: from getter */
    public final Integer getGroupRole() {
        return this.groupRole;
    }

    /* renamed from: component5, reason: from getter */
    public final double getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component50, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component51, reason: from getter */
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @Nullable
    /* renamed from: component52, reason: from getter */
    public final MyCp getCp() {
        return this.cp;
    }

    @Nullable
    /* renamed from: component53, reason: from getter */
    public final Boolean getIsNew() {
        return this.isNew;
    }

    /* renamed from: component54, reason: from getter */
    public final int getArea() {
        return this.area;
    }

    @Nullable
    /* renamed from: component55, reason: from getter */
    public final Boolean getIsCountryId() {
        return this.isCountryId;
    }

    @Nullable
    /* renamed from: component56, reason: from getter */
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    @Nullable
    /* renamed from: component57, reason: from getter */
    public final RelationUserData getMRelationData() {
        return this.mRelationData;
    }

    @Nullable
    /* renamed from: component58, reason: from getter */
    public final String getCardEffect() {
        return this.cardEffect;
    }

    @Nullable
    /* renamed from: component59, reason: from getter */
    public final String getCardEffectV2() {
        return this.cardEffectV2;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component60, reason: from getter */
    public final String getMaskAvatar() {
        return this.maskAvatar;
    }

    @Nullable
    /* renamed from: component61, reason: from getter */
    public final String getMaskNick() {
        return this.maskNick;
    }

    @Nullable
    /* renamed from: component62, reason: from getter */
    public final CanChat getChat() {
        return this.chat;
    }

    @Nullable
    /* renamed from: component63, reason: from getter */
    public final MyGameLevel getGameLevel() {
        return this.gameLevel;
    }

    @Nullable
    /* renamed from: component64, reason: from getter */
    public final Integer getIsRealCertification() {
        return this.isRealCertification;
    }

    @Nullable
    /* renamed from: component65, reason: from getter */
    public final Boolean getHasGroupCountryManagerPower() {
        return this.hasGroupCountryManagerPower;
    }

    /* renamed from: component66, reason: from getter */
    public final int getNotRecommend() {
        return this.notRecommend;
    }

    /* renamed from: component67, reason: from getter */
    public final int getCornerMark() {
        return this.cornerMark;
    }

    /* renamed from: component7, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final User copy(@Nullable String avatar, @Nullable Long birthday, @Nullable String country, @Nullable String countryIcon, double diamondNum, @NotNull String externalId, long id, @NotNull String code, int likeCount, int iLikeCount, int videoLikeCount, @Nullable String nick, int sex, @Nullable String description, @Nullable Integer isShowAge, @Nullable Boolean isTradeUnion, @Nullable Integer isPush, @Nullable Boolean isTradeUnionMatchNotification, @Nullable Boolean isAgentMgr, @Nullable Boolean isLike, @Nullable Boolean isLikeMe, @Nullable Boolean isSession, @Nullable Boolean defaultAvatar, int visitCount, int heartValue, int heartValueMax, @Nullable Integer meetDays, long wealthUserGrade, long charmUserGrade, long activityUserGrade, boolean isVip, long vipExpireTime, @Nullable List<Integer> medals, @Nullable List<MedalInfo> medalInfo, @Nullable HeadWearBean headwear, @Nullable Boolean isPrettyCode, @Nullable String currentRoom, long myGroupPower, @Nullable RideBean ride, @Nullable String myGroupPowerName, @Nullable NobleInfo noble, boolean isOfficialStaff, @Nullable String groupId, @Nullable Double diamond, @Nullable PhoneInfo phoneInfo, @Nullable ArrayList<Integer> thirdList, @Nullable CountryManager countryManager, @Nullable Double pinkDiamondNum, @Nullable Integer groupRole, @Nullable SvipData svip, @Nullable FamilyInfo groupPower, @Nullable MyCp cp, @Nullable Boolean isNew, int area, @Nullable Boolean isCountryId, @Nullable Integer idFrameType, @Nullable RelationUserData mRelationData, @Nullable String cardEffect, @Nullable String cardEffectV2, @Nullable String maskAvatar, @Nullable String maskNick, @Nullable CanChat chat, @Nullable MyGameLevel gameLevel, @Nullable Integer isRealCertification, @Nullable Boolean hasGroupCountryManagerPower, int notRecommend, int cornerMark) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        Intrinsics.checkNotNullParameter(code, "code");
        return new User(avatar, birthday, country, countryIcon, diamondNum, externalId, id, code, likeCount, iLikeCount, videoLikeCount, nick, sex, description, isShowAge, isTradeUnion, isPush, isTradeUnionMatchNotification, isAgentMgr, isLike, isLikeMe, isSession, defaultAvatar, visitCount, heartValue, heartValueMax, meetDays, wealthUserGrade, charmUserGrade, activityUserGrade, isVip, vipExpireTime, medals, medalInfo, headwear, isPrettyCode, currentRoom, myGroupPower, ride, myGroupPowerName, noble, isOfficialStaff, groupId, diamond, phoneInfo, thirdList, countryManager, pinkDiamondNum, groupRole, svip, groupPower, cp, isNew, area, isCountryId, idFrameType, mRelationData, cardEffect, cardEffectV2, maskAvatar, maskNick, chat, gameLevel, isRealCertification, hasGroupCountryManagerPower, notRecommend, cornerMark);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.avatar, user.avatar) && Intrinsics.areEqual(this.birthday, user.birthday) && Intrinsics.areEqual(this.country, user.country) && Intrinsics.areEqual(this.countryIcon, user.countryIcon) && Double.compare(this.diamondNum, user.diamondNum) == 0 && Intrinsics.areEqual(this.externalId, user.externalId) && this.id == user.id && Intrinsics.areEqual(this.code, user.code) && this.likeCount == user.likeCount && this.iLikeCount == user.iLikeCount && this.videoLikeCount == user.videoLikeCount && Intrinsics.areEqual(this.nick, user.nick) && this.sex == user.sex && Intrinsics.areEqual(this.description, user.description) && Intrinsics.areEqual(this.isShowAge, user.isShowAge) && Intrinsics.areEqual(this.isTradeUnion, user.isTradeUnion) && Intrinsics.areEqual(this.isPush, user.isPush) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, user.isTradeUnionMatchNotification) && Intrinsics.areEqual(this.isAgentMgr, user.isAgentMgr) && Intrinsics.areEqual(this.isLike, user.isLike) && Intrinsics.areEqual(this.isLikeMe, user.isLikeMe) && Intrinsics.areEqual(this.isSession, user.isSession) && Intrinsics.areEqual(this.defaultAvatar, user.defaultAvatar) && this.visitCount == user.visitCount && this.heartValue == user.heartValue && this.heartValueMax == user.heartValueMax && Intrinsics.areEqual(this.meetDays, user.meetDays) && this.wealthUserGrade == user.wealthUserGrade && this.charmUserGrade == user.charmUserGrade && this.activityUserGrade == user.activityUserGrade && this.isVip == user.isVip && this.vipExpireTime == user.vipExpireTime && Intrinsics.areEqual(this.medals, user.medals) && Intrinsics.areEqual(this.medalInfo, user.medalInfo) && Intrinsics.areEqual(this.headwear, user.headwear) && Intrinsics.areEqual(this.isPrettyCode, user.isPrettyCode) && Intrinsics.areEqual(this.currentRoom, user.currentRoom) && this.myGroupPower == user.myGroupPower && Intrinsics.areEqual(this.ride, user.ride) && Intrinsics.areEqual(this.myGroupPowerName, user.myGroupPowerName) && Intrinsics.areEqual(this.noble, user.noble) && this.isOfficialStaff == user.isOfficialStaff && Intrinsics.areEqual(this.groupId, user.groupId) && Intrinsics.areEqual((Object) this.diamond, (Object) user.diamond) && Intrinsics.areEqual(this.phoneInfo, user.phoneInfo) && Intrinsics.areEqual(this.thirdList, user.thirdList) && Intrinsics.areEqual(this.countryManager, user.countryManager) && Intrinsics.areEqual((Object) this.pinkDiamondNum, (Object) user.pinkDiamondNum) && Intrinsics.areEqual(this.groupRole, user.groupRole) && Intrinsics.areEqual(this.svip, user.svip) && Intrinsics.areEqual(this.groupPower, user.groupPower) && Intrinsics.areEqual(this.cp, user.cp) && Intrinsics.areEqual(this.isNew, user.isNew) && this.area == user.area && Intrinsics.areEqual(this.isCountryId, user.isCountryId) && Intrinsics.areEqual(this.idFrameType, user.idFrameType) && Intrinsics.areEqual(this.mRelationData, user.mRelationData) && Intrinsics.areEqual(this.cardEffect, user.cardEffect) && Intrinsics.areEqual(this.cardEffectV2, user.cardEffectV2) && Intrinsics.areEqual(this.maskAvatar, user.maskAvatar) && Intrinsics.areEqual(this.maskNick, user.maskNick) && Intrinsics.areEqual(this.chat, user.chat) && Intrinsics.areEqual(this.gameLevel, user.gameLevel) && Intrinsics.areEqual(this.isRealCertification, user.isRealCertification) && Intrinsics.areEqual(this.hasGroupCountryManagerPower, user.hasGroupCountryManagerPower) && this.notRecommend == user.notRecommend && this.cornerMark == user.cornerMark;
    }

    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @NotNull
    public final String getAge() {
        long j10;
        long j11;
        Long l10 = this.birthday;
        long j12 = 0;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = 0;
        }
        if (j10 <= 0) {
            return "";
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Long l11 = this.birthday;
        if (l11 != null) {
            j11 = l11.longValue();
        } else {
            j11 = 0;
        }
        calendar.setTimeInMillis(j11 * 1000);
        Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j12 = service.getServerTime();
        }
        calendar2.setTimeInMillis(j12 * 1000);
        int i10 = calendar2.get(1) - calendar.get(1);
        if (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) {
            i10--;
        }
        return String.valueOf(i10);
    }

    public final int getArea() {
        return this.area;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final Special getCP() {
        ArrayList<Special> arrayList;
        int i10;
        int i11;
        RelationUserData relationUserData;
        ArrayList<Special> specialList;
        ArrayList<Special> specialList2;
        Special special;
        Integer type;
        ArrayList<Special> specialList3;
        RelationUserData relationUserData2 = this.mRelationData;
        if (relationUserData2 != null) {
            arrayList = relationUserData2.getSpecialList();
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        RelationUserData relationUserData3 = this.mRelationData;
        if (relationUserData3 != null && (specialList3 = relationUserData3.getSpecialList()) != null) {
            i10 = specialList3.size();
        } else {
            i10 = 0;
        }
        if (i10 <= 0) {
            return null;
        }
        RelationUserData relationUserData4 = this.mRelationData;
        if (relationUserData4 != null && (specialList2 = relationUserData4.getSpecialList()) != null && (special = specialList2.get(0)) != null && (type = special.getType()) != null) {
            i11 = type.intValue();
        } else {
            i11 = 0;
        }
        if (i11 != 1 || (relationUserData = this.mRelationData) == null || (specialList = relationUserData.getSpecialList()) == null) {
            return null;
        }
        return specialList.get(0);
    }

    @Nullable
    public final String getCardEffect() {
        return this.cardEffect;
    }

    @Nullable
    public final String getCardEffectV2() {
        return this.cardEffectV2;
    }

    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @Nullable
    public final CanChat getChat() {
        return this.chat;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    public final Country getCountryInfo() {
        String str;
        String str2;
        String str3;
        String str4 = this.country;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        String str5 = this.countryIcon;
        if (str5 == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        return new Country(str, str3, str2, 0L, null, null, 56, null);
    }

    @Nullable
    public final CountryManager getCountryManager() {
        return this.countryManager;
    }

    @Nullable
    public final MyCp getCp() {
        return this.cp;
    }

    @Nullable
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    @Nullable
    public final Boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Double getDiamond() {
        return this.diamond;
    }

    public final double getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final MyGameLevel getGameLevel() {
        return this.gameLevel;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @Nullable
    public final Integer getGroupRole() {
        return this.groupRole;
    }

    @Nullable
    public final Boolean getHasGroupCountryManagerPower() {
        return this.hasGroupCountryManagerPower;
    }

    @Nullable
    public final HeadWearBean getHeadwear() {
        return this.headwear;
    }

    public final int getHeartPer() {
        int i10;
        Boolean bool = this.isLike;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) && Intrinsics.areEqual(this.isLikeMe, bool2) && (i10 = this.heartValueMax) > 0) {
            return (int) ((this.heartValue / i10) * 100.0f);
        }
        return -1;
    }

    public final int getHeartValue() {
        return this.heartValue;
    }

    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    public final int getILikeCount() {
        return this.iLikeCount;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final RelationUserData getMRelationData() {
        return this.mRelationData;
    }

    @Nullable
    public final String getMaskAvatar() {
        return this.maskAvatar;
    }

    @Nullable
    public final String getMaskNick() {
        return this.maskNick;
    }

    @Nullable
    public final List<MedalInfo> getMedalInfo() {
        return this.medalInfo;
    }

    @Nullable
    public final List<Integer> getMedals() {
        return this.medals;
    }

    @Nullable
    public final Integer getMeetDays() {
        return this.meetDays;
    }

    public final long getMyGroupPower() {
        return this.myGroupPower;
    }

    @Nullable
    public final String getMyGroupPowerName() {
        return this.myGroupPowerName;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getNotRecommend() {
        return this.notRecommend;
    }

    @NotNull
    public final ArrayList<Special> getOtherRelation() {
        ArrayList<Special> specialList;
        ArrayList<Special> arrayList = new ArrayList<>();
        RelationUserData relationUserData = this.mRelationData;
        if (relationUserData != null && (specialList = relationUserData.getSpecialList()) != null) {
            for (Special special : specialList) {
                Integer type = special.getType();
                if (type == null || type.intValue() != 1) {
                    arrayList.add(special);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final PhoneInfo getPhoneInfo() {
        return this.phoneInfo;
    }

    @Nullable
    public final Double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    @Nullable
    public final RideBean getRide() {
        return this.ride;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final String getSmallAvatar() {
        return this.avatar;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final ArrayList<Integer> getThirdList() {
        return this.thirdList;
    }

    public final int getVideoLikeCount() {
        return this.videoLikeCount;
    }

    public final long getVipExpireTime() {
        return this.vipExpireTime;
    }

    public final int getVisitCount() {
        return this.visitCount;
    }

    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.birthday;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryIcon;
        int hashCode4 = (((((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + com.google.firebase.sessions.a.a(this.diamondNum)) * 31) + this.externalId.hashCode()) * 31) + c.a(this.id)) * 31) + this.code.hashCode()) * 31) + this.likeCount) * 31) + this.iLikeCount) * 31) + this.videoLikeCount) * 31;
        String str4 = this.nick;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sex) * 31;
        String str5 = this.description;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.isShowAge;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isTradeUnion;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.isPush;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.isTradeUnionMatchNotification;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isAgentMgr;
        int hashCode11 = (hashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isLike;
        int hashCode12 = (hashCode11 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isLikeMe;
        int hashCode13 = (hashCode12 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isSession;
        int hashCode14 = (hashCode13 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.defaultAvatar;
        int hashCode15 = (((((((hashCode14 + (bool7 == null ? 0 : bool7.hashCode())) * 31) + this.visitCount) * 31) + this.heartValue) * 31) + this.heartValueMax) * 31;
        Integer num3 = this.meetDays;
        int hashCode16 = (((((((((((hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31) + c.a(this.wealthUserGrade)) * 31) + c.a(this.charmUserGrade)) * 31) + c.a(this.activityUserGrade)) * 31) + q2.a.a(this.isVip)) * 31) + c.a(this.vipExpireTime)) * 31;
        List<Integer> list = this.medals;
        int hashCode17 = (hashCode16 + (list == null ? 0 : list.hashCode())) * 31;
        List<MedalInfo> list2 = this.medalInfo;
        int hashCode18 = (hashCode17 + (list2 == null ? 0 : list2.hashCode())) * 31;
        HeadWearBean headWearBean = this.headwear;
        int hashCode19 = (hashCode18 + (headWearBean == null ? 0 : headWearBean.hashCode())) * 31;
        Boolean bool8 = this.isPrettyCode;
        int hashCode20 = (hashCode19 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        String str6 = this.currentRoom;
        int hashCode21 = (((hashCode20 + (str6 == null ? 0 : str6.hashCode())) * 31) + c.a(this.myGroupPower)) * 31;
        RideBean rideBean = this.ride;
        int hashCode22 = (hashCode21 + (rideBean == null ? 0 : rideBean.hashCode())) * 31;
        String str7 = this.myGroupPowerName;
        int hashCode23 = (hashCode22 + (str7 == null ? 0 : str7.hashCode())) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode24 = (((hashCode23 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31) + q2.a.a(this.isOfficialStaff)) * 31;
        String str8 = this.groupId;
        int hashCode25 = (hashCode24 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Double d10 = this.diamond;
        int hashCode26 = (hashCode25 + (d10 == null ? 0 : d10.hashCode())) * 31;
        PhoneInfo phoneInfo = this.phoneInfo;
        int hashCode27 = (hashCode26 + (phoneInfo == null ? 0 : phoneInfo.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.thirdList;
        int hashCode28 = (hashCode27 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        CountryManager countryManager = this.countryManager;
        int hashCode29 = (hashCode28 + (countryManager == null ? 0 : countryManager.hashCode())) * 31;
        Double d11 = this.pinkDiamondNum;
        int hashCode30 = (hashCode29 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num4 = this.groupRole;
        int hashCode31 = (hashCode30 + (num4 == null ? 0 : num4.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode32 = (hashCode31 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        FamilyInfo familyInfo = this.groupPower;
        int hashCode33 = (hashCode32 + (familyInfo == null ? 0 : familyInfo.hashCode())) * 31;
        MyCp myCp = this.cp;
        int hashCode34 = (hashCode33 + (myCp == null ? 0 : myCp.hashCode())) * 31;
        Boolean bool9 = this.isNew;
        int hashCode35 = (((hashCode34 + (bool9 == null ? 0 : bool9.hashCode())) * 31) + this.area) * 31;
        Boolean bool10 = this.isCountryId;
        int hashCode36 = (hashCode35 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Integer num5 = this.idFrameType;
        int hashCode37 = (hashCode36 + (num5 == null ? 0 : num5.hashCode())) * 31;
        RelationUserData relationUserData = this.mRelationData;
        int hashCode38 = (hashCode37 + (relationUserData == null ? 0 : relationUserData.hashCode())) * 31;
        String str9 = this.cardEffect;
        int hashCode39 = (hashCode38 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.cardEffectV2;
        int hashCode40 = (hashCode39 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.maskAvatar;
        int hashCode41 = (hashCode40 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.maskNick;
        int hashCode42 = (hashCode41 + (str12 == null ? 0 : str12.hashCode())) * 31;
        CanChat canChat = this.chat;
        int hashCode43 = (hashCode42 + (canChat == null ? 0 : canChat.hashCode())) * 31;
        MyGameLevel myGameLevel = this.gameLevel;
        int hashCode44 = (hashCode43 + (myGameLevel == null ? 0 : myGameLevel.hashCode())) * 31;
        Integer num6 = this.isRealCertification;
        int hashCode45 = (hashCode44 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool11 = this.hasGroupCountryManagerPower;
        return ((((hashCode45 + (bool11 != null ? bool11.hashCode() : 0)) * 31) + this.notRecommend) * 31) + this.cornerMark;
    }

    @Nullable
    public final Boolean isAgentMgr() {
        return this.isAgentMgr;
    }

    public final boolean isAr() {
        if (this.area == 1) {
            return true;
        }
        return false;
    }

    public final boolean isCompleteMaterial() {
        if (!TextUtils.isEmpty(this.nick) && this.birthday != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Boolean isCountryId() {
        return this.isCountryId;
    }

    @Nullable
    public final Boolean isLike() {
        return this.isLike;
    }

    @Nullable
    public final Boolean isLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    public final Boolean isNew() {
        return this.isNew;
    }

    public final boolean isOfficialStaff() {
        return this.isOfficialStaff;
    }

    @Nullable
    public final Boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    public final Integer isPush() {
        return this.isPush;
    }

    @Nullable
    public final Integer isRealCertification() {
        return this.isRealCertification;
    }

    @Nullable
    public final Boolean isSession() {
        return this.isSession;
    }

    @Nullable
    public final Integer isShowAge() {
        return this.isShowAge;
    }

    @Nullable
    public final Boolean isTradeUnion() {
        return this.isTradeUnion;
    }

    @Nullable
    public final Boolean isTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setActivityUserGrade(long j10) {
        this.activityUserGrade = j10;
    }

    public final void setAgentMgr(@Nullable Boolean bool) {
        this.isAgentMgr = bool;
    }

    public final void setArea(int i10) {
        this.area = i10;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setBirthday(@Nullable Long l10) {
        this.birthday = l10;
    }

    public final void setCardEffect(@Nullable String str) {
        this.cardEffect = str;
    }

    public final void setCardEffectV2(@Nullable String str) {
        this.cardEffectV2 = str;
    }

    public final void setCharmUserGrade(long j10) {
        this.charmUserGrade = j10;
    }

    public final void setChat(@Nullable CanChat canChat) {
        this.chat = canChat;
    }

    public final void setCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setCornerMark(int i10) {
        this.cornerMark = i10;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setCountryIcon(@Nullable String str) {
        this.countryIcon = str;
    }

    public final void setCountryId(@Nullable Boolean bool) {
        this.isCountryId = bool;
    }

    public final void setCountryManager(@Nullable CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    public final void setCp(@Nullable MyCp myCp) {
        this.cp = myCp;
    }

    public final void setCurrentRoom(@Nullable String str) {
        this.currentRoom = str;
    }

    public final void setDefaultAvatar(@Nullable Boolean bool) {
        this.defaultAvatar = bool;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setDiamond(@Nullable Double d10) {
        this.diamond = d10;
    }

    public final void setDiamondNum(double d10) {
        this.diamondNum = d10;
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setGameLevel(@Nullable MyGameLevel myGameLevel) {
        this.gameLevel = myGameLevel;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setGroupPower(@Nullable FamilyInfo familyInfo) {
        this.groupPower = familyInfo;
    }

    public final void setGroupRole(@Nullable Integer num) {
        this.groupRole = num;
    }

    public final void setHasGroupCountryManagerPower(@Nullable Boolean bool) {
        this.hasGroupCountryManagerPower = bool;
    }

    public final void setHeadwear(@Nullable HeadWearBean headWearBean) {
        this.headwear = headWearBean;
    }

    public final void setHeartValue(int i10) {
        this.heartValue = i10;
    }

    public final void setHeartValueMax(int i10) {
        this.heartValueMax = i10;
    }

    public final void setILikeCount(int i10) {
        this.iLikeCount = i10;
    }

    public final void setId(long j10) {
        this.id = j10;
    }

    public final void setIdFrameType(@Nullable Integer num) {
        this.idFrameType = num;
    }

    public final void setLike(@Nullable Boolean bool) {
        this.isLike = bool;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setLikeMe(@Nullable Boolean bool) {
        this.isLikeMe = bool;
    }

    public final void setMRelationData(@Nullable RelationUserData relationUserData) {
        this.mRelationData = relationUserData;
    }

    public final void setMaskAvatar(@Nullable String str) {
        this.maskAvatar = str;
    }

    public final void setMaskNick(@Nullable String str) {
        this.maskNick = str;
    }

    public final void setMedalInfo(@Nullable List<MedalInfo> list) {
        this.medalInfo = list;
    }

    public final void setMedals(@Nullable List<Integer> list) {
        this.medals = list;
    }

    public final void setMeetDays(@Nullable Integer num) {
        this.meetDays = num;
    }

    public final void setMyGroupPower(long j10) {
        this.myGroupPower = j10;
    }

    public final void setMyGroupPowerName(@Nullable String str) {
        this.myGroupPowerName = str;
    }

    public final void setNew(@Nullable Boolean bool) {
        this.isNew = bool;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setNotRecommend(int i10) {
        this.notRecommend = i10;
    }

    public final void setOfficialStaff(boolean z10) {
        this.isOfficialStaff = z10;
    }

    public final void setPhoneInfo(@Nullable PhoneInfo phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public final void setPinkDiamondNum(@Nullable Double d10) {
        this.pinkDiamondNum = d10;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setPush(@Nullable Integer num) {
        this.isPush = num;
    }

    public final void setRealCertification(@Nullable Integer num) {
        this.isRealCertification = num;
    }

    public final void setRide(@Nullable RideBean rideBean) {
        this.ride = rideBean;
    }

    public final void setSession(@Nullable Boolean bool) {
        this.isSession = bool;
    }

    public final void setSex(int i10) {
        this.sex = i10;
    }

    public final void setShowAge(@Nullable Integer num) {
        this.isShowAge = num;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setThirdList(@Nullable ArrayList<Integer> arrayList) {
        this.thirdList = arrayList;
    }

    public final void setTradeUnion(@Nullable Boolean bool) {
        this.isTradeUnion = bool;
    }

    public final void setTradeUnionMatchNotification(@Nullable Boolean bool) {
        this.isTradeUnionMatchNotification = bool;
    }

    public final void setVideoLikeCount(int i10) {
        this.videoLikeCount = i10;
    }

    public final void setVip(boolean z10) {
        this.isVip = z10;
    }

    public final void setVipExpireTime(long j10) {
        this.vipExpireTime = j10;
    }

    public final void setVisitCount(int i10) {
        this.visitCount = i10;
    }

    public final void setWealthUserGrade(long j10) {
        this.wealthUserGrade = j10;
    }

    @NotNull
    public String toString() {
        return "User(avatar=" + this.avatar + ", birthday=" + this.birthday + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", diamondNum=" + this.diamondNum + ", externalId=" + this.externalId + ", id=" + this.id + ", code=" + this.code + ", likeCount=" + this.likeCount + ", iLikeCount=" + this.iLikeCount + ", videoLikeCount=" + this.videoLikeCount + ", nick=" + this.nick + ", sex=" + this.sex + ", description=" + this.description + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isPush=" + this.isPush + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", isAgentMgr=" + this.isAgentMgr + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", isSession=" + this.isSession + ", defaultAvatar=" + this.defaultAvatar + ", visitCount=" + this.visitCount + ", heartValue=" + this.heartValue + ", heartValueMax=" + this.heartValueMax + ", meetDays=" + this.meetDays + ", wealthUserGrade=" + this.wealthUserGrade + ", charmUserGrade=" + this.charmUserGrade + ", activityUserGrade=" + this.activityUserGrade + ", isVip=" + this.isVip + ", vipExpireTime=" + this.vipExpireTime + ", medals=" + this.medals + ", medalInfo=" + this.medalInfo + ", headwear=" + this.headwear + ", isPrettyCode=" + this.isPrettyCode + ", currentRoom=" + this.currentRoom + ", myGroupPower=" + this.myGroupPower + ", ride=" + this.ride + ", myGroupPowerName=" + this.myGroupPowerName + ", noble=" + this.noble + ", isOfficialStaff=" + this.isOfficialStaff + ", groupId=" + this.groupId + ", diamond=" + this.diamond + ", phoneInfo=" + this.phoneInfo + ", thirdList=" + this.thirdList + ", countryManager=" + this.countryManager + ", pinkDiamondNum=" + this.pinkDiamondNum + ", groupRole=" + this.groupRole + ", svip=" + this.svip + ", groupPower=" + this.groupPower + ", cp=" + this.cp + ", isNew=" + this.isNew + ", area=" + this.area + ", isCountryId=" + this.isCountryId + ", idFrameType=" + this.idFrameType + ", mRelationData=" + this.mRelationData + ", cardEffect=" + this.cardEffect + ", cardEffectV2=" + this.cardEffectV2 + ", maskAvatar=" + this.maskAvatar + ", maskNick=" + this.maskNick + ", chat=" + this.chat + ", gameLevel=" + this.gameLevel + ", isRealCertification=" + this.isRealCertification + ", hasGroupCountryManagerPower=" + this.hasGroupCountryManagerPower + ", notRecommend=" + this.notRecommend + ", cornerMark=" + this.cornerMark + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.avatar);
        Long l10 = this.birthday;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.country);
        dest.writeString(this.countryIcon);
        dest.writeDouble(this.diamondNum);
        dest.writeString(this.externalId);
        dest.writeLong(this.id);
        dest.writeString(this.code);
        dest.writeInt(this.likeCount);
        dest.writeInt(this.iLikeCount);
        dest.writeInt(this.videoLikeCount);
        dest.writeString(this.nick);
        dest.writeInt(this.sex);
        dest.writeString(this.description);
        Integer num = this.isShowAge;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool = this.isTradeUnion;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.isPush;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Boolean bool2 = this.isTradeUnionMatchNotification;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.isAgentMgr;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.isLike;
        if (bool4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.isLikeMe;
        if (bool5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        Boolean bool6 = this.isSession;
        if (bool6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        Boolean bool7 = this.defaultAvatar;
        if (bool7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.visitCount);
        dest.writeInt(this.heartValue);
        dest.writeInt(this.heartValueMax);
        Integer num3 = this.meetDays;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeLong(this.wealthUserGrade);
        dest.writeLong(this.charmUserGrade);
        dest.writeLong(this.activityUserGrade);
        dest.writeInt(this.isVip ? 1 : 0);
        dest.writeLong(this.vipExpireTime);
        List<Integer> list = this.medals;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        List<MedalInfo> list2 = this.medalInfo;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<MedalInfo> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        HeadWearBean headWearBean = this.headwear;
        if (headWearBean == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            headWearBean.writeToParcel(dest, flags);
        }
        Boolean bool8 = this.isPrettyCode;
        if (bool8 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.currentRoom);
        dest.writeLong(this.myGroupPower);
        RideBean rideBean = this.ride;
        if (rideBean == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            rideBean.writeToParcel(dest, flags);
        }
        dest.writeString(this.myGroupPowerName);
        NobleInfo nobleInfo = this.noble;
        if (nobleInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            nobleInfo.writeToParcel(dest, flags);
        }
        dest.writeInt(this.isOfficialStaff ? 1 : 0);
        dest.writeString(this.groupId);
        Double d10 = this.diamond;
        if (d10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeDouble(d10.doubleValue());
        }
        PhoneInfo phoneInfo = this.phoneInfo;
        if (phoneInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            phoneInfo.writeToParcel(dest, flags);
        }
        ArrayList<Integer> arrayList = this.thirdList;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<Integer> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                dest.writeInt(it3.next().intValue());
            }
        }
        CountryManager countryManager = this.countryManager;
        if (countryManager == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            countryManager.writeToParcel(dest, flags);
        }
        Double d11 = this.pinkDiamondNum;
        if (d11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeDouble(d11.doubleValue());
        }
        Integer num4 = this.groupRole;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        SvipData svipData = this.svip;
        if (svipData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            svipData.writeToParcel(dest, flags);
        }
        FamilyInfo familyInfo = this.groupPower;
        if (familyInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            familyInfo.writeToParcel(dest, flags);
        }
        MyCp myCp = this.cp;
        if (myCp == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            myCp.writeToParcel(dest, flags);
        }
        Boolean bool9 = this.isNew;
        if (bool9 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool9.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.area);
        Boolean bool10 = this.isCountryId;
        if (bool10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool10.booleanValue() ? 1 : 0);
        }
        Integer num5 = this.idFrameType;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
        RelationUserData relationUserData = this.mRelationData;
        if (relationUserData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            relationUserData.writeToParcel(dest, flags);
        }
        dest.writeString(this.cardEffect);
        dest.writeString(this.cardEffectV2);
        dest.writeString(this.maskAvatar);
        dest.writeString(this.maskNick);
        CanChat canChat = this.chat;
        if (canChat == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            canChat.writeToParcel(dest, flags);
        }
        MyGameLevel myGameLevel = this.gameLevel;
        if (myGameLevel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            myGameLevel.writeToParcel(dest, flags);
        }
        Integer num6 = this.isRealCertification;
        if (num6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num6.intValue());
        }
        Boolean bool11 = this.hasGroupCountryManagerPower;
        if (bool11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool11.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.notRecommend);
        dest.writeInt(this.cornerMark);
    }

    public /* synthetic */ User(String str, Long l10, String str2, String str3, double d10, String str4, long j10, String str5, int i10, int i11, int i12, String str6, int i13, String str7, Integer num, Boolean bool, Integer num2, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i14, int i15, int i16, Integer num3, long j11, long j12, long j13, boolean z10, long j14, List list, List list2, HeadWearBean headWearBean, Boolean bool8, String str8, long j15, RideBean rideBean, String str9, NobleInfo nobleInfo, boolean z11, String str10, Double d11, PhoneInfo phoneInfo, ArrayList arrayList, CountryManager countryManager, Double d12, Integer num4, SvipData svipData, FamilyInfo familyInfo, MyCp myCp, Boolean bool9, int i17, Boolean bool10, Integer num5, RelationUserData relationUserData, String str11, String str12, String str13, String str14, CanChat canChat, MyGameLevel myGameLevel, Integer num6, Boolean bool11, int i18, int i19, int i20, int i21, int i22, DefaultConstructorMarker defaultConstructorMarker) {
        this((i20 & 1) != 0 ? null : str, (i20 & 2) != 0 ? 0L : l10, (i20 & 4) != 0 ? "" : str2, (i20 & 8) != 0 ? null : str3, (i20 & 16) != 0 ? 0.0d : d10, (i20 & 32) != 0 ? "" : str4, (i20 & 64) != 0 ? 0L : j10, (i20 & 128) != 0 ? "" : str5, (i20 & 256) != 0 ? 0 : i10, (i20 & 512) != 0 ? 0 : i11, (i20 & 1024) != 0 ? 0 : i12, (i20 & 2048) != 0 ? "" : str6, (i20 & 4096) != 0 ? 0 : i13, str7, (i20 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : num, (i20 & 32768) != 0 ? null : bool, (i20 & 65536) != 0 ? 0 : num2, (i20 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? null : bool2, (i20 & 262144) != 0 ? Boolean.FALSE : bool3, (i20 & a.MAX_POOL_SIZE) != 0 ? Boolean.FALSE : bool4, (i20 & Constants.MB) != 0 ? Boolean.FALSE : bool5, (i20 & 2097152) != 0 ? Boolean.FALSE : bool6, (i20 & 4194304) != 0 ? Boolean.FALSE : bool7, (i20 & 8388608) != 0 ? 0 : i14, (i20 & 16777216) != 0 ? 0 : i15, (i20 & 33554432) != 0 ? 1 : i16, (i20 & 67108864) != 0 ? null : num3, (i20 & 134217728) != 0 ? 0L : j11, (i20 & 268435456) != 0 ? 0L : j12, (i20 & 536870912) != 0 ? 0L : j13, (i20 & 1073741824) != 0 ? false : z10, (i20 & Integer.MIN_VALUE) != 0 ? 0L : j14, (i21 & 1) != 0 ? null : list, (i21 & 2) != 0 ? null : list2, (i21 & 4) != 0 ? null : headWearBean, (i21 & 8) != 0 ? Boolean.FALSE : bool8, (i21 & 16) != 0 ? "" : str8, (i21 & 32) != 0 ? 0L : j15, (i21 & 64) != 0 ? null : rideBean, (i21 & 128) != 0 ? "" : str9, (i21 & 256) != 0 ? null : nobleInfo, (i21 & 512) != 0 ? false : z11, (i21 & 1024) != 0 ? "" : str10, (i21 & 2048) != 0 ? Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : d11, (i21 & 4096) != 0 ? null : phoneInfo, (i21 & 8192) != 0 ? null : arrayList, (i21 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : countryManager, (32768 & i21) != 0 ? Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : d12, (i21 & 65536) != 0 ? 0 : num4, (i21 & e.MAX_RSP_BUFFER_LENGTH) != 0 ? null : svipData, (262144 & i21) != 0 ? null : familyInfo, (524288 & i21) != 0 ? null : myCp, (1048576 & i21) != 0 ? Boolean.FALSE : bool9, (2097152 & i21) != 0 ? 2 : i17, (4194304 & i21) != 0 ? null : bool10, (8388608 & i21) != 0 ? null : num5, (16777216 & i21) != 0 ? null : relationUserData, (33554432 & i21) != 0 ? null : str11, (67108864 & i21) != 0 ? null : str12, (134217728 & i21) != 0 ? null : str13, (268435456 & i21) != 0 ? null : str14, (536870912 & i21) != 0 ? null : canChat, (1073741824 & i21) != 0 ? null : myGameLevel, (i21 & Integer.MIN_VALUE) == 0 ? num6 : null, (i22 & 1) != 0 ? Boolean.FALSE : bool11, (i22 & 2) != 0 ? 0 : i18, (i22 & 4) != 0 ? 0 : i19);
    }
}
