
package org.monte.media.seq;

import org.monte.media.Demultiplexer;
import org.monte.media.Track;
import java.io.File;
import java.io.IOException;


public class SEQDemultiplexer extends SEQReader implements Demultiplexer {

    private Track[] tracks;

    public SEQDemultiplexer(File file) throws IOException {
        super(file);
    }
    public SEQDemultiplexer(File file, boolean variableFramerate) throws IOException {
        super(file, variableFramerate);
    }

    @Override
    public Track[] getTracks() {
        if (tracks == null) {
            tracks = new Track[]{new SEQTrack(this)};
        }
        return tracks.clone();
    }
}
