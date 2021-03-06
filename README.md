# barbora_test
This project purpose is to cover "Barbora" e-shop with two test cases using Selenium web driver in page object design pattern (https://www.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern).

This project was created using IntelJ IDE and Java programming language. Project uses Selenium jars and chrome web driver, which you can download from https://www.seleniumhq.org/download/. Project configuration also use Maven integration in order to run tests. How to configure Maven you can find here: https://www.youtube.com/watch?v=pt3uB0sd5kY.

Task: Write an automated test which adds two cheapest pizzas into the basket of www.barbora.lt

Project contains two tests:
"TestAddTwoCheapestPizzas"
"TestAddOneMostExpensiveDrink"

Test "TestAddOneMostExpensiveDrink" was created in order to demonstrate that "User" class methods are reusable and applicable in different test cases. Tests cover: 1. User login function 2. Modal closing function 3. Cart clearing function  4. Button click function (in order to reproduce natural user behaviour and path to reach product list) 5. Product filtering function (to order products by relevant priorities) 5. Add first available products in list function (to select wanted quantity of products that are available on list).

I didn't include user registration action, since I assumed that user is already registered before test begins. Here I provided method "user.loginWithCredentials("[Your email]", "[Your password]")" so you can use your own credentials to run test.

Challenges that I faced:
1. Choosing right approach to create correct test. I chose to use method which orders products by price and selects first available products from list if they are available (sometimes products are not available if there is no residual in warehouse). Pros: a) no need to compare prices and find cheepest product. It sounds easy, but it is difficult to select all products from all product pages, compare them by price, find cheapest one and select right product. b) avoiding problem that driver may select unwanted product when prices are equal for several products. Cons: a) This method requires additional method to filter products. Another method I considered was to select all available products and compare them. Since I didn't came up what is the right way to get all products from all product pages and after comparison derive the right product selection option, I decided not to apply it.
2. Finding the cheapest product when prices are the same. Test does not separate products if they have same price, but different weight. It only selects wanted number of available products from ordered product list. The correct way to find cheapest product would be to include weight comparison as well, but I didn't know how to do it.
3. Deciding when driver should run login action. After few manual tests I noticed, that depending when user decides to login, product availability vary. If user try to select product when he/she is not logged in, server asks user to do so. After this action, user is informed, that selected product is not available. Since it is not optimal way to set test, I decided to login user right after user go to page www.barbora.lt.
4. Unpredictable modal displays. Sometimes, probably regarding of business logic (or bug), ad modals are displayed after login action and sometimes - not displayed at all. I decided to create "closeModal" action with option to close it if it appears. Since I don't know business logic and program construction I am not sure if it is OK that modal is displayed or not displayed from time to time. It may be that modal should always be displayed and fact that it does not appear may indicate bug that "closeModal" will not be able to catch as it will be ignored wether modal appears or not.
5. Cart cleaning. Sometimes user is presented by server alert if he exceeds fixed quantity of same product in cart. In order to avoid this and be able to run separate independent tests, I decided to create method that cleans cart if it contain products in it every time after user logs in.
6. Website language. Realising that web has different language options determined that I had to use different approach and change buttons finding method in order to find them by link, that does not change, instead of button title.
