package test.com.project.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project.model.EmotionDAO;
import com.project.model.InteractionDAO;
import com.project.model.UserDAO;
import com.project.model.WriterDAO;

public class DAOJUnitTest {
	static WriterDAO wDao;
	static UserDAO uDao;
	
	static InteractionDAO iDao;
	static EmotionDAO eDao;
	
	@BeforeClass
	public static void 테스트_시작() {
		System.out.println("테스트 시작");
		uDao = new UserDAO();
		wDao = new WriterDAO();
		
		iDao = new InteractionDAO();
		eDao = new EmotionDAO();
	}
	
	@Before
	public void startUnitTest(){
		System.out.println("단위테스트 시작");
	}
	
//	@Test
//	public void getFriendWriteListTest() {
//		try {
//			assertNotNull(wDao.getFriendWriteList("test2"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void isReactedTest() {
//		try {
//			assertTrue(iDao.isReacted("test1", "1"));
//			assertFalse(iDao.isReacted("test1", "2"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void addUserTest() {
//		try {
//			assertTrue(uDao.addUser("test6", "테스트6", "테스트6", "1234", "rkacskrl@naver.com", "01011112222"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void loginTest() {
//		try {
//			assertNotNull(uDao.login("test6", "1234"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
//	@Test
//	public void findIdTest() {
//		try {
//			assertNotNull(uDao.findId("테스트1", "test1@naver.com"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void findPwTest() {
		try {
			assertNotNull(uDao.findPw("테스트1", "test1@naver.com"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void diaryWriteTest() {
//		try {
//			assertTrue(wDao.diaryWrite("JUnit 글작성 테스트", "test5", "813"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void diaryModifyTest() {
//		try {
//			assertTrue(wDao.diaryModify("test5", "8", "먹고살수있겠지?"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void diaryRemoveTest() {
//		try {
//			assertTrue(wDao.diaryRemove("test5", "9"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//		//없는 번호를 검색해도 그 코드에 대한 글이 없기때문에 null로 표시되기떄문에 
//	@Test//없는 번호를 넣어도 실행에 문제는 없다.
//	public void getHomeBoardListTest() {
//		try {
//			assertNotNull(wDao.getHomeBoardList("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void setShareStatusTest() {
//		try {
//			assertTrue(wDao.setShareStatus("공유", "3", "test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void getNewBoardListTest() {
//		try {
//			assertNotNull(wDao.getNewBoardList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void getNowRecommendedBoardListTest() {
//		try {
//			assertNotNull(wDao.getNowRecommendedBoardList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	//InteractionDAO
//	@Test //즐겨찾기 글 목록 조회
//	public void getBookmarkListTest() {
//		try {
//			assertNotNull(iDao.getBookmarkList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test //즐겨찾기 글 추가
	public void addBookmarkTest() {
		try {
			assertTrue(iDao.addBookmark("test1", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test //즐겨찾기 글 삭제
	public void deleteBookmarkTest() {
		try {
			assertTrue(iDao.deleteBookmark("test1", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test //즐겨찾기 글 상세조회
//	public void getBookmarkWriteTest() {
//		try {
//			assertNotNull(iDao.getBookmarkWrite("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test //팔로우(친구추가)
	public void addFollowTest() {
		try {
			assertTrue(iDao.addFollow("test2", "test5").equals("false"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //팔로우(목록조회)
	public void getFollowListTest() {
		try {
			assertNotNull(iDao.getFollowList("test1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //좋아요 추가
	public void addReactionTest() {
		try {
			assertTrue(iDao.addReaction("test4", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test //좋아요 삭제
	public void deleteReactionTest() {
		try {
			assertTrue(iDao.deleteReaction("test4", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
//	//EmotionDAO
//	@Test//감정 8개 추출
//	public void getEmotionNameTest() {
//		try {
//			assertNotNull(eDao.getEmotionName());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//감정 선택
//	public void addEmpathyTest() {
//		try {
//			assertTrue(eDao.addEmpathy("test2", "220"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//감정 트렌드 조회
//	public void getTrendEmotionTest() {
//		try {
//			assertNotNull(eDao.getTrendEmotion());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//트렌드 글 상세조회
//	public void getTrendWriteTest() {
//		try {
//			assertNotNull(eDao.getTrendWrite("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//제시어 선택
//	public void selectSuggestionTest() {
//		try {
//			assertNotNull(eDao.selectSuggestion("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void getBookmarkedWriteTest() {
		try {
			assertNotNull(iDao.getBookmarkedWriteList("test1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void getBookmarkedWriteListTest() {
//		try {
//			assertNotNull(iDao.getBookmarkedWriteList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void searchByPenNameTest() {
//		assertNotNull(wDao.searchByPenName("pen_test1", "22/05/10"));
//	}
//	@Test
//	public void searchBySuggestionNameTest() {
//		assertNotNull(wDao.searchBySuggestionName("고기", "22/05/10"));
//	}
//	@Test
//	public void getHomeBoardListTest() {
//		
//	}
//	@Test
//	public void getNewBoardListTest() {
//		try {
//			assertNotNull(wDao.getNewBoardList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void getNowRecommendedBoardListTest() {
//		try {
//			assertNotNull(wDao.getNowRecommendedBoardList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void getFriendWriteListTest() {
//		try {
//			assertNotNull(wDao.getFriendWriteList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void getWriteDetailTest() {
		try {
			assertNotNull(wDao.getWriteDetail("1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	@Test
//	public void getTrendWriteTest() {
//		try {
//			assertNotNull(wDao.getTrendWrite("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void getSortedByDateFollowListTest() {
//		try {
//			assertNotNull(iDao.getSortedByDateFollowList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void getSortedByPenNameFollowListTest() {
//		try {
//			assertNotNull(iDao.getSortedByPenNameFollowList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void addReactionTest() {
//		try {
//			assertTrue(iDao.addReaction("test5", "6"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void deleteReactionTest() {
//		try {
//			assertTrue(iDao.deleteReaction("test5", "6"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	@Test
	public void isReactedTest() {
		try {
			assertTrue(iDao.isReacted("test2", "1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void countReactionsTest() {
//		try {
//			assertNotNull(iDao.countReactions("1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void isBookmarkedTest() {
		try {
			assertFalse(iDao.isBookmarked("test1", "6"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findIdTest() {
		try {
			assertNotNull(uDao.findId("테스트1", "test1@naver.com"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



























