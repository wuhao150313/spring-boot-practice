package wuhao.springboot.configure.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.configure.service.ConfigBackupService;

/**
 * @author PC
 */
@RestController
@AllArgsConstructor
public class ConfigBackupController {
    private final ConfigBackupService configBackupService;

    @GetMapping("/backup")
    public void backupConfig() {
        configBackupService.backupConfigFile();
    }
}
