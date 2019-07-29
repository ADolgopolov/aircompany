package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{
    public static class PassengersCapacity{
        private final int passengersCapacity;
        public PassengersCapacity(int passengersCapacity) {
            this.passengersCapacity = passengersCapacity;
        }
        public int getPassengersCapacity() {
            return this.passengersCapacity;
        }
    }
    private final int passengersCapacity;

    public PassengerPlane(BasicParametersPlane basicParametersPlane, PassengersCapacity passengersCapacity) {
        super(basicParametersPlane);
        this.passengersCapacity = passengersCapacity.getPassengersCapacity();
    }
    public int getPassengersCapacity() {
        return this.passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + this.passengersCapacity +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        return this.passengersCapacity == ((PassengerPlane)o).passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
