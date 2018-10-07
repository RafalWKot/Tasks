package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.name}")
    private String adminName;

    @Value("${info.company.name}")
    private String company_name;

    @Value("${info.company.email}")
    private String company_email;

    @Value("${info.company.phone}")
    private String company_phone;
}
