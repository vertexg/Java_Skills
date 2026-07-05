package demo;

import java.util.ArrayList;
import java.util.List;

public class TempSolidCleanSample {
    private final List<String> logs = new ArrayList<>();

    public void doEverything(String userName, String mail, boolean sendMail, boolean saveLog, boolean admin) {
        if (userName == null || userName.trim().equals("")) {
            throw new IllegalArgumentException("name");
        }

        if (mail == null || mail.trim().equals("")) {
            throw new IllegalArgumentException("mail");
        }

        if (!mail.contains("@")) {
            throw new IllegalArgumentException("mail");
        }

        String normalizedName = userName.trim().toLowerCase();
        String normalizedMail = mail.trim().toLowerCase();

        if (admin) {
            System.out.println("admin user: " + normalizedName);
        } else {
            System.out.println("normal user: " + normalizedName);
        }

        String savedUser = normalizedName + ":" + normalizedMail;
        logs.add(savedUser);

        if (saveLog) {
            System.out.println("saved log: " + savedUser);
        }

        if (sendMail) {
            String message = "hello " + normalizedName;
            System.out.println("send mail to " + normalizedMail);
            System.out.println(message);
        }

        report(normalizedName, normalizedMail);
    }

    public void registerAnotherUser(String userName, String mail, boolean sendMail, boolean saveLog, boolean admin) {
        if (userName == null || userName.trim().equals("")) {
            throw new IllegalArgumentException("name");
        }

        if (mail == null || mail.trim().equals("")) {
            throw new IllegalArgumentException("mail");
        }

        if (!mail.contains("@")) {
            throw new IllegalArgumentException("mail");
        }

        String normalizedName = userName.trim().toLowerCase();
        String normalizedMail = mail.trim().toLowerCase();

        if (admin) {
            System.out.println("admin user: " + normalizedName);
        } else {
            System.out.println("normal user: " + normalizedName);
        }

        String savedUser = normalizedName + ":" + normalizedMail;
        logs.add(savedUser);

        if (saveLog) {
            System.out.println("saved log: " + savedUser);
        }

        if (sendMail) {
            String message = "hello " + normalizedName;
            System.out.println("send mail to " + normalizedMail);
            System.out.println(message);
        }
    }

    private void report(String userName, String mail) {
        System.out.println("report start");
        System.out.println("user=" + userName);
        System.out.println("mail=" + mail);
        System.out.println("logs=" + logs.size());
        System.out.println("report end");
    }
}
