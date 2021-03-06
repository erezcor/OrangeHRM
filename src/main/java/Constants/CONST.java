package Constants;

import static Processes.NumberUtils.getRandomNumberAsString;

public class CONST {
    public static String ADMIN_USERNAME = "opensourcecms";
    public static String ADMIN_PASSWORD = "opensourcecms";

    public static String ORGANIZATION_NAME = "Erez Company";
    public static String ORGANIZATION_EMAIL = "admin@erez.com";
    public static String ORGANIZATION_PHONE_NUMBER = "+9753454964";
    public static String ORGANIZATION_FAX_NUMBER = "+23139218329";

    public static String LOCATION_NAME = "Buenos Aires" + getRandomNumberAsString();
    public static Country LOCATION_COUNTRY = Country.ARGENTINA;

    public static int SECONDS_TO_WAIT = 20;
}
