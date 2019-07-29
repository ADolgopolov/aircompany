import Planes.*;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class AirportTest {
    private static final List<? extends Plane> planes = Arrays.asList(
            new PassengerPlane(new BasicParametersPlane("Boeing-737", 900, 12000, 60500),
                    new PassengerPlane.PassengersCapacity(164)),
            new PassengerPlane(new BasicParametersPlane("Boeing-737-800", 940, 12300, 63870),
                    new PassengerPlane.PassengersCapacity(192)),
            new PassengerPlane(new BasicParametersPlane("Boeing-747", 980, 16100, 70500),
                    new PassengerPlane.PassengersCapacity(242)),
            new PassengerPlane(new BasicParametersPlane("Airbus A320", 930, 11800, 65500),
                    new PassengerPlane.PassengersCapacity(188)),
            new PassengerPlane(new BasicParametersPlane("Airbus A330", 990, 14800, 80500),
                    new PassengerPlane.PassengersCapacity(222)),
            new PassengerPlane(new BasicParametersPlane("Embraer 190", 870, 8100, 30800),
                    new PassengerPlane.PassengersCapacity(64)),
            new PassengerPlane(new BasicParametersPlane("Sukhoi Superjet 100", 870, 11500, 50500),
                    new PassengerPlane.PassengersCapacity(140)),
            new PassengerPlane(new BasicParametersPlane("Bombardier CS300", 920, 11000, 60700),
                    new PassengerPlane.PassengersCapacity(196)),
            new MilitaryPlane(new BasicParametersPlane("B-1B Lancer", 1050, 21000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new BasicParametersPlane("B-2 Spirit", 1030, 22000, 70000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new BasicParametersPlane("B-52 Stratofortress", 1000, 20000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new BasicParametersPlane("F-15", 1500, 12000, 10000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new BasicParametersPlane("F-22", 1550, 13000, 11000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new BasicParametersPlane("C-130 Hercules", 650, 5000, 110000),
                    MilitaryType.TRANSPORT),
            new ExperimentalPlane(new BasicParametersPlane("Bell X-14", 277, 482, 500),
                    ExperimentalType.HIGH_ALTITUDE,
                    ClassificationLevel.SECRET),
            new ExperimentalPlane(new BasicParametersPlane("Ryan X-13 Vertijet", 560, 307, 500),
                    ExperimentalType.VTOL,
                    ClassificationLevel.TOP_SECRET)
    );
    private static final List<? extends Plane> planesSortedByMaxLoadCapacity = Arrays.asList(
            new ExperimentalPlane( new BasicParametersPlane("Bell X-14", 277, 482, 500),
                    ExperimentalType.HIGH_ALTITUDE,
                    ClassificationLevel.SECRET),
            new ExperimentalPlane(new BasicParametersPlane("Ryan X-13 Vertijet", 560, 307, 500),
                    ExperimentalType.VTOL,
                    ClassificationLevel.TOP_SECRET),
            new MilitaryPlane(new BasicParametersPlane("F-15", 1500, 12000, 10000),
                    MilitaryType.FIGHTER),
            new MilitaryPlane(new BasicParametersPlane("F-22", 1550, 13000, 11000),
                    MilitaryType.FIGHTER),
            new PassengerPlane(new BasicParametersPlane("Embraer 190", 870, 8100, 30800),
                    new PassengerPlane.PassengersCapacity(64)),
            new PassengerPlane(new BasicParametersPlane("Sukhoi Superjet 100", 870, 11500, 50500),
                    new PassengerPlane.PassengersCapacity(140)),
            new PassengerPlane(new BasicParametersPlane("Boeing-737", 900, 12000, 60500),
                    new PassengerPlane.PassengersCapacity(164)),
            new PassengerPlane(new BasicParametersPlane("Bombardier CS300", 920, 11000, 60700),
                    new PassengerPlane.PassengersCapacity(196)),
            new PassengerPlane(new BasicParametersPlane("Boeing-737-800", 940, 12300, 63870),
                    new PassengerPlane.PassengersCapacity(192)),
            new PassengerPlane(new BasicParametersPlane("Airbus A320", 930, 11800, 65500),
                    new PassengerPlane.PassengersCapacity(188)),
            new MilitaryPlane(new BasicParametersPlane("B-2 Spirit", 1030, 22000, 70000),
                    MilitaryType.BOMBER),
            new PassengerPlane(new BasicParametersPlane("Boeing-747", 980, 16100, 70500),
                    new PassengerPlane.PassengersCapacity(242)),
            new MilitaryPlane(new BasicParametersPlane("B-1B Lancer", 1050, 21000, 80000),
                    MilitaryType.BOMBER),
            new MilitaryPlane(new BasicParametersPlane("B-52 Stratofortress", 1000, 20000, 80000),
                    MilitaryType.BOMBER),
            new PassengerPlane(new BasicParametersPlane("Airbus A330", 990, 14800, 80500),
                    new PassengerPlane.PassengersCapacity(222)),
            new MilitaryPlane(new BasicParametersPlane("C-130 Hercules", 650, 5000, 110000),
                    MilitaryType.TRANSPORT)
    );
    private static final PassengerPlane expectedPlaneWithMaxPassengersCapacity = new PassengerPlane(
            new BasicParametersPlane("Boeing-747", 980, 16100, 70500),
            new PassengerPlane.PassengersCapacity(242));

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getMilitaryPlanesByType(MilitaryType.TRANSPORT);
        Assert.assertTrue(transportMilitaryPlanes.stream().allMatch(plane -> plane.getMilitaryType() == MilitaryType.TRANSPORT));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane foundPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, foundPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacityActual = airport.getAllPlanes();
        Assert.assertEquals(planesSortedByMaxLoadCapacity, planesSortedByMaxLoadCapacityActual);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getMilitaryPlanesByType(MilitaryType.BOMBER);
        Assert.assertTrue(bomberMilitaryPlanes.size() > 0);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getLisOfPlanesByType(ExperimentalPlane.class);
        Assert.assertTrue(experimentalPlanes.stream().allMatch(plane -> plane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED));
    }
}
