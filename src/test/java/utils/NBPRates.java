package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPRates {
    public String effectiveDate;
    public ArrayList<Rate> rates;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "NBPRates{" +
                "effectiveDate='" + effectiveDate + '\'' +
                ", rates=" + rates +
                '}';
    }
}
