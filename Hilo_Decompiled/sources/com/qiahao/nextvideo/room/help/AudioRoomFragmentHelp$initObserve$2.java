package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.hilo_message.utils.MessageProcessor;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.Pk1v1End;
import com.qiahao.nextvideo.data.game.SUDGameData;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.EnterEffectData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.model.SocketGlobalBroadCastBean;
import com.qiahao.nextvideo.data.model.UserInRoom;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKEnd;
import com.qiahao.nextvideo.data.room.Svip10Signaling;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.signaling.RoomAllGift;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.dialog.PKEndDialog;
import com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.rocket.RoomRocketEnterView;
import com.qiahao.nextvideo.room.view.GlobalRoomBroadCastLayout;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.foodie.FoodieGameDialog;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import io.agora.rtc.IRtcEngineEventHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import roomMessage.RoomMessage;
import userProxy.UserProxy1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2", f = "AudioRoomFragmentHelp.kt", i = {}, l = {1234}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$initObserve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2$1", f = "AudioRoomFragmentHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super RoomEvent>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Throwable th = (Throwable) this.L$0;
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "房间事件处理出错" + th.getMessage(), false, 4, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(FlowCollector<? super RoomEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudioRoomFragmentHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initObserve$2$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3693:1\n13472#2,2:3694\n*S KotlinDebug\n*F\n+ 1 AudioRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initObserve$2$2\n*L\n1421#1:3694,2\n*E\n"})
    /* renamed from: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ AudioRoomFragmentHelp this$0;

        AnonymousClass2(AudioRoomFragmentHelp audioRoomFragmentHelp, CoroutineScope coroutineScope) {
            this.this$0 = audioRoomFragmentHelp;
            this.$$this$launch = coroutineScope;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$11(final AudioRoomFragmentHelp audioRoomFragmentHelp, final CoroutineScope coroutineScope) {
            audioRoomFragmentHelp.checkPK();
            MeetingRoomManager.INSTANCE.setMicMemberAllRemoteMute(false);
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.y2
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomFragmentHelp$initObserve$2.AnonymousClass2.emit$lambda$11$lambda$10(coroutineScope, audioRoomFragmentHelp);
                }
            }, 1500L);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$11$lambda$10(CoroutineScope coroutineScope, AudioRoomFragmentHelp audioRoomFragmentHelp) {
            RoomTip roomTip = new RoomTip("1000", 4, ResourcesKtxKt.getStringById(coroutineScope, 2131953657));
            RoomMessageView mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout();
            if (mChatLayout != null) {
                RoomMessageView.addData$default(mChatLayout, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "1000", roomTip, (User) null, 0, 24, (Object) null), false, 2, (Object) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$13(RoomPKEnd roomPKEnd, AudioRoomFragmentHelp audioRoomFragmentHelp) {
            if (roomPKEnd.getWin() == 1) {
                audioRoomFragmentHelp.getFragment().getMViewModel().getPKBox();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$6$lambda$5(ActivityDetailData activityDetailData, AudioRoomFragmentHelp audioRoomFragmentHelp) {
            activityDetailData.setType("105");
            RoomMessageView mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout();
            if (mChatLayout != null) {
                RoomMessageView.addData$default(mChatLayout, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "105", activityDetailData, (User) null, 0, 24, (Object) null), false, 2, (Object) null);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((RoomEvent) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:446:0x0889, code lost:
        
            r2 = r3.getGameId();
         */
        /* JADX WARN: Code restructure failed: missing block: B:447:0x088d, code lost:
        
            if (r2 != null) goto L٤٥٠;
         */
        /* JADX WARN: Code restructure failed: missing block: B:450:0x0894, code lost:
        
            if (r2.intValue() != 22) goto L٤٥٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:451:0x0896, code lost:
        
            r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
            r4 = r2.getMPK();
         */
        /* JADX WARN: Code restructure failed: missing block: B:452:0x089c, code lost:
        
            if (r4 == null) goto L٤٥٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:454:0x08a2, code lost:
        
            if (r4.getStatus() != 0) goto L٤٥٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:455:0x08a4, code lost:
        
            r2.setMPK(null);
            r2.getMBoxLevel().clear();
            r27.this$0.checkPK();
         */
        /* JADX WARN: Removed duplicated region for block: B:786:0x1089 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:3:0x0003, B:22:0x0043, B:24:0x004f, B:26:0x0053, B:27:0x005d, B:29:0x0069, B:30:0x006e, B:32:0x007a, B:33:0x0085, B:35:0x008b, B:37:0x0091, B:39:0x009d, B:41:0x00a1, B:42:0x00a6, B:44:0x00b2, B:45:0x00b7, B:47:0x00c3, B:48:0x00ca, B:50:0x00d6, B:52:0x00da, B:53:0x00df, B:55:0x00eb, B:56:0x00f2, B:58:0x00fe, B:60:0x0102, B:61:0x0107, B:62:0x010e, B:64:0x0116, B:66:0x012d, B:67:0x0138, B:69:0x0140, B:71:0x014c, B:73:0x0152, B:74:0x0164, B:76:0x016c, B:78:0x0178, B:80:0x017e, B:81:0x0185, B:83:0x018d, B:85:0x0195, B:87:0x019b, B:89:0x01a1, B:91:0x01ad, B:93:0x01ed, B:95:0x01f3, B:97:0x01ff, B:99:0x0206, B:101:0x020e, B:103:0x021a, B:105:0x0220, B:106:0x0232, B:108:0x023a, B:110:0x0246, B:112:0x024c, B:113:0x025e, B:115:0x0266, B:117:0x0272, B:119:0x0278, B:120:0x028a, B:122:0x0292, B:123:0x02c8, B:125:0x02d4, B:127:0x02d8, B:128:0x02dd, B:130:0x02e9, B:131:0x02ee, B:133:0x02fa, B:134:0x0305, B:136:0x030b, B:138:0x0311, B:140:0x031d, B:142:0x0321, B:143:0x0326, B:145:0x0332, B:146:0x0337, B:148:0x0343, B:149:0x034a, B:151:0x0356, B:153:0x035a, B:154:0x035f, B:156:0x036b, B:157:0x0372, B:159:0x037e, B:161:0x0382, B:162:0x0387, B:163:0x038e, B:165:0x0396, B:167:0x03ad, B:169:0x03b3, B:170:0x03be, B:172:0x03ca, B:174:0x03d0, B:175:0x03d7, B:177:0x03df, B:179:0x03f6, B:181:0x03fc, B:182:0x0403, B:184:0x040f, B:186:0x0415, B:187:0x041c, B:189:0x0428, B:191:0x042c, B:192:0x0431, B:194:0x043d, B:195:0x0442, B:197:0x044e, B:198:0x0459, B:200:0x045f, B:202:0x0465, B:204:0x0471, B:206:0x0475, B:207:0x047a, B:209:0x0486, B:210:0x048b, B:212:0x0497, B:213:0x049e, B:215:0x04aa, B:217:0x04ae, B:218:0x04b3, B:220:0x04bf, B:221:0x04c6, B:223:0x04d2, B:225:0x04d6, B:226:0x04db, B:227:0x04e2, B:229:0x04ee, B:231:0x04f4, B:232:0x04fb, B:234:0x0507, B:236:0x050b, B:237:0x0510, B:239:0x051c, B:240:0x0521, B:242:0x052d, B:243:0x0538, B:245:0x053e, B:247:0x0544, B:249:0x0550, B:251:0x0554, B:252:0x0559, B:254:0x0565, B:255:0x056a, B:257:0x0576, B:258:0x057d, B:260:0x0589, B:262:0x058d, B:263:0x0592, B:265:0x059e, B:266:0x05a5, B:268:0x05b1, B:270:0x05b5, B:271:0x05ba, B:272:0x05c1, B:274:0x05c9, B:280:0x0649, B:282:0x064f, B:284:0x0655, B:286:0x065b, B:288:0x0667, B:290:0x066d, B:293:0x0670, B:295:0x0676, B:297:0x067c, B:299:0x0682, B:301:0x068e, B:303:0x0694, B:305:0x0697, B:307:0x06a3, B:308:0x06a8, B:310:0x06b4, B:311:0x0608, B:313:0x060e, B:315:0x061a, B:317:0x0620, B:318:0x0625, B:320:0x0631, B:321:0x0636, B:323:0x0642, B:324:0x05d2, B:326:0x05d9, B:328:0x05e5, B:329:0x05ea, B:331:0x05f6, B:333:0x05fc, B:335:0x06bb, B:337:0x06c3, B:339:0x06c9, B:341:0x06d5, B:343:0x06db, B:344:0x06e2, B:346:0x06ea, B:348:0x06f0, B:350:0x06fc, B:352:0x0702, B:353:0x0707, B:354:0x070c, B:356:0x0718, B:359:0x0726, B:361:0x072e, B:363:0x0736, B:365:0x073c, B:367:0x0742, B:370:0x0749, B:372:0x074f, B:373:0x0752, B:375:0x0758, B:376:0x075d, B:378:0x0774, B:379:0x077e, B:381:0x078a, B:383:0x0790, B:384:0x0795, B:386:0x07a1, B:388:0x07a7, B:389:0x07b0, B:390:0x07be, B:392:0x07c1, B:395:0x07d9, B:397:0x07e1, B:400:0x07e9, B:403:0x07f1, B:405:0x07f7, B:407:0x07ff, B:410:0x0812, B:412:0x0806, B:414:0x080c, B:416:0x0815, B:418:0x081b, B:420:0x0821, B:422:0x0827, B:424:0x082d, B:426:0x0830, B:429:0x0880, B:430:0x0837, B:432:0x083d, B:434:0x0843, B:435:0x0854, B:437:0x085a, B:438:0x0863, B:440:0x0869, B:441:0x086e, B:443:0x0874, B:444:0x0879, B:446:0x0889, B:449:0x0890, B:451:0x0896, B:453:0x089e, B:455:0x08a4, B:456:0x08b5, B:458:0x08bc, B:460:0x08c8, B:462:0x08cc, B:463:0x08d1, B:465:0x08dd, B:466:0x08e2, B:468:0x08ee, B:469:0x08f9, B:471:0x08ff, B:473:0x0905, B:475:0x0911, B:477:0x0915, B:478:0x091a, B:480:0x0926, B:481:0x092b, B:483:0x0937, B:484:0x093e, B:486:0x094a, B:488:0x094e, B:489:0x0953, B:491:0x095f, B:492:0x0966, B:494:0x0972, B:496:0x0976, B:497:0x097b, B:498:0x0982, B:500:0x098e, B:502:0x0992, B:503:0x0997, B:505:0x09a3, B:506:0x09a8, B:508:0x09b4, B:509:0x09bf, B:511:0x09c5, B:513:0x09cb, B:515:0x09d7, B:517:0x09db, B:518:0x09e0, B:520:0x09ec, B:521:0x09f1, B:523:0x09fd, B:524:0x0a04, B:526:0x0a10, B:528:0x0a14, B:529:0x0a19, B:531:0x0a25, B:532:0x0a2c, B:534:0x0a38, B:536:0x0a3c, B:537:0x0a41, B:538:0x0a48, B:540:0x0a50, B:542:0x0a53, B:544:0x0a59, B:546:0x0a5c, B:548:0x0a64, B:550:0x0a7b, B:551:0x0ab2, B:553:0x0aba, B:554:0x0abf, B:556:0x0ac5, B:558:0x0ac8, B:560:0x0ace, B:562:0x0ad6, B:565:0x0ae1, B:566:0x0af5, B:567:0x0af9, B:569:0x0b05, B:571:0x0b09, B:572:0x0b0e, B:574:0x0b1a, B:575:0x0b1f, B:577:0x0b2b, B:578:0x0b36, B:580:0x0b3c, B:582:0x0b42, B:584:0x0b4e, B:586:0x0b52, B:587:0x0b57, B:589:0x0b63, B:590:0x0b68, B:592:0x0b74, B:593:0x0b7b, B:595:0x0b87, B:597:0x0b8b, B:598:0x0b90, B:600:0x0b9c, B:601:0x0ba3, B:603:0x0baf, B:605:0x0bb3, B:606:0x0bb8, B:607:0x0bbf, B:609:0x0bcb, B:611:0x0bcf, B:612:0x0bd4, B:614:0x0be0, B:615:0x0be5, B:617:0x0bf1, B:618:0x0bfc, B:620:0x0c02, B:622:0x0c08, B:624:0x0c14, B:626:0x0c18, B:627:0x0c1d, B:629:0x0c29, B:630:0x0c2e, B:632:0x0c3a, B:633:0x0c41, B:635:0x0c4d, B:637:0x0c51, B:638:0x0c56, B:640:0x0c62, B:641:0x0c69, B:643:0x0c75, B:645:0x0c79, B:646:0x0c7e, B:647:0x0c85, B:649:0x0c8d, B:651:0x0c93, B:653:0x0c9f, B:655:0x0ca3, B:656:0x0caa, B:657:0x0cb9, B:659:0x0cbf, B:661:0x0ccb, B:663:0x0ccf, B:664:0x0cd6, B:665:0x0cf2, B:666:0x0cf9, B:668:0x0d01, B:670:0x0d04, B:672:0x0d19, B:674:0x0d23, B:676:0x0d29, B:678:0x0d2f, B:679:0x0d59, B:680:0x0d8d, B:682:0x0db1, B:683:0x0dc0, B:684:0x0dcd, B:686:0x0dd3, B:687:0x0de3, B:688:0x0dfe, B:689:0x0e05, B:691:0x0e1b, B:693:0x0e1f, B:695:0x0e27, B:697:0x0e2e, B:699:0x0e33, B:701:0x0e3f, B:703:0x0e46, B:707:0x0e4e, B:708:0x0e55, B:709:0x0e60, B:711:0x0e72, B:713:0x0e8a, B:714:0x0e99, B:715:0x0e9d, B:717:0x0ebb, B:719:0x0ebf, B:721:0x0ec5, B:723:0x0ec9, B:725:0x0ed5, B:727:0x0ee5, B:731:0x0f04, B:729:0x0f25, B:735:0x0f27, B:736:0x0f29, B:738:0x0f2f, B:740:0x0f6b, B:742:0x0f73, B:744:0x0f7d, B:746:0x0f81, B:747:0x0f86, B:749:0x0f90, B:750:0x0f95, B:752:0x0f9f, B:753:0x0fa4, B:754:0x0fa8, B:756:0x0fb4, B:757:0x0fbb, B:759:0x0fc3, B:761:0x0fda, B:763:0x0fde, B:764:0x0fe3, B:766:0x0fef, B:767:0x0ff6, B:769:0x1018, B:770:0x1023, B:771:0x103e, B:773:0x1046, B:775:0x1061, B:777:0x1068, B:779:0x106e, B:781:0x107d, B:786:0x1089, B:788:0x108f, B:792:0x1099, B:794:0x10a1, B:797:0x10ac, B:800:0x10b5, B:803:0x10be, B:806:0x10c9, B:809:0x10d4, B:818:0x10fb, B:820:0x1107, B:823:0x110f, B:825:0x1116, B:827:0x1137, B:828:0x1140, B:830:0x1156, B:831:0x1163, B:833:0x117c, B:835:0x1180, B:836:0x1189, B:838:0x1195, B:839:0x119a, B:841:0x11aa, B:843:0x11b0, B:845:0x11bc, B:847:0x11c0, B:848:0x11c5, B:850:0x11d1, B:852:0x11d7, B:854:0x11db, B:855:0x11e2, B:857:0x11ee, B:859:0x11f2, B:860:0x11f7, B:862:0x1203, B:864:0x1209, B:866:0x120d, B:867:0x1214, B:869:0x1220, B:871:0x1224, B:872:0x1229, B:874:0x1235, B:876:0x123b, B:878:0x123f, B:879:0x1246, B:881:0x125e, B:883:0x1262, B:884:0x1267, B:886:0x1273, B:887:0x1278, B:889:0x1283, B:891:0x128b, B:893:0x129c, B:894:0x12a6), top: B:2:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(RoomEvent roomEvent, Continuation<? super Unit> continuation) {
            NewMicroView newMicroView;
            RoomMessageViewBinding messageBinding;
            RoomInputView roomInputView;
            ImageView imageView;
            RoomMessageViewBinding messageBinding2;
            RoomInputView roomInputView2;
            ImageView imageView2;
            RoomMessageViewBinding messageBinding3;
            RoomInputView roomInputView3;
            ImageView imageView3;
            NewMicroView newMicroView2;
            String str;
            boolean z;
            MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
            NewMicroView newMicroView3;
            String svagUrl;
            NewMicroView newMicroView4;
            String str2;
            FragmentAudioRoomBinding binding;
            RoomRocketEnterView roomRocketEnterView;
            SocketGlobalBroadCastBean mSocketGlobalBroadCastBean;
            FragmentAudioRoomBinding binding2;
            GlobalRoomBroadCastLayout globalRoomBroadCastLayout;
            ImageView imageView4;
            ImageView imageView5;
            ImageView imageView6;
            ImageView imageView7;
            ImageView imageView8;
            ImageView imageView9;
            ImageView imageView10;
            ImageView imageView11;
            ImageView imageView12;
            ImageView imageView13;
            ImageView imageView14;
            ImageView imageView15;
            ImageView imageView16;
            ImageView imageView17;
            ImageView imageView18;
            ImageView imageView19;
            Integer type;
            RoomPK mpk;
            RoomPK mpk2;
            MeetingRoomManager meetingRoomManager;
            RoomPK mpk3;
            PKGameHelp mPKGameHelp;
            PKGameHelp mPKGameHelp2;
            Integer type2;
            PKGameHelp mPKGameHelp3;
            AudioGameHelp mGameHelp;
            PKGameHelp mPKGameHelp4;
            YouTuBeHelper mYouTuBe;
            YouTuBeHelper mYouTuBe2;
            YouTuGameData mYouTuBe3;
            AudioGameHelp mGameHelp2;
            YouTuGameData mYouTuBe4;
            AudioGameHelp mGameHelp3;
            ImageView imageView20;
            ImageView imageView21;
            ImageView imageView22;
            ImageView imageView23;
            EnvelopeHelper mEnvelopeHelper;
            ImageView imageView24;
            ImageView imageView25;
            ImageView imageView26;
            ImageView imageView27;
            Pk1v1Help mPk1v1Help;
            Pk1v1Help mPk1v1Help2;
            FoodieGameDialog mFoodieDialog;
            FoodieGameDialog mFoodieDialog2;
            ImageView imageView28;
            ImageView imageView29;
            ImageView imageView30;
            ImageView imageView31;
            AudioGameHelp mGameHelp4;
            HiloGameHelp mHiloGameHelp;
            AudioGameHelp mGameHelp5;
            HiloGameHelp mHiloGameHelp2;
            AudioGameHelp mGameHelp6;
            HiloGameHelp mHiloGameHelp3;
            AudioGameHelp mGameHelp7;
            AudioGameHelp mGameHelp8;
            HiloGameHelp mHiloGameHelp4;
            RoomMessageView mChatLayout;
            MessageProcessor mMessageProcessor;
            ImageView imageView32;
            ImageView imageView33;
            ImageView imageView34;
            ImageView imageView35;
            boolean z2 = true;
            try {
                int mEventId = roomEvent.getMEventId();
                if (mEventId == 100) {
                    AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "麦位变化", false, 5, null);
                    FragmentAudioRoomBinding binding3 = this.this$0.getFragment().getBinding();
                    if (binding3 != null && (newMicroView = binding3.microView) != null) {
                        newMicroView.notificationMicChange();
                        Unit unit = Unit.INSTANCE;
                    }
                    AudioGameHelp mGameHelp9 = this.this$0.getFragment().getMGameHelp();
                    if (mGameHelp9 != null) {
                        mGameHelp9.notificationMicChange();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    this.this$0.checkChatMic();
                    if (roomEvent.getEventData() != null && (roomEvent.getEventData() instanceof MicroBean)) {
                        Object eventData = roomEvent.getEventData();
                        Intrinsics.checkNotNull(eventData, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MicroBean");
                        MicroBean microBean = (MicroBean) eventData;
                        if (microBean.getRoomBanner() == null) {
                            this.this$0.getVoteHelper().removeVoteLayout();
                        } else {
                            this.this$0.getVoteHelper().createVoteLayout();
                            this.this$0.getVoteHelper().refreshVote(microBean.getRoomBanner());
                        }
                    }
                } else if (mEventId != 101) {
                    String str3 = "";
                    if (mEventId == 212) {
                        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
                        if (mDialogHelp != null) {
                            String mContent = roomEvent.getMContent();
                            if (mContent != null) {
                                str3 = mContent;
                            }
                            mDialogHelp.showInviteUserUpDialog(str3);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else if (mEventId != 213) {
                        switch (mEventId) {
                            case 201:
                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "收到修改用户等级的通知", true, 1, null);
                                this.this$0.getFragment().getMViewModel().getRoomRole();
                                break;
                            case RoomEvent.ROOM_OPEN_USE_INFO /* 210 */:
                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "打开用户资料页", true, 1, null);
                                int findMicPositionFromExtraId = MeetingRoomManager.INSTANCE.findMicPositionFromExtraId(roomEvent.getMUserExtraId());
                                AudioRoomDialogHelp mDialogHelp2 = this.this$0.getFragment().getMDialogHelp();
                                if (mDialogHelp2 != null) {
                                    mDialogHelp2.showUserInfoDialog(roomEvent.getMUserExtraId(), findMicPositionFromExtraId);
                                    Unit unit4 = Unit.INSTANCE;
                                    break;
                                }
                                break;
                            case RoomEvent.ROOM_CURRENT_USER_ONLINE /* 250 */:
                                if (roomEvent.getEventData() instanceof CurrentRoomOnlineBeanList) {
                                    Object eventData2 = roomEvent.getEventData();
                                    Intrinsics.checkNotNull(eventData2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList");
                                    CurrentRoomOnlineBeanList currentRoomOnlineBeanList = (CurrentRoomOnlineBeanList) eventData2;
                                    FragmentAudioRoomBinding binding4 = this.this$0.getFragment().getBinding();
                                    if (binding4 != null && (meetingRoomOnlineMemberLayout = binding4.meetingRoomOnlineMember) != null) {
                                        meetingRoomOnlineMemberLayout.updateData(currentRoomOnlineBeanList);
                                        Unit unit5 = Unit.INSTANCE;
                                    }
                                    AudioGameHelp mGameHelp10 = this.this$0.getFragment().getMGameHelp();
                                    if (mGameHelp10 != null) {
                                        mGameHelp10.refreshOnlineNumber(currentRoomOnlineBeanList);
                                        Unit unit6 = Unit.INSTANCE;
                                        break;
                                    }
                                }
                                break;
                            case 260:
                                AudioRoomDialogHelp mDialogHelp3 = this.this$0.getFragment().getMDialogHelp();
                                if (mDialogHelp3 != null) {
                                    mDialogHelp3.showRoomTipDialog();
                                    Unit unit7 = Unit.INSTANCE;
                                    break;
                                }
                                break;
                            case 400:
                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "麦位说话改变", false, 1, null);
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                IRtcEngineEventHandler.AudioVolumeInfo[] mSpeakers = roomEvent.getMSpeakers();
                                if (mSpeakers != null) {
                                    for (IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo : mSpeakers) {
                                        if (audioVolumeInfo.volume > 0) {
                                            if (audioVolumeInfo.uid == 0) {
                                                MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                                                MicroBean findMicInfoFromAgoraId = meetingRoomManager2.findMicInfoFromAgoraId(meetingRoomManager2.getMAgoraId());
                                                if (findMicInfoFromAgoraId != null ? Intrinsics.areEqual(findMicInfoFromAgoraId.getForbid(), Boxing.boxBoolean(false)) : false) {
                                                    arrayList.add(Boxing.boxInt(MeetingRoomManager.findMicPositionFromAgoraId$default(meetingRoomManager2, meetingRoomManager2.getMAgoraId(), false, 2, null)));
                                                    arrayList2.add(Boxing.boxInt(meetingRoomManager2.findMicPositionFromAgoraId(meetingRoomManager2.getMAgoraId(), true)));
                                                }
                                            }
                                            MeetingRoomManager meetingRoomManager3 = MeetingRoomManager.INSTANCE;
                                            arrayList.add(Boxing.boxInt(MeetingRoomManager.findMicPositionFromAgoraId$default(meetingRoomManager3, audioVolumeInfo.uid, false, 2, null)));
                                            arrayList2.add(Boxing.boxInt(meetingRoomManager3.findMicPositionFromAgoraId(audioVolumeInfo.uid, true)));
                                            meetingRoomManager3.addCurrentUserSaid(audioVolumeInfo.uid);
                                        }
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                }
                                if (!arrayList.isEmpty()) {
                                    AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "initObserve: 麦位说话 " + arrayList.size() + " " + arrayList, false, 1, null);
                                    GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                                    if (groupDetailBean != null) {
                                        AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
                                        if (groupDetailBean.getMicOn()) {
                                            FragmentAudioRoomBinding binding5 = audioRoomFragmentHelp.getFragment().getBinding();
                                            if (binding5 != null && (newMicroView3 = binding5.microView) != null) {
                                                newMicroView3.showMicSpeakWaveAnim(arrayList);
                                                Unit unit9 = Unit.INSTANCE;
                                            }
                                            AudioGameHelp mGameHelp11 = audioRoomFragmentHelp.getFragment().getMGameHelp();
                                            if (mGameHelp11 != null) {
                                                AudioGameHelp.showMicSpeakWaveAnim$default(mGameHelp11, arrayList, false, 2, null);
                                                Unit unit10 = Unit.INSTANCE;
                                            }
                                            AudioGameHelp mGameHelp12 = audioRoomFragmentHelp.getFragment().getMGameHelp();
                                            if (mGameHelp12 != null) {
                                                mGameHelp12.showMicSpeakWaveAnim(arrayList2, true);
                                                Unit unit11 = Unit.INSTANCE;
                                            }
                                        }
                                        Unit unit12 = Unit.INSTANCE;
                                        break;
                                    }
                                }
                                break;
                            case 500:
                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "房间信息改变", false, 1, null);
                                GroupDetailBean mGroupDetail = roomEvent.getMGroupDetail();
                                if (mGroupDetail != null) {
                                    AudioRoomFragmentHelp audioRoomFragmentHelp2 = this.this$0;
                                    if (Intrinsics.areEqual(mGroupDetail.getGroupId(), audioRoomFragmentHelp2.getFragment().getMViewModel().getMGroupId())) {
                                        audioRoomFragmentHelp2.getFragment().getMViewModel().getMGroupDetailBean().setValue(mGroupDetail);
                                    }
                                    Unit unit13 = Unit.INSTANCE;
                                    break;
                                }
                                break;
                            case RoomEvent.ROOM_MUSIC_FINISH_NEXT /* 702 */:
                                MeetingRoomManager.INSTANCE.getMusicManager().p(true);
                                break;
                            case RoomEvent.ROOM_MIC_EMOJI /* 800 */:
                                int findMicPositionFromExtraId2 = MeetingRoomManager.INSTANCE.findMicPositionFromExtraId(roomEvent.getMUserExtraId());
                                FragmentAudioRoomBinding binding6 = this.this$0.getFragment().getBinding();
                                if (binding6 != null && (newMicroView4 = binding6.microView) != null) {
                                    int i = findMicPositionFromExtraId2 - 1;
                                    EmojiBean mMicEmoji = roomEvent.getMMicEmoji();
                                    if (mMicEmoji == null || (str2 = mMicEmoji.getSvagUrl()) == null) {
                                        str2 = "";
                                    }
                                    newMicroView4.showFace(i, str2);
                                    Unit unit14 = Unit.INSTANCE;
                                }
                                AudioGameHelp mGameHelp13 = this.this$0.getFragment().getMGameHelp();
                                if (mGameHelp13 != null) {
                                    int i2 = findMicPositionFromExtraId2 - 1;
                                    EmojiBean mMicEmoji2 = roomEvent.getMMicEmoji();
                                    if (mMicEmoji2 != null && (svagUrl = mMicEmoji2.getSvagUrl()) != null) {
                                        str3 = svagUrl;
                                    }
                                    mGameHelp13.showFace(i2, str3);
                                    Unit unit15 = Unit.INSTANCE;
                                }
                                break;
                            case RoomEvent.ROOM_TASK_MIC_UP_COMPLETE /* 911 */:
                                this.this$0.showUserCompleteUpMicTask();
                                break;
                            case 1000:
                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "房间banner更新", false, 5, null);
                                this.this$0.getFragment().getMViewModel().getRoomBanner();
                                break;
                            case RoomEvent.ROOM_ACTIVITY_DETAIL /* 1500 */:
                                final ActivityDetailData activityDetailData = roomEvent.getActivityDetailData();
                                if (activityDetailData != null) {
                                    final AudioRoomFragmentHelp audioRoomFragmentHelp3 = this.this$0;
                                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.v2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            AudioRoomFragmentHelp$initObserve$2.AnonymousClass2.emit$lambda$6$lambda$5(activityDetailData, audioRoomFragmentHelp3);
                                        }
                                    }, 1000L);
                                    Unit unit16 = Unit.INSTANCE;
                                    break;
                                }
                                break;
                            default:
                                switch (mEventId) {
                                    case RoomEvent.ROOM_USER_LEAVE /* 216 */:
                                        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "RoomEvent.ROOM_USER_LEAVE 有人离开房间", false, 1, null);
                                        break;
                                    case RoomEvent.ROOM_JOIN_AGORA_CHANNEL_SUCCESS /* 217 */:
                                        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "加入频道成功", false, 5, null);
                                        this.this$0.getFragment().getMViewModel().setRemoteAllMute(true);
                                        if (MeetingRoomManager.INSTANCE.getLocalRoomMicStatus()) {
                                            this.this$0.getFragment().getMViewModel().setRemoteAllMute(false);
                                            break;
                                        }
                                        break;
                                    case RoomEvent.ROOM_LEAVE_AGORA_CHANNEL_SUCCESS /* 218 */:
                                        MeetingRoomManager meetingRoomManager4 = MeetingRoomManager.INSTANCE;
                                        if (meetingRoomManager4.getMPK() != null) {
                                            return Unit.INSTANCE;
                                        }
                                        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "initObserve: 离开频道成功", true, 1, null);
                                        if (!TextUtils.isEmpty(meetingRoomManager4.getMAgoraToken()) && !TextUtils.isEmpty(meetingRoomManager4.getMRoomChannelId()) && meetingRoomManager4.getMAgoraId() > 0 && meetingRoomManager4.getMProvider() > 0) {
                                            AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "initObserve: 重新加入频道groupJoinChannel", true, 1, null);
                                            this.this$0.getFragment().getMViewModel().joinChannel(meetingRoomManager4.getMAgoraToken(), meetingRoomManager4.getMRoomChannelId(), meetingRoomManager4.getMAgoraId(), meetingRoomManager4.getMProvider());
                                            break;
                                        } else {
                                            AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "initObserve: 没有重新加入频道" + meetingRoomManager4.getMAgoraToken() + " " + meetingRoomManager4.getMRoomChannelId() + " " + meetingRoomManager4.getMAgoraId(), true, 1, null);
                                            break;
                                        }
                                        break;
                                    case RoomEvent.ROOM_CLEAN /* 219 */:
                                        this.this$0.clearMessage();
                                        break;
                                    default:
                                        switch (mEventId) {
                                            case RoomEvent.ROOM_LUCKY_WHEEL_EVENT /* 900 */:
                                                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "LucklyWheel initObserve: 幸运转盘socket通知回调", false, 5, null);
                                                RoomViewModel.refreshLuckLyDialog$default(this.this$0.getFragment().getMViewModel(), false, 1, null);
                                                break;
                                            case RoomEvent.ROOM_ROCKET_UPDATE /* 901 */:
                                                RocketRoomSmallBean rocketData = roomEvent.getRocketData();
                                                if (rocketData != null && (binding = this.this$0.getFragment().getBinding()) != null && (roomRocketEnterView = binding.roomRocketEnter) != null) {
                                                    roomRocketEnterView.setData(rocketData);
                                                    Unit unit17 = Unit.INSTANCE;
                                                    break;
                                                }
                                                break;
                                            case RoomEvent.ROOM_ROCKET_ANIMATOR /* 902 */:
                                                this.this$0.getFragment().getMViewModel().getRocketSvgaCountDown(false);
                                                break;
                                            case RoomEvent.ROOM_GLOBAL_BROADCAST /* 903 */:
                                                if (MeetingRoomManager.INSTANCE.checkShowEffect() && (mSocketGlobalBroadCastBean = roomEvent.getMSocketGlobalBroadCastBean()) != null && (binding2 = this.this$0.getFragment().getBinding()) != null && (globalRoomBroadCastLayout = binding2.globalRoomBroadLayout) != null) {
                                                    globalRoomBroadCastLayout.hasNewBroadcast(mSocketGlobalBroadCastBean);
                                                    Unit unit18 = Unit.INSTANCE;
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (mEventId) {
                                                    case RoomEvent.ROOM_LUDO_GAME_CREATE /* 922 */:
                                                        FragmentAudioRoomBinding binding7 = this.this$0.getFragment().getBinding();
                                                        if (binding7 != null && (imageView4 = binding7.ludoGame) != null) {
                                                            imageView4.setVisibility(0);
                                                            Unit unit19 = Unit.INSTANCE;
                                                        }
                                                        this.this$0.showLudoGameView();
                                                        break;
                                                    case RoomEvent.ROOM_LUDO_GAME_STATUS /* 923 */:
                                                        SUDGameData gameState = roomEvent.getGameState();
                                                        if (gameState != null && gameState.getStatus() == 2) {
                                                            FragmentAudioRoomBinding binding8 = this.this$0.getFragment().getBinding();
                                                            if (binding8 != null && (imageView6 = binding8.ludoGame) != null) {
                                                                imageView6.setVisibility(8);
                                                                Unit unit20 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp14 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp14 != null) {
                                                                AudioGameHelp.hideGameView$default(mGameHelp14, null, 1, null);
                                                                Unit unit21 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp15 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp15 != null) {
                                                                AudioGameHelp.releaseGame$default(mGameHelp15, false, false, 3, null);
                                                                Unit unit22 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        } else {
                                                            FragmentAudioRoomBinding binding9 = this.this$0.getFragment().getBinding();
                                                            if (binding9 != null && (imageView5 = binding9.ludoGame) != null) {
                                                                imageView5.setVisibility(0);
                                                                Unit unit23 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp16 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp16 != null) {
                                                                mGameHelp16.refreshGameData(1);
                                                                Unit unit24 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_LUDO_GAME_END /* 924 */:
                                                        FragmentAudioRoomBinding binding10 = this.this$0.getFragment().getBinding();
                                                        if (binding10 != null && (imageView7 = binding10.ludoGame) != null) {
                                                            imageView7.setVisibility(8);
                                                            Unit unit25 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp17 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp17 != null) {
                                                            AudioGameHelp.hideGameView$default(mGameHelp17, null, 1, null);
                                                            Unit unit26 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp18 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp18 != null) {
                                                            mGameHelp18.showGameEnd(1, roomEvent.getGameAward());
                                                            Unit unit27 = Unit.INSTANCE;
                                                            break;
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_UNO_GAME_CREATE /* 925 */:
                                                        FragmentAudioRoomBinding binding11 = this.this$0.getFragment().getBinding();
                                                        if (binding11 != null && (imageView8 = binding11.unoGame) != null) {
                                                            imageView8.setVisibility(0);
                                                            Unit unit28 = Unit.INSTANCE;
                                                        }
                                                        this.this$0.showUnoGameView();
                                                        break;
                                                    case RoomEvent.ROOM_UNO_GAME_STATUS /* 926 */:
                                                        SUDGameData gameState2 = roomEvent.getGameState();
                                                        if (gameState2 != null && gameState2.getStatus() == 2) {
                                                            FragmentAudioRoomBinding binding12 = this.this$0.getFragment().getBinding();
                                                            if (binding12 != null && (imageView10 = binding12.unoGame) != null) {
                                                                imageView10.setVisibility(8);
                                                                Unit unit29 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp19 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp19 != null) {
                                                                AudioGameHelp.hideGameView$default(mGameHelp19, null, 1, null);
                                                                Unit unit30 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp20 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp20 != null) {
                                                                AudioGameHelp.releaseGame$default(mGameHelp20, false, false, 3, null);
                                                                Unit unit31 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        } else {
                                                            FragmentAudioRoomBinding binding13 = this.this$0.getFragment().getBinding();
                                                            if (binding13 != null && (imageView9 = binding13.unoGame) != null) {
                                                                imageView9.setVisibility(0);
                                                                Unit unit32 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp21 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp21 != null) {
                                                                mGameHelp21.refreshGameData(2);
                                                                Unit unit33 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_UNO_GAME_END /* 927 */:
                                                        FragmentAudioRoomBinding binding14 = this.this$0.getFragment().getBinding();
                                                        if (binding14 != null && (imageView11 = binding14.unoGame) != null) {
                                                            imageView11.setVisibility(8);
                                                            Unit unit34 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp22 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp22 != null) {
                                                            AudioGameHelp.hideGameView$default(mGameHelp22, null, 1, null);
                                                            Unit unit35 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp23 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp23 != null) {
                                                            mGameHelp23.showGameEnd(2, roomEvent.getGameAward());
                                                            Unit unit36 = Unit.INSTANCE;
                                                            break;
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_GAME_NOTICE /* 928 */:
                                                        MeetingRoomManager meetingRoomManager5 = MeetingRoomManager.INSTANCE;
                                                        UserProxy1.GlobalGameBanner gameBanner = roomEvent.getGameBanner();
                                                        if (!meetingRoomManager5.isLuckyGame(gameBanner != null ? (int) gameBanner.getGameId() : 0)) {
                                                            return Unit.INSTANCE;
                                                        }
                                                        UserProxy1.GlobalGameBanner gameBanner2 = roomEvent.getGameBanner();
                                                        if (gameBanner2 != null) {
                                                            AudioRoomFragmentHelp audioRoomFragmentHelp4 = this.this$0;
                                                            if (meetingRoomManager5.checkShowEffect() && audioRoomFragmentHelp4.getFragment().getContext() != null) {
                                                                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(audioRoomFragmentHelp4.getFragment()), (CoroutineContext) null, (CoroutineStart) null, new AudioRoomFragmentHelp$initObserve$2$2$7$1(audioRoomFragmentHelp4, gameBanner2, null), 3, (Object) null);
                                                            }
                                                            Unit unit37 = Unit.INSTANCE;
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_ALL_GIFT /* 929 */:
                                                        MeetingRoomManager meetingRoomManager6 = MeetingRoomManager.INSTANCE;
                                                        if (meetingRoomManager6.checkShowEffect() && meetingRoomManager6.isShowGiftEffect()) {
                                                            if (roomEvent.getEventData() instanceof RoomAllGift) {
                                                                Object eventData3 = roomEvent.getEventData();
                                                                Intrinsics.checkNotNull(eventData3, "null cannot be cast to non-null type com.qiahao.nextvideo.data.signaling.RoomAllGift");
                                                                RoomAllGift roomAllGift = (RoomAllGift) eventData3;
                                                                FragmentActivity activity = this.this$0.getFragment().getActivity();
                                                                if (activity != null) {
                                                                    final AudioRoomFragmentHelp audioRoomFragmentHelp5 = this.this$0;
                                                                    Glide.with(activity).b().q0(new c5.h().W(UiKtxKt.toPX(UserProxyUtility.cpUpgrades), UiKtxKt.toPX(UserProxyUtility.cpUpgrades))).K0(roomAllGift.getGiftIcon()).F0(new c5.g() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2$2$8$1
                                                                        public boolean onLoadFailed(o4.q e, Object model, com.bumptech.glide.request.target.j target, boolean isFirstResource) {
                                                                            Intrinsics.checkNotNullParameter(target, Constants.KEY_TARGET);
                                                                            return false;
                                                                        }

                                                                        public boolean onResourceReady(Bitmap resource, Object model, com.bumptech.glide.request.target.j target, m4.a dataSource, boolean isFirstResource) {
                                                                            Intrinsics.checkNotNullParameter(resource, "resource");
                                                                            Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
                                                                            Intrinsics.checkNotNullParameter(target, Constants.KEY_TARGET);
                                                                            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                                                                            AudioRoomFragmentHelp audioRoomFragmentHelp6 = AudioRoomFragmentHelp.this;
                                                                            FullGiftHelper fullGiftHelper = audioRoomFragmentHelp6.getFullGiftHelper();
                                                                            Bitmap createBitmap = Bitmap.createBitmap(resource);
                                                                            LifecycleOwner viewLifecycleOwner = audioRoomFragmentHelp6.getFragment().getViewLifecycleOwner();
                                                                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                                                                            fullGiftHelper.startAllGift(createBitmap, viewLifecycleOwner);
                                                                            return false;
                                                                        }
                                                                    }).Q0();
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    case RoomEvent.ROOM_DOMINO_GAME_CREATE /* 930 */:
                                                        FragmentAudioRoomBinding binding15 = this.this$0.getFragment().getBinding();
                                                        if (binding15 != null && (imageView12 = binding15.dominoGame) != null) {
                                                            imageView12.setVisibility(0);
                                                            Unit unit38 = Unit.INSTANCE;
                                                        }
                                                        this.this$0.showDominoGameView();
                                                        break;
                                                    case RoomEvent.ROOM_DOMINO_GAME_STATUS /* 931 */:
                                                        SUDGameData gameState3 = roomEvent.getGameState();
                                                        if (gameState3 != null && gameState3.getStatus() == 2) {
                                                            FragmentAudioRoomBinding binding16 = this.this$0.getFragment().getBinding();
                                                            if (binding16 != null && (imageView14 = binding16.dominoGame) != null) {
                                                                imageView14.setVisibility(8);
                                                                Unit unit39 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp24 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp24 != null) {
                                                                AudioGameHelp.hideGameView$default(mGameHelp24, null, 1, null);
                                                                Unit unit40 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp25 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp25 != null) {
                                                                AudioGameHelp.releaseGame$default(mGameHelp25, false, false, 3, null);
                                                                Unit unit41 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        } else {
                                                            FragmentAudioRoomBinding binding17 = this.this$0.getFragment().getBinding();
                                                            if (binding17 != null && (imageView13 = binding17.dominoGame) != null) {
                                                                imageView13.setVisibility(0);
                                                                Unit unit42 = Unit.INSTANCE;
                                                            }
                                                            AudioGameHelp mGameHelp26 = this.this$0.getFragment().getMGameHelp();
                                                            if (mGameHelp26 != null) {
                                                                mGameHelp26.refreshGameData(10);
                                                                Unit unit43 = Unit.INSTANCE;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    case RoomEvent.ROOM_DOMINO_GAME_END /* 932 */:
                                                        FragmentAudioRoomBinding binding18 = this.this$0.getFragment().getBinding();
                                                        if (binding18 != null && (imageView15 = binding18.dominoGame) != null) {
                                                            imageView15.setVisibility(8);
                                                            Unit unit44 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp27 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp27 != null) {
                                                            AudioGameHelp.hideGameView$default(mGameHelp27, null, 1, null);
                                                            Unit unit45 = Unit.INSTANCE;
                                                        }
                                                        AudioGameHelp mGameHelp28 = this.this$0.getFragment().getMGameHelp();
                                                        if (mGameHelp28 != null) {
                                                            mGameHelp28.showGameEnd(10, roomEvent.getGameAward());
                                                            Unit unit46 = Unit.INSTANCE;
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (mEventId) {
                                                            case RoomEvent.ROOM_CRUSH_GAME_CREATE /* 934 */:
                                                                FragmentAudioRoomBinding binding19 = this.this$0.getFragment().getBinding();
                                                                if (binding19 != null && (imageView16 = binding19.crushGame) != null) {
                                                                    imageView16.setVisibility(0);
                                                                    Unit unit47 = Unit.INSTANCE;
                                                                }
                                                                this.this$0.showCrushGameView();
                                                                break;
                                                            case RoomEvent.ROOM_CRUSH_GAME_STATUS /* 935 */:
                                                                SUDGameData gameState4 = roomEvent.getGameState();
                                                                if (gameState4 != null && gameState4.getStatus() == 2) {
                                                                    FragmentAudioRoomBinding binding20 = this.this$0.getFragment().getBinding();
                                                                    if (binding20 != null && (imageView18 = binding20.crushGame) != null) {
                                                                        imageView18.setVisibility(8);
                                                                        Unit unit48 = Unit.INSTANCE;
                                                                    }
                                                                    AudioGameHelp mGameHelp29 = this.this$0.getFragment().getMGameHelp();
                                                                    if (mGameHelp29 != null) {
                                                                        AudioGameHelp.hideGameView$default(mGameHelp29, null, 1, null);
                                                                        Unit unit49 = Unit.INSTANCE;
                                                                    }
                                                                    AudioGameHelp mGameHelp30 = this.this$0.getFragment().getMGameHelp();
                                                                    if (mGameHelp30 != null) {
                                                                        AudioGameHelp.releaseGame$default(mGameHelp30, false, false, 3, null);
                                                                        Unit unit50 = Unit.INSTANCE;
                                                                        break;
                                                                    }
                                                                } else {
                                                                    FragmentAudioRoomBinding binding21 = this.this$0.getFragment().getBinding();
                                                                    if (binding21 != null && (imageView17 = binding21.crushGame) != null) {
                                                                        imageView17.setVisibility(0);
                                                                        Unit unit51 = Unit.INSTANCE;
                                                                    }
                                                                    AudioGameHelp mGameHelp31 = this.this$0.getFragment().getMGameHelp();
                                                                    if (mGameHelp31 != null) {
                                                                        mGameHelp31.refreshGameData(11);
                                                                        Unit unit52 = Unit.INSTANCE;
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case RoomEvent.ROOM_CRUSH_GAME_END /* 936 */:
                                                                FragmentAudioRoomBinding binding22 = this.this$0.getFragment().getBinding();
                                                                if (binding22 != null && (imageView19 = binding22.crushGame) != null) {
                                                                    imageView19.setVisibility(8);
                                                                    Unit unit53 = Unit.INSTANCE;
                                                                }
                                                                AudioGameHelp mGameHelp32 = this.this$0.getFragment().getMGameHelp();
                                                                if (mGameHelp32 != null) {
                                                                    AudioGameHelp.hideGameView$default(mGameHelp32, null, 1, null);
                                                                    Unit unit54 = Unit.INSTANCE;
                                                                }
                                                                AudioGameHelp mGameHelp33 = this.this$0.getFragment().getMGameHelp();
                                                                if (mGameHelp33 != null) {
                                                                    mGameHelp33.showGameEnd(11, roomEvent.getGameAward());
                                                                    Unit unit55 = Unit.INSTANCE;
                                                                    break;
                                                                }
                                                                break;
                                                            case RoomEvent.ROOM_PK_INVITE_OR_CANCEL /* 937 */:
                                                                Object eventData4 = roomEvent.getEventData();
                                                                PKInviteCancel pKInviteCancel = eventData4 instanceof PKInviteCancel ? (PKInviteCancel) eventData4 : null;
                                                                if (pKInviteCancel != null && (type = pKInviteCancel.getType()) != null && type.intValue() == 1) {
                                                                    MeetingRoomManager meetingRoomManager7 = MeetingRoomManager.INSTANCE;
                                                                    RoomPK mpk4 = meetingRoomManager7.getMPK();
                                                                    if ((mpk4 == null || mpk4.getStatus() != 1) && ((mpk = meetingRoomManager7.getMPK()) == null || mpk.getStatus() != 2)) {
                                                                        RoomPK mpk5 = meetingRoomManager7.getMPK();
                                                                        if (mpk5 != null && mpk5.getStatus() == 0 && (mpk2 = meetingRoomManager7.getMPK()) != null && mpk2.checkIsInvite()) {
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        Integer gameId = pKInviteCancel.getGameId();
                                                                        if (gameId != null && gameId.intValue() == 22) {
                                                                            if (meetingRoomManager7.getMPK() == null) {
                                                                                meetingRoomManager7.setMPK(new RoomPK(null, null, null, 0, null, 31, null));
                                                                            }
                                                                            RoomPK mpk6 = meetingRoomManager7.getMPK();
                                                                            if (mpk6 != null) {
                                                                                mpk6.setInviteGroup(DataExternalKt.toGroupDetailBean(pKInviteCancel));
                                                                                Unit unit56 = Unit.INSTANCE;
                                                                            }
                                                                            RoomPK mpk7 = meetingRoomManager7.getMPK();
                                                                            if (mpk7 != null) {
                                                                                mpk7.setPkExternalData(pKInviteCancel);
                                                                                Unit unit57 = Unit.INSTANCE;
                                                                            }
                                                                            RoomPK mpk8 = meetingRoomManager7.getMPK();
                                                                            if (mpk8 != null) {
                                                                                mpk8.setStatus(0);
                                                                                Unit unit58 = Unit.INSTANCE;
                                                                            }
                                                                            this.this$0.checkPK();
                                                                            break;
                                                                        }
                                                                        this.this$0.checkOtherPK(pKInviteCancel);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                                this.this$0.checkOtherPK(pKInviteCancel);
                                                                break;
                                                            default:
                                                                switch (mEventId) {
                                                                    case RoomEvent.ROOM_PK_MATCH_SUCCESS /* 939 */:
                                                                        RoomViewModel mViewModel = this.this$0.getFragment().getMViewModel();
                                                                        final AudioRoomFragmentHelp audioRoomFragmentHelp6 = this.this$0;
                                                                        final CoroutineScope coroutineScope = this.$$this$launch;
                                                                        RoomViewModel.requestNewToken$default(mViewModel, new Function0() { // from class: com.qiahao.nextvideo.room.help.w2
                                                                            public final Object invoke() {
                                                                                Unit emit$lambda$11;
                                                                                emit$lambda$11 = AudioRoomFragmentHelp$initObserve$2.AnonymousClass2.emit$lambda$11(AudioRoomFragmentHelp.this, coroutineScope);
                                                                                return emit$lambda$11;
                                                                            }
                                                                        }, null, 2, null);
                                                                        break;
                                                                    case RoomEvent.ROOM_PK_END /* 940 */:
                                                                        if (!this.this$0.getFragment().isDetached() && this.this$0.getFragment().getContext() != null) {
                                                                            if ((roomEvent.getEventData() instanceof RoomPKEnd) && (mpk3 = (meetingRoomManager = MeetingRoomManager.INSTANCE).getMPK()) != null && mpk3.getStatus() == 1) {
                                                                                PKInviteCancel mPKGame = meetingRoomManager.getMPKGame();
                                                                                if (mPKGame != null && (type2 = mPKGame.getType()) != null && type2.intValue() == 1) {
                                                                                    meetingRoomManager.setMPKGame(null);
                                                                                }
                                                                                RoomPK mpk9 = meetingRoomManager.getMPK();
                                                                                if (mpk9 != null) {
                                                                                    mpk9.setStatus(2);
                                                                                    Unit unit59 = Unit.INSTANCE;
                                                                                }
                                                                                Object eventData5 = roomEvent.getEventData();
                                                                                Intrinsics.checkNotNull(eventData5, "null cannot be cast to non-null type com.qiahao.nextvideo.data.room.RoomPKEnd");
                                                                                final RoomPKEnd roomPKEnd = (RoomPKEnd) eventData5;
                                                                                Context context = this.this$0.getFragment().getContext();
                                                                                if (context != null) {
                                                                                    new PKEndDialog(context, roomPKEnd).show();
                                                                                    Unit unit60 = Unit.INSTANCE;
                                                                                }
                                                                                AudioGameHelp mGameHelp34 = this.this$0.getFragment().getMGameHelp();
                                                                                if (mGameHelp34 != null && (mPKGameHelp2 = mGameHelp34.getMPKGameHelp()) != null) {
                                                                                    mPKGameHelp2.refreshPro();
                                                                                    Unit unit61 = Unit.INSTANCE;
                                                                                }
                                                                                AudioGameHelp mGameHelp35 = this.this$0.getFragment().getMGameHelp();
                                                                                if (mGameHelp35 != null && (mPKGameHelp = mGameHelp35.getMPKGameHelp()) != null) {
                                                                                    mPKGameHelp.pkCountDown(Boxing.boxBoolean(true));
                                                                                    Unit unit62 = Unit.INSTANCE;
                                                                                }
                                                                                HiloUtils hiloUtils = HiloUtils.INSTANCE;
                                                                                final AudioRoomFragmentHelp audioRoomFragmentHelp7 = this.this$0;
                                                                                hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.x2
                                                                                    @Override // java.lang.Runnable
                                                                                    public final void run() {
                                                                                        AudioRoomFragmentHelp$initObserve$2.AnonymousClass2.emit$lambda$13(RoomPKEnd.this, audioRoomFragmentHelp7);
                                                                                    }
                                                                                }, 1000L);
                                                                                break;
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case RoomEvent.ROOM_PK_PRO /* 941 */:
                                                                        MeetingRoomManager meetingRoomManager8 = MeetingRoomManager.INSTANCE;
                                                                        RoomPK mpk10 = meetingRoomManager8.getMPK();
                                                                        if (mpk10 != null && mpk10.getStatus() == 1) {
                                                                            AudioGameHelp mGameHelp36 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp36 != null && (mPKGameHelp3 = mGameHelp36.getMPKGameHelp()) != null) {
                                                                                mPKGameHelp3.refreshPro();
                                                                                Unit unit63 = Unit.INSTANCE;
                                                                            }
                                                                            meetingRoomManager8.changePKRoomMic();
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_PK_PUNISH /* 942 */:
                                                                        RoomPK mpk11 = MeetingRoomManager.INSTANCE.getMPK();
                                                                        if (mpk11 != null && mpk11.getStatus() == 3 && (mGameHelp = this.this$0.getFragment().getMGameHelp()) != null && (mPKGameHelp4 = mGameHelp.getMPKGameHelp()) != null) {
                                                                            mPKGameHelp4.pkEnd();
                                                                            Unit unit64 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_YOU_TU /* 943 */:
                                                                        MeetingRoomManager meetingRoomManager9 = MeetingRoomManager.INSTANCE;
                                                                        YouTuGameData mYouTuBe5 = meetingRoomManager9.getMYouTuBe();
                                                                        Integer type3 = mYouTuBe5 != null ? mYouTuBe5.getType() : null;
                                                                        if (type3 != null && type3.intValue() == 4) {
                                                                            AudioGameHelp mGameHelp37 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp37 != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp37, null, 1, null);
                                                                                Unit unit65 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp38 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp38 != null && (mYouTuBe = mGameHelp38.getMYouTuBe()) != null) {
                                                                                mYouTuBe.releaseGame();
                                                                                Unit unit66 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (type3 != null && type3.intValue() == 3) {
                                                                            AudioGameHelp mGameHelp39 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp39 != null && (mYouTuBe2 = mGameHelp39.getMYouTuBe()) != null) {
                                                                                mYouTuBe2.resetVideoView();
                                                                                Unit unit67 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp40 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp40 != null) {
                                                                                mGameHelp40.resetVideo();
                                                                                Unit unit68 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp41 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp41 != null) {
                                                                                mGameHelp41.refreshGameData(13);
                                                                                Unit unit69 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (!meetingRoomManager9.checkOwnOrManager() && (mYouTuBe4 = meetingRoomManager9.getMYouTuBe()) != null && !mYouTuBe4.isOwner() && (mGameHelp3 = this.this$0.getFragment().getMGameHelp()) != null && mGameHelp3.checkGameIsShow()) {
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        if (meetingRoomManager9.checkOwnOrManager() && (mYouTuBe3 = meetingRoomManager9.getMYouTuBe()) != null && !mYouTuBe3.isOwner() && (mGameHelp2 = this.this$0.getFragment().getMGameHelp()) != null && mGameHelp2.checkGameIsShow()) {
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp42 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp42 != null) {
                                                                            AudioGameHelp.showGameView$default(mGameHelp42, 13, null, 2, null);
                                                                            Unit unit70 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp43 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp43 != null) {
                                                                            mGameHelp43.refreshGameData(13);
                                                                            Unit unit71 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_BALOOT_GAME_CREATE /* 944 */:
                                                                        FragmentAudioRoomBinding binding23 = this.this$0.getFragment().getBinding();
                                                                        if (binding23 != null && (imageView20 = binding23.balootGame) != null) {
                                                                            imageView20.setVisibility(0);
                                                                            Unit unit72 = Unit.INSTANCE;
                                                                        }
                                                                        this.this$0.showBalootGameView();
                                                                        break;
                                                                    case RoomEvent.ROOM_BALOOT_GAME_STATUS /* 945 */:
                                                                        SUDGameData gameState5 = roomEvent.getGameState();
                                                                        if (gameState5 != null && gameState5.getStatus() == 2) {
                                                                            FragmentAudioRoomBinding binding24 = this.this$0.getFragment().getBinding();
                                                                            if (binding24 != null && (imageView22 = binding24.balootGame) != null) {
                                                                                imageView22.setVisibility(8);
                                                                                Unit unit73 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp44 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp44 != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp44, null, 1, null);
                                                                                Unit unit74 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp45 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp45 != null) {
                                                                                AudioGameHelp.releaseGame$default(mGameHelp45, false, false, 3, null);
                                                                                Unit unit75 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            FragmentAudioRoomBinding binding25 = this.this$0.getFragment().getBinding();
                                                                            if (binding25 != null && (imageView21 = binding25.balootGame) != null) {
                                                                                imageView21.setVisibility(0);
                                                                                Unit unit76 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp46 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp46 != null) {
                                                                                mGameHelp46.refreshGameData(14);
                                                                                Unit unit77 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_BALOOT_GAME_END /* 946 */:
                                                                        FragmentAudioRoomBinding binding26 = this.this$0.getFragment().getBinding();
                                                                        if (binding26 != null && (imageView23 = binding26.balootGame) != null) {
                                                                            imageView23.setVisibility(8);
                                                                            Unit unit78 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp47 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp47 != null) {
                                                                            AudioGameHelp.hideGameView$default(mGameHelp47, null, 1, null);
                                                                            Unit unit79 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp48 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp48 != null) {
                                                                            mGameHelp48.showGameEnd(14, roomEvent.getGameAward());
                                                                            Unit unit80 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_ENVELOPE /* 947 */:
                                                                        AudioGameHelp mGameHelp49 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp49 != null && (mEnvelopeHelper = mGameHelp49.getMEnvelopeHelper()) != null) {
                                                                            mEnvelopeHelper.checkEnvelope(true);
                                                                            Unit unit81 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_CARROM_GAME_CREATE /* 948 */:
                                                                        FragmentAudioRoomBinding binding27 = this.this$0.getFragment().getBinding();
                                                                        if (binding27 != null && (imageView24 = binding27.carromGame) != null) {
                                                                            imageView24.setVisibility(0);
                                                                            Unit unit82 = Unit.INSTANCE;
                                                                        }
                                                                        this.this$0.showCarromGameView();
                                                                        break;
                                                                    case RoomEvent.ROOM_CARROM_GAME_STATUS /* 949 */:
                                                                        SUDGameData gameState6 = roomEvent.getGameState();
                                                                        if (gameState6 != null && gameState6.getStatus() == 2) {
                                                                            FragmentAudioRoomBinding binding28 = this.this$0.getFragment().getBinding();
                                                                            if (binding28 != null && (imageView26 = binding28.carromGame) != null) {
                                                                                imageView26.setVisibility(8);
                                                                                Unit unit83 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp50 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp50 != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp50, null, 1, null);
                                                                                Unit unit84 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp51 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp51 != null) {
                                                                                AudioGameHelp.releaseGame$default(mGameHelp51, false, false, 3, null);
                                                                                Unit unit85 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            FragmentAudioRoomBinding binding29 = this.this$0.getFragment().getBinding();
                                                                            if (binding29 != null && (imageView25 = binding29.carromGame) != null) {
                                                                                imageView25.setVisibility(0);
                                                                                Unit unit86 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp52 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp52 != null) {
                                                                                mGameHelp52.refreshGameData(18);
                                                                                Unit unit87 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_CARROM_GAME_END /* 950 */:
                                                                        FragmentAudioRoomBinding binding30 = this.this$0.getFragment().getBinding();
                                                                        if (binding30 != null && (imageView27 = binding30.carromGame) != null) {
                                                                            imageView27.setVisibility(8);
                                                                            Unit unit88 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp53 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp53 != null) {
                                                                            AudioGameHelp.hideGameView$default(mGameHelp53, null, 1, null);
                                                                            Unit unit89 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp54 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp54 != null) {
                                                                            mGameHelp54.showGameEnd(18, roomEvent.getGameAward());
                                                                            Unit unit90 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_PK1V1_REFRESH /* 951 */:
                                                                        AudioGameHelp mGameHelp55 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp55 != null && (mPk1v1Help = mGameHelp55.getMPk1v1Help()) != null) {
                                                                            mPk1v1Help.showPk1v1();
                                                                            Unit unit91 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_PK1V1_END /* 952 */:
                                                                        if (roomEvent.getEventData() instanceof Pk1v1End) {
                                                                            Object eventData6 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData6, "null cannot be cast to non-null type com.qiahao.nextvideo.data.game.Pk1v1End");
                                                                            Pk1v1End pk1v1End = (Pk1v1End) eventData6;
                                                                            AudioGameHelp mGameHelp56 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp56 != null && (mPk1v1Help2 = mGameHelp56.getMPk1v1Help()) != null) {
                                                                                mPk1v1Help2.pkEnd(pk1v1End);
                                                                                Unit unit92 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.FOODIE_RESULT /* 953 */:
                                                                        AudioRoomDialogHelp mDialogHelp4 = this.this$0.getFragment().getMDialogHelp();
                                                                        if (mDialogHelp4 != null && (mFoodieDialog = mDialogHelp4.getMFoodieDialog()) != null) {
                                                                            mFoodieDialog.setDrawResult();
                                                                            Unit unit93 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.FOODIE_HOT /* 954 */:
                                                                        if (roomEvent.getEventData() instanceof UserProxy1.FoodieTopHotMessage) {
                                                                            Object eventData7 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData7, "null cannot be cast to non-null type userProxy.UserProxy1.FoodieTopHotMessage");
                                                                            UserProxy1.FoodieTopHotMessage foodieTopHotMessage = (UserProxy1.FoodieTopHotMessage) eventData7;
                                                                            AudioRoomDialogHelp mDialogHelp5 = this.this$0.getFragment().getMDialogHelp();
                                                                            if (mDialogHelp5 != null && (mFoodieDialog2 = mDialogHelp5.getMFoodieDialog()) != null) {
                                                                                mFoodieDialog2.refreshHotItem(DataExternalKt.toFoodieHotMessage(foodieTopHotMessage));
                                                                                Unit unit94 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_JACKARO_GAME_CREATE /* 955 */:
                                                                        FragmentAudioRoomBinding binding31 = this.this$0.getFragment().getBinding();
                                                                        if (binding31 != null && (imageView28 = binding31.jackaroGame) != null) {
                                                                            imageView28.setVisibility(0);
                                                                            Unit unit95 = Unit.INSTANCE;
                                                                        }
                                                                        this.this$0.showJackaroGameView();
                                                                        break;
                                                                    case RoomEvent.ROOM_JACKARO_GAME_STATUS /* 956 */:
                                                                        SUDGameData gameState7 = roomEvent.getGameState();
                                                                        if (gameState7 != null && gameState7.getStatus() == 2) {
                                                                            FragmentAudioRoomBinding binding32 = this.this$0.getFragment().getBinding();
                                                                            if (binding32 != null && (imageView30 = binding32.jackaroGame) != null) {
                                                                                imageView30.setVisibility(8);
                                                                                Unit unit96 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp57 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp57 != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp57, null, 1, null);
                                                                                Unit unit97 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp58 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp58 != null) {
                                                                                AudioGameHelp.releaseGame$default(mGameHelp58, false, false, 3, null);
                                                                                Unit unit98 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            FragmentAudioRoomBinding binding33 = this.this$0.getFragment().getBinding();
                                                                            if (binding33 != null && (imageView29 = binding33.jackaroGame) != null) {
                                                                                imageView29.setVisibility(0);
                                                                                Unit unit99 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp59 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp59 != null) {
                                                                                mGameHelp59.refreshGameData(21);
                                                                                Unit unit100 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_JACKARO_GAME_END /* 957 */:
                                                                        FragmentAudioRoomBinding binding34 = this.this$0.getFragment().getBinding();
                                                                        if (binding34 != null && (imageView31 = binding34.jackaroGame) != null) {
                                                                            imageView31.setVisibility(8);
                                                                            Unit unit101 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp60 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp60 != null) {
                                                                            AudioGameHelp.hideGameView$default(mGameHelp60, null, 1, null);
                                                                            Unit unit102 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp61 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp61 != null) {
                                                                            mGameHelp61.showGameEnd(21, roomEvent.getGameAward());
                                                                            Unit unit103 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_SVIP10_ONLINE /* 958 */:
                                                                        if (roomEvent.getEventData() instanceof Svip10Signaling) {
                                                                            Object eventData8 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData8, "null cannot be cast to non-null type com.qiahao.nextvideo.data.room.Svip10Signaling");
                                                                            Svip10Signaling svip10Signaling = (Svip10Signaling) eventData8;
                                                                            this.this$0.addEnterUserLayout(new EnterEffectData(svip10Signaling.getNickName(), false, 0, null, svip10Signaling.getAvatar(), null, "", Boxing.boxInt(8), svip10Signaling.getCode(), svip10Signaling.getContent(), svip10Signaling.getSvipLevel()));
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_GAME_BET /* 959 */:
                                                                        if ((roomEvent.getEventData() instanceof UserProxy1.NoticeBetGame) && (mGameHelp4 = this.this$0.getFragment().getMGameHelp()) != null && (mHiloGameHelp = mGameHelp4.getMHiloGameHelp()) != null) {
                                                                            Object eventData9 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData9, "null cannot be cast to non-null type userProxy.UserProxy1.NoticeBetGame");
                                                                            mHiloGameHelp.refreshBet((UserProxy1.NoticeBetGame) eventData9);
                                                                            Unit unit104 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_GAME_BET_RANK /* 960 */:
                                                                        if ((roomEvent.getEventData() instanceof UserProxy1.NoticeBetGameBetTopN) && (mGameHelp5 = this.this$0.getFragment().getMGameHelp()) != null && (mHiloGameHelp2 = mGameHelp5.getMHiloGameHelp()) != null) {
                                                                            Object eventData10 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData10, "null cannot be cast to non-null type userProxy.UserProxy1.NoticeBetGameBetTopN");
                                                                            mHiloGameHelp2.refreshButtonRank((UserProxy1.NoticeBetGameBetTopN) eventData10);
                                                                            Unit unit105 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_GAME_WIN_RANK /* 961 */:
                                                                        if ((roomEvent.getEventData() instanceof UserProxy1.NoticeBetGameWinTopN) && (mGameHelp6 = this.this$0.getFragment().getMGameHelp()) != null && (mHiloGameHelp3 = mGameHelp6.getMHiloGameHelp()) != null) {
                                                                            Object eventData11 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData11, "null cannot be cast to non-null type userProxy.UserProxy1.NoticeBetGameWinTopN");
                                                                            mHiloGameHelp3.winRank((UserProxy1.NoticeBetGameWinTopN) eventData11);
                                                                            Unit unit106 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_GAME_CHANGE_MODEL /* 962 */:
                                                                        if (roomEvent.getEventData() instanceof UserProxy1.NoticeGroupGameMode) {
                                                                            Object eventData12 = roomEvent.getEventData();
                                                                            UserProxy1.NoticeGroupGameMode noticeGroupGameMode = eventData12 instanceof UserProxy1.NoticeGroupGameMode ? (UserProxy1.NoticeGroupGameMode) eventData12 : null;
                                                                            if (noticeGroupGameMode != null && noticeGroupGameMode.getStatus() == 1) {
                                                                                AudioGameHelp mGameHelp62 = this.this$0.getFragment().getMGameHelp();
                                                                                if (mGameHelp62 != null) {
                                                                                    mGameHelp62.showGameView(noticeGroupGameMode.getGameType(), new GameConfiguration(Boxing.boxInt(noticeGroupGameMode.getGameType()), null, null, null, null, null, null, noticeGroupGameMode.getGameUrl(), Boxing.boxInt(noticeGroupGameMode.getGameId()), null, null, null, null, null, null, null, 65150, null));
                                                                                    Unit unit107 = Unit.INSTANCE;
                                                                                    break;
                                                                                }
                                                                            } else if (noticeGroupGameMode != null && noticeGroupGameMode.getStatus() == 2 && (mGameHelp7 = this.this$0.getFragment().getMGameHelp()) != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp7, null, 1, null);
                                                                                Unit unit108 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_GAME_NEW_ROUND /* 963 */:
                                                                        if ((roomEvent.getEventData() instanceof UserProxy1.NoticeGroupGameNewRoundStart) && (mGameHelp8 = this.this$0.getFragment().getMGameHelp()) != null && (mHiloGameHelp4 = mGameHelp8.getMHiloGameHelp()) != null) {
                                                                            mHiloGameHelp4.refreshButtonRank(null);
                                                                            Unit unit109 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_MESSAGE_RECEIVER /* 964 */:
                                                                        if ((roomEvent.getEventData() instanceof RoomMessageMulti) && (mChatLayout = this.this$0.getFragment().getMChatLayout()) != null && (mMessageProcessor = mChatLayout.getMMessageProcessor()) != null) {
                                                                            Object eventData13 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData13, "null cannot be cast to non-null type com.qiahao.hilo_message.data.RoomMessageMulti");
                                                                            mMessageProcessor.addMessage((RoomMessageMulti) eventData13);
                                                                            Unit unit110 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_MESSAGE_RSP /* 965 */:
                                                                        if (roomEvent.getEventData() instanceof RoomMessage.GroupMessageSendRsp) {
                                                                            Object eventData14 = roomEvent.getEventData();
                                                                            Intrinsics.checkNotNull(eventData14, "null cannot be cast to non-null type roomMessage.RoomMessage.GroupMessageSendRsp");
                                                                            RoomMessage.GroupMessageSendRsp groupMessageSendRsp = (RoomMessage.GroupMessageSendRsp) eventData14;
                                                                            RoomMessageView mChatLayout2 = this.this$0.getFragment().getMChatLayout();
                                                                            if (mChatLayout2 != null) {
                                                                                mChatLayout2.refreshMessageStatus(groupMessageSendRsp.getMsgId(), 1);
                                                                                Unit unit111 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_CREATE /* 966 */:
                                                                        FragmentAudioRoomBinding binding35 = this.this$0.getFragment().getBinding();
                                                                        if (binding35 != null && (imageView32 = binding35.backgammonGame) != null) {
                                                                            imageView32.setVisibility(0);
                                                                            Unit unit112 = Unit.INSTANCE;
                                                                        }
                                                                        this.this$0.showBackgammonGameView();
                                                                        break;
                                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_STATUS /* 967 */:
                                                                        SUDGameData gameState8 = roomEvent.getGameState();
                                                                        if (gameState8 != null && gameState8.getStatus() == 2) {
                                                                            FragmentAudioRoomBinding binding36 = this.this$0.getFragment().getBinding();
                                                                            if (binding36 != null && (imageView34 = binding36.backgammonGame) != null) {
                                                                                imageView34.setVisibility(8);
                                                                                Unit unit113 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp63 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp63 != null) {
                                                                                AudioGameHelp.hideGameView$default(mGameHelp63, null, 1, null);
                                                                                Unit unit114 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp64 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp64 != null) {
                                                                                AudioGameHelp.releaseGame$default(mGameHelp64, false, false, 3, null);
                                                                                Unit unit115 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            FragmentAudioRoomBinding binding37 = this.this$0.getFragment().getBinding();
                                                                            if (binding37 != null && (imageView33 = binding37.backgammonGame) != null) {
                                                                                imageView33.setVisibility(0);
                                                                                Unit unit116 = Unit.INSTANCE;
                                                                            }
                                                                            AudioGameHelp mGameHelp65 = this.this$0.getFragment().getMGameHelp();
                                                                            if (mGameHelp65 != null) {
                                                                                mGameHelp65.refreshGameData(23);
                                                                                Unit unit117 = Unit.INSTANCE;
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_END /* 968 */:
                                                                        FragmentAudioRoomBinding binding38 = this.this$0.getFragment().getBinding();
                                                                        if (binding38 != null && (imageView35 = binding38.backgammonGame) != null) {
                                                                            imageView35.setVisibility(8);
                                                                            Unit unit118 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp66 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp66 != null) {
                                                                            AudioGameHelp.hideGameView$default(mGameHelp66, null, 1, null);
                                                                            Unit unit119 = Unit.INSTANCE;
                                                                        }
                                                                        AudioGameHelp mGameHelp67 = this.this$0.getFragment().getMGameHelp();
                                                                        if (mGameHelp67 != null) {
                                                                            mGameHelp67.showGameEnd(23, roomEvent.getGameAward());
                                                                            Unit unit120 = Unit.INSTANCE;
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    } else if (roomEvent.getEventData() instanceof UserInRoom) {
                        Object eventData15 = roomEvent.getEventData();
                        Intrinsics.checkNotNull(eventData15, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.UserInRoom");
                        UserInRoom userInRoom = (UserInRoom) eventData15;
                        String externalId = userInRoom.getExternalId();
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user == null || (str = user.getExternalId()) == null) {
                            str = "";
                        }
                        if (!Intrinsics.areEqual(externalId, str)) {
                            this.this$0.addEnterUserLayout(DataExternalKt.roomEventToEnterEffectData(userInRoom));
                            String rideEffectUrl = userInRoom.getRideEffectUrl();
                            if (rideEffectUrl != null && rideEffectUrl.length() != 0) {
                                z = false;
                                if (!z) {
                                    SvipData svip = userInRoom.getSvip();
                                    if (svip == null || svip.isMystery()) {
                                        z2 = false;
                                    }
                                    if (z2 && MeetingRoomManager.INSTANCE.isShowEnterEffect()) {
                                        AudioRoomFragmentHelp audioRoomFragmentHelp8 = this.this$0;
                                        String rideEffectUrl2 = userInRoom.getRideEffectUrl();
                                        String str4 = rideEffectUrl2 == null ? "" : rideEffectUrl2;
                                        String userAvatar = userInRoom.getUserAvatar();
                                        String str5 = userAvatar == null ? "" : userAvatar;
                                        String ridReceiverAvatar = userInRoom.getRidReceiverAvatar();
                                        String str6 = ridReceiverAvatar == null ? "" : ridReceiverAvatar;
                                        String ridSenderAvatar = userInRoom.getRidSenderAvatar();
                                        String str7 = ridSenderAvatar == null ? "" : ridSenderAvatar;
                                        String ridReceiverAvatar2 = userInRoom.getRidReceiverAvatar();
                                        audioRoomFragmentHelp8.playGift(new GiftDateItem(str4, str5, str6, null, null, GiftDateItem.TYPE_ENTER_ANIMATION, null, null, str7, ridReceiverAvatar2 == null ? "" : ridReceiverAvatar2, null, userInRoom.getRideTextStyleList(), userInRoom.getRideReceiverNick(), userInRoom.getRideSenderNick(), null, 17624, null));
                                    }
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                } else {
                    AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "initObserve: RoomEvent.ROOM_MIC_NUMBER_CHANGE麦位数量变化", true, 1, null);
                    GroupDetailBean groupDetailBean2 = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean2 != null) {
                        groupDetailBean2.setMicOn(roomEvent.getMMicOn());
                        Unit unit121 = Unit.INSTANCE;
                    }
                    GroupDetailBean groupDetailBean3 = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean3 != null) {
                        groupDetailBean3.setMicNumType(Boxing.boxInt(roomEvent.getMMicNumType()));
                        Unit unit122 = Unit.INSTANCE;
                    }
                    MeetingRoomManager meetingRoomManager10 = MeetingRoomManager.INSTANCE;
                    meetingRoomManager10.emptyMicInit(meetingRoomManager10.getMicSize(roomEvent.getMMicNumType()));
                    FragmentAudioRoomBinding binding39 = this.this$0.getFragment().getBinding();
                    if (binding39 != null && (newMicroView2 = binding39.microView) != null) {
                        newMicroView2.changeMicType(roomEvent.getMMicNumType());
                        Unit unit123 = Unit.INSTANCE;
                    }
                    AudioGameHelp mGameHelp68 = this.this$0.getFragment().getMGameHelp();
                    if (mGameHelp68 != null) {
                        mGameHelp68.changeGameMicType();
                        Unit unit124 = Unit.INSTANCE;
                    }
                    this.this$0.checkPlayLayout();
                    HiloRtcEngine.INSTANCE.setClientRole(2);
                    if (roomEvent.getMMicOn()) {
                        if (meetingRoomManager10.getLocalRoomMicStatus()) {
                            FragmentAudioRoomBinding binding40 = this.this$0.getFragment().getBinding();
                            if (binding40 != null && (imageView3 = binding40.closeMicTip) != null) {
                                imageView3.setVisibility(8);
                                Unit unit125 = Unit.INSTANCE;
                            }
                            RoomMessageView mChatLayout3 = this.this$0.getFragment().getMChatLayout();
                            if (mChatLayout3 != null && (messageBinding3 = mChatLayout3.messageBinding()) != null && (roomInputView3 = messageBinding3.chatInputLayout) != null) {
                                roomInputView3.changeRoomSoundStatus(true);
                                Unit unit126 = Unit.INSTANCE;
                            }
                        } else {
                            FragmentAudioRoomBinding binding41 = this.this$0.getFragment().getBinding();
                            if (binding41 != null && (imageView2 = binding41.closeMicTip) != null) {
                                imageView2.setVisibility(0);
                                Unit unit127 = Unit.INSTANCE;
                            }
                            RoomMessageView mChatLayout4 = this.this$0.getFragment().getMChatLayout();
                            if (mChatLayout4 != null && (messageBinding2 = mChatLayout4.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                                roomInputView2.changeRoomSoundStatus(false);
                                Unit unit128 = Unit.INSTANCE;
                            }
                        }
                    } else {
                        FragmentAudioRoomBinding binding42 = this.this$0.getFragment().getBinding();
                        if (binding42 != null && (imageView = binding42.closeMicTip) != null) {
                            imageView.setVisibility(8);
                            Unit unit129 = Unit.INSTANCE;
                        }
                        RoomMessageView mChatLayout5 = this.this$0.getFragment().getMChatLayout();
                        if (mChatLayout5 != null && (messageBinding = mChatLayout5.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                            roomInputView.changeRoomSoundStatus(false);
                            Unit unit130 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (Exception e) {
                AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "房间回调逻辑信息报错" + e.getMessage(), false, 5, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRoomFragmentHelp$initObserve$2(AudioRoomFragmentHelp audioRoomFragmentHelp, Continuation<? super AudioRoomFragmentHelp$initObserve$2> continuation) {
        super(2, continuation);
        this.this$0 = audioRoomFragmentHelp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AudioRoomFragmentHelp$initObserve$2 audioRoomFragmentHelp$initObserve$2 = new AudioRoomFragmentHelp$initObserve$2(this.this$0, continuation);
        audioRoomFragmentHelp$initObserve$2.L$0 = obj;
        return audioRoomFragmentHelp$initObserve$2;
    }

    public final Object invokeSuspend(Object obj) {
        Flow buffer$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            buffer$default = FlowKt__ContextKt.buffer$default(MeetingRoomManager.INSTANCE.getWsFlow(), 200, null, 2, null);
            Flow flow = FlowKt.m١٩٠catch(buffer$default, new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, coroutineScope);
            this.label = 1;
            if (flow.collect(anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
