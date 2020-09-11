let BASE_URL = "http://localhost:8080/AirBnB/api";

let GET_APPROVED_USERS = BASE_URL + "/admin/users/approved";
let REJECT_APPROVED_USER = BASE_URL + "/admin/users/reject_approved/";
let GET_REJECTED_USERS = BASE_URL + "/admin/users/rejected";
let APPROVE_REJECTED_USER = BASE_URL + "/admin/users/approve_rejected/";
let GET_PENDING_USERS = BASE_URL + "/admin/users/pending/";
let APPROVE_PENDING_USER = BASE_URL + "/admin/users/approve/";
let REJECT_PENDING_USER = BASE_URL + "/admin/users/reject/";
let EXPORT_JSON = BASE_URL + "/admin/export/json";
let EXPORT_XML = BASE_URL + "/admin/export/xml";

export default {
  GET_APPROVED_USERS,
  REJECT_APPROVED_USER,
  GET_REJECTED_USERS,
  APPROVE_REJECTED_USER,
  GET_PENDING_USERS,
  APPROVE_PENDING_USER,
  REJECT_PENDING_USER,
  EXPORT_JSON,
  EXPORT_XML,
};
