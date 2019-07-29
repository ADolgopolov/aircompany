package Planes;

import java.util.Objects;

public abstract class Plane {
    protected final String model;
    protected final int maxSpeed;
    protected final int maxFlightDistance;
    protected final int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }
    public Plane(BasicParametersPlane basicParametersPlane) {
        this.model = basicParametersPlane.getModel();
        this.maxSpeed = basicParametersPlane.getMaxSpeed();
        this.maxFlightDistance = basicParametersPlane.getMaxFlightDistance();
        this.maxLoadCapacity = basicParametersPlane.getMaxLoadCapacity();
    }

    public String getModel() {
        return this.model;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getMaxFlightDistance() {
        return this.maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + this.model + '\'' +
                ", maxSpeed=" + this.maxSpeed +
                ", maxFlightDistance=" + this.maxFlightDistance +
                ", maxLoadCapacity=" + this.maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return this.maxSpeed == plane.maxSpeed &&
                this.maxFlightDistance == plane.maxFlightDistance &&
                this.maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(this.model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
