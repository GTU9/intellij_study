package com.ohgiraffers.section02.named;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NamedNativeQueryTests {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@BeforeAll
	public static void initFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
	}

	@BeforeEach
	public void initManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@AfterAll
	public static void closeFactory() {
		entityManagerFactory.close();
	}

	@AfterEach
	public void closeManager() {
		entityManager.close();
	}
	

	
	@Test
	public void NamedNativeQuery를_이용한_조회_테스트() {
		
		//when
		Query naitveQuery=entityManager.createNamedQuery("Category.menuCountOfCategory");
		List<Object[]> categorylist=naitveQuery.getResultList();


    	//then
		assertNotNull(categorylist);

		categorylist.forEach(row->{
			Stream.of(row).forEach(col-> System.out.println(col + " "));
			System.out.println();
		});
		
	}

}
