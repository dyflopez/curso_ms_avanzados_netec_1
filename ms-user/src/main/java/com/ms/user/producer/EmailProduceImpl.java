package com.ms.user.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.user.dto.JmsEmailDetails;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class EmailProduceImpl implements  IEmailProduce{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final JmsTemplate jmsTemplate;

    public EmailProduceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails) {
        try {

            final String messageBody = convertToJson(jmsEmailDetails);


            jmsTemplate.setPubSubDomain(false);

            jmsTemplate.convertAndSend(
                    "ms.send.email.queue",
                    messageBody
            );

        } catch (JmsException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public static String convertToJson(@NotNull final Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
