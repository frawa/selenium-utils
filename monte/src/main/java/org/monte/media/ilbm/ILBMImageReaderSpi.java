
package org.monte.media.ilbm;

import org.monte.media.iff.IFFParser;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.ImageInputStream;


public class ILBMImageReaderSpi extends ImageReaderSpi {
    protected final static int FORM_ID = IFFParser.stringToID("FORM");
    protected final static int CAT_ID = IFFParser.stringToID("CAT ");
    protected final static int LIST_ID = IFFParser.stringToID("LIST");
    protected final static int ILBM_ID = IFFParser.stringToID("ILBM");
    protected final static int ANIM_ID = IFFParser.stringToID("ANIM");

    public ILBMImageReaderSpi() {
        super("Werner Randelshofer",
                "1.0",
                new String[]{"ILBM"},
                new String[]{"ilbm","lbm",""},
                new String[]{"image/ilbm"},
                "org.monte.media.ilbm.ILBMImageReader",
                new Class[]{ImageInputStream.class},
                null,
                false,
                null,
                null,
                null,
                null,
                false,
                null,
                null,
                null,
                null
                );
    }

    @Override
    public boolean canDecodeInput(Object source) throws IOException {
        if (source instanceof ImageInputStream) {
            ImageInputStream in = (ImageInputStream) source;
            in.mark();


            int fileID = in.readInt();
            if (fileID != FORM_ID && fileID!=CAT_ID&&fileID!=LIST_ID) {
                in.reset();
                return false;
            }

            int contentSize = in.readInt();
            int contentID = in.readInt();
            if (contentID != ILBM_ID && contentID!=ANIM_ID) {
                in.reset();
                return false;
            }
            in.reset();
            return true;
        }
        return false;
    }

    @Override
    public ImageReader createReaderInstance(Object extension) throws IOException {
        return new ILBMImageReader(this);
    }

    @Override
    public String getDescription(Locale locale) {
        return "ILBM Interleaved Bitmap";
    }
}
