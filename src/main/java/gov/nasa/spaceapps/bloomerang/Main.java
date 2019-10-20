package gov.nasa.spaceapps.bloomerang;

import gov.nasa.spaceapps.bloomerang.controller.BloomerangController;
import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;
import gov.nasa.spaceapps.bloomerang.interfaces.impl.BloomerangImpl;
import gov.nasa.spaceapps.bloomerang.interfaces.impl.RiskImpl;
import gov.nasa.spaceapps.bloomerang.utils.Constans;

public class Main {

    public static void main(String[] args) {
        BloomerangDataLoader dataLoader = null;
        Risk risk = new RiskImpl(Constans.DEFAULT_SALINITY, Constans.DEFAULT_TEMPERATURE, Constans.DEFAULT_DISOLVED_OXIGEN, Constans.DEFAULT_PHOSPHATE, Constans.DEFAULT_NITRATE);
        Bloomerang bloomerang = new BloomerangImpl(dataLoader);
        BloomerangController controller = BloomerangController.getController(risk, bloomerang);

        Coordinates coordinates = new Coordinates(0, 0);
        Double percentageRisk = controller.getRiskPercentageOf(coordinates);

        if (percentageRisk == null) {
            System.out.println("No se ha podido calcular el riesgo");
        }
        else {
            System.out.println("Hay un " + percentageRisk + "% de riesgo");
        }

    }

}
