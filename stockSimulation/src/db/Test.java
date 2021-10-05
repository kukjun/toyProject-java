package db;

import db.query.DAO;
import db.table.Member;
import db.table.Stock;

import java.util.ArrayList;

public class Test {

  public static void main(String[] args) {
    DAO dao = new DAO();
    Member kukjun = new Member("kukjun123", "Kingkun", "abcd1234",
        Member.Authority.TRUE, 10000000);
    Stock kukjunStock = new Stock("A", 20, 5000, "kukjun123");
    Stock deleteStock = new Stock("C", 100, 5000, "kukjun123");
    Member hiyoung = new Member("hiyoung123", "test", "abcd1234",
        Member.Authority.FALSE, 10000000);
    Stock registerStock = new Stock("D", 50, 10000, "kukjun123");
    Stock updateStock = new Stock("A", 30, 7500, "kukjun123");
    Member admin = new Member("admin123", "KingJun", "abcd1234", Member.Authority.TRUE, 0);

    // isMember Test
    System.out.println("isMemberTest");
    System.out.println(dao.isMember(new Member()));
    System.out.println(dao.isMember(kukjun));
    System.out.println(dao.isAdmin(admin));
    System.out.println();

    // isAdmin Test
    System.out.println("isAdminTest");
    System.out.println(dao.isAdmin(kukjun));
    System.out.println();

    // isStock Test
    System.out.println("isStockTest");
    System.out.println(dao.isStock(kukjun, new Stock()));
    System.out.println(dao.isStock(kukjun, kukjunStock));
    System.out.println();

    // getMember Test
    System.out.println("getMemberTest");
    System.out.println(dao.getMember("test", "test"));
    System.out.println(dao.getMember(kukjun.getId(), kukjun.getPassword()));
    System.out.println();

    // getStock Test
    System.out.println("getStockTest");
    System.out.println(dao.getAllStock("test"));
    ArrayList<Stock> arrayList = dao.getAllStock(kukjunStock.getName());
    for (Stock stock : arrayList) {
      System.out.println(stock);
    }
    System.out.println();

    // getStockHavenMember
    System.out.println("getStockHavenMember");
    System.out.println(dao.getStockHavenMember(new Member()));
    ArrayList<Stock> arrayList1 = dao.getStockHavenMember(kukjun);
    for (Stock stock : arrayList1) {
      System.out.println(stock);
    }
    System.out.println();

    // registerMember 정보 : hiyoung123, test, 'abcd1234', 1, 10000000
    System.out.println("registerMember");
    System.out.println(dao.registerMember(hiyoung));
    System.out.println(dao.getMember("hiyoung123", "abcd1234"));
    System.out.println();

    // registerStock
    System.out.println("registerStock");
    System.out.println(dao.registerStock(registerStock));
    System.out.println(dao.getStockHavenMember(kukjun));
    System.out.println();

    // deleteStock
    System.out.println("deleteStock");
    System.out.println(dao.deleteStock(kukjun, deleteStock));
    System.out.println(dao.getStockHavenMember(kukjun));
    System.out.println();


    // deleteMember
    System.out.println("deleteMember");
    System.out.println(dao.deleteMember(hiyoung));
    ArrayList<Member> arrayList2 = dao.getAllMember();
    for (Member member : arrayList2) {
      System.out.println(member);
    }
    System.out.println();

    //updateStock
    System.out.println("updateStock");
    System.out.println(dao.updateStock(updateStock));
    System.out.println(dao.getStockHavenMember(kukjun));
    System.out.println();
  }



}
