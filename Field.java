public class Field {
    private BigObject parentObject;
    private String name;
    private String[] allowedValues;
    private boolean mandatory;


    public Field(BigObject parentObject, String name, String[] allowedValues, boolean mandatory) {
        this.parentObject = parentObject;
        this.name = name;
        this.allowedValues = allowedValues;
        this.mandatory = mandatory;
    }

    public BigObject getParentObject() {
        return parentObject;
    }

    public void setParentObject(BigObject parentObject) {
        this.parentObject = parentObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String[] allowedValues) {
        this.allowedValues = allowedValues;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
