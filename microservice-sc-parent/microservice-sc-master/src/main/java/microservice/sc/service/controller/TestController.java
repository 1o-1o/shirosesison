package microservice.sc.service.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {


	@CrossOrigin
	@GetMapping("/test")
	public Object  select(){
		return "登录成功，已成功访问A项目接口";
	}

}
