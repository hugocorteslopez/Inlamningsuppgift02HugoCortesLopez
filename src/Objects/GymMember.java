package Objects;

import java.time.LocalDate;

/**
 * Created by Hugo Cortes Lopez
 * Date:    2020-10-14
 * Time:    15:19
 * Project: Inlamningsuppgift02HugoCortesLopez
 */
public class GymMember {
    protected String fullName;
    protected String socialSecurityNumber;
    protected LocalDate dateOfBoughtMembership;

    public GymMember(String socialSecurityNumber, String fullName, LocalDate dateOfBoughtMembership) {
        this.fullName = fullName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBoughtMembership = dateOfBoughtMembership;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public LocalDate getDateOfBoughtMembership() {
        return dateOfBoughtMembership;
    }
}
