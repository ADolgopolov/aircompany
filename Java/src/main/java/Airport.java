import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

import static java.util.Comparator.*;

/**
 * @author Vitali Shulha
 * @version 1.1
 * {@code @date} 04/01/2019
 */

public class Airport {
    private final List<? extends Plane> planes;
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }
    public List<? extends Plane> getAllPlanes() {
        return planes;
    }

    public <T extends Plane> List<T> getLisOfPlanesByType(Class<T> classType) {
        List<T> listOfPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane.getClass() == classType) {
                listOfPlanes.add(classType.cast(plane));
            }
        }
        return listOfPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> allPassengerPlanes = this.getLisOfPlanesByType(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = allPassengerPlanes.get(0);
        for (PassengerPlane plane : allPassengerPlanes) {
            if (plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = plane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType militaryType) {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof MilitaryPlane) {
                if(((MilitaryPlane) plane).getMilitaryType() == militaryType) {
                    militaryPlanes.add((MilitaryPlane) plane);
                }
            }
        }
        return militaryPlanes;
    }

    public Airport sortByMaxFlightDistance() {
        planes.sort(comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(comparingInt(Plane::getMaxLoadCapacity));
        return this;
    }

    public void printPlanesList(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
