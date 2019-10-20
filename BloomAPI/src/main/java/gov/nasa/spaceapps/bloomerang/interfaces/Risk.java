package gov.nasa.spaceapps.bloomerang.interfaces;

public interface Risk {

    int getSalinity();

    int getTemperature();

    int getDisolvedOxigen();

    int getPhosphate();

    int getNitrate();

    int getRiskPercentageSalinity(int salinity);

    int getRiskPercentageTemperature(int temperature);

    int getRiskPercentageDisolvedOxigen(int disolvedOxigen);

    int getRiskPercentagePhosphate(int phosphate);

    int getRiskPercentageNitrate(int nitrate);

}
