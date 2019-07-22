package component;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalRounder {
    public static BigDecimal roundToHalfUp(final double value, final int scale) {
        return BigDecimal.valueOf(value).setScale(scale, RoundingMode.HALF_UP);
    }
}
