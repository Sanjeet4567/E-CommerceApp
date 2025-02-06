# E-Commerce Web Application

This is a full-fledged e-commerce web application built with **React** for the frontend, **Spring Boot** for the backend, **Redux** for state management, and **Tailwind CSS** for styling. It also integrates **Razorpay** for secure payments.

---

## Features

- **User Authentication**: Sign up and login functionality for users.
- **Product Listing**: Display products with search and filter options.
- **Shopping Cart**: Add products to the cart, view cart details, and proceed to checkout.
- **Secure Payments**: Integrated Razorpay for secure and seamless payment processing.
- **Responsive Design**: Built using **Tailwind CSS**, ensuring the app looks great on all screen sizes.

---

## Technologies Used

- **Frontend**:
  - React.js
  - Redux
  - Tailwind CSS
- **Backend**:
  - Spring Boot (Java)
- **Payment Gateway**:
  - Razorpay API
- **State Management**:
  - Redux

---

## Getting Started

### Prerequisites

- JDK 11 or higher
- Node.js (v14+ recommended)
- Maven (for building Spring Boot project)

### Installation

#### Backend (Spring Boot)

1. Clone this repository:
    ```bash
    git clone https://github.com/Sanjeet4567/E-CommerceApp
    cd E-CommerceApp/backend
    ```

2. Install dependencies using Maven:
    ```bash
    mvn install
    ```
3. Navigate to the backend directory:
    ```bash
    cd E-CommerceApp/e-commerceBackend
    ```

4. Start the backend server:
    ```bash
    mvn spring-boot:run
    ```

#### Frontend (React)

1. Navigate to the frontend directory:
    ```bash
    cd E-CommerceApp/e-commerceFrontend
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

3. Start the React development server:
    ```bash
    npm start
    ```

The app should now be running on `http://localhost:3000` (Frontend) and `http://localhost:8080` (Backend).

---

## Razorpay Integration

To make Razorpay work, you’ll need to configure the payment gateway:

1. **Create a Razorpay account**: [Razorpay Sign Up](https://razorpay.com/)
2. **Obtain API Keys** from Razorpay (API Key and Secret Key).
3. Add your Razorpay credentials in the backend's configuration.

---

## Contributing

Feel free to fork this repo, submit pull requests, or open issues if you find any bugs or have suggestions for improvements.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact

For any questions, feel free to reach out at:  
LinkedIn: [[Sanjeet Raj](https://www.linkedin.com/in/sanjeetraj40/)]  
GitHub: [[Sanjeet Raj](https://github.com/Sanjeet4567)]
