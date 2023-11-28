package com.ms.user.producer;

import com.ms.user.dto.JmsEmailDetails;

public interface IEmailProduce {

    void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails);

}
