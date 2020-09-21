<template>
  <!-- Start Contact Us  -->
  <div class="contact-box-main">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-sm-12"></div>
        <div class="col-lg-8 col-sm-12">
          <div class="contact-form-right">
            <h2>Send a message</h2>

            <form id="contactForm">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      placeholder="Recipient name"
                      id="text"
                      class="form-control"
                      name="name"
                      required
                      data-error="Please enter recipient name"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="subject"
                      name="name"
                      placeholder="Subject"
                      required
                      data-error="Please enter your Subject"
                    />
                    <div class="help-block with-errors"></div>
                  </div>
                </div>
                <div class="col-md-12">
                  <div class="form-group">
                    <textarea
                      class="form-control"
                      id="message"
                      placeholder="Your Message"
                      rows="4"
                      data-error="Write your message"
                      required
                    ></textarea>
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="submit-button text-center">
                    <button class="btn hvr-hover" id="submit" type="submit">
                      Send Message
                    </button>
                    <div id="msgSubmit" class="h3 text-center hidden"></div>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Cart -->
</template>
