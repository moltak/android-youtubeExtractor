package at.huber.youtubeExtractor.rx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;
import io.reactivex.Observable;

public class RxYouTubeExtractorImpl implements RxYouTubeExtractor {

    private Relay<RxReult> relay = PublishRelay.create();
    private YouTubeExtractor youTubeExtractor;

    @SuppressLint("StaticFieldLeak")
    public RxYouTubeExtractorImpl(Context context) {
        youTubeExtractor = new YouTubeExtractor(context) {
            @Override
            protected void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta videoMeta) {
                relay.accept(new RxReult(ytFiles, videoMeta));
            }
        };
    }

    @Override
    public void extract(String youTubeLink, boolean parseDashManifest, boolean includeWebm) {
        youTubeExtractor.extract(youTubeLink, parseDashManifest, includeWebm);
    }

    @Override
    public Observable<RxReult> bind() {
        return relay;
    }
}
