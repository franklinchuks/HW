TEST CASES AND SCENARIOS

1. BASIC FUNCTIONALITY
TEST SCENARIO: Verify that the factoring calculator loads correctly.
TEST CASE:
    1. Open the web browser and visit the factoring calculator page.
TEST STEPS:
    1. Open web browser
    2. Visit the Swedbank’s factoring calculator page
PRECONDICTIONS:
    1. User has access to the Swedbank’s factoring calculator link
EXPECTED OUTCOMES:
    1. 
	
2. INPUT VALIDATION
TEST SCENARIO: Verify input validation for all fields.
TEST CASE:
    1. Enter negative values Verify that this action isn’t allowed or an error message is displayed
    2. Enter non-numeric values. Verify that this action isn’t allowed or an error message is displayed
    3. Leave the input fields empty and submit form. Verify that an error message is displayed
TEST STEPS:
    1. Open web browser
    2. Visit the Swedbank’s factoring calculator page
    3. Enter invalid values in the fields or leave empty
    4. Click the calculate button
PRECONDICTIONS:
    1. User is unaware that negative values are not allowed
    2. User is unaware that non-numeric values are not allowed
	EXPECTED OUTCOMES:

3. CALCULATION ACCURACY
TEST SCENARIO: Verify that the calculated financing charge is accurate.
TEST CASE:
    1. Enter a specific invoice amount, advance rate, interest rate, payment term, and commission fee. Calculate the financing charge manually and compare it with the calculator's result.
TEST STEPS:
    1. Open web browser
    2. Visit the Swedbank’s factoring calculator page
    3. Enter valid specific values in the fields
    4. Click the calculate button
    5. Calculate the values entered manually
    6. Verify if the outputs match
PRECONDICTIONS:
    1. User enters valid values
	EXPECTED OUTCOMES:

4. BOUNDRY TESTING
TEST SCENARIO: Test boundary conditions for input fields.
TEST CASE:
    1. Enter the maximum allowed in the fields. Verify the calculators behaviour
    2. Enter the minimum allowed in the fields. Verify the calculators behavior
TEST STEPS:
    1. Open web browser
    2. Visit the Swedbank’s factoring calculator page
    3. Enter valid large/small values in the fields
    4. Click the calculate button
    5. Verify the calculators behaviour
PRECONDICTIONS:
    1. User is unaware of the boundaries
	EPECTED OUTCOMES:
