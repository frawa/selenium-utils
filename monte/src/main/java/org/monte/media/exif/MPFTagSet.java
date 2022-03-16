
package org.monte.media.exif;

import org.monte.media.tiff.ASCIIValueFormatter;
import org.monte.media.tiff.TagSet;
import org.monte.media.tiff.*;
import static org.monte.media.tiff.TIFFTag.*;


public class MPFTagSet extends TagSet {

    public final static int TAG_NumberOfImages = 0xb001;
    public final static int TAG_MPEntryInformation = 0xb002;

    public final static TIFFTag MPEntryInformation = new TIFFTag("MPEntryInformation", TAG_MPEntryInformation, UNDEFINED_MASK);

    public final static TIFFTag ConvergenceAngle = new TIFFTag("ConvergenceAngle", 0xb205, SRATIONAL_MASK);
    public final static TIFFTag BaselineLength = new TIFFTag("BaselineLength", 0xb206, RATIONAL_MASK);

    private static MPFTagSet instance;

    private MPFTagSet(TIFFTag[] tags) {
        super("MPF", tags);
    }

    public static TIFFTag get(int tagNumber) {
        return getInstance().getTag(tagNumber);
    }

    
    public static MPFTagSet getInstance() {
        if (instance == null) {
            TIFFTag[] tags = {
                new TIFFTag("MPFVersion", 0xb000, UNDEFINED_MASK, new ASCIIValueFormatter()),
                new TIFFTag("NumberOfImages", TAG_NumberOfImages, SHORT_MASK),
                MPEntryInformation,
                new TIFFTag("IndividualImageUniqueIDList", 0xb003, SHORT_MASK),
                new TIFFTag("TotalNumberOfCapturedFrames", 0xb004, SHORT_MASK),
                new TIFFTag("MPIndividualImageNumber", 0xb101, LONG_MASK),
                new TIFFTag("PanOrientation", 0xb201, LONG_MASK),
                new TIFFTag("PanOverlap_H", 0xb202, RATIONAL_MASK),
                new TIFFTag("PanOverlap_V", 0xb203, RATIONAL_MASK),
                new TIFFTag("BaseViewpointNum", 0xb204, LONG_MASK),
                ConvergenceAngle,
                BaselineLength,
                new TIFFTag("VerticalDivergence", 0xb207, SRATIONAL_MASK),
                new TIFFTag("AxisDistance_X", 0xb208, SRATIONAL_MASK),
                new TIFFTag("AxisDistance_Y", 0xb209, SRATIONAL_MASK),
                new TIFFTag("AxisDistance_Z", 0xb20a, SRATIONAL_MASK),
                new TIFFTag("YawAngle", 0xb20b, SRATIONAL_MASK),
                new TIFFTag("PitchAngle", 0xb20c, SRATIONAL_MASK),
                new TIFFTag("RollAngle", 0xb20d, SRATIONAL_MASK),


            };
            instance = new MPFTagSet(tags);

        }
        return instance;
    }
}
