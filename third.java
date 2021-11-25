	import org.openqa.selenium.By;  
	import org.openqa.selenium.WebDriver;
    //import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;	  
    import org.junit.Assert;
    import org.testng.annotations.DataProvider;
    //import org.testng.annotations.Optional;
    //import org.testng.annotations.Parameters;
    import org.testng.annotations.Test;
    //import org.junit.jupiter.api.Test;
	public class third {  
	       
	    	@Test (dataProvider="input")
	        public void Loginattempt(String scene, String uname, String pass) {
	    		
	        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");      
	        WebDriver driver=new ChromeDriver();  
	        driver.get("https://www.netflix.com/bd/login");
	        
	        driver.findElement(By.xpath("//*[@id=\"id_userLoginId\"]")).sendKeys(uname);
	        driver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys(pass);
	        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div[1]/div[3]/div/div/div[1]/form/button")).click();
	        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}driver.close();
	        if(scene.equals("Incorrect"))
	        {
	        	String msg=driver.findElement(By.className("ui-message-contents")).getText();
	        	Assert.assertEquals(msg, "ui-message-contents");
	        	
	        } 
	        if(scene.equals("OneFieldEmpty"))
	        {
	        	String msg=driver.findElement(By.className("ui-message-contents")).getText();
	        	Assert.assertEquals(msg, "Inappropriate Input");
	        } 
	        }
	    	
	    	@DataProvider(name="input")
	    	public Object[][] getData(){
	    		return new Object[][] {
	    			{"Incorrect","ks@gmail.com","ks55!23"},
	    			{"Incorrect","ks@gmail.com","ks@@55"},
	    			{"Incorrect","kshk78@gmail.com","ks55!25"},
	    			{"Incorrect","kshk78@gmail.com","ks@@55"},
	    			{"OneFieldEmpty","kshk78@gmail.com",""},
	    			{"OneFieldEmpty","","ks@@57"},
	    			{"OneFieldEmpty","ks@gmail.com",""},
	    			{"OneFieldEmpty","","ks@@56"},
	    			{"OneFieldEmpty","",""}
	    		};
	    	}
	}