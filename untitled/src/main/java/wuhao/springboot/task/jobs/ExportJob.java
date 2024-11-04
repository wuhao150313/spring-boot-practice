//package wuhao.springboot.task.jobs;
//
//
//import cn.hutool.core.lang.UUID;
//import com.alibaba.excel.EasyExcel;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//import wuhao.springboot.task.entity.Student;
//import wuhao.springboot.task.mapper.StudentMapper;
//
//import java.util.List;
//
///**
// * @author PC
// */
//@Slf4j
//@AllArgsConstructor
//public class ExportJob extends QuartzJobBean {
//    protected final StudentMapper studentMapper;
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        log.info("开始执行导出任务");
//        List<Student> students = studentMapper.selectList(null);
//        String fileName = "/F:/桌面/新建文件夹/" + UUID.randomUUID()+".xlsx";
//
//        EasyExcel.write(fileName, Student.class)
//                .sheet("学生数据")
//                .doWrite(() -> students);
//    }
//}
