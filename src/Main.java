import Utility.GymUtil;
import Utility.IOUtil;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hugo Cortes Lopez
 * Date:    2020-10-14
 * Time:    15:42
 * Project: Inlamningsuppgift02HugoCortesLopez
 */
public class Main {

    public Main() {
        String filePath = "src/customers.txt";
        String folderPath = "src/CustomerFolder";

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, "Välkommen till gymmet! Vänligen ange namn eller personnummer.", "Gymregister", JOptionPane.INFORMATION_MESSAGE);

                if (input == null)
                    System.exit(0);

                var member = IOUtil.findMemberInFile(filePath, input);

                var isMemberValid = false;
                if (member != null)
                    isMemberValid = GymUtil.isMemberEligable(member);

                if (member == null) {
                    JOptionPane.showMessageDialog(null, "Personen hittas ej i systemet, vänligen pröva igen.",
                            "Not Found", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                if (isMemberValid) {
                    JOptionPane.showMessageDialog(null, "Kunden har ett aktivt medlemskap");
                    IOUtil.writeDataToFile(folderPath, member);
                    JOptionPane.showMessageDialog(null, "Kunden har klockats in.");
                } else {
                    JOptionPane.showMessageDialog(null, "Kundens medlemskap har upphört, vänligen förnya.");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
