package com.indbilisim;

import com.indbilisim.conf.WebConfig;
import com.indbilisim.demo.Building;
import com.indbilisim.demo.BuildingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EShoppingApplicationTests {

	@Test
	public void contextLoads() {
		
	}

	/*@Test
	public void BuildingServiceTest(){

		Building building=null;
		building= new Building();
		building.setBuildingName("Cumhuriyet");
		building.setDescription("Apartman");
		building.setRecordDate(new Date(2017,10,01));
		building.setRecordUserId("Ahmet");

		BuildingService test = new BuildingService();
		test.save(building);
	}*/
}
