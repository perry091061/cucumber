# cucumber
Extracting data from a pdf
using the following as the feature description:

Feature: Extract Text from PDF

  Scenario: Extract text from a PDF file
    Given I have a PDF file "Interest_Statement.pdf"
    When I extract from the field in the PDF
    Then I should see the text "some text"
