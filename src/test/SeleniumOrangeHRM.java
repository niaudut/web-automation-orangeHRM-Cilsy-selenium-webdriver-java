package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumOrangeHRM {

	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		SeleniumOrangeHRM test = new SeleniumOrangeHRM();
		test.setBrowser("EdgeChromium");
		test.setBrowserConfig();
		test.verifyOpenPage();

		test.verifyLoginFailed();
		test.verifyLoginSuccess();

		test.verifyAddEmployeeFailed();
		test.verifyAddEmployeeSuccess();
		test.verifyEditPersonalDetailFailed();
		test.verifyEditPersonalDetailSuccess();
		
		test.verifyPunchInFailed();
		test.verifyPunchInSuccess();
		test.verifyPunchOutFailed();
		test.verifyPunchOutSuccess();
		test.verifyEditAttendanceFailed();
		test.verifyEditAttendanceSuccess();
		test.verifyDeleteAttendance();

		test.verifyAddUserFailed();
		test.verifyAddUserSuccess();
		test.verifyEditUserFailed();
		test.verifyEditUserSuccess();
		test.verifyDeleteUserSuccess();

		test.verifySearchEmployee();
		test.verifyDeleteEmployee();

		test.verifyAddJobTitleFailed();
		test.verifyAddJobTitleSuccess();
		test.verifyEditJobTitleFailed();
		test.verifyEditJobTitleSuccess();
		test.verifyDeleteJobTitleSuccess();

//		test.modulAdmin();
		test.verifyAddPayGradeFailed();
		test.verifyAddPayGradeSuccess();
		test.verifyEditPayGradeFailed();
		test.verifyEditPayGradeSuccess();
		test.verifyDeletePayGrade();

//		test.modulAdmin();
		test.verifyAddEmploymentStatusFailed();
		test.verifyAddEmploymentStatusSuccess();
		test.verifyEditEmploymentStatusFailed();
		test.verifyEditEmploymentStatusSuccess();
		test.verifyDeleteEmploymentStatus();

//		test.modulAdmin();
		test.verifyAddJobCategoryFailed();
		test.verifyAddJobCategorySuccess();
		test.verifyEditJobCategoryFailed();
		test.verifyEditJobCategorySuccess();
		test.verifyDeleteJobCategory();

//		test.modulAdmin();
		test.verifyAddWorkShiftFailed();
		test.verifyAddWorkShiftSuccess();
		test.verifyEditWorkShiftFailed();
		test.verifyEditWorkShiftSuccess();
		test.verifyDeleteWorkShift();

//		test.modulAdmin();
		test.verifyEditGeneralInfoFailed();
		test.verifyEditGeneralInfoSuccess();

//		test.modulAdmin();
		test.verifyAddLocationFailed();
		test.verifyAddLocationSuccess();
		test.verifyEditLocationFailed();
		test.verifyEditLocationSuccess();
		test.verifyDeleteLocation();

//		test.modulAdmin();
		test.verifyAddStructureFailed();
		test.verifyAddStructureSuccess();
		test.verifyEditStructureFailed();
		test.verifyEditStructureSuccess();

//		test.modulAdmin();
		test.verifyAddSkillFailed();
		test.verifyAddSkillSuccess();
		test.verifyEditSkillFailed();
		test.verifyEditSkillSuccess();
		test.verifyDeleteSkill();

//		test.modulAdmin();
		test.verifyAddEducationFailed();
		test.verifyAddEducationSuccess();
		test.verifyEditEducationFailed();
		test.verifyEditEducationSuccess();
		test.verifyDeleteEducation();

//		test.modulAdmin();
		test.verifyAddLicenseFailed();
		test.verifyAddLicenseSuccess();
		test.verifyEditLicenseFailed();
		test.verifyEditLicenseSuccess();
		test.verifyDeleteLicense();

//		test.modulAdmin();
		test.verifyAddLanguageFailed();
		test.verifyAddLanguageSuccess();
		test.verifyEditLanguageFailed();
		test.verifyEditLanguageSuccess();
		test.verifyDeleteLanguage();

//		test.modulAdmin();
		test.verifyAddMembershipFailed();
		test.verifyAddMembershipSuccess();
		test.verifyEditMembershipFailed();
		test.verifyEditMembershipSuccess();
		test.verifyDeleteMembership();

//		test.modulAdmin();
		test.verifyAddNationalityFailed();
		test.verifyAddNationalitySuccess();
		test.verifyEditNationalityFailed();
		test.verifyEditNationalitySuccess();
		test.verifyDeleteNationality();
		
		test.logout();
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");

		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.contains("EdgeChromium")) {
			System.setProperty("webdriver.edge.driver", projectLocation + "\\lib\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}

	
	@Test
	public void verifyOpenPage() {
		driver.get("https://qa.cilsy.id/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		String expectedOpenPage = "LOGIN Panel";
		String actualOpenPage = "";
		actualOpenPage = driver.findElement(By.id("logInPanelHeading")).getText();
		Assert.assertEquals(expectedOpenPage, actualOpenPage);
		System.out.println("Open OrangeHRM login page passed");
	}

	@Test
	public void verifyLoginFailed() {
		driver.findElement(By.id("btnLogin")).click();
		String expectedLogin1 = "Username cannot be empty";
		String actualLogin1 = "";
		actualLogin1 = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(expectedLogin1, actualLogin1);
		System.out.println("Login tanpa isi mandatory field passed");

		driver.findElement(By.id("txtUsername")).sendKeys("QA");
		driver.findElement(By.id("txtPassword")).sendKeys("s3Kol4HQA!*");
		driver.findElement(By.id("btnLogin")).click();
		String expectedLogin2 = "Invalid credentials";
		String actualLogin2 = "";
		actualLogin2 = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(expectedLogin2, actualLogin2);
		System.out.println("Login dengan invalid username passed");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("s3Kol4HQA");
		driver.findElement(By.id("btnLogin")).click();
		String expectedLogin3 = "Invalid credentials";
		String actualLogin3 = "";
		actualLogin3 = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(expectedLogin3, actualLogin3);
		System.out.println("Login dengan invalid password passed");
	}

	@Test
	public void verifyLoginSuccess() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("s3Kol4HQA!*");
		driver.findElement(By.id("btnLogin")).click();
		String expectedLogin = "Dashboard";
		String actualLogin = "";
		actualLogin = driver.findElement(By.id("menu_dashboard_index")).getText();
		Assert.assertEquals(expectedLogin, actualLogin);
		System.out.println("Login dengan valid username & password passed");
	}

	@Test
	public void verifyAddEmployeeFailed() {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEmployee = "Required";
		String actualAddEmployee = "";
		actualAddEmployee = driver.findElement(By.className("validation-error")).getText();
		Assert.assertNotEquals(expectedAddEmployee, actualAddEmployee);
		System.out.println("Add employee tanpa isi madatory field passed");
	}

	@Test
	public void verifyAddEmployeeSuccess() {
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Clarke");
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys("3103");
		driver.findElement(By.id("btnSave")).click();

		String expectedFirstName = "John";
		String actualFirstName = "";
		actualFirstName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
		Assert.assertNotEquals(expectedFirstName, actualFirstName);

		String expectedLastName = "Clarke";
		String actualLastName = "";
		actualLastName = driver.findElement(By.id("personal_txtEmpLastName")).getText();
		Assert.assertNotEquals(expectedLastName, actualLastName);

		String expectedEmployeeCode = "3103";
		String actualEmployeeCode = "";
		actualEmployeeCode = driver.findElement(By.id("personal_txtEmployeeId")).getText();
		Assert.assertNotEquals(expectedEmployeeCode, actualEmployeeCode);
		System.out.println("Add employee dengan valid data passed");
	}

	@Test
	public void verifyEditPersonalDetailFailed() {
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEmployee = "Required";
		String actualEditEmployee = "";
		actualEditEmployee = driver.findElement(By.className("validation-error")).getText();
		Assert.assertNotEquals(expectedEditEmployee, actualEditEmployee);
		System.out.println("Edit personal detail tanpa isi madatory field passed");
	}

	@Test
	public void verifyEditPersonalDetailSuccess() {
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Antony");
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Clark");
		driver.findElement(By.id("personal_txtEmployeeId")).clear();
		driver.findElement(By.id("personal_txtEmployeeId")).sendKeys("3103a");
		Select drpNationality = new Select(driver.findElement(By.id("personal_cmbNation")));
		drpNationality.selectByVisibleText("Indonesian");
		driver.findElement(By.id("btnSave")).click();

		String expectedFirstName = "Antony";
		String actualFirstName = "";
		actualFirstName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
		Assert.assertNotEquals(expectedFirstName, actualFirstName);

		String expectedLastName = "Clark";
		String actualLastName = "";
		actualLastName = driver.findElement(By.id("personal_txtEmpLastName")).getText();
		Assert.assertNotEquals(expectedLastName, actualLastName);

		String expectedEmployeeCode = "3103a";
		String actualEmployeeCode = "";
		actualEmployeeCode = driver.findElement(By.id("personal_txtEmployeeId")).getText();
		Assert.assertNotEquals(expectedEmployeeCode, actualEmployeeCode);

		String expectedNationality = "Indonesian";
		String actualNationality = "";
		actualNationality = driver.findElement(By.id("personal_cmbNation")).getText();
		Assert.assertNotEquals(expectedNationality, actualNationality);
		System.out.println("Edit personal detail dengan valid data passed");
	}

	@Test
	public void verifyPunchInFailed() {
		driver.findElement(By.id("menu_time_viewTimeModule")).click();
		driver.findElement(By.id("menu_attendance_Attendance")).click();
		driver.findElement(By.id("menu_attendance_viewAttendanceRecord")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("attendance_employeeName_empName")).sendKeys("Antony Clark");
		driver.findElement(By.id("attendance_date")).clear();
		driver.findElement(By.id("attendance_date")).sendKeys("2020-11-18");	
		driver.findElement(By.id("btView")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("btnPunchOut")).click();
		driver.findElement(By.id("attendance_time")).clear();
		driver.findElement(By.id("attendance_time")).sendKeys("08.00");
		driver.findElement(By.id("btnPunch")).click();
		String expectedPunchIn = "Should Be a Valid Time in HH:MM Format";
		String actualPunchIn = "";
		actualPunchIn = driver.findElement(By.id("timeErrorHolder")).getText();
		Assert.assertEquals(expectedPunchIn, actualPunchIn);
		System.out.println("Punch In dengan invalid time passed");
	}

	@Test
	public void verifyPunchInSuccess() {
		driver.findElement(By.id("attendance_time")).clear();
		driver.findElement(By.id("attendance_time")).sendKeys("08:00");
		driver.findElement(By.id("attendance_note")).sendKeys("test punch in");
		driver.findElement(By.id("btnPunch")).click();
		String expectedPunchIn = "test punch in";
		String actualPunchIn = "";
		actualPunchIn = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]")).getText();
		Assert.assertEquals(expectedPunchIn, actualPunchIn);
		System.out.println("Punch In dengan valid data passed");
	}

	@Test
	public void verifyPunchOutFailed() {
		driver.findElement(By.id("btnPunchOut")).click();
		driver.findElement(By.id("attendance_time")).clear();
		driver.findElement(By.id("attendance_time")).sendKeys("17.30");
		driver.findElement(By.id("btnPunch")).click();
		String expectedPunchOut = "Should Be a Valid Time in HH:MM Format";
		String actualPunchOut = "";
		actualPunchOut = driver.findElement(By.id("timeErrorHolder")).getText();
		Assert.assertEquals(expectedPunchOut, actualPunchOut);
		System.out.println("Punch Out dengan invalid time passed");
	}

	@Test
	public void verifyPunchOutSuccess() {
		driver.findElement(By.id("attendance_time")).clear();
		driver.findElement(By.id("attendance_time")).sendKeys("17:30");
		driver.findElement(By.id("attendance_note")).sendKeys("test punch out");
		driver.findElement(By.id("btnPunch")).click();
		String expectedPunchOut = "test punch out";
		String actualPunchOut = "";
		actualPunchOut = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[6]")).getText();
		Assert.assertEquals(expectedPunchOut, actualPunchOut);
		System.out.println("Punch Out dengan valid data passed");
	}

	@Test
	public void verifyEditAttendanceFailed() {
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.id("attendance_punchInTime_1")).clear();
		driver.findElement(By.id("attendance_punchInTime_1")).sendKeys("08.30");
		driver.findElement(By.id("attendance_punchOutTime_1")).clear();
		driver.findElement(By.id("attendance_punchOutTime_1")).sendKeys("18.00");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditAttendance = "Should Be a Valid Time in HH:MM Format";
		String actualEditAttendance = "";
		actualEditAttendance = driver.findElement(By.id("validationMsg")).getText();
		Assert.assertEquals(expectedEditAttendance, actualEditAttendance);
		System.out.println("Edit Punch In/Out dengan invalid time passed");
	}

	@Test
	public void verifyEditAttendanceSuccess() {
		driver.findElement(By.id("attendance_punchInTime_1")).clear();
		driver.findElement(By.id("attendance_punchInTime_1")).sendKeys("08:30");
		driver.findElement(By.id("attendance_punchOutTime_1")).clear();
		driver.findElement(By.id("attendance_punchOutTime_1")).sendKeys("18:00");
//		driver.findElement(By.xpath("//*[@id=\"175_1_3\"]")).click();
//		driver.findElement(By.id("punchInOutNote")).clear();
//		driver.findElement(By.id("punchInOutNote")).sendKeys("test edit punch in");
//		driver.findElement(By.id("commentSave")).click();
//		driver.findElement(By.xpath("//*[@id=\"175_1_4\"]")).click();
//		driver.findElement(By.id("punchInOutNote")).clear();
//		driver.findElement(By.id("punchInOutNote")).sendKeys("test edit punch out");
		driver.findElement(By.id("btnSave")).click();

		String expectedPunchIn = "2020-11-18 08:30:00 GMT 7.0";
		String actualPunchIn = "";
		actualPunchIn = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[3]")).getText();
		Assert.assertEquals(expectedPunchIn, actualPunchIn);

		String expectedPunchOut = "2020-11-18 18:00:00 GMT 7.0";
		String actualPunchOut = "";
		actualPunchOut = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[5]")).getText();
		Assert.assertEquals(expectedPunchOut, actualPunchOut);
		System.out.println("Edit Punch In/Out dengan valid data passed");
	}

	@Test
	public void verifyDeleteAttendance() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("okBtn")).click();
		String expectedDeleteAttendance = "No attendance records to display";
		String actualDeleteAttendance = "";
		actualDeleteAttendance = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]")).getText();
		Assert.assertEquals(expectedDeleteAttendance, actualDeleteAttendance);
		System.out.println("Delete Punch In/Out dengan valid data passed");
	}

	@Test
	public void verifyAddUserFailed() {
//		username bersifat unik meskipun sudah di delete tetap tidak bisa dipakai lagi, ubah sebelum running automation
		String username = "antony011";

		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_password")).clear();
		driver.findElement(By.id("btnSave")).click();		
		String expectedAddUser1 = "Required";
		String actualAddUser1 = "";
		actualAddUser1 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedAddUser1, actualAddUser1);
		System.out.println("Add user tanpa isi mandatory field passed");

		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("antony clarkee");
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		driver.findElement(By.id("systemUser_password")).sendKeys("j0Hnd033!@");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("j0Hnd033!@");
		driver.findElement(By.id("btnSave")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedAddUser2 = "Employee does not exist";
		String actualAddUser2 = "";
		actualAddUser2 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedAddUser2, actualAddUser2);
		System.out.println("Add user dengan invalid employee name passed");

		
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("antony clark");
		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_userName")).sendKeys("antony001");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddUser3 = "Already exists";
		String actualAddUser3 = "";
		actualAddUser3 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[3]/span")).getText();
		Assert.assertEquals(expectedAddUser3, actualAddUser3);
		System.out.println("Add user dengan invalid username passed");
		

		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		driver.findElement(By.id("systemUser_password")).clear();
		driver.findElement(By.id("systemUser_password")).sendKeys("j0Hnd03");
		driver.findElement(By.id("systemUser_confirmPassword")).clear();
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("j0Hnd03");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddUser4 = "Should have at least 8 characters";
		String actualAddUser4 = "";
		actualAddUser4 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[6]/span")).getText();
		Assert.assertEquals(expectedAddUser4, actualAddUser4);
		System.out.println("Add user dengan password < 8 karakter passed");

		
		driver.findElement(By.id("systemUser_password")).clear();
		driver.findElement(By.id("systemUser_password")).sendKeys("johndoe12");
		driver.findElement(By.id("systemUser_confirmPassword")).clear();
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("johndoe12");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddUser5 = "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.";
		String actualAddUser5 = "";
		actualAddUser5 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[6]/span")).getText();
		Assert.assertEquals(expectedAddUser5, actualAddUser5);
		System.out.println("Add user dengan invalid password passed");

		
		driver.findElement(By.id("systemUser_password")).clear();
		driver.findElement(By.id("systemUser_password")).sendKeys("j0Hnd033!@");
		driver.findElement(By.id("systemUser_password_strength_meter")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddUser6 = "Passwords do not match";
		String actualAddUser6 = "";
		actualAddUser6 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[7]/span")).getText();
		Assert.assertEquals(expectedAddUser6, actualAddUser6);
		System.out.println("Add user dengan invalid confirm password passed");
	}

	@Test
	public void verifyAddUserSuccess() {
//		samakan value username dengan yang diinput
		String username = "antony011";

		driver.findElement(By.id("systemUser_confirmPassword")).clear();
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("j0Hnd033!@");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("btnSave")).click();		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).submit();
		String expectedAddUser = username;
		String actualAddUser = "";
		actualAddUser = driver.findElement(By.linkText(username)).getText();
		Assert.assertEquals(expectedAddUser, actualAddUser);
		System.out.println("Add user dengan valid data passed");
	}

//	@Test
//	public void verifySearchUser() {
//		String username = "antony006";
//		
//		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
//		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
//		driver.findElement(By.id("searchBtn")).click();
//		String expectedSearchUser1 = username;
//		String actualSearchUser1 = "";
//		actualSearchUser1 = driver.findElement(By.linkText(username)).getText();
//		Assert.assertEquals(expectedSearchUser1, actualSearchUser1);
//		System.out.println("Search user dengan filter passed");	
//	}

	@Test
	public void verifyEditUserFailed() {
//		samakan value username dengan yang diinput
		String username = "antony011";

		driver.findElement(By.linkText(username)).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditUser1 = "Required";
		String actualEditUser1 = "";
		actualEditUser1 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedEditUser1, actualEditUser1);
		System.out.println("Edit user tanpa isi mandatory field passed");

		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("john doee");
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		driver.findElement(By.id("btnSave")).click();
		String expectedEditUser2 = "Employee does not exist";
		String actualEditUser2 = "";
		actualEditUser2 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedEditUser2, actualEditUser2);
		System.out.println("Edit user dengan invalid employee name passed");

		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Nia Middle Test");
		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_userName")).sendKeys("johndoe");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditUser3 = "Already exists";
		String actualEditUser3 = "";
		actualEditUser3 = driver.findElement(By.xpath("//*[@id=\"frmSystemUser\"]/fieldset/ol/li[3]/span")).getText();
		Assert.assertEquals(expectedEditUser3, actualEditUser3);
		System.out.println("Edit user dengan invalid username passed");
	}

	@Test
	public void verifyEditUserSuccess() {
//		ubah2 editUserName
		String editUsername = "niatest003";

		driver.findElement(By.id("systemUser_userName")).clear();
		driver.findElement(By.id("systemUser_userName")).sendKeys(editUsername);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(editUsername);
		driver.findElement(By.id("searchBtn")).click();
		String expectedEditUser = editUsername;
		String actualEditUser = "";
		actualEditUser = driver.findElement(By.linkText(editUsername)).getText();
		Assert.assertEquals(expectedEditUser, actualEditUser);
		System.out.println("Edit user dengan valid data passed");
	}

	@Test
	public void verifyDeleteUserSuccess() {
		String editUsername = "niatest003";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(editUsername);
		driver.findElement(By.id("searchBtn")).click();
		String expectedDeleteUser = "No Records Found";
		String actualDeleteUser = "";
		actualDeleteUser = driver.findElement(By.linkText("No Records Found")).getText();
		Assert.assertEquals(expectedDeleteUser, actualDeleteUser);
		System.out.println("Delete user passed");
		
		driver.findElement(By.id("resetBtn")).click();
		String unexpectedResetSearchUser = "No Records Found";
		String actualResetSearchUser = "";
		actualResetSearchUser = driver.findElement(By.linkText("No Records Found")).getText();
		Assert.assertNotEquals(unexpectedResetSearchUser, actualResetSearchUser);
		System.out.println("Reset search user passed");
	}

	@Test
	public void verifySearchEmployee() {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("antony clark");
		driver.findElement(By.id("empsearch_id")).sendKeys("3103a");
		driver.findElement(By.id("searchBtn")).click();
		String expectedEmployeeId = "3103a";
		String actualEmployeeId = "";
		actualEmployeeId = driver.findElement(By.linkText("3103a")).getText();
		Assert.assertEquals(expectedEmployeeId, actualEmployeeId);
		System.out.println("Search employee dengan filter passed");
	}

	@Test
	public void verifyDeleteEmployee() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("antony clark");
		driver.findElement(By.id("empsearch_id")).sendKeys("3103a");
		driver.findElement(By.id("searchBtn")).click();
		String expectedDeleteEmployee = "No Records Found";
		String actualDeleteEmployee = "";
		actualDeleteEmployee = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
		Assert.assertEquals(expectedDeleteEmployee, actualDeleteEmployee);
		System.out.println("Delete employee dengan valid data passed");

		driver.findElement(By.id("resetBtn")).click();
		String unexpectedResetSearchEmployee = "No Records Found";
		String actualResetSearchEmployee = "";
		actualResetSearchEmployee = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
		Assert.assertNotEquals(unexpectedResetSearchEmployee, actualResetSearchEmployee);
		System.out.println("Reset search employee passed");
	}

	@Test
	public void verifyAddJobTitleFailed() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobTitle1 = "Required";
		String actualAddJobTitle1 = "";
		actualAddJobTitle1 = driver.findElement(By.xpath("//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddJobTitle1, actualAddJobTitle1);
		System.out.println("Add job title tanpa isi mandatory field passed");

		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("QA Engineer");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobTitle2 = "Already exists";
		String actualAddJobTitle2 = "";
		actualAddJobTitle2 = driver.findElement(By.xpath("//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddJobTitle2, actualAddJobTitle2);
		System.out.println("Add job title dengan invalid data passed");
	}

	@Test
	public void verifyAddJobTitleSuccess() {
		driver.findElement(By.id("jobTitle_jobTitle")).clear();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobTitle = "aaa";
		String actualAddJobTitle = "";
		actualAddJobTitle = driver.findElement(By.linkText("aaa")).getText();
		Assert.assertEquals(expectedAddJobTitle, actualAddJobTitle);
		System.out.println("Add job title dengan valid data passed");
	}

	@Test
	public void verifyEditJobTitleFailed() {
		driver.findElement(By.linkText("aaa")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).clear();
		driver.findElement(By.id("btnSave")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("validation-error")));
		String expectedEditJobTitle1 = "Required";
		String actualEditJobTitle1 = "";
		actualEditJobTitle1 = driver.findElement(By.xpath("//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditJobTitle1, actualEditJobTitle1);
		System.out.println("Edit job title tanpa isi mandatory field passed");

		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("QA Engineer");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditJobTitle2 = "Already exists";
		String actualEditJobTitle2 = "";
		actualEditJobTitle2 = driver.findElement(By.xpath("//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditJobTitle2, actualEditJobTitle2);
		System.out.println("Edit job title dengan invalid data passed");
	}

	@Test
	public void verifyEditJobTitleSuccess() {
		driver.findElement(By.id("jobTitle_jobTitle")).clear();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobTitle = "aaaa";
		String actualAddJobTitle = "";
		actualAddJobTitle = driver.findElement(By.linkText("aaaa")).getText();
		Assert.assertEquals(expectedAddJobTitle, actualAddJobTitle);
		System.out.println("Edit job title dengan valid data passed");
	}

	@Test
	public void verifyDeleteJobTitleSuccess() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteJobTitle = "aaaa";
		String actualDeleteJobTitle = "";
		actualDeleteJobTitle = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteJobTitle, actualDeleteJobTitle);
		System.out.println("Delete job title passed");
	}

	@Test
	public void modulAdmin() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	
	@Test
	public void verifyAddPayGradeFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewPayGrades")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddPayGrade1 = "Required";
		String actualAddPayGrade1 = "";
		actualAddPayGrade1 = driver.findElement(By.xpath("//*[@id=\"frmPayGrade\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddPayGrade1, actualAddPayGrade1);
		System.out.println("Add pay grade tanpa isi mandatory field passed");

		driver.findElement(By.id("payGrade_name")).sendKeys("staff");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddPayGrade2 = "Already exists";
		String actualAddPayGrade2 = "";
		actualAddPayGrade2 = driver.findElement(By.xpath("//*[@id=\"frmPayGrade\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddPayGrade2, actualAddPayGrade2);
		System.out.println("Add pay grade dengan invalid data passed");
	}

	@Test
	public void verifyAddPayGradeSuccess() {
		driver.findElement(By.id("payGrade_name")).clear();
		driver.findElement(By.id("payGrade_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnCancel")).click();
		String expectedAddPayGrade = "aaa";
		String actualAddPayGrade = "";
		actualAddPayGrade = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedAddPayGrade, actualAddPayGrade);
		System.out.println("Add pay grade dengan valid data passed");
	}

	@Test
	public void verifyEditPayGradeFailed() {
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("payGrade_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditPayGrade1 = "Required";
		String actualEditPayGrade1 = "";
		actualEditPayGrade1 = driver.findElement(By.xpath("//*[@id=\"frmPayGrade\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditPayGrade1, actualEditPayGrade1);
		System.out.println("Edit pay grade tanpa isi mandatory field passed");

		driver.findElement(By.id("payGrade_name")).sendKeys("staff");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditPayGrade2 = "Already exists";
		String actualEditPayGrade2 = "";
		actualEditPayGrade2 = driver.findElement(By.xpath("//*[@id=\"frmPayGrade\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditPayGrade2, actualEditPayGrade2);
		System.out.println("Edit pay grade dengan invalid data passed");
	}

	@Test
	public void verifyEditPayGradeSuccess() {
		driver.findElement(By.id("payGrade_name")).clear();
		driver.findElement(By.id("payGrade_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnCancel")).click();
		String expectedEditPayGrade = "aaaa";
		String actualEditPayGrade = "";
		actualEditPayGrade = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditPayGrade, actualEditPayGrade);
		System.out.println("Edit pay grade dengan valid data passed");
	}

	@Test
	public void verifyDeletePayGrade() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeletePayGrade = "aaaa";
		String actualDeletePayGrade = "";
		actualDeletePayGrade = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeletePayGrade, actualDeletePayGrade);
		System.out.println("Delete pay grade passed");
	}

	@Test
	public void verifyAddEmploymentStatusFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_employmentStatus")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEmploymentStatus1 = "Required";
		String actualAddEmploymentStatus1 = "";
		actualAddEmploymentStatus1 = driver.findElement(By.xpath("//*[@id=\"frmEmpStatus\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddEmploymentStatus1, actualAddEmploymentStatus1);
		System.out.println("Add employement status tanpa isi mandatory field passed");

		driver.findElement(By.id("empStatus_name")).sendKeys("Internship");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEmploymentStatus2 = "Already exists";
		String actualAddEmploymentStatus2 = "";
		actualAddEmploymentStatus2 = driver.findElement(By.xpath("//*[@id=\"frmEmpStatus\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddEmploymentStatus2, actualAddEmploymentStatus2);
		System.out.println("Add employement status dengan invalid data passed");
	}

	@Test
	public void verifyAddEmploymentStatusSuccess() {
		driver.findElement(By.id("empStatus_name")).clear();
		driver.findElement(By.id("empStatus_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEmploymentStatus = "aaa";
		String actualAddEmploymentStatus = "";
		actualAddEmploymentStatus = driver.findElement(By.linkText("aaa")).getText();
		Assert.assertEquals(expectedAddEmploymentStatus, actualAddEmploymentStatus);
		System.out.println("Add employement status dengan valid data passed");
	}

	@Test
	public void verifyEditEmploymentStatusFailed() {
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"empStatus_name\"]")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEmploymentStatus1 = "Required";
		String actualEditEmploymentStatus1 = "";
		actualEditEmploymentStatus1 = driver.findElement(By.xpath("//*[@id=\"frmEmpStatus\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditEmploymentStatus1, actualEditEmploymentStatus1);
		System.out.println("Edit employement status tanpa isi mandatory field passed");

		driver.findElement(By.id("empStatus_name")).sendKeys("Internship");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEmploymentStatus2 = "Already exists";
		String actualEditEmploymentStatus2 = "";
		actualEditEmploymentStatus2 = driver.findElement(By.xpath("//*[@id=\"frmEmpStatus\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditEmploymentStatus2, actualEditEmploymentStatus2);
		System.out.println("Edit employement status dengan invalid data passed");
	}

	@Test
	public void verifyEditEmploymentStatusSuccess() {
		driver.findElement(By.id("empStatus_name")).clear();
		driver.findElement(By.id("empStatus_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEmploymentStatus = "aaaa";
		String actualEditEmploymentStatus = "";
		actualEditEmploymentStatus = driver.findElement(By.linkText("aaaa")).getText();
		Assert.assertEquals(expectedEditEmploymentStatus, actualEditEmploymentStatus);
		System.out.println("Edit employement status dengan valid data passed");
	}

	@Test
	public void verifyDeleteEmploymentStatus() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteEmploymentStatus = "aaaa";
		String actualDeleteEmploymentStatus = "";
		actualDeleteEmploymentStatus = driver.findElement(By.linkText("Internship")).getText();
		Assert.assertNotEquals(unexpectedDeleteEmploymentStatus, actualDeleteEmploymentStatus);
		System.out.println("Delete employement status passed");
	}

	@Test
	public void verifyAddJobCategoryFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_jobCategory")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobCategory1 = "Required";
		String actualAddJobCategory1 = "";
		actualAddJobCategory1 = driver.findElement(By.xpath("//*[@id=\"frmJobCategory\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddJobCategory1, actualAddJobCategory1);
		System.out.println("Add job category tanpa isi mandatory field passed");

		driver.findElement(By.id("jobCategory_name")).sendKeys("IT");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobCategory2 = "Already exists";
		String actualAddJobCategory2 = "";
		actualAddJobCategory2 = driver.findElement(By.xpath("//*[@id=\"frmJobCategory\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddJobCategory2, actualAddJobCategory2);
		System.out.println("Add job category dengan invalid data passed");
	}

	@Test
	public void verifyAddJobCategorySuccess() {
		driver.findElement(By.id("jobCategory_name")).clear();
		driver.findElement(By.id("jobCategory_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddJobCategory = "aaa";
		String actualAddJobCategory = "";
		actualAddJobCategory = driver.findElement(By.linkText("aaa")).getText();
		Assert.assertEquals(expectedAddJobCategory, actualAddJobCategory);
		System.out.println("Add job category dengan valid data passed");
	}

	@Test
	public void verifyEditJobCategoryFailed() {
		driver.findElement(By.linkText("aaa")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("jobCategory_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditJobCategory1 = "Required";
		String actualEditJobCategory1 = "";
		actualEditJobCategory1 = driver.findElement(By.xpath("//*[@id=\"frmJobCategory\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditJobCategory1, actualEditJobCategory1);
		System.out.println("Edit job category tanpa isi mandatory field passed");

		driver.findElement(By.id("jobCategory_name")).sendKeys("QA Engineer");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditJobCategory2 = "Already exists";
		String actualEditJobCategory2 = "";
		actualEditJobCategory2 = driver.findElement(By.xpath("//*[@id=\"frmJobCategory\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditJobCategory2, actualEditJobCategory2);
		System.out.println("Edit job category dengan invalid data passed");
	}

	@Test
	public void verifyEditJobCategorySuccess() {
		driver.findElement(By.id("jobCategory_name")).clear();
		driver.findElement(By.id("jobCategory_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditJobCategory = "aaaa";
		String actualEditJobCategory = "";
		actualEditJobCategory = driver.findElement(By.linkText("aaaa")).getText();
		Assert.assertEquals(expectedEditJobCategory, actualEditJobCategory);
		System.out.println("Edit job category dengan valid data passed");
	}

	@Test
	public void verifyDeleteJobCategory() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteJobCategory = "aaaa";
		String actualDeleteJobCategory = "";
		actualDeleteJobCategory = driver.findElement(By.linkText("Craft Workers")).getText();
		Assert.assertNotEquals(unexpectedDeleteJobCategory, actualDeleteJobCategory);
		System.out.println("Delete job category passed");
	}

	@Test
	public void verifyAddWorkShiftFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_workShift")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddWorkShift1 = "Required";
		String actualAddWorkShift1 = "";
		actualAddWorkShift1 = driver.findElement(By.xpath("//*[@id=\"frmWorkShift\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddWorkShift1, actualAddWorkShift1);
		System.out.println("Add work shift tanpa isi mandatory field passed");

		driver.findElement(By.id("workShift_name")).sendKeys("zenitsu");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddWorkShift2 = "Already exists";
		String actualAddWorkShift2 = "";
		actualAddWorkShift2 = driver.findElement(By.xpath("//*[@id=\"frmWorkShift\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddWorkShift2, actualAddWorkShift2);
		System.out.println("Add work shift dengan invalid data passed");
	}

	@Test
	public void verifyAddWorkShiftSuccess() {
		driver.findElement(By.id("workShift_name")).clear();
		driver.findElement(By.id("workShift_name")).sendKeys("aaa");
		Select drpWorkHours = new Select(driver.findElement(By.id("workShift_workHours_from")));
		drpWorkHours.selectByVisibleText("08:00");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddWorkShift = "aaa";
		String actualAddWorkShift = "";
		actualAddWorkShift = driver.findElement(By.linkText("aaa")).getText();
		Assert.assertEquals(expectedAddWorkShift, actualAddWorkShift);
		System.out.println("Add work shift dengan valid data passed");
	}

	@Test
	public void verifyEditWorkShiftFailed() {
		driver.findElement(By.linkText("aaa")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("workShift_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditWorkShift1 = "Required";
		String actualEditWorkShift1 = "";
		actualEditWorkShift1 = driver.findElement(By.xpath("//*[@id=\"frmWorkShift\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditWorkShift1, actualEditWorkShift1);
		System.out.println("Edit work shift tanpa isi mandatory field passed");

		driver.findElement(By.id("workShift_name")).sendKeys("zenitsu");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditWorkShift2 = "Already exists";
		String actualEditWorkShift2 = "";
		actualEditWorkShift2 = driver.findElement(By.xpath("//*[@id=\"frmWorkShift\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditWorkShift2, actualEditWorkShift2);
		System.out.println("Edit work shift dengan invalid data passed");
	}

	@Test
	public void verifyEditWorkShiftSuccess() {
		driver.findElement(By.id("workShift_name")).clear();
		driver.findElement(By.id("workShift_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditWorkShift = "aaaa";
		String actualEditWorkShift = "";
		actualEditWorkShift = driver.findElement(By.linkText("aaaa")).getText();
		Assert.assertEquals(expectedEditWorkShift, actualEditWorkShift);
		System.out.println("Edit work shift dengan valid data passed");
	}

	@Test
	public void verifyDeleteWorkShift() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteWorkShift = "aaaa";
		String actualDeleteWorkShift = "";
		actualDeleteWorkShift = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteWorkShift, actualDeleteWorkShift);
		System.out.println("Delete work shift passed");
	}

	@Test
	public void verifyEditGeneralInfoFailed() {
		driver.findElement(By.id("menu_admin_Organization")).click();
		driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
		driver.findElement(By.id("btnSaveGenInfo")).click();
		driver.findElement(By.id("organization_name")).clear();
		driver.findElement(By.id("btnSaveGenInfo")).click();
		String expectedEditGeneralInfo1 = "Required";
		String actualEditGeneralInfo1 = "";
		actualEditGeneralInfo1 = driver.findElement(By.xpath("//*[@id=\"frmGenInfo\"]/fieldset/ol[1]/li[1]/span")).getText();
		Assert.assertEquals(expectedEditGeneralInfo1, actualEditGeneralInfo1);
		System.out.println("Edit general information tanpa isi mandatory field passed");

		driver.findElement(By.id("organization_name")).sendKeys("Ajo Resort");
		driver.findElement(By.id("organization_email")).clear();
		driver.findElement(By.id("organization_email")).sendKeys("ajoresort@email");
		driver.findElement(By.id("btnSaveGenInfo")).click();
		String expectedEditGeneralInfo2 = "Expected format: admin@example.com";
		String actualEditGeneralInfo2 = "";
		actualEditGeneralInfo2 = driver.findElement(By.xpath("//*[@id=\"frmGenInfo\"]/fieldset/ol[2]/li[3]/span")).getText();
		Assert.assertEquals(expectedEditGeneralInfo2, actualEditGeneralInfo2);
		System.out.println("Edit general information dengan invalid email passed");

		driver.findElement(By.id("organization_email")).clear();
		driver.findElement(By.id("organization_email")).sendKeys("ajoresort@email.com");
		driver.findElement(By.id("organization_phone")).clear();
		driver.findElement(By.id("organization_phone")).sendKeys("asd");
		driver.findElement(By.id("btnSaveGenInfo")).click();
		String expectedEditGeneralInfo3 = "Allows numbers and only + - / ( )";
		String actualEditGeneralInfo3 = "";
		actualEditGeneralInfo3 = driver.findElement(By.xpath("//*[@id=\"frmGenInfo\"]/fieldset/ol[2]/li[1]/span")).getText();
		Assert.assertEquals(expectedEditGeneralInfo3, actualEditGeneralInfo3);
		System.out.println("Edit general information dengan invalid phone passed");

		driver.findElement(By.id("organization_phone")).clear();
		driver.findElement(By.id("organization_phone")).sendKeys("021-8008932");
		driver.findElement(By.id("organization_fax")).clear();
		driver.findElement(By.id("organization_fax")).sendKeys("asd");
		driver.findElement(By.id("btnSaveGenInfo")).click();
		String expectedEditGeneralInfo4 = "Allows numbers and only + - / ( )";
		String actualEditGeneralInfo4 = "";
		actualEditGeneralInfo4 = driver.findElement(By.xpath("//*[@id=\"frmGenInfo\"]/fieldset/ol[2]/li[2]/span")).getText();
		Assert.assertEquals(expectedEditGeneralInfo4, actualEditGeneralInfo4);
		System.out.println("Edit general information dengan invalid fax passed");
	}

	@Test
	public void verifyEditGeneralInfoSuccess() {
		driver.findElement(By.id("organization_fax")).clear();
		driver.findElement(By.id("organization_fax")).sendKeys("021-8008933");
		driver.findElement(By.id("btnSaveGenInfo")).click();

		String expectedEditOrgName = "Ajo Resort";
		String actualEditOrgName = "";
		actualEditOrgName = driver.findElement(By.id("organization_name")).getAttribute("value");
		Assert.assertEquals(expectedEditOrgName, actualEditOrgName);

		String expectedEditPhone = "021-8008932";
		String actualEditPhone = "";
		actualEditPhone = driver.findElement(By.id("organization_phone")).getAttribute("value");
		Assert.assertEquals(expectedEditPhone, actualEditPhone);

		String expectedEditFax = "021-8008933";
		String actualEditFax = "";
		actualEditFax = driver.findElement(By.id("organization_fax")).getAttribute("value");
		Assert.assertEquals(expectedEditFax, actualEditFax);

		String expectedEditEmail = "ajoresort@email.com";
		String actualEditEmail = "";
		actualEditEmail = driver.findElement(By.id("organization_email")).getAttribute("value");
		Assert.assertEquals(expectedEditEmail, actualEditEmail);
		System.out.println("Edit general information dengan valid data passed");
	}

	@Test
	public void verifyAddLocationFailed() {
		driver.findElement(By.id("menu_admin_Organization")).click();
		driver.findElement(By.id("menu_admin_viewLocations")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLocation1 = "Required";
		String actualAddLocation1 = "";
		actualAddLocation1 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddLocation1, actualAddLocation1);
		System.out.println("Add location tanpa isi mandatory field passed");

		driver.findElement(By.id("location_name")).sendKeys("aaa");
		Select drpCountry = new Select(driver.findElement(By.id("location_country")));
		drpCountry.selectByVisibleText("Singapore");
		driver.findElement(By.id("location_province")).sendKeys("Singapore");
		driver.findElement(By.id("location_city")).sendKeys("Singapore");
		driver.findElement(By.id("location_address")).sendKeys("16 Sandilands Road");
		driver.findElement(By.id("location_zipCode")).sendKeys("546080");
		driver.findElement(By.id("location_phone")).sendKeys("asd");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLocation2 = "Allows numbers and only + - / ( )";
		String actualAddLocation2 = "";
		actualAddLocation2 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[8]/span")).getText();
		Assert.assertEquals(expectedAddLocation2, actualAddLocation2);
		System.out.println("Add location dengan invalid phone passed");

		driver.findElement(By.id("location_phone")).clear();
		driver.findElement(By.id("location_phone")).sendKeys("+6581001234");
		driver.findElement(By.id("location_fax")).sendKeys("asd");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLocation3 = "Allows numbers and only + - / ( )";
		String actualAddLocation3 = "";
		actualAddLocation3 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[9]/span")).getText();
		Assert.assertEquals(expectedAddLocation3, actualAddLocation3);
		System.out.println("Add location dengan invalid fax passed");
	}

	@Test
	public void verifyAddLocationSuccess() {
		driver.findElement(By.id("location_fax")).clear();
		driver.findElement(By.id("location_fax")).sendKeys("+6581001235");
		driver.findElement(By.id("location_notes")).sendKeys("nia test");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchLocation_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSearch")).click();
		String expectedAddLocation = "aaa";
		String actualAddLocation = "";
		actualAddLocation = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedAddLocation, actualAddLocation);
		System.out.println("Add location dengan valid data passed");
	}

	@Test
	public void verifyEditLocationFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("location_name")).clear();
		Select drpCountry = new Select(driver.findElement(By.id("location_country")));
		drpCountry.selectByVisibleText("-- Select --");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLocation1 = "Required";
		String actualEditLocation1 = "";
		actualEditLocation1 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditLocation1, actualEditLocation1);
		System.out.println("Add location tanpa isi mandatory field passed");

		driver.findElement(By.id("location_name")).sendKeys("aaaa");
		drpCountry.selectByVisibleText("Indonesia");
		driver.findElement(By.id("location_province")).clear();
		driver.findElement(By.id("location_province")).sendKeys("Siantar");
		driver.findElement(By.id("location_city")).clear();
		driver.findElement(By.id("location_city")).sendKeys("Sumatera Utara");
		driver.findElement(By.id("location_address")).clear();
		driver.findElement(By.id("location_address")).sendKeys("Jl. Merdeka X");
		driver.findElement(By.id("location_address")).clear();
		driver.findElement(By.id("location_address")).sendKeys("12345");
		driver.findElement(By.id("location_phone")).clear();
		driver.findElement(By.id("location_phone")).sendKeys("asd");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLocation2 = "Allows numbers and only + - / ( )";
		String actualEditLocation2 = "";
		actualEditLocation2 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[8]/span")).getText();
		Assert.assertEquals(expectedEditLocation2, actualEditLocation2);
		System.out.println("Edit location dengan invalid phone passed");

		driver.findElement(By.id("location_phone")).clear();
		driver.findElement(By.id("location_phone")).sendKeys("021-8008932");
		driver.findElement(By.id("location_fax")).clear();
		driver.findElement(By.id("location_fax")).sendKeys("asd");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLocation3 = "Allows numbers and only + - / ( )";
		String actualEditLocation3 = "";
		actualEditLocation3 = driver.findElement(By.xpath("//*[@id=\"frmLocation\"]/fieldset/ol/li[9]/span")).getText();
		Assert.assertEquals(expectedEditLocation3, actualEditLocation3);
		System.out.println("Edit location dengan invalid fax passed");
	}

	@Test
	public void verifyEditLocationSuccess() {
		driver.findElement(By.id("location_fax")).clear();
		driver.findElement(By.id("location_fax")).sendKeys("021-8008933");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchLocation_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSearch")).click();
		String expectedEditLocation = "aaaa";
		String actualEditLocation = "";
		actualEditLocation = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditLocation, actualEditLocation);
		System.out.println("Edit location dengan valid data passed");
	}

	@Test
	public void verifyDeleteLocation() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		driver.findElement(By.id("searchLocation_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSearch")).click();
		String expectedDeleteLocation = "No Records Found";
		String actualDeleteLocation = "";
		actualDeleteLocation = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
		Assert.assertEquals(expectedDeleteLocation, actualDeleteLocation);
		System.out.println("Delete location dengan valid data passed");

		driver.findElement(By.id("btnReset")).click();
		String unexpectedResetSearchLocation = "No Records Found";
		String actualResetSearchLocation = "";
		actualResetSearchLocation = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedResetSearchLocation, actualResetSearchLocation);
		System.out.println("Reset search location passed");
	}

	@Test
	public void verifyAddStructureFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_admin_Organization")).click();
		driver.findElement(By.id("menu_admin_viewCompanyStructure")).click();
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.xpath("//*[@id=\"treeLink_addChild_9\"]")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddStructure = "Required";
		String actualAddStructure = "";
		actualAddStructure = driver.findElement(By.xpath("//*[@id=\"ohrmFormComponent_Form\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedAddStructure, actualAddStructure);
		System.out.println("Add structure tanpa isi mandatory field passed");
	}
	
	@Test
	public void verifyAddStructureSuccess() {
		driver.findElement(By.id("txtName")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddStructure = "aaa";
		String actualAddStructure = "";
		actualAddStructure = driver.findElement(By.linkText("aaa")).getText();
		Assert.assertEquals(expectedAddStructure, actualAddStructure);
		System.out.println("Add structure dengan valid data passed");
	}
	
	@Test
	public void verifyEditStructureFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("aaa")).click();
		driver.findElement(By.id("txtName")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditStructure = "Required";
		String actualEditStructure = "";
		actualEditStructure = driver.findElement(By.xpath("//*[@id=\"ohrmFormComponent_Form\"]/fieldset/ol/li[2]/span")).getText();
		Assert.assertEquals(expectedEditStructure, actualEditStructure);
		System.out.println("Edit structure tanpa isi mandatory field passed");
	}
	
	@Test
	public void verifyEditStructureSuccess() {
		driver.findElement(By.id("txtName")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditStructure = "aaaa";
		String actualEditStructure = "";
		actualEditStructure = driver.findElement(By.linkText("aaaa")).getText();
		Assert.assertEquals(expectedEditStructure, actualEditStructure);
		System.out.println("Edit structure dengan valid data passed");
		driver.findElement(By.id("btnEdit")).click();
	}

	@Test
	public void verifyAddSkillFailed() {
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddSkill1 = "Required";
		String actualAddSkill1 = "";
		actualAddSkill1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddSkill1, actualAddSkill1);
		System.out.println("Add skill tanpa isi mandatory field passed");

		driver.findElement(By.id("skill_name")).sendKeys("selenium");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddSkill2 = "Already exists";
		String actualAddSkill2 = "";
		actualAddSkill2 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddSkill2, actualAddSkill2);
		System.out.println("Add skill dengan invalid data passed");
	}

	@Test
	public void verifyAddSkillSuccess() {
		driver.findElement(By.id("skill_name")).clear();
		driver.findElement(By.id("skill_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddSkill = "aaa";
		String actualAddSkill = "";
		actualAddSkill = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddSkill, actualAddSkill);
		System.out.println("Add skill dengan valid data passed");
	}

	@Test
	public void verifyEditSkillFailed() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("skill_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditSkill1 = "Required";
		String actualEditSkill1 = "";
		actualEditSkill1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditSkill1, actualEditSkill1);
		System.out.println("Edit skill tanpa isi mandatory field passed");

		driver.findElement(By.id("skill_name")).sendKeys("selenium");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditSkill2 = "Already exists";
		String actualEditSkill2 = "";
		actualEditSkill2 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditSkill2, actualEditSkill2);
		System.out.println("Edit skill dengan invalid data passed");
	}

	@Test
	public void verifyEditSkillSuccess() {
		driver.findElement(By.id("skill_name")).clear();
		driver.findElement(By.id("skill_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditSkill = "aaaa";
		String actualEditSkill = "";
		actualEditSkill = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedEditSkill, actualEditSkill);
		System.out.println("Edit skill dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteSkill() {
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		String unexpectedDeleteSkill = "aaaa";
		String actualDeleteSkill = "";
		actualDeleteSkill = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteSkill, actualDeleteSkill);
		System.out.println("Delete skill dengan valid data passed");
	}
	
	@Test
	public void verifyAddEducationFailed() {
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewEducation")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEducation1 = "Required";
		String actualAddEducation1 = "";
		actualAddEducation1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddEducation1, actualAddEducation1);
		System.out.println("Add education tanpa isi mandatory field passed");

		driver.findElement(By.id("education_name")).sendKeys("bachelor degree");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEducation2 = "Bachelor Degree";
		String actualAddEducation2 = "";
		actualAddEducation2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedAddEducation2, actualAddEducation2);
		System.out.println("Add education dengan invalid data passed");
	}

	@Test
	public void verifyAddEducationSuccess() {
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("education_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddEducation = "aaa";
		String actualAddEducation = "";
		actualAddEducation = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddEducation, actualAddEducation);
		System.out.println("Add education dengan valid data passed");
	}

	@Test
	public void verifyEditEducationFailed() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("education_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEducation1 = "Required";
		String actualEditEducation1 = "";
		actualEditEducation1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditEducation1, actualEditEducation1);
		System.out.println("Edit education tanpa isi mandatory field passed");

		driver.findElement(By.id("education_name")).sendKeys("bachelor degree");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEducation2 = "Bachelor Degree";
		String actualEditEducation2 = "";
		actualEditEducation2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[2]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditEducation2, actualEditEducation2);
		System.out.println("Edit education dengan invalid data passed");
	}

	@Test
	public void verifyEditEducationSuccess() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("education_name")).clear();
		driver.findElement(By.id("education_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditEducation = "aaaa";
		String actualEditEducation = "";
		actualEditEducation = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedEditEducation, actualEditEducation);
		System.out.println("Edit education dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteEducation() {
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		String unexpectedDeleteEducation = "aaaa";
		String actualDeleteEducation = "";
		actualDeleteEducation = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteEducation, actualDeleteEducation);
		System.out.println("Delete education dengan valid data passed");
	}
	
	@Test
	public void verifyAddLicenseFailed() {
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewLicenses")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLicense1 = "Required";
		String actualAddLicense1 = "";
		actualAddLicense1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddLicense1, actualAddLicense1);
		System.out.println("Add license tanpa isi mandatory field passed");

		driver.findElement(By.id("license_name")).sendKeys("sim a");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLicense2 = "SIM A";
		String actualAddLicense2 = "";
		actualAddLicense2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddLicense2, actualAddLicense2);
		System.out.println("Add license dengan invalid data passed");
	}

	@Test
	public void verifyAddLicenseSuccess() {
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("license_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLicense = "aaa";
		String actualAddLicense = "";
		actualAddLicense = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddLicense, actualAddLicense);
		System.out.println("Add license dengan valid data passed");
	}

	@Test
	public void verifyEditLicenseFailed() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("license_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLicense1 = "Required";
		String actualEditLicense1 = "";
		actualEditLicense1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditLicense1, actualEditLicense1);
		System.out.println("Edit license tanpa isi mandatory field passed");

		driver.findElement(By.id("license_name")).sendKeys("sim a");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLicense2 = "SIM A";
		String actualEditLicense2 = "";
		actualEditLicense2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[2]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditLicense2, actualEditLicense2);
		System.out.println("Edit license dengan invalid data passed");
	}

	@Test
	public void verifyEditLicenseSuccess() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("license_name")).clear();
		driver.findElement(By.id("license_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLicense = "aaaa";
		String actualEditLicense = "";
		actualEditLicense = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedEditLicense, actualEditLicense);
		System.out.println("Edit license dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteLicense() {
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		String unexpectedDeleteLicense = "aaaa";
		String actualDeleteLicense = "";
		actualDeleteLicense = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteLicense, actualDeleteLicense);
		System.out.println("Delete license dengan valid data passed");
	}
	
	@Test
	public void verifyAddLanguageFailed() {
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewLanguages")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLanguage1 = "Required";
		String actualAddLanguage1 = "";
		actualAddLanguage1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddLanguage1, actualAddLanguage1);
		System.out.println("Add language tanpa isi mandatory field passed");

		driver.findElement(By.id("language_name")).sendKeys("Indonesia");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLanguage2 = "Indonesia";
		String actualAddLanguage2 = "";
		actualAddLanguage2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddLanguage2, actualAddLanguage2);
		System.out.println("Add language dengan invalid data passed");
	}

	@Test
	public void verifyAddLanguageSuccess() {
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("language_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddLanguage = "aaa";
		String actualAddLanguage = "";
		actualAddLanguage = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedAddLanguage, actualAddLanguage);
		System.out.println("Add language dengan valid data passed");
	}

	@Test
	public void verifyEditLanguageFailed() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("language_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLanguage1 = "Required";
		String actualEditLanguage1 = "";
		actualEditLanguage1 = driver.findElement(By.xpath("//*[@id=\"frmSave\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditLanguage1, actualEditLanguage1);
		System.out.println("Edit language tanpa isi mandatory field passed");

		driver.findElement(By.id("language_name")).sendKeys("Indonesia");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLanguage2 = "Indonesia";
		String actualEditLanguage2 = "";
		actualEditLanguage2 = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[2]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditLanguage2, actualEditLanguage2);
		System.out.println("Edit language dengan invalid data passed");
	}

	@Test
	public void verifyEditLanguageSuccess() {
		driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("language_name")).clear();
		driver.findElement(By.id("language_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditLanguage = "aaaa";
		String actualEditLanguage = "";
		actualEditLanguage = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertEquals(expectedEditLanguage, actualEditLanguage);
		System.out.println("Edit language dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteLanguage() {
		driver.findElement(By.name("chkListRecord[]")).click();
		driver.findElement(By.id("btnDel")).click();
		String unexpectedDeleteLanguage = "aaaa";
		String actualDeleteLanguage = "";
		actualDeleteLanguage = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteLanguage, actualDeleteLanguage);
		System.out.println("Delete language dengan valid data passed");
	}
	
	@Test
	public void verifyAddMembershipFailed() {
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_membership")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddMembership1 = "Required";
		String actualAddMembership1 = "";
		actualAddMembership1 = driver.findElement(By.xpath("//*[@id=\"frmMembership\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddMembership1, actualAddMembership1);
		System.out.println("Add membership tanpa isi mandatory field passed");

		driver.findElement(By.id("membership_name")).sendKeys("inosuke");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddMembership2 = "Already exists";
		String actualAddMembership2 = "";
		actualAddMembership2 = driver.findElement(By.xpath("//*[@id=\"frmMembership\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddMembership2, actualAddMembership2);
		System.out.println("Add membership dengan invalid data passed");
	}

	@Test
	public void verifyAddMembershipSuccess() {
		driver.findElement(By.id("membership_name")).clear();
		driver.findElement(By.id("membership_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddMembership = "aaa";
		String actualAddMembership = "";
		actualAddMembership = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedAddMembership, actualAddMembership);
		System.out.println("Add membership dengan valid data passed");
	}

	@Test
	public void verifyEditMembershipFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("membership_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditMembership1 = "Required";
		String actualEditMembership1 = "";
		actualEditMembership1 = driver.findElement(By.xpath("//*[@id=\"frmMembership\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditMembership1, actualEditMembership1);
		System.out.println("Edit membership tanpa isi mandatory field passed");

		driver.findElement(By.id("membership_name")).sendKeys("inosuke");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditMembership2 = "Already exists";
		String actualEditMembership2 = "";
		actualEditMembership2 = driver.findElement(By.xpath("//*[@id=\"frmMembership\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditMembership2, actualEditMembership2);
		System.out.println("Edit membership dengan invalid data passed");
	}

	@Test
	public void verifyEditMembershipSuccess() {
		driver.findElement(By.id("membership_name")).clear();
		driver.findElement(By.id("membership_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditMembership = "aaaa";
		String actualEditMembership = "";
		actualEditMembership = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditMembership, actualEditMembership);
		System.out.println("Edit membership dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteMembership() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteMembership = "aaaa";
		String actualDeleteMembership = "";
		actualDeleteMembership = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteMembership, actualDeleteMembership);
		System.out.println("Delete membership dengan valid data passed");
	}
	
	@Test
	public void verifyAddNationalityFailed() {
		driver.findElement(By.id("menu_admin_nationality")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("btnSave")).click();
		String expectedAddNationality1 = "Required";
		String actualAddNationality1 = "";
		actualAddNationality1 = driver.findElement(By.xpath("//*[@id=\"frmNationality\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddNationality1, actualAddNationality1);
		System.out.println("Add nationality tanpa isi mandatory field passed");

		driver.findElement(By.id("nationality_name")).sendKeys("Afghan");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddNationality2 = "Already exists";
		String actualAddNationality2 = "";
		actualAddNationality2 = driver.findElement(By.xpath("//*[@id=\"frmNationality\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedAddNationality2, actualAddNationality2);
		System.out.println("Add nationality dengan invalid data passed");
	}

	@Test
	public void verifyAddNationalitySuccess() {
		driver.findElement(By.id("nationality_name")).clear();
		driver.findElement(By.id("nationality_name")).sendKeys("aaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedAddNationality = "aaa";
		String actualAddNationality = "";
		actualAddNationality = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedAddNationality, actualAddNationality);
		System.out.println("Add nationality dengan valid data passed");
	}

	@Test
	public void verifyEditNationalityFailed() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("nationality_name")).clear();
		driver.findElement(By.id("btnSave")).click();
		String expectedEditNationality1 = "Required";
		String actualEditNationality1 = "";
		actualEditNationality1 = driver.findElement(By.xpath("//*[@id=\"frmNationality\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditNationality1, actualEditNationality1);
		System.out.println("Edit nationality tanpa isi mandatory field passed");

		driver.findElement(By.id("nationality_name")).sendKeys("Afghan");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditNationality2 = "Already exists";
		String actualEditNationality2 = "";
		actualEditNationality2 = driver.findElement(By.xpath("//*[@id=\"frmNationality\"]/fieldset/ol/li[1]/span")).getText();
		Assert.assertEquals(expectedEditNationality2, actualEditNationality2);
		System.out.println("Edit nationality dengan invalid data passed");
	}

	@Test
	public void verifyEditNationalitySuccess() {
		driver.findElement(By.id("nationality_name")).clear();
		driver.findElement(By.id("nationality_name")).sendKeys("aaaa");
		driver.findElement(By.id("btnSave")).click();
		String expectedEditNationality = "aaaa";
		String actualEditNationality = "";
		actualEditNationality = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertEquals(expectedEditNationality, actualEditNationality);
		System.out.println("Edit nationality dengan valid data passed");
	}
	
	@Test
	public void verifyDeleteNationality() {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String unexpectedDeleteNationality = "aaaa";
		String actualDeleteNationality = "";
		actualDeleteNationality = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).getText();
		Assert.assertNotEquals(unexpectedDeleteNationality, actualDeleteNationality);
		System.out.println("Delete nationality dengan valid data passed");
	}
	
	@Test
	public void logout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
		String expectedLogout = "LOGIN Panel";
		String actualLogout = "";
		actualLogout = driver.findElement(By.id("logInPanelHeading")).getText();
		Assert.assertEquals(expectedLogout, actualLogout);
		System.out.println("Logout passed");
		
		driver.close();
	}
}
