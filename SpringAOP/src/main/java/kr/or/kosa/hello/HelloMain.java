package kr.or.kosa.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.kosa.hello.controller.HelloController;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= 
				new ClassPathXmlApplicationContext("application-config.xml");
	HelloController controller =context.getBean("helloController",HelloController.class);
	controller.hello("홍길동");
	controller.hello("가은");
	}

}
