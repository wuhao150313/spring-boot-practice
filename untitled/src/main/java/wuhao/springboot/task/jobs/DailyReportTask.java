package wuhao.springboot.task.jobs;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wuhao.springboot.task.service.MailService;

import java.time.LocalDateTime;

/**
 * @author PC
 */
@Component
@Slf4j
@AllArgsConstructor
public class DailyReportTask {
    private final MailService mailService;

    @Scheduled(cron ="0 39 20 * * ?")
    public void sendReport() {
        String report = "这是每日报表的内容";
        mailService.sendMail("1840165925@qq.com","每日数据报表",report);
        log.info("报表已生成，并发送邮件完成 {}", LocalDateTime.now());
    }

}
