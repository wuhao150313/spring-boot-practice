//package wuhao.springboot.task.config;
//
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import wuhao.springboot.task.jobs.SimpleQuartzTask;
//
///**
// * @author PC
// */
//@Configuration
//public class SimpleQuartzConfig {
//    @Bean
//    public JobDetail jobDetail() {
//        return JobBuilder.newJob(SimpleQuartzTask.class)
//                .withIdentity("simpleQuartzTask")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger trigger() {
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(jobDetail())
//                .withIdentity("simpleQuartzTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//}
