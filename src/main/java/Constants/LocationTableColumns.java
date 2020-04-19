package Constants;

public enum LocationTableColumns {
    CHECKBOX (0),
    NAME (1),
    CITY (2),
    COUNTRY (3),
    PHONE (4),
    NUMBER_OF_EMPLOYEES (5);

    public final int INDEX;

    LocationTableColumns(int index) {
        this.INDEX = index;
    }
}
