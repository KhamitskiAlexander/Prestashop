package webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteBrowser implements Browser {
    /**
     * Initializes an instance of {@link RemoteBrowser}.
     */
    public RemoteBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        String nodeURL = "http://127.0.0.1:4444/wd/hub";
        try {
            return new RemoteWebDriver(new URL(nodeURL), getChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets chrome options.
     *
     * @return the chrome options
     */
    private ChromeOptions getChromeOptions() {
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
}

