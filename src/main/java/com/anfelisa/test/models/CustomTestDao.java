package com.anfelisa.test.models;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.models.CustomResultDao;
import com.anfelisa.result.models.IResultAbstractModel;

public class CustomTestDao {

	private CustomResultDao customResultDao = new CustomResultDao();

	static final Logger LOG = LoggerFactory.getLogger(CustomTestDao.class);

	public List<ITestModel> selectTests(Handle handle, String lessonId) {
		return handle.createQuery("SELECT * FROM public.test WHERE lessonId = :lessonId ORDER By sequence")
				.bind("lessonId", lessonId).map(new TestMapper()).list();
	}

	public List<IMyTestModel> selectMyTests(Handle handle, String lessonId, String username) {
		List<ITestModel> tests = this.selectTests(handle, lessonId);
		List<IMyTestModel> list = new ArrayList<IMyTestModel>();
		for (ITestModel test : tests) {
			List<IResultAbstractModel> results = customResultDao.selectByTestIdAndUsername(handle, test.getTestId(),
					username);
			MyTestModel myTest = new MyTestModel(test.getTestId(), test.getName(), test.getSequence(), results.size(),
					results.size() > 0, results);
			list.add(myTest);
		}
		return list;
	}

	public ITestModel selectByTestIdAndUsername(Handle handle, String testId, String username) {
		return handle.createQuery(
				"SELECT t.* FROM public.course c, public.studentofcourse sc, public.lesson l, public.test t "
						+ "WHERE t.testId = :testId AND t.lessonId = l.lessonId AND l.courseId = c.courseId AND sc.courseId = c.courseId AND sc.username = :username")
				.bind("testId", testId).bind("username", username).map(new TestMapper()).first();

	}

}
