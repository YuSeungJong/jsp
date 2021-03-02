package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.MemberVo;
import kr.or.ddit.user.model.UserVO;

public interface UserDaoI {
	
	// 전체 사용자 정보 조회
	/* SELECT *
	 * FROM users;
	 */
	
	List<UserVO> selectAllUser();
	
	//userid에 해당하는 사용자 한명의 정보 조회
	UserVO selectUser(String userid);
	
	//사용자 페이징 조회
	List<UserVO> selectPagingUser(PageVo pageVo);
	
	
	List<MemberVo> selectAllMember();
	
	//사용자 전체 수 조회
	int selectAllCnt();
	
	//member 페이징 조회
	List<MemberVo> selectPagingMember(PageVo pageVo);
	
	//member 전체 수 조회
	int selectAllMemCnt();
	
	//사용자 정보 수정
	int modifyUser(UserVO userVo);
	
	//사용자 정보 추가
	int insertUser(UserVO userVo);

	int deleteUser(String userid);
}

























