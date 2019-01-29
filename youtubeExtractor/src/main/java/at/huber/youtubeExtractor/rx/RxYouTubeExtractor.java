package at.huber.youtubeExtractor.rx;

import io.reactivex.Observable;

public interface RxYouTubeExtractor {
    void extract(String youTubeLink, boolean parseDashManifest, boolean includeWebm);
    Observable<RxReult> bind();
}
