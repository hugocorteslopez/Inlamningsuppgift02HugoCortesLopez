package Utility;

import Domain.GymMember;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hugo Cortes Lopez
 * Date:    2020-10-14
 * Time:    15:26
 * Project: Inlamningsuppgift02HugoCortesLopez
 */
public class IOUtil {

    public static List<GymMember> findMembersInFile(String filePath, String input) throws IOException {
        if (input.trim().equals(""))
            return null;
        Path path = Paths.get(filePath);
        List<GymMember> foundMembers = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String[] currentLine = scanner.nextLine().split(", ");
                if (currentLine.length == 2) {
                    var SSN = currentLine[0];
                    var name = currentLine[1];
                    var date = LocalDate.parse(scanner.nextLine());
                    if (input.trim().equalsIgnoreCase(name.trim()) || input.trim().equalsIgnoreCase(SSN.trim())) {
                        var member = new GymMember(SSN, name, date);
                        foundMembers.add(member);
                    }
                }
            }
        }
        return foundMembers;
    }

    public static void writeDataToFile(String folderPath, GymMember member) {
        Path outFilePath = Paths.get(folderPath + "\\" + member.getFullName() + member.getSocialSecurityNumber() + ".txt");
        try (FileWriter w = new FileWriter(outFilePath.toFile(), true)) {
            w.write("Kunden klockade in sig: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
