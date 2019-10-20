package gov.nasa.spaceapps.bloomerang;

import gov.nasa.spaceapps.bloomerang.controller.BloomerangController;
import gov.nasa.spaceapps.bloomerang.entities.Coordinates;
import gov.nasa.spaceapps.bloomerang.interfaces.Bloomerang;
import gov.nasa.spaceapps.bloomerang.interfaces.BloomerangDataLoader;
import gov.nasa.spaceapps.bloomerang.interfaces.Risk;

public class Main {

    public static void main(String[] args) {
        BloomerangDataLoader dataLoader = null;
        Risk risk = null;
        Bloomerang bloomerang = null;
        BloomerangController controller = BloomerangController.getController(dataLoader, risk, bloomerang);

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
