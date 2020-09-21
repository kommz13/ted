<template>
  <!-- Start Contact Us  -->
  <div class="contact-box-main">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-sm-12"></div>
        <div class="col-lg-8 col-sm-12">
          <div class="contact-form-right">
            <h2>Received message</h2>

            <form id="contactForm">
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      id="name"
                      name="name"
                      placeholder="Message From"
                      required
                      data-error="Please enter your name"
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
                      placeholder="Message"
                      rows="4"
                      data-error="Write your message"
                      required
                    ></textarea>
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="submit-button text-center">
                    <button class="btn hvr-hover" id="submit" type="submit">
                      Reply
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
