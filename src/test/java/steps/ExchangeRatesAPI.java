package steps;


import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.NBPRates;
import utils.Rate;

import static utils.JSONMapper.getRes;

public class ExchangeRatesAPI {
    NBPRates[] nbpRates;

    private static final Logger logger = LoggerFactory.getLogger(ChoosePhoneSteps.class);

    @Given("użytkownik pobiera kursy walut ze strony {string}")
    public void opensApplicationWithCurrencyRates(String url) throws JsonProcessingException {
        logger.info("get API response from: {}", url);
        ObjectMapper objectMapper = new ObjectMapper();
        nbpRates = objectMapper.readValue(getRes(url), NBPRates[].class);
        logger.info("API response received successfully");
    }

    @Then("użytkownik wyświetla kurs dla waluty o kodzie: {string}")
    public void rateForCurrencyWithCode(String arg0) {
        logger.info("Displaying rate for currency with code: {}", arg0);
        for (Rate rate : nbpRates[0].getRates()) {
            if (rate.getCode().equals(arg0)) {
                logger.info("Rate for currency with code {} is: {}", arg0, rate.getMid());
            }
        }
    }

    @And("użytkownik wyświetla kurs dla waluty o nazwie: {string}")
    public void rateForCurrencyWithName(String arg0) {
        logger.info("Displaying rate for currency with name: {}", arg0);
        for (Rate rate : nbpRates[0].getRates()) {
            if (rate.getCurrency().equals(arg0)) {
                logger.info("Rate for currency with name {} is: {}", arg0, rate.getMid());
            }
        }
    }

    @And("użytkownik wyświetla waluty o kursie powyżej: {int}")
    public void currenciesWithRateAbove(int arg0) {
        logger.info("Displaying currencies with rate above: {}", arg0);
        for (Rate rate : nbpRates[0].getRates()) {
            if (rate.getMid() > arg0) {
                logger.info("Currency with rate above {}: {}", arg0, rate.getCurrency());
            }
        }
    }

    @And("użytkownik wyświetla waluty o kursie poniżej: {int}")
    public void currenciesWithRateBelow(int arg0) {
        logger.info("Displaying currencies with rate below: {}", arg0);
        for (Rate rate : nbpRates[0].getRates()) {
            if (rate.getMid() < arg0) {
                logger.info("Currency with rate below {}: {}", arg0, rate.getCurrency());
            }
        }
    }
}

