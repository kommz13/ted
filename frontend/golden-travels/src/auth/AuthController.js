import axios from "axios";
import decode from "jwt-decode";
import API from "@/api/Api.js";

const AUTH_TOKEN_KEY = "security_token";

export function loginUser(form) {
  return axios.post(API.LOGIN, form).then((res) => {
    console.log("storing token to local storage #1");
    setAuthToken(res.data.token);
  });
}

export function logoutUser() {
    clearAuthToken();
}

export function setAuthToken(token) {
  console.log("storing token to local storage");

  axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
  localStorage.setItem(AUTH_TOKEN_KEY, token);
}

export function getAuthToken() {
  return localStorage.getItem(AUTH_TOKEN_KEY);
}

export function clearAuthToken() {
  axios.defaults.headers.common["Authorization"] = "";
  localStorage.removeItem(AUTH_TOKEN_KEY);
}



export function isLoggedIn() {
  let authToken = getAuthToken();
  return !!authToken && !isTokenExpired(authToken);
}

export function getUserInfo() {
  if (isLoggedIn()) {
    return decode(getAuthToken());
  }
}

export function isAdmin() {
  if (!isLoggedIn) {
    return false;
  }
  let obj = getUserInfo();
  let rolesArray = obj["roles"];
  let roles = rolesArray.split(",");

  return roles.includes("moderator");
}

export function isCustomer() {
  if (!isLoggedIn) {
    return false;
  }
  let obj = getUserInfo();
  let rolesArray = obj["roles"];
  let roles = rolesArray.split(",");

  return roles.includes("customer");
}

export function isHost() {
  if (!isLoggedIn) {
    return false;
  }
  let obj = getUserInfo();
  let rolesArray = obj["roles"];
  let roles = rolesArray.split(",");

  return roles.includes("host");
}

function getTokenExpirationDate(encodedToken) {
  let token = decode(encodedToken);
  if (!token.exp) {
    return null;
  }

  let date = new Date(0);
  date.setUTCSeconds(token.exp);

  return date;
}

function isTokenExpired(token) {
  let expirationDate = getTokenExpirationDate(token);
  return expirationDate < new Date();
}
