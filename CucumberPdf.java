import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFSteps {

    private PDDocument document;
    private PDFTextStripper pdfStripper;
    private String text;

    @Given("I have a PDF file {string}")
    public void i_have_a_pdf_file(String filename) {
        File file = new File(filename);
        try {
            document = PDDocument.load(file);
            pdfStripper = new PDFTextStripper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I extract the text from the PDF")
    public void i_extract_the_text_from_the_pdf() {
        try {
            text = pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the text {string}")
    public void i_should_see_the_text(String expectedText) {
        if (text.equals(expectedText)) {
            System.out.println("Text matches expected value");
        } else {
            System.out.println("Text does not match expected value");
        }
    }
}