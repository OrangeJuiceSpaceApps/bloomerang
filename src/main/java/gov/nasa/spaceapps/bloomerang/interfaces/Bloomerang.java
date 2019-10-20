package gov.nasa.spaceapps.bloomerang.interfaces;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;

public interface Bloomerang {

    Double getBloomRiskPercentage(Risk risk, Coordinates coordinates);

}
