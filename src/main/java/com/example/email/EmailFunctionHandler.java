package com.example.email;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.example.email.model.Email;
import com.example.email.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailFunctionHandler implements RequestHandler<SQSEvent, Void> {

    private static final Logger log = LoggerFactory.getLogger(EmailFunctionHandler.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final EmailService emailService = new EmailService();

    @Override
    public Void handleRequest(SQSEvent sqsEvent, Context context) {
        for (SQSEvent.SQSMessage message : sqsEvent.getRecords()) {
            String messageBody = message.getBody();
            try {
                log.info("Iniciando envio de email!!");
                Email sentEmail = mapper.readValue(messageBody, Email.class);
                emailService.sendEmail(sentEmail);
                log.info("Email enviado com sucesso!");
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
