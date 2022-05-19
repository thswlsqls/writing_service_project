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
	public static void �׽�Ʈ_����() {
		System.out.println("�׽�Ʈ ����");
		uDao = new UserDAO();
		wDao = new WriterDAO();
		
		iDao = new InteractionDAO();
		eDao = new EmotionDAO();
	}
	
	@Before
	public void startUnitTest(){
		System.out.println("�����׽�Ʈ ����");
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
//			assertTrue(uDao.addUser("test6", "�׽�Ʈ6", "�׽�Ʈ6", "1234", "rkacskrl@naver.com", "01011112222"));
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
//			assertNotNull(uDao.findId("�׽�Ʈ1", "test1@naver.com"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void findPwTest() {
		try {
			assertNotNull(uDao.findPw("�׽�Ʈ1", "test1@naver.com"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void diaryWriteTest() {
//		try {
//			assertTrue(wDao.diaryWrite("JUnit ���ۼ� �׽�Ʈ", "test5", "813"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void diaryModifyTest() {
//		try {
//			assertTrue(wDao.diaryModify("test5", "8", "�԰����ְ���?"));
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
//		//���� ��ȣ�� �˻��ص� �� �ڵ忡 ���� ���� ���⶧���� null�� ǥ�õǱ⋚���� 
//	@Test//���� ��ȣ�� �־ ���࿡ ������ ����.
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
//			assertTrue(wDao.setShareStatus("����", "3", "test1"));
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
//	@Test //���ã�� �� ��� ��ȸ
//	public void getBookmarkListTest() {
//		try {
//			assertNotNull(iDao.getBookmarkList("test1"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test //���ã�� �� �߰�
	public void addBookmarkTest() {
		try {
			assertTrue(iDao.addBookmark("test1", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test //���ã�� �� ����
	public void deleteBookmarkTest() {
		try {
			assertTrue(iDao.deleteBookmark("test1", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test //���ã�� �� ����ȸ
//	public void getBookmarkWriteTest() {
//		try {
//			assertNotNull(iDao.getBookmarkWrite("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test //�ȷο�(ģ���߰�)
	public void addFollowTest() {
		try {
			assertTrue(iDao.addFollow("test2", "test5").equals("false"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //�ȷο�(�����ȸ)
	public void getFollowListTest() {
		try {
			assertNotNull(iDao.getFollowList("test1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //���ƿ� �߰�
	public void addReactionTest() {
		try {
			assertTrue(iDao.addReaction("test4", "7"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test //���ƿ� ����
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
//	@Test//���� 8�� ����
//	public void getEmotionNameTest() {
//		try {
//			assertNotNull(eDao.getEmotionName());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//���� ����
//	public void addEmpathyTest() {
//		try {
//			assertTrue(eDao.addEmpathy("test2", "220"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//���� Ʈ���� ��ȸ
//	public void getTrendEmotionTest() {
//		try {
//			assertNotNull(eDao.getTrendEmotion());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//Ʈ���� �� ����ȸ
//	public void getTrendWriteTest() {
//		try {
//			assertNotNull(eDao.getTrendWrite("110"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test//���þ� ����
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
//		assertNotNull(wDao.searchBySuggestionName("���", "22/05/10"));
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
			assertNotNull(uDao.findId("�׽�Ʈ1", "test1@naver.com"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



























