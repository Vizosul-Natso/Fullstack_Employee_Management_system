<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <style>
    body {
      background-color: black;
      background-color: #000000;
    }
    .heading {
      margin-top: 10vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    h1 {
      color: rgb(211, 209, 212);
      font-family: cursive;
      font-size: 12vh;
      text-shadow: 0px 4px 6px rgb(81, 26, 233);
    }
    .button-container {
      min-height: 30vh;
      font-family: "Comfortaa", sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    button {
      color: black;
      gap: 20px;
      min-width: 11rem;
      height: 4.4rem;
      cursor: pointer;
      border-radius: 10px;
      font-size: 2rem;
      border: none;
      margin: 2rem;
      background-color: #afa9b8;
      box-shadow: 0 0 5px 2px rgb(35, 49, 255);
    }
    button:hover{
        scale: 1.18;
        filter: brightness(110%);
    }
    a:visited, a:active{
        text-decoration: none;
        color: #000000;
    }
  </style>
  <body>
    <div class="heading">
      <h1>Employee Management System</h1>
    </div>
    <div class="button-container">
      <div class="buttons">
        <button class="create"><a href="createEmployee">Create</a></button>
        <button class="find"><a href="findEmployee">Find</a></button>
        <button class="delete"><a href="deleteEmployee">Delete</a></button>
        <button class="update"><a href="updateEmployee">Update</a></button>
      </div>
    </div>
  </body>
</html>
