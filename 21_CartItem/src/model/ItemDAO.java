package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate {

	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 */
	private static ItemDAO dao = new ItemDAO();

	private ItemDAO() {
			try {
				Class.forName(ServerInfo.DRIVER_NAME);
				System.out.println("드라이버 로딩!");
			} catch (ClassNotFoundException e) {}
		}

	public static ItemDAO getInstance() {
		return dao;
	}

//		public MemberDAO() {
//			try {
//				Class.forName(ServerInfo.DRIVER_NAME);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("db 연결!!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

//	@Override
//	public void registerMember(Item item) throws SQLException {
//		Connection conn = getConnection();
//
//		String query = "INSERT INTO MEMBER_DTO(id, password, name, address) VALUES(?, ?, ?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ps.setString(1, item.getId());
//		ps.setString(2, item.getPassword());
//		ps.setString(3, item.getName());
//		ps.setString(4, item.getAddress());
//
//		ps.executeUpdate();
//
//		closeAll(ps, conn);
//
//	}
//
//	@Override
//	public MemberVO login(String id, String password) throws SQLException {
//		Connection conn = getConnection();
//
//		String query = "SELECT * FROM MEMBER_DTO WHERE id=? AND password=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ps.setString(1, id);
//		ps.setString(2, password);
//
//		ResultSet rs = ps.executeQuery();
//		MemberVO vo = null;
//		if (rs.next()) {
//			vo = new MemberVO();
//			vo.setId(rs.getString("id"));
//			vo.setPassword(rs.getString("password"));
//			vo.setName(rs.getString("name"));
//			vo.setAddress(rs.getString("address"));
//		}
//		closeAll(rs, ps, conn);
//		return vo;
//	}
//
//	@Override
//	public MemberVO findByIdMember(String id) throws SQLException {
//		Connection conn = getConnection();
//
//		String query = "SELECT * FROM MEMBER_DTO WHERE id=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ps.setString(1, id);
//
//		ResultSet rs = ps.executeQuery();
//		MemberVO vo = null;
//		if (rs.next()) {
//			vo = new MemberVO();
//			vo.setId(rs.getString("id"));
//			vo.setPassword(rs.getString("password"));
//			vo.setName(rs.getString("name"));
//			vo.setAddress(rs.getString("address"));
//		}
//		closeAll(rs, ps, conn);
//		return vo;
//	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();

		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		ArrayList<Item> list = new ArrayList<>();
		while (rs.next()) {
			Item item = new Item();
			item.setItemId(rs.getInt("ITEM_ID"));
			item.setItemName(rs.getString("ITEM_NAME"));
			item.setPrice(rs.getInt("PRICE"));
			item.setDescription(rs.getString("DESCRIPTION"));
			item.setPictureUrl(rs.getString("PICTURE_URL"));
			item.setCount(rs.getInt("COUNT"));
			list.add(item);
		}
		closeAll(rs, ps, conn);
		return list;
	}
	
	

	@Override
	public Item getItem(int itemId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		
		try {
			ArrayList<Item> list = dao.getAllItem();
			
			System.out.println(list.get(0).getItemName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Override
//	public int update(Item item) throws SQLException {
//		Connection conn = getConnection();
//		String query = "UPDATE MEMBER_DTO SET PASSWORD = ?, NAME = ?, ADDRESS = ? WHERE ID = ?";
//
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, item.getPassword());
//		ps.setString(2, item.getName());
//		ps.setString(3, item.getAddress());
//		ps.setString(4, item.getId());
//
//		int result = ps.executeUpdate();
//		closeAll(ps, conn);
//		return result;
//	}
//
//	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
//		MemberVO vo = new MemberVO();
//		vo.setId("USER1");
//		vo.setPassword("1234");
//		vo.setName("김미경");
//		vo.setAddress("경기 광주");
////			vo.setId("user1");
////			vo.setPassword("user1");
////			vo.setName("김미경");
////			vo.setAddress("경기 광주");
//
//		try {
//			System.out.println("skskskskskskks");
//			// dao.registerMember(vo);
//
////				vo = dao.login("USER1", "1234");
//
////				System.out.println("name : " + vo.getName());
////				System.out.println("address : " + vo.getAddress());
//			if (dao.update(vo) == 1) {
//				System.out.println("수정성공");
//			} else {
//				System.out.println("수정실패");
//			}
//
//		} catch (SQLException e) {
//		}
//	}
//
//	@Override
//	public ArrayList<Item> getAllItem() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Item getItem(int itemId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean updateRecordCount(int itemId) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
