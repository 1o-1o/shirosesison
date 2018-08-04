import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cloud.gateway.GatewayApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GatewayApplication.class)
@WebAppConfiguration
public class test {
		

	//service  检查 数据库 是否连接
    @Test
    @Rollback(false)
    public void selectByDb() throws Exception {

    	
    }
    
    
}
