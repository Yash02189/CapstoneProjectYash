Feature: Demo Web Shop Automation Test

@Registration
Scenario Outline: User enters valid credentials to Register
Given User is on Demo Shop Home Page
When user enters the registeration page
And user enters fname<first_name>
And user enters lname<last_name>
And user enters Email<email>
And user enters Pass<password>
And user enters pass Confirmation<pass_confirm>
Then user clicks register button

Examples:
|first_name|last_name|email         |password |pass_confirm |
|User13579 |OddUser  |odd3@user.com |passOdd  |passOdd      |
|User24680 |EvenUser |even4@user.com|passEven |passEven     |

@Registration
Scenario Outline: User enters invalid credentials to Register
Given User is on Demo Shop Home Page
When user enters the registeration page
And user enters invalid fname<first_name>
And user enters invalid lname<last_name>
And user enters invalid Email<email>
And user enters invalid Pass<password>
And user enters invalid pass Confirmation<pass_confirm>
Then user tries to register

Examples:
|first_name|last_name|email        |password |pass_confirm|
|User13579 |OddUser  |             |passOdd  |passOdd     |
|User24680 |EvenUser |             |passEven |passEven    |


@Login
Scenario Outline: Login Functionality
Given user is on Demo Shop Home Page
When user enters email<email>
And user enters password<password>
And user clicks on Login button 
Then user logged in!

Examples:
|email                      |password      |
|voroh47402@isorax.com      |WelcomeDemo   |
|invalid@credential.com     |password1     |

@Logout
Scenario Outline: Logout Functionality
Given user is on login page
When user enters valid email<email>
And user enters valid pass<password>
When user clicks on logout button
Then user is logged out 

Examples:
|email                      |password      |
|voroh47402@isorax.com      |WelcomeDemo   |
|odd3@user.com              |passOdd       |


@AddToCart
Scenario: Adding To Cart
Given user on home page
When user searches"Computer"
And user clicks on a product of choice
And user clicks add to cart button 
Then Product is added to cart


@MultiAddToCart
Scenario: Adding multiple products to Cart
Given user is on home page
And User adds given products to the cart.
		|Polka Dot      |
		|Golf Belt      |
		|Blue Jeans     |
Then user verifies total

@CouponCode
Scenario: Applying invalid coupon code
Given user is on demo web shop home page
When user adds a product to cart 
And user enters code in cart"Discount10"
Then error message is displayed

@Checkout
Scenario: Checking out with invalid details
Given user is home page of demo web shop 
When user gives email
And user gives password
And user adds product to cart
And user checksout
And user enters invalid billing address
		|India      |
		|Dharamshala|
		|Street_14  |
		|           |
		|09876544556|
Then error message is captured

@Checkout
Scenario: Checking out with valid details
Given user is home page of demo web shop 
When user gives email
And user gives password
And user adds product to cart
And user checksout
And user enters valid billing address
		|India      |
		|Dharamshala|
		|Street_14  |
		|234555     |
		|09876544556|
And user clicks all the continue buttons
Then Confirmation Text visible

