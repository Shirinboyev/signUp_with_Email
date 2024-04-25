package backend;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailingServiceImp {
        private static final String USERNAME = "gayratshirinboyev6707@gmail.com";
        private static final String PASSWORD = "hkkg msop oyim kqsa";
        public static void sendCode(String recipient, String text) throws MessagingException {
            Properties properties = getProperties();
            Session session = getSesions(properties);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Verification Code");
            message.setText(text);

            Transport.send(message);
        }

        public static Properties getProperties() {
            Properties properties = new Properties();
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.port", "465");
            properties.setProperty("mail.smtp.ssl.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");
            return properties;
        }

        public static Session getSesions(Properties properties) {
            return Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
        }
    }


