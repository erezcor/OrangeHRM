package Constants.Table;

public enum LocationTableColumns implements TableColumn {
    CHECKBOX (0, "input"),
    NAME (1, "a"),
    CITY (2, ""),
    COUNTRY (3, ""),
    PHONE (4, ""),
    NUMBER_OF_EMPLOYEES (5, "");

    public final int INDEX;
    public final String TAG;

    LocationTableColumns(int index, String tag) {
        this.INDEX = index;
        this.TAG = tag;
    }

    @Override
    public int getIndex() {
        return INDEX;
    }

    @Override
    public String getTagSelector() {
        return TAG;
    }
}
