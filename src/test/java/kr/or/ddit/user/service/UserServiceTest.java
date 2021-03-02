package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserServiceTest {
		
	private UserServiceI userService;
	
	@Before
	public void setup() {
		userService = new UserService();
		
		//테스트에서 사용할 신규 사용자 추가
		UserVO userVo = new UserVO("testUser", "테스트사용자", "testUserPass", 
									new Date(), "대덕", "대전 중구 중앙로 76", "4층", "34940", "brown.png", "uuid-generated");
		
		userService.insertUser(userVo);
		
		//신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("ddit_n");
	}
	
	@After
	public void tearDown() {
		userService.deleteUser("testUser");
	}
	//전체 사용자 조회 테스트
		@Test
		public void selectAllUsertest() {
			/***Given***/

			/***When***/
			List<UserVO> userList = userService.selectAllUser();
			
			/***Then***/
			assertEquals(21, userList.size());
		}
		
		//사용자 아이디를 이용하여 특정 사용자 정보 조회
		@Test
		public void selectUserTest() {
			/***Given***/
			String userid = "brown";

			/***When***/
			UserVO user = userService.selectUser(userid);
			
			/***Then***/
			assertNotNull(user);
			assertEquals("브라운", user.getUsernm());
		}
		
		//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
		
		
		// 사용자 페이징 조회 테스트
		@Test
		public void selectPagingTest() {
			/***Given***/
			PageVo pageVo = new PageVo(2, 5);
			
			/***When***/
			Map<String, Object> map = userService.selectPagingUser(pageVo);
			List<UserVO> userList = (List<UserVO>)map.get("userList");
			int userCnt = (int)map.get("userCnt");
			
			/***Then***/
			assertEquals(5, userList.size());
			assertEquals(21, userCnt);
		}
		
		@Test
		public void selectAllUserCntTest() {
			/***Given***/

			/***When***/
			int userCnt = userService.selectAllCnt();

			/***Then***/
			assertEquals(21, userCnt);
		}
		
		@Test
		public void modifyUserTest() {
			/***Given***/
			
			//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
			UserVO userVo = new UserVO("ddit", "대덕인재", "dditpass", new Date(), "개발원 m", "대전시 중구 중앙로76", "4층 대덕인재개발원", "34940", "brown.png", "uuid-generated");
			
			/***When***/
			int updateCnt = userService.modifyUser(userVo);
			
			/***Then***/
			assertEquals(1, updateCnt);
		}
		
		@Test
		public void insertUserTest() {
			/***Given***/
			userService.deleteUser("ddit_n");
			//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
			UserVO userVo = new UserVO("ddit_n", "대덕인", "dditpass", new Date(), "개발원 i", "대전시 중구 중앙로76", "4층 대덕인재개발원", "34940", "brown.png", "uuid-generated");
			
			/***When***/
			int insertCnt = userService.insertUser(userVo);
			
			/***Then***/
			assertEquals(1, insertCnt);
		}
		
		//삭제 테스트
		@Test
		public void deleteUserTest() {
			/***Given***/
			//해당 테스트가 실행될 때는 testUser라는 사용자가 before 메소드에 의해 등록이 된 상태
			String userid = "testUser";
			
			/***When***/
			int deleteCnt = userService.deleteUser(userid);

			/***Then***/
			assertEquals(1, deleteCnt);
		}
		
}
