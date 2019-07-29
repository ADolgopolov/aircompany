import Planes.*;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Plane> planes = Arrays.asList(
                new PassengerPlane(new BasicParametersPlane("Boeing-737", 900, 12000, 60500),
                        new PassengerPlane.PassengersCapacity(164)),
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
                        ClassificationLevel.CONFIDENTIAL),
                new ExperimentalPlane(new BasicParametersPlane("Bell X-141", 277, 482, 500),
                        ExperimentalType.HYPERSONIC,
                        ClassificationLevel.CONFIDENTIAL),
                new ExperimentalPlane(new BasicParametersPlane("Bell X-142", 277, 482, 500),
                        ExperimentalType.LIFTING_BODY,
                        ClassificationLevel.CONFIDENTIAL)
        );

        Airport airport = new Airport(planes);
        System.out.println("\n MilitaryPlanes TRANSPORT");
        airport.printPlanesList(airport.getMilitaryPlanesByType(MilitaryType.TRANSPORT));
        System.out.println("\n MilitaryPlanes FIGHTER");
        airport.printPlanesList(airport.getMilitaryPlanesByType(MilitaryType.FIGHTER));
        System.out.println("\n MilitaryPlanes BOMBER");
        airport.printPlanesList(airport.getMilitaryPlanesByType(MilitaryType.BOMBER));
        System.out.println("\n\n");

        ExperimentalPlane experimentalPlane = new ExperimentalPlane(new BasicParametersPlane("Ryan X-13 Vertijet", 560, 307, 500),
                ExperimentalType.VTOL,
                ClassificationLevel.TOP_SECRET);
        System.out.println(experimentalPlane);
        System.out.println(experimentalPlane.getExperimentalType());
        System.out.println(experimentalPlane.getClassificationLevel());


        Airport militaryAirport = new Airport(airport.getLisOfPlanesByType(MilitaryPlane.class));
        Airport passengerAirport = new Airport(airport.getLisOfPlanesByType(PassengerPlane.class));
        Airport experimentalAirport = new Airport(airport.getLisOfPlanesByType(ExperimentalPlane.class));
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxFlightDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());
        System.out.println("Passenger airport sorted by max load capacity: " + passengerAirport
                .sortByMaxLoadCapacity()
                .toString());
        System.out.println("Experimental airport sorted by max load capacity:: " + experimentalAirport
                .sortByMaxLoadCapacity()
                .toString());

        System.out.println("\nPlane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
