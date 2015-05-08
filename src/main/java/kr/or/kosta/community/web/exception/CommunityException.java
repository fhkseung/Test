package kr.or.kosta.community.web.exception;

/**
 * ������Ʈ���� ����� ����� ���� ���� Ŭ����
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
