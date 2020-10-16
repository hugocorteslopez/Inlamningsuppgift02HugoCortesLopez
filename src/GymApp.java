import Utility.GymUtil;
import Utility.IOUtil;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hugo Cortes Lopez
 * Date:    2020-10-16
 * Time:    11:13
 * Project: Inlamningsuppgift02HugoCortesLopez
 */
public class GymApp {
    public static void Init() {
        String filePath = "src/customers.txt";
        String folderPath = "src/CustomerFolder";

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, "Välkommen till gymmet! Vänligen ange namn eller personnummer.", "Gymregister", JOptionPane.INFORMATION_MESSAGE);
                if (input == null)
                    System.exit(0);

                var members = IOUtil.findMembersInFile(filePath, input);
                if (members == null || members.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Personen hittas ej i systemet, vänligen pröva igen.",
                            "Not Found", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                if (members.size() > 1) {
                    JOptionPane.showMessageDialog(null, "Hittade mer än en person, försök söka efter personnumret.",
                            "Multiple Members Found", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                var isMemberValid = GymUtil.isMemberEligable(members.get(0));
                if (isMemberValid) {
                    JOptionPane.showMessageDialog(null, "Kunden har ett aktivt medlemskap");
                    IOUtil.writeDataToFile(folderPath, members.get(0));
                    JOptionPane.showMessageDialog(null, members.get(0).getFullName() + " har klockats in.");
                } else {
                    JOptionPane.showMessageDialog(null, "Kundens medlemskap har upphört, vänligen förnya.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
