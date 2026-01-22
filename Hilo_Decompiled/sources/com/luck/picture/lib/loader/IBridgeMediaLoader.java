package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class IBridgeMediaLoader {
    protected static final String COLUMN_COUNT = "count";
    protected static final String DISTINCT_BUCKET_Id = "DISTINCT bucket_id";
    protected static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    protected static final int MAX_SORT_SIZE = 60;
    protected static final String NOT_BMP = " AND (mime_type!='image/bmp')";
    protected static final String NOT_GIF = " AND (mime_type!='image/gif')";
    protected static final String NOT_HEIC = " AND (mime_type!='image/heic')";
    protected static final String NOT_VND_WAP_BMP = " AND (mime_type!='image/vnd.wap.wbmp')";
    protected static final String NOT_WEBP = " AND (mime_type!='image/webp')";
    protected static final String NOT_XMS_BMP = " AND (mime_type!='image/x-ms-bmp')";
    protected static final String ORDER_BY = "date_modified DESC";
    protected static final String TAG = "IBridgeMediaLoader";
    protected final SelectorConfig mConfig;
    private final Context mContext;
    protected static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    protected static final String COLUMN_DURATION = "duration";
    protected static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    protected static final String COLUMN_BUCKET_ID = "bucket_id";
    protected static final String COLUMN_ORIENTATION = "orientation";
    protected static final String[] PROJECTION = {TransferTable.COLUMN_ID, "_data", "mime_type", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, COLUMN_DURATION, "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", COLUMN_ORIENTATION};
    protected static final String[] ALL_PROJECTION = {TransferTable.COLUMN_ID, "_data", "mime_type", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, COLUMN_DURATION, "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", COLUMN_ORIENTATION, "COUNT(*) AS count"};

    public IBridgeMediaLoader(Context context, SelectorConfig selectorConfig) {
        this.mContext = context;
        this.mConfig = selectorConfig;
    }

    public abstract String getAlbumFirstCover(long j10);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAudioMimeTypeCondition() {
        String str;
        List<String> list = getConfig().queryOnlyAudioList;
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str2 = list.get(i10);
            if (i10 == 0) {
                str = " AND ";
            } else {
                str = " OR ";
            }
            sb.append(str);
            sb.append("mime_type");
            sb.append("='");
            sb.append(str2);
            sb.append("'");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SelectorConfig getConfig() {
        return this.mConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDurationCondition() {
        long j10;
        if (getConfig().filterVideoMaxSecond == 0) {
            j10 = LongCompanionObject.MAX_VALUE;
        } else {
            j10 = getConfig().filterVideoMaxSecond;
        }
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(0L, getConfig().filterVideoMinSecond)), "=", Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFileSizeCondition() {
        long j10;
        if (getConfig().filterMaxFileSize == 0) {
            j10 = LongCompanionObject.MAX_VALUE;
        } else {
            j10 = getConfig().filterMaxFileSize;
        }
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", Long.valueOf(Math.max(0L, getConfig().filterMinFileSize)), "=", Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getImageMimeTypeCondition() {
        String str;
        List<String> list = getConfig().queryOnlyImageList;
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str2 = list.get(i10);
            if (i10 == 0) {
                str = " AND ";
            } else {
                str = " OR ";
            }
            sb.append(str);
            sb.append("mime_type");
            sb.append("='");
            sb.append(str2);
            sb.append("'");
        }
        if (!getConfig().isGif && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofGIF())) {
            sb.append(NOT_GIF);
        }
        if (!getConfig().isWebp && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofWEBP())) {
            sb.append(NOT_WEBP);
        }
        if (!getConfig().isBmp && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofBMP()) && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofXmsBMP()) && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofWapBMP())) {
            sb.append(NOT_BMP);
            sb.append(NOT_XMS_BMP);
            sb.append(NOT_VND_WAP_BMP);
        }
        if (!getConfig().isHeic && !getConfig().queryOnlyImageList.contains(PictureMimeType.ofHeic())) {
            sb.append(NOT_HEIC);
        }
        return sb.toString();
    }

    protected abstract String getSelection();

    protected abstract String[] getSelectionArgs();

    protected abstract String getSortOrder();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getVideoMimeTypeCondition() {
        String str;
        List<String> list = getConfig().queryOnlyVideoList;
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str2 = list.get(i10);
            if (i10 == 0) {
                str = " AND ";
            } else {
                str = " OR ";
            }
            sb.append(str);
            sb.append("mime_type");
            sb.append("='");
            sb.append(str2);
            sb.append("'");
        }
        return sb.toString();
    }

    public abstract void loadAllAlbum(OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener);

    public abstract void loadOnlyInAppDirAllMedia(OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener);

    public abstract void loadPageMediaData(long j10, int i10, int i11, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener);

    protected abstract LocalMedia parseLocalMedia(Cursor cursor, boolean z10);
}
