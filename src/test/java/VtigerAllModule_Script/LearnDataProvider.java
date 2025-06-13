package VtigerAllModule_Script;

import org.testng.annotations.Test;

public class LearnDataProvider {
	@Test(dataProviderClass = com.tek.crm.genericUtility.DataProviderUtility.class, dataProvider = "getData")
	public void TakingData(String Product, String ProductName, String Price) {
		System.out.print(Product+" ");
		System.out.print(ProductName+ " ");
		System.out.print(Price);
		System.out.println();
		
	}

}
