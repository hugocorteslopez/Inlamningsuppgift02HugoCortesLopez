package Utility;

import Objects.GymMember;

import java.time.LocalDate;

/**
 * Created by Hugo Cortes Lopez
 * Date:    2020-10-14
 * Time:    21:12
 * Project: Inlamningsuppgift02HugoCortesLopez
 */
public class GymUtil {

    public static boolean isMemberEligable(GymMember p) {
        if (p.getDateOfBoughtMembership() == null)
            throw new NullPointerException("Date of bought membership may not be null");
        LocalDate lastValidDate = LocalDate.now().minusYears(1);
        return lastValidDate.isBefore(p.getDateOfBoughtMembership());
    }
}
