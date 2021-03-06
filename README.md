Coverage: 80.4%

This the the READme file for JozzaOzza/QaProject1

# Title

QaProject1

## Description

The application connects to a MySQL database containing information on Customers, Items, and Orders. 
The application allows users to Create, Read, Update and Delete this information, as well as removing individual items from orders, 
and viewing the total order cost as part of Read.
The application runs on Java.

## Installation

There are several applications to install before attempting to use this application:
  - Eclipse IDE. https://www.eclipse.org/downloads/packages/installer . 
  - Apache Maven. https://maven.apache.org/download.cgi . How to: How to: https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows
  - MySQL Workbench (editing the schema). https://dev.mysql.com/downloads/workbench/

To set up the application:

  1. Fork the repository on GitHub. https://github.com/JozzaOzza/QaProject1
  2. GitBash command to clone repository. ' git clone <link to forked repo> '

## Usage

When the application and all its dependencies have been installed, run the program.
The Console should read: "Welcome to the Inventory Management System!
                          Which entity would you like to use?
                          CUSTOMER: Information about customers
                          ITEM: Individual Items
                          ORDER: Purchases of items
                          STOP: To close the application"
                          
The words in CAPITAL LETTERS can be typed into the console as commands.
Typing in "customer" and pressing 'Enter' would bring you to the CUSTOMER section of the application. 

Accessing the commands inside CUSTOMER, ITEMS, or ORDERS will either prompt you to enter in words or numbers as input, or will take you back to the main menu. Typing in 'read' and pressing 'Enter' inside of CUSTOMER would display a list of all the customers.

## Requirements of project

The minimum requirements for this application are, being able to: // The commands needed to perform this requirement: // Any side notes:
  Add a customer to the system // CUSTOMER, CREATE
  View all customers in the system // CUSTOMER, READ
  Update a customer in the system // CUSTOMER, UPDATE
  Delete a customer in the system // CUSTOMER, DELETE
  Add an item to the system // ITEM, CREATE
  View all items in the system // ITEM, READ
  Update an item in the system // ITEM, UPDATE
  Delete an item in the system // ITEM, DELETE
  Create an order in the system // ORDER, CREATE
  View all orders in the system // ORDER, READ
  Delete an order in the system // ORDER, DELETE
  Add an item to an order // ORDER, UPDATE, ADD
  Calculate a cost for an order // ORDER, READ // Order costs are listed when a user selects ORDER READ
  Delete an item in an order // ORDER, UPDATE, REMOVE
  
When considering the entities in this domain:

  Customers need to have a name.
  Items need to have a name and a value.
  Orders need to have a customer and contains items.
  
## Running tests

### Unit test:

In the OrderControllerTest.java file, 

			@Test
			public void testReadAll() {
				List<Order> orders = new ArrayList<>();
				orders.add(new Order(11L, "Orr", 150D));

				Mockito.when(dao.readAll()).thenReturn(orders);

				assertEquals(orders, controller.readAll());

				Mockito.verify(dao, Mockito.times(1)).readAll();
			}  
			
This test ensures that the ReadAll method in OrderDAO.java works independently of the other classes and methods, which can be helpful when debugging.

## Built With
Maven - Dependency Management

## Authors
Chris Perrins - Initial work - [christophperrins](https://github.com/christophperrins)
Jamie Orr - Updated work - [JozzaOzza](https://github.com/JozzaOzza)


## License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

## Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc  			
