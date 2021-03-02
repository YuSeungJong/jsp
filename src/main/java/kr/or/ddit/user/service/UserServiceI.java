package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.MemberVo;
import kr.or.ddit.user.model.UserVO;

public interface UserServiceI {
	List<UserVO> selectAllUser();
	
	//userid에 해당하는 사용자 한명의 정보 조회
	UserVO selectUser(String userid);
	
	Map<String, Object> selectPagingUser(PageVo pageVo);
	
	List<MemberVo> selectAllMember();
	
	//사용자 전체 수 조회
	int selectAllCnt();
	
	Map<String, Object> selectPagingMember(PageVo paveVo);
	
	int modifyUser(UserVO userVo);
	
	int insertUser(UserVO userVo);
	
	//사용자 삭제
	int deleteUser(String userid);
	
	
}
