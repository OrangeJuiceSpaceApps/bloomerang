package gov.nasa.spaceapps.bloomerang.interfaces;

public interface Risk {

    double getSalinity();

    double getTemperature();

    double getDisolvedOxigen();

    double getPhosphate();

    double getNitrate();

    boolean isRiskSalinity(double salinity);

    double getRiskPercentageTemperature(double temperature);

    boolean isRiskDisolvedOxigen(double disolvedOxigen);

    double getRiskPercentageNitratePhosphate(double nitrate, double phosphate);

}
