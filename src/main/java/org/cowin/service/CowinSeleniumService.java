package org.cowin.service;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.cowin.data.SelCalendarByPin;
import org.cowin.data.SelRoot;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

@ApplicationScoped
public class CowinSeleniumService {

	public SelRoot getSessionSlotFindByPin(String pincode, String date) {
		// Declaring and initialising the HtmlUnitWebDriver
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		unitDriver.setJavascriptEnabled(true);
		unitDriver.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=" + pincode
				+ "&date=" + date);
		unitDriver.manage().window().setSize(new Dimension(976, 824));
		// unitDriver.findElement(By.cssSelector("pre")).click();
		System.out.println(unitDriver.getPageSource().toString());
		String json = unitDriver.getPageSource().toString();
		Jsonb jsonb = JsonbBuilder.create();
		SelRoot p = jsonb.fromJson(json, SelRoot.class);
		unitDriver.close();
		return p;
	}

	public SelCalendarByPin getSessionSlotCalendarByPin(String pincode, String date) {
		// Declaring and initialising the HtmlUnitWebDriver
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		unitDriver.setJavascriptEnabled(true);
		unitDriver.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=" + pincode
				+ "&date=" + date);
		unitDriver.manage().window().setSize(new Dimension(976, 824));
		// unitDriver.findElement(By.cssSelector("pre")).click();
		System.out.println(unitDriver.getPageSource().toString());
		String json = unitDriver.getPageSource().toString();
		Jsonb jsonb = JsonbBuilder.create();
		SelCalendarByPin p = jsonb.fromJson(json, SelCalendarByPin.class);
		unitDriver.close();
		return p;
	}

}