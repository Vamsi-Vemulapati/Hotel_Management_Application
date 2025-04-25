Hotel Management Application
This application is built using Spring Boot to manage hotel data through a set of RESTful services. It provides core functionalities that allow users to create, read, update, and delete hotel records efficiently.

Users can add a new hotel by submitting hotel details like name, address, rating, and other relevant information. Once added, the system allows retrieving the complete list of all hotels stored, helping users to view the available hotel options at a glance.

If needed, users can fetch detailed information about a specific hotel by using its unique identifier. This helps in managing or viewing individual hotel data precisely.

The system supports updating hotel information in two ways:

Complete update of all hotel details using the hotel’s ID, which allows modifying name, rating, address, and other information.

Partial update specifically for the hotel’s address, enabling users to change only the location information without affecting other details.

Deletion of hotel records is also supported, enabling removal of hotels that are no longer in service or needed.

Additionally, the application allows users to check the rating of a hotel by providing its name, offering a quick way to understand customer feedback or hotel quality without retrieving full details.

These functionalities together provide a comprehensive backend solution for managing hotel data, designed with simplicity and modularity in mind. The application handles incoming requests, processes the business logic, and interacts with the database to ensure reliable storage and retrieval of hotel information.
