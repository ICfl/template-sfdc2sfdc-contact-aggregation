package org.mule.kicks.flows;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.config.MuleProperties;
import org.mule.tck.junit4.FunctionalTestCase;

/**
 * The objective of this class is to validate the correct behavior of the flows
 * for this Mule Kick.
 */
public class FlowsTest extends FunctionalTestCase {

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("mule.env", "dev");
    }

    @AfterClass
    public static void afterClass() {
        System.getProperties().remove("mule.env");
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Override
    protected String getConfigResources() {
        //TODO: Add here the configuration files to be used by your tests others than the ones in the application
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("./src/main/app/mule-deploy.properties"));
            return props.getProperty("config.resources");
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Could not find mule-deploy.properties file on classpath. Please add any of those files or override the getConfigResources() method to provide the resources by your own.");
        }
    }

    @Override
    protected Properties getStartUpProperties() {
        Properties properties = new Properties(super.getStartUpProperties());

        String pathToResource = "./mappings";
        File graphFile = new File(pathToResource);

        properties.put(MuleProperties.APP_HOME_DIRECTORY_PROPERTY, graphFile.getAbsolutePath());

        return properties;
    }

    @Test
    public void testAFlow() throws Exception {
        //TODO: Add here a valid tests 
        Assert.assertTrue("You should really be adding tests to your kicks.", true);
    }
}

