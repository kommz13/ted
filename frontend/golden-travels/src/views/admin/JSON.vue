<template>
  <div>
    <!-- Start All Title Box -->
    <ExportTitleBox></ExportTitleBox>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="table-main table-responsive"></div>
            <p>Click the button below to download the dataset</p>

            <button type="button" @click="exportjson" class="btn btn-warning">
              Export
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- End Cart -->
  </div>
</template>

<script>
import axios from "axios";
import API from "@/api/Api.js";
import ExportTitleBox from "@/components/admin/ExportTitleBox";

export default {
  components: {
    ExportTitleBox,
  },
  methods: {
    exportjson() {
      const config = { responseType: "blob" };

      axios.get(API.EXPORT_JSON, config).then((response) => {
        const blob = new Blob([response.data], { type: "text/plain" });
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);
        link.download = "file.json";
        link.click();
        URL.revokeObjectURL(link.href);

        console.log(response.data);
      });
    },
  },
};
</script>
