package kr.or.kosa.hello.service.proxy;

import org.springframework.stereotype.Component;

import kr.or.kosa.hello.service.HelloService;
import kr.or.kosa.hello.util.HelloLog;
@Component
//HelloService : targetObject
//PointCount
public class HelloServiceProxy extends HelloService {
	@Override
	
	public String sayHello(String name){
		String result = super.sayHello(name);
		HelloLog.log();
		return result;
		//핵심코드
	}
}
