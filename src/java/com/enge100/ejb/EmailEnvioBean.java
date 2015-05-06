package com.enge100.ejb;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Stateless
public class EmailEnvioBean {
    
    
    public void envioEmail(String paraemail, String usuario, String senha,
            String email, String assunto, String mensagem){
    
                try {
                        
            Properties prop = System.getProperties();
            
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.fallback", "false");
            
            Session mailSession = Session.getDefaultInstance(prop,null);
            mailSession.setDebug(true);
            
            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress(paraemail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            
            mailMessage.setContent(mensagem, "text/html");
            mailMessage.setSubject(assunto);
            
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", senha, assunto);
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
                                  
            
                        mailMessage.setFrom(new InternetAddress(paraemail));
                    } catch (Exception ex) {
                        Logger.getLogger(EmailEnvioBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
           
                }
    }

        
    