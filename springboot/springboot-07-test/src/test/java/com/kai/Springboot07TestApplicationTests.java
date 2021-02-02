package com.kai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot07TestApplicationTests {


    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("notice");
        mailMessage.setText("hello");
        mailMessage.setTo("2570650250@qq.com");
        mailMessage.setFrom("2570650250@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void test() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("hello");
        helper.setText("<p style='color:red'>hello</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File(""));

        helper.setTo("2570650250@qq.com");
        helper.setFrom("2570650250@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
     *
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);

        helper.setSubject(subject);
        helper.setText(text,true);
        //附件
        helper.addAttachment("1.jpg",new File(""));

        helper.setTo("2570650250@qq.com");
        helper.setFrom("2570650250@qq.com");
        mailSender.send(mimeMessage);
    }

}
