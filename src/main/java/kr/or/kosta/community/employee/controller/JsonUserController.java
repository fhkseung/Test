package kr.or.kosta.community.employee.controller;


import java.util.Map;

import kr.or.kosta.community.employee.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSON 송수신 샘플 컨트롤러
 */
@Controller
@RequestMapping("/user")
public class JsonUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonUserController.class);
	
	
	/**
	 * @ResponseBody를 사용하면 해당 콘트롤러 메소드에서 리턴하는 값이 바로 응답 바디가 되므로
	 * 다른 뷰로 사용하지 않고도 간단한 응답을 클라이언트에게 직접 전송할 수 있다
	 * 주로 AJAX 통신에서 XML, JSON 전송 시 사용
	 */
	
	
	
	@RequestMapping(value = "/json", produces="application/json; charset=utf8")
	@ResponseBody
	//내가 직접 데이터를 만들어서 브라우져에 보낼때는 아래와 같이 JSON문법에 맞게 문자열을 만들어줘야 한다.
	public  String json(){
		// Json 데이터 : {"name": "홍길동","age": 21}
	    String jsonResult = "{\"name\": \"홍길동\",\"age\": 21}" ;
		return jsonResult;
	}
	
	
	
	@RequestMapping(value = "/json1", method=RequestMethod.POST)
	//자바스크립트에서 모든 객체는 Map타입이기 때문에(실제로는 연관배열) 서버쪽에서 해당 데이터를 받는 가장 좋은 방법이 MAP이 된다.
	public @ResponseBody User json1(@RequestBody Map<String, Object> map) {
		logger.info("/user/json1 요청 처리");
		logger.info(map.toString());
		return new User("hong", "홍길동", "1111");
	}
	
	
	
	@RequestMapping(value = "/json2", method=RequestMethod.POST)
	//서버쪽에서 JSON을 받을때는 MAP으로 받는 것이 좋으나(자바스크립트는 모든 객체가 맵이므로)아래와 같이 도메인클래스로 받을 수도 있다.
	public @ResponseBody User json(@RequestBody User user) {
		logger.info("/user/json2 요청 처리");
		logger.info(user.toString());
		return user;
	}
}


