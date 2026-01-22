package com.qiahao.nextvideo.network;

import com.qiahao.base_common.model.ActivityConfigData;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.ApiListData;
import com.qiahao.base_common.model.CustomData;
import com.qiahao.base_common.model.DiamondBean;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.RelationStoreData;
import com.qiahao.base_common.model.RoomRuleBean;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.common.RelationUserData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.model.cp.CpSpace;
import com.qiahao.base_common.model.svip.Details;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.base_common.network.CommonApi;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.GsonConverter;
import com.qiahao.base_common.network.model.OnlineUserListResponse;
import com.qiahao.base_common.network.model.UserCostDiamondsDetail;
import com.qiahao.nextvideo.data.CheckNobleAward;
import com.qiahao.nextvideo.data.RefreshDiamond;
import com.qiahao.nextvideo.data.RefreshMoney;
import com.qiahao.nextvideo.data.baishun.BaiShunActivityData;
import com.qiahao.nextvideo.data.baishun.BaiShunData;
import com.qiahao.nextvideo.data.baishun.HomeMatchGameData;
import com.qiahao.nextvideo.data.cp.CpCheck;
import com.qiahao.nextvideo.data.cp.CpListData;
import com.qiahao.nextvideo.data.cp.CpRecord;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.data.family.FamilyCenterData;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.data.family.FamilyRankData;
import com.qiahao.nextvideo.data.family.FamilyRoomInfo;
import com.qiahao.nextvideo.data.family.FamilyStarData;
import com.qiahao.nextvideo.data.family.FamilyWheelRecord;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.data.firstCharge.ListData;
import com.qiahao.nextvideo.data.foodie.FoodieDrawResult;
import com.qiahao.nextvideo.data.foodie.FoodieGameInfo;
import com.qiahao.nextvideo.data.foodie.FoodieRecordBean;
import com.qiahao.nextvideo.data.foodie.FoodieRepeat;
import com.qiahao.nextvideo.data.foodie.FoodieStake;
import com.qiahao.nextvideo.data.game.GameBroadcast;
import com.qiahao.nextvideo.data.game.GameLobby;
import com.qiahao.nextvideo.data.game.GameLobbyMatch;
import com.qiahao.nextvideo.data.game.GameQuickMatch;
import com.qiahao.nextvideo.data.game.GemGameRank;
import com.qiahao.nextvideo.data.game.HomeGameUser;
import com.qiahao.nextvideo.data.game.LudoCode;
import com.qiahao.nextvideo.data.game.MatchRecent;
import com.qiahao.nextvideo.data.game.Pk1v1End;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.giftRecord.GiftRecordData;
import com.qiahao.nextvideo.data.giftRecord.UploadGiftConfirm;
import com.qiahao.nextvideo.data.mainActivity.MainActivityData;
import com.qiahao.nextvideo.data.medal.MedalSort;
import com.qiahao.nextvideo.data.model.AgentMgrConnectionLogBean;
import com.qiahao.nextvideo.data.model.AgoraVideoCallParams;
import com.qiahao.nextvideo.data.model.AllRankTop3Bean;
import com.qiahao.nextvideo.data.model.AutoInviteUserUpMicBean;
import com.qiahao.nextvideo.data.model.AwardDetailBean;
import com.qiahao.nextvideo.data.model.BeanBaseBean;
import com.qiahao.nextvideo.data.model.BeanChangeDetail;
import com.qiahao.nextvideo.data.model.BlockListBean;
import com.qiahao.nextvideo.data.model.BlockedInfo;
import com.qiahao.nextvideo.data.model.CelebrityOrCharmBean;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.CheckUserInfo;
import com.qiahao.nextvideo.data.model.ConfigurationParam;
import com.qiahao.nextvideo.data.model.ConnectLogItem;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeAllBean;
import com.qiahao.nextvideo.data.model.CpBean;
import com.qiahao.nextvideo.data.model.CpTop3Bean;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.CustomThemeBean;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerListBean;
import com.qiahao.nextvideo.data.model.DeleteAccountConditionBean;
import com.qiahao.nextvideo.data.model.DeleteAccountSuccessBean;
import com.qiahao.nextvideo.data.model.DeleteAccountTimeBean;
import com.qiahao.nextvideo.data.model.EarnDiamondBean;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.ExchangeGem;
import com.qiahao.nextvideo.data.model.FlagBean;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GemBean;
import com.qiahao.nextvideo.data.model.GemGameData;
import com.qiahao.nextvideo.data.model.GiftShortcutData;
import com.qiahao.nextvideo.data.model.GiftWallBean;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.GroupMedalBean;
import com.qiahao.nextvideo.data.model.GroupMemberListBean;
import com.qiahao.nextvideo.data.model.GroupPowerTitleDetail;
import com.qiahao.nextvideo.data.model.GroupPowerWeekBean;
import com.qiahao.nextvideo.data.model.GroupRankBean;
import com.qiahao.nextvideo.data.model.GroupSupportDetailResponseBean;
import com.qiahao.nextvideo.data.model.GroupThemeCustomConfig;
import com.qiahao.nextvideo.data.model.GroupThemesBean;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.HasMyGroupListBean;
import com.qiahao.nextvideo.data.model.HiloAssistantItem;
import com.qiahao.nextvideo.data.model.HiloInformationItem;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupListBean;
import com.qiahao.nextvideo.data.model.ILikeGuyItem;
import com.qiahao.nextvideo.data.model.InRoomBean;
import com.qiahao.nextvideo.data.model.IsBroadCastMangerBean;
import com.qiahao.nextvideo.data.model.IsDealerBean;
import com.qiahao.nextvideo.data.model.JoinGroupBean;
import com.qiahao.nextvideo.data.model.LikeMeGuyItem;
import com.qiahao.nextvideo.data.model.LuckBoxConfigBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.LuckyBoxRankingBean;
import com.qiahao.nextvideo.data.model.LuckyBoxRecordBean;
import com.qiahao.nextvideo.data.model.LuckyFruitBetBean;
import com.qiahao.nextvideo.data.model.LuckyFruitGameDetailBean;
import com.qiahao.nextvideo.data.model.LuckyFruitRankAllBean;
import com.qiahao.nextvideo.data.model.LuckyFruitResultList;
import com.qiahao.nextvideo.data.model.LuckyFruitResultMyRecord;
import com.qiahao.nextvideo.data.model.LuckyTeenRewardBean;
import com.qiahao.nextvideo.data.model.LuckyWheelConfig;
import com.qiahao.nextvideo.data.model.MainListData;
import com.qiahao.nextvideo.data.model.MedalAllTypeBean;
import com.qiahao.nextvideo.data.model.MedalLevelUserHasBeanBody;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.data.model.MissData;
import com.qiahao.nextvideo.data.model.MsgForHiloOfficial;
import com.qiahao.nextvideo.data.model.MyCpBean;
import com.qiahao.nextvideo.data.model.MyNobleBeanItem;
import com.qiahao.nextvideo.data.model.MySupportAllBean;
import com.qiahao.nextvideo.data.model.NamePlateData;
import com.qiahao.nextvideo.data.model.NewRoomBean;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.data.model.PowerGroupMemberBean;
import com.qiahao.nextvideo.data.model.PowerTeamMemberBean;
import com.qiahao.nextvideo.data.model.PowerTop3Bean;
import com.qiahao.nextvideo.data.model.PraiseGuyItem;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.model.PurchaseItem;
import com.qiahao.nextvideo.data.model.RandomPairChatroomConfig;
import com.qiahao.nextvideo.data.model.RankGroupBean;
import com.qiahao.nextvideo.data.model.ReceivedGift;
import com.qiahao.nextvideo.data.model.RewardLuckyBoxBean;
import com.qiahao.nextvideo.data.model.RocketDetailBean;
import com.qiahao.nextvideo.data.model.RocketResultListBean;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.model.RoomAndPersonalBannerBean;
import com.qiahao.nextvideo.data.model.RoomAndPersonalTaskBean;
import com.qiahao.nextvideo.data.model.ScrollBean;
import com.qiahao.nextvideo.data.model.SearchGroupListBean;
import com.qiahao.nextvideo.data.model.SuperLikeData;
import com.qiahao.nextvideo.data.model.SupportAwardResponseBean;
import com.qiahao.nextvideo.data.model.SurplusDiamonds;
import com.qiahao.nextvideo.data.model.UploadCustomThemeBean;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.data.model.UserLikeEachItem;
import com.qiahao.nextvideo.data.model.UserPictureResponseBean;
import com.qiahao.nextvideo.data.model.UserResponse;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.model.VideoFreeCheck;
import com.qiahao.nextvideo.data.model.VideoResultData;
import com.qiahao.nextvideo.data.model.VipDailyDiamondBean;
import com.qiahao.nextvideo.data.model.VisitGuyItem;
import com.qiahao.nextvideo.data.model.WechatAuthorizedInfo;
import com.qiahao.nextvideo.data.model.WechatUserInfo;
import com.qiahao.nextvideo.data.model.WeekPowerTop3Bean;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelData;
import com.qiahao.nextvideo.data.model.youtube.WatchYouTuListData;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.data.noble.NobleCardLog;
import com.qiahao.nextvideo.data.noble.NobleUse;
import com.qiahao.nextvideo.data.planets.HiloPlanetsData;
import com.qiahao.nextvideo.data.promote.PromoteMonth;
import com.qiahao.nextvideo.data.promote.PromoteRank;
import com.qiahao.nextvideo.data.promote.PromoteRankData;
import com.qiahao.nextvideo.data.room.BoxGet;
import com.qiahao.nextvideo.data.room.BoxLevel;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.data.room.EnvelopeRecordData;
import com.qiahao.nextvideo.data.room.GameCategory;
import com.qiahao.nextvideo.data.room.RoomActiveData;
import com.qiahao.nextvideo.data.room.RoomCurrentPK;
import com.qiahao.nextvideo.data.room.RoomPKUser;
import com.qiahao.nextvideo.data.room.RoomRecordData;
import com.qiahao.nextvideo.data.service.match.MatchConfigData;
import com.qiahao.nextvideo.data.sheep.SheepMatchData;
import com.qiahao.nextvideo.data.store.BagCarromData;
import com.qiahao.nextvideo.data.store.StoreCarromData;
import com.qiahao.nextvideo.data.strange.StrangeConfirm;
import com.qiahao.nextvideo.data.strange.StrangeUserData;
import com.qiahao.nextvideo.data.task.GoldTaskData;
import com.qiahao.nextvideo.data.task.RealCertificationResult;
import com.qiahao.nextvideo.data.transfer.SecondMonth;
import com.qiahao.nextvideo.data.transfer.SecondRank;
import com.qiahao.nextvideo.data.transfer.TransferBanner;
import com.qiahao.nextvideo.data.transfer.TransferCheckData;
import com.qiahao.nextvideo.data.transfer.TransferMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.data.transfer.TransferRank;
import com.qiahao.nextvideo.data.transfer.TransferRecordData;
import com.qiahao.nextvideo.room.viewmodel.GroupSettingViewModel;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.cp.CpMemorialViewModel;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity;
import com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskFragment;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000æ\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J]\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0004\b\u0010\u0010\u0011Jc\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\n2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0004\b\"\u0010#J5\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0004\b%\u0010#J5\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0004\b'\u0010#J5\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0004\b*\u0010#J%\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u000b0\n2\b\b\u0003\u0010+\u001a\u00020\u0004H'¢\u0006\u0004\b-\u0010.J%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000b0\n2\b\b\u0001\u0010/\u001a\u00020\u0002H'¢\u0006\u0004\b1\u00102J%\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u000b0\n2\b\b\u0001\u0010/\u001a\u00020\u0002H'¢\u0006\u0004\b3\u00102J%\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0004\b5\u00102J%\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u000b0\n2\b\b\u0003\u00106\u001a\u00020\u0002H'¢\u0006\u0004\b8\u00102J+\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090 0\u000b0\n2\b\b\u0003\u00106\u001a\u00020\u0002H'¢\u0006\u0004\b:\u00102J\u001b\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u000b0\nH'¢\u0006\u0004\b<\u0010\u0011JA\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b?\u0010@JS\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010B\u001a\u00020\u00042\n\b\u0001\u0010C\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010D\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\bF\u0010GJ\u001b\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u000b0\nH'¢\u0006\u0004\bI\u0010\u0011J\u001b\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u000b0JH'¢\u0006\u0004\bL\u0010MJ1\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010N\u001a\u00020\u00042\n\b\u0001\u0010O\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bP\u0010QJ%\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\b\b\u0001\u0010R\u001a\u00020\u0002H'¢\u0006\u0004\bS\u00102J?\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0(0\u000b0\n2\b\b\u0001\u0010R\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0004\bU\u0010VJC\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u000b0\n2\b\b\u0001\u0010/\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010W\u001a\u00020\u00042\b\b\u0001\u0010X\u001a\u00020\u0004H'¢\u0006\u0004\bZ\u0010[JY\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\b\b\u0001\u0010/\u001a\u00020\u00022\b\b\u0001\u0010\\\u001a\u00020\u00192\b\b\u0003\u0010]\u001a\u00020\u00042\b\b\u0001\u0010^\u001a\u00020\u00022\b\b\u0003\u0010_\u001a\u00020\u00042\n\b\u0003\u0010`\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bb\u0010cJY\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020i0\u000b0\n2\b\b\u0003\u00106\u001a\u00020\u00042\b\b\u0001\u0010d\u001a\u00020\u00022\b\b\u0001\u0010e\u001a\u00020\u00022\n\b\u0003\u0010f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010g\u001a\u00020\u00022\b\b\u0003\u0010h\u001a\u00020\u0002H'¢\u0006\u0004\bj\u0010kJE\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\n2\b\b\u0001\u0010d\u001a\u00020\u00022\b\b\u0001\u0010l\u001a\u00020\u00022\b\b\u0001\u0010g\u001a\u00020\u00022\n\b\u0003\u0010m\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bn\u0010oJ?\u0010r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0003\u0010p\u001a\u00020\u0004H'¢\u0006\u0004\br\u0010sJ1\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0014\u001a\u00020\u00022\n\b\u0001\u0010t\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\bu\u0010vJ5\u0010z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0 0\u000b0\n2\b\b\u0001\u0010w\u001a\u00020\u00192\b\b\u0001\u0010x\u001a\u00020\u0019H'¢\u0006\u0004\bz\u0010{J%\u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0\u000b0\n2\b\b\u0001\u0010|\u001a\u00020\u0002H'¢\u0006\u0004\b~\u00102J7\u0010\u0080\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u007f0 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b\u0080\u0001\u0010#J\u001d\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\nH'¢\u0006\u0005\b\u0081\u0001\u0010\u0011J\u001d\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\nH'¢\u0006\u0005\b\u0082\u0001\u0010\u0011J2\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\b\b\u0001\u0010R\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0084\u0001\u0010vJ3\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0086\u0001\u0010vJ'\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000b0\n2\b\b\u0001\u0010R\u001a\u00020\u0002H'¢\u0006\u0005\b\u0087\u0001\u00102J(\u0010\u0089\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0089\u0001\u00102J:\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010\n2\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u008b\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u008c\u0001\u001a\u00020\u0002H'¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J'\u0010\u0090\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\b\u0090\u0001\u00102JO\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u00010\n2\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u00022\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0002H'¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001JG\u0010\u0098\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u00022\b\b\u0001\u0010N\u001a\u00020\u00022\b\b\u0001\u0010O\u001a\u00020\u0002H'¢\u0006\u0005\b\u0098\u0001\u0010oJI\u0010\u009a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010\u0099\u0001\u001a\u00020\u0004H'¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J8\u0010\u009d\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009c\u00010 0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b\u009d\u0001\u0010#J \u0010 \u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009f\u00010\u000b0\u009e\u0001H'¢\u0006\u0006\b \u0001\u0010¡\u0001J8\u0010£\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¢\u00010 0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b£\u0001\u0010#J8\u0010¥\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¤\u00010 0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b¥\u0001\u0010#J(\u0010§\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¦\u0001\u001a\u00020\u0004H'¢\u0006\u0005\b§\u0001\u0010.J3\u0010©\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¨\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b©\u0001\u0010vJ5\u0010¬\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u00010\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u00022\t\b\u0001\u0010ª\u0001\u001a\u00020\u0004H'¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J(\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010®\u0001\u001a\u00020\u0004H'¢\u0006\u0005\b¯\u0001\u0010.J\u001d\u0010°\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b°\u0001\u0010\u0011J\u001e\u0010²\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030±\u00010\u000b0\nH'¢\u0006\u0005\b²\u0001\u0010\u0011J)\u0010µ\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030´\u00010\u000b0\n2\t\b\u0001\u0010³\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bµ\u0001\u00102J)\u0010·\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u00010\u000b0\n2\t\b\u0001\u0010¶\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b·\u0001\u00102J\u001e\u0010¹\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¸\u00010\u000b0\nH'¢\u0006\u0005\b¹\u0001\u0010\u0011J(\u0010º\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¶\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bº\u0001\u00102J(\u0010»\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b»\u0001\u00102J(\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b¼\u0001\u00102J(\u0010½\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b½\u0001\u00102J4\u0010¿\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u00022\t\b\u0001\u0010¾\u0001\u001a\u00020\u0004H'¢\u0006\u0006\b¿\u0001\u0010\u00ad\u0001J8\u0010Á\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030À\u00010 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÁ\u0001\u0010#J(\u0010Ã\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Â\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÃ\u0001\u00102J3\u0010Æ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Ä\u0001\u001a\u00020\u00022\t\b\u0001\u0010Å\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÆ\u0001\u0010vJ/\u0010È\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ç\u00010 0\u000b0\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÈ\u0001\u00102J5\u0010Ë\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010É\u0001\u001a\u00020\u00022\u000b\b\u0003\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0005\bË\u0001\u0010vJ(\u0010Ì\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÌ\u0001\u00102J(\u0010Î\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Í\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÎ\u0001\u00102J$\u0010Ð\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00010 0\u000b0\nH'¢\u0006\u0005\bÐ\u0001\u0010\u0011J)\u0010Ò\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ñ\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÒ\u0001\u00102J)\u0010Ó\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ñ\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÓ\u0001\u00102J\u001e\u0010Õ\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ô\u00010\u000b0\nH'¢\u0006\u0005\bÕ\u0001\u0010\u0011J4\u0010×\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0003\u0010Ö\u0001\u001a\u00020\u0004H'¢\u0006\u0006\b×\u0001\u0010\u00ad\u0001J(\u0010Ø\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bØ\u0001\u00102J=\u0010Ú\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ù\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÚ\u0001\u0010VJJ\u0010Û\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ù\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J/\u0010Þ\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ý\u00010 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÞ\u0001\u00102Jù\u0001\u0010î\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010ß\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010à\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010á\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010â\u0001\u001a\u0004\u0018\u00010\u00022\f\b\u0003\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00012\u000b\b\u0003\u0010å\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010æ\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010ç\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010è\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010é\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010ê\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010ë\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010ì\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010í\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0003\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\bî\u0001\u0010ï\u0001J(\u0010ñ\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ð\u00010\u000b0\n2\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\bñ\u0001\u00102J2\u0010ó\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ò\u00010\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bó\u0001\u0010#JC\u0010õ\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00010 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\t\b\u0001\u0010ô\u0001\u001a\u00020\u0004H'¢\u0006\u0005\bõ\u0001\u0010sJ$\u0010÷\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ö\u00010 0\u000b0\nH'¢\u0006\u0005\b÷\u0001\u0010\u0011J=\u0010ù\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ò\u00010\u000b0\n2\t\b\u0001\u0010ø\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bù\u0001\u0010VJv\u0010ÿ\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010]\u001a\u00020\u00042\b\b\u0001\u0010^\u001a\u00020\u00022\t\b\u0001\u0010â\u0001\u001a\u00020\u00022\t\b\u0001\u0010ú\u0001\u001a\u00020\u00042\t\b\u0001\u0010û\u0001\u001a\u00020\u00022\n\b\u0001\u0010ü\u0001\u001a\u00030ã\u00012\t\b\u0001\u0010ý\u0001\u001a\u00020\u0004H'¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J/\u0010\u0082\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0081\u00020 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0082\u0002\u00102J>\u0010\u0084\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0002\u001a\u00020\u00042\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002JK\u0010\u0086\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ù\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\u000b\b\u0001\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002J6\u0010\u0089\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\u000b\b\u0001\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002J3\u0010\u008c\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u008b\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b\u008c\u0002\u0010vJ4\u0010\u008d\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u008d\u0002\u0010\u00ad\u0001J4\u0010\u008e\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u008e\u0002\u0010\u00ad\u0001J4\u0010\u008f\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u008f\u0002\u0010\u00ad\u0001J4\u0010\u0090\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u0090\u0002\u0010\u00ad\u0001J4\u0010\u0091\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u0091\u0002\u0010\u00ad\u0001J4\u0010\u0092\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u0092\u0002\u0010\u00ad\u0001J4\u0010\u0093\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0002\u001a\u00020\u0004H'¢\u0006\u0006\b\u0093\u0002\u0010\u00ad\u0001J5\u0010\u0095\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0094\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0005\b\u0095\u0002\u0010vJK\u0010\u0098\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u00022\n\b\u0001\u0010\u0096\u0002\u001a\u00030ã\u00012\n\b\u0001\u0010\u0097\u0002\u001a\u00030ã\u0001H'¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002J2\u0010\u009a\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b\u009a\u0002\u0010vJ2\u0010\u009b\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b\u009b\u0002\u0010vJf\u0010¡\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u009c\u0002\u001a\u00020\u00042\u000b\b\u0001\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u009f\u0002\u001a\u00030ã\u00012\n\b\u0003\u0010 \u0002\u001a\u00030ã\u0001H'¢\u0006\u0006\b¡\u0002\u0010¢\u0002J$\u0010¤\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00020 0\u000b0\nH'¢\u0006\u0005\b¤\u0002\u0010\u0011JI\u0010¥\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\\\u001a\u00020\u00192\b\b\u0001\u0010_\u001a\u00020\u00042\n\b\u0003\u0010`\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\b¥\u0002\u0010¦\u0002JI\u0010§\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\\\u001a\u00020\u00192\b\b\u0001\u0010_\u001a\u00020\u00042\n\b\u0003\u0010`\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\b§\u0002\u0010¦\u0002J\u001e\u0010©\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00020\u000b0\nH'¢\u0006\u0005\b©\u0002\u0010\u0011J*\u0010«\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00020\u000b0\n2\t\b\u0001\u0010ª\u0002\u001a\u00020\u0019H'¢\u0006\u0006\b«\u0002\u0010¬\u0002J)\u0010¯\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u00020\u000b0\n2\t\b\u0001\u0010\u00ad\u0002\u001a\u00020\u0004H'¢\u0006\u0005\b¯\u0002\u0010.J8\u0010±\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030°\u00020 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b±\u0002\u0010#J8\u0010³\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030²\u00020 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b³\u0002\u0010#J)\u0010µ\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030´\u00020\u000b0\n2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bµ\u0002\u00102J/\u0010¸\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030·\u00020 0\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b¸\u0002\u00102J/\u0010¹\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030·\u00020 0\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b¹\u0002\u00102J/\u0010»\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030º\u00020 0\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b»\u0002\u00102J3\u0010½\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010¼\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b½\u0002\u0010vJ\u001e\u0010¿\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¾\u00020\u000b0\nH'¢\u0006\u0005\b¿\u0002\u0010\u0011J\u001e\u0010Á\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030À\u00020\u000b0\nH'¢\u0006\u0005\bÁ\u0002\u0010\u0011J:\u0010Ã\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Â\u00020 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\bÃ\u0002\u0010vJ:\u0010Ä\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Â\u00020 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\bÄ\u0002\u0010vJ@\u0010Ç\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010Å\u0002\u001a\u00020\u00042\n\b\u0001\u0010Æ\u0002\u001a\u00030ã\u00012\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bÇ\u0002\u0010È\u0002J'\u0010É\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bÉ\u0002\u0010.J$\u0010Ë\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ê\u00020 0\u000b0\nH'¢\u0006\u0005\bË\u0002\u0010\u0011J4\u0010Í\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bÍ\u0002\u0010Î\u0002J\u001e\u0010Ð\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00020\u000b0\nH'¢\u0006\u0005\bÐ\u0002\u0010\u0011J$\u0010Ò\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ñ\u00020 0\u000b0\nH'¢\u0006\u0005\bÒ\u0002\u0010\u0011J)\u0010Ô\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ó\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÔ\u0002\u00102J\u001e\u0010Ö\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Õ\u00020\u000b0\nH'¢\u0006\u0005\bÖ\u0002\u0010\u0011J$\u0010Ø\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030×\u00020 0\u000b0\nH'¢\u0006\u0005\bØ\u0002\u0010\u0011J@\u0010Û\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\n\b\u0001\u0010Ù\u0002\u001a\u00030ã\u00012\t\b\u0001\u0010Ú\u0002\u001a\u00020\u0002H'¢\u0006\u0006\bÛ\u0002\u0010Ü\u0002J@\u0010Ý\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\n\b\u0001\u0010Ù\u0002\u001a\u00030ã\u00012\t\b\u0001\u0010Ú\u0002\u001a\u00020\u0002H'¢\u0006\u0006\bÝ\u0002\u0010Ü\u0002J(\u0010Þ\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÞ\u0002\u00102J)\u0010ß\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bß\u0002\u00102J+\u0010á\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030à\u00020\u000b0\n2\u000b\b\u0001\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0005\bá\u0002\u00102J2\u0010â\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\bâ\u0002\u0010vJ4\u0010å\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ä\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010ã\u0002\u001a\u00020\u0002H'¢\u0006\u0005\bå\u0002\u0010vJ*\u0010è\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ç\u00020\u000b0\n2\t\b\u0001\u0010æ\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bè\u0002\u0010¬\u0002J*\u0010ë\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ê\u00020\u000b0\n2\t\b\u0001\u0010é\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bë\u0002\u0010¬\u0002J)\u0010ì\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010æ\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bì\u0002\u0010¬\u0002J)\u0010í\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010æ\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bí\u0002\u0010¬\u0002JB\u0010ï\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030î\u00020 0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bï\u0002\u0010sJD\u0010ñ\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ð\u00020 0\u000b0\n2\t\b\u0001\u0010æ\u0002\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0006\bñ\u0002\u0010ò\u0002J(\u0010ó\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bó\u0002\u00102J$\u0010ô\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00020 0\u000b0\nH'¢\u0006\u0005\bô\u0002\u0010\u0011J8\u0010ö\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030õ\u00020 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bö\u0002\u0010#J.\u0010ø\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030÷\u00020 0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\bø\u0002\u00102J)\u0010ú\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010ù\u0002\u001a\u00020\u0019H'¢\u0006\u0006\bú\u0002\u0010¬\u0002J5\u0010þ\u0002\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ý\u00020\u000b0\n2\t\b\u0001\u0010û\u0002\u001a\u00020\u00192\t\b\u0001\u0010ü\u0002\u001a\u00020\u0002H'¢\u0006\u0006\bþ\u0002\u0010ÿ\u0002J4\u0010\u0080\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010ù\u0002\u001a\u00020\u00192\t\b\u0001\u0010ü\u0002\u001a\u00020\u0002H'¢\u0006\u0006\b\u0080\u0003\u0010ÿ\u0002J8\u0010\u0081\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030õ\u00020 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b\u0081\u0003\u0010#J$\u0010\u0082\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030÷\u00020 0\u000b0\nH'¢\u0006\u0005\b\u0082\u0003\u0010\u0011J)\u0010\u0084\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0003\u001a\u00020\u0019H'¢\u0006\u0006\b\u0084\u0003\u0010¬\u0002J5\u0010\u0086\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ý\u00020\u000b0\n2\t\b\u0001\u0010\u0085\u0003\u001a\u00020\u00192\t\b\u0001\u0010ü\u0002\u001a\u00020\u0002H'¢\u0006\u0006\b\u0086\u0003\u0010ÿ\u0002J4\u0010\u0087\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0003\u001a\u00020\u00192\t\b\u0001\u0010ü\u0002\u001a\u00020\u0002H'¢\u0006\u0006\b\u0087\u0003\u0010ÿ\u0002J\u001d\u0010\u0088\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\nH'¢\u0006\u0005\b\u0088\u0003\u0010\u0011J\u001d\u0010\u0089\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\nH'¢\u0006\u0005\b\u0089\u0003\u0010\u0011J)\u0010\u008b\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008a\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008b\u0003\u00102J(\u0010\u008c\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008c\u0003\u00102J(\u0010\u008d\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008d\u0003\u00102J(\u0010\u008e\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008e\u0003\u00102J)\u0010\u0090\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008f\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0090\u0003\u00102JL\u0010\u0094\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010\u0091\u0003\u001a\u00020\u00042\n\b\u0001\u0010\u0092\u0003\u001a\u00030ã\u00012\n\b\u0001\u0010\u0093\u0003\u001a\u00030ã\u00012\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\b\u0094\u0003\u0010\u0095\u0003J)\u0010\u0097\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0096\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0097\u0003\u00102JE\u0010\u009a\u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030£\u00020\u0098\u0003j\n\u0012\u0005\u0012\u00030£\u0002`\u0099\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b\u009a\u0003\u0010#J\u001e\u0010\u009c\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009b\u00030\u000b0\nH'¢\u0006\u0005\b\u009c\u0003\u0010\u0011JP\u0010\u009e\u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u009d\u00030\u0098\u0003j\n\u0012\u0005\u0012\u00030\u009d\u0003`\u0099\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b\u009e\u0003\u0010@JE\u0010 \u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u009f\u00030\u0098\u0003j\n\u0012\u0005\u0012\u00030\u009f\u0003`\u0099\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b \u0003\u0010#J'\u0010¡\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b¡\u0003\u00102J=\u0010¤\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\t\b\u0001\u0010¢\u0003\u001a\u00020\u0002H'¢\u0006\u0005\b¤\u0003\u0010@J\u001e\u0010¦\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¥\u00030\u000b0\nH'¢\u0006\u0005\b¦\u0003\u0010\u0011J\u001e\u0010¨\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030§\u00030\u000b0\nH'¢\u0006\u0005\b¨\u0003\u0010\u0011J\u001e\u0010ª\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030©\u00030\u000b0\nH'¢\u0006\u0005\bª\u0003\u0010\u0011J\u001e\u0010¬\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u00030\u000b0\nH'¢\u0006\u0005\b¬\u0003\u0010\u0011J=\u0010®\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\t\b\u0001\u0010\u0091\u0003\u001a\u00020\u00042\t\b\u0001\u0010\u00ad\u0003\u001a\u00020\u0004H'¢\u0006\u0005\b®\u0003\u0010VJ=\u0010±\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030°\u00030\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\t\b\u0003\u0010¯\u0003\u001a\u00020\u0004H'¢\u0006\u0005\b±\u0003\u0010VJ@\u0010³\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030²\u00030\u000b0\n2\t\b\u0001\u0010¨\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010Ê\u0001\u001a\u00020\u0002H'¢\u0006\u0006\b³\u0003\u0010\u008f\u0001J<\u0010µ\u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030´\u00030\u0098\u0003j\n\u0012\u0005\u0012\u00030´\u0003`\u0099\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bµ\u0003\u00102J3\u0010·\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010¶\u0003\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b·\u0003\u0010QJ\u001e\u0010¹\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¸\u00030\u000b0\nH'¢\u0006\u0005\b¹\u0003\u0010\u0011J$\u0010»\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030º\u00030 0\u000b0\nH'¢\u0006\u0005\b»\u0003\u0010\u0011J$\u0010¼\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030º\u00030 0\u000b0\nH'¢\u0006\u0005\b¼\u0003\u0010\u0011J(\u0010¾\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030½\u00030\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b¾\u0003\u0010.J(\u0010À\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010¿\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bÀ\u0003\u0010.J/\u0010Â\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Á\u00030 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÂ\u0003\u00102J)\u0010Ä\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ã\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÄ\u0003\u00102J)\u0010Æ\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Å\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÆ\u0003\u00102J)\u0010È\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ç\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÈ\u0003\u00102J1\u0010Ê\u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030É\u00030\u0098\u0003j\n\u0012\u0005\u0012\u00030É\u0003`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bÊ\u0003\u0010\u0011JE\u0010Ì\u0003\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030Ë\u00030\u0098\u0003j\n\u0012\u0005\u0012\u00030Ë\u0003`\u0099\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÌ\u0003\u0010#J\u001e\u0010Î\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Í\u00030\u000b0\nH'¢\u0006\u0005\bÎ\u0003\u0010\u0011J\u001e\u0010Ð\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00030\u000b0\nH'¢\u0006\u0005\bÐ\u0003\u0010\u0011J\u001e\u0010Ò\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ñ\u00030\u000b0\nH'¢\u0006\u0005\bÒ\u0003\u0010\u0011J\u001e\u0010Ó\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00030\u000b0\nH'¢\u0006\u0005\bÓ\u0003\u0010\u0011J$\u0010Õ\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ô\u00030 0\u000b0\nH'¢\u0006\u0005\bÕ\u0003\u0010\u0011J\u001e\u0010×\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ö\u00030\u000b0\nH'¢\u0006\u0005\b×\u0003\u0010\u0011J(\u0010Ù\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ø\u00030\u000b0\n2\b\b\u0001\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0005\bÙ\u0003\u00102J8\u0010Û\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ú\u00030 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÛ\u0003\u0010#J3\u0010Ý\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010Ü\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bÝ\u0003\u0010vJ?\u0010à\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010Þ\u0003\u001a\u00020\u00192\t\b\u0001\u0010ß\u0003\u001a\u00020\u00022\t\b\u0001\u0010\u009e\u0002\u001a\u00020\u0002H'¢\u0006\u0006\bà\u0003\u0010á\u0003J8\u0010ã\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030â\u00030 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bã\u0003\u0010#J.\u0010å\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ä\u00030 0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bå\u0003\u0010.J$\u0010ç\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030æ\u00030 0\u000b0\nH'¢\u0006\u0005\bç\u0003\u0010\u0011J\u001e\u0010è\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030æ\u00030\u000b0\nH'¢\u0006\u0005\bè\u0003\u0010\u0011J)\u0010é\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bé\u0003\u00102J2\u0010ë\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ê\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bë\u0003\u0010#J$\u0010ì\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00010 0\u000b0\nH'¢\u0006\u0005\bì\u0003\u0010\u0011J8\u0010í\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00010 0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bí\u0003\u0010#J$\u0010î\u0003\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ï\u00010 0\u000b0\nH'¢\u0006\u0005\bî\u0003\u0010\u0011J)\u0010ñ\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ð\u00030\u000b0\n2\t\b\u0003\u0010ï\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bñ\u0003\u0010.J3\u0010ó\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010ò\u0003\u001a\u00020\u00042\t\b\u0003\u0010ï\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bó\u0003\u0010#J4\u0010÷\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ö\u00030\u000b0\n2\t\b\u0001\u0010ô\u0003\u001a\u00020\u00042\t\b\u0001\u0010õ\u0003\u001a\u00020\u0004H'¢\u0006\u0005\b÷\u0003\u0010#J\u001e\u0010ù\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ø\u00030\u000b0\nH'¢\u0006\u0005\bù\u0003\u0010\u0011J)\u0010û\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ø\u00030\u000b0\n2\t\b\u0001\u0010ú\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bû\u0003\u0010.J\u001e\u0010ý\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ü\u00030\u000b0\nH'¢\u0006\u0005\bý\u0003\u0010\u0011J2\u0010ÿ\u0003\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00030\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÿ\u0003\u0010#J2\u0010\u0081\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0080\u00040\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b\u0081\u0004\u0010#J:\u0010\u0083\u0004\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u00160\u0098\u0003j\t\u0012\u0004\u0012\u00020\u0016`\u0099\u00030\u000b0\n2\t\b\u0001\u0010\u0082\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b\u0083\u0004\u00102J@\u0010\u0087\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00040\u000b0\n2\t\b\u0001\u0010\u0084\u0004\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u00022\n\b\u0003\u0010\u0085\u0004\u001a\u00030ã\u0001H'¢\u0006\u0006\b\u0087\u0004\u0010\u0088\u0004J4\u0010\u008a\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Þ\u0003\u001a\u00020\u00022\t\b\u0003\u0010\u0089\u0004\u001a\u00020\u0004H'¢\u0006\u0006\b\u008a\u0004\u0010\u00ad\u0001J$\u0010\u008c\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00040 0\u000b0\nH'¢\u0006\u0005\b\u008c\u0004\u0010\u0011J$\u0010\u008e\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008d\u00040 0\u000b0\nH'¢\u0006\u0005\b\u008e\u0004\u0010\u0011J(\u0010\u0090\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010\u008f\u0004\u001a\u00020\u0004H'¢\u0006\u0005\b\u0090\u0004\u0010.J3\u0010\u0092\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\t\b\u0001\u0010\u008f\u0004\u001a\u00020\u00042\t\b\u0001\u0010\u0091\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b\u0092\u0004\u0010QJ@\u0010\u0097\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0096\u00040\u000b0\n2\t\b\u0001\u0010\u0093\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u0094\u0004\u001a\u00020\u00042\t\b\u0001\u0010\u0095\u0004\u001a\u00020\u0002H'¢\u0006\u0006\b\u0097\u0004\u0010\u0085\u0002J?\u0010\u0098\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0093\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u0094\u0004\u001a\u00020\u00042\t\b\u0001\u0010\u0095\u0004\u001a\u00020\u0002H'¢\u0006\u0006\b\u0098\u0004\u0010\u0085\u0002J'\u0010\u0099\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b\u0099\u0004\u00102J'\u0010\u009a\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b\u009a\u0004\u00102J\u001e\u0010\u009c\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009b\u00040\u000b0\nH'¢\u0006\u0005\b\u009c\u0004\u0010\u0011J\u001d\u0010\u009d\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\nH'¢\u0006\u0005\b\u009d\u0004\u0010\u0011J8\u0010\u009f\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009e\u00040(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b\u009f\u0004\u0010#JB\u0010 \u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009e\u00040 0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b \u0004\u0010VJ\u001e\u0010¢\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¡\u00040\u000b0\nH'¢\u0006\u0005\b¢\u0004\u0010\u0011J3\u0010¥\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¤\u00040\u000b0\n2\b\b\u0001\u00106\u001a\u00020\u00042\t\b\u0001\u0010£\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b¥\u0004\u0010QJO\u0010¨\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030§\u00040¦\u00040\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\b¨\u0004\u0010©\u0004J4\u0010¬\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010ª\u0004\u001a\u00020\u00022\t\b\u0001\u0010«\u0004\u001a\u00020\u0004H'¢\u0006\u0006\b¬\u0004\u0010\u00ad\u0001JM\u0010\u00ad\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\t\b\u0001\u0010ª\u0004\u001a\u00020\u0002H'¢\u0006\u0006\b\u00ad\u0004\u0010©\u0004J)\u0010®\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030§\u00040\u000b0\n2\t\b\u0001\u0010ª\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b®\u0004\u00102Jx\u0010µ\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¯\u0004\u001a\u00020\u00022\t\b\u0001\u0010°\u0004\u001a\u00020\u00022\t\b\u0001\u0010±\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010²\u0004\u001a\u00020\u00042\t\b\u0001\u0010³\u0004\u001a\u00020\u00192\t\b\u0001\u0010´\u0004\u001a\u00020\u00042\u000b\b\u0003\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\bµ\u0004\u0010¶\u0004J>\u0010·\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010ª\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010\u009e\u0002\u001a\u00020\u0002H'¢\u0006\u0006\b·\u0004\u0010\u0085\u0002J@\u0010º\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\t\b\u0001\u0010¹\u0004\u001a\u00020\u0002H'¢\u0006\u0006\bº\u0004\u0010\u008f\u0001J]\u0010½\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00040\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u00022\t\b\u0001\u0010»\u0004\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u00022\t\b\u0001\u0010¹\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b½\u0004\u0010kJH\u0010¾\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00040\u000b0\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00022\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\t\b\u0001\u0010¹\u0004\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\b¾\u0004\u0010oJ>\u0010À\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¿\u0004\u001a\u00020\u00022\t\b\u0001\u0010¹\u0004\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0006\bÀ\u0004\u0010\u008f\u0001JI\u0010Á\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010\u0094\u0004\u001a\u00020\u00042\t\b\u0001\u0010\u0093\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u0095\u0004\u001a\u00020\u0002H'¢\u0006\u0006\bÁ\u0004\u0010Â\u0004JS\u0010Å\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u00022\t\b\u0001\u0010Ã\u0004\u001a\u00020\u00022\t\b\u0001\u0010Ä\u0004\u001a\u00020\u0004H'¢\u0006\u0006\bÅ\u0004\u0010Æ\u0004JH\u0010À\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Ç\u0004\u001a\u00020\u00022\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\t\b\u0001\u0010¹\u0004\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\bÀ\u0004\u0010oJJ\u0010È\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¸\u0004\u001a\u00020\u00022\t\b\u0001\u0010Ç\u0004\u001a\u00020\u00022\t\b\u0001\u0010Ã\u0004\u001a\u00020\u00022\t\b\u0001\u0010Ä\u0004\u001a\u00020\u0004H'¢\u0006\u0006\bÈ\u0004\u0010É\u0004J<\u0010Ì\u0004\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030Ë\u00040\u0098\u0003j\n\u0012\u0005\u0012\u00030Ë\u0004`\u0099\u00030\u000b0\n2\t\b\u0001\u0010Ê\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bÌ\u0004\u0010.J5\u0010Ï\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Î\u00040\u000b0\n2\t\b\u0001\u0010Í\u0004\u001a\u00020\u00192\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bÏ\u0004\u0010ÿ\u0002J(\u0010Ñ\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Ð\u0004\u001a\u00020\u0002H'¢\u0006\u0005\bÑ\u0004\u00102J(\u0010Ó\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Ò\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bÓ\u0004\u0010.J(\u0010Õ\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Ô\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bÕ\u0004\u0010.J\u001e\u0010×\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ö\u00040\u000b0\nH'¢\u0006\u0005\b×\u0004\u0010\u0011J(\u0010Ø\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bØ\u0004\u00102Jw\u0010ß\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00020\u000b0\n2\t\b\u0001\u0010Ù\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ú\u0004\u001a\u00020\u00042\t\b\u0001\u0010Û\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ü\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ý\u0004\u001a\u00020\u00042\t\b\u0001\u0010Þ\u0004\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010û\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bß\u0004\u0010à\u0004Jk\u0010â\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u00192\t\b\u0001\u0010Ú\u0004\u001a\u00020\u00042\t\b\u0001\u0010Û\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ü\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ý\u0004\u001a\u00020\u00042\t\b\u0001\u0010Þ\u0004\u001a\u00020\u00042\t\b\u0001\u0010û\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bâ\u0004\u0010ã\u0004JK\u0010å\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00020\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u00192\t\b\u0001\u0010ä\u0004\u001a\u00020\u00042\t\b\u0001\u0010û\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bå\u0004\u0010æ\u0004J)\u0010è\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ç\u00040\u000b0\n2\t\b\u0001\u0010Ù\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bè\u0004\u0010.J\u001e\u0010ê\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030é\u00040\u000b0\nH'¢\u0006\u0005\bê\u0004\u0010\u0011J2\u0010ì\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010ë\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bì\u0004\u0010#J8\u0010î\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030í\u00040(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\bî\u0004\u0010#J\u001e\u0010ð\u0004\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ï\u00040\u000b0\nH'¢\u0006\u0005\bð\u0004\u0010\u0011JW\u0010ó\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010ñ\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u009c\u0002\u001a\u00020\u00042\t\b\u0001\u0010\u009e\u0002\u001a\u00020\u00022\t\b\u0001\u0010ß\u0003\u001a\u00020\u00022\u000b\b\u0003\u0010ò\u0004\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\bó\u0004\u0010ô\u0004J(\u0010õ\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u008f\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bõ\u0004\u0010.J.\u0010÷\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ö\u00040 0\u000b0\n2\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\b÷\u0004\u00102J/\u0010ù\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ø\u00040 0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bù\u0004\u00102J/\u0010û\u0004\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ë\u00040 0\u000b0\n2\t\b\u0001\u0010ú\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bû\u0004\u0010.J\u0093\u0001\u0010\u0080\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ë\u00040\u000b0\n2\u000b\b\u0003\u0010ñ\u0004\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00022\t\b\u0001\u0010ü\u0004\u001a\u00020\u00192\b\b\u0003\u0010_\u001a\u00020\u00042\b\b\u0003\u0010]\u001a\u00020\u00042\b\b\u0001\u0010^\u001a\u00020\u00022\u000b\b\u0003\u0010ý\u0004\u001a\u0004\u0018\u00010\u00192\t\b\u0003\u0010þ\u0004\u001a\u00020\u00042\n\b\u0003\u0010`\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010ÿ\u0004\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\b\u0080\u0005\u0010\u0081\u0005J)\u0010\u0084\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0083\u00050\u000b0\n2\t\b\u0001\u0010\u0082\u0005\u001a\u00020\u0002H'¢\u0006\u0005\b\u0084\u0005\u00102JY\u0010\u0086\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0085\u00050(0\u000b0\n2\t\b\u0001\u0010\u0082\u0005\u001a\u00020\u00022\t\b\u0001\u0010æ\u0002\u001a\u00020\u00192\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0006\b\u0086\u0005\u0010\u0087\u0005J*\u0010\u008a\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0089\u00050\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0019H'¢\u0006\u0006\b\u008a\u0005\u0010¬\u0002JD\u0010\u008c\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00050(0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00192\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0006\b\u008c\u0005\u0010ò\u0002JO\u0010\u008f\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008e\u00050(0\u000b0\n2\t\b\u0001\u0010\u008d\u0005\u001a\u00020\u00022\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00192\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0006\b\u008f\u0005\u0010\u0090\u0005J)\u0010\u0091\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0019H'¢\u0006\u0006\b\u0091\u0005\u0010¬\u0002J3\u0010\u0091\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0092\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b\u0091\u0005\u0010\u00ad\u0001J8\u0010\u0094\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00050(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b\u0094\u0005\u0010#J8\u0010\u0095\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00050(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\b\u0095\u0005\u0010#J3\u0010\u0096\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0092\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b\u0096\u0005\u0010\u00ad\u0001J3\u0010\u0097\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0092\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b\u0097\u0005\u0010\u00ad\u0001Jj\u0010\u009c\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009b\u00050\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00192\u000b\b\u0001\u0010\u0098\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u0099\u0005\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u009a\u0005\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\b\u009c\u0005\u0010\u009d\u0005J4\u0010\u009e\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030²\u00020\u000b0\n2\t\b\u0001\u0010\u008d\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b\u009e\u0005\u0010\u00ad\u0001J\u001d\u0010\u009f\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\nH'¢\u0006\u0005\b\u009f\u0005\u0010\u0011J=\u0010P\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¢\u00050\u000b0\n2\t\b\u0001\u0010 \u0005\u001a\u00020\u00042\t\b\u0001\u0010¡\u0005\u001a\u00020\u00042\t\b\u0001\u0010á\u0004\u001a\u00020\u0004H'¢\u0006\u0004\bP\u0010sJ3\u0010£\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010 \u0005\u001a\u00020\u00042\t\b\u0001\u0010á\u0004\u001a\u00020\u0004H'¢\u0006\u0005\b£\u0005\u0010#J\u001d\u0010¤\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0(0\nH'¢\u0006\u0005\b¤\u0005\u0010\u0011J'\u0010¥\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\b\b\u0001\u0010=\u001a\u00020\u0002H'¢\u0006\u0005\b¥\u0005\u00102JC\u0010§\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00050(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\t\b\u0001\u0010\u00ad\u0003\u001a\u00020\u0004H'¢\u0006\u0005\b§\u0005\u0010sJ\u001e\u0010©\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00050\u000b0\nH'¢\u0006\u0005\b©\u0005\u0010\u0011J<\u0010«\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ª\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030ª\u0005`\u0099\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b«\u0005\u00102J)\u0010\u00ad\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¬\u00050\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u0004H'¢\u0006\u0005\b\u00ad\u0005\u0010.JC\u0010¯\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u00050(0\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b¯\u0005\u0010VJ)\u0010°\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u00050\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b°\u0005\u00102J$\u0010²\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030±\u00050(0\u000b0\nH'¢\u0006\u0005\b²\u0005\u0010\u0011J=\u0010´\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010ë\u0004\u001a\u00020\u00042\t\b\u0001\u0010³\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b´\u0005\u0010sJ(\u0010¶\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030µ\u00050\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b¶\u0005\u00102J2\u0010·\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b·\u0005\u0010\u00ad\u0001J2\u0010¸\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b¸\u0005\u0010\u00ad\u0001J(\u0010º\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¹\u00050\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\bº\u0005\u00102J(\u0010»\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030µ\u00050\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b»\u0005\u00102J8\u0010½\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00050(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b½\u0005\u0010#J@\u0010À\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010¼\u0002\u001a\u00020\u00022\t\b\u0001\u0010¾\u0005\u001a\u00020\u00192\n\b\u0001\u0010¿\u0005\u001a\u00030ã\u0001H'¢\u0006\u0006\bÀ\u0005\u0010Á\u0005J(\u0010Â\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bÂ\u0005\u0010.JK\u0010Ã\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00042\t\b\u0001\u0010¼\u0002\u001a\u00020\u00022\t\b\u0001\u0010¾\u0005\u001a\u00020\u00192\n\b\u0001\u0010¿\u0005\u001a\u00030ã\u0001H'¢\u0006\u0006\bÃ\u0005\u0010Ä\u0005J?\u0010Ç\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030Æ\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030Æ\u0005`\u0099\u00030\u000b0\n2\u000b\b\u0003\u0010Å\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\bÇ\u0005\u0010È\u0005J\u001e\u0010Ê\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030É\u00050\u000b0\nH'¢\u0006\u0005\bÊ\u0005\u0010\u0011J\\\u0010Î\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Í\u00050(0\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\u000b\b\u0003\u0010Å\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\bÎ\u0005\u0010Ï\u0005J,\u0010Ñ\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ð\u00050\u000b0\n2\u000b\b\u0003\u0010Å\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\bÑ\u0005\u0010È\u0005JB\u0010Ò\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ð\u00050\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u00022\u000b\b\u0003\u0010Å\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0006\bÒ\u0005\u0010Ó\u0005J4\u0010Õ\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ô\u00050\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u0002H'¢\u0006\u0005\bÕ\u0005\u0010vJO\u0010×\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ö\u00050(0\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0006\b×\u0005\u0010\u009b\u0001J3\u0010Ø\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\t\b\u0001\u0010\u0091\u0003\u001a\u00020\u0004H'¢\u0006\u0006\bØ\u0005\u0010\u00ad\u0001J8\u0010Ù\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00050(0\u000b0\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0004H'¢\u0006\u0005\bÙ\u0005\u0010#J1\u0010Û\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030Ú\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030Ú\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bÛ\u0005\u0010\u0011J\u001e\u0010Ý\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ü\u00050\u000b0\nH'¢\u0006\u0005\bÝ\u0005\u0010\u0011J)\u0010à\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ß\u00050\u000b0\n2\t\b\u0001\u0010Þ\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bà\u0005\u0010.J1\u0010â\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030á\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030á\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bâ\u0005\u0010\u0011J4\u0010ä\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ã\u00050\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u00042\t\b\u0001\u0010Ú\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bä\u0005\u0010#J\u001d\u0010å\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\bå\u0005\u0010\u0011J8\u0010ç\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030æ\u00050(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bç\u0005\u0010#J1\u0010é\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030è\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030è\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bé\u0005\u0010\u0011J(\u0010ê\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bê\u0005\u0010.J1\u0010ë\u0005\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ª\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030ª\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bë\u0005\u0010\u0011J\u001e\u0010í\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ì\u00050\u000b0\nH'¢\u0006\u0005\bí\u0005\u0010\u0011J)\u0010í\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030î\u00050\u000b0\n2\t\b\u0001\u0010\u008f\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bí\u0005\u0010.J9\u0010ï\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002090\u0098\u0003j\t\u0012\u0004\u0012\u000209`\u0099\u00030\u000b0\n2\b\b\u0003\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bï\u0005\u0010.JM\u0010ò\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010ð\u0005\u001a\u00020\u00042\u000b\b\u0003\u0010¶\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010ñ\u0005\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\bò\u0005\u0010Â\u0004JO\u0010ö\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030õ\u00050\u000b0\n2\t\b\u0001\u0010ó\u0005\u001a\u00020\u00042\t\b\u0001\u0010ô\u0005\u001a\u00020\u00042\u000b\b\u0003\u0010¶\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0003\u0010ñ\u0005\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0006\bö\u0005\u0010Â\u0004J\u001e\u0010ø\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030÷\u00050\u000b0\nH'¢\u0006\u0005\bø\u0005\u0010\u0011J4\u0010ú\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ù\u00050\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u0002H'¢\u0006\u0005\bú\u0005\u0010vJO\u0010ü\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030û\u00050(0\u000b0\n2\t\b\u0001\u0010Ë\u0005\u001a\u00020\u00022\t\b\u0001\u0010Ì\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0006\bü\u0005\u0010\u009b\u0001J)\u0010ý\u0005\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030«\u00030\u000b0\n2\t\b\u0003\u0010\u008f\u0004\u001a\u00020\u0004H'¢\u0006\u0005\bý\u0005\u0010.JM\u0010ÿ\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00050(0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÿ\u0005\u0010[J$\u0010\u0081\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0080\u00060 0\u000b0\nH'¢\u0006\u0005\b\u0081\u0006\u0010\u0011J3\u0010\u0084\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b0\n2\t\b\u0001\u0010\u0082\u0006\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0006\u001a\u00020\u0004H'¢\u0006\u0005\b\u0084\u0006\u0010#J8\u0010\u0086\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0085\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b\u0086\u0006\u0010#J3\u0010\u0088\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010\u0087\u0006\u001a\u00020\u0002H'¢\u0006\u0005\b\u0088\u0006\u0010vJ)\u0010\u0089\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0085\u00060\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0089\u0006\u00102J(\u0010\u008a\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008a\u0006\u00102J(\u0010\u008b\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008b\u0006\u00102J)\u0010\u008c\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00010\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008c\u0006\u00102J1\u0010\u008e\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u008d\u00060\u0098\u0003j\n\u0012\u0005\u0012\u00030\u008d\u0006`\u0099\u00030\u000b0\nH'¢\u0006\u0005\b\u008e\u0006\u0010\u0011J\u001e\u0010\u0090\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008f\u00060\u000b0\nH'¢\u0006\u0005\b\u0090\u0006\u0010\u0011JC\u0010\u0092\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0091\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u0092\u0006\u0010@J\u001e\u0010\u0094\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0093\u00060\u000b0\nH'¢\u0006\u0005\b\u0094\u0006\u0010\u0011J(\u0010\u0095\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0003\u0010\u008f\u0004\u001a\u00020\u0004H'¢\u0006\u0005\b\u0095\u0006\u0010.J$\u0010\u0097\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0096\u00060 0\u000b0\nH'¢\u0006\u0005\b\u0097\u0006\u0010\u0011J)\u0010\u0099\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0098\u00060\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u0099\u0006\u0010.JB\u0010\u009b\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009a\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u009b\u0006\u0010sJ2\u0010\u009c\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00042\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b\u009c\u0006\u0010QJ/\u0010\u009d\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u00020\u0098\u0003j\t\u0012\u0004\u0012\u00020\u0002`\u0099\u00030\u000b0\nH'¢\u0006\u0005\b\u009d\u0006\u0010\u0011J'\u0010\u009e\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u009e\u0006\u0010.J<\u0010\u009f\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010³\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u009f\u0006\u0010VJ<\u0010 \u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010³\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b \u0006\u0010VJ4\u0010¡\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¹\u00050\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u00022\t\b\u0001\u0010³\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b¡\u0006\u0010\u00ad\u0001J2\u0010£\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¢\u00060\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b£\u0006\u0010#J@\u0010¦\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030µ\u00050\u000b0\n2\t\b\u0001\u0010¤\u0006\u001a\u00020\u00022\t\b\u0001\u0010¥\u0006\u001a\u00020\u00022\t\b\u0001\u0010³\u0005\u001a\u00020\u0004H'¢\u0006\u0006\b¦\u0006\u0010§\u0006J(\u0010©\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00060\u000b0\n2\b\b\u0001\u00104\u001a\u00020\u0002H'¢\u0006\u0005\b©\u0006\u00102JC\u0010ª\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u00050(0\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bª\u0006\u0010VJ)\u0010«\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u00050\u000b0\n2\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\b«\u0006\u00102J\u001e\u0010\u00ad\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¬\u00060\u000b0\nH'¢\u0006\u0005\b\u00ad\u0006\u0010\u0011J<\u0010°\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030¯\u00060\u0098\u0003j\n\u0012\u0005\u0012\u00030¯\u0006`\u0099\u00030\u000b0\n2\t\b\u0001\u0010®\u0006\u001a\u00020\u0002H'¢\u0006\u0005\b°\u0006\u00102J2\u0010²\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010±\u0006\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H'¢\u0006\u0005\b²\u0006\u0010vJ\u001d\u0010³\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b³\u0006\u0010\u0011J(\u0010µ\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010´\u0006\u001a\u00020\u0002H'¢\u0006\u0005\bµ\u0006\u00102J(\u0010¶\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010ñ\u0004\u001a\u00020\u0002H'¢\u0006\u0005\b¶\u0006\u00102J)\u0010¸\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030·\u00060\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b¸\u0006\u00102J(\u0010¹\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b¹\u0006\u00102J(\u0010º\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bº\u0006\u00102J4\u0010½\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00060\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010»\u0006\u001a\u00020\u0002H'¢\u0006\u0005\b½\u0006\u0010vJ3\u0010¾\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010Ä\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b¾\u0006\u0010vJC\u0010¿\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00060(0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\b¿\u0006\u0010VJ1\u0010À\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030¼\u00060\u0098\u0003j\n\u0012\u0005\u0012\u00030¼\u0006`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bÀ\u0006\u0010\u0011J\u001d\u0010Á\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\nH'¢\u0006\u0005\bÁ\u0006\u0010\u0011J8\u0010Ã\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Â\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÃ\u0006\u0010#J\u001e\u0010Å\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ä\u00060\u000b0\nH'¢\u0006\u0005\bÅ\u0006\u0010\u0011J1\u0010Æ\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ª\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030ª\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bÆ\u0006\u0010\u0011J8\u0010È\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ç\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÈ\u0006\u0010#J)\u0010Ê\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030É\u00060\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u0002H'¢\u0006\u0005\bÊ\u0006\u00102J1\u0010Ë\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ª\u00050\u0098\u0003j\n\u0012\u0005\u0012\u00030ª\u0005`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bË\u0006\u0010\u0011J8\u0010Í\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ì\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÍ\u0006\u0010#JB\u0010Ï\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Î\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\bÏ\u0006\u0010sJ?\u0010Ñ\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ð\u00060\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00192\t\b\u0001\u0010Ý\u0004\u001a\u00020\u00192\t\b\u0001\u0010ð\u0005\u001a\u00020\u0019H'¢\u0006\u0006\bÑ\u0006\u0010Ò\u0006J5\u0010Ô\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ó\u00060\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u00192\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bÔ\u0006\u0010ÿ\u0002J*\u0010Õ\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ó\u00060\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0019H'¢\u0006\u0006\bÕ\u0006\u0010¬\u0002JF\u0010×\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ö\u00060(0\u000b0\n2\u000b\b\u0001\u0010\u0088\u0005\u001a\u0004\u0018\u00010\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0006\b×\u0006\u0010Ø\u0006J\u001e\u0010Ú\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ù\u00060\u000b0\nH'¢\u0006\u0005\bÚ\u0006\u0010\u0011J(\u0010Ú\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010Û\u0006\u001a\u00020\u0002H'¢\u0006\u0005\bÚ\u0006\u00102J8\u0010Ý\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ü\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bÝ\u0006\u0010#J)\u0010à\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ß\u00060\u000b0\n2\t\b\u0001\u0010Þ\u0006\u001a\u00020\u0002H'¢\u0006\u0005\bà\u0006\u00102JJ\u0010ä\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010á\u0006\u001a\u00020\u00022\t\b\u0001\u0010â\u0006\u001a\u00020\u00022\t\b\u0001\u0010ã\u0006\u001a\u00020\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0006\bä\u0006\u0010å\u0006J)\u0010ç\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030æ\u00060\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bç\u0006\u00102J\u001e\u0010é\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030è\u00060\u000b0\nH'¢\u0006\u0005\bé\u0006\u0010\u0011J4\u0010ì\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ë\u00060\u000b0\n2\t\b\u0001\u0010ê\u0006\u001a\u00020\u00042\t\b\u0001\u0010õ\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bì\u0006\u0010#J8\u0010î\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030í\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bî\u0006\u0010#J)\u0010é\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030è\u00060\u000b0\n2\t\b\u0001\u0010ú\u0003\u001a\u00020\u0004H'¢\u0006\u0005\bé\u0006\u0010.J1\u0010ð\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ï\u00060\u0098\u0003j\n\u0012\u0005\u0012\u00030ï\u0006`\u0099\u00030\u000b0\nH'¢\u0006\u0005\bð\u0006\u0010\u0011J\u001d\u0010ñ\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\bñ\u0006\u0010\u0011J(\u0010ò\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0088\u0005\u001a\u00020\u0002H'¢\u0006\u0005\bò\u0006\u00102J(\u0010ô\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010ó\u0006\u001a\u00020\u0002H'¢\u0006\u0005\bô\u0006\u00102J>\u0010ö\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\t\b\u0001\u0010õ\u0006\u001a\u00020\u00022\t\b\u0001\u0010ö\u0006\u001a\u00020\u0004H'¢\u0006\u0006\bö\u0006\u0010÷\u0006J3\u0010ù\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010ø\u0006\u001a\u00020\u00022\t\b\u0001\u0010Ä\u0001\u001a\u00020\u0002H'¢\u0006\u0005\bù\u0006\u0010vJ8\u0010û\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ú\u00060(0\u000b0\n2\b\b\u0001\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'¢\u0006\u0005\bû\u0006\u0010#JG\u0010ý\u0006\u001a\"\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030ü\u00060\u0098\u0003j\n\u0012\u0005\u0012\u00030ü\u0006`\u0099\u00030\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u00022\t\b\u0001\u0010¶\u0002\u001a\u00020\u0002H'¢\u0006\u0005\bý\u0006\u0010vJ\u001e\u0010ÿ\u0006\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00060\u000b0\nH'¢\u0006\u0005\bÿ\u0006\u0010\u0011J'\u0010\u0080\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'¢\u0006\u0005\b\u0080\u0007\u00102J(\u0010\u0081\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n2\t\b\u0001\u0010ó\u0006\u001a\u00020\u0002H'¢\u0006\u0005\b\u0081\u0007\u00102J\u001d\u0010\u0082\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b\u0082\u0007\u0010\u0011J\u001d\u0010\u0083\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b\u0083\u0007\u0010\u0011J\u001e\u0010\u0085\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0084\u00070\u000b0\nH'¢\u0006\u0005\b\u0085\u0007\u0010\u0011J\u001e\u0010\u0086\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0084\u00070\u000b0\nH'¢\u0006\u0005\b\u0086\u0007\u0010\u0011J\u001e\u0010\u0087\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0084\u00070\u000b0\nH'¢\u0006\u0005\b\u0087\u0007\u0010\u0011J\u001e\u0010\u0088\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0084\u00070\u000b0\nH'¢\u0006\u0005\b\u0088\u0007\u0010\u0011J%\u0010\u008b\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008a\u00070\u0089\u00070\u000b0\nH'¢\u0006\u0005\b\u008b\u0007\u0010\u0011J(\u0010\u008c\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H'¢\u0006\u0005\b\u008c\u0007\u00102J#\u0010\u008d\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0\u000b0\nH'¢\u0006\u0005\b\u008d\u0007\u0010\u0011J$\u0010\u008f\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008e\u00070 0\u000b0\nH'¢\u0006\u0005\b\u008f\u0007\u0010\u0011J:\u0010\u0092\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0091\u00070\u0090\u00070\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u0092\u0007\u0010#J:\u0010\u0094\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0093\u00070\u0090\u00070\u000b0\n2\t\b\u0001\u0010á\u0004\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0005\b\u0094\u0007\u0010#J3\u0010\u0095\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u0091\u0003\u001a\u00020\u00192\t\b\u0001\u0010ý\u0004\u001a\u00020\u0019H'¢\u0006\u0005\b\u0095\u0007\u0010{J\u001d\u0010\u0096\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b\u0096\u0007\u0010\u0011J\u001d\u0010\u0097\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'¢\u0006\u0005\b\u0097\u0007\u0010\u0011J\u001e\u0010\u0099\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0098\u00070\u000b0\nH'¢\u0006\u0005\b\u0099\u0007\u0010\u0011J(\u0010\u009b\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\n2\t\b\u0001\u0010\u009a\u0007\u001a\u00020\u0002H'¢\u0006\u0005\b\u009b\u0007\u00102J$\u0010\u009d\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009c\u00070 0\u000b0\nH'¢\u0006\u0005\b\u009d\u0007\u0010\u0011J\u001e\u0010\u009f\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009e\u00070\u000b0\nH'¢\u0006\u0005\b\u009f\u0007\u0010\u0011J3\u0010¢\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010 \u0007\u001a\u00020\u00022\t\b\u0001\u0010¡\u0007\u001a\u00020\u0002H'¢\u0006\u0005\b¢\u0007\u0010vJ\u001e\u0010¤\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00070\u000b0\nH'¢\u0006\u0005\b¤\u0007\u0010\u0011J$\u0010¦\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¥\u00070 0\u000b0\nH'¢\u0006\u0005\b¦\u0007\u0010\u0011J,\u0010©\u0007\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00070\u000b0\n2\u000b\b\u0003\u0010§\u0007\u001a\u0004\u0018\u00010\u0019H'¢\u0006\u0006\b©\u0007\u0010ª\u0007J)\u0010«\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n2\t\b\u0001\u0010\u009a\u0007\u001a\u00020\u0019H'¢\u0006\u0006\b«\u0007\u0010¬\u0002¨\u0006¬\u0007"}, d2 = {"Lcom/qiahao/nextvideo/network/ServerApi;", "Lcom/qiahao/base_common/network/CommonApi;", "", TUIConstants.TUILive.USER_ID, "", "type", "token", "sex", "avatar", "nickname", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/nextvideo/data/model/UserResponse;", "login", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "", "hello", "()Lio/reactivex/rxjava3/core/i0;", "name", "country", "description", "isShowAge", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "updateUserInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "", "birthday", "Lcom/qiahao/base_common/model/common/User;", "commitUserInfo", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "pageIndex", "pageSize", "", "Lcom/qiahao/nextvideo/data/model/LikeMeGuyItem;", "fetchUserLikesMeList", "(II)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/ILikeGuyItem;", "fetchILikesList", "Lcom/qiahao/nextvideo/data/model/VisitGuyItem;", "fetchUserVisitList", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/model/PraiseGuyItem;", "fetchUserPraiseList", "filterArea", "Lcom/qiahao/nextvideo/data/model/CountriesResponse;", "countries", "(I)Lio/reactivex/rxjava3/core/i0;", "toUID", "Lcom/qiahao/base_common/model/common/LikeResult;", OnlineCellViewHolder.CLICK_LIKE, "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "unlike", SupportGiftRankActivity.EXTERNAL_ID, "unblockUser", "platform", "Lcom/qiahao/nextvideo/data/model/PurchaseGem;", "fetchDiamondList", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "fetchVipDetail", "Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;", "fetchPurchaseFeeDetails", Constants.KEY_HTTP_CODE, "Lcom/qiahao/nextvideo/data/model/BlockedInfo;", "fetchUserBlacklist", "(IILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", Constants.SP_KEY_VERSION, "lastIndex", Constants.KEY_MODEL, "firstIndex", "Lcom/qiahao/base_common/network/model/OnlineUserListResponse;", "fetchOnlineUsersNew", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "getMatchConfigData", "Lio/reactivex/rxjava3/core/z;", "Lcom/qiahao/nextvideo/data/model/RandomPairChatroomConfig;", "exitMatchPool", "()Lio/reactivex/rxjava3/core/z;", "conditionSex", "conditionCountry", "joinMatch", "(ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "uid", "testPurchasePrivilege", "Lcom/qiahao/nextvideo/data/model/ReceivedGift;", "fetchReceviedGifts", "(Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "orginType", "orginId", "Lcom/qiahao/nextvideo/data/model/SurplusDiamonds;", "userCostMessage", "(Ljava/lang/String;III)Lio/reactivex/rxjava3/core/i0;", "giftID", "sceneType", "sceneUid", "giftN", "giftText", "Lcom/qiahao/base_common/model/common/ChannelEventGiftAddTime;", "sendGift", "(Ljava/lang/String;JILjava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", Constants.KEY_PACKAGE_NAME, "productID", "orderID", "purchaseToken", "buyType", "Lcom/qiahao/nextvideo/data/model/UserDiamonds;", "buyDiamonds", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "subscriptionID", "purchaseOrderId", "subscribeVip", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "getType", "Lcom/qiahao/base_common/network/model/UserCostDiamondsDetail;", "userDiamondsDetail", "(III)Lio/reactivex/rxjava3/core/i0;", "images", "feedback", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "beginTimestamp", "endTimestamp", "Lcom/qiahao/nextvideo/data/model/ConnectLogItem;", "fetchConnectLogs", "(JJ)Lio/reactivex/rxjava3/core/i0;", "date", "Lcom/qiahao/nextvideo/data/model/AgentMgrConnectionLogBean;", "fetchAgentMgrConnectLogs", "Lcom/qiahao/nextvideo/data/model/PurchaseItem;", "fetchUserPaymentsDetail", "fetchDiamond", "fetchUserDetailInfo", "groupId", "fetchUserDetail", "userExternalId", "roomUserInfo", "fetchUserSummary", "matchUniqueId", "dispatchEventInRoomName", "url", "accessToken", "openid", "Lcom/qiahao/nextvideo/data/model/WechatUserInfo;", "fetchWechatUserInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "findUserByCode", "appid", "secret", "grantType", "Lcom/qiahao/nextvideo/data/model/WechatAuthorizedInfo;", "fetchWechatAuthorizedToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "otherUserExternalId", "accept", "from", "rejectInvite", "(Ljava/lang/String;Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/PrivateRecordBean;", "privateRecordList", "Lretrofit2/Call;", "Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "fetchMsgLastForHiloOfficial", "()Lretrofit2/Call;", "Lcom/qiahao/nextvideo/data/model/HiloAssistantItem;", "fetchHiloAssistants", "Lcom/qiahao/nextvideo/data/model/HiloInformationItem;", "fetchHiloInformations", "isNotification", "tradeUnionNotification", "picUrl", "matchPic", "endType", "Lcom/qiahao/nextvideo/data/model/VideoResultData;", "matchTalkingEnd", "(Ljava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "isPush", "userMsgPush", "userRecallWindow", "Lcom/qiahao/nextvideo/data/model/ConfigurationParam;", "fetchConfigurationParam", "specifyUserExternalId", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallParams;", "videoMinuteSend", "videoUid", "videoEnd", "Lcom/qiahao/nextvideo/data/model/VideoFreeCheck;", "videoFreeCheck", "videoRefuse", "videoCallReady", "videoReceive", "userVisit", "readType", "readHas", "Lcom/qiahao/nextvideo/data/model/UserLikeEachItem;", "userLikeEachList", "language", "userAppLanguage", "videoId", "requestId", "loggingAgora", "Lcom/qiahao/nextvideo/data/model/UserPictureResponseBean;", "getPhotos", "photos", "md5", "setPhotos", "close", "otherExternalId", "deleteSession", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "getNewRecommendGroup", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", GroupSettingViewModel.INTERFACE_GETGROUP, "getRoomInfo", "Lcom/qiahao/nextvideo/data/model/CreateGroupBean;", "createGroup", "isInvite", "joinGroup", "leaveGroup", "Lcom/qiahao/nextvideo/data/model/GroupMemberListBean;", "getGroupMember", "getGroupVisitor", "(Ljava/lang/String;IILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "getRoomAdminMember", "introduction", "notification", TUIConstants.TUIChat.FACE_URL, "password", "", "loadHistory", "welcomeText", "themeId", "diceNum", GroupSettingViewModel.TOURIST_MIC, GroupSettingViewModel.TOURIST_MSG, GroupSettingViewModel.TOURIST_PIC, GroupSettingViewModel.TOURIST_FEE, "memberFee", "diceType", "updateGroupInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/SearchGroupListBean;", "searchGroup", "Lcom/qiahao/nextvideo/data/model/HotGroupListBean;", "getPopularGroup", "lastId", "getLatestGroup", "Lcom/qiahao/base_common/model/common/Country;", "getTop7Country", "countryShortName", "getCountryGroup", "enterType", "gameCode", "is1V1", "gameMode", "Lcom/qiahao/nextvideo/data/model/InRoomBean;", "inRoom", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/model/RoomRuleBean;", "getRoomRole", "role", "setRoomUserRole", "(Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "getGroupMemberByRole", "(Ljava/lang/String;Ljava/lang/Integer;II)Lio/reactivex/rxjava3/core/i0;", "micIndex", "upMic", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "beInvitedUserId", "inviteOtherUpMic", "downMic", "lockMic", "unlockMic", "muteMic", "muteByIndex", "unMuteByIndex", "unMuteMic", "Lcom/qiahao/nextvideo/data/model/BlockListBean;", "getGroupBlockList", "removeHistory", "blackImei", "groupBlockListAddUser", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/i0;", "removeGroupBlockById", "groupKick", "reasonType", "image", "reason", "isBlock", "isPK", "reportGroup", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "groupBanner", "sendGiftToMicAllMember", "(Ljava/lang/String;JILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "sendGiftToRoomAllMember", "Lcom/qiahao/nextvideo/data/model/BeanBaseBean;", "getBeanBase", ExchangeDiamondsActivity.BEAN_NUM, "changeBeanToDiamond", "(J)Lio/reactivex/rxjava3/core/i0;", "gemNum", "Lcom/qiahao/nextvideo/data/model/GemBean;", "changeGemToDiamond", "Lcom/qiahao/nextvideo/data/model/BeanChangeDetail;", "getBeanDetail", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "getLikeEachOtherList", "Lcom/qiahao/nextvideo/data/model/HasMyGroupListBean;", "getPublicGroup", "queryType", "Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmBean;", "getRankCelebrity", "getRankCharm", "Lcom/qiahao/nextvideo/data/model/RankGroupBean;", "getRankGroup", "content", "roomPostBroadcast", "Lcom/qiahao/nextvideo/data/model/AllRankTop3Bean;", "getAllRankTop3Aavatar", "Lcom/qiahao/nextvideo/data/model/WeekPowerTop3Bean;", "getFamilyTop3Avatar", "Lcom/qiahao/nextvideo/data/model/GroupRankBean;", "getGroupFamous", "getGroupCharm", "micNumType", "micOn", "changeMicNum", "(IZLjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "clientReport", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "getMicEmoji", "micEmojiId", "sendMicEmoji", "(Ljava/lang/String;J)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/VipDailyDiamondBean;", "vipDailyDiamond", "Lcom/qiahao/nextvideo/data/model/GroupThemesBean;", "getGroupThemes", "Lcom/qiahao/nextvideo/data/model/AutoInviteUserUpMicBean;", "enterRoomCheckAutoInviteUpMicDialog", "Lcom/qiahao/nextvideo/data/model/FlagBean;", "judgeShowNotificationDialog", "Lcom/qiahao/base_common/model/MedalBean;", "getMedalList", "selectAll", "extIds", "shareRoomToContacts", "(Ljava/lang/String;ZLjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "shareRoomToLikeMe", "toGameDice", "canOpenGroupSupport", "Lcom/qiahao/nextvideo/data/model/GroupSupportDetailResponseBean;", "getGroupSupportDetail", "checkAdminSupportGetAward", "supporters", "Lcom/qiahao/nextvideo/data/model/SupportAwardResponseBean;", "getSupportAward", "groupPowerId", "Lcom/qiahao/nextvideo/data/model/PowerTeamMemberBean;", "getPowerTeamMember", "powerId", "Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "getGroupPowerTitleDetail", "joinGroupPower", "leaveGroupPower", "Lcom/qiahao/nextvideo/data/model/GroupPowerWeekBean;", "getGroupPowerRankWeek", "Lcom/qiahao/nextvideo/data/model/PowerGroupMemberBean;", "getGroupPowerMemberGroup", "(JII)Lio/reactivex/rxjava3/core/i0;", "leaveRoom", "getRoomBanner", "Lcom/qiahao/base_common/model/StoreBean;", "getPropertyList", "Lcom/qiahao/base_common/model/MyBagBean;", "getMyProperty", "resPropertyId", "setPropertyUsing", "resPropertyDiamondId", "receiveExternal", "Lcom/qiahao/base_common/model/DiamondBean;", "propertySendOrBuy", "(JLjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "propertySend", "getHeadWearList", "getMyHeadWear", "resHeadwearId", "setHeadWearUsing", "resHeadwearDiamondId", "headWearSendOrBuy", "headWearSend", "clearSysUnRead", "clearAssistantUnRead", "Lcom/qiahao/nextvideo/data/model/LuckyWheelConfig;", "getRoomLuckyWheelConfig", "joinRoomLuckyWheel", "playRoomLuckyWheel", "closeRoomLuckWheel", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "getRoomLuckWheelInfo", "resId", "creatorJoin", "autoRestart", "createRoomLuckWheel", "(IZZLjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "getRoomOnlineUser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDiscoverBannerList", "Lcom/qiahao/nextvideo/data/model/CpTop3Bean;", "getCpTop3", "Lcom/qiahao/nextvideo/data/model/CpBean;", "getCpRankList", "Lcom/qiahao/nextvideo/data/model/MyCpBean;", "getMyCpRankList", "cpDisconnect", "receiveExternalId", "Lcom/qiahao/nextvideo/data/model/MySupportAllBean;", "getRecentUserSendGift", "Lcom/qiahao/nextvideo/data/model/DeleteAccountSuccessBean;", "userDeleteAccount", "Lcom/qiahao/nextvideo/data/model/DeleteAccountConditionBean;", "userDeleteAccountCondition", "Lcom/qiahao/nextvideo/data/model/IsDealerBean;", "getIsDealer", "Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "getDealerDetail", "isPink", "sendDiamondToUser", "send", "Lcom/qiahao/nextvideo/data/transfer/TransferCheckData;", "checkShare", "Lcom/qiahao/nextvideo/data/model/UploadCustomThemeBean;", "uploadThemeCustom", "Lcom/qiahao/nextvideo/data/model/CustomThemeBean;", "getAllCustomTheme", "groupCustomThemeId", "usingCustomTheme", "Lcom/qiahao/nextvideo/data/model/GroupThemeCustomConfig;", "getCustomThemeConfig", "Lcom/qiahao/nextvideo/data/model/MedalAllTypeBean;", "getAllPublicMedalType", "getRoomMedalType", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBeanBody;", "getUserHasMedalList", "resMedalId", "getMedalForUser", "Lcom/qiahao/nextvideo/data/model/GroupMedalBean;", "getGroupMedalAll", "Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "getRoomRocketSmallData", "Lcom/qiahao/nextvideo/data/model/RocketDetailBean;", "getRocketRoomDetailData", "Lcom/qiahao/nextvideo/data/model/RocketResultListBean;", "getRocketRoomResultData", "Lcom/qiahao/nextvideo/data/model/ScrollBean;", "getLuckBoxScroll", "Lcom/qiahao/nextvideo/data/model/LuckyBoxRecordBean;", "getLuckBoxRecord", "Lcom/qiahao/nextvideo/data/model/LuckyBoxRankingBean;", "getLuckBoxRanking", "Lcom/qiahao/nextvideo/data/model/LuckyTeenRewardBean;", "openOneTimesLuckyBox", "Lcom/qiahao/nextvideo/data/model/LuckBoxConfigBean;", "getLuckConfig", "openTeenTimesLuckyBox", "Lcom/qiahao/nextvideo/data/model/RewardLuckyBoxBean;", "luckyBoxAward", "Lcom/qiahao/nextvideo/data/model/DealerListBean;", "getDealerList", "Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeAllBean;", "getCountryTop3Contribute", "Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "getGlobalBroadCast", "msg", "sendGlobalBroadCast", "globalBroadcastId", "imageUrl", "prohibitBroadCastMessage", "(JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/GiftWallBean;", "getGiftWall", "Lcom/qiahao/nextvideo/data/model/PowerTop3Bean;", "getTop3PowerWeek", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "getOpenScreenSource", "getOperationWindow", "checkGroupHasPassWord", "Lcom/qiahao/nextvideo/data/model/JoinGroupBean;", "getMyJoinedGroup", "getMyRecentGroup", "getMyPermanentGroup", "getOwnGroup", RoomAndPersonalTaskFragment.TASK_TYPE, "Lcom/qiahao/nextvideo/data/model/EarnDiamondBean;", "getEarnDiamondTaskList", "taskConfigId", "awardEarnDiamondTask", "fruitId", "amount", "Lcom/qiahao/nextvideo/data/model/LuckyFruitBetBean;", "setFruitMachineBet", "Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;", "getFruitMachineDetail", "round", "getRoundFruitMachineDetail", "Lcom/qiahao/nextvideo/data/model/LuckyFruitResultList;", "getFruitMachineHistory", "Lcom/qiahao/nextvideo/data/model/LuckyFruitResultMyRecord;", "getFruitMachineMyRecord", "Lcom/qiahao/nextvideo/data/model/LuckyFruitRankAllBean;", "getFruitMachineRanking", "agoraIds", "getUserIdForAgoraId", "items", "needCheckSvip", "Lcom/qiahao/nextvideo/data/model/IsBroadCastMangerBean;", "checkIsBroadcastManager", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/i0;", "delType", "deleteBroadcastMessage", "Lcom/qiahao/nextvideo/data/model/MyNobleBeanItem;", "getMyNobleDetail", "Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "getNobleConfig", "level", "buyNoble", "targetExtId", "sendNoble", "thirdPartyId", "thirdPartyType", "thirdPartyToken", "Lcom/qiahao/nextvideo/data/model/DeleteAccountTimeBean;", "getDeleteAccountTime", "cancelDeleteAccount", "resetUserInfo", "resetRoomInfo", "Lcom/qiahao/nextvideo/data/model/AwardDetailBean;", "checkFirstRecharge", "refreshTIMToken", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "videoGoddessList", "videoMatchingHistory", "Lcom/qiahao/nextvideo/data/model/MissData;", "videoMissNum", "productId", "Lcom/qiahao/nextvideo/data/model/CheckChargeData;", "checkIsChargeUser", "Lcom/qiahao/base_common/model/ApiListData;", "Lcom/qiahao/base_common/model/ActivityDetailData;", "activityList", "(IIILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", ActivitiesDetailActivity.ACTIVITY_ID, "subType", "activitySubscribe", "subscribeList", "activityDetail", "banner", "theme", "desc", "acType", "startAt", "duration", "crateActivity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "reportActivity", "phone", "pwd", "loginPhone", "oldCode", "Lcom/qiahao/base_common/model/common/PhoneInfo;", "checkPhone", "binderPhoneAndPwd", "oldPwd", "changePwd", "binderOrUnBinderThird", "(IILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "authen", "way", "checkSMS", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "areaCode", "checkSendSMS", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "column", "Lcom/qiahao/base_common/model/GiftData;", "giftListOfType", "giftId", "Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "giftShortcut", "acId", "deleteActivity", "headWearId", "deleteHeadWear", "propertyId", "deleteProperty", "Lcom/qiahao/nextvideo/data/game/LudoCode;", "sudCode", "cleanMessage", "gameType", Constants.KEY_MODE, "piece", "onOff1", ExchangeDetailActivity.TYPE_DIAMOND, "autoMatch", "createSud", "(IIIIIILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", GameMatchActivity.GAME_ID, "editSud", "(JIIIIILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "opt", "reportSud", "(JILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/game/GameQuickMatch;", "getQuickID", "Lcom/qiahao/base_common/model/svip/SvipInfo;", "getSvipInfo", "openClose", "privilegeOpen", "Lcom/qiahao/base_common/model/svip/Details;", "getSvipDetail", "Lcom/qiahao/base_common/model/svip/UserSvip;", "getSvipPoint", "toUserExternalId", "hours", "superAdminReport", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "deleteNoble", "Lcom/qiahao/nextvideo/data/model/NamePlateData;", "getNamePlateList", "Lcom/qiahao/nextvideo/data/room/GameCategory;", "getGameListOfType", "resType", "getBagGiftList", "resGiftId", "bagId", "sendType", "maskGroupId", "sendBagGift", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Long;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "period", "Lcom/qiahao/nextvideo/data/family/FamilyRankData;", "familyRank", "Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "familyStar", "(Ljava/lang/String;JIII)Lio/reactivex/rxjava3/core/i0;", AgooConstants.MESSAGE_ID, "Lcom/qiahao/nextvideo/data/family/FamilyCenterData;", "familyInfo", "Lcom/qiahao/nextvideo/data/family/FamilyRoomInfo;", "familyRoomList", "userCode", "Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "familyMemberList", "(Ljava/lang/String;JII)Lio/reactivex/rxjava3/core/i0;", "applyFamily", "userExtId", "Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "familyApplyList", "familyQuitList", "quitFamily", "setFamilyAdmin", TUIConstants.TUIChat.INPUT_MORE_ICON, "nameplate", "declaration", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "inviteSheep", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "searchFriends", "familyApplicationNumber", "matchId", "lastMatchId", "Lcom/qiahao/nextvideo/data/sheep/SheepMatchData;", "exitSheep", "transferUserList", "transferSearchUser", "Lcom/qiahao/nextvideo/data/transfer/TransferRecordData;", "transferDiamondDetail", "Lcom/qiahao/nextvideo/data/model/GemGameData;", "gemGameData", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "diamondGameData", "Lcom/qiahao/nextvideo/data/game/GemGameRank;", "gemGameRank", "Lcom/qiahao/nextvideo/data/cp/CpListData;", "cpRankList", "myCp", "Lcom/qiahao/nextvideo/data/cp/CpRecord;", "cpRecord", CpSpaceActivity.RELATION_TYPE, "cpOpenClose", "Lcom/qiahao/base_common/model/cp/CpSpace;", "cpSpace", "cpRelation", "cpReply", "Lcom/qiahao/nextvideo/data/cp/CpCheck;", "checkBindCp", "cpProfile", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "cpMemorial", "timestamp", "isRemind", CpMemorialViewModel.POST_MEMORIAL, "(Ljava/lang/String;JZ)Lio/reactivex/rxjava3/core/i0;", CpMemorialViewModel.DELETE_MEMORIAL, CpMemorialViewModel.UPDATE_MEMORIAL, "(ILjava/lang/String;JZ)Lio/reactivex/rxjava3/core/i0;", "isG", "Lcom/qiahao/nextvideo/data/transfer/TransferBanner;", "transferBanners", "(Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "transferPeriod", "beginDate", "endDate", "Lcom/qiahao/nextvideo/data/transfer/TransferRank;", "transferRank", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/transfer/TransferMonth;", "transferMonth", "transferRange", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/transfer/SecondMonth;", "secondRange", "Lcom/qiahao/nextvideo/data/transfer/SecondRank;", "secondRank", "secondShift", "secondDiamondDetail", "Lcom/qiahao/nextvideo/data/planets/HiloPlanetsData;", "recommendList", "Lcom/qiahao/nextvideo/data/baishun/HomeMatchGameData;", "matchGameList", "diamondNum", "Lcom/qiahao/nextvideo/data/model/ExchangeGem;", "exchangeGem", "Lcom/qiahao/nextvideo/data/game/GameLobby;", "gameLobbyList", "Lcom/qiahao/nextvideo/data/game/GameLobbyMatch;", "lobbyMatch", "exitLobbyMatch", "Lcom/qiahao/nextvideo/data/game/MatchRecent;", "matchRecentList", "Lcom/qiahao/nextvideo/data/game/GameBroadcast;", "matchBroadcast", "broadcastTop", "taskGameList", "Lcom/qiahao/nextvideo/data/task/GoldTaskData;", "taskSign", "Lcom/qiahao/nextvideo/data/RefreshMoney;", "gemExchangeList", "num", "matchUid", "videoInter", "frontOrBack", "cameraOnOff", "Lcom/qiahao/base_common/model/common/VideoSetting;", "videoSetting", "Lcom/qiahao/nextvideo/data/promote/PromoteMonth;", "promoteMonth", "Lcom/qiahao/nextvideo/data/promote/PromoteRankData;", "promoteRange", "Lcom/qiahao/nextvideo/data/promote/PromoteRank;", "promoteRank", "getPromoteDetail", "Lcom/qiahao/nextvideo/data/room/RoomRecordData;", "roomRecord", "Lcom/qiahao/nextvideo/data/medal/MedalSort;", "getMedalSort", "pos", "medalId", "setMedalSort", "Lcom/qiahao/nextvideo/data/room/RoomCurrentPK;", "roomCurrentPK", "targetGroupId", "acceptPK", "currentPKStatus", "createPK", "exitPK", "getNewPKToken", "Lcom/qiahao/nextvideo/data/room/BoxLevel;", "getPKBoxList", "Lcom/qiahao/nextvideo/data/room/BoxGet;", "getPKBox", "Lcom/qiahao/nextvideo/data/room/RoomPKUser;", "supportRank", "Lcom/qiahao/nextvideo/data/CheckNobleAward;", "checkNobleAward", "getNobleAward", "Lcom/qiahao/nextvideo/data/noble/NobleCard;", "nobleCard", "Lcom/qiahao/nextvideo/data/noble/NobleUse;", "useNobleCard", "Lcom/qiahao/nextvideo/data/noble/NobleCardLog;", "nobleCardLog", "sendNobleCard", "getSensitiveWord", "changeOtherRoomMic", "specialRelation", "relationReply", "checkBindRelation", "Lcom/qiahao/base_common/model/RelationStoreData;", "getRelationList", CpSpaceActivity.EXTERNAL_ID1, CpSpaceActivity.EXTERNAL_ID2, "relationSpace", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/model/common/RelationUserData;", "relationBack", "relationRankList", "myRelation", "Lcom/qiahao/nextvideo/data/strange/StrangeConfirm;", "strangeConfirmChange", "groupIds", "Lcom/qiahao/nextvideo/data/strange/StrangeUserData;", "strangeChatList", "nick", "starStrangeMatch", "exitStrangeMatch", "targetExternalId", "acceptStrangeMatch", "svipUnblock", "Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "youTuBeProcess", "exitYouTuBe", "startYouTuBe", "youtubeUrl", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "addYouTuBeVideo", "deleteYouTuBeVideo", "roomYouTuList", "hotYouTuList", "myOwnRoom", "Lcom/qiahao/nextvideo/data/model/youtube/WatchYouTuListData;", "watchYouTuList", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelData;", "gameLevel", "homeGameList", "Lcom/qiahao/nextvideo/data/game/HomeGameUser;", "homeGameUserList", "Lcom/qiahao/nextvideo/data/baishun/BaiShunData;", "bsCode", "baiShunGameList", "Lcom/qiahao/nextvideo/data/baishun/BaiShunActivityData;", "baiShunBannerList", "Lcom/qiahao/nextvideo/data/giftRecord/GiftRecordData;", "giftRecord", "Lcom/qiahao/nextvideo/data/RefreshDiamond;", "sendEnvelope", "(JJJ)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "getEnvelopeData", "openEnvelope", "Lcom/qiahao/nextvideo/data/room/EnvelopeRecordData;", "envelopeRecord", "(Ljava/lang/Long;II)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/task/RealCertificationResult;", "realCertification", "videoUrl", "Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "superLikeList", "extId", "", "superLike", "extId1", "extId2", "minute", "pk1v1Start", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/game/Pk1v1End;", "pk1v1", "Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "foodieGameInfo", "foodieId", "Lcom/qiahao/nextvideo/data/foodie/FoodieStake;", "foodieStake", "Lcom/qiahao/nextvideo/data/foodie/FoodieRecordBean;", "foodieRecord", "Lcom/qiahao/nextvideo/data/foodie/FoodieDrawResult;", "foodieRank", "clearInteractionMessage", "resetActivity", "deviceToken", "thirdIMEI", "uniqueKey", "notRecommend", "(ILjava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "txGroupId", "notRecommendVideo", "Lcom/qiahao/nextvideo/data/family/FamilyWheelRecord;", "familyWheelRecord", "Lcom/qiahao/nextvideo/data/room/RoomActiveData;", "groupActive", "Lcom/qiahao/base_common/model/ActivityConfigData;", "activityConfig", "uploadToken", "serviceDeviceID", "checkDeleteFamily", "deleteFamily", "Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;", "foodieRepeatData", "foodieRepeat", "fruitRepeatData", "fruitRepeat", "Lcom/qiahao/nextvideo/data/firstCharge/ListData;", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "firstRechargeCard", "exitHiloGameModel", "newUserList", "Lcom/qiahao/nextvideo/data/model/NewRoomBean;", "newRoomList", "Lcom/qiahao/base_common/model/CustomData;", "Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "storeCarromSkin", "Lcom/qiahao/nextvideo/data/store/BagCarromData;", "bagCarromSkin", "useCarromSkin", "roomStartMusic", "roomStopMusic", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalTaskBean;", "getPersonalAndRoomTaskList", "taskId", "getPersonalAndRoomTaskAward", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalBannerBean;", "getPersonalAndRoomBanner", "Lcom/qiahao/nextvideo/data/giftRecord/UploadGiftConfirm;", "checkUploadGiftConfirm", "effectUrl", "iconUrl", "uploadGift", "Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "checkEditeUserInfo", "Lcom/qiahao/nextvideo/data/model/MainListData;", "showAllList", "activityPopupId", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "mainActivityData", "(Ljava/lang/Long;)Lio/reactivex/rxjava3/core/i0;", "receiveSvipTaskAward", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface ServerApi extends CommonApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ i0 awardEarnDiamondTask$default(ServerApi serverApi, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = 0;
                }
                return serverApi.awardEarnDiamondTask(i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awardEarnDiamondTask");
        }

        public static /* synthetic */ i0 buyDiamonds$default(ServerApi serverApi, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            int i3;
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i3 = 1;
                } else {
                    i3 = i;
                }
                if ((i2 & 8) != 0) {
                    str3 = null;
                }
                String str6 = str3;
                if ((i2 & 32) != 0) {
                    str5 = "";
                }
                return serverApi.buyDiamonds(i3, str, str2, str6, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buyDiamonds");
        }

        public static /* synthetic */ i0 checkIsBroadcastManager$default(ServerApi serverApi, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return serverApi.checkIsBroadcastManager(str, str2, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkIsBroadcastManager");
        }

        public static /* synthetic */ i0 checkShare$default(ServerApi serverApi, String str, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 0;
                }
                return serverApi.checkShare(str, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkShare");
        }

        public static /* synthetic */ i0 countries$default(ServerApi serverApi, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                return serverApi.countries(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countries");
        }

        public static /* synthetic */ i0 crateActivity$default(ServerApi serverApi, String str, String str2, String str3, String str4, int i, long j, int i2, String str5, int i3, Object obj) {
            String str6;
            if (obj == null) {
                if ((i3 & 128) != 0) {
                    str6 = null;
                } else {
                    str6 = str5;
                }
                return serverApi.crateActivity(str, str2, str3, str4, i, j, i2, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: crateActivity");
        }

        public static /* synthetic */ i0 deleteBroadcastMessage$default(ServerApi serverApi, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return serverApi.deleteBroadcastMessage(str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteBroadcastMessage");
        }

        public static /* synthetic */ i0 fetchDiamondList$default(ServerApi serverApi, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return serverApi.fetchDiamondList(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchDiamondList");
        }

        public static /* synthetic */ i0 fetchUserBlacklist$default(ServerApi serverApi, int i, int i2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = null;
                }
                return serverApi.fetchUserBlacklist(i, i2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchUserBlacklist");
        }

        public static /* synthetic */ i0 fetchVipDetail$default(ServerApi serverApi, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return serverApi.fetchVipDetail(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchVipDetail");
        }

        public static /* synthetic */ i0 gemExchangeList$default(ServerApi serverApi, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                return serverApi.gemExchangeList(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gemExchangeList");
        }

        public static /* synthetic */ i0 getEarnDiamondTaskList$default(ServerApi serverApi, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                return serverApi.getEarnDiamondTaskList(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEarnDiamondTaskList");
        }

        public static /* synthetic */ i0 getGroupBlockList$default(ServerApi serverApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return serverApi.getGroupBlockList(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGroupBlockList");
        }

        public static /* synthetic */ i0 getGroupVisitor$default(ServerApi serverApi, String str, int i, int i2, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str2 = null;
                }
                return serverApi.getGroupVisitor(str, i, i2, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGroupVisitor");
        }

        public static /* synthetic */ i0 getNobleAward$default(ServerApi serverApi, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 8;
                }
                return serverApi.getNobleAward(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNobleAward");
        }

        public static /* synthetic */ i0 getPromoteDetail$default(ServerApi serverApi, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return serverApi.getPromoteDetail(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPromoteDetail");
        }

        public static /* synthetic */ i0 inviteSheep$default(ServerApi serverApi, long j, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            String str6;
            if (obj == null) {
                if ((i & 32) != 0) {
                    str6 = null;
                } else {
                    str6 = str5;
                }
                return serverApi.inviteSheep(j, str, str2, str3, str4, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inviteSheep");
        }

        public static /* synthetic */ i0 joinGroup$default(ServerApi serverApi, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return serverApi.joinGroup(str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinGroup");
        }

        public static /* synthetic */ i0 mainActivityData$default(ServerApi serverApi, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                return serverApi.mainActivityData(l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mainActivityData");
        }

        public static /* synthetic */ i0 reportGroup$default(ServerApi serverApi, String str, int i, String str2, String str3, boolean z, boolean z2, int i2, Object obj) {
            boolean z3;
            boolean z4;
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    z3 = false;
                } else {
                    z3 = z;
                }
                if ((i2 & 32) != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                return serverApi.reportGroup(str, i, str2, str3, z3, z4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportGroup");
        }

        public static /* synthetic */ i0 sendBagGift$default(ServerApi serverApi, String str, String str2, long j, int i, int i2, String str3, Long l, int i3, String str4, String str5, int i4, Object obj) {
            String str6;
            String str7;
            int i5;
            int i6;
            Long l2;
            int i7;
            String str8;
            String str9;
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str6 = null;
                } else {
                    str6 = str;
                }
                if ((i4 & 2) != 0) {
                    str7 = null;
                } else {
                    str7 = str2;
                }
                if ((i4 & 8) != 0) {
                    i5 = 1;
                } else {
                    i5 = i;
                }
                if ((i4 & 16) != 0) {
                    i6 = 1;
                } else {
                    i6 = i2;
                }
                if ((i4 & 64) != 0) {
                    l2 = null;
                } else {
                    l2 = l;
                }
                if ((i4 & 128) != 0) {
                    i7 = 0;
                } else {
                    i7 = i3;
                }
                if ((i4 & 256) != 0) {
                    str8 = null;
                } else {
                    str8 = str4;
                }
                if ((i4 & 512) != 0) {
                    str9 = null;
                } else {
                    str9 = str5;
                }
                return serverApi.sendBagGift(str6, str7, j, i5, i6, str3, l2, i7, str8, str9);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBagGift");
        }

        public static /* synthetic */ i0 sendGift$default(ServerApi serverApi, String str, long j, int i, String str2, int i2, String str3, int i3, Object obj) {
            int i4;
            int i5;
            String str4;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i4 = 1;
                } else {
                    i4 = i;
                }
                if ((i3 & 16) != 0) {
                    i5 = 1;
                } else {
                    i5 = i2;
                }
                if ((i3 & 32) != 0) {
                    str4 = null;
                } else {
                    str4 = str3;
                }
                return serverApi.sendGift(str, j, i4, str2, i5, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendGift");
        }

        public static /* synthetic */ i0 sendGiftToMicAllMember$default(ServerApi serverApi, String str, long j, int i, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str2 = null;
                }
                return serverApi.sendGiftToMicAllMember(str, j, i, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendGiftToMicAllMember");
        }

        public static /* synthetic */ i0 sendGiftToRoomAllMember$default(ServerApi serverApi, String str, long j, int i, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str2 = null;
                }
                return serverApi.sendGiftToRoomAllMember(str, j, i, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendGiftToRoomAllMember");
        }

        public static /* synthetic */ i0 setPhotos$default(ServerApi serverApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return serverApi.setPhotos(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPhotos");
        }

        public static /* synthetic */ i0 subscribeVip$default(ServerApi serverApi, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return serverApi.subscribeVip(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeVip");
        }

        public static /* synthetic */ i0 superAdminReport$default(ServerApi serverApi, String str, int i, String str2, String str3, Integer num, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 16) != 0) {
                    num = null;
                }
                return serverApi.superAdminReport(str, i, str2, str3, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: superAdminReport");
        }

        public static /* synthetic */ i0 transferBanners$default(ServerApi serverApi, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = 0;
                }
                return serverApi.transferBanners(num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transferBanners");
        }

        public static /* synthetic */ i0 transferMonth$default(ServerApi serverApi, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    num = 0;
                }
                return serverApi.transferMonth(num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transferMonth");
        }

        public static /* synthetic */ i0 transferRange$default(ServerApi serverApi, String str, String str2, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    num = 0;
                }
                return serverApi.transferRange(str, str2, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transferRange");
        }

        public static /* synthetic */ i0 transferRank$default(ServerApi serverApi, String str, String str2, int i, int i2, Integer num, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    num = 0;
                }
                return serverApi.transferRank(str, str2, i, i2, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transferRank");
        }

        public static /* synthetic */ i0 updateGroupInfo$default(ServerApi serverApi, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, String str8, int i, Object obj) {
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            Boolean bool2;
            String str14;
            Integer num9;
            Integer num10;
            Integer num11;
            Integer num12;
            Integer num13;
            Integer num14;
            Integer num15;
            Integer num16;
            if (obj == null) {
                String str15 = null;
                if ((i & 2) != 0) {
                    str9 = null;
                } else {
                    str9 = str2;
                }
                if ((i & 4) != 0) {
                    str10 = null;
                } else {
                    str10 = str3;
                }
                if ((i & 8) != 0) {
                    str11 = null;
                } else {
                    str11 = str4;
                }
                if ((i & 16) != 0) {
                    str12 = null;
                } else {
                    str12 = str5;
                }
                if ((i & 32) != 0) {
                    str13 = null;
                } else {
                    str13 = str6;
                }
                if ((i & 64) != 0) {
                    bool2 = null;
                } else {
                    bool2 = bool;
                }
                if ((i & 128) != 0) {
                    str14 = null;
                } else {
                    str14 = str7;
                }
                if ((i & 256) != 0) {
                    num9 = null;
                } else {
                    num9 = num;
                }
                if ((i & 512) != 0) {
                    num10 = null;
                } else {
                    num10 = num2;
                }
                if ((i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
                    num11 = null;
                } else {
                    num11 = num3;
                }
                if ((i & 2048) != 0) {
                    num12 = null;
                } else {
                    num12 = num4;
                }
                if ((i & 4096) != 0) {
                    num13 = null;
                } else {
                    num13 = num5;
                }
                if ((i & 8192) != 0) {
                    num14 = null;
                } else {
                    num14 = num6;
                }
                if ((i & 16384) != 0) {
                    num15 = null;
                } else {
                    num15 = num7;
                }
                if ((i & 32768) != 0) {
                    num16 = null;
                } else {
                    num16 = num8;
                }
                if ((i & 65536) == 0) {
                    str15 = str8;
                }
                return serverApi.updateGroupInfo(str, str9, str10, str11, str12, str13, bool2, str14, num9, num10, num11, num12, num13, num14, num15, num16, str15);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateGroupInfo");
        }

        public static /* synthetic */ i0 userDiamondsDetail$default(ServerApi serverApi, int i, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 4) != 0) {
                    i3 = 0;
                }
                return serverApi.userDiamondsDetail(i, i2, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userDiamondsDetail");
        }

        public static /* synthetic */ i0 videoInter$default(ServerApi serverApi, int i, int i2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = null;
                }
                if ((i3 & 8) != 0) {
                    str2 = null;
                }
                return serverApi.videoInter(i, i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: videoInter");
        }

        public static /* synthetic */ i0 videoSetting$default(ServerApi serverApi, int i, int i2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = null;
                }
                if ((i3 & 8) != 0) {
                    str2 = null;
                }
                return serverApi.videoSetting(i, i2, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: videoSetting");
        }
    }

    @FormUrlEncoded
    @PUT("/v2/match/accept")
    @NotNull
    i0<ApiResponse<Object>> accept(@Field("matchUniqueId") @NotNull String matchUniqueId, @Field("otherUserExternalId") @NotNull String otherUserExternalId, @Field("conditionSex") @NotNull String conditionSex, @Field("conditionCountry") @NotNull String conditionCountry);

    @FormUrlEncoded
    @POST("/v1/groupPk/accept")
    @NotNull
    i0<ApiResponse<Object>> acceptPK(@Field("groupId") @NotNull String groupId, @Field("targetGroupId") @NotNull String targetGroupId);

    @FormUrlEncoded
    @POST("/v1/mask/match/accept")
    @NotNull
    i0<ApiResponse<String>> acceptStrangeMatch(@Field("targetExternalId") @NotNull String targetExternalId);

    @GET("/v1/group/activity/config")
    @NotNull
    i0<ApiResponse<ActivityConfigData>> activityConfig();

    @GET("/v1/group/activity/detail")
    @NotNull
    i0<ApiResponse<ActivityDetailData>> activityDetail(@NotNull @Query("activityId") String r1);

    @GET("/v1/group/activity")
    @NotNull
    i0<ApiResponse<ApiListData<ActivityDetailData>>> activityList(@Query("type") int type, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex, @NotNull @Query("groupId") String groupId);

    @FormUrlEncoded
    @POST("/v1/group/activity/subscribe")
    @NotNull
    i0<ApiResponse<Object>> activitySubscribe(@Field("activityId") @NotNull String r1, @Field("subType") int subType);

    @FormUrlEncoded
    @POST("/v1/ytb/playlist/add")
    @NotNull
    i0<ApiResponse<YouTuBeData>> addYouTuBeVideo(@Field("groupId") @NotNull String groupId, @Field("youtubeUrl") @NotNull String youtubeUrl);

    @FormUrlEncoded
    @POST("/v1/groupPower/apply")
    @NotNull
    i0<ApiResponse<Object>> applyFamily(@Field("id") long r1);

    @FormUrlEncoded
    @POST("/v1/groupPower/apply/pass")
    @NotNull
    i0<ApiResponse<Object>> applyFamily(@Field("userExtId") @NotNull String userExtId, @Field("type") int type);

    @FormUrlEncoded
    @POST("/v1/task/award")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> awardEarnDiamondTask(@Field("taskConfigId") int taskConfigId, @Field("taskType") int r2);

    @GET("/v1/gameSkin/bag")
    @NotNull
    i0<ApiResponse<CustomData<BagCarromData>>> bagCarromSkin(@Query("gameId") int r1, @Query("type") int type);

    @GET("/v2/game/act/banner")
    @NotNull
    i0<ApiResponse<ApiList<BaiShunActivityData>>> baiShunBannerList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v2/game/h5/list")
    @NotNull
    i0<ApiResponse<ArrayList<GameConfiguration>>> baiShunGameList();

    @FormUrlEncoded
    @POST("/v1/user/third")
    @NotNull
    i0<ApiResponse<Object>> binderOrUnBinderThird(@Field("type") int type, @Field("thirdPartyType") int thirdPartyType, @Field("thirdPartyId") @NotNull String thirdPartyId, @Field("thirdPartyToken") @NotNull String thirdPartyToken);

    @FormUrlEncoded
    @POST("/v1/user/phone")
    @NotNull
    i0<ApiResponse<PhoneInfo>> binderPhoneAndPwd(@Field("country") @NotNull String country, @Field("phone") @NotNull String phone, @Field("pwd") @NotNull String pwd, @Field("code") @NotNull String r4);

    @FormUrlEncoded
    @POST("/v1/user/global/broadcast/top")
    @NotNull
    i0<ApiResponse<Object>> broadcastTop(@Field("id") int r1);

    @FormUrlEncoded
    @POST("/v1/game/bsCode")
    @NotNull
    i0<ApiResponse<BaiShunData>> bsCode(@Field("gameId") @NotNull String r1);

    @FormUrlEncoded
    @POST("/v1/diamond/buy/google")
    @NotNull
    i0<ApiResponse<UserDiamonds>> buyDiamonds(@Field("platform") int platform, @Field("packageName") @NotNull String r2, @Field("productId") @NotNull String productID, @Field("orderId") @Nullable String orderID, @Field("purchaseToken") @NotNull String purchaseToken, @Field("buyType") @NotNull String buyType);

    @FormUrlEncoded
    @POST("/v1/noble/buy")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> buyNoble(@Field("level") int level);

    @GET("/v1/imGroup/support/page/{groupId}")
    @NotNull
    i0<ApiResponse<Boolean>> canOpenGroupSupport(@Path("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/logout/del")
    @NotNull
    i0<ApiResponse<Object>> cancelDeleteAccount(@Field("thirdPartyId") @NotNull String thirdPartyId, @Field("thirdPartyType") int thirdPartyType, @Field("thirdPartyToken") @NotNull String thirdPartyToken);

    @FormUrlEncoded
    @POST("/v1/bean/exchange/diamond")
    @NotNull
    i0<ApiResponse<BeanBaseBean>> changeBeanToDiamond(@Field("beanNum") long r1);

    @FormUrlEncoded
    @POST("/v1/gem/exchange/diamond")
    @NotNull
    i0<ApiResponse<GemBean>> changeGemToDiamond(@Field("gemNum") int gemNum);

    @FormUrlEncoded
    @PUT("/v1/imGroup/mic/num")
    @NotNull
    i0<ApiResponse<String>> changeMicNum(@Field("micNumType") int micNumType, @Field("micOn") boolean micOn, @Field("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/groupPk/mute")
    @NotNull
    i0<ApiResponse<Object>> changeOtherRoomMic(@Field("type") int type);

    @FormUrlEncoded
    @PUT("/v1/user/pwd")
    @NotNull
    i0<ApiResponse<Object>> changePwd(@Field("oldPwd") @NotNull String oldPwd, @Field("pwd") @NotNull String pwd, @Field("code") @NotNull String r3);

    @FormUrlEncoded
    @PUT("/v1/user/changePwd")
    @NotNull
    i0<ApiResponse<Object>> changePwd(@Field("areaCode") @NotNull String areaCode, @Field("phone") @NotNull String phone, @Field("pwd") @NotNull String pwd, @Field("code") @NotNull String r4);

    @GET("/v1/imGroup/support/award/{groupId}")
    @NotNull
    i0<ApiResponse<Object>> checkAdminSupportGetAward(@Path("groupId") @NotNull String groupId, @NotNull @Query("externalId") String r2);

    @GET("/v2/cp/relation/check")
    @NotNull
    i0<ApiResponse<CpCheck>> checkBindCp(@NotNull @Query("externalId") String r1);

    @GET("/v1/specialRelation/check")
    @NotNull
    i0<ApiResponse<CpCheck>> checkBindRelation(@NotNull @Query("externalId") String r1, @Query("relationType") int r2);

    @GET("/v1/groupPower/dissolve/check")
    @NotNull
    i0<ApiResponse<Object>> checkDeleteFamily();

    @GET("/v1/user/edit/check")
    @NotNull
    i0<ApiResponse<CheckUserInfo>> checkEditeUserInfo();

    @GET("/v1/diamond/recharge/first")
    @NotNull
    i0<ApiResponse<AwardDetailBean>> checkFirstRecharge();

    @GET("/v1/imGroup/password/{groupId}")
    @NotNull
    i0<ApiResponse<Boolean>> checkGroupHasPassWord(@Path("groupId") @NotNull String groupId);

    @GET("/v1/manager/check")
    @NotNull
    i0<ApiResponse<IsBroadCastMangerBean>> checkIsBroadcastManager(@NotNull @Query("items") String items, @NotNull @Query("externalId") String r2, @Query("needCheckSvip") boolean needCheckSvip);

    @GET("/v1/diamond/charge/whiteList")
    @NotNull
    i0<ApiResponse<CheckChargeData>> checkIsChargeUser(@Query("platform") int platform, @NotNull @Query("productId") String productId);

    @GET("/v2/user/noble/award")
    @NotNull
    i0<ApiResponse<CheckNobleAward>> checkNobleAward();

    @FormUrlEncoded
    @PUT("/v1/user/phone")
    @NotNull
    i0<ApiResponse<PhoneInfo>> checkPhone(@Field("type") int type, @Field("phone") @NotNull String phone, @Field("country") @NotNull String country, @Field("oldCode") @NotNull String oldCode, @Field("code") @NotNull String r5, @Field("pwd") @NotNull String pwd);

    @FormUrlEncoded
    @POST("/v1/sms")
    @NotNull
    i0<ApiResponse<Object>> checkSMS(@Field("type") int type, @Field("phone") @NotNull String phone, @Field("country") @NotNull String country, @Field("authen") @NotNull String authen, @Field("way") int way);

    @FormUrlEncoded
    @POST("/v1/sendSms")
    @NotNull
    i0<ApiResponse<Object>> checkSendSMS(@Field("phone") @NotNull String phone, @Field("areaCode") @NotNull String areaCode, @Field("authen") @NotNull String authen, @Field("way") int way);

    @GET("/v1/c/share")
    @NotNull
    i0<ApiResponse<TransferCheckData>> checkShare(@NotNull @Query("externalId") String r1, @Query("type") int type, @Query("send") int send);

    @GET("/v1/configuration/uploadGift/config")
    @NotNull
    i0<ApiResponse<UploadGiftConfirm>> checkUploadGiftConfirm();

    @FormUrlEncoded
    @POST("/v1/imGroup/mgr/clearScreen")
    @NotNull
    i0<ApiResponse<Object>> cleanMessage(@Field("groupId") @NotNull String groupId);

    @POST("/v1/msg/user/clear")
    @NotNull
    i0<ApiResponse<String>> clearAssistantUnRead();

    @POST("/v1/msg/interaction/clear")
    @NotNull
    i0<ApiResponse<Object>> clearInteractionMessage();

    @POST("/v1/msg/sys/clear")
    @NotNull
    i0<ApiResponse<String>> clearSysUnRead();

    @FormUrlEncoded
    @POST("/v1/client/report")
    @NotNull
    i0<ApiResponse<String>> clientReport(@Field("type") int type);

    @FormUrlEncoded
    @POST("/v1/match/minimize/close")
    @NotNull
    i0<ApiResponse<Object>> close(@Field("matchUniqueId") @NotNull String matchUniqueId);

    @DELETE("/v1/luckyWheel/{groupId}")
    @NotNull
    i0<ApiResponse<String>> closeRoomLuckWheel(@Path("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/user/info")
    @NotNull
    i0<ApiResponse<User>> commitUserInfo(@Field("nick") @Nullable String name, @Field("birthday") @Nullable Long birthday, @Field("sex") @Nullable Integer sex, @Field("country") @Nullable String country);

    @GET("/v1/res/country")
    @NotNull
    i0<ApiResponse<CountriesResponse>> countries(@Query("filterArea") int filterArea);

    @FormUrlEncoded
    @POST("/v1/cp/disconnect")
    @NotNull
    i0<ApiResponse<String>> cpDisconnect(@Field("externalId") @NotNull String r1);

    @GET("/v2/cp/anniversary")
    @NotNull
    i0<ApiResponse<ApiList<CpMemorial>>> cpMemorial(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @PUT("/v2/cp/privilege/openClose")
    @NotNull
    i0<ApiResponse<Object>> cpOpenClose(@Field("type") int type, @Field("openClose") int openClose, @Field("relationType") int r3);

    @GET("/v2/cp/relation/detail")
    @NotNull
    i0<ApiResponse<CpSpace>> cpProfile(@NotNull @Query("externalId") String r1);

    @GET("/v2/cp/rank/{queryType}")
    @NotNull
    i0<ApiResponse<ApiList<CpListData>>> cpRankList(@Path("queryType") @NotNull String queryType, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v2/cp/achievement")
    @NotNull
    i0<ApiResponse<ApiList<CpRecord>>> cpRecord();

    @FormUrlEncoded
    @POST("/v2/cp/relation")
    @NotNull
    i0<ApiResponse<Object>> cpRelation(@Field("externalId") @NotNull String r1, @Field("type") int type);

    @FormUrlEncoded
    @POST("/v2/cp/relation/cancel/reply")
    @NotNull
    i0<ApiResponse<Object>> cpReply(@Field("externalId") @NotNull String r1, @Field("type") int type);

    @GET("/v2/cp/space")
    @NotNull
    i0<ApiResponse<CpSpace>> cpSpace(@NotNull @Query("externalId") String r1);

    @FormUrlEncoded
    @POST("/v1/group/activity")
    @NotNull
    i0<ApiResponse<Object>> crateActivity(@Field("banner") @NotNull String banner, @Field("theme") @NotNull String theme, @Field("desc") @NotNull String desc, @Field("groupId") @NotNull String groupId, @Field("acType") int acType, @Field("startAt") long startAt, @Field("duration") int duration, @Field("md5") @Nullable String md5);

    @POST("/v1/imGroup/group")
    @NotNull
    i0<ApiResponse<CreateGroupBean>> createGroup();

    @FormUrlEncoded
    @POST("/v1/groupPk/join")
    @NotNull
    i0<ApiResponse<Object>> createPK(@Field("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/luckyWheel/{groupId}")
    @NotNull
    i0<ApiResponse<String>> createRoomLuckWheel(@Field("resId") int resId, @Field("creatorJoin") boolean creatorJoin, @Field("autoRestart") boolean autoRestart, @Path("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/game/add")
    @NotNull
    i0<ApiResponse<BeanBaseBean>> createSud(@Field("gameType") int gameType, @Field("mode") int r2, @Field("piece") int piece, @Field("onOff1") int onOff1, @Field("diamond") int r5, @Field("autoMatch") int autoMatch, @Field("groupId") @NotNull String groupId, @Field("gameCode") @NotNull String gameCode);

    @GET("/v1/groupPk/info")
    @NotNull
    i0<ApiResponse<RoomCurrentPK>> currentPKStatus(@NotNull @Query("groupId") String groupId);

    @DELETE("/v1/group/activity")
    @NotNull
    i0<ApiResponse<Object>> deleteActivity(@NotNull @Query("acId") String acId);

    @DELETE("/v1/user/global/broadcast/manager/{globalBroadcastId}")
    @NotNull
    i0<ApiResponse<Object>> deleteBroadcastMessage(@Path("globalBroadcastId") @NotNull String globalBroadcastId, @Query("delType") int delType);

    @DELETE("/v2/cp/anniversary/{id}")
    @NotNull
    i0<ApiResponse<Object>> deleteCpMemorial(@Path("id") int i);

    @POST("/v1/groupPower/dissolve")
    @NotNull
    i0<ApiResponse<Object>> deleteFamily();

    @DELETE("/v1/headwear")
    @NotNull
    i0<ApiResponse<Object>> deleteHeadWear(@Query("headWearId") int headWearId);

    @DELETE("/v1/noble/user/{level}")
    @NotNull
    i0<ApiResponse<Object>> deleteNoble(@Path("level") int level);

    @DELETE("/v1/property")
    @NotNull
    i0<ApiResponse<Object>> deleteProperty(@Query("propertyId") int propertyId);

    @DELETE("/v1/session/{otherExternalId}")
    @NotNull
    i0<ApiResponse<Object>> deleteSession(@Path("otherExternalId") @NotNull String otherExternalId);

    @FormUrlEncoded
    @POST("/v1/ytb/playlist/del")
    @NotNull
    i0<ApiResponse<Object>> deleteYouTuBeVideo(@Field("groupId") @NotNull String groupId, @Field("videoId") @NotNull String videoId);

    @GET("/v1/game/diamond/list")
    @NotNull
    i0<ApiResponse<ArrayList<GameConfiguration>>> diamondGameData(@NotNull @Query("groupId") String groupId);

    @FormUrlEncoded
    @POST("/v2/match/call/ready")
    @NotNull
    i0<ApiResponse<Object>> dispatchEventInRoomName(@Field("matchUniqueId") @NotNull String matchUniqueId);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/leave")
    @NotNull
    i0<ApiResponse<Object>> downMic(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @FormUrlEncoded
    @POST("/v1/game/edit")
    @NotNull
    i0<ApiResponse<Object>> editSud(@Field("gameId") long r1, @Field("mode") int r3, @Field("piece") int piece, @Field("onOff1") int onOff1, @Field("diamond") int r6, @Field("autoMatch") int autoMatch, @Field("gameCode") @NotNull String gameCode);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/task/invite/dialog")
    @NotNull
    i0<ApiResponse<AutoInviteUserUpMicBean>> enterRoomCheckAutoInviteUpMicDialog(@Field("groupId") @NotNull String groupId);

    @GET("/v1/luckyBag/record")
    @NotNull
    i0<ApiResponse<ApiList<EnvelopeRecordData>>> envelopeRecord(@Nullable @Query("id") Long r1, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v2/diamond/exchange/gem")
    @NotNull
    i0<ApiResponse<ExchangeGem>> exchangeGem(@Field("diamondNum") int diamondNum);

    @FormUrlEncoded
    @POST("/v1/imGroup/gameMode/quit")
    @NotNull
    i0<ApiResponse<Object>> exitHiloGameModel(@Field("groupId") @NotNull String groupId);

    @DELETE("/v1/game/lobby/match")
    @NotNull
    i0<ApiResponse<Object>> exitLobbyMatch();

    @DELETE("/v2/match")
    @NotNull
    z<ApiResponse<RandomPairChatroomConfig>> exitMatchPool();

    @DELETE("/v1/groupPk/quit/{groupId}")
    @NotNull
    i0<ApiResponse<Object>> exitPK(@Path("groupId") @NotNull String groupId);

    @DELETE("/v1/game/sheep/match")
    @NotNull
    i0<ApiResponse<Object>> exitSheep(@Query("matchId") int matchId, @Query("gameId") int r2);

    @DELETE("/v1/mask/match/cancel")
    @NotNull
    i0<ApiResponse<Object>> exitStrangeMatch();

    @FormUrlEncoded
    @POST("/v1/ytb/quit")
    @NotNull
    i0<ApiResponse<Object>> exitYouTuBe(@Field("groupId") @NotNull String groupId);

    @GET("/v1/groupPower/apply/count")
    @NotNull
    i0<ApiResponse<Integer>> familyApplicationNumber();

    @GET("/v1/groupPower/apply/list")
    @NotNull
    i0<ApiResponse<ApiList<FamilyApplicationData>>> familyApplyList(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/groupPower/info")
    @NotNull
    i0<ApiResponse<FamilyCenterData>> familyInfo(@Query("id") long r1);

    @GET("/v1/groupPower/members")
    @NotNull
    i0<ApiResponse<ApiList<FamilyCenterMember>>> familyMemberList(@NotNull @Query("userCode") String userCode, @Query("id") long r2, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/groupPower/quit/list")
    @NotNull
    i0<ApiResponse<ApiList<FamilyApplicationData>>> familyQuitList(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/groupPower/rank/{period}")
    @NotNull
    i0<ApiResponse<FamilyRankData>> familyRank(@Path("period") @NotNull String period);

    @GET("/v1/groupPower/rooms")
    @NotNull
    i0<ApiResponse<ApiList<FamilyRoomInfo>>> familyRoomList(@Query("id") long r1, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/groupPower/star/{period}")
    @NotNull
    i0<ApiResponse<ApiList<FamilyStarData>>> familyStar(@Path("period") @NotNull String period, @Query("groupPowerId") long groupPowerId, @Query("type") int type, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/groupPower/wheel/records")
    @NotNull
    i0<ApiResponse<ApiList<FamilyWheelRecord>>> familyWheelRecord(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v1/user/advice")
    @NotNull
    i0<ApiResponse<Object>> feedback(@Field("advice") @NotNull String description, @Field("picUrls") @Nullable String images);

    @GET("/v1/user/agentMgr/connectionLog")
    @NotNull
    i0<ApiResponse<AgentMgrConnectionLogBean>> fetchAgentMgrConnectLogs(@NotNull @Query("date") String date);

    @GET("/v1/configuration/param")
    @NotNull
    i0<ApiResponse<ConfigurationParam>> fetchConfigurationParam();

    @GET("/v1/user/tradeUnion/count")
    @NotNull
    i0<ApiResponse<List<ConnectLogItem>>> fetchConnectLogs(@Query("beginTimestamp") long beginTimestamp, @Query("endTimestamp") long endTimestamp);

    @GET("/v1/diamond")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> fetchDiamond();

    @GET("/v2/res/purchase/diamond/{platform}")
    @NotNull
    i0<ApiResponse<PurchaseGem>> fetchDiamondList(@Path("platform") @NotNull String platform);

    @GET("/v1/msg/user")
    @NotNull
    i0<ApiResponse<List<HiloAssistantItem>>> fetchHiloAssistants(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/msg/sys")
    @NotNull
    i0<ApiResponse<List<HiloInformationItem>>> fetchHiloInformations(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/user/i/like")
    @NotNull
    i0<ApiResponse<List<ILikeGuyItem>>> fetchILikesList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/msg/last")
    @NotNull
    Call<ApiResponse<MsgForHiloOfficial>> fetchMsgLastForHiloOfficial();

    @GET("/v1/recommend/unit/list")
    @NotNull
    i0<ApiResponse<OnlineUserListResponse>> fetchOnlineUsersNew(@Query("pageSize") int pageSize, @Nullable @Query("version") String r2, @Query("lastIndex") int lastIndex, @Nullable @Query("model") Integer r4, @Nullable @Query("firstIndex") Integer firstIndex);

    @GET("/v1/configuration/fee")
    @NotNull
    i0<ApiResponse<PurchaseFeeDetailsX>> fetchPurchaseFeeDetails();

    @GET("/v2/gift/receive/{userExternalId}")
    @NotNull
    i0<ApiResponse<ApiList<ReceivedGift>>> fetchReceviedGifts(@Path("userExternalId") @NotNull String uid, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/user/black")
    @NotNull
    i0<ApiResponse<List<BlockedInfo>>> fetchUserBlacklist(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Nullable @Query("code") String r3);

    @GET("/v1/user/detail/{userExternalId}")
    @NotNull
    i0<ApiResponse<User>> fetchUserDetail(@Path("userExternalId") @NotNull String uid, @NotNull @Query("groupId") String groupId);

    @GET("/v1/user/detail")
    @NotNull
    i0<ApiResponse<User>> fetchUserDetailInfo();

    @GET("/v1/user/like/me")
    @NotNull
    i0<ApiResponse<List<LikeMeGuyItem>>> fetchUserLikesMeList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/diamond/buy")
    @NotNull
    i0<ApiResponse<List<PurchaseItem>>> fetchUserPaymentsDetail(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v2/video/inter/like/list")
    @NotNull
    i0<ApiResponse<ApiList<PraiseGuyItem>>> fetchUserPraiseList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/user/base/{userExternalId}")
    @NotNull
    i0<ApiResponse<UserSummaryInfo>> fetchUserSummary(@Path("userExternalId") @NotNull String uid);

    @GET("/v1/user/visit")
    @NotNull
    i0<ApiResponse<List<VisitGuyItem>>> fetchUserVisitList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/res/purchase/vip/{platform}")
    @NotNull
    i0<ApiResponse<List<PurchaseDiamondDetail>>> fetchVipDetail(@Path("platform") @NotNull String platform);

    @GET
    @GsonConverter("common")
    @NotNull
    i0<WechatAuthorizedInfo> fetchWechatAuthorizedToken(@Url @NotNull String url, @NotNull @Query("appid") String appid, @NotNull @Query("secret") String secret, @NotNull @Query("code") String r4, @NotNull @Query("grant_type") String grantType);

    @GET
    @GsonConverter("common")
    @NotNull
    i0<WechatUserInfo> fetchWechatUserInfo(@Url @NotNull String url, @NotNull @Query("access_token") String accessToken, @NotNull @Query("openid") String openid);

    @GET("/v1/user/extend/code")
    @NotNull
    i0<ApiResponse<User>> findUserByCode(@NotNull @Query("code") String r1);

    @GET("/v2/act/recharge/first")
    @NotNull
    i0<ApiResponse<ListData<FirstChargeData>>> firstRechargeCard();

    @GET("/v1/foodie")
    @NotNull
    i0<ApiResponse<FoodieGameInfo>> foodieGameInfo();

    @GET("/v1/foodie/round")
    @NotNull
    i0<ApiResponse<FoodieGameInfo>> foodieGameInfo(@Query("round") int round);

    @GET("/v1/foodie/billboard")
    @NotNull
    i0<ApiResponse<ArrayList<FoodieDrawResult>>> foodieRank();

    @GET("/v1/foodie/myRecord")
    @NotNull
    i0<ApiResponse<ApiList<FoodieRecordBean>>> foodieRecord(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @POST("/v1/foodie/auto")
    @NotNull
    i0<ApiResponse<FoodieRepeat>> foodieRepeat();

    @GET("/v1/foodie/auto")
    @NotNull
    i0<ApiResponse<FoodieRepeat>> foodieRepeatData();

    @FormUrlEncoded
    @POST("/v1/foodie")
    @NotNull
    i0<ApiResponse<FoodieStake>> foodieStake(@Field("foodieId") int foodieId, @Field("amount") int amount);

    @POST("/v1/fruitMachine/auto")
    @NotNull
    i0<ApiResponse<FoodieRepeat>> fruitRepeat();

    @GET("/v1/fruitMachine/auto")
    @NotNull
    i0<ApiResponse<FoodieRepeat>> fruitRepeatData();

    @GET("/v1/gameLevel/info")
    @NotNull
    i0<ApiResponse<GameLevelData>> gameLevel();

    @GET("/v1/game/lobby/list")
    @NotNull
    i0<ApiResponse<ArrayList<GameLobby>>> gameLobbyList();

    @GET("/v2/res/purchase/eList")
    @NotNull
    i0<ApiResponse<ArrayList<PurchaseDiamondDetail>>> gemExchangeList(@Query("type") int type);

    @GET("/v1/game/gem/list")
    @NotNull
    i0<ApiResponse<GemGameData>> gemGameData();

    @GET("/v1/game/gem/rank")
    @NotNull
    i0<ApiResponse<GemGameRank>> gemGameRank(@Query("gameId") int r1);

    @GET("/v1/imGroup/theme/custom/all")
    @NotNull
    i0<ApiResponse<ArrayList<CustomThemeBean>>> getAllCustomTheme(@NotNull @Query("groupId") String groupId);

    @GET("/v1/user/medal/public/all")
    @NotNull
    i0<ApiResponse<List<MedalAllTypeBean>>> getAllPublicMedalType();

    @GET("/v1/billboard/top")
    @NotNull
    i0<ApiResponse<AllRankTop3Bean>> getAllRankTop3Aavatar();

    @GET("/v1/user/bag/{resType}")
    @NotNull
    i0<ApiResponse<List<GiftData>>> getBagGiftList(@Path("resType") int resType);

    @GET("/v1/bean/base")
    @NotNull
    i0<ApiResponse<BeanBaseBean>> getBeanBase();

    @GET("/v1/bean/detail")
    @NotNull
    i0<ApiResponse<List<BeanChangeDetail>>> getBeanDetail(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/imGroup/country")
    @NotNull
    i0<ApiResponse<HotGroupListBean>> getCountryGroup(@NotNull @Query("countryShortName") String countryShortName, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/user/country/top")
    @NotNull
    i0<ApiResponse<CountryTop3ContributeAllBean>> getCountryTop3Contribute(@NotNull @Query("country") String country);

    @GET("/v1/cp/ranking/list")
    @NotNull
    i0<ApiResponse<ArrayList<CpBean>>> getCpRankList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @NotNull @Query("queryType") String queryType);

    @GET("/v2/cp/top3")
    @NotNull
    i0<ApiResponse<CpTop3Bean>> getCpTop3();

    @GET("/v1/imGroup/theme/custom/config")
    @NotNull
    i0<ApiResponse<GroupThemeCustomConfig>> getCustomThemeConfig();

    @GET("/v1/dl/account")
    @NotNull
    i0<ApiResponse<DealerDetailBean>> getDealerDetail();

    @GET("/v1/dl/list")
    @NotNull
    i0<ApiResponse<DealerListBean>> getDealerList();

    @FormUrlEncoded
    @POST("/v1/logout/time")
    @NotNull
    i0<ApiResponse<DeleteAccountTimeBean>> getDeleteAccountTime(@Field("thirdPartyId") @NotNull String thirdPartyId, @Field("thirdPartyType") int thirdPartyType, @Field("thirdPartyToken") @NotNull String thirdPartyToken);

    @GET("/v1/discovery/banner/list")
    @NotNull
    i0<ApiResponse<ArrayList<GroupTopBannerBean>>> getDiscoverBannerList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/task/my")
    @NotNull
    i0<ApiResponse<EarnDiamondBean>> getEarnDiamondTaskList(@Query("taskType") int r1);

    @GET("/v1/luckyBag/info")
    @NotNull
    i0<ApiResponse<EnvelopeData>> getEnvelopeData(@Query("id") long r1, @NotNull @Query("groupId") String groupId);

    @GET("/v1/groupPower/rankTop")
    @NotNull
    i0<ApiResponse<WeekPowerTop3Bean>> getFamilyTop3Avatar();

    @GET("/v1/fruitMachine/")
    @NotNull
    i0<ApiResponse<LuckyFruitGameDetailBean>> getFruitMachineDetail();

    @GET("/v1/fruitMachine/history")
    @NotNull
    i0<ApiResponse<LuckyFruitResultList>> getFruitMachineHistory();

    @GET("/v1/fruitMachine/myRecord")
    @NotNull
    i0<ApiResponse<LuckyFruitResultMyRecord>> getFruitMachineMyRecord(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/fruitMachine/weeklyBillboard")
    @NotNull
    i0<ApiResponse<LuckyFruitRankAllBean>> getFruitMachineRanking(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/game/category/list")
    @NotNull
    i0<ApiResponse<List<GameCategory>>> getGameListOfType(@NotNull @Query("groupId") String groupId);

    @GET("/v1/gift/wall")
    @NotNull
    i0<ApiResponse<List<GiftWallBean>>> getGiftWall(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/user/global/broadcast")
    @NotNull
    i0<ApiResponse<List<GlobalBroadCastBean>>> getGlobalBroadCast(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/imGroup/blacklist/{groupId}")
    @NotNull
    i0<ApiResponse<BlockListBean>> getGroupBlockList(@Path("groupId") @NotNull String groupId, @Nullable @Query("code") String r2);

    @GET("/v1/billboard/groupCharm/{groupId}/{queryType}")
    @NotNull
    i0<ApiResponse<List<GroupRankBean>>> getGroupCharm(@Path("groupId") @NotNull String groupId, @Path("queryType") @NotNull String queryType);

    @GET("/v1/imGroup/detail/{groupId}")
    @NotNull
    i0<ApiResponse<GroupDetailBean>> getGroupDetail(@Path("groupId") @NotNull String str);

    @GET("/v1/billboard/groupCelebrity/{groupId}/{queryType}")
    @NotNull
    i0<ApiResponse<List<GroupRankBean>>> getGroupFamous(@Path("groupId") @NotNull String groupId, @Path("queryType") @NotNull String queryType);

    @GET("/v1/imGroup/medal/all")
    @NotNull
    i0<ApiResponse<List<GroupMedalBean>>> getGroupMedalAll(@NotNull @Query("groupId") String groupId);

    @GET("/v1/imGroup/permanent/{groupId}")
    @NotNull
    i0<ApiResponse<GroupMemberListBean>> getGroupMember(@Path("groupId") @NotNull String groupId, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v2/imGroup/role/{groupId}")
    @NotNull
    i0<ApiResponse<GroupMemberListBean>> getGroupMemberByRole(@Path("groupId") @NotNull String groupId, @Nullable @Query("role") Integer role, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/groupPower/group/{groupPowerId}")
    @NotNull
    i0<ApiResponse<List<PowerGroupMemberBean>>> getGroupPowerMemberGroup(@Path("groupPowerId") long groupPowerId, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/groupPower/billboard/week")
    @NotNull
    i0<ApiResponse<List<GroupPowerWeekBean>>> getGroupPowerRankWeek(@Query("type") int type, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/groupPower/title/{groupPowerId}")
    @NotNull
    i0<ApiResponse<GroupPowerTitleDetail>> getGroupPowerTitleDetail(@Path("groupPowerId") long powerId);

    @GET("/v1/imGroup/support/detail")
    @NotNull
    i0<ApiResponse<GroupSupportDetailResponseBean>> getGroupSupportDetail(@Nullable @Query("groupId") String groupId);

    @GET("/v1/res/group/themes")
    @NotNull
    i0<ApiResponse<List<GroupThemesBean>>> getGroupThemes();

    @GET("/v1/imGroup/visitors/{groupId}")
    @NotNull
    i0<ApiResponse<GroupMemberListBean>> getGroupVisitor(@Path("groupId") @NotNull String groupId, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Nullable @Query("code") String r4);

    @GET("/v1/headwear/diamond/list")
    @NotNull
    i0<ApiResponse<List<StoreBean>>> getHeadWearList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/dl")
    @NotNull
    i0<ApiResponse<IsDealerBean>> getIsDealer();

    @GET("/v1/imGroup/latest")
    @NotNull
    i0<ApiResponse<List<HotGroupBean>>> getLatestGroup(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Query("lastId") int lastId);

    @GET("/v1/user/contacts")
    @NotNull
    i0<ApiResponse<List<ContactsLikeEachItem>>> getLikeEachOtherList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/luckybox/ranking")
    @NotNull
    i0<ApiResponse<LuckyBoxRankingBean>> getLuckBoxRanking();

    @GET("/v1/luckybox/win/record")
    @NotNull
    i0<ApiResponse<ArrayList<LuckyBoxRecordBean>>> getLuckBoxRecord(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/luckybox/scroll")
    @NotNull
    i0<ApiResponse<ArrayList<ScrollBean>>> getLuckBoxScroll();

    @GET("/v1/luckybox/config")
    @NotNull
    i0<ApiResponse<LuckBoxConfigBean>> getLuckConfig();

    @GET("/v2/match/config")
    @NotNull
    i0<ApiResponse<MatchConfigData>> getMatchConfigData();

    @FormUrlEncoded
    @POST("/v1/user/medal/public/type")
    @NotNull
    i0<ApiResponse<String>> getMedalForUser(@Field("resMedalId") int resMedalId);

    @GET("/v1/res/medal")
    @NotNull
    i0<ApiResponse<List<MedalBean>>> getMedalList();

    @GET("/v1/user/medal/sort")
    @NotNull
    i0<ApiResponse<List<MedalSort>>> getMedalSort();

    @GET("/v1/res/mic/emoji")
    @NotNull
    i0<ApiResponse<List<EmojiBean>>> getMicEmoji();

    @GET("/v1/cp/my/list")
    @NotNull
    i0<ApiResponse<ArrayList<MyCpBean>>> getMyCpRankList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/headwear")
    @NotNull
    i0<ApiResponse<List<MyBagBean>>> getMyHeadWear();

    @GET("/v1/imGroup/joinedGroup")
    @NotNull
    i0<ApiResponse<JoinGroupBean>> getMyJoinedGroup(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/noble")
    @NotNull
    i0<ApiResponse<List<MyNobleBeanItem>>> getMyNobleDetail();

    @GET("/v1/imGroup/myPermanent")
    @NotNull
    i0<ApiResponse<List<HotGroupBean>>> getMyPermanentGroup(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/property")
    @NotNull
    i0<ApiResponse<List<MyBagBean>>> getMyProperty(@NotNull @Query("externalId") String r1);

    @GET("/v1/imGroup/myRecent")
    @NotNull
    i0<ApiResponse<List<HotGroupBean>>> getMyRecentGroup();

    @GET("/v1/user/nameplate")
    @NotNull
    i0<ApiResponse<List<NamePlateData>>> getNamePlateList(@NotNull @Query("code") String r1);

    @GET("/v1/groupPk/token")
    @NotNull
    i0<ApiResponse<InRoomBean>> getNewPKToken(@NotNull @Query("groupId") String groupId);

    @GET("/v1/imGroup/recommended")
    @NotNull
    i0<ApiResponse<List<HotGroupBean>>> getNewRecommendGroup();

    @FormUrlEncoded
    @POST("/v2/user/noble/award")
    @NotNull
    i0<ApiResponse<Object>> getNobleAward(@Field("level") int level);

    @GET("/v1/noble/config")
    @NotNull
    i0<ApiResponse<List<NobleBeanConfig>>> getNobleConfig();

    @GET("/v1/openScreen/all")
    @NotNull
    i0<ApiResponse<List<OpenScreenBean>>> getOpenScreenSource();

    @GET("/v1/operationWindow")
    @NotNull
    i0<ApiResponse<OpenScreenBean>> getOperationWindow();

    @GET("/v1/imGroup/ownGroup")
    @NotNull
    i0<ApiResponse<List<HotGroupBean>>> getOwnGroup();

    @POST("/v1/groupPk/box")
    @NotNull
    i0<ApiResponse<BoxGet>> getPKBox();

    @GET("/v1/groupPk/box")
    @NotNull
    i0<ApiResponse<ArrayList<BoxLevel>>> getPKBoxList();

    @GET("/v1/imGroup/task/banner")
    @NotNull
    i0<ApiResponse<List<RoomAndPersonalBannerBean>>> getPersonalAndRoomBanner();

    @FormUrlEncoded
    @POST("/v2/task/award")
    @NotNull
    i0<ApiResponse<Long>> getPersonalAndRoomTaskAward(@Field("taskId") @NotNull String taskId);

    @GET("/v2/task/my")
    @NotNull
    i0<ApiResponse<RoomAndPersonalTaskBean>> getPersonalAndRoomTaskList();

    @GET("/v1/user/photos/{userExternalId}")
    @NotNull
    i0<ApiResponse<List<UserPictureResponseBean>>> getPhotos(@Path("userExternalId") @NotNull String userExternalId);

    @GET("/v2/imGroup/popular")
    @NotNull
    i0<ApiResponse<HotGroupListBean>> getPopularGroup(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/groupPower/team")
    @NotNull
    i0<ApiResponse<PowerTeamMemberBean>> getPowerTeamMember(@Query("groupPowerId") long groupPowerId);

    @GET("/v1/dl/account/tc")
    @NotNull
    i0<ApiResponse<DealerDetailBean>> getPromoteDetail(@Query("level") int level);

    @GET("/v1/property/diamond/list")
    @NotNull
    i0<ApiResponse<List<StoreBean>>> getPropertyList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/imGroup/theirGroup/{userExternalId}")
    @NotNull
    i0<ApiResponse<HasMyGroupListBean>> getPublicGroup(@Path("userExternalId") @NotNull String userExternalId);

    @GET("/v1/game/quickMatch")
    @NotNull
    i0<ApiResponse<GameQuickMatch>> getQuickID(@Query("gameType") int gameType);

    @GET("/v1/billboard/celebrity/{queryType}")
    @NotNull
    i0<ApiResponse<List<CelebrityOrCharmBean>>> getRankCelebrity(@Path("queryType") @NotNull String queryType);

    @GET("/v1/billboard/charm/{queryType}")
    @NotNull
    i0<ApiResponse<List<CelebrityOrCharmBean>>> getRankCharm(@Path("queryType") @NotNull String queryType);

    @GET("/v1/billboard/group/{queryType}")
    @NotNull
    i0<ApiResponse<List<RankGroupBean>>> getRankGroup(@Path("queryType") @NotNull String queryType);

    @GET("/v1/gift/send/user/recent")
    @NotNull
    i0<ApiResponse<MySupportAllBean>> getRecentUserSendGift(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @NotNull @Query("receiveExternalId") String receiveExternalId);

    @GET("/v1/specialRelationCard/diamond/list")
    @NotNull
    i0<ApiResponse<RelationStoreData>> getRelationList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/rocket/{groupId}/detail")
    @NotNull
    i0<ApiResponse<RocketDetailBean>> getRocketRoomDetailData(@Path("groupId") @NotNull String groupId);

    @GET("/v1/rocket/{groupId}/result")
    @NotNull
    i0<ApiResponse<RocketResultListBean>> getRocketRoomResultData(@Path("groupId") @NotNull String groupId);

    @GET("/v1/imGroup/admin/{groupId}")
    @NotNull
    i0<ApiResponse<List<MemberBean>>> getRoomAdminMember(@Path("groupId") @NotNull String groupId);

    @GET("/v1/imGroup/roomBanners")
    @NotNull
    i0<ApiResponse<List<GroupTopBannerBean>>> getRoomBanner();

    @GET("/v1/imGroup/roomInfo/{groupId}")
    @NotNull
    i0<ApiResponse<GroupDetailBean>> getRoomInfo(@Path("groupId") @NotNull String groupId);

    @GET("/v1/luckyWheel/{groupId}")
    @NotNull
    i0<ApiResponse<LuckWheelInfo>> getRoomLuckWheelInfo(@Path("groupId") @NotNull String groupId);

    @GET("/v1/luckyWheel/{groupId}/setting")
    @NotNull
    i0<ApiResponse<LuckyWheelConfig>> getRoomLuckyWheelConfig(@Path("groupId") @NotNull String groupId);

    @GET("/v1/imGroup/medal/room")
    @NotNull
    i0<ApiResponse<List<MedalAllTypeBean>>> getRoomMedalType();

    @GET("/v1/imGroup/online/users/new")
    @NotNull
    i0<ApiResponse<CurrentRoomOnlineBeanList>> getRoomOnlineUser(@NotNull @Query("groupId") String groupId);

    @GET("/v1/rocket/{groupId}")
    @NotNull
    i0<ApiResponse<RocketRoomSmallBean>> getRoomRocketSmallData(@Path("groupId") @NotNull String groupId);

    @GET("/v1/imGroup/role/{groupId}")
    @NotNull
    i0<ApiResponse<List<RoomRuleBean>>> getRoomRole(@Path("groupId") @NotNull String groupId);

    @GET("/v1/fruitMachine/round")
    @NotNull
    i0<ApiResponse<LuckyFruitGameDetailBean>> getRoundFruitMachineDetail(@Query("round") int round);

    @GET("/v1/configuration/sensitive/word")
    @NotNull
    i0<ApiResponse<ArrayList<String>>> getSensitiveWord();

    @FormUrlEncoded
    @POST("/v1/imGroup/support/award/{groupId}")
    @NotNull
    i0<ApiResponse<SupportAwardResponseBean>> getSupportAward(@Path("groupId") @NotNull String groupId, @Field("supporters") @NotNull String supporters);

    @GET("/v1/svip/details")
    @NotNull
    i0<ApiResponse<ApiList<Details>>> getSvipDetail(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v2/svip/info")
    @NotNull
    i0<ApiResponse<SvipInfo>> getSvipInfo();

    @GET("/v1/svip/user")
    @NotNull
    i0<ApiResponse<UserSvip>> getSvipPoint();

    @GET("/v1/groupPower/billboard/owner/week")
    @NotNull
    i0<ApiResponse<List<PowerTop3Bean>>> getTop3PowerWeek(@Query("type") int type);

    @GET("v1/imGroup/country/prior")
    @NotNull
    i0<ApiResponse<List<Country>>> getTop7Country();

    @GET("/v1/user/medal/public/type")
    @NotNull
    i0<ApiResponse<MedalLevelUserHasBeanBody>> getUserHasMedalList(@Query("type") int type);

    @GET("/v1/agora/users")
    @NotNull
    i0<ApiResponse<ArrayList<UserSummaryInfo>>> getUserIdForAgoraId(@NotNull @Query("agoraIds") String agoraIds);

    @GET("/v1/res/gift/column/{column}")
    @NotNull
    i0<ApiResponse<ArrayList<GiftData>>> giftListOfType(@Path("column") int column);

    @GET("/v1/user/giftOperate")
    @NotNull
    i0<ApiResponse<ApiList<GiftRecordData>>> giftRecord(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Query("type") int type);

    @GET("v1/res/gift/shortcut")
    @NotNull
    i0<ApiResponse<GiftShortcutData>> giftShortcut(@Query("giftId") long giftId, @NotNull @Query("groupId") String groupId);

    @GET("/v1/billboard/groupActive/{groupId}/{queryType}")
    @NotNull
    i0<ApiResponse<ArrayList<RoomActiveData>>> groupActive(@Path("groupId") @NotNull String groupId, @Path("queryType") @NotNull String queryType);

    @GET("/v1/imGroup/banner/list")
    @NotNull
    i0<ApiResponse<List<GroupTopBannerBean>>> groupBanner();

    @FormUrlEncoded
    @PUT("/v1/imGroup/blacklist/{groupId}")
    @NotNull
    i0<ApiResponse<String>> groupBlockListAddUser(@Path("groupId") @NotNull String groupId, @Field("externalId") @NotNull String r2, @Field("removeHistory") boolean removeHistory, @Field("blackImei") boolean blackImei);

    @FormUrlEncoded
    @POST("/v1/imGroup/kick")
    @NotNull
    i0<ApiResponse<String>> groupKick(@Field("groupId") @NotNull String groupId, @Field("externalId") @NotNull String r2);

    @FormUrlEncoded
    @POST("/v1/headwear/give")
    @NotNull
    i0<ApiResponse<Object>> headWearSend(@Field("resHeadwearId") long resHeadwearId, @Field("receiveExternal") @NotNull String receiveExternal);

    @FormUrlEncoded
    @POST("/v1/headwear/send")
    @NotNull
    i0<ApiResponse<DiamondBean>> headWearSendOrBuy(@Field("resHeadwearDiamondId") long resHeadwearDiamondId, @Field("receiveExternal") @NotNull String receiveExternal);

    @GET("/api/hello")
    @NotNull
    i0<ApiResponse<Object>> hello();

    @GET("/v1/game/lobby/list2")
    @NotNull
    i0<ApiResponse<ArrayList<GameConfiguration>>> homeGameList();

    @GET("/v1/game/lobby/users")
    @NotNull
    i0<ApiResponse<ApiList<HomeGameUser>>> homeGameUserList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/ytb/playlist/hot")
    @NotNull
    i0<ApiResponse<ArrayList<YouTuBeData>>> hotYouTuList();

    @FormUrlEncoded
    @PUT("/v1/imGroup/in")
    @NotNull
    i0<ApiResponse<InRoomBean>> inRoom(@Field("groupId") @NotNull String groupId, @Field("sceneType") int sceneType, @Field("sceneUid") @NotNull String sceneUid, @Field("password") @NotNull String password, @Field("enterType") int enterType, @Field("gameCode") @NotNull String gameCode, @Field("is1V1") boolean is1V1, @Field("gameMode") int gameMode);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/invite")
    @NotNull
    i0<ApiResponse<Object>> inviteOtherUpMic(@Field("groupUuid") @NotNull String groupId, @Field("beInvitedExternalId") @NotNull String beInvitedUserId);

    @FormUrlEncoded
    @POST("/v1/groupPower/info/set")
    @NotNull
    i0<ApiResponse<FamilyInfo>> inviteSheep(@Field("id") long r1, @Field("icon") @Nullable String r3, @Field("name") @Nullable String name, @Field("nameplate") @Nullable String nameplate, @Field("declaration") @Nullable String declaration, @Field("md5") @Nullable String md5);

    @FormUrlEncoded
    @PUT("/v1/imGroup/permanent/{groupId}")
    @NotNull
    i0<ApiResponse<Integer>> joinGroup(@Path("groupId") @NotNull String groupId, @Field("isInvite") int isInvite);

    @FormUrlEncoded
    @POST("/v1/groupPower/user")
    @NotNull
    i0<ApiResponse<Object>> joinGroupPower(@Field("groupPowerId") long groupPowerId);

    @FormUrlEncoded
    @PUT("/v1/game/sheep/match")
    @NotNull
    i0<ApiResponse<SheepMatchData>> joinMatch(@Field("matchId") int matchId, @Field("lastMatchId") int lastMatchId, @Field("gameId") int r3);

    @FormUrlEncoded
    @POST("/v2/match")
    @NotNull
    i0<ApiResponse<Object>> joinMatch(@Field("conditionSex") int conditionSex, @Field("conditionCountry") @Nullable String conditionCountry);

    @POST("/v1/luckyWheel/{groupId}/seat")
    @NotNull
    i0<ApiResponse<String>> joinRoomLuckyWheel(@Path("groupId") @NotNull String groupId);

    @POST("/v1/user/authorize/window")
    @NotNull
    i0<ApiResponse<FlagBean>> judgeShowNotificationDialog();

    @DELETE("/v1/imGroup/permanent/{groupId}")
    @NotNull
    i0<ApiResponse<Object>> leaveGroup(@Path("groupId") @NotNull String groupId);

    @DELETE("/v1/groupPower/user/{groupPowerId}")
    @NotNull
    i0<ApiResponse<String>> leaveGroupPower(@Path("groupPowerId") long groupPowerId);

    @FormUrlEncoded
    @POST("/v1/imGroup/leave")
    @NotNull
    i0<ApiResponse<String>> leaveRoom(@Field("groupId") @NotNull String groupId);

    @POST("/v1/user/like/{likeUserExternalId}")
    @NotNull
    i0<ApiResponse<LikeResult>> like(@Path("likeUserExternalId") @NotNull String str);

    @FormUrlEncoded
    @POST("/v1/game/lobby/match")
    @NotNull
    i0<ApiResponse<GameLobbyMatch>> lobbyMatch(@Field("gameId") int r1, @Field("mode") int r2);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/lock")
    @NotNull
    i0<ApiResponse<Object>> lockMic(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @FormUrlEncoded
    @POST("/v1/logging/agora")
    @NotNull
    i0<ApiResponse<Object>> loggingAgora(@Field("videoId") @NotNull String videoId, @Field("requestId") @NotNull String requestId);

    @FormUrlEncoded
    @POST("/v1/user/login")
    @NotNull
    i0<ApiResponse<UserResponse>> login(@Field("thirdPartyId") @NotNull String r1, @Field("thirdPartyType") int type, @Field("thirdPartyToken") @NotNull String token, @Field("sex") @Nullable Integer sex, @Field("avatar") @Nullable String avatar, @Field("nick") @Nullable String nickname);

    @FormUrlEncoded
    @POST("/v1/user/login/phone")
    @NotNull
    i0<ApiResponse<UserResponse>> loginPhone(@Field("country") @NotNull String country, @Field("phone") @NotNull String phone, @Field("pwd") @NotNull String pwd);

    @GET("/v1/luckybox/award")
    @NotNull
    i0<ApiResponse<List<RewardLuckyBoxBean>>> luckyBoxAward();

    @GET("/v2/act/popup/recharge/details")
    @NotNull
    i0<ApiResponse<MainActivityData>> mainActivityData(@Nullable @Query("activityPopupId") Long activityPopupId);

    @GET("/v1/game/lobby/match/rolling")
    @NotNull
    i0<ApiResponse<ArrayList<GameBroadcast>>> matchBroadcast();

    @GET("/v2/game/h5/recent")
    @NotNull
    i0<ApiResponse<HomeMatchGameData>> matchGameList();

    @FormUrlEncoded
    @PUT("/v1/match/pic")
    @NotNull
    i0<ApiResponse<Object>> matchPic(@Field("picUrl") @NotNull String picUrl, @Field("matchUniqueId") @NotNull String matchUniqueId);

    @GET("/v1/game/lobby/match/recent")
    @NotNull
    i0<ApiResponse<ApiList<MatchRecent>>> matchRecentList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v2/match/talking/end")
    @NotNull
    i0<ApiResponse<VideoResultData>> matchTalkingEnd(@Field("matchUniqueId") @NotNull String matchUniqueId, @Field("endType") int endType);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/mute")
    @NotNull
    i0<ApiResponse<Object>> muteByIndex(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/speech/close")
    @NotNull
    i0<ApiResponse<Object>> muteMic(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @GET("/v2/cp/my/{queryType}")
    @NotNull
    i0<ApiResponse<CpListData>> myCp(@Path("queryType") @NotNull String queryType);

    @GET("/v1/imGroup/ownGroupId")
    @NotNull
    i0<ApiResponse<String>> myOwnRoom();

    @GET("/v1/specialRelation/myMax/{queryType}")
    @NotNull
    i0<ApiResponse<CpListData>> myRelation(@Path("queryType") @NotNull String queryType);

    @GET("/v1/imGroup/newList")
    @NotNull
    i0<ApiResponse<List<NewRoomBean>>> newRoomList();

    @GET("/v1/user/newList")
    @NotNull
    i0<ApiResponse<List<User>>> newUserList();

    @GET("/v2/user/noble/card")
    @NotNull
    i0<ApiResponse<List<NobleCard>>> nobleCard();

    @GET("/v2/user/noble/card/log")
    @NotNull
    i0<ApiResponse<ApiList<NobleCardLog>>> nobleCardLog(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Query("type") int type);

    @FormUrlEncoded
    @POST("/v1/notRecommend")
    @NotNull
    i0<ApiResponse<Object>> notRecommend(@Field("type") int type, @Field("uniqueKey") @NotNull String uniqueKey, @Field("notRecommend") int notRecommend);

    @FormUrlEncoded
    @POST("/v1/ytb/notRecommend")
    @NotNull
    i0<ApiResponse<Object>> notRecommendVideo(@Field("txGroupId") @NotNull String txGroupId, @Field("videoId") @NotNull String videoId);

    @FormUrlEncoded
    @POST("/v1/luckyBag/open")
    @NotNull
    i0<ApiResponse<EnvelopeData>> openEnvelope(@Field("id") long r1);

    @POST("/v1/luckybox/lottery/one")
    @NotNull
    i0<ApiResponse<LuckyTeenRewardBean>> openOneTimesLuckyBox();

    @POST("/v1/luckybox/lottery/ten")
    @NotNull
    i0<ApiResponse<LuckyTeenRewardBean>> openTeenTimesLuckyBox();

    @GET("/v1/groupPk/1v1/info")
    @NotNull
    i0<ApiResponse<Pk1v1End>> pk1v1(@NotNull @Query("groupId") String groupId);

    @FormUrlEncoded
    @POST("/v1/groupPk/1v1/start")
    @NotNull
    i0<ApiResponse<Object>> pk1v1Start(@Field("extId1") @NotNull String extId1, @Field("extId2") @NotNull String extId2, @Field("minute") int minute, @Field("groupId") @NotNull String groupId);

    @PUT("/v1/luckyWheel/{groupId}/play")
    @NotNull
    i0<ApiResponse<String>> playRoomLuckyWheel(@Path("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("v2/cp/anniversary")
    @NotNull
    i0<ApiResponse<Object>> postCpMemorial(@Field("content") @NotNull String str, @Field("timestamp") long j, @Field("isRemind") boolean z);

    @GET("/v1/gift/privateRecord")
    @NotNull
    i0<ApiResponse<List<PrivateRecordBean>>> privateRecordList(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @FormUrlEncoded
    @PUT("/v1/svip/privilege/openClose")
    @NotNull
    i0<ApiResponse<Object>> privilegeOpen(@Field("type") int type, @Field("openClose") int openClose);

    @FormUrlEncoded
    @POST("/v1/user/global/broadcast/prohibit")
    @NotNull
    i0<ApiResponse<String>> prohibitBroadCastMessage(@Field("globalBroadcastId") long globalBroadcastId, @Field("imageUrl") @NotNull String imageUrl, @Field("reason") @NotNull String reason);

    @GET("/v1/ag/pt/sum/month")
    @NotNull
    i0<ApiResponse<PromoteMonth>> promoteMonth();

    @GET("/v1/ag/pt/sum/range")
    @NotNull
    i0<ApiResponse<PromoteRankData>> promoteRange(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate);

    @GET("/v1/ag/pt/detail/rank")
    @NotNull
    i0<ApiResponse<ApiList<PromoteRank>>> promoteRank(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v1/property/give")
    @NotNull
    i0<ApiResponse<Object>> propertySend(@Field("resPropertyId") long resPropertyId, @Field("receiveExternal") @NotNull String receiveExternal);

    @FormUrlEncoded
    @POST("/v1/property/send")
    @NotNull
    i0<ApiResponse<DiamondBean>> propertySendOrBuy(@Field("resPropertyDiamondId") long resPropertyDiamondId, @Field("receiveExternal") @NotNull String receiveExternal);

    @FormUrlEncoded
    @POST("/v1/groupPower/quit")
    @NotNull
    i0<ApiResponse<Object>> quitFamily(@Field("userExtId") @NotNull String userExtId, @Field("type") int type);

    @FormUrlEncoded
    @PUT("/v1/read/has")
    @NotNull
    i0<ApiResponse<Object>> readHas(@Field("userExternalId") @NotNull String userExternalId, @Field("readType") int readType);

    @GET("/v1/user/realCertification")
    @NotNull
    i0<ApiResponse<RealCertificationResult>> realCertification();

    @FormUrlEncoded
    @POST("/v1/user/realCertification")
    @NotNull
    i0<ApiResponse<Object>> realCertification(@Field("videoUrl") @NotNull String videoUrl);

    @FormUrlEncoded
    @POST("/v1/svip/taskAward/receive")
    @NotNull
    i0<ApiResponse<Object>> receiveSvipTaskAward(@Field("taskId") long taskId);

    @GET("/v1/recommend/user/gift")
    @NotNull
    i0<ApiResponse<ArrayList<HiloPlanetsData>>> recommendList();

    @GET("/v1/user/timToken")
    @NotNull
    i0<ApiResponse<String>> refreshTIMToken();

    @FormUrlEncoded
    @PUT("/v2/match/refuse")
    @NotNull
    i0<ApiResponse<Object>> rejectInvite(@Field("matchUniqueId") @NotNull String matchUniqueId, @Field("otherUserExternalId") @NotNull String otherUserExternalId, @Field("type") int type, @Header("from") int from);

    @GET("/v1/specialRelation/backgroundCard")
    @NotNull
    i0<ApiResponse<RelationUserData>> relationBack(@NotNull @Query("externalId") String r1);

    @GET("/v1/specialRelation/rank/{queryType}")
    @NotNull
    i0<ApiResponse<ApiList<CpListData>>> relationRankList(@Path("queryType") @NotNull String queryType, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v1/specialRelation/cancel/reply")
    @NotNull
    i0<ApiResponse<Object>> relationReply(@Field("externalId") @NotNull String r1, @Field("type") int type, @Field("relationType") int r3);

    @GET("/v1/specialRelation/space")
    @NotNull
    i0<ApiResponse<CpSpace>> relationSpace(@NotNull @Query("externalId1") String r1, @NotNull @Query("externalId2") String r2, @Query("relationType") int r3);

    @DELETE("/v1/imGroup/blacklist/{groupId}")
    @NotNull
    i0<ApiResponse<String>> removeGroupBlockById(@Path("groupId") @NotNull String groupId, @NotNull @Query("externalId") String r2);

    @FormUrlEncoded
    @POST("/v1/group/activity/report")
    @NotNull
    i0<ApiResponse<Object>> reportActivity(@Field("activityId") @NotNull String r1, @Field("type") int type, @Field("reason") @NotNull String reason);

    @FormUrlEncoded
    @POST("/v1/imGroup/report")
    @NotNull
    i0<ApiResponse<String>> reportGroup(@Field("groupId") @NotNull String groupId, @Field("reasonType") int reasonType, @Field("imageUrl") @Nullable String image, @Field("reason") @Nullable String reason, @Field("isBlock") boolean isBlock, @Field("isPK") boolean isPK);

    @FormUrlEncoded
    @POST("/v1/game/report")
    @NotNull
    i0<ApiResponse<BeanBaseBean>> reportSud(@Field("gameId") long r1, @Field("opt") int opt, @Field("gameCode") @NotNull String gameCode, @Field("groupId") @NotNull String groupId);

    @DELETE("/v1/group/activity/cover/{id}")
    @NotNull
    i0<ApiResponse<Object>> resetActivity(@Path("id") @NotNull String r1);

    @FormUrlEncoded
    @PUT("/v1/imGroup/info/reset")
    @NotNull
    i0<ApiResponse<Object>> resetRoomInfo(@Field("externalId") @NotNull String r1);

    @FormUrlEncoded
    @PUT("/v1/user/info/reset")
    @NotNull
    i0<ApiResponse<Object>> resetUserInfo(@Field("externalId") @NotNull String r1);

    @GET("/v1/groupPk/list")
    @NotNull
    i0<ApiResponse<ApiList<RoomCurrentPK>>> roomCurrentPK(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v1/imGroup/mgr/mass")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> roomPostBroadcast(@Field("groupId") @NotNull String groupId, @Field("content") @NotNull String content);

    @GET("/v1/imGroup/room/action")
    @NotNull
    i0<ApiResponse<ApiList<RoomRecordData>>> roomRecord(@NotNull @Query("groupId") String groupId, @Query("type") int type, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @POST("/v1/imGroup/mic/music")
    @NotNull
    i0<ApiResponse<Object>> roomStartMusic();

    @POST("/v1/imGroup/mic/unmusic")
    @NotNull
    i0<ApiResponse<Object>> roomStopMusic();

    @GET("/v2/user/detail/room")
    @NotNull
    i0<ApiResponse<User>> roomUserInfo(@NotNull @Query("userExternalId") String userExternalId, @NotNull @Query("groupId") String groupId);

    @GET("/v1/ytb/playlist/group")
    @NotNull
    i0<ApiResponse<ApiList<YouTuBeData>>> roomYouTuList(@NotNull @Query("groupId") String groupId, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/user/search")
    @NotNull
    i0<ApiResponse<ContactsLikeEachItem>> searchFriends(@NotNull @Query("userCode") String userCode, @Query("type") int type);

    @GET("/v1/imGroup/search/{code}")
    @NotNull
    i0<ApiResponse<SearchGroupListBean>> searchGroup(@Path("code") @NotNull String r1);

    @GET("/v2/dl/diamond/shift")
    @NotNull
    i0<ApiResponse<ApiList<TransferRecordData>>> secondDiamondDetail(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @GET("/v1/ag/s/sum/range/2")
    @NotNull
    i0<ApiResponse<SecondMonth>> secondRange(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate);

    @GET("/v1/ag/s/detail/rank/2")
    @NotNull
    i0<ApiResponse<ApiList<SecondRank>>> secondRank(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("/v1/dl/diamond/shift")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> secondShift(@Field("externalId") @NotNull String r1, @Field("resId") int resId);

    @FormUrlEncoded
    @POST("/v1/user/bag/send")
    @NotNull
    i0<ApiResponse<GiftData>> sendBagGift(@Field("toUserExternalId") @Nullable String toUserExternalId, @Field("groupId") @Nullable String groupId, @Field("resGiftId") long resGiftId, @Field("giftN") int giftN, @Field("sceneType") int sceneType, @Field("sceneUid") @NotNull String sceneUid, @Field("bagId") @Nullable Long bagId, @Field("sendType") int sendType, @Field("giftText") @Nullable String giftText, @Field("maskGroupId") @Nullable String maskGroupId);

    @FormUrlEncoded
    @POST("/v1/dl/diamond")
    @NotNull
    i0<ApiResponse<Object>> sendDiamondToUser(@Field("externalId") @NotNull String r1, @Field("resId") int resId, @Field("isPink") int isPink);

    @FormUrlEncoded
    @POST("/v1/luckyBag/send")
    @NotNull
    i0<ApiResponse<RefreshDiamond>> sendEnvelope(@Field("type") long type, @Field("diamond") long r3, @Field("num") long num);

    @FormUrlEncoded
    @POST("/v1/gift")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> sendGift(@Field("toUserExternalId") @NotNull String toUID, @Field("resGiftId") long giftID, @Field("sceneType") int sceneType, @Field("sceneUid") @NotNull String sceneUid, @Field("giftN") int giftN, @Field("giftText") @Nullable String giftText);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/gift")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> sendGiftToMicAllMember(@Field("groupId") @NotNull String groupId, @Field("resGiftId") long giftID, @Field("giftN") int giftN, @Field("giftText") @Nullable String giftText);

    @FormUrlEncoded
    @POST("/v1/imGroup/room/gift")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> sendGiftToRoomAllMember(@Field("groupId") @NotNull String groupId, @Field("resGiftId") long giftID, @Field("giftN") int giftN, @Field("giftText") @Nullable String giftText);

    @FormUrlEncoded
    @POST("/v1/user/global/broadcast")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> sendGlobalBroadCast(@Field("msg") @NotNull String msg, @Field("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/emoji/msg")
    @NotNull
    i0<ApiResponse<String>> sendMicEmoji(@Field("groupId") @NotNull String groupId, @Field("micEmojiId") long micEmojiId);

    @FormUrlEncoded
    @POST("/v1/noble/buy")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> sendNoble(@Field("level") int level, @Field("targetExtId") @NotNull String targetExtId);

    @FormUrlEncoded
    @POST("/v2/user/noble/card/send")
    @NotNull
    i0<ApiResponse<Object>> sendNobleCard(@Field("id") int r1, @Field("externalId") @NotNull String r2);

    @FormUrlEncoded
    @POST("/third/imei/self")
    @NotNull
    i0<ApiResponse<String>> serviceDeviceID(@Field("deviceToken") @NotNull String deviceToken);

    @FormUrlEncoded
    @POST("/v1/groupPower/admin")
    @NotNull
    i0<ApiResponse<Object>> setFamilyAdmin(@Field("userExtId") @NotNull String userExtId, @Field("type") int type);

    @FormUrlEncoded
    @POST("/v1/fruitMachine/")
    @NotNull
    i0<ApiResponse<LuckyFruitBetBean>> setFruitMachineBet(@Field("fruitId") int fruitId, @Field("amount") int amount);

    @FormUrlEncoded
    @POST("/v1/headwear/using")
    @NotNull
    i0<ApiResponse<String>> setHeadWearUsing(@Field("resHeadwearId") long resHeadwearId);

    @FormUrlEncoded
    @PUT("/v1/user/medal/sort")
    @NotNull
    i0<ApiResponse<User>> setMedalSort(@Field("pos") int pos, @Field("medalId") int medalId);

    @FormUrlEncoded
    @POST("/v1/user/photos")
    @NotNull
    i0<ApiResponse<Object>> setPhotos(@Field("photos") @NotNull String photos, @Field("md5") @Nullable String md5);

    @FormUrlEncoded
    @POST("/v1/property/using")
    @NotNull
    i0<ApiResponse<String>> setPropertyUsing(@Field("resPropertyId") long resPropertyId);

    @FormUrlEncoded
    @PUT("/v1/imGroup/role/{groupId}")
    @NotNull
    i0<ApiResponse<String>> setRoomUserRole(@Path("groupId") @NotNull String groupId, @Field("role") int role, @Field("externalId") @NotNull String r3);

    @FormUrlEncoded
    @POST("/v1/user/share/contacts")
    @NotNull
    i0<ApiResponse<String>> shareRoomToContacts(@Field("groupId") @NotNull String groupId, @Field("selectAll") boolean selectAll, @Field("extIds") @NotNull String extIds);

    @FormUrlEncoded
    @POST("/v1/user/share/likeMe")
    @NotNull
    i0<ApiResponse<String>> shareRoomToLikeMe(@Field("groupId") @NotNull String groupId, @Field("selectAll") boolean selectAll, @Field("extIds") @NotNull String extIds);

    @GET("/v2/act/popup/showAllList")
    @NotNull
    i0<ApiResponse<List<MainListData>>> showAllList();

    @FormUrlEncoded
    @POST("/v1/specialRelation/relation")
    @NotNull
    i0<ApiResponse<Object>> specialRelation(@Field("externalId") @NotNull String r1, @Field("type") int type, @Field("relationType") int r3);

    @FormUrlEncoded
    @POST("/v1/mask/match/start")
    @NotNull
    i0<ApiResponse<Object>> starStrangeMatch(@Field("nick") @NotNull String nick, @Field("avatar") @NotNull String avatar);

    @FormUrlEncoded
    @POST("/v1/ytb/start")
    @NotNull
    i0<ApiResponse<Object>> startYouTuBe(@Field("groupId") @NotNull String groupId);

    @GET("/v1/gameSkin")
    @NotNull
    i0<ApiResponse<CustomData<StoreCarromData>>> storeCarromSkin(@Query("gameId") int r1, @Query("type") int type);

    @FormUrlEncoded
    @POST("/v1/mask/chat/list")
    @NotNull
    i0<ApiResponse<ArrayList<StrangeUserData>>> strangeChatList(@Field("groupIds") @NotNull String groupIds);

    @POST("/v1/mask/info/change")
    @NotNull
    i0<ApiResponse<StrangeConfirm>> strangeConfirmChange();

    @GET("/v1/group/activity/subscribe")
    @NotNull
    i0<ApiResponse<List<User>>> subscribeList(@Query("type") int type, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex, @NotNull @Query("activityId") String r4);

    @FormUrlEncoded
    @POST("/v1/vip/subscribe/google")
    @NotNull
    i0<ApiResponse<Long>> subscribeVip(@Field("packageName") @NotNull String r1, @Field("subscriptionID") @NotNull String subscriptionID, @Field("purchaseToken") @NotNull String purchaseToken, @Field("orderId") @Nullable String purchaseOrderId);

    @POST("/v1/game/code")
    @NotNull
    i0<ApiResponse<LudoCode>> sudCode();

    @FormUrlEncoded
    @POST("/v1/user/mgr/lock")
    @NotNull
    i0<ApiResponse<Object>> superAdminReport(@Field("toUserExternalId") @NotNull String toUserExternalId, @Field("reasonType") int reasonType, @Field("reason") @NotNull String reason, @Field("imageUrl") @NotNull String imageUrl, @Field("hours") @Nullable Integer hours);

    @FormUrlEncoded
    @POST("/v1/super/like")
    @NotNull
    i0<ApiResponse<Double>> superLike(@Field("extId") @NotNull String extId);

    @GET("/v1/super/like")
    @NotNull
    i0<ApiResponse<ApiList<SuperLikeData>>> superLikeList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/groupPk/support/rank")
    @NotNull
    i0<ApiResponse<ApiList<RoomPKUser>>> supportRank(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @NotNull @Query("groupId") String groupId);

    @FormUrlEncoded
    @POST("/v1/user/mgr/unlock")
    @NotNull
    i0<ApiResponse<String>> svipUnblock(@Field("toUserExternalId") @NotNull String toUserExternalId);

    @GET("/v1/game/gem/task/list")
    @NotNull
    i0<ApiResponse<ArrayList<GameConfiguration>>> taskGameList();

    @GET("/v1/game/gem/task/sign")
    @NotNull
    i0<ApiResponse<GoldTaskData>> taskSign();

    @FormUrlEncoded
    @POST("/v1/game/gem/task/sign")
    @NotNull
    i0<ApiResponse<RefreshMoney>> taskSign(@Field("level") int level);

    @GET("/api/test/privilege/vip")
    @NotNull
    i0<ApiResponse<User>> testPurchasePrivilege(@NotNull @Query("id") String uid);

    @FormUrlEncoded
    @POST("/third/imei")
    @NotNull
    i0<ApiResponse<String>> thirdIMEI(@Field("deviceToken") @NotNull String deviceToken);

    @FormUrlEncoded
    @PUT("/v1/game/dice")
    @NotNull
    i0<ApiResponse<String>> toGameDice(@Field("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @PUT("/v1/user/tradeUnion/notification")
    @NotNull
    i0<ApiResponse<Object>> tradeUnionNotification(@Field("isNotification") int isNotification);

    @GET("/v1/ag/banners")
    @NotNull
    i0<ApiResponse<ArrayList<TransferBanner>>> transferBanners(@Nullable @Query("isG") Integer isG);

    @GET("/v2/dl/diamond")
    @NotNull
    i0<ApiResponse<ApiList<TransferRecordData>>> transferDiamondDetail(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex, @Query("isPink") int isPink);

    @GET("/v1/ag/s/sum/month")
    @NotNull
    i0<ApiResponse<TransferMonth>> transferMonth(@Nullable @Query("isG") Integer isG);

    @GET("/v1/ag/period")
    @NotNull
    i0<ApiResponse<TransferPeriod>> transferPeriod();

    @GET("/v1/ag/s/sum/range")
    @NotNull
    i0<ApiResponse<TransferMonth>> transferRange(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate, @Nullable @Query("isG") Integer isG);

    @GET("/v1/ag/s/detail/rank")
    @NotNull
    i0<ApiResponse<ApiList<TransferRank>>> transferRank(@NotNull @Query("beginDate") String beginDate, @NotNull @Query("endDate") String endDate, @Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Nullable @Query("isG") Integer isG);

    @GET("/v1/ag/user/search")
    @NotNull
    i0<ApiResponse<User>> transferSearchUser(@NotNull @Query("code") String r1);

    @GET("/v1/ag/c/recently")
    @NotNull
    i0<ApiList<User>> transferUserList();

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/unmute")
    @NotNull
    i0<ApiResponse<Object>> unMuteByIndex(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/speech/open")
    @NotNull
    i0<ApiResponse<Object>> unMuteMic(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @DELETE("/v1/user/block/{blockUserExternalId}")
    @NotNull
    i0<ApiResponse<Object>> unblockUser(@Path("blockUserExternalId") @NotNull String r1);

    @DELETE("/v1/user/like/{likeUserExternalId}")
    @NotNull
    i0<ApiResponse<LikeResult>> unlike(@Path("likeUserExternalId") @NotNull String toUID);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/unlock")
    @NotNull
    i0<ApiResponse<Object>> unlockMic(@Field("groupUuid") @NotNull String groupId, @Field("i") int micIndex);

    @FormUrlEncoded
    @POST("/v1/imGroup/mic/in")
    @NotNull
    i0<ApiResponse<Object>> upMic(@Field("groupUuid") @NotNull String groupId, @Field("i") @Nullable Integer micIndex);

    @FormUrlEncoded
    @PUT("/v2/cp/anniversary/{id}")
    @NotNull
    i0<ApiResponse<Object>> updateCpMemorial(@Path("id") int i, @Field("content") @NotNull String str, @Field("timestamp") long j, @Field("isRemind") boolean z);

    @FormUrlEncoded
    @PUT("/v1/imGroup/group/{groupId}")
    @NotNull
    i0<ApiResponse<String>> updateGroupInfo(@Path("groupId") @NotNull String groupId, @Field("name") @Nullable String name, @Field("introduction") @Nullable String introduction, @Field("notification") @Nullable String notification, @Field("faceUrl") @Nullable String r5, @Field("password") @Nullable String password, @Field("loadHistory") @Nullable Boolean loadHistory, @Field("welcomeText") @Nullable String welcomeText, @Field("themeId") @Nullable Integer themeId, @Field("diceNum") @Nullable Integer diceNum, @Field("touristMic") @Nullable Integer r11, @Field("touristSendMsg") @Nullable Integer r12, @Field("touristSendPic") @Nullable Integer r13, @Field("isChangeFee") @Nullable Integer r14, @Field("memberFee") @Nullable Integer memberFee, @Field("diceType") @Nullable Integer diceType, @Field("md5") @Nullable String md5);

    @FormUrlEncoded
    @PUT("/v1/user/info")
    @NotNull
    i0<ApiResponse<UserSummaryInfo>> updateUserInfo(@Field("avatar") @Nullable String avatar, @Field("nick") @Nullable String name, @Field("country") @Nullable String country, @Field("description") @Nullable String description, @Field("isShowAge") @Nullable Integer isShowAge, @Field("sex") @Nullable Integer sex);

    @FormUrlEncoded
    @POST("/v1/configuration/uploadGift/upload")
    @NotNull
    i0<ApiResponse<Object>> uploadGift(@Field("effectUrl") @NotNull String effectUrl, @Field("iconUrl") @NotNull String iconUrl);

    @FormUrlEncoded
    @POST("/v1/imGroup/theme/custom")
    @NotNull
    i0<ApiResponse<UploadCustomThemeBean>> uploadThemeCustom(@Field("picUrl") @NotNull String picUrl, @Field("groupId") @NotNull String groupId, @Field("md5") @NotNull String md5);

    @FormUrlEncoded
    @POST("/v2/user/fcm")
    @NotNull
    i0<ApiResponse<Object>> uploadToken(@Field("token") @NotNull String token);

    @FormUrlEncoded
    @POST("/v1/gameSkin/using")
    @NotNull
    i0<ApiResponse<Object>> useCarromSkin(@Field("resId") long resId, @Field("bagId") long bagId);

    @FormUrlEncoded
    @POST("/v2/user/noble/card")
    @NotNull
    i0<ApiResponse<NobleUse>> useNobleCard(@Field("id") int r1);

    @FormUrlEncoded
    @POST("/v1/user/app/language")
    @NotNull
    i0<ApiResponse<Object>> userAppLanguage(@Field("language") @NotNull String language);

    @FormUrlEncoded
    @POST("/v1/session")
    @NotNull
    i0<ApiResponse<SurplusDiamonds>> userCostMessage(@Field("otherExternalId") @NotNull String toUID, @Field("type") int type, @Field("orginType") int orginType, @Field("orginId") int orginId);

    @POST("/v1/logout")
    @NotNull
    i0<ApiResponse<DeleteAccountSuccessBean>> userDeleteAccount();

    @GET("/v1/logout/condition")
    @NotNull
    i0<ApiResponse<DeleteAccountConditionBean>> userDeleteAccountCondition();

    @GET("/v1/diamond/detail")
    @NotNull
    i0<ApiResponse<List<UserCostDiamondsDetail>>> userDiamondsDetail(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize, @Query("getType") int getType);

    @GET("/v1/read/like/each/list")
    @NotNull
    i0<ApiResponse<List<UserLikeEachItem>>> userLikeEachList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @FormUrlEncoded
    @PUT("/v1/user/msg/push")
    @NotNull
    i0<ApiResponse<Object>> userMsgPush(@Field("isPush") int isPush);

    @POST("/v1/user/recall/window")
    @NotNull
    i0<ApiResponse<Object>> userRecallWindow();

    @FormUrlEncoded
    @POST("/v1/user/visit")
    @NotNull
    i0<ApiResponse<Object>> userVisit(@Field("userExternalId") @NotNull String userExternalId);

    @FormUrlEncoded
    @PUT("/v1/imGroup/theme/custom/using")
    @NotNull
    i0<ApiResponse<String>> usingCustomTheme(@Field("groupCustomThemeId") int groupCustomThemeId, @Field("groupId") @NotNull String groupId);

    @FormUrlEncoded
    @POST("/v2/video/call/ready")
    @NotNull
    i0<ApiResponse<Object>> videoCallReady(@Field("videoUniquId") @NotNull String matchUniqueId);

    @FormUrlEncoded
    @POST("/v2/video/end")
    @NotNull
    i0<ApiResponse<VideoResultData>> videoEnd(@Field("videoUid") @NotNull String videoUid);

    @GET("/v1/video/free/check")
    @NotNull
    i0<ApiResponse<VideoFreeCheck>> videoFreeCheck();

    @GET("/v2/user/goddess/list")
    @NotNull
    i0<ApiResponse<ApiList<VideoBaseData>>> videoGoddessList(@Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("/v2/video/inter/act")
    @NotNull
    i0<ApiResponse<Object>> videoInter(@Field("type") int type, @Field("num") int num, @Field("videoUid") @Nullable String videoUid, @Field("matchUid") @Nullable String matchUid);

    @GET("/v2/match/history")
    @NotNull
    i0<ApiResponse<List<VideoBaseData>>> videoMatchingHistory(@NotNull @Query("type") String type, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("/v2/video/minute/send")
    @NotNull
    i0<ApiResponse<AgoraVideoCallParams>> videoMinuteSend(@Field("userExternalId") @NotNull String specifyUserExternalId);

    @GET("/v2/match/video/miss/num")
    @NotNull
    i0<ApiResponse<MissData>> videoMissNum();

    @FormUrlEncoded
    @POST("/v2/video/receive")
    @NotNull
    i0<ApiResponse<Object>> videoReceive(@Field("videoUid") @NotNull String matchUniqueId);

    @FormUrlEncoded
    @POST("/v2/video/refuse")
    @NotNull
    i0<ApiResponse<Object>> videoRefuse(@Field("videoUid") @NotNull String videoUid);

    @FormUrlEncoded
    @PUT("/v2/video/setting")
    @NotNull
    i0<ApiResponse<VideoSetting>> videoSetting(@Field("frontOrBack") int frontOrBack, @Field("cameraOnOff") int cameraOnOff, @Field("videoUid") @Nullable String videoUid, @Field("matchUid") @Nullable String matchUid);

    @POST("/v1/user/vip/daily/diamond")
    @NotNull
    i0<ApiResponse<VipDailyDiamondBean>> vipDailyDiamond();

    @GET("/v1/ytb/groups")
    @NotNull
    i0<ApiResponse<ApiList<WatchYouTuListData>>> watchYouTuList(@Query("pageIndex") int pageIndex, @Query("pageSize") int pageSize);

    @GET("/v1/ytb/process")
    @NotNull
    i0<ApiResponse<YouTuGameData>> youTuBeProcess(@NotNull @Query("groupId") String groupId);
}
