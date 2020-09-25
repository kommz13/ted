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
let REGISTRATION = BASE_URL + "/account/register";
let LOGIN = BASE_URL + "/account/login";
let GET_USER_BY_ID = BASE_URL + "/admin/users/";
let GET_ACTIVE_LISTINGS_BY_USER_ID = BASE_URL + "/listing/active/";
let GET_INACTIVE_LISTINGS_BY_USER_ID = BASE_URL + "/listing/inactive/";
let GET_ALL_LISTINGS = BASE_URL + "/listing/all";
let GET_UPDATE_LISTING = BASE_URL + "/listing/";
let POST_UPDATE_LISTING = BASE_URL + "/listing/update/";
let POST_ACTIVATE_LISTING= BASE_URL + "/listing/activate/";
let POST_DEACTIVATE_LISTING= BASE_URL + "/listing/deactivate/";
let GET_ACTIVE_LISTINGS = BASE_URL + "/listing/active/";
let GET_INACTIVE_LISTINGS = BASE_URL + "/listing/inactive/";
let GET_RECEIVED_MESSAGES = BASE_URL + "/messages/received/";
let GET_SENT_MESSAGES =  BASE_URL + "/messages/sent/";
let GET_MESSAGE_DETAILS = BASE_URL + "/messages/details/";
let POST_DELETE_MESSAGE = BASE_URL + "/messages/delete_message/";
let POST_LISTING_CREATE = BASE_URL + "/listing/create/";
let CHANGE_PROFILE = BASE_URL + "/account/edit/";
let GET_LISTING_BY_ID = BASE_URL + "/listing/";

let GET_ACTIVE_BOOKINGS_BY_USER_ID = BASE_URL + "/listing/accepted_bookings/customer/";
let GET_REJECTED_BOOKINGS_BY_USER_ID = BASE_URL + "/listing/rejected_bookings/customer/";
let GET_PENDING_BOOKINGS_BY_USER_ID = BASE_URL + "/listing/pending_bookings/customer/";
let GET_PREVIOUS_BOOKINGS_BY_USER_ID = BASE_URL + "/listing/previous_bookings/customer/";

let POST_ACCEPT_BOOKING = BASE_URL + "/bookings/accept_pending_booking/";
let POST_REJECT_BOOKING = BASE_URL + "/bookings/reject_pending_booking/";
let POST_LISTING_SEARCH = BASE_URL + "/listing/search/";
let POST_BOOKING = BASE_URL + "/bookings/create";

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
  REGISTRATION,
  GET_USER_BY_ID,
  GET_ACTIVE_LISTINGS_BY_USER_ID,
  GET_INACTIVE_LISTINGS_BY_USER_ID,
  GET_ALL_LISTINGS,
  GET_ACTIVE_LISTINGS,
  GET_INACTIVE_LISTINGS,
  GET_RECEIVED_MESSAGES,
  GET_SENT_MESSAGES,
  GET_MESSAGE_DETAILS,
  POST_LISTING_CREATE,
  LOGIN,
  GET_UPDATE_LISTING,
  POST_UPDATE_LISTING,
  CHANGE_PROFILE,
  GET_LISTING_BY_ID,
  GET_ACTIVE_BOOKINGS_BY_USER_ID,
  GET_PREVIOUS_BOOKINGS_BY_USER_ID,
  GET_PENDING_BOOKINGS_BY_USER_ID,
  POST_ACCEPT_BOOKING,
  POST_REJECT_BOOKING,
  POST_DELETE_MESSAGE,
  POST_ACTIVATE_LISTING,
  POST_DEACTIVATE_LISTING,
  GET_REJECTED_BOOKINGS_BY_USER_ID,
  POST_LISTING_SEARCH,
  POST_BOOKING
};
