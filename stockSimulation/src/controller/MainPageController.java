package controller;

import db.query.DAO;
import db.table.Member;

public class MainPageController {

  DAO dao;

  public MainPageController(DAO dao) {
    this.dao = dao;
  }

  public Member checkMemberDB(Member member) {
    member = dao.getMember(member.getId(), member.getPassword());
    if (member == null) {
      return null;
    }
    else {
      return member;
    }
  }

  public boolean checkAdmin(Member member) {
    if(dao.isAdmin(member)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean registerMember(Member member) {
    if (dao.isMember(member)) {
      return false;
    }
    else {
      if(dao.registerMember(member)) {
        return true;
      }
      return false;
    }
  }



}
