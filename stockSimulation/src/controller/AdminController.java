package controller;

import db.query.DAO;
import db.table.Member;

import java.util.ArrayList;

public class AdminController {

  DAO dao;

  public AdminController(DAO dao) {
    this.dao = dao;
  }

  public ArrayList<String> getAllMemberNickName() {
    ArrayList<Member> members = dao.getAllMemberExceptAdmin();
    ArrayList<String> membersNickname = new ArrayList<>();
    if(members == null) {
      return null;
    }
    for (Member member : members) {
      membersNickname.add(member.getNickname());
    }
    return membersNickname;
  }

  public Member getMemberInfo(String nickname) {
    Member member = dao.getMember(nickname);
    if (member == null) {
      return null;
    }
    else {
      return member;
    }
  }

  public boolean deleteMember(Member member) {
    return dao.deleteMember(member);
  }


}
