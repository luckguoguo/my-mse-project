package cn.edu.sjtu.common.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.mssql.InsertIdentityOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

public abstract class SpringTxDaoTestCase extends SpringTxTestCase {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected DataSource dataSource;
	
	@BeforeTransaction
	public void onSetUpInTransaction() throws Exception {
		
		if (getTestDataFile() == null) {
			return;
		}
		
		Connection conn = dataSource.getConnection();
		try {
			IDatabaseConnection connection = new DatabaseConnection(conn);
			logger.info("*** Inserting test data ***");
			InsertIdentityOperation.INSERT.execute(connection,
					new FlatXmlDataSet(this.getClass().getResourceAsStream(
							getTestDataFile())));
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}
	
	protected abstract String getTestDataFile();

	@AfterTransaction
	public void onTearDownInTransaction() throws Exception {
		
		if (getTestDataFile() == null) {
			return;
		}
		
		Connection conn = dataSource.getConnection();
		try {
			IDatabaseConnection connection = new DatabaseConnection(conn);
			logger.info("*** Removing test data ***");
			InsertIdentityOperation.TRUNCATE_TABLE.execute(connection,
					new FlatXmlDataSet(this.getClass().getResourceAsStream(
							getTestDataFile())));
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

}
