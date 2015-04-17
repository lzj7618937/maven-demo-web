package com.maven.demo.service;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.maven.demo.entity.DayplanModel;
import com.maven.demo.service.DayplanService;

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
public class DayplanServiceTest {

	AtomicInteger counter = new AtomicInteger();

	@Autowired
	private DayplanService dayplanService;

	@Test
	public void testCreate() {

		int beforeDbCount = dayplanService.countAll();

		dayplanService.save(genRandomUser());

		int afterDbCount = dayplanService.countAll();

		assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		DayplanModel dayplan = dayplanService.save(genRandomUser());
		String expectedRemark = "123234";
		dayplan.setRemark(expectedRemark);
		dayplanService.update(dayplan);

		String actualRemark = dayplanService.get(dayplan.getId())
				.getRemark();

		assertEquals(expectedRemark, actualRemark);

	}
	
	@Test
	public void testQuery(){
		dayplanService.delete(2);
	}

	@Test
	public void testDelete() {

		int beforeDbCount = dayplanService.countAll();

		DayplanModel dayplan = dayplanService.save(genRandomUser());

		dayplanService.delete(dayplan.getId());

		int afterDbCount = dayplanService.countAll();

		assertEquals(beforeDbCount, afterDbCount);
	}

	@Test
	public void testList() {

		DayplanModel dayplan = dayplanService.save(genRandomUser());

		List<DayplanModel> dayplanList = dayplanService.listAll();

		assertThat(dayplanList, hasItem(dayplan));
	}

	public DayplanModel genRandomUser() {
		long randomKey = System.nanoTime() + counter.addAndGet(1);
		Random random = new Random(100);
		int randomPlanId = Math.abs(random.nextInt())%1000;
		int randomSort = Math.abs(random.nextInt())%1000;
		DayplanModel dayplan = new DayplanModel();
		dayplan.setPlanId( randomPlanId);
		dayplan.setSort(randomSort);
		dayplan.setDate(new Date());
		dayplan.setRemark("tets" + randomKey);
		return dayplan;
	}

}
