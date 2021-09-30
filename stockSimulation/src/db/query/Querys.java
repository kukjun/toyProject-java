package db.query;

import db.DBAccess;
import db.table.Stock;
import db.table.TUser;
import main.InStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querys {

  public boolean isUser(TUser user) {
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

  public boolean isStock(TUser user, Stock stock) {
    String query = "SELECT * FROM user, stock WHERE user.id = stock.id AND user.id = ? AND stock.name= ? ";
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
  public boolean login(TUser user) {
    String query = "SELECT id, password, authority, nickname, asset FROM user WHERE id = ? AND password = ?";
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
        if(rs.next()) {
          // 만약 authority 가 false 이면 -> 맴버
          if(!rs.getBoolean(3)) {
            user.setNickname(rs.getString(4));
            user.setAsset(rs.getInt(5));
          }
          // 관리자가 아니면 괜찮음
          return true;
        }
        // 예외처리 필요
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //비정상 종료
    return false;
  }

  public boolean register(TUser user) {
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
      pstmt.setBoolean(4, user.isAuthority());
      pstmt.setInt(5, user.getAsset());

      int retValue = pstmt.executeUpdate();

      System.out.println(retValue + "건의 사항 처리");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean sellStock(TUser user, Stock stock, int count) {
    // 만약 없는 주식이면
    if(!isStock(user, stock)) {
      return false;
    }
    // 있는 주식이면
    else {
      // 개수가
      if(stock.getCount()=count) {

      }
    }
  }


}
