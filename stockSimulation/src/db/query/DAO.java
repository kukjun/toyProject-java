package db.query;

import db.DBAccess;
import db.table.Stock;
import db.table.Member;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

  // id의 유저가 있는지 확인하는 query
  public boolean isMember(Member member) {
    String query = "SELECT * FROM member WHERE id = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, member.getId());
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
  public boolean isMember(String id) {
    String query = "SELECT * FROM member WHERE id = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, id);
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

  // id, password 를 가진 유저가 있는지 확인하는 query
  public boolean isMember(String id, String password) {
    String query = "SELECT * " +
        "FROM member " +
        "WHERE id = ? " +
        "AND password = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, id);
      pstmt.setString(2, password);
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
  public boolean isStock(Member member, Stock stock) {
    String query = "SELECT M.id AS id, S.name AS stockName, S.purchase_price AS purchase_price, S.count AS count " +
        "FROM member M, stock S " +
        "WHERE M.id = S.member_id " +
        "AND M.id = ? " +
        "AND S.name= ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setString(1, member.getId());
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

  // member 가 admin 인지 확인하는 query
  public boolean isAdmin(Member member) {
    String query = "SELECT * " +
        "FROM member " +
        "WHERE authority = ? " +
        "AND id = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
    ) {
      pstmt.setInt(1, member.getAuthority().ordinal());
      pstmt.setString(2, member.getId());
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

  public Member getMember(String id, String password) {
    String query = "SELECT id, nickname, password, authority, asset " +
        "FROM member " +
        "WHERE member.id = ? " +
        "AND member.password = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      pstmt.setString(1, id);
      pstmt.setString(2, password);
      try (
          ResultSet rs = pstmt.executeQuery();
      ) {
        if (rs.next()) {
          Member member = new Member(
              rs.getString("id"),
              rs.getString("nickname"),
              rs.getString("password"),
              Member.Authority.values()[rs.getInt("Authority")],
              rs.getInt("asset")
          );
          return member;
        } else {
          return null;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public Member getMember(String nickname) {
    String query = "SELECT id, nickname, password, authority, asset " +
        "FROM member " +
        "WHERE member.nickname = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      pstmt.setString(1, nickname);
      try (
          ResultSet rs = pstmt.executeQuery();
      ) {
        if (rs.next()) {
          Member member = new Member(
              rs.getString("id"),
              rs.getString("nickname"),
              rs.getString("password"),
              Member.Authority.values()[rs.getInt("Authority")],
              rs.getInt("asset")
          );
          return member;
        } else {
          return null;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<Member> getAllMember() {
    String query = "SELECT id, nickname, password, authority, asset " +
        "FROM member ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
    ) {
      ArrayList<Member> members = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member(
            rs.getString("id"),
            rs.getString("nickname"),
            rs.getString("password"),
            Member.Authority.values()[rs.getInt("Authority")],
            rs.getInt("asset")
        );
        members.add(member);
      }
      if(members.isEmpty()) {
        return null;
      } else {
        return members;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<Member> getAllMemberExceptAdmin() {
    String query = "SELECT id, nickname, password, authority, asset " +
        "FROM member " +
        "WHERE authority = 1";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
    ) {
      ArrayList<Member> members = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member(
            rs.getString("id"),
            rs.getString("nickname"),
            rs.getString("password"),
            Member.Authority.values()[rs.getInt("Authority")],
            rs.getInt("asset")
        );
        members.add(member);
      }
      if(members.isEmpty()) {
        return null;
      } else {
        return members;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<Stock> getAllStock(String name) {
    String query = "SELECT name, count, purchase_price, member_id " +
        "FROM stock " +
        "WHERE stock.name = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      pstmt.setString(1, name);
      try (
          ResultSet rs = pstmt.executeQuery();
      ) {
        ArrayList<Stock> arrayList = new ArrayList();
        while (rs.next()) {
          Stock stock = new Stock(
              rs.getString("name"),
              rs.getInt("count"),
              rs.getInt("purchase_price"),
              rs.getString("member_id")
          );
          arrayList.add(stock);
        }
        if (arrayList.isEmpty()) {
          return null;
        } else {
          return arrayList;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<Stock> getStockHavenMember(Member member) {
    String query = "SELECT S.name AS name, S.count AS count, S.purchase_price AS purchase_price, S.member_id AS member_id " +
        "FROM stock S, member M " +
        "WHERE M.id = S.member_id " +
        "AND M.id = ?";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      pstmt.setString(1, member.getId());
      try (
          ResultSet rs = pstmt.executeQuery();
      ) {
        ArrayList<Stock> arrayList = new ArrayList();
        while (rs.next()) {
          Stock stock = new Stock(
              rs.getString("name"),
              rs.getInt("count"),
              rs.getInt("purchase_price"),
              rs.getString("member_id")
          );
          arrayList.add(stock);
        }
        if (arrayList.isEmpty()) {
          return null;
        } else {
          return arrayList;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean registerMember(Member member) {
    if (isMember(member)) {
      return false;
    }
    String query = "INSERT INTO member(id, nickname, password, authority, asset)" +
        "VALUES (?, ?, ?, ?, ?)";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setString(1, member.getId());
      pstmt.setString(2, member.getNickname());
      pstmt.setString(3, member.getPassword());
      pstmt.setInt(4, Member.Authority.FALSE.ordinal());
      pstmt.setInt(5, 10000000);

      int retValue = pstmt.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 사항 처리");
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean registerStock(Stock stock) {
    String query = "INSERT INTO stock(name, count, purchase_price, member_id)" +
        "VALUES (?, ?, ?, ?)";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setString(1, stock.getName());
      pstmt.setInt(2, stock.getCount());
      pstmt.setInt(3, stock.getPurchase_price());
      pstmt.setString(4, stock.getMember_id());

      int retValue = pstmt.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 사항 처리");
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean deleteStock(Member member, Stock stock) {
    if (!isMember(member)) {
      return false;
    }
    if (!isStock(member, stock)) {
      return false;
    }

    String query = "DELETE FROM stock " +
        "WHERE stock.name = ? " +
        "AND stock.member_id = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setString(1, stock.getName());
      pstmt.setString(2, member.getId());

      int retValue = pstmt.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 사항 처리");
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean deleteMember(Member member) {
    if (!isMember(member)) {
      return false;
    }

    String query = "DELETE FROM member " +
        "WHERE member.id = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setString(1, member.getId());

      int retValue = pstmt.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 사항 처리");
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean updateStock(Stock stock) {
    String query = "UPDATE stock " +
        "SET count = ? , purchase_price = ?" +
        "WHERE name = ? " +
        "AND member_id = ? ";
    try (
        Connection conn = DBAccess.setConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)
    ) {
      conn.setAutoCommit(false);
      pstmt.setInt(1, stock.getCount());
      pstmt.setInt(2, stock.getPurchase_price());
      pstmt.setString(3, stock.getName());
      pstmt.setString(4, stock.getMember_id());

      int retValue = pstmt.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 사항 처리");
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}
