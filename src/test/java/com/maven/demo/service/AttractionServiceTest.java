package com.maven.demo.service;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.maven.demo.entity.AttractionModel;
import com.maven.demo.service.AttractionService;

/**
 * 
 * 该测试为集成测试，非单元测试
 * 
 * User: Zhang Kaitao Date: 11-12-26 下午4:33 Version: 1.0
 */
// @Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class AttractionServiceTest {

	AtomicInteger counter = new AtomicInteger();

	@Autowired
	private AttractionService attractionService;

	@Test
	public void testCreate() {

		int beforeDbCount = attractionService.countAll();

		attractionService.save(genRandomUser());

		int afterDbCount = attractionService.countAll();

		assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		AttractionModel attraction = attractionService.save(genRandomUser());
		String expectedPassword = "123234";
		attraction.setContact(expectedPassword);
		attractionService.update(attraction);

		String actualPassword = attractionService.get(attraction.getId())
				.getContact();

		assertEquals(expectedPassword, actualPassword);

	}

	@Test
	public void testDelete() {

		int beforeDbCount = attractionService.countAll();

		AttractionModel attraction = attractionService.save(genRandomUser());

		attractionService.delete(attraction.getId());

		int afterDbCount = attractionService.countAll();

		assertEquals(beforeDbCount, afterDbCount);
	}

	@Test
	public void testList() {

		AttractionModel attraction = attractionService.save(genRandomUser());

		List<AttractionModel> attractionList = attractionService.listAll();

		assertThat(attractionList, hasItem(attraction));
	}

	public AttractionModel genRandomUser() {
		long randomKey = System.nanoTime() + counter.addAndGet(1);
		AttractionModel attraction = new AttractionModel();
		attraction.setCity("zhang" + randomKey);
		attraction.setContact("zhang" + randomKey + "@sishuok.com");
		attraction.setImage("123456");
		attraction.setTraffic("tets" + randomKey);
		return attraction;
	}

}
