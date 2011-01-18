package cn.edu.sjtu.common.orm.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.ReflectionUtils;

public abstract class AbstractJpaDaoSupport<T, PK extends Serializable> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected Class<T> entityClass;
	
	protected EntityManager entityManager;
	
	@PersistenceContext(unitName = "PetClinicJPAPU")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public AbstractJpaDaoSupport() {
		super();
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}
	
	public void save(final T entity) {
		Assert.notNull(entity, "entity cannot be null");
		entityManager.persist(entity);
		logger.debug("save entity: {}", entity);
	}
	
	public void merge(final T entity) {
		Assert.notNull(entity, "entity cannot be null");
		entityManager.merge(entity);
		logger.debug("merge entity: {}", entity);
	}

	public void delete(final T entity) {
		Assert.notNull(entity, "entity cannot be null");
		entityManager.remove(entity);
		logger.debug("delete entity: {}", entity);
	}

	public void delete(final PK id) {
		Assert.notNull(id, "id cannot be null");
		delete(get(id));
		logger.debug("delete entity {}, id is {}", entityClass.getSimpleName(), id);
	}

	public T get(final PK id) {
		Assert.notNull(id, "id cannot be null");
		return (T) entityManager.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String jpql, final Object... values) {
		return createQuery(jpql, values).getResultList();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String jpql, final Map<String, Object> values) {
		return createQuery(jpql, values).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String jpql, final Object... values) {
		try {
			return (X) createQuery(jpql, values).getSingleResult();
		} catch (PersistenceException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String jpql, final Map<String, Object> values) {
		try {
			return (X) createQuery(jpql, values).getSingleResult();
		} catch (PersistenceException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
	
	public int batchExecute(final String jpql, final Object... values) {
		return createQuery(jpql, values).executeUpdate();
	}

	public int batchExecute(final String jpql, final Map<String, Object> values) {
		return createQuery(jpql, values).executeUpdate();
	}

	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString cannot be blank");
		Query query = entityManager.createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i + 1, values[i]);
			}
		}
		return query;
	}
	
	public Query createQuery(final String queryString, final Map<String, Object> values) {
		Assert.hasText(queryString, "queryString cannot be blank");
		Query query = entityManager.createQuery(queryString);
		if (values != null) {
			for (Entry<String, Object> entry : values.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query;
	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page, final String jpql, final Object... values) {
		Assert.notNull(page, "page cannot be null");

		Query q = createQuery(jpql, values);

		if (page.isAutoCount()) {
			long totalCount = countJpqlResult(jpql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);
		List result = q.getResultList();
		page.setResult(result);
		return page;
	}

	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page, final String jpql, final Map<String, Object> values) {
		Assert.notNull(page, "page cannot be null");

		Query q = createQuery(jpql, values);

		if (page.isAutoCount()) {
			long totalCount = countJpqlResult(jpql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);

		List result = q.getResultList();
		page.setResult(result);
		return page;
	}

	protected Query setPageParameter(final Query q, final Page<T> page) {
		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}

	protected long countJpqlResult(final String jpql, final Object... values) {
		String fromJpql = jpql;
		
		fromJpql = "from " + StringUtils.substringAfter(fromJpql, "from");
		fromJpql = StringUtils.substringBefore(fromJpql, "order by");

		String countJpql = "select count(*) " + fromJpql;

		try {
			Long count = findUnique(countJpql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("jpql can't be auto count, jpql is:" + countJpql, e);
		}
	}

	protected long countJpqlResult(final String jpql, final Map<String, Object> values) {
		String fromJpql = jpql;
		
		fromJpql = "from " + StringUtils.substringAfter(fromJpql, "from");
		fromJpql = StringUtils.substringBefore(fromJpql, "order by");

		String countJpql = "select count(*) " + fromJpql;

		try {
			Long count = findUnique(countJpql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("jpql can't be auto count, jpql is:" + countJpql, e);
		}
	}
	
}
