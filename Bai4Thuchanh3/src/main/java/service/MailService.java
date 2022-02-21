package service;

import model.Mail;

import java.util.ArrayList;
import java.util.Arrays;


public class MailService implements IMailService {
    private Mail mail = new Mail();


    @Override
    public void save(Mail mail) {
        this.mail = mail;
    }

    @Override
    public Mail view() {
        return this.mail;
    }


}
