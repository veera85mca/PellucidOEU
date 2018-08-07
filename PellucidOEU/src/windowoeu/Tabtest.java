package windowoeu;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.SpinnerUI;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Tabtest extends Tabdataprovider {

public static AndroidDriver driver=null;
//public SoftAssert softasser;
	
@Test(groups="login")
public void Login() throws MalformedURLException
{
	DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability("platformName", "Android");
	caps.setCapability("deviceName", "Lenovo PB1-750M");
	caps.setCapability("platformVersion", "6.0.1");
	caps.setCapability("appPackage", "PellucidOEU.PellucidOEU");
	caps.setCapability("appActivity", "md50a5968a76516f0ac9d1f1174cee64e9e.MainActivity");
	//caps.setCapability("appActivity", "md50a5968a76516f0ac9d1f1174cee64e9e.WorklistActivity");
	driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.id("edt_login")).clear();
	driver.findElement(By.id("edt_login")).sendKeys("pro@icu.in");
	driver.findElement(By.id("edt_password")).sendKeys("password");
	driver.findElement(By.id("Provider")).clear();
	driver.findElement(By.id("Provider")).sendKeys("192.168.0.199");
	driver.hideKeyboard();
	driver.findElement(By.id("btn_login")).click();	
}

@Test(dataProvider="headf", groups="head")
public void headfamiliy(String[] head)
{
	commonfamilyregislink();
	commonname(head[0]);
	commonmobileno(head[1]);
	commonage(head[2]);
	commonsex(head[3]);
	commonrelation(head[4]);
	commonheadoffamily(head[0]);
	commonnumberfamily(head[5]);
	commonincome(head[6]);
	commonhouseno(head[7]);
	commonblock(head[8]);
	commonvillage(head[9]);
	commonpanchayat(head[10]);
	commonpersonavailable(head[11], head[12]);
	commoninsurance(head[13]);
	commonsaveandproceed();
	if(head[11].equalsIgnoreCase("yes"))
	{
	casesheetRightVA(head[14]);
	casesheetLeftVA(head[15]);
	casesheetRighteyedisease(head[16]);
	casesheetLefteyedisease(head[17]);
	casesheetRemarks2(head[19]);
	casesheetRemarks3(head[20]);
	casesheetRemarks4(head[21]);
	//casesheetRemarks1(head[18]);	
	casesheet_generalquesscroll();
	casesheet_mandatory_visiontestspectacles(head[22]);
	casesheet_mandatory_needeyecheckup(head[23]);
	casesheet_mandatory_wantrefer(head[24], head[25]);
	casesheet_savescroll();
	casesheet_general_awarehospital(head[26], head[27]);
	casesheet_general_cataracttreated(head[28]);
		if("Female".equalsIgnoreCase(head[3]))
		{
		casesheet_general_requireANC(head[29], head[30]);
		casesheet_general_requirePNC(head[31], head[32]);
		}
	casesheet_save();
	}
}

@Test(dataProvider="members", groups="membersfamily")
public void membersfamily(String[] familiy) throws InterruptedException
{
	commonfamilyhead(familiy[0]);
	commonname(familiy[1]);
	Integer memage=Integer.parseInt(familiy[2]);
	commonage(familiy[2]);
	commonsex(familiy[3]);
	commonrelation(familiy[4]);
	register_saveandcontinuescroll();
	Thread.sleep(4000);
	driver.findElement(By.id("txt_Panchayath")).click();
	commonpersonavailable(familiy[5], familiy[6]);
	commonsaveandproceed();
	if(familiy[5].equalsIgnoreCase("yes"))
	{
		casesheetRightVA(familiy[7]);
		casesheetLeftVA(familiy[8]);
		casesheetRighteyedisease(familiy[9]);
		casesheetLefteyedisease(familiy[10]);
		casesheetRemarks2(familiy[12]);
		casesheetRemarks3(familiy[13]);
		casesheetRemarks4(familiy[14]);
		//casesheetRemarks1(familiy[11]);
		casesheet_savescroll();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mandatory Questions']")).click();
		if(memage<=2)
		{
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
			casesheet_general_requireimmuni(familiy[23]);
			casesheet_general_availimmuni(familiy[24]);
		}else if (memage<=5 && memage>=3) {
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
			casesheet_general_requireimmuni(familiy[23]);
			casesheet_general_availimmuni(familiy[24]);
			casesheet_general_enrollicds(familiy[25]);
			casesheet_general_availnutri(familiy[26]);
		}else if (memage<=15 && memage>=6) {
			casesheet_mandatory_visiontestspectacles(familiy[15]);
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
		}else if (familiy[3].equalsIgnoreCase("Male") && memage>=16) {
			casesheet_mandatory_visiontestspectacles(familiy[15]);
			casesheet_mandatory_needeyecheckup(familiy[16]);
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
		}else if (familiy[3].equalsIgnoreCase("Female") && memage>=17) {
			if(familiy[13].equalsIgnoreCase("Pregnant"))
			{
			casesheet_mandatory_visiontestspectacles(familiy[15]);
			casesheet_mandatory_needeyecheckup(familiy[16]);
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
			casesheet_general_requireANC(familiy[19], familiy[20]);
			}else {
			casesheet_mandatory_visiontestspectacles(familiy[15]);
			casesheet_mandatory_needeyecheckup(familiy[16]);
			casesheet_mandatory_wantrefer(familiy[17], familiy[18]);
			casesheet_general_requireANC(familiy[19], familiy[20]);
			casesheet_general_requirePNC(familiy[21], familiy[22]);
		}
	}
	casesheet_save();
	}
}

@Test(dataProvider="lockreg", groups="Locked")
public void lockedregis(String mobileno, String totalno, String houseno, String block, String village, String panchayat)
{
	commonfamilyregislink();
	driver.findElement(By.id("chb_Locked")).click();
	if(!"Locked".equalsIgnoreCase(driver.findElement(By.id("edt_PatName")).getText()))
	{
		Assert.fail("Name field not disabled with Locked");
	}
	commonmobileno(mobileno);
	commonnumberfamily(totalno);
	commonhouseno(houseno);
	commonblock(block);
	commonvillage(village);
	commonpanchayat(panchayat);
	driver.findElement(By.id("textView6")).click();
	commonsaveandproceed();
		
}
@Test(dataProvider="notinerest", groups="Notinerested")
public void notinterested(String mobileno, String totalno, String houseno, String block, String village, String panchayat)
{
	commonfamilyregislink();
	driver.findElement(By.id("chb_NotInterested")).click();
	if(!"Not interested".equalsIgnoreCase(driver.findElement(By.id("edt_PatName")).getText()))
	{
		Assert.fail("Name field not disabled with Not interested");
	}
	commonmobileno(mobileno);
	commonnumberfamily(totalno);
	commonhouseno(houseno);
	commonblock(block);
	commonvillage(village);
	commonpanchayat(panchayat);
	driver.findElement(By.id("textView6")).click();
	commonsaveandproceed();
}

//Common for registration
public void commonfamilyregislink()
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc='Open drawer']")));
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open drawer']")).click();
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='New Family Registration']")).click();
	WebDriverWait wait1=new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Registration']")));
}
public void commonfamilyhead(String famhead)
{
	driver.findElement(By.id("edttxt_SearchPatName")).sendKeys(famhead);
	driver.findElement(By.id("imgbtn_Search")).click();
	driver.findElement(By.id("imgbtn_AddMember")).click();
	WebDriverWait wait1=new WebDriverWait(driver, 15);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Registration']")));
}
public void commonname(String name)
{
	driver.findElement(By.id("edt_PatName")).sendKeys(name);
}
public void commonmobileno(String mobile)
{
	driver.findElement(By.id("edt_ContactNumber")).sendKeys(mobile);
}
public void commonage(String age)
{
	driver.findElement(By.id("edt_Age")).sendKeys(age);
}
public void commonsex(String sex)
{
	if(sex.equalsIgnoreCase("Male"))
	{
		driver.findElement(By.id("rdo_Male")).click();
	}else if (sex.equalsIgnoreCase("Female")) {
		driver.findElement(By.id("rdo_Female")).click();
	}
}
public void commonrelation(String relation)
{
	driver.findElement(By.id("spn_Relationship")).click();
	listscrollelement(relation);
}
public void commonheadoffamily(String head)
{
	if(!head.equals(driver.findElement(By.id("edt_HeadofFam")).getText()))
	{
		Assert.fail("head of familiy is not bind");
	}
}
public void commonnumberfamily(String numberfamily)
{
	driver.findElement(By.id("edt_Numberfamily")).sendKeys(numberfamily);
}
public void commonincome(String income)
{
	driver.findElement(By.id("txtview_Numberfamily")).click();
	driver.findElement(By.id("edt_MonthlyIncome")).sendKeys(income);
}
public void commonhouseno(String houseno)
{
	driver.findElement(By.id("txtview_Numberfamily")).click();
	register_saveandcontinuescroll();
	driver.findElement(By.id("edt_HouseNo")).sendKeys(houseno);
}
public void commonblock(String block)
{
	driver.findElement(By.id("edt_Block")).sendKeys(block);
}
public void commonvillage(String village)
{
	driver.findElement(By.id("edt_Village")).sendKeys(village);
}
public void commonpanchayat(String panchayat)
{
	driver.findElement(By.id("textView6")).click();
	driver.findElement(By.id("edt_Panchayath")).sendKeys(panchayat);
	driver.findElement(By.id("textView6")).click();
}
public void commonpersonavailable(String personavailable, String reason)
{
	if("yes".equalsIgnoreCase(personavailable))
	{
		driver.findElement(By.id("rdbReasonQuestYes")).click();
	}else if ("no".equalsIgnoreCase(personavailable)) {
		driver.findElement(By.id("rdbReasonQuestNo")).click();
		driver.findElement(By.id("spn_Reason")).click();
		WebDriverWait wait3=new WebDriverWait(driver, 15);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.CheckedTextView")));
		List<WebElement> reas=driver.findElements(By.className("android.widget.CheckedTextView"));
		for(int i=0;i<reas.size();i++)
		{
			if(reason.equalsIgnoreCase(reas.get(i).getText()))
			{
				reas.get(i).click();
				break;
			}
		}
	}
}
public void commoninsurance(String insurance)
{
	if(insurance.equalsIgnoreCase("yes"))
	{
		driver.findElement(By.id("rdbInsurQuestYes")).click();
	}else if (insurance.equalsIgnoreCase("no")) {
		driver.findElement(By.id("rdbInsurQuestNo")).click();
	}
}
public void commonsaveandproceed()
{
	driver.findElement(By.id("btn_SaveAndGo")).click();
}

//Common for casesheet
public void casesheetRightVA(String rightva)
{
	WebDriverWait wait=new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acuityrightspinner")));
	if(!rightva.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("acuityrightspinner")).click();
	listscrollelement(rightva);
	}
}
public void casesheetLeftVA(String leftva)
{
	if(!leftva.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("acuityleftspinner")).click();
	listscrollelement(leftva);
	}
}
public void casesheetRighteyedisease(String righteyedisease)
{
	if(!righteyedisease.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("disrightsp")).click();
	listscrollelement(righteyedisease);
	}
}
public void casesheetLefteyedisease(String lefteyedisease)
{
	if(!lefteyedisease.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("disleftsp")).click();
	listscrollelement(lefteyedisease);
	}
}
public void casesheetRemarks2(String remark2)
{
	if(!remark2.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("disremarkleftsp")).click();
	dropdown(remark2);
	}
}
public void casesheetRemarks3(String remark3)
{
	if(!remark3.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("disremarksrightspSecond")).click();
	dropdown(remark3);
	}
}
public void casesheetRemarks4(String remark4)
{
	if(!remark4.equalsIgnoreCase("None"))
	{
	driver.findElement(By.id("disremarkleftspSecond")).click();
	dropdown(remark4);
	}
}
public void casesheetRemarks1(String remark1)
{
	System.out.println(remark1);
	SoftAssert softasser=new SoftAssert();
	String rem=driver.findElement(By.xpath("//android.widget.TextView[@text='"+remark1+"']")).getText();
	System.out.println(rem);
	softasser.assertEquals(remark1, rem);
	softasser.assertAll();
}
//mandatory questions
public void casesheet_mandatory_visiontestspectacles(String mandatoryone)
{
	if("yes".equalsIgnoreCase(mandatoryone))
	{
		driver.findElement(By.id("rdgSpectaclesYes")).click();
	}else if ("no".equalsIgnoreCase(mandatoryone)) {
		driver.findElement(By.id("rdgSpectaclesNo")).click();
	}
}
public void casesheet_mandatory_needeyecheckup(String mandatorytwo)
{
	if("yes".equalsIgnoreCase(mandatorytwo))
	{
		driver.findElement(By.id("rdgEyeCheckUpYes")).click();
	}else if ("no".equalsIgnoreCase(mandatorytwo)) {
		driver.findElement(By.id("rdgEyeCheckUpNo")).click();
	}
}
public void casesheet_mandatory_wantrefer(String mandatorythree, String value)
{
	if("yes".equalsIgnoreCase(mandatorythree))
	{
		driver.findElement(By.id("rdgReferYes")).click();
		driver.findElement(By.id("SpnReferFor")).click();
		dropdown(value);
	}else if ("no".equalsIgnoreCase(mandatorythree)) {
		driver.findElement(By.id("rdgReferNo")).click();
	}
}
//General questions
public void casesheet_general_awarehospital(String generalone, String hosname)
{
	if("yes".equalsIgnoreCase(generalone))
	{
		driver.findElement(By.id("rdgAwareofHospYes")).click();
		driver.findElement(By.id("edt_TypeOfHosp")).sendKeys(hosname);
		driver.findElement(By.id("txtAwareOfHosp")).click();
	}else if ("no".equalsIgnoreCase(generalone)) {
		driver.findElement(By.id("rdgAwareofHospNo")).click();
	}
}
public void casesheet_general_cataracttreated(String generaltwo)
{
	if("yes".equalsIgnoreCase(generaltwo))
	{
		driver.findElement(By.id("rdgCatCanBeTreatedYes")).click();
	}else if ("no".equalsIgnoreCase(generaltwo)) {
		driver.findElement(By.id("rdgCatCanBeTreatedNo")).click();
	}
}
public void casesheet_general_requireANC(String requireanc, String availanc)
{
	if("yes".equalsIgnoreCase(requireanc))
	{
		driver.findElement(By.id("rdgReqANCYes")).click();
		casesheet_general_availANC(availanc);
	}else if ("no".equalsIgnoreCase(requireanc)) {
		driver.findElement(By.id("rdgReqANCNo")).click();
	}
}
public void casesheet_general_availANC(String availanc)
{
	if("yes".equalsIgnoreCase(availanc))
	{
		driver.findElement(By.id("rdgAvailANCYes")).click();
	}else if ("no".equalsIgnoreCase(availanc)) {
		driver.findElement(By.id("rdgAvailANCNo")).click();
	}
}
public void casesheet_general_requirePNC(String requirepnc, String availpnc)
{
	if("yes".equalsIgnoreCase(requirepnc))
	{
		driver.findElement(By.id("rdgReqPNCYes")).click();
		casesheet_general_availPNC(availpnc);
	}else if ("no".equalsIgnoreCase(requirepnc)) {
		driver.findElement(By.id("rdgReqPNCNo")).click();
	}
}
public void casesheet_general_availPNC(String availpnc)
{
	if("yes".equalsIgnoreCase(availpnc))
	{
		driver.findElement(By.id("rdgAvailPNCYes")).click();
	}else if ("no".equalsIgnoreCase(availpnc)) {
		driver.findElement(By.id("rdgAvailPNCNo")).click();
	}
}
public void casesheet_general_requireimmuni(String reqimmun)
{
	if("yes".equalsIgnoreCase(reqimmun))
	{
		driver.findElement(By.id("rdgReqImmnYes")).click();
	}else if ("no".equalsIgnoreCase(reqimmun)) {
		driver.findElement(By.id("rdgReqImmnNo")).click();
	}
}
public void casesheet_general_availimmuni(String avaimmun)
{
	if("yes".equalsIgnoreCase(avaimmun))
	{
		driver.findElement(By.id("rdgAvailImmnYes")).click();
	}else if ("no".equalsIgnoreCase(avaimmun)) {
		driver.findElement(By.id("rdgAvailImmnNo")).click();
	}
}
public void casesheet_general_enrollicds(String enrollicds)
{
	if("yes".equalsIgnoreCase(enrollicds))
	{
		driver.findElement(By.id("rdgICDSYes")).click();
	}else if ("no".equalsIgnoreCase(enrollicds)) {
		driver.findElement(By.id("rdgICDSNo")).click();
	}
}
public void casesheet_general_availnutri(String avanutri)
{
	if("yes".equalsIgnoreCase(avanutri))
	{
		driver.findElement(By.id("rdgnutritionservicesYes")).click();
	}else if ("no".equalsIgnoreCase(avanutri)) {
		driver.findElement(By.id("rdgnutritionservicesNo")).click();
	}
}
public void casesheet_save()
{
	driver.findElement(By.id("btn_Sheet")).click();
}

//common for all
public void dropdown(String inputdata)
{
	List<WebElement> listdrop=driver.findElements(By.className("android.widget.CheckedTextView"));
	for(int i=0;i<listdrop.size();i++)
	{
		if(inputdata.equalsIgnoreCase(listdrop.get(i).getText()))
		{
			listdrop.get(i).click();
			break;
		}
	}
}
public void listscrollelement(String listele)
{
	String scrollviewcontainer="new UiSelector().className(\"android.widget.ListView\")";
	String scrollelement="new UiSelector().text(\""+listele+"\")";
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("+scrollviewcontainer+")"+".scrollIntoView("+scrollelement+")")).click();
}
public void register_saveandcontinuescroll()
{
	String scrollviewcontainer="new UiSelector().className(\"android.widget.ScrollView\")";
	String scrollelement="new UiSelector().text(\"Save and Proceed\")";
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("+scrollviewcontainer+")"+".scrollIntoView("+scrollelement+")"));
}
public void casesheet_savescroll()
{
	String scrollviewcontainer="new UiSelector().className(\"android.widget.ScrollView\")";
	String scrollelement="new UiSelector().text(\"Save\")";
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("+scrollviewcontainer+")"+".scrollIntoView("+scrollelement+")"));
}
public void casesheet_generalquesscroll()
{
	String scrollviewcontainer="new UiSelector().className(\"android.widget.ScrollView\")";
	String scrollelement="new UiSelector().text(\"General Questions\")";
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("+scrollviewcontainer+")"+".scrollIntoView("+scrollelement+")"));
}
}
