package db.query;

import db.DBAccess;
import db.table.Stock;
import db.table.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

  // id의 유저가 있는지 확인하는 query
  public boolean isUser(User user) {
    String query = "SELECT * FROM user WHERE id = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, user.getId());
      try (
          ResultSet rs = pstmt.executeQuery()
      ) {
        // rs에 저장된게 없으면 false, 있으면 true
        return rs.next();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //비정상 종료
    return false;
  }

  // id의 유저가 해당 name 의 stock 을 가지고 있는지 확인하는 query
  public boolean isStock(User user, Stock stock) {
    String query = "SELECT U.id AS id, S.name AS stockName, S.purchasePrice AS purchasePrice, S.count AS count " +
        "FROM user U, stock S " +
        "WHERE U.id = S.user_id " +
        "AND user.id = ? " +
        "AND stock.name= ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, user.getId());
      pstmt.setString(2, stock.getName());
      try (
          ResultSet rs = pstmt.executeQuery()
      ) {
        // rs에 저장된게 없으면 false, 있으면 true
        return rs.next();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //비정상 종료
    return false;
  }

  // 세분화 할 경우 필요할 수도 있음
  public boolean login(User user) {
    String query = "SELECT id, password, authority, nickname, asset " +
        "FROM user " +
        "WHERE id = ? " +
        "AND password = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, user.getId());
      pstmt.setString(2, user.getPassword());
      try (
          ResultSet rs = pstmt.executeQuery()
      ) {
        // 만약 rs.next() 가 true -> 튜플 존재
        if (rs.next()) {
          // 만약 authority 가 TRUE이면
          if (rs.getInt("authority") == User.Authority.TRUE.ordinal()) {
            user.setNickname(rs.getString("nickname"));
            user.setAsset(rs.getInt("asset"));
          }
          // 관리자가 아니면 괜찮음
          return true;
        }
        // 예외 발생 처리
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //비정상 종료
    return false;
  }

  public boolean register(User user) {
    if (isUser(user)) {
      return false;
    }
    String query = "INSERT INTO user(id, nickname, password, authority, asset)" +
        "VALUES (?, ?, ?, ?, ?)";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setString(1, user.getId());
      pstmt.setString(2, user.getNickname());
      pstmt.setString(3, user.getPassword());
      pstmt.setInt(4, user.getAuthority().ordinal());
      pstmt.setInt(5, user.getAsset());

      int retValue = pstmt.executeUpdate();

      System.out.println(retValue + "건의 사항 처리");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean sellStock(User user, Stock stock, int count) {
    int inCount = 0;
    if (isStock(user, stock)) {
      inCount = findStockCount(user, stock);
    }
    if(inCount == count) {
      // Stock 삭제 연산
    }
    else if (inCount <= count) {
      // Stock Update 연산
    }
    else {
      // 예외 처리
    }
    return false;
  }

  public int findStockCount(User user, Stock stock) {
    // 먼저 몇 개 있는 확인
    String FindCountQuery = "SELECT S.count AS count " +
        "FROM user U, stock S " +
        "WHERE U.id = S.user_id " +
        "AND U.id = ? " +
        "AND S.name = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(FindCountQuery)
    ) {
      pstmt.setString(1, user.getId());
      pstmt.setString(2, stock.getName());
      try (
          ResultSet rs = pstmt.getResultSet()
      ) {
        if (rs.next()) {
          return rs.getInt("count");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

}
