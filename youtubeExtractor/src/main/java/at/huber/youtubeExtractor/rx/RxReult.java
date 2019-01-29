package at.huber.youtubeExtractor.rx;

import android.util.SparseArray;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YtFile;

public class RxReult {
    SparseArray<YtFile> sparseArray;
    VideoMeta videoMeta;

    RxReult(SparseArray<YtFile> sparseArray, VideoMeta videoMeta) {
        this.sparseArray = sparseArray;
        this.videoMeta = videoMeta;
    }
}
