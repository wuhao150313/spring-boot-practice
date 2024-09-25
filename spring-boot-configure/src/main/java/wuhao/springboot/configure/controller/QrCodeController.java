package wuhao.springboot.configure.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wuhao.springboot.configure.service.QrcodeService;

/**
 * @author PC
 */
@RestController
@AllArgsConstructor
public class QrCodeController {

    private final QrcodeService qrcodeService;

    @GetMapping("/qrcode")
    public void qrcode() {
        qrcodeService.generateCode();
    }
}
