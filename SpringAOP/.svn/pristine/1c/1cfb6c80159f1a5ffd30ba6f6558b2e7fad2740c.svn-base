package kr.or.kosa.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import kr.or.kosa.hello.service.IHelloService;
import kr.or.kosa.hello.util.HelloLog;
@Controller
public class HelloController {
	@Autowired
//	@Qualifier("helloServiceProxy")
	IHelloService helloService;
	public void hello(String name){
		//HelloLog.log();
		System.out.println(helloService.sayHello(name));
	}
	public void bye(String name){
		//HelloLog.log();
		System.out.println(helloService.sayGoodbye(name));
	}
}
