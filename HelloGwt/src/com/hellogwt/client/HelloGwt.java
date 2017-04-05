package com.hellogwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hellogwt.shared.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloGwt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		//create a panel
		TabLayoutPanel tabPanel = new TabLayoutPanel(5, Unit.EM);
		tabPanel.getElement().getStyle().setMarginBottom(250, Unit.PX);
		
		// Add a tab
	    generateMondaytab(tabPanel);
	    
	    generateTuesdaytab(tabPanel);
	    
	    //add a new tab
	    generateWednesdaytab(tabPanel);
	    
	    //add a new tab
	    generateThursdaytab(tabPanel);
	    
	    //add a new tab
	    generateFridaytab(tabPanel);	    
	    
	      
		tabPanel.setWidth("400px");
		tabPanel.setHeight("450px");
	    RootPanel.get("tabPanelContainer").add(tabPanel);

	    defaultSetup();
	    
	    
	}

	private void generateFridaytab(TabLayoutPanel tabPanel) {
		HTML moreInfo4 = new HTML("test4");
	    tabPanel.add(moreInfo4, "Freitag");
	}

	private void generateThursdaytab(TabLayoutPanel tabPanel) {
		HTML moreInfo3 = new HTML("test3");
	    tabPanel.add(moreInfo3, "Donnerstag");
	}

	private void generateWednesdaytab(TabLayoutPanel tabPanel) {
		HTML moreInfo2 = new HTML("test2");
	    tabPanel.add(moreInfo2, "Mittwoch");
	}

	private void generateTuesdaytab(TabLayoutPanel tabPanel) {
		HTML dayDescription = new HTML("<h1>Am Dienstag morgen konnte ich dann an meinem, vom vorherigen Tag schon angefangenes Project, weiterarbeiten. Um Punkt 10 Uhr war ein CANDy Meeting, welches bi Mittags ging. Nach dem Project gab es wie jeden Tag essen in der Kantine der Telekom. Nach dem Essen hab ich dann mit Hilfe des anwesenden Fachpersonal, weiter an meinem Project gearbeitet.</h1>");
	    
	    HTML imagePlaceholder = new HTML("Placeholder");
	    imagePlaceholder.addStyleName("text-placeholder");
	    
	    HTML textPlaceholder = new HTML("Placeholder");
	    textPlaceholder.addStyleName("text-placeholder");
	    
	    HTML githubDescription = new HTML("GitHub Discribtion ");
	    githubDescription.addStyleName("image-text");
	    
	    HTML gwtDescription = new HTML("GWT Discribtion");
	    gwtDescription.addStyleName("image-text");
	       
	    // verticalPanel "replaces" RootPanel
	    VerticalPanel verticalPanel = new VerticalPanel();
	    HorizontalPanel horizontalPanelImages = new HorizontalPanel();
	    HorizontalPanel horizontalPanelText = new HorizontalPanel();
	    
	    // simplePanel holds image layer
	    SimplePanel githubImageContainer = new SimplePanel();
	    Image gitImage = new Image("https://about.gitlab.com/images/press/logo/wm_no_bg.svg");
	    gitImage.setHeight("50px");
	    gitImage.setWidth("100px");
	    githubImageContainer.setWidget(gitImage);
	    
	    // simplePanel holds image layer
	    SimplePanel gwtImageContainer = new SimplePanel();
	    Image gwtImage = new Image("http://www.codetab.org/wp-content/uploads/title_logo.png");
	    gwtImage.setHeight("50px");
	    gwtImage.setWidth("100px");
	    gwtImageContainer.setWidget(gwtImage);
	    
	    // build vertical Panel together
	    verticalPanel.add(dayDescription);
	    tabPanel.add(verticalPanel, "Dienstag");
	    
	    verticalPanel.add(horizontalPanelImages);
	    
	    horizontalPanelImages.add(githubImageContainer);
	    horizontalPanelImages.add(imagePlaceholder);
	    horizontalPanelImages.add(gwtImageContainer);
	    
	    verticalPanel.add(horizontalPanelText);
	    
	    horizontalPanelText.add(githubDescription);
	    horizontalPanelText.add(textPlaceholder);
	    horizontalPanelText.add(gwtDescription);
	}

	private void generateMondaytab(TabLayoutPanel tabPanel) {
		HTML moreInfo0 = new HTML("<h1>Als erstes wurde ich allen vorgestellt und hab die ersten organisatorischen Informationen entgegen genommen. Also habe ich meinen Laptop bekommen zusammen mit den ersten Einweisungen. Ich habe ersteinmal den Mitarbeitern ein wenig ueber die Schulter geguckt. Im weiteren Verlauf des Nachmittags hab ich dann ein kleines Projekt in Java mit GWT und Eclipse programmiert.</h1>");
	    moreInfo0.setStylePrimaryName("body-text");
	    tabPanel.add(moreInfo0, "Montag");
	}

	private void defaultSetup() {
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("Name");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}
}
