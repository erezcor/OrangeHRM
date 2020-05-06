package Constants;

public enum LocationTableColumns {
    CHECKBOX (0, "input"),
    NAME (1, "a"),
    CITY (2, ""),
    COUNTRY (3, ""),
    PHONE (4, ""),
    NUMBER_OF_EMPLOYEES (5, "");

    public final int INDEX;
    public final String SELECTOR;

    LocationTableColumns(int index, String selector) {
        this.INDEX = index;
        this.SELECTOR = selector;
    }
}
