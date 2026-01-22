package com.luck.picture.lib.loader;

import android.content.Context;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.luck.picture.lib.utils.ValueOf;
import java.io.File;
import java.io.FileFilter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SandboxFileLoader {
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017b, code lost:
    
        if (r2 < r5) goto L٨٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0187, code lost:
    
        if (r2 > r5) goto L٨٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x018e, code lost:
    
        if (r2 != 0) goto L٩٢;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<LocalMedia> loadInAppSandboxFile(Context context, String str) {
        MessageDigest messageDigest;
        List<String> list;
        List<String> list2;
        long lastModified;
        int i10;
        int i11;
        MessageDigest messageDigest2;
        int i12;
        int i13;
        long j10;
        long j11;
        int width;
        int height;
        long duration;
        File[] fileArr;
        int i14;
        long j12;
        int i15;
        ArrayList<LocalMedia> arrayList;
        List<String> list3;
        Context context2 = context;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<LocalMedia> arrayList2 = new ArrayList<>();
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.luck.picture.lib.loader.SandboxFileLoader.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return !file2.isDirectory();
                }
            });
            if (listFiles == null) {
                return arrayList2;
            }
            SelectorConfig selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e10) {
                e10.printStackTrace();
                messageDigest = null;
            }
            int length = listFiles.length;
            int i16 = 0;
            while (i16 < length) {
                File file2 = listFiles[i16];
                String mimeTypeFromMediaUrl = MediaUtils.getMimeTypeFromMediaUrl(file2.getAbsolutePath());
                if (selectorConfig.chooseMode != SelectMimeType.ofImage() ? selectorConfig.chooseMode != SelectMimeType.ofVideo() ? selectorConfig.chooseMode != SelectMimeType.ofAudio() || (PictureMimeType.isHasAudio(mimeTypeFromMediaUrl) && ((list = selectorConfig.queryOnlyAudioList) == null || list.size() <= 0 || selectorConfig.queryOnlyAudioList.contains(mimeTypeFromMediaUrl))) : PictureMimeType.isHasVideo(mimeTypeFromMediaUrl) && ((list2 = selectorConfig.queryOnlyVideoList) == null || list2.size() <= 0 || selectorConfig.queryOnlyVideoList.contains(mimeTypeFromMediaUrl)) : PictureMimeType.isHasImage(mimeTypeFromMediaUrl) && ((list3 = selectorConfig.queryOnlyImageList) == null || list3.size() <= 0 || selectorConfig.queryOnlyImageList.contains(mimeTypeFromMediaUrl))) {
                    if (selectorConfig.isGif || !PictureMimeType.isHasGif(mimeTypeFromMediaUrl)) {
                        String absolutePath = file2.getAbsolutePath();
                        long length2 = file2.length();
                        if (length2 > 0) {
                            if (messageDigest != null) {
                                messageDigest.update(absolutePath.getBytes());
                                lastModified = new BigInteger(1, messageDigest.digest()).longValue();
                            } else {
                                lastModified = file2.lastModified() / 1000;
                            }
                            i10 = length;
                            i11 = i16;
                            long j13 = ValueOf.toLong(Integer.valueOf(file.getName().hashCode()));
                            ArrayList<LocalMedia> arrayList3 = arrayList2;
                            long lastModified2 = file2.lastModified() / 1000;
                            if (PictureMimeType.isHasVideo(mimeTypeFromMediaUrl)) {
                                MediaExtraInfo videoSize = MediaUtils.getVideoSize(context2, absolutePath);
                                width = videoSize.getWidth();
                                height = videoSize.getHeight();
                                duration = videoSize.getDuration();
                            } else if (PictureMimeType.isHasAudio(mimeTypeFromMediaUrl)) {
                                MediaExtraInfo audioSize = MediaUtils.getAudioSize(context2, absolutePath);
                                width = audioSize.getWidth();
                                height = audioSize.getHeight();
                                duration = audioSize.getDuration();
                            } else {
                                MediaExtraInfo imageSize = MediaUtils.getImageSize(context2, absolutePath);
                                int width2 = imageSize.getWidth();
                                int height2 = imageSize.getHeight();
                                messageDigest2 = messageDigest;
                                i12 = width2;
                                i13 = height2;
                                j10 = lastModified2;
                                j11 = 0;
                                if (!PictureMimeType.isHasVideo(mimeTypeFromMediaUrl) || PictureMimeType.isHasAudio(mimeTypeFromMediaUrl)) {
                                    fileArr = listFiles;
                                    i14 = selectorConfig.filterVideoMinSecond;
                                    j12 = j13;
                                    if (i14 > 0) {
                                    }
                                    i15 = selectorConfig.filterVideoMaxSecond;
                                    if (i15 > 0) {
                                    }
                                } else {
                                    fileArr = listFiles;
                                    j12 = j13;
                                }
                                LocalMedia create = LocalMedia.create();
                                create.setId(lastModified);
                                create.setPath(absolutePath);
                                create.setRealPath(absolutePath);
                                create.setFileName(file2.getName());
                                create.setParentFolderName(file.getName());
                                create.setDuration(j11);
                                create.setChooseModel(selectorConfig.chooseMode);
                                create.setMimeType(mimeTypeFromMediaUrl);
                                create.setWidth(i12);
                                create.setHeight(i13);
                                create.setSize(length2);
                                create.setBucketId(j12);
                                create.setDateAddedTime(j10);
                                OnQueryFilterListener onQueryFilterListener = selectorConfig.onQueryFilterListener;
                                if (onQueryFilterListener == null || !onQueryFilterListener.onFilter(create)) {
                                    if (!SdkVersionUtils.isQ()) {
                                        absolutePath = null;
                                    }
                                    create.setSandboxPath(absolutePath);
                                    arrayList = arrayList3;
                                    arrayList.add(create);
                                    i16 = i11 + 1;
                                    length = i10;
                                    arrayList2 = arrayList;
                                    messageDigest = messageDigest2;
                                    listFiles = fileArr;
                                    context2 = context;
                                }
                                arrayList = arrayList3;
                                i16 = i11 + 1;
                                length = i10;
                                arrayList2 = arrayList;
                                messageDigest = messageDigest2;
                                listFiles = fileArr;
                                context2 = context;
                            }
                            messageDigest2 = messageDigest;
                            i12 = width;
                            i13 = height;
                            j10 = lastModified2;
                            j11 = duration;
                            if (!PictureMimeType.isHasVideo(mimeTypeFromMediaUrl)) {
                            }
                            fileArr = listFiles;
                            i14 = selectorConfig.filterVideoMinSecond;
                            j12 = j13;
                            if (i14 > 0) {
                            }
                            i15 = selectorConfig.filterVideoMaxSecond;
                            if (i15 > 0) {
                            }
                        }
                    }
                }
                messageDigest2 = messageDigest;
                arrayList = arrayList2;
                fileArr = listFiles;
                i10 = length;
                i11 = i16;
                i16 = i11 + 1;
                length = i10;
                arrayList2 = arrayList;
                messageDigest = messageDigest2;
                listFiles = fileArr;
                context2 = context;
            }
        }
        return arrayList2;
    }

    public static LocalMediaFolder loadInAppSandboxFolderFile(Context context, String str) {
        ArrayList<LocalMedia> loadInAppSandboxFile = loadInAppSandboxFile(context, str);
        if (loadInAppSandboxFile != null && loadInAppSandboxFile.size() > 0) {
            SortUtils.sortLocalMediaAddedTime(loadInAppSandboxFile);
            LocalMedia localMedia = loadInAppSandboxFile.get(0);
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setFolderName(localMedia.getParentFolderName());
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setBucketId(localMedia.getBucketId());
            localMediaFolder.setFolderTotalNum(loadInAppSandboxFile.size());
            localMediaFolder.setData(loadInAppSandboxFile);
            return localMediaFolder;
        }
        return null;
    }
}
