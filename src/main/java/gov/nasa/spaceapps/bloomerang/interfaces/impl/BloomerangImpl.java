package gov.nasa.spaceapps.bloomerang.interfaces.impl;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

public class BloomerangImpl implements Bloomerang {
    @Override
    public Double getBloomRiskPercentage(Risk risk, Coordinates coordinates) {
        return 0.0;
    }
}
