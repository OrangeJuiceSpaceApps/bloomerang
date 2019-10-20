package gov.nasa.spaceapps.bloomerang.interfaces.impl;

import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

public class RiskImpl implements Risk {

    private double salinity;
    private double temperature;
    private double disolvedOxigen;
    private double phosphate;
    private double nitrate;

    private static final double TEMP_MIN = 5.0;
    private static final double TEMP_MAX = 40.0;

    public RiskImpl(double salinity, double temperature, double disolvedOxigen, double phosphate, double nitrate) {
        this.salinity = salinity;
        this.temperature = temperature;
        this.disolvedOxigen = disolvedOxigen;
        this.phosphate = phosphate;
        this.phosphate = nitrate;
    }

    @Override
    public double getSalinity() {
        return this.salinity;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public double getDisolvedOxigen() {
        return this.disolvedOxigen;
    }

    @Override
    public double getPhosphate() {
        return this.phosphate;
    }

    @Override
    public double getNitrate() {
        return this.nitrate;
    }

    @Override
    public boolean isRiskSalinity(double salinity) {
        boolean risk = false;
        if (this.salinity < salinity) {
            risk = true;
        }
        return risk;
    }

    @Override
    public double getRiskPercentageTemperature(double temperature) {
        double risk = 0;
        if (TEMP_MIN > temperature && temperature < TEMP_MAX) {
            if (TEMP_MIN > temperature && temperature < TEMP_MIN + 5) {
                risk = 5.0;
            }
            else if (TEMP_MIN + 5 > temperature && temperature < TEMP_MIN + 10) {
                risk = 20.0;
            }
            else if (TEMP_MIN + 10 > temperature && temperature < TEMP_MIN + 15) {
                risk = 40.0;
            }
            else if (TEMP_MIN + 15 > temperature && temperature < TEMP_MIN + 20) {
                risk = 60.0;
            }
            else if (TEMP_MIN + 20 > temperature && temperature < TEMP_MIN + 25) {
                risk = 80.0;
            }
            else if (TEMP_MIN + 25 > temperature && temperature < TEMP_MIN + 30) {
                risk = 100.0;
            }
            else if (TEMP_MIN + 30 > temperature && temperature < TEMP_MIN + 35) {
                risk = 90.0;
            }
        }
        return risk;
    }

    @Override
    public boolean isRiskDisolvedOxigen(double disolvedOxigen) {
        boolean risk = false;
        if (this.disolvedOxigen < disolvedOxigen) {
            risk = true;
        }
        return risk;
    }

    @Override
    public double getRiskPercentageNitratePhosphate(double nitrate, double phosphate) {
        double risk = 0;
        if (nitrate / 24 < phosphate) {
            risk = 100.0;
        }
        else if (nitrate / 21.5 < phosphate) {
            risk = 75.0;
        }
        else if (nitrate / 19 < phosphate) {
            risk = 50.0;
        }
        else if (nitrate / 16.5 < phosphate) {
            risk = 25.0;
        }
        else if (nitrate / 14 < phosphate) {
            risk = 0.0;
        }
        else if (nitrate / 11.25 < phosphate) {
            risk = 25.0;
        }
        else if (nitrate / 8.5 < phosphate) {
            risk = 50.0;
        }
        else if (nitrate / 5.75 < phosphate) {
            risk = 75.0;
        }
        else if (nitrate / 3 < phosphate) {
            risk = 100.0;
        }
        return risk;
    }
}
