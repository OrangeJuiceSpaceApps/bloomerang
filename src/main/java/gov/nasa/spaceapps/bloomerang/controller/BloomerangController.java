package gov.nasa.spaceapps.bloomerang.controller;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

public final class BloomerangController {

    private Risk risk;
    private Bloomerang bloomerang;

    private static BloomerangController singleton;

    private BloomerangController(Risk risk, Bloomerang bloomerang) {
        this.risk = risk;
        this.bloomerang = bloomerang;
    }

    public static BloomerangController getController(Risk risk, Bloomerang bloomerang) {
        if (singleton == null) {
            singleton = new BloomerangController(risk, bloomerang);
        }
        return singleton;
    }

    public Double getRiskPercentageOf(Coordinates coordinates) {
        return this.bloomerang.getBloomRiskPercentage(this.risk, coordinates);
    }

}
