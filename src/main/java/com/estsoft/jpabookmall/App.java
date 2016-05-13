package com.estsoft.jpabookmall;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.estsoft.jpabookmall.domain.Book;

public class App {
    public static void main( String[] args ){
    	
    	// 1. 엔티티 매니저 팩토리 생성(persistence-unit name)
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabookmall");
    	
    	// 2. 엔티티 매니저 생성
    	EntityManager em = emf.createEntityManager();
    	
    	// 3. 트랜잭션 받아오기
    	EntityTransaction tx = em.getTransaction();
    	
    	// 4. 트랜잭션 시작
    	tx.begin();
    	
    	// 5. 비즈니스 로직
    	try{
    		// logic(em)
    		insertLogic(em);
    		//insertAndUpdateLogic(em);
    		//findOneLogic(em);
    		//findListLogic(em);
    		// findAndRemoveLogic(em);
    		
    	} catch(Exception ex){
    		ex.printStackTrace();
    		tx.rollback();
    	}
    	
    	// 6. 트랜잭션 commit
    	tx.commit();
    	
    	// 7. 엔티티 매니저 닫기
    	em.close();
    	
    	// 8. 엔티티 매니저 팩토리 닫기
    	emf.close();
    }
    
    public static void insertLogic(EntityManager em){
    	Book book = new Book();
    	//book.setNo(3L);
    	book.setTitle("자바의 신");
    	book.setDescription("자바책 중엔 최고!");
    	book.setPrice(20000L);
    	
    	em.persist(book);
    }
    
    public static void insertAndUpdateLogic(EntityManager em){
    	Book book = new Book();
    	book.setNo(2L);
    	book.setTitle("자바의 정석");
    	book.setPrice(30000L);
    	
    	// 저장
    	em.persist(book);
    	
    	// 가격 update
    	book.setPrice(0L);
    	
    }
    	
    public static void findOneLogic(EntityManager em){
    	Book book = em.find(Book.class, 1L);;
    	System.out.println( book );
    	
    	System.out.println("JPA 완전정복");
    }
    
    public static void findAndRemoveLogic(EntityManager em){
//    	이렇게 삭제하면 XXX
//    	Book book = new Book();
//    	book.setNo(1L);
    	
    	// 영속된 객체만 삭제 가능!
    	Book book = em.find(Book.class, 1L);
    	em.remove(book);
    }
    
    public static void findListLogic(EntityManager em){
    	
    	// 객체지향 쿼리(JPQL)
    	TypedQuery<Book> query = em.createQuery("select m from Book m",Book.class);
    	List<Book> list = query.getResultList();
    	
    	for (Book book : list) {
    		System.out.println(book);
			
		}
    }
    
    /*
     * EntityManager == DB
     */
}
