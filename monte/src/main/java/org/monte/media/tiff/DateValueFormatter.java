

package org.monte.media.tiff;


public class DateValueFormatter implements ValueFormatter {

    public DateValueFormatter() {
    }

    @Override
    public Object format(Object value) {
        return value;
    }

    @Override
    public Object prettyFormat(Object value) {
        return value;
    }

    @Override
    public String descriptionFormat(Object data) {
       return null;
    }
}
