package kr.or.kosta.community.web.exception;

/**
 * 프로젝트에서 사용할 사용자 정의 예외 클래스
 * @author SD
 *
 */

public class CommunityException extends RuntimeException{
	
	public CommunityException(String message){
		super(message);
	}
	
	public CommunityException(Exception ex){
		super(ex.getClass().getName() + " : " + ex.getMessage());
	}
	
}
