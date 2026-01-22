package org.apache.commons.sudcompress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ZipSplitReadOnlySeekableByteChannel extends k0.i {
    private static final int ZIP_SPLIT_SIGNATURE_LENGTH = 4;
    private final ByteBuffer zipSplitSignatureByteBuffer;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class ZipSplitSegmentComparator implements Comparator<File>, Serializable {
        private static final long serialVersionUID = 20200123;

        private ZipSplitSegmentComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            String substring;
            String path = file.getPath();
            String str = "";
            if (path == null) {
                substring = null;
            } else {
                String name = new File(path).getName();
                int lastIndexOf = name.lastIndexOf(46);
                substring = lastIndexOf < 0 ? "" : name.substring(lastIndexOf + 1);
            }
            String path2 = file2.getPath();
            if (path2 == null) {
                str = null;
            } else {
                String name2 = new File(path2).getName();
                int lastIndexOf2 = name2.lastIndexOf(46);
                if (lastIndexOf2 >= 0) {
                    str = name2.substring(lastIndexOf2 + 1);
                }
            }
            if (!substring.startsWith("z")) {
                return -1;
            }
            if (str.startsWith("z")) {
                return Integer.valueOf(Integer.parseInt(substring.substring(1))).compareTo(Integer.valueOf(Integer.parseInt(str.substring(1))));
            }
            return 1;
        }
    }

    public ZipSplitReadOnlySeekableByteChannel(List<SeekableByteChannel> list) {
        super(list);
        this.zipSplitSignatureByteBuffer = ByteBuffer.allocate(4);
        assertSplitSignature(list);
    }

    private void assertSplitSignature(List<SeekableByteChannel> list) {
        SeekableByteChannel a = k0.b.a(list.get(0));
        k0.g.a(a, 0L);
        this.zipSplitSignatureByteBuffer.rewind();
        k0.e.a(a, this.zipSplitSignatureByteBuffer);
        if (new ZipLong(this.zipSplitSignatureByteBuffer.array()).equals(ZipLong.DD_SIG)) {
            k0.g.a(a, 0L);
        } else {
            k0.g.a(a, 0L);
            throw new IOException("The first zip split segment does not begin with split zip file signature");
        }
    }

    public static SeekableByteChannel buildFromLastSplitSegment(File file) {
        String substring;
        String name;
        String canonicalPath = file.getCanonicalPath();
        if (canonicalPath == null) {
            substring = null;
        } else {
            String name2 = new File(canonicalPath).getName();
            int lastIndexOf = name2.lastIndexOf(46);
            if (lastIndexOf < 0) {
                substring = "";
            } else {
                substring = name2.substring(lastIndexOf + 1);
            }
        }
        if (substring.equalsIgnoreCase("zip")) {
            File parentFile = file.getParentFile();
            String canonicalPath2 = file.getCanonicalPath();
            if (canonicalPath2 == null) {
                name = null;
            } else {
                name = new File(canonicalPath2).getName();
                int lastIndexOf2 = name.lastIndexOf(46);
                if (lastIndexOf2 >= 0) {
                    name = name.substring(0, lastIndexOf2);
                }
            }
            ArrayList arrayList = new ArrayList();
            Pattern compile = Pattern.compile(Pattern.quote(name) + ".[zZ][0-9]+");
            File[] listFiles = parentFile.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (compile.matcher(file2.getName()).matches()) {
                        arrayList.add(file2);
                    }
                }
            }
            Collections.sort(arrayList, new ZipSplitSegmentComparator());
            return forFiles(file, arrayList);
        }
        throw new IllegalArgumentException("The extension of last zip split segment should be .zip");
    }

    public static SeekableByteChannel forFiles(File... fileArr) {
        SeekableByteChannel newByteChannel;
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(fileArr, "files must not be null");
        for (File file : fileArr) {
            newByteChannel = Files.newByteChannel(i0.a.a(file), okio.c.a());
            arrayList.add(newByteChannel);
        }
        if (arrayList.size() == 1) {
            return k0.b.a(arrayList.get(0));
        }
        return new ZipSplitReadOnlySeekableByteChannel(arrayList);
    }

    public static SeekableByteChannel forOrderedSeekableByteChannels(SeekableByteChannel... seekableByteChannelArr) {
        Objects.requireNonNull(seekableByteChannelArr, "channels must not be null");
        if (seekableByteChannelArr.length == 1) {
            return seekableByteChannelArr[0];
        }
        return new ZipSplitReadOnlySeekableByteChannel(Arrays.asList(seekableByteChannelArr));
    }

    public static SeekableByteChannel forOrderedSeekableByteChannels(SeekableByteChannel seekableByteChannel, Iterable<SeekableByteChannel> iterable) {
        Objects.requireNonNull(iterable, "channels");
        Objects.requireNonNull(seekableByteChannel, "lastSegmentChannel");
        ArrayList arrayList = new ArrayList();
        Iterator<SeekableByteChannel> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(k0.b.a(it.next()));
        }
        arrayList.add(seekableByteChannel);
        return forOrderedSeekableByteChannels((SeekableByteChannel[]) arrayList.toArray(new SeekableByteChannel[arrayList.size()]));
    }

    public static SeekableByteChannel forFiles(File file, Iterable<File> iterable) {
        Objects.requireNonNull(iterable, "files");
        Objects.requireNonNull(file, "lastSegmentFile");
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(file);
        return forFiles((File[]) arrayList.toArray(new File[arrayList.size()]));
    }
}
