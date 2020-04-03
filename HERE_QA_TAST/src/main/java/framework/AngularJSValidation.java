package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AngularJSValidation {
	public static boolean angularIsBeingUsed(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String UsingAngular = "if (window.angular){return true;} else {return false;}";
		boolean isTheSiteUsingAngular = (Boolean) js.executeScript(UsingAngular);
		return isTheSiteUsingAngular;
	}

	public static boolean checkAngularIsLoaded(WebDriver driver, int timeout) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String isAngularLoaded = "return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";
		boolean hasTheAngularLoaded = (Boolean) js.executeScript(isAngularLoaded);
		while ((!hasTheAngularLoaded)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			hasTheAngularLoaded = (Boolean) js.executeScript(isAngularLoaded);
			timeout--;
			if (timeout == 0)
				break;

		}
		return hasTheAngularLoaded;
	}
}
