package Planes;

import models.ClassificationLevel;
import models.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType experimentalType;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(BasicParametersPlane basicParametersPlane, ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(basicParametersPlane);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return this.classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + this.experimentalType +
                ", classification level=" + this.classificationLevel +
                        '}');
    }
}
