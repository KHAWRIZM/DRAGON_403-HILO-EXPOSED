package com.liulishuo.okdownload.core.breakpoint;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.download.DownloadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointInfo {
    private final List<BlockInfo> blockInfoList = new ArrayList();
    private boolean chunked;
    private String etag;
    private final DownloadStrategy.FilenameHolder filenameHolder;
    final int id;
    final File parentFile;
    private File targetFile;
    private final boolean taskOnlyProvidedParentPath;
    private final String url;

    public BreakpointInfo(int i10, String str, File file, String str2) {
        this.id = i10;
        this.url = str;
        this.parentFile = file;
        if (Util.isEmpty(str2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.taskOnlyProvidedParentPath = true;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str2);
            this.taskOnlyProvidedParentPath = false;
            this.targetFile = new File(file, str2);
        }
    }

    public void addBlock(BlockInfo blockInfo) {
        this.blockInfoList.add(blockInfo);
    }

    public BreakpointInfo copy() {
        BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            breakpointInfo.blockInfoList.add(it.next().copy());
        }
        return breakpointInfo;
    }

    public BreakpointInfo copyWithReplaceId(int i10) {
        BreakpointInfo breakpointInfo = new BreakpointInfo(i10, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            breakpointInfo.blockInfoList.add(it.next().copy());
        }
        return breakpointInfo;
    }

    public BreakpointInfo copyWithReplaceIdAndUrl(int i10, String str) {
        BreakpointInfo breakpointInfo = new BreakpointInfo(i10, str, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        Iterator<BlockInfo> it = this.blockInfoList.iterator();
        while (it.hasNext()) {
            breakpointInfo.blockInfoList.add(it.next().copy());
        }
        return breakpointInfo;
    }

    public BlockInfo getBlock(int i10) {
        return this.blockInfoList.get(i10);
    }

    public int getBlockCount() {
        return this.blockInfoList.size();
    }

    public String getEtag() {
        return this.etag;
    }

    public File getFile() {
        String str = this.filenameHolder.get();
        if (str == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.parentFile, str);
        }
        return this.targetFile;
    }

    public String getFilename() {
        return this.filenameHolder.get();
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public int getId() {
        return this.id;
    }

    public long getTotalLength() {
        if (isChunked()) {
            return getTotalOffset();
        }
        Object[] array = this.blockInfoList.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof BlockInfo) {
                    j10 = ((BlockInfo) obj).getContentLength() + j10;
                }
            }
        }
        return j10;
    }

    public long getTotalOffset() {
        Object[] array = this.blockInfoList.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof BlockInfo) {
                    j10 = ((BlockInfo) obj).getCurrentOffset() + j10;
                }
            }
        }
        return j10;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isLastBlock(int i10) {
        if (i10 == this.blockInfoList.size() - 1) {
            return true;
        }
        return false;
    }

    public boolean isSameFrom(DownloadTask downloadTask) {
        if (!this.parentFile.equals(downloadTask.getParentFile()) || !this.url.equals(downloadTask.getUrl())) {
            return false;
        }
        String filename = downloadTask.getFilename();
        if (filename != null && filename.equals(this.filenameHolder.get())) {
            return true;
        }
        if (!this.taskOnlyProvidedParentPath || !downloadTask.isFilenameFromResponse()) {
            return false;
        }
        if (filename != null && !filename.equals(this.filenameHolder.get())) {
            return false;
        }
        return true;
    }

    public boolean isSingleBlock() {
        if (this.blockInfoList.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public void resetBlockInfos() {
        this.blockInfoList.clear();
    }

    public void resetInfo() {
        this.blockInfoList.clear();
        this.etag = null;
    }

    public void reuseBlocks(BreakpointInfo breakpointInfo) {
        this.blockInfoList.clear();
        this.blockInfoList.addAll(breakpointInfo.blockInfoList);
    }

    public void setChunked(boolean z10) {
        this.chunked = z10;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String toString() {
        return "id[" + this.id + "] url[" + this.url + "] etag[" + this.etag + "] taskOnlyProvidedParentPath[" + this.taskOnlyProvidedParentPath + "] parent path[" + this.parentFile + "] filename[" + this.filenameHolder.get() + "] block(s):" + this.blockInfoList.toString();
    }

    public BreakpointInfo(int i10, String str, File file, String str2, boolean z10) {
        this.id = i10;
        this.url = str;
        this.parentFile = file;
        if (Util.isEmpty(str2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str2);
        }
        this.taskOnlyProvidedParentPath = z10;
    }
}
