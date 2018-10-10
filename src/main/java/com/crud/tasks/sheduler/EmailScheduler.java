package com.crud.tasks.sheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.GetAllTasksEmailService;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private GetAllTasksEmailService getAllTasksEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail(){
        long size = taskRepository.count();
        String taskSingularOrPlural = " tasks";
        if(size == 1) {
            taskSingularOrPlural = " task";
        }
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                null,
                SUBJECT,
                "Currently in database you got: " + size + taskSingularOrPlural)
        );
    }

    @Scheduled(cron = "0 0 16 * * *")
    public void sendInformationOfAllTasks(){
        long size = taskRepository.count();
        String taskSingularOrPlural = " tasks";
        if(size == 1) {
            taskSingularOrPlural = " task";
        }
        getAllTasksEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                null,
                SUBJECT,
                "Quantity of your tasks: " + size + taskSingularOrPlural)
        );
    }
}
