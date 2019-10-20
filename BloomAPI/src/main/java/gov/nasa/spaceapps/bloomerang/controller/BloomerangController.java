package gov.nasa.spaceapps.bloomerang.controller;

import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

public final class BloomerangController {

    private BloomerangDataLoader dataLoader;
    private Risk risk;
    private Bloomerang bloomerang;

    private static BloomerangController singleton;

    private BloomerangController(BloomerangDataLoader dataLoader, Risk risk, Bloomerang bloomerang) {
        this.dataLoader = dataLoader;
        this.risk = risk;
        this.bloomerang = bloomerang;
    }

    public static BloomerangController getController(BloomerangDataLoader dataLoader, Risk risk, Bloomerang bloomerang) {
        if (singleton == null) {
            singleton = new BloomerangController(dataLoader, risk, bloomerang);
        }
        return singleton;
    }

    public Integer getRiskPercentageOf(Coordinates coordinates) {



        return null;
    }

}
