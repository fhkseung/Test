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
 * JSON �ۼ��� ���� ��Ʈ�ѷ�
 */
@Controller
@RequestMapping("/user")
public class JsonUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonUserController.class);
	
	
	/**
	 * @ResponseBody�� ����ϸ� �ش� ��Ʈ�ѷ� �޼ҵ忡�� �����ϴ� ���� �ٷ� ���� �ٵ� �ǹǷ�
	 * �ٸ� ��� ������� �ʰ� ������ ������ Ŭ���̾�Ʈ���� ���� ������ �� �ִ�
	 * �ַ� AJAX ��ſ��� XML, JSON ���� �� ���
	 */
	
	
	
	@RequestMapping(value = "/json", produces="application/json; charset=utf8")
	@ResponseBody
	//���� ���� �����͸� ���� �������� �������� �Ʒ��� ���� JSON������ �°� ���ڿ��� �������� �Ѵ�.
	public  String json(){
		// Json ������ : {"name": "ȫ�浿","age": 21}
	    String jsonResult = "{\"name\": \"ȫ�浿\",\"age\": 21}" ;
		return jsonResult;
	}
	
	
	
	@RequestMapping(value = "/json1", method=RequestMethod.POST)
	//�ڹٽ�ũ��Ʈ���� ��� ��ü�� MapŸ���̱� ������(�����δ� �����迭) �����ʿ��� �ش� �����͸� �޴� ���� ���� ����� MAP�� �ȴ�.
	public @ResponseBody User json1(@RequestBody Map<String, Object> map) {
		logger.info("/user/json1 ��û ó��");
		logger.info(map.toString());
		return new User("hong", "ȫ�浿", "1111");
	}
	
	
	
	@RequestMapping(value = "/json2", method=RequestMethod.POST)
	//�����ʿ��� JSON�� �������� MAP���� �޴� ���� ������(�ڹٽ�ũ��Ʈ�� ��� ��ü�� ���̹Ƿ�)�Ʒ��� ���� ������Ŭ������ ���� ���� �ִ�.
	public @ResponseBody User json(@RequestBody User user) {
		logger.info("/user/json2 ��û ó��");
		logger.info(user.toString());
		return user;
	}
}


