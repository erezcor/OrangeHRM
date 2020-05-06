package Entities;

import Constants.Country;
import lombok.Builder;
import lombok.Getter;

import static Constants.Country.ARGENTINA;
import static Processes.NumberUtils.getRandomNumberAsString;
import static Processes.StringUtils.getRandomString;
import static lombok.Builder.Default;

@Getter
@Builder (builderMethodName = "generateLocation")
public class Location {
    @Default
    private String name = getRandomString();

    @Default
    private Country country = ARGENTINA;

    @Default
    private String province = getRandomString();

    @Default
    private String city = getRandomString();

    @Default
    private String address = getRandomString();

    @Default
    private String zipCode = getRandomNumberAsString();

    @Default
    private String phone = getRandomNumberAsString();

    @Default
    private String fax = getRandomNumberAsString();

    @Default
    private String notes = getRandomString();
}
