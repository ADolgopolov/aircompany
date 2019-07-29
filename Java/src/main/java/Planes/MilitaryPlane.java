package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private final MilitaryType militaryType;

    public MilitaryPlane(BasicParametersPlane basicParametersPlane, MilitaryType militaryType) {
        super(basicParametersPlane);
        this.militaryType = militaryType;
    }

    public MilitaryType getMilitaryType() {
        return this.militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + this.militaryType +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        return this.militaryType == ((MilitaryPlane)o).militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
