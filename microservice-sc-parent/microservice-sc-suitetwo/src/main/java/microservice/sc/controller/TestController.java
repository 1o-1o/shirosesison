package microservice.sc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/31.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Object testCx(){
        return "登录成功，已成功访问C项目接口";
    }
}
