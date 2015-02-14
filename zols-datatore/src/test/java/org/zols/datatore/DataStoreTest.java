/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zols.datatore;

import org.zols.datatore.domain.Employee;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zols.datastore.DataStore;
import org.zols.datastore.elasticsearch.ElasticSearchDataStore;
import org.zols.datatore.exception.DataStoreException;

/**
 *
 * @author sathish
 */
public class DataStoreTest {

    private final DataStore dataStore;

    public DataStoreTest() {
        dataStore = new ElasticSearchDataStore("zols");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws DataStoreException {
        Employee employee = new Employee();
        employee.setName("EmployeeName");
        employee.setAge(Integer.SIZE);
        dataStore.create(Employee.class, employee);
    }

    @After
    public void tearDown() throws DataStoreException {
        dataStore.delete(Employee.class, "EmployeeName");
    }

    /**
     * Test of listData method, of class DataStore.
     * @throws org.zols.datatore.exception.DataStoreException
     */
    @Test
    public void test_Create_Basic_Object() throws DataStoreException {
        Employee employee = dataStore.read(Employee.class, "EmployeeName");
        Assert.assertNotNull("Created Employee exists", employee);
    }

}
