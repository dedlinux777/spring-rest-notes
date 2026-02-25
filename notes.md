# Spring RESTfull services notes:

## Introduction:
---
```
Frontend (React / Mobile / Postman)
        ↓ JSON
Spring Boot REST API
        ↓
Service Layer
        ↓
Spring Data JPA
        ↓
Database
```

Spring REST teaches you:

* Stateless backend design
* JSON-based communication
* Real-world architecture (Controller → Service → Repo)
* How Spring apps are actually used in companies

---

## What will *change* when you move to Spring REST

Here’s a quick mindset shift so you don’t get confused later:

### 1. No JSP, no UI rendering

* Controllers return **JSON**, not views
* `@RestController` instead of `@Controller`

### 2. HTTP becomes first-class

You’ll think in terms of:

* `GET /customers`
* `POST /customers`
* `PUT /customers/{id}`
* `DELETE /customers/{id}`

Not “pages”, but **resources**.

### 3. DTOs, status codes, validation

You’ll start caring about:

* `ResponseEntity`
* HTTP status codes
* Input validation
* Exception handling

This is where Spring becomes **real backend engineering**.

---

# 1️⃣ Why Web Services Exist (The Core Problem)

Early enterprise apps had a big problem:

> **How do two applications communicate if they are built using different languages, platforms, and frameworks?**

Example:

* Java app (Spring)
* .NET app
* PHP app
* Python app

They **cannot directly call each other’s methods**.

👉 So we needed **platform-independent communication**.

That’s where **Web Services** were born.

---

# 2️⃣ WSI (Web Services Interoperability)

## What is WSI?

**WSI** is an **industry consortium** (IBM, Microsoft, Oracle, etc.) formed to ensure:

> Web services built by different vendors can **interoperate correctly**

### Why interoperability was a problem?

Even if everyone used SOAP:

* Vendors implemented specs *slightly differently*
* Result → services failed to talk to each other

### WSI’s Goal

> “If you follow our profile, your web service will work everywhere.”

---

## WSI Specifications (Profiles)

### 🔹 Basic Profile 1.0 (B.P. 1.0)

Defines **how** to use:

* SOAP
* WSDL
* XML
* HTTP

✔ Eliminates ambiguity
✔ Standardizes message formats
✔ Prevents vendor-specific behavior

### 🔹 Basic Profile 1.1 (B.P. 1.1)

Improved version:

* Clarifies edge cases
* Fixes inconsistencies in BP 1.0
* Aligns with newer SOAP/WSDL clarifications

---

# 3️⃣ SOAP-Based Web Services (The Old World)

SOAP = **Simple Object Access Protocol**

### Characteristics

* XML-based
* Very strict
* Heavy
* Contract-first

---

## 🔸 Marshalling / Unmarshalling

Because SOAP works with XML:

* **Marshalling**
  Java Object → XML

* **Unmarshalling**
  XML → Java Object

This conversion is mandatory in SOAP.

---

## 🔸 WSDL (Web Services Description Language)

Think of WSDL as:

> **A contract that describes WHAT a service does and HOW to call it**

WSDL defines:

* Operations (methods)
* Input/output types
* Endpoint URL
* Protocol used

📌 Without WSDL → SOAP client cannot be built.

---

## 🔸 UDDI (Universal Description, Discovery, and Integration)

Think of it as:

> **A phone directory for web services**

* Providers publish services
* Consumers discover services

📌 In reality, UDDI mostly **failed in adoption**.

---

# 4️⃣ Java APIs for SOAP

### 🔹 JAX-RPC (Java API for XML-Based RPC)

* Old
* RPC-style
* Tightly coupled
* Deprecated ❌

### 🔹 JAX-WS (Java API for XML Web Services)

* Replacement for JAX-RPC
* SOAP-based
* Uses annotations
* Still XML-heavy

✔ Enterprise-ready
❌ Complex
❌ Overkill for most apps

---

# 5️⃣ Why SOAP Started Dying

SOAP was great for:

* Banking
* Transactions
* Security-heavy systems

But had problems:

* Huge XML payloads
* Hard to debug
* Slow
* Complex tooling
* Not web-friendly

👉 The web needed something **simpler**.

---

# 6️⃣ Enter REST (The New World)

## Who is REST’s Father?

### 👤 Roy Fielding

* One of the **authors of HTTP**
* Wrote REST in his **PhD dissertation (2000)**

📌 Important:

> REST is **NOT a framework**
> REST is an **architectural style**

---

## REST = Representational State Transfer

Key idea:

> Treat everything as a **resource**, not an operation.

---

# 7️⃣ Rules (Constraints) of RESTful Services

Roy Fielding defined **6 constraints**:

### 1️⃣ Client–Server

* Client and server are separate
* UI ≠ Data logic

### 2️⃣ Stateless

* Server does NOT store client state
* Each request is complete

### 3️⃣ Cacheable

* Responses should define cache rules

### 4️⃣ Uniform Interface (MOST IMPORTANT)

Includes:

* Resource identification via URI
* Manipulation through representations
* Self-descriptive messages
* HATEOAS (optional in practice)

### 5️⃣ Layered System

* Client doesn’t know if it’s talking to:

    * Load balancer
    * Proxy
    * Actual server

### 6️⃣ Code on Demand (Optional)

* Server can send executable code (rarely used)

---

# 8️⃣ REST Resources vs REST Clients

## 🔹 REST Resource

Anything identifiable via a URI:

```
/users
/orders/101
/products/55
```

* Nouns, not verbs
* Represent data/entities

---

## 🔹 REST Client

Any application that:

* Sends HTTP requests
* Consumes REST APIs

Examples:

* Browser
* Postman
* Mobile app
* Another backend service

---

# 9️⃣ JAX-RS (Java API for RESTful Services)

JAX-RS is:

> Java standard API for building REST services

Annotations like:

* `@Path`
* `@GET`
* `@POST`
* `@PUT`
* `@DELETE`

Popular implementations:

* Jersey
* RESTEasy

📌 **Spring does NOT use JAX-RS**, but concepts are similar.

---

# 🔟 What is Jackson?

**Jackson** is a **JSON processing library**.

### Role:

* Java Object ↔ JSON conversion

Equivalent to:

* SOAP → JAXB (XML)
* REST → Jackson (JSON)

📌 In Spring REST:

* Jackson is used **automatically**
* You rarely call it directly

---

# 1️⃣1️⃣ Finally — What is Spring REST?

## Spring REST is:

> **Spring’s implementation of REST principles using Spring Web**

### Key points:

* Built on HTTP
* Stateless
* JSON-based
* Lightweight
* Annotation-driven

---

## Spring REST Architecture

```
Client (Postman / React)
        ↓ JSON
@RestController
        ↓
@Service
        ↓
@Repository (JPA)
        ↓
Database
```

---

## How Spring REST Uses Everything You Learned

| Concept          | Role in Spring REST           |
| ---------------- | ----------------------------- |
| WSI              | Historical reason REST exists |
| SOAP             | What REST replaced            |
| REST constraints | Architectural foundation      |
| HTTP             | Transport layer               |
| JAX-RS           | REST inspiration              |
| Jackson          | JSON conversion               |
| Spring MVC       | Base engine                   |
| Spring REST      | Modern backend development    |

---


### **Overview of REST API Communication of Different HTTP Methods**

In a REST Controller, data is typically exchanged in **JSON** format.

* **Sending Data:** The client sends data to the server using URL Path Variables, Request Parameters, or a Request Body.
* **Receiving Data:** The server responds with a **ResponseEntity**, which includes the data (Body), an HTTP Status Code, and Headers.

---

### **Breakdown of the Tourist APIs**

#### **1. Register Tourist (`@PostMapping`)**

* **HTTP Method:** `POST` (used to create new resources).
* **Data Sent:** A JSON object representing a `Tourist` is sent in the **Request Body**.
* **Data Received:** A success message string and a `201 CREATED` status code.
* **Logic:** It calls the service to save the tourist details into the database.

```java
@PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        String message = service.registerTourist(tourist);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
```


#### **2. Find All Tourists (`@GetMapping`)**

* **HTTP Method:** `GET` (used to retrieve data).
* **Data Sent:** None (no body or parameters required).
* **Data Received:** A **List** of all `Tourist` objects in JSON format with a `200 OK` status.
```java
 @GetMapping("/findAll")
    public ResponseEntity<?> displayTourists() {
        List<Tourist> list = service.fetchAllTouristInfo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
```

#### **3. Find Tourist By ID (`@GetMapping`)**

* **HTTP Method:** `GET`.
* **Data Sent:** The specific ID is sent as a **Path Variable** in the URL (e.g., `/findById/101`).
* **Data Received:** If found, the `Tourist` object is returned. If not found, a "Tourist not found" error message is returned with a `404 NOT FOUND` status.
```java
@GetMapping("/findById/{id}")
    public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        } catch (TouristNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
```


#### **4. Modify Tourist (`@PutMapping`)**

* **HTTP Method:** `PUT` (used for full updates of an existing resource).
* **Data Sent:** The entire updated `Tourist` object (including the `id`) in the **Request Body**.
* **Data Received:** A success message or an error message if the ID does not exist.

```java
 @PutMapping("/modify")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
        try {
            String msg = service.updateTourist(tourist);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
```

#### **5. Update Budget (`@PatchMapping`)**

* **HTTP Method:** `PATCH` (used for partial updates, such as changing only one field).
* **Data Sent:** Both the `id` and the new `budget` are sent as **Path Variables** in the URL.
* **Data Received:** A confirmation message string.

```java
@PatchMapping("/budgetUpdate/{id}/{budget}")
    public ResponseEntity<String> updateBudget(@PathVariable Integer id, @PathVariable Integer budget) {
        try {
            String msg = service.updateTouristBudget(id, budget);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
```

#### **6. Remove Tourist (`@DeleteMapping`)**

* **HTTP Method:** `DELETE` (used to remove a resource).
* **Data Sent:** The `id` of the tourist to be deleted via a **Path Variable**.
* **Data Received:** A success message string.
* **Note:** This method is optimized for **Global Exception Handling**, meaning it doesn't need a `try-catch` block because error handling is managed centrally by a `@RestControllerAdvice` class.

```java
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeTourist(@PathVariable("id") Integer id) {
        // Primary logic call; secondary logic (exception handling) is managed globally
        String message = service.deleteTourist(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
```
---

Spring REST JSON Handling Guide
JSON Handling in Spring REST

1.  Manual JSON Handling (Jackson Library)
    As shown in the example, the ObjectMapper class from the Jackson library is the core engine for manual conversions:

- Serialization (Java to JSON): Using mapper.writeValueAsString(object).
- Deserialization (JSON to Java): Using mapper.readValue(file, Class.class).

2.  Implicit JSON Handling in Spring Boot
    In a @RestController, you don't need to manually call the ObjectMapper. Spring Boot uses HttpMessageConverters (with Jackson) to handle this automatically:

- @RequestBody: Automatically converts incoming JSON from the request body into a Java object.
- Return Types: When a method returns a POJO (like Customer), Spring automatically converts it into JSON for the response.

Example Code:
@RestController
@RequestMapping("/customers")
public class CustomerController {
@GetMapping("/{id}")
public Customer getCustomer(@PathVariable int id) {
return new Customer(id, "Harsha", "Bengaluru");
}

@PostMapping("/add")
public String addCustomer(@RequestBody Customer customer) {
return "Received customer: " + customer.getName();
}

}

---

### **Summary Table**

| API Goal | HTTP Method | Data Input Location | Success Status |
| --- | --- | --- | --- |
| Create | `POST` | Request Body (JSON) | `201 Created` |
| Read All | `GET` | N/A | `200 OK` |
| Read One | `GET` | Path Variable (`{id}`) | `200 OK` |
| Update (Full) | `PUT` | Request Body (JSON) | `200 OK` |
| Update (Partial) | `PATCH` | Path Variable (`{id}/{budget}`) | `200 OK` |
| Delete | `DELETE` | Path Variable (`{id}`) | `200 OK` |



In software architecture, particularly in Spring Boot applications like your **Tourist Management API**, we distinguish between primary and secondary logic to keep the code clean and maintainable.

### 1. Primary Logic vs. Secondary Logic

* **Primary Logic (Business Logic):** This is the core functional logic of your application—what the application is actually built to do. In your project, registering a tourist, calculating budgets, or fetching data from the database is primary logic. This should always reside in the **Service Layer** (`TouristServiceImpl`).
* **Secondary Logic (Cross-Cutting Concerns):** These are tasks that support the application but aren't part of the core business function. Examples include **exception handling**, logging, security, and transaction management.

### 2. Why Exception Handling in a Controller is Bad Practice

While you can use `try-catch` blocks in your `TouristRestController`, it is considered bad practice for several reasons:

* **Code Duplication:** If you have 10 controllers, you would have to write the same `try-catch` logic in every single one, leading to massive code repetition.
* **Violation of Single Responsibility Principle (SRP):** A controller’s job is to handle incoming HTTP requests and return responses. It shouldn't be cluttered with complex error-handling logic.
* **Maintenance Overhead:** If you decide to change the error response format (e.g., adding a timestamp to all errors), you would have to manually update every controller method.

### 3. What is Global Exception Handling and `@RestControllerAdvice`?

**Global Exception Handling** is a centralized mechanism to catch exceptions thrown by any controller in your application.
Instead of handling errors locally, you "throw" the exception from the Service or Controller, and a central component catches it to return a uniform response. In Spring, this is implemented using the **`@RestControllerAdvice`** annotation.

* **`@RestControllerAdvice`:** This acts as an "interceptor" for exceptions. It combines `@ControllerAdvice` and `@ResponseBody`, ensuring that the returned error data is automatically converted to JSON.

### 4. How to Implement Global Exception Handling

To implement this in your project, you should create a new class in your `exception` package. This moves the **secondary logic** (error handling) out of your `TouristRestController`.

#### Step 1: Create an Error Details Class

This represents the structure of the error message sent to the client.

```java
public class ErrorDetails {
    private String message;
    private String details;
    // Getters, Setters, and Constructor
}

```

#### Step 2: Create the Global Exception Handler

```java
package org.practice.touristmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // This makes it a Global Exception Handler
public class GlobalExceptionHandler {

    // Handles your custom TouristNotFoundException
    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), "Check the ID provided");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handles any other unexpected exceptions (Generic)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {
        ErrorDetails error = new ErrorDetails("An internal server error occurred", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

```

#### Step 3: Clean up the Controller

Now, your controller methods no longer need `try-catch` blocks. They simply call the service, and if an exception occurs, the `GlobalExceptionHandler` automatically takes over.

```java
@GetMapping("/findById/{id}")
public ResponseEntity<Tourist> displayTouristById(@PathVariable("id") Integer id) {
    // No try-catch needed!
    Tourist tourist = service.fetchTouristById(id); 
    return new ResponseEntity<>(tourist, HttpStatus.OK);
}

```




## Swagger API Implementation:  
[Swagger-ticket-booking-api](https://github.com/dedlinux777/ticket-booking-backend-api/blob/main/notes.md)


## B2B Concept how to communicate from a WebApp to Standalone API
[Flight Ticket Booking web app](https://github.com/dedlinux777/FlightTicketBookingWebApp/blob/main/notes.md)


## Working with XML data:

# 🔹 1️⃣ How XML Works in Spring Boot

By default:

```
Java Object  ↔  JSON
```

using **Jackson**

To enable XML:

```
Java Object  ↔  XML
```

We use:

📦 `jackson-dataformat-xml`

Spring Boot automatically detects it and registers:

* `MappingJackson2XmlHttpMessageConverter`

So now Spring can:

* Deserialize XML → Java object
* Serialize Java object → XML

---

# 🔹 2️⃣ Add Dependency (VERY IMPORTANT)

If using Maven:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```

That’s it. No extra config required.

---

# 🔹 3️⃣ Create Course Model (XML Root Element)

```java
package com.example.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "course")
public class Course {

    private Long id;
    private String name;
    private String instructor;
    private int duration;

    public Course() {
    }

    public Course(Long id, String name, String instructor, int duration) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
    }

    // Getters and Setters
}
```

---

## 🔹 What `@JacksonXmlRootElement` Does

It defines the root XML tag:

Without it:

```xml
<Course>
```

With it:

```xml
<course>
```

Cleaner and controlled.

---

# 🔹 4️⃣ Create CourseController

```java
package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private Course course;

    // POST API (Consumes + Produces XML)
    @PostMapping(
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public Course createCourse(@RequestBody Course course) {
        this.course = course;
        return this.course;
    }

    // GET API (Produces XML)
    @GetMapping(
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public Course getCourse() {
        return this.course;
    }
}
```

---

# 🔹 5️⃣ What Happens Internally?

When you send:

```
Content-Type: application/xml
Accept: application/xml
```

Spring:

1. Detects XML format
2. Uses XML HttpMessageConverter
3. Unmarshals XML → Java object
4. Executes controller
5. Marshals Java object → XML

This is automatic.

---

# 🔹 6️⃣ Example XML Request (POST)

URL:

```
POST http://localhost:8080/courses
```

Headers:

```
Content-Type: application/xml
Accept: application/xml
```

Body:

```xml
<course>
    <id>1</id>
    <name>Spring Boot</name>
    <instructor>Harsha</instructor>
    <duration>30</duration>
</course>
```

---

# 🔹 7️⃣ Example XML Response

```xml
<course>
    <id>1</id>
    <name>Spring Boot</name>
    <instructor>Harsha</instructor>
    <duration>30</duration>
</course>
```

---

# 🔹 8️⃣ How Content Negotiation Works Here

Spring decides format based on:

1. `Content-Type` → For request body
2. `Accept` → For response format

If client sends:

```
Accept: application/xml
```

Spring returns XML.

If:

```
Accept: application/json
```

Spring returns JSON (if available).

---

# 🔹 9️⃣ Important Interview Concepts

### Q: What enables XML in Spring Boot?

Answer:

> `jackson-dataformat-xml` dependency

---

### Q: What handles conversion?

Answer:

> `HttpMessageConverters`

Specifically:

* `MappingJackson2XmlHttpMessageConverter`

---

### Q: Difference between JAXB and Jackson XML?

| JAXB         | Jackson XML         |
| ------------ | ------------------- |
| Used in SOAP | Used in REST        |
| XML-only     | Works with JSON too |
| Older        | Modern              |

---

# 🔥 1️⃣0️⃣ Optional Advanced: Returning Both JSON and XML

You can allow both formats:

```java
@PostMapping(
        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
)
```

Now client chooses format.

That’s professional REST design.

---
Perfect Harsha 👌 — this is exactly how a **real-world REST API** should be designed.

Instead of restricting your API to only XML, you should allow:

* ✅ `application/xml`
* ✅ `application/json`

Let’s properly design it the professional way.

---

# 🔹 1️⃣ Why Use Multiple Media Types?

When you write:

```java
consumes = MediaType.APPLICATION_XML_VALUE,
produces = MediaType.APPLICATION_XML_VALUE
```

You are saying:

> ❌ This API ONLY supports XML

But in real-world backend systems:

* Some clients want JSON
* Some legacy systems want XML

So we make it flexible.

---

# 🔹 2️⃣ Updated Course Model

```java
package com.example.demo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "course")
public class Course {

    private Long id;
    private String name;
    private String instructor;
    private int duration;

    public Course() {}

    public Course(Long id, String name, String instructor, int duration) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
    }

    // Getters and Setters
}
```

✔ Works for both JSON and XML
✔ Jackson handles JSON
✔ Jackson XML handles XML

---

# 🔹 3️⃣ Updated Controller (Supports Both XML and JSON)

```java
package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private Course course;

    // POST API
    @PostMapping(
            consumes = {"application/xml", "application/json"},
            produces = {"application/xml", "application/json"}
    )
    public Course createCourse(@RequestBody Course course) {
        this.course = course;
        return this.course;
    }

    // GET API
    @GetMapping(
            produces = {"application/xml", "application/json"}
    )
    public Course getCourse() {
        return this.course;
    }
}
```

---

# 🔹 4️⃣ What Happens Internally?

Spring checks headers:

### 🔸 Request Body Format → `Content-Type`

Determines how to convert request to Java object.

### 🔸 Response Format → `Accept`

Determines how to send response.

Spring uses:

* `MappingJackson2HttpMessageConverter` → JSON
* `MappingJackson2XmlHttpMessageConverter` → XML

This is called:

> 🔥 Content Negotiation

---

# 🔹 5️⃣ Example Requests

---

## ✅ JSON Request

Headers:

```
Content-Type: application/json
Accept: application/json
```

Body:

```json
{
  "id": 1,
  "name": "Spring Boot",
  "instructor": "Harsha",
  "duration": 30
}
```

Response:

```json
{
  "id": 1,
  "name": "Spring Boot",
  "instructor": "Harsha",
  "duration": 30
}
```

---

## ✅ XML Request

Headers:

```
Content-Type: application/xml
Accept: application/xml
```

Body:

```xml
<course>
    <id>1</id>
    <name>Spring Boot</name>
    <instructor>Harsha</instructor>
    <duration>30</duration>
</course>
```

Response:

```xml
<course>
    <id>1</id>
    <name>Spring Boot</name>
    <instructor>Harsha</instructor>
    <duration>30</duration>
</course>
```

---

# 🔹 6️⃣ Cleaner Alternative (Professional Tip)

Instead of writing media types on every method, you can put it at class level:

```java
@RestController
@RequestMapping(
        value = "/courses",
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
)
```

And only specify `consumes` where needed.

Cleaner and more maintainable.

---

# 🔹 7️⃣ What If Client Sends Wrong Type?

If client sends:

```
Content-Type: text/plain
```

Spring throws:

```
415 Unsupported Media Type
```

If client requests unsupported format:

```
Accept: text/html
```

Spring throws:

```
406 Not Acceptable
```

These are REST best practices.

---

# 🔥 8️⃣ Interview-Level Explanation

If interviewer asks:

> How does Spring support both JSON and XML in same API?

You answer:

> Spring uses HttpMessageConverters and content negotiation. Based on Content-Type and Accept headers, it chooses the appropriate converter like MappingJackson2HttpMessageConverter for JSON and MappingJackson2XmlHttpMessageConverter for XML.

That sounds senior-level.

---

# 🔥 9️⃣ Final Mental Model

When you write:

```java
consumes = {"application/xml", "application/json"}
produces = {"application/xml", "application/json"}
```

You are not writing two APIs.

You are writing:

> One API, multiple representations.

---





## Spring Boot Profiles:

### 🔹 1️⃣ Why Do We Even Need Profiles?

In real applications, we don’t have just *one environment*.

We usually have:

* **Development (dev)**
* **Testing (test)**
* **Production (prod)**

Each environment needs different configuration.

Example:

| Environment | Database         | Logging | Debug    |
| ----------- | ---------------- | ------- | -------- |
| Dev         | H2 / Local MySQL | DEBUG   | Enabled  |
| Test        | Test DB          | INFO    | Disabled |
| Prod        | Cloud DB         | WARN    | Strict   |

You cannot hardcode these in one file.

👉 That’s where **Spring Profiles** come in.

---

# 🔹 2️⃣ What is a Spring Profile?

**Definition (Interview-ready):**

A Spring Profile is a mechanism that allows you to **segregate configuration and beans based on the active environment**.

In simple words:

> Profiles let you run the same application with different configurations.

---

Excellent Harsha 👌 — this is now **real backend engineering territory**.

We’ll go deep into:

1. ✅ How Spring Boot Profiles Work (internals)
2. ✅ Different Ways to Define Profiles
3. ✅ Using `@Profile` Annotation properly
4. ✅ How `spring.profiles.include` works
5. ✅ Real-world architecture example

I’ll explain this like you're designing a production-grade REST system.

---

# 🔹 1️⃣ How Spring Boot Profiles Work (Internally)

When a Spring Boot application starts:

### Step 1️⃣: It reads the active profile

It checks in this order:

* Command-line argument
* Environment variable
* `application.properties`
* Default profile

Example:

```properties
spring.profiles.active=dev
```

---

### Step 2️⃣: It Loads Property Sources in Order

Spring loads configuration in this sequence:

1. `application.properties`
2. `application-dev.properties` (if dev is active)
3. External config (if any)
4. Command-line overrides

📌 Important Rule:

> Profile-specific properties OVERRIDE default properties.

---

### Step 3️⃣: Conditional Bean Creation

Spring registers beans only if their `@Profile` condition matches.

Internally, `@Profile` is implemented using Spring’s `@Conditional` mechanism.

So conceptually:

```
If activeProfile == beanProfile → Register Bean
Else → Skip Bean
```

---

# 🔹 2️⃣ Different Ways to Define Profiles

There are 5 major ways.

---

## ✅ 1️⃣ Using application.properties (Most Common)

```
application.properties
application-dev.properties
application-prod.properties
```

Activate:

```properties
spring.profiles.active=dev
```

---

## ✅ 2️⃣ Using Command Line

```bash
java -jar app.jar --spring.profiles.active=prod
```

This overrides properties file.

Useful in:

* Docker
* CI/CD
* Jenkins pipelines

---

## ✅ 3️⃣ Using Environment Variables

Linux:

```bash
export SPRING_PROFILES_ACTIVE=prod
```

Windows:

```cmd
set SPRING_PROFILES_ACTIVE=prod
```

Very common in cloud deployments.

---

## ✅ 4️⃣ Using YAML

```yaml
spring:
  profiles:
    active: dev
```

---

## ✅ 5️⃣ Using @Profile Annotation (Bean-Level Control)

Now we go deeper 👇

---

# 🔹 3️⃣ Using `@Profile` Annotation (Detailed)

`@Profile` controls **which beans get created**.

---

## 🎯 Example 1: Different DataSource Beans

### Dev Configuration

```java
@Configuration
@Profile("dev")
public class DevDBConfig {

    @Bean
    public DataSource devDataSource() {
        return new H2DataSource();
    }
}
```

---

### Prod Configuration

```java
@Configuration
@Profile("prod")
public class ProdDBConfig {

    @Bean
    public DataSource prodDataSource() {
        return new MySQLDataSource();
    }
}
```

Now:

If:

```
spring.profiles.active=dev
```

Only DevDBConfig loads.

If:

```
spring.profiles.active=prod
```

Only ProdDBConfig loads.

---

## 🎯 Example 2: Profile on a Single Bean

```java
@Bean
@Profile("prod")
public PaymentService realPaymentService() {
    return new StripePaymentService();
}
```

```java
@Bean
@Profile("dev")
public PaymentService mockPaymentService() {
    return new FakePaymentService();
}
```

This is how companies use:

* Mock services in dev
* Real services in prod

---

## 🎯 Example 3: Multiple Profiles

```java
@Profile({"dev", "test"})
```

Means:
Bean loads if either dev OR test is active.

---

# 🔹 4️⃣ What is `spring.profiles.include`?

This is slightly advanced and powerful.

It allows you to **activate additional profiles automatically**.

---

## 🔥 Basic Example

In:

```properties
application-dev.properties
```

Add:

```properties
spring.profiles.include=common
```

Now when you activate:

```
spring.profiles.active=dev
```

Spring actually activates:

```
dev + common
```

---

# 🔹 Why Is This Useful?

Imagine you have:

* common → logging, shared configs
* dev → dev database
* prod → prod database

Instead of duplicating common config everywhere:

You structure like:

```
application-common.properties
application-dev.properties
application-prod.properties
```

Then:

```properties
# application-dev.properties
spring.profiles.include=common
```

Now dev automatically inherits common settings.

---

# 🔹 5️⃣ Real Industry Profile Structure

In real microservices:

```
application.properties
application-common.properties
application-dev.properties
application-prod.properties
application-cloud.properties
```

Example:

### application.properties

```properties
spring.application.name=user-service
```

---

### application-common.properties

```properties
logging.level.root=INFO
```

---

### application-dev.properties

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.profiles.include=common
```

---

### application-prod.properties

```properties
spring.datasource.url=jdbc:mysql://prod-db
spring.profiles.include=common
```

---

# 🔹 6️⃣ Profile Priority & Merge Behavior

Order of override:

```
Default < Included Profiles < Active Profile < Command-line
```

So active profile always wins.

---

# 🔹 7️⃣ Advanced Profile Expressions

Spring supports logical expressions.

```java
@Profile("dev & cloud")
```

Bean loads only if both are active.

```java
@Profile("!prod")
```

Bean loads if NOT prod.

Very powerful.

---

# 🔹 8️⃣ Common Interview Questions

### Q: What is difference between spring.profiles.active and include?

**Answer:**

* `spring.profiles.active` → Sets the main active profile
* `spring.profiles.include` → Adds additional profiles automatically

---

### Q: Can multiple profiles be active?

Yes:

```
spring.profiles.active=dev,cloud
```

---

### Q: What happens if no profile is active?

Spring uses:

```
default
```

---

# 🔹 9️⃣ Internal Conceptual Model

Think like this:

Profiles are just:

> Conditional switches for configuration and bean registration.

Under the hood:

* Spring creates an `Environment`
* Environment checks active profiles
* BeanFactory applies conditions
* Beans are registered or skipped

---

# 🔥 10️⃣ Very Important Real-World Advice (For You)

Since you’re moving toward:

* Spring REST
* Microservices
* Backend placements

You MUST:

* Always separate dev and prod DB
* Never hardcode credentials
* Use profiles for environment separation

This avoids:

> “It worked locally but failed in production.”

That’s the most common junior mistake.

---

# 🎯 Final Mental Model

Profiles solve:

✔ Environment separation
✔ Bean conditional loading
✔ Config modularization
✔ Production readiness

---


## Bean Scope: 

---

### 🔹 1️⃣ What is Bean Scope?

In Spring:

> Scope defines **how many objects of a bean are created and how long they live** inside the Spring container.

By default, Spring Boot beans are:

```text
singleton
```

---

# 🔹 2️⃣ Singleton Scope (Default)

## 🔹 Definition

Only **ONE instance per Spring container**.

All injections share the same object.

---

## 🔹 Example

```java
@Component
public class MyService {
}
```

Or explicitly:

```java
@Component
@Scope("singleton")
public class MyService {
}
```

---

## 🔹 Behavior

```java
@Autowired
MyService s1;

@Autowired
MyService s2;
```

Both `s1` and `s2` point to the **same object**.

---

## 🔹 Initialization Type

✅ **Eager by default**

Spring creates singleton beans at **application startup**.

### Why?

To fail fast if dependencies are broken.

---

## 🔹 Making Singleton Lazy

```java
@Component
@Lazy
public class MyService {
}
```

Now:

* Bean created only when first used.

---

# 🔹 3️⃣ Prototype Scope

## 🔹 Definition

Every time the bean is requested, a **new object** is created.

---

## 🔹 Example

```java
@Component
@Scope("prototype")
public class PrototypeService {
}
```

Now:

```java
@Autowired
PrototypeService p1;

@Autowired
PrototypeService p2;
```

`p1 != p2`

---

## 🔹 Important Note

Spring creates prototype bean:

* When requested
* Then hands control to you
* Does NOT manage full lifecycle after creation

---

## 🔹 Initialization Type

✅ **Lazy by nature**

Prototype beans are created **only when requested**.

Spring does NOT create them at startup.

---

# 🔹 4️⃣ Request Scope (Web Applications Only)

Works only in:

* Spring MVC
* Spring REST

---

## 🔹 Definition

One bean instance per **HTTP request**.

---

## 🔹 Example

```java
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class RequestScopedBean {
}
```

Each HTTP request gets a new object.

If 10 users hit endpoint:

* 10 objects created.

---

## 🔹 Initialization Type

✅ **Lazy (per request)**

Created only when request comes.

Destroyed after request completes.

---

# 🔹 5️⃣ Session Scope

## 🔹 Definition

One bean instance per **HTTP session**.

Each user gets their own object.

---

## 🔹 Example

```java
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class SessionScopedBean {
}
```

If:

* 3 users logged in
* 3 session beans created

---

## 🔹 Initialization Type

✅ **Lazy (per session)**

Created when first used in session.

Destroyed when session ends.

---

# 🔹 6️⃣ Summary Table (Very Important)

| Scope     | Instances Created  | Lifetime                   | Default Init |
| --------- | ------------------ | -------------------------- | ------------ |
| Singleton | 1 per container    | App lifetime               | Eager        |
| Prototype | New per request    | Not managed after creation | Lazy         |
| Request   | 1 per HTTP request | Request duration           | Lazy         |
| Session   | 1 per session      | Session duration           | Lazy         |

---

# 🔹 7️⃣ Internal Lifecycle Understanding

### Singleton

```
App starts
   ↓
Bean created
   ↓
Stays till app shuts down
```

---

### Prototype

```
Request bean
   ↓
Bean created
   ↓
Spring forgets it
```

---

### Request

```
HTTP request arrives
   ↓
Bean created
   ↓
Request completes → Bean destroyed
```

---

### Session

```
User session created
   ↓
Bean created
   ↓
Session invalidated → Bean destroyed
```

---

# 🔹 8️⃣ Very Important: Injection Trap

⚠️ Common Interview Question:

> What happens if you inject Prototype into Singleton?

Example:

```java
@Component
public class SingletonBean {

    @Autowired
    private PrototypeBean prototypeBean;
}
```

Result:

* Prototype created only once at injection time
* Singleton keeps that same reference

To truly get new prototype every time:

* Use `ObjectProvider`
* Or `ApplicationContext.getBean()`

---

# 🔹 9️⃣ Lazy vs Eager Summary

| Scope     | Default |
| --------- | ------- |
| Singleton | Eager   |
| Prototype | Lazy    |
| Request   | Lazy    |
| Session   | Lazy    |

---

# 🔹 1️⃣0️⃣ Real World Usage

### Singleton

✔ Services
✔ Repositories
✔ Controllers

(Default in 95% of cases)

---

### Prototype

✔ Temporary objects
✔ Stateful processing

Rare in REST APIs.

---

### Request

✔ Request tracking
✔ Request metadata
✔ Logging correlation

---

### Session

✔ Shopping cart
✔ User preferences

(Not common in stateless REST APIs)

---

# 🔥 1️⃣1️⃣ REST Context (Important for You)

Since you're moving to **Spring REST**:

* REST is **stateless**
* So session scope is rarely used
* Singleton is most common

In microservices:

* 99% beans are singleton

---

# 🔥 1️⃣2️⃣ Interview Answer (Perfect Version)

If asked:

> What are bean scopes in Spring?

You say:

> Spring supports singleton (default, eager), prototype (new instance per request, lazy), request (per HTTP request), and session (per HTTP session). Singleton beans are eagerly initialized by default, while others are lazily created when needed.

That’s clean and correct.

---




## 🔹`application.yml` in Spring Boot?

In Spring Boot, configuration can be written in:

* `application.properties`
* `application.yml`

Both do the same job:

> Externalized configuration of your Spring Boot application.

YAML is just a different format.

---

# 🔹 2️⃣ Why Use YAML Instead of Properties?

Compare:

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

---

### application.yml

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: 1234
  jpa:
    hibernate:
      ddl-auto: update
```

👉 YAML is:

* Cleaner
* Hierarchical
* More readable
* Less repetitive

That’s why production projects prefer it.

---

# 🔹 3️⃣ Basic YAML Syntax Rules (VERY IMPORTANT)

YAML is indentation-based.

### Rule 1️⃣: Indentation matters

Use **2 spaces** (not tabs).

### Rule 2️⃣: No semicolons, no braces

### Rule 3️⃣: Key-value pairs use `:`

```yaml
server:
  port: 8081
```

---

# 🔹 4️⃣ How Spring Reads YAML

Internally:

Spring converts YAML into flat properties.

Example:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost
```

Becomes internally:

```text
spring.datasource.url=jdbc:mysql://localhost
```

So YAML is just a cleaner wrapper.

---

# 🔹 5️⃣ Writing Common Spring Config in YAML

---

## ✅ Change Server Port

```yaml
server:
  port: 9090
```

---

## ✅ Database Configuration

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

---

## ✅ JPA Configuration

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## ✅ Logging Level

```yaml
logging:
  level:
    root: INFO
    org.springframework.web: DEBUG
```

---

# 🔹 6️⃣ Profiles in YAML (Important)

Instead of multiple files, you can define profiles in same YAML file.

---

## ✅ Method 1: Separate YAML Files

```
application.yml
application-dev.yml
application-prod.yml
```

Activate:

```yaml
spring:
  profiles:
    active: dev
```

---

## ✅ Method 2: Multiple Profiles in Same File

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb

---

spring:
  config:
    activate:
      on-profile: prod
  datasource:
    url: jdbc:mysql://prod-db
```

`---` separates profile sections.

This is very professional usage.

---

# 🔹 7️⃣ Lists in YAML

Example:

```yaml
my:
  servers:
    - server1
    - server2
    - server3
```

Equivalent to:

```properties
my.servers[0]=server1
my.servers[1]=server2
```

---

# 🔹 8️⃣ Objects in YAML

```yaml
my:
  app:
    name: CourseApp
    version: 1.0
```

---

# 🔹 9️⃣ Binding YAML to Java Class

Very important in real projects.

### application.yml

```yaml
course:
  name: Spring Boot
  duration: 30
```

### Java Class

```java
@Component
@ConfigurationProperties(prefix = "course")
public class CourseConfig {

    private String name;
    private int duration;

    // getters and setters
}
```

Spring automatically binds YAML → Java object.

Professional usage.

---

# 🔹 🔟 Complete Real-World Example

```yaml
server:
  port: 8081

spring:
  application:
    name: course-service

  datasource:
    url: jdbc:mysql://localhost:3306/course_db
    username: root
    password: root

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

logging:
  level:
    root: INFO
```

This is production-style configuration.

---

# 🔹 1️⃣1️⃣ Common YAML Mistakes

❌ Using tabs instead of spaces
❌ Wrong indentation
❌ Forgetting `:`
❌ Mixing indentation levels

Bad example:

```yaml
spring:
datasource:
  url: test
```

This will fail.

---

# 🔹 1️⃣2️⃣ When to Use Properties vs YAML?

| Properties        | YAML                     |
| ----------------- | ------------------------ |
| Simple configs    | Large structured configs |
| Flat structure    | Nested structure         |
| Beginner friendly | Production friendly      |

For your backend projects:
👉 Use `application.yml`.

---

# 🔥 1️⃣3️⃣ Interview Answer (Perfect Version)

If interviewer asks:

> What is application.yml?

You say:

> application.yml is a YAML-based configuration file in Spring Boot used to externalize application configuration. It provides hierarchical, readable structure and supports profile-specific configurations.

That sounds mature.

---

# 🔥 1️⃣4️⃣ Final Mental Model

YAML is just:

> A cleaner way to write Spring properties.

Spring converts it internally to normal properties.

---


