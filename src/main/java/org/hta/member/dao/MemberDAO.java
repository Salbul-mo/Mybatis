package org.hta.member.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.member.domain.Member;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MemberDAO {

  private SqlSession getSession() {
    SqlSession session = null;
    Reader reader = null;

    try {
      reader = Resources.getResourceAsReader("mybatis/config/sqlMapConfig.xml");
      SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
      session = sf.openSession(true);
       /*
     SqlSessionFactory 를 통해서 SqlSession 객체를 생성한다.

     1. openSession(boolean)의 매개변수 값을
        true 로 지정하면 자동 커밋을 수행하는 SqlSession 객체를 반환한다.

     2. 기본값 false 인 경우 자동 커밋이 되지 않아 직접 commit() 을 호출해야 한다.
        try(SqlSession session = getSession()) {
          session.commit(); // 트랜잭션 커밋
        } catch () {
          session.rollback(); // 트랜잭션 롤백
        }
     */

    } catch (IOException ie) {
      ie.printStackTrace();
    }
    return session;
  }
/*
    mybatis 프레임워크의 핵심 컨포넌트
      1) SqlSession : 실제 SQL을 실행하는 객체로 이 객체는 SQL 을 처리하기 위해
                      JDBC 드라이버를 사용한다.
      2) SqlSessionFactory : SqlSession 객체를 생성한다.

      3) SqlSessionFactoryBuilder : 마이바티스 설정 파일의 내용을 토대로
                                    SqlSessionFactory 를 생성한다.

      4) mybatis 설정 파일 : 데이터 베이스 연결 정보, 트랜잭션 정보,
                             mybatis 제어 정보 등의 설정 내용을 포함하고 있다.
                             SqlSessionFactory 를 만들 때 사용된다.
      5) SQL 맵퍼 파일 : SQL 문을 담고 있는 파일로 SqlSession 객체가 참조한다.

      ***SqlSession 의 주요 메서드
        1) selectList() : select 문을 실행한다.
                          값 객체(Value Object) 목록을 반환한다.
                          쿼리 결과를 List<E>로 반환한다.
                          결과가 없으면 size() 가 0인 List 를 반환한다.

        2) selectOne() : select 문을 실행한다.
                          하나의 값 객체(Value Object) 를 반환한다.
                          쿼리 결과가 없으면 null 반환한다.

        3) insert() : insert 문을 실행한다. 반환값은 입력한 로우 갯수이다.

        4) update() : update 문을 실행한다. 반환값은 변경한 로우 갯수이다.

        5) delete() : delete 문을 실행한다. 반환값은 삭제한 로우 갯수이다.
 */
  public int chk(Member member) {
    int result = 0;

    try (SqlSession session = getSession()) {
      // 조회 결과가 없는 경우 dbmember 는 null 이다.
      Member dbmember = session.selectOne("org.hta.mybatis.member.select", member.getId());
      /*
          첫번째 매개변수 "org.hta.mybatis.member.select" 는
          SQL 매퍼파일에서 namespace 가 "org.hta.mybatis.member" 이고
          id가 "select"로 정의된 태그를 의미한다.


          두번째 매개변수 : SQL 문을 실행할 때 입력 매개 변수에 값을 공급할 객체이다.
          member.getId() 의 자료형은 parameterType 과 일치해야 한다.
          <select id="select" parameterType="String" resultType="Member">
              select * from member22 where id = #{inputid}
          </select>
       */

      if (dbmember != null) {
        if (dbmember.getId().equals(member.getId())) {
          result = -1; // 아이디는 같고 비번이 다른 경우
          if (dbmember.getPassword().equals(member.getPassword())) {
            result = 1; // 아이디와 비번이 같은 경우
          }
        }
      } else {
        System.out.println("chk() 결과 = null");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public int insert(Member member) {
    int result = 0;

    try (SqlSession session = getSession()) {
      result = session.insert("org.hta.mybatis.member.insert", member);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public List<Member> list() {
      List<Member> list = null;
    try (SqlSession session = getSession()) {
      list = session.selectList("org.hta.mybatis.member.list");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int update(Member member) {
    int result = 0;
    try (SqlSession session = getSession()) {
      result = session.update("org.hta.mybatis.member.update", member);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public Member select(String id) {
    Member member = null;

    try (SqlSession session = getSession()) {
      member = session.selectOne("org.hta.mybatis.member.select", id);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return member;
  }

  public int delete(String id) {
    int result = 0;

    try (SqlSession session = getSession()){
      result = session.delete("org.hta.mybatis.member.delete", id);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }
}
