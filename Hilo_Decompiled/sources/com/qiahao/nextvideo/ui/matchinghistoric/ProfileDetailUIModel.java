package com.qiahao.nextvideo.ui.matchinghistoric;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import androidx.collection.c;
import com.qiahao.base_common.model.common.CountryManager;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.HeadWearBean;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RelationUserData;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u0087\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Ç\u00012\u00020\u0001:\u0002Ç\u0001B£\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u001c\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107¢\u0006\u0004\b8\u00109J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010 \u0001\u001a\u00020\u000fHÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010XJ\n\u0010¦\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010§\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010©\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0005HÆ\u0003J\u0012\u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\u0012\u0010°\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u001cHÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010XJ\f\u0010¹\u0001\u001a\u0004\u0018\u000107HÆ\u0003JÎ\u0003\u0010º\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0003\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!2\b\b\u0002\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u001c2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u000107HÆ\u0001¢\u0006\u0003\u0010»\u0001J\u0007\u0010¼\u0001\u001a\u00020\u000fJ\u0016\u0010½\u0001\u001a\u00020\u00052\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001HÖ\u0003J\n\u0010À\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010Á\u0001\u001a\u00020\u0007HÖ\u0001J\u001b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\u0007\u0010Æ\u0001\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010<\"\u0004\b=\u0010>R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010ER\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010@R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010@R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u0010@R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bO\u0010JR\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010JR\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010JR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010@\"\u0004\bS\u0010ER\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010<\"\u0004\bT\u0010>R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010<\"\u0004\bU\u0010>R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010<\"\u0004\bV\u0010>R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010J\"\u0004\b]\u0010LR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010\u001d\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR\u001a\u0010\u001e\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010<\"\u0004\bf\u0010>R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001e\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\b$\u0010X\"\u0004\bo\u0010ZR\u001c\u0010%\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010@\"\u0004\bq\u0010ER\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010h\"\u0004\bw\u0010jR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010@\"\u0004\by\u0010ER\u001a\u0010+\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010_\"\u0004\b{\u0010aR\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001b\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b.\u0010<\"\u0005\b\u0080\u0001\u0010>R \u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R \u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R \u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001f\u00105\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0011\n\u0002\u0010[\u001a\u0004\b5\u0010X\"\u0005\b\u008d\u0001\u0010ZR \u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006È\u0001"}, d2 = {"Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "Landroid/os/Parcelable;", "imageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "isSelected", "", "nickname", "", "uid", Constants.KEY_HTTP_CODE, "matchID", "description", "pairedDate", "age", "position", "", "countryImageUIModel", "countryName", "sexIconResId", "sex", "sexBackgroundResID", "birthdayInFormat", "isFreeMessage", "isLike", "isLikeMe", "hasRead", "heartPer", "wealthUserGrade", "", "charmUserGrade", "activityUserGrade", "isVip", "medals", "", "headwear", "Lcom/qiahao/base_common/model/common/HeadWearBean;", "isPrettyCode", "currentRoom", "rideBean", "Lcom/qiahao/base_common/model/common/RideBean;", "medalInfo", "Lcom/qiahao/base_common/model/common/MedalInfo;", "myGroupPowerName", "myGroupPowerId", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "isOfficialStaff", "countryManager", "Lcom/qiahao/base_common/model/common/CountryManager;", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "groupPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "isCountryId", "mRelationData", "Lcom/qiahao/base_common/model/common/RelationUserData;", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;IIILjava/lang/String;ZZZLjava/lang/Boolean;IJJJZLjava/util/List;Lcom/qiahao/base_common/model/common/HeadWearBean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/RideBean;Ljava/util/List;Ljava/lang/String;JLcom/qiahao/base_common/model/common/NobleInfo;ZLcom/qiahao/base_common/model/common/CountryManager;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/RelationUserData;)V", "getImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "()Z", "setSelected", "(Z)V", "getNickname", "()Ljava/lang/String;", "getUid", "getCode", "getMatchID", "setMatchID", "(Ljava/lang/String;)V", "getDescription", "getPairedDate", "getAge", "getPosition", "()I", "setPosition", "(I)V", "getCountryImageUIModel", "getCountryName", "getSexIconResId", "getSex", "getSexBackgroundResID", "getBirthdayInFormat", "setBirthdayInFormat", "setFreeMessage", "setLike", "setLikeMe", "getHasRead", "()Ljava/lang/Boolean;", "setHasRead", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHeartPer", "setHeartPer", "getWealthUserGrade", "()J", "setWealthUserGrade", "(J)V", "getCharmUserGrade", "setCharmUserGrade", "getActivityUserGrade", "setActivityUserGrade", "setVip", "getMedals", "()Ljava/util/List;", "setMedals", "(Ljava/util/List;)V", "getHeadwear", "()Lcom/qiahao/base_common/model/common/HeadWearBean;", "setHeadwear", "(Lcom/qiahao/base_common/model/common/HeadWearBean;)V", "setPrettyCode", "getCurrentRoom", "setCurrentRoom", "getRideBean", "()Lcom/qiahao/base_common/model/common/RideBean;", "setRideBean", "(Lcom/qiahao/base_common/model/common/RideBean;)V", "getMedalInfo", "setMedalInfo", "getMyGroupPowerName", "setMyGroupPowerName", "getMyGroupPowerId", "setMyGroupPowerId", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "setOfficialStaff", "getCountryManager", "()Lcom/qiahao/base_common/model/common/CountryManager;", "setCountryManager", "(Lcom/qiahao/base_common/model/common/CountryManager;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getGroupPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setGroupPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "setCountryId", "getMRelationData", "()Lcom/qiahao/base_common/model/common/RelationUserData;", "setMRelationData", "(Lcom/qiahao/base_common/model/common/RelationUserData;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "copy", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;IIILjava/lang/String;ZZZLjava/lang/Boolean;IJJJZLjava/util/List;Lcom/qiahao/base_common/model/common/HeadWearBean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/RideBean;Ljava/util/List;Ljava/lang/String;JLcom/qiahao/base_common/model/common/NobleInfo;ZLcom/qiahao/base_common/model/common/CountryManager;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/RelationUserData;)Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ProfileDetailUIModel implements Parcelable {

    @NotNull
    public static final String keyPreloadModel = "keyOfUIModel";
    private long activityUserGrade;

    @Nullable
    private final String age;

    @Nullable
    private String birthdayInFormat;
    private long charmUserGrade;

    @NotNull
    private final String code;

    @NotNull
    private final ImageUIModel countryImageUIModel;

    @Nullable
    private CountryManager countryManager;

    @NotNull
    private final String countryName;

    @Nullable
    private String currentRoom;

    @Nullable
    private final String description;

    @Nullable
    private FamilyInfo groupPower;

    @Nullable
    private Boolean hasRead;

    @Nullable
    private HeadWearBean headwear;
    private int heartPer;

    @NotNull
    private final ImageUIModel imageUIModel;

    @Nullable
    private Boolean isCountryId;
    private boolean isFreeMessage;
    private boolean isLike;
    private boolean isLikeMe;
    private boolean isOfficialStaff;

    @Nullable
    private Boolean isPrettyCode;
    private boolean isSelected;
    private boolean isVip;

    @Nullable
    private RelationUserData mRelationData;

    @Nullable
    private String matchID;

    @Nullable
    private List<MedalInfo> medalInfo;

    @Nullable
    private List<Integer> medals;
    private long myGroupPowerId;

    @NotNull
    private String myGroupPowerName;

    @NotNull
    private final String nickname;

    @Nullable
    private NobleInfo noble;

    @NotNull
    private final String pairedDate;
    private int position;

    @Nullable
    private RideBean rideBean;
    private final int sex;
    private final int sexBackgroundResID;
    private final int sexIconResId;

    @Nullable
    private SvipData svip;

    @NotNull
    private final String uid;
    private long wealthUserGrade;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ProfileDetailUIModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel$Companion;", "", "<init>", "()V", "keyPreloadModel", "", "init", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileDetailUIModel init(@NotNull User user) {
            int i;
            String str;
            int i2;
            int i3;
            long j;
            String str2;
            Intrinsics.checkNotNullParameter(user, "user");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            ImageUIModel full = companion.full(user.getAvatar());
            full.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (user.getSex() != 1) {
                i = R.drawable.bg_default_online_list_female_placeholder;
            } else {
                i = R.drawable.bg_default_online_list_male_placeholder;
            }
            full.setPlaceholder(Integer.valueOf(i));
            String nick = user.getNick();
            if (nick == null) {
                str = "";
            } else {
                str = nick;
            }
            String externalId = user.getExternalId();
            String code = user.getCode();
            String description = user.getDescription();
            String age = user.getAge();
            ImageUIModel countryTag = companion.countryTag(user.getCountryInfo().getIcon());
            String name = user.getCountryInfo().getName();
            if (user.getSex() == 2) {
                i2 = R.drawable.icon_girl;
            } else {
                i2 = R.drawable.icon_boy;
            }
            int sex = user.getSex();
            if (user.getSex() == 1) {
                i3 = R.drawable.bg_age_male;
            } else {
                i3 = R.drawable.bg_age_female;
            }
            Long birthday = user.getBirthday();
            if (birthday != null) {
                j = birthday.longValue();
            } else {
                j = 0;
            }
            String dateInSecs$default = DateTimeUtilityKt.getDateInSecs$default(j, (Locale) null, (String) null, 6, (Object) null);
            Boolean isSession = user.isSession();
            Boolean bool = Boolean.TRUE;
            boolean areEqual = Intrinsics.areEqual(isSession, bool);
            boolean areEqual2 = Intrinsics.areEqual(user.isLike(), bool);
            boolean areEqual3 = Intrinsics.areEqual(user.isLikeMe(), bool);
            int heartPer = user.getHeartPer();
            long wealthUserGrade = user.getWealthUserGrade();
            long charmUserGrade = user.getCharmUserGrade();
            long activityUserGrade = user.getActivityUserGrade();
            boolean isVip = user.isVip();
            List medals = user.getMedals();
            HeadWearBean headwear = user.getHeadwear();
            Boolean isPrettyCode = user.isPrettyCode();
            String currentRoom = user.getCurrentRoom();
            RideBean ride = user.getRide();
            List medalInfo = user.getMedalInfo();
            String myGroupPowerName = user.getMyGroupPowerName();
            if (myGroupPowerName == null) {
                str2 = "";
            } else {
                str2 = myGroupPowerName;
            }
            return new ProfileDetailUIModel(full, false, str, externalId, code, null, description, "", age, 0, countryTag, name, i2, sex, i3, dateInSecs$default, areEqual, areEqual2, areEqual3, null, heartPer, wealthUserGrade, charmUserGrade, activityUserGrade, isVip, medals, headwear, isPrettyCode, currentRoom, ride, medalInfo, str2, user.getMyGroupPower(), user.getNoble(), user.isOfficialStaff(), user.getCountryManager(), user.getSvip(), user.getGroupPower(), user.isCountryId(), user.getMRelationData(), 524320, 0, null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<ProfileDetailUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProfileDetailUIModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean bool;
            ArrayList arrayList;
            Boolean valueOf2;
            ArrayList arrayList2;
            ArrayList arrayList3;
            String str;
            Boolean valueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Parcelable.Creator<ImageUIModel> creator = ImageUIModel.CREATOR;
            ImageUIModel createFromParcel = creator.createFromParcel(parcel);
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            int readInt = parcel.readInt();
            ImageUIModel createFromParcel2 = creator.createFromParcel(parcel);
            String readString8 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            String readString9 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            int readInt5 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            long readLong3 = parcel.readLong();
            boolean z5 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                bool = valueOf;
                arrayList = null;
            } else {
                int readInt6 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt6);
                bool = valueOf;
                int i = 0;
                while (i != readInt6) {
                    arrayList4.add(Integer.valueOf(parcel.readInt()));
                    i++;
                    readInt6 = readInt6;
                }
                arrayList = arrayList4;
            }
            HeadWearBean readParcelable = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString10 = parcel.readString();
            RideBean readParcelable2 = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList2 = arrayList;
                str = readString8;
                arrayList3 = null;
            } else {
                int readInt7 = parcel.readInt();
                arrayList2 = arrayList;
                arrayList3 = new ArrayList(readInt7);
                str = readString8;
                int i2 = 0;
                while (i2 != readInt7) {
                    arrayList3.add(parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader()));
                    i2++;
                    readInt7 = readInt7;
                }
            }
            String readString11 = parcel.readString();
            long readLong4 = parcel.readLong();
            NobleInfo readParcelable3 = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            boolean z6 = parcel.readInt() != 0;
            CountryManager readParcelable4 = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            SvipData readParcelable5 = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            FamilyInfo readParcelable6 = parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ProfileDetailUIModel(createFromParcel, z, readString, readString2, readString3, readString4, readString5, readString6, readString7, readInt, createFromParcel2, str, readInt2, readInt3, readInt4, readString9, z2, z3, z4, bool, readInt5, readLong, readLong2, readLong3, z5, arrayList2, readParcelable, valueOf2, readString10, readParcelable2, arrayList3, readString11, readLong4, readParcelable3, z6, readParcelable4, readParcelable5, readParcelable6, valueOf3, parcel.readParcelable(ProfileDetailUIModel.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProfileDetailUIModel[] newArray(int i) {
            return new ProfileDetailUIModel[i];
        }
    }

    public ProfileDetailUIModel(@NotNull ImageUIModel imageUIModel, boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7, int i, @NotNull ImageUIModel imageUIModel2, @NotNull String str8, int i2, int i3, int i4, @Nullable String str9, boolean z2, boolean z3, boolean z4, @Nullable Boolean bool, int i5, long j, long j2, long j3, boolean z5, @Nullable List<Integer> list, @Nullable HeadWearBean headWearBean, @Nullable Boolean bool2, @Nullable String str10, @Nullable RideBean rideBean, @Nullable List<MedalInfo> list2, @NotNull String str11, long j4, @Nullable NobleInfo nobleInfo, boolean z6, @Nullable CountryManager countryManager, @Nullable SvipData svipData, @Nullable FamilyInfo familyInfo, @Nullable Boolean bool3, @Nullable RelationUserData relationUserData) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        Intrinsics.checkNotNullParameter(str, "nickname");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str6, "pairedDate");
        Intrinsics.checkNotNullParameter(imageUIModel2, "countryImageUIModel");
        Intrinsics.checkNotNullParameter(str8, "countryName");
        Intrinsics.checkNotNullParameter(str11, "myGroupPowerName");
        this.imageUIModel = imageUIModel;
        this.isSelected = z;
        this.nickname = str;
        this.uid = str2;
        this.code = str3;
        this.matchID = str4;
        this.description = str5;
        this.pairedDate = str6;
        this.age = str7;
        this.position = i;
        this.countryImageUIModel = imageUIModel2;
        this.countryName = str8;
        this.sexIconResId = i2;
        this.sex = i3;
        this.sexBackgroundResID = i4;
        this.birthdayInFormat = str9;
        this.isFreeMessage = z2;
        this.isLike = z3;
        this.isLikeMe = z4;
        this.hasRead = bool;
        this.heartPer = i5;
        this.wealthUserGrade = j;
        this.charmUserGrade = j2;
        this.activityUserGrade = j3;
        this.isVip = z5;
        this.medals = list;
        this.headwear = headWearBean;
        this.isPrettyCode = bool2;
        this.currentRoom = str10;
        this.rideBean = rideBean;
        this.medalInfo = list2;
        this.myGroupPowerName = str11;
        this.myGroupPowerId = j4;
        this.noble = nobleInfo;
        this.isOfficialStaff = z6;
        this.countryManager = countryManager;
        this.svip = svipData;
        this.groupPower = familyInfo;
        this.isCountryId = bool3;
        this.mRelationData = relationUserData;
    }

    public static /* synthetic */ ProfileDetailUIModel copy$default(ProfileDetailUIModel profileDetailUIModel, ImageUIModel imageUIModel, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, ImageUIModel imageUIModel2, String str8, int i2, int i3, int i4, String str9, boolean z2, boolean z3, boolean z4, Boolean bool, int i5, long j, long j2, long j3, boolean z5, List list, HeadWearBean headWearBean, Boolean bool2, String str10, RideBean rideBean, List list2, String str11, long j4, NobleInfo nobleInfo, boolean z6, CountryManager countryManager, SvipData svipData, FamilyInfo familyInfo, Boolean bool3, RelationUserData relationUserData, int i6, int i7, Object obj) {
        ImageUIModel imageUIModel3 = (i6 & 1) != 0 ? profileDetailUIModel.imageUIModel : imageUIModel;
        boolean z7 = (i6 & 2) != 0 ? profileDetailUIModel.isSelected : z;
        String str12 = (i6 & 4) != 0 ? profileDetailUIModel.nickname : str;
        String str13 = (i6 & 8) != 0 ? profileDetailUIModel.uid : str2;
        String str14 = (i6 & 16) != 0 ? profileDetailUIModel.code : str3;
        String str15 = (i6 & 32) != 0 ? profileDetailUIModel.matchID : str4;
        String str16 = (i6 & 64) != 0 ? profileDetailUIModel.description : str5;
        String str17 = (i6 & 128) != 0 ? profileDetailUIModel.pairedDate : str6;
        String str18 = (i6 & 256) != 0 ? profileDetailUIModel.age : str7;
        int i8 = (i6 & 512) != 0 ? profileDetailUIModel.position : i;
        ImageUIModel imageUIModel4 = (i6 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? profileDetailUIModel.countryImageUIModel : imageUIModel2;
        String str19 = (i6 & 2048) != 0 ? profileDetailUIModel.countryName : str8;
        return profileDetailUIModel.copy(imageUIModel3, z7, str12, str13, str14, str15, str16, str17, str18, i8, imageUIModel4, str19, (i6 & 4096) != 0 ? profileDetailUIModel.sexIconResId : i2, (i6 & 8192) != 0 ? profileDetailUIModel.sex : i3, (i6 & 16384) != 0 ? profileDetailUIModel.sexBackgroundResID : i4, (i6 & 32768) != 0 ? profileDetailUIModel.birthdayInFormat : str9, (i6 & 65536) != 0 ? profileDetailUIModel.isFreeMessage : z2, (i6 & 131072) != 0 ? profileDetailUIModel.isLike : z3, (i6 & 262144) != 0 ? profileDetailUIModel.isLikeMe : z4, (i6 & 524288) != 0 ? profileDetailUIModel.hasRead : bool, (i6 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? profileDetailUIModel.heartPer : i5, (i6 & 2097152) != 0 ? profileDetailUIModel.wealthUserGrade : j, (i6 & 4194304) != 0 ? profileDetailUIModel.charmUserGrade : j2, (i6 & 8388608) != 0 ? profileDetailUIModel.activityUserGrade : j3, (i6 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? profileDetailUIModel.isVip : z5, (33554432 & i6) != 0 ? profileDetailUIModel.medals : list, (i6 & 67108864) != 0 ? profileDetailUIModel.headwear : headWearBean, (i6 & 134217728) != 0 ? profileDetailUIModel.isPrettyCode : bool2, (i6 & 268435456) != 0 ? profileDetailUIModel.currentRoom : str10, (i6 & 536870912) != 0 ? profileDetailUIModel.rideBean : rideBean, (i6 & 1073741824) != 0 ? profileDetailUIModel.medalInfo : list2, (i6 & Integer.MIN_VALUE) != 0 ? profileDetailUIModel.myGroupPowerName : str11, (i7 & 1) != 0 ? profileDetailUIModel.myGroupPowerId : j4, (i7 & 2) != 0 ? profileDetailUIModel.noble : nobleInfo, (i7 & 4) != 0 ? profileDetailUIModel.isOfficialStaff : z6, (i7 & 8) != 0 ? profileDetailUIModel.countryManager : countryManager, (i7 & 16) != 0 ? profileDetailUIModel.svip : svipData, (i7 & 32) != 0 ? profileDetailUIModel.groupPower : familyInfo, (i7 & 64) != 0 ? profileDetailUIModel.isCountryId : bool3, (i7 & 128) != 0 ? profileDetailUIModel.mRelationData : relationUserData);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    /* renamed from: component10, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final ImageUIModel getCountryImageUIModel() {
        return this.countryImageUIModel;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* renamed from: component13, reason: from getter */
    public final int getSexIconResId() {
        return this.sexIconResId;
    }

    /* renamed from: component14, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component15, reason: from getter */
    public final int getSexBackgroundResID() {
        return this.sexBackgroundResID;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getBirthdayInFormat() {
        return this.birthdayInFormat;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsFreeMessage() {
        return this.isFreeMessage;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Boolean getHasRead() {
        return this.hasRead;
    }

    /* renamed from: component21, reason: from getter */
    public final int getHeartPer() {
        return this.heartPer;
    }

    /* renamed from: component22, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component23, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    /* renamed from: component24, reason: from getter */
    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    /* renamed from: component25, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    public final List<Integer> component26() {
        return this.medals;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final HeadWearBean getHeadwear() {
        return this.headwear;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component30, reason: from getter */
    public final RideBean getRideBean() {
        return this.rideBean;
    }

    @Nullable
    public final List<MedalInfo> component31() {
        return this.medalInfo;
    }

    @NotNull
    /* renamed from: component32, reason: from getter */
    public final String getMyGroupPowerName() {
        return this.myGroupPowerName;
    }

    /* renamed from: component33, reason: from getter */
    public final long getMyGroupPowerId() {
        return this.myGroupPowerId;
    }

    @Nullable
    /* renamed from: component34, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    /* renamed from: component35, reason: from getter */
    public final boolean getIsOfficialStaff() {
        return this.isOfficialStaff;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final CountryManager getCountryManager() {
        return this.countryManager;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component38, reason: from getter */
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @Nullable
    /* renamed from: component39, reason: from getter */
    public final Boolean getIsCountryId() {
        return this.isCountryId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @Nullable
    /* renamed from: component40, reason: from getter */
    public final RelationUserData getMRelationData() {
        return this.mRelationData;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getMatchID() {
        return this.matchID;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getPairedDate() {
        return this.pairedDate;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getAge() {
        return this.age;
    }

    @NotNull
    public final ProfileDetailUIModel copy(@NotNull ImageUIModel imageUIModel, boolean isSelected, @NotNull String nickname, @NotNull String uid, @NotNull String code, @Nullable String matchID, @Nullable String description, @NotNull String pairedDate, @Nullable String age, int position, @NotNull ImageUIModel countryImageUIModel, @NotNull String countryName, int sexIconResId, int sex, int sexBackgroundResID, @Nullable String birthdayInFormat, boolean isFreeMessage, boolean isLike, boolean isLikeMe, @Nullable Boolean hasRead, int heartPer, long wealthUserGrade, long charmUserGrade, long activityUserGrade, boolean isVip, @Nullable List<Integer> medals, @Nullable HeadWearBean headwear, @Nullable Boolean isPrettyCode, @Nullable String currentRoom, @Nullable RideBean rideBean, @Nullable List<MedalInfo> medalInfo, @NotNull String myGroupPowerName, long myGroupPowerId, @Nullable NobleInfo noble, boolean isOfficialStaff, @Nullable CountryManager countryManager, @Nullable SvipData svip, @Nullable FamilyInfo groupPower, @Nullable Boolean isCountryId, @Nullable RelationUserData mRelationData) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(pairedDate, "pairedDate");
        Intrinsics.checkNotNullParameter(countryImageUIModel, "countryImageUIModel");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(myGroupPowerName, "myGroupPowerName");
        return new ProfileDetailUIModel(imageUIModel, isSelected, nickname, uid, code, matchID, description, pairedDate, age, position, countryImageUIModel, countryName, sexIconResId, sex, sexBackgroundResID, birthdayInFormat, isFreeMessage, isLike, isLikeMe, hasRead, heartPer, wealthUserGrade, charmUserGrade, activityUserGrade, isVip, medals, headwear, isPrettyCode, currentRoom, rideBean, medalInfo, myGroupPowerName, myGroupPowerId, noble, isOfficialStaff, countryManager, svip, groupPower, isCountryId, mRelationData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileDetailUIModel)) {
            return false;
        }
        ProfileDetailUIModel profileDetailUIModel = (ProfileDetailUIModel) other;
        return Intrinsics.areEqual(this.imageUIModel, profileDetailUIModel.imageUIModel) && this.isSelected == profileDetailUIModel.isSelected && Intrinsics.areEqual(this.nickname, profileDetailUIModel.nickname) && Intrinsics.areEqual(this.uid, profileDetailUIModel.uid) && Intrinsics.areEqual(this.code, profileDetailUIModel.code) && Intrinsics.areEqual(this.matchID, profileDetailUIModel.matchID) && Intrinsics.areEqual(this.description, profileDetailUIModel.description) && Intrinsics.areEqual(this.pairedDate, profileDetailUIModel.pairedDate) && Intrinsics.areEqual(this.age, profileDetailUIModel.age) && this.position == profileDetailUIModel.position && Intrinsics.areEqual(this.countryImageUIModel, profileDetailUIModel.countryImageUIModel) && Intrinsics.areEqual(this.countryName, profileDetailUIModel.countryName) && this.sexIconResId == profileDetailUIModel.sexIconResId && this.sex == profileDetailUIModel.sex && this.sexBackgroundResID == profileDetailUIModel.sexBackgroundResID && Intrinsics.areEqual(this.birthdayInFormat, profileDetailUIModel.birthdayInFormat) && this.isFreeMessage == profileDetailUIModel.isFreeMessage && this.isLike == profileDetailUIModel.isLike && this.isLikeMe == profileDetailUIModel.isLikeMe && Intrinsics.areEqual(this.hasRead, profileDetailUIModel.hasRead) && this.heartPer == profileDetailUIModel.heartPer && this.wealthUserGrade == profileDetailUIModel.wealthUserGrade && this.charmUserGrade == profileDetailUIModel.charmUserGrade && this.activityUserGrade == profileDetailUIModel.activityUserGrade && this.isVip == profileDetailUIModel.isVip && Intrinsics.areEqual(this.medals, profileDetailUIModel.medals) && Intrinsics.areEqual(this.headwear, profileDetailUIModel.headwear) && Intrinsics.areEqual(this.isPrettyCode, profileDetailUIModel.isPrettyCode) && Intrinsics.areEqual(this.currentRoom, profileDetailUIModel.currentRoom) && Intrinsics.areEqual(this.rideBean, profileDetailUIModel.rideBean) && Intrinsics.areEqual(this.medalInfo, profileDetailUIModel.medalInfo) && Intrinsics.areEqual(this.myGroupPowerName, profileDetailUIModel.myGroupPowerName) && this.myGroupPowerId == profileDetailUIModel.myGroupPowerId && Intrinsics.areEqual(this.noble, profileDetailUIModel.noble) && this.isOfficialStaff == profileDetailUIModel.isOfficialStaff && Intrinsics.areEqual(this.countryManager, profileDetailUIModel.countryManager) && Intrinsics.areEqual(this.svip, profileDetailUIModel.svip) && Intrinsics.areEqual(this.groupPower, profileDetailUIModel.groupPower) && Intrinsics.areEqual(this.isCountryId, profileDetailUIModel.isCountryId) && Intrinsics.areEqual(this.mRelationData, profileDetailUIModel.mRelationData);
    }

    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @Nullable
    public final String getAge() {
        return this.age;
    }

    @Nullable
    public final String getBirthdayInFormat() {
        return this.birthdayInFormat;
    }

    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final ImageUIModel getCountryImageUIModel() {
        return this.countryImageUIModel;
    }

    @Nullable
    public final CountryManager getCountryManager() {
        return this.countryManager;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
    }

    @Nullable
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @Nullable
    public final Boolean getHasRead() {
        return this.hasRead;
    }

    @Nullable
    public final HeadWearBean getHeadwear() {
        return this.headwear;
    }

    public final int getHeartPer() {
        return this.heartPer;
    }

    @NotNull
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    public final RelationUserData getMRelationData() {
        return this.mRelationData;
    }

    @Nullable
    public final String getMatchID() {
        return this.matchID;
    }

    @Nullable
    public final List<MedalInfo> getMedalInfo() {
        return this.medalInfo;
    }

    @Nullable
    public final List<Integer> getMedals() {
        return this.medals;
    }

    public final long getMyGroupPowerId() {
        return this.myGroupPowerId;
    }

    @NotNull
    public final String getMyGroupPowerName() {
        return this.myGroupPowerName;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @NotNull
    public final String getPairedDate() {
        return this.pairedDate;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final RideBean getRideBean() {
        return this.rideBean;
    }

    public final int getSex() {
        return this.sex;
    }

    public final int getSexBackgroundResID() {
        return this.sexBackgroundResID;
    }

    public final int getSexIconResId() {
        return this.sexIconResId;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    public int hashCode() {
        int hashCode = ((((((((this.imageUIModel.hashCode() * 31) + a.a(this.isSelected)) * 31) + this.nickname.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.matchID;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.pairedDate.hashCode()) * 31;
        String str3 = this.age;
        int hashCode4 = (((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.position) * 31) + this.countryImageUIModel.hashCode()) * 31) + this.countryName.hashCode()) * 31) + this.sexIconResId) * 31) + this.sex) * 31) + this.sexBackgroundResID) * 31;
        String str4 = this.birthdayInFormat;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.isFreeMessage)) * 31) + a.a(this.isLike)) * 31) + a.a(this.isLikeMe)) * 31;
        Boolean bool = this.hasRead;
        int hashCode6 = (((((((((((hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + this.heartPer) * 31) + c.a(this.wealthUserGrade)) * 31) + c.a(this.charmUserGrade)) * 31) + c.a(this.activityUserGrade)) * 31) + a.a(this.isVip)) * 31;
        List<Integer> list = this.medals;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        HeadWearBean headWearBean = this.headwear;
        int hashCode8 = (hashCode7 + (headWearBean == null ? 0 : headWearBean.hashCode())) * 31;
        Boolean bool2 = this.isPrettyCode;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str5 = this.currentRoom;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        RideBean rideBean = this.rideBean;
        int hashCode11 = (hashCode10 + (rideBean == null ? 0 : rideBean.hashCode())) * 31;
        List<MedalInfo> list2 = this.medalInfo;
        int hashCode12 = (((((hashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.myGroupPowerName.hashCode()) * 31) + c.a(this.myGroupPowerId)) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode13 = (((hashCode12 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31) + a.a(this.isOfficialStaff)) * 31;
        CountryManager countryManager = this.countryManager;
        int hashCode14 = (hashCode13 + (countryManager == null ? 0 : countryManager.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode15 = (hashCode14 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        FamilyInfo familyInfo = this.groupPower;
        int hashCode16 = (hashCode15 + (familyInfo == null ? 0 : familyInfo.hashCode())) * 31;
        Boolean bool3 = this.isCountryId;
        int hashCode17 = (hashCode16 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        RelationUserData relationUserData = this.mRelationData;
        return hashCode17 + (relationUserData != null ? relationUserData.hashCode() : 0);
    }

    @Nullable
    public final Boolean isCountryId() {
        return this.isCountryId;
    }

    public final boolean isFreeMessage() {
        return this.isFreeMessage;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isLikeMe() {
        return this.isLikeMe;
    }

    public final boolean isOfficialStaff() {
        return this.isOfficialStaff;
    }

    @Nullable
    public final Boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setActivityUserGrade(long j) {
        this.activityUserGrade = j;
    }

    public final void setBirthdayInFormat(@Nullable String str) {
        this.birthdayInFormat = str;
    }

    public final void setCharmUserGrade(long j) {
        this.charmUserGrade = j;
    }

    public final void setCountryId(@Nullable Boolean bool) {
        this.isCountryId = bool;
    }

    public final void setCountryManager(@Nullable CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    public final void setCurrentRoom(@Nullable String str) {
        this.currentRoom = str;
    }

    public final void setFreeMessage(boolean z) {
        this.isFreeMessage = z;
    }

    public final void setGroupPower(@Nullable FamilyInfo familyInfo) {
        this.groupPower = familyInfo;
    }

    public final void setHasRead(@Nullable Boolean bool) {
        this.hasRead = bool;
    }

    public final void setHeadwear(@Nullable HeadWearBean headWearBean) {
        this.headwear = headWearBean;
    }

    public final void setHeartPer(int i) {
        this.heartPer = i;
    }

    public final void setLike(boolean z) {
        this.isLike = z;
    }

    public final void setLikeMe(boolean z) {
        this.isLikeMe = z;
    }

    public final void setMRelationData(@Nullable RelationUserData relationUserData) {
        this.mRelationData = relationUserData;
    }

    public final void setMatchID(@Nullable String str) {
        this.matchID = str;
    }

    public final void setMedalInfo(@Nullable List<MedalInfo> list) {
        this.medalInfo = list;
    }

    public final void setMedals(@Nullable List<Integer> list) {
        this.medals = list;
    }

    public final void setMyGroupPowerId(long j) {
        this.myGroupPowerId = j;
    }

    public final void setMyGroupPowerName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.myGroupPowerName = str;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setOfficialStaff(boolean z) {
        this.isOfficialStaff = z;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setRideBean(@Nullable RideBean rideBean) {
        this.rideBean = rideBean;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    public final void setWealthUserGrade(long j) {
        this.wealthUserGrade = j;
    }

    @NotNull
    public String toString() {
        return "ProfileDetailUIModel(imageUIModel=" + this.imageUIModel + ", isSelected=" + this.isSelected + ", nickname=" + this.nickname + ", uid=" + this.uid + ", code=" + this.code + ", matchID=" + this.matchID + ", description=" + this.description + ", pairedDate=" + this.pairedDate + ", age=" + this.age + ", position=" + this.position + ", countryImageUIModel=" + this.countryImageUIModel + ", countryName=" + this.countryName + ", sexIconResId=" + this.sexIconResId + ", sex=" + this.sex + ", sexBackgroundResID=" + this.sexBackgroundResID + ", birthdayInFormat=" + this.birthdayInFormat + ", isFreeMessage=" + this.isFreeMessage + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", hasRead=" + this.hasRead + ", heartPer=" + this.heartPer + ", wealthUserGrade=" + this.wealthUserGrade + ", charmUserGrade=" + this.charmUserGrade + ", activityUserGrade=" + this.activityUserGrade + ", isVip=" + this.isVip + ", medals=" + this.medals + ", headwear=" + this.headwear + ", isPrettyCode=" + this.isPrettyCode + ", currentRoom=" + this.currentRoom + ", rideBean=" + this.rideBean + ", medalInfo=" + this.medalInfo + ", myGroupPowerName=" + this.myGroupPowerName + ", myGroupPowerId=" + this.myGroupPowerId + ", noble=" + this.noble + ", isOfficialStaff=" + this.isOfficialStaff + ", countryManager=" + this.countryManager + ", svip=" + this.svip + ", groupPower=" + this.groupPower + ", isCountryId=" + this.isCountryId + ", mRelationData=" + this.mRelationData + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.imageUIModel.writeToParcel(dest, flags);
        dest.writeInt(this.isSelected ? 1 : 0);
        dest.writeString(this.nickname);
        dest.writeString(this.uid);
        dest.writeString(this.code);
        dest.writeString(this.matchID);
        dest.writeString(this.description);
        dest.writeString(this.pairedDate);
        dest.writeString(this.age);
        dest.writeInt(this.position);
        this.countryImageUIModel.writeToParcel(dest, flags);
        dest.writeString(this.countryName);
        dest.writeInt(this.sexIconResId);
        dest.writeInt(this.sex);
        dest.writeInt(this.sexBackgroundResID);
        dest.writeString(this.birthdayInFormat);
        dest.writeInt(this.isFreeMessage ? 1 : 0);
        dest.writeInt(this.isLike ? 1 : 0);
        dest.writeInt(this.isLikeMe ? 1 : 0);
        Boolean bool = this.hasRead;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.heartPer);
        dest.writeLong(this.wealthUserGrade);
        dest.writeLong(this.charmUserGrade);
        dest.writeLong(this.activityUserGrade);
        dest.writeInt(this.isVip ? 1 : 0);
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
        dest.writeParcelable(this.headwear, flags);
        Boolean bool2 = this.isPrettyCode;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.currentRoom);
        dest.writeParcelable(this.rideBean, flags);
        List<MedalInfo> list2 = this.medalInfo;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<MedalInfo> it2 = list2.iterator();
            while (it2.hasNext()) {
                dest.writeParcelable((Parcelable) it2.next(), flags);
            }
        }
        dest.writeString(this.myGroupPowerName);
        dest.writeLong(this.myGroupPowerId);
        dest.writeParcelable(this.noble, flags);
        dest.writeInt(this.isOfficialStaff ? 1 : 0);
        dest.writeParcelable(this.countryManager, flags);
        dest.writeParcelable(this.svip, flags);
        dest.writeParcelable(this.groupPower, flags);
        Boolean bool3 = this.isCountryId;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        dest.writeParcelable(this.mRelationData, flags);
    }

    public /* synthetic */ ProfileDetailUIModel(ImageUIModel imageUIModel, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, ImageUIModel imageUIModel2, String str8, int i2, int i3, int i4, String str9, boolean z2, boolean z3, boolean z4, Boolean bool, int i5, long j, long j2, long j3, boolean z5, List list, HeadWearBean headWearBean, Boolean bool2, String str10, RideBean rideBean, List list2, String str11, long j4, NobleInfo nobleInfo, boolean z6, CountryManager countryManager, SvipData svipData, FamilyInfo familyInfo, Boolean bool3, RelationUserData relationUserData, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageUIModel, z, str, str2, str3, (i6 & 32) != 0 ? null : str4, str5, str6, str7, i, imageUIModel2, str8, i2, i3, i4, str9, z2, z3, (i6 & 262144) != 0 ? false : z4, (i6 & 524288) != 0 ? null : bool, i5, (i6 & 2097152) != 0 ? 0L : j, (i6 & 4194304) != 0 ? 0L : j2, (i6 & 8388608) != 0 ? 0L : j3, (i6 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? false : z5, (i6 & 33554432) != 0 ? null : list, (i6 & 67108864) != 0 ? null : headWearBean, (i6 & 134217728) != 0 ? Boolean.FALSE : bool2, (i6 & 268435456) != 0 ? "" : str10, (i6 & 536870912) != 0 ? null : rideBean, (i6 & 1073741824) != 0 ? null : list2, (i6 & Integer.MIN_VALUE) != 0 ? "" : str11, (i7 & 1) != 0 ? 0L : j4, (i7 & 2) != 0 ? null : nobleInfo, (i7 & 4) != 0 ? false : z6, (i7 & 8) != 0 ? null : countryManager, (i7 & 16) != 0 ? null : svipData, (i7 & 32) != 0 ? null : familyInfo, (i7 & 64) != 0 ? null : bool3, (i7 & 128) != 0 ? null : relationUserData);
    }
}
