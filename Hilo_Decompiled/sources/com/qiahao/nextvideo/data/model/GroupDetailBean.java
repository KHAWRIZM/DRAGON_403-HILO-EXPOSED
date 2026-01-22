package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.RoomRuleBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.game.GameConfig;
import com.qiahao.nextvideo.data.room.RoomEnvelopeConfig;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.room.viewmodel.GroupSettingViewModel;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Settings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0003\b³\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0018\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0018\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018\u0012\b\b\u0002\u0010=\u001a\u00020\u000e\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b@\u0010AJ\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010½\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010VJ\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\n\u0010Å\u0001\u001a\u00020\fHÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ç\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0012\u0010Ì\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010Ò\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ô\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0012\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0018HÆ\u0003J\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010×\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010Ø\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0012\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0018HÆ\u0003J\u0012\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018HÆ\u0003J\u0012\u0010Û\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0018HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010â\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010ä\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0012\u0010ç\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018HÆ\u0003J\n\u0010è\u0001\u001a\u00020\u000eHÆ\u0003J\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jð\u0004\u0010ë\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00182\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00182\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00182\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00182\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\b\b\u0002\u0010=\u001a\u00020\u000e2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010ì\u0001J\u0016\u0010í\u0001\u001a\u00020\f2\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001HÖ\u0003J\n\u0010ð\u0001\u001a\u00020\u000eHÖ\u0001J\n\u0010ñ\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010C\"\u0004\bN\u0010ER\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010C\"\u0004\bP\u0010ER\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010C\"\u0004\bR\u0010ER\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bS\u0010I\"\u0004\bT\u0010KR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010C\"\u0004\bf\u0010ER\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bg\u0010[\"\u0004\bh\u0010]R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010C\"\u0004\bj\u0010ER\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010C\"\u0004\bl\u0010ER\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010C\"\u0004\bn\u0010ER\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bo\u0010[\"\u0004\bp\u0010]R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010C\"\u0004\bv\u0010ER\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bw\u0010[\"\u0004\bx\u0010]R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\by\u0010[\"\u0004\bz\u0010]R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010C\"\u0004\b|\u0010ER\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\b}\u0010I\"\u0004\b~\u0010KR\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0011\n\u0002\u0010^\u001a\u0004\b\u007f\u0010[\"\u0005\b\u0080\u0001\u0010]R\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010C\"\u0005\b\u0082\u0001\u0010ER \u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u0083\u0001\u0010[\"\u0005\b\u0084\u0001\u0010]R$\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010r\"\u0005\b\u0086\u0001\u0010tR \u0010$\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u0087\u0001\u0010[\"\u0005\b\u0088\u0001\u0010]R \u0010%\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u0089\u0001\u0010[\"\u0005\b\u008a\u0001\u0010]R \u0010&\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u008b\u0001\u0010[\"\u0005\b\u008c\u0001\u0010]R$\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010r\"\u0005\b\u008e\u0001\u0010tR$\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010r\"\u0005\b\u0090\u0001\u0010tR$\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010r\"\u0005\b\u0092\u0001\u0010tR \u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R \u00101\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u009b\u0001\u0010[\"\u0005\b\u009c\u0001\u0010]R \u00102\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u009d\u0001\u0010[\"\u0005\b\u009e\u0001\u0010]R \u00103\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u009f\u0001\u0010[\"\u0005\b \u0001\u0010]R \u00104\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b¡\u0001\u0010[\"\u0005\b¢\u0001\u0010]R \u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R \u00107\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b§\u0001\u0010[\"\u0005\b¨\u0001\u0010]R \u00108\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b©\u0001\u0010[\"\u0005\bª\u0001\u0010]R\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010C\"\u0005\b¬\u0001\u0010ER \u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R$\u0010<\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010r\"\u0005\b²\u0001\u0010tR\u001e\u0010=\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R \u0010>\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b·\u0001\u0010[\"\u0005\b¸\u0001\u0010]R\u001e\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010C\"\u0005\bº\u0001\u0010E¨\u0006ò\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "Ljava/io/Serializable;", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "loadHistory", "", "maxMemberNum", "", "memberNum", "micOn", "name", "nextMsgSeq", "notification", "ownerAccount", "password", "role", "role_members", "", "Lcom/qiahao/nextvideo/data/model/RoleMember;", "shutUpAllMember", "micNumType", "groupInUserDuration", "welcomeText", "totalConsume", "themeId", "themeUrl", "themeType", "topConsumers", "Lcom/qiahao/nextvideo/data/model/TopConsumersBean;", "diceNum", "diceType", "supportLevel", "roleMembers", "Lcom/qiahao/base_common/model/RoomRuleBean;", "groupMedals", "Lcom/qiahao/nextvideo/data/model/GroupMedalBean;", "banners", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "luckyWheel", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", TUIConstants.TUIChat.OWNER, "Lcom/qiahao/base_common/model/common/User;", GroupSettingViewModel.TOURIST_MIC, GroupSettingViewModel.TOURIST_MSG, GroupSettingViewModel.TOURIST_PIC, "memberFee", "gameConfig", "Lcom/qiahao/nextvideo/data/game/GameConfig;", "entryEffectType", "cpLevel", "cpUserAvatar", "luckyBag", "Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;", "groupPk1V1", "notRecommend", "taskAwardCnt", "groupHeadwear", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/qiahao/nextvideo/data/game/GameConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;Ljava/util/List;ILjava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getCountryIcon", "setCountryIcon", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFaceUrl", "setFaceUrl", "getGroupId", "setGroupId", "getIntroduction", "setIntroduction", "getLastMsgTime", "setLastMsgTime", "getLoadHistory", "()Ljava/lang/Boolean;", "setLoadHistory", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxMemberNum", "()Ljava/lang/Integer;", "setMaxMemberNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMemberNum", "setMemberNum", "getMicOn", "()Z", "setMicOn", "(Z)V", "getName", "setName", "getNextMsgSeq", "setNextMsgSeq", "getNotification", "setNotification", "getOwnerAccount", "setOwnerAccount", "getPassword", "setPassword", "getRole", "setRole", "getRole_members", "()Ljava/util/List;", "setRole_members", "(Ljava/util/List;)V", "getShutUpAllMember", "setShutUpAllMember", "getMicNumType", "setMicNumType", "getGroupInUserDuration", "setGroupInUserDuration", "getWelcomeText", "setWelcomeText", "getTotalConsume", "setTotalConsume", "getThemeId", "setThemeId", "getThemeUrl", "setThemeUrl", "getThemeType", "setThemeType", "getTopConsumers", "setTopConsumers", "getDiceNum", "setDiceNum", "getDiceType", "setDiceType", "getSupportLevel", "setSupportLevel", "getRoleMembers", "setRoleMembers", "getGroupMedals", "setGroupMedals", "getBanners", "setBanners", "getLuckyWheel", "()Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "setLuckyWheel", "(Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;)V", "getOwner", "()Lcom/qiahao/base_common/model/common/User;", "setOwner", "(Lcom/qiahao/base_common/model/common/User;)V", "getTouristMic", "setTouristMic", "getTouristSendMsg", "setTouristSendMsg", "getTouristSendPic", "setTouristSendPic", "getMemberFee", "setMemberFee", "getGameConfig", "()Lcom/qiahao/nextvideo/data/game/GameConfig;", "setGameConfig", "(Lcom/qiahao/nextvideo/data/game/GameConfig;)V", "getEntryEffectType", "setEntryEffectType", "getCpLevel", "setCpLevel", "getCpUserAvatar", "setCpUserAvatar", "getLuckyBag", "()Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;", "setLuckyBag", "(Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;)V", "getGroupPk1V1", "setGroupPk1V1", "getNotRecommend", "()I", "setNotRecommend", "(I)V", "getTaskAwardCnt", "setTaskAwardCnt", "getGroupHeadwear", "setGroupHeadwear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/qiahao/nextvideo/data/game/GameConfig;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;Ljava/util/List;ILjava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupDetailBean implements Serializable {

    @Nullable
    private List<GroupTopBannerBean> banners;

    @Nullable
    private String code;

    @Nullable
    private String countryIcon;

    @Nullable
    private Integer cpLevel;

    @Nullable
    private String cpUserAvatar;

    @Nullable
    private Long createTime;

    @Nullable
    private Integer diceNum;

    @Nullable
    private Integer diceType;

    @Nullable
    private Integer entryEffectType;

    @Nullable
    private String faceUrl;

    @Nullable
    private GameConfig gameConfig;

    @Nullable
    private String groupHeadwear;

    @Nullable
    private String groupId;

    @Nullable
    private Integer groupInUserDuration;

    @Nullable
    private List<GroupMedalBean> groupMedals;

    @Nullable
    private List<Integer> groupPk1V1;

    @Nullable
    private String introduction;

    @Nullable
    private Long lastMsgTime;

    @Nullable
    private Boolean loadHistory;

    @Nullable
    private RoomEnvelopeConfig luckyBag;

    @Nullable
    private LuckWheelInfo luckyWheel;

    @Nullable
    private Integer maxMemberNum;

    @Nullable
    private Integer memberFee;

    @Nullable
    private Integer memberNum;

    @Nullable
    private Integer micNumType;
    private boolean micOn;

    @Nullable
    private String name;

    @Nullable
    private Integer nextMsgSeq;
    private int notRecommend;

    @Nullable
    private String notification;

    @Nullable
    private User owner;

    @Nullable
    private String ownerAccount;

    @Nullable
    private String password;

    @Nullable
    private Integer role;

    @Nullable
    private List<RoomRuleBean> roleMembers;

    @Nullable
    private List<RoleMember> role_members;

    @Nullable
    private String shutUpAllMember;

    @Nullable
    private Integer supportLevel;

    @Nullable
    private Integer taskAwardCnt;

    @Nullable
    private Integer themeId;

    @Nullable
    private Integer themeType;

    @Nullable
    private String themeUrl;

    @Nullable
    private List<TopConsumersBean> topConsumers;

    @Nullable
    private Long totalConsume;

    @Nullable
    private Integer touristMic;

    @Nullable
    private Integer touristSendMsg;

    @Nullable
    private Integer touristSendPic;

    @Nullable
    private String welcomeText;

    public GroupDetailBean() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getMemberNum() {
        return this.memberNum;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getMicOn() {
        return this.micOn;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    public final List<RoleMember> component18() {
        return this.role_members;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getMicNumType() {
        return this.micNumType;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Integer getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final String getWelcomeText() {
        return this.welcomeText;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Long getTotalConsume() {
        return this.totalConsume;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getThemeId() {
        return this.themeId;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final Integer getThemeType() {
        return this.themeType;
    }

    @Nullable
    public final List<TopConsumersBean> component27() {
        return this.topConsumers;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final Integer getDiceNum() {
        return this.diceNum;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final Integer getDiceType() {
        return this.diceType;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    /* renamed from: component30, reason: from getter */
    public final Integer getSupportLevel() {
        return this.supportLevel;
    }

    @Nullable
    public final List<RoomRuleBean> component31() {
        return this.roleMembers;
    }

    @Nullable
    public final List<GroupMedalBean> component32() {
        return this.groupMedals;
    }

    @Nullable
    public final List<GroupTopBannerBean> component33() {
        return this.banners;
    }

    @Nullable
    /* renamed from: component34, reason: from getter */
    public final LuckWheelInfo getLuckyWheel() {
        return this.luckyWheel;
    }

    @Nullable
    /* renamed from: component35, reason: from getter */
    public final User getOwner() {
        return this.owner;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final Integer getTouristMic() {
        return this.touristMic;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final Integer getTouristSendMsg() {
        return this.touristSendMsg;
    }

    @Nullable
    /* renamed from: component38, reason: from getter */
    public final Integer getTouristSendPic() {
        return this.touristSendPic;
    }

    @Nullable
    /* renamed from: component39, reason: from getter */
    public final Integer getMemberFee() {
        return this.memberFee;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    /* renamed from: component40, reason: from getter */
    public final GameConfig getGameConfig() {
        return this.gameConfig;
    }

    @Nullable
    /* renamed from: component41, reason: from getter */
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    @Nullable
    /* renamed from: component42, reason: from getter */
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    /* renamed from: component43, reason: from getter */
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    /* renamed from: component44, reason: from getter */
    public final RoomEnvelopeConfig getLuckyBag() {
        return this.luckyBag;
    }

    @Nullable
    public final List<Integer> component45() {
        return this.groupPk1V1;
    }

    /* renamed from: component46, reason: from getter */
    public final int getNotRecommend() {
        return this.notRecommend;
    }

    @Nullable
    /* renamed from: component47, reason: from getter */
    public final Integer getTaskAwardCnt() {
        return this.taskAwardCnt;
    }

    @Nullable
    /* renamed from: component48, reason: from getter */
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getLastMsgTime() {
        return this.lastMsgTime;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Boolean getLoadHistory() {
        return this.loadHistory;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @NotNull
    public final GroupDetailBean copy(@Nullable String code, @Nullable String countryIcon, @Nullable Long createTime, @Nullable String faceUrl, @Nullable String groupId, @Nullable String introduction, @Nullable Long lastMsgTime, @Nullable Boolean loadHistory, @Nullable Integer maxMemberNum, @Nullable Integer memberNum, boolean micOn, @Nullable String name, @Nullable Integer nextMsgSeq, @Nullable String notification, @Nullable String ownerAccount, @Nullable String password, @Nullable Integer role, @Nullable List<RoleMember> role_members, @Nullable String shutUpAllMember, @Nullable Integer micNumType, @Nullable Integer groupInUserDuration, @Nullable String welcomeText, @Nullable Long totalConsume, @Nullable Integer themeId, @Nullable String themeUrl, @Nullable Integer themeType, @Nullable List<TopConsumersBean> topConsumers, @Nullable Integer diceNum, @Nullable Integer diceType, @Nullable Integer supportLevel, @Nullable List<RoomRuleBean> roleMembers, @Nullable List<GroupMedalBean> groupMedals, @Nullable List<GroupTopBannerBean> banners, @Nullable LuckWheelInfo luckyWheel, @Nullable User owner, @Nullable Integer touristMic, @Nullable Integer touristSendMsg, @Nullable Integer touristSendPic, @Nullable Integer memberFee, @Nullable GameConfig gameConfig, @Nullable Integer entryEffectType, @Nullable Integer cpLevel, @Nullable String cpUserAvatar, @Nullable RoomEnvelopeConfig luckyBag, @Nullable List<Integer> groupPk1V1, int notRecommend, @Nullable Integer taskAwardCnt, @Nullable String groupHeadwear) {
        return new GroupDetailBean(code, countryIcon, createTime, faceUrl, groupId, introduction, lastMsgTime, loadHistory, maxMemberNum, memberNum, micOn, name, nextMsgSeq, notification, ownerAccount, password, role, role_members, shutUpAllMember, micNumType, groupInUserDuration, welcomeText, totalConsume, themeId, themeUrl, themeType, topConsumers, diceNum, diceType, supportLevel, roleMembers, groupMedals, banners, luckyWheel, owner, touristMic, touristSendMsg, touristSendPic, memberFee, gameConfig, entryEffectType, cpLevel, cpUserAvatar, luckyBag, groupPk1V1, notRecommend, taskAwardCnt, groupHeadwear);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupDetailBean)) {
            return false;
        }
        GroupDetailBean groupDetailBean = (GroupDetailBean) other;
        return Intrinsics.areEqual(this.code, groupDetailBean.code) && Intrinsics.areEqual(this.countryIcon, groupDetailBean.countryIcon) && Intrinsics.areEqual(this.createTime, groupDetailBean.createTime) && Intrinsics.areEqual(this.faceUrl, groupDetailBean.faceUrl) && Intrinsics.areEqual(this.groupId, groupDetailBean.groupId) && Intrinsics.areEqual(this.introduction, groupDetailBean.introduction) && Intrinsics.areEqual(this.lastMsgTime, groupDetailBean.lastMsgTime) && Intrinsics.areEqual(this.loadHistory, groupDetailBean.loadHistory) && Intrinsics.areEqual(this.maxMemberNum, groupDetailBean.maxMemberNum) && Intrinsics.areEqual(this.memberNum, groupDetailBean.memberNum) && this.micOn == groupDetailBean.micOn && Intrinsics.areEqual(this.name, groupDetailBean.name) && Intrinsics.areEqual(this.nextMsgSeq, groupDetailBean.nextMsgSeq) && Intrinsics.areEqual(this.notification, groupDetailBean.notification) && Intrinsics.areEqual(this.ownerAccount, groupDetailBean.ownerAccount) && Intrinsics.areEqual(this.password, groupDetailBean.password) && Intrinsics.areEqual(this.role, groupDetailBean.role) && Intrinsics.areEqual(this.role_members, groupDetailBean.role_members) && Intrinsics.areEqual(this.shutUpAllMember, groupDetailBean.shutUpAllMember) && Intrinsics.areEqual(this.micNumType, groupDetailBean.micNumType) && Intrinsics.areEqual(this.groupInUserDuration, groupDetailBean.groupInUserDuration) && Intrinsics.areEqual(this.welcomeText, groupDetailBean.welcomeText) && Intrinsics.areEqual(this.totalConsume, groupDetailBean.totalConsume) && Intrinsics.areEqual(this.themeId, groupDetailBean.themeId) && Intrinsics.areEqual(this.themeUrl, groupDetailBean.themeUrl) && Intrinsics.areEqual(this.themeType, groupDetailBean.themeType) && Intrinsics.areEqual(this.topConsumers, groupDetailBean.topConsumers) && Intrinsics.areEqual(this.diceNum, groupDetailBean.diceNum) && Intrinsics.areEqual(this.diceType, groupDetailBean.diceType) && Intrinsics.areEqual(this.supportLevel, groupDetailBean.supportLevel) && Intrinsics.areEqual(this.roleMembers, groupDetailBean.roleMembers) && Intrinsics.areEqual(this.groupMedals, groupDetailBean.groupMedals) && Intrinsics.areEqual(this.banners, groupDetailBean.banners) && Intrinsics.areEqual(this.luckyWheel, groupDetailBean.luckyWheel) && Intrinsics.areEqual(this.owner, groupDetailBean.owner) && Intrinsics.areEqual(this.touristMic, groupDetailBean.touristMic) && Intrinsics.areEqual(this.touristSendMsg, groupDetailBean.touristSendMsg) && Intrinsics.areEqual(this.touristSendPic, groupDetailBean.touristSendPic) && Intrinsics.areEqual(this.memberFee, groupDetailBean.memberFee) && Intrinsics.areEqual(this.gameConfig, groupDetailBean.gameConfig) && Intrinsics.areEqual(this.entryEffectType, groupDetailBean.entryEffectType) && Intrinsics.areEqual(this.cpLevel, groupDetailBean.cpLevel) && Intrinsics.areEqual(this.cpUserAvatar, groupDetailBean.cpUserAvatar) && Intrinsics.areEqual(this.luckyBag, groupDetailBean.luckyBag) && Intrinsics.areEqual(this.groupPk1V1, groupDetailBean.groupPk1V1) && this.notRecommend == groupDetailBean.notRecommend && Intrinsics.areEqual(this.taskAwardCnt, groupDetailBean.taskAwardCnt) && Intrinsics.areEqual(this.groupHeadwear, groupDetailBean.groupHeadwear);
    }

    @Nullable
    public final List<GroupTopBannerBean> getBanners() {
        return this.banners;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final Integer getDiceNum() {
        return this.diceNum;
    }

    @Nullable
    public final Integer getDiceType() {
        return this.diceType;
    }

    @Nullable
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final GameConfig getGameConfig() {
        return this.gameConfig;
    }

    @Nullable
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Integer getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    public final List<GroupMedalBean> getGroupMedals() {
        return this.groupMedals;
    }

    @Nullable
    public final List<Integer> getGroupPk1V1() {
        return this.groupPk1V1;
    }

    @Nullable
    public final String getIntroduction() {
        return this.introduction;
    }

    @Nullable
    public final Long getLastMsgTime() {
        return this.lastMsgTime;
    }

    @Nullable
    public final Boolean getLoadHistory() {
        return this.loadHistory;
    }

    @Nullable
    public final RoomEnvelopeConfig getLuckyBag() {
        return this.luckyBag;
    }

    @Nullable
    public final LuckWheelInfo getLuckyWheel() {
        return this.luckyWheel;
    }

    @Nullable
    public final Integer getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @Nullable
    public final Integer getMemberFee() {
        return this.memberFee;
    }

    @Nullable
    public final Integer getMemberNum() {
        return this.memberNum;
    }

    @Nullable
    public final Integer getMicNumType() {
        return this.micNumType;
    }

    public final boolean getMicOn() {
        return this.micOn;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    public final int getNotRecommend() {
        return this.notRecommend;
    }

    @Nullable
    public final String getNotification() {
        return this.notification;
    }

    @Nullable
    public final User getOwner() {
        return this.owner;
    }

    @Nullable
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    public final List<RoomRuleBean> getRoleMembers() {
        return this.roleMembers;
    }

    @Nullable
    public final List<RoleMember> getRole_members() {
        return this.role_members;
    }

    @Nullable
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    @Nullable
    public final Integer getSupportLevel() {
        return this.supportLevel;
    }

    @Nullable
    public final Integer getTaskAwardCnt() {
        return this.taskAwardCnt;
    }

    @Nullable
    public final Integer getThemeId() {
        return this.themeId;
    }

    @Nullable
    public final Integer getThemeType() {
        return this.themeType;
    }

    @Nullable
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    @Nullable
    public final List<TopConsumersBean> getTopConsumers() {
        return this.topConsumers;
    }

    @Nullable
    public final Long getTotalConsume() {
        return this.totalConsume;
    }

    @Nullable
    public final Integer getTouristMic() {
        return this.touristMic;
    }

    @Nullable
    public final Integer getTouristSendMsg() {
        return this.touristSendMsg;
    }

    @Nullable
    public final Integer getTouristSendPic() {
        return this.touristSendPic;
    }

    @Nullable
    public final String getWelcomeText() {
        return this.welcomeText;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.countryIcon;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.createTime;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.faceUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.groupId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.introduction;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l2 = this.lastMsgTime;
        int hashCode7 = (hashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool = this.loadHistory;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.maxMemberNum;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.memberNum;
        int hashCode10 = (((hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31) + a.a(this.micOn)) * 31;
        String str6 = this.name;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.nextMsgSeq;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.notification;
        int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.ownerAccount;
        int hashCode14 = (hashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.password;
        int hashCode15 = (hashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num4 = this.role;
        int hashCode16 = (hashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        List<RoleMember> list = this.role_members;
        int hashCode17 = (hashCode16 + (list == null ? 0 : list.hashCode())) * 31;
        String str10 = this.shutUpAllMember;
        int hashCode18 = (hashCode17 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num5 = this.micNumType;
        int hashCode19 = (hashCode18 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.groupInUserDuration;
        int hashCode20 = (hashCode19 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str11 = this.welcomeText;
        int hashCode21 = (hashCode20 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Long l3 = this.totalConsume;
        int hashCode22 = (hashCode21 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num7 = this.themeId;
        int hashCode23 = (hashCode22 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str12 = this.themeUrl;
        int hashCode24 = (hashCode23 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num8 = this.themeType;
        int hashCode25 = (hashCode24 + (num8 == null ? 0 : num8.hashCode())) * 31;
        List<TopConsumersBean> list2 = this.topConsumers;
        int hashCode26 = (hashCode25 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num9 = this.diceNum;
        int hashCode27 = (hashCode26 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.diceType;
        int hashCode28 = (hashCode27 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.supportLevel;
        int hashCode29 = (hashCode28 + (num11 == null ? 0 : num11.hashCode())) * 31;
        List<RoomRuleBean> list3 = this.roleMembers;
        int hashCode30 = (hashCode29 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<GroupMedalBean> list4 = this.groupMedals;
        int hashCode31 = (hashCode30 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<GroupTopBannerBean> list5 = this.banners;
        int hashCode32 = (hashCode31 + (list5 == null ? 0 : list5.hashCode())) * 31;
        LuckWheelInfo luckWheelInfo = this.luckyWheel;
        int hashCode33 = (hashCode32 + (luckWheelInfo == null ? 0 : luckWheelInfo.hashCode())) * 31;
        User user = this.owner;
        int hashCode34 = (hashCode33 + (user == null ? 0 : user.hashCode())) * 31;
        Integer num12 = this.touristMic;
        int hashCode35 = (hashCode34 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.touristSendMsg;
        int hashCode36 = (hashCode35 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.touristSendPic;
        int hashCode37 = (hashCode36 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.memberFee;
        int hashCode38 = (hashCode37 + (num15 == null ? 0 : num15.hashCode())) * 31;
        GameConfig gameConfig = this.gameConfig;
        int hashCode39 = (hashCode38 + (gameConfig == null ? 0 : gameConfig.hashCode())) * 31;
        Integer num16 = this.entryEffectType;
        int hashCode40 = (hashCode39 + (num16 == null ? 0 : num16.hashCode())) * 31;
        Integer num17 = this.cpLevel;
        int hashCode41 = (hashCode40 + (num17 == null ? 0 : num17.hashCode())) * 31;
        String str13 = this.cpUserAvatar;
        int hashCode42 = (hashCode41 + (str13 == null ? 0 : str13.hashCode())) * 31;
        RoomEnvelopeConfig roomEnvelopeConfig = this.luckyBag;
        int hashCode43 = (hashCode42 + (roomEnvelopeConfig == null ? 0 : roomEnvelopeConfig.hashCode())) * 31;
        List<Integer> list6 = this.groupPk1V1;
        int hashCode44 = (((hashCode43 + (list6 == null ? 0 : list6.hashCode())) * 31) + this.notRecommend) * 31;
        Integer num18 = this.taskAwardCnt;
        int hashCode45 = (hashCode44 + (num18 == null ? 0 : num18.hashCode())) * 31;
        String str14 = this.groupHeadwear;
        return hashCode45 + (str14 != null ? str14.hashCode() : 0);
    }

    public final void setBanners(@Nullable List<GroupTopBannerBean> list) {
        this.banners = list;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setCountryIcon(@Nullable String str) {
        this.countryIcon = str;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    public final void setCpUserAvatar(@Nullable String str) {
        this.cpUserAvatar = str;
    }

    public final void setCreateTime(@Nullable Long l) {
        this.createTime = l;
    }

    public final void setDiceNum(@Nullable Integer num) {
        this.diceNum = num;
    }

    public final void setDiceType(@Nullable Integer num) {
        this.diceType = num;
    }

    public final void setEntryEffectType(@Nullable Integer num) {
        this.entryEffectType = num;
    }

    public final void setFaceUrl(@Nullable String str) {
        this.faceUrl = str;
    }

    public final void setGameConfig(@Nullable GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public final void setGroupHeadwear(@Nullable String str) {
        this.groupHeadwear = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setGroupInUserDuration(@Nullable Integer num) {
        this.groupInUserDuration = num;
    }

    public final void setGroupMedals(@Nullable List<GroupMedalBean> list) {
        this.groupMedals = list;
    }

    public final void setGroupPk1V1(@Nullable List<Integer> list) {
        this.groupPk1V1 = list;
    }

    public final void setIntroduction(@Nullable String str) {
        this.introduction = str;
    }

    public final void setLastMsgTime(@Nullable Long l) {
        this.lastMsgTime = l;
    }

    public final void setLoadHistory(@Nullable Boolean bool) {
        this.loadHistory = bool;
    }

    public final void setLuckyBag(@Nullable RoomEnvelopeConfig roomEnvelopeConfig) {
        this.luckyBag = roomEnvelopeConfig;
    }

    public final void setLuckyWheel(@Nullable LuckWheelInfo luckWheelInfo) {
        this.luckyWheel = luckWheelInfo;
    }

    public final void setMaxMemberNum(@Nullable Integer num) {
        this.maxMemberNum = num;
    }

    public final void setMemberFee(@Nullable Integer num) {
        this.memberFee = num;
    }

    public final void setMemberNum(@Nullable Integer num) {
        this.memberNum = num;
    }

    public final void setMicNumType(@Nullable Integer num) {
        this.micNumType = num;
    }

    public final void setMicOn(boolean z) {
        this.micOn = z;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNextMsgSeq(@Nullable Integer num) {
        this.nextMsgSeq = num;
    }

    public final void setNotRecommend(int i) {
        this.notRecommend = i;
    }

    public final void setNotification(@Nullable String str) {
        this.notification = str;
    }

    public final void setOwner(@Nullable User user) {
        this.owner = user;
    }

    public final void setOwnerAccount(@Nullable String str) {
        this.ownerAccount = str;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setRole(@Nullable Integer num) {
        this.role = num;
    }

    public final void setRoleMembers(@Nullable List<RoomRuleBean> list) {
        this.roleMembers = list;
    }

    public final void setRole_members(@Nullable List<RoleMember> list) {
        this.role_members = list;
    }

    public final void setShutUpAllMember(@Nullable String str) {
        this.shutUpAllMember = str;
    }

    public final void setSupportLevel(@Nullable Integer num) {
        this.supportLevel = num;
    }

    public final void setTaskAwardCnt(@Nullable Integer num) {
        this.taskAwardCnt = num;
    }

    public final void setThemeId(@Nullable Integer num) {
        this.themeId = num;
    }

    public final void setThemeType(@Nullable Integer num) {
        this.themeType = num;
    }

    public final void setThemeUrl(@Nullable String str) {
        this.themeUrl = str;
    }

    public final void setTopConsumers(@Nullable List<TopConsumersBean> list) {
        this.topConsumers = list;
    }

    public final void setTotalConsume(@Nullable Long l) {
        this.totalConsume = l;
    }

    public final void setTouristMic(@Nullable Integer num) {
        this.touristMic = num;
    }

    public final void setTouristSendMsg(@Nullable Integer num) {
        this.touristSendMsg = num;
    }

    public final void setTouristSendPic(@Nullable Integer num) {
        this.touristSendPic = num;
    }

    public final void setWelcomeText(@Nullable String str) {
        this.welcomeText = str;
    }

    @NotNull
    public String toString() {
        return "GroupDetailBean(code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", loadHistory=" + this.loadHistory + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", micOn=" + this.micOn + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", password=" + this.password + ", role=" + this.role + ", role_members=" + this.role_members + ", shutUpAllMember=" + this.shutUpAllMember + ", micNumType=" + this.micNumType + ", groupInUserDuration=" + this.groupInUserDuration + ", welcomeText=" + this.welcomeText + ", totalConsume=" + this.totalConsume + ", themeId=" + this.themeId + ", themeUrl=" + this.themeUrl + ", themeType=" + this.themeType + ", topConsumers=" + this.topConsumers + ", diceNum=" + this.diceNum + ", diceType=" + this.diceType + ", supportLevel=" + this.supportLevel + ", roleMembers=" + this.roleMembers + ", groupMedals=" + this.groupMedals + ", banners=" + this.banners + ", luckyWheel=" + this.luckyWheel + ", owner=" + this.owner + ", touristMic=" + this.touristMic + ", touristSendMsg=" + this.touristSendMsg + ", touristSendPic=" + this.touristSendPic + ", memberFee=" + this.memberFee + ", gameConfig=" + this.gameConfig + ", entryEffectType=" + this.entryEffectType + ", cpLevel=" + this.cpLevel + ", cpUserAvatar=" + this.cpUserAvatar + ", luckyBag=" + this.luckyBag + ", groupPk1V1=" + this.groupPk1V1 + ", notRecommend=" + this.notRecommend + ", taskAwardCnt=" + this.taskAwardCnt + ", groupHeadwear=" + this.groupHeadwear + ")";
    }

    public GroupDetailBean(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Long l2, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, boolean z, @Nullable String str6, @Nullable Integer num3, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Integer num4, @Nullable List<RoleMember> list, @Nullable String str10, @Nullable Integer num5, @Nullable Integer num6, @Nullable String str11, @Nullable Long l3, @Nullable Integer num7, @Nullable String str12, @Nullable Integer num8, @Nullable List<TopConsumersBean> list2, @Nullable Integer num9, @Nullable Integer num10, @Nullable Integer num11, @Nullable List<RoomRuleBean> list3, @Nullable List<GroupMedalBean> list4, @Nullable List<GroupTopBannerBean> list5, @Nullable LuckWheelInfo luckWheelInfo, @Nullable User user, @Nullable Integer num12, @Nullable Integer num13, @Nullable Integer num14, @Nullable Integer num15, @Nullable GameConfig gameConfig, @Nullable Integer num16, @Nullable Integer num17, @Nullable String str13, @Nullable RoomEnvelopeConfig roomEnvelopeConfig, @Nullable List<Integer> list6, int i, @Nullable Integer num18, @Nullable String str14) {
        this.code = str;
        this.countryIcon = str2;
        this.createTime = l;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = l2;
        this.loadHistory = bool;
        this.maxMemberNum = num;
        this.memberNum = num2;
        this.micOn = z;
        this.name = str6;
        this.nextMsgSeq = num3;
        this.notification = str7;
        this.ownerAccount = str8;
        this.password = str9;
        this.role = num4;
        this.role_members = list;
        this.shutUpAllMember = str10;
        this.micNumType = num5;
        this.groupInUserDuration = num6;
        this.welcomeText = str11;
        this.totalConsume = l3;
        this.themeId = num7;
        this.themeUrl = str12;
        this.themeType = num8;
        this.topConsumers = list2;
        this.diceNum = num9;
        this.diceType = num10;
        this.supportLevel = num11;
        this.roleMembers = list3;
        this.groupMedals = list4;
        this.banners = list5;
        this.luckyWheel = luckWheelInfo;
        this.owner = user;
        this.touristMic = num12;
        this.touristSendMsg = num13;
        this.touristSendPic = num14;
        this.memberFee = num15;
        this.gameConfig = gameConfig;
        this.entryEffectType = num16;
        this.cpLevel = num17;
        this.cpUserAvatar = str13;
        this.luckyBag = roomEnvelopeConfig;
        this.groupPk1V1 = list6;
        this.notRecommend = i;
        this.taskAwardCnt = num18;
        this.groupHeadwear = str14;
    }

    public /* synthetic */ GroupDetailBean(String str, String str2, Long l, String str3, String str4, String str5, Long l2, Boolean bool, Integer num, Integer num2, boolean z, String str6, Integer num3, String str7, String str8, String str9, Integer num4, List list, String str10, Integer num5, Integer num6, String str11, Long l3, Integer num7, String str12, Integer num8, List list2, Integer num9, Integer num10, Integer num11, List list3, List list4, List list5, LuckWheelInfo luckWheelInfo, User user, Integer num12, Integer num13, Integer num14, Integer num15, GameConfig gameConfig, Integer num16, Integer num17, String str13, RoomEnvelopeConfig roomEnvelopeConfig, List list6, int i, Integer num18, String str14, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : l2, (i2 & 128) != 0 ? null : bool, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? null : num2, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? true : z, (i2 & 2048) != 0 ? null : str6, (i2 & 4096) != 0 ? null : num3, (i2 & 8192) != 0 ? null : str7, (i2 & 16384) != 0 ? null : str8, (i2 & 32768) != 0 ? null : str9, (i2 & 65536) != 0 ? null : num4, (i2 & 131072) != 0 ? null : list, (i2 & 262144) != 0 ? null : str10, (i2 & 524288) != 0 ? null : num5, (i2 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? null : num6, (i2 & 2097152) != 0 ? null : str11, (i2 & 4194304) != 0 ? null : l3, (i2 & 8388608) != 0 ? null : num7, (i2 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : str12, (i2 & 33554432) != 0 ? null : num8, (i2 & 67108864) != 0 ? null : list2, (i2 & 134217728) != 0 ? null : num9, (i2 & 268435456) != 0 ? null : num10, (i2 & 536870912) != 0 ? null : num11, (i2 & 1073741824) != 0 ? null : list3, (i2 & Integer.MIN_VALUE) != 0 ? null : list4, (i3 & 1) != 0 ? null : list5, (i3 & 2) != 0 ? null : luckWheelInfo, (i3 & 4) != 0 ? null : user, (i3 & 8) != 0 ? null : num12, (i3 & 16) != 0 ? null : num13, (i3 & 32) != 0 ? null : num14, (i3 & 64) != 0 ? null : num15, (i3 & 128) != 0 ? null : gameConfig, (i3 & 256) != 0 ? null : num16, (i3 & 512) != 0 ? null : num17, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str13, (i3 & 2048) != 0 ? null : roomEnvelopeConfig, (i3 & 4096) != 0 ? null : list6, (i3 & 8192) != 0 ? 0 : i, (i3 & 16384) != 0 ? null : num18, (i3 & 32768) != 0 ? null : str14);
    }
}
