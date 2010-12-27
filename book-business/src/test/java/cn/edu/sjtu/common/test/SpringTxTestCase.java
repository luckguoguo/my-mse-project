package cn.edu.sjtu.common.test;

import org.junit.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

@ContextConfiguration(locations = { "classpath*:applicationContext-test.xml" })
public class SpringTxTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected void assertReflectionEquals(Object expected, Object actual) {
		ReflectionAssert.assertReflectionEquals(expected, actual, ReflectionComparatorMode.IGNORE_DEFAULTS,
				ReflectionComparatorMode.LENIENT_ORDER);
	}

	protected void assertReflectionEquals(String message, Object expected, Object actual) {
		ReflectionAssert.assertReflectionEquals(message, expected, actual, ReflectionComparatorMode.IGNORE_DEFAULTS,
				ReflectionComparatorMode.LENIENT_ORDER);
	}

	protected void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	protected void assertEquals(String message, Object expected, Object actual) {
		Assert.assertEquals(message, expected, actual);
	}

	protected void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	protected void assertTrue(String message, boolean condition) {
		Assert.assertTrue(message, condition);
	}

	protected void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	protected void assertFalse(String message, boolean condition) {
		Assert.assertFalse(message, condition);
	}

	protected void assertNull(Object object) {
		Assert.assertNull(object);
	}

	protected void assertNull(String message, Object object) {
		Assert.assertNull(message, object);
	}

	protected void assertNotNull(Object object) {
		Assert.assertNotNull(object);
	}

	protected void assertNotNull(String message, Object object) {
		Assert.assertNotNull(message, object);
	}
	
}
