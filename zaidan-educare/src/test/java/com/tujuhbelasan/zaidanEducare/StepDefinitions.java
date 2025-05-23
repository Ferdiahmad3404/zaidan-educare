package com.tujuhbelasan.zaidanEducare;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Person lucy;
    private Person sean;
    private List<String> messageFromSean;
    private List<Person> listeners;

    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        lucy = new Person();
        sean = new Person();
        listeners = new ArrayList<>();
        listeners.add(lucy);
        sean.moveTo(0); // Posisi Sean di 0
        lucy.moveTo(distance);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        messageFromSean = new ArrayList<>();
        messageFromSean.add(message);
        sean.shout(message, listeners);
    }

    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(messageFromSean, lucy.getMessagesHeard());
    }
}