package controller;

import crawling.Crawling;
import db.query.DAO;

public class UserController {

  Crawling crawling;
  DAO dao;

  public UserController(Crawling crawling, DAO dao) {
    this.crawling = crawling;
    this.dao = dao;
  }



}
