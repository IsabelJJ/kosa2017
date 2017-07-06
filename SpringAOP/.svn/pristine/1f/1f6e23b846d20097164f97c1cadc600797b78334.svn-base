package kr.or.kosa.hello.service;

import org.springframework.stereotype.Service;

import kr.or.kosa.hello.util.HelloLog;

@Service
public class HelloService implements IHelloService {
	
	
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		//System.out.println(new java.util.Date());
		//HelloLog.log();//횡단적 산재
		return "hello"+name;
	}

	@Override
	public String sayGoodbye(String name) {
		// TODO Auto-generated method stub
		return "bye"+name;
	}

}
