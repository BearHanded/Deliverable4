package cs1699.deliverable4;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class testing {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://pets.overstock.com/");
		selenium.start();
	}
	
	
	@Test
	public void testNotFound() throws Exception {
		selenium.open("/");
		selenium.type("id=breed", "asdfghjkl");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("10000");
		assertTrue(selenium.isElementPresent("css=div.btn-nav.start-over"));
		assertEquals("We're Sorry! We could not find any results that meet your criteria. Start Over", selenium.getText("css=div.sorry"));
		assertEquals("We're Sorry!", selenium.getText("css=h2"));
	}
	
	@Test
	public void testReptilesSnake() throws Exception {
		selenium.open("/");
		selenium.select("id=species", "label=Reptiles");
		selenium.click("css=option[value=\"Reptile\"]");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("10000");
		selenium.click("css=div.nav-see-all");
		selenium.click("css=div.nav-see-all");
		selenium.click("//div[@id='refinements-mod']/div[2]/div[2]/ul/a[2]/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Snake", selenium.getText("//div[@id='brd-crumbs']/ul/li[2]"));
	}


	@Test
	public void testDogChihuahuaGenderMale() throws Exception {
		selenium.open("/");
		selenium.select("id=species", "label=Dogs");
		selenium.click("css=option[value=\"Dog\"]");
		selenium.type("id=breed", "chihuahua");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='refinements-mod']/div[3]/div");
		selenium.click("//div[@id='refinements-mod']/div[3]/div");
		selenium.click("//div[@id='refinements-mod']/div[3]/div[2]/ul/a/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Male", selenium.getText("//div[@id='brd-crumbs']/ul/li[2]"));
		assertEquals("Male", selenium.getText("//ul[@id='pets-results']/li/div/div[2]/ul/li[2]"));
	}
	
	@Test
	public void testDogBeagleColorTan() throws Exception {
		selenium.open("/");
		selenium.select("id=species", "label=Dogs");
		selenium.click("css=option[value=\"Dog\"]");
		selenium.type("id=breed", "beagle");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("20000");
		selenium.click("//div[@id='refinements-mod']/div[4]/div");
		selenium.click("//div[@id='refinements-mod']/div[4]/div");
		selenium.click("//div[@id='refinements-mod']/div[4]/div[2]/ul/a[5]/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Tan", selenium.getText("//div[@id='brd-crumbs']/ul/li[2]"));
		selenium.click("css=span.pet-name");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.expandCollapse");
		assertEquals("Tan", selenium.getText("//div[@id='bd']/div/div[2]/div[2]/div[2]/ul[2]/li[4]/span"));
	}


	@Test
	public void testCatPersianGenderMale() throws Exception {
		selenium.open("/");
		selenium.select("id=species", "label=Cats");
		selenium.click("css=option[value=\"Cat\"]");
		selenium.type("id=breed", "persian");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='refinements-mod']/div[3]/div");
		selenium.click("//div[@id='refinements-mod']/div[3]/div");
		selenium.click("//div[@id='refinements-mod']/div[3]/div[2]/ul/a[2]/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Male", selenium.getText("//div[@id='brd-crumbs']/ul/li[2]"));
		assertEquals("Male", selenium.getText("//ul[@id='pets-results']/li/div/div[2]/ul/li[2]"));
	}

	@Test
	public void testCatSiameseColorCream() throws Exception {
		selenium.open("/");
		selenium.select("id=species", "label=Cats");
		selenium.click("css=option[value=\"Cat\"]");
		selenium.type("id=breed", "siamese");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='refinements-mod']/div[4]/div");
		selenium.click("//div[@id='refinements-mod']/div[4]/div");
		selenium.click("//div[@id='refinements-mod']/div[4]/div[2]/ul/a/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Cream(Mostly)", selenium.getText("//div[@id='brd-crumbs']/ul/li[2]"));
		selenium.click("css=span.pet-name");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.expandCollapse");
		assertEquals("Cream(Mostly)", selenium.getText("//div[@id='bd']/div/div[2]/div[2]/div[2]/ul[2]/li[2]/span"));
	}
	
	@Test
	public void testGenderFemaleColorBlack() throws Exception {
		selenium.open("/");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=h3[title=\"Sex\"]");
		selenium.click("css=h3[title=\"Sex\"]");
		selenium.click("//div[@id='refinements-mod']/div[4]/div[2]/ul/a/li/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=h3[title=\"Color\"]");
		selenium.click("css=h3[title=\"Color\"]");
		selenium.click("//div[@id='refinements-mod']/div[4]/div[2]/ul/a/li");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=span.pet-name");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.expandCollapse");
		assertEquals("Female", selenium.getText("//div[@id='bd']/div/div[2]/div[2]/div[2]/ul/li[3]/span"));
		assertEquals("Black", selenium.getText("css=ul.hide > li > span.column2"));
	}

	@Test
	public void testTestAdoptionSubmissionError() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.click("css=#animal > label");
		selenium.select("id=species", "label=Cats");
		selenium.click("css=option[value=\"Cat\"]");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.hoverlay");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=adopt-me");
		selenium.click("id=adopt-sbmt-ipt");
		assertEquals("Please Enter a First Name", selenium.getText("css=div.error-container"));
	}

	@Test
	public void testTestAdoptPageDisplayed() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("id=species", "label=Dogs");
		selenium.click("css=option[value=\"Dog\"]");
		selenium.click("id=oasis-search-button");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.hoverlay");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=adopt-me");
		assertTrue(selenium.isElementPresent("id=adopt-sbmt-ipt"));
	}
	
	@Test
	public void testTestAskAboutPet() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("name=distance", "label=Within 100 Miles");
		selenium.click("css=option[value=\"100\"]");
		selenium.select("id=species", "label=Reptiles");
		selenium.click("css=option[value=\"Reptile\"]");
		selenium.click("id=oasis-search-button");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=span.pet-name");
		selenium.waitForPageToLoad("30000");
		assertEquals("Ask About Me", selenium.getText("id=inquiry"));
		assertTrue(selenium.isElementPresent("id=inquiry"));
	}
	
	@Test
	public void testTestCatByAge() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("name=distance", "label=Within 50 Miles");
		selenium.click("css=option[value=\"50\"]");
		selenium.select("id=species", "label=Cats");
		selenium.click("css=option[value=\"Cat\"]");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='refinements-mod']/div[7]/div[2]/ul/a/li");
		selenium.waitForPageToLoad("30000");
		assertEquals("Adult", selenium.getText("css=ul.pet-tags > li"));
	}
	
	@Test
	public void testTestLocation() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("name=distance", "label=Within 10 Miles");
		selenium.click("css=option[value=\"10\"]");
		selenium.click("id=oasis-search-button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Pittsburgh, PA", selenium.getText("css=span.pet-loc"));
	}
	
	@Test
	public void testTestPhoneError() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "18045");
		selenium.click("id=oasis-search-button");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a > li");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.hoverlay");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.expandCollapse");
		selenium.click("id=inquiry");
		selenium.type("id=phone-ipt-pre", "asd");
		selenium.type("id=phone-ipt-mid", "asd");
		selenium.type("id=phone-ipt-last", "asdd");
		selenium.click("id=adopt-sbmt-ipt");
		assertEquals("Please Enter a 10-digit Number", selenium.getText("css=#phone > div.error-container"));
	}
	
	@Test
	public void testTestTweetPet() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("id=species", "label=Dogs");
		selenium.click("css=option[value=\"Dog\"]");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.hoverlay");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='bd']/div/div[2]/div[2]/div/div/ul/li[4]/a/img");
		selenium.waitForPopUp("twitter_share", "30000");
		selenium.selectWindow("name=twitter_share");
		assertEquals("Share a link with your followers", selenium.getText("css=h2.action-information"));
	}
	
	@Test
	public void testTestZipCodeMatch() throws Exception {
		selenium.open("/");
		selenium.type("id=zipCode", "15213");
		selenium.select("id=species", "label=Dogs");
		selenium.click("css=option[value=\"Dog\"]");
		selenium.click("id=oasis-search-button");
		selenium.click("id=oasis-search");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img.hoverlay");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Dogs near 15233");
		selenium.waitForPageToLoad("30000");
		assertEquals("Pittsburgh, PA", selenium.getText("css=span.pet-loc"));
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

