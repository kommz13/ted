import axios from "axios";
import decode from "jwt-decode";
import API from "@/api/Api.js";

const AUTH_TOKEN_KEY = "security_token";

class AuthController {
  _token = localStorage.getItem(AUTH_TOKEN_KEY);

  constructor() {
    console.log("AuthController constructed");
    this._token = localStorage.getItem(AUTH_TOKEN_KEY);
  }

  // getters/setters for reactive property
  set token(token) {
    console.log("storing token to local storage");
    axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    localStorage.setItem(AUTH_TOKEN_KEY, token);
    this._token = token;
  }

  get token() {
    console.log("getting token from local storage");
    return this._token;
  }

  // methods:
  loginUser(form) {
    return axios.post(API.LOGIN, form).then((res) => {
      console.log("storing token to local storage #1");
      this.token = res.data.token;
    });
  }

  logoutUser() {
    axios.defaults.headers.common["Authorization"] = "";
    localStorage.removeItem(AUTH_TOKEN_KEY);
    this.token = "";
  }

  isLoggedIn() {
    let authToken = this.token;
    return !!authToken && !this.isTokenExpired(authToken);
  }

  getUserInfo() {
    let authToken = this.token;
    if (this.isLoggedIn()) {
      return decode(authToken);
    } else {
      return undefined;
    }
  }

  getUserID() {
    let authToken = this.token;
    if (this.isLoggedIn()) {
      let obj = decode(authToken);
      let id = obj["id"];
      return id;
    } else {
      return undefined;
    }
  }

  isAdmin() {
    if (!this.isLoggedIn()) {
      return false;
    }
    let obj = this.getUserInfo();
    let rolesArray = obj["roles"];
    let roles = rolesArray.split(",");
    return roles.includes("moderator") ;//|| true;
  }

  isCustomer() {
    if (!this.isLoggedIn()) {
      return false;
    }
    let obj = this.getUserInfo();
    let rolesArray = obj["roles"];
    let roles = rolesArray.split(",");
    return roles.includes("customer") ;//|| true;
  }

  isHost() {
    if (!this.isLoggedIn()) {
      return false;
    }
    let obj = this.getUserInfo();
    let rolesArray = obj["roles"];
    let roles = rolesArray.split(",") ;
    return roles.includes("host"); //|| true;
  }

  getTokenExpirationDate(encodedToken) {
    let token = decode(encodedToken);
    if (!token.exp) {
      return null;
    }
    let date = new Date(0);
    date.setUTCSeconds(token.exp);
    return date;
  }

  isTokenExpired(token) {
    let expirationDate = this.getTokenExpirationDate(token);
    return expirationDate < new Date();
  }
}

const singleton = new AuthController();

export default singleton;
