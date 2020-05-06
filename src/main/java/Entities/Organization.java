package Entities;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import static Constants.CONST.*;

@Getter
@Builder(builderMethodName = "anOrganizationDetails")
public class Organization {
    @Default
    private String name = ORGANIZATION_NAME;

    @Default
    private String email = ORGANIZATION_EMAIL;

    @Default
    private String faxNumber = ORGANIZATION_FAX_NUMBER;

    @Default
    private String phoneNumber = ORGANIZATION_PHONE_NUMBER;
}
